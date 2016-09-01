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
import com.bydan.erp.facturacion.util.AnticipoClienteConstantesFunciones;
import com.bydan.erp.facturacion.util.AnticipoClienteParameterReturnGeneral;
//import com.bydan.erp.facturacion.util.AnticipoClienteParameterGeneral;
import com.bydan.erp.facturacion.business.entity.AnticipoCliente;
import com.bydan.erp.facturacion.business.logic.AnticipoClienteLogicAdditional;
import com.bydan.erp.facturacion.business.dataaccess.*;
import com.bydan.erp.facturacion.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.nomina.business.entity.*;


import com.bydan.erp.seguridad.business.logic.*;
import com.bydan.erp.nomina.business.logic.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.nomina.util.*;


import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.nomina.business.dataaccess.*;








@SuppressWarnings("unused")
public class AnticipoClienteLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(AnticipoClienteLogic.class);
	
	protected AnticipoClienteDataAccess anticipoclienteDataAccess; 	
	protected AnticipoCliente anticipocliente;
	protected List<AnticipoCliente> anticipoclientes;
	protected Object anticipoclienteObject;	
	protected List<Object> anticipoclientesObject;
	
	public static ClassValidator<AnticipoCliente> anticipoclienteValidator = new ClassValidator<AnticipoCliente>(AnticipoCliente.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected AnticipoClienteLogicAdditional anticipoclienteLogicAdditional=null;
	
	public AnticipoClienteLogicAdditional getAnticipoClienteLogicAdditional() {
		return this.anticipoclienteLogicAdditional;
	}
	
	public void setAnticipoClienteLogicAdditional(AnticipoClienteLogicAdditional anticipoclienteLogicAdditional) {
		try {
			this.anticipoclienteLogicAdditional=anticipoclienteLogicAdditional;
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
	
	
	
	
	public  AnticipoClienteLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.anticipoclienteDataAccess = new AnticipoClienteDataAccess();
			
			this.anticipoclientes= new ArrayList<AnticipoCliente>();
			this.anticipocliente= new AnticipoCliente();
			
			this.anticipoclienteObject=new Object();
			this.anticipoclientesObject=new ArrayList<Object>();
				
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
			
			this.anticipoclienteDataAccess.setConnexionType(this.connexionType);
			this.anticipoclienteDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  AnticipoClienteLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.anticipoclienteDataAccess = new AnticipoClienteDataAccess();
			this.anticipoclientes= new ArrayList<AnticipoCliente>();
			this.anticipocliente= new AnticipoCliente();
			this.anticipoclienteObject=new Object();
			this.anticipoclientesObject=new ArrayList<Object>();
			
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
			
			this.anticipoclienteDataAccess.setConnexionType(this.connexionType);
			this.anticipoclienteDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public AnticipoCliente getAnticipoCliente() throws Exception {	
		AnticipoClienteLogicAdditional.checkAnticipoClienteToGet(anticipocliente,this.datosCliente,this.arrDatoGeneral);
		AnticipoClienteLogicAdditional.updateAnticipoClienteToGet(anticipocliente,this.arrDatoGeneral);
		
		return anticipocliente;
	}
		
	public void setAnticipoCliente(AnticipoCliente newAnticipoCliente) {
		this.anticipocliente = newAnticipoCliente;
	}
	
	public AnticipoClienteDataAccess getAnticipoClienteDataAccess() {
		return anticipoclienteDataAccess;
	}
	
	public void setAnticipoClienteDataAccess(AnticipoClienteDataAccess newanticipoclienteDataAccess) {
		this.anticipoclienteDataAccess = newanticipoclienteDataAccess;
	}
	
	public List<AnticipoCliente> getAnticipoClientes() throws Exception {		
		this.quitarAnticipoClientesNulos();
		
		AnticipoClienteLogicAdditional.checkAnticipoClienteToGets(anticipoclientes,this.datosCliente,this.arrDatoGeneral);
		
		for (AnticipoCliente anticipoclienteLocal: anticipoclientes ) {
			AnticipoClienteLogicAdditional.updateAnticipoClienteToGet(anticipoclienteLocal,this.arrDatoGeneral);
		}
		
		return anticipoclientes;
	}
	
	public void setAnticipoClientes(List<AnticipoCliente> newAnticipoClientes) {
		this.anticipoclientes = newAnticipoClientes;
	}
	
	public Object getAnticipoClienteObject() {	
		this.anticipoclienteObject=this.anticipoclienteDataAccess.getEntityObject();
		return this.anticipoclienteObject;
	}
		
	public void setAnticipoClienteObject(Object newAnticipoClienteObject) {
		this.anticipoclienteObject = newAnticipoClienteObject;
	}
	
	public List<Object> getAnticipoClientesObject() {		
		this.anticipoclientesObject=this.anticipoclienteDataAccess.getEntitiesObject();
		return this.anticipoclientesObject;
	}
		
	public void setAnticipoClientesObject(List<Object> newAnticipoClientesObject) {
		this.anticipoclientesObject = newAnticipoClientesObject;
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
		
		if(this.anticipoclienteDataAccess!=null) {
			this.anticipoclienteDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,AnticipoCliente.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			anticipoclienteDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			anticipoclienteDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		anticipocliente = new  AnticipoCliente();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,AnticipoCliente.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			anticipocliente=anticipoclienteDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.anticipocliente,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				AnticipoClienteConstantesFunciones.refrescarForeignKeysDescripcionesAnticipoCliente(this.anticipocliente);
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
		anticipocliente = new  AnticipoCliente();
		  		  
        try {
			
			anticipocliente=anticipoclienteDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.anticipocliente,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				AnticipoClienteConstantesFunciones.refrescarForeignKeysDescripcionesAnticipoCliente(this.anticipocliente);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		anticipocliente = new  AnticipoCliente();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,AnticipoCliente.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			anticipocliente=anticipoclienteDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.anticipocliente,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				AnticipoClienteConstantesFunciones.refrescarForeignKeysDescripcionesAnticipoCliente(this.anticipocliente);
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
		anticipocliente = new  AnticipoCliente();
		  		  
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
		anticipocliente = new  AnticipoCliente();
		  		  
        try {
			
			anticipocliente=anticipoclienteDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.anticipocliente,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				AnticipoClienteConstantesFunciones.refrescarForeignKeysDescripcionesAnticipoCliente(this.anticipocliente);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		anticipocliente = new  AnticipoCliente();
		  		  
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
		anticipocliente = new  AnticipoCliente();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,AnticipoCliente.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =anticipoclienteDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		anticipocliente = new  AnticipoCliente();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=anticipoclienteDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		anticipocliente = new  AnticipoCliente();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,AnticipoCliente.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =anticipoclienteDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		anticipocliente = new  AnticipoCliente();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=anticipoclienteDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		anticipocliente = new  AnticipoCliente();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,AnticipoCliente.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =anticipoclienteDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		anticipocliente = new  AnticipoCliente();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=anticipoclienteDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		anticipoclientes = new  ArrayList<AnticipoCliente>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,AnticipoCliente.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			AnticipoClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			anticipoclientes=anticipoclienteDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarAnticipoCliente(anticipoclientes);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				AnticipoClienteConstantesFunciones.refrescarForeignKeysDescripcionesAnticipoCliente(this.anticipoclientes);
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
		anticipoclientes = new  ArrayList<AnticipoCliente>();
		  		  
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
		anticipoclientes = new  ArrayList<AnticipoCliente>();
		  		  
        try {			
			AnticipoClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			anticipoclientes=anticipoclienteDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarAnticipoCliente(anticipoclientes);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				AnticipoClienteConstantesFunciones.refrescarForeignKeysDescripcionesAnticipoCliente(this.anticipoclientes);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		anticipoclientes = new  ArrayList<AnticipoCliente>();
		  		  
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
		anticipoclientes = new  ArrayList<AnticipoCliente>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,AnticipoCliente.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			AnticipoClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			anticipoclientes=anticipoclienteDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarAnticipoCliente(anticipoclientes);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				AnticipoClienteConstantesFunciones.refrescarForeignKeysDescripcionesAnticipoCliente(this.anticipoclientes);
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
		anticipoclientes = new  ArrayList<AnticipoCliente>();
		  		  
        try {
			AnticipoClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			anticipoclientes=anticipoclienteDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarAnticipoCliente(anticipoclientes);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				AnticipoClienteConstantesFunciones.refrescarForeignKeysDescripcionesAnticipoCliente(this.anticipoclientes);
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
		anticipoclientes = new  ArrayList<AnticipoCliente>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,AnticipoCliente.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			AnticipoClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			anticipoclientes=anticipoclienteDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarAnticipoCliente(anticipoclientes);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				AnticipoClienteConstantesFunciones.refrescarForeignKeysDescripcionesAnticipoCliente(this.anticipoclientes);
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
		anticipoclientes = new  ArrayList<AnticipoCliente>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			AnticipoClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			anticipoclientes=anticipoclienteDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarAnticipoCliente(anticipoclientes);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				AnticipoClienteConstantesFunciones.refrescarForeignKeysDescripcionesAnticipoCliente(this.anticipoclientes);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		anticipocliente = new  AnticipoCliente();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,AnticipoCliente.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			AnticipoClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			anticipocliente=anticipoclienteDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarAnticipoCliente(anticipocliente);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				AnticipoClienteConstantesFunciones.refrescarForeignKeysDescripcionesAnticipoCliente(this.anticipocliente);
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
		anticipocliente = new  AnticipoCliente();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			AnticipoClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			anticipocliente=anticipoclienteDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarAnticipoCliente(anticipocliente);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				AnticipoClienteConstantesFunciones.refrescarForeignKeysDescripcionesAnticipoCliente(this.anticipocliente);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		anticipoclientes = new  ArrayList<AnticipoCliente>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,AnticipoCliente.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			AnticipoClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			anticipoclientes=anticipoclienteDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarAnticipoCliente(anticipoclientes);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				AnticipoClienteConstantesFunciones.refrescarForeignKeysDescripcionesAnticipoCliente(this.anticipoclientes);
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
		anticipoclientes = new  ArrayList<AnticipoCliente>();
		  		  
        try {
			AnticipoClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			anticipoclientes=anticipoclienteDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarAnticipoCliente(anticipoclientes);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				AnticipoClienteConstantesFunciones.refrescarForeignKeysDescripcionesAnticipoCliente(this.anticipoclientes);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosAnticipoClientesWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		anticipoclientes = new  ArrayList<AnticipoCliente>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,AnticipoCliente.class.getSimpleName()+"-getTodosAnticipoClientesWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			AnticipoClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			anticipoclientes=anticipoclienteDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarAnticipoCliente(anticipoclientes);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				AnticipoClienteConstantesFunciones.refrescarForeignKeysDescripcionesAnticipoCliente(this.anticipoclientes);
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
	
	public  void  getTodosAnticipoClientes(String sFinalQuery,Pagination pagination)throws Exception {
		anticipoclientes = new  ArrayList<AnticipoCliente>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			AnticipoClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			anticipoclientes=anticipoclienteDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarAnticipoCliente(anticipoclientes);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				AnticipoClienteConstantesFunciones.refrescarForeignKeysDescripcionesAnticipoCliente(this.anticipoclientes);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarAnticipoCliente(AnticipoCliente anticipocliente) throws Exception {
		Boolean estaValidado=false;
		
		if(anticipocliente.getIsNew() || anticipocliente.getIsChanged()) { 
			this.invalidValues = anticipoclienteValidator.getInvalidValues(anticipocliente);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(anticipocliente);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarAnticipoCliente(List<AnticipoCliente> AnticipoClientes) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(AnticipoCliente anticipoclienteLocal:anticipoclientes) {				
			estaValidadoObjeto=this.validarGuardarAnticipoCliente(anticipoclienteLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarAnticipoCliente(List<AnticipoCliente> AnticipoClientes) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarAnticipoCliente(anticipoclientes)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarAnticipoCliente(AnticipoCliente AnticipoCliente) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarAnticipoCliente(anticipocliente)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(AnticipoCliente anticipocliente) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+anticipocliente.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=AnticipoClienteConstantesFunciones.getAnticipoClienteLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"anticipocliente","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(AnticipoClienteConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(AnticipoClienteConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveAnticipoClienteWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,AnticipoCliente.class.getSimpleName()+"-saveAnticipoClienteWithConnection");connexion.begin();			
			
			AnticipoClienteLogicAdditional.checkAnticipoClienteToSave(this.anticipocliente,this.datosCliente,connexion,this.arrDatoGeneral);
			
			AnticipoClienteLogicAdditional.updateAnticipoClienteToSave(this.anticipocliente,this.arrDatoGeneral);
			
			AnticipoClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.anticipocliente,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowAnticipoCliente();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarAnticipoCliente(this.anticipocliente)) {
				AnticipoClienteDataAccess.save(this.anticipocliente, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.anticipocliente,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			AnticipoClienteLogicAdditional.checkAnticipoClienteToSaveAfter(this.anticipocliente,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowAnticipoCliente();
			
			connexion.commit();			
			
			if(this.anticipocliente.getIsDeleted()) {
				this.anticipocliente=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveAnticipoCliente()throws Exception {	
		try {	
			
			AnticipoClienteLogicAdditional.checkAnticipoClienteToSave(this.anticipocliente,this.datosCliente,connexion,this.arrDatoGeneral);
			
			AnticipoClienteLogicAdditional.updateAnticipoClienteToSave(this.anticipocliente,this.arrDatoGeneral);
			
			AnticipoClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.anticipocliente,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarAnticipoCliente(this.anticipocliente)) {			
				AnticipoClienteDataAccess.save(this.anticipocliente, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.anticipocliente,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			AnticipoClienteLogicAdditional.checkAnticipoClienteToSaveAfter(this.anticipocliente,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.anticipocliente.getIsDeleted()) {
				this.anticipocliente=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveAnticipoClientesWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,AnticipoCliente.class.getSimpleName()+"-saveAnticipoClientesWithConnection");connexion.begin();			
			
			AnticipoClienteLogicAdditional.checkAnticipoClienteToSaves(anticipoclientes,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowAnticipoClientes();
			
			Boolean validadoTodosAnticipoCliente=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(AnticipoCliente anticipoclienteLocal:anticipoclientes) {		
				if(anticipoclienteLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				AnticipoClienteLogicAdditional.updateAnticipoClienteToSave(anticipoclienteLocal,this.arrDatoGeneral);
	        	
				AnticipoClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),anticipoclienteLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarAnticipoCliente(anticipoclienteLocal)) {
					AnticipoClienteDataAccess.save(anticipoclienteLocal, connexion);				
				} else {
					validadoTodosAnticipoCliente=false;
				}
			}
			
			if(!validadoTodosAnticipoCliente) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			AnticipoClienteLogicAdditional.checkAnticipoClienteToSavesAfter(anticipoclientes,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowAnticipoClientes();
			
			connexion.commit();		
			
			this.quitarAnticipoClientesEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveAnticipoClientes()throws Exception {				
		 try {	
			AnticipoClienteLogicAdditional.checkAnticipoClienteToSaves(anticipoclientes,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosAnticipoCliente=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(AnticipoCliente anticipoclienteLocal:anticipoclientes) {				
				if(anticipoclienteLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				AnticipoClienteLogicAdditional.updateAnticipoClienteToSave(anticipoclienteLocal,this.arrDatoGeneral);
	        	
				AnticipoClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),anticipoclienteLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarAnticipoCliente(anticipoclienteLocal)) {				
					AnticipoClienteDataAccess.save(anticipoclienteLocal, connexion);				
				} else {
					validadoTodosAnticipoCliente=false;
				}
			}
			
			if(!validadoTodosAnticipoCliente) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			AnticipoClienteLogicAdditional.checkAnticipoClienteToSavesAfter(anticipoclientes,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarAnticipoClientesEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public AnticipoClienteParameterReturnGeneral procesarAccionAnticipoClientes(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<AnticipoCliente> anticipoclientes,AnticipoClienteParameterReturnGeneral anticipoclienteParameterGeneral)throws Exception {
		 try {	
			AnticipoClienteParameterReturnGeneral anticipoclienteReturnGeneral=new AnticipoClienteParameterReturnGeneral();
	
			AnticipoClienteLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,anticipoclientes,anticipoclienteParameterGeneral,anticipoclienteReturnGeneral);
			
			return anticipoclienteReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public AnticipoClienteParameterReturnGeneral procesarAccionAnticipoClientesWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<AnticipoCliente> anticipoclientes,AnticipoClienteParameterReturnGeneral anticipoclienteParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,AnticipoCliente.class.getSimpleName()+"-procesarAccionAnticipoClientesWithConnection");connexion.begin();			
			
			AnticipoClienteParameterReturnGeneral anticipoclienteReturnGeneral=new AnticipoClienteParameterReturnGeneral();
	
			AnticipoClienteLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,anticipoclientes,anticipoclienteParameterGeneral,anticipoclienteReturnGeneral);
			
			this.connexion.commit();
			
			return anticipoclienteReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public AnticipoClienteParameterReturnGeneral procesarEventosAnticipoClientes(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<AnticipoCliente> anticipoclientes,AnticipoCliente anticipocliente,AnticipoClienteParameterReturnGeneral anticipoclienteParameterGeneral,Boolean isEsNuevoAnticipoCliente,ArrayList<Classe> clases)throws Exception {
		 try {	
			AnticipoClienteParameterReturnGeneral anticipoclienteReturnGeneral=new AnticipoClienteParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				anticipoclienteReturnGeneral.setConRecargarPropiedades(true);
			}
			
			AnticipoClienteLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,anticipoclientes,anticipocliente,anticipoclienteParameterGeneral,anticipoclienteReturnGeneral,isEsNuevoAnticipoCliente,clases);
			
			return anticipoclienteReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public AnticipoClienteParameterReturnGeneral procesarEventosAnticipoClientesWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<AnticipoCliente> anticipoclientes,AnticipoCliente anticipocliente,AnticipoClienteParameterReturnGeneral anticipoclienteParameterGeneral,Boolean isEsNuevoAnticipoCliente,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,AnticipoCliente.class.getSimpleName()+"-procesarEventosAnticipoClientesWithConnection");connexion.begin();			
			
			AnticipoClienteParameterReturnGeneral anticipoclienteReturnGeneral=new AnticipoClienteParameterReturnGeneral();
	
			anticipoclienteReturnGeneral.setAnticipoCliente(anticipocliente);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				anticipoclienteReturnGeneral.setConRecargarPropiedades(true);
			}
			
			AnticipoClienteLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,anticipoclientes,anticipocliente,anticipoclienteParameterGeneral,anticipoclienteReturnGeneral,isEsNuevoAnticipoCliente,clases);
			
			this.connexion.commit();
			
			return anticipoclienteReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public AnticipoClienteParameterReturnGeneral procesarImportacionAnticipoClientesWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,AnticipoClienteParameterReturnGeneral anticipoclienteParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,AnticipoCliente.class.getSimpleName()+"-procesarImportacionAnticipoClientesWithConnection");connexion.begin();			
			
			AnticipoClienteParameterReturnGeneral anticipoclienteReturnGeneral=new AnticipoClienteParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.anticipoclientes=new ArrayList<AnticipoCliente>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.anticipocliente=new AnticipoCliente();
				
				
				if(conColumnasBase) {this.anticipocliente.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.anticipocliente.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.anticipocliente.setfecha(Funciones.ConvertToDate(arrColumnas[iColumn++]));
				this.anticipocliente.setvalor(Double.parseDouble(arrColumnas[iColumn++]));
				this.anticipocliente.setdescripcion(arrColumnas[iColumn++]);
				this.anticipocliente.setvalor_adicional(Double.parseDouble(arrColumnas[iColumn++]));
				this.anticipocliente.setvalor_prestamo(Double.parseDouble(arrColumnas[iColumn++]));
				this.anticipocliente.setingreso1(Double.parseDouble(arrColumnas[iColumn++]));
				this.anticipocliente.setingreso2(Double.parseDouble(arrColumnas[iColumn++]));
				this.anticipocliente.setingreso3(Double.parseDouble(arrColumnas[iColumn++]));
				this.anticipocliente.setingreso4(Double.parseDouble(arrColumnas[iColumn++]));
				this.anticipocliente.setingreso5(Double.parseDouble(arrColumnas[iColumn++]));
				this.anticipocliente.setdescuento1(Double.parseDouble(arrColumnas[iColumn++]));
				this.anticipocliente.setdescuento2(Double.parseDouble(arrColumnas[iColumn++]));
				this.anticipocliente.setdescuento3(Double.parseDouble(arrColumnas[iColumn++]));
				this.anticipocliente.setdescuento4(Double.parseDouble(arrColumnas[iColumn++]));
				this.anticipocliente.setdescuento5(Double.parseDouble(arrColumnas[iColumn++]));
				this.anticipocliente.settipo_ingreso(Double.parseDouble(arrColumnas[iColumn++]));
				this.anticipocliente.settipo_descuento(Double.parseDouble(arrColumnas[iColumn++]));
				
				this.anticipoclientes.add(this.anticipocliente);
			}
			
			this.saveAnticipoClientes();
			
			this.connexion.commit();
			
			anticipoclienteReturnGeneral.setConRetornoEstaProcesado(true);
			anticipoclienteReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return anticipoclienteReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarAnticipoClientesEliminados() throws Exception {				
		
		List<AnticipoCliente> anticipoclientesAux= new ArrayList<AnticipoCliente>();
		
		for(AnticipoCliente anticipocliente:anticipoclientes) {
			if(!anticipocliente.getIsDeleted()) {
				anticipoclientesAux.add(anticipocliente);
			}
		}
		
		anticipoclientes=anticipoclientesAux;
	}
	
	public void quitarAnticipoClientesNulos() throws Exception {				
		
		List<AnticipoCliente> anticipoclientesAux= new ArrayList<AnticipoCliente>();
		
		for(AnticipoCliente anticipocliente : this.anticipoclientes) {
			if(anticipocliente==null) {
				anticipoclientesAux.add(anticipocliente);
			}
		}
		
		//this.anticipoclientes=anticipoclientesAux;
		
		this.anticipoclientes.removeAll(anticipoclientesAux);
	}
	
	public void getSetVersionRowAnticipoClienteWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(anticipocliente.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((anticipocliente.getIsDeleted() || (anticipocliente.getIsChanged()&&!anticipocliente.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=anticipoclienteDataAccess.getSetVersionRowAnticipoCliente(connexion,anticipocliente.getId());
				
				if(!anticipocliente.getVersionRow().equals(timestamp)) {	
					anticipocliente.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				anticipocliente.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowAnticipoCliente()throws Exception {	
		
		if(anticipocliente.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((anticipocliente.getIsDeleted() || (anticipocliente.getIsChanged()&&!anticipocliente.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=anticipoclienteDataAccess.getSetVersionRowAnticipoCliente(connexion,anticipocliente.getId());
			
			try {							
				if(!anticipocliente.getVersionRow().equals(timestamp)) {	
					anticipocliente.setVersionRow(timestamp);
				}
				
				anticipocliente.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowAnticipoClientesWithConnection()throws Exception {	
		if(anticipoclientes!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(AnticipoCliente anticipoclienteAux:anticipoclientes) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(anticipoclienteAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(anticipoclienteAux.getIsDeleted() || (anticipoclienteAux.getIsChanged()&&!anticipoclienteAux.getIsNew())) {
						
						timestamp=anticipoclienteDataAccess.getSetVersionRowAnticipoCliente(connexion,anticipoclienteAux.getId());
						
						if(!anticipocliente.getVersionRow().equals(timestamp)) {	
							anticipoclienteAux.setVersionRow(timestamp);
						}
								
						anticipoclienteAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowAnticipoClientes()throws Exception {	
		if(anticipoclientes!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(AnticipoCliente anticipoclienteAux:anticipoclientes) {
					if(anticipoclienteAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(anticipoclienteAux.getIsDeleted() || (anticipoclienteAux.getIsChanged()&&!anticipoclienteAux.getIsNew())) {
						
						timestamp=anticipoclienteDataAccess.getSetVersionRowAnticipoCliente(connexion,anticipoclienteAux.getId());
						
						if(!anticipoclienteAux.getVersionRow().equals(timestamp)) {	
							anticipoclienteAux.setVersionRow(timestamp);
						}
						
													
						anticipoclienteAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public AnticipoClienteParameterReturnGeneral cargarCombosLoteForeignKeyAnticipoClienteWithConnection(String finalQueryGlobalEmpresa,String finalQueryGlobalEmpleado,String finalQueryGlobalEstadoAntiCliente,String finalQueryGlobalTipoGrupoFormaPago) throws Exception {
		AnticipoClienteParameterReturnGeneral  anticipoclienteReturnGeneral =new AnticipoClienteParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,AnticipoCliente.class.getSimpleName()+"-cargarCombosLoteForeignKeyAnticipoClienteWithConnection");connexion.begin();
			
			anticipoclienteReturnGeneral =new AnticipoClienteParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			anticipoclienteReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Empleado> empleadosForeignKey=new ArrayList<Empleado>();
			EmpleadoLogic empleadoLogic=new EmpleadoLogic();
			empleadoLogic.setConnexion(this.connexion);
			empleadoLogic.getEmpleadoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpleado.equals("NONE")) {
				empleadoLogic.getTodosEmpleados(finalQueryGlobalEmpleado,new Pagination());
				empleadosForeignKey=empleadoLogic.getEmpleados();
			}

			anticipoclienteReturnGeneral.setempleadosForeignKey(empleadosForeignKey);


			List<EstadoAntiCliente> estadoanticlientesForeignKey=new ArrayList<EstadoAntiCliente>();
			EstadoAntiClienteLogic estadoanticlienteLogic=new EstadoAntiClienteLogic();
			estadoanticlienteLogic.setConnexion(this.connexion);
			estadoanticlienteLogic.getEstadoAntiClienteDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEstadoAntiCliente.equals("NONE")) {
				estadoanticlienteLogic.getTodosEstadoAntiClientes(finalQueryGlobalEstadoAntiCliente,new Pagination());
				estadoanticlientesForeignKey=estadoanticlienteLogic.getEstadoAntiClientes();
			}

			anticipoclienteReturnGeneral.setestadoanticlientesForeignKey(estadoanticlientesForeignKey);


			List<TipoGrupoFormaPago> tipogrupoformapagosForeignKey=new ArrayList<TipoGrupoFormaPago>();
			TipoGrupoFormaPagoLogic tipogrupoformapagoLogic=new TipoGrupoFormaPagoLogic();
			tipogrupoformapagoLogic.setConnexion(this.connexion);
			tipogrupoformapagoLogic.getTipoGrupoFormaPagoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoGrupoFormaPago.equals("NONE")) {
				tipogrupoformapagoLogic.getTodosTipoGrupoFormaPagos(finalQueryGlobalTipoGrupoFormaPago,new Pagination());
				tipogrupoformapagosForeignKey=tipogrupoformapagoLogic.getTipoGrupoFormaPagos();
			}

			anticipoclienteReturnGeneral.settipogrupoformapagosForeignKey(tipogrupoformapagosForeignKey);

			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
		
		return anticipoclienteReturnGeneral;
	}
	
	public AnticipoClienteParameterReturnGeneral cargarCombosLoteForeignKeyAnticipoCliente(String finalQueryGlobalEmpresa,String finalQueryGlobalEmpleado,String finalQueryGlobalEstadoAntiCliente,String finalQueryGlobalTipoGrupoFormaPago) throws Exception {
		AnticipoClienteParameterReturnGeneral  anticipoclienteReturnGeneral =new AnticipoClienteParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {						
			anticipoclienteReturnGeneral =new AnticipoClienteParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			anticipoclienteReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Empleado> empleadosForeignKey=new ArrayList<Empleado>();
			EmpleadoLogic empleadoLogic=new EmpleadoLogic();
			empleadoLogic.setConnexion(this.connexion);
			empleadoLogic.getEmpleadoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpleado.equals("NONE")) {
				empleadoLogic.getTodosEmpleados(finalQueryGlobalEmpleado,new Pagination());
				empleadosForeignKey=empleadoLogic.getEmpleados();
			}

			anticipoclienteReturnGeneral.setempleadosForeignKey(empleadosForeignKey);


			List<EstadoAntiCliente> estadoanticlientesForeignKey=new ArrayList<EstadoAntiCliente>();
			EstadoAntiClienteLogic estadoanticlienteLogic=new EstadoAntiClienteLogic();
			estadoanticlienteLogic.setConnexion(this.connexion);
			estadoanticlienteLogic.getEstadoAntiClienteDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEstadoAntiCliente.equals("NONE")) {
				estadoanticlienteLogic.getTodosEstadoAntiClientes(finalQueryGlobalEstadoAntiCliente,new Pagination());
				estadoanticlientesForeignKey=estadoanticlienteLogic.getEstadoAntiClientes();
			}

			anticipoclienteReturnGeneral.setestadoanticlientesForeignKey(estadoanticlientesForeignKey);


			List<TipoGrupoFormaPago> tipogrupoformapagosForeignKey=new ArrayList<TipoGrupoFormaPago>();
			TipoGrupoFormaPagoLogic tipogrupoformapagoLogic=new TipoGrupoFormaPagoLogic();
			tipogrupoformapagoLogic.setConnexion(this.connexion);
			tipogrupoformapagoLogic.getTipoGrupoFormaPagoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoGrupoFormaPago.equals("NONE")) {
				tipogrupoformapagoLogic.getTodosTipoGrupoFormaPagos(finalQueryGlobalTipoGrupoFormaPago,new Pagination());
				tipogrupoformapagosForeignKey=tipogrupoformapagoLogic.getTipoGrupoFormaPagos();
			}

			anticipoclienteReturnGeneral.settipogrupoformapagosForeignKey(tipogrupoformapagosForeignKey);
						
			
		} catch(Exception e) {			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			
		}
		
		return anticipoclienteReturnGeneral;
	}
	
	
	public void deepLoad(AnticipoCliente anticipocliente,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			AnticipoClienteLogicAdditional.updateAnticipoClienteToGet(anticipocliente,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		anticipocliente.setEmpresa(anticipoclienteDataAccess.getEmpresa(connexion,anticipocliente));
		anticipocliente.setEmpleado(anticipoclienteDataAccess.getEmpleado(connexion,anticipocliente));
		anticipocliente.setEstadoAntiCliente(anticipoclienteDataAccess.getEstadoAntiCliente(connexion,anticipocliente));
		anticipocliente.setTipoGrupoFormaPago(anticipoclienteDataAccess.getTipoGrupoFormaPago(connexion,anticipocliente));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				anticipocliente.setEmpresa(anticipoclienteDataAccess.getEmpresa(connexion,anticipocliente));
				continue;
			}

			if(clas.clas.equals(Empleado.class)) {
				anticipocliente.setEmpleado(anticipoclienteDataAccess.getEmpleado(connexion,anticipocliente));
				continue;
			}

			if(clas.clas.equals(EstadoAntiCliente.class)) {
				anticipocliente.setEstadoAntiCliente(anticipoclienteDataAccess.getEstadoAntiCliente(connexion,anticipocliente));
				continue;
			}

			if(clas.clas.equals(TipoGrupoFormaPago.class)) {
				anticipocliente.setTipoGrupoFormaPago(anticipoclienteDataAccess.getTipoGrupoFormaPago(connexion,anticipocliente));
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
			anticipocliente.setEmpresa(anticipoclienteDataAccess.getEmpresa(connexion,anticipocliente));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Empleado.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			anticipocliente.setEmpleado(anticipoclienteDataAccess.getEmpleado(connexion,anticipocliente));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(EstadoAntiCliente.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			anticipocliente.setEstadoAntiCliente(anticipoclienteDataAccess.getEstadoAntiCliente(connexion,anticipocliente));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(TipoGrupoFormaPago.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			anticipocliente.setTipoGrupoFormaPago(anticipoclienteDataAccess.getTipoGrupoFormaPago(connexion,anticipocliente));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		anticipocliente.setEmpresa(anticipoclienteDataAccess.getEmpresa(connexion,anticipocliente));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(anticipocliente.getEmpresa(),isDeep,deepLoadType,clases);
				
		anticipocliente.setEmpleado(anticipoclienteDataAccess.getEmpleado(connexion,anticipocliente));
		EmpleadoLogic empleadoLogic= new EmpleadoLogic(connexion);
		empleadoLogic.deepLoad(anticipocliente.getEmpleado(),isDeep,deepLoadType,clases);
				
		anticipocliente.setEstadoAntiCliente(anticipoclienteDataAccess.getEstadoAntiCliente(connexion,anticipocliente));
		EstadoAntiClienteLogic estadoanticlienteLogic= new EstadoAntiClienteLogic(connexion);
		estadoanticlienteLogic.deepLoad(anticipocliente.getEstadoAntiCliente(),isDeep,deepLoadType,clases);
				
		anticipocliente.setTipoGrupoFormaPago(anticipoclienteDataAccess.getTipoGrupoFormaPago(connexion,anticipocliente));
		TipoGrupoFormaPagoLogic tipogrupoformapagoLogic= new TipoGrupoFormaPagoLogic(connexion);
		tipogrupoformapagoLogic.deepLoad(anticipocliente.getTipoGrupoFormaPago(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				anticipocliente.setEmpresa(anticipoclienteDataAccess.getEmpresa(connexion,anticipocliente));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(anticipocliente.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Empleado.class)) {
				anticipocliente.setEmpleado(anticipoclienteDataAccess.getEmpleado(connexion,anticipocliente));
				EmpleadoLogic empleadoLogic= new EmpleadoLogic(connexion);
				empleadoLogic.deepLoad(anticipocliente.getEmpleado(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(EstadoAntiCliente.class)) {
				anticipocliente.setEstadoAntiCliente(anticipoclienteDataAccess.getEstadoAntiCliente(connexion,anticipocliente));
				EstadoAntiClienteLogic estadoanticlienteLogic= new EstadoAntiClienteLogic(connexion);
				estadoanticlienteLogic.deepLoad(anticipocliente.getEstadoAntiCliente(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoGrupoFormaPago.class)) {
				anticipocliente.setTipoGrupoFormaPago(anticipoclienteDataAccess.getTipoGrupoFormaPago(connexion,anticipocliente));
				TipoGrupoFormaPagoLogic tipogrupoformapagoLogic= new TipoGrupoFormaPagoLogic(connexion);
				tipogrupoformapagoLogic.deepLoad(anticipocliente.getTipoGrupoFormaPago(),isDeep,deepLoadType,clases);				
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
			anticipocliente.setEmpresa(anticipoclienteDataAccess.getEmpresa(connexion,anticipocliente));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(anticipocliente.getEmpresa(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Empleado.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			anticipocliente.setEmpleado(anticipoclienteDataAccess.getEmpleado(connexion,anticipocliente));
			EmpleadoLogic empleadoLogic= new EmpleadoLogic(connexion);
			empleadoLogic.deepLoad(anticipocliente.getEmpleado(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(EstadoAntiCliente.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			anticipocliente.setEstadoAntiCliente(anticipoclienteDataAccess.getEstadoAntiCliente(connexion,anticipocliente));
			EstadoAntiClienteLogic estadoanticlienteLogic= new EstadoAntiClienteLogic(connexion);
			estadoanticlienteLogic.deepLoad(anticipocliente.getEstadoAntiCliente(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(TipoGrupoFormaPago.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			anticipocliente.setTipoGrupoFormaPago(anticipoclienteDataAccess.getTipoGrupoFormaPago(connexion,anticipocliente));
			TipoGrupoFormaPagoLogic tipogrupoformapagoLogic= new TipoGrupoFormaPagoLogic(connexion);
			tipogrupoformapagoLogic.deepLoad(anticipocliente.getTipoGrupoFormaPago(),isDeep,deepLoadType,clases);
				
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(AnticipoCliente anticipocliente,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			AnticipoClienteLogicAdditional.updateAnticipoClienteToSave(anticipocliente,this.arrDatoGeneral);
			
AnticipoClienteDataAccess.save(anticipocliente, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(anticipocliente.getEmpresa(),connexion);

		EmpleadoDataAccess.save(anticipocliente.getEmpleado(),connexion);

		EstadoAntiClienteDataAccess.save(anticipocliente.getEstadoAntiCliente(),connexion);

		TipoGrupoFormaPagoDataAccess.save(anticipocliente.getTipoGrupoFormaPago(),connexion);
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(anticipocliente.getEmpresa(),connexion);
				continue;
			}

			if(clas.clas.equals(Empleado.class)) {
				EmpleadoDataAccess.save(anticipocliente.getEmpleado(),connexion);
				continue;
			}

			if(clas.clas.equals(EstadoAntiCliente.class)) {
				EstadoAntiClienteDataAccess.save(anticipocliente.getEstadoAntiCliente(),connexion);
				continue;
			}

			if(clas.clas.equals(TipoGrupoFormaPago.class)) {
				TipoGrupoFormaPagoDataAccess.save(anticipocliente.getTipoGrupoFormaPago(),connexion);
				continue;
			}

		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(anticipocliente.getEmpresa(),connexion);
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(anticipocliente.getEmpresa(),isDeep,deepLoadType,clases);
				

		EmpleadoDataAccess.save(anticipocliente.getEmpleado(),connexion);
		EmpleadoLogic empleadoLogic= new EmpleadoLogic(connexion);
		empleadoLogic.deepLoad(anticipocliente.getEmpleado(),isDeep,deepLoadType,clases);
				

		EstadoAntiClienteDataAccess.save(anticipocliente.getEstadoAntiCliente(),connexion);
		EstadoAntiClienteLogic estadoanticlienteLogic= new EstadoAntiClienteLogic(connexion);
		estadoanticlienteLogic.deepLoad(anticipocliente.getEstadoAntiCliente(),isDeep,deepLoadType,clases);
				

		TipoGrupoFormaPagoDataAccess.save(anticipocliente.getTipoGrupoFormaPago(),connexion);
		TipoGrupoFormaPagoLogic tipogrupoformapagoLogic= new TipoGrupoFormaPagoLogic(connexion);
		tipogrupoformapagoLogic.deepLoad(anticipocliente.getTipoGrupoFormaPago(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(anticipocliente.getEmpresa(),connexion);
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepSave(anticipocliente.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Empleado.class)) {
				EmpleadoDataAccess.save(anticipocliente.getEmpleado(),connexion);
				EmpleadoLogic empleadoLogic= new EmpleadoLogic(connexion);
				empleadoLogic.deepSave(anticipocliente.getEmpleado(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(EstadoAntiCliente.class)) {
				EstadoAntiClienteDataAccess.save(anticipocliente.getEstadoAntiCliente(),connexion);
				EstadoAntiClienteLogic estadoanticlienteLogic= new EstadoAntiClienteLogic(connexion);
				estadoanticlienteLogic.deepSave(anticipocliente.getEstadoAntiCliente(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoGrupoFormaPago.class)) {
				TipoGrupoFormaPagoDataAccess.save(anticipocliente.getTipoGrupoFormaPago(),connexion);
				TipoGrupoFormaPagoLogic tipogrupoformapagoLogic= new TipoGrupoFormaPagoLogic(connexion);
				tipogrupoformapagoLogic.deepSave(anticipocliente.getTipoGrupoFormaPago(),isDeep,deepLoadType,clases);				
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
			this.getNewConnexionToDeep(AnticipoCliente.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(anticipocliente,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				AnticipoClienteConstantesFunciones.refrescarForeignKeysDescripcionesAnticipoCliente(anticipocliente);
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
			this.deepLoad(this.anticipocliente,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				AnticipoClienteConstantesFunciones.refrescarForeignKeysDescripcionesAnticipoCliente(this.anticipocliente);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(AnticipoCliente.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(anticipoclientes!=null) {
				for(AnticipoCliente anticipocliente:anticipoclientes) {
					this.deepLoad(anticipocliente,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					AnticipoClienteConstantesFunciones.refrescarForeignKeysDescripcionesAnticipoCliente(anticipoclientes);
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
			if(anticipoclientes!=null) {
				for(AnticipoCliente anticipocliente:anticipoclientes) {
					this.deepLoad(anticipocliente,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					AnticipoClienteConstantesFunciones.refrescarForeignKeysDescripcionesAnticipoCliente(anticipoclientes);
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
			this.getNewConnexionToDeep(AnticipoCliente.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(anticipocliente,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(AnticipoCliente.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(anticipoclientes!=null) {
				for(AnticipoCliente anticipocliente:anticipoclientes) {
					this.deepSave(anticipocliente,isDeep,deepLoadType,clases);
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
			if(anticipoclientes!=null) {
				for(AnticipoCliente anticipocliente:anticipoclientes) {
					this.deepSave(anticipocliente,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getAnticipoClientesFK_IdEmpleadoWithConnection(String sFinalQuery,Pagination pagination,Long id_empleado)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,AnticipoCliente.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpleado= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpleado.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empleado,AnticipoClienteConstantesFunciones.IDEMPLEADO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpleado);

			AnticipoClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpleado","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			anticipoclientes=anticipoclienteDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				AnticipoClienteConstantesFunciones.refrescarForeignKeysDescripcionesAnticipoCliente(this.anticipoclientes);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getAnticipoClientesFK_IdEmpleado(String sFinalQuery,Pagination pagination,Long id_empleado)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpleado= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpleado.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empleado,AnticipoClienteConstantesFunciones.IDEMPLEADO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpleado);

			AnticipoClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpleado","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			anticipoclientes=anticipoclienteDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				AnticipoClienteConstantesFunciones.refrescarForeignKeysDescripcionesAnticipoCliente(this.anticipoclientes);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getAnticipoClientesFK_IdEmpresaWithConnection(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,AnticipoCliente.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,AnticipoClienteConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			AnticipoClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			anticipoclientes=anticipoclienteDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				AnticipoClienteConstantesFunciones.refrescarForeignKeysDescripcionesAnticipoCliente(this.anticipoclientes);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getAnticipoClientesFK_IdEmpresa(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,AnticipoClienteConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			AnticipoClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			anticipoclientes=anticipoclienteDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				AnticipoClienteConstantesFunciones.refrescarForeignKeysDescripcionesAnticipoCliente(this.anticipoclientes);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getAnticipoClientesFK_IdEstadoAntiClienteWithConnection(String sFinalQuery,Pagination pagination,Long id_estado_anti_cliente)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,AnticipoCliente.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEstadoAntiCliente= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEstadoAntiCliente.setParameterSelectionGeneralEqual(ParameterType.LONG,id_estado_anti_cliente,AnticipoClienteConstantesFunciones.IDESTADOANTICLIENTE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEstadoAntiCliente);

			AnticipoClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEstadoAntiCliente","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			anticipoclientes=anticipoclienteDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				AnticipoClienteConstantesFunciones.refrescarForeignKeysDescripcionesAnticipoCliente(this.anticipoclientes);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getAnticipoClientesFK_IdEstadoAntiCliente(String sFinalQuery,Pagination pagination,Long id_estado_anti_cliente)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEstadoAntiCliente= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEstadoAntiCliente.setParameterSelectionGeneralEqual(ParameterType.LONG,id_estado_anti_cliente,AnticipoClienteConstantesFunciones.IDESTADOANTICLIENTE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEstadoAntiCliente);

			AnticipoClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEstadoAntiCliente","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			anticipoclientes=anticipoclienteDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				AnticipoClienteConstantesFunciones.refrescarForeignKeysDescripcionesAnticipoCliente(this.anticipoclientes);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getAnticipoClientesFK_IdTipoGrupoFormaPagoWithConnection(String sFinalQuery,Pagination pagination,Long id_tipo_grupo_forma_pago)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,AnticipoCliente.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoGrupoFormaPago= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoGrupoFormaPago.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_grupo_forma_pago,AnticipoClienteConstantesFunciones.IDTIPOGRUPOFORMAPAGO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoGrupoFormaPago);

			AnticipoClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoGrupoFormaPago","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			anticipoclientes=anticipoclienteDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				AnticipoClienteConstantesFunciones.refrescarForeignKeysDescripcionesAnticipoCliente(this.anticipoclientes);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getAnticipoClientesFK_IdTipoGrupoFormaPago(String sFinalQuery,Pagination pagination,Long id_tipo_grupo_forma_pago)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoGrupoFormaPago= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoGrupoFormaPago.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_grupo_forma_pago,AnticipoClienteConstantesFunciones.IDTIPOGRUPOFORMAPAGO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoGrupoFormaPago);

			AnticipoClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoGrupoFormaPago","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			anticipoclientes=anticipoclienteDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				AnticipoClienteConstantesFunciones.refrescarForeignKeysDescripcionesAnticipoCliente(this.anticipoclientes);
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
			if(AnticipoClienteConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,AnticipoClienteDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,AnticipoCliente anticipocliente,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(AnticipoClienteConstantesFunciones.ISCONAUDITORIA) {
				if(anticipocliente.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,AnticipoClienteDataAccess.TABLENAME, anticipocliente.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(AnticipoClienteConstantesFunciones.ISCONAUDITORIADETALLE) {
						////AnticipoClienteLogic.registrarAuditoriaDetallesAnticipoCliente(connexion,anticipocliente,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(anticipocliente.getIsDeleted()) {
					/*if(!anticipocliente.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,AnticipoClienteDataAccess.TABLENAME, anticipocliente.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////AnticipoClienteLogic.registrarAuditoriaDetallesAnticipoCliente(connexion,anticipocliente,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,AnticipoClienteDataAccess.TABLENAME, anticipocliente.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(anticipocliente.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,AnticipoClienteDataAccess.TABLENAME, anticipocliente.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(AnticipoClienteConstantesFunciones.ISCONAUDITORIADETALLE) {
						////AnticipoClienteLogic.registrarAuditoriaDetallesAnticipoCliente(connexion,anticipocliente,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesAnticipoCliente(Connexion connexion,AnticipoCliente anticipocliente)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(anticipocliente.getIsNew()||!anticipocliente.getid_empresa().equals(anticipocliente.getAnticipoClienteOriginal().getid_empresa()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(anticipocliente.getAnticipoClienteOriginal().getid_empresa()!=null)
				{
					strValorActual=anticipocliente.getAnticipoClienteOriginal().getid_empresa().toString();
				}
				if(anticipocliente.getid_empresa()!=null)
				{
					strValorNuevo=anticipocliente.getid_empresa().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),AnticipoClienteConstantesFunciones.IDEMPRESA,strValorActual,strValorNuevo);
			}	
			
			if(anticipocliente.getIsNew()||!anticipocliente.getid_empleado().equals(anticipocliente.getAnticipoClienteOriginal().getid_empleado()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(anticipocliente.getAnticipoClienteOriginal().getid_empleado()!=null)
				{
					strValorActual=anticipocliente.getAnticipoClienteOriginal().getid_empleado().toString();
				}
				if(anticipocliente.getid_empleado()!=null)
				{
					strValorNuevo=anticipocliente.getid_empleado().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),AnticipoClienteConstantesFunciones.IDEMPLEADO,strValorActual,strValorNuevo);
			}	
			
			if(anticipocliente.getIsNew()||!anticipocliente.getid_estado_anti_cliente().equals(anticipocliente.getAnticipoClienteOriginal().getid_estado_anti_cliente()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(anticipocliente.getAnticipoClienteOriginal().getid_estado_anti_cliente()!=null)
				{
					strValorActual=anticipocliente.getAnticipoClienteOriginal().getid_estado_anti_cliente().toString();
				}
				if(anticipocliente.getid_estado_anti_cliente()!=null)
				{
					strValorNuevo=anticipocliente.getid_estado_anti_cliente().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),AnticipoClienteConstantesFunciones.IDESTADOANTICLIENTE,strValorActual,strValorNuevo);
			}	
			
			if(anticipocliente.getIsNew()||!anticipocliente.getid_tipo_grupo_forma_pago().equals(anticipocliente.getAnticipoClienteOriginal().getid_tipo_grupo_forma_pago()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(anticipocliente.getAnticipoClienteOriginal().getid_tipo_grupo_forma_pago()!=null)
				{
					strValorActual=anticipocliente.getAnticipoClienteOriginal().getid_tipo_grupo_forma_pago().toString();
				}
				if(anticipocliente.getid_tipo_grupo_forma_pago()!=null)
				{
					strValorNuevo=anticipocliente.getid_tipo_grupo_forma_pago().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),AnticipoClienteConstantesFunciones.IDTIPOGRUPOFORMAPAGO,strValorActual,strValorNuevo);
			}	
			
			if(anticipocliente.getIsNew()||!anticipocliente.getfecha().equals(anticipocliente.getAnticipoClienteOriginal().getfecha()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(anticipocliente.getAnticipoClienteOriginal().getfecha()!=null)
				{
					strValorActual=anticipocliente.getAnticipoClienteOriginal().getfecha().toString();
				}
				if(anticipocliente.getfecha()!=null)
				{
					strValorNuevo=anticipocliente.getfecha().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),AnticipoClienteConstantesFunciones.FECHA,strValorActual,strValorNuevo);
			}	
			
			if(anticipocliente.getIsNew()||!anticipocliente.getvalor().equals(anticipocliente.getAnticipoClienteOriginal().getvalor()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(anticipocliente.getAnticipoClienteOriginal().getvalor()!=null)
				{
					strValorActual=anticipocliente.getAnticipoClienteOriginal().getvalor().toString();
				}
				if(anticipocliente.getvalor()!=null)
				{
					strValorNuevo=anticipocliente.getvalor().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),AnticipoClienteConstantesFunciones.VALOR,strValorActual,strValorNuevo);
			}	
			
			if(anticipocliente.getIsNew()||!anticipocliente.getdescripcion().equals(anticipocliente.getAnticipoClienteOriginal().getdescripcion()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(anticipocliente.getAnticipoClienteOriginal().getdescripcion()!=null)
				{
					strValorActual=anticipocliente.getAnticipoClienteOriginal().getdescripcion();
				}
				if(anticipocliente.getdescripcion()!=null)
				{
					strValorNuevo=anticipocliente.getdescripcion() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),AnticipoClienteConstantesFunciones.DESCRIPCION,strValorActual,strValorNuevo);
			}	
			
			if(anticipocliente.getIsNew()||!anticipocliente.getvalor_adicional().equals(anticipocliente.getAnticipoClienteOriginal().getvalor_adicional()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(anticipocliente.getAnticipoClienteOriginal().getvalor_adicional()!=null)
				{
					strValorActual=anticipocliente.getAnticipoClienteOriginal().getvalor_adicional().toString();
				}
				if(anticipocliente.getvalor_adicional()!=null)
				{
					strValorNuevo=anticipocliente.getvalor_adicional().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),AnticipoClienteConstantesFunciones.VALORADICIONAL,strValorActual,strValorNuevo);
			}	
			
			if(anticipocliente.getIsNew()||!anticipocliente.getvalor_prestamo().equals(anticipocliente.getAnticipoClienteOriginal().getvalor_prestamo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(anticipocliente.getAnticipoClienteOriginal().getvalor_prestamo()!=null)
				{
					strValorActual=anticipocliente.getAnticipoClienteOriginal().getvalor_prestamo().toString();
				}
				if(anticipocliente.getvalor_prestamo()!=null)
				{
					strValorNuevo=anticipocliente.getvalor_prestamo().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),AnticipoClienteConstantesFunciones.VALORPRESTAMO,strValorActual,strValorNuevo);
			}	
			
			if(anticipocliente.getIsNew()||!anticipocliente.getingreso1().equals(anticipocliente.getAnticipoClienteOriginal().getingreso1()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(anticipocliente.getAnticipoClienteOriginal().getingreso1()!=null)
				{
					strValorActual=anticipocliente.getAnticipoClienteOriginal().getingreso1().toString();
				}
				if(anticipocliente.getingreso1()!=null)
				{
					strValorNuevo=anticipocliente.getingreso1().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),AnticipoClienteConstantesFunciones.INGRESO1,strValorActual,strValorNuevo);
			}	
			
			if(anticipocliente.getIsNew()||!anticipocliente.getingreso2().equals(anticipocliente.getAnticipoClienteOriginal().getingreso2()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(anticipocliente.getAnticipoClienteOriginal().getingreso2()!=null)
				{
					strValorActual=anticipocliente.getAnticipoClienteOriginal().getingreso2().toString();
				}
				if(anticipocliente.getingreso2()!=null)
				{
					strValorNuevo=anticipocliente.getingreso2().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),AnticipoClienteConstantesFunciones.INGRESO2,strValorActual,strValorNuevo);
			}	
			
			if(anticipocliente.getIsNew()||!anticipocliente.getingreso3().equals(anticipocliente.getAnticipoClienteOriginal().getingreso3()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(anticipocliente.getAnticipoClienteOriginal().getingreso3()!=null)
				{
					strValorActual=anticipocliente.getAnticipoClienteOriginal().getingreso3().toString();
				}
				if(anticipocliente.getingreso3()!=null)
				{
					strValorNuevo=anticipocliente.getingreso3().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),AnticipoClienteConstantesFunciones.INGRESO3,strValorActual,strValorNuevo);
			}	
			
			if(anticipocliente.getIsNew()||!anticipocliente.getingreso4().equals(anticipocliente.getAnticipoClienteOriginal().getingreso4()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(anticipocliente.getAnticipoClienteOriginal().getingreso4()!=null)
				{
					strValorActual=anticipocliente.getAnticipoClienteOriginal().getingreso4().toString();
				}
				if(anticipocliente.getingreso4()!=null)
				{
					strValorNuevo=anticipocliente.getingreso4().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),AnticipoClienteConstantesFunciones.INGRESO4,strValorActual,strValorNuevo);
			}	
			
			if(anticipocliente.getIsNew()||!anticipocliente.getingreso5().equals(anticipocliente.getAnticipoClienteOriginal().getingreso5()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(anticipocliente.getAnticipoClienteOriginal().getingreso5()!=null)
				{
					strValorActual=anticipocliente.getAnticipoClienteOriginal().getingreso5().toString();
				}
				if(anticipocliente.getingreso5()!=null)
				{
					strValorNuevo=anticipocliente.getingreso5().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),AnticipoClienteConstantesFunciones.INGRESO5,strValorActual,strValorNuevo);
			}	
			
			if(anticipocliente.getIsNew()||!anticipocliente.getdescuento1().equals(anticipocliente.getAnticipoClienteOriginal().getdescuento1()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(anticipocliente.getAnticipoClienteOriginal().getdescuento1()!=null)
				{
					strValorActual=anticipocliente.getAnticipoClienteOriginal().getdescuento1().toString();
				}
				if(anticipocliente.getdescuento1()!=null)
				{
					strValorNuevo=anticipocliente.getdescuento1().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),AnticipoClienteConstantesFunciones.DESCUENTO1,strValorActual,strValorNuevo);
			}	
			
			if(anticipocliente.getIsNew()||!anticipocliente.getdescuento2().equals(anticipocliente.getAnticipoClienteOriginal().getdescuento2()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(anticipocliente.getAnticipoClienteOriginal().getdescuento2()!=null)
				{
					strValorActual=anticipocliente.getAnticipoClienteOriginal().getdescuento2().toString();
				}
				if(anticipocliente.getdescuento2()!=null)
				{
					strValorNuevo=anticipocliente.getdescuento2().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),AnticipoClienteConstantesFunciones.DESCUENTO2,strValorActual,strValorNuevo);
			}	
			
			if(anticipocliente.getIsNew()||!anticipocliente.getdescuento3().equals(anticipocliente.getAnticipoClienteOriginal().getdescuento3()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(anticipocliente.getAnticipoClienteOriginal().getdescuento3()!=null)
				{
					strValorActual=anticipocliente.getAnticipoClienteOriginal().getdescuento3().toString();
				}
				if(anticipocliente.getdescuento3()!=null)
				{
					strValorNuevo=anticipocliente.getdescuento3().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),AnticipoClienteConstantesFunciones.DESCUENTO3,strValorActual,strValorNuevo);
			}	
			
			if(anticipocliente.getIsNew()||!anticipocliente.getdescuento4().equals(anticipocliente.getAnticipoClienteOriginal().getdescuento4()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(anticipocliente.getAnticipoClienteOriginal().getdescuento4()!=null)
				{
					strValorActual=anticipocliente.getAnticipoClienteOriginal().getdescuento4().toString();
				}
				if(anticipocliente.getdescuento4()!=null)
				{
					strValorNuevo=anticipocliente.getdescuento4().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),AnticipoClienteConstantesFunciones.DESCUENTO4,strValorActual,strValorNuevo);
			}	
			
			if(anticipocliente.getIsNew()||!anticipocliente.getdescuento5().equals(anticipocliente.getAnticipoClienteOriginal().getdescuento5()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(anticipocliente.getAnticipoClienteOriginal().getdescuento5()!=null)
				{
					strValorActual=anticipocliente.getAnticipoClienteOriginal().getdescuento5().toString();
				}
				if(anticipocliente.getdescuento5()!=null)
				{
					strValorNuevo=anticipocliente.getdescuento5().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),AnticipoClienteConstantesFunciones.DESCUENTO5,strValorActual,strValorNuevo);
			}	
			
			if(anticipocliente.getIsNew()||!anticipocliente.gettipo_ingreso().equals(anticipocliente.getAnticipoClienteOriginal().gettipo_ingreso()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(anticipocliente.getAnticipoClienteOriginal().gettipo_ingreso()!=null)
				{
					strValorActual=anticipocliente.getAnticipoClienteOriginal().gettipo_ingreso().toString();
				}
				if(anticipocliente.gettipo_ingreso()!=null)
				{
					strValorNuevo=anticipocliente.gettipo_ingreso().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),AnticipoClienteConstantesFunciones.TIPOINGRESO,strValorActual,strValorNuevo);
			}	
			
			if(anticipocliente.getIsNew()||!anticipocliente.gettipo_descuento().equals(anticipocliente.getAnticipoClienteOriginal().gettipo_descuento()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(anticipocliente.getAnticipoClienteOriginal().gettipo_descuento()!=null)
				{
					strValorActual=anticipocliente.getAnticipoClienteOriginal().gettipo_descuento().toString();
				}
				if(anticipocliente.gettipo_descuento()!=null)
				{
					strValorNuevo=anticipocliente.gettipo_descuento().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),AnticipoClienteConstantesFunciones.TIPODESCUENTO,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void saveAnticipoClienteRelacionesWithConnection(AnticipoCliente anticipocliente) throws Exception {

		if(!anticipocliente.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveAnticipoClienteRelacionesBase(anticipocliente,true);
		}
	}

	public void saveAnticipoClienteRelaciones(AnticipoCliente anticipocliente)throws Exception {

		if(!anticipocliente.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveAnticipoClienteRelacionesBase(anticipocliente,false);
		}
	}

	public void saveAnticipoClienteRelacionesBase(AnticipoCliente anticipocliente,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("AnticipoCliente-saveRelacionesWithConnection");}
	

			this.setAnticipoCliente(anticipocliente);

			if(AnticipoClienteLogicAdditional.validarSaveRelaciones(anticipocliente,this)) {

				AnticipoClienteLogicAdditional.updateRelacionesToSave(anticipocliente,this);

				if((anticipocliente.getIsNew()||anticipocliente.getIsChanged())&&!anticipocliente.getIsDeleted()) {
					this.saveAnticipoCliente();
					this.saveAnticipoClienteRelacionesDetalles();

				} else if(anticipocliente.getIsDeleted()) {
					this.saveAnticipoClienteRelacionesDetalles();
					this.saveAnticipoCliente();
				}

				AnticipoClienteLogicAdditional.updateRelacionesToSaveAfter(anticipocliente,this);

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
	
	
	private void saveAnticipoClienteRelacionesDetalles()throws Exception {
		try {
	

		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfAnticipoCliente(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=AnticipoClienteConstantesFunciones.getClassesForeignKeysOfAnticipoCliente(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfAnticipoCliente(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=AnticipoClienteConstantesFunciones.getClassesRelationshipsOfAnticipoCliente(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}
