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
import com.bydan.erp.cartera.util.NegocioClienteConstantesFunciones;
import com.bydan.erp.cartera.util.NegocioClienteParameterReturnGeneral;
//import com.bydan.erp.cartera.util.NegocioClienteParameterGeneral;
import com.bydan.erp.cartera.business.entity.NegocioCliente;
import com.bydan.erp.cartera.business.logic.NegocioClienteLogicAdditional;
import com.bydan.erp.cartera.business.dataaccess.*;
import com.bydan.erp.cartera.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.logic.*;


import com.bydan.erp.seguridad.util.*;


import com.bydan.erp.seguridad.business.dataaccess.*;








@SuppressWarnings("unused")
public class NegocioClienteLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(NegocioClienteLogic.class);
	
	protected NegocioClienteDataAccess negocioclienteDataAccess; 	
	protected NegocioCliente negociocliente;
	protected List<NegocioCliente> negocioclientes;
	protected Object negocioclienteObject;	
	protected List<Object> negocioclientesObject;
	
	public static ClassValidator<NegocioCliente> negocioclienteValidator = new ClassValidator<NegocioCliente>(NegocioCliente.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected NegocioClienteLogicAdditional negocioclienteLogicAdditional=null;
	
	public NegocioClienteLogicAdditional getNegocioClienteLogicAdditional() {
		return this.negocioclienteLogicAdditional;
	}
	
	public void setNegocioClienteLogicAdditional(NegocioClienteLogicAdditional negocioclienteLogicAdditional) {
		try {
			this.negocioclienteLogicAdditional=negocioclienteLogicAdditional;
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
	
	
	
	
	public  NegocioClienteLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.negocioclienteDataAccess = new NegocioClienteDataAccess();
			
			this.negocioclientes= new ArrayList<NegocioCliente>();
			this.negociocliente= new NegocioCliente();
			
			this.negocioclienteObject=new Object();
			this.negocioclientesObject=new ArrayList<Object>();
				
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
			
			this.negocioclienteDataAccess.setConnexionType(this.connexionType);
			this.negocioclienteDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  NegocioClienteLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.negocioclienteDataAccess = new NegocioClienteDataAccess();
			this.negocioclientes= new ArrayList<NegocioCliente>();
			this.negociocliente= new NegocioCliente();
			this.negocioclienteObject=new Object();
			this.negocioclientesObject=new ArrayList<Object>();
			
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
			
			this.negocioclienteDataAccess.setConnexionType(this.connexionType);
			this.negocioclienteDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public NegocioCliente getNegocioCliente() throws Exception {	
		NegocioClienteLogicAdditional.checkNegocioClienteToGet(negociocliente,this.datosCliente,this.arrDatoGeneral);
		NegocioClienteLogicAdditional.updateNegocioClienteToGet(negociocliente,this.arrDatoGeneral);
		
		return negociocliente;
	}
		
	public void setNegocioCliente(NegocioCliente newNegocioCliente) {
		this.negociocliente = newNegocioCliente;
	}
	
	public NegocioClienteDataAccess getNegocioClienteDataAccess() {
		return negocioclienteDataAccess;
	}
	
	public void setNegocioClienteDataAccess(NegocioClienteDataAccess newnegocioclienteDataAccess) {
		this.negocioclienteDataAccess = newnegocioclienteDataAccess;
	}
	
	public List<NegocioCliente> getNegocioClientes() throws Exception {		
		this.quitarNegocioClientesNulos();
		
		NegocioClienteLogicAdditional.checkNegocioClienteToGets(negocioclientes,this.datosCliente,this.arrDatoGeneral);
		
		for (NegocioCliente negocioclienteLocal: negocioclientes ) {
			NegocioClienteLogicAdditional.updateNegocioClienteToGet(negocioclienteLocal,this.arrDatoGeneral);
		}
		
		return negocioclientes;
	}
	
	public void setNegocioClientes(List<NegocioCliente> newNegocioClientes) {
		this.negocioclientes = newNegocioClientes;
	}
	
	public Object getNegocioClienteObject() {	
		this.negocioclienteObject=this.negocioclienteDataAccess.getEntityObject();
		return this.negocioclienteObject;
	}
		
	public void setNegocioClienteObject(Object newNegocioClienteObject) {
		this.negocioclienteObject = newNegocioClienteObject;
	}
	
	public List<Object> getNegocioClientesObject() {		
		this.negocioclientesObject=this.negocioclienteDataAccess.getEntitiesObject();
		return this.negocioclientesObject;
	}
		
	public void setNegocioClientesObject(List<Object> newNegocioClientesObject) {
		this.negocioclientesObject = newNegocioClientesObject;
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
		
		if(this.negocioclienteDataAccess!=null) {
			this.negocioclienteDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,NegocioCliente.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			negocioclienteDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			negocioclienteDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		negociocliente = new  NegocioCliente();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,NegocioCliente.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			negociocliente=negocioclienteDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.negociocliente,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				NegocioClienteConstantesFunciones.refrescarForeignKeysDescripcionesNegocioCliente(this.negociocliente);
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
		negociocliente = new  NegocioCliente();
		  		  
        try {
			
			negociocliente=negocioclienteDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.negociocliente,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				NegocioClienteConstantesFunciones.refrescarForeignKeysDescripcionesNegocioCliente(this.negociocliente);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		negociocliente = new  NegocioCliente();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,NegocioCliente.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			negociocliente=negocioclienteDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.negociocliente,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				NegocioClienteConstantesFunciones.refrescarForeignKeysDescripcionesNegocioCliente(this.negociocliente);
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
		negociocliente = new  NegocioCliente();
		  		  
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
		negociocliente = new  NegocioCliente();
		  		  
        try {
			
			negociocliente=negocioclienteDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.negociocliente,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				NegocioClienteConstantesFunciones.refrescarForeignKeysDescripcionesNegocioCliente(this.negociocliente);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		negociocliente = new  NegocioCliente();
		  		  
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
		negociocliente = new  NegocioCliente();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,NegocioCliente.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =negocioclienteDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		negociocliente = new  NegocioCliente();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=negocioclienteDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		negociocliente = new  NegocioCliente();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,NegocioCliente.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =negocioclienteDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		negociocliente = new  NegocioCliente();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=negocioclienteDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		negociocliente = new  NegocioCliente();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,NegocioCliente.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =negocioclienteDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		negociocliente = new  NegocioCliente();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=negocioclienteDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		negocioclientes = new  ArrayList<NegocioCliente>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,NegocioCliente.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			NegocioClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			negocioclientes=negocioclienteDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarNegocioCliente(negocioclientes);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				NegocioClienteConstantesFunciones.refrescarForeignKeysDescripcionesNegocioCliente(this.negocioclientes);
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
		negocioclientes = new  ArrayList<NegocioCliente>();
		  		  
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
		negocioclientes = new  ArrayList<NegocioCliente>();
		  		  
        try {			
			NegocioClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			negocioclientes=negocioclienteDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarNegocioCliente(negocioclientes);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				NegocioClienteConstantesFunciones.refrescarForeignKeysDescripcionesNegocioCliente(this.negocioclientes);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		negocioclientes = new  ArrayList<NegocioCliente>();
		  		  
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
		negocioclientes = new  ArrayList<NegocioCliente>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,NegocioCliente.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			NegocioClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			negocioclientes=negocioclienteDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarNegocioCliente(negocioclientes);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				NegocioClienteConstantesFunciones.refrescarForeignKeysDescripcionesNegocioCliente(this.negocioclientes);
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
		negocioclientes = new  ArrayList<NegocioCliente>();
		  		  
        try {
			NegocioClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			negocioclientes=negocioclienteDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarNegocioCliente(negocioclientes);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				NegocioClienteConstantesFunciones.refrescarForeignKeysDescripcionesNegocioCliente(this.negocioclientes);
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
		negocioclientes = new  ArrayList<NegocioCliente>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,NegocioCliente.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			NegocioClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			negocioclientes=negocioclienteDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarNegocioCliente(negocioclientes);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				NegocioClienteConstantesFunciones.refrescarForeignKeysDescripcionesNegocioCliente(this.negocioclientes);
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
		negocioclientes = new  ArrayList<NegocioCliente>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			NegocioClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			negocioclientes=negocioclienteDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarNegocioCliente(negocioclientes);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				NegocioClienteConstantesFunciones.refrescarForeignKeysDescripcionesNegocioCliente(this.negocioclientes);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		negociocliente = new  NegocioCliente();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,NegocioCliente.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			NegocioClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			negociocliente=negocioclienteDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarNegocioCliente(negociocliente);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				NegocioClienteConstantesFunciones.refrescarForeignKeysDescripcionesNegocioCliente(this.negociocliente);
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
		negociocliente = new  NegocioCliente();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			NegocioClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			negociocliente=negocioclienteDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarNegocioCliente(negociocliente);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				NegocioClienteConstantesFunciones.refrescarForeignKeysDescripcionesNegocioCliente(this.negociocliente);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		negocioclientes = new  ArrayList<NegocioCliente>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,NegocioCliente.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			NegocioClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			negocioclientes=negocioclienteDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarNegocioCliente(negocioclientes);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				NegocioClienteConstantesFunciones.refrescarForeignKeysDescripcionesNegocioCliente(this.negocioclientes);
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
		negocioclientes = new  ArrayList<NegocioCliente>();
		  		  
        try {
			NegocioClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			negocioclientes=negocioclienteDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarNegocioCliente(negocioclientes);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				NegocioClienteConstantesFunciones.refrescarForeignKeysDescripcionesNegocioCliente(this.negocioclientes);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosNegocioClientesWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		negocioclientes = new  ArrayList<NegocioCliente>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,NegocioCliente.class.getSimpleName()+"-getTodosNegocioClientesWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			NegocioClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			negocioclientes=negocioclienteDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarNegocioCliente(negocioclientes);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				NegocioClienteConstantesFunciones.refrescarForeignKeysDescripcionesNegocioCliente(this.negocioclientes);
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
	
	public  void  getTodosNegocioClientes(String sFinalQuery,Pagination pagination)throws Exception {
		negocioclientes = new  ArrayList<NegocioCliente>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			NegocioClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			negocioclientes=negocioclienteDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarNegocioCliente(negocioclientes);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				NegocioClienteConstantesFunciones.refrescarForeignKeysDescripcionesNegocioCliente(this.negocioclientes);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarNegocioCliente(NegocioCliente negociocliente) throws Exception {
		Boolean estaValidado=false;
		
		if(negociocliente.getIsNew() || negociocliente.getIsChanged()) { 
			this.invalidValues = negocioclienteValidator.getInvalidValues(negociocliente);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(negociocliente);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarNegocioCliente(List<NegocioCliente> NegocioClientes) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(NegocioCliente negocioclienteLocal:negocioclientes) {				
			estaValidadoObjeto=this.validarGuardarNegocioCliente(negocioclienteLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarNegocioCliente(List<NegocioCliente> NegocioClientes) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarNegocioCliente(negocioclientes)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarNegocioCliente(NegocioCliente NegocioCliente) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarNegocioCliente(negociocliente)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(NegocioCliente negociocliente) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+negociocliente.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=NegocioClienteConstantesFunciones.getNegocioClienteLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"negociocliente","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(NegocioClienteConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(NegocioClienteConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveNegocioClienteWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,NegocioCliente.class.getSimpleName()+"-saveNegocioClienteWithConnection");connexion.begin();			
			
			NegocioClienteLogicAdditional.checkNegocioClienteToSave(this.negociocliente,this.datosCliente,connexion,this.arrDatoGeneral);
			
			NegocioClienteLogicAdditional.updateNegocioClienteToSave(this.negociocliente,this.arrDatoGeneral);
			
			NegocioClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.negociocliente,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowNegocioCliente();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarNegocioCliente(this.negociocliente)) {
				NegocioClienteDataAccess.save(this.negociocliente, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.negociocliente,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			NegocioClienteLogicAdditional.checkNegocioClienteToSaveAfter(this.negociocliente,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowNegocioCliente();
			
			connexion.commit();			
			
			if(this.negociocliente.getIsDeleted()) {
				this.negociocliente=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveNegocioCliente()throws Exception {	
		try {	
			
			NegocioClienteLogicAdditional.checkNegocioClienteToSave(this.negociocliente,this.datosCliente,connexion,this.arrDatoGeneral);
			
			NegocioClienteLogicAdditional.updateNegocioClienteToSave(this.negociocliente,this.arrDatoGeneral);
			
			NegocioClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.negociocliente,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarNegocioCliente(this.negociocliente)) {			
				NegocioClienteDataAccess.save(this.negociocliente, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.negociocliente,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			NegocioClienteLogicAdditional.checkNegocioClienteToSaveAfter(this.negociocliente,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.negociocliente.getIsDeleted()) {
				this.negociocliente=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveNegocioClientesWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,NegocioCliente.class.getSimpleName()+"-saveNegocioClientesWithConnection");connexion.begin();			
			
			NegocioClienteLogicAdditional.checkNegocioClienteToSaves(negocioclientes,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowNegocioClientes();
			
			Boolean validadoTodosNegocioCliente=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(NegocioCliente negocioclienteLocal:negocioclientes) {		
				if(negocioclienteLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				NegocioClienteLogicAdditional.updateNegocioClienteToSave(negocioclienteLocal,this.arrDatoGeneral);
	        	
				NegocioClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),negocioclienteLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarNegocioCliente(negocioclienteLocal)) {
					NegocioClienteDataAccess.save(negocioclienteLocal, connexion);				
				} else {
					validadoTodosNegocioCliente=false;
				}
			}
			
			if(!validadoTodosNegocioCliente) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			NegocioClienteLogicAdditional.checkNegocioClienteToSavesAfter(negocioclientes,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowNegocioClientes();
			
			connexion.commit();		
			
			this.quitarNegocioClientesEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveNegocioClientes()throws Exception {				
		 try {	
			NegocioClienteLogicAdditional.checkNegocioClienteToSaves(negocioclientes,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosNegocioCliente=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(NegocioCliente negocioclienteLocal:negocioclientes) {				
				if(negocioclienteLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				NegocioClienteLogicAdditional.updateNegocioClienteToSave(negocioclienteLocal,this.arrDatoGeneral);
	        	
				NegocioClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),negocioclienteLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarNegocioCliente(negocioclienteLocal)) {				
					NegocioClienteDataAccess.save(negocioclienteLocal, connexion);				
				} else {
					validadoTodosNegocioCliente=false;
				}
			}
			
			if(!validadoTodosNegocioCliente) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			NegocioClienteLogicAdditional.checkNegocioClienteToSavesAfter(negocioclientes,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarNegocioClientesEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public NegocioClienteParameterReturnGeneral procesarAccionNegocioClientes(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<NegocioCliente> negocioclientes,NegocioClienteParameterReturnGeneral negocioclienteParameterGeneral)throws Exception {
		 try {	
			NegocioClienteParameterReturnGeneral negocioclienteReturnGeneral=new NegocioClienteParameterReturnGeneral();
	
			NegocioClienteLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,negocioclientes,negocioclienteParameterGeneral,negocioclienteReturnGeneral);
			
			return negocioclienteReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public NegocioClienteParameterReturnGeneral procesarAccionNegocioClientesWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<NegocioCliente> negocioclientes,NegocioClienteParameterReturnGeneral negocioclienteParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,NegocioCliente.class.getSimpleName()+"-procesarAccionNegocioClientesWithConnection");connexion.begin();			
			
			NegocioClienteParameterReturnGeneral negocioclienteReturnGeneral=new NegocioClienteParameterReturnGeneral();
	
			NegocioClienteLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,negocioclientes,negocioclienteParameterGeneral,negocioclienteReturnGeneral);
			
			this.connexion.commit();
			
			return negocioclienteReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public NegocioClienteParameterReturnGeneral procesarEventosNegocioClientes(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<NegocioCliente> negocioclientes,NegocioCliente negociocliente,NegocioClienteParameterReturnGeneral negocioclienteParameterGeneral,Boolean isEsNuevoNegocioCliente,ArrayList<Classe> clases)throws Exception {
		 try {	
			NegocioClienteParameterReturnGeneral negocioclienteReturnGeneral=new NegocioClienteParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				negocioclienteReturnGeneral.setConRecargarPropiedades(true);
			}
			
			NegocioClienteLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,negocioclientes,negociocliente,negocioclienteParameterGeneral,negocioclienteReturnGeneral,isEsNuevoNegocioCliente,clases);
			
			return negocioclienteReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public NegocioClienteParameterReturnGeneral procesarEventosNegocioClientesWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<NegocioCliente> negocioclientes,NegocioCliente negociocliente,NegocioClienteParameterReturnGeneral negocioclienteParameterGeneral,Boolean isEsNuevoNegocioCliente,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,NegocioCliente.class.getSimpleName()+"-procesarEventosNegocioClientesWithConnection");connexion.begin();			
			
			NegocioClienteParameterReturnGeneral negocioclienteReturnGeneral=new NegocioClienteParameterReturnGeneral();
	
			negocioclienteReturnGeneral.setNegocioCliente(negociocliente);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				negocioclienteReturnGeneral.setConRecargarPropiedades(true);
			}
			
			NegocioClienteLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,negocioclientes,negociocliente,negocioclienteParameterGeneral,negocioclienteReturnGeneral,isEsNuevoNegocioCliente,clases);
			
			this.connexion.commit();
			
			return negocioclienteReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public NegocioClienteParameterReturnGeneral procesarImportacionNegocioClientesWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,NegocioClienteParameterReturnGeneral negocioclienteParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,NegocioCliente.class.getSimpleName()+"-procesarImportacionNegocioClientesWithConnection");connexion.begin();			
			
			NegocioClienteParameterReturnGeneral negocioclienteReturnGeneral=new NegocioClienteParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.negocioclientes=new ArrayList<NegocioCliente>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.negociocliente=new NegocioCliente();
				
				
				if(conColumnasBase) {this.negociocliente.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.negociocliente.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.negociocliente.setnombre_quien_se_factura(arrColumnas[iColumn++]);
				this.negociocliente.setfax(arrColumnas[iColumn++]);
				this.negociocliente.setruc(arrColumnas[iColumn++]);
				this.negociocliente.settelefono(arrColumnas[iColumn++]);
				this.negociocliente.setnombre_local(arrColumnas[iColumn++]);
				this.negociocliente.sete_mail(arrColumnas[iColumn++]);
				this.negociocliente.setdireccion(arrColumnas[iColumn++]);
				this.negociocliente.setes_local_propio(Boolean.parseBoolean(arrColumnas[iColumn++]));
				this.negociocliente.setnumero_anios(Integer.parseInt(arrColumnas[iColumn++]));
				this.negociocliente.setnumero_meses(Integer.parseInt(arrColumnas[iColumn++]));
				this.negociocliente.setempleados_fijos(Integer.parseInt(arrColumnas[iColumn++]));
				this.negociocliente.setempleado_temporales(Integer.parseInt(arrColumnas[iColumn++]));
				this.negociocliente.setempleados_total(Integer.parseInt(arrColumnas[iColumn++]));
				this.negociocliente.setporcentaje_ventas_contado(Double.parseDouble(arrColumnas[iColumn++]));
				this.negociocliente.setporcentaje_ventas_credito(Double.parseDouble(arrColumnas[iColumn++]));
				this.negociocliente.setplazo_dias(Integer.parseInt(arrColumnas[iColumn++]));
				this.negociocliente.setnumero_clientes(Integer.parseInt(arrColumnas[iColumn++]));
				this.negociocliente.setmonto_maximo_ventas_mensual(Double.parseDouble(arrColumnas[iColumn++]));
				this.negociocliente.setmonto_minimo_ventas_mensual(Double.parseDouble(arrColumnas[iColumn++]));
				this.negociocliente.setes_enero_alto(Boolean.parseBoolean(arrColumnas[iColumn++]));
				this.negociocliente.setes_febrero_alto(Boolean.parseBoolean(arrColumnas[iColumn++]));
				this.negociocliente.setes_marzo_alto(Boolean.parseBoolean(arrColumnas[iColumn++]));
				this.negociocliente.setes_abril_alto(Boolean.parseBoolean(arrColumnas[iColumn++]));
				this.negociocliente.setes_mayo_alto(Boolean.parseBoolean(arrColumnas[iColumn++]));
				this.negociocliente.setes_junio_alto(Boolean.parseBoolean(arrColumnas[iColumn++]));
				this.negociocliente.setes_julio_alto(Boolean.parseBoolean(arrColumnas[iColumn++]));
				this.negociocliente.setes_agosto_alto(Boolean.parseBoolean(arrColumnas[iColumn++]));
				this.negociocliente.setes_septiembre_alto(Boolean.parseBoolean(arrColumnas[iColumn++]));
				this.negociocliente.setes_octubre_alto(Boolean.parseBoolean(arrColumnas[iColumn++]));
				this.negociocliente.setes_noviembre_alto(Boolean.parseBoolean(arrColumnas[iColumn++]));
				this.negociocliente.setes_diciembre_alto(Boolean.parseBoolean(arrColumnas[iColumn++]));
				this.negociocliente.setes_enero_bajo(Boolean.parseBoolean(arrColumnas[iColumn++]));
				this.negociocliente.setes_febrero_bajo(Boolean.parseBoolean(arrColumnas[iColumn++]));
				this.negociocliente.setes_marzo_bajo(Boolean.parseBoolean(arrColumnas[iColumn++]));
				this.negociocliente.setes_abril_bajo(Boolean.parseBoolean(arrColumnas[iColumn++]));
				this.negociocliente.setes_mayo_bajo(Boolean.parseBoolean(arrColumnas[iColumn++]));
				this.negociocliente.setes_junio_bajo(Boolean.parseBoolean(arrColumnas[iColumn++]));
				this.negociocliente.setes_julio_bajo(Boolean.parseBoolean(arrColumnas[iColumn++]));
				this.negociocliente.setes_agosto_bajo(Boolean.parseBoolean(arrColumnas[iColumn++]));
				this.negociocliente.setes_septiembre_bajo(Boolean.parseBoolean(arrColumnas[iColumn++]));
				this.negociocliente.setes_octubre_bajo(Boolean.parseBoolean(arrColumnas[iColumn++]));
				this.negociocliente.setes_noviembre_bajo(Boolean.parseBoolean(arrColumnas[iColumn++]));
				this.negociocliente.setes_diciembre_bajo(Boolean.parseBoolean(arrColumnas[iColumn++]));
			this.negociocliente.setdescripcion(arrColumnas[iColumn++]);
				
				this.negocioclientes.add(this.negociocliente);
			}
			
			this.saveNegocioClientes();
			
			this.connexion.commit();
			
			negocioclienteReturnGeneral.setConRetornoEstaProcesado(true);
			negocioclienteReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return negocioclienteReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarNegocioClientesEliminados() throws Exception {				
		
		List<NegocioCliente> negocioclientesAux= new ArrayList<NegocioCliente>();
		
		for(NegocioCliente negociocliente:negocioclientes) {
			if(!negociocliente.getIsDeleted()) {
				negocioclientesAux.add(negociocliente);
			}
		}
		
		negocioclientes=negocioclientesAux;
	}
	
	public void quitarNegocioClientesNulos() throws Exception {				
		
		List<NegocioCliente> negocioclientesAux= new ArrayList<NegocioCliente>();
		
		for(NegocioCliente negociocliente : this.negocioclientes) {
			if(negociocliente==null) {
				negocioclientesAux.add(negociocliente);
			}
		}
		
		//this.negocioclientes=negocioclientesAux;
		
		this.negocioclientes.removeAll(negocioclientesAux);
	}
	
	public void getSetVersionRowNegocioClienteWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(negociocliente.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((negociocliente.getIsDeleted() || (negociocliente.getIsChanged()&&!negociocliente.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=negocioclienteDataAccess.getSetVersionRowNegocioCliente(connexion,negociocliente.getId());
				
				if(!negociocliente.getVersionRow().equals(timestamp)) {	
					negociocliente.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				negociocliente.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowNegocioCliente()throws Exception {	
		
		if(negociocliente.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((negociocliente.getIsDeleted() || (negociocliente.getIsChanged()&&!negociocliente.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=negocioclienteDataAccess.getSetVersionRowNegocioCliente(connexion,negociocliente.getId());
			
			try {							
				if(!negociocliente.getVersionRow().equals(timestamp)) {	
					negociocliente.setVersionRow(timestamp);
				}
				
				negociocliente.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowNegocioClientesWithConnection()throws Exception {	
		if(negocioclientes!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(NegocioCliente negocioclienteAux:negocioclientes) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(negocioclienteAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(negocioclienteAux.getIsDeleted() || (negocioclienteAux.getIsChanged()&&!negocioclienteAux.getIsNew())) {
						
						timestamp=negocioclienteDataAccess.getSetVersionRowNegocioCliente(connexion,negocioclienteAux.getId());
						
						if(!negociocliente.getVersionRow().equals(timestamp)) {	
							negocioclienteAux.setVersionRow(timestamp);
						}
								
						negocioclienteAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowNegocioClientes()throws Exception {	
		if(negocioclientes!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(NegocioCliente negocioclienteAux:negocioclientes) {
					if(negocioclienteAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(negocioclienteAux.getIsDeleted() || (negocioclienteAux.getIsChanged()&&!negocioclienteAux.getIsNew())) {
						
						timestamp=negocioclienteDataAccess.getSetVersionRowNegocioCliente(connexion,negocioclienteAux.getId());
						
						if(!negocioclienteAux.getVersionRow().equals(timestamp)) {	
							negocioclienteAux.setVersionRow(timestamp);
						}
						
													
						negocioclienteAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public NegocioClienteParameterReturnGeneral cargarCombosLoteForeignKeyNegocioClienteWithConnection(String finalQueryGlobalEmpresa,String finalQueryGlobalCliente,String finalQueryGlobalTipoUbicacionNegocio) throws Exception {
		NegocioClienteParameterReturnGeneral  negocioclienteReturnGeneral =new NegocioClienteParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,NegocioCliente.class.getSimpleName()+"-cargarCombosLoteForeignKeyNegocioClienteWithConnection");connexion.begin();
			
			negocioclienteReturnGeneral =new NegocioClienteParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			negocioclienteReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Cliente> clientesForeignKey=new ArrayList<Cliente>();
			ClienteLogic clienteLogic=new ClienteLogic();
			clienteLogic.setConnexion(this.connexion);
			clienteLogic.getClienteDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCliente.equals("NONE")) {
				clienteLogic.getTodosClientes(finalQueryGlobalCliente,new Pagination());
				clientesForeignKey=clienteLogic.getClientes();
			}

			negocioclienteReturnGeneral.setclientesForeignKey(clientesForeignKey);


			List<TipoUbicacionNegocio> tipoubicacionnegociosForeignKey=new ArrayList<TipoUbicacionNegocio>();
			TipoUbicacionNegocioLogic tipoubicacionnegocioLogic=new TipoUbicacionNegocioLogic();
			tipoubicacionnegocioLogic.setConnexion(this.connexion);
			tipoubicacionnegocioLogic.getTipoUbicacionNegocioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoUbicacionNegocio.equals("NONE")) {
				tipoubicacionnegocioLogic.getTodosTipoUbicacionNegocios(finalQueryGlobalTipoUbicacionNegocio,new Pagination());
				tipoubicacionnegociosForeignKey=tipoubicacionnegocioLogic.getTipoUbicacionNegocios();
			}

			negocioclienteReturnGeneral.settipoubicacionnegociosForeignKey(tipoubicacionnegociosForeignKey);

			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
		
		return negocioclienteReturnGeneral;
	}
	
	public NegocioClienteParameterReturnGeneral cargarCombosLoteForeignKeyNegocioCliente(String finalQueryGlobalEmpresa,String finalQueryGlobalCliente,String finalQueryGlobalTipoUbicacionNegocio) throws Exception {
		NegocioClienteParameterReturnGeneral  negocioclienteReturnGeneral =new NegocioClienteParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {						
			negocioclienteReturnGeneral =new NegocioClienteParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			negocioclienteReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Cliente> clientesForeignKey=new ArrayList<Cliente>();
			ClienteLogic clienteLogic=new ClienteLogic();
			clienteLogic.setConnexion(this.connexion);
			clienteLogic.getClienteDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCliente.equals("NONE")) {
				clienteLogic.getTodosClientes(finalQueryGlobalCliente,new Pagination());
				clientesForeignKey=clienteLogic.getClientes();
			}

			negocioclienteReturnGeneral.setclientesForeignKey(clientesForeignKey);


			List<TipoUbicacionNegocio> tipoubicacionnegociosForeignKey=new ArrayList<TipoUbicacionNegocio>();
			TipoUbicacionNegocioLogic tipoubicacionnegocioLogic=new TipoUbicacionNegocioLogic();
			tipoubicacionnegocioLogic.setConnexion(this.connexion);
			tipoubicacionnegocioLogic.getTipoUbicacionNegocioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoUbicacionNegocio.equals("NONE")) {
				tipoubicacionnegocioLogic.getTodosTipoUbicacionNegocios(finalQueryGlobalTipoUbicacionNegocio,new Pagination());
				tipoubicacionnegociosForeignKey=tipoubicacionnegocioLogic.getTipoUbicacionNegocios();
			}

			negocioclienteReturnGeneral.settipoubicacionnegociosForeignKey(tipoubicacionnegociosForeignKey);
						
			
		} catch(Exception e) {			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			
		}
		
		return negocioclienteReturnGeneral;
	}
	
	
	public void deepLoad(NegocioCliente negociocliente,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			NegocioClienteLogicAdditional.updateNegocioClienteToGet(negociocliente,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		negociocliente.setEmpresa(negocioclienteDataAccess.getEmpresa(connexion,negociocliente));
		negociocliente.setCliente(negocioclienteDataAccess.getCliente(connexion,negociocliente));
		negociocliente.setTipoUbicacionNegocio(negocioclienteDataAccess.getTipoUbicacionNegocio(connexion,negociocliente));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				negociocliente.setEmpresa(negocioclienteDataAccess.getEmpresa(connexion,negociocliente));
				continue;
			}

			if(clas.clas.equals(Cliente.class)) {
				negociocliente.setCliente(negocioclienteDataAccess.getCliente(connexion,negociocliente));
				continue;
			}

			if(clas.clas.equals(TipoUbicacionNegocio.class)) {
				negociocliente.setTipoUbicacionNegocio(negocioclienteDataAccess.getTipoUbicacionNegocio(connexion,negociocliente));
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
			negociocliente.setEmpresa(negocioclienteDataAccess.getEmpresa(connexion,negociocliente));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Cliente.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			negociocliente.setCliente(negocioclienteDataAccess.getCliente(connexion,negociocliente));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(TipoUbicacionNegocio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			negociocliente.setTipoUbicacionNegocio(negocioclienteDataAccess.getTipoUbicacionNegocio(connexion,negociocliente));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		negociocliente.setEmpresa(negocioclienteDataAccess.getEmpresa(connexion,negociocliente));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(negociocliente.getEmpresa(),isDeep,deepLoadType,clases);
				
		negociocliente.setCliente(negocioclienteDataAccess.getCliente(connexion,negociocliente));
		ClienteLogic clienteLogic= new ClienteLogic(connexion);
		clienteLogic.deepLoad(negociocliente.getCliente(),isDeep,deepLoadType,clases);
				
		negociocliente.setTipoUbicacionNegocio(negocioclienteDataAccess.getTipoUbicacionNegocio(connexion,negociocliente));
		TipoUbicacionNegocioLogic tipoubicacionnegocioLogic= new TipoUbicacionNegocioLogic(connexion);
		tipoubicacionnegocioLogic.deepLoad(negociocliente.getTipoUbicacionNegocio(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				negociocliente.setEmpresa(negocioclienteDataAccess.getEmpresa(connexion,negociocliente));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(negociocliente.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Cliente.class)) {
				negociocliente.setCliente(negocioclienteDataAccess.getCliente(connexion,negociocliente));
				ClienteLogic clienteLogic= new ClienteLogic(connexion);
				clienteLogic.deepLoad(negociocliente.getCliente(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoUbicacionNegocio.class)) {
				negociocliente.setTipoUbicacionNegocio(negocioclienteDataAccess.getTipoUbicacionNegocio(connexion,negociocliente));
				TipoUbicacionNegocioLogic tipoubicacionnegocioLogic= new TipoUbicacionNegocioLogic(connexion);
				tipoubicacionnegocioLogic.deepLoad(negociocliente.getTipoUbicacionNegocio(),isDeep,deepLoadType,clases);				
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
			negociocliente.setEmpresa(negocioclienteDataAccess.getEmpresa(connexion,negociocliente));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(negociocliente.getEmpresa(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Cliente.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			negociocliente.setCliente(negocioclienteDataAccess.getCliente(connexion,negociocliente));
			ClienteLogic clienteLogic= new ClienteLogic(connexion);
			clienteLogic.deepLoad(negociocliente.getCliente(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(TipoUbicacionNegocio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			negociocliente.setTipoUbicacionNegocio(negocioclienteDataAccess.getTipoUbicacionNegocio(connexion,negociocliente));
			TipoUbicacionNegocioLogic tipoubicacionnegocioLogic= new TipoUbicacionNegocioLogic(connexion);
			tipoubicacionnegocioLogic.deepLoad(negociocliente.getTipoUbicacionNegocio(),isDeep,deepLoadType,clases);
				
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(NegocioCliente negociocliente,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			NegocioClienteLogicAdditional.updateNegocioClienteToSave(negociocliente,this.arrDatoGeneral);
			
NegocioClienteDataAccess.save(negociocliente, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(negociocliente.getEmpresa(),connexion);

		ClienteDataAccess.save(negociocliente.getCliente(),connexion);

		TipoUbicacionNegocioDataAccess.save(negociocliente.getTipoUbicacionNegocio(),connexion);
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(negociocliente.getEmpresa(),connexion);
				continue;
			}

			if(clas.clas.equals(Cliente.class)) {
				ClienteDataAccess.save(negociocliente.getCliente(),connexion);
				continue;
			}

			if(clas.clas.equals(TipoUbicacionNegocio.class)) {
				TipoUbicacionNegocioDataAccess.save(negociocliente.getTipoUbicacionNegocio(),connexion);
				continue;
			}

		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(negociocliente.getEmpresa(),connexion);
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(negociocliente.getEmpresa(),isDeep,deepLoadType,clases);
				

		ClienteDataAccess.save(negociocliente.getCliente(),connexion);
		ClienteLogic clienteLogic= new ClienteLogic(connexion);
		clienteLogic.deepLoad(negociocliente.getCliente(),isDeep,deepLoadType,clases);
				

		TipoUbicacionNegocioDataAccess.save(negociocliente.getTipoUbicacionNegocio(),connexion);
		TipoUbicacionNegocioLogic tipoubicacionnegocioLogic= new TipoUbicacionNegocioLogic(connexion);
		tipoubicacionnegocioLogic.deepLoad(negociocliente.getTipoUbicacionNegocio(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(negociocliente.getEmpresa(),connexion);
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepSave(negociocliente.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Cliente.class)) {
				ClienteDataAccess.save(negociocliente.getCliente(),connexion);
				ClienteLogic clienteLogic= new ClienteLogic(connexion);
				clienteLogic.deepSave(negociocliente.getCliente(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoUbicacionNegocio.class)) {
				TipoUbicacionNegocioDataAccess.save(negociocliente.getTipoUbicacionNegocio(),connexion);
				TipoUbicacionNegocioLogic tipoubicacionnegocioLogic= new TipoUbicacionNegocioLogic(connexion);
				tipoubicacionnegocioLogic.deepSave(negociocliente.getTipoUbicacionNegocio(),isDeep,deepLoadType,clases);				
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
			this.getNewConnexionToDeep(NegocioCliente.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(negociocliente,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				NegocioClienteConstantesFunciones.refrescarForeignKeysDescripcionesNegocioCliente(negociocliente);
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
			this.deepLoad(this.negociocliente,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				NegocioClienteConstantesFunciones.refrescarForeignKeysDescripcionesNegocioCliente(this.negociocliente);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(NegocioCliente.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(negocioclientes!=null) {
				for(NegocioCliente negociocliente:negocioclientes) {
					this.deepLoad(negociocliente,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					NegocioClienteConstantesFunciones.refrescarForeignKeysDescripcionesNegocioCliente(negocioclientes);
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
			if(negocioclientes!=null) {
				for(NegocioCliente negociocliente:negocioclientes) {
					this.deepLoad(negociocliente,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					NegocioClienteConstantesFunciones.refrescarForeignKeysDescripcionesNegocioCliente(negocioclientes);
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
			this.getNewConnexionToDeep(NegocioCliente.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(negociocliente,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(NegocioCliente.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(negocioclientes!=null) {
				for(NegocioCliente negociocliente:negocioclientes) {
					this.deepSave(negociocliente,isDeep,deepLoadType,clases);
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
			if(negocioclientes!=null) {
				for(NegocioCliente negociocliente:negocioclientes) {
					this.deepSave(negociocliente,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getNegocioClientesFK_IdClienteWithConnection(String sFinalQuery,Pagination pagination,Long id_cliente)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,NegocioCliente.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCliente= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCliente.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cliente,NegocioClienteConstantesFunciones.IDCLIENTE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCliente);

			NegocioClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCliente","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			negocioclientes=negocioclienteDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				NegocioClienteConstantesFunciones.refrescarForeignKeysDescripcionesNegocioCliente(this.negocioclientes);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getNegocioClientesFK_IdCliente(String sFinalQuery,Pagination pagination,Long id_cliente)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCliente= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCliente.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cliente,NegocioClienteConstantesFunciones.IDCLIENTE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCliente);

			NegocioClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCliente","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			negocioclientes=negocioclienteDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				NegocioClienteConstantesFunciones.refrescarForeignKeysDescripcionesNegocioCliente(this.negocioclientes);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getNegocioClientesFK_IdEmpresaWithConnection(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,NegocioCliente.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,NegocioClienteConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			NegocioClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			negocioclientes=negocioclienteDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				NegocioClienteConstantesFunciones.refrescarForeignKeysDescripcionesNegocioCliente(this.negocioclientes);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getNegocioClientesFK_IdEmpresa(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,NegocioClienteConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			NegocioClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			negocioclientes=negocioclienteDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				NegocioClienteConstantesFunciones.refrescarForeignKeysDescripcionesNegocioCliente(this.negocioclientes);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getNegocioClientesFK_IdTipoUbicacionNegocioWithConnection(String sFinalQuery,Pagination pagination,Long id_tipo_ubicacion_negocio)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,NegocioCliente.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoUbicacionNegocio= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoUbicacionNegocio.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_ubicacion_negocio,NegocioClienteConstantesFunciones.IDTIPOUBICACIONNEGOCIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoUbicacionNegocio);

			NegocioClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoUbicacionNegocio","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			negocioclientes=negocioclienteDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				NegocioClienteConstantesFunciones.refrescarForeignKeysDescripcionesNegocioCliente(this.negocioclientes);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getNegocioClientesFK_IdTipoUbicacionNegocio(String sFinalQuery,Pagination pagination,Long id_tipo_ubicacion_negocio)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoUbicacionNegocio= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoUbicacionNegocio.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_ubicacion_negocio,NegocioClienteConstantesFunciones.IDTIPOUBICACIONNEGOCIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoUbicacionNegocio);

			NegocioClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoUbicacionNegocio","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			negocioclientes=negocioclienteDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				NegocioClienteConstantesFunciones.refrescarForeignKeysDescripcionesNegocioCliente(this.negocioclientes);
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
			if(NegocioClienteConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,NegocioClienteDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,NegocioCliente negociocliente,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(NegocioClienteConstantesFunciones.ISCONAUDITORIA) {
				if(negociocliente.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,NegocioClienteDataAccess.TABLENAME, negociocliente.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(NegocioClienteConstantesFunciones.ISCONAUDITORIADETALLE) {
						////NegocioClienteLogic.registrarAuditoriaDetallesNegocioCliente(connexion,negociocliente,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(negociocliente.getIsDeleted()) {
					/*if(!negociocliente.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,NegocioClienteDataAccess.TABLENAME, negociocliente.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////NegocioClienteLogic.registrarAuditoriaDetallesNegocioCliente(connexion,negociocliente,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,NegocioClienteDataAccess.TABLENAME, negociocliente.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(negociocliente.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,NegocioClienteDataAccess.TABLENAME, negociocliente.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(NegocioClienteConstantesFunciones.ISCONAUDITORIADETALLE) {
						////NegocioClienteLogic.registrarAuditoriaDetallesNegocioCliente(connexion,negociocliente,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesNegocioCliente(Connexion connexion,NegocioCliente negociocliente)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(negociocliente.getIsNew()||!negociocliente.getid_empresa().equals(negociocliente.getNegocioClienteOriginal().getid_empresa()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(negociocliente.getNegocioClienteOriginal().getid_empresa()!=null)
				{
					strValorActual=negociocliente.getNegocioClienteOriginal().getid_empresa().toString();
				}
				if(negociocliente.getid_empresa()!=null)
				{
					strValorNuevo=negociocliente.getid_empresa().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),NegocioClienteConstantesFunciones.IDEMPRESA,strValorActual,strValorNuevo);
			}	
			
			if(negociocliente.getIsNew()||!negociocliente.getid_cliente().equals(negociocliente.getNegocioClienteOriginal().getid_cliente()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(negociocliente.getNegocioClienteOriginal().getid_cliente()!=null)
				{
					strValorActual=negociocliente.getNegocioClienteOriginal().getid_cliente().toString();
				}
				if(negociocliente.getid_cliente()!=null)
				{
					strValorNuevo=negociocliente.getid_cliente().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),NegocioClienteConstantesFunciones.IDCLIENTE,strValorActual,strValorNuevo);
			}	
			
			if(negociocliente.getIsNew()||!negociocliente.getnombre_quien_se_factura().equals(negociocliente.getNegocioClienteOriginal().getnombre_quien_se_factura()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(negociocliente.getNegocioClienteOriginal().getnombre_quien_se_factura()!=null)
				{
					strValorActual=negociocliente.getNegocioClienteOriginal().getnombre_quien_se_factura();
				}
				if(negociocliente.getnombre_quien_se_factura()!=null)
				{
					strValorNuevo=negociocliente.getnombre_quien_se_factura() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),NegocioClienteConstantesFunciones.NOMBREQUIENSEFACTURA,strValorActual,strValorNuevo);
			}	
			
			if(negociocliente.getIsNew()||!negociocliente.getfax().equals(negociocliente.getNegocioClienteOriginal().getfax()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(negociocliente.getNegocioClienteOriginal().getfax()!=null)
				{
					strValorActual=negociocliente.getNegocioClienteOriginal().getfax();
				}
				if(negociocliente.getfax()!=null)
				{
					strValorNuevo=negociocliente.getfax() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),NegocioClienteConstantesFunciones.FAX,strValorActual,strValorNuevo);
			}	
			
			if(negociocliente.getIsNew()||!negociocliente.getruc().equals(negociocliente.getNegocioClienteOriginal().getruc()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(negociocliente.getNegocioClienteOriginal().getruc()!=null)
				{
					strValorActual=negociocliente.getNegocioClienteOriginal().getruc();
				}
				if(negociocliente.getruc()!=null)
				{
					strValorNuevo=negociocliente.getruc() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),NegocioClienteConstantesFunciones.RUC,strValorActual,strValorNuevo);
			}	
			
			if(negociocliente.getIsNew()||!negociocliente.gettelefono().equals(negociocliente.getNegocioClienteOriginal().gettelefono()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(negociocliente.getNegocioClienteOriginal().gettelefono()!=null)
				{
					strValorActual=negociocliente.getNegocioClienteOriginal().gettelefono();
				}
				if(negociocliente.gettelefono()!=null)
				{
					strValorNuevo=negociocliente.gettelefono() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),NegocioClienteConstantesFunciones.TELEFONO,strValorActual,strValorNuevo);
			}	
			
			if(negociocliente.getIsNew()||!negociocliente.getnombre_local().equals(negociocliente.getNegocioClienteOriginal().getnombre_local()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(negociocliente.getNegocioClienteOriginal().getnombre_local()!=null)
				{
					strValorActual=negociocliente.getNegocioClienteOriginal().getnombre_local();
				}
				if(negociocliente.getnombre_local()!=null)
				{
					strValorNuevo=negociocliente.getnombre_local() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),NegocioClienteConstantesFunciones.NOMBRELOCAL,strValorActual,strValorNuevo);
			}	
			
			if(negociocliente.getIsNew()||!negociocliente.gete_mail().equals(negociocliente.getNegocioClienteOriginal().gete_mail()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(negociocliente.getNegocioClienteOriginal().gete_mail()!=null)
				{
					strValorActual=negociocliente.getNegocioClienteOriginal().gete_mail();
				}
				if(negociocliente.gete_mail()!=null)
				{
					strValorNuevo=negociocliente.gete_mail() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),NegocioClienteConstantesFunciones.EMAIL,strValorActual,strValorNuevo);
			}	
			
			if(negociocliente.getIsNew()||!negociocliente.getdireccion().equals(negociocliente.getNegocioClienteOriginal().getdireccion()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(negociocliente.getNegocioClienteOriginal().getdireccion()!=null)
				{
					strValorActual=negociocliente.getNegocioClienteOriginal().getdireccion();
				}
				if(negociocliente.getdireccion()!=null)
				{
					strValorNuevo=negociocliente.getdireccion() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),NegocioClienteConstantesFunciones.DIRECCION,strValorActual,strValorNuevo);
			}	
			
			if(negociocliente.getIsNew()||!negociocliente.getes_local_propio().equals(negociocliente.getNegocioClienteOriginal().getes_local_propio()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(negociocliente.getNegocioClienteOriginal().getes_local_propio()!=null)
				{
					strValorActual=negociocliente.getNegocioClienteOriginal().getes_local_propio().toString();
				}
				if(negociocliente.getes_local_propio()!=null)
				{
					strValorNuevo=negociocliente.getes_local_propio().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),NegocioClienteConstantesFunciones.ESLOCALPROPIO,strValorActual,strValorNuevo);
			}	
			
			if(negociocliente.getIsNew()||!negociocliente.getnumero_anios().equals(negociocliente.getNegocioClienteOriginal().getnumero_anios()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(negociocliente.getNegocioClienteOriginal().getnumero_anios()!=null)
				{
					strValorActual=negociocliente.getNegocioClienteOriginal().getnumero_anios().toString();
				}
				if(negociocliente.getnumero_anios()!=null)
				{
					strValorNuevo=negociocliente.getnumero_anios().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),NegocioClienteConstantesFunciones.NUMEROANIOS,strValorActual,strValorNuevo);
			}	
			
			if(negociocliente.getIsNew()||!negociocliente.getnumero_meses().equals(negociocliente.getNegocioClienteOriginal().getnumero_meses()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(negociocliente.getNegocioClienteOriginal().getnumero_meses()!=null)
				{
					strValorActual=negociocliente.getNegocioClienteOriginal().getnumero_meses().toString();
				}
				if(negociocliente.getnumero_meses()!=null)
				{
					strValorNuevo=negociocliente.getnumero_meses().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),NegocioClienteConstantesFunciones.NUMEROMESES,strValorActual,strValorNuevo);
			}	
			
			if(negociocliente.getIsNew()||!negociocliente.getid_tipo_ubicacion_negocio().equals(negociocliente.getNegocioClienteOriginal().getid_tipo_ubicacion_negocio()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(negociocliente.getNegocioClienteOriginal().getid_tipo_ubicacion_negocio()!=null)
				{
					strValorActual=negociocliente.getNegocioClienteOriginal().getid_tipo_ubicacion_negocio().toString();
				}
				if(negociocliente.getid_tipo_ubicacion_negocio()!=null)
				{
					strValorNuevo=negociocliente.getid_tipo_ubicacion_negocio().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),NegocioClienteConstantesFunciones.IDTIPOUBICACIONNEGOCIO,strValorActual,strValorNuevo);
			}	
			
			if(negociocliente.getIsNew()||!negociocliente.getempleados_fijos().equals(negociocliente.getNegocioClienteOriginal().getempleados_fijos()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(negociocliente.getNegocioClienteOriginal().getempleados_fijos()!=null)
				{
					strValorActual=negociocliente.getNegocioClienteOriginal().getempleados_fijos().toString();
				}
				if(negociocliente.getempleados_fijos()!=null)
				{
					strValorNuevo=negociocliente.getempleados_fijos().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),NegocioClienteConstantesFunciones.EMPLEADOSFIJOS,strValorActual,strValorNuevo);
			}	
			
			if(negociocliente.getIsNew()||!negociocliente.getempleado_temporales().equals(negociocliente.getNegocioClienteOriginal().getempleado_temporales()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(negociocliente.getNegocioClienteOriginal().getempleado_temporales()!=null)
				{
					strValorActual=negociocliente.getNegocioClienteOriginal().getempleado_temporales().toString();
				}
				if(negociocliente.getempleado_temporales()!=null)
				{
					strValorNuevo=negociocliente.getempleado_temporales().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),NegocioClienteConstantesFunciones.EMPLEADOTEMPORALES,strValorActual,strValorNuevo);
			}	
			
			if(negociocliente.getIsNew()||!negociocliente.getempleados_total().equals(negociocliente.getNegocioClienteOriginal().getempleados_total()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(negociocliente.getNegocioClienteOriginal().getempleados_total()!=null)
				{
					strValorActual=negociocliente.getNegocioClienteOriginal().getempleados_total().toString();
				}
				if(negociocliente.getempleados_total()!=null)
				{
					strValorNuevo=negociocliente.getempleados_total().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),NegocioClienteConstantesFunciones.EMPLEADOSTOTAL,strValorActual,strValorNuevo);
			}	
			
			if(negociocliente.getIsNew()||!negociocliente.getporcentaje_ventas_contado().equals(negociocliente.getNegocioClienteOriginal().getporcentaje_ventas_contado()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(negociocliente.getNegocioClienteOriginal().getporcentaje_ventas_contado()!=null)
				{
					strValorActual=negociocliente.getNegocioClienteOriginal().getporcentaje_ventas_contado().toString();
				}
				if(negociocliente.getporcentaje_ventas_contado()!=null)
				{
					strValorNuevo=negociocliente.getporcentaje_ventas_contado().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),NegocioClienteConstantesFunciones.PORCENTAJEVENTASCONTADO,strValorActual,strValorNuevo);
			}	
			
			if(negociocliente.getIsNew()||!negociocliente.getporcentaje_ventas_credito().equals(negociocliente.getNegocioClienteOriginal().getporcentaje_ventas_credito()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(negociocliente.getNegocioClienteOriginal().getporcentaje_ventas_credito()!=null)
				{
					strValorActual=negociocliente.getNegocioClienteOriginal().getporcentaje_ventas_credito().toString();
				}
				if(negociocliente.getporcentaje_ventas_credito()!=null)
				{
					strValorNuevo=negociocliente.getporcentaje_ventas_credito().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),NegocioClienteConstantesFunciones.PORCENTAJEVENTASCREDITO,strValorActual,strValorNuevo);
			}	
			
			if(negociocliente.getIsNew()||!negociocliente.getplazo_dias().equals(negociocliente.getNegocioClienteOriginal().getplazo_dias()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(negociocliente.getNegocioClienteOriginal().getplazo_dias()!=null)
				{
					strValorActual=negociocliente.getNegocioClienteOriginal().getplazo_dias().toString();
				}
				if(negociocliente.getplazo_dias()!=null)
				{
					strValorNuevo=negociocliente.getplazo_dias().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),NegocioClienteConstantesFunciones.PLAZODIAS,strValorActual,strValorNuevo);
			}	
			
			if(negociocliente.getIsNew()||!negociocliente.getnumero_clientes().equals(negociocliente.getNegocioClienteOriginal().getnumero_clientes()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(negociocliente.getNegocioClienteOriginal().getnumero_clientes()!=null)
				{
					strValorActual=negociocliente.getNegocioClienteOriginal().getnumero_clientes().toString();
				}
				if(negociocliente.getnumero_clientes()!=null)
				{
					strValorNuevo=negociocliente.getnumero_clientes().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),NegocioClienteConstantesFunciones.NUMEROCLIENTES,strValorActual,strValorNuevo);
			}	
			
			if(negociocliente.getIsNew()||!negociocliente.getmonto_maximo_ventas_mensual().equals(negociocliente.getNegocioClienteOriginal().getmonto_maximo_ventas_mensual()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(negociocliente.getNegocioClienteOriginal().getmonto_maximo_ventas_mensual()!=null)
				{
					strValorActual=negociocliente.getNegocioClienteOriginal().getmonto_maximo_ventas_mensual().toString();
				}
				if(negociocliente.getmonto_maximo_ventas_mensual()!=null)
				{
					strValorNuevo=negociocliente.getmonto_maximo_ventas_mensual().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),NegocioClienteConstantesFunciones.MONTOMAXIMOVENTASMENSUAL,strValorActual,strValorNuevo);
			}	
			
			if(negociocliente.getIsNew()||!negociocliente.getmonto_minimo_ventas_mensual().equals(negociocliente.getNegocioClienteOriginal().getmonto_minimo_ventas_mensual()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(negociocliente.getNegocioClienteOriginal().getmonto_minimo_ventas_mensual()!=null)
				{
					strValorActual=negociocliente.getNegocioClienteOriginal().getmonto_minimo_ventas_mensual().toString();
				}
				if(negociocliente.getmonto_minimo_ventas_mensual()!=null)
				{
					strValorNuevo=negociocliente.getmonto_minimo_ventas_mensual().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),NegocioClienteConstantesFunciones.MONTOMINIMOVENTASMENSUAL,strValorActual,strValorNuevo);
			}	
			
			if(negociocliente.getIsNew()||!negociocliente.getes_enero_alto().equals(negociocliente.getNegocioClienteOriginal().getes_enero_alto()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(negociocliente.getNegocioClienteOriginal().getes_enero_alto()!=null)
				{
					strValorActual=negociocliente.getNegocioClienteOriginal().getes_enero_alto().toString();
				}
				if(negociocliente.getes_enero_alto()!=null)
				{
					strValorNuevo=negociocliente.getes_enero_alto().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),NegocioClienteConstantesFunciones.ESENEROALTO,strValorActual,strValorNuevo);
			}	
			
			if(negociocliente.getIsNew()||!negociocliente.getes_febrero_alto().equals(negociocliente.getNegocioClienteOriginal().getes_febrero_alto()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(negociocliente.getNegocioClienteOriginal().getes_febrero_alto()!=null)
				{
					strValorActual=negociocliente.getNegocioClienteOriginal().getes_febrero_alto().toString();
				}
				if(negociocliente.getes_febrero_alto()!=null)
				{
					strValorNuevo=negociocliente.getes_febrero_alto().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),NegocioClienteConstantesFunciones.ESFEBREROALTO,strValorActual,strValorNuevo);
			}	
			
			if(negociocliente.getIsNew()||!negociocliente.getes_marzo_alto().equals(negociocliente.getNegocioClienteOriginal().getes_marzo_alto()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(negociocliente.getNegocioClienteOriginal().getes_marzo_alto()!=null)
				{
					strValorActual=negociocliente.getNegocioClienteOriginal().getes_marzo_alto().toString();
				}
				if(negociocliente.getes_marzo_alto()!=null)
				{
					strValorNuevo=negociocliente.getes_marzo_alto().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),NegocioClienteConstantesFunciones.ESMARZOALTO,strValorActual,strValorNuevo);
			}	
			
			if(negociocliente.getIsNew()||!negociocliente.getes_abril_alto().equals(negociocliente.getNegocioClienteOriginal().getes_abril_alto()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(negociocliente.getNegocioClienteOriginal().getes_abril_alto()!=null)
				{
					strValorActual=negociocliente.getNegocioClienteOriginal().getes_abril_alto().toString();
				}
				if(negociocliente.getes_abril_alto()!=null)
				{
					strValorNuevo=negociocliente.getes_abril_alto().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),NegocioClienteConstantesFunciones.ESABRILALTO,strValorActual,strValorNuevo);
			}	
			
			if(negociocliente.getIsNew()||!negociocliente.getes_mayo_alto().equals(negociocliente.getNegocioClienteOriginal().getes_mayo_alto()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(negociocliente.getNegocioClienteOriginal().getes_mayo_alto()!=null)
				{
					strValorActual=negociocliente.getNegocioClienteOriginal().getes_mayo_alto().toString();
				}
				if(negociocliente.getes_mayo_alto()!=null)
				{
					strValorNuevo=negociocliente.getes_mayo_alto().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),NegocioClienteConstantesFunciones.ESMAYOALTO,strValorActual,strValorNuevo);
			}	
			
			if(negociocliente.getIsNew()||!negociocliente.getes_junio_alto().equals(negociocliente.getNegocioClienteOriginal().getes_junio_alto()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(negociocliente.getNegocioClienteOriginal().getes_junio_alto()!=null)
				{
					strValorActual=negociocliente.getNegocioClienteOriginal().getes_junio_alto().toString();
				}
				if(negociocliente.getes_junio_alto()!=null)
				{
					strValorNuevo=negociocliente.getes_junio_alto().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),NegocioClienteConstantesFunciones.ESJUNIOALTO,strValorActual,strValorNuevo);
			}	
			
			if(negociocliente.getIsNew()||!negociocliente.getes_julio_alto().equals(negociocliente.getNegocioClienteOriginal().getes_julio_alto()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(negociocliente.getNegocioClienteOriginal().getes_julio_alto()!=null)
				{
					strValorActual=negociocliente.getNegocioClienteOriginal().getes_julio_alto().toString();
				}
				if(negociocliente.getes_julio_alto()!=null)
				{
					strValorNuevo=negociocliente.getes_julio_alto().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),NegocioClienteConstantesFunciones.ESJULIOALTO,strValorActual,strValorNuevo);
			}	
			
			if(negociocliente.getIsNew()||!negociocliente.getes_agosto_alto().equals(negociocliente.getNegocioClienteOriginal().getes_agosto_alto()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(negociocliente.getNegocioClienteOriginal().getes_agosto_alto()!=null)
				{
					strValorActual=negociocliente.getNegocioClienteOriginal().getes_agosto_alto().toString();
				}
				if(negociocliente.getes_agosto_alto()!=null)
				{
					strValorNuevo=negociocliente.getes_agosto_alto().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),NegocioClienteConstantesFunciones.ESAGOSTOALTO,strValorActual,strValorNuevo);
			}	
			
			if(negociocliente.getIsNew()||!negociocliente.getes_septiembre_alto().equals(negociocliente.getNegocioClienteOriginal().getes_septiembre_alto()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(negociocliente.getNegocioClienteOriginal().getes_septiembre_alto()!=null)
				{
					strValorActual=negociocliente.getNegocioClienteOriginal().getes_septiembre_alto().toString();
				}
				if(negociocliente.getes_septiembre_alto()!=null)
				{
					strValorNuevo=negociocliente.getes_septiembre_alto().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),NegocioClienteConstantesFunciones.ESSEPTIEMBREALTO,strValorActual,strValorNuevo);
			}	
			
			if(negociocliente.getIsNew()||!negociocliente.getes_octubre_alto().equals(negociocliente.getNegocioClienteOriginal().getes_octubre_alto()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(negociocliente.getNegocioClienteOriginal().getes_octubre_alto()!=null)
				{
					strValorActual=negociocliente.getNegocioClienteOriginal().getes_octubre_alto().toString();
				}
				if(negociocliente.getes_octubre_alto()!=null)
				{
					strValorNuevo=negociocliente.getes_octubre_alto().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),NegocioClienteConstantesFunciones.ESOCTUBREALTO,strValorActual,strValorNuevo);
			}	
			
			if(negociocliente.getIsNew()||!negociocliente.getes_noviembre_alto().equals(negociocliente.getNegocioClienteOriginal().getes_noviembre_alto()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(negociocliente.getNegocioClienteOriginal().getes_noviembre_alto()!=null)
				{
					strValorActual=negociocliente.getNegocioClienteOriginal().getes_noviembre_alto().toString();
				}
				if(negociocliente.getes_noviembre_alto()!=null)
				{
					strValorNuevo=negociocliente.getes_noviembre_alto().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),NegocioClienteConstantesFunciones.ESNOVIEMBREALTO,strValorActual,strValorNuevo);
			}	
			
			if(negociocliente.getIsNew()||!negociocliente.getes_diciembre_alto().equals(negociocliente.getNegocioClienteOriginal().getes_diciembre_alto()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(negociocliente.getNegocioClienteOriginal().getes_diciembre_alto()!=null)
				{
					strValorActual=negociocliente.getNegocioClienteOriginal().getes_diciembre_alto().toString();
				}
				if(negociocliente.getes_diciembre_alto()!=null)
				{
					strValorNuevo=negociocliente.getes_diciembre_alto().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),NegocioClienteConstantesFunciones.ESDICIEMBREALTO,strValorActual,strValorNuevo);
			}	
			
			if(negociocliente.getIsNew()||!negociocliente.getes_enero_bajo().equals(negociocliente.getNegocioClienteOriginal().getes_enero_bajo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(negociocliente.getNegocioClienteOriginal().getes_enero_bajo()!=null)
				{
					strValorActual=negociocliente.getNegocioClienteOriginal().getes_enero_bajo().toString();
				}
				if(negociocliente.getes_enero_bajo()!=null)
				{
					strValorNuevo=negociocliente.getes_enero_bajo().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),NegocioClienteConstantesFunciones.ESENEROBAJO,strValorActual,strValorNuevo);
			}	
			
			if(negociocliente.getIsNew()||!negociocliente.getes_febrero_bajo().equals(negociocliente.getNegocioClienteOriginal().getes_febrero_bajo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(negociocliente.getNegocioClienteOriginal().getes_febrero_bajo()!=null)
				{
					strValorActual=negociocliente.getNegocioClienteOriginal().getes_febrero_bajo().toString();
				}
				if(negociocliente.getes_febrero_bajo()!=null)
				{
					strValorNuevo=negociocliente.getes_febrero_bajo().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),NegocioClienteConstantesFunciones.ESFEBREROBAJO,strValorActual,strValorNuevo);
			}	
			
			if(negociocliente.getIsNew()||!negociocliente.getes_marzo_bajo().equals(negociocliente.getNegocioClienteOriginal().getes_marzo_bajo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(negociocliente.getNegocioClienteOriginal().getes_marzo_bajo()!=null)
				{
					strValorActual=negociocliente.getNegocioClienteOriginal().getes_marzo_bajo().toString();
				}
				if(negociocliente.getes_marzo_bajo()!=null)
				{
					strValorNuevo=negociocliente.getes_marzo_bajo().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),NegocioClienteConstantesFunciones.ESMARZOBAJO,strValorActual,strValorNuevo);
			}	
			
			if(negociocliente.getIsNew()||!negociocliente.getes_abril_bajo().equals(negociocliente.getNegocioClienteOriginal().getes_abril_bajo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(negociocliente.getNegocioClienteOriginal().getes_abril_bajo()!=null)
				{
					strValorActual=negociocliente.getNegocioClienteOriginal().getes_abril_bajo().toString();
				}
				if(negociocliente.getes_abril_bajo()!=null)
				{
					strValorNuevo=negociocliente.getes_abril_bajo().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),NegocioClienteConstantesFunciones.ESABRILBAJO,strValorActual,strValorNuevo);
			}	
			
			if(negociocliente.getIsNew()||!negociocliente.getes_mayo_bajo().equals(negociocliente.getNegocioClienteOriginal().getes_mayo_bajo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(negociocliente.getNegocioClienteOriginal().getes_mayo_bajo()!=null)
				{
					strValorActual=negociocliente.getNegocioClienteOriginal().getes_mayo_bajo().toString();
				}
				if(negociocliente.getes_mayo_bajo()!=null)
				{
					strValorNuevo=negociocliente.getes_mayo_bajo().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),NegocioClienteConstantesFunciones.ESMAYOBAJO,strValorActual,strValorNuevo);
			}	
			
			if(negociocliente.getIsNew()||!negociocliente.getes_junio_bajo().equals(negociocliente.getNegocioClienteOriginal().getes_junio_bajo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(negociocliente.getNegocioClienteOriginal().getes_junio_bajo()!=null)
				{
					strValorActual=negociocliente.getNegocioClienteOriginal().getes_junio_bajo().toString();
				}
				if(negociocliente.getes_junio_bajo()!=null)
				{
					strValorNuevo=negociocliente.getes_junio_bajo().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),NegocioClienteConstantesFunciones.ESJUNIOBAJO,strValorActual,strValorNuevo);
			}	
			
			if(negociocliente.getIsNew()||!negociocliente.getes_julio_bajo().equals(negociocliente.getNegocioClienteOriginal().getes_julio_bajo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(negociocliente.getNegocioClienteOriginal().getes_julio_bajo()!=null)
				{
					strValorActual=negociocliente.getNegocioClienteOriginal().getes_julio_bajo().toString();
				}
				if(negociocliente.getes_julio_bajo()!=null)
				{
					strValorNuevo=negociocliente.getes_julio_bajo().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),NegocioClienteConstantesFunciones.ESJULIOBAJO,strValorActual,strValorNuevo);
			}	
			
			if(negociocliente.getIsNew()||!negociocliente.getes_agosto_bajo().equals(negociocliente.getNegocioClienteOriginal().getes_agosto_bajo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(negociocliente.getNegocioClienteOriginal().getes_agosto_bajo()!=null)
				{
					strValorActual=negociocliente.getNegocioClienteOriginal().getes_agosto_bajo().toString();
				}
				if(negociocliente.getes_agosto_bajo()!=null)
				{
					strValorNuevo=negociocliente.getes_agosto_bajo().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),NegocioClienteConstantesFunciones.ESAGOSTOBAJO,strValorActual,strValorNuevo);
			}	
			
			if(negociocliente.getIsNew()||!negociocliente.getes_septiembre_bajo().equals(negociocliente.getNegocioClienteOriginal().getes_septiembre_bajo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(negociocliente.getNegocioClienteOriginal().getes_septiembre_bajo()!=null)
				{
					strValorActual=negociocliente.getNegocioClienteOriginal().getes_septiembre_bajo().toString();
				}
				if(negociocliente.getes_septiembre_bajo()!=null)
				{
					strValorNuevo=negociocliente.getes_septiembre_bajo().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),NegocioClienteConstantesFunciones.ESSEPTIEMBREBAJO,strValorActual,strValorNuevo);
			}	
			
			if(negociocliente.getIsNew()||!negociocliente.getes_octubre_bajo().equals(negociocliente.getNegocioClienteOriginal().getes_octubre_bajo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(negociocliente.getNegocioClienteOriginal().getes_octubre_bajo()!=null)
				{
					strValorActual=negociocliente.getNegocioClienteOriginal().getes_octubre_bajo().toString();
				}
				if(negociocliente.getes_octubre_bajo()!=null)
				{
					strValorNuevo=negociocliente.getes_octubre_bajo().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),NegocioClienteConstantesFunciones.ESOCTUBREBAJO,strValorActual,strValorNuevo);
			}	
			
			if(negociocliente.getIsNew()||!negociocliente.getes_noviembre_bajo().equals(negociocliente.getNegocioClienteOriginal().getes_noviembre_bajo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(negociocliente.getNegocioClienteOriginal().getes_noviembre_bajo()!=null)
				{
					strValorActual=negociocliente.getNegocioClienteOriginal().getes_noviembre_bajo().toString();
				}
				if(negociocliente.getes_noviembre_bajo()!=null)
				{
					strValorNuevo=negociocliente.getes_noviembre_bajo().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),NegocioClienteConstantesFunciones.ESNOVIEMBREBAJO,strValorActual,strValorNuevo);
			}	
			
			if(negociocliente.getIsNew()||!negociocliente.getes_diciembre_bajo().equals(negociocliente.getNegocioClienteOriginal().getes_diciembre_bajo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(negociocliente.getNegocioClienteOriginal().getes_diciembre_bajo()!=null)
				{
					strValorActual=negociocliente.getNegocioClienteOriginal().getes_diciembre_bajo().toString();
				}
				if(negociocliente.getes_diciembre_bajo()!=null)
				{
					strValorNuevo=negociocliente.getes_diciembre_bajo().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),NegocioClienteConstantesFunciones.ESDICIEMBREBAJO,strValorActual,strValorNuevo);
			}	
			
			if(negociocliente.getIsNew()||!negociocliente.getdescripcion().equals(negociocliente.getNegocioClienteOriginal().getdescripcion()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(negociocliente.getNegocioClienteOriginal().getdescripcion()!=null)
				{
					strValorActual=negociocliente.getNegocioClienteOriginal().getdescripcion();
				}
				if(negociocliente.getdescripcion()!=null)
				{
					strValorNuevo=negociocliente.getdescripcion() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),NegocioClienteConstantesFunciones.DESCRIPCION,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void saveNegocioClienteRelacionesWithConnection(NegocioCliente negociocliente) throws Exception {

		if(!negociocliente.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveNegocioClienteRelacionesBase(negociocliente,true);
		}
	}

	public void saveNegocioClienteRelaciones(NegocioCliente negociocliente)throws Exception {

		if(!negociocliente.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveNegocioClienteRelacionesBase(negociocliente,false);
		}
	}

	public void saveNegocioClienteRelacionesBase(NegocioCliente negociocliente,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("NegocioCliente-saveRelacionesWithConnection");}
	

			this.setNegocioCliente(negociocliente);

			if(NegocioClienteLogicAdditional.validarSaveRelaciones(negociocliente,this)) {

				NegocioClienteLogicAdditional.updateRelacionesToSave(negociocliente,this);

				if((negociocliente.getIsNew()||negociocliente.getIsChanged())&&!negociocliente.getIsDeleted()) {
					this.saveNegocioCliente();
					this.saveNegocioClienteRelacionesDetalles();

				} else if(negociocliente.getIsDeleted()) {
					this.saveNegocioClienteRelacionesDetalles();
					this.saveNegocioCliente();
				}

				NegocioClienteLogicAdditional.updateRelacionesToSaveAfter(negociocliente,this);

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
	
	
	private void saveNegocioClienteRelacionesDetalles()throws Exception {
		try {
	

		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfNegocioCliente(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=NegocioClienteConstantesFunciones.getClassesForeignKeysOfNegocioCliente(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfNegocioCliente(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=NegocioClienteConstantesFunciones.getClassesRelationshipsOfNegocioCliente(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}
