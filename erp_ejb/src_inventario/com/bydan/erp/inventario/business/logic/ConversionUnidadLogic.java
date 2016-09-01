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
import com.bydan.erp.inventario.util.ConversionUnidadConstantesFunciones;
import com.bydan.erp.inventario.util.ConversionUnidadParameterReturnGeneral;
//import com.bydan.erp.inventario.util.ConversionUnidadParameterGeneral;
import com.bydan.erp.inventario.business.entity.ConversionUnidad;
import com.bydan.erp.inventario.business.logic.ConversionUnidadLogicAdditional;
import com.bydan.erp.inventario.business.dataaccess.*;
import com.bydan.erp.inventario.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.logic.*;


import com.bydan.erp.seguridad.util.*;


import com.bydan.erp.seguridad.business.dataaccess.*;








@SuppressWarnings("unused")
public class ConversionUnidadLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(ConversionUnidadLogic.class);
	
	protected ConversionUnidadDataAccess conversionunidadDataAccess; 	
	protected ConversionUnidad conversionunidad;
	protected List<ConversionUnidad> conversionunidads;
	protected Object conversionunidadObject;	
	protected List<Object> conversionunidadsObject;
	
	public static ClassValidator<ConversionUnidad> conversionunidadValidator = new ClassValidator<ConversionUnidad>(ConversionUnidad.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected ConversionUnidadLogicAdditional conversionunidadLogicAdditional=null;
	
	public ConversionUnidadLogicAdditional getConversionUnidadLogicAdditional() {
		return this.conversionunidadLogicAdditional;
	}
	
	public void setConversionUnidadLogicAdditional(ConversionUnidadLogicAdditional conversionunidadLogicAdditional) {
		try {
			this.conversionunidadLogicAdditional=conversionunidadLogicAdditional;
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
	
	
	
	
	public  ConversionUnidadLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.conversionunidadDataAccess = new ConversionUnidadDataAccess();
			
			this.conversionunidads= new ArrayList<ConversionUnidad>();
			this.conversionunidad= new ConversionUnidad();
			
			this.conversionunidadObject=new Object();
			this.conversionunidadsObject=new ArrayList<Object>();
				
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
			
			this.conversionunidadDataAccess.setConnexionType(this.connexionType);
			this.conversionunidadDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  ConversionUnidadLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.conversionunidadDataAccess = new ConversionUnidadDataAccess();
			this.conversionunidads= new ArrayList<ConversionUnidad>();
			this.conversionunidad= new ConversionUnidad();
			this.conversionunidadObject=new Object();
			this.conversionunidadsObject=new ArrayList<Object>();
			
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
			
			this.conversionunidadDataAccess.setConnexionType(this.connexionType);
			this.conversionunidadDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public ConversionUnidad getConversionUnidad() throws Exception {	
		ConversionUnidadLogicAdditional.checkConversionUnidadToGet(conversionunidad,this.datosCliente,this.arrDatoGeneral);
		ConversionUnidadLogicAdditional.updateConversionUnidadToGet(conversionunidad,this.arrDatoGeneral);
		
		return conversionunidad;
	}
		
	public void setConversionUnidad(ConversionUnidad newConversionUnidad) {
		this.conversionunidad = newConversionUnidad;
	}
	
	public ConversionUnidadDataAccess getConversionUnidadDataAccess() {
		return conversionunidadDataAccess;
	}
	
	public void setConversionUnidadDataAccess(ConversionUnidadDataAccess newconversionunidadDataAccess) {
		this.conversionunidadDataAccess = newconversionunidadDataAccess;
	}
	
	public List<ConversionUnidad> getConversionUnidads() throws Exception {		
		this.quitarConversionUnidadsNulos();
		
		ConversionUnidadLogicAdditional.checkConversionUnidadToGets(conversionunidads,this.datosCliente,this.arrDatoGeneral);
		
		for (ConversionUnidad conversionunidadLocal: conversionunidads ) {
			ConversionUnidadLogicAdditional.updateConversionUnidadToGet(conversionunidadLocal,this.arrDatoGeneral);
		}
		
		return conversionunidads;
	}
	
	public void setConversionUnidads(List<ConversionUnidad> newConversionUnidads) {
		this.conversionunidads = newConversionUnidads;
	}
	
	public Object getConversionUnidadObject() {	
		this.conversionunidadObject=this.conversionunidadDataAccess.getEntityObject();
		return this.conversionunidadObject;
	}
		
	public void setConversionUnidadObject(Object newConversionUnidadObject) {
		this.conversionunidadObject = newConversionUnidadObject;
	}
	
	public List<Object> getConversionUnidadsObject() {		
		this.conversionunidadsObject=this.conversionunidadDataAccess.getEntitiesObject();
		return this.conversionunidadsObject;
	}
		
	public void setConversionUnidadsObject(List<Object> newConversionUnidadsObject) {
		this.conversionunidadsObject = newConversionUnidadsObject;
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
		
		if(this.conversionunidadDataAccess!=null) {
			this.conversionunidadDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ConversionUnidad.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			conversionunidadDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			conversionunidadDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		conversionunidad = new  ConversionUnidad();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ConversionUnidad.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			conversionunidad=conversionunidadDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.conversionunidad,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				ConversionUnidadConstantesFunciones.refrescarForeignKeysDescripcionesConversionUnidad(this.conversionunidad);
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
		conversionunidad = new  ConversionUnidad();
		  		  
        try {
			
			conversionunidad=conversionunidadDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.conversionunidad,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				ConversionUnidadConstantesFunciones.refrescarForeignKeysDescripcionesConversionUnidad(this.conversionunidad);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		conversionunidad = new  ConversionUnidad();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ConversionUnidad.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			conversionunidad=conversionunidadDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.conversionunidad,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				ConversionUnidadConstantesFunciones.refrescarForeignKeysDescripcionesConversionUnidad(this.conversionunidad);
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
		conversionunidad = new  ConversionUnidad();
		  		  
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
		conversionunidad = new  ConversionUnidad();
		  		  
        try {
			
			conversionunidad=conversionunidadDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.conversionunidad,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				ConversionUnidadConstantesFunciones.refrescarForeignKeysDescripcionesConversionUnidad(this.conversionunidad);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		conversionunidad = new  ConversionUnidad();
		  		  
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
		conversionunidad = new  ConversionUnidad();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ConversionUnidad.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =conversionunidadDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		conversionunidad = new  ConversionUnidad();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=conversionunidadDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		conversionunidad = new  ConversionUnidad();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ConversionUnidad.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =conversionunidadDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		conversionunidad = new  ConversionUnidad();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=conversionunidadDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		conversionunidad = new  ConversionUnidad();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ConversionUnidad.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =conversionunidadDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		conversionunidad = new  ConversionUnidad();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=conversionunidadDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		conversionunidads = new  ArrayList<ConversionUnidad>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ConversionUnidad.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			ConversionUnidadLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			conversionunidads=conversionunidadDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarConversionUnidad(conversionunidads);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ConversionUnidadConstantesFunciones.refrescarForeignKeysDescripcionesConversionUnidad(this.conversionunidads);
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
		conversionunidads = new  ArrayList<ConversionUnidad>();
		  		  
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
		conversionunidads = new  ArrayList<ConversionUnidad>();
		  		  
        try {			
			ConversionUnidadLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			conversionunidads=conversionunidadDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarConversionUnidad(conversionunidads);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ConversionUnidadConstantesFunciones.refrescarForeignKeysDescripcionesConversionUnidad(this.conversionunidads);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		conversionunidads = new  ArrayList<ConversionUnidad>();
		  		  
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
		conversionunidads = new  ArrayList<ConversionUnidad>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ConversionUnidad.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			ConversionUnidadLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			conversionunidads=conversionunidadDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarConversionUnidad(conversionunidads);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ConversionUnidadConstantesFunciones.refrescarForeignKeysDescripcionesConversionUnidad(this.conversionunidads);
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
		conversionunidads = new  ArrayList<ConversionUnidad>();
		  		  
        try {
			ConversionUnidadLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			conversionunidads=conversionunidadDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarConversionUnidad(conversionunidads);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ConversionUnidadConstantesFunciones.refrescarForeignKeysDescripcionesConversionUnidad(this.conversionunidads);
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
		conversionunidads = new  ArrayList<ConversionUnidad>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ConversionUnidad.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ConversionUnidadLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			conversionunidads=conversionunidadDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarConversionUnidad(conversionunidads);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ConversionUnidadConstantesFunciones.refrescarForeignKeysDescripcionesConversionUnidad(this.conversionunidads);
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
		conversionunidads = new  ArrayList<ConversionUnidad>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ConversionUnidadLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			conversionunidads=conversionunidadDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarConversionUnidad(conversionunidads);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ConversionUnidadConstantesFunciones.refrescarForeignKeysDescripcionesConversionUnidad(this.conversionunidads);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		conversionunidad = new  ConversionUnidad();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ConversionUnidad.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ConversionUnidadLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			conversionunidad=conversionunidadDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarConversionUnidad(conversionunidad);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ConversionUnidadConstantesFunciones.refrescarForeignKeysDescripcionesConversionUnidad(this.conversionunidad);
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
		conversionunidad = new  ConversionUnidad();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ConversionUnidadLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			conversionunidad=conversionunidadDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarConversionUnidad(conversionunidad);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ConversionUnidadConstantesFunciones.refrescarForeignKeysDescripcionesConversionUnidad(this.conversionunidad);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		conversionunidads = new  ArrayList<ConversionUnidad>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ConversionUnidad.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			ConversionUnidadLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			conversionunidads=conversionunidadDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarConversionUnidad(conversionunidads);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ConversionUnidadConstantesFunciones.refrescarForeignKeysDescripcionesConversionUnidad(this.conversionunidads);
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
		conversionunidads = new  ArrayList<ConversionUnidad>();
		  		  
        try {
			ConversionUnidadLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			conversionunidads=conversionunidadDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarConversionUnidad(conversionunidads);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ConversionUnidadConstantesFunciones.refrescarForeignKeysDescripcionesConversionUnidad(this.conversionunidads);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosConversionUnidadsWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		conversionunidads = new  ArrayList<ConversionUnidad>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ConversionUnidad.class.getSimpleName()+"-getTodosConversionUnidadsWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ConversionUnidadLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			conversionunidads=conversionunidadDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarConversionUnidad(conversionunidads);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ConversionUnidadConstantesFunciones.refrescarForeignKeysDescripcionesConversionUnidad(this.conversionunidads);
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
	
	public  void  getTodosConversionUnidads(String sFinalQuery,Pagination pagination)throws Exception {
		conversionunidads = new  ArrayList<ConversionUnidad>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ConversionUnidadLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			conversionunidads=conversionunidadDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarConversionUnidad(conversionunidads);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ConversionUnidadConstantesFunciones.refrescarForeignKeysDescripcionesConversionUnidad(this.conversionunidads);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarConversionUnidad(ConversionUnidad conversionunidad) throws Exception {
		Boolean estaValidado=false;
		
		if(conversionunidad.getIsNew() || conversionunidad.getIsChanged()) { 
			this.invalidValues = conversionunidadValidator.getInvalidValues(conversionunidad);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(conversionunidad);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarConversionUnidad(List<ConversionUnidad> ConversionUnidads) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(ConversionUnidad conversionunidadLocal:conversionunidads) {				
			estaValidadoObjeto=this.validarGuardarConversionUnidad(conversionunidadLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarConversionUnidad(List<ConversionUnidad> ConversionUnidads) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarConversionUnidad(conversionunidads)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarConversionUnidad(ConversionUnidad ConversionUnidad) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarConversionUnidad(conversionunidad)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(ConversionUnidad conversionunidad) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+conversionunidad.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=ConversionUnidadConstantesFunciones.getConversionUnidadLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"conversionunidad","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(ConversionUnidadConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(ConversionUnidadConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveConversionUnidadWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ConversionUnidad.class.getSimpleName()+"-saveConversionUnidadWithConnection");connexion.begin();			
			
			ConversionUnidadLogicAdditional.checkConversionUnidadToSave(this.conversionunidad,this.datosCliente,connexion,this.arrDatoGeneral);
			
			ConversionUnidadLogicAdditional.updateConversionUnidadToSave(this.conversionunidad,this.arrDatoGeneral);
			
			ConversionUnidadLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.conversionunidad,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowConversionUnidad();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarConversionUnidad(this.conversionunidad)) {
				ConversionUnidadDataAccess.save(this.conversionunidad, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.conversionunidad,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			ConversionUnidadLogicAdditional.checkConversionUnidadToSaveAfter(this.conversionunidad,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowConversionUnidad();
			
			connexion.commit();			
			
			if(this.conversionunidad.getIsDeleted()) {
				this.conversionunidad=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveConversionUnidad()throws Exception {	
		try {	
			
			ConversionUnidadLogicAdditional.checkConversionUnidadToSave(this.conversionunidad,this.datosCliente,connexion,this.arrDatoGeneral);
			
			ConversionUnidadLogicAdditional.updateConversionUnidadToSave(this.conversionunidad,this.arrDatoGeneral);
			
			ConversionUnidadLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.conversionunidad,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarConversionUnidad(this.conversionunidad)) {			
				ConversionUnidadDataAccess.save(this.conversionunidad, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.conversionunidad,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			ConversionUnidadLogicAdditional.checkConversionUnidadToSaveAfter(this.conversionunidad,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.conversionunidad.getIsDeleted()) {
				this.conversionunidad=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveConversionUnidadsWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ConversionUnidad.class.getSimpleName()+"-saveConversionUnidadsWithConnection");connexion.begin();			
			
			ConversionUnidadLogicAdditional.checkConversionUnidadToSaves(conversionunidads,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowConversionUnidads();
			
			Boolean validadoTodosConversionUnidad=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(ConversionUnidad conversionunidadLocal:conversionunidads) {		
				if(conversionunidadLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				ConversionUnidadLogicAdditional.updateConversionUnidadToSave(conversionunidadLocal,this.arrDatoGeneral);
	        	
				ConversionUnidadLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),conversionunidadLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarConversionUnidad(conversionunidadLocal)) {
					ConversionUnidadDataAccess.save(conversionunidadLocal, connexion);				
				} else {
					validadoTodosConversionUnidad=false;
				}
			}
			
			if(!validadoTodosConversionUnidad) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			ConversionUnidadLogicAdditional.checkConversionUnidadToSavesAfter(conversionunidads,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowConversionUnidads();
			
			connexion.commit();		
			
			this.quitarConversionUnidadsEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveConversionUnidads()throws Exception {				
		 try {	
			ConversionUnidadLogicAdditional.checkConversionUnidadToSaves(conversionunidads,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosConversionUnidad=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(ConversionUnidad conversionunidadLocal:conversionunidads) {				
				if(conversionunidadLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				ConversionUnidadLogicAdditional.updateConversionUnidadToSave(conversionunidadLocal,this.arrDatoGeneral);
	        	
				ConversionUnidadLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),conversionunidadLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarConversionUnidad(conversionunidadLocal)) {				
					ConversionUnidadDataAccess.save(conversionunidadLocal, connexion);				
				} else {
					validadoTodosConversionUnidad=false;
				}
			}
			
			if(!validadoTodosConversionUnidad) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			ConversionUnidadLogicAdditional.checkConversionUnidadToSavesAfter(conversionunidads,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarConversionUnidadsEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public ConversionUnidadParameterReturnGeneral procesarAccionConversionUnidads(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<ConversionUnidad> conversionunidads,ConversionUnidadParameterReturnGeneral conversionunidadParameterGeneral)throws Exception {
		 try {	
			ConversionUnidadParameterReturnGeneral conversionunidadReturnGeneral=new ConversionUnidadParameterReturnGeneral();
	
			ConversionUnidadLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,conversionunidads,conversionunidadParameterGeneral,conversionunidadReturnGeneral);
			
			return conversionunidadReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public ConversionUnidadParameterReturnGeneral procesarAccionConversionUnidadsWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<ConversionUnidad> conversionunidads,ConversionUnidadParameterReturnGeneral conversionunidadParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ConversionUnidad.class.getSimpleName()+"-procesarAccionConversionUnidadsWithConnection");connexion.begin();			
			
			ConversionUnidadParameterReturnGeneral conversionunidadReturnGeneral=new ConversionUnidadParameterReturnGeneral();
	
			ConversionUnidadLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,conversionunidads,conversionunidadParameterGeneral,conversionunidadReturnGeneral);
			
			this.connexion.commit();
			
			return conversionunidadReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public ConversionUnidadParameterReturnGeneral procesarEventosConversionUnidads(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<ConversionUnidad> conversionunidads,ConversionUnidad conversionunidad,ConversionUnidadParameterReturnGeneral conversionunidadParameterGeneral,Boolean isEsNuevoConversionUnidad,ArrayList<Classe> clases)throws Exception {
		 try {	
			ConversionUnidadParameterReturnGeneral conversionunidadReturnGeneral=new ConversionUnidadParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				conversionunidadReturnGeneral.setConRecargarPropiedades(true);
			}
			
			ConversionUnidadLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,conversionunidads,conversionunidad,conversionunidadParameterGeneral,conversionunidadReturnGeneral,isEsNuevoConversionUnidad,clases);
			
			return conversionunidadReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public ConversionUnidadParameterReturnGeneral procesarEventosConversionUnidadsWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<ConversionUnidad> conversionunidads,ConversionUnidad conversionunidad,ConversionUnidadParameterReturnGeneral conversionunidadParameterGeneral,Boolean isEsNuevoConversionUnidad,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ConversionUnidad.class.getSimpleName()+"-procesarEventosConversionUnidadsWithConnection");connexion.begin();			
			
			ConversionUnidadParameterReturnGeneral conversionunidadReturnGeneral=new ConversionUnidadParameterReturnGeneral();
	
			conversionunidadReturnGeneral.setConversionUnidad(conversionunidad);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				conversionunidadReturnGeneral.setConRecargarPropiedades(true);
			}
			
			ConversionUnidadLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,conversionunidads,conversionunidad,conversionunidadParameterGeneral,conversionunidadReturnGeneral,isEsNuevoConversionUnidad,clases);
			
			this.connexion.commit();
			
			return conversionunidadReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public ConversionUnidadParameterReturnGeneral procesarImportacionConversionUnidadsWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,ConversionUnidadParameterReturnGeneral conversionunidadParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ConversionUnidad.class.getSimpleName()+"-procesarImportacionConversionUnidadsWithConnection");connexion.begin();			
			
			ConversionUnidadParameterReturnGeneral conversionunidadReturnGeneral=new ConversionUnidadParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.conversionunidads=new ArrayList<ConversionUnidad>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.conversionunidad=new ConversionUnidad();
				
				
				if(conColumnasBase) {this.conversionunidad.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.conversionunidad.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.conversionunidad.setvalor(Double.parseDouble(arrColumnas[iColumn++]));
				this.conversionunidad.setrelacion(Double.parseDouble(arrColumnas[iColumn++]));
				
				this.conversionunidads.add(this.conversionunidad);
			}
			
			this.saveConversionUnidads();
			
			this.connexion.commit();
			
			conversionunidadReturnGeneral.setConRetornoEstaProcesado(true);
			conversionunidadReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return conversionunidadReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarConversionUnidadsEliminados() throws Exception {				
		
		List<ConversionUnidad> conversionunidadsAux= new ArrayList<ConversionUnidad>();
		
		for(ConversionUnidad conversionunidad:conversionunidads) {
			if(!conversionunidad.getIsDeleted()) {
				conversionunidadsAux.add(conversionunidad);
			}
		}
		
		conversionunidads=conversionunidadsAux;
	}
	
	public void quitarConversionUnidadsNulos() throws Exception {				
		
		List<ConversionUnidad> conversionunidadsAux= new ArrayList<ConversionUnidad>();
		
		for(ConversionUnidad conversionunidad : this.conversionunidads) {
			if(conversionunidad==null) {
				conversionunidadsAux.add(conversionunidad);
			}
		}
		
		//this.conversionunidads=conversionunidadsAux;
		
		this.conversionunidads.removeAll(conversionunidadsAux);
	}
	
	public void getSetVersionRowConversionUnidadWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(conversionunidad.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((conversionunidad.getIsDeleted() || (conversionunidad.getIsChanged()&&!conversionunidad.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=conversionunidadDataAccess.getSetVersionRowConversionUnidad(connexion,conversionunidad.getId());
				
				if(!conversionunidad.getVersionRow().equals(timestamp)) {	
					conversionunidad.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				conversionunidad.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowConversionUnidad()throws Exception {	
		
		if(conversionunidad.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((conversionunidad.getIsDeleted() || (conversionunidad.getIsChanged()&&!conversionunidad.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=conversionunidadDataAccess.getSetVersionRowConversionUnidad(connexion,conversionunidad.getId());
			
			try {							
				if(!conversionunidad.getVersionRow().equals(timestamp)) {	
					conversionunidad.setVersionRow(timestamp);
				}
				
				conversionunidad.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowConversionUnidadsWithConnection()throws Exception {	
		if(conversionunidads!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(ConversionUnidad conversionunidadAux:conversionunidads) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(conversionunidadAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(conversionunidadAux.getIsDeleted() || (conversionunidadAux.getIsChanged()&&!conversionunidadAux.getIsNew())) {
						
						timestamp=conversionunidadDataAccess.getSetVersionRowConversionUnidad(connexion,conversionunidadAux.getId());
						
						if(!conversionunidad.getVersionRow().equals(timestamp)) {	
							conversionunidadAux.setVersionRow(timestamp);
						}
								
						conversionunidadAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowConversionUnidads()throws Exception {	
		if(conversionunidads!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(ConversionUnidad conversionunidadAux:conversionunidads) {
					if(conversionunidadAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(conversionunidadAux.getIsDeleted() || (conversionunidadAux.getIsChanged()&&!conversionunidadAux.getIsNew())) {
						
						timestamp=conversionunidadDataAccess.getSetVersionRowConversionUnidad(connexion,conversionunidadAux.getId());
						
						if(!conversionunidadAux.getVersionRow().equals(timestamp)) {	
							conversionunidadAux.setVersionRow(timestamp);
						}
						
													
						conversionunidadAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public ConversionUnidadParameterReturnGeneral cargarCombosLoteForeignKeyConversionUnidadWithConnection(String finalQueryGlobalEmpresa,String finalQueryGlobalUnidadDesde,String finalQueryGlobalUnidadHasta) throws Exception {
		ConversionUnidadParameterReturnGeneral  conversionunidadReturnGeneral =new ConversionUnidadParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ConversionUnidad.class.getSimpleName()+"-cargarCombosLoteForeignKeyConversionUnidadWithConnection");connexion.begin();
			
			conversionunidadReturnGeneral =new ConversionUnidadParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			conversionunidadReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Unidad> unidaddesdesForeignKey=new ArrayList<Unidad>();
			UnidadLogic unidaddesdeLogic=new UnidadLogic();
			unidaddesdeLogic.setConnexion(this.connexion);
			unidaddesdeLogic.getUnidadDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalUnidadDesde.equals("NONE")) {
				unidaddesdeLogic.getTodosUnidads(finalQueryGlobalUnidadDesde,new Pagination());
				unidaddesdesForeignKey=unidaddesdeLogic.getUnidads();
			}

			conversionunidadReturnGeneral.setunidaddesdesForeignKey(unidaddesdesForeignKey);


			List<Unidad> unidadhastasForeignKey=new ArrayList<Unidad>();
			UnidadLogic unidadhastaLogic=new UnidadLogic();
			unidadhastaLogic.setConnexion(this.connexion);
			unidadhastaLogic.getUnidadDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalUnidadHasta.equals("NONE")) {
				unidadhastaLogic.getTodosUnidads(finalQueryGlobalUnidadHasta,new Pagination());
				unidadhastasForeignKey=unidadhastaLogic.getUnidads();
			}

			conversionunidadReturnGeneral.setunidadhastasForeignKey(unidadhastasForeignKey);

			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
		
		return conversionunidadReturnGeneral;
	}
	
	public ConversionUnidadParameterReturnGeneral cargarCombosLoteForeignKeyConversionUnidad(String finalQueryGlobalEmpresa,String finalQueryGlobalUnidadDesde,String finalQueryGlobalUnidadHasta) throws Exception {
		ConversionUnidadParameterReturnGeneral  conversionunidadReturnGeneral =new ConversionUnidadParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {						
			conversionunidadReturnGeneral =new ConversionUnidadParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			conversionunidadReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Unidad> unidaddesdesForeignKey=new ArrayList<Unidad>();
			UnidadLogic unidaddesdeLogic=new UnidadLogic();
			unidaddesdeLogic.setConnexion(this.connexion);
			unidaddesdeLogic.getUnidadDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalUnidadDesde.equals("NONE")) {
				unidaddesdeLogic.getTodosUnidads(finalQueryGlobalUnidadDesde,new Pagination());
				unidaddesdesForeignKey=unidaddesdeLogic.getUnidads();
			}

			conversionunidadReturnGeneral.setunidaddesdesForeignKey(unidaddesdesForeignKey);


			List<Unidad> unidadhastasForeignKey=new ArrayList<Unidad>();
			UnidadLogic unidadhastaLogic=new UnidadLogic();
			unidadhastaLogic.setConnexion(this.connexion);
			unidadhastaLogic.getUnidadDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalUnidadHasta.equals("NONE")) {
				unidadhastaLogic.getTodosUnidads(finalQueryGlobalUnidadHasta,new Pagination());
				unidadhastasForeignKey=unidadhastaLogic.getUnidads();
			}

			conversionunidadReturnGeneral.setunidadhastasForeignKey(unidadhastasForeignKey);
						
			
		} catch(Exception e) {			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			
		}
		
		return conversionunidadReturnGeneral;
	}
	
	
	public void deepLoad(ConversionUnidad conversionunidad,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			ConversionUnidadLogicAdditional.updateConversionUnidadToGet(conversionunidad,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		conversionunidad.setEmpresa(conversionunidadDataAccess.getEmpresa(connexion,conversionunidad));
		conversionunidad.setUnidadDesde(conversionunidadDataAccess.getUnidadDesde(connexion,conversionunidad));
		conversionunidad.setUnidadHasta(conversionunidadDataAccess.getUnidadHasta(connexion,conversionunidad));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				conversionunidad.setEmpresa(conversionunidadDataAccess.getEmpresa(connexion,conversionunidad));
				continue;
			}

			if(clas.clas.equals(Unidad.class)) {
				conversionunidad.setUnidadDesde(conversionunidadDataAccess.getUnidadDesde(connexion,conversionunidad));
				continue;
			}

			if(clas.clas.equals(Unidad.class)) {
				conversionunidad.setUnidadHasta(conversionunidadDataAccess.getUnidadHasta(connexion,conversionunidad));
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
			conversionunidad.setEmpresa(conversionunidadDataAccess.getEmpresa(connexion,conversionunidad));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Unidad.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			conversionunidad.setUnidadDesde(conversionunidadDataAccess.getUnidadDesde(connexion,conversionunidad));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Unidad.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			conversionunidad.setUnidadHasta(conversionunidadDataAccess.getUnidadHasta(connexion,conversionunidad));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		conversionunidad.setEmpresa(conversionunidadDataAccess.getEmpresa(connexion,conversionunidad));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(conversionunidad.getEmpresa(),isDeep,deepLoadType,clases);
				
		conversionunidad.setUnidadDesde(conversionunidadDataAccess.getUnidadDesde(connexion,conversionunidad));
		UnidadLogic unidaddesdeLogic= new UnidadLogic(connexion);
		unidaddesdeLogic.deepLoad(conversionunidad.getUnidadDesde(),isDeep,deepLoadType,clases);
				
		conversionunidad.setUnidadHasta(conversionunidadDataAccess.getUnidadHasta(connexion,conversionunidad));
		UnidadLogic unidadhastaLogic= new UnidadLogic(connexion);
		unidadhastaLogic.deepLoad(conversionunidad.getUnidadHasta(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				conversionunidad.setEmpresa(conversionunidadDataAccess.getEmpresa(connexion,conversionunidad));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(conversionunidad.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Unidad.class)) {
				conversionunidad.setUnidadDesde(conversionunidadDataAccess.getUnidadDesde(connexion,conversionunidad));
				UnidadLogic unidadLogic= new UnidadLogic(connexion);
				unidadLogic.deepLoad(conversionunidad.getUnidadDesde(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Unidad.class)) {
				conversionunidad.setUnidadHasta(conversionunidadDataAccess.getUnidadHasta(connexion,conversionunidad));
				UnidadLogic unidadLogic= new UnidadLogic(connexion);
				unidadLogic.deepLoad(conversionunidad.getUnidadHasta(),isDeep,deepLoadType,clases);				
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
			conversionunidad.setEmpresa(conversionunidadDataAccess.getEmpresa(connexion,conversionunidad));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(conversionunidad.getEmpresa(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Unidad.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			conversionunidad.setUnidadDesde(conversionunidadDataAccess.getUnidadDesde(connexion,conversionunidad));
			UnidadLogic unidadLogic= new UnidadLogic(connexion);
			unidadLogic.deepLoad(conversionunidad.getUnidadDesde(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Unidad.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			conversionunidad.setUnidadHasta(conversionunidadDataAccess.getUnidadHasta(connexion,conversionunidad));
			UnidadLogic unidadLogic= new UnidadLogic(connexion);
			unidadLogic.deepLoad(conversionunidad.getUnidadHasta(),isDeep,deepLoadType,clases);
				
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(ConversionUnidad conversionunidad,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			ConversionUnidadLogicAdditional.updateConversionUnidadToSave(conversionunidad,this.arrDatoGeneral);
			
ConversionUnidadDataAccess.save(conversionunidad, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(conversionunidad.getEmpresa(),connexion);

		UnidadDataAccess.save(conversionunidad.getUnidadDesde(),connexion);

		UnidadDataAccess.save(conversionunidad.getUnidadHasta(),connexion);
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(conversionunidad.getEmpresa(),connexion);
				continue;
			}

			if(clas.clas.equals(Unidad.class)) {
				UnidadDataAccess.save(conversionunidad.getUnidadDesde(),connexion);
				continue;
			}

			if(clas.clas.equals(Unidad.class)) {
				UnidadDataAccess.save(conversionunidad.getUnidadHasta(),connexion);
				continue;
			}

		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(conversionunidad.getEmpresa(),connexion);
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(conversionunidad.getEmpresa(),isDeep,deepLoadType,clases);
				

		UnidadDataAccess.save(conversionunidad.getUnidadDesde(),connexion);
		UnidadLogic unidaddesdeLogic= new UnidadLogic(connexion);
		unidaddesdeLogic.deepLoad(conversionunidad.getUnidadDesde(),isDeep,deepLoadType,clases);
				

		UnidadDataAccess.save(conversionunidad.getUnidadHasta(),connexion);
		UnidadLogic unidadhastaLogic= new UnidadLogic(connexion);
		unidadhastaLogic.deepLoad(conversionunidad.getUnidadHasta(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(conversionunidad.getEmpresa(),connexion);
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepSave(conversionunidad.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Unidad.class)) {
				UnidadDataAccess.save(conversionunidad.getUnidadDesde(),connexion);
				UnidadLogic unidadLogic= new UnidadLogic(connexion);
				unidadLogic.deepSave(conversionunidad.getUnidadDesde(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Unidad.class)) {
				UnidadDataAccess.save(conversionunidad.getUnidadHasta(),connexion);
				UnidadLogic unidadLogic= new UnidadLogic(connexion);
				unidadLogic.deepSave(conversionunidad.getUnidadHasta(),isDeep,deepLoadType,clases);				
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
			this.getNewConnexionToDeep(ConversionUnidad.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(conversionunidad,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				ConversionUnidadConstantesFunciones.refrescarForeignKeysDescripcionesConversionUnidad(conversionunidad);
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
			this.deepLoad(this.conversionunidad,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				ConversionUnidadConstantesFunciones.refrescarForeignKeysDescripcionesConversionUnidad(this.conversionunidad);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(ConversionUnidad.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(conversionunidads!=null) {
				for(ConversionUnidad conversionunidad:conversionunidads) {
					this.deepLoad(conversionunidad,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					ConversionUnidadConstantesFunciones.refrescarForeignKeysDescripcionesConversionUnidad(conversionunidads);
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
			if(conversionunidads!=null) {
				for(ConversionUnidad conversionunidad:conversionunidads) {
					this.deepLoad(conversionunidad,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					ConversionUnidadConstantesFunciones.refrescarForeignKeysDescripcionesConversionUnidad(conversionunidads);
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
			this.getNewConnexionToDeep(ConversionUnidad.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(conversionunidad,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(ConversionUnidad.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(conversionunidads!=null) {
				for(ConversionUnidad conversionunidad:conversionunidads) {
					this.deepSave(conversionunidad,isDeep,deepLoadType,clases);
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
			if(conversionunidads!=null) {
				for(ConversionUnidad conversionunidad:conversionunidads) {
					this.deepSave(conversionunidad,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getConversionUnidadsFK_IdEmpresaWithConnection(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ConversionUnidad.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,ConversionUnidadConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			ConversionUnidadLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			conversionunidads=conversionunidadDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ConversionUnidadConstantesFunciones.refrescarForeignKeysDescripcionesConversionUnidad(this.conversionunidads);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getConversionUnidadsFK_IdEmpresa(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,ConversionUnidadConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			ConversionUnidadLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			conversionunidads=conversionunidadDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ConversionUnidadConstantesFunciones.refrescarForeignKeysDescripcionesConversionUnidad(this.conversionunidads);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getConversionUnidadsFK_IdUnidadDesdeWithConnection(String sFinalQuery,Pagination pagination,Long id_unidad_desde)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ConversionUnidad.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidUnidadDesde= new ParameterSelectionGeneral();
			parameterSelectionGeneralidUnidadDesde.setParameterSelectionGeneralEqual(ParameterType.LONG,id_unidad_desde,ConversionUnidadConstantesFunciones.IDUNIDADDESDE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidUnidadDesde);

			ConversionUnidadLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdUnidadDesde","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			conversionunidads=conversionunidadDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ConversionUnidadConstantesFunciones.refrescarForeignKeysDescripcionesConversionUnidad(this.conversionunidads);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getConversionUnidadsFK_IdUnidadDesde(String sFinalQuery,Pagination pagination,Long id_unidad_desde)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidUnidadDesde= new ParameterSelectionGeneral();
			parameterSelectionGeneralidUnidadDesde.setParameterSelectionGeneralEqual(ParameterType.LONG,id_unidad_desde,ConversionUnidadConstantesFunciones.IDUNIDADDESDE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidUnidadDesde);

			ConversionUnidadLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdUnidadDesde","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			conversionunidads=conversionunidadDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ConversionUnidadConstantesFunciones.refrescarForeignKeysDescripcionesConversionUnidad(this.conversionunidads);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getConversionUnidadsFK_IdUnidadHastaWithConnection(String sFinalQuery,Pagination pagination,Long id_unidad_hasta)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ConversionUnidad.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidUnidadHasta= new ParameterSelectionGeneral();
			parameterSelectionGeneralidUnidadHasta.setParameterSelectionGeneralEqual(ParameterType.LONG,id_unidad_hasta,ConversionUnidadConstantesFunciones.IDUNIDADHASTA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidUnidadHasta);

			ConversionUnidadLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdUnidadHasta","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			conversionunidads=conversionunidadDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ConversionUnidadConstantesFunciones.refrescarForeignKeysDescripcionesConversionUnidad(this.conversionunidads);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getConversionUnidadsFK_IdUnidadHasta(String sFinalQuery,Pagination pagination,Long id_unidad_hasta)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidUnidadHasta= new ParameterSelectionGeneral();
			parameterSelectionGeneralidUnidadHasta.setParameterSelectionGeneralEqual(ParameterType.LONG,id_unidad_hasta,ConversionUnidadConstantesFunciones.IDUNIDADHASTA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidUnidadHasta);

			ConversionUnidadLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdUnidadHasta","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			conversionunidads=conversionunidadDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ConversionUnidadConstantesFunciones.refrescarForeignKeysDescripcionesConversionUnidad(this.conversionunidads);
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
			if(ConversionUnidadConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,ConversionUnidadDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,ConversionUnidad conversionunidad,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(ConversionUnidadConstantesFunciones.ISCONAUDITORIA) {
				if(conversionunidad.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,ConversionUnidadDataAccess.TABLENAME, conversionunidad.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(ConversionUnidadConstantesFunciones.ISCONAUDITORIADETALLE) {
						////ConversionUnidadLogic.registrarAuditoriaDetallesConversionUnidad(connexion,conversionunidad,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(conversionunidad.getIsDeleted()) {
					/*if(!conversionunidad.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,ConversionUnidadDataAccess.TABLENAME, conversionunidad.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////ConversionUnidadLogic.registrarAuditoriaDetallesConversionUnidad(connexion,conversionunidad,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,ConversionUnidadDataAccess.TABLENAME, conversionunidad.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(conversionunidad.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,ConversionUnidadDataAccess.TABLENAME, conversionunidad.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(ConversionUnidadConstantesFunciones.ISCONAUDITORIADETALLE) {
						////ConversionUnidadLogic.registrarAuditoriaDetallesConversionUnidad(connexion,conversionunidad,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesConversionUnidad(Connexion connexion,ConversionUnidad conversionunidad)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(conversionunidad.getIsNew()||!conversionunidad.getid_empresa().equals(conversionunidad.getConversionUnidadOriginal().getid_empresa()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(conversionunidad.getConversionUnidadOriginal().getid_empresa()!=null)
				{
					strValorActual=conversionunidad.getConversionUnidadOriginal().getid_empresa().toString();
				}
				if(conversionunidad.getid_empresa()!=null)
				{
					strValorNuevo=conversionunidad.getid_empresa().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ConversionUnidadConstantesFunciones.IDEMPRESA,strValorActual,strValorNuevo);
			}	
			
			if(conversionunidad.getIsNew()||!conversionunidad.getid_unidad_desde().equals(conversionunidad.getConversionUnidadOriginal().getid_unidad_desde()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(conversionunidad.getConversionUnidadOriginal().getid_unidad_desde()!=null)
				{
					strValorActual=conversionunidad.getConversionUnidadOriginal().getid_unidad_desde().toString();
				}
				if(conversionunidad.getid_unidad_desde()!=null)
				{
					strValorNuevo=conversionunidad.getid_unidad_desde().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ConversionUnidadConstantesFunciones.IDUNIDADDESDE,strValorActual,strValorNuevo);
			}	
			
			if(conversionunidad.getIsNew()||!conversionunidad.getid_unidad_hasta().equals(conversionunidad.getConversionUnidadOriginal().getid_unidad_hasta()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(conversionunidad.getConversionUnidadOriginal().getid_unidad_hasta()!=null)
				{
					strValorActual=conversionunidad.getConversionUnidadOriginal().getid_unidad_hasta().toString();
				}
				if(conversionunidad.getid_unidad_hasta()!=null)
				{
					strValorNuevo=conversionunidad.getid_unidad_hasta().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ConversionUnidadConstantesFunciones.IDUNIDADHASTA,strValorActual,strValorNuevo);
			}	
			
			if(conversionunidad.getIsNew()||!conversionunidad.getvalor().equals(conversionunidad.getConversionUnidadOriginal().getvalor()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(conversionunidad.getConversionUnidadOriginal().getvalor()!=null)
				{
					strValorActual=conversionunidad.getConversionUnidadOriginal().getvalor().toString();
				}
				if(conversionunidad.getvalor()!=null)
				{
					strValorNuevo=conversionunidad.getvalor().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ConversionUnidadConstantesFunciones.VALOR,strValorActual,strValorNuevo);
			}	
			
			if(conversionunidad.getIsNew()||!conversionunidad.getrelacion().equals(conversionunidad.getConversionUnidadOriginal().getrelacion()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(conversionunidad.getConversionUnidadOriginal().getrelacion()!=null)
				{
					strValorActual=conversionunidad.getConversionUnidadOriginal().getrelacion().toString();
				}
				if(conversionunidad.getrelacion()!=null)
				{
					strValorNuevo=conversionunidad.getrelacion().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ConversionUnidadConstantesFunciones.RELACION,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void saveConversionUnidadRelacionesWithConnection(ConversionUnidad conversionunidad) throws Exception {

		if(!conversionunidad.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveConversionUnidadRelacionesBase(conversionunidad,true);
		}
	}

	public void saveConversionUnidadRelaciones(ConversionUnidad conversionunidad)throws Exception {

		if(!conversionunidad.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveConversionUnidadRelacionesBase(conversionunidad,false);
		}
	}

	public void saveConversionUnidadRelacionesBase(ConversionUnidad conversionunidad,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("ConversionUnidad-saveRelacionesWithConnection");}
	

			this.setConversionUnidad(conversionunidad);

			if(ConversionUnidadLogicAdditional.validarSaveRelaciones(conversionunidad,this)) {

				ConversionUnidadLogicAdditional.updateRelacionesToSave(conversionunidad,this);

				if((conversionunidad.getIsNew()||conversionunidad.getIsChanged())&&!conversionunidad.getIsDeleted()) {
					this.saveConversionUnidad();
					this.saveConversionUnidadRelacionesDetalles();

				} else if(conversionunidad.getIsDeleted()) {
					this.saveConversionUnidadRelacionesDetalles();
					this.saveConversionUnidad();
				}

				ConversionUnidadLogicAdditional.updateRelacionesToSaveAfter(conversionunidad,this);

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
	
	
	private void saveConversionUnidadRelacionesDetalles()throws Exception {
		try {
	

		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfConversionUnidad(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=ConversionUnidadConstantesFunciones.getClassesForeignKeysOfConversionUnidad(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfConversionUnidad(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=ConversionUnidadConstantesFunciones.getClassesRelationshipsOfConversionUnidad(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}
