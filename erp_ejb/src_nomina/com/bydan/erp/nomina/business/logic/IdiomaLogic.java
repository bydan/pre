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
import com.bydan.erp.nomina.util.IdiomaConstantesFunciones;
import com.bydan.erp.nomina.util.IdiomaParameterReturnGeneral;
//import com.bydan.erp.nomina.util.IdiomaParameterGeneral;
import com.bydan.erp.nomina.business.entity.Idioma;
import com.bydan.erp.nomina.business.logic.IdiomaLogicAdditional;
import com.bydan.erp.nomina.business.dataaccess.*;
import com.bydan.erp.nomina.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;
















@SuppressWarnings("unused")
public class IdiomaLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(IdiomaLogic.class);
	
	protected IdiomaDataAccess idiomaDataAccess; 	
	protected Idioma idioma;
	protected List<Idioma> idiomas;
	protected Object idiomaObject;	
	protected List<Object> idiomasObject;
	
	public static ClassValidator<Idioma> idiomaValidator = new ClassValidator<Idioma>(Idioma.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected IdiomaLogicAdditional idiomaLogicAdditional=null;
	
	public IdiomaLogicAdditional getIdiomaLogicAdditional() {
		return this.idiomaLogicAdditional;
	}
	
	public void setIdiomaLogicAdditional(IdiomaLogicAdditional idiomaLogicAdditional) {
		try {
			this.idiomaLogicAdditional=idiomaLogicAdditional;
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
	
	
	
	
	public  IdiomaLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.idiomaDataAccess = new IdiomaDataAccess();
			
			this.idiomas= new ArrayList<Idioma>();
			this.idioma= new Idioma();
			
			this.idiomaObject=new Object();
			this.idiomasObject=new ArrayList<Object>();
				
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
			
			this.idiomaDataAccess.setConnexionType(this.connexionType);
			this.idiomaDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  IdiomaLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.idiomaDataAccess = new IdiomaDataAccess();
			this.idiomas= new ArrayList<Idioma>();
			this.idioma= new Idioma();
			this.idiomaObject=new Object();
			this.idiomasObject=new ArrayList<Object>();
			
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
			
			this.idiomaDataAccess.setConnexionType(this.connexionType);
			this.idiomaDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public Idioma getIdioma() throws Exception {	
		IdiomaLogicAdditional.checkIdiomaToGet(idioma,this.datosCliente,this.arrDatoGeneral);
		IdiomaLogicAdditional.updateIdiomaToGet(idioma,this.arrDatoGeneral);
		
		return idioma;
	}
		
	public void setIdioma(Idioma newIdioma) {
		this.idioma = newIdioma;
	}
	
	public IdiomaDataAccess getIdiomaDataAccess() {
		return idiomaDataAccess;
	}
	
	public void setIdiomaDataAccess(IdiomaDataAccess newidiomaDataAccess) {
		this.idiomaDataAccess = newidiomaDataAccess;
	}
	
	public List<Idioma> getIdiomas() throws Exception {		
		this.quitarIdiomasNulos();
		
		IdiomaLogicAdditional.checkIdiomaToGets(idiomas,this.datosCliente,this.arrDatoGeneral);
		
		for (Idioma idiomaLocal: idiomas ) {
			IdiomaLogicAdditional.updateIdiomaToGet(idiomaLocal,this.arrDatoGeneral);
		}
		
		return idiomas;
	}
	
	public void setIdiomas(List<Idioma> newIdiomas) {
		this.idiomas = newIdiomas;
	}
	
	public Object getIdiomaObject() {	
		this.idiomaObject=this.idiomaDataAccess.getEntityObject();
		return this.idiomaObject;
	}
		
	public void setIdiomaObject(Object newIdiomaObject) {
		this.idiomaObject = newIdiomaObject;
	}
	
	public List<Object> getIdiomasObject() {		
		this.idiomasObject=this.idiomaDataAccess.getEntitiesObject();
		return this.idiomasObject;
	}
		
	public void setIdiomasObject(List<Object> newIdiomasObject) {
		this.idiomasObject = newIdiomasObject;
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
		
		if(this.idiomaDataAccess!=null) {
			this.idiomaDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Idioma.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			idiomaDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			idiomaDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		idioma = new  Idioma();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Idioma.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			idioma=idiomaDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.idioma,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				IdiomaConstantesFunciones.refrescarForeignKeysDescripcionesIdioma(this.idioma);
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
		idioma = new  Idioma();
		  		  
        try {
			
			idioma=idiomaDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.idioma,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				IdiomaConstantesFunciones.refrescarForeignKeysDescripcionesIdioma(this.idioma);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		idioma = new  Idioma();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Idioma.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			idioma=idiomaDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.idioma,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				IdiomaConstantesFunciones.refrescarForeignKeysDescripcionesIdioma(this.idioma);
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
		idioma = new  Idioma();
		  		  
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
		idioma = new  Idioma();
		  		  
        try {
			
			idioma=idiomaDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.idioma,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				IdiomaConstantesFunciones.refrescarForeignKeysDescripcionesIdioma(this.idioma);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		idioma = new  Idioma();
		  		  
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
		idioma = new  Idioma();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Idioma.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =idiomaDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		idioma = new  Idioma();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=idiomaDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		idioma = new  Idioma();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Idioma.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =idiomaDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		idioma = new  Idioma();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=idiomaDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		idioma = new  Idioma();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Idioma.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =idiomaDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		idioma = new  Idioma();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=idiomaDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		idiomas = new  ArrayList<Idioma>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Idioma.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			IdiomaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			idiomas=idiomaDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarIdioma(idiomas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				IdiomaConstantesFunciones.refrescarForeignKeysDescripcionesIdioma(this.idiomas);
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
		idiomas = new  ArrayList<Idioma>();
		  		  
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
		idiomas = new  ArrayList<Idioma>();
		  		  
        try {			
			IdiomaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			idiomas=idiomaDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarIdioma(idiomas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				IdiomaConstantesFunciones.refrescarForeignKeysDescripcionesIdioma(this.idiomas);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		idiomas = new  ArrayList<Idioma>();
		  		  
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
		idiomas = new  ArrayList<Idioma>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Idioma.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			IdiomaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			idiomas=idiomaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarIdioma(idiomas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				IdiomaConstantesFunciones.refrescarForeignKeysDescripcionesIdioma(this.idiomas);
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
		idiomas = new  ArrayList<Idioma>();
		  		  
        try {
			IdiomaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			idiomas=idiomaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarIdioma(idiomas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				IdiomaConstantesFunciones.refrescarForeignKeysDescripcionesIdioma(this.idiomas);
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
		idiomas = new  ArrayList<Idioma>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Idioma.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			IdiomaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			idiomas=idiomaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarIdioma(idiomas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				IdiomaConstantesFunciones.refrescarForeignKeysDescripcionesIdioma(this.idiomas);
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
		idiomas = new  ArrayList<Idioma>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			IdiomaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			idiomas=idiomaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarIdioma(idiomas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				IdiomaConstantesFunciones.refrescarForeignKeysDescripcionesIdioma(this.idiomas);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		idioma = new  Idioma();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Idioma.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			IdiomaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			idioma=idiomaDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarIdioma(idioma);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				IdiomaConstantesFunciones.refrescarForeignKeysDescripcionesIdioma(this.idioma);
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
		idioma = new  Idioma();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			IdiomaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			idioma=idiomaDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarIdioma(idioma);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				IdiomaConstantesFunciones.refrescarForeignKeysDescripcionesIdioma(this.idioma);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		idiomas = new  ArrayList<Idioma>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Idioma.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			IdiomaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			idiomas=idiomaDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarIdioma(idiomas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				IdiomaConstantesFunciones.refrescarForeignKeysDescripcionesIdioma(this.idiomas);
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
		idiomas = new  ArrayList<Idioma>();
		  		  
        try {
			IdiomaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			idiomas=idiomaDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarIdioma(idiomas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				IdiomaConstantesFunciones.refrescarForeignKeysDescripcionesIdioma(this.idiomas);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosIdiomasWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		idiomas = new  ArrayList<Idioma>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Idioma.class.getSimpleName()+"-getTodosIdiomasWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			IdiomaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			idiomas=idiomaDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarIdioma(idiomas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				IdiomaConstantesFunciones.refrescarForeignKeysDescripcionesIdioma(this.idiomas);
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
	
	public  void  getTodosIdiomas(String sFinalQuery,Pagination pagination)throws Exception {
		idiomas = new  ArrayList<Idioma>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			IdiomaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			idiomas=idiomaDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarIdioma(idiomas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				IdiomaConstantesFunciones.refrescarForeignKeysDescripcionesIdioma(this.idiomas);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarIdioma(Idioma idioma) throws Exception {
		Boolean estaValidado=false;
		
		if(idioma.getIsNew() || idioma.getIsChanged()) { 
			this.invalidValues = idiomaValidator.getInvalidValues(idioma);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(idioma);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarIdioma(List<Idioma> Idiomas) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(Idioma idiomaLocal:idiomas) {				
			estaValidadoObjeto=this.validarGuardarIdioma(idiomaLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarIdioma(List<Idioma> Idiomas) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarIdioma(idiomas)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarIdioma(Idioma Idioma) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarIdioma(idioma)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(Idioma idioma) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+idioma.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=IdiomaConstantesFunciones.getIdiomaLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"idioma","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(IdiomaConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(IdiomaConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveIdiomaWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Idioma.class.getSimpleName()+"-saveIdiomaWithConnection");connexion.begin();			
			
			IdiomaLogicAdditional.checkIdiomaToSave(this.idioma,this.datosCliente,connexion,this.arrDatoGeneral);
			
			IdiomaLogicAdditional.updateIdiomaToSave(this.idioma,this.arrDatoGeneral);
			
			IdiomaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.idioma,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowIdioma();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarIdioma(this.idioma)) {
				IdiomaDataAccess.save(this.idioma, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.idioma,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			IdiomaLogicAdditional.checkIdiomaToSaveAfter(this.idioma,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowIdioma();
			
			connexion.commit();			
			
			if(this.idioma.getIsDeleted()) {
				this.idioma=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveIdioma()throws Exception {	
		try {	
			
			IdiomaLogicAdditional.checkIdiomaToSave(this.idioma,this.datosCliente,connexion,this.arrDatoGeneral);
			
			IdiomaLogicAdditional.updateIdiomaToSave(this.idioma,this.arrDatoGeneral);
			
			IdiomaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.idioma,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarIdioma(this.idioma)) {			
				IdiomaDataAccess.save(this.idioma, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.idioma,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			IdiomaLogicAdditional.checkIdiomaToSaveAfter(this.idioma,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.idioma.getIsDeleted()) {
				this.idioma=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveIdiomasWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Idioma.class.getSimpleName()+"-saveIdiomasWithConnection");connexion.begin();			
			
			IdiomaLogicAdditional.checkIdiomaToSaves(idiomas,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowIdiomas();
			
			Boolean validadoTodosIdioma=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(Idioma idiomaLocal:idiomas) {		
				if(idiomaLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				IdiomaLogicAdditional.updateIdiomaToSave(idiomaLocal,this.arrDatoGeneral);
	        	
				IdiomaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),idiomaLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarIdioma(idiomaLocal)) {
					IdiomaDataAccess.save(idiomaLocal, connexion);				
				} else {
					validadoTodosIdioma=false;
				}
			}
			
			if(!validadoTodosIdioma) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			IdiomaLogicAdditional.checkIdiomaToSavesAfter(idiomas,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowIdiomas();
			
			connexion.commit();		
			
			this.quitarIdiomasEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveIdiomas()throws Exception {				
		 try {	
			IdiomaLogicAdditional.checkIdiomaToSaves(idiomas,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosIdioma=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(Idioma idiomaLocal:idiomas) {				
				if(idiomaLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				IdiomaLogicAdditional.updateIdiomaToSave(idiomaLocal,this.arrDatoGeneral);
	        	
				IdiomaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),idiomaLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarIdioma(idiomaLocal)) {				
					IdiomaDataAccess.save(idiomaLocal, connexion);				
				} else {
					validadoTodosIdioma=false;
				}
			}
			
			if(!validadoTodosIdioma) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			IdiomaLogicAdditional.checkIdiomaToSavesAfter(idiomas,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarIdiomasEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public IdiomaParameterReturnGeneral procesarAccionIdiomas(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<Idioma> idiomas,IdiomaParameterReturnGeneral idiomaParameterGeneral)throws Exception {
		 try {	
			IdiomaParameterReturnGeneral idiomaReturnGeneral=new IdiomaParameterReturnGeneral();
	
			IdiomaLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,idiomas,idiomaParameterGeneral,idiomaReturnGeneral);
			
			return idiomaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public IdiomaParameterReturnGeneral procesarAccionIdiomasWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<Idioma> idiomas,IdiomaParameterReturnGeneral idiomaParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Idioma.class.getSimpleName()+"-procesarAccionIdiomasWithConnection");connexion.begin();			
			
			IdiomaParameterReturnGeneral idiomaReturnGeneral=new IdiomaParameterReturnGeneral();
	
			IdiomaLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,idiomas,idiomaParameterGeneral,idiomaReturnGeneral);
			
			this.connexion.commit();
			
			return idiomaReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public IdiomaParameterReturnGeneral procesarEventosIdiomas(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<Idioma> idiomas,Idioma idioma,IdiomaParameterReturnGeneral idiomaParameterGeneral,Boolean isEsNuevoIdioma,ArrayList<Classe> clases)throws Exception {
		 try {	
			IdiomaParameterReturnGeneral idiomaReturnGeneral=new IdiomaParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				idiomaReturnGeneral.setConRecargarPropiedades(true);
			}
			
			IdiomaLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,idiomas,idioma,idiomaParameterGeneral,idiomaReturnGeneral,isEsNuevoIdioma,clases);
			
			return idiomaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public IdiomaParameterReturnGeneral procesarEventosIdiomasWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<Idioma> idiomas,Idioma idioma,IdiomaParameterReturnGeneral idiomaParameterGeneral,Boolean isEsNuevoIdioma,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Idioma.class.getSimpleName()+"-procesarEventosIdiomasWithConnection");connexion.begin();			
			
			IdiomaParameterReturnGeneral idiomaReturnGeneral=new IdiomaParameterReturnGeneral();
	
			idiomaReturnGeneral.setIdioma(idioma);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				idiomaReturnGeneral.setConRecargarPropiedades(true);
			}
			
			IdiomaLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,idiomas,idioma,idiomaParameterGeneral,idiomaReturnGeneral,isEsNuevoIdioma,clases);
			
			this.connexion.commit();
			
			return idiomaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public IdiomaParameterReturnGeneral procesarImportacionIdiomasWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,IdiomaParameterReturnGeneral idiomaParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Idioma.class.getSimpleName()+"-procesarImportacionIdiomasWithConnection");connexion.begin();			
			
			IdiomaParameterReturnGeneral idiomaReturnGeneral=new IdiomaParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.idiomas=new ArrayList<Idioma>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.idioma=new Idioma();
				
				
				if(conColumnasBase) {this.idioma.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.idioma.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.idioma.setnombre(arrColumnas[iColumn++]);
				this.idioma.setdescripcion(arrColumnas[iColumn++]);
				
				this.idiomas.add(this.idioma);
			}
			
			this.saveIdiomas();
			
			this.connexion.commit();
			
			idiomaReturnGeneral.setConRetornoEstaProcesado(true);
			idiomaReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return idiomaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarIdiomasEliminados() throws Exception {				
		
		List<Idioma> idiomasAux= new ArrayList<Idioma>();
		
		for(Idioma idioma:idiomas) {
			if(!idioma.getIsDeleted()) {
				idiomasAux.add(idioma);
			}
		}
		
		idiomas=idiomasAux;
	}
	
	public void quitarIdiomasNulos() throws Exception {				
		
		List<Idioma> idiomasAux= new ArrayList<Idioma>();
		
		for(Idioma idioma : this.idiomas) {
			if(idioma==null) {
				idiomasAux.add(idioma);
			}
		}
		
		//this.idiomas=idiomasAux;
		
		this.idiomas.removeAll(idiomasAux);
	}
	
	public void getSetVersionRowIdiomaWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(idioma.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((idioma.getIsDeleted() || (idioma.getIsChanged()&&!idioma.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=idiomaDataAccess.getSetVersionRowIdioma(connexion,idioma.getId());
				
				if(!idioma.getVersionRow().equals(timestamp)) {	
					idioma.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				idioma.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowIdioma()throws Exception {	
		
		if(idioma.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((idioma.getIsDeleted() || (idioma.getIsChanged()&&!idioma.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=idiomaDataAccess.getSetVersionRowIdioma(connexion,idioma.getId());
			
			try {							
				if(!idioma.getVersionRow().equals(timestamp)) {	
					idioma.setVersionRow(timestamp);
				}
				
				idioma.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowIdiomasWithConnection()throws Exception {	
		if(idiomas!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(Idioma idiomaAux:idiomas) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(idiomaAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(idiomaAux.getIsDeleted() || (idiomaAux.getIsChanged()&&!idiomaAux.getIsNew())) {
						
						timestamp=idiomaDataAccess.getSetVersionRowIdioma(connexion,idiomaAux.getId());
						
						if(!idioma.getVersionRow().equals(timestamp)) {	
							idiomaAux.setVersionRow(timestamp);
						}
								
						idiomaAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowIdiomas()throws Exception {	
		if(idiomas!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(Idioma idiomaAux:idiomas) {
					if(idiomaAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(idiomaAux.getIsDeleted() || (idiomaAux.getIsChanged()&&!idiomaAux.getIsNew())) {
						
						timestamp=idiomaDataAccess.getSetVersionRowIdioma(connexion,idiomaAux.getId());
						
						if(!idiomaAux.getVersionRow().equals(timestamp)) {	
							idiomaAux.setVersionRow(timestamp);
						}
						
													
						idiomaAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	
	public void cargarRelacionesLoteForeignKeyIdiomaWithConnection() throws Exception {
		ArrayList<Classe> classes=new ArrayList<Classe>();		
		
		
			EmpleadoIdiomaLogic empleadoidiomaLogic=new EmpleadoIdiomaLogic();
		
		try {
			
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Idioma.class.getSimpleName()+"-cargarRelacionesLoteForeignKeyIdiomaWithConnection");connexion.begin();
			
			
			classes.add(new Classe(EmpleadoIdioma.class));
											
			

			empleadoidiomaLogic.setConnexion(this.getConnexion());
			empleadoidiomaLogic.setDatosCliente(this.datosCliente);
			empleadoidiomaLogic.setIsConRefrescarForeignKeys(true);
			
			this.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
			
			for(Idioma idioma:this.idiomas) {
				

				classes=new ArrayList<Classe>();
				classes=EmpleadoIdiomaConstantesFunciones.getClassesForeignKeysOfEmpleadoIdioma(new ArrayList<Classe>(),DeepLoadType.NONE);

				empleadoidiomaLogic.setEmpleadoIdiomas(idioma.empleadoidiomas);
				empleadoidiomaLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
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
	
	public void deepLoad(Idioma idioma,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			IdiomaLogicAdditional.updateIdiomaToGet(idioma,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		idioma.setEmpleadoIdiomas(idiomaDataAccess.getEmpleadoIdiomas(connexion,idioma));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(EmpleadoIdioma.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				idioma.setEmpleadoIdiomas(idiomaDataAccess.getEmpleadoIdiomas(connexion,idioma));

				if(this.isConDeep) {
					EmpleadoIdiomaLogic empleadoidiomaLogic= new EmpleadoIdiomaLogic(this.connexion);
					empleadoidiomaLogic.setEmpleadoIdiomas(idioma.getEmpleadoIdiomas());
					ArrayList<Classe> classesLocal=EmpleadoIdiomaConstantesFunciones.getClassesForeignKeysOfEmpleadoIdioma(new ArrayList<Classe>(),DeepLoadType.NONE);
					empleadoidiomaLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					EmpleadoIdiomaConstantesFunciones.refrescarForeignKeysDescripcionesEmpleadoIdioma(empleadoidiomaLogic.getEmpleadoIdiomas());
					idioma.setEmpleadoIdiomas(empleadoidiomaLogic.getEmpleadoIdiomas());
				}

				continue;
			}
		}
	}
	else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {


		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(EmpleadoIdioma.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(EmpleadoIdioma.class));
			idioma.setEmpleadoIdiomas(idiomaDataAccess.getEmpleadoIdiomas(connexion,idioma));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {


		idioma.setEmpleadoIdiomas(idiomaDataAccess.getEmpleadoIdiomas(connexion,idioma));

		for(EmpleadoIdioma empleadoidioma:idioma.getEmpleadoIdiomas()) {
			EmpleadoIdiomaLogic empleadoidiomaLogic= new EmpleadoIdiomaLogic(connexion);
			empleadoidiomaLogic.deepLoad(empleadoidioma,isDeep,deepLoadType,clases);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(EmpleadoIdioma.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				idioma.setEmpleadoIdiomas(idiomaDataAccess.getEmpleadoIdiomas(connexion,idioma));

				for(EmpleadoIdioma empleadoidioma:idioma.getEmpleadoIdiomas()) {
					EmpleadoIdiomaLogic empleadoidiomaLogic= new EmpleadoIdiomaLogic(connexion);
					empleadoidiomaLogic.deepLoad(empleadoidioma,isDeep,deepLoadType,clases);
				}
				continue;
			}

		}
	}
	else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {


		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(EmpleadoIdioma.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(EmpleadoIdioma.class));
			idioma.setEmpleadoIdiomas(idiomaDataAccess.getEmpleadoIdiomas(connexion,idioma));

			for(EmpleadoIdioma empleadoidioma:idioma.getEmpleadoIdiomas()) {
				EmpleadoIdiomaLogic empleadoidiomaLogic= new EmpleadoIdiomaLogic(connexion);
				empleadoidiomaLogic.deepLoad(empleadoidioma,isDeep,deepLoadType,clases);
			}
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(Idioma idioma,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			IdiomaLogicAdditional.updateIdiomaToSave(idioma,this.arrDatoGeneral);
			
IdiomaDataAccess.save(idioma, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		for(EmpleadoIdioma empleadoidioma:idioma.getEmpleadoIdiomas()) {
			empleadoidioma.setid_idioma(idioma.getId());
			EmpleadoIdiomaDataAccess.save(empleadoidioma,connexion);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {

			if(clas.clas.equals(EmpleadoIdioma.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(EmpleadoIdioma empleadoidioma:idioma.getEmpleadoIdiomas()) {
					empleadoidioma.setid_idioma(idioma.getId());
					EmpleadoIdiomaDataAccess.save(empleadoidioma,connexion);
				}
				continue;
			}
		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		for(EmpleadoIdioma empleadoidioma:idioma.getEmpleadoIdiomas()) {
			EmpleadoIdiomaLogic empleadoidiomaLogic= new EmpleadoIdiomaLogic(connexion);
			empleadoidioma.setid_idioma(idioma.getId());
			EmpleadoIdiomaDataAccess.save(empleadoidioma,connexion);
			empleadoidiomaLogic.deepSave(empleadoidioma,isDeep,deepLoadType,clases);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {

			if(clas.clas.equals(EmpleadoIdioma.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(EmpleadoIdioma empleadoidioma:idioma.getEmpleadoIdiomas()) {
					EmpleadoIdiomaLogic empleadoidiomaLogic= new EmpleadoIdiomaLogic(connexion);
					empleadoidioma.setid_idioma(idioma.getId());
					EmpleadoIdiomaDataAccess.save(empleadoidioma,connexion);
					empleadoidiomaLogic.deepSave(empleadoidioma,isDeep,deepLoadType,clases);
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
			this.getNewConnexionToDeep(Idioma.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(idioma,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				IdiomaConstantesFunciones.refrescarForeignKeysDescripcionesIdioma(idioma);
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
			this.deepLoad(this.idioma,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				IdiomaConstantesFunciones.refrescarForeignKeysDescripcionesIdioma(this.idioma);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(Idioma.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(idiomas!=null) {
				for(Idioma idioma:idiomas) {
					this.deepLoad(idioma,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					IdiomaConstantesFunciones.refrescarForeignKeysDescripcionesIdioma(idiomas);
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
			if(idiomas!=null) {
				for(Idioma idioma:idiomas) {
					this.deepLoad(idioma,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					IdiomaConstantesFunciones.refrescarForeignKeysDescripcionesIdioma(idiomas);
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
			this.getNewConnexionToDeep(Idioma.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(idioma,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(Idioma.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(idiomas!=null) {
				for(Idioma idioma:idiomas) {
					this.deepSave(idioma,isDeep,deepLoadType,clases);
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
			if(idiomas!=null) {
				for(Idioma idioma:idiomas) {
					this.deepSave(idioma,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,String sProcesoBusqueda,String sDetalleProcesoBusqueda,QueryWhereSelectParameters queryWhereSelectParameters,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(IdiomaConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,IdiomaDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,Idioma idioma,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(IdiomaConstantesFunciones.ISCONAUDITORIA) {
				if(idioma.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,IdiomaDataAccess.TABLENAME, idioma.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(IdiomaConstantesFunciones.ISCONAUDITORIADETALLE) {
						////IdiomaLogic.registrarAuditoriaDetallesIdioma(connexion,idioma,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(idioma.getIsDeleted()) {
					/*if(!idioma.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,IdiomaDataAccess.TABLENAME, idioma.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////IdiomaLogic.registrarAuditoriaDetallesIdioma(connexion,idioma,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,IdiomaDataAccess.TABLENAME, idioma.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(idioma.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,IdiomaDataAccess.TABLENAME, idioma.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(IdiomaConstantesFunciones.ISCONAUDITORIADETALLE) {
						////IdiomaLogic.registrarAuditoriaDetallesIdioma(connexion,idioma,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesIdioma(Connexion connexion,Idioma idioma)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(idioma.getIsNew()||!idioma.getnombre().equals(idioma.getIdiomaOriginal().getnombre()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(idioma.getIdiomaOriginal().getnombre()!=null)
				{
					strValorActual=idioma.getIdiomaOriginal().getnombre();
				}
				if(idioma.getnombre()!=null)
				{
					strValorNuevo=idioma.getnombre() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),IdiomaConstantesFunciones.NOMBRE,strValorActual,strValorNuevo);
			}	
			
			if(idioma.getIsNew()||!idioma.getdescripcion().equals(idioma.getIdiomaOriginal().getdescripcion()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(idioma.getIdiomaOriginal().getdescripcion()!=null)
				{
					strValorActual=idioma.getIdiomaOriginal().getdescripcion();
				}
				if(idioma.getdescripcion()!=null)
				{
					strValorNuevo=idioma.getdescripcion() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),IdiomaConstantesFunciones.DESCRIPCION,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void saveIdiomaRelacionesWithConnection(Idioma idioma,List<EmpleadoIdioma> empleadoidiomas) throws Exception {

		if(!idioma.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveIdiomaRelacionesBase(idioma,empleadoidiomas,true);
		}
	}

	public void saveIdiomaRelaciones(Idioma idioma,List<EmpleadoIdioma> empleadoidiomas)throws Exception {

		if(!idioma.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveIdiomaRelacionesBase(idioma,empleadoidiomas,false);
		}
	}

	public void saveIdiomaRelacionesBase(Idioma idioma,List<EmpleadoIdioma> empleadoidiomas,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("Idioma-saveRelacionesWithConnection");}
	
			idioma.setEmpleadoIdiomas(empleadoidiomas);

			this.setIdioma(idioma);

				if((idioma.getIsNew()||idioma.getIsChanged())&&!idioma.getIsDeleted()) {
					this.saveIdioma();
					this.saveIdiomaRelacionesDetalles(empleadoidiomas);

				} else if(idioma.getIsDeleted()) {
					this.saveIdiomaRelacionesDetalles(empleadoidiomas);
					this.saveIdioma();
				}

			if(conConexion) {connexion.commit();}

		} catch(Exception e) {
			
			EmpleadoIdiomaConstantesFunciones.InicializarGeneralEntityAuxiliaresEmpleadoIdiomas(empleadoidiomas,true,true);

			if(conConexion){connexion.rollback();}
			Funciones.manageException(logger,e);
			throw e;

		} finally {
			if(conConexion){this.closeNewConnexionToDeep();}
		}
	}
	
	
	private void saveIdiomaRelacionesDetalles(List<EmpleadoIdioma> empleadoidiomas)throws Exception {
		try {
	

			Long idIdiomaActual=this.getIdioma().getId();

			EmpleadoIdiomaLogic empleadoidiomaLogic_Desde_Idioma=new EmpleadoIdiomaLogic();
			empleadoidiomaLogic_Desde_Idioma.setEmpleadoIdiomas(empleadoidiomas);

			empleadoidiomaLogic_Desde_Idioma.setConnexion(this.getConnexion());
			empleadoidiomaLogic_Desde_Idioma.setDatosCliente(this.datosCliente);

			for(EmpleadoIdioma empleadoidioma_Desde_Idioma:empleadoidiomaLogic_Desde_Idioma.getEmpleadoIdiomas()) {
				empleadoidioma_Desde_Idioma.setid_idioma(idIdiomaActual);
			}

			empleadoidiomaLogic_Desde_Idioma.saveEmpleadoIdiomas();

		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfIdioma(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=IdiomaConstantesFunciones.getClassesForeignKeysOfIdioma(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfIdioma(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=IdiomaConstantesFunciones.getClassesRelationshipsOfIdioma(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}
