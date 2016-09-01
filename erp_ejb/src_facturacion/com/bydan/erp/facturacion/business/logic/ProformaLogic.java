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
import com.bydan.erp.facturacion.util.ProformaConstantesFunciones;
import com.bydan.erp.facturacion.util.ProformaParameterReturnGeneral;
//import com.bydan.erp.facturacion.util.ProformaParameterGeneral;
import com.bydan.erp.facturacion.business.entity.Proforma;
import com.bydan.erp.facturacion.business.logic.ProformaLogicAdditional;
import com.bydan.erp.facturacion.business.dataaccess.*;
import com.bydan.erp.facturacion.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.nomina.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.inventario.business.entity.*;
import com.bydan.erp.comisiones.business.entity.*;


import com.bydan.erp.seguridad.business.logic.*;
import com.bydan.erp.contabilidad.business.logic.*;
import com.bydan.erp.nomina.business.logic.*;
import com.bydan.erp.cartera.business.logic.*;
import com.bydan.erp.inventario.business.logic.*;
import com.bydan.erp.comisiones.business.logic.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.contabilidad.util.*;
import com.bydan.erp.nomina.util.*;
import com.bydan.erp.cartera.util.*;
import com.bydan.erp.inventario.util.*;
import com.bydan.erp.comisiones.util.*;


import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.contabilidad.business.dataaccess.*;
import com.bydan.erp.nomina.business.dataaccess.*;
import com.bydan.erp.cartera.business.dataaccess.*;
import com.bydan.erp.inventario.business.dataaccess.*;
import com.bydan.erp.comisiones.business.dataaccess.*;








@SuppressWarnings("unused")
public class ProformaLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(ProformaLogic.class);
	
	protected ProformaDataAccess proformaDataAccess; 	
	protected Proforma proforma;
	protected List<Proforma> proformas;
	protected Object proformaObject;	
	protected List<Object> proformasObject;
	
	public static ClassValidator<Proforma> proformaValidator = new ClassValidator<Proforma>(Proforma.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected ProformaLogicAdditional proformaLogicAdditional=null;
	
	public ProformaLogicAdditional getProformaLogicAdditional() {
		return this.proformaLogicAdditional;
	}
	
	public void setProformaLogicAdditional(ProformaLogicAdditional proformaLogicAdditional) {
		try {
			this.proformaLogicAdditional=proformaLogicAdditional;
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
	
	
	
	
	public  ProformaLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.proformaDataAccess = new ProformaDataAccess();
			
			this.proformas= new ArrayList<Proforma>();
			this.proforma= new Proforma();
			
			this.proformaObject=new Object();
			this.proformasObject=new ArrayList<Object>();
				
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
			
			this.proformaDataAccess.setConnexionType(this.connexionType);
			this.proformaDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  ProformaLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.proformaDataAccess = new ProformaDataAccess();
			this.proformas= new ArrayList<Proforma>();
			this.proforma= new Proforma();
			this.proformaObject=new Object();
			this.proformasObject=new ArrayList<Object>();
			
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
			
			this.proformaDataAccess.setConnexionType(this.connexionType);
			this.proformaDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public Proforma getProforma() throws Exception {	
		ProformaLogicAdditional.checkProformaToGet(proforma,this.datosCliente,this.arrDatoGeneral);
		ProformaLogicAdditional.updateProformaToGet(proforma,this.arrDatoGeneral);
		
		return proforma;
	}
		
	public void setProforma(Proforma newProforma) {
		this.proforma = newProforma;
	}
	
	public ProformaDataAccess getProformaDataAccess() {
		return proformaDataAccess;
	}
	
	public void setProformaDataAccess(ProformaDataAccess newproformaDataAccess) {
		this.proformaDataAccess = newproformaDataAccess;
	}
	
	public List<Proforma> getProformas() throws Exception {		
		this.quitarProformasNulos();
		
		ProformaLogicAdditional.checkProformaToGets(proformas,this.datosCliente,this.arrDatoGeneral);
		
		for (Proforma proformaLocal: proformas ) {
			ProformaLogicAdditional.updateProformaToGet(proformaLocal,this.arrDatoGeneral);
		}
		
		return proformas;
	}
	
	public void setProformas(List<Proforma> newProformas) {
		this.proformas = newProformas;
	}
	
	public Object getProformaObject() {	
		this.proformaObject=this.proformaDataAccess.getEntityObject();
		return this.proformaObject;
	}
		
	public void setProformaObject(Object newProformaObject) {
		this.proformaObject = newProformaObject;
	}
	
	public List<Object> getProformasObject() {		
		this.proformasObject=this.proformaDataAccess.getEntitiesObject();
		return this.proformasObject;
	}
		
	public void setProformasObject(List<Object> newProformasObject) {
		this.proformasObject = newProformasObject;
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
		
		if(this.proformaDataAccess!=null) {
			this.proformaDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Proforma.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			proformaDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			proformaDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		proforma = new  Proforma();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Proforma.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			proforma=proformaDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.proforma,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				ProformaConstantesFunciones.refrescarForeignKeysDescripcionesProforma(this.proforma);
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
		proforma = new  Proforma();
		  		  
        try {
			
			proforma=proformaDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.proforma,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				ProformaConstantesFunciones.refrescarForeignKeysDescripcionesProforma(this.proforma);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		proforma = new  Proforma();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Proforma.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			proforma=proformaDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.proforma,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				ProformaConstantesFunciones.refrescarForeignKeysDescripcionesProforma(this.proforma);
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
		proforma = new  Proforma();
		  		  
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
		proforma = new  Proforma();
		  		  
        try {
			
			proforma=proformaDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.proforma,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				ProformaConstantesFunciones.refrescarForeignKeysDescripcionesProforma(this.proforma);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		proforma = new  Proforma();
		  		  
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
		proforma = new  Proforma();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Proforma.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =proformaDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		proforma = new  Proforma();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=proformaDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		proforma = new  Proforma();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Proforma.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =proformaDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		proforma = new  Proforma();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=proformaDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		proforma = new  Proforma();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Proforma.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =proformaDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		proforma = new  Proforma();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=proformaDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		proformas = new  ArrayList<Proforma>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Proforma.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			ProformaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			proformas=proformaDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarProforma(proformas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ProformaConstantesFunciones.refrescarForeignKeysDescripcionesProforma(this.proformas);
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
		proformas = new  ArrayList<Proforma>();
		  		  
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
		proformas = new  ArrayList<Proforma>();
		  		  
        try {			
			ProformaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			proformas=proformaDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarProforma(proformas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ProformaConstantesFunciones.refrescarForeignKeysDescripcionesProforma(this.proformas);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		proformas = new  ArrayList<Proforma>();
		  		  
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
		proformas = new  ArrayList<Proforma>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Proforma.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			ProformaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			proformas=proformaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarProforma(proformas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ProformaConstantesFunciones.refrescarForeignKeysDescripcionesProforma(this.proformas);
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
		proformas = new  ArrayList<Proforma>();
		  		  
        try {
			ProformaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			proformas=proformaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarProforma(proformas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ProformaConstantesFunciones.refrescarForeignKeysDescripcionesProforma(this.proformas);
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
		proformas = new  ArrayList<Proforma>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Proforma.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ProformaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			proformas=proformaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarProforma(proformas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ProformaConstantesFunciones.refrescarForeignKeysDescripcionesProforma(this.proformas);
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
		proformas = new  ArrayList<Proforma>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ProformaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			proformas=proformaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarProforma(proformas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ProformaConstantesFunciones.refrescarForeignKeysDescripcionesProforma(this.proformas);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		proforma = new  Proforma();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Proforma.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ProformaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			proforma=proformaDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarProforma(proforma);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ProformaConstantesFunciones.refrescarForeignKeysDescripcionesProforma(this.proforma);
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
		proforma = new  Proforma();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ProformaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			proforma=proformaDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarProforma(proforma);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ProformaConstantesFunciones.refrescarForeignKeysDescripcionesProforma(this.proforma);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		proformas = new  ArrayList<Proforma>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Proforma.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			ProformaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			proformas=proformaDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarProforma(proformas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ProformaConstantesFunciones.refrescarForeignKeysDescripcionesProforma(this.proformas);
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
		proformas = new  ArrayList<Proforma>();
		  		  
        try {
			ProformaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			proformas=proformaDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarProforma(proformas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ProformaConstantesFunciones.refrescarForeignKeysDescripcionesProforma(this.proformas);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosProformasWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		proformas = new  ArrayList<Proforma>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Proforma.class.getSimpleName()+"-getTodosProformasWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ProformaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			proformas=proformaDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarProforma(proformas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ProformaConstantesFunciones.refrescarForeignKeysDescripcionesProforma(this.proformas);
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
	
	public  void  getTodosProformas(String sFinalQuery,Pagination pagination)throws Exception {
		proformas = new  ArrayList<Proforma>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ProformaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			proformas=proformaDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarProforma(proformas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ProformaConstantesFunciones.refrescarForeignKeysDescripcionesProforma(this.proformas);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarProforma(Proforma proforma) throws Exception {
		Boolean estaValidado=false;
		
		if(proforma.getIsNew() || proforma.getIsChanged()) { 
			this.invalidValues = proformaValidator.getInvalidValues(proforma);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(proforma);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarProforma(List<Proforma> Proformas) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(Proforma proformaLocal:proformas) {				
			estaValidadoObjeto=this.validarGuardarProforma(proformaLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarProforma(List<Proforma> Proformas) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarProforma(proformas)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarProforma(Proforma Proforma) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarProforma(proforma)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(Proforma proforma) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+proforma.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=ProformaConstantesFunciones.getProformaLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"proforma","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(ProformaConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(ProformaConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveProformaWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Proforma.class.getSimpleName()+"-saveProformaWithConnection");connexion.begin();			
			
			ProformaLogicAdditional.checkProformaToSave(this.proforma,this.datosCliente,connexion,this.arrDatoGeneral);
			
			ProformaLogicAdditional.updateProformaToSave(this.proforma,this.arrDatoGeneral);
			
			ProformaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.proforma,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowProforma();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarProforma(this.proforma)) {
				ProformaDataAccess.save(this.proforma, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.proforma,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			ProformaLogicAdditional.checkProformaToSaveAfter(this.proforma,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowProforma();
			
			connexion.commit();			
			
			if(this.proforma.getIsDeleted()) {
				this.proforma=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveProforma()throws Exception {	
		try {	
			
			ProformaLogicAdditional.checkProformaToSave(this.proforma,this.datosCliente,connexion,this.arrDatoGeneral);
			
			ProformaLogicAdditional.updateProformaToSave(this.proforma,this.arrDatoGeneral);
			
			ProformaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.proforma,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarProforma(this.proforma)) {			
				ProformaDataAccess.save(this.proforma, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.proforma,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			ProformaLogicAdditional.checkProformaToSaveAfter(this.proforma,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.proforma.getIsDeleted()) {
				this.proforma=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveProformasWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Proforma.class.getSimpleName()+"-saveProformasWithConnection");connexion.begin();			
			
			ProformaLogicAdditional.checkProformaToSaves(proformas,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowProformas();
			
			Boolean validadoTodosProforma=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(Proforma proformaLocal:proformas) {		
				if(proformaLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				ProformaLogicAdditional.updateProformaToSave(proformaLocal,this.arrDatoGeneral);
	        	
				ProformaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),proformaLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarProforma(proformaLocal)) {
					ProformaDataAccess.save(proformaLocal, connexion);				
				} else {
					validadoTodosProforma=false;
				}
			}
			
			if(!validadoTodosProforma) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			ProformaLogicAdditional.checkProformaToSavesAfter(proformas,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowProformas();
			
			connexion.commit();		
			
			this.quitarProformasEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveProformas()throws Exception {				
		 try {	
			ProformaLogicAdditional.checkProformaToSaves(proformas,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosProforma=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(Proforma proformaLocal:proformas) {				
				if(proformaLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				ProformaLogicAdditional.updateProformaToSave(proformaLocal,this.arrDatoGeneral);
	        	
				ProformaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),proformaLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarProforma(proformaLocal)) {				
					ProformaDataAccess.save(proformaLocal, connexion);				
				} else {
					validadoTodosProforma=false;
				}
			}
			
			if(!validadoTodosProforma) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			ProformaLogicAdditional.checkProformaToSavesAfter(proformas,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarProformasEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public ProformaParameterReturnGeneral procesarAccionProformas(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<Proforma> proformas,ProformaParameterReturnGeneral proformaParameterGeneral)throws Exception {
		 try {	
			ProformaParameterReturnGeneral proformaReturnGeneral=new ProformaParameterReturnGeneral();
	
			ProformaLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,proformas,proformaParameterGeneral,proformaReturnGeneral);
			
			return proformaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public ProformaParameterReturnGeneral procesarAccionProformasWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<Proforma> proformas,ProformaParameterReturnGeneral proformaParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Proforma.class.getSimpleName()+"-procesarAccionProformasWithConnection");connexion.begin();			
			
			ProformaParameterReturnGeneral proformaReturnGeneral=new ProformaParameterReturnGeneral();
	
			ProformaLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,proformas,proformaParameterGeneral,proformaReturnGeneral);
			
			this.connexion.commit();
			
			return proformaReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public ProformaParameterReturnGeneral procesarEventosProformas(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<Proforma> proformas,Proforma proforma,ProformaParameterReturnGeneral proformaParameterGeneral,Boolean isEsNuevoProforma,ArrayList<Classe> clases)throws Exception {
		 try {	
			ProformaParameterReturnGeneral proformaReturnGeneral=new ProformaParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				proformaReturnGeneral.setConRecargarPropiedades(true);
			}
			
			ProformaLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,proformas,proforma,proformaParameterGeneral,proformaReturnGeneral,isEsNuevoProforma,clases);
			
			return proformaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public ProformaParameterReturnGeneral procesarEventosProformasWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<Proforma> proformas,Proforma proforma,ProformaParameterReturnGeneral proformaParameterGeneral,Boolean isEsNuevoProforma,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Proforma.class.getSimpleName()+"-procesarEventosProformasWithConnection");connexion.begin();			
			
			ProformaParameterReturnGeneral proformaReturnGeneral=new ProformaParameterReturnGeneral();
	
			proformaReturnGeneral.setProforma(proforma);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				proformaReturnGeneral.setConRecargarPropiedades(true);
			}
			
			ProformaLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,proformas,proforma,proformaParameterGeneral,proformaReturnGeneral,isEsNuevoProforma,clases);
			
			this.connexion.commit();
			
			return proformaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public ProformaParameterReturnGeneral procesarImportacionProformasWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,ProformaParameterReturnGeneral proformaParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Proforma.class.getSimpleName()+"-procesarImportacionProformasWithConnection");connexion.begin();			
			
			ProformaParameterReturnGeneral proformaReturnGeneral=new ProformaParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.proformas=new ArrayList<Proforma>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.proforma=new Proforma();
				
				
				if(conColumnasBase) {this.proforma.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.proforma.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.proforma.setnumero_pre_impreso(arrColumnas[iColumn++]);
				this.proforma.setfecha_emision(Funciones.ConvertToDate(arrColumnas[iColumn++]));
				this.proforma.setdias(Integer.parseInt(arrColumnas[iColumn++]));
				this.proforma.setfecha_vencimiento(Funciones.ConvertToDate(arrColumnas[iColumn++]));
				this.proforma.setcotizacion(Double.parseDouble(arrColumnas[iColumn++]));
				this.proforma.setdireccion(arrColumnas[iColumn++]);
				this.proforma.setruc(arrColumnas[iColumn++]);
				this.proforma.setes_oferta(Boolean.parseBoolean(arrColumnas[iColumn++]));
				this.proforma.settelefono(arrColumnas[iColumn++]);
				this.proforma.setdescripcion(arrColumnas[iColumn++]);
				this.proforma.setdescuento_porcentaje(Double.parseDouble(arrColumnas[iColumn++]));
				this.proforma.setmonto_con_iva(Double.parseDouble(arrColumnas[iColumn++]));
				this.proforma.setsuman(Double.parseDouble(arrColumnas[iColumn++]));
				this.proforma.setdescuento_valor(Double.parseDouble(arrColumnas[iColumn++]));
				this.proforma.setmonto_sin_iva(Double.parseDouble(arrColumnas[iColumn++]));
				this.proforma.setdescuento_general(Double.parseDouble(arrColumnas[iColumn++]));
				this.proforma.setflete(Double.parseDouble(arrColumnas[iColumn++]));
				this.proforma.setultimo_costo(Double.parseDouble(arrColumnas[iColumn++]));
				this.proforma.setsubtotal(Double.parseDouble(arrColumnas[iColumn++]));
				this.proforma.setotros_cargos(Double.parseDouble(arrColumnas[iColumn++]));
				this.proforma.setmargen_utilidad(Double.parseDouble(arrColumnas[iColumn++]));
				this.proforma.setiva(Double.parseDouble(arrColumnas[iColumn++]));
				this.proforma.setfinanciamiento(Double.parseDouble(arrColumnas[iColumn++]));
				this.proforma.settotal(Double.parseDouble(arrColumnas[iColumn++]));
				this.proforma.setotros_valores(Double.parseDouble(arrColumnas[iColumn++]));
				this.proforma.setanticipo(Double.parseDouble(arrColumnas[iColumn++]));
				
				this.proformas.add(this.proforma);
			}
			
			this.saveProformas();
			
			this.connexion.commit();
			
			proformaReturnGeneral.setConRetornoEstaProcesado(true);
			proformaReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return proformaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarProformasEliminados() throws Exception {				
		
		List<Proforma> proformasAux= new ArrayList<Proforma>();
		
		for(Proforma proforma:proformas) {
			if(!proforma.getIsDeleted()) {
				proformasAux.add(proforma);
			}
		}
		
		proformas=proformasAux;
	}
	
	public void quitarProformasNulos() throws Exception {				
		
		List<Proforma> proformasAux= new ArrayList<Proforma>();
		
		for(Proforma proforma : this.proformas) {
			if(proforma==null) {
				proformasAux.add(proforma);
			}
		}
		
		//this.proformas=proformasAux;
		
		this.proformas.removeAll(proformasAux);
	}
	
	public void getSetVersionRowProformaWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(proforma.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((proforma.getIsDeleted() || (proforma.getIsChanged()&&!proforma.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=proformaDataAccess.getSetVersionRowProforma(connexion,proforma.getId());
				
				if(!proforma.getVersionRow().equals(timestamp)) {	
					proforma.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				proforma.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowProforma()throws Exception {	
		
		if(proforma.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((proforma.getIsDeleted() || (proforma.getIsChanged()&&!proforma.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=proformaDataAccess.getSetVersionRowProforma(connexion,proforma.getId());
			
			try {							
				if(!proforma.getVersionRow().equals(timestamp)) {	
					proforma.setVersionRow(timestamp);
				}
				
				proforma.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowProformasWithConnection()throws Exception {	
		if(proformas!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(Proforma proformaAux:proformas) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(proformaAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(proformaAux.getIsDeleted() || (proformaAux.getIsChanged()&&!proformaAux.getIsNew())) {
						
						timestamp=proformaDataAccess.getSetVersionRowProforma(connexion,proformaAux.getId());
						
						if(!proforma.getVersionRow().equals(timestamp)) {	
							proformaAux.setVersionRow(timestamp);
						}
								
						proformaAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowProformas()throws Exception {	
		if(proformas!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(Proforma proformaAux:proformas) {
					if(proformaAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(proformaAux.getIsDeleted() || (proformaAux.getIsChanged()&&!proformaAux.getIsNew())) {
						
						timestamp=proformaDataAccess.getSetVersionRowProforma(connexion,proformaAux.getId());
						
						if(!proformaAux.getVersionRow().equals(timestamp)) {	
							proformaAux.setVersionRow(timestamp);
						}
						
													
						proformaAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public ProformaParameterReturnGeneral cargarCombosLoteForeignKeyProformaWithConnection(String finalQueryGlobalEmpresa,String finalQueryGlobalSucursal,String finalQueryGlobalUsuario,String finalQueryGlobalEjercicio,String finalQueryGlobalPeriodo,String finalQueryGlobalAnio,String finalQueryGlobalMes,String finalQueryGlobalMoneda,String finalQueryGlobalEmpleado,String finalQueryGlobalFormato,String finalQueryGlobalEstadoProforma,String finalQueryGlobalCliente,String finalQueryGlobalTipoPrecio,String finalQueryGlobalVendedor,String finalQueryGlobalSubCliente,String finalQueryGlobalTipoViaTransporte,String finalQueryGlobalTransporte,String finalQueryGlobalRutaTransporte,String finalQueryGlobalCentroCosto,String finalQueryGlobalTipoProforma,String finalQueryGlobalConsignatario,String finalQueryGlobalTipoCambio) throws Exception {
		ProformaParameterReturnGeneral  proformaReturnGeneral =new ProformaParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Proforma.class.getSimpleName()+"-cargarCombosLoteForeignKeyProformaWithConnection");connexion.begin();
			
			proformaReturnGeneral =new ProformaParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			proformaReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Sucursal> sucursalsForeignKey=new ArrayList<Sucursal>();
			SucursalLogic sucursalLogic=new SucursalLogic();
			sucursalLogic.setConnexion(this.connexion);
			//sucursalLogic.getSucursalDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalSucursal.equals("NONE")) {
				sucursalLogic.getTodosSucursals(finalQueryGlobalSucursal,new Pagination());
				sucursalsForeignKey=sucursalLogic.getSucursals();
			}

			proformaReturnGeneral.setsucursalsForeignKey(sucursalsForeignKey);


			List<Usuario> usuariosForeignKey=new ArrayList<Usuario>();
			UsuarioLogic usuarioLogic=new UsuarioLogic();
			usuarioLogic.setConnexion(this.connexion);
			//usuarioLogic.getUsuarioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalUsuario.equals("NONE")) {
				usuarioLogic.getTodosUsuarios(finalQueryGlobalUsuario,new Pagination());
				usuariosForeignKey=usuarioLogic.getUsuarios();
			}

			proformaReturnGeneral.setusuariosForeignKey(usuariosForeignKey);


			List<Ejercicio> ejerciciosForeignKey=new ArrayList<Ejercicio>();
			EjercicioLogic ejercicioLogic=new EjercicioLogic();
			ejercicioLogic.setConnexion(this.connexion);
			//ejercicioLogic.getEjercicioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEjercicio.equals("NONE")) {
				ejercicioLogic.getTodosEjercicios(finalQueryGlobalEjercicio,new Pagination());
				ejerciciosForeignKey=ejercicioLogic.getEjercicios();
			}

			proformaReturnGeneral.setejerciciosForeignKey(ejerciciosForeignKey);


			List<Periodo> periodosForeignKey=new ArrayList<Periodo>();
			PeriodoLogic periodoLogic=new PeriodoLogic();
			periodoLogic.setConnexion(this.connexion);
			//periodoLogic.getPeriodoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalPeriodo.equals("NONE")) {
				periodoLogic.getTodosPeriodos(finalQueryGlobalPeriodo,new Pagination());
				periodosForeignKey=periodoLogic.getPeriodos();
			}

			proformaReturnGeneral.setperiodosForeignKey(periodosForeignKey);


			List<Anio> aniosForeignKey=new ArrayList<Anio>();
			AnioLogic anioLogic=new AnioLogic();
			anioLogic.setConnexion(this.connexion);
			anioLogic.getAnioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalAnio.equals("NONE")) {
				anioLogic.getTodosAnios(finalQueryGlobalAnio,new Pagination());
				aniosForeignKey=anioLogic.getAnios();
			}

			proformaReturnGeneral.setaniosForeignKey(aniosForeignKey);


			List<Mes> messForeignKey=new ArrayList<Mes>();
			MesLogic mesLogic=new MesLogic();
			mesLogic.setConnexion(this.connexion);
			mesLogic.getMesDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalMes.equals("NONE")) {
				mesLogic.getTodosMess(finalQueryGlobalMes,new Pagination());
				messForeignKey=mesLogic.getMess();
			}

			proformaReturnGeneral.setmessForeignKey(messForeignKey);


			List<Moneda> monedasForeignKey=new ArrayList<Moneda>();
			MonedaLogic monedaLogic=new MonedaLogic();
			monedaLogic.setConnexion(this.connexion);
			//monedaLogic.getMonedaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalMoneda.equals("NONE")) {
				monedaLogic.getTodosMonedas(finalQueryGlobalMoneda,new Pagination());
				monedasForeignKey=monedaLogic.getMonedas();
			}

			proformaReturnGeneral.setmonedasForeignKey(monedasForeignKey);


			List<Empleado> empleadosForeignKey=new ArrayList<Empleado>();
			EmpleadoLogic empleadoLogic=new EmpleadoLogic();
			empleadoLogic.setConnexion(this.connexion);
			empleadoLogic.getEmpleadoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpleado.equals("NONE")) {
				empleadoLogic.getTodosEmpleados(finalQueryGlobalEmpleado,new Pagination());
				empleadosForeignKey=empleadoLogic.getEmpleados();
			}

			proformaReturnGeneral.setempleadosForeignKey(empleadosForeignKey);


			List<Formato> formatosForeignKey=new ArrayList<Formato>();
			FormatoLogic formatoLogic=new FormatoLogic();
			formatoLogic.setConnexion(this.connexion);
			formatoLogic.getFormatoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalFormato.equals("NONE")) {
				formatoLogic.getTodosFormatos(finalQueryGlobalFormato,new Pagination());
				formatosForeignKey=formatoLogic.getFormatos();
			}

			proformaReturnGeneral.setformatosForeignKey(formatosForeignKey);


			List<EstadoProforma> estadoproformasForeignKey=new ArrayList<EstadoProforma>();
			EstadoProformaLogic estadoproformaLogic=new EstadoProformaLogic();
			estadoproformaLogic.setConnexion(this.connexion);
			estadoproformaLogic.getEstadoProformaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEstadoProforma.equals("NONE")) {
				estadoproformaLogic.getTodosEstadoProformas(finalQueryGlobalEstadoProforma,new Pagination());
				estadoproformasForeignKey=estadoproformaLogic.getEstadoProformas();
			}

			proformaReturnGeneral.setestadoproformasForeignKey(estadoproformasForeignKey);


			List<Cliente> clientesForeignKey=new ArrayList<Cliente>();
			ClienteLogic clienteLogic=new ClienteLogic();
			clienteLogic.setConnexion(this.connexion);
			clienteLogic.getClienteDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCliente.equals("NONE")) {
				clienteLogic.getTodosClientes(finalQueryGlobalCliente,new Pagination());
				clientesForeignKey=clienteLogic.getClientes();
			}

			proformaReturnGeneral.setclientesForeignKey(clientesForeignKey);


			List<TipoPrecio> tipopreciosForeignKey=new ArrayList<TipoPrecio>();
			TipoPrecioLogic tipoprecioLogic=new TipoPrecioLogic();
			tipoprecioLogic.setConnexion(this.connexion);
			tipoprecioLogic.getTipoPrecioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoPrecio.equals("NONE")) {
				tipoprecioLogic.getTodosTipoPrecios(finalQueryGlobalTipoPrecio,new Pagination());
				tipopreciosForeignKey=tipoprecioLogic.getTipoPrecios();
			}

			proformaReturnGeneral.settipopreciosForeignKey(tipopreciosForeignKey);


			List<Vendedor> vendedorsForeignKey=new ArrayList<Vendedor>();
			VendedorLogic vendedorLogic=new VendedorLogic();
			vendedorLogic.setConnexion(this.connexion);
			vendedorLogic.getVendedorDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalVendedor.equals("NONE")) {
				vendedorLogic.getTodosVendedors(finalQueryGlobalVendedor,new Pagination());
				vendedorsForeignKey=vendedorLogic.getVendedors();
			}

			proformaReturnGeneral.setvendedorsForeignKey(vendedorsForeignKey);


			List<SubCliente> subclientesForeignKey=new ArrayList<SubCliente>();
			SubClienteLogic subclienteLogic=new SubClienteLogic();
			subclienteLogic.setConnexion(this.connexion);
			subclienteLogic.getSubClienteDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalSubCliente.equals("NONE")) {
				subclienteLogic.getTodosSubClientes(finalQueryGlobalSubCliente,new Pagination());
				subclientesForeignKey=subclienteLogic.getSubClientes();
			}

			proformaReturnGeneral.setsubclientesForeignKey(subclientesForeignKey);


			List<TipoViaTransporte> tipoviatransportesForeignKey=new ArrayList<TipoViaTransporte>();
			TipoViaTransporteLogic tipoviatransporteLogic=new TipoViaTransporteLogic();
			tipoviatransporteLogic.setConnexion(this.connexion);
			tipoviatransporteLogic.getTipoViaTransporteDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoViaTransporte.equals("NONE")) {
				tipoviatransporteLogic.getTodosTipoViaTransportes(finalQueryGlobalTipoViaTransporte,new Pagination());
				tipoviatransportesForeignKey=tipoviatransporteLogic.getTipoViaTransportes();
			}

			proformaReturnGeneral.settipoviatransportesForeignKey(tipoviatransportesForeignKey);


			List<Transporte> transportesForeignKey=new ArrayList<Transporte>();
			TransporteLogic transporteLogic=new TransporteLogic();
			transporteLogic.setConnexion(this.connexion);
			transporteLogic.getTransporteDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTransporte.equals("NONE")) {
				transporteLogic.getTodosTransportes(finalQueryGlobalTransporte,new Pagination());
				transportesForeignKey=transporteLogic.getTransportes();
			}

			proformaReturnGeneral.settransportesForeignKey(transportesForeignKey);


			List<RutaTransporte> rutatransportesForeignKey=new ArrayList<RutaTransporte>();
			RutaTransporteLogic rutatransporteLogic=new RutaTransporteLogic();
			rutatransporteLogic.setConnexion(this.connexion);
			rutatransporteLogic.getRutaTransporteDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalRutaTransporte.equals("NONE")) {
				rutatransporteLogic.getTodosRutaTransportes(finalQueryGlobalRutaTransporte,new Pagination());
				rutatransportesForeignKey=rutatransporteLogic.getRutaTransportes();
			}

			proformaReturnGeneral.setrutatransportesForeignKey(rutatransportesForeignKey);


			List<CentroCosto> centrocostosForeignKey=new ArrayList<CentroCosto>();
			CentroCostoLogic centrocostoLogic=new CentroCostoLogic();
			centrocostoLogic.setConnexion(this.connexion);
			centrocostoLogic.getCentroCostoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCentroCosto.equals("NONE")) {
				centrocostoLogic.getTodosCentroCostos(finalQueryGlobalCentroCosto,new Pagination());
				centrocostosForeignKey=centrocostoLogic.getCentroCostos();
			}

			proformaReturnGeneral.setcentrocostosForeignKey(centrocostosForeignKey);


			List<TipoProforma> tipoproformasForeignKey=new ArrayList<TipoProforma>();
			TipoProformaLogic tipoproformaLogic=new TipoProformaLogic();
			tipoproformaLogic.setConnexion(this.connexion);
			tipoproformaLogic.getTipoProformaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoProforma.equals("NONE")) {
				tipoproformaLogic.getTodosTipoProformas(finalQueryGlobalTipoProforma,new Pagination());
				tipoproformasForeignKey=tipoproformaLogic.getTipoProformas();
			}

			proformaReturnGeneral.settipoproformasForeignKey(tipoproformasForeignKey);


			List<Consignatario> consignatariosForeignKey=new ArrayList<Consignatario>();
			ConsignatarioLogic consignatarioLogic=new ConsignatarioLogic();
			consignatarioLogic.setConnexion(this.connexion);
			consignatarioLogic.getConsignatarioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalConsignatario.equals("NONE")) {
				consignatarioLogic.getTodosConsignatarios(finalQueryGlobalConsignatario,new Pagination());
				consignatariosForeignKey=consignatarioLogic.getConsignatarios();
			}

			proformaReturnGeneral.setconsignatariosForeignKey(consignatariosForeignKey);


			List<TipoCambio> tipocambiosForeignKey=new ArrayList<TipoCambio>();
			TipoCambioLogic tipocambioLogic=new TipoCambioLogic();
			tipocambioLogic.setConnexion(this.connexion);
			tipocambioLogic.getTipoCambioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoCambio.equals("NONE")) {
				tipocambioLogic.getTodosTipoCambios(finalQueryGlobalTipoCambio,new Pagination());
				tipocambiosForeignKey=tipocambioLogic.getTipoCambios();
			}

			proformaReturnGeneral.settipocambiosForeignKey(tipocambiosForeignKey);

			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
		
		return proformaReturnGeneral;
	}
	
	public ProformaParameterReturnGeneral cargarCombosLoteForeignKeyProforma(String finalQueryGlobalEmpresa,String finalQueryGlobalSucursal,String finalQueryGlobalUsuario,String finalQueryGlobalEjercicio,String finalQueryGlobalPeriodo,String finalQueryGlobalAnio,String finalQueryGlobalMes,String finalQueryGlobalMoneda,String finalQueryGlobalEmpleado,String finalQueryGlobalFormato,String finalQueryGlobalEstadoProforma,String finalQueryGlobalCliente,String finalQueryGlobalTipoPrecio,String finalQueryGlobalVendedor,String finalQueryGlobalSubCliente,String finalQueryGlobalTipoViaTransporte,String finalQueryGlobalTransporte,String finalQueryGlobalRutaTransporte,String finalQueryGlobalCentroCosto,String finalQueryGlobalTipoProforma,String finalQueryGlobalConsignatario,String finalQueryGlobalTipoCambio) throws Exception {
		ProformaParameterReturnGeneral  proformaReturnGeneral =new ProformaParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {						
			proformaReturnGeneral =new ProformaParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			proformaReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Sucursal> sucursalsForeignKey=new ArrayList<Sucursal>();
			SucursalLogic sucursalLogic=new SucursalLogic();
			sucursalLogic.setConnexion(this.connexion);
			//sucursalLogic.getSucursalDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalSucursal.equals("NONE")) {
				sucursalLogic.getTodosSucursals(finalQueryGlobalSucursal,new Pagination());
				sucursalsForeignKey=sucursalLogic.getSucursals();
			}

			proformaReturnGeneral.setsucursalsForeignKey(sucursalsForeignKey);


			List<Usuario> usuariosForeignKey=new ArrayList<Usuario>();
			UsuarioLogic usuarioLogic=new UsuarioLogic();
			usuarioLogic.setConnexion(this.connexion);
			//usuarioLogic.getUsuarioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalUsuario.equals("NONE")) {
				usuarioLogic.getTodosUsuarios(finalQueryGlobalUsuario,new Pagination());
				usuariosForeignKey=usuarioLogic.getUsuarios();
			}

			proformaReturnGeneral.setusuariosForeignKey(usuariosForeignKey);


			List<Ejercicio> ejerciciosForeignKey=new ArrayList<Ejercicio>();
			EjercicioLogic ejercicioLogic=new EjercicioLogic();
			ejercicioLogic.setConnexion(this.connexion);
			//ejercicioLogic.getEjercicioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEjercicio.equals("NONE")) {
				ejercicioLogic.getTodosEjercicios(finalQueryGlobalEjercicio,new Pagination());
				ejerciciosForeignKey=ejercicioLogic.getEjercicios();
			}

			proformaReturnGeneral.setejerciciosForeignKey(ejerciciosForeignKey);


			List<Periodo> periodosForeignKey=new ArrayList<Periodo>();
			PeriodoLogic periodoLogic=new PeriodoLogic();
			periodoLogic.setConnexion(this.connexion);
			//periodoLogic.getPeriodoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalPeriodo.equals("NONE")) {
				periodoLogic.getTodosPeriodos(finalQueryGlobalPeriodo,new Pagination());
				periodosForeignKey=periodoLogic.getPeriodos();
			}

			proformaReturnGeneral.setperiodosForeignKey(periodosForeignKey);


			List<Anio> aniosForeignKey=new ArrayList<Anio>();
			AnioLogic anioLogic=new AnioLogic();
			anioLogic.setConnexion(this.connexion);
			anioLogic.getAnioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalAnio.equals("NONE")) {
				anioLogic.getTodosAnios(finalQueryGlobalAnio,new Pagination());
				aniosForeignKey=anioLogic.getAnios();
			}

			proformaReturnGeneral.setaniosForeignKey(aniosForeignKey);


			List<Mes> messForeignKey=new ArrayList<Mes>();
			MesLogic mesLogic=new MesLogic();
			mesLogic.setConnexion(this.connexion);
			mesLogic.getMesDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalMes.equals("NONE")) {
				mesLogic.getTodosMess(finalQueryGlobalMes,new Pagination());
				messForeignKey=mesLogic.getMess();
			}

			proformaReturnGeneral.setmessForeignKey(messForeignKey);


			List<Moneda> monedasForeignKey=new ArrayList<Moneda>();
			MonedaLogic monedaLogic=new MonedaLogic();
			monedaLogic.setConnexion(this.connexion);
			//monedaLogic.getMonedaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalMoneda.equals("NONE")) {
				monedaLogic.getTodosMonedas(finalQueryGlobalMoneda,new Pagination());
				monedasForeignKey=monedaLogic.getMonedas();
			}

			proformaReturnGeneral.setmonedasForeignKey(monedasForeignKey);


			List<Empleado> empleadosForeignKey=new ArrayList<Empleado>();
			EmpleadoLogic empleadoLogic=new EmpleadoLogic();
			empleadoLogic.setConnexion(this.connexion);
			empleadoLogic.getEmpleadoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpleado.equals("NONE")) {
				empleadoLogic.getTodosEmpleados(finalQueryGlobalEmpleado,new Pagination());
				empleadosForeignKey=empleadoLogic.getEmpleados();
			}

			proformaReturnGeneral.setempleadosForeignKey(empleadosForeignKey);


			List<Formato> formatosForeignKey=new ArrayList<Formato>();
			FormatoLogic formatoLogic=new FormatoLogic();
			formatoLogic.setConnexion(this.connexion);
			formatoLogic.getFormatoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalFormato.equals("NONE")) {
				formatoLogic.getTodosFormatos(finalQueryGlobalFormato,new Pagination());
				formatosForeignKey=formatoLogic.getFormatos();
			}

			proformaReturnGeneral.setformatosForeignKey(formatosForeignKey);


			List<EstadoProforma> estadoproformasForeignKey=new ArrayList<EstadoProforma>();
			EstadoProformaLogic estadoproformaLogic=new EstadoProformaLogic();
			estadoproformaLogic.setConnexion(this.connexion);
			estadoproformaLogic.getEstadoProformaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEstadoProforma.equals("NONE")) {
				estadoproformaLogic.getTodosEstadoProformas(finalQueryGlobalEstadoProforma,new Pagination());
				estadoproformasForeignKey=estadoproformaLogic.getEstadoProformas();
			}

			proformaReturnGeneral.setestadoproformasForeignKey(estadoproformasForeignKey);


			List<Cliente> clientesForeignKey=new ArrayList<Cliente>();
			ClienteLogic clienteLogic=new ClienteLogic();
			clienteLogic.setConnexion(this.connexion);
			clienteLogic.getClienteDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCliente.equals("NONE")) {
				clienteLogic.getTodosClientes(finalQueryGlobalCliente,new Pagination());
				clientesForeignKey=clienteLogic.getClientes();
			}

			proformaReturnGeneral.setclientesForeignKey(clientesForeignKey);


			List<TipoPrecio> tipopreciosForeignKey=new ArrayList<TipoPrecio>();
			TipoPrecioLogic tipoprecioLogic=new TipoPrecioLogic();
			tipoprecioLogic.setConnexion(this.connexion);
			tipoprecioLogic.getTipoPrecioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoPrecio.equals("NONE")) {
				tipoprecioLogic.getTodosTipoPrecios(finalQueryGlobalTipoPrecio,new Pagination());
				tipopreciosForeignKey=tipoprecioLogic.getTipoPrecios();
			}

			proformaReturnGeneral.settipopreciosForeignKey(tipopreciosForeignKey);


			List<Vendedor> vendedorsForeignKey=new ArrayList<Vendedor>();
			VendedorLogic vendedorLogic=new VendedorLogic();
			vendedorLogic.setConnexion(this.connexion);
			vendedorLogic.getVendedorDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalVendedor.equals("NONE")) {
				vendedorLogic.getTodosVendedors(finalQueryGlobalVendedor,new Pagination());
				vendedorsForeignKey=vendedorLogic.getVendedors();
			}

			proformaReturnGeneral.setvendedorsForeignKey(vendedorsForeignKey);


			List<SubCliente> subclientesForeignKey=new ArrayList<SubCliente>();
			SubClienteLogic subclienteLogic=new SubClienteLogic();
			subclienteLogic.setConnexion(this.connexion);
			subclienteLogic.getSubClienteDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalSubCliente.equals("NONE")) {
				subclienteLogic.getTodosSubClientes(finalQueryGlobalSubCliente,new Pagination());
				subclientesForeignKey=subclienteLogic.getSubClientes();
			}

			proformaReturnGeneral.setsubclientesForeignKey(subclientesForeignKey);


			List<TipoViaTransporte> tipoviatransportesForeignKey=new ArrayList<TipoViaTransporte>();
			TipoViaTransporteLogic tipoviatransporteLogic=new TipoViaTransporteLogic();
			tipoviatransporteLogic.setConnexion(this.connexion);
			tipoviatransporteLogic.getTipoViaTransporteDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoViaTransporte.equals("NONE")) {
				tipoviatransporteLogic.getTodosTipoViaTransportes(finalQueryGlobalTipoViaTransporte,new Pagination());
				tipoviatransportesForeignKey=tipoviatransporteLogic.getTipoViaTransportes();
			}

			proformaReturnGeneral.settipoviatransportesForeignKey(tipoviatransportesForeignKey);


			List<Transporte> transportesForeignKey=new ArrayList<Transporte>();
			TransporteLogic transporteLogic=new TransporteLogic();
			transporteLogic.setConnexion(this.connexion);
			transporteLogic.getTransporteDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTransporte.equals("NONE")) {
				transporteLogic.getTodosTransportes(finalQueryGlobalTransporte,new Pagination());
				transportesForeignKey=transporteLogic.getTransportes();
			}

			proformaReturnGeneral.settransportesForeignKey(transportesForeignKey);


			List<RutaTransporte> rutatransportesForeignKey=new ArrayList<RutaTransporte>();
			RutaTransporteLogic rutatransporteLogic=new RutaTransporteLogic();
			rutatransporteLogic.setConnexion(this.connexion);
			rutatransporteLogic.getRutaTransporteDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalRutaTransporte.equals("NONE")) {
				rutatransporteLogic.getTodosRutaTransportes(finalQueryGlobalRutaTransporte,new Pagination());
				rutatransportesForeignKey=rutatransporteLogic.getRutaTransportes();
			}

			proformaReturnGeneral.setrutatransportesForeignKey(rutatransportesForeignKey);


			List<CentroCosto> centrocostosForeignKey=new ArrayList<CentroCosto>();
			CentroCostoLogic centrocostoLogic=new CentroCostoLogic();
			centrocostoLogic.setConnexion(this.connexion);
			centrocostoLogic.getCentroCostoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCentroCosto.equals("NONE")) {
				centrocostoLogic.getTodosCentroCostos(finalQueryGlobalCentroCosto,new Pagination());
				centrocostosForeignKey=centrocostoLogic.getCentroCostos();
			}

			proformaReturnGeneral.setcentrocostosForeignKey(centrocostosForeignKey);


			List<TipoProforma> tipoproformasForeignKey=new ArrayList<TipoProforma>();
			TipoProformaLogic tipoproformaLogic=new TipoProformaLogic();
			tipoproformaLogic.setConnexion(this.connexion);
			tipoproformaLogic.getTipoProformaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoProforma.equals("NONE")) {
				tipoproformaLogic.getTodosTipoProformas(finalQueryGlobalTipoProforma,new Pagination());
				tipoproformasForeignKey=tipoproformaLogic.getTipoProformas();
			}

			proformaReturnGeneral.settipoproformasForeignKey(tipoproformasForeignKey);


			List<Consignatario> consignatariosForeignKey=new ArrayList<Consignatario>();
			ConsignatarioLogic consignatarioLogic=new ConsignatarioLogic();
			consignatarioLogic.setConnexion(this.connexion);
			consignatarioLogic.getConsignatarioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalConsignatario.equals("NONE")) {
				consignatarioLogic.getTodosConsignatarios(finalQueryGlobalConsignatario,new Pagination());
				consignatariosForeignKey=consignatarioLogic.getConsignatarios();
			}

			proformaReturnGeneral.setconsignatariosForeignKey(consignatariosForeignKey);


			List<TipoCambio> tipocambiosForeignKey=new ArrayList<TipoCambio>();
			TipoCambioLogic tipocambioLogic=new TipoCambioLogic();
			tipocambioLogic.setConnexion(this.connexion);
			tipocambioLogic.getTipoCambioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoCambio.equals("NONE")) {
				tipocambioLogic.getTodosTipoCambios(finalQueryGlobalTipoCambio,new Pagination());
				tipocambiosForeignKey=tipocambioLogic.getTipoCambios();
			}

			proformaReturnGeneral.settipocambiosForeignKey(tipocambiosForeignKey);
						
			
		} catch(Exception e) {			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			
		}
		
		return proformaReturnGeneral;
	}
	
	public void cargarRelacionesLoteForeignKeyProformaWithConnection() throws Exception {
		ArrayList<Classe> classes=new ArrayList<Classe>();		
		
		
			TerminoProformaLogic terminoproformaLogic=new TerminoProformaLogic();
			DetalleProformaLogic detalleproformaLogic=new DetalleProformaLogic();
		
		try {
			
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Proforma.class.getSimpleName()+"-cargarRelacionesLoteForeignKeyProformaWithConnection");connexion.begin();
			
			
			classes.add(new Classe(TerminoProforma.class));
			classes.add(new Classe(DetalleProforma.class));
											
			

			terminoproformaLogic.setConnexion(this.getConnexion());
			terminoproformaLogic.setDatosCliente(this.datosCliente);
			terminoproformaLogic.setIsConRefrescarForeignKeys(true);

			detalleproformaLogic.setConnexion(this.getConnexion());
			detalleproformaLogic.setDatosCliente(this.datosCliente);
			detalleproformaLogic.setIsConRefrescarForeignKeys(true);
			
			this.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
			
			for(Proforma proforma:this.proformas) {
				

				classes=new ArrayList<Classe>();
				classes=TerminoProformaConstantesFunciones.getClassesForeignKeysOfTerminoProforma(new ArrayList<Classe>(),DeepLoadType.NONE);

				terminoproformaLogic.setTerminoProformas(proforma.terminoproformas);
				terminoproformaLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");

				classes=new ArrayList<Classe>();
				classes=DetalleProformaConstantesFunciones.getClassesForeignKeysOfDetalleProforma(new ArrayList<Classe>(),DeepLoadType.NONE);

				detalleproformaLogic.setDetalleProformas(proforma.detalleproformas);
				detalleproformaLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
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
	
	public void deepLoad(Proforma proforma,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			ProformaLogicAdditional.updateProformaToGet(proforma,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		proforma.setEmpresa(proformaDataAccess.getEmpresa(connexion,proforma));
		proforma.setSucursal(proformaDataAccess.getSucursal(connexion,proforma));
		proforma.setUsuario(proformaDataAccess.getUsuario(connexion,proforma));
		proforma.setEjercicio(proformaDataAccess.getEjercicio(connexion,proforma));
		proforma.setPeriodo(proformaDataAccess.getPeriodo(connexion,proforma));
		proforma.setAnio(proformaDataAccess.getAnio(connexion,proforma));
		proforma.setMes(proformaDataAccess.getMes(connexion,proforma));
		proforma.setMoneda(proformaDataAccess.getMoneda(connexion,proforma));
		proforma.setEmpleado(proformaDataAccess.getEmpleado(connexion,proforma));
		proforma.setFormato(proformaDataAccess.getFormato(connexion,proforma));
		proforma.setEstadoProforma(proformaDataAccess.getEstadoProforma(connexion,proforma));
		proforma.setCliente(proformaDataAccess.getCliente(connexion,proforma));
		proforma.setTipoPrecio(proformaDataAccess.getTipoPrecio(connexion,proforma));
		proforma.setVendedor(proformaDataAccess.getVendedor(connexion,proforma));
		proforma.setSubCliente(proformaDataAccess.getSubCliente(connexion,proforma));
		proforma.setTipoViaTransporte(proformaDataAccess.getTipoViaTransporte(connexion,proforma));
		proforma.setTransporte(proformaDataAccess.getTransporte(connexion,proforma));
		proforma.setRutaTransporte(proformaDataAccess.getRutaTransporte(connexion,proforma));
		proforma.setCentroCosto(proformaDataAccess.getCentroCosto(connexion,proforma));
		proforma.setTipoProforma(proformaDataAccess.getTipoProforma(connexion,proforma));
		proforma.setConsignatario(proformaDataAccess.getConsignatario(connexion,proforma));
		proforma.setTipoCambio(proformaDataAccess.getTipoCambio(connexion,proforma));
		proforma.setTerminoProformas(proformaDataAccess.getTerminoProformas(connexion,proforma));
		proforma.setDetalleProformas(proformaDataAccess.getDetalleProformas(connexion,proforma));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				proforma.setEmpresa(proformaDataAccess.getEmpresa(connexion,proforma));
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				proforma.setSucursal(proformaDataAccess.getSucursal(connexion,proforma));
				continue;
			}

			if(clas.clas.equals(Usuario.class)) {
				proforma.setUsuario(proformaDataAccess.getUsuario(connexion,proforma));
				continue;
			}

			if(clas.clas.equals(Ejercicio.class)) {
				proforma.setEjercicio(proformaDataAccess.getEjercicio(connexion,proforma));
				continue;
			}

			if(clas.clas.equals(Periodo.class)) {
				proforma.setPeriodo(proformaDataAccess.getPeriodo(connexion,proforma));
				continue;
			}

			if(clas.clas.equals(Anio.class)) {
				proforma.setAnio(proformaDataAccess.getAnio(connexion,proforma));
				continue;
			}

			if(clas.clas.equals(Mes.class)) {
				proforma.setMes(proformaDataAccess.getMes(connexion,proforma));
				continue;
			}

			if(clas.clas.equals(Moneda.class)) {
				proforma.setMoneda(proformaDataAccess.getMoneda(connexion,proforma));
				continue;
			}

			if(clas.clas.equals(Empleado.class)) {
				proforma.setEmpleado(proformaDataAccess.getEmpleado(connexion,proforma));
				continue;
			}

			if(clas.clas.equals(Formato.class)) {
				proforma.setFormato(proformaDataAccess.getFormato(connexion,proforma));
				continue;
			}

			if(clas.clas.equals(EstadoProforma.class)) {
				proforma.setEstadoProforma(proformaDataAccess.getEstadoProforma(connexion,proforma));
				continue;
			}

			if(clas.clas.equals(Cliente.class)) {
				proforma.setCliente(proformaDataAccess.getCliente(connexion,proforma));
				continue;
			}

			if(clas.clas.equals(TipoPrecio.class)) {
				proforma.setTipoPrecio(proformaDataAccess.getTipoPrecio(connexion,proforma));
				continue;
			}

			if(clas.clas.equals(Vendedor.class)) {
				proforma.setVendedor(proformaDataAccess.getVendedor(connexion,proforma));
				continue;
			}

			if(clas.clas.equals(SubCliente.class)) {
				proforma.setSubCliente(proformaDataAccess.getSubCliente(connexion,proforma));
				continue;
			}

			if(clas.clas.equals(TipoViaTransporte.class)) {
				proforma.setTipoViaTransporte(proformaDataAccess.getTipoViaTransporte(connexion,proforma));
				continue;
			}

			if(clas.clas.equals(Transporte.class)) {
				proforma.setTransporte(proformaDataAccess.getTransporte(connexion,proforma));
				continue;
			}

			if(clas.clas.equals(RutaTransporte.class)) {
				proforma.setRutaTransporte(proformaDataAccess.getRutaTransporte(connexion,proforma));
				continue;
			}

			if(clas.clas.equals(CentroCosto.class)) {
				proforma.setCentroCosto(proformaDataAccess.getCentroCosto(connexion,proforma));
				continue;
			}

			if(clas.clas.equals(TipoProforma.class)) {
				proforma.setTipoProforma(proformaDataAccess.getTipoProforma(connexion,proforma));
				continue;
			}

			if(clas.clas.equals(Consignatario.class)) {
				proforma.setConsignatario(proformaDataAccess.getConsignatario(connexion,proforma));
				continue;
			}

			if(clas.clas.equals(TipoCambio.class)) {
				proforma.setTipoCambio(proformaDataAccess.getTipoCambio(connexion,proforma));
				continue;
			}

			if(clas.clas.equals(TerminoProforma.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				proforma.setTerminoProformas(proformaDataAccess.getTerminoProformas(connexion,proforma));

				if(this.isConDeep) {
					TerminoProformaLogic terminoproformaLogic= new TerminoProformaLogic(this.connexion);
					terminoproformaLogic.setTerminoProformas(proforma.getTerminoProformas());
					ArrayList<Classe> classesLocal=TerminoProformaConstantesFunciones.getClassesForeignKeysOfTerminoProforma(new ArrayList<Classe>(),DeepLoadType.NONE);
					terminoproformaLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					TerminoProformaConstantesFunciones.refrescarForeignKeysDescripcionesTerminoProforma(terminoproformaLogic.getTerminoProformas());
					proforma.setTerminoProformas(terminoproformaLogic.getTerminoProformas());
				}

				continue;
			}

			if(clas.clas.equals(DetalleProforma.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				proforma.setDetalleProformas(proformaDataAccess.getDetalleProformas(connexion,proforma));

				if(this.isConDeep) {
					DetalleProformaLogic detalleproformaLogic= new DetalleProformaLogic(this.connexion);
					detalleproformaLogic.setDetalleProformas(proforma.getDetalleProformas());
					ArrayList<Classe> classesLocal=DetalleProformaConstantesFunciones.getClassesForeignKeysOfDetalleProforma(new ArrayList<Classe>(),DeepLoadType.NONE);
					detalleproformaLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					DetalleProformaConstantesFunciones.refrescarForeignKeysDescripcionesDetalleProforma(detalleproformaLogic.getDetalleProformas());
					proforma.setDetalleProformas(detalleproformaLogic.getDetalleProformas());
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
			proforma.setEmpresa(proformaDataAccess.getEmpresa(connexion,proforma));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			proforma.setSucursal(proformaDataAccess.getSucursal(connexion,proforma));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Usuario.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			proforma.setUsuario(proformaDataAccess.getUsuario(connexion,proforma));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Ejercicio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			proforma.setEjercicio(proformaDataAccess.getEjercicio(connexion,proforma));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Periodo.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			proforma.setPeriodo(proformaDataAccess.getPeriodo(connexion,proforma));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Anio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			proforma.setAnio(proformaDataAccess.getAnio(connexion,proforma));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Mes.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			proforma.setMes(proformaDataAccess.getMes(connexion,proforma));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Moneda.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			proforma.setMoneda(proformaDataAccess.getMoneda(connexion,proforma));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Empleado.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			proforma.setEmpleado(proformaDataAccess.getEmpleado(connexion,proforma));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Formato.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			proforma.setFormato(proformaDataAccess.getFormato(connexion,proforma));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(EstadoProforma.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			proforma.setEstadoProforma(proformaDataAccess.getEstadoProforma(connexion,proforma));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Cliente.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			proforma.setCliente(proformaDataAccess.getCliente(connexion,proforma));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(TipoPrecio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			proforma.setTipoPrecio(proformaDataAccess.getTipoPrecio(connexion,proforma));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Vendedor.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			proforma.setVendedor(proformaDataAccess.getVendedor(connexion,proforma));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(SubCliente.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			proforma.setSubCliente(proformaDataAccess.getSubCliente(connexion,proforma));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(TipoViaTransporte.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			proforma.setTipoViaTransporte(proformaDataAccess.getTipoViaTransporte(connexion,proforma));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Transporte.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			proforma.setTransporte(proformaDataAccess.getTransporte(connexion,proforma));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(RutaTransporte.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			proforma.setRutaTransporte(proformaDataAccess.getRutaTransporte(connexion,proforma));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(CentroCosto.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			proforma.setCentroCosto(proformaDataAccess.getCentroCosto(connexion,proforma));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(TipoProforma.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			proforma.setTipoProforma(proformaDataAccess.getTipoProforma(connexion,proforma));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Consignatario.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			proforma.setConsignatario(proformaDataAccess.getConsignatario(connexion,proforma));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(TipoCambio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			proforma.setTipoCambio(proformaDataAccess.getTipoCambio(connexion,proforma));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(TerminoProforma.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(TerminoProforma.class));
			proforma.setTerminoProformas(proformaDataAccess.getTerminoProformas(connexion,proforma));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(DetalleProforma.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(DetalleProforma.class));
			proforma.setDetalleProformas(proformaDataAccess.getDetalleProformas(connexion,proforma));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		proforma.setEmpresa(proformaDataAccess.getEmpresa(connexion,proforma));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(proforma.getEmpresa(),isDeep,deepLoadType,clases);
				
		proforma.setSucursal(proformaDataAccess.getSucursal(connexion,proforma));
		SucursalLogic sucursalLogic= new SucursalLogic(connexion);
		sucursalLogic.deepLoad(proforma.getSucursal(),isDeep,deepLoadType,clases);
				
		proforma.setUsuario(proformaDataAccess.getUsuario(connexion,proforma));
		UsuarioLogic usuarioLogic= new UsuarioLogic(connexion);
		usuarioLogic.deepLoad(proforma.getUsuario(),isDeep,deepLoadType,clases);
				
		proforma.setEjercicio(proformaDataAccess.getEjercicio(connexion,proforma));
		EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
		ejercicioLogic.deepLoad(proforma.getEjercicio(),isDeep,deepLoadType,clases);
				
		proforma.setPeriodo(proformaDataAccess.getPeriodo(connexion,proforma));
		PeriodoLogic periodoLogic= new PeriodoLogic(connexion);
		periodoLogic.deepLoad(proforma.getPeriodo(),isDeep,deepLoadType,clases);
				
		proforma.setAnio(proformaDataAccess.getAnio(connexion,proforma));
		AnioLogic anioLogic= new AnioLogic(connexion);
		anioLogic.deepLoad(proforma.getAnio(),isDeep,deepLoadType,clases);
				
		proforma.setMes(proformaDataAccess.getMes(connexion,proforma));
		MesLogic mesLogic= new MesLogic(connexion);
		mesLogic.deepLoad(proforma.getMes(),isDeep,deepLoadType,clases);
				
		proforma.setMoneda(proformaDataAccess.getMoneda(connexion,proforma));
		MonedaLogic monedaLogic= new MonedaLogic(connexion);
		monedaLogic.deepLoad(proforma.getMoneda(),isDeep,deepLoadType,clases);
				
		proforma.setEmpleado(proformaDataAccess.getEmpleado(connexion,proforma));
		EmpleadoLogic empleadoLogic= new EmpleadoLogic(connexion);
		empleadoLogic.deepLoad(proforma.getEmpleado(),isDeep,deepLoadType,clases);
				
		proforma.setFormato(proformaDataAccess.getFormato(connexion,proforma));
		FormatoLogic formatoLogic= new FormatoLogic(connexion);
		formatoLogic.deepLoad(proforma.getFormato(),isDeep,deepLoadType,clases);
				
		proforma.setEstadoProforma(proformaDataAccess.getEstadoProforma(connexion,proforma));
		EstadoProformaLogic estadoproformaLogic= new EstadoProformaLogic(connexion);
		estadoproformaLogic.deepLoad(proforma.getEstadoProforma(),isDeep,deepLoadType,clases);
				
		proforma.setCliente(proformaDataAccess.getCliente(connexion,proforma));
		ClienteLogic clienteLogic= new ClienteLogic(connexion);
		clienteLogic.deepLoad(proforma.getCliente(),isDeep,deepLoadType,clases);
				
		proforma.setTipoPrecio(proformaDataAccess.getTipoPrecio(connexion,proforma));
		TipoPrecioLogic tipoprecioLogic= new TipoPrecioLogic(connexion);
		tipoprecioLogic.deepLoad(proforma.getTipoPrecio(),isDeep,deepLoadType,clases);
				
		proforma.setVendedor(proformaDataAccess.getVendedor(connexion,proforma));
		VendedorLogic vendedorLogic= new VendedorLogic(connexion);
		vendedorLogic.deepLoad(proforma.getVendedor(),isDeep,deepLoadType,clases);
				
		proforma.setSubCliente(proformaDataAccess.getSubCliente(connexion,proforma));
		SubClienteLogic subclienteLogic= new SubClienteLogic(connexion);
		subclienteLogic.deepLoad(proforma.getSubCliente(),isDeep,deepLoadType,clases);
				
		proforma.setTipoViaTransporte(proformaDataAccess.getTipoViaTransporte(connexion,proforma));
		TipoViaTransporteLogic tipoviatransporteLogic= new TipoViaTransporteLogic(connexion);
		tipoviatransporteLogic.deepLoad(proforma.getTipoViaTransporte(),isDeep,deepLoadType,clases);
				
		proforma.setTransporte(proformaDataAccess.getTransporte(connexion,proforma));
		TransporteLogic transporteLogic= new TransporteLogic(connexion);
		transporteLogic.deepLoad(proforma.getTransporte(),isDeep,deepLoadType,clases);
				
		proforma.setRutaTransporte(proformaDataAccess.getRutaTransporte(connexion,proforma));
		RutaTransporteLogic rutatransporteLogic= new RutaTransporteLogic(connexion);
		rutatransporteLogic.deepLoad(proforma.getRutaTransporte(),isDeep,deepLoadType,clases);
				
		proforma.setCentroCosto(proformaDataAccess.getCentroCosto(connexion,proforma));
		CentroCostoLogic centrocostoLogic= new CentroCostoLogic(connexion);
		centrocostoLogic.deepLoad(proforma.getCentroCosto(),isDeep,deepLoadType,clases);
				
		proforma.setTipoProforma(proformaDataAccess.getTipoProforma(connexion,proforma));
		TipoProformaLogic tipoproformaLogic= new TipoProformaLogic(connexion);
		tipoproformaLogic.deepLoad(proforma.getTipoProforma(),isDeep,deepLoadType,clases);
				
		proforma.setConsignatario(proformaDataAccess.getConsignatario(connexion,proforma));
		ConsignatarioLogic consignatarioLogic= new ConsignatarioLogic(connexion);
		consignatarioLogic.deepLoad(proforma.getConsignatario(),isDeep,deepLoadType,clases);
				
		proforma.setTipoCambio(proformaDataAccess.getTipoCambio(connexion,proforma));
		TipoCambioLogic tipocambioLogic= new TipoCambioLogic(connexion);
		tipocambioLogic.deepLoad(proforma.getTipoCambio(),isDeep,deepLoadType,clases);
				

		proforma.setTerminoProformas(proformaDataAccess.getTerminoProformas(connexion,proforma));

		for(TerminoProforma terminoproforma:proforma.getTerminoProformas()) {
			TerminoProformaLogic terminoproformaLogic= new TerminoProformaLogic(connexion);
			terminoproformaLogic.deepLoad(terminoproforma,isDeep,deepLoadType,clases);
		}

		proforma.setDetalleProformas(proformaDataAccess.getDetalleProformas(connexion,proforma));

		for(DetalleProforma detalleproforma:proforma.getDetalleProformas()) {
			DetalleProformaLogic detalleproformaLogic= new DetalleProformaLogic(connexion);
			detalleproformaLogic.deepLoad(detalleproforma,isDeep,deepLoadType,clases);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				proforma.setEmpresa(proformaDataAccess.getEmpresa(connexion,proforma));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(proforma.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				proforma.setSucursal(proformaDataAccess.getSucursal(connexion,proforma));
				SucursalLogic sucursalLogic= new SucursalLogic(connexion);
				sucursalLogic.deepLoad(proforma.getSucursal(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Usuario.class)) {
				proforma.setUsuario(proformaDataAccess.getUsuario(connexion,proforma));
				UsuarioLogic usuarioLogic= new UsuarioLogic(connexion);
				usuarioLogic.deepLoad(proforma.getUsuario(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Ejercicio.class)) {
				proforma.setEjercicio(proformaDataAccess.getEjercicio(connexion,proforma));
				EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
				ejercicioLogic.deepLoad(proforma.getEjercicio(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Periodo.class)) {
				proforma.setPeriodo(proformaDataAccess.getPeriodo(connexion,proforma));
				PeriodoLogic periodoLogic= new PeriodoLogic(connexion);
				periodoLogic.deepLoad(proforma.getPeriodo(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Anio.class)) {
				proforma.setAnio(proformaDataAccess.getAnio(connexion,proforma));
				AnioLogic anioLogic= new AnioLogic(connexion);
				anioLogic.deepLoad(proforma.getAnio(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Mes.class)) {
				proforma.setMes(proformaDataAccess.getMes(connexion,proforma));
				MesLogic mesLogic= new MesLogic(connexion);
				mesLogic.deepLoad(proforma.getMes(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Moneda.class)) {
				proforma.setMoneda(proformaDataAccess.getMoneda(connexion,proforma));
				MonedaLogic monedaLogic= new MonedaLogic(connexion);
				monedaLogic.deepLoad(proforma.getMoneda(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Empleado.class)) {
				proforma.setEmpleado(proformaDataAccess.getEmpleado(connexion,proforma));
				EmpleadoLogic empleadoLogic= new EmpleadoLogic(connexion);
				empleadoLogic.deepLoad(proforma.getEmpleado(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Formato.class)) {
				proforma.setFormato(proformaDataAccess.getFormato(connexion,proforma));
				FormatoLogic formatoLogic= new FormatoLogic(connexion);
				formatoLogic.deepLoad(proforma.getFormato(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(EstadoProforma.class)) {
				proforma.setEstadoProforma(proformaDataAccess.getEstadoProforma(connexion,proforma));
				EstadoProformaLogic estadoproformaLogic= new EstadoProformaLogic(connexion);
				estadoproformaLogic.deepLoad(proforma.getEstadoProforma(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Cliente.class)) {
				proforma.setCliente(proformaDataAccess.getCliente(connexion,proforma));
				ClienteLogic clienteLogic= new ClienteLogic(connexion);
				clienteLogic.deepLoad(proforma.getCliente(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoPrecio.class)) {
				proforma.setTipoPrecio(proformaDataAccess.getTipoPrecio(connexion,proforma));
				TipoPrecioLogic tipoprecioLogic= new TipoPrecioLogic(connexion);
				tipoprecioLogic.deepLoad(proforma.getTipoPrecio(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Vendedor.class)) {
				proforma.setVendedor(proformaDataAccess.getVendedor(connexion,proforma));
				VendedorLogic vendedorLogic= new VendedorLogic(connexion);
				vendedorLogic.deepLoad(proforma.getVendedor(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(SubCliente.class)) {
				proforma.setSubCliente(proformaDataAccess.getSubCliente(connexion,proforma));
				SubClienteLogic subclienteLogic= new SubClienteLogic(connexion);
				subclienteLogic.deepLoad(proforma.getSubCliente(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoViaTransporte.class)) {
				proforma.setTipoViaTransporte(proformaDataAccess.getTipoViaTransporte(connexion,proforma));
				TipoViaTransporteLogic tipoviatransporteLogic= new TipoViaTransporteLogic(connexion);
				tipoviatransporteLogic.deepLoad(proforma.getTipoViaTransporte(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Transporte.class)) {
				proforma.setTransporte(proformaDataAccess.getTransporte(connexion,proforma));
				TransporteLogic transporteLogic= new TransporteLogic(connexion);
				transporteLogic.deepLoad(proforma.getTransporte(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(RutaTransporte.class)) {
				proforma.setRutaTransporte(proformaDataAccess.getRutaTransporte(connexion,proforma));
				RutaTransporteLogic rutatransporteLogic= new RutaTransporteLogic(connexion);
				rutatransporteLogic.deepLoad(proforma.getRutaTransporte(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(CentroCosto.class)) {
				proforma.setCentroCosto(proformaDataAccess.getCentroCosto(connexion,proforma));
				CentroCostoLogic centrocostoLogic= new CentroCostoLogic(connexion);
				centrocostoLogic.deepLoad(proforma.getCentroCosto(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoProforma.class)) {
				proforma.setTipoProforma(proformaDataAccess.getTipoProforma(connexion,proforma));
				TipoProformaLogic tipoproformaLogic= new TipoProformaLogic(connexion);
				tipoproformaLogic.deepLoad(proforma.getTipoProforma(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Consignatario.class)) {
				proforma.setConsignatario(proformaDataAccess.getConsignatario(connexion,proforma));
				ConsignatarioLogic consignatarioLogic= new ConsignatarioLogic(connexion);
				consignatarioLogic.deepLoad(proforma.getConsignatario(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoCambio.class)) {
				proforma.setTipoCambio(proformaDataAccess.getTipoCambio(connexion,proforma));
				TipoCambioLogic tipocambioLogic= new TipoCambioLogic(connexion);
				tipocambioLogic.deepLoad(proforma.getTipoCambio(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TerminoProforma.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				proforma.setTerminoProformas(proformaDataAccess.getTerminoProformas(connexion,proforma));

				for(TerminoProforma terminoproforma:proforma.getTerminoProformas()) {
					TerminoProformaLogic terminoproformaLogic= new TerminoProformaLogic(connexion);
					terminoproformaLogic.deepLoad(terminoproforma,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(DetalleProforma.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				proforma.setDetalleProformas(proformaDataAccess.getDetalleProformas(connexion,proforma));

				for(DetalleProforma detalleproforma:proforma.getDetalleProformas()) {
					DetalleProformaLogic detalleproformaLogic= new DetalleProformaLogic(connexion);
					detalleproformaLogic.deepLoad(detalleproforma,isDeep,deepLoadType,clases);
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
			proforma.setEmpresa(proformaDataAccess.getEmpresa(connexion,proforma));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(proforma.getEmpresa(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			proforma.setSucursal(proformaDataAccess.getSucursal(connexion,proforma));
			SucursalLogic sucursalLogic= new SucursalLogic(connexion);
			sucursalLogic.deepLoad(proforma.getSucursal(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Usuario.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			proforma.setUsuario(proformaDataAccess.getUsuario(connexion,proforma));
			UsuarioLogic usuarioLogic= new UsuarioLogic(connexion);
			usuarioLogic.deepLoad(proforma.getUsuario(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Ejercicio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			proforma.setEjercicio(proformaDataAccess.getEjercicio(connexion,proforma));
			EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
			ejercicioLogic.deepLoad(proforma.getEjercicio(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Periodo.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			proforma.setPeriodo(proformaDataAccess.getPeriodo(connexion,proforma));
			PeriodoLogic periodoLogic= new PeriodoLogic(connexion);
			periodoLogic.deepLoad(proforma.getPeriodo(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Anio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			proforma.setAnio(proformaDataAccess.getAnio(connexion,proforma));
			AnioLogic anioLogic= new AnioLogic(connexion);
			anioLogic.deepLoad(proforma.getAnio(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Mes.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			proforma.setMes(proformaDataAccess.getMes(connexion,proforma));
			MesLogic mesLogic= new MesLogic(connexion);
			mesLogic.deepLoad(proforma.getMes(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Moneda.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			proforma.setMoneda(proformaDataAccess.getMoneda(connexion,proforma));
			MonedaLogic monedaLogic= new MonedaLogic(connexion);
			monedaLogic.deepLoad(proforma.getMoneda(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Empleado.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			proforma.setEmpleado(proformaDataAccess.getEmpleado(connexion,proforma));
			EmpleadoLogic empleadoLogic= new EmpleadoLogic(connexion);
			empleadoLogic.deepLoad(proforma.getEmpleado(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Formato.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			proforma.setFormato(proformaDataAccess.getFormato(connexion,proforma));
			FormatoLogic formatoLogic= new FormatoLogic(connexion);
			formatoLogic.deepLoad(proforma.getFormato(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(EstadoProforma.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			proforma.setEstadoProforma(proformaDataAccess.getEstadoProforma(connexion,proforma));
			EstadoProformaLogic estadoproformaLogic= new EstadoProformaLogic(connexion);
			estadoproformaLogic.deepLoad(proforma.getEstadoProforma(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Cliente.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			proforma.setCliente(proformaDataAccess.getCliente(connexion,proforma));
			ClienteLogic clienteLogic= new ClienteLogic(connexion);
			clienteLogic.deepLoad(proforma.getCliente(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(TipoPrecio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			proforma.setTipoPrecio(proformaDataAccess.getTipoPrecio(connexion,proforma));
			TipoPrecioLogic tipoprecioLogic= new TipoPrecioLogic(connexion);
			tipoprecioLogic.deepLoad(proforma.getTipoPrecio(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Vendedor.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			proforma.setVendedor(proformaDataAccess.getVendedor(connexion,proforma));
			VendedorLogic vendedorLogic= new VendedorLogic(connexion);
			vendedorLogic.deepLoad(proforma.getVendedor(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(SubCliente.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			proforma.setSubCliente(proformaDataAccess.getSubCliente(connexion,proforma));
			SubClienteLogic subclienteLogic= new SubClienteLogic(connexion);
			subclienteLogic.deepLoad(proforma.getSubCliente(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(TipoViaTransporte.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			proforma.setTipoViaTransporte(proformaDataAccess.getTipoViaTransporte(connexion,proforma));
			TipoViaTransporteLogic tipoviatransporteLogic= new TipoViaTransporteLogic(connexion);
			tipoviatransporteLogic.deepLoad(proforma.getTipoViaTransporte(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Transporte.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			proforma.setTransporte(proformaDataAccess.getTransporte(connexion,proforma));
			TransporteLogic transporteLogic= new TransporteLogic(connexion);
			transporteLogic.deepLoad(proforma.getTransporte(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(RutaTransporte.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			proforma.setRutaTransporte(proformaDataAccess.getRutaTransporte(connexion,proforma));
			RutaTransporteLogic rutatransporteLogic= new RutaTransporteLogic(connexion);
			rutatransporteLogic.deepLoad(proforma.getRutaTransporte(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(CentroCosto.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			proforma.setCentroCosto(proformaDataAccess.getCentroCosto(connexion,proforma));
			CentroCostoLogic centrocostoLogic= new CentroCostoLogic(connexion);
			centrocostoLogic.deepLoad(proforma.getCentroCosto(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(TipoProforma.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			proforma.setTipoProforma(proformaDataAccess.getTipoProforma(connexion,proforma));
			TipoProformaLogic tipoproformaLogic= new TipoProformaLogic(connexion);
			tipoproformaLogic.deepLoad(proforma.getTipoProforma(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Consignatario.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			proforma.setConsignatario(proformaDataAccess.getConsignatario(connexion,proforma));
			ConsignatarioLogic consignatarioLogic= new ConsignatarioLogic(connexion);
			consignatarioLogic.deepLoad(proforma.getConsignatario(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(TipoCambio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			proforma.setTipoCambio(proformaDataAccess.getTipoCambio(connexion,proforma));
			TipoCambioLogic tipocambioLogic= new TipoCambioLogic(connexion);
			tipocambioLogic.deepLoad(proforma.getTipoCambio(),isDeep,deepLoadType,clases);
				
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(TerminoProforma.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(TerminoProforma.class));
			proforma.setTerminoProformas(proformaDataAccess.getTerminoProformas(connexion,proforma));

			for(TerminoProforma terminoproforma:proforma.getTerminoProformas()) {
				TerminoProformaLogic terminoproformaLogic= new TerminoProformaLogic(connexion);
				terminoproformaLogic.deepLoad(terminoproforma,isDeep,deepLoadType,clases);
			}
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(DetalleProforma.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(DetalleProforma.class));
			proforma.setDetalleProformas(proformaDataAccess.getDetalleProformas(connexion,proforma));

			for(DetalleProforma detalleproforma:proforma.getDetalleProformas()) {
				DetalleProformaLogic detalleproformaLogic= new DetalleProformaLogic(connexion);
				detalleproformaLogic.deepLoad(detalleproforma,isDeep,deepLoadType,clases);
			}
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(Proforma proforma,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			ProformaLogicAdditional.updateProformaToSave(proforma,this.arrDatoGeneral);
			
ProformaDataAccess.save(proforma, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(proforma.getEmpresa(),connexion);

		SucursalDataAccess.save(proforma.getSucursal(),connexion);

		UsuarioDataAccess.save(proforma.getUsuario(),connexion);

		EjercicioDataAccess.save(proforma.getEjercicio(),connexion);

		PeriodoDataAccess.save(proforma.getPeriodo(),connexion);

		AnioDataAccess.save(proforma.getAnio(),connexion);

		MesDataAccess.save(proforma.getMes(),connexion);

		MonedaDataAccess.save(proforma.getMoneda(),connexion);

		EmpleadoDataAccess.save(proforma.getEmpleado(),connexion);

		FormatoDataAccess.save(proforma.getFormato(),connexion);

		EstadoProformaDataAccess.save(proforma.getEstadoProforma(),connexion);

		ClienteDataAccess.save(proforma.getCliente(),connexion);

		TipoPrecioDataAccess.save(proforma.getTipoPrecio(),connexion);

		VendedorDataAccess.save(proforma.getVendedor(),connexion);

		SubClienteDataAccess.save(proforma.getSubCliente(),connexion);

		TipoViaTransporteDataAccess.save(proforma.getTipoViaTransporte(),connexion);

		TransporteDataAccess.save(proforma.getTransporte(),connexion);

		RutaTransporteDataAccess.save(proforma.getRutaTransporte(),connexion);

		CentroCostoDataAccess.save(proforma.getCentroCosto(),connexion);

		TipoProformaDataAccess.save(proforma.getTipoProforma(),connexion);

		ConsignatarioDataAccess.save(proforma.getConsignatario(),connexion);

		TipoCambioDataAccess.save(proforma.getTipoCambio(),connexion);

		for(TerminoProforma terminoproforma:proforma.getTerminoProformas()) {
			terminoproforma.setid_proforma(proforma.getId());
			TerminoProformaDataAccess.save(terminoproforma,connexion);
		}

		for(DetalleProforma detalleproforma:proforma.getDetalleProformas()) {
			detalleproforma.setid_proforma(proforma.getId());
			DetalleProformaDataAccess.save(detalleproforma,connexion);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(proforma.getEmpresa(),connexion);
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				SucursalDataAccess.save(proforma.getSucursal(),connexion);
				continue;
			}

			if(clas.clas.equals(Usuario.class)) {
				UsuarioDataAccess.save(proforma.getUsuario(),connexion);
				continue;
			}

			if(clas.clas.equals(Ejercicio.class)) {
				EjercicioDataAccess.save(proforma.getEjercicio(),connexion);
				continue;
			}

			if(clas.clas.equals(Periodo.class)) {
				PeriodoDataAccess.save(proforma.getPeriodo(),connexion);
				continue;
			}

			if(clas.clas.equals(Anio.class)) {
				AnioDataAccess.save(proforma.getAnio(),connexion);
				continue;
			}

			if(clas.clas.equals(Mes.class)) {
				MesDataAccess.save(proforma.getMes(),connexion);
				continue;
			}

			if(clas.clas.equals(Moneda.class)) {
				MonedaDataAccess.save(proforma.getMoneda(),connexion);
				continue;
			}

			if(clas.clas.equals(Empleado.class)) {
				EmpleadoDataAccess.save(proforma.getEmpleado(),connexion);
				continue;
			}

			if(clas.clas.equals(Formato.class)) {
				FormatoDataAccess.save(proforma.getFormato(),connexion);
				continue;
			}

			if(clas.clas.equals(EstadoProforma.class)) {
				EstadoProformaDataAccess.save(proforma.getEstadoProforma(),connexion);
				continue;
			}

			if(clas.clas.equals(Cliente.class)) {
				ClienteDataAccess.save(proforma.getCliente(),connexion);
				continue;
			}

			if(clas.clas.equals(TipoPrecio.class)) {
				TipoPrecioDataAccess.save(proforma.getTipoPrecio(),connexion);
				continue;
			}

			if(clas.clas.equals(Vendedor.class)) {
				VendedorDataAccess.save(proforma.getVendedor(),connexion);
				continue;
			}

			if(clas.clas.equals(SubCliente.class)) {
				SubClienteDataAccess.save(proforma.getSubCliente(),connexion);
				continue;
			}

			if(clas.clas.equals(TipoViaTransporte.class)) {
				TipoViaTransporteDataAccess.save(proforma.getTipoViaTransporte(),connexion);
				continue;
			}

			if(clas.clas.equals(Transporte.class)) {
				TransporteDataAccess.save(proforma.getTransporte(),connexion);
				continue;
			}

			if(clas.clas.equals(RutaTransporte.class)) {
				RutaTransporteDataAccess.save(proforma.getRutaTransporte(),connexion);
				continue;
			}

			if(clas.clas.equals(CentroCosto.class)) {
				CentroCostoDataAccess.save(proforma.getCentroCosto(),connexion);
				continue;
			}

			if(clas.clas.equals(TipoProforma.class)) {
				TipoProformaDataAccess.save(proforma.getTipoProforma(),connexion);
				continue;
			}

			if(clas.clas.equals(Consignatario.class)) {
				ConsignatarioDataAccess.save(proforma.getConsignatario(),connexion);
				continue;
			}

			if(clas.clas.equals(TipoCambio.class)) {
				TipoCambioDataAccess.save(proforma.getTipoCambio(),connexion);
				continue;
			}


			if(clas.clas.equals(TerminoProforma.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(TerminoProforma terminoproforma:proforma.getTerminoProformas()) {
					terminoproforma.setid_proforma(proforma.getId());
					TerminoProformaDataAccess.save(terminoproforma,connexion);
				}
				continue;
			}

			if(clas.clas.equals(DetalleProforma.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(DetalleProforma detalleproforma:proforma.getDetalleProformas()) {
					detalleproforma.setid_proforma(proforma.getId());
					DetalleProformaDataAccess.save(detalleproforma,connexion);
				}
				continue;
			}
		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(proforma.getEmpresa(),connexion);
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(proforma.getEmpresa(),isDeep,deepLoadType,clases);
				

		SucursalDataAccess.save(proforma.getSucursal(),connexion);
		SucursalLogic sucursalLogic= new SucursalLogic(connexion);
		sucursalLogic.deepLoad(proforma.getSucursal(),isDeep,deepLoadType,clases);
				

		UsuarioDataAccess.save(proforma.getUsuario(),connexion);
		UsuarioLogic usuarioLogic= new UsuarioLogic(connexion);
		usuarioLogic.deepLoad(proforma.getUsuario(),isDeep,deepLoadType,clases);
				

		EjercicioDataAccess.save(proforma.getEjercicio(),connexion);
		EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
		ejercicioLogic.deepLoad(proforma.getEjercicio(),isDeep,deepLoadType,clases);
				

		PeriodoDataAccess.save(proforma.getPeriodo(),connexion);
		PeriodoLogic periodoLogic= new PeriodoLogic(connexion);
		periodoLogic.deepLoad(proforma.getPeriodo(),isDeep,deepLoadType,clases);
				

		AnioDataAccess.save(proforma.getAnio(),connexion);
		AnioLogic anioLogic= new AnioLogic(connexion);
		anioLogic.deepLoad(proforma.getAnio(),isDeep,deepLoadType,clases);
				

		MesDataAccess.save(proforma.getMes(),connexion);
		MesLogic mesLogic= new MesLogic(connexion);
		mesLogic.deepLoad(proforma.getMes(),isDeep,deepLoadType,clases);
				

		MonedaDataAccess.save(proforma.getMoneda(),connexion);
		MonedaLogic monedaLogic= new MonedaLogic(connexion);
		monedaLogic.deepLoad(proforma.getMoneda(),isDeep,deepLoadType,clases);
				

		EmpleadoDataAccess.save(proforma.getEmpleado(),connexion);
		EmpleadoLogic empleadoLogic= new EmpleadoLogic(connexion);
		empleadoLogic.deepLoad(proforma.getEmpleado(),isDeep,deepLoadType,clases);
				

		FormatoDataAccess.save(proforma.getFormato(),connexion);
		FormatoLogic formatoLogic= new FormatoLogic(connexion);
		formatoLogic.deepLoad(proforma.getFormato(),isDeep,deepLoadType,clases);
				

		EstadoProformaDataAccess.save(proforma.getEstadoProforma(),connexion);
		EstadoProformaLogic estadoproformaLogic= new EstadoProformaLogic(connexion);
		estadoproformaLogic.deepLoad(proforma.getEstadoProforma(),isDeep,deepLoadType,clases);
				

		ClienteDataAccess.save(proforma.getCliente(),connexion);
		ClienteLogic clienteLogic= new ClienteLogic(connexion);
		clienteLogic.deepLoad(proforma.getCliente(),isDeep,deepLoadType,clases);
				

		TipoPrecioDataAccess.save(proforma.getTipoPrecio(),connexion);
		TipoPrecioLogic tipoprecioLogic= new TipoPrecioLogic(connexion);
		tipoprecioLogic.deepLoad(proforma.getTipoPrecio(),isDeep,deepLoadType,clases);
				

		VendedorDataAccess.save(proforma.getVendedor(),connexion);
		VendedorLogic vendedorLogic= new VendedorLogic(connexion);
		vendedorLogic.deepLoad(proforma.getVendedor(),isDeep,deepLoadType,clases);
				

		SubClienteDataAccess.save(proforma.getSubCliente(),connexion);
		SubClienteLogic subclienteLogic= new SubClienteLogic(connexion);
		subclienteLogic.deepLoad(proforma.getSubCliente(),isDeep,deepLoadType,clases);
				

		TipoViaTransporteDataAccess.save(proforma.getTipoViaTransporte(),connexion);
		TipoViaTransporteLogic tipoviatransporteLogic= new TipoViaTransporteLogic(connexion);
		tipoviatransporteLogic.deepLoad(proforma.getTipoViaTransporte(),isDeep,deepLoadType,clases);
				

		TransporteDataAccess.save(proforma.getTransporte(),connexion);
		TransporteLogic transporteLogic= new TransporteLogic(connexion);
		transporteLogic.deepLoad(proforma.getTransporte(),isDeep,deepLoadType,clases);
				

		RutaTransporteDataAccess.save(proforma.getRutaTransporte(),connexion);
		RutaTransporteLogic rutatransporteLogic= new RutaTransporteLogic(connexion);
		rutatransporteLogic.deepLoad(proforma.getRutaTransporte(),isDeep,deepLoadType,clases);
				

		CentroCostoDataAccess.save(proforma.getCentroCosto(),connexion);
		CentroCostoLogic centrocostoLogic= new CentroCostoLogic(connexion);
		centrocostoLogic.deepLoad(proforma.getCentroCosto(),isDeep,deepLoadType,clases);
				

		TipoProformaDataAccess.save(proforma.getTipoProforma(),connexion);
		TipoProformaLogic tipoproformaLogic= new TipoProformaLogic(connexion);
		tipoproformaLogic.deepLoad(proforma.getTipoProforma(),isDeep,deepLoadType,clases);
				

		ConsignatarioDataAccess.save(proforma.getConsignatario(),connexion);
		ConsignatarioLogic consignatarioLogic= new ConsignatarioLogic(connexion);
		consignatarioLogic.deepLoad(proforma.getConsignatario(),isDeep,deepLoadType,clases);
				

		TipoCambioDataAccess.save(proforma.getTipoCambio(),connexion);
		TipoCambioLogic tipocambioLogic= new TipoCambioLogic(connexion);
		tipocambioLogic.deepLoad(proforma.getTipoCambio(),isDeep,deepLoadType,clases);
				

		for(TerminoProforma terminoproforma:proforma.getTerminoProformas()) {
			TerminoProformaLogic terminoproformaLogic= new TerminoProformaLogic(connexion);
			terminoproforma.setid_proforma(proforma.getId());
			TerminoProformaDataAccess.save(terminoproforma,connexion);
			terminoproformaLogic.deepSave(terminoproforma,isDeep,deepLoadType,clases);
		}

		for(DetalleProforma detalleproforma:proforma.getDetalleProformas()) {
			DetalleProformaLogic detalleproformaLogic= new DetalleProformaLogic(connexion);
			detalleproforma.setid_proforma(proforma.getId());
			DetalleProformaDataAccess.save(detalleproforma,connexion);
			detalleproformaLogic.deepSave(detalleproforma,isDeep,deepLoadType,clases);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(proforma.getEmpresa(),connexion);
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepSave(proforma.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				SucursalDataAccess.save(proforma.getSucursal(),connexion);
				SucursalLogic sucursalLogic= new SucursalLogic(connexion);
				sucursalLogic.deepSave(proforma.getSucursal(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Usuario.class)) {
				UsuarioDataAccess.save(proforma.getUsuario(),connexion);
				UsuarioLogic usuarioLogic= new UsuarioLogic(connexion);
				usuarioLogic.deepSave(proforma.getUsuario(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Ejercicio.class)) {
				EjercicioDataAccess.save(proforma.getEjercicio(),connexion);
				EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
				ejercicioLogic.deepSave(proforma.getEjercicio(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Periodo.class)) {
				PeriodoDataAccess.save(proforma.getPeriodo(),connexion);
				PeriodoLogic periodoLogic= new PeriodoLogic(connexion);
				periodoLogic.deepSave(proforma.getPeriodo(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Anio.class)) {
				AnioDataAccess.save(proforma.getAnio(),connexion);
				AnioLogic anioLogic= new AnioLogic(connexion);
				anioLogic.deepSave(proforma.getAnio(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Mes.class)) {
				MesDataAccess.save(proforma.getMes(),connexion);
				MesLogic mesLogic= new MesLogic(connexion);
				mesLogic.deepSave(proforma.getMes(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Moneda.class)) {
				MonedaDataAccess.save(proforma.getMoneda(),connexion);
				MonedaLogic monedaLogic= new MonedaLogic(connexion);
				monedaLogic.deepSave(proforma.getMoneda(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Empleado.class)) {
				EmpleadoDataAccess.save(proforma.getEmpleado(),connexion);
				EmpleadoLogic empleadoLogic= new EmpleadoLogic(connexion);
				empleadoLogic.deepSave(proforma.getEmpleado(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Formato.class)) {
				FormatoDataAccess.save(proforma.getFormato(),connexion);
				FormatoLogic formatoLogic= new FormatoLogic(connexion);
				formatoLogic.deepSave(proforma.getFormato(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(EstadoProforma.class)) {
				EstadoProformaDataAccess.save(proforma.getEstadoProforma(),connexion);
				EstadoProformaLogic estadoproformaLogic= new EstadoProformaLogic(connexion);
				estadoproformaLogic.deepSave(proforma.getEstadoProforma(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Cliente.class)) {
				ClienteDataAccess.save(proforma.getCliente(),connexion);
				ClienteLogic clienteLogic= new ClienteLogic(connexion);
				clienteLogic.deepSave(proforma.getCliente(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoPrecio.class)) {
				TipoPrecioDataAccess.save(proforma.getTipoPrecio(),connexion);
				TipoPrecioLogic tipoprecioLogic= new TipoPrecioLogic(connexion);
				tipoprecioLogic.deepSave(proforma.getTipoPrecio(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Vendedor.class)) {
				VendedorDataAccess.save(proforma.getVendedor(),connexion);
				VendedorLogic vendedorLogic= new VendedorLogic(connexion);
				vendedorLogic.deepSave(proforma.getVendedor(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(SubCliente.class)) {
				SubClienteDataAccess.save(proforma.getSubCliente(),connexion);
				SubClienteLogic subclienteLogic= new SubClienteLogic(connexion);
				subclienteLogic.deepSave(proforma.getSubCliente(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoViaTransporte.class)) {
				TipoViaTransporteDataAccess.save(proforma.getTipoViaTransporte(),connexion);
				TipoViaTransporteLogic tipoviatransporteLogic= new TipoViaTransporteLogic(connexion);
				tipoviatransporteLogic.deepSave(proforma.getTipoViaTransporte(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Transporte.class)) {
				TransporteDataAccess.save(proforma.getTransporte(),connexion);
				TransporteLogic transporteLogic= new TransporteLogic(connexion);
				transporteLogic.deepSave(proforma.getTransporte(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(RutaTransporte.class)) {
				RutaTransporteDataAccess.save(proforma.getRutaTransporte(),connexion);
				RutaTransporteLogic rutatransporteLogic= new RutaTransporteLogic(connexion);
				rutatransporteLogic.deepSave(proforma.getRutaTransporte(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(CentroCosto.class)) {
				CentroCostoDataAccess.save(proforma.getCentroCosto(),connexion);
				CentroCostoLogic centrocostoLogic= new CentroCostoLogic(connexion);
				centrocostoLogic.deepSave(proforma.getCentroCosto(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoProforma.class)) {
				TipoProformaDataAccess.save(proforma.getTipoProforma(),connexion);
				TipoProformaLogic tipoproformaLogic= new TipoProformaLogic(connexion);
				tipoproformaLogic.deepSave(proforma.getTipoProforma(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Consignatario.class)) {
				ConsignatarioDataAccess.save(proforma.getConsignatario(),connexion);
				ConsignatarioLogic consignatarioLogic= new ConsignatarioLogic(connexion);
				consignatarioLogic.deepSave(proforma.getConsignatario(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoCambio.class)) {
				TipoCambioDataAccess.save(proforma.getTipoCambio(),connexion);
				TipoCambioLogic tipocambioLogic= new TipoCambioLogic(connexion);
				tipocambioLogic.deepSave(proforma.getTipoCambio(),isDeep,deepLoadType,clases);				
				continue;
			}


			if(clas.clas.equals(TerminoProforma.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(TerminoProforma terminoproforma:proforma.getTerminoProformas()) {
					TerminoProformaLogic terminoproformaLogic= new TerminoProformaLogic(connexion);
					terminoproforma.setid_proforma(proforma.getId());
					TerminoProformaDataAccess.save(terminoproforma,connexion);
					terminoproformaLogic.deepSave(terminoproforma,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(DetalleProforma.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(DetalleProforma detalleproforma:proforma.getDetalleProformas()) {
					DetalleProformaLogic detalleproformaLogic= new DetalleProformaLogic(connexion);
					detalleproforma.setid_proforma(proforma.getId());
					DetalleProformaDataAccess.save(detalleproforma,connexion);
					detalleproformaLogic.deepSave(detalleproforma,isDeep,deepLoadType,clases);
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
			this.getNewConnexionToDeep(Proforma.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(proforma,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				ProformaConstantesFunciones.refrescarForeignKeysDescripcionesProforma(proforma);
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
			this.deepLoad(this.proforma,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				ProformaConstantesFunciones.refrescarForeignKeysDescripcionesProforma(this.proforma);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(Proforma.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(proformas!=null) {
				for(Proforma proforma:proformas) {
					this.deepLoad(proforma,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					ProformaConstantesFunciones.refrescarForeignKeysDescripcionesProforma(proformas);
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
			if(proformas!=null) {
				for(Proforma proforma:proformas) {
					this.deepLoad(proforma,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					ProformaConstantesFunciones.refrescarForeignKeysDescripcionesProforma(proformas);
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
			this.getNewConnexionToDeep(Proforma.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(proforma,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(Proforma.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(proformas!=null) {
				for(Proforma proforma:proformas) {
					this.deepSave(proforma,isDeep,deepLoadType,clases);
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
			if(proformas!=null) {
				for(Proforma proforma:proformas) {
					this.deepSave(proforma,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getProformasFK_IdAnioWithConnection(String sFinalQuery,Pagination pagination,Long id_anio)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Proforma.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidAnio= new ParameterSelectionGeneral();
			parameterSelectionGeneralidAnio.setParameterSelectionGeneralEqual(ParameterType.LONG,id_anio,ProformaConstantesFunciones.IDANIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidAnio);

			ProformaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdAnio","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			proformas=proformaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ProformaConstantesFunciones.refrescarForeignKeysDescripcionesProforma(this.proformas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getProformasFK_IdAnio(String sFinalQuery,Pagination pagination,Long id_anio)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidAnio= new ParameterSelectionGeneral();
			parameterSelectionGeneralidAnio.setParameterSelectionGeneralEqual(ParameterType.LONG,id_anio,ProformaConstantesFunciones.IDANIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidAnio);

			ProformaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdAnio","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			proformas=proformaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ProformaConstantesFunciones.refrescarForeignKeysDescripcionesProforma(this.proformas);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getProformasFK_IdCentroCostoWithConnection(String sFinalQuery,Pagination pagination,Long id_centro_costo)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Proforma.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCentroCosto= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCentroCosto.setParameterSelectionGeneralEqual(ParameterType.LONG,id_centro_costo,ProformaConstantesFunciones.IDCENTROCOSTO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCentroCosto);

			ProformaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCentroCosto","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			proformas=proformaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ProformaConstantesFunciones.refrescarForeignKeysDescripcionesProforma(this.proformas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getProformasFK_IdCentroCosto(String sFinalQuery,Pagination pagination,Long id_centro_costo)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCentroCosto= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCentroCosto.setParameterSelectionGeneralEqual(ParameterType.LONG,id_centro_costo,ProformaConstantesFunciones.IDCENTROCOSTO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCentroCosto);

			ProformaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCentroCosto","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			proformas=proformaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ProformaConstantesFunciones.refrescarForeignKeysDescripcionesProforma(this.proformas);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getProformasFK_IdClienteWithConnection(String sFinalQuery,Pagination pagination,Long id_cliente)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Proforma.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCliente= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCliente.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cliente,ProformaConstantesFunciones.IDCLIENTE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCliente);

			ProformaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCliente","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			proformas=proformaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ProformaConstantesFunciones.refrescarForeignKeysDescripcionesProforma(this.proformas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getProformasFK_IdCliente(String sFinalQuery,Pagination pagination,Long id_cliente)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCliente= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCliente.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cliente,ProformaConstantesFunciones.IDCLIENTE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCliente);

			ProformaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCliente","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			proformas=proformaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ProformaConstantesFunciones.refrescarForeignKeysDescripcionesProforma(this.proformas);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getProformasFK_IdConsignatarioWithConnection(String sFinalQuery,Pagination pagination,Long id_consignatario)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Proforma.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidConsignatario= new ParameterSelectionGeneral();
			parameterSelectionGeneralidConsignatario.setParameterSelectionGeneralEqual(ParameterType.LONG,id_consignatario,ProformaConstantesFunciones.IDCONSIGNATARIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidConsignatario);

			ProformaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdConsignatario","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			proformas=proformaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ProformaConstantesFunciones.refrescarForeignKeysDescripcionesProforma(this.proformas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getProformasFK_IdConsignatario(String sFinalQuery,Pagination pagination,Long id_consignatario)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidConsignatario= new ParameterSelectionGeneral();
			parameterSelectionGeneralidConsignatario.setParameterSelectionGeneralEqual(ParameterType.LONG,id_consignatario,ProformaConstantesFunciones.IDCONSIGNATARIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidConsignatario);

			ProformaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdConsignatario","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			proformas=proformaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ProformaConstantesFunciones.refrescarForeignKeysDescripcionesProforma(this.proformas);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getProformasFK_IdEjercicioWithConnection(String sFinalQuery,Pagination pagination,Long id_ejercicio)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Proforma.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEjercicio= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEjercicio.setParameterSelectionGeneralEqual(ParameterType.LONG,id_ejercicio,ProformaConstantesFunciones.IDEJERCICIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEjercicio);

			ProformaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEjercicio","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			proformas=proformaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ProformaConstantesFunciones.refrescarForeignKeysDescripcionesProforma(this.proformas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getProformasFK_IdEjercicio(String sFinalQuery,Pagination pagination,Long id_ejercicio)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEjercicio= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEjercicio.setParameterSelectionGeneralEqual(ParameterType.LONG,id_ejercicio,ProformaConstantesFunciones.IDEJERCICIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEjercicio);

			ProformaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEjercicio","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			proformas=proformaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ProformaConstantesFunciones.refrescarForeignKeysDescripcionesProforma(this.proformas);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getProformasFK_IdEmpleadoWithConnection(String sFinalQuery,Pagination pagination,Long id_empleado)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Proforma.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpleado= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpleado.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empleado,ProformaConstantesFunciones.IDEMPLEADO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpleado);

			ProformaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpleado","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			proformas=proformaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ProformaConstantesFunciones.refrescarForeignKeysDescripcionesProforma(this.proformas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getProformasFK_IdEmpleado(String sFinalQuery,Pagination pagination,Long id_empleado)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpleado= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpleado.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empleado,ProformaConstantesFunciones.IDEMPLEADO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpleado);

			ProformaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpleado","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			proformas=proformaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ProformaConstantesFunciones.refrescarForeignKeysDescripcionesProforma(this.proformas);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getProformasFK_IdEmpresaWithConnection(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Proforma.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,ProformaConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			ProformaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			proformas=proformaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ProformaConstantesFunciones.refrescarForeignKeysDescripcionesProforma(this.proformas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getProformasFK_IdEmpresa(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,ProformaConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			ProformaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			proformas=proformaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ProformaConstantesFunciones.refrescarForeignKeysDescripcionesProforma(this.proformas);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getProformasFK_IdEstadoProformaWithConnection(String sFinalQuery,Pagination pagination,Long id_estado_proforma)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Proforma.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEstadoProforma= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEstadoProforma.setParameterSelectionGeneralEqual(ParameterType.LONG,id_estado_proforma,ProformaConstantesFunciones.IDESTADOPROFORMA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEstadoProforma);

			ProformaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEstadoProforma","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			proformas=proformaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ProformaConstantesFunciones.refrescarForeignKeysDescripcionesProforma(this.proformas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getProformasFK_IdEstadoProforma(String sFinalQuery,Pagination pagination,Long id_estado_proforma)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEstadoProforma= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEstadoProforma.setParameterSelectionGeneralEqual(ParameterType.LONG,id_estado_proforma,ProformaConstantesFunciones.IDESTADOPROFORMA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEstadoProforma);

			ProformaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEstadoProforma","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			proformas=proformaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ProformaConstantesFunciones.refrescarForeignKeysDescripcionesProforma(this.proformas);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getProformasFK_IdFormatoWithConnection(String sFinalQuery,Pagination pagination,Long id_formato)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Proforma.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidFormato= new ParameterSelectionGeneral();
			parameterSelectionGeneralidFormato.setParameterSelectionGeneralEqual(ParameterType.LONG,id_formato,ProformaConstantesFunciones.IDFORMATO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidFormato);

			ProformaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdFormato","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			proformas=proformaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ProformaConstantesFunciones.refrescarForeignKeysDescripcionesProforma(this.proformas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getProformasFK_IdFormato(String sFinalQuery,Pagination pagination,Long id_formato)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidFormato= new ParameterSelectionGeneral();
			parameterSelectionGeneralidFormato.setParameterSelectionGeneralEqual(ParameterType.LONG,id_formato,ProformaConstantesFunciones.IDFORMATO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidFormato);

			ProformaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdFormato","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			proformas=proformaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ProformaConstantesFunciones.refrescarForeignKeysDescripcionesProforma(this.proformas);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getProformasFK_IdMesWithConnection(String sFinalQuery,Pagination pagination,Long id_mes)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Proforma.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidMes= new ParameterSelectionGeneral();
			parameterSelectionGeneralidMes.setParameterSelectionGeneralEqual(ParameterType.LONG,id_mes,ProformaConstantesFunciones.IDMES,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidMes);

			ProformaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdMes","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			proformas=proformaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ProformaConstantesFunciones.refrescarForeignKeysDescripcionesProforma(this.proformas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getProformasFK_IdMes(String sFinalQuery,Pagination pagination,Long id_mes)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidMes= new ParameterSelectionGeneral();
			parameterSelectionGeneralidMes.setParameterSelectionGeneralEqual(ParameterType.LONG,id_mes,ProformaConstantesFunciones.IDMES,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidMes);

			ProformaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdMes","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			proformas=proformaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ProformaConstantesFunciones.refrescarForeignKeysDescripcionesProforma(this.proformas);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getProformasFK_IdMonedaWithConnection(String sFinalQuery,Pagination pagination,Long id_moneda)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Proforma.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidMoneda= new ParameterSelectionGeneral();
			parameterSelectionGeneralidMoneda.setParameterSelectionGeneralEqual(ParameterType.LONG,id_moneda,ProformaConstantesFunciones.IDMONEDA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidMoneda);

			ProformaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdMoneda","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			proformas=proformaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ProformaConstantesFunciones.refrescarForeignKeysDescripcionesProforma(this.proformas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getProformasFK_IdMoneda(String sFinalQuery,Pagination pagination,Long id_moneda)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidMoneda= new ParameterSelectionGeneral();
			parameterSelectionGeneralidMoneda.setParameterSelectionGeneralEqual(ParameterType.LONG,id_moneda,ProformaConstantesFunciones.IDMONEDA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidMoneda);

			ProformaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdMoneda","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			proformas=proformaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ProformaConstantesFunciones.refrescarForeignKeysDescripcionesProforma(this.proformas);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getProformasFK_IdPeriodoWithConnection(String sFinalQuery,Pagination pagination,Long id_periodo)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Proforma.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidPeriodo= new ParameterSelectionGeneral();
			parameterSelectionGeneralidPeriodo.setParameterSelectionGeneralEqual(ParameterType.LONG,id_periodo,ProformaConstantesFunciones.IDPERIODO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidPeriodo);

			ProformaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdPeriodo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			proformas=proformaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ProformaConstantesFunciones.refrescarForeignKeysDescripcionesProforma(this.proformas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getProformasFK_IdPeriodo(String sFinalQuery,Pagination pagination,Long id_periodo)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidPeriodo= new ParameterSelectionGeneral();
			parameterSelectionGeneralidPeriodo.setParameterSelectionGeneralEqual(ParameterType.LONG,id_periodo,ProformaConstantesFunciones.IDPERIODO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidPeriodo);

			ProformaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdPeriodo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			proformas=proformaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ProformaConstantesFunciones.refrescarForeignKeysDescripcionesProforma(this.proformas);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getProformasFK_IdRutaTransporteWithConnection(String sFinalQuery,Pagination pagination,Long id_ruta_transporte)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Proforma.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidRutaTransporte= new ParameterSelectionGeneral();
			parameterSelectionGeneralidRutaTransporte.setParameterSelectionGeneralEqual(ParameterType.LONG,id_ruta_transporte,ProformaConstantesFunciones.IDRUTATRANSPORTE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidRutaTransporte);

			ProformaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdRutaTransporte","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			proformas=proformaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ProformaConstantesFunciones.refrescarForeignKeysDescripcionesProforma(this.proformas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getProformasFK_IdRutaTransporte(String sFinalQuery,Pagination pagination,Long id_ruta_transporte)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidRutaTransporte= new ParameterSelectionGeneral();
			parameterSelectionGeneralidRutaTransporte.setParameterSelectionGeneralEqual(ParameterType.LONG,id_ruta_transporte,ProformaConstantesFunciones.IDRUTATRANSPORTE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidRutaTransporte);

			ProformaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdRutaTransporte","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			proformas=proformaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ProformaConstantesFunciones.refrescarForeignKeysDescripcionesProforma(this.proformas);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getProformasFK_IdSubClienteWithConnection(String sFinalQuery,Pagination pagination,Long id_sub_cliente)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Proforma.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidSubCliente= new ParameterSelectionGeneral();
			parameterSelectionGeneralidSubCliente.setParameterSelectionGeneralEqual(ParameterType.LONG,id_sub_cliente,ProformaConstantesFunciones.IDSUBCLIENTE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidSubCliente);

			ProformaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdSubCliente","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			proformas=proformaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ProformaConstantesFunciones.refrescarForeignKeysDescripcionesProforma(this.proformas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getProformasFK_IdSubCliente(String sFinalQuery,Pagination pagination,Long id_sub_cliente)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidSubCliente= new ParameterSelectionGeneral();
			parameterSelectionGeneralidSubCliente.setParameterSelectionGeneralEqual(ParameterType.LONG,id_sub_cliente,ProformaConstantesFunciones.IDSUBCLIENTE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidSubCliente);

			ProformaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdSubCliente","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			proformas=proformaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ProformaConstantesFunciones.refrescarForeignKeysDescripcionesProforma(this.proformas);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getProformasFK_IdSucursalWithConnection(String sFinalQuery,Pagination pagination,Long id_sucursal)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Proforma.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidSucursal= new ParameterSelectionGeneral();
			parameterSelectionGeneralidSucursal.setParameterSelectionGeneralEqual(ParameterType.LONG,id_sucursal,ProformaConstantesFunciones.IDSUCURSAL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidSucursal);

			ProformaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdSucursal","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			proformas=proformaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ProformaConstantesFunciones.refrescarForeignKeysDescripcionesProforma(this.proformas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getProformasFK_IdSucursal(String sFinalQuery,Pagination pagination,Long id_sucursal)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidSucursal= new ParameterSelectionGeneral();
			parameterSelectionGeneralidSucursal.setParameterSelectionGeneralEqual(ParameterType.LONG,id_sucursal,ProformaConstantesFunciones.IDSUCURSAL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidSucursal);

			ProformaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdSucursal","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			proformas=proformaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ProformaConstantesFunciones.refrescarForeignKeysDescripcionesProforma(this.proformas);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getProformasFK_IdTipoCambioWithConnection(String sFinalQuery,Pagination pagination,Long id_tipo_cambio)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Proforma.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoCambio= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoCambio.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_cambio,ProformaConstantesFunciones.IDTIPOCAMBIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoCambio);

			ProformaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoCambio","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			proformas=proformaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ProformaConstantesFunciones.refrescarForeignKeysDescripcionesProforma(this.proformas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getProformasFK_IdTipoCambio(String sFinalQuery,Pagination pagination,Long id_tipo_cambio)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoCambio= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoCambio.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_cambio,ProformaConstantesFunciones.IDTIPOCAMBIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoCambio);

			ProformaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoCambio","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			proformas=proformaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ProformaConstantesFunciones.refrescarForeignKeysDescripcionesProforma(this.proformas);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getProformasFK_IdTipoPrecioWithConnection(String sFinalQuery,Pagination pagination,Long id_tipo_precio)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Proforma.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoPrecio= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoPrecio.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_precio,ProformaConstantesFunciones.IDTIPOPRECIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoPrecio);

			ProformaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoPrecio","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			proformas=proformaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ProformaConstantesFunciones.refrescarForeignKeysDescripcionesProforma(this.proformas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getProformasFK_IdTipoPrecio(String sFinalQuery,Pagination pagination,Long id_tipo_precio)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoPrecio= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoPrecio.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_precio,ProformaConstantesFunciones.IDTIPOPRECIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoPrecio);

			ProformaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoPrecio","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			proformas=proformaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ProformaConstantesFunciones.refrescarForeignKeysDescripcionesProforma(this.proformas);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getProformasFK_IdTipoProformaWithConnection(String sFinalQuery,Pagination pagination,Long id_tipo_proforma)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Proforma.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoProforma= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoProforma.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_proforma,ProformaConstantesFunciones.IDTIPOPROFORMA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoProforma);

			ProformaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoProforma","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			proformas=proformaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ProformaConstantesFunciones.refrescarForeignKeysDescripcionesProforma(this.proformas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getProformasFK_IdTipoProforma(String sFinalQuery,Pagination pagination,Long id_tipo_proforma)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoProforma= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoProforma.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_proforma,ProformaConstantesFunciones.IDTIPOPROFORMA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoProforma);

			ProformaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoProforma","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			proformas=proformaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ProformaConstantesFunciones.refrescarForeignKeysDescripcionesProforma(this.proformas);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getProformasFK_IdTipoViaTransporteWithConnection(String sFinalQuery,Pagination pagination,Long id_tipo_via_transporte)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Proforma.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoViaTransporte= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoViaTransporte.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_via_transporte,ProformaConstantesFunciones.IDTIPOVIATRANSPORTE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoViaTransporte);

			ProformaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoViaTransporte","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			proformas=proformaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ProformaConstantesFunciones.refrescarForeignKeysDescripcionesProforma(this.proformas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getProformasFK_IdTipoViaTransporte(String sFinalQuery,Pagination pagination,Long id_tipo_via_transporte)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoViaTransporte= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoViaTransporte.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_via_transporte,ProformaConstantesFunciones.IDTIPOVIATRANSPORTE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoViaTransporte);

			ProformaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoViaTransporte","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			proformas=proformaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ProformaConstantesFunciones.refrescarForeignKeysDescripcionesProforma(this.proformas);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getProformasFK_IdTransporteWithConnection(String sFinalQuery,Pagination pagination,Long id_transporte)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Proforma.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTransporte= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTransporte.setParameterSelectionGeneralEqual(ParameterType.LONG,id_transporte,ProformaConstantesFunciones.IDTRANSPORTE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTransporte);

			ProformaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTransporte","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			proformas=proformaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ProformaConstantesFunciones.refrescarForeignKeysDescripcionesProforma(this.proformas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getProformasFK_IdTransporte(String sFinalQuery,Pagination pagination,Long id_transporte)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTransporte= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTransporte.setParameterSelectionGeneralEqual(ParameterType.LONG,id_transporte,ProformaConstantesFunciones.IDTRANSPORTE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTransporte);

			ProformaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTransporte","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			proformas=proformaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ProformaConstantesFunciones.refrescarForeignKeysDescripcionesProforma(this.proformas);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getProformasFK_IdUsuarioWithConnection(String sFinalQuery,Pagination pagination,Long id_usuario)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Proforma.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidUsuario= new ParameterSelectionGeneral();
			parameterSelectionGeneralidUsuario.setParameterSelectionGeneralEqual(ParameterType.LONG,id_usuario,ProformaConstantesFunciones.IDUSUARIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidUsuario);

			ProformaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdUsuario","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			proformas=proformaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ProformaConstantesFunciones.refrescarForeignKeysDescripcionesProforma(this.proformas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getProformasFK_IdUsuario(String sFinalQuery,Pagination pagination,Long id_usuario)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidUsuario= new ParameterSelectionGeneral();
			parameterSelectionGeneralidUsuario.setParameterSelectionGeneralEqual(ParameterType.LONG,id_usuario,ProformaConstantesFunciones.IDUSUARIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidUsuario);

			ProformaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdUsuario","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			proformas=proformaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ProformaConstantesFunciones.refrescarForeignKeysDescripcionesProforma(this.proformas);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getProformasFK_IdVendedorWithConnection(String sFinalQuery,Pagination pagination,Long id_vendedor)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Proforma.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidVendedor= new ParameterSelectionGeneral();
			parameterSelectionGeneralidVendedor.setParameterSelectionGeneralEqual(ParameterType.LONG,id_vendedor,ProformaConstantesFunciones.IDVENDEDOR,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidVendedor);

			ProformaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdVendedor","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			proformas=proformaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ProformaConstantesFunciones.refrescarForeignKeysDescripcionesProforma(this.proformas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getProformasFK_IdVendedor(String sFinalQuery,Pagination pagination,Long id_vendedor)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidVendedor= new ParameterSelectionGeneral();
			parameterSelectionGeneralidVendedor.setParameterSelectionGeneralEqual(ParameterType.LONG,id_vendedor,ProformaConstantesFunciones.IDVENDEDOR,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidVendedor);

			ProformaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdVendedor","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			proformas=proformaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ProformaConstantesFunciones.refrescarForeignKeysDescripcionesProforma(this.proformas);
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
			if(ProformaConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,ProformaDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,Proforma proforma,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(ProformaConstantesFunciones.ISCONAUDITORIA) {
				if(proforma.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,ProformaDataAccess.TABLENAME, proforma.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(ProformaConstantesFunciones.ISCONAUDITORIADETALLE) {
						////ProformaLogic.registrarAuditoriaDetallesProforma(connexion,proforma,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(proforma.getIsDeleted()) {
					/*if(!proforma.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,ProformaDataAccess.TABLENAME, proforma.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////ProformaLogic.registrarAuditoriaDetallesProforma(connexion,proforma,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,ProformaDataAccess.TABLENAME, proforma.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(proforma.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,ProformaDataAccess.TABLENAME, proforma.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(ProformaConstantesFunciones.ISCONAUDITORIADETALLE) {
						////ProformaLogic.registrarAuditoriaDetallesProforma(connexion,proforma,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesProforma(Connexion connexion,Proforma proforma)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(proforma.getIsNew()||!proforma.getid_empresa().equals(proforma.getProformaOriginal().getid_empresa()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(proforma.getProformaOriginal().getid_empresa()!=null)
				{
					strValorActual=proforma.getProformaOriginal().getid_empresa().toString();
				}
				if(proforma.getid_empresa()!=null)
				{
					strValorNuevo=proforma.getid_empresa().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ProformaConstantesFunciones.IDEMPRESA,strValorActual,strValorNuevo);
			}	
			
			if(proforma.getIsNew()||!proforma.getid_sucursal().equals(proforma.getProformaOriginal().getid_sucursal()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(proforma.getProformaOriginal().getid_sucursal()!=null)
				{
					strValorActual=proforma.getProformaOriginal().getid_sucursal().toString();
				}
				if(proforma.getid_sucursal()!=null)
				{
					strValorNuevo=proforma.getid_sucursal().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ProformaConstantesFunciones.IDSUCURSAL,strValorActual,strValorNuevo);
			}	
			
			if(proforma.getIsNew()||!proforma.getid_usuario().equals(proforma.getProformaOriginal().getid_usuario()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(proforma.getProformaOriginal().getid_usuario()!=null)
				{
					strValorActual=proforma.getProformaOriginal().getid_usuario().toString();
				}
				if(proforma.getid_usuario()!=null)
				{
					strValorNuevo=proforma.getid_usuario().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ProformaConstantesFunciones.IDUSUARIO,strValorActual,strValorNuevo);
			}	
			
			if(proforma.getIsNew()||!proforma.getid_ejercicio().equals(proforma.getProformaOriginal().getid_ejercicio()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(proforma.getProformaOriginal().getid_ejercicio()!=null)
				{
					strValorActual=proforma.getProformaOriginal().getid_ejercicio().toString();
				}
				if(proforma.getid_ejercicio()!=null)
				{
					strValorNuevo=proforma.getid_ejercicio().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ProformaConstantesFunciones.IDEJERCICIO,strValorActual,strValorNuevo);
			}	
			
			if(proforma.getIsNew()||!proforma.getid_periodo().equals(proforma.getProformaOriginal().getid_periodo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(proforma.getProformaOriginal().getid_periodo()!=null)
				{
					strValorActual=proforma.getProformaOriginal().getid_periodo().toString();
				}
				if(proforma.getid_periodo()!=null)
				{
					strValorNuevo=proforma.getid_periodo().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ProformaConstantesFunciones.IDPERIODO,strValorActual,strValorNuevo);
			}	
			
			if(proforma.getIsNew()||!proforma.getid_anio().equals(proforma.getProformaOriginal().getid_anio()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(proforma.getProformaOriginal().getid_anio()!=null)
				{
					strValorActual=proforma.getProformaOriginal().getid_anio().toString();
				}
				if(proforma.getid_anio()!=null)
				{
					strValorNuevo=proforma.getid_anio().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ProformaConstantesFunciones.IDANIO,strValorActual,strValorNuevo);
			}	
			
			if(proforma.getIsNew()||!proforma.getid_mes().equals(proforma.getProformaOriginal().getid_mes()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(proforma.getProformaOriginal().getid_mes()!=null)
				{
					strValorActual=proforma.getProformaOriginal().getid_mes().toString();
				}
				if(proforma.getid_mes()!=null)
				{
					strValorNuevo=proforma.getid_mes().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ProformaConstantesFunciones.IDMES,strValorActual,strValorNuevo);
			}	
			
			if(proforma.getIsNew()||!proforma.getnumero_pre_impreso().equals(proforma.getProformaOriginal().getnumero_pre_impreso()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(proforma.getProformaOriginal().getnumero_pre_impreso()!=null)
				{
					strValorActual=proforma.getProformaOriginal().getnumero_pre_impreso();
				}
				if(proforma.getnumero_pre_impreso()!=null)
				{
					strValorNuevo=proforma.getnumero_pre_impreso() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ProformaConstantesFunciones.NUMEROPREIMPRESO,strValorActual,strValorNuevo);
			}	
			
			if(proforma.getIsNew()||!proforma.getfecha_emision().equals(proforma.getProformaOriginal().getfecha_emision()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(proforma.getProformaOriginal().getfecha_emision()!=null)
				{
					strValorActual=proforma.getProformaOriginal().getfecha_emision().toString();
				}
				if(proforma.getfecha_emision()!=null)
				{
					strValorNuevo=proforma.getfecha_emision().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ProformaConstantesFunciones.FECHAEMISION,strValorActual,strValorNuevo);
			}	
			
			if(proforma.getIsNew()||!proforma.getdias().equals(proforma.getProformaOriginal().getdias()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(proforma.getProformaOriginal().getdias()!=null)
				{
					strValorActual=proforma.getProformaOriginal().getdias().toString();
				}
				if(proforma.getdias()!=null)
				{
					strValorNuevo=proforma.getdias().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ProformaConstantesFunciones.DIAS,strValorActual,strValorNuevo);
			}	
			
			if(proforma.getIsNew()||!proforma.getfecha_vencimiento().equals(proforma.getProformaOriginal().getfecha_vencimiento()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(proforma.getProformaOriginal().getfecha_vencimiento()!=null)
				{
					strValorActual=proforma.getProformaOriginal().getfecha_vencimiento().toString();
				}
				if(proforma.getfecha_vencimiento()!=null)
				{
					strValorNuevo=proforma.getfecha_vencimiento().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ProformaConstantesFunciones.FECHAVENCIMIENTO,strValorActual,strValorNuevo);
			}	
			
			if(proforma.getIsNew()||!proforma.getid_moneda().equals(proforma.getProformaOriginal().getid_moneda()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(proforma.getProformaOriginal().getid_moneda()!=null)
				{
					strValorActual=proforma.getProformaOriginal().getid_moneda().toString();
				}
				if(proforma.getid_moneda()!=null)
				{
					strValorNuevo=proforma.getid_moneda().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ProformaConstantesFunciones.IDMONEDA,strValorActual,strValorNuevo);
			}	
			
			if(proforma.getIsNew()||!proforma.getcotizacion().equals(proforma.getProformaOriginal().getcotizacion()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(proforma.getProformaOriginal().getcotizacion()!=null)
				{
					strValorActual=proforma.getProformaOriginal().getcotizacion().toString();
				}
				if(proforma.getcotizacion()!=null)
				{
					strValorNuevo=proforma.getcotizacion().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ProformaConstantesFunciones.COTIZACION,strValorActual,strValorNuevo);
			}	
			
			if(proforma.getIsNew()||!proforma.getid_empleado().equals(proforma.getProformaOriginal().getid_empleado()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(proforma.getProformaOriginal().getid_empleado()!=null)
				{
					strValorActual=proforma.getProformaOriginal().getid_empleado().toString();
				}
				if(proforma.getid_empleado()!=null)
				{
					strValorNuevo=proforma.getid_empleado().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ProformaConstantesFunciones.IDEMPLEADO,strValorActual,strValorNuevo);
			}	
			
			if(proforma.getIsNew()||!proforma.getid_formato().equals(proforma.getProformaOriginal().getid_formato()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(proforma.getProformaOriginal().getid_formato()!=null)
				{
					strValorActual=proforma.getProformaOriginal().getid_formato().toString();
				}
				if(proforma.getid_formato()!=null)
				{
					strValorNuevo=proforma.getid_formato().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ProformaConstantesFunciones.IDFORMATO,strValorActual,strValorNuevo);
			}	
			
			if(proforma.getIsNew()||!proforma.getid_estado_proforma().equals(proforma.getProformaOriginal().getid_estado_proforma()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(proforma.getProformaOriginal().getid_estado_proforma()!=null)
				{
					strValorActual=proforma.getProformaOriginal().getid_estado_proforma().toString();
				}
				if(proforma.getid_estado_proforma()!=null)
				{
					strValorNuevo=proforma.getid_estado_proforma().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ProformaConstantesFunciones.IDESTADOPROFORMA,strValorActual,strValorNuevo);
			}	
			
			if(proforma.getIsNew()||!proforma.getdireccion().equals(proforma.getProformaOriginal().getdireccion()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(proforma.getProformaOriginal().getdireccion()!=null)
				{
					strValorActual=proforma.getProformaOriginal().getdireccion();
				}
				if(proforma.getdireccion()!=null)
				{
					strValorNuevo=proforma.getdireccion() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ProformaConstantesFunciones.DIRECCION,strValorActual,strValorNuevo);
			}	
			
			if(proforma.getIsNew()||!proforma.getid_cliente().equals(proforma.getProformaOriginal().getid_cliente()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(proforma.getProformaOriginal().getid_cliente()!=null)
				{
					strValorActual=proforma.getProformaOriginal().getid_cliente().toString();
				}
				if(proforma.getid_cliente()!=null)
				{
					strValorNuevo=proforma.getid_cliente().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ProformaConstantesFunciones.IDCLIENTE,strValorActual,strValorNuevo);
			}	
			
			if(proforma.getIsNew()||!proforma.getruc().equals(proforma.getProformaOriginal().getruc()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(proforma.getProformaOriginal().getruc()!=null)
				{
					strValorActual=proforma.getProformaOriginal().getruc();
				}
				if(proforma.getruc()!=null)
				{
					strValorNuevo=proforma.getruc() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ProformaConstantesFunciones.RUC,strValorActual,strValorNuevo);
			}	
			
			if(proforma.getIsNew()||!proforma.getes_oferta().equals(proforma.getProformaOriginal().getes_oferta()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(proforma.getProformaOriginal().getes_oferta()!=null)
				{
					strValorActual=proforma.getProformaOriginal().getes_oferta().toString();
				}
				if(proforma.getes_oferta()!=null)
				{
					strValorNuevo=proforma.getes_oferta().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ProformaConstantesFunciones.ESOFERTA,strValorActual,strValorNuevo);
			}	
			
			if(proforma.getIsNew()||!proforma.gettelefono().equals(proforma.getProformaOriginal().gettelefono()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(proforma.getProformaOriginal().gettelefono()!=null)
				{
					strValorActual=proforma.getProformaOriginal().gettelefono();
				}
				if(proforma.gettelefono()!=null)
				{
					strValorNuevo=proforma.gettelefono() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ProformaConstantesFunciones.TELEFONO,strValorActual,strValorNuevo);
			}	
			
			if(proforma.getIsNew()||!proforma.getid_tipo_precio().equals(proforma.getProformaOriginal().getid_tipo_precio()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(proforma.getProformaOriginal().getid_tipo_precio()!=null)
				{
					strValorActual=proforma.getProformaOriginal().getid_tipo_precio().toString();
				}
				if(proforma.getid_tipo_precio()!=null)
				{
					strValorNuevo=proforma.getid_tipo_precio().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ProformaConstantesFunciones.IDTIPOPRECIO,strValorActual,strValorNuevo);
			}	
			
			if(proforma.getIsNew()||!proforma.getid_vendedor().equals(proforma.getProformaOriginal().getid_vendedor()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(proforma.getProformaOriginal().getid_vendedor()!=null)
				{
					strValorActual=proforma.getProformaOriginal().getid_vendedor().toString();
				}
				if(proforma.getid_vendedor()!=null)
				{
					strValorNuevo=proforma.getid_vendedor().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ProformaConstantesFunciones.IDVENDEDOR,strValorActual,strValorNuevo);
			}	
			
			if(proforma.getIsNew()||!proforma.getid_sub_cliente().equals(proforma.getProformaOriginal().getid_sub_cliente()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(proforma.getProformaOriginal().getid_sub_cliente()!=null)
				{
					strValorActual=proforma.getProformaOriginal().getid_sub_cliente().toString();
				}
				if(proforma.getid_sub_cliente()!=null)
				{
					strValorNuevo=proforma.getid_sub_cliente().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ProformaConstantesFunciones.IDSUBCLIENTE,strValorActual,strValorNuevo);
			}	
			
			if(proforma.getIsNew()||!proforma.getid_tipo_via_transporte().equals(proforma.getProformaOriginal().getid_tipo_via_transporte()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(proforma.getProformaOriginal().getid_tipo_via_transporte()!=null)
				{
					strValorActual=proforma.getProformaOriginal().getid_tipo_via_transporte().toString();
				}
				if(proforma.getid_tipo_via_transporte()!=null)
				{
					strValorNuevo=proforma.getid_tipo_via_transporte().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ProformaConstantesFunciones.IDTIPOVIATRANSPORTE,strValorActual,strValorNuevo);
			}	
			
			if(proforma.getIsNew()||!proforma.getid_transporte().equals(proforma.getProformaOriginal().getid_transporte()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(proforma.getProformaOriginal().getid_transporte()!=null)
				{
					strValorActual=proforma.getProformaOriginal().getid_transporte().toString();
				}
				if(proforma.getid_transporte()!=null)
				{
					strValorNuevo=proforma.getid_transporte().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ProformaConstantesFunciones.IDTRANSPORTE,strValorActual,strValorNuevo);
			}	
			
			if(proforma.getIsNew()||!proforma.getid_ruta_transporte().equals(proforma.getProformaOriginal().getid_ruta_transporte()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(proforma.getProformaOriginal().getid_ruta_transporte()!=null)
				{
					strValorActual=proforma.getProformaOriginal().getid_ruta_transporte().toString();
				}
				if(proforma.getid_ruta_transporte()!=null)
				{
					strValorNuevo=proforma.getid_ruta_transporte().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ProformaConstantesFunciones.IDRUTATRANSPORTE,strValorActual,strValorNuevo);
			}	
			
			if(proforma.getIsNew()||!proforma.getdescripcion().equals(proforma.getProformaOriginal().getdescripcion()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(proforma.getProformaOriginal().getdescripcion()!=null)
				{
					strValorActual=proforma.getProformaOriginal().getdescripcion();
				}
				if(proforma.getdescripcion()!=null)
				{
					strValorNuevo=proforma.getdescripcion() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ProformaConstantesFunciones.DESCRIPCION,strValorActual,strValorNuevo);
			}	
			
			if(proforma.getIsNew()||!proforma.getdescuento_porcentaje().equals(proforma.getProformaOriginal().getdescuento_porcentaje()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(proforma.getProformaOriginal().getdescuento_porcentaje()!=null)
				{
					strValorActual=proforma.getProformaOriginal().getdescuento_porcentaje().toString();
				}
				if(proforma.getdescuento_porcentaje()!=null)
				{
					strValorNuevo=proforma.getdescuento_porcentaje().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ProformaConstantesFunciones.DESCUENTOPORCENTAJE,strValorActual,strValorNuevo);
			}	
			
			if(proforma.getIsNew()||!proforma.getmonto_con_iva().equals(proforma.getProformaOriginal().getmonto_con_iva()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(proforma.getProformaOriginal().getmonto_con_iva()!=null)
				{
					strValorActual=proforma.getProformaOriginal().getmonto_con_iva().toString();
				}
				if(proforma.getmonto_con_iva()!=null)
				{
					strValorNuevo=proforma.getmonto_con_iva().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ProformaConstantesFunciones.MONTOCONIVA,strValorActual,strValorNuevo);
			}	
			
			if(proforma.getIsNew()||!proforma.getsuman().equals(proforma.getProformaOriginal().getsuman()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(proforma.getProformaOriginal().getsuman()!=null)
				{
					strValorActual=proforma.getProformaOriginal().getsuman().toString();
				}
				if(proforma.getsuman()!=null)
				{
					strValorNuevo=proforma.getsuman().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ProformaConstantesFunciones.SUMAN,strValorActual,strValorNuevo);
			}	
			
			if(proforma.getIsNew()||!proforma.getdescuento_valor().equals(proforma.getProformaOriginal().getdescuento_valor()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(proforma.getProformaOriginal().getdescuento_valor()!=null)
				{
					strValorActual=proforma.getProformaOriginal().getdescuento_valor().toString();
				}
				if(proforma.getdescuento_valor()!=null)
				{
					strValorNuevo=proforma.getdescuento_valor().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ProformaConstantesFunciones.DESCUENTOVALOR,strValorActual,strValorNuevo);
			}	
			
			if(proforma.getIsNew()||!proforma.getmonto_sin_iva().equals(proforma.getProformaOriginal().getmonto_sin_iva()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(proforma.getProformaOriginal().getmonto_sin_iva()!=null)
				{
					strValorActual=proforma.getProformaOriginal().getmonto_sin_iva().toString();
				}
				if(proforma.getmonto_sin_iva()!=null)
				{
					strValorNuevo=proforma.getmonto_sin_iva().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ProformaConstantesFunciones.MONTOSINIVA,strValorActual,strValorNuevo);
			}	
			
			if(proforma.getIsNew()||!proforma.getdescuento_general().equals(proforma.getProformaOriginal().getdescuento_general()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(proforma.getProformaOriginal().getdescuento_general()!=null)
				{
					strValorActual=proforma.getProformaOriginal().getdescuento_general().toString();
				}
				if(proforma.getdescuento_general()!=null)
				{
					strValorNuevo=proforma.getdescuento_general().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ProformaConstantesFunciones.DESCUENTOGENERAL,strValorActual,strValorNuevo);
			}	
			
			if(proforma.getIsNew()||!proforma.getflete().equals(proforma.getProformaOriginal().getflete()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(proforma.getProformaOriginal().getflete()!=null)
				{
					strValorActual=proforma.getProformaOriginal().getflete().toString();
				}
				if(proforma.getflete()!=null)
				{
					strValorNuevo=proforma.getflete().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ProformaConstantesFunciones.FLETE,strValorActual,strValorNuevo);
			}	
			
			if(proforma.getIsNew()||!proforma.getultimo_costo().equals(proforma.getProformaOriginal().getultimo_costo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(proforma.getProformaOriginal().getultimo_costo()!=null)
				{
					strValorActual=proforma.getProformaOriginal().getultimo_costo().toString();
				}
				if(proforma.getultimo_costo()!=null)
				{
					strValorNuevo=proforma.getultimo_costo().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ProformaConstantesFunciones.ULTIMOCOSTO,strValorActual,strValorNuevo);
			}	
			
			if(proforma.getIsNew()||!proforma.getsubtotal().equals(proforma.getProformaOriginal().getsubtotal()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(proforma.getProformaOriginal().getsubtotal()!=null)
				{
					strValorActual=proforma.getProformaOriginal().getsubtotal().toString();
				}
				if(proforma.getsubtotal()!=null)
				{
					strValorNuevo=proforma.getsubtotal().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ProformaConstantesFunciones.SUBTOTAL,strValorActual,strValorNuevo);
			}	
			
			if(proforma.getIsNew()||!proforma.getotros_cargos().equals(proforma.getProformaOriginal().getotros_cargos()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(proforma.getProformaOriginal().getotros_cargos()!=null)
				{
					strValorActual=proforma.getProformaOriginal().getotros_cargos().toString();
				}
				if(proforma.getotros_cargos()!=null)
				{
					strValorNuevo=proforma.getotros_cargos().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ProformaConstantesFunciones.OTROSCARGOS,strValorActual,strValorNuevo);
			}	
			
			if(proforma.getIsNew()||!proforma.getmargen_utilidad().equals(proforma.getProformaOriginal().getmargen_utilidad()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(proforma.getProformaOriginal().getmargen_utilidad()!=null)
				{
					strValorActual=proforma.getProformaOriginal().getmargen_utilidad().toString();
				}
				if(proforma.getmargen_utilidad()!=null)
				{
					strValorNuevo=proforma.getmargen_utilidad().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ProformaConstantesFunciones.MARGENUTILIDAD,strValorActual,strValorNuevo);
			}	
			
			if(proforma.getIsNew()||!proforma.getiva().equals(proforma.getProformaOriginal().getiva()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(proforma.getProformaOriginal().getiva()!=null)
				{
					strValorActual=proforma.getProformaOriginal().getiva().toString();
				}
				if(proforma.getiva()!=null)
				{
					strValorNuevo=proforma.getiva().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ProformaConstantesFunciones.IVA,strValorActual,strValorNuevo);
			}	
			
			if(proforma.getIsNew()||!proforma.getfinanciamiento().equals(proforma.getProformaOriginal().getfinanciamiento()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(proforma.getProformaOriginal().getfinanciamiento()!=null)
				{
					strValorActual=proforma.getProformaOriginal().getfinanciamiento().toString();
				}
				if(proforma.getfinanciamiento()!=null)
				{
					strValorNuevo=proforma.getfinanciamiento().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ProformaConstantesFunciones.FINANCIAMIENTO,strValorActual,strValorNuevo);
			}	
			
			if(proforma.getIsNew()||!proforma.gettotal().equals(proforma.getProformaOriginal().gettotal()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(proforma.getProformaOriginal().gettotal()!=null)
				{
					strValorActual=proforma.getProformaOriginal().gettotal().toString();
				}
				if(proforma.gettotal()!=null)
				{
					strValorNuevo=proforma.gettotal().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ProformaConstantesFunciones.TOTAL,strValorActual,strValorNuevo);
			}	
			
			if(proforma.getIsNew()||!proforma.getotros_valores().equals(proforma.getProformaOriginal().getotros_valores()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(proforma.getProformaOriginal().getotros_valores()!=null)
				{
					strValorActual=proforma.getProformaOriginal().getotros_valores().toString();
				}
				if(proforma.getotros_valores()!=null)
				{
					strValorNuevo=proforma.getotros_valores().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ProformaConstantesFunciones.OTROSVALORES,strValorActual,strValorNuevo);
			}	
			
			if(proforma.getIsNew()||!proforma.getanticipo().equals(proforma.getProformaOriginal().getanticipo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(proforma.getProformaOriginal().getanticipo()!=null)
				{
					strValorActual=proforma.getProformaOriginal().getanticipo().toString();
				}
				if(proforma.getanticipo()!=null)
				{
					strValorNuevo=proforma.getanticipo().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ProformaConstantesFunciones.ANTICIPO,strValorActual,strValorNuevo);
			}	
			
			if(proforma.getIsNew()||!proforma.getice().equals(proforma.getProformaOriginal().getice()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(proforma.getProformaOriginal().getice()!=null)
				{
					strValorActual=proforma.getProformaOriginal().getice().toString();
				}
				if(proforma.getice()!=null)
				{
					strValorNuevo=proforma.getice().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ProformaConstantesFunciones.ICE,strValorActual,strValorNuevo);
			}	
			
			if(proforma.getIsNew()||!proforma.getmonto_retencion().equals(proforma.getProformaOriginal().getmonto_retencion()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(proforma.getProformaOriginal().getmonto_retencion()!=null)
				{
					strValorActual=proforma.getProformaOriginal().getmonto_retencion().toString();
				}
				if(proforma.getmonto_retencion()!=null)
				{
					strValorNuevo=proforma.getmonto_retencion().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ProformaConstantesFunciones.MONTORETENCION,strValorActual,strValorNuevo);
			}	
			
			if(proforma.getIsNew()||!proforma.getfecha().equals(proforma.getProformaOriginal().getfecha()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(proforma.getProformaOriginal().getfecha()!=null)
				{
					strValorActual=proforma.getProformaOriginal().getfecha().toString();
				}
				if(proforma.getfecha()!=null)
				{
					strValorNuevo=proforma.getfecha().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ProformaConstantesFunciones.FECHA,strValorActual,strValorNuevo);
			}	
			
			if(proforma.getIsNew()||!proforma.getfecha_servidor().equals(proforma.getProformaOriginal().getfecha_servidor()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(proforma.getProformaOriginal().getfecha_servidor()!=null)
				{
					strValorActual=proforma.getProformaOriginal().getfecha_servidor().toString();
				}
				if(proforma.getfecha_servidor()!=null)
				{
					strValorNuevo=proforma.getfecha_servidor().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ProformaConstantesFunciones.FECHASERVIDOR,strValorActual,strValorNuevo);
			}	
			
			if(proforma.getIsNew()||!proforma.gethora_inicio().equals(proforma.getProformaOriginal().gethora_inicio()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(proforma.getProformaOriginal().gethora_inicio()!=null)
				{
					strValorActual=proforma.getProformaOriginal().gethora_inicio().toString();
				}
				if(proforma.gethora_inicio()!=null)
				{
					strValorNuevo=proforma.gethora_inicio().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ProformaConstantesFunciones.HORAINICIO,strValorActual,strValorNuevo);
			}	
			
			if(proforma.getIsNew()||!proforma.gethora_fin().equals(proforma.getProformaOriginal().gethora_fin()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(proforma.getProformaOriginal().gethora_fin()!=null)
				{
					strValorActual=proforma.getProformaOriginal().gethora_fin().toString();
				}
				if(proforma.gethora_fin()!=null)
				{
					strValorNuevo=proforma.gethora_fin().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ProformaConstantesFunciones.HORAFIN,strValorActual,strValorNuevo);
			}	
			
			if(proforma.getIsNew()||!proforma.getid_centro_costo().equals(proforma.getProformaOriginal().getid_centro_costo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(proforma.getProformaOriginal().getid_centro_costo()!=null)
				{
					strValorActual=proforma.getProformaOriginal().getid_centro_costo().toString();
				}
				if(proforma.getid_centro_costo()!=null)
				{
					strValorNuevo=proforma.getid_centro_costo().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ProformaConstantesFunciones.IDCENTROCOSTO,strValorActual,strValorNuevo);
			}	
			
			if(proforma.getIsNew()||!proforma.getid_tipo_proforma().equals(proforma.getProformaOriginal().getid_tipo_proforma()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(proforma.getProformaOriginal().getid_tipo_proforma()!=null)
				{
					strValorActual=proforma.getProformaOriginal().getid_tipo_proforma().toString();
				}
				if(proforma.getid_tipo_proforma()!=null)
				{
					strValorNuevo=proforma.getid_tipo_proforma().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ProformaConstantesFunciones.IDTIPOPROFORMA,strValorActual,strValorNuevo);
			}	
			
			if(proforma.getIsNew()||!proforma.getid_consignatario().equals(proforma.getProformaOriginal().getid_consignatario()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(proforma.getProformaOriginal().getid_consignatario()!=null)
				{
					strValorActual=proforma.getProformaOriginal().getid_consignatario().toString();
				}
				if(proforma.getid_consignatario()!=null)
				{
					strValorNuevo=proforma.getid_consignatario().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ProformaConstantesFunciones.IDCONSIGNATARIO,strValorActual,strValorNuevo);
			}	
			
			if(proforma.getIsNew()||!proforma.getid_tipo_cambio().equals(proforma.getProformaOriginal().getid_tipo_cambio()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(proforma.getProformaOriginal().getid_tipo_cambio()!=null)
				{
					strValorActual=proforma.getProformaOriginal().getid_tipo_cambio().toString();
				}
				if(proforma.getid_tipo_cambio()!=null)
				{
					strValorNuevo=proforma.getid_tipo_cambio().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ProformaConstantesFunciones.IDTIPOCAMBIO,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void saveProformaRelacionesWithConnection(Proforma proforma,List<TerminoProforma> terminoproformas,List<DetalleProforma> detalleproformas) throws Exception {

		if(!proforma.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveProformaRelacionesBase(proforma,terminoproformas,detalleproformas,true);
		}
	}

	public void saveProformaRelaciones(Proforma proforma,List<TerminoProforma> terminoproformas,List<DetalleProforma> detalleproformas)throws Exception {

		if(!proforma.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveProformaRelacionesBase(proforma,terminoproformas,detalleproformas,false);
		}
	}

	public void saveProformaRelacionesBase(Proforma proforma,List<TerminoProforma> terminoproformas,List<DetalleProforma> detalleproformas,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("Proforma-saveRelacionesWithConnection");}
	
			proforma.setTerminoProformas(terminoproformas);
			proforma.setDetalleProformas(detalleproformas);

			this.setProforma(proforma);

			if(ProformaLogicAdditional.validarSaveRelaciones(proforma,this)) {

				ProformaLogicAdditional.updateRelacionesToSave(proforma,this);

				if((proforma.getIsNew()||proforma.getIsChanged())&&!proforma.getIsDeleted()) {
					this.saveProforma();
					this.saveProformaRelacionesDetalles(terminoproformas,detalleproformas);

				} else if(proforma.getIsDeleted()) {
					this.saveProformaRelacionesDetalles(terminoproformas,detalleproformas);
					this.saveProforma();
				}

				ProformaLogicAdditional.updateRelacionesToSaveAfter(proforma,this);

			} else {
				throw new Exception("LOS DATOS SON INVALIDOS");
			}

			if(conConexion) {connexion.commit();}

		} catch(Exception e) {
			
			TerminoProformaConstantesFunciones.InicializarGeneralEntityAuxiliaresTerminoProformas(terminoproformas,true,true);
			DetalleProformaConstantesFunciones.InicializarGeneralEntityAuxiliaresDetalleProformas(detalleproformas,true,true);

			if(conConexion){connexion.rollback();}
			Funciones.manageException(logger,e);
			throw e;

		} finally {
			if(conConexion){this.closeNewConnexionToDeep();}
		}
	}
	
	
	private void saveProformaRelacionesDetalles(List<TerminoProforma> terminoproformas,List<DetalleProforma> detalleproformas)throws Exception {
		try {
	

			Long idProformaActual=this.getProforma().getId();

			TerminoProformaLogic terminoproformaLogic_Desde_Proforma=new TerminoProformaLogic();
			terminoproformaLogic_Desde_Proforma.setTerminoProformas(terminoproformas);

			terminoproformaLogic_Desde_Proforma.setConnexion(this.getConnexion());
			terminoproformaLogic_Desde_Proforma.setDatosCliente(this.datosCliente);

			for(TerminoProforma terminoproforma_Desde_Proforma:terminoproformaLogic_Desde_Proforma.getTerminoProformas()) {
				terminoproforma_Desde_Proforma.setid_proforma(idProformaActual);

				terminoproformaLogic_Desde_Proforma.setTerminoProforma(terminoproforma_Desde_Proforma);
				terminoproformaLogic_Desde_Proforma.saveTerminoProforma();

				Long idTerminoProformaActual=terminoproforma_Desde_Proforma.getId();

				DetalleTerminoProformaLogic detalleterminoproformaLogic_Desde_TerminoProforma=new DetalleTerminoProformaLogic();

				if(terminoproforma_Desde_Proforma.getDetalleTerminoProformas()==null){
					terminoproforma_Desde_Proforma.setDetalleTerminoProformas(new ArrayList<DetalleTerminoProforma>());
				}

				detalleterminoproformaLogic_Desde_TerminoProforma.setDetalleTerminoProformas(terminoproforma_Desde_Proforma.getDetalleTerminoProformas());

				detalleterminoproformaLogic_Desde_TerminoProforma.setConnexion(this.getConnexion());
				detalleterminoproformaLogic_Desde_TerminoProforma.setDatosCliente(this.datosCliente);

				for(DetalleTerminoProforma detalleterminoproforma_Desde_TerminoProforma:detalleterminoproformaLogic_Desde_TerminoProforma.getDetalleTerminoProformas()) {
					detalleterminoproforma_Desde_TerminoProforma.setid_termino_proforma(idTerminoProformaActual);
				}

				detalleterminoproformaLogic_Desde_TerminoProforma.saveDetalleTerminoProformas();
			}


			DetalleProformaLogic detalleproformaLogic_Desde_Proforma=new DetalleProformaLogic();
			detalleproformaLogic_Desde_Proforma.setDetalleProformas(detalleproformas);

			detalleproformaLogic_Desde_Proforma.setConnexion(this.getConnexion());
			detalleproformaLogic_Desde_Proforma.setDatosCliente(this.datosCliente);

			for(DetalleProforma detalleproforma_Desde_Proforma:detalleproformaLogic_Desde_Proforma.getDetalleProformas()) {
				detalleproforma_Desde_Proforma.setid_proforma(idProformaActual);
			}

			detalleproformaLogic_Desde_Proforma.saveDetalleProformas();

		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfProforma(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=ProformaConstantesFunciones.getClassesForeignKeysOfProforma(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfProforma(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=ProformaConstantesFunciones.getClassesRelationshipsOfProforma(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}
