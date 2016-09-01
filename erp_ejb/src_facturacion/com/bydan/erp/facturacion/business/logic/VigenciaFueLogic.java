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
import com.bydan.erp.facturacion.util.VigenciaFueConstantesFunciones;
import com.bydan.erp.facturacion.util.VigenciaFueParameterReturnGeneral;
//import com.bydan.erp.facturacion.util.VigenciaFueParameterGeneral;
import com.bydan.erp.facturacion.business.entity.VigenciaFue;
import com.bydan.erp.facturacion.business.logic.VigenciaFueLogicAdditional;
import com.bydan.erp.facturacion.business.dataaccess.*;
import com.bydan.erp.facturacion.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.logic.*;


import com.bydan.erp.seguridad.util.*;


import com.bydan.erp.seguridad.business.dataaccess.*;








@SuppressWarnings("unused")
public class VigenciaFueLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(VigenciaFueLogic.class);
	
	protected VigenciaFueDataAccess vigenciafueDataAccess; 	
	protected VigenciaFue vigenciafue;
	protected List<VigenciaFue> vigenciafues;
	protected Object vigenciafueObject;	
	protected List<Object> vigenciafuesObject;
	
	public static ClassValidator<VigenciaFue> vigenciafueValidator = new ClassValidator<VigenciaFue>(VigenciaFue.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected VigenciaFueLogicAdditional vigenciafueLogicAdditional=null;
	
	public VigenciaFueLogicAdditional getVigenciaFueLogicAdditional() {
		return this.vigenciafueLogicAdditional;
	}
	
	public void setVigenciaFueLogicAdditional(VigenciaFueLogicAdditional vigenciafueLogicAdditional) {
		try {
			this.vigenciafueLogicAdditional=vigenciafueLogicAdditional;
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
	
	
	
	
	public  VigenciaFueLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.vigenciafueDataAccess = new VigenciaFueDataAccess();
			
			this.vigenciafues= new ArrayList<VigenciaFue>();
			this.vigenciafue= new VigenciaFue();
			
			this.vigenciafueObject=new Object();
			this.vigenciafuesObject=new ArrayList<Object>();
				
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
			
			this.vigenciafueDataAccess.setConnexionType(this.connexionType);
			this.vigenciafueDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  VigenciaFueLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.vigenciafueDataAccess = new VigenciaFueDataAccess();
			this.vigenciafues= new ArrayList<VigenciaFue>();
			this.vigenciafue= new VigenciaFue();
			this.vigenciafueObject=new Object();
			this.vigenciafuesObject=new ArrayList<Object>();
			
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
			
			this.vigenciafueDataAccess.setConnexionType(this.connexionType);
			this.vigenciafueDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public VigenciaFue getVigenciaFue() throws Exception {	
		VigenciaFueLogicAdditional.checkVigenciaFueToGet(vigenciafue,this.datosCliente,this.arrDatoGeneral);
		VigenciaFueLogicAdditional.updateVigenciaFueToGet(vigenciafue,this.arrDatoGeneral);
		
		return vigenciafue;
	}
		
	public void setVigenciaFue(VigenciaFue newVigenciaFue) {
		this.vigenciafue = newVigenciaFue;
	}
	
	public VigenciaFueDataAccess getVigenciaFueDataAccess() {
		return vigenciafueDataAccess;
	}
	
	public void setVigenciaFueDataAccess(VigenciaFueDataAccess newvigenciafueDataAccess) {
		this.vigenciafueDataAccess = newvigenciafueDataAccess;
	}
	
	public List<VigenciaFue> getVigenciaFues() throws Exception {		
		this.quitarVigenciaFuesNulos();
		
		VigenciaFueLogicAdditional.checkVigenciaFueToGets(vigenciafues,this.datosCliente,this.arrDatoGeneral);
		
		for (VigenciaFue vigenciafueLocal: vigenciafues ) {
			VigenciaFueLogicAdditional.updateVigenciaFueToGet(vigenciafueLocal,this.arrDatoGeneral);
		}
		
		return vigenciafues;
	}
	
	public void setVigenciaFues(List<VigenciaFue> newVigenciaFues) {
		this.vigenciafues = newVigenciaFues;
	}
	
	public Object getVigenciaFueObject() {	
		this.vigenciafueObject=this.vigenciafueDataAccess.getEntityObject();
		return this.vigenciafueObject;
	}
		
	public void setVigenciaFueObject(Object newVigenciaFueObject) {
		this.vigenciafueObject = newVigenciaFueObject;
	}
	
	public List<Object> getVigenciaFuesObject() {		
		this.vigenciafuesObject=this.vigenciafueDataAccess.getEntitiesObject();
		return this.vigenciafuesObject;
	}
		
	public void setVigenciaFuesObject(List<Object> newVigenciaFuesObject) {
		this.vigenciafuesObject = newVigenciaFuesObject;
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
		
		if(this.vigenciafueDataAccess!=null) {
			this.vigenciafueDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,VigenciaFue.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			vigenciafueDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			vigenciafueDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		vigenciafue = new  VigenciaFue();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,VigenciaFue.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			vigenciafue=vigenciafueDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.vigenciafue,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				VigenciaFueConstantesFunciones.refrescarForeignKeysDescripcionesVigenciaFue(this.vigenciafue);
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
		vigenciafue = new  VigenciaFue();
		  		  
        try {
			
			vigenciafue=vigenciafueDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.vigenciafue,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				VigenciaFueConstantesFunciones.refrescarForeignKeysDescripcionesVigenciaFue(this.vigenciafue);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		vigenciafue = new  VigenciaFue();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,VigenciaFue.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			vigenciafue=vigenciafueDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.vigenciafue,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				VigenciaFueConstantesFunciones.refrescarForeignKeysDescripcionesVigenciaFue(this.vigenciafue);
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
		vigenciafue = new  VigenciaFue();
		  		  
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
		vigenciafue = new  VigenciaFue();
		  		  
        try {
			
			vigenciafue=vigenciafueDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.vigenciafue,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				VigenciaFueConstantesFunciones.refrescarForeignKeysDescripcionesVigenciaFue(this.vigenciafue);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		vigenciafue = new  VigenciaFue();
		  		  
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
		vigenciafue = new  VigenciaFue();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,VigenciaFue.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =vigenciafueDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		vigenciafue = new  VigenciaFue();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=vigenciafueDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		vigenciafue = new  VigenciaFue();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,VigenciaFue.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =vigenciafueDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		vigenciafue = new  VigenciaFue();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=vigenciafueDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		vigenciafue = new  VigenciaFue();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,VigenciaFue.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =vigenciafueDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		vigenciafue = new  VigenciaFue();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=vigenciafueDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		vigenciafues = new  ArrayList<VigenciaFue>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,VigenciaFue.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			VigenciaFueLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			vigenciafues=vigenciafueDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarVigenciaFue(vigenciafues);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				VigenciaFueConstantesFunciones.refrescarForeignKeysDescripcionesVigenciaFue(this.vigenciafues);
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
		vigenciafues = new  ArrayList<VigenciaFue>();
		  		  
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
		vigenciafues = new  ArrayList<VigenciaFue>();
		  		  
        try {			
			VigenciaFueLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			vigenciafues=vigenciafueDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarVigenciaFue(vigenciafues);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				VigenciaFueConstantesFunciones.refrescarForeignKeysDescripcionesVigenciaFue(this.vigenciafues);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		vigenciafues = new  ArrayList<VigenciaFue>();
		  		  
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
		vigenciafues = new  ArrayList<VigenciaFue>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,VigenciaFue.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			VigenciaFueLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			vigenciafues=vigenciafueDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarVigenciaFue(vigenciafues);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				VigenciaFueConstantesFunciones.refrescarForeignKeysDescripcionesVigenciaFue(this.vigenciafues);
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
		vigenciafues = new  ArrayList<VigenciaFue>();
		  		  
        try {
			VigenciaFueLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			vigenciafues=vigenciafueDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarVigenciaFue(vigenciafues);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				VigenciaFueConstantesFunciones.refrescarForeignKeysDescripcionesVigenciaFue(this.vigenciafues);
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
		vigenciafues = new  ArrayList<VigenciaFue>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,VigenciaFue.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			VigenciaFueLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			vigenciafues=vigenciafueDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarVigenciaFue(vigenciafues);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				VigenciaFueConstantesFunciones.refrescarForeignKeysDescripcionesVigenciaFue(this.vigenciafues);
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
		vigenciafues = new  ArrayList<VigenciaFue>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			VigenciaFueLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			vigenciafues=vigenciafueDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarVigenciaFue(vigenciafues);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				VigenciaFueConstantesFunciones.refrescarForeignKeysDescripcionesVigenciaFue(this.vigenciafues);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		vigenciafue = new  VigenciaFue();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,VigenciaFue.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			VigenciaFueLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			vigenciafue=vigenciafueDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarVigenciaFue(vigenciafue);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				VigenciaFueConstantesFunciones.refrescarForeignKeysDescripcionesVigenciaFue(this.vigenciafue);
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
		vigenciafue = new  VigenciaFue();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			VigenciaFueLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			vigenciafue=vigenciafueDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarVigenciaFue(vigenciafue);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				VigenciaFueConstantesFunciones.refrescarForeignKeysDescripcionesVigenciaFue(this.vigenciafue);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		vigenciafues = new  ArrayList<VigenciaFue>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,VigenciaFue.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			VigenciaFueLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			vigenciafues=vigenciafueDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarVigenciaFue(vigenciafues);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				VigenciaFueConstantesFunciones.refrescarForeignKeysDescripcionesVigenciaFue(this.vigenciafues);
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
		vigenciafues = new  ArrayList<VigenciaFue>();
		  		  
        try {
			VigenciaFueLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			vigenciafues=vigenciafueDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarVigenciaFue(vigenciafues);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				VigenciaFueConstantesFunciones.refrescarForeignKeysDescripcionesVigenciaFue(this.vigenciafues);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosVigenciaFuesWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		vigenciafues = new  ArrayList<VigenciaFue>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,VigenciaFue.class.getSimpleName()+"-getTodosVigenciaFuesWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			VigenciaFueLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			vigenciafues=vigenciafueDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarVigenciaFue(vigenciafues);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				VigenciaFueConstantesFunciones.refrescarForeignKeysDescripcionesVigenciaFue(this.vigenciafues);
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
	
	public  void  getTodosVigenciaFues(String sFinalQuery,Pagination pagination)throws Exception {
		vigenciafues = new  ArrayList<VigenciaFue>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			VigenciaFueLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			vigenciafues=vigenciafueDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarVigenciaFue(vigenciafues);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				VigenciaFueConstantesFunciones.refrescarForeignKeysDescripcionesVigenciaFue(this.vigenciafues);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarVigenciaFue(VigenciaFue vigenciafue) throws Exception {
		Boolean estaValidado=false;
		
		if(vigenciafue.getIsNew() || vigenciafue.getIsChanged()) { 
			this.invalidValues = vigenciafueValidator.getInvalidValues(vigenciafue);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(vigenciafue);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarVigenciaFue(List<VigenciaFue> VigenciaFues) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(VigenciaFue vigenciafueLocal:vigenciafues) {				
			estaValidadoObjeto=this.validarGuardarVigenciaFue(vigenciafueLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarVigenciaFue(List<VigenciaFue> VigenciaFues) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarVigenciaFue(vigenciafues)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarVigenciaFue(VigenciaFue VigenciaFue) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarVigenciaFue(vigenciafue)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(VigenciaFue vigenciafue) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+vigenciafue.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=VigenciaFueConstantesFunciones.getVigenciaFueLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"vigenciafue","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(VigenciaFueConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(VigenciaFueConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveVigenciaFueWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,VigenciaFue.class.getSimpleName()+"-saveVigenciaFueWithConnection");connexion.begin();			
			
			VigenciaFueLogicAdditional.checkVigenciaFueToSave(this.vigenciafue,this.datosCliente,connexion,this.arrDatoGeneral);
			
			VigenciaFueLogicAdditional.updateVigenciaFueToSave(this.vigenciafue,this.arrDatoGeneral);
			
			VigenciaFueLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.vigenciafue,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowVigenciaFue();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarVigenciaFue(this.vigenciafue)) {
				VigenciaFueDataAccess.save(this.vigenciafue, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.vigenciafue,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			VigenciaFueLogicAdditional.checkVigenciaFueToSaveAfter(this.vigenciafue,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowVigenciaFue();
			
			connexion.commit();			
			
			if(this.vigenciafue.getIsDeleted()) {
				this.vigenciafue=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveVigenciaFue()throws Exception {	
		try {	
			
			VigenciaFueLogicAdditional.checkVigenciaFueToSave(this.vigenciafue,this.datosCliente,connexion,this.arrDatoGeneral);
			
			VigenciaFueLogicAdditional.updateVigenciaFueToSave(this.vigenciafue,this.arrDatoGeneral);
			
			VigenciaFueLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.vigenciafue,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarVigenciaFue(this.vigenciafue)) {			
				VigenciaFueDataAccess.save(this.vigenciafue, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.vigenciafue,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			VigenciaFueLogicAdditional.checkVigenciaFueToSaveAfter(this.vigenciafue,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.vigenciafue.getIsDeleted()) {
				this.vigenciafue=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveVigenciaFuesWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,VigenciaFue.class.getSimpleName()+"-saveVigenciaFuesWithConnection");connexion.begin();			
			
			VigenciaFueLogicAdditional.checkVigenciaFueToSaves(vigenciafues,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowVigenciaFues();
			
			Boolean validadoTodosVigenciaFue=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(VigenciaFue vigenciafueLocal:vigenciafues) {		
				if(vigenciafueLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				VigenciaFueLogicAdditional.updateVigenciaFueToSave(vigenciafueLocal,this.arrDatoGeneral);
	        	
				VigenciaFueLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),vigenciafueLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarVigenciaFue(vigenciafueLocal)) {
					VigenciaFueDataAccess.save(vigenciafueLocal, connexion);				
				} else {
					validadoTodosVigenciaFue=false;
				}
			}
			
			if(!validadoTodosVigenciaFue) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			VigenciaFueLogicAdditional.checkVigenciaFueToSavesAfter(vigenciafues,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowVigenciaFues();
			
			connexion.commit();		
			
			this.quitarVigenciaFuesEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveVigenciaFues()throws Exception {				
		 try {	
			VigenciaFueLogicAdditional.checkVigenciaFueToSaves(vigenciafues,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosVigenciaFue=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(VigenciaFue vigenciafueLocal:vigenciafues) {				
				if(vigenciafueLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				VigenciaFueLogicAdditional.updateVigenciaFueToSave(vigenciafueLocal,this.arrDatoGeneral);
	        	
				VigenciaFueLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),vigenciafueLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarVigenciaFue(vigenciafueLocal)) {				
					VigenciaFueDataAccess.save(vigenciafueLocal, connexion);				
				} else {
					validadoTodosVigenciaFue=false;
				}
			}
			
			if(!validadoTodosVigenciaFue) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			VigenciaFueLogicAdditional.checkVigenciaFueToSavesAfter(vigenciafues,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarVigenciaFuesEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public VigenciaFueParameterReturnGeneral procesarAccionVigenciaFues(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<VigenciaFue> vigenciafues,VigenciaFueParameterReturnGeneral vigenciafueParameterGeneral)throws Exception {
		 try {	
			VigenciaFueParameterReturnGeneral vigenciafueReturnGeneral=new VigenciaFueParameterReturnGeneral();
	
			VigenciaFueLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,vigenciafues,vigenciafueParameterGeneral,vigenciafueReturnGeneral);
			
			return vigenciafueReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public VigenciaFueParameterReturnGeneral procesarAccionVigenciaFuesWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<VigenciaFue> vigenciafues,VigenciaFueParameterReturnGeneral vigenciafueParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,VigenciaFue.class.getSimpleName()+"-procesarAccionVigenciaFuesWithConnection");connexion.begin();			
			
			VigenciaFueParameterReturnGeneral vigenciafueReturnGeneral=new VigenciaFueParameterReturnGeneral();
	
			VigenciaFueLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,vigenciafues,vigenciafueParameterGeneral,vigenciafueReturnGeneral);
			
			this.connexion.commit();
			
			return vigenciafueReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public VigenciaFueParameterReturnGeneral procesarEventosVigenciaFues(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<VigenciaFue> vigenciafues,VigenciaFue vigenciafue,VigenciaFueParameterReturnGeneral vigenciafueParameterGeneral,Boolean isEsNuevoVigenciaFue,ArrayList<Classe> clases)throws Exception {
		 try {	
			VigenciaFueParameterReturnGeneral vigenciafueReturnGeneral=new VigenciaFueParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				vigenciafueReturnGeneral.setConRecargarPropiedades(true);
			}
			
			VigenciaFueLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,vigenciafues,vigenciafue,vigenciafueParameterGeneral,vigenciafueReturnGeneral,isEsNuevoVigenciaFue,clases);
			
			return vigenciafueReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public VigenciaFueParameterReturnGeneral procesarEventosVigenciaFuesWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<VigenciaFue> vigenciafues,VigenciaFue vigenciafue,VigenciaFueParameterReturnGeneral vigenciafueParameterGeneral,Boolean isEsNuevoVigenciaFue,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,VigenciaFue.class.getSimpleName()+"-procesarEventosVigenciaFuesWithConnection");connexion.begin();			
			
			VigenciaFueParameterReturnGeneral vigenciafueReturnGeneral=new VigenciaFueParameterReturnGeneral();
	
			vigenciafueReturnGeneral.setVigenciaFue(vigenciafue);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				vigenciafueReturnGeneral.setConRecargarPropiedades(true);
			}
			
			VigenciaFueLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,vigenciafues,vigenciafue,vigenciafueParameterGeneral,vigenciafueReturnGeneral,isEsNuevoVigenciaFue,clases);
			
			this.connexion.commit();
			
			return vigenciafueReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public VigenciaFueParameterReturnGeneral procesarImportacionVigenciaFuesWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,VigenciaFueParameterReturnGeneral vigenciafueParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,VigenciaFue.class.getSimpleName()+"-procesarImportacionVigenciaFuesWithConnection");connexion.begin();			
			
			VigenciaFueParameterReturnGeneral vigenciafueReturnGeneral=new VigenciaFueParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.vigenciafues=new ArrayList<VigenciaFue>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.vigenciafue=new VigenciaFue();
				
				
				if(conColumnasBase) {this.vigenciafue.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.vigenciafue.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.vigenciafue.setfecha_inicio(Funciones.ConvertToDate(arrColumnas[iColumn++]));
				this.vigenciafue.setfecha_fin(Funciones.ConvertToDate(arrColumnas[iColumn++]));
				this.vigenciafue.setnumero_embarques(Integer.parseInt(arrColumnas[iColumn++]));
				this.vigenciafue.setfue(arrColumnas[iColumn++]);
				this.vigenciafue.setfecha_ultimo_embarque(Funciones.ConvertToDate(arrColumnas[iColumn++]));
				this.vigenciafue.setvalor(Double.parseDouble(arrColumnas[iColumn++]));
				this.vigenciafue.setnumero_cajas(Integer.parseInt(arrColumnas[iColumn++]));
				this.vigenciafue.setesta_activo(Boolean.parseBoolean(arrColumnas[iColumn++]));
				
				this.vigenciafues.add(this.vigenciafue);
			}
			
			this.saveVigenciaFues();
			
			this.connexion.commit();
			
			vigenciafueReturnGeneral.setConRetornoEstaProcesado(true);
			vigenciafueReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return vigenciafueReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarVigenciaFuesEliminados() throws Exception {				
		
		List<VigenciaFue> vigenciafuesAux= new ArrayList<VigenciaFue>();
		
		for(VigenciaFue vigenciafue:vigenciafues) {
			if(!vigenciafue.getIsDeleted()) {
				vigenciafuesAux.add(vigenciafue);
			}
		}
		
		vigenciafues=vigenciafuesAux;
	}
	
	public void quitarVigenciaFuesNulos() throws Exception {				
		
		List<VigenciaFue> vigenciafuesAux= new ArrayList<VigenciaFue>();
		
		for(VigenciaFue vigenciafue : this.vigenciafues) {
			if(vigenciafue==null) {
				vigenciafuesAux.add(vigenciafue);
			}
		}
		
		//this.vigenciafues=vigenciafuesAux;
		
		this.vigenciafues.removeAll(vigenciafuesAux);
	}
	
	public void getSetVersionRowVigenciaFueWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(vigenciafue.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((vigenciafue.getIsDeleted() || (vigenciafue.getIsChanged()&&!vigenciafue.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=vigenciafueDataAccess.getSetVersionRowVigenciaFue(connexion,vigenciafue.getId());
				
				if(!vigenciafue.getVersionRow().equals(timestamp)) {	
					vigenciafue.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				vigenciafue.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowVigenciaFue()throws Exception {	
		
		if(vigenciafue.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((vigenciafue.getIsDeleted() || (vigenciafue.getIsChanged()&&!vigenciafue.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=vigenciafueDataAccess.getSetVersionRowVigenciaFue(connexion,vigenciafue.getId());
			
			try {							
				if(!vigenciafue.getVersionRow().equals(timestamp)) {	
					vigenciafue.setVersionRow(timestamp);
				}
				
				vigenciafue.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowVigenciaFuesWithConnection()throws Exception {	
		if(vigenciafues!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(VigenciaFue vigenciafueAux:vigenciafues) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(vigenciafueAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(vigenciafueAux.getIsDeleted() || (vigenciafueAux.getIsChanged()&&!vigenciafueAux.getIsNew())) {
						
						timestamp=vigenciafueDataAccess.getSetVersionRowVigenciaFue(connexion,vigenciafueAux.getId());
						
						if(!vigenciafue.getVersionRow().equals(timestamp)) {	
							vigenciafueAux.setVersionRow(timestamp);
						}
								
						vigenciafueAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowVigenciaFues()throws Exception {	
		if(vigenciafues!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(VigenciaFue vigenciafueAux:vigenciafues) {
					if(vigenciafueAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(vigenciafueAux.getIsDeleted() || (vigenciafueAux.getIsChanged()&&!vigenciafueAux.getIsNew())) {
						
						timestamp=vigenciafueDataAccess.getSetVersionRowVigenciaFue(connexion,vigenciafueAux.getId());
						
						if(!vigenciafueAux.getVersionRow().equals(timestamp)) {	
							vigenciafueAux.setVersionRow(timestamp);
						}
						
													
						vigenciafueAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public VigenciaFueParameterReturnGeneral cargarCombosLoteForeignKeyVigenciaFueWithConnection(String finalQueryGlobalPais,String finalQueryGlobalCiudad) throws Exception {
		VigenciaFueParameterReturnGeneral  vigenciafueReturnGeneral =new VigenciaFueParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,VigenciaFue.class.getSimpleName()+"-cargarCombosLoteForeignKeyVigenciaFueWithConnection");connexion.begin();
			
			vigenciafueReturnGeneral =new VigenciaFueParameterReturnGeneral();
			
			

			List<Pais> paissForeignKey=new ArrayList<Pais>();
			PaisLogic paisLogic=new PaisLogic();
			paisLogic.setConnexion(this.connexion);
			paisLogic.getPaisDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalPais.equals("NONE")) {
				paisLogic.getTodosPaiss(finalQueryGlobalPais,new Pagination());
				paissForeignKey=paisLogic.getPaiss();
			}

			vigenciafueReturnGeneral.setpaissForeignKey(paissForeignKey);


			List<Ciudad> ciudadsForeignKey=new ArrayList<Ciudad>();
			CiudadLogic ciudadLogic=new CiudadLogic();
			ciudadLogic.setConnexion(this.connexion);
			ciudadLogic.getCiudadDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCiudad.equals("NONE")) {
				ciudadLogic.getTodosCiudads(finalQueryGlobalCiudad,new Pagination());
				ciudadsForeignKey=ciudadLogic.getCiudads();
			}

			vigenciafueReturnGeneral.setciudadsForeignKey(ciudadsForeignKey);

			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
		
		return vigenciafueReturnGeneral;
	}
	
	public VigenciaFueParameterReturnGeneral cargarCombosLoteForeignKeyVigenciaFue(String finalQueryGlobalPais,String finalQueryGlobalCiudad) throws Exception {
		VigenciaFueParameterReturnGeneral  vigenciafueReturnGeneral =new VigenciaFueParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {						
			vigenciafueReturnGeneral =new VigenciaFueParameterReturnGeneral();
			
			

			List<Pais> paissForeignKey=new ArrayList<Pais>();
			PaisLogic paisLogic=new PaisLogic();
			paisLogic.setConnexion(this.connexion);
			paisLogic.getPaisDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalPais.equals("NONE")) {
				paisLogic.getTodosPaiss(finalQueryGlobalPais,new Pagination());
				paissForeignKey=paisLogic.getPaiss();
			}

			vigenciafueReturnGeneral.setpaissForeignKey(paissForeignKey);


			List<Ciudad> ciudadsForeignKey=new ArrayList<Ciudad>();
			CiudadLogic ciudadLogic=new CiudadLogic();
			ciudadLogic.setConnexion(this.connexion);
			ciudadLogic.getCiudadDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCiudad.equals("NONE")) {
				ciudadLogic.getTodosCiudads(finalQueryGlobalCiudad,new Pagination());
				ciudadsForeignKey=ciudadLogic.getCiudads();
			}

			vigenciafueReturnGeneral.setciudadsForeignKey(ciudadsForeignKey);
						
			
		} catch(Exception e) {			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			
		}
		
		return vigenciafueReturnGeneral;
	}
	
	
	public void deepLoad(VigenciaFue vigenciafue,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			VigenciaFueLogicAdditional.updateVigenciaFueToGet(vigenciafue,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		vigenciafue.setPais(vigenciafueDataAccess.getPais(connexion,vigenciafue));
		vigenciafue.setCiudad(vigenciafueDataAccess.getCiudad(connexion,vigenciafue));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Pais.class)) {
				vigenciafue.setPais(vigenciafueDataAccess.getPais(connexion,vigenciafue));
				continue;
			}

			if(clas.clas.equals(Ciudad.class)) {
				vigenciafue.setCiudad(vigenciafueDataAccess.getCiudad(connexion,vigenciafue));
				continue;
			}
		}
	}
	else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Pais.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			vigenciafue.setPais(vigenciafueDataAccess.getPais(connexion,vigenciafue));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Ciudad.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			vigenciafue.setCiudad(vigenciafueDataAccess.getCiudad(connexion,vigenciafue));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		vigenciafue.setPais(vigenciafueDataAccess.getPais(connexion,vigenciafue));
		PaisLogic paisLogic= new PaisLogic(connexion);
		paisLogic.deepLoad(vigenciafue.getPais(),isDeep,deepLoadType,clases);
				
		vigenciafue.setCiudad(vigenciafueDataAccess.getCiudad(connexion,vigenciafue));
		CiudadLogic ciudadLogic= new CiudadLogic(connexion);
		ciudadLogic.deepLoad(vigenciafue.getCiudad(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Pais.class)) {
				vigenciafue.setPais(vigenciafueDataAccess.getPais(connexion,vigenciafue));
				PaisLogic paisLogic= new PaisLogic(connexion);
				paisLogic.deepLoad(vigenciafue.getPais(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Ciudad.class)) {
				vigenciafue.setCiudad(vigenciafueDataAccess.getCiudad(connexion,vigenciafue));
				CiudadLogic ciudadLogic= new CiudadLogic(connexion);
				ciudadLogic.deepLoad(vigenciafue.getCiudad(),isDeep,deepLoadType,clases);				
				continue;
			}

		}
	}
	else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {


		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Pais.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			vigenciafue.setPais(vigenciafueDataAccess.getPais(connexion,vigenciafue));
			PaisLogic paisLogic= new PaisLogic(connexion);
			paisLogic.deepLoad(vigenciafue.getPais(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Ciudad.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			vigenciafue.setCiudad(vigenciafueDataAccess.getCiudad(connexion,vigenciafue));
			CiudadLogic ciudadLogic= new CiudadLogic(connexion);
			ciudadLogic.deepLoad(vigenciafue.getCiudad(),isDeep,deepLoadType,clases);
				
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(VigenciaFue vigenciafue,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			VigenciaFueLogicAdditional.updateVigenciaFueToSave(vigenciafue,this.arrDatoGeneral);
			
VigenciaFueDataAccess.save(vigenciafue, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		PaisDataAccess.save(vigenciafue.getPais(),connexion);

		CiudadDataAccess.save(vigenciafue.getCiudad(),connexion);
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Pais.class)) {
				PaisDataAccess.save(vigenciafue.getPais(),connexion);
				continue;
			}

			if(clas.clas.equals(Ciudad.class)) {
				CiudadDataAccess.save(vigenciafue.getCiudad(),connexion);
				continue;
			}

		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		PaisDataAccess.save(vigenciafue.getPais(),connexion);
		PaisLogic paisLogic= new PaisLogic(connexion);
		paisLogic.deepLoad(vigenciafue.getPais(),isDeep,deepLoadType,clases);
				

		CiudadDataAccess.save(vigenciafue.getCiudad(),connexion);
		CiudadLogic ciudadLogic= new CiudadLogic(connexion);
		ciudadLogic.deepLoad(vigenciafue.getCiudad(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Pais.class)) {
				PaisDataAccess.save(vigenciafue.getPais(),connexion);
				PaisLogic paisLogic= new PaisLogic(connexion);
				paisLogic.deepSave(vigenciafue.getPais(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Ciudad.class)) {
				CiudadDataAccess.save(vigenciafue.getCiudad(),connexion);
				CiudadLogic ciudadLogic= new CiudadLogic(connexion);
				ciudadLogic.deepSave(vigenciafue.getCiudad(),isDeep,deepLoadType,clases);				
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
			this.getNewConnexionToDeep(VigenciaFue.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(vigenciafue,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				VigenciaFueConstantesFunciones.refrescarForeignKeysDescripcionesVigenciaFue(vigenciafue);
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
			this.deepLoad(this.vigenciafue,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				VigenciaFueConstantesFunciones.refrescarForeignKeysDescripcionesVigenciaFue(this.vigenciafue);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(VigenciaFue.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(vigenciafues!=null) {
				for(VigenciaFue vigenciafue:vigenciafues) {
					this.deepLoad(vigenciafue,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					VigenciaFueConstantesFunciones.refrescarForeignKeysDescripcionesVigenciaFue(vigenciafues);
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
			if(vigenciafues!=null) {
				for(VigenciaFue vigenciafue:vigenciafues) {
					this.deepLoad(vigenciafue,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					VigenciaFueConstantesFunciones.refrescarForeignKeysDescripcionesVigenciaFue(vigenciafues);
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
			this.getNewConnexionToDeep(VigenciaFue.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(vigenciafue,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(VigenciaFue.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(vigenciafues!=null) {
				for(VigenciaFue vigenciafue:vigenciafues) {
					this.deepSave(vigenciafue,isDeep,deepLoadType,clases);
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
			if(vigenciafues!=null) {
				for(VigenciaFue vigenciafue:vigenciafues) {
					this.deepSave(vigenciafue,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getVigenciaFuesFK_IdCiudadWithConnection(String sFinalQuery,Pagination pagination,Long id_ciudad)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,VigenciaFue.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCiudad= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCiudad.setParameterSelectionGeneralEqual(ParameterType.LONG,id_ciudad,VigenciaFueConstantesFunciones.IDCIUDAD,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCiudad);

			VigenciaFueLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCiudad","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			vigenciafues=vigenciafueDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				VigenciaFueConstantesFunciones.refrescarForeignKeysDescripcionesVigenciaFue(this.vigenciafues);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getVigenciaFuesFK_IdCiudad(String sFinalQuery,Pagination pagination,Long id_ciudad)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCiudad= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCiudad.setParameterSelectionGeneralEqual(ParameterType.LONG,id_ciudad,VigenciaFueConstantesFunciones.IDCIUDAD,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCiudad);

			VigenciaFueLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCiudad","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			vigenciafues=vigenciafueDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				VigenciaFueConstantesFunciones.refrescarForeignKeysDescripcionesVigenciaFue(this.vigenciafues);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getVigenciaFuesFK_IdPaisWithConnection(String sFinalQuery,Pagination pagination,Long id_pais)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,VigenciaFue.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidPais= new ParameterSelectionGeneral();
			parameterSelectionGeneralidPais.setParameterSelectionGeneralEqual(ParameterType.LONG,id_pais,VigenciaFueConstantesFunciones.IDPAIS,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidPais);

			VigenciaFueLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdPais","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			vigenciafues=vigenciafueDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				VigenciaFueConstantesFunciones.refrescarForeignKeysDescripcionesVigenciaFue(this.vigenciafues);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getVigenciaFuesFK_IdPais(String sFinalQuery,Pagination pagination,Long id_pais)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidPais= new ParameterSelectionGeneral();
			parameterSelectionGeneralidPais.setParameterSelectionGeneralEqual(ParameterType.LONG,id_pais,VigenciaFueConstantesFunciones.IDPAIS,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidPais);

			VigenciaFueLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdPais","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			vigenciafues=vigenciafueDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				VigenciaFueConstantesFunciones.refrescarForeignKeysDescripcionesVigenciaFue(this.vigenciafues);
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
			if(VigenciaFueConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,VigenciaFueDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,VigenciaFue vigenciafue,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(VigenciaFueConstantesFunciones.ISCONAUDITORIA) {
				if(vigenciafue.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,VigenciaFueDataAccess.TABLENAME, vigenciafue.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(VigenciaFueConstantesFunciones.ISCONAUDITORIADETALLE) {
						////VigenciaFueLogic.registrarAuditoriaDetallesVigenciaFue(connexion,vigenciafue,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(vigenciafue.getIsDeleted()) {
					/*if(!vigenciafue.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,VigenciaFueDataAccess.TABLENAME, vigenciafue.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////VigenciaFueLogic.registrarAuditoriaDetallesVigenciaFue(connexion,vigenciafue,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,VigenciaFueDataAccess.TABLENAME, vigenciafue.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(vigenciafue.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,VigenciaFueDataAccess.TABLENAME, vigenciafue.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(VigenciaFueConstantesFunciones.ISCONAUDITORIADETALLE) {
						////VigenciaFueLogic.registrarAuditoriaDetallesVigenciaFue(connexion,vigenciafue,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesVigenciaFue(Connexion connexion,VigenciaFue vigenciafue)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(vigenciafue.getIsNew()||!vigenciafue.getid_pais().equals(vigenciafue.getVigenciaFueOriginal().getid_pais()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(vigenciafue.getVigenciaFueOriginal().getid_pais()!=null)
				{
					strValorActual=vigenciafue.getVigenciaFueOriginal().getid_pais().toString();
				}
				if(vigenciafue.getid_pais()!=null)
				{
					strValorNuevo=vigenciafue.getid_pais().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),VigenciaFueConstantesFunciones.IDPAIS,strValorActual,strValorNuevo);
			}	
			
			if(vigenciafue.getIsNew()||!vigenciafue.getid_ciudad().equals(vigenciafue.getVigenciaFueOriginal().getid_ciudad()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(vigenciafue.getVigenciaFueOriginal().getid_ciudad()!=null)
				{
					strValorActual=vigenciafue.getVigenciaFueOriginal().getid_ciudad().toString();
				}
				if(vigenciafue.getid_ciudad()!=null)
				{
					strValorNuevo=vigenciafue.getid_ciudad().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),VigenciaFueConstantesFunciones.IDCIUDAD,strValorActual,strValorNuevo);
			}	
			
			if(vigenciafue.getIsNew()||!vigenciafue.getfecha_inicio().equals(vigenciafue.getVigenciaFueOriginal().getfecha_inicio()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(vigenciafue.getVigenciaFueOriginal().getfecha_inicio()!=null)
				{
					strValorActual=vigenciafue.getVigenciaFueOriginal().getfecha_inicio().toString();
				}
				if(vigenciafue.getfecha_inicio()!=null)
				{
					strValorNuevo=vigenciafue.getfecha_inicio().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),VigenciaFueConstantesFunciones.FECHAINICIO,strValorActual,strValorNuevo);
			}	
			
			if(vigenciafue.getIsNew()||!vigenciafue.getfecha_fin().equals(vigenciafue.getVigenciaFueOriginal().getfecha_fin()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(vigenciafue.getVigenciaFueOriginal().getfecha_fin()!=null)
				{
					strValorActual=vigenciafue.getVigenciaFueOriginal().getfecha_fin().toString();
				}
				if(vigenciafue.getfecha_fin()!=null)
				{
					strValorNuevo=vigenciafue.getfecha_fin().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),VigenciaFueConstantesFunciones.FECHAFIN,strValorActual,strValorNuevo);
			}	
			
			if(vigenciafue.getIsNew()||!vigenciafue.getnumero_embarques().equals(vigenciafue.getVigenciaFueOriginal().getnumero_embarques()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(vigenciafue.getVigenciaFueOriginal().getnumero_embarques()!=null)
				{
					strValorActual=vigenciafue.getVigenciaFueOriginal().getnumero_embarques().toString();
				}
				if(vigenciafue.getnumero_embarques()!=null)
				{
					strValorNuevo=vigenciafue.getnumero_embarques().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),VigenciaFueConstantesFunciones.NUMEROEMBARQUES,strValorActual,strValorNuevo);
			}	
			
			if(vigenciafue.getIsNew()||!vigenciafue.getfue().equals(vigenciafue.getVigenciaFueOriginal().getfue()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(vigenciafue.getVigenciaFueOriginal().getfue()!=null)
				{
					strValorActual=vigenciafue.getVigenciaFueOriginal().getfue();
				}
				if(vigenciafue.getfue()!=null)
				{
					strValorNuevo=vigenciafue.getfue() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),VigenciaFueConstantesFunciones.FUE,strValorActual,strValorNuevo);
			}	
			
			if(vigenciafue.getIsNew()||!vigenciafue.getfecha_ultimo_embarque().equals(vigenciafue.getVigenciaFueOriginal().getfecha_ultimo_embarque()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(vigenciafue.getVigenciaFueOriginal().getfecha_ultimo_embarque()!=null)
				{
					strValorActual=vigenciafue.getVigenciaFueOriginal().getfecha_ultimo_embarque().toString();
				}
				if(vigenciafue.getfecha_ultimo_embarque()!=null)
				{
					strValorNuevo=vigenciafue.getfecha_ultimo_embarque().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),VigenciaFueConstantesFunciones.FECHAULTIMOEMBARQUE,strValorActual,strValorNuevo);
			}	
			
			if(vigenciafue.getIsNew()||!vigenciafue.getvalor().equals(vigenciafue.getVigenciaFueOriginal().getvalor()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(vigenciafue.getVigenciaFueOriginal().getvalor()!=null)
				{
					strValorActual=vigenciafue.getVigenciaFueOriginal().getvalor().toString();
				}
				if(vigenciafue.getvalor()!=null)
				{
					strValorNuevo=vigenciafue.getvalor().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),VigenciaFueConstantesFunciones.VALOR,strValorActual,strValorNuevo);
			}	
			
			if(vigenciafue.getIsNew()||!vigenciafue.getnumero_cajas().equals(vigenciafue.getVigenciaFueOriginal().getnumero_cajas()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(vigenciafue.getVigenciaFueOriginal().getnumero_cajas()!=null)
				{
					strValorActual=vigenciafue.getVigenciaFueOriginal().getnumero_cajas().toString();
				}
				if(vigenciafue.getnumero_cajas()!=null)
				{
					strValorNuevo=vigenciafue.getnumero_cajas().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),VigenciaFueConstantesFunciones.NUMEROCAJAS,strValorActual,strValorNuevo);
			}	
			
			if(vigenciafue.getIsNew()||!vigenciafue.getesta_activo().equals(vigenciafue.getVigenciaFueOriginal().getesta_activo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(vigenciafue.getVigenciaFueOriginal().getesta_activo()!=null)
				{
					strValorActual=vigenciafue.getVigenciaFueOriginal().getesta_activo().toString();
				}
				if(vigenciafue.getesta_activo()!=null)
				{
					strValorNuevo=vigenciafue.getesta_activo().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),VigenciaFueConstantesFunciones.ESTAACTIVO,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void saveVigenciaFueRelacionesWithConnection(VigenciaFue vigenciafue) throws Exception {

		if(!vigenciafue.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveVigenciaFueRelacionesBase(vigenciafue,true);
		}
	}

	public void saveVigenciaFueRelaciones(VigenciaFue vigenciafue)throws Exception {

		if(!vigenciafue.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveVigenciaFueRelacionesBase(vigenciafue,false);
		}
	}

	public void saveVigenciaFueRelacionesBase(VigenciaFue vigenciafue,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("VigenciaFue-saveRelacionesWithConnection");}
	

			this.setVigenciaFue(vigenciafue);

			if(VigenciaFueLogicAdditional.validarSaveRelaciones(vigenciafue,this)) {

				VigenciaFueLogicAdditional.updateRelacionesToSave(vigenciafue,this);

				if((vigenciafue.getIsNew()||vigenciafue.getIsChanged())&&!vigenciafue.getIsDeleted()) {
					this.saveVigenciaFue();
					this.saveVigenciaFueRelacionesDetalles();

				} else if(vigenciafue.getIsDeleted()) {
					this.saveVigenciaFueRelacionesDetalles();
					this.saveVigenciaFue();
				}

				VigenciaFueLogicAdditional.updateRelacionesToSaveAfter(vigenciafue,this);

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
	
	
	private void saveVigenciaFueRelacionesDetalles()throws Exception {
		try {
	

		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfVigenciaFue(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=VigenciaFueConstantesFunciones.getClassesForeignKeysOfVigenciaFue(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfVigenciaFue(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=VigenciaFueConstantesFunciones.getClassesRelationshipsOfVigenciaFue(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}
