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
package com.bydan.erp.seguridad.business.logic;

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
import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.seguridad.util.PerfilCampoConstantesFunciones;
import com.bydan.erp.seguridad.util.PerfilCampoParameterReturnGeneral;
//import com.bydan.erp.seguridad.util.PerfilCampoParameterGeneral;
import com.bydan.erp.seguridad.business.entity.PerfilCampo;
import com.bydan.erp.seguridad.business.logic.PerfilCampoLogicAdditional;
import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.seguridad.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;
















@SuppressWarnings("unused")
public class PerfilCampoLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(PerfilCampoLogic.class);
	
	protected PerfilCampoDataAccess perfilcampoDataAccess; 	
	protected PerfilCampo perfilcampo;
	protected List<PerfilCampo> perfilcampos;
	protected Object perfilcampoObject;	
	protected List<Object> perfilcamposObject;
	
	public static ClassValidator<PerfilCampo> perfilcampoValidator = new ClassValidator<PerfilCampo>(PerfilCampo.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected PerfilCampoLogicAdditional perfilcampoLogicAdditional=null;
	
	public PerfilCampoLogicAdditional getPerfilCampoLogicAdditional() {
		return this.perfilcampoLogicAdditional;
	}
	
	public void setPerfilCampoLogicAdditional(PerfilCampoLogicAdditional perfilcampoLogicAdditional) {
		try {
			this.perfilcampoLogicAdditional=perfilcampoLogicAdditional;
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
	
	
	
	
	public  PerfilCampoLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.perfilcampoDataAccess = new PerfilCampoDataAccess();
			
			this.perfilcampos= new ArrayList<PerfilCampo>();
			this.perfilcampo= new PerfilCampo();
			
			this.perfilcampoObject=new Object();
			this.perfilcamposObject=new ArrayList<Object>();
				
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
			
			this.perfilcampoDataAccess.setConnexionType(this.connexionType);
			this.perfilcampoDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  PerfilCampoLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.perfilcampoDataAccess = new PerfilCampoDataAccess();
			this.perfilcampos= new ArrayList<PerfilCampo>();
			this.perfilcampo= new PerfilCampo();
			this.perfilcampoObject=new Object();
			this.perfilcamposObject=new ArrayList<Object>();
			
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
			
			this.perfilcampoDataAccess.setConnexionType(this.connexionType);
			this.perfilcampoDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public PerfilCampo getPerfilCampo() throws Exception {	
		PerfilCampoLogicAdditional.checkPerfilCampoToGet(perfilcampo,this.datosCliente,this.arrDatoGeneral);
		PerfilCampoLogicAdditional.updatePerfilCampoToGet(perfilcampo,this.arrDatoGeneral);
		
		return perfilcampo;
	}
		
	public void setPerfilCampo(PerfilCampo newPerfilCampo) {
		this.perfilcampo = newPerfilCampo;
	}
	
	public PerfilCampoDataAccess getPerfilCampoDataAccess() {
		return perfilcampoDataAccess;
	}
	
	public void setPerfilCampoDataAccess(PerfilCampoDataAccess newperfilcampoDataAccess) {
		this.perfilcampoDataAccess = newperfilcampoDataAccess;
	}
	
	public List<PerfilCampo> getPerfilCampos() throws Exception {		
		this.quitarPerfilCamposNulos();
		
		PerfilCampoLogicAdditional.checkPerfilCampoToGets(perfilcampos,this.datosCliente,this.arrDatoGeneral);
		
		for (PerfilCampo perfilcampoLocal: perfilcampos ) {
			PerfilCampoLogicAdditional.updatePerfilCampoToGet(perfilcampoLocal,this.arrDatoGeneral);
		}
		
		return perfilcampos;
	}
	
	public void setPerfilCampos(List<PerfilCampo> newPerfilCampos) {
		this.perfilcampos = newPerfilCampos;
	}
	
	public Object getPerfilCampoObject() {	
		this.perfilcampoObject=this.perfilcampoDataAccess.getEntityObject();
		return this.perfilcampoObject;
	}
		
	public void setPerfilCampoObject(Object newPerfilCampoObject) {
		this.perfilcampoObject = newPerfilCampoObject;
	}
	
	public List<Object> getPerfilCamposObject() {		
		this.perfilcamposObject=this.perfilcampoDataAccess.getEntitiesObject();
		return this.perfilcamposObject;
	}
		
	public void setPerfilCamposObject(List<Object> newPerfilCamposObject) {
		this.perfilcamposObject = newPerfilCamposObject;
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
		
		if(this.perfilcampoDataAccess!=null) {
			this.perfilcampoDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PerfilCampo.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			perfilcampoDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			perfilcampoDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		perfilcampo = new  PerfilCampo();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PerfilCampo.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			perfilcampo=perfilcampoDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.perfilcampo,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				PerfilCampoConstantesFunciones.refrescarForeignKeysDescripcionesPerfilCampo(this.perfilcampo);
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
		perfilcampo = new  PerfilCampo();
		  		  
        try {
			
			perfilcampo=perfilcampoDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.perfilcampo,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				PerfilCampoConstantesFunciones.refrescarForeignKeysDescripcionesPerfilCampo(this.perfilcampo);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		perfilcampo = new  PerfilCampo();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PerfilCampo.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			perfilcampo=perfilcampoDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.perfilcampo,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				PerfilCampoConstantesFunciones.refrescarForeignKeysDescripcionesPerfilCampo(this.perfilcampo);
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
		perfilcampo = new  PerfilCampo();
		  		  
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
		perfilcampo = new  PerfilCampo();
		  		  
        try {
			
			perfilcampo=perfilcampoDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.perfilcampo,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				PerfilCampoConstantesFunciones.refrescarForeignKeysDescripcionesPerfilCampo(this.perfilcampo);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		perfilcampo = new  PerfilCampo();
		  		  
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
		perfilcampo = new  PerfilCampo();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PerfilCampo.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =perfilcampoDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		perfilcampo = new  PerfilCampo();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=perfilcampoDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		perfilcampo = new  PerfilCampo();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PerfilCampo.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =perfilcampoDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		perfilcampo = new  PerfilCampo();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=perfilcampoDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		perfilcampo = new  PerfilCampo();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PerfilCampo.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =perfilcampoDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		perfilcampo = new  PerfilCampo();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=perfilcampoDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		perfilcampos = new  ArrayList<PerfilCampo>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PerfilCampo.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			PerfilCampoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			perfilcampos=perfilcampoDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarPerfilCampo(perfilcampos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				PerfilCampoConstantesFunciones.refrescarForeignKeysDescripcionesPerfilCampo(this.perfilcampos);
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
		perfilcampos = new  ArrayList<PerfilCampo>();
		  		  
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
		perfilcampos = new  ArrayList<PerfilCampo>();
		  		  
        try {			
			PerfilCampoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			perfilcampos=perfilcampoDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarPerfilCampo(perfilcampos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				PerfilCampoConstantesFunciones.refrescarForeignKeysDescripcionesPerfilCampo(this.perfilcampos);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		perfilcampos = new  ArrayList<PerfilCampo>();
		  		  
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
		perfilcampos = new  ArrayList<PerfilCampo>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PerfilCampo.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			PerfilCampoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			perfilcampos=perfilcampoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarPerfilCampo(perfilcampos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				PerfilCampoConstantesFunciones.refrescarForeignKeysDescripcionesPerfilCampo(this.perfilcampos);
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
		perfilcampos = new  ArrayList<PerfilCampo>();
		  		  
        try {
			PerfilCampoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			perfilcampos=perfilcampoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarPerfilCampo(perfilcampos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				PerfilCampoConstantesFunciones.refrescarForeignKeysDescripcionesPerfilCampo(this.perfilcampos);
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
		perfilcampos = new  ArrayList<PerfilCampo>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PerfilCampo.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			PerfilCampoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			perfilcampos=perfilcampoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarPerfilCampo(perfilcampos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				PerfilCampoConstantesFunciones.refrescarForeignKeysDescripcionesPerfilCampo(this.perfilcampos);
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
		perfilcampos = new  ArrayList<PerfilCampo>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			PerfilCampoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			perfilcampos=perfilcampoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarPerfilCampo(perfilcampos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				PerfilCampoConstantesFunciones.refrescarForeignKeysDescripcionesPerfilCampo(this.perfilcampos);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		perfilcampo = new  PerfilCampo();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PerfilCampo.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			PerfilCampoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			perfilcampo=perfilcampoDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarPerfilCampo(perfilcampo);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				PerfilCampoConstantesFunciones.refrescarForeignKeysDescripcionesPerfilCampo(this.perfilcampo);
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
		perfilcampo = new  PerfilCampo();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			PerfilCampoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			perfilcampo=perfilcampoDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarPerfilCampo(perfilcampo);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				PerfilCampoConstantesFunciones.refrescarForeignKeysDescripcionesPerfilCampo(this.perfilcampo);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		perfilcampos = new  ArrayList<PerfilCampo>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PerfilCampo.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			PerfilCampoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			perfilcampos=perfilcampoDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarPerfilCampo(perfilcampos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				PerfilCampoConstantesFunciones.refrescarForeignKeysDescripcionesPerfilCampo(this.perfilcampos);
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
		perfilcampos = new  ArrayList<PerfilCampo>();
		  		  
        try {
			PerfilCampoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			perfilcampos=perfilcampoDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarPerfilCampo(perfilcampos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				PerfilCampoConstantesFunciones.refrescarForeignKeysDescripcionesPerfilCampo(this.perfilcampos);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosPerfilCamposWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		perfilcampos = new  ArrayList<PerfilCampo>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PerfilCampo.class.getSimpleName()+"-getTodosPerfilCamposWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			PerfilCampoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			perfilcampos=perfilcampoDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarPerfilCampo(perfilcampos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				PerfilCampoConstantesFunciones.refrescarForeignKeysDescripcionesPerfilCampo(this.perfilcampos);
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
	
	public  void  getTodosPerfilCampos(String sFinalQuery,Pagination pagination)throws Exception {
		perfilcampos = new  ArrayList<PerfilCampo>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			PerfilCampoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			perfilcampos=perfilcampoDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarPerfilCampo(perfilcampos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				PerfilCampoConstantesFunciones.refrescarForeignKeysDescripcionesPerfilCampo(this.perfilcampos);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarPerfilCampo(PerfilCampo perfilcampo) throws Exception {
		Boolean estaValidado=false;
		
		if(perfilcampo.getIsNew() || perfilcampo.getIsChanged()) { 
			this.invalidValues = perfilcampoValidator.getInvalidValues(perfilcampo);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(perfilcampo);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarPerfilCampo(List<PerfilCampo> PerfilCampos) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(PerfilCampo perfilcampoLocal:perfilcampos) {				
			estaValidadoObjeto=this.validarGuardarPerfilCampo(perfilcampoLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarPerfilCampo(List<PerfilCampo> PerfilCampos) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarPerfilCampo(perfilcampos)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarPerfilCampo(PerfilCampo PerfilCampo) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarPerfilCampo(perfilcampo)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(PerfilCampo perfilcampo) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+perfilcampo.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=PerfilCampoConstantesFunciones.getPerfilCampoLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"perfilcampo","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(PerfilCampoConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(PerfilCampoConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void savePerfilCampoWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PerfilCampo.class.getSimpleName()+"-savePerfilCampoWithConnection");connexion.begin();			
			
			PerfilCampoLogicAdditional.checkPerfilCampoToSave(this.perfilcampo,this.datosCliente,connexion,this.arrDatoGeneral);
			
			PerfilCampoLogicAdditional.updatePerfilCampoToSave(this.perfilcampo,this.arrDatoGeneral);
			
			PerfilCampoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.perfilcampo,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowPerfilCampo();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarPerfilCampo(this.perfilcampo)) {
				PerfilCampoDataAccess.save(this.perfilcampo, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.perfilcampo,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			PerfilCampoLogicAdditional.checkPerfilCampoToSaveAfter(this.perfilcampo,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowPerfilCampo();
			
			connexion.commit();			
			
			if(this.perfilcampo.getIsDeleted()) {
				this.perfilcampo=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void savePerfilCampo()throws Exception {	
		try {	
			
			PerfilCampoLogicAdditional.checkPerfilCampoToSave(this.perfilcampo,this.datosCliente,connexion,this.arrDatoGeneral);
			
			PerfilCampoLogicAdditional.updatePerfilCampoToSave(this.perfilcampo,this.arrDatoGeneral);
			
			PerfilCampoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.perfilcampo,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarPerfilCampo(this.perfilcampo)) {			
				PerfilCampoDataAccess.save(this.perfilcampo, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.perfilcampo,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			PerfilCampoLogicAdditional.checkPerfilCampoToSaveAfter(this.perfilcampo,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.perfilcampo.getIsDeleted()) {
				this.perfilcampo=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void savePerfilCamposWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PerfilCampo.class.getSimpleName()+"-savePerfilCamposWithConnection");connexion.begin();			
			
			PerfilCampoLogicAdditional.checkPerfilCampoToSaves(perfilcampos,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowPerfilCampos();
			
			Boolean validadoTodosPerfilCampo=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(PerfilCampo perfilcampoLocal:perfilcampos) {		
				if(perfilcampoLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				PerfilCampoLogicAdditional.updatePerfilCampoToSave(perfilcampoLocal,this.arrDatoGeneral);
	        	
				PerfilCampoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),perfilcampoLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarPerfilCampo(perfilcampoLocal)) {
					PerfilCampoDataAccess.save(perfilcampoLocal, connexion);				
				} else {
					validadoTodosPerfilCampo=false;
				}
			}
			
			if(!validadoTodosPerfilCampo) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			PerfilCampoLogicAdditional.checkPerfilCampoToSavesAfter(perfilcampos,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowPerfilCampos();
			
			connexion.commit();		
			
			this.quitarPerfilCamposEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void savePerfilCampos()throws Exception {				
		 try {	
			PerfilCampoLogicAdditional.checkPerfilCampoToSaves(perfilcampos,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosPerfilCampo=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(PerfilCampo perfilcampoLocal:perfilcampos) {				
				if(perfilcampoLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				PerfilCampoLogicAdditional.updatePerfilCampoToSave(perfilcampoLocal,this.arrDatoGeneral);
	        	
				PerfilCampoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),perfilcampoLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarPerfilCampo(perfilcampoLocal)) {				
					PerfilCampoDataAccess.save(perfilcampoLocal, connexion);				
				} else {
					validadoTodosPerfilCampo=false;
				}
			}
			
			if(!validadoTodosPerfilCampo) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			PerfilCampoLogicAdditional.checkPerfilCampoToSavesAfter(perfilcampos,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarPerfilCamposEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public PerfilCampoParameterReturnGeneral procesarAccionPerfilCampos(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<PerfilCampo> perfilcampos,PerfilCampoParameterReturnGeneral perfilcampoParameterGeneral)throws Exception {
		 try {	
			PerfilCampoParameterReturnGeneral perfilcampoReturnGeneral=new PerfilCampoParameterReturnGeneral();
	
			PerfilCampoLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,perfilcampos,perfilcampoParameterGeneral,perfilcampoReturnGeneral);
			
			return perfilcampoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public PerfilCampoParameterReturnGeneral procesarAccionPerfilCamposWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<PerfilCampo> perfilcampos,PerfilCampoParameterReturnGeneral perfilcampoParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PerfilCampo.class.getSimpleName()+"-procesarAccionPerfilCamposWithConnection");connexion.begin();			
			
			PerfilCampoParameterReturnGeneral perfilcampoReturnGeneral=new PerfilCampoParameterReturnGeneral();
	
			PerfilCampoLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,perfilcampos,perfilcampoParameterGeneral,perfilcampoReturnGeneral);
			
			this.connexion.commit();
			
			return perfilcampoReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public PerfilCampoParameterReturnGeneral procesarEventosPerfilCampos(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<PerfilCampo> perfilcampos,PerfilCampo perfilcampo,PerfilCampoParameterReturnGeneral perfilcampoParameterGeneral,Boolean isEsNuevoPerfilCampo,ArrayList<Classe> clases)throws Exception {
		 try {	
			PerfilCampoParameterReturnGeneral perfilcampoReturnGeneral=new PerfilCampoParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				perfilcampoReturnGeneral.setConRecargarPropiedades(true);
			}
			
			PerfilCampoLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,perfilcampos,perfilcampo,perfilcampoParameterGeneral,perfilcampoReturnGeneral,isEsNuevoPerfilCampo,clases);
			
			return perfilcampoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public PerfilCampoParameterReturnGeneral procesarEventosPerfilCamposWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<PerfilCampo> perfilcampos,PerfilCampo perfilcampo,PerfilCampoParameterReturnGeneral perfilcampoParameterGeneral,Boolean isEsNuevoPerfilCampo,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PerfilCampo.class.getSimpleName()+"-procesarEventosPerfilCamposWithConnection");connexion.begin();			
			
			PerfilCampoParameterReturnGeneral perfilcampoReturnGeneral=new PerfilCampoParameterReturnGeneral();
	
			perfilcampoReturnGeneral.setPerfilCampo(perfilcampo);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				perfilcampoReturnGeneral.setConRecargarPropiedades(true);
			}
			
			PerfilCampoLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,perfilcampos,perfilcampo,perfilcampoParameterGeneral,perfilcampoReturnGeneral,isEsNuevoPerfilCampo,clases);
			
			this.connexion.commit();
			
			return perfilcampoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public PerfilCampoParameterReturnGeneral procesarImportacionPerfilCamposWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,PerfilCampoParameterReturnGeneral perfilcampoParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PerfilCampo.class.getSimpleName()+"-procesarImportacionPerfilCamposWithConnection");connexion.begin();			
			
			PerfilCampoParameterReturnGeneral perfilcampoReturnGeneral=new PerfilCampoParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.perfilcampos=new ArrayList<PerfilCampo>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.perfilcampo=new PerfilCampo();
				
				
				if(conColumnasBase) {this.perfilcampo.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.perfilcampo.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.perfilcampo.settodo(Boolean.parseBoolean(arrColumnas[iColumn++]));
				this.perfilcampo.setingreso(Boolean.parseBoolean(arrColumnas[iColumn++]));
				this.perfilcampo.setmodificacion(Boolean.parseBoolean(arrColumnas[iColumn++]));
				this.perfilcampo.seteliminacion(Boolean.parseBoolean(arrColumnas[iColumn++]));
				this.perfilcampo.setconsulta(Boolean.parseBoolean(arrColumnas[iColumn++]));
				this.perfilcampo.setestado(Boolean.parseBoolean(arrColumnas[iColumn++]));
				
				this.perfilcampos.add(this.perfilcampo);
			}
			
			this.savePerfilCampos();
			
			this.connexion.commit();
			
			perfilcampoReturnGeneral.setConRetornoEstaProcesado(true);
			perfilcampoReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return perfilcampoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarPerfilCamposEliminados() throws Exception {				
		
		List<PerfilCampo> perfilcamposAux= new ArrayList<PerfilCampo>();
		
		for(PerfilCampo perfilcampo:perfilcampos) {
			if(!perfilcampo.getIsDeleted()) {
				perfilcamposAux.add(perfilcampo);
			}
		}
		
		perfilcampos=perfilcamposAux;
	}
	
	public void quitarPerfilCamposNulos() throws Exception {				
		
		List<PerfilCampo> perfilcamposAux= new ArrayList<PerfilCampo>();
		
		for(PerfilCampo perfilcampo : this.perfilcampos) {
			if(perfilcampo==null) {
				perfilcamposAux.add(perfilcampo);
			}
		}
		
		//this.perfilcampos=perfilcamposAux;
		
		this.perfilcampos.removeAll(perfilcamposAux);
	}
	
	public void getSetVersionRowPerfilCampoWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(perfilcampo.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((perfilcampo.getIsDeleted() || (perfilcampo.getIsChanged()&&!perfilcampo.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=perfilcampoDataAccess.getSetVersionRowPerfilCampo(connexion,perfilcampo.getId());
				
				if(!perfilcampo.getVersionRow().equals(timestamp)) {	
					perfilcampo.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				perfilcampo.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowPerfilCampo()throws Exception {	
		
		if(perfilcampo.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((perfilcampo.getIsDeleted() || (perfilcampo.getIsChanged()&&!perfilcampo.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=perfilcampoDataAccess.getSetVersionRowPerfilCampo(connexion,perfilcampo.getId());
			
			try {							
				if(!perfilcampo.getVersionRow().equals(timestamp)) {	
					perfilcampo.setVersionRow(timestamp);
				}
				
				perfilcampo.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowPerfilCamposWithConnection()throws Exception {	
		if(perfilcampos!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(PerfilCampo perfilcampoAux:perfilcampos) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(perfilcampoAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(perfilcampoAux.getIsDeleted() || (perfilcampoAux.getIsChanged()&&!perfilcampoAux.getIsNew())) {
						
						timestamp=perfilcampoDataAccess.getSetVersionRowPerfilCampo(connexion,perfilcampoAux.getId());
						
						if(!perfilcampo.getVersionRow().equals(timestamp)) {	
							perfilcampoAux.setVersionRow(timestamp);
						}
								
						perfilcampoAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowPerfilCampos()throws Exception {	
		if(perfilcampos!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(PerfilCampo perfilcampoAux:perfilcampos) {
					if(perfilcampoAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(perfilcampoAux.getIsDeleted() || (perfilcampoAux.getIsChanged()&&!perfilcampoAux.getIsNew())) {
						
						timestamp=perfilcampoDataAccess.getSetVersionRowPerfilCampo(connexion,perfilcampoAux.getId());
						
						if(!perfilcampoAux.getVersionRow().equals(timestamp)) {	
							perfilcampoAux.setVersionRow(timestamp);
						}
						
													
						perfilcampoAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public PerfilCampoParameterReturnGeneral cargarCombosLoteForeignKeyPerfilCampoWithConnection(String finalQueryGlobalPerfil,String finalQueryGlobalCampo) throws Exception {
		PerfilCampoParameterReturnGeneral  perfilcampoReturnGeneral =new PerfilCampoParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PerfilCampo.class.getSimpleName()+"-cargarCombosLoteForeignKeyPerfilCampoWithConnection");connexion.begin();
			
			perfilcampoReturnGeneral =new PerfilCampoParameterReturnGeneral();
			
			

			List<Perfil> perfilsForeignKey=new ArrayList<Perfil>();
			PerfilLogic perfilLogic=new PerfilLogic();
			perfilLogic.setConnexion(this.connexion);
			perfilLogic.getPerfilDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalPerfil.equals("NONE")) {
				perfilLogic.getTodosPerfils(finalQueryGlobalPerfil,new Pagination());
				perfilsForeignKey=perfilLogic.getPerfils();
			}

			perfilcampoReturnGeneral.setperfilsForeignKey(perfilsForeignKey);


			List<Campo> camposForeignKey=new ArrayList<Campo>();
			CampoLogic campoLogic=new CampoLogic();
			campoLogic.setConnexion(this.connexion);
			campoLogic.getCampoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCampo.equals("NONE")) {
				campoLogic.getTodosCampos(finalQueryGlobalCampo,new Pagination());
				camposForeignKey=campoLogic.getCampos();
			}

			perfilcampoReturnGeneral.setcamposForeignKey(camposForeignKey);

			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
		
		return perfilcampoReturnGeneral;
	}
	
	public PerfilCampoParameterReturnGeneral cargarCombosLoteForeignKeyPerfilCampo(String finalQueryGlobalPerfil,String finalQueryGlobalCampo) throws Exception {
		PerfilCampoParameterReturnGeneral  perfilcampoReturnGeneral =new PerfilCampoParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {						
			perfilcampoReturnGeneral =new PerfilCampoParameterReturnGeneral();
			
			

			List<Perfil> perfilsForeignKey=new ArrayList<Perfil>();
			PerfilLogic perfilLogic=new PerfilLogic();
			perfilLogic.setConnexion(this.connexion);
			perfilLogic.getPerfilDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalPerfil.equals("NONE")) {
				perfilLogic.getTodosPerfils(finalQueryGlobalPerfil,new Pagination());
				perfilsForeignKey=perfilLogic.getPerfils();
			}

			perfilcampoReturnGeneral.setperfilsForeignKey(perfilsForeignKey);


			List<Campo> camposForeignKey=new ArrayList<Campo>();
			CampoLogic campoLogic=new CampoLogic();
			campoLogic.setConnexion(this.connexion);
			campoLogic.getCampoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCampo.equals("NONE")) {
				campoLogic.getTodosCampos(finalQueryGlobalCampo,new Pagination());
				camposForeignKey=campoLogic.getCampos();
			}

			perfilcampoReturnGeneral.setcamposForeignKey(camposForeignKey);
						
			
		} catch(Exception e) {			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			
		}
		
		return perfilcampoReturnGeneral;
	}
	
	
	public void deepLoad(PerfilCampo perfilcampo,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			PerfilCampoLogicAdditional.updatePerfilCampoToGet(perfilcampo,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		perfilcampo.setPerfil(perfilcampoDataAccess.getPerfil(connexion,perfilcampo));
		perfilcampo.setCampo(perfilcampoDataAccess.getCampo(connexion,perfilcampo));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Perfil.class)) {
				perfilcampo.setPerfil(perfilcampoDataAccess.getPerfil(connexion,perfilcampo));
				continue;
			}

			if(clas.clas.equals(Campo.class)) {
				perfilcampo.setCampo(perfilcampoDataAccess.getCampo(connexion,perfilcampo));
				continue;
			}
		}
	}
	else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Perfil.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			perfilcampo.setPerfil(perfilcampoDataAccess.getPerfil(connexion,perfilcampo));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Campo.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			perfilcampo.setCampo(perfilcampoDataAccess.getCampo(connexion,perfilcampo));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		perfilcampo.setPerfil(perfilcampoDataAccess.getPerfil(connexion,perfilcampo));
		PerfilLogic perfilLogic= new PerfilLogic(connexion);
		perfilLogic.deepLoad(perfilcampo.getPerfil(),isDeep,deepLoadType,clases);
				
		perfilcampo.setCampo(perfilcampoDataAccess.getCampo(connexion,perfilcampo));
		CampoLogic campoLogic= new CampoLogic(connexion);
		campoLogic.deepLoad(perfilcampo.getCampo(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Perfil.class)) {
				perfilcampo.setPerfil(perfilcampoDataAccess.getPerfil(connexion,perfilcampo));
				PerfilLogic perfilLogic= new PerfilLogic(connexion);
				perfilLogic.deepLoad(perfilcampo.getPerfil(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Campo.class)) {
				perfilcampo.setCampo(perfilcampoDataAccess.getCampo(connexion,perfilcampo));
				CampoLogic campoLogic= new CampoLogic(connexion);
				campoLogic.deepLoad(perfilcampo.getCampo(),isDeep,deepLoadType,clases);				
				continue;
			}

		}
	}
	else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {


		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Perfil.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			perfilcampo.setPerfil(perfilcampoDataAccess.getPerfil(connexion,perfilcampo));
			PerfilLogic perfilLogic= new PerfilLogic(connexion);
			perfilLogic.deepLoad(perfilcampo.getPerfil(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Campo.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			perfilcampo.setCampo(perfilcampoDataAccess.getCampo(connexion,perfilcampo));
			CampoLogic campoLogic= new CampoLogic(connexion);
			campoLogic.deepLoad(perfilcampo.getCampo(),isDeep,deepLoadType,clases);
				
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(PerfilCampo perfilcampo,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			PerfilCampoLogicAdditional.updatePerfilCampoToSave(perfilcampo,this.arrDatoGeneral);
			
PerfilCampoDataAccess.save(perfilcampo, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		PerfilDataAccess.save(perfilcampo.getPerfil(),connexion);

		CampoDataAccess.save(perfilcampo.getCampo(),connexion);
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Perfil.class)) {
				PerfilDataAccess.save(perfilcampo.getPerfil(),connexion);
				continue;
			}

			if(clas.clas.equals(Campo.class)) {
				CampoDataAccess.save(perfilcampo.getCampo(),connexion);
				continue;
			}

		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		PerfilDataAccess.save(perfilcampo.getPerfil(),connexion);
		PerfilLogic perfilLogic= new PerfilLogic(connexion);
		perfilLogic.deepLoad(perfilcampo.getPerfil(),isDeep,deepLoadType,clases);
				

		CampoDataAccess.save(perfilcampo.getCampo(),connexion);
		CampoLogic campoLogic= new CampoLogic(connexion);
		campoLogic.deepLoad(perfilcampo.getCampo(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Perfil.class)) {
				PerfilDataAccess.save(perfilcampo.getPerfil(),connexion);
				PerfilLogic perfilLogic= new PerfilLogic(connexion);
				perfilLogic.deepSave(perfilcampo.getPerfil(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Campo.class)) {
				CampoDataAccess.save(perfilcampo.getCampo(),connexion);
				CampoLogic campoLogic= new CampoLogic(connexion);
				campoLogic.deepSave(perfilcampo.getCampo(),isDeep,deepLoadType,clases);				
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
			this.getNewConnexionToDeep(PerfilCampo.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(perfilcampo,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				PerfilCampoConstantesFunciones.refrescarForeignKeysDescripcionesPerfilCampo(perfilcampo);
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
			this.deepLoad(this.perfilcampo,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				PerfilCampoConstantesFunciones.refrescarForeignKeysDescripcionesPerfilCampo(this.perfilcampo);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(PerfilCampo.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(perfilcampos!=null) {
				for(PerfilCampo perfilcampo:perfilcampos) {
					this.deepLoad(perfilcampo,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					PerfilCampoConstantesFunciones.refrescarForeignKeysDescripcionesPerfilCampo(perfilcampos);
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
			if(perfilcampos!=null) {
				for(PerfilCampo perfilcampo:perfilcampos) {
					this.deepLoad(perfilcampo,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					PerfilCampoConstantesFunciones.refrescarForeignKeysDescripcionesPerfilCampo(perfilcampos);
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
			this.getNewConnexionToDeep(PerfilCampo.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(perfilcampo,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(PerfilCampo.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(perfilcampos!=null) {
				for(PerfilCampo perfilcampo:perfilcampos) {
					this.deepSave(perfilcampo,isDeep,deepLoadType,clases);
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
			if(perfilcampos!=null) {
				for(PerfilCampo perfilcampo:perfilcampos) {
					this.deepSave(perfilcampo,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getPerfilCamposFK_IdCampoWithConnection(String sFinalQuery,Pagination pagination,Long id_campo)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PerfilCampo.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCampo= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCampo.setParameterSelectionGeneralEqual(ParameterType.LONG,id_campo,PerfilCampoConstantesFunciones.IDCAMPO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCampo);

			PerfilCampoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCampo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			perfilcampos=perfilcampoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PerfilCampoConstantesFunciones.refrescarForeignKeysDescripcionesPerfilCampo(this.perfilcampos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getPerfilCamposFK_IdCampo(String sFinalQuery,Pagination pagination,Long id_campo)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCampo= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCampo.setParameterSelectionGeneralEqual(ParameterType.LONG,id_campo,PerfilCampoConstantesFunciones.IDCAMPO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCampo);

			PerfilCampoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCampo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			perfilcampos=perfilcampoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PerfilCampoConstantesFunciones.refrescarForeignKeysDescripcionesPerfilCampo(this.perfilcampos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getPerfilCamposFK_IdPerfilWithConnection(String sFinalQuery,Pagination pagination,Long id_perfil)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PerfilCampo.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidPerfil= new ParameterSelectionGeneral();
			parameterSelectionGeneralidPerfil.setParameterSelectionGeneralEqual(ParameterType.LONG,id_perfil,PerfilCampoConstantesFunciones.IDPERFIL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidPerfil);

			PerfilCampoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdPerfil","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			perfilcampos=perfilcampoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PerfilCampoConstantesFunciones.refrescarForeignKeysDescripcionesPerfilCampo(this.perfilcampos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getPerfilCamposFK_IdPerfil(String sFinalQuery,Pagination pagination,Long id_perfil)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidPerfil= new ParameterSelectionGeneral();
			parameterSelectionGeneralidPerfil.setParameterSelectionGeneralEqual(ParameterType.LONG,id_perfil,PerfilCampoConstantesFunciones.IDPERFIL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidPerfil);

			PerfilCampoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdPerfil","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			perfilcampos=perfilcampoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PerfilCampoConstantesFunciones.refrescarForeignKeysDescripcionesPerfilCampo(this.perfilcampos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,String sProcesoBusqueda,String sDetalleProcesoBusqueda,QueryWhereSelectParameters queryWhereSelectParameters,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		//AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		//auditoriaLogicAdditional.setConnexion(connexion);
		//AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(PerfilCampoConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				//auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,PerfilCampoDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,PerfilCampo perfilcampo,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		//AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		//auditoriaLogicAdditional.setConnexion(connexion);
		//AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(PerfilCampoConstantesFunciones.ISCONAUDITORIA) {
				if(perfilcampo.getIsNew()) {
					//auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,PerfilCampoDataAccess.TABLENAME, perfilcampo.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(PerfilCampoConstantesFunciones.ISCONAUDITORIADETALLE) {
						//PerfilCampoLogic.registrarAuditoriaDetallesPerfilCampo(connexion,perfilcampo,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(perfilcampo.getIsDeleted()) {
					/*if(!perfilcampo.getIsExpired()) {
						//auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,PerfilCampoDataAccess.TABLENAME, perfilcampo.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						//PerfilCampoLogic.registrarAuditoriaDetallesPerfilCampo(connexion,perfilcampo,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						//auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,PerfilCampoDataAccess.TABLENAME, perfilcampo.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(perfilcampo.getIsChanged()) {
					//auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,PerfilCampoDataAccess.TABLENAME, perfilcampo.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(PerfilCampoConstantesFunciones.ISCONAUDITORIADETALLE) {
						//PerfilCampoLogic.registrarAuditoriaDetallesPerfilCampo(connexion,perfilcampo,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesPerfilCampo(Connexion connexion,PerfilCampo perfilcampo)throws Exception {		
		//AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		//auditoriaDetalleLogicAdditional.setConnexion(connexion);
		//AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(perfilcampo.getIsNew()||!perfilcampo.getid_perfil().equals(perfilcampo.getPerfilCampoOriginal().getid_perfil()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(perfilcampo.getPerfilCampoOriginal().getid_perfil()!=null)
				{
					strValorActual=perfilcampo.getPerfilCampoOriginal().getid_perfil().toString();
				}
				if(perfilcampo.getid_perfil()!=null)
				{
					strValorNuevo=perfilcampo.getid_perfil().toString() ;
				}

				//auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PerfilCampoConstantesFunciones.IDPERFIL,strValorActual,strValorNuevo);
			}	
			
			if(perfilcampo.getIsNew()||!perfilcampo.getid_campo().equals(perfilcampo.getPerfilCampoOriginal().getid_campo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(perfilcampo.getPerfilCampoOriginal().getid_campo()!=null)
				{
					strValorActual=perfilcampo.getPerfilCampoOriginal().getid_campo().toString();
				}
				if(perfilcampo.getid_campo()!=null)
				{
					strValorNuevo=perfilcampo.getid_campo().toString() ;
				}

				//auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PerfilCampoConstantesFunciones.IDCAMPO,strValorActual,strValorNuevo);
			}	
			
			if(perfilcampo.getIsNew()||!perfilcampo.gettodo().equals(perfilcampo.getPerfilCampoOriginal().gettodo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(perfilcampo.getPerfilCampoOriginal().gettodo()!=null)
				{
					strValorActual=perfilcampo.getPerfilCampoOriginal().gettodo().toString();
				}
				if(perfilcampo.gettodo()!=null)
				{
					strValorNuevo=perfilcampo.gettodo().toString() ;
				}

				//auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PerfilCampoConstantesFunciones.TODO,strValorActual,strValorNuevo);
			}	
			
			if(perfilcampo.getIsNew()||!perfilcampo.getingreso().equals(perfilcampo.getPerfilCampoOriginal().getingreso()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(perfilcampo.getPerfilCampoOriginal().getingreso()!=null)
				{
					strValorActual=perfilcampo.getPerfilCampoOriginal().getingreso().toString();
				}
				if(perfilcampo.getingreso()!=null)
				{
					strValorNuevo=perfilcampo.getingreso().toString() ;
				}

				//auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PerfilCampoConstantesFunciones.INGRESO,strValorActual,strValorNuevo);
			}	
			
			if(perfilcampo.getIsNew()||!perfilcampo.getmodificacion().equals(perfilcampo.getPerfilCampoOriginal().getmodificacion()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(perfilcampo.getPerfilCampoOriginal().getmodificacion()!=null)
				{
					strValorActual=perfilcampo.getPerfilCampoOriginal().getmodificacion().toString();
				}
				if(perfilcampo.getmodificacion()!=null)
				{
					strValorNuevo=perfilcampo.getmodificacion().toString() ;
				}

				//auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PerfilCampoConstantesFunciones.MODIFICACION,strValorActual,strValorNuevo);
			}	
			
			if(perfilcampo.getIsNew()||!perfilcampo.geteliminacion().equals(perfilcampo.getPerfilCampoOriginal().geteliminacion()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(perfilcampo.getPerfilCampoOriginal().geteliminacion()!=null)
				{
					strValorActual=perfilcampo.getPerfilCampoOriginal().geteliminacion().toString();
				}
				if(perfilcampo.geteliminacion()!=null)
				{
					strValorNuevo=perfilcampo.geteliminacion().toString() ;
				}

				//auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PerfilCampoConstantesFunciones.ELIMINACION,strValorActual,strValorNuevo);
			}	
			
			if(perfilcampo.getIsNew()||!perfilcampo.getconsulta().equals(perfilcampo.getPerfilCampoOriginal().getconsulta()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(perfilcampo.getPerfilCampoOriginal().getconsulta()!=null)
				{
					strValorActual=perfilcampo.getPerfilCampoOriginal().getconsulta().toString();
				}
				if(perfilcampo.getconsulta()!=null)
				{
					strValorNuevo=perfilcampo.getconsulta().toString() ;
				}

				//auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PerfilCampoConstantesFunciones.CONSULTA,strValorActual,strValorNuevo);
			}	
			
			if(perfilcampo.getIsNew()||!perfilcampo.getestado().equals(perfilcampo.getPerfilCampoOriginal().getestado()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(perfilcampo.getPerfilCampoOriginal().getestado()!=null)
				{
					strValorActual=perfilcampo.getPerfilCampoOriginal().getestado().toString();
				}
				if(perfilcampo.getestado()!=null)
				{
					strValorNuevo=perfilcampo.getestado().toString() ;
				}

				//auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PerfilCampoConstantesFunciones.ESTADO,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void savePerfilCampoRelacionesWithConnection(PerfilCampo perfilcampo) throws Exception {

		if(!perfilcampo.getsType().contains(Constantes2.S_TOTALES)) {
			this.savePerfilCampoRelacionesBase(perfilcampo,true);
		}
	}

	public void savePerfilCampoRelaciones(PerfilCampo perfilcampo)throws Exception {

		if(!perfilcampo.getsType().contains(Constantes2.S_TOTALES)) {
			this.savePerfilCampoRelacionesBase(perfilcampo,false);
		}
	}

	public void savePerfilCampoRelacionesBase(PerfilCampo perfilcampo,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("PerfilCampo-saveRelacionesWithConnection");}
	

			this.setPerfilCampo(perfilcampo);

			if(PerfilCampoLogicAdditional.validarSaveRelaciones(perfilcampo,this)) {

				PerfilCampoLogicAdditional.updateRelacionesToSave(perfilcampo,this);

				if((perfilcampo.getIsNew()||perfilcampo.getIsChanged())&&!perfilcampo.getIsDeleted()) {
					this.savePerfilCampo();
					this.savePerfilCampoRelacionesDetalles();

				} else if(perfilcampo.getIsDeleted()) {
					this.savePerfilCampoRelacionesDetalles();
					this.savePerfilCampo();
				}

				PerfilCampoLogicAdditional.updateRelacionesToSaveAfter(perfilcampo,this);

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
	
	
	private void savePerfilCampoRelacionesDetalles()throws Exception {
		try {
	

		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfPerfilCampo(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=PerfilCampoConstantesFunciones.getClassesForeignKeysOfPerfilCampo(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfPerfilCampo(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=PerfilCampoConstantesFunciones.getClassesRelationshipsOfPerfilCampo(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}
