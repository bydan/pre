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
import com.bydan.erp.facturacion.util.ResponsableConstantesFunciones;
import com.bydan.erp.facturacion.util.ResponsableParameterReturnGeneral;
//import com.bydan.erp.facturacion.util.ResponsableParameterGeneral;
import com.bydan.erp.facturacion.business.entity.Responsable;
import com.bydan.erp.facturacion.business.logic.ResponsableLogicAdditional;
import com.bydan.erp.facturacion.business.dataaccess.*;
import com.bydan.erp.facturacion.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.nomina.business.entity.*;
import com.bydan.erp.inventario.business.entity.*;
import com.bydan.erp.comisiones.business.entity.*;
import com.bydan.erp.tesoreria.business.entity.*;


import com.bydan.erp.seguridad.business.logic.*;
import com.bydan.erp.cartera.business.logic.*;
import com.bydan.erp.contabilidad.business.logic.*;
import com.bydan.erp.nomina.business.logic.*;
import com.bydan.erp.inventario.business.logic.*;
import com.bydan.erp.comisiones.business.logic.*;
import com.bydan.erp.tesoreria.business.logic.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.cartera.util.*;
import com.bydan.erp.contabilidad.util.*;
import com.bydan.erp.nomina.util.*;
import com.bydan.erp.inventario.util.*;
import com.bydan.erp.comisiones.util.*;
import com.bydan.erp.tesoreria.util.*;


import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.cartera.business.dataaccess.*;
import com.bydan.erp.contabilidad.business.dataaccess.*;
import com.bydan.erp.nomina.business.dataaccess.*;
import com.bydan.erp.inventario.business.dataaccess.*;
import com.bydan.erp.comisiones.business.dataaccess.*;
import com.bydan.erp.tesoreria.business.dataaccess.*;








@SuppressWarnings("unused")
public class ResponsableLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(ResponsableLogic.class);
	
	protected ResponsableDataAccess responsableDataAccess; 	
	protected Responsable responsable;
	protected List<Responsable> responsables;
	protected Object responsableObject;	
	protected List<Object> responsablesObject;
	
	public static ClassValidator<Responsable> responsableValidator = new ClassValidator<Responsable>(Responsable.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected ResponsableLogicAdditional responsableLogicAdditional=null;
	
	public ResponsableLogicAdditional getResponsableLogicAdditional() {
		return this.responsableLogicAdditional;
	}
	
	public void setResponsableLogicAdditional(ResponsableLogicAdditional responsableLogicAdditional) {
		try {
			this.responsableLogicAdditional=responsableLogicAdditional;
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
	
	
	
	
	public  ResponsableLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.responsableDataAccess = new ResponsableDataAccess();
			
			this.responsables= new ArrayList<Responsable>();
			this.responsable= new Responsable();
			
			this.responsableObject=new Object();
			this.responsablesObject=new ArrayList<Object>();
				
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
			
			this.responsableDataAccess.setConnexionType(this.connexionType);
			this.responsableDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  ResponsableLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.responsableDataAccess = new ResponsableDataAccess();
			this.responsables= new ArrayList<Responsable>();
			this.responsable= new Responsable();
			this.responsableObject=new Object();
			this.responsablesObject=new ArrayList<Object>();
			
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
			
			this.responsableDataAccess.setConnexionType(this.connexionType);
			this.responsableDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public Responsable getResponsable() throws Exception {	
		ResponsableLogicAdditional.checkResponsableToGet(responsable,this.datosCliente,this.arrDatoGeneral);
		ResponsableLogicAdditional.updateResponsableToGet(responsable,this.arrDatoGeneral);
		
		return responsable;
	}
		
	public void setResponsable(Responsable newResponsable) {
		this.responsable = newResponsable;
	}
	
	public ResponsableDataAccess getResponsableDataAccess() {
		return responsableDataAccess;
	}
	
	public void setResponsableDataAccess(ResponsableDataAccess newresponsableDataAccess) {
		this.responsableDataAccess = newresponsableDataAccess;
	}
	
	public List<Responsable> getResponsables() throws Exception {		
		this.quitarResponsablesNulos();
		
		ResponsableLogicAdditional.checkResponsableToGets(responsables,this.datosCliente,this.arrDatoGeneral);
		
		for (Responsable responsableLocal: responsables ) {
			ResponsableLogicAdditional.updateResponsableToGet(responsableLocal,this.arrDatoGeneral);
		}
		
		return responsables;
	}
	
	public void setResponsables(List<Responsable> newResponsables) {
		this.responsables = newResponsables;
	}
	
	public Object getResponsableObject() {	
		this.responsableObject=this.responsableDataAccess.getEntityObject();
		return this.responsableObject;
	}
		
	public void setResponsableObject(Object newResponsableObject) {
		this.responsableObject = newResponsableObject;
	}
	
	public List<Object> getResponsablesObject() {		
		this.responsablesObject=this.responsableDataAccess.getEntitiesObject();
		return this.responsablesObject;
	}
		
	public void setResponsablesObject(List<Object> newResponsablesObject) {
		this.responsablesObject = newResponsablesObject;
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
		
		if(this.responsableDataAccess!=null) {
			this.responsableDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Responsable.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			responsableDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			responsableDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		responsable = new  Responsable();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Responsable.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			responsable=responsableDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.responsable,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				ResponsableConstantesFunciones.refrescarForeignKeysDescripcionesResponsable(this.responsable);
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
		responsable = new  Responsable();
		  		  
        try {
			
			responsable=responsableDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.responsable,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				ResponsableConstantesFunciones.refrescarForeignKeysDescripcionesResponsable(this.responsable);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		responsable = new  Responsable();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Responsable.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			responsable=responsableDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.responsable,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				ResponsableConstantesFunciones.refrescarForeignKeysDescripcionesResponsable(this.responsable);
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
		responsable = new  Responsable();
		  		  
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
		responsable = new  Responsable();
		  		  
        try {
			
			responsable=responsableDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.responsable,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				ResponsableConstantesFunciones.refrescarForeignKeysDescripcionesResponsable(this.responsable);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		responsable = new  Responsable();
		  		  
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
		responsable = new  Responsable();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Responsable.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =responsableDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		responsable = new  Responsable();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=responsableDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		responsable = new  Responsable();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Responsable.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =responsableDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		responsable = new  Responsable();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=responsableDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		responsable = new  Responsable();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Responsable.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =responsableDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		responsable = new  Responsable();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=responsableDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		responsables = new  ArrayList<Responsable>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Responsable.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			ResponsableLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			responsables=responsableDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarResponsable(responsables);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ResponsableConstantesFunciones.refrescarForeignKeysDescripcionesResponsable(this.responsables);
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
		responsables = new  ArrayList<Responsable>();
		  		  
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
		responsables = new  ArrayList<Responsable>();
		  		  
        try {			
			ResponsableLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			responsables=responsableDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarResponsable(responsables);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ResponsableConstantesFunciones.refrescarForeignKeysDescripcionesResponsable(this.responsables);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		responsables = new  ArrayList<Responsable>();
		  		  
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
		responsables = new  ArrayList<Responsable>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Responsable.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			ResponsableLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			responsables=responsableDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarResponsable(responsables);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ResponsableConstantesFunciones.refrescarForeignKeysDescripcionesResponsable(this.responsables);
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
		responsables = new  ArrayList<Responsable>();
		  		  
        try {
			ResponsableLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			responsables=responsableDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarResponsable(responsables);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ResponsableConstantesFunciones.refrescarForeignKeysDescripcionesResponsable(this.responsables);
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
		responsables = new  ArrayList<Responsable>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Responsable.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ResponsableLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			responsables=responsableDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarResponsable(responsables);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ResponsableConstantesFunciones.refrescarForeignKeysDescripcionesResponsable(this.responsables);
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
		responsables = new  ArrayList<Responsable>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ResponsableLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			responsables=responsableDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarResponsable(responsables);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ResponsableConstantesFunciones.refrescarForeignKeysDescripcionesResponsable(this.responsables);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		responsable = new  Responsable();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Responsable.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ResponsableLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			responsable=responsableDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarResponsable(responsable);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ResponsableConstantesFunciones.refrescarForeignKeysDescripcionesResponsable(this.responsable);
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
		responsable = new  Responsable();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ResponsableLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			responsable=responsableDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarResponsable(responsable);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ResponsableConstantesFunciones.refrescarForeignKeysDescripcionesResponsable(this.responsable);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		responsables = new  ArrayList<Responsable>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Responsable.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			ResponsableLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			responsables=responsableDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarResponsable(responsables);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ResponsableConstantesFunciones.refrescarForeignKeysDescripcionesResponsable(this.responsables);
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
		responsables = new  ArrayList<Responsable>();
		  		  
        try {
			ResponsableLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			responsables=responsableDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarResponsable(responsables);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ResponsableConstantesFunciones.refrescarForeignKeysDescripcionesResponsable(this.responsables);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosResponsablesWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		responsables = new  ArrayList<Responsable>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Responsable.class.getSimpleName()+"-getTodosResponsablesWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ResponsableLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			responsables=responsableDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarResponsable(responsables);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ResponsableConstantesFunciones.refrescarForeignKeysDescripcionesResponsable(this.responsables);
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
	
	public  void  getTodosResponsables(String sFinalQuery,Pagination pagination)throws Exception {
		responsables = new  ArrayList<Responsable>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ResponsableLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			responsables=responsableDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarResponsable(responsables);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ResponsableConstantesFunciones.refrescarForeignKeysDescripcionesResponsable(this.responsables);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarResponsable(Responsable responsable) throws Exception {
		Boolean estaValidado=false;
		
		if(responsable.getIsNew() || responsable.getIsChanged()) { 
			this.invalidValues = responsableValidator.getInvalidValues(responsable);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(responsable);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarResponsable(List<Responsable> Responsables) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(Responsable responsableLocal:responsables) {				
			estaValidadoObjeto=this.validarGuardarResponsable(responsableLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarResponsable(List<Responsable> Responsables) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarResponsable(responsables)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarResponsable(Responsable Responsable) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarResponsable(responsable)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(Responsable responsable) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+responsable.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=ResponsableConstantesFunciones.getResponsableLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"responsable","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(ResponsableConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(ResponsableConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveResponsableWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Responsable.class.getSimpleName()+"-saveResponsableWithConnection");connexion.begin();			
			
			ResponsableLogicAdditional.checkResponsableToSave(this.responsable,this.datosCliente,connexion,this.arrDatoGeneral);
			
			ResponsableLogicAdditional.updateResponsableToSave(this.responsable,this.arrDatoGeneral);
			
			ResponsableLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.responsable,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowResponsable();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarResponsable(this.responsable)) {
				ResponsableDataAccess.save(this.responsable, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.responsable,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			ResponsableLogicAdditional.checkResponsableToSaveAfter(this.responsable,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowResponsable();
			
			connexion.commit();			
			
			if(this.responsable.getIsDeleted()) {
				this.responsable=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveResponsable()throws Exception {	
		try {	
			
			ResponsableLogicAdditional.checkResponsableToSave(this.responsable,this.datosCliente,connexion,this.arrDatoGeneral);
			
			ResponsableLogicAdditional.updateResponsableToSave(this.responsable,this.arrDatoGeneral);
			
			ResponsableLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.responsable,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarResponsable(this.responsable)) {			
				ResponsableDataAccess.save(this.responsable, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.responsable,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			ResponsableLogicAdditional.checkResponsableToSaveAfter(this.responsable,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.responsable.getIsDeleted()) {
				this.responsable=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveResponsablesWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Responsable.class.getSimpleName()+"-saveResponsablesWithConnection");connexion.begin();			
			
			ResponsableLogicAdditional.checkResponsableToSaves(responsables,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowResponsables();
			
			Boolean validadoTodosResponsable=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(Responsable responsableLocal:responsables) {		
				if(responsableLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				ResponsableLogicAdditional.updateResponsableToSave(responsableLocal,this.arrDatoGeneral);
	        	
				ResponsableLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),responsableLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarResponsable(responsableLocal)) {
					ResponsableDataAccess.save(responsableLocal, connexion);				
				} else {
					validadoTodosResponsable=false;
				}
			}
			
			if(!validadoTodosResponsable) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			ResponsableLogicAdditional.checkResponsableToSavesAfter(responsables,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowResponsables();
			
			connexion.commit();		
			
			this.quitarResponsablesEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveResponsables()throws Exception {				
		 try {	
			ResponsableLogicAdditional.checkResponsableToSaves(responsables,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosResponsable=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(Responsable responsableLocal:responsables) {				
				if(responsableLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				ResponsableLogicAdditional.updateResponsableToSave(responsableLocal,this.arrDatoGeneral);
	        	
				ResponsableLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),responsableLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarResponsable(responsableLocal)) {				
					ResponsableDataAccess.save(responsableLocal, connexion);				
				} else {
					validadoTodosResponsable=false;
				}
			}
			
			if(!validadoTodosResponsable) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			ResponsableLogicAdditional.checkResponsableToSavesAfter(responsables,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarResponsablesEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public ResponsableParameterReturnGeneral procesarAccionResponsables(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<Responsable> responsables,ResponsableParameterReturnGeneral responsableParameterGeneral)throws Exception {
		 try {	
			ResponsableParameterReturnGeneral responsableReturnGeneral=new ResponsableParameterReturnGeneral();
	
			ResponsableLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,responsables,responsableParameterGeneral,responsableReturnGeneral);
			
			return responsableReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public ResponsableParameterReturnGeneral procesarAccionResponsablesWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<Responsable> responsables,ResponsableParameterReturnGeneral responsableParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Responsable.class.getSimpleName()+"-procesarAccionResponsablesWithConnection");connexion.begin();			
			
			ResponsableParameterReturnGeneral responsableReturnGeneral=new ResponsableParameterReturnGeneral();
	
			ResponsableLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,responsables,responsableParameterGeneral,responsableReturnGeneral);
			
			this.connexion.commit();
			
			return responsableReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public ResponsableParameterReturnGeneral procesarEventosResponsables(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<Responsable> responsables,Responsable responsable,ResponsableParameterReturnGeneral responsableParameterGeneral,Boolean isEsNuevoResponsable,ArrayList<Classe> clases)throws Exception {
		 try {	
			ResponsableParameterReturnGeneral responsableReturnGeneral=new ResponsableParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				responsableReturnGeneral.setConRecargarPropiedades(true);
			}
			
			ResponsableLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,responsables,responsable,responsableParameterGeneral,responsableReturnGeneral,isEsNuevoResponsable,clases);
			
			return responsableReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public ResponsableParameterReturnGeneral procesarEventosResponsablesWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<Responsable> responsables,Responsable responsable,ResponsableParameterReturnGeneral responsableParameterGeneral,Boolean isEsNuevoResponsable,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Responsable.class.getSimpleName()+"-procesarEventosResponsablesWithConnection");connexion.begin();			
			
			ResponsableParameterReturnGeneral responsableReturnGeneral=new ResponsableParameterReturnGeneral();
	
			responsableReturnGeneral.setResponsable(responsable);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				responsableReturnGeneral.setConRecargarPropiedades(true);
			}
			
			ResponsableLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,responsables,responsable,responsableParameterGeneral,responsableReturnGeneral,isEsNuevoResponsable,clases);
			
			this.connexion.commit();
			
			return responsableReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public ResponsableParameterReturnGeneral procesarImportacionResponsablesWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,ResponsableParameterReturnGeneral responsableParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Responsable.class.getSimpleName()+"-procesarImportacionResponsablesWithConnection");connexion.begin();			
			
			ResponsableParameterReturnGeneral responsableReturnGeneral=new ResponsableParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.responsables=new ArrayList<Responsable>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.responsable=new Responsable();
				
				
				if(conColumnasBase) {this.responsable.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.responsable.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.responsable.setidentificacion(arrColumnas[iColumn++]);
				this.responsable.setruc(arrColumnas[iColumn++]);
				this.responsable.setnombre(arrColumnas[iColumn++]);
				this.responsable.setapellido(arrColumnas[iColumn++]);
			this.responsable.setnombre_completo(arrColumnas[iColumn++]);
				this.responsable.setemail(arrColumnas[iColumn++]);
				this.responsable.settelefono(arrColumnas[iColumn++]);
				this.responsable.settelefono_celular(arrColumnas[iColumn++]);
				this.responsable.setdireccion(arrColumnas[iColumn++]);
				this.responsable.setfax(arrColumnas[iColumn++]);
			this.responsable.setobservacion(arrColumnas[iColumn++]);
				
				this.responsables.add(this.responsable);
			}
			
			this.saveResponsables();
			
			this.connexion.commit();
			
			responsableReturnGeneral.setConRetornoEstaProcesado(true);
			responsableReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return responsableReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarResponsablesEliminados() throws Exception {				
		
		List<Responsable> responsablesAux= new ArrayList<Responsable>();
		
		for(Responsable responsable:responsables) {
			if(!responsable.getIsDeleted()) {
				responsablesAux.add(responsable);
			}
		}
		
		responsables=responsablesAux;
	}
	
	public void quitarResponsablesNulos() throws Exception {				
		
		List<Responsable> responsablesAux= new ArrayList<Responsable>();
		
		for(Responsable responsable : this.responsables) {
			if(responsable==null) {
				responsablesAux.add(responsable);
			}
		}
		
		//this.responsables=responsablesAux;
		
		this.responsables.removeAll(responsablesAux);
	}
	
	public void getSetVersionRowResponsableWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(responsable.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((responsable.getIsDeleted() || (responsable.getIsChanged()&&!responsable.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=responsableDataAccess.getSetVersionRowResponsable(connexion,responsable.getId());
				
				if(!responsable.getVersionRow().equals(timestamp)) {	
					responsable.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				responsable.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowResponsable()throws Exception {	
		
		if(responsable.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((responsable.getIsDeleted() || (responsable.getIsChanged()&&!responsable.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=responsableDataAccess.getSetVersionRowResponsable(connexion,responsable.getId());
			
			try {							
				if(!responsable.getVersionRow().equals(timestamp)) {	
					responsable.setVersionRow(timestamp);
				}
				
				responsable.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowResponsablesWithConnection()throws Exception {	
		if(responsables!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(Responsable responsableAux:responsables) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(responsableAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(responsableAux.getIsDeleted() || (responsableAux.getIsChanged()&&!responsableAux.getIsNew())) {
						
						timestamp=responsableDataAccess.getSetVersionRowResponsable(connexion,responsableAux.getId());
						
						if(!responsable.getVersionRow().equals(timestamp)) {	
							responsableAux.setVersionRow(timestamp);
						}
								
						responsableAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowResponsables()throws Exception {	
		if(responsables!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(Responsable responsableAux:responsables) {
					if(responsableAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(responsableAux.getIsDeleted() || (responsableAux.getIsChanged()&&!responsableAux.getIsNew())) {
						
						timestamp=responsableDataAccess.getSetVersionRowResponsable(connexion,responsableAux.getId());
						
						if(!responsableAux.getVersionRow().equals(timestamp)) {	
							responsableAux.setVersionRow(timestamp);
						}
						
													
						responsableAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public ResponsableParameterReturnGeneral cargarCombosLoteForeignKeyResponsableWithConnection(String finalQueryGlobalEmpresa,String finalQueryGlobalSucursal,String finalQueryGlobalCliente,String finalQueryGlobalUsuario) throws Exception {
		ResponsableParameterReturnGeneral  responsableReturnGeneral =new ResponsableParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Responsable.class.getSimpleName()+"-cargarCombosLoteForeignKeyResponsableWithConnection");connexion.begin();
			
			responsableReturnGeneral =new ResponsableParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			responsableReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Sucursal> sucursalsForeignKey=new ArrayList<Sucursal>();
			SucursalLogic sucursalLogic=new SucursalLogic();
			sucursalLogic.setConnexion(this.connexion);
			//sucursalLogic.getSucursalDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalSucursal.equals("NONE")) {
				sucursalLogic.getTodosSucursals(finalQueryGlobalSucursal,new Pagination());
				sucursalsForeignKey=sucursalLogic.getSucursals();
			}

			responsableReturnGeneral.setsucursalsForeignKey(sucursalsForeignKey);


			List<Cliente> clientesForeignKey=new ArrayList<Cliente>();
			ClienteLogic clienteLogic=new ClienteLogic();
			clienteLogic.setConnexion(this.connexion);
			clienteLogic.getClienteDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCliente.equals("NONE")) {
				clienteLogic.getTodosClientes(finalQueryGlobalCliente,new Pagination());
				clientesForeignKey=clienteLogic.getClientes();
			}

			responsableReturnGeneral.setclientesForeignKey(clientesForeignKey);


			List<Usuario> usuariosForeignKey=new ArrayList<Usuario>();
			UsuarioLogic usuarioLogic=new UsuarioLogic();
			usuarioLogic.setConnexion(this.connexion);
			//usuarioLogic.getUsuarioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalUsuario.equals("NONE")) {
				usuarioLogic.getTodosUsuarios(finalQueryGlobalUsuario,new Pagination());
				usuariosForeignKey=usuarioLogic.getUsuarios();
			}

			responsableReturnGeneral.setusuariosForeignKey(usuariosForeignKey);

			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
		
		return responsableReturnGeneral;
	}
	
	public ResponsableParameterReturnGeneral cargarCombosLoteForeignKeyResponsable(String finalQueryGlobalEmpresa,String finalQueryGlobalSucursal,String finalQueryGlobalCliente,String finalQueryGlobalUsuario) throws Exception {
		ResponsableParameterReturnGeneral  responsableReturnGeneral =new ResponsableParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {						
			responsableReturnGeneral =new ResponsableParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			responsableReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Sucursal> sucursalsForeignKey=new ArrayList<Sucursal>();
			SucursalLogic sucursalLogic=new SucursalLogic();
			sucursalLogic.setConnexion(this.connexion);
			//sucursalLogic.getSucursalDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalSucursal.equals("NONE")) {
				sucursalLogic.getTodosSucursals(finalQueryGlobalSucursal,new Pagination());
				sucursalsForeignKey=sucursalLogic.getSucursals();
			}

			responsableReturnGeneral.setsucursalsForeignKey(sucursalsForeignKey);


			List<Cliente> clientesForeignKey=new ArrayList<Cliente>();
			ClienteLogic clienteLogic=new ClienteLogic();
			clienteLogic.setConnexion(this.connexion);
			clienteLogic.getClienteDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCliente.equals("NONE")) {
				clienteLogic.getTodosClientes(finalQueryGlobalCliente,new Pagination());
				clientesForeignKey=clienteLogic.getClientes();
			}

			responsableReturnGeneral.setclientesForeignKey(clientesForeignKey);


			List<Usuario> usuariosForeignKey=new ArrayList<Usuario>();
			UsuarioLogic usuarioLogic=new UsuarioLogic();
			usuarioLogic.setConnexion(this.connexion);
			//usuarioLogic.getUsuarioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalUsuario.equals("NONE")) {
				usuarioLogic.getTodosUsuarios(finalQueryGlobalUsuario,new Pagination());
				usuariosForeignKey=usuarioLogic.getUsuarios();
			}

			responsableReturnGeneral.setusuariosForeignKey(usuariosForeignKey);
						
			
		} catch(Exception e) {			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			
		}
		
		return responsableReturnGeneral;
	}
	
	public void cargarRelacionesLoteForeignKeyResponsableWithConnection() throws Exception {
		ArrayList<Classe> classes=new ArrayList<Classe>();		
		
		
			FacturaLogic facturaLogic=new FacturaLogic();
			ConsignacionLogic consignacionLogic=new ConsignacionLogic();
			PedidoExporLogic pedidoexporLogic=new PedidoExporLogic();
			PedidoLogic pedidoLogic=new PedidoLogic();
			NotaCreditoSoliLogic notacreditosoliLogic=new NotaCreditoSoliLogic();
		
		try {
			
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Responsable.class.getSimpleName()+"-cargarRelacionesLoteForeignKeyResponsableWithConnection");connexion.begin();
			
			
			classes.add(new Classe(Factura.class));
			classes.add(new Classe(Consignacion.class));
			classes.add(new Classe(PedidoExpor.class));
			classes.add(new Classe(Pedido.class));
			classes.add(new Classe(NotaCreditoSoli.class));
											
			

			facturaLogic.setConnexion(this.getConnexion());
			facturaLogic.setDatosCliente(this.datosCliente);
			facturaLogic.setIsConRefrescarForeignKeys(true);

			consignacionLogic.setConnexion(this.getConnexion());
			consignacionLogic.setDatosCliente(this.datosCliente);
			consignacionLogic.setIsConRefrescarForeignKeys(true);

			pedidoexporLogic.setConnexion(this.getConnexion());
			pedidoexporLogic.setDatosCliente(this.datosCliente);
			pedidoexporLogic.setIsConRefrescarForeignKeys(true);

			pedidoLogic.setConnexion(this.getConnexion());
			pedidoLogic.setDatosCliente(this.datosCliente);
			pedidoLogic.setIsConRefrescarForeignKeys(true);

			notacreditosoliLogic.setConnexion(this.getConnexion());
			notacreditosoliLogic.setDatosCliente(this.datosCliente);
			notacreditosoliLogic.setIsConRefrescarForeignKeys(true);
			
			this.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
			
			for(Responsable responsable:this.responsables) {
				

				classes=new ArrayList<Classe>();
				classes=FacturaConstantesFunciones.getClassesForeignKeysOfFactura(new ArrayList<Classe>(),DeepLoadType.NONE);

				facturaLogic.setFacturas(responsable.facturas);
				facturaLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");

				classes=new ArrayList<Classe>();
				classes=ConsignacionConstantesFunciones.getClassesForeignKeysOfConsignacion(new ArrayList<Classe>(),DeepLoadType.NONE);

				consignacionLogic.setConsignacions(responsable.consignacions);
				consignacionLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");

				classes=new ArrayList<Classe>();
				classes=PedidoExporConstantesFunciones.getClassesForeignKeysOfPedidoExpor(new ArrayList<Classe>(),DeepLoadType.NONE);

				pedidoexporLogic.setPedidoExpors(responsable.pedidoexpors);
				pedidoexporLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");

				classes=new ArrayList<Classe>();
				classes=PedidoConstantesFunciones.getClassesForeignKeysOfPedido(new ArrayList<Classe>(),DeepLoadType.NONE);

				pedidoLogic.setPedidos(responsable.pedidos);
				pedidoLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");

				classes=new ArrayList<Classe>();
				classes=NotaCreditoSoliConstantesFunciones.getClassesForeignKeysOfNotaCreditoSoli(new ArrayList<Classe>(),DeepLoadType.NONE);

				notacreditosoliLogic.setNotaCreditoSolis(responsable.notacreditosolis);
				notacreditosoliLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
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
	
	public void deepLoad(Responsable responsable,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			ResponsableLogicAdditional.updateResponsableToGet(responsable,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		responsable.setEmpresa(responsableDataAccess.getEmpresa(connexion,responsable));
		responsable.setSucursal(responsableDataAccess.getSucursal(connexion,responsable));
		responsable.setCliente(responsableDataAccess.getCliente(connexion,responsable));
		responsable.setUsuario(responsableDataAccess.getUsuario(connexion,responsable));
		responsable.setFacturas(responsableDataAccess.getFacturas(connexion,responsable));
		responsable.setConsignacions(responsableDataAccess.getConsignacions(connexion,responsable));
		responsable.setPedidos(responsableDataAccess.getPedidos(connexion,responsable));
		responsable.setPedidoExpors(responsableDataAccess.getPedidoExpors(connexion,responsable));
		responsable.setNotaCreditoSolis(responsableDataAccess.getNotaCreditoSolis(connexion,responsable));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				responsable.setEmpresa(responsableDataAccess.getEmpresa(connexion,responsable));
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				responsable.setSucursal(responsableDataAccess.getSucursal(connexion,responsable));
				continue;
			}

			if(clas.clas.equals(Cliente.class)) {
				responsable.setCliente(responsableDataAccess.getCliente(connexion,responsable));
				continue;
			}

			if(clas.clas.equals(Usuario.class)) {
				responsable.setUsuario(responsableDataAccess.getUsuario(connexion,responsable));
				continue;
			}

			if(clas.clas.equals(Factura.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				responsable.setFacturas(responsableDataAccess.getFacturas(connexion,responsable));

				if(this.isConDeep) {
					FacturaLogic facturaLogic= new FacturaLogic(this.connexion);
					facturaLogic.setFacturas(responsable.getFacturas());
					ArrayList<Classe> classesLocal=FacturaConstantesFunciones.getClassesForeignKeysOfFactura(new ArrayList<Classe>(),DeepLoadType.NONE);
					facturaLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					FacturaConstantesFunciones.refrescarForeignKeysDescripcionesFactura(facturaLogic.getFacturas());
					responsable.setFacturas(facturaLogic.getFacturas());
				}

				continue;
			}

			if(clas.clas.equals(Consignacion.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				responsable.setConsignacions(responsableDataAccess.getConsignacions(connexion,responsable));

				if(this.isConDeep) {
					ConsignacionLogic consignacionLogic= new ConsignacionLogic(this.connexion);
					consignacionLogic.setConsignacions(responsable.getConsignacions());
					ArrayList<Classe> classesLocal=ConsignacionConstantesFunciones.getClassesForeignKeysOfConsignacion(new ArrayList<Classe>(),DeepLoadType.NONE);
					consignacionLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					ConsignacionConstantesFunciones.refrescarForeignKeysDescripcionesConsignacion(consignacionLogic.getConsignacions());
					responsable.setConsignacions(consignacionLogic.getConsignacions());
				}

				continue;
			}

			if(clas.clas.equals(Pedido.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				responsable.setPedidos(responsableDataAccess.getPedidos(connexion,responsable));

				if(this.isConDeep) {
					PedidoLogic pedidoLogic= new PedidoLogic(this.connexion);
					pedidoLogic.setPedidos(responsable.getPedidos());
					ArrayList<Classe> classesLocal=PedidoConstantesFunciones.getClassesForeignKeysOfPedido(new ArrayList<Classe>(),DeepLoadType.NONE);
					pedidoLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					PedidoConstantesFunciones.refrescarForeignKeysDescripcionesPedido(pedidoLogic.getPedidos());
					responsable.setPedidos(pedidoLogic.getPedidos());
				}

				continue;
			}

			if(clas.clas.equals(PedidoExpor.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				responsable.setPedidoExpors(responsableDataAccess.getPedidoExpors(connexion,responsable));

				if(this.isConDeep) {
					PedidoExporLogic pedidoexporLogic= new PedidoExporLogic(this.connexion);
					pedidoexporLogic.setPedidoExpors(responsable.getPedidoExpors());
					ArrayList<Classe> classesLocal=PedidoExporConstantesFunciones.getClassesForeignKeysOfPedidoExpor(new ArrayList<Classe>(),DeepLoadType.NONE);
					pedidoexporLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					PedidoExporConstantesFunciones.refrescarForeignKeysDescripcionesPedidoExpor(pedidoexporLogic.getPedidoExpors());
					responsable.setPedidoExpors(pedidoexporLogic.getPedidoExpors());
				}

				continue;
			}

			if(clas.clas.equals(NotaCreditoSoli.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				responsable.setNotaCreditoSolis(responsableDataAccess.getNotaCreditoSolis(connexion,responsable));

				if(this.isConDeep) {
					NotaCreditoSoliLogic notacreditosoliLogic= new NotaCreditoSoliLogic(this.connexion);
					notacreditosoliLogic.setNotaCreditoSolis(responsable.getNotaCreditoSolis());
					ArrayList<Classe> classesLocal=NotaCreditoSoliConstantesFunciones.getClassesForeignKeysOfNotaCreditoSoli(new ArrayList<Classe>(),DeepLoadType.NONE);
					notacreditosoliLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					NotaCreditoSoliConstantesFunciones.refrescarForeignKeysDescripcionesNotaCreditoSoli(notacreditosoliLogic.getNotaCreditoSolis());
					responsable.setNotaCreditoSolis(notacreditosoliLogic.getNotaCreditoSolis());
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
			responsable.setEmpresa(responsableDataAccess.getEmpresa(connexion,responsable));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			responsable.setSucursal(responsableDataAccess.getSucursal(connexion,responsable));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Cliente.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			responsable.setCliente(responsableDataAccess.getCliente(connexion,responsable));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Usuario.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			responsable.setUsuario(responsableDataAccess.getUsuario(connexion,responsable));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Factura.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(Factura.class));
			responsable.setFacturas(responsableDataAccess.getFacturas(connexion,responsable));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Consignacion.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(Consignacion.class));
			responsable.setConsignacions(responsableDataAccess.getConsignacions(connexion,responsable));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Pedido.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(Pedido.class));
			responsable.setPedidos(responsableDataAccess.getPedidos(connexion,responsable));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(PedidoExpor.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(PedidoExpor.class));
			responsable.setPedidoExpors(responsableDataAccess.getPedidoExpors(connexion,responsable));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(NotaCreditoSoli.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(NotaCreditoSoli.class));
			responsable.setNotaCreditoSolis(responsableDataAccess.getNotaCreditoSolis(connexion,responsable));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		responsable.setEmpresa(responsableDataAccess.getEmpresa(connexion,responsable));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(responsable.getEmpresa(),isDeep,deepLoadType,clases);
				
		responsable.setSucursal(responsableDataAccess.getSucursal(connexion,responsable));
		SucursalLogic sucursalLogic= new SucursalLogic(connexion);
		sucursalLogic.deepLoad(responsable.getSucursal(),isDeep,deepLoadType,clases);
				
		responsable.setCliente(responsableDataAccess.getCliente(connexion,responsable));
		ClienteLogic clienteLogic= new ClienteLogic(connexion);
		clienteLogic.deepLoad(responsable.getCliente(),isDeep,deepLoadType,clases);
				
		responsable.setUsuario(responsableDataAccess.getUsuario(connexion,responsable));
		UsuarioLogic usuarioLogic= new UsuarioLogic(connexion);
		usuarioLogic.deepLoad(responsable.getUsuario(),isDeep,deepLoadType,clases);
				

		responsable.setFacturas(responsableDataAccess.getFacturas(connexion,responsable));

		for(Factura factura:responsable.getFacturas()) {
			FacturaLogic facturaLogic= new FacturaLogic(connexion);
			facturaLogic.deepLoad(factura,isDeep,deepLoadType,clases);
		}

		responsable.setConsignacions(responsableDataAccess.getConsignacions(connexion,responsable));

		for(Consignacion consignacion:responsable.getConsignacions()) {
			ConsignacionLogic consignacionLogic= new ConsignacionLogic(connexion);
			consignacionLogic.deepLoad(consignacion,isDeep,deepLoadType,clases);
		}

		responsable.setPedidos(responsableDataAccess.getPedidos(connexion,responsable));

		for(Pedido pedido:responsable.getPedidos()) {
			PedidoLogic pedidoLogic= new PedidoLogic(connexion);
			pedidoLogic.deepLoad(pedido,isDeep,deepLoadType,clases);
		}

		responsable.setPedidoExpors(responsableDataAccess.getPedidoExpors(connexion,responsable));

		for(PedidoExpor pedidoexpor:responsable.getPedidoExpors()) {
			PedidoExporLogic pedidoexporLogic= new PedidoExporLogic(connexion);
			pedidoexporLogic.deepLoad(pedidoexpor,isDeep,deepLoadType,clases);
		}

		responsable.setNotaCreditoSolis(responsableDataAccess.getNotaCreditoSolis(connexion,responsable));

		for(NotaCreditoSoli notacreditosoli:responsable.getNotaCreditoSolis()) {
			NotaCreditoSoliLogic notacreditosoliLogic= new NotaCreditoSoliLogic(connexion);
			notacreditosoliLogic.deepLoad(notacreditosoli,isDeep,deepLoadType,clases);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				responsable.setEmpresa(responsableDataAccess.getEmpresa(connexion,responsable));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(responsable.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				responsable.setSucursal(responsableDataAccess.getSucursal(connexion,responsable));
				SucursalLogic sucursalLogic= new SucursalLogic(connexion);
				sucursalLogic.deepLoad(responsable.getSucursal(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Cliente.class)) {
				responsable.setCliente(responsableDataAccess.getCliente(connexion,responsable));
				ClienteLogic clienteLogic= new ClienteLogic(connexion);
				clienteLogic.deepLoad(responsable.getCliente(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Usuario.class)) {
				responsable.setUsuario(responsableDataAccess.getUsuario(connexion,responsable));
				UsuarioLogic usuarioLogic= new UsuarioLogic(connexion);
				usuarioLogic.deepLoad(responsable.getUsuario(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Factura.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				responsable.setFacturas(responsableDataAccess.getFacturas(connexion,responsable));

				for(Factura factura:responsable.getFacturas()) {
					FacturaLogic facturaLogic= new FacturaLogic(connexion);
					facturaLogic.deepLoad(factura,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(Consignacion.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				responsable.setConsignacions(responsableDataAccess.getConsignacions(connexion,responsable));

				for(Consignacion consignacion:responsable.getConsignacions()) {
					ConsignacionLogic consignacionLogic= new ConsignacionLogic(connexion);
					consignacionLogic.deepLoad(consignacion,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(Pedido.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				responsable.setPedidos(responsableDataAccess.getPedidos(connexion,responsable));

				for(Pedido pedido:responsable.getPedidos()) {
					PedidoLogic pedidoLogic= new PedidoLogic(connexion);
					pedidoLogic.deepLoad(pedido,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(PedidoExpor.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				responsable.setPedidoExpors(responsableDataAccess.getPedidoExpors(connexion,responsable));

				for(PedidoExpor pedidoexpor:responsable.getPedidoExpors()) {
					PedidoExporLogic pedidoexporLogic= new PedidoExporLogic(connexion);
					pedidoexporLogic.deepLoad(pedidoexpor,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(NotaCreditoSoli.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				responsable.setNotaCreditoSolis(responsableDataAccess.getNotaCreditoSolis(connexion,responsable));

				for(NotaCreditoSoli notacreditosoli:responsable.getNotaCreditoSolis()) {
					NotaCreditoSoliLogic notacreditosoliLogic= new NotaCreditoSoliLogic(connexion);
					notacreditosoliLogic.deepLoad(notacreditosoli,isDeep,deepLoadType,clases);
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
			responsable.setEmpresa(responsableDataAccess.getEmpresa(connexion,responsable));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(responsable.getEmpresa(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			responsable.setSucursal(responsableDataAccess.getSucursal(connexion,responsable));
			SucursalLogic sucursalLogic= new SucursalLogic(connexion);
			sucursalLogic.deepLoad(responsable.getSucursal(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Cliente.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			responsable.setCliente(responsableDataAccess.getCliente(connexion,responsable));
			ClienteLogic clienteLogic= new ClienteLogic(connexion);
			clienteLogic.deepLoad(responsable.getCliente(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Usuario.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			responsable.setUsuario(responsableDataAccess.getUsuario(connexion,responsable));
			UsuarioLogic usuarioLogic= new UsuarioLogic(connexion);
			usuarioLogic.deepLoad(responsable.getUsuario(),isDeep,deepLoadType,clases);
				
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Factura.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(Factura.class));
			responsable.setFacturas(responsableDataAccess.getFacturas(connexion,responsable));

			for(Factura factura:responsable.getFacturas()) {
				FacturaLogic facturaLogic= new FacturaLogic(connexion);
				facturaLogic.deepLoad(factura,isDeep,deepLoadType,clases);
			}
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Consignacion.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(Consignacion.class));
			responsable.setConsignacions(responsableDataAccess.getConsignacions(connexion,responsable));

			for(Consignacion consignacion:responsable.getConsignacions()) {
				ConsignacionLogic consignacionLogic= new ConsignacionLogic(connexion);
				consignacionLogic.deepLoad(consignacion,isDeep,deepLoadType,clases);
			}
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Pedido.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(Pedido.class));
			responsable.setPedidos(responsableDataAccess.getPedidos(connexion,responsable));

			for(Pedido pedido:responsable.getPedidos()) {
				PedidoLogic pedidoLogic= new PedidoLogic(connexion);
				pedidoLogic.deepLoad(pedido,isDeep,deepLoadType,clases);
			}
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(PedidoExpor.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(PedidoExpor.class));
			responsable.setPedidoExpors(responsableDataAccess.getPedidoExpors(connexion,responsable));

			for(PedidoExpor pedidoexpor:responsable.getPedidoExpors()) {
				PedidoExporLogic pedidoexporLogic= new PedidoExporLogic(connexion);
				pedidoexporLogic.deepLoad(pedidoexpor,isDeep,deepLoadType,clases);
			}
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(NotaCreditoSoli.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(NotaCreditoSoli.class));
			responsable.setNotaCreditoSolis(responsableDataAccess.getNotaCreditoSolis(connexion,responsable));

			for(NotaCreditoSoli notacreditosoli:responsable.getNotaCreditoSolis()) {
				NotaCreditoSoliLogic notacreditosoliLogic= new NotaCreditoSoliLogic(connexion);
				notacreditosoliLogic.deepLoad(notacreditosoli,isDeep,deepLoadType,clases);
			}
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(Responsable responsable,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			ResponsableLogicAdditional.updateResponsableToSave(responsable,this.arrDatoGeneral);
			
ResponsableDataAccess.save(responsable, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(responsable.getEmpresa(),connexion);

		SucursalDataAccess.save(responsable.getSucursal(),connexion);

		ClienteDataAccess.save(responsable.getCliente(),connexion);

		UsuarioDataAccess.save(responsable.getUsuario(),connexion);

		for(Factura factura:responsable.getFacturas()) {
			factura.setid_responsable(responsable.getId());
			FacturaDataAccess.save(factura,connexion);
		}

		for(Consignacion consignacion:responsable.getConsignacions()) {
			consignacion.setid_responsable(responsable.getId());
			ConsignacionDataAccess.save(consignacion,connexion);
		}

		for(Pedido pedido:responsable.getPedidos()) {
			pedido.setid_responsable(responsable.getId());
			PedidoDataAccess.save(pedido,connexion);
		}

		for(PedidoExpor pedidoexpor:responsable.getPedidoExpors()) {
			pedidoexpor.setid_responsable(responsable.getId());
			PedidoExporDataAccess.save(pedidoexpor,connexion);
		}

		for(NotaCreditoSoli notacreditosoli:responsable.getNotaCreditoSolis()) {
			notacreditosoli.setid_responsable(responsable.getId());
			NotaCreditoSoliDataAccess.save(notacreditosoli,connexion);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(responsable.getEmpresa(),connexion);
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				SucursalDataAccess.save(responsable.getSucursal(),connexion);
				continue;
			}

			if(clas.clas.equals(Cliente.class)) {
				ClienteDataAccess.save(responsable.getCliente(),connexion);
				continue;
			}

			if(clas.clas.equals(Usuario.class)) {
				UsuarioDataAccess.save(responsable.getUsuario(),connexion);
				continue;
			}


			if(clas.clas.equals(Factura.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(Factura factura:responsable.getFacturas()) {
					factura.setid_responsable(responsable.getId());
					FacturaDataAccess.save(factura,connexion);
				}
				continue;
			}

			if(clas.clas.equals(Consignacion.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(Consignacion consignacion:responsable.getConsignacions()) {
					consignacion.setid_responsable(responsable.getId());
					ConsignacionDataAccess.save(consignacion,connexion);
				}
				continue;
			}

			if(clas.clas.equals(Pedido.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(Pedido pedido:responsable.getPedidos()) {
					pedido.setid_responsable(responsable.getId());
					PedidoDataAccess.save(pedido,connexion);
				}
				continue;
			}

			if(clas.clas.equals(PedidoExpor.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(PedidoExpor pedidoexpor:responsable.getPedidoExpors()) {
					pedidoexpor.setid_responsable(responsable.getId());
					PedidoExporDataAccess.save(pedidoexpor,connexion);
				}
				continue;
			}

			if(clas.clas.equals(NotaCreditoSoli.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(NotaCreditoSoli notacreditosoli:responsable.getNotaCreditoSolis()) {
					notacreditosoli.setid_responsable(responsable.getId());
					NotaCreditoSoliDataAccess.save(notacreditosoli,connexion);
				}
				continue;
			}
		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(responsable.getEmpresa(),connexion);
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(responsable.getEmpresa(),isDeep,deepLoadType,clases);
				

		SucursalDataAccess.save(responsable.getSucursal(),connexion);
		SucursalLogic sucursalLogic= new SucursalLogic(connexion);
		sucursalLogic.deepLoad(responsable.getSucursal(),isDeep,deepLoadType,clases);
				

		ClienteDataAccess.save(responsable.getCliente(),connexion);
		ClienteLogic clienteLogic= new ClienteLogic(connexion);
		clienteLogic.deepLoad(responsable.getCliente(),isDeep,deepLoadType,clases);
				

		UsuarioDataAccess.save(responsable.getUsuario(),connexion);
		UsuarioLogic usuarioLogic= new UsuarioLogic(connexion);
		usuarioLogic.deepLoad(responsable.getUsuario(),isDeep,deepLoadType,clases);
				

		for(Factura factura:responsable.getFacturas()) {
			FacturaLogic facturaLogic= new FacturaLogic(connexion);
			factura.setid_responsable(responsable.getId());
			FacturaDataAccess.save(factura,connexion);
			facturaLogic.deepSave(factura,isDeep,deepLoadType,clases);
		}

		for(Consignacion consignacion:responsable.getConsignacions()) {
			ConsignacionLogic consignacionLogic= new ConsignacionLogic(connexion);
			consignacion.setid_responsable(responsable.getId());
			ConsignacionDataAccess.save(consignacion,connexion);
			consignacionLogic.deepSave(consignacion,isDeep,deepLoadType,clases);
		}

		for(Pedido pedido:responsable.getPedidos()) {
			PedidoLogic pedidoLogic= new PedidoLogic(connexion);
			pedido.setid_responsable(responsable.getId());
			PedidoDataAccess.save(pedido,connexion);
			pedidoLogic.deepSave(pedido,isDeep,deepLoadType,clases);
		}

		for(PedidoExpor pedidoexpor:responsable.getPedidoExpors()) {
			PedidoExporLogic pedidoexporLogic= new PedidoExporLogic(connexion);
			pedidoexpor.setid_responsable(responsable.getId());
			PedidoExporDataAccess.save(pedidoexpor,connexion);
			pedidoexporLogic.deepSave(pedidoexpor,isDeep,deepLoadType,clases);
		}

		for(NotaCreditoSoli notacreditosoli:responsable.getNotaCreditoSolis()) {
			NotaCreditoSoliLogic notacreditosoliLogic= new NotaCreditoSoliLogic(connexion);
			notacreditosoli.setid_responsable(responsable.getId());
			NotaCreditoSoliDataAccess.save(notacreditosoli,connexion);
			notacreditosoliLogic.deepSave(notacreditosoli,isDeep,deepLoadType,clases);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(responsable.getEmpresa(),connexion);
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepSave(responsable.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				SucursalDataAccess.save(responsable.getSucursal(),connexion);
				SucursalLogic sucursalLogic= new SucursalLogic(connexion);
				sucursalLogic.deepSave(responsable.getSucursal(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Cliente.class)) {
				ClienteDataAccess.save(responsable.getCliente(),connexion);
				ClienteLogic clienteLogic= new ClienteLogic(connexion);
				clienteLogic.deepSave(responsable.getCliente(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Usuario.class)) {
				UsuarioDataAccess.save(responsable.getUsuario(),connexion);
				UsuarioLogic usuarioLogic= new UsuarioLogic(connexion);
				usuarioLogic.deepSave(responsable.getUsuario(),isDeep,deepLoadType,clases);				
				continue;
			}


			if(clas.clas.equals(Factura.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(Factura factura:responsable.getFacturas()) {
					FacturaLogic facturaLogic= new FacturaLogic(connexion);
					factura.setid_responsable(responsable.getId());
					FacturaDataAccess.save(factura,connexion);
					facturaLogic.deepSave(factura,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(Consignacion.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(Consignacion consignacion:responsable.getConsignacions()) {
					ConsignacionLogic consignacionLogic= new ConsignacionLogic(connexion);
					consignacion.setid_responsable(responsable.getId());
					ConsignacionDataAccess.save(consignacion,connexion);
					consignacionLogic.deepSave(consignacion,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(Pedido.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(Pedido pedido:responsable.getPedidos()) {
					PedidoLogic pedidoLogic= new PedidoLogic(connexion);
					pedido.setid_responsable(responsable.getId());
					PedidoDataAccess.save(pedido,connexion);
					pedidoLogic.deepSave(pedido,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(PedidoExpor.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(PedidoExpor pedidoexpor:responsable.getPedidoExpors()) {
					PedidoExporLogic pedidoexporLogic= new PedidoExporLogic(connexion);
					pedidoexpor.setid_responsable(responsable.getId());
					PedidoExporDataAccess.save(pedidoexpor,connexion);
					pedidoexporLogic.deepSave(pedidoexpor,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(NotaCreditoSoli.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(NotaCreditoSoli notacreditosoli:responsable.getNotaCreditoSolis()) {
					NotaCreditoSoliLogic notacreditosoliLogic= new NotaCreditoSoliLogic(connexion);
					notacreditosoli.setid_responsable(responsable.getId());
					NotaCreditoSoliDataAccess.save(notacreditosoli,connexion);
					notacreditosoliLogic.deepSave(notacreditosoli,isDeep,deepLoadType,clases);
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
			this.getNewConnexionToDeep(Responsable.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(responsable,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				ResponsableConstantesFunciones.refrescarForeignKeysDescripcionesResponsable(responsable);
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
			this.deepLoad(this.responsable,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				ResponsableConstantesFunciones.refrescarForeignKeysDescripcionesResponsable(this.responsable);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(Responsable.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(responsables!=null) {
				for(Responsable responsable:responsables) {
					this.deepLoad(responsable,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					ResponsableConstantesFunciones.refrescarForeignKeysDescripcionesResponsable(responsables);
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
			if(responsables!=null) {
				for(Responsable responsable:responsables) {
					this.deepLoad(responsable,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					ResponsableConstantesFunciones.refrescarForeignKeysDescripcionesResponsable(responsables);
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
			this.getNewConnexionToDeep(Responsable.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(responsable,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(Responsable.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(responsables!=null) {
				for(Responsable responsable:responsables) {
					this.deepSave(responsable,isDeep,deepLoadType,clases);
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
			if(responsables!=null) {
				for(Responsable responsable:responsables) {
					this.deepSave(responsable,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getResponsablesBusquedaPorIdentificacionWithConnection(String sFinalQuery,Pagination pagination,String identificacion)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Responsable.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralIdentificacion= new ParameterSelectionGeneral();
			parameterSelectionGeneralIdentificacion.setParameterSelectionGeneralLike(ParameterType.STRING,"%"+identificacion+"%",ResponsableConstantesFunciones.IDENTIFICACION,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralIdentificacion);

			ResponsableLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorIdentificacion","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			responsables=responsableDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ResponsableConstantesFunciones.refrescarForeignKeysDescripcionesResponsable(this.responsables);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getResponsablesBusquedaPorIdentificacion(String sFinalQuery,Pagination pagination,String identificacion)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralIdentificacion= new ParameterSelectionGeneral();
			parameterSelectionGeneralIdentificacion.setParameterSelectionGeneralLike(ParameterType.STRING,"%"+identificacion+"%",ResponsableConstantesFunciones.IDENTIFICACION,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralIdentificacion);

			ResponsableLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorIdentificacion","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			responsables=responsableDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ResponsableConstantesFunciones.refrescarForeignKeysDescripcionesResponsable(this.responsables);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getResponsablesBusquedaPorNombreCompletoWithConnection(String sFinalQuery,Pagination pagination,String nombre_completo)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Responsable.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralNombreCompleto= new ParameterSelectionGeneral();
			parameterSelectionGeneralNombreCompleto.setParameterSelectionGeneralLike(ParameterType.STRING,"%"+nombre_completo+"%",ResponsableConstantesFunciones.NOMBRECOMPLETO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralNombreCompleto);

			ResponsableLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorNombreCompleto","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			responsables=responsableDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ResponsableConstantesFunciones.refrescarForeignKeysDescripcionesResponsable(this.responsables);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getResponsablesBusquedaPorNombreCompleto(String sFinalQuery,Pagination pagination,String nombre_completo)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralNombreCompleto= new ParameterSelectionGeneral();
			parameterSelectionGeneralNombreCompleto.setParameterSelectionGeneralLike(ParameterType.STRING,"%"+nombre_completo+"%",ResponsableConstantesFunciones.NOMBRECOMPLETO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralNombreCompleto);

			ResponsableLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorNombreCompleto","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			responsables=responsableDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ResponsableConstantesFunciones.refrescarForeignKeysDescripcionesResponsable(this.responsables);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getResponsablesBusquedaPorRucWithConnection(String sFinalQuery,Pagination pagination,String ruc)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Responsable.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralRuc= new ParameterSelectionGeneral();
			parameterSelectionGeneralRuc.setParameterSelectionGeneralLike(ParameterType.STRING,"%"+ruc+"%",ResponsableConstantesFunciones.RUC,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralRuc);

			ResponsableLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorRuc","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			responsables=responsableDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ResponsableConstantesFunciones.refrescarForeignKeysDescripcionesResponsable(this.responsables);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getResponsablesBusquedaPorRuc(String sFinalQuery,Pagination pagination,String ruc)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralRuc= new ParameterSelectionGeneral();
			parameterSelectionGeneralRuc.setParameterSelectionGeneralLike(ParameterType.STRING,"%"+ruc+"%",ResponsableConstantesFunciones.RUC,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralRuc);

			ResponsableLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorRuc","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			responsables=responsableDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ResponsableConstantesFunciones.refrescarForeignKeysDescripcionesResponsable(this.responsables);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getResponsablesBusquedaPorTelefonoWithConnection(String sFinalQuery,Pagination pagination,String telefono)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Responsable.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralTelefono= new ParameterSelectionGeneral();
			parameterSelectionGeneralTelefono.setParameterSelectionGeneralLike(ParameterType.STRING,"%"+telefono+"%",ResponsableConstantesFunciones.TELEFONO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralTelefono);

			ResponsableLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorTelefono","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			responsables=responsableDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ResponsableConstantesFunciones.refrescarForeignKeysDescripcionesResponsable(this.responsables);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getResponsablesBusquedaPorTelefono(String sFinalQuery,Pagination pagination,String telefono)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralTelefono= new ParameterSelectionGeneral();
			parameterSelectionGeneralTelefono.setParameterSelectionGeneralLike(ParameterType.STRING,"%"+telefono+"%",ResponsableConstantesFunciones.TELEFONO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralTelefono);

			ResponsableLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorTelefono","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			responsables=responsableDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ResponsableConstantesFunciones.refrescarForeignKeysDescripcionesResponsable(this.responsables);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getResponsablesBusquedaPorTelefonoCelularWithConnection(String sFinalQuery,Pagination pagination,String telefono_celular)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Responsable.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralTelefonoCelular= new ParameterSelectionGeneral();
			parameterSelectionGeneralTelefonoCelular.setParameterSelectionGeneralLike(ParameterType.STRING,"%"+telefono_celular+"%",ResponsableConstantesFunciones.TELEFONOCELULAR,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralTelefonoCelular);

			ResponsableLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorTelefonoCelular","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			responsables=responsableDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ResponsableConstantesFunciones.refrescarForeignKeysDescripcionesResponsable(this.responsables);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getResponsablesBusquedaPorTelefonoCelular(String sFinalQuery,Pagination pagination,String telefono_celular)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralTelefonoCelular= new ParameterSelectionGeneral();
			parameterSelectionGeneralTelefonoCelular.setParameterSelectionGeneralLike(ParameterType.STRING,"%"+telefono_celular+"%",ResponsableConstantesFunciones.TELEFONOCELULAR,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralTelefonoCelular);

			ResponsableLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorTelefonoCelular","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			responsables=responsableDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ResponsableConstantesFunciones.refrescarForeignKeysDescripcionesResponsable(this.responsables);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getResponsablesFK_IdClienteWithConnection(String sFinalQuery,Pagination pagination,Long id_cliente)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Responsable.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCliente= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCliente.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cliente,ResponsableConstantesFunciones.IDCLIENTE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCliente);

			ResponsableLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCliente","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			responsables=responsableDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ResponsableConstantesFunciones.refrescarForeignKeysDescripcionesResponsable(this.responsables);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getResponsablesFK_IdCliente(String sFinalQuery,Pagination pagination,Long id_cliente)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCliente= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCliente.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cliente,ResponsableConstantesFunciones.IDCLIENTE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCliente);

			ResponsableLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCliente","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			responsables=responsableDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ResponsableConstantesFunciones.refrescarForeignKeysDescripcionesResponsable(this.responsables);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getResponsablesFK_IdEmpresaWithConnection(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Responsable.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,ResponsableConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			ResponsableLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			responsables=responsableDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ResponsableConstantesFunciones.refrescarForeignKeysDescripcionesResponsable(this.responsables);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getResponsablesFK_IdEmpresa(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,ResponsableConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			ResponsableLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			responsables=responsableDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ResponsableConstantesFunciones.refrescarForeignKeysDescripcionesResponsable(this.responsables);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getResponsablesFK_IdSucursalWithConnection(String sFinalQuery,Pagination pagination,Long id_sucursal)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Responsable.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidSucursal= new ParameterSelectionGeneral();
			parameterSelectionGeneralidSucursal.setParameterSelectionGeneralEqual(ParameterType.LONG,id_sucursal,ResponsableConstantesFunciones.IDSUCURSAL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidSucursal);

			ResponsableLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdSucursal","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			responsables=responsableDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ResponsableConstantesFunciones.refrescarForeignKeysDescripcionesResponsable(this.responsables);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getResponsablesFK_IdSucursal(String sFinalQuery,Pagination pagination,Long id_sucursal)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidSucursal= new ParameterSelectionGeneral();
			parameterSelectionGeneralidSucursal.setParameterSelectionGeneralEqual(ParameterType.LONG,id_sucursal,ResponsableConstantesFunciones.IDSUCURSAL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidSucursal);

			ResponsableLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdSucursal","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			responsables=responsableDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ResponsableConstantesFunciones.refrescarForeignKeysDescripcionesResponsable(this.responsables);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getResponsablesFK_IdUsuarioWithConnection(String sFinalQuery,Pagination pagination,Long id_usuario)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Responsable.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidUsuario= new ParameterSelectionGeneral();
			parameterSelectionGeneralidUsuario.setParameterSelectionGeneralEqual(ParameterType.LONG,id_usuario,ResponsableConstantesFunciones.IDUSUARIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidUsuario);

			ResponsableLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdUsuario","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			responsables=responsableDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ResponsableConstantesFunciones.refrescarForeignKeysDescripcionesResponsable(this.responsables);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getResponsablesFK_IdUsuario(String sFinalQuery,Pagination pagination,Long id_usuario)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidUsuario= new ParameterSelectionGeneral();
			parameterSelectionGeneralidUsuario.setParameterSelectionGeneralEqual(ParameterType.LONG,id_usuario,ResponsableConstantesFunciones.IDUSUARIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidUsuario);

			ResponsableLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdUsuario","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			responsables=responsableDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ResponsableConstantesFunciones.refrescarForeignKeysDescripcionesResponsable(this.responsables);
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
			if(ResponsableConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,ResponsableDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,Responsable responsable,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(ResponsableConstantesFunciones.ISCONAUDITORIA) {
				if(responsable.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,ResponsableDataAccess.TABLENAME, responsable.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(ResponsableConstantesFunciones.ISCONAUDITORIADETALLE) {
						////ResponsableLogic.registrarAuditoriaDetallesResponsable(connexion,responsable,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(responsable.getIsDeleted()) {
					/*if(!responsable.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,ResponsableDataAccess.TABLENAME, responsable.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////ResponsableLogic.registrarAuditoriaDetallesResponsable(connexion,responsable,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,ResponsableDataAccess.TABLENAME, responsable.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(responsable.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,ResponsableDataAccess.TABLENAME, responsable.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(ResponsableConstantesFunciones.ISCONAUDITORIADETALLE) {
						////ResponsableLogic.registrarAuditoriaDetallesResponsable(connexion,responsable,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesResponsable(Connexion connexion,Responsable responsable)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(responsable.getIsNew()||!responsable.getid_empresa().equals(responsable.getResponsableOriginal().getid_empresa()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(responsable.getResponsableOriginal().getid_empresa()!=null)
				{
					strValorActual=responsable.getResponsableOriginal().getid_empresa().toString();
				}
				if(responsable.getid_empresa()!=null)
				{
					strValorNuevo=responsable.getid_empresa().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ResponsableConstantesFunciones.IDEMPRESA,strValorActual,strValorNuevo);
			}	
			
			if(responsable.getIsNew()||!responsable.getid_sucursal().equals(responsable.getResponsableOriginal().getid_sucursal()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(responsable.getResponsableOriginal().getid_sucursal()!=null)
				{
					strValorActual=responsable.getResponsableOriginal().getid_sucursal().toString();
				}
				if(responsable.getid_sucursal()!=null)
				{
					strValorNuevo=responsable.getid_sucursal().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ResponsableConstantesFunciones.IDSUCURSAL,strValorActual,strValorNuevo);
			}	
			
			if(responsable.getIsNew()||!responsable.getid_cliente().equals(responsable.getResponsableOriginal().getid_cliente()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(responsable.getResponsableOriginal().getid_cliente()!=null)
				{
					strValorActual=responsable.getResponsableOriginal().getid_cliente().toString();
				}
				if(responsable.getid_cliente()!=null)
				{
					strValorNuevo=responsable.getid_cliente().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ResponsableConstantesFunciones.IDCLIENTE,strValorActual,strValorNuevo);
			}	
			
			if(responsable.getIsNew()||!responsable.getid_usuario().equals(responsable.getResponsableOriginal().getid_usuario()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(responsable.getResponsableOriginal().getid_usuario()!=null)
				{
					strValorActual=responsable.getResponsableOriginal().getid_usuario().toString();
				}
				if(responsable.getid_usuario()!=null)
				{
					strValorNuevo=responsable.getid_usuario().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ResponsableConstantesFunciones.IDUSUARIO,strValorActual,strValorNuevo);
			}	
			
			if(responsable.getIsNew()||!responsable.getidentificacion().equals(responsable.getResponsableOriginal().getidentificacion()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(responsable.getResponsableOriginal().getidentificacion()!=null)
				{
					strValorActual=responsable.getResponsableOriginal().getidentificacion();
				}
				if(responsable.getidentificacion()!=null)
				{
					strValorNuevo=responsable.getidentificacion() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ResponsableConstantesFunciones.IDENTIFICACION,strValorActual,strValorNuevo);
			}	
			
			if(responsable.getIsNew()||!responsable.getruc().equals(responsable.getResponsableOriginal().getruc()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(responsable.getResponsableOriginal().getruc()!=null)
				{
					strValorActual=responsable.getResponsableOriginal().getruc();
				}
				if(responsable.getruc()!=null)
				{
					strValorNuevo=responsable.getruc() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ResponsableConstantesFunciones.RUC,strValorActual,strValorNuevo);
			}	
			
			if(responsable.getIsNew()||!responsable.getnombre().equals(responsable.getResponsableOriginal().getnombre()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(responsable.getResponsableOriginal().getnombre()!=null)
				{
					strValorActual=responsable.getResponsableOriginal().getnombre();
				}
				if(responsable.getnombre()!=null)
				{
					strValorNuevo=responsable.getnombre() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ResponsableConstantesFunciones.NOMBRE,strValorActual,strValorNuevo);
			}	
			
			if(responsable.getIsNew()||!responsable.getapellido().equals(responsable.getResponsableOriginal().getapellido()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(responsable.getResponsableOriginal().getapellido()!=null)
				{
					strValorActual=responsable.getResponsableOriginal().getapellido();
				}
				if(responsable.getapellido()!=null)
				{
					strValorNuevo=responsable.getapellido() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ResponsableConstantesFunciones.APELLIDO,strValorActual,strValorNuevo);
			}	
			
			if(responsable.getIsNew()||!responsable.getnombre_completo().equals(responsable.getResponsableOriginal().getnombre_completo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(responsable.getResponsableOriginal().getnombre_completo()!=null)
				{
					strValorActual=responsable.getResponsableOriginal().getnombre_completo();
				}
				if(responsable.getnombre_completo()!=null)
				{
					strValorNuevo=responsable.getnombre_completo() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ResponsableConstantesFunciones.NOMBRECOMPLETO,strValorActual,strValorNuevo);
			}	
			
			if(responsable.getIsNew()||!responsable.getemail().equals(responsable.getResponsableOriginal().getemail()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(responsable.getResponsableOriginal().getemail()!=null)
				{
					strValorActual=responsable.getResponsableOriginal().getemail();
				}
				if(responsable.getemail()!=null)
				{
					strValorNuevo=responsable.getemail() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ResponsableConstantesFunciones.EMAIL,strValorActual,strValorNuevo);
			}	
			
			if(responsable.getIsNew()||!responsable.gettelefono().equals(responsable.getResponsableOriginal().gettelefono()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(responsable.getResponsableOriginal().gettelefono()!=null)
				{
					strValorActual=responsable.getResponsableOriginal().gettelefono();
				}
				if(responsable.gettelefono()!=null)
				{
					strValorNuevo=responsable.gettelefono() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ResponsableConstantesFunciones.TELEFONO,strValorActual,strValorNuevo);
			}	
			
			if(responsable.getIsNew()||!responsable.gettelefono_celular().equals(responsable.getResponsableOriginal().gettelefono_celular()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(responsable.getResponsableOriginal().gettelefono_celular()!=null)
				{
					strValorActual=responsable.getResponsableOriginal().gettelefono_celular();
				}
				if(responsable.gettelefono_celular()!=null)
				{
					strValorNuevo=responsable.gettelefono_celular() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ResponsableConstantesFunciones.TELEFONOCELULAR,strValorActual,strValorNuevo);
			}	
			
			if(responsable.getIsNew()||!responsable.getdireccion().equals(responsable.getResponsableOriginal().getdireccion()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(responsable.getResponsableOriginal().getdireccion()!=null)
				{
					strValorActual=responsable.getResponsableOriginal().getdireccion();
				}
				if(responsable.getdireccion()!=null)
				{
					strValorNuevo=responsable.getdireccion() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ResponsableConstantesFunciones.DIRECCION,strValorActual,strValorNuevo);
			}	
			
			if(responsable.getIsNew()||!responsable.getfax().equals(responsable.getResponsableOriginal().getfax()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(responsable.getResponsableOriginal().getfax()!=null)
				{
					strValorActual=responsable.getResponsableOriginal().getfax();
				}
				if(responsable.getfax()!=null)
				{
					strValorNuevo=responsable.getfax() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ResponsableConstantesFunciones.FAX,strValorActual,strValorNuevo);
			}	
			
			if(responsable.getIsNew()||!responsable.getobservacion().equals(responsable.getResponsableOriginal().getobservacion()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(responsable.getResponsableOriginal().getobservacion()!=null)
				{
					strValorActual=responsable.getResponsableOriginal().getobservacion();
				}
				if(responsable.getobservacion()!=null)
				{
					strValorNuevo=responsable.getobservacion() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ResponsableConstantesFunciones.OBSERVACION,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void saveResponsableRelacionesWithConnection(Responsable responsable,List<Factura> facturas,List<Consignacion> consignacions,List<Pedido> pedidos,List<PedidoExpor> pedidoexpors,List<NotaCreditoSoli> notacreditosolis) throws Exception {

		if(!responsable.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveResponsableRelacionesBase(responsable,facturas,consignacions,pedidos,pedidoexpors,notacreditosolis,true);
		}
	}

	public void saveResponsableRelaciones(Responsable responsable,List<Factura> facturas,List<Consignacion> consignacions,List<Pedido> pedidos,List<PedidoExpor> pedidoexpors,List<NotaCreditoSoli> notacreditosolis)throws Exception {

		if(!responsable.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveResponsableRelacionesBase(responsable,facturas,consignacions,pedidos,pedidoexpors,notacreditosolis,false);
		}
	}

	public void saveResponsableRelacionesBase(Responsable responsable,List<Factura> facturas,List<Consignacion> consignacions,List<Pedido> pedidos,List<PedidoExpor> pedidoexpors,List<NotaCreditoSoli> notacreditosolis,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("Responsable-saveRelacionesWithConnection");}
	
			responsable.setFacturas(facturas);
			responsable.setConsignacions(consignacions);
			responsable.setPedidos(pedidos);
			responsable.setPedidoExpors(pedidoexpors);
			responsable.setNotaCreditoSolis(notacreditosolis);

			this.setResponsable(responsable);

			if(ResponsableLogicAdditional.validarSaveRelaciones(responsable,this)) {

				ResponsableLogicAdditional.updateRelacionesToSave(responsable,this);

				if((responsable.getIsNew()||responsable.getIsChanged())&&!responsable.getIsDeleted()) {
					this.saveResponsable();
					this.saveResponsableRelacionesDetalles(facturas,consignacions,pedidos,pedidoexpors,notacreditosolis);

				} else if(responsable.getIsDeleted()) {
					this.saveResponsableRelacionesDetalles(facturas,consignacions,pedidos,pedidoexpors,notacreditosolis);
					this.saveResponsable();
				}

				ResponsableLogicAdditional.updateRelacionesToSaveAfter(responsable,this);

			} else {
				throw new Exception("LOS DATOS SON INVALIDOS");
			}

			if(conConexion) {connexion.commit();}

		} catch(Exception e) {
			
			FacturaConstantesFunciones.InicializarGeneralEntityAuxiliaresFacturas(facturas,true,true);
			ConsignacionConstantesFunciones.InicializarGeneralEntityAuxiliaresConsignacions(consignacions,true,true);
			PedidoConstantesFunciones.InicializarGeneralEntityAuxiliaresPedidos(pedidos,true,true);
			PedidoExporConstantesFunciones.InicializarGeneralEntityAuxiliaresPedidoExpors(pedidoexpors,true,true);
			NotaCreditoSoliConstantesFunciones.InicializarGeneralEntityAuxiliaresNotaCreditoSolis(notacreditosolis,true,true);

			if(conConexion){connexion.rollback();}
			Funciones.manageException(logger,e);
			throw e;

		} finally {
			if(conConexion){this.closeNewConnexionToDeep();}
		}
	}
	
	
	private void saveResponsableRelacionesDetalles(List<Factura> facturas,List<Consignacion> consignacions,List<Pedido> pedidos,List<PedidoExpor> pedidoexpors,List<NotaCreditoSoli> notacreditosolis)throws Exception {
		try {
	

			Long idResponsableActual=this.getResponsable().getId();

			FacturaLogic facturaLogic_Desde_Responsable=new FacturaLogic();
			facturaLogic_Desde_Responsable.setFacturas(facturas);

			facturaLogic_Desde_Responsable.setConnexion(this.getConnexion());
			facturaLogic_Desde_Responsable.setDatosCliente(this.datosCliente);

			for(Factura factura_Desde_Responsable:facturaLogic_Desde_Responsable.getFacturas()) {
				factura_Desde_Responsable.setid_responsable(idResponsableActual);

				facturaLogic_Desde_Responsable.setFactura(factura_Desde_Responsable);
				facturaLogic_Desde_Responsable.saveFactura();

				Long idFacturaActual=factura_Desde_Responsable.getId();

				DetaFormaPagoLogic detaformapagoLogic_Desde_Factura=new DetaFormaPagoLogic();

				if(factura_Desde_Responsable.getDetaFormaPagos()==null){
					factura_Desde_Responsable.setDetaFormaPagos(new ArrayList<DetaFormaPago>());
				}

				detaformapagoLogic_Desde_Factura.setDetaFormaPagos(factura_Desde_Responsable.getDetaFormaPagos());

				detaformapagoLogic_Desde_Factura.setConnexion(this.getConnexion());
				detaformapagoLogic_Desde_Factura.setDatosCliente(this.datosCliente);

				for(DetaFormaPago detaformapago_Desde_Factura:detaformapagoLogic_Desde_Factura.getDetaFormaPagos()) {
					detaformapago_Desde_Factura.setid_factura(idFacturaActual);

					detaformapagoLogic_Desde_Factura.setDetaFormaPago(detaformapago_Desde_Factura);
					detaformapagoLogic_Desde_Factura.saveDetaFormaPago();

					Long idDetaFormaPagoActual=detaformapago_Desde_Factura.getId();

					BancoFormaPagoLogic bancoformapagoLogic_Desde_DetaFormaPago=new BancoFormaPagoLogic();

					if(detaformapago_Desde_Factura.getBancoFormaPagos()==null){
						detaformapago_Desde_Factura.setBancoFormaPagos(new ArrayList<BancoFormaPago>());
					}

					bancoformapagoLogic_Desde_DetaFormaPago.setBancoFormaPagos(detaformapago_Desde_Factura.getBancoFormaPagos());

					bancoformapagoLogic_Desde_DetaFormaPago.setConnexion(this.getConnexion());
					bancoformapagoLogic_Desde_DetaFormaPago.setDatosCliente(this.datosCliente);

					for(BancoFormaPago bancoformapago_Desde_DetaFormaPago:bancoformapagoLogic_Desde_DetaFormaPago.getBancoFormaPagos()) {
						bancoformapago_Desde_DetaFormaPago.setid_deta_forma_pago(idDetaFormaPagoActual);
					}

					bancoformapagoLogic_Desde_DetaFormaPago.saveBancoFormaPagos();
				}


				DetalleFacturaLogic detallefacturaLogic_Desde_Factura=new DetalleFacturaLogic();

				if(factura_Desde_Responsable.getDetalleFacturas()==null){
					factura_Desde_Responsable.setDetalleFacturas(new ArrayList<DetalleFactura>());
				}

				detallefacturaLogic_Desde_Factura.setDetalleFacturas(factura_Desde_Responsable.getDetalleFacturas());

				detallefacturaLogic_Desde_Factura.setConnexion(this.getConnexion());
				detallefacturaLogic_Desde_Factura.setDatosCliente(this.datosCliente);

				for(DetalleFactura detallefactura_Desde_Factura:detallefacturaLogic_Desde_Factura.getDetalleFacturas()) {
					detallefactura_Desde_Factura.setid_factura(idFacturaActual);
				}

				detallefacturaLogic_Desde_Factura.saveDetalleFacturas();
			}


			ConsignacionLogic consignacionLogic_Desde_Responsable=new ConsignacionLogic();
			consignacionLogic_Desde_Responsable.setConsignacions(consignacions);

			consignacionLogic_Desde_Responsable.setConnexion(this.getConnexion());
			consignacionLogic_Desde_Responsable.setDatosCliente(this.datosCliente);

			for(Consignacion consignacion_Desde_Responsable:consignacionLogic_Desde_Responsable.getConsignacions()) {
				consignacion_Desde_Responsable.setid_responsable(idResponsableActual);

				consignacionLogic_Desde_Responsable.setConsignacion(consignacion_Desde_Responsable);
				consignacionLogic_Desde_Responsable.saveConsignacion();

				Long idConsignacionActual=consignacion_Desde_Responsable.getId();

				DetalleConsignacionLogic detalleconsignacionLogic_Desde_Consignacion=new DetalleConsignacionLogic();

				if(consignacion_Desde_Responsable.getDetalleConsignacions()==null){
					consignacion_Desde_Responsable.setDetalleConsignacions(new ArrayList<DetalleConsignacion>());
				}

				detalleconsignacionLogic_Desde_Consignacion.setDetalleConsignacions(consignacion_Desde_Responsable.getDetalleConsignacions());

				detalleconsignacionLogic_Desde_Consignacion.setConnexion(this.getConnexion());
				detalleconsignacionLogic_Desde_Consignacion.setDatosCliente(this.datosCliente);

				for(DetalleConsignacion detalleconsignacion_Desde_Consignacion:detalleconsignacionLogic_Desde_Consignacion.getDetalleConsignacions()) {
					detalleconsignacion_Desde_Consignacion.setid_consignacion(idConsignacionActual);
				}

				detalleconsignacionLogic_Desde_Consignacion.saveDetalleConsignacions();
			}


			PedidoLogic pedidoLogic_Desde_Responsable=new PedidoLogic();
			pedidoLogic_Desde_Responsable.setPedidos(pedidos);

			pedidoLogic_Desde_Responsable.setConnexion(this.getConnexion());
			pedidoLogic_Desde_Responsable.setDatosCliente(this.datosCliente);

			for(Pedido pedido_Desde_Responsable:pedidoLogic_Desde_Responsable.getPedidos()) {
				pedido_Desde_Responsable.setid_responsable(idResponsableActual);

				pedidoLogic_Desde_Responsable.setPedido(pedido_Desde_Responsable);
				pedidoLogic_Desde_Responsable.savePedido();

				Long idPedidoActual=pedido_Desde_Responsable.getId();

				DetallePedidoLogic detallepedidoLogic_Desde_Pedido=new DetallePedidoLogic();

				if(pedido_Desde_Responsable.getDetallePedidos()==null){
					pedido_Desde_Responsable.setDetallePedidos(new ArrayList<DetallePedido>());
				}

				detallepedidoLogic_Desde_Pedido.setDetallePedidos(pedido_Desde_Responsable.getDetallePedidos());

				detallepedidoLogic_Desde_Pedido.setConnexion(this.getConnexion());
				detallepedidoLogic_Desde_Pedido.setDatosCliente(this.datosCliente);

				for(DetallePedido detallepedido_Desde_Pedido:detallepedidoLogic_Desde_Pedido.getDetallePedidos()) {
					detallepedido_Desde_Pedido.setid_pedido(idPedidoActual);
				}

				detallepedidoLogic_Desde_Pedido.saveDetallePedidos();
			}


			PedidoExporLogic pedidoexporLogic_Desde_Responsable=new PedidoExporLogic();
			pedidoexporLogic_Desde_Responsable.setPedidoExpors(pedidoexpors);

			pedidoexporLogic_Desde_Responsable.setConnexion(this.getConnexion());
			pedidoexporLogic_Desde_Responsable.setDatosCliente(this.datosCliente);

			for(PedidoExpor pedidoexpor_Desde_Responsable:pedidoexporLogic_Desde_Responsable.getPedidoExpors()) {
				pedidoexpor_Desde_Responsable.setid_responsable(idResponsableActual);

				pedidoexporLogic_Desde_Responsable.setPedidoExpor(pedidoexpor_Desde_Responsable);
				pedidoexporLogic_Desde_Responsable.savePedidoExpor();

				Long idPedidoExporActual=pedidoexpor_Desde_Responsable.getId();

				DetallePedidoExporLogic detallepedidoexporLogic_Desde_PedidoExpor=new DetallePedidoExporLogic();

				if(pedidoexpor_Desde_Responsable.getDetallePedidoExpors()==null){
					pedidoexpor_Desde_Responsable.setDetallePedidoExpors(new ArrayList<DetallePedidoExpor>());
				}

				detallepedidoexporLogic_Desde_PedidoExpor.setDetallePedidoExpors(pedidoexpor_Desde_Responsable.getDetallePedidoExpors());

				detallepedidoexporLogic_Desde_PedidoExpor.setConnexion(this.getConnexion());
				detallepedidoexporLogic_Desde_PedidoExpor.setDatosCliente(this.datosCliente);

				for(DetallePedidoExpor detallepedidoexpor_Desde_PedidoExpor:detallepedidoexporLogic_Desde_PedidoExpor.getDetallePedidoExpors()) {
					detallepedidoexpor_Desde_PedidoExpor.setid_pedido_expor(idPedidoExporActual);
				}

				detallepedidoexporLogic_Desde_PedidoExpor.saveDetallePedidoExpors();
			}


			NotaCreditoSoliLogic notacreditosoliLogic_Desde_Responsable=new NotaCreditoSoliLogic();
			notacreditosoliLogic_Desde_Responsable.setNotaCreditoSolis(notacreditosolis);

			notacreditosoliLogic_Desde_Responsable.setConnexion(this.getConnexion());
			notacreditosoliLogic_Desde_Responsable.setDatosCliente(this.datosCliente);

			for(NotaCreditoSoli notacreditosoli_Desde_Responsable:notacreditosoliLogic_Desde_Responsable.getNotaCreditoSolis()) {
				notacreditosoli_Desde_Responsable.setid_responsable(idResponsableActual);

				notacreditosoliLogic_Desde_Responsable.setNotaCreditoSoli(notacreditosoli_Desde_Responsable);
				notacreditosoliLogic_Desde_Responsable.saveNotaCreditoSoli();
			}


		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfResponsable(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=ResponsableConstantesFunciones.getClassesForeignKeysOfResponsable(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfResponsable(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=ResponsableConstantesFunciones.getClassesRelationshipsOfResponsable(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}
