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
import com.bydan.erp.inventario.util.ArancelConstantesFunciones;
import com.bydan.erp.inventario.util.ArancelParameterReturnGeneral;
//import com.bydan.erp.inventario.util.ArancelParameterGeneral;
import com.bydan.erp.inventario.business.entity.Arancel;
import com.bydan.erp.inventario.business.logic.ArancelLogicAdditional;
import com.bydan.erp.inventario.business.dataaccess.*;
import com.bydan.erp.inventario.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.facturacion.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.importaciones.business.entity.*;


import com.bydan.erp.seguridad.business.logic.*;
import com.bydan.erp.facturacion.business.logic.*;
import com.bydan.erp.cartera.business.logic.*;
import com.bydan.erp.importaciones.business.logic.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.facturacion.util.*;
import com.bydan.erp.cartera.util.*;
import com.bydan.erp.importaciones.util.*;


import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.facturacion.business.dataaccess.*;
import com.bydan.erp.cartera.business.dataaccess.*;
import com.bydan.erp.importaciones.business.dataaccess.*;








@SuppressWarnings("unused")
public class ArancelLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(ArancelLogic.class);
	
	protected ArancelDataAccess arancelDataAccess; 	
	protected Arancel arancel;
	protected List<Arancel> arancels;
	protected Object arancelObject;	
	protected List<Object> arancelsObject;
	
	public static ClassValidator<Arancel> arancelValidator = new ClassValidator<Arancel>(Arancel.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected ArancelLogicAdditional arancelLogicAdditional=null;
	
	public ArancelLogicAdditional getArancelLogicAdditional() {
		return this.arancelLogicAdditional;
	}
	
	public void setArancelLogicAdditional(ArancelLogicAdditional arancelLogicAdditional) {
		try {
			this.arancelLogicAdditional=arancelLogicAdditional;
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
	
	
	
	
	public  ArancelLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.arancelDataAccess = new ArancelDataAccess();
			
			this.arancels= new ArrayList<Arancel>();
			this.arancel= new Arancel();
			
			this.arancelObject=new Object();
			this.arancelsObject=new ArrayList<Object>();
				
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
			
			this.arancelDataAccess.setConnexionType(this.connexionType);
			this.arancelDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  ArancelLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.arancelDataAccess = new ArancelDataAccess();
			this.arancels= new ArrayList<Arancel>();
			this.arancel= new Arancel();
			this.arancelObject=new Object();
			this.arancelsObject=new ArrayList<Object>();
			
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
			
			this.arancelDataAccess.setConnexionType(this.connexionType);
			this.arancelDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public Arancel getArancel() throws Exception {	
		ArancelLogicAdditional.checkArancelToGet(arancel,this.datosCliente,this.arrDatoGeneral);
		ArancelLogicAdditional.updateArancelToGet(arancel,this.arrDatoGeneral);
		
		return arancel;
	}
		
	public void setArancel(Arancel newArancel) {
		this.arancel = newArancel;
	}
	
	public ArancelDataAccess getArancelDataAccess() {
		return arancelDataAccess;
	}
	
	public void setArancelDataAccess(ArancelDataAccess newarancelDataAccess) {
		this.arancelDataAccess = newarancelDataAccess;
	}
	
	public List<Arancel> getArancels() throws Exception {		
		this.quitarArancelsNulos();
		
		ArancelLogicAdditional.checkArancelToGets(arancels,this.datosCliente,this.arrDatoGeneral);
		
		for (Arancel arancelLocal: arancels ) {
			ArancelLogicAdditional.updateArancelToGet(arancelLocal,this.arrDatoGeneral);
		}
		
		return arancels;
	}
	
	public void setArancels(List<Arancel> newArancels) {
		this.arancels = newArancels;
	}
	
	public Object getArancelObject() {	
		this.arancelObject=this.arancelDataAccess.getEntityObject();
		return this.arancelObject;
	}
		
	public void setArancelObject(Object newArancelObject) {
		this.arancelObject = newArancelObject;
	}
	
	public List<Object> getArancelsObject() {		
		this.arancelsObject=this.arancelDataAccess.getEntitiesObject();
		return this.arancelsObject;
	}
		
	public void setArancelsObject(List<Object> newArancelsObject) {
		this.arancelsObject = newArancelsObject;
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
		
		if(this.arancelDataAccess!=null) {
			this.arancelDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Arancel.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			arancelDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			arancelDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		arancel = new  Arancel();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Arancel.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			arancel=arancelDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.arancel,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				ArancelConstantesFunciones.refrescarForeignKeysDescripcionesArancel(this.arancel);
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
		arancel = new  Arancel();
		  		  
        try {
			
			arancel=arancelDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.arancel,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				ArancelConstantesFunciones.refrescarForeignKeysDescripcionesArancel(this.arancel);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		arancel = new  Arancel();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Arancel.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			arancel=arancelDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.arancel,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				ArancelConstantesFunciones.refrescarForeignKeysDescripcionesArancel(this.arancel);
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
		arancel = new  Arancel();
		  		  
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
		arancel = new  Arancel();
		  		  
        try {
			
			arancel=arancelDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.arancel,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				ArancelConstantesFunciones.refrescarForeignKeysDescripcionesArancel(this.arancel);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		arancel = new  Arancel();
		  		  
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
		arancel = new  Arancel();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Arancel.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =arancelDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		arancel = new  Arancel();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=arancelDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		arancel = new  Arancel();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Arancel.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =arancelDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		arancel = new  Arancel();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=arancelDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		arancel = new  Arancel();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Arancel.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =arancelDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		arancel = new  Arancel();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=arancelDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		arancels = new  ArrayList<Arancel>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Arancel.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			ArancelLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			arancels=arancelDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarArancel(arancels);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ArancelConstantesFunciones.refrescarForeignKeysDescripcionesArancel(this.arancels);
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
		arancels = new  ArrayList<Arancel>();
		  		  
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
		arancels = new  ArrayList<Arancel>();
		  		  
        try {			
			ArancelLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			arancels=arancelDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarArancel(arancels);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ArancelConstantesFunciones.refrescarForeignKeysDescripcionesArancel(this.arancels);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		arancels = new  ArrayList<Arancel>();
		  		  
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
		arancels = new  ArrayList<Arancel>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Arancel.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			ArancelLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			arancels=arancelDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarArancel(arancels);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ArancelConstantesFunciones.refrescarForeignKeysDescripcionesArancel(this.arancels);
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
		arancels = new  ArrayList<Arancel>();
		  		  
        try {
			ArancelLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			arancels=arancelDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarArancel(arancels);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ArancelConstantesFunciones.refrescarForeignKeysDescripcionesArancel(this.arancels);
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
		arancels = new  ArrayList<Arancel>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Arancel.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ArancelLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			arancels=arancelDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarArancel(arancels);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ArancelConstantesFunciones.refrescarForeignKeysDescripcionesArancel(this.arancels);
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
		arancels = new  ArrayList<Arancel>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ArancelLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			arancels=arancelDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarArancel(arancels);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ArancelConstantesFunciones.refrescarForeignKeysDescripcionesArancel(this.arancels);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		arancel = new  Arancel();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Arancel.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ArancelLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			arancel=arancelDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarArancel(arancel);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ArancelConstantesFunciones.refrescarForeignKeysDescripcionesArancel(this.arancel);
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
		arancel = new  Arancel();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ArancelLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			arancel=arancelDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarArancel(arancel);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ArancelConstantesFunciones.refrescarForeignKeysDescripcionesArancel(this.arancel);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		arancels = new  ArrayList<Arancel>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Arancel.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			ArancelLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			arancels=arancelDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarArancel(arancels);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ArancelConstantesFunciones.refrescarForeignKeysDescripcionesArancel(this.arancels);
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
		arancels = new  ArrayList<Arancel>();
		  		  
        try {
			ArancelLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			arancels=arancelDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarArancel(arancels);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ArancelConstantesFunciones.refrescarForeignKeysDescripcionesArancel(this.arancels);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosArancelsWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		arancels = new  ArrayList<Arancel>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Arancel.class.getSimpleName()+"-getTodosArancelsWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ArancelLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			arancels=arancelDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarArancel(arancels);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ArancelConstantesFunciones.refrescarForeignKeysDescripcionesArancel(this.arancels);
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
	
	public  void  getTodosArancels(String sFinalQuery,Pagination pagination)throws Exception {
		arancels = new  ArrayList<Arancel>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ArancelLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			arancels=arancelDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarArancel(arancels);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ArancelConstantesFunciones.refrescarForeignKeysDescripcionesArancel(this.arancels);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarArancel(Arancel arancel) throws Exception {
		Boolean estaValidado=false;
		
		if(arancel.getIsNew() || arancel.getIsChanged()) { 
			this.invalidValues = arancelValidator.getInvalidValues(arancel);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(arancel);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarArancel(List<Arancel> Arancels) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(Arancel arancelLocal:arancels) {				
			estaValidadoObjeto=this.validarGuardarArancel(arancelLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarArancel(List<Arancel> Arancels) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarArancel(arancels)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarArancel(Arancel Arancel) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarArancel(arancel)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(Arancel arancel) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+arancel.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=ArancelConstantesFunciones.getArancelLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"arancel","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(ArancelConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(ArancelConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveArancelWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Arancel.class.getSimpleName()+"-saveArancelWithConnection");connexion.begin();			
			
			ArancelLogicAdditional.checkArancelToSave(this.arancel,this.datosCliente,connexion,this.arrDatoGeneral);
			
			ArancelLogicAdditional.updateArancelToSave(this.arancel,this.arrDatoGeneral);
			
			ArancelLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.arancel,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowArancel();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarArancel(this.arancel)) {
				ArancelDataAccess.save(this.arancel, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.arancel,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			ArancelLogicAdditional.checkArancelToSaveAfter(this.arancel,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowArancel();
			
			connexion.commit();			
			
			if(this.arancel.getIsDeleted()) {
				this.arancel=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveArancel()throws Exception {	
		try {	
			
			ArancelLogicAdditional.checkArancelToSave(this.arancel,this.datosCliente,connexion,this.arrDatoGeneral);
			
			ArancelLogicAdditional.updateArancelToSave(this.arancel,this.arrDatoGeneral);
			
			ArancelLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.arancel,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarArancel(this.arancel)) {			
				ArancelDataAccess.save(this.arancel, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.arancel,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			ArancelLogicAdditional.checkArancelToSaveAfter(this.arancel,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.arancel.getIsDeleted()) {
				this.arancel=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveArancelsWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Arancel.class.getSimpleName()+"-saveArancelsWithConnection");connexion.begin();			
			
			ArancelLogicAdditional.checkArancelToSaves(arancels,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowArancels();
			
			Boolean validadoTodosArancel=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(Arancel arancelLocal:arancels) {		
				if(arancelLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				ArancelLogicAdditional.updateArancelToSave(arancelLocal,this.arrDatoGeneral);
	        	
				ArancelLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),arancelLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarArancel(arancelLocal)) {
					ArancelDataAccess.save(arancelLocal, connexion);				
				} else {
					validadoTodosArancel=false;
				}
			}
			
			if(!validadoTodosArancel) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			ArancelLogicAdditional.checkArancelToSavesAfter(arancels,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowArancels();
			
			connexion.commit();		
			
			this.quitarArancelsEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveArancels()throws Exception {				
		 try {	
			ArancelLogicAdditional.checkArancelToSaves(arancels,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosArancel=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(Arancel arancelLocal:arancels) {				
				if(arancelLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				ArancelLogicAdditional.updateArancelToSave(arancelLocal,this.arrDatoGeneral);
	        	
				ArancelLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),arancelLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarArancel(arancelLocal)) {				
					ArancelDataAccess.save(arancelLocal, connexion);				
				} else {
					validadoTodosArancel=false;
				}
			}
			
			if(!validadoTodosArancel) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			ArancelLogicAdditional.checkArancelToSavesAfter(arancels,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarArancelsEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public ArancelParameterReturnGeneral procesarAccionArancels(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<Arancel> arancels,ArancelParameterReturnGeneral arancelParameterGeneral)throws Exception {
		 try {	
			ArancelParameterReturnGeneral arancelReturnGeneral=new ArancelParameterReturnGeneral();
	
			ArancelLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,arancels,arancelParameterGeneral,arancelReturnGeneral);
			
			return arancelReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public ArancelParameterReturnGeneral procesarAccionArancelsWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<Arancel> arancels,ArancelParameterReturnGeneral arancelParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Arancel.class.getSimpleName()+"-procesarAccionArancelsWithConnection");connexion.begin();			
			
			ArancelParameterReturnGeneral arancelReturnGeneral=new ArancelParameterReturnGeneral();
	
			ArancelLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,arancels,arancelParameterGeneral,arancelReturnGeneral);
			
			this.connexion.commit();
			
			return arancelReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public ArancelParameterReturnGeneral procesarEventosArancels(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<Arancel> arancels,Arancel arancel,ArancelParameterReturnGeneral arancelParameterGeneral,Boolean isEsNuevoArancel,ArrayList<Classe> clases)throws Exception {
		 try {	
			ArancelParameterReturnGeneral arancelReturnGeneral=new ArancelParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				arancelReturnGeneral.setConRecargarPropiedades(true);
			}
			
			ArancelLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,arancels,arancel,arancelParameterGeneral,arancelReturnGeneral,isEsNuevoArancel,clases);
			
			return arancelReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public ArancelParameterReturnGeneral procesarEventosArancelsWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<Arancel> arancels,Arancel arancel,ArancelParameterReturnGeneral arancelParameterGeneral,Boolean isEsNuevoArancel,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Arancel.class.getSimpleName()+"-procesarEventosArancelsWithConnection");connexion.begin();			
			
			ArancelParameterReturnGeneral arancelReturnGeneral=new ArancelParameterReturnGeneral();
	
			arancelReturnGeneral.setArancel(arancel);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				arancelReturnGeneral.setConRecargarPropiedades(true);
			}
			
			ArancelLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,arancels,arancel,arancelParameterGeneral,arancelReturnGeneral,isEsNuevoArancel,clases);
			
			this.connexion.commit();
			
			return arancelReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public ArancelParameterReturnGeneral procesarImportacionArancelsWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,ArancelParameterReturnGeneral arancelParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Arancel.class.getSimpleName()+"-procesarImportacionArancelsWithConnection");connexion.begin();			
			
			ArancelParameterReturnGeneral arancelReturnGeneral=new ArancelParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.arancels=new ArrayList<Arancel>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.arancel=new Arancel();
				
				
				if(conColumnasBase) {this.arancel.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.arancel.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.arancel.setcodigo(arrColumnas[iColumn++]);
				this.arancel.setnombre(arrColumnas[iColumn++]);
				this.arancel.setporcentaje(Double.parseDouble(arrColumnas[iColumn++]));
				this.arancel.setobservacion(arrColumnas[iColumn++]);
				
				this.arancels.add(this.arancel);
			}
			
			this.saveArancels();
			
			this.connexion.commit();
			
			arancelReturnGeneral.setConRetornoEstaProcesado(true);
			arancelReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return arancelReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarArancelsEliminados() throws Exception {				
		
		List<Arancel> arancelsAux= new ArrayList<Arancel>();
		
		for(Arancel arancel:arancels) {
			if(!arancel.getIsDeleted()) {
				arancelsAux.add(arancel);
			}
		}
		
		arancels=arancelsAux;
	}
	
	public void quitarArancelsNulos() throws Exception {				
		
		List<Arancel> arancelsAux= new ArrayList<Arancel>();
		
		for(Arancel arancel : this.arancels) {
			if(arancel==null) {
				arancelsAux.add(arancel);
			}
		}
		
		//this.arancels=arancelsAux;
		
		this.arancels.removeAll(arancelsAux);
	}
	
	public void getSetVersionRowArancelWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(arancel.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((arancel.getIsDeleted() || (arancel.getIsChanged()&&!arancel.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=arancelDataAccess.getSetVersionRowArancel(connexion,arancel.getId());
				
				if(!arancel.getVersionRow().equals(timestamp)) {	
					arancel.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				arancel.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowArancel()throws Exception {	
		
		if(arancel.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((arancel.getIsDeleted() || (arancel.getIsChanged()&&!arancel.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=arancelDataAccess.getSetVersionRowArancel(connexion,arancel.getId());
			
			try {							
				if(!arancel.getVersionRow().equals(timestamp)) {	
					arancel.setVersionRow(timestamp);
				}
				
				arancel.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowArancelsWithConnection()throws Exception {	
		if(arancels!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(Arancel arancelAux:arancels) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(arancelAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(arancelAux.getIsDeleted() || (arancelAux.getIsChanged()&&!arancelAux.getIsNew())) {
						
						timestamp=arancelDataAccess.getSetVersionRowArancel(connexion,arancelAux.getId());
						
						if(!arancel.getVersionRow().equals(timestamp)) {	
							arancelAux.setVersionRow(timestamp);
						}
								
						arancelAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowArancels()throws Exception {	
		if(arancels!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(Arancel arancelAux:arancels) {
					if(arancelAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(arancelAux.getIsDeleted() || (arancelAux.getIsChanged()&&!arancelAux.getIsNew())) {
						
						timestamp=arancelDataAccess.getSetVersionRowArancel(connexion,arancelAux.getId());
						
						if(!arancelAux.getVersionRow().equals(timestamp)) {	
							arancelAux.setVersionRow(timestamp);
						}
						
													
						arancelAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public ArancelParameterReturnGeneral cargarCombosLoteForeignKeyArancelWithConnection(String finalQueryGlobalEmpresa) throws Exception {
		ArancelParameterReturnGeneral  arancelReturnGeneral =new ArancelParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Arancel.class.getSimpleName()+"-cargarCombosLoteForeignKeyArancelWithConnection");connexion.begin();
			
			arancelReturnGeneral =new ArancelParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			arancelReturnGeneral.setempresasForeignKey(empresasForeignKey);

			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
		
		return arancelReturnGeneral;
	}
	
	public ArancelParameterReturnGeneral cargarCombosLoteForeignKeyArancel(String finalQueryGlobalEmpresa) throws Exception {
		ArancelParameterReturnGeneral  arancelReturnGeneral =new ArancelParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {						
			arancelReturnGeneral =new ArancelParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			arancelReturnGeneral.setempresasForeignKey(empresasForeignKey);
						
			
		} catch(Exception e) {			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			
		}
		
		return arancelReturnGeneral;
	}
	
	public void cargarRelacionesLoteForeignKeyArancelWithConnection() throws Exception {
		ArrayList<Classe> classes=new ArrayList<Classe>();		
		
		
			ProductoLogic productoLogic=new ProductoLogic();
			DetallePedidoCompraImporLogic detallepedidocompraimporLogic=new DetallePedidoCompraImporLogic();
		
		try {
			
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Arancel.class.getSimpleName()+"-cargarRelacionesLoteForeignKeyArancelWithConnection");connexion.begin();
			
			
			classes.add(new Classe(Producto.class));
			classes.add(new Classe(DetallePedidoCompraImpor.class));
											
			

			productoLogic.setConnexion(this.getConnexion());
			productoLogic.setDatosCliente(this.datosCliente);
			productoLogic.setIsConRefrescarForeignKeys(true);

			detallepedidocompraimporLogic.setConnexion(this.getConnexion());
			detallepedidocompraimporLogic.setDatosCliente(this.datosCliente);
			detallepedidocompraimporLogic.setIsConRefrescarForeignKeys(true);
			
			this.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
			
			for(Arancel arancel:this.arancels) {
				

				classes=new ArrayList<Classe>();
				classes=ProductoConstantesFunciones.getClassesForeignKeysOfProducto(new ArrayList<Classe>(),DeepLoadType.NONE);

				productoLogic.setProductos(arancel.productos);
				productoLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");

				classes=new ArrayList<Classe>();
				classes=DetallePedidoCompraImporConstantesFunciones.getClassesForeignKeysOfDetallePedidoCompraImpor(new ArrayList<Classe>(),DeepLoadType.NONE);

				detallepedidocompraimporLogic.setDetallePedidoCompraImpors(arancel.detallepedidocompraimpors);
				detallepedidocompraimporLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
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
	
	public void deepLoad(Arancel arancel,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			ArancelLogicAdditional.updateArancelToGet(arancel,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		arancel.setEmpresa(arancelDataAccess.getEmpresa(connexion,arancel));
		arancel.setProductos(arancelDataAccess.getProductos(connexion,arancel));
		arancel.setDetallePedidoCompraImpors(arancelDataAccess.getDetallePedidoCompraImpors(connexion,arancel));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				arancel.setEmpresa(arancelDataAccess.getEmpresa(connexion,arancel));
				continue;
			}

			if(clas.clas.equals(Producto.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				arancel.setProductos(arancelDataAccess.getProductos(connexion,arancel));

				if(this.isConDeep) {
					ProductoLogic productoLogic= new ProductoLogic(this.connexion);
					productoLogic.setProductos(arancel.getProductos());
					ArrayList<Classe> classesLocal=ProductoConstantesFunciones.getClassesForeignKeysOfProducto(new ArrayList<Classe>(),DeepLoadType.NONE);
					productoLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					ProductoConstantesFunciones.refrescarForeignKeysDescripcionesProducto(productoLogic.getProductos());
					arancel.setProductos(productoLogic.getProductos());
				}

				continue;
			}

			if(clas.clas.equals(DetallePedidoCompraImpor.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				arancel.setDetallePedidoCompraImpors(arancelDataAccess.getDetallePedidoCompraImpors(connexion,arancel));

				if(this.isConDeep) {
					DetallePedidoCompraImporLogic detallepedidocompraimporLogic= new DetallePedidoCompraImporLogic(this.connexion);
					detallepedidocompraimporLogic.setDetallePedidoCompraImpors(arancel.getDetallePedidoCompraImpors());
					ArrayList<Classe> classesLocal=DetallePedidoCompraImporConstantesFunciones.getClassesForeignKeysOfDetallePedidoCompraImpor(new ArrayList<Classe>(),DeepLoadType.NONE);
					detallepedidocompraimporLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					DetallePedidoCompraImporConstantesFunciones.refrescarForeignKeysDescripcionesDetallePedidoCompraImpor(detallepedidocompraimporLogic.getDetallePedidoCompraImpors());
					arancel.setDetallePedidoCompraImpors(detallepedidocompraimporLogic.getDetallePedidoCompraImpors());
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
			arancel.setEmpresa(arancelDataAccess.getEmpresa(connexion,arancel));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Producto.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(Producto.class));
			arancel.setProductos(arancelDataAccess.getProductos(connexion,arancel));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(DetallePedidoCompraImpor.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(DetallePedidoCompraImpor.class));
			arancel.setDetallePedidoCompraImpors(arancelDataAccess.getDetallePedidoCompraImpors(connexion,arancel));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		arancel.setEmpresa(arancelDataAccess.getEmpresa(connexion,arancel));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(arancel.getEmpresa(),isDeep,deepLoadType,clases);
				

		arancel.setProductos(arancelDataAccess.getProductos(connexion,arancel));

		for(Producto producto:arancel.getProductos()) {
			ProductoLogic productoLogic= new ProductoLogic(connexion);
			productoLogic.deepLoad(producto,isDeep,deepLoadType,clases);
		}

		arancel.setDetallePedidoCompraImpors(arancelDataAccess.getDetallePedidoCompraImpors(connexion,arancel));

		for(DetallePedidoCompraImpor detallepedidocompraimpor:arancel.getDetallePedidoCompraImpors()) {
			DetallePedidoCompraImporLogic detallepedidocompraimporLogic= new DetallePedidoCompraImporLogic(connexion);
			detallepedidocompraimporLogic.deepLoad(detallepedidocompraimpor,isDeep,deepLoadType,clases);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				arancel.setEmpresa(arancelDataAccess.getEmpresa(connexion,arancel));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(arancel.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Producto.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				arancel.setProductos(arancelDataAccess.getProductos(connexion,arancel));

				for(Producto producto:arancel.getProductos()) {
					ProductoLogic productoLogic= new ProductoLogic(connexion);
					productoLogic.deepLoad(producto,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(DetallePedidoCompraImpor.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				arancel.setDetallePedidoCompraImpors(arancelDataAccess.getDetallePedidoCompraImpors(connexion,arancel));

				for(DetallePedidoCompraImpor detallepedidocompraimpor:arancel.getDetallePedidoCompraImpors()) {
					DetallePedidoCompraImporLogic detallepedidocompraimporLogic= new DetallePedidoCompraImporLogic(connexion);
					detallepedidocompraimporLogic.deepLoad(detallepedidocompraimpor,isDeep,deepLoadType,clases);
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
			arancel.setEmpresa(arancelDataAccess.getEmpresa(connexion,arancel));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(arancel.getEmpresa(),isDeep,deepLoadType,clases);
				
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Producto.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(Producto.class));
			arancel.setProductos(arancelDataAccess.getProductos(connexion,arancel));

			for(Producto producto:arancel.getProductos()) {
				ProductoLogic productoLogic= new ProductoLogic(connexion);
				productoLogic.deepLoad(producto,isDeep,deepLoadType,clases);
			}
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(DetallePedidoCompraImpor.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(DetallePedidoCompraImpor.class));
			arancel.setDetallePedidoCompraImpors(arancelDataAccess.getDetallePedidoCompraImpors(connexion,arancel));

			for(DetallePedidoCompraImpor detallepedidocompraimpor:arancel.getDetallePedidoCompraImpors()) {
				DetallePedidoCompraImporLogic detallepedidocompraimporLogic= new DetallePedidoCompraImporLogic(connexion);
				detallepedidocompraimporLogic.deepLoad(detallepedidocompraimpor,isDeep,deepLoadType,clases);
			}
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(Arancel arancel,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			ArancelLogicAdditional.updateArancelToSave(arancel,this.arrDatoGeneral);
			
ArancelDataAccess.save(arancel, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(arancel.getEmpresa(),connexion);

		for(Producto producto:arancel.getProductos()) {
			producto.setid_arancel(arancel.getId());
			ProductoDataAccess.save(producto,connexion);
		}

		for(DetallePedidoCompraImpor detallepedidocompraimpor:arancel.getDetallePedidoCompraImpors()) {
			detallepedidocompraimpor.setid_arancel(arancel.getId());
			DetallePedidoCompraImporDataAccess.save(detallepedidocompraimpor,connexion);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(arancel.getEmpresa(),connexion);
				continue;
			}


			if(clas.clas.equals(Producto.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(Producto producto:arancel.getProductos()) {
					producto.setid_arancel(arancel.getId());
					ProductoDataAccess.save(producto,connexion);
				}
				continue;
			}

			if(clas.clas.equals(DetallePedidoCompraImpor.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(DetallePedidoCompraImpor detallepedidocompraimpor:arancel.getDetallePedidoCompraImpors()) {
					detallepedidocompraimpor.setid_arancel(arancel.getId());
					DetallePedidoCompraImporDataAccess.save(detallepedidocompraimpor,connexion);
				}
				continue;
			}
		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(arancel.getEmpresa(),connexion);
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(arancel.getEmpresa(),isDeep,deepLoadType,clases);
				

		for(Producto producto:arancel.getProductos()) {
			ProductoLogic productoLogic= new ProductoLogic(connexion);
			producto.setid_arancel(arancel.getId());
			ProductoDataAccess.save(producto,connexion);
			productoLogic.deepSave(producto,isDeep,deepLoadType,clases);
		}

		for(DetallePedidoCompraImpor detallepedidocompraimpor:arancel.getDetallePedidoCompraImpors()) {
			DetallePedidoCompraImporLogic detallepedidocompraimporLogic= new DetallePedidoCompraImporLogic(connexion);
			detallepedidocompraimpor.setid_arancel(arancel.getId());
			DetallePedidoCompraImporDataAccess.save(detallepedidocompraimpor,connexion);
			detallepedidocompraimporLogic.deepSave(detallepedidocompraimpor,isDeep,deepLoadType,clases);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(arancel.getEmpresa(),connexion);
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepSave(arancel.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}


			if(clas.clas.equals(Producto.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(Producto producto:arancel.getProductos()) {
					ProductoLogic productoLogic= new ProductoLogic(connexion);
					producto.setid_arancel(arancel.getId());
					ProductoDataAccess.save(producto,connexion);
					productoLogic.deepSave(producto,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(DetallePedidoCompraImpor.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(DetallePedidoCompraImpor detallepedidocompraimpor:arancel.getDetallePedidoCompraImpors()) {
					DetallePedidoCompraImporLogic detallepedidocompraimporLogic= new DetallePedidoCompraImporLogic(connexion);
					detallepedidocompraimpor.setid_arancel(arancel.getId());
					DetallePedidoCompraImporDataAccess.save(detallepedidocompraimpor,connexion);
					detallepedidocompraimporLogic.deepSave(detallepedidocompraimpor,isDeep,deepLoadType,clases);
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
			this.getNewConnexionToDeep(Arancel.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(arancel,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				ArancelConstantesFunciones.refrescarForeignKeysDescripcionesArancel(arancel);
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
			this.deepLoad(this.arancel,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				ArancelConstantesFunciones.refrescarForeignKeysDescripcionesArancel(this.arancel);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(Arancel.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(arancels!=null) {
				for(Arancel arancel:arancels) {
					this.deepLoad(arancel,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					ArancelConstantesFunciones.refrescarForeignKeysDescripcionesArancel(arancels);
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
			if(arancels!=null) {
				for(Arancel arancel:arancels) {
					this.deepLoad(arancel,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					ArancelConstantesFunciones.refrescarForeignKeysDescripcionesArancel(arancels);
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
			this.getNewConnexionToDeep(Arancel.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(arancel,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(Arancel.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(arancels!=null) {
				for(Arancel arancel:arancels) {
					this.deepSave(arancel,isDeep,deepLoadType,clases);
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
			if(arancels!=null) {
				for(Arancel arancel:arancels) {
					this.deepSave(arancel,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getArancelsBusquedaPorCodigoWithConnection(String sFinalQuery,Pagination pagination,String codigo)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Arancel.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralCodigo= new ParameterSelectionGeneral();
			parameterSelectionGeneralCodigo.setParameterSelectionGeneralLike(ParameterType.STRING,"%"+codigo+"%",ArancelConstantesFunciones.CODIGO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralCodigo);

			ArancelLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorCodigo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			arancels=arancelDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ArancelConstantesFunciones.refrescarForeignKeysDescripcionesArancel(this.arancels);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getArancelsBusquedaPorCodigo(String sFinalQuery,Pagination pagination,String codigo)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralCodigo= new ParameterSelectionGeneral();
			parameterSelectionGeneralCodigo.setParameterSelectionGeneralLike(ParameterType.STRING,"%"+codigo+"%",ArancelConstantesFunciones.CODIGO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralCodigo);

			ArancelLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorCodigo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			arancels=arancelDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ArancelConstantesFunciones.refrescarForeignKeysDescripcionesArancel(this.arancels);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getArancelsBusquedaPorNombreWithConnection(String sFinalQuery,Pagination pagination,String nombre)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Arancel.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralNombre= new ParameterSelectionGeneral();
			parameterSelectionGeneralNombre.setParameterSelectionGeneralLike(ParameterType.STRING,"%"+nombre+"%",ArancelConstantesFunciones.NOMBRE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralNombre);

			ArancelLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorNombre","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			arancels=arancelDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ArancelConstantesFunciones.refrescarForeignKeysDescripcionesArancel(this.arancels);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getArancelsBusquedaPorNombre(String sFinalQuery,Pagination pagination,String nombre)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralNombre= new ParameterSelectionGeneral();
			parameterSelectionGeneralNombre.setParameterSelectionGeneralLike(ParameterType.STRING,"%"+nombre+"%",ArancelConstantesFunciones.NOMBRE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralNombre);

			ArancelLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorNombre","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			arancels=arancelDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ArancelConstantesFunciones.refrescarForeignKeysDescripcionesArancel(this.arancels);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getArancelsFK_IdEmpresaWithConnection(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Arancel.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,ArancelConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			ArancelLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			arancels=arancelDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ArancelConstantesFunciones.refrescarForeignKeysDescripcionesArancel(this.arancels);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getArancelsFK_IdEmpresa(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,ArancelConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			ArancelLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			arancels=arancelDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ArancelConstantesFunciones.refrescarForeignKeysDescripcionesArancel(this.arancels);
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
			if(ArancelConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,ArancelDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,Arancel arancel,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(ArancelConstantesFunciones.ISCONAUDITORIA) {
				if(arancel.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,ArancelDataAccess.TABLENAME, arancel.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(ArancelConstantesFunciones.ISCONAUDITORIADETALLE) {
						////ArancelLogic.registrarAuditoriaDetallesArancel(connexion,arancel,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(arancel.getIsDeleted()) {
					/*if(!arancel.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,ArancelDataAccess.TABLENAME, arancel.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////ArancelLogic.registrarAuditoriaDetallesArancel(connexion,arancel,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,ArancelDataAccess.TABLENAME, arancel.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(arancel.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,ArancelDataAccess.TABLENAME, arancel.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(ArancelConstantesFunciones.ISCONAUDITORIADETALLE) {
						////ArancelLogic.registrarAuditoriaDetallesArancel(connexion,arancel,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesArancel(Connexion connexion,Arancel arancel)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(arancel.getIsNew()||!arancel.getid_empresa().equals(arancel.getArancelOriginal().getid_empresa()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(arancel.getArancelOriginal().getid_empresa()!=null)
				{
					strValorActual=arancel.getArancelOriginal().getid_empresa().toString();
				}
				if(arancel.getid_empresa()!=null)
				{
					strValorNuevo=arancel.getid_empresa().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ArancelConstantesFunciones.IDEMPRESA,strValorActual,strValorNuevo);
			}	
			
			if(arancel.getIsNew()||!arancel.getcodigo().equals(arancel.getArancelOriginal().getcodigo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(arancel.getArancelOriginal().getcodigo()!=null)
				{
					strValorActual=arancel.getArancelOriginal().getcodigo();
				}
				if(arancel.getcodigo()!=null)
				{
					strValorNuevo=arancel.getcodigo() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ArancelConstantesFunciones.CODIGO,strValorActual,strValorNuevo);
			}	
			
			if(arancel.getIsNew()||!arancel.getnombre().equals(arancel.getArancelOriginal().getnombre()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(arancel.getArancelOriginal().getnombre()!=null)
				{
					strValorActual=arancel.getArancelOriginal().getnombre();
				}
				if(arancel.getnombre()!=null)
				{
					strValorNuevo=arancel.getnombre() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ArancelConstantesFunciones.NOMBRE,strValorActual,strValorNuevo);
			}	
			
			if(arancel.getIsNew()||!arancel.getporcentaje().equals(arancel.getArancelOriginal().getporcentaje()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(arancel.getArancelOriginal().getporcentaje()!=null)
				{
					strValorActual=arancel.getArancelOriginal().getporcentaje().toString();
				}
				if(arancel.getporcentaje()!=null)
				{
					strValorNuevo=arancel.getporcentaje().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ArancelConstantesFunciones.PORCENTAJE,strValorActual,strValorNuevo);
			}	
			
			if(arancel.getIsNew()||!arancel.getobservacion().equals(arancel.getArancelOriginal().getobservacion()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(arancel.getArancelOriginal().getobservacion()!=null)
				{
					strValorActual=arancel.getArancelOriginal().getobservacion();
				}
				if(arancel.getobservacion()!=null)
				{
					strValorNuevo=arancel.getobservacion() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ArancelConstantesFunciones.OBSERVACION,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void saveArancelRelacionesWithConnection(Arancel arancel,List<Producto> productos,List<DetallePedidoCompraImpor> detallepedidocompraimpors) throws Exception {

		if(!arancel.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveArancelRelacionesBase(arancel,productos,detallepedidocompraimpors,true);
		}
	}

	public void saveArancelRelaciones(Arancel arancel,List<Producto> productos,List<DetallePedidoCompraImpor> detallepedidocompraimpors)throws Exception {

		if(!arancel.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveArancelRelacionesBase(arancel,productos,detallepedidocompraimpors,false);
		}
	}

	public void saveArancelRelacionesBase(Arancel arancel,List<Producto> productos,List<DetallePedidoCompraImpor> detallepedidocompraimpors,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("Arancel-saveRelacionesWithConnection");}
	
			arancel.setProductos(productos);
			arancel.setDetallePedidoCompraImpors(detallepedidocompraimpors);

			this.setArancel(arancel);

			if(ArancelLogicAdditional.validarSaveRelaciones(arancel,this)) {

				ArancelLogicAdditional.updateRelacionesToSave(arancel,this);

				if((arancel.getIsNew()||arancel.getIsChanged())&&!arancel.getIsDeleted()) {
					this.saveArancel();
					this.saveArancelRelacionesDetalles(productos,detallepedidocompraimpors);

				} else if(arancel.getIsDeleted()) {
					this.saveArancelRelacionesDetalles(productos,detallepedidocompraimpors);
					this.saveArancel();
				}

				ArancelLogicAdditional.updateRelacionesToSaveAfter(arancel,this);

			} else {
				throw new Exception("LOS DATOS SON INVALIDOS");
			}

			if(conConexion) {connexion.commit();}

		} catch(Exception e) {
			
			ProductoConstantesFunciones.InicializarGeneralEntityAuxiliaresProductos(productos,true,true);
			DetallePedidoCompraImporConstantesFunciones.InicializarGeneralEntityAuxiliaresDetallePedidoCompraImpors(detallepedidocompraimpors,true,true);

			if(conConexion){connexion.rollback();}
			Funciones.manageException(logger,e);
			throw e;

		} finally {
			if(conConexion){this.closeNewConnexionToDeep();}
		}
	}
	
	
	private void saveArancelRelacionesDetalles(List<Producto> productos,List<DetallePedidoCompraImpor> detallepedidocompraimpors)throws Exception {
		try {
	

			Long idArancelActual=this.getArancel().getId();

			ProductoLogic productoLogic_Desde_Arancel=new ProductoLogic();
			productoLogic_Desde_Arancel.setProductos(productos);

			productoLogic_Desde_Arancel.setConnexion(this.getConnexion());
			productoLogic_Desde_Arancel.setDatosCliente(this.datosCliente);

			for(Producto producto_Desde_Arancel:productoLogic_Desde_Arancel.getProductos()) {
				producto_Desde_Arancel.setid_arancel(idArancelActual);

				productoLogic_Desde_Arancel.setProducto(producto_Desde_Arancel);
				productoLogic_Desde_Arancel.saveProducto();
			}


			DetallePedidoCompraImporLogic detallepedidocompraimporLogic_Desde_Arancel=new DetallePedidoCompraImporLogic();
			detallepedidocompraimporLogic_Desde_Arancel.setDetallePedidoCompraImpors(detallepedidocompraimpors);

			detallepedidocompraimporLogic_Desde_Arancel.setConnexion(this.getConnexion());
			detallepedidocompraimporLogic_Desde_Arancel.setDatosCliente(this.datosCliente);

			for(DetallePedidoCompraImpor detallepedidocompraimpor_Desde_Arancel:detallepedidocompraimporLogic_Desde_Arancel.getDetallePedidoCompraImpors()) {
				detallepedidocompraimpor_Desde_Arancel.setid_arancel(idArancelActual);
			}

			detallepedidocompraimporLogic_Desde_Arancel.saveDetallePedidoCompraImpors();

		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfArancel(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=ArancelConstantesFunciones.getClassesForeignKeysOfArancel(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfArancel(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=ArancelConstantesFunciones.getClassesRelationshipsOfArancel(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}
