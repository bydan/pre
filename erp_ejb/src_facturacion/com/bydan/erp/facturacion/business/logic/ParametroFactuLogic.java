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
import com.bydan.erp.facturacion.util.ParametroFactuConstantesFunciones;
import com.bydan.erp.facturacion.util.ParametroFactuParameterReturnGeneral;
//import com.bydan.erp.facturacion.util.ParametroFactuParameterGeneral;
import com.bydan.erp.facturacion.business.entity.ParametroFactu;
import com.bydan.erp.facturacion.business.logic.ParametroFactuLogicAdditional;
import com.bydan.erp.facturacion.business.dataaccess.*;
import com.bydan.erp.facturacion.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;


import com.bydan.erp.seguridad.business.logic.*;
import com.bydan.erp.contabilidad.business.logic.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.contabilidad.util.*;


import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.contabilidad.business.dataaccess.*;








@SuppressWarnings("unused")
public class ParametroFactuLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(ParametroFactuLogic.class);
	
	protected ParametroFactuDataAccess parametrofactuDataAccess; 	
	protected ParametroFactu parametrofactu;
	protected List<ParametroFactu> parametrofactus;
	protected Object parametrofactuObject;	
	protected List<Object> parametrofactusObject;
	
	public static ClassValidator<ParametroFactu> parametrofactuValidator = new ClassValidator<ParametroFactu>(ParametroFactu.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected ParametroFactuLogicAdditional parametrofactuLogicAdditional=null;
	
	public ParametroFactuLogicAdditional getParametroFactuLogicAdditional() {
		return this.parametrofactuLogicAdditional;
	}
	
	public void setParametroFactuLogicAdditional(ParametroFactuLogicAdditional parametrofactuLogicAdditional) {
		try {
			this.parametrofactuLogicAdditional=parametrofactuLogicAdditional;
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
	
	
	
	
	public  ParametroFactuLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.parametrofactuDataAccess = new ParametroFactuDataAccess();
			
			this.parametrofactus= new ArrayList<ParametroFactu>();
			this.parametrofactu= new ParametroFactu();
			
			this.parametrofactuObject=new Object();
			this.parametrofactusObject=new ArrayList<Object>();
				
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
			
			this.parametrofactuDataAccess.setConnexionType(this.connexionType);
			this.parametrofactuDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  ParametroFactuLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.parametrofactuDataAccess = new ParametroFactuDataAccess();
			this.parametrofactus= new ArrayList<ParametroFactu>();
			this.parametrofactu= new ParametroFactu();
			this.parametrofactuObject=new Object();
			this.parametrofactusObject=new ArrayList<Object>();
			
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
			
			this.parametrofactuDataAccess.setConnexionType(this.connexionType);
			this.parametrofactuDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public ParametroFactu getParametroFactu() throws Exception {	
		ParametroFactuLogicAdditional.checkParametroFactuToGet(parametrofactu,this.datosCliente,this.arrDatoGeneral);
		ParametroFactuLogicAdditional.updateParametroFactuToGet(parametrofactu,this.arrDatoGeneral);
		
		return parametrofactu;
	}
		
	public void setParametroFactu(ParametroFactu newParametroFactu) {
		this.parametrofactu = newParametroFactu;
	}
	
	public ParametroFactuDataAccess getParametroFactuDataAccess() {
		return parametrofactuDataAccess;
	}
	
	public void setParametroFactuDataAccess(ParametroFactuDataAccess newparametrofactuDataAccess) {
		this.parametrofactuDataAccess = newparametrofactuDataAccess;
	}
	
	public List<ParametroFactu> getParametroFactus() throws Exception {		
		this.quitarParametroFactusNulos();
		
		ParametroFactuLogicAdditional.checkParametroFactuToGets(parametrofactus,this.datosCliente,this.arrDatoGeneral);
		
		for (ParametroFactu parametrofactuLocal: parametrofactus ) {
			ParametroFactuLogicAdditional.updateParametroFactuToGet(parametrofactuLocal,this.arrDatoGeneral);
		}
		
		return parametrofactus;
	}
	
	public void setParametroFactus(List<ParametroFactu> newParametroFactus) {
		this.parametrofactus = newParametroFactus;
	}
	
	public Object getParametroFactuObject() {	
		this.parametrofactuObject=this.parametrofactuDataAccess.getEntityObject();
		return this.parametrofactuObject;
	}
		
	public void setParametroFactuObject(Object newParametroFactuObject) {
		this.parametrofactuObject = newParametroFactuObject;
	}
	
	public List<Object> getParametroFactusObject() {		
		this.parametrofactusObject=this.parametrofactuDataAccess.getEntitiesObject();
		return this.parametrofactusObject;
	}
		
	public void setParametroFactusObject(List<Object> newParametroFactusObject) {
		this.parametrofactusObject = newParametroFactusObject;
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
		
		if(this.parametrofactuDataAccess!=null) {
			this.parametrofactuDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroFactu.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			parametrofactuDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			parametrofactuDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		parametrofactu = new  ParametroFactu();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroFactu.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			parametrofactu=parametrofactuDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.parametrofactu,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				ParametroFactuConstantesFunciones.refrescarForeignKeysDescripcionesParametroFactu(this.parametrofactu);
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
		parametrofactu = new  ParametroFactu();
		  		  
        try {
			
			parametrofactu=parametrofactuDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.parametrofactu,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				ParametroFactuConstantesFunciones.refrescarForeignKeysDescripcionesParametroFactu(this.parametrofactu);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		parametrofactu = new  ParametroFactu();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroFactu.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			parametrofactu=parametrofactuDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.parametrofactu,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				ParametroFactuConstantesFunciones.refrescarForeignKeysDescripcionesParametroFactu(this.parametrofactu);
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
		parametrofactu = new  ParametroFactu();
		  		  
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
		parametrofactu = new  ParametroFactu();
		  		  
        try {
			
			parametrofactu=parametrofactuDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.parametrofactu,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				ParametroFactuConstantesFunciones.refrescarForeignKeysDescripcionesParametroFactu(this.parametrofactu);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		parametrofactu = new  ParametroFactu();
		  		  
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
		parametrofactu = new  ParametroFactu();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroFactu.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =parametrofactuDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		parametrofactu = new  ParametroFactu();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=parametrofactuDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		parametrofactu = new  ParametroFactu();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroFactu.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =parametrofactuDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		parametrofactu = new  ParametroFactu();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=parametrofactuDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		parametrofactu = new  ParametroFactu();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroFactu.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =parametrofactuDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		parametrofactu = new  ParametroFactu();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=parametrofactuDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		parametrofactus = new  ArrayList<ParametroFactu>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroFactu.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			ParametroFactuLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			parametrofactus=parametrofactuDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarParametroFactu(parametrofactus);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ParametroFactuConstantesFunciones.refrescarForeignKeysDescripcionesParametroFactu(this.parametrofactus);
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
		parametrofactus = new  ArrayList<ParametroFactu>();
		  		  
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
		parametrofactus = new  ArrayList<ParametroFactu>();
		  		  
        try {			
			ParametroFactuLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			parametrofactus=parametrofactuDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarParametroFactu(parametrofactus);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ParametroFactuConstantesFunciones.refrescarForeignKeysDescripcionesParametroFactu(this.parametrofactus);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		parametrofactus = new  ArrayList<ParametroFactu>();
		  		  
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
		parametrofactus = new  ArrayList<ParametroFactu>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroFactu.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			ParametroFactuLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			parametrofactus=parametrofactuDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarParametroFactu(parametrofactus);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ParametroFactuConstantesFunciones.refrescarForeignKeysDescripcionesParametroFactu(this.parametrofactus);
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
		parametrofactus = new  ArrayList<ParametroFactu>();
		  		  
        try {
			ParametroFactuLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			parametrofactus=parametrofactuDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarParametroFactu(parametrofactus);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ParametroFactuConstantesFunciones.refrescarForeignKeysDescripcionesParametroFactu(this.parametrofactus);
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
		parametrofactus = new  ArrayList<ParametroFactu>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroFactu.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ParametroFactuLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			parametrofactus=parametrofactuDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarParametroFactu(parametrofactus);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ParametroFactuConstantesFunciones.refrescarForeignKeysDescripcionesParametroFactu(this.parametrofactus);
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
		parametrofactus = new  ArrayList<ParametroFactu>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ParametroFactuLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			parametrofactus=parametrofactuDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarParametroFactu(parametrofactus);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ParametroFactuConstantesFunciones.refrescarForeignKeysDescripcionesParametroFactu(this.parametrofactus);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		parametrofactu = new  ParametroFactu();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroFactu.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ParametroFactuLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			parametrofactu=parametrofactuDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarParametroFactu(parametrofactu);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ParametroFactuConstantesFunciones.refrescarForeignKeysDescripcionesParametroFactu(this.parametrofactu);
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
		parametrofactu = new  ParametroFactu();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ParametroFactuLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			parametrofactu=parametrofactuDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarParametroFactu(parametrofactu);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ParametroFactuConstantesFunciones.refrescarForeignKeysDescripcionesParametroFactu(this.parametrofactu);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		parametrofactus = new  ArrayList<ParametroFactu>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroFactu.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			ParametroFactuLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			parametrofactus=parametrofactuDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarParametroFactu(parametrofactus);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ParametroFactuConstantesFunciones.refrescarForeignKeysDescripcionesParametroFactu(this.parametrofactus);
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
		parametrofactus = new  ArrayList<ParametroFactu>();
		  		  
        try {
			ParametroFactuLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			parametrofactus=parametrofactuDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarParametroFactu(parametrofactus);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ParametroFactuConstantesFunciones.refrescarForeignKeysDescripcionesParametroFactu(this.parametrofactus);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosParametroFactusWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		parametrofactus = new  ArrayList<ParametroFactu>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroFactu.class.getSimpleName()+"-getTodosParametroFactusWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ParametroFactuLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			parametrofactus=parametrofactuDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarParametroFactu(parametrofactus);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ParametroFactuConstantesFunciones.refrescarForeignKeysDescripcionesParametroFactu(this.parametrofactus);
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
	
	public  void  getTodosParametroFactus(String sFinalQuery,Pagination pagination)throws Exception {
		parametrofactus = new  ArrayList<ParametroFactu>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ParametroFactuLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			parametrofactus=parametrofactuDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarParametroFactu(parametrofactus);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ParametroFactuConstantesFunciones.refrescarForeignKeysDescripcionesParametroFactu(this.parametrofactus);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarParametroFactu(ParametroFactu parametrofactu) throws Exception {
		Boolean estaValidado=false;
		
		if(parametrofactu.getIsNew() || parametrofactu.getIsChanged()) { 
			this.invalidValues = parametrofactuValidator.getInvalidValues(parametrofactu);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(parametrofactu);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarParametroFactu(List<ParametroFactu> ParametroFactus) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(ParametroFactu parametrofactuLocal:parametrofactus) {				
			estaValidadoObjeto=this.validarGuardarParametroFactu(parametrofactuLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarParametroFactu(List<ParametroFactu> ParametroFactus) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarParametroFactu(parametrofactus)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarParametroFactu(ParametroFactu ParametroFactu) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarParametroFactu(parametrofactu)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(ParametroFactu parametrofactu) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+parametrofactu.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=ParametroFactuConstantesFunciones.getParametroFactuLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"parametrofactu","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(ParametroFactuConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(ParametroFactuConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveParametroFactuWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroFactu.class.getSimpleName()+"-saveParametroFactuWithConnection");connexion.begin();			
			
			ParametroFactuLogicAdditional.checkParametroFactuToSave(this.parametrofactu,this.datosCliente,connexion,this.arrDatoGeneral);
			
			ParametroFactuLogicAdditional.updateParametroFactuToSave(this.parametrofactu,this.arrDatoGeneral);
			
			ParametroFactuLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.parametrofactu,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowParametroFactu();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarParametroFactu(this.parametrofactu)) {
				ParametroFactuDataAccess.save(this.parametrofactu, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.parametrofactu,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			ParametroFactuLogicAdditional.checkParametroFactuToSaveAfter(this.parametrofactu,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowParametroFactu();
			
			connexion.commit();			
			
			if(this.parametrofactu.getIsDeleted()) {
				this.parametrofactu=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveParametroFactu()throws Exception {	
		try {	
			
			ParametroFactuLogicAdditional.checkParametroFactuToSave(this.parametrofactu,this.datosCliente,connexion,this.arrDatoGeneral);
			
			ParametroFactuLogicAdditional.updateParametroFactuToSave(this.parametrofactu,this.arrDatoGeneral);
			
			ParametroFactuLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.parametrofactu,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarParametroFactu(this.parametrofactu)) {			
				ParametroFactuDataAccess.save(this.parametrofactu, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.parametrofactu,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			ParametroFactuLogicAdditional.checkParametroFactuToSaveAfter(this.parametrofactu,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.parametrofactu.getIsDeleted()) {
				this.parametrofactu=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveParametroFactusWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroFactu.class.getSimpleName()+"-saveParametroFactusWithConnection");connexion.begin();			
			
			ParametroFactuLogicAdditional.checkParametroFactuToSaves(parametrofactus,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowParametroFactus();
			
			Boolean validadoTodosParametroFactu=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(ParametroFactu parametrofactuLocal:parametrofactus) {		
				if(parametrofactuLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				ParametroFactuLogicAdditional.updateParametroFactuToSave(parametrofactuLocal,this.arrDatoGeneral);
	        	
				ParametroFactuLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),parametrofactuLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarParametroFactu(parametrofactuLocal)) {
					ParametroFactuDataAccess.save(parametrofactuLocal, connexion);				
				} else {
					validadoTodosParametroFactu=false;
				}
			}
			
			if(!validadoTodosParametroFactu) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			ParametroFactuLogicAdditional.checkParametroFactuToSavesAfter(parametrofactus,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowParametroFactus();
			
			connexion.commit();		
			
			this.quitarParametroFactusEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveParametroFactus()throws Exception {				
		 try {	
			ParametroFactuLogicAdditional.checkParametroFactuToSaves(parametrofactus,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosParametroFactu=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(ParametroFactu parametrofactuLocal:parametrofactus) {				
				if(parametrofactuLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				ParametroFactuLogicAdditional.updateParametroFactuToSave(parametrofactuLocal,this.arrDatoGeneral);
	        	
				ParametroFactuLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),parametrofactuLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarParametroFactu(parametrofactuLocal)) {				
					ParametroFactuDataAccess.save(parametrofactuLocal, connexion);				
				} else {
					validadoTodosParametroFactu=false;
				}
			}
			
			if(!validadoTodosParametroFactu) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			ParametroFactuLogicAdditional.checkParametroFactuToSavesAfter(parametrofactus,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarParametroFactusEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public ParametroFactuParameterReturnGeneral procesarAccionParametroFactus(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<ParametroFactu> parametrofactus,ParametroFactuParameterReturnGeneral parametrofactuParameterGeneral)throws Exception {
		 try {	
			ParametroFactuParameterReturnGeneral parametrofactuReturnGeneral=new ParametroFactuParameterReturnGeneral();
	
			ParametroFactuLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,parametrofactus,parametrofactuParameterGeneral,parametrofactuReturnGeneral);
			
			return parametrofactuReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public ParametroFactuParameterReturnGeneral procesarAccionParametroFactusWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<ParametroFactu> parametrofactus,ParametroFactuParameterReturnGeneral parametrofactuParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroFactu.class.getSimpleName()+"-procesarAccionParametroFactusWithConnection");connexion.begin();			
			
			ParametroFactuParameterReturnGeneral parametrofactuReturnGeneral=new ParametroFactuParameterReturnGeneral();
	
			ParametroFactuLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,parametrofactus,parametrofactuParameterGeneral,parametrofactuReturnGeneral);
			
			this.connexion.commit();
			
			return parametrofactuReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public ParametroFactuParameterReturnGeneral procesarEventosParametroFactus(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<ParametroFactu> parametrofactus,ParametroFactu parametrofactu,ParametroFactuParameterReturnGeneral parametrofactuParameterGeneral,Boolean isEsNuevoParametroFactu,ArrayList<Classe> clases)throws Exception {
		 try {	
			ParametroFactuParameterReturnGeneral parametrofactuReturnGeneral=new ParametroFactuParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				parametrofactuReturnGeneral.setConRecargarPropiedades(true);
			}
			
			ParametroFactuLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,parametrofactus,parametrofactu,parametrofactuParameterGeneral,parametrofactuReturnGeneral,isEsNuevoParametroFactu,clases);
			
			return parametrofactuReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public ParametroFactuParameterReturnGeneral procesarEventosParametroFactusWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<ParametroFactu> parametrofactus,ParametroFactu parametrofactu,ParametroFactuParameterReturnGeneral parametrofactuParameterGeneral,Boolean isEsNuevoParametroFactu,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroFactu.class.getSimpleName()+"-procesarEventosParametroFactusWithConnection");connexion.begin();			
			
			ParametroFactuParameterReturnGeneral parametrofactuReturnGeneral=new ParametroFactuParameterReturnGeneral();
	
			parametrofactuReturnGeneral.setParametroFactu(parametrofactu);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				parametrofactuReturnGeneral.setConRecargarPropiedades(true);
			}
			
			ParametroFactuLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,parametrofactus,parametrofactu,parametrofactuParameterGeneral,parametrofactuReturnGeneral,isEsNuevoParametroFactu,clases);
			
			this.connexion.commit();
			
			return parametrofactuReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public ParametroFactuParameterReturnGeneral procesarImportacionParametroFactusWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,ParametroFactuParameterReturnGeneral parametrofactuParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroFactu.class.getSimpleName()+"-procesarImportacionParametroFactusWithConnection");connexion.begin();			
			
			ParametroFactuParameterReturnGeneral parametrofactuReturnGeneral=new ParametroFactuParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.parametrofactus=new ArrayList<ParametroFactu>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.parametrofactu=new ParametroFactu();
				
				
				if(conColumnasBase) {this.parametrofactu.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.parametrofactu.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.parametrofactu.setsecuencial_proforma(arrColumnas[iColumn++]);
				this.parametrofactu.setsecuancial_pedido(arrColumnas[iColumn++]);
				this.parametrofactu.setsecuencial_factura(arrColumnas[iColumn++]);
				this.parametrofactu.setsecuencial_nota_credito(arrColumnas[iColumn++]);
				this.parametrofactu.setitem_proforma(Integer.parseInt(arrColumnas[iColumn++]));
				this.parametrofactu.setitem_pedido(Integer.parseInt(arrColumnas[iColumn++]));
				this.parametrofactu.setitem_factura(Integer.parseInt(arrColumnas[iColumn++]));
				this.parametrofactu.setitem_nota_credito(Integer.parseInt(arrColumnas[iColumn++]));
				this.parametrofactu.setitem_inventario(Integer.parseInt(arrColumnas[iColumn++]));
				this.parametrofactu.setcon_detalle_proforma(Boolean.parseBoolean(arrColumnas[iColumn++]));
				this.parametrofactu.setcon_detalle_pedido(Boolean.parseBoolean(arrColumnas[iColumn++]));
				this.parametrofactu.setcon_detalle_factura(Boolean.parseBoolean(arrColumnas[iColumn++]));
				this.parametrofactu.setcon_detalle_nota_credito(Boolean.parseBoolean(arrColumnas[iColumn++]));
				
				this.parametrofactus.add(this.parametrofactu);
			}
			
			this.saveParametroFactus();
			
			this.connexion.commit();
			
			parametrofactuReturnGeneral.setConRetornoEstaProcesado(true);
			parametrofactuReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return parametrofactuReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarParametroFactusEliminados() throws Exception {				
		
		List<ParametroFactu> parametrofactusAux= new ArrayList<ParametroFactu>();
		
		for(ParametroFactu parametrofactu:parametrofactus) {
			if(!parametrofactu.getIsDeleted()) {
				parametrofactusAux.add(parametrofactu);
			}
		}
		
		parametrofactus=parametrofactusAux;
	}
	
	public void quitarParametroFactusNulos() throws Exception {				
		
		List<ParametroFactu> parametrofactusAux= new ArrayList<ParametroFactu>();
		
		for(ParametroFactu parametrofactu : this.parametrofactus) {
			if(parametrofactu==null) {
				parametrofactusAux.add(parametrofactu);
			}
		}
		
		//this.parametrofactus=parametrofactusAux;
		
		this.parametrofactus.removeAll(parametrofactusAux);
	}
	
	public void getSetVersionRowParametroFactuWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(parametrofactu.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((parametrofactu.getIsDeleted() || (parametrofactu.getIsChanged()&&!parametrofactu.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=parametrofactuDataAccess.getSetVersionRowParametroFactu(connexion,parametrofactu.getId());
				
				if(!parametrofactu.getVersionRow().equals(timestamp)) {	
					parametrofactu.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				parametrofactu.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowParametroFactu()throws Exception {	
		
		if(parametrofactu.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((parametrofactu.getIsDeleted() || (parametrofactu.getIsChanged()&&!parametrofactu.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=parametrofactuDataAccess.getSetVersionRowParametroFactu(connexion,parametrofactu.getId());
			
			try {							
				if(!parametrofactu.getVersionRow().equals(timestamp)) {	
					parametrofactu.setVersionRow(timestamp);
				}
				
				parametrofactu.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowParametroFactusWithConnection()throws Exception {	
		if(parametrofactus!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(ParametroFactu parametrofactuAux:parametrofactus) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(parametrofactuAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(parametrofactuAux.getIsDeleted() || (parametrofactuAux.getIsChanged()&&!parametrofactuAux.getIsNew())) {
						
						timestamp=parametrofactuDataAccess.getSetVersionRowParametroFactu(connexion,parametrofactuAux.getId());
						
						if(!parametrofactu.getVersionRow().equals(timestamp)) {	
							parametrofactuAux.setVersionRow(timestamp);
						}
								
						parametrofactuAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowParametroFactus()throws Exception {	
		if(parametrofactus!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(ParametroFactu parametrofactuAux:parametrofactus) {
					if(parametrofactuAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(parametrofactuAux.getIsDeleted() || (parametrofactuAux.getIsChanged()&&!parametrofactuAux.getIsNew())) {
						
						timestamp=parametrofactuDataAccess.getSetVersionRowParametroFactu(connexion,parametrofactuAux.getId());
						
						if(!parametrofactuAux.getVersionRow().equals(timestamp)) {	
							parametrofactuAux.setVersionRow(timestamp);
						}
						
													
						parametrofactuAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public ParametroFactuParameterReturnGeneral cargarCombosLoteForeignKeyParametroFactuWithConnection(String finalQueryGlobalEmpresa,String finalQueryGlobalSucursal,String finalQueryGlobalCuentaContableFactu,String finalQueryGlobalCuentaContableFinan,String finalQueryGlobalCuentaContableOtro,String finalQueryGlobalFormatoProforma,String finalQueryGlobalFormatoPedido,String finalQueryGlobalFormatoFactura,String finalQueryGlobalFormatoNotaCredito,String finalQueryGlobalFormatoInventario) throws Exception {
		ParametroFactuParameterReturnGeneral  parametrofactuReturnGeneral =new ParametroFactuParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroFactu.class.getSimpleName()+"-cargarCombosLoteForeignKeyParametroFactuWithConnection");connexion.begin();
			
			parametrofactuReturnGeneral =new ParametroFactuParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			parametrofactuReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Sucursal> sucursalsForeignKey=new ArrayList<Sucursal>();
			SucursalLogic sucursalLogic=new SucursalLogic();
			sucursalLogic.setConnexion(this.connexion);
			//sucursalLogic.getSucursalDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalSucursal.equals("NONE")) {
				sucursalLogic.getTodosSucursals(finalQueryGlobalSucursal,new Pagination());
				sucursalsForeignKey=sucursalLogic.getSucursals();
			}

			parametrofactuReturnGeneral.setsucursalsForeignKey(sucursalsForeignKey);


			List<CuentaContable> cuentacontablefactusForeignKey=new ArrayList<CuentaContable>();
			CuentaContableLogic cuentacontablefactuLogic=new CuentaContableLogic();
			cuentacontablefactuLogic.setConnexion(this.connexion);
			cuentacontablefactuLogic.getCuentaContableDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCuentaContableFactu.equals("NONE")) {
				cuentacontablefactuLogic.getTodosCuentaContables(finalQueryGlobalCuentaContableFactu,new Pagination());
				cuentacontablefactusForeignKey=cuentacontablefactuLogic.getCuentaContables();
			}

			parametrofactuReturnGeneral.setcuentacontablefactusForeignKey(cuentacontablefactusForeignKey);


			List<CuentaContable> cuentacontablefinansForeignKey=new ArrayList<CuentaContable>();
			CuentaContableLogic cuentacontablefinanLogic=new CuentaContableLogic();
			cuentacontablefinanLogic.setConnexion(this.connexion);
			cuentacontablefinanLogic.getCuentaContableDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCuentaContableFinan.equals("NONE")) {
				cuentacontablefinanLogic.getTodosCuentaContables(finalQueryGlobalCuentaContableFinan,new Pagination());
				cuentacontablefinansForeignKey=cuentacontablefinanLogic.getCuentaContables();
			}

			parametrofactuReturnGeneral.setcuentacontablefinansForeignKey(cuentacontablefinansForeignKey);


			List<CuentaContable> cuentacontableotrosForeignKey=new ArrayList<CuentaContable>();
			CuentaContableLogic cuentacontableotroLogic=new CuentaContableLogic();
			cuentacontableotroLogic.setConnexion(this.connexion);
			cuentacontableotroLogic.getCuentaContableDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCuentaContableOtro.equals("NONE")) {
				cuentacontableotroLogic.getTodosCuentaContables(finalQueryGlobalCuentaContableOtro,new Pagination());
				cuentacontableotrosForeignKey=cuentacontableotroLogic.getCuentaContables();
			}

			parametrofactuReturnGeneral.setcuentacontableotrosForeignKey(cuentacontableotrosForeignKey);


			List<Formato> formatoproformasForeignKey=new ArrayList<Formato>();
			FormatoLogic formatoproformaLogic=new FormatoLogic();
			formatoproformaLogic.setConnexion(this.connexion);
			formatoproformaLogic.getFormatoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalFormatoProforma.equals("NONE")) {
				formatoproformaLogic.getTodosFormatos(finalQueryGlobalFormatoProforma,new Pagination());
				formatoproformasForeignKey=formatoproformaLogic.getFormatos();
			}

			parametrofactuReturnGeneral.setformatoproformasForeignKey(formatoproformasForeignKey);


			List<Formato> formatopedidosForeignKey=new ArrayList<Formato>();
			FormatoLogic formatopedidoLogic=new FormatoLogic();
			formatopedidoLogic.setConnexion(this.connexion);
			formatopedidoLogic.getFormatoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalFormatoPedido.equals("NONE")) {
				formatopedidoLogic.getTodosFormatos(finalQueryGlobalFormatoPedido,new Pagination());
				formatopedidosForeignKey=formatopedidoLogic.getFormatos();
			}

			parametrofactuReturnGeneral.setformatopedidosForeignKey(formatopedidosForeignKey);


			List<Formato> formatofacturasForeignKey=new ArrayList<Formato>();
			FormatoLogic formatofacturaLogic=new FormatoLogic();
			formatofacturaLogic.setConnexion(this.connexion);
			formatofacturaLogic.getFormatoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalFormatoFactura.equals("NONE")) {
				formatofacturaLogic.getTodosFormatos(finalQueryGlobalFormatoFactura,new Pagination());
				formatofacturasForeignKey=formatofacturaLogic.getFormatos();
			}

			parametrofactuReturnGeneral.setformatofacturasForeignKey(formatofacturasForeignKey);


			List<Formato> formatonotacreditosForeignKey=new ArrayList<Formato>();
			FormatoLogic formatonotacreditoLogic=new FormatoLogic();
			formatonotacreditoLogic.setConnexion(this.connexion);
			formatonotacreditoLogic.getFormatoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalFormatoNotaCredito.equals("NONE")) {
				formatonotacreditoLogic.getTodosFormatos(finalQueryGlobalFormatoNotaCredito,new Pagination());
				formatonotacreditosForeignKey=formatonotacreditoLogic.getFormatos();
			}

			parametrofactuReturnGeneral.setformatonotacreditosForeignKey(formatonotacreditosForeignKey);


			List<Formato> formatoinventariosForeignKey=new ArrayList<Formato>();
			FormatoLogic formatoinventarioLogic=new FormatoLogic();
			formatoinventarioLogic.setConnexion(this.connexion);
			formatoinventarioLogic.getFormatoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalFormatoInventario.equals("NONE")) {
				formatoinventarioLogic.getTodosFormatos(finalQueryGlobalFormatoInventario,new Pagination());
				formatoinventariosForeignKey=formatoinventarioLogic.getFormatos();
			}

			parametrofactuReturnGeneral.setformatoinventariosForeignKey(formatoinventariosForeignKey);

			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
		
		return parametrofactuReturnGeneral;
	}
	
	public ParametroFactuParameterReturnGeneral cargarCombosLoteForeignKeyParametroFactu(String finalQueryGlobalEmpresa,String finalQueryGlobalSucursal,String finalQueryGlobalCuentaContableFactu,String finalQueryGlobalCuentaContableFinan,String finalQueryGlobalCuentaContableOtro,String finalQueryGlobalFormatoProforma,String finalQueryGlobalFormatoPedido,String finalQueryGlobalFormatoFactura,String finalQueryGlobalFormatoNotaCredito,String finalQueryGlobalFormatoInventario) throws Exception {
		ParametroFactuParameterReturnGeneral  parametrofactuReturnGeneral =new ParametroFactuParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {						
			parametrofactuReturnGeneral =new ParametroFactuParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			parametrofactuReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Sucursal> sucursalsForeignKey=new ArrayList<Sucursal>();
			SucursalLogic sucursalLogic=new SucursalLogic();
			sucursalLogic.setConnexion(this.connexion);
			//sucursalLogic.getSucursalDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalSucursal.equals("NONE")) {
				sucursalLogic.getTodosSucursals(finalQueryGlobalSucursal,new Pagination());
				sucursalsForeignKey=sucursalLogic.getSucursals();
			}

			parametrofactuReturnGeneral.setsucursalsForeignKey(sucursalsForeignKey);


			List<CuentaContable> cuentacontablefactusForeignKey=new ArrayList<CuentaContable>();
			CuentaContableLogic cuentacontablefactuLogic=new CuentaContableLogic();
			cuentacontablefactuLogic.setConnexion(this.connexion);
			cuentacontablefactuLogic.getCuentaContableDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCuentaContableFactu.equals("NONE")) {
				cuentacontablefactuLogic.getTodosCuentaContables(finalQueryGlobalCuentaContableFactu,new Pagination());
				cuentacontablefactusForeignKey=cuentacontablefactuLogic.getCuentaContables();
			}

			parametrofactuReturnGeneral.setcuentacontablefactusForeignKey(cuentacontablefactusForeignKey);


			List<CuentaContable> cuentacontablefinansForeignKey=new ArrayList<CuentaContable>();
			CuentaContableLogic cuentacontablefinanLogic=new CuentaContableLogic();
			cuentacontablefinanLogic.setConnexion(this.connexion);
			cuentacontablefinanLogic.getCuentaContableDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCuentaContableFinan.equals("NONE")) {
				cuentacontablefinanLogic.getTodosCuentaContables(finalQueryGlobalCuentaContableFinan,new Pagination());
				cuentacontablefinansForeignKey=cuentacontablefinanLogic.getCuentaContables();
			}

			parametrofactuReturnGeneral.setcuentacontablefinansForeignKey(cuentacontablefinansForeignKey);


			List<CuentaContable> cuentacontableotrosForeignKey=new ArrayList<CuentaContable>();
			CuentaContableLogic cuentacontableotroLogic=new CuentaContableLogic();
			cuentacontableotroLogic.setConnexion(this.connexion);
			cuentacontableotroLogic.getCuentaContableDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCuentaContableOtro.equals("NONE")) {
				cuentacontableotroLogic.getTodosCuentaContables(finalQueryGlobalCuentaContableOtro,new Pagination());
				cuentacontableotrosForeignKey=cuentacontableotroLogic.getCuentaContables();
			}

			parametrofactuReturnGeneral.setcuentacontableotrosForeignKey(cuentacontableotrosForeignKey);


			List<Formato> formatoproformasForeignKey=new ArrayList<Formato>();
			FormatoLogic formatoproformaLogic=new FormatoLogic();
			formatoproformaLogic.setConnexion(this.connexion);
			formatoproformaLogic.getFormatoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalFormatoProforma.equals("NONE")) {
				formatoproformaLogic.getTodosFormatos(finalQueryGlobalFormatoProforma,new Pagination());
				formatoproformasForeignKey=formatoproformaLogic.getFormatos();
			}

			parametrofactuReturnGeneral.setformatoproformasForeignKey(formatoproformasForeignKey);


			List<Formato> formatopedidosForeignKey=new ArrayList<Formato>();
			FormatoLogic formatopedidoLogic=new FormatoLogic();
			formatopedidoLogic.setConnexion(this.connexion);
			formatopedidoLogic.getFormatoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalFormatoPedido.equals("NONE")) {
				formatopedidoLogic.getTodosFormatos(finalQueryGlobalFormatoPedido,new Pagination());
				formatopedidosForeignKey=formatopedidoLogic.getFormatos();
			}

			parametrofactuReturnGeneral.setformatopedidosForeignKey(formatopedidosForeignKey);


			List<Formato> formatofacturasForeignKey=new ArrayList<Formato>();
			FormatoLogic formatofacturaLogic=new FormatoLogic();
			formatofacturaLogic.setConnexion(this.connexion);
			formatofacturaLogic.getFormatoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalFormatoFactura.equals("NONE")) {
				formatofacturaLogic.getTodosFormatos(finalQueryGlobalFormatoFactura,new Pagination());
				formatofacturasForeignKey=formatofacturaLogic.getFormatos();
			}

			parametrofactuReturnGeneral.setformatofacturasForeignKey(formatofacturasForeignKey);


			List<Formato> formatonotacreditosForeignKey=new ArrayList<Formato>();
			FormatoLogic formatonotacreditoLogic=new FormatoLogic();
			formatonotacreditoLogic.setConnexion(this.connexion);
			formatonotacreditoLogic.getFormatoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalFormatoNotaCredito.equals("NONE")) {
				formatonotacreditoLogic.getTodosFormatos(finalQueryGlobalFormatoNotaCredito,new Pagination());
				formatonotacreditosForeignKey=formatonotacreditoLogic.getFormatos();
			}

			parametrofactuReturnGeneral.setformatonotacreditosForeignKey(formatonotacreditosForeignKey);


			List<Formato> formatoinventariosForeignKey=new ArrayList<Formato>();
			FormatoLogic formatoinventarioLogic=new FormatoLogic();
			formatoinventarioLogic.setConnexion(this.connexion);
			formatoinventarioLogic.getFormatoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalFormatoInventario.equals("NONE")) {
				formatoinventarioLogic.getTodosFormatos(finalQueryGlobalFormatoInventario,new Pagination());
				formatoinventariosForeignKey=formatoinventarioLogic.getFormatos();
			}

			parametrofactuReturnGeneral.setformatoinventariosForeignKey(formatoinventariosForeignKey);
						
			
		} catch(Exception e) {			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			
		}
		
		return parametrofactuReturnGeneral;
	}
	
	
	public void deepLoad(ParametroFactu parametrofactu,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			ParametroFactuLogicAdditional.updateParametroFactuToGet(parametrofactu,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		parametrofactu.setEmpresa(parametrofactuDataAccess.getEmpresa(connexion,parametrofactu));
		parametrofactu.setSucursal(parametrofactuDataAccess.getSucursal(connexion,parametrofactu));
		parametrofactu.setCuentaContableFactu(parametrofactuDataAccess.getCuentaContableFactu(connexion,parametrofactu));
		parametrofactu.setCuentaContableFinan(parametrofactuDataAccess.getCuentaContableFinan(connexion,parametrofactu));
		parametrofactu.setCuentaContableOtro(parametrofactuDataAccess.getCuentaContableOtro(connexion,parametrofactu));
		parametrofactu.setFormatoProforma(parametrofactuDataAccess.getFormatoProforma(connexion,parametrofactu));
		parametrofactu.setFormatoPedido(parametrofactuDataAccess.getFormatoPedido(connexion,parametrofactu));
		parametrofactu.setFormatoFactura(parametrofactuDataAccess.getFormatoFactura(connexion,parametrofactu));
		parametrofactu.setFormatoNotaCredito(parametrofactuDataAccess.getFormatoNotaCredito(connexion,parametrofactu));
		parametrofactu.setFormatoInventario(parametrofactuDataAccess.getFormatoInventario(connexion,parametrofactu));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				parametrofactu.setEmpresa(parametrofactuDataAccess.getEmpresa(connexion,parametrofactu));
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				parametrofactu.setSucursal(parametrofactuDataAccess.getSucursal(connexion,parametrofactu));
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				parametrofactu.setCuentaContableFactu(parametrofactuDataAccess.getCuentaContableFactu(connexion,parametrofactu));
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				parametrofactu.setCuentaContableFinan(parametrofactuDataAccess.getCuentaContableFinan(connexion,parametrofactu));
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				parametrofactu.setCuentaContableOtro(parametrofactuDataAccess.getCuentaContableOtro(connexion,parametrofactu));
				continue;
			}

			if(clas.clas.equals(Formato.class)) {
				parametrofactu.setFormatoProforma(parametrofactuDataAccess.getFormatoProforma(connexion,parametrofactu));
				continue;
			}

			if(clas.clas.equals(Formato.class)) {
				parametrofactu.setFormatoPedido(parametrofactuDataAccess.getFormatoPedido(connexion,parametrofactu));
				continue;
			}

			if(clas.clas.equals(Formato.class)) {
				parametrofactu.setFormatoFactura(parametrofactuDataAccess.getFormatoFactura(connexion,parametrofactu));
				continue;
			}

			if(clas.clas.equals(Formato.class)) {
				parametrofactu.setFormatoNotaCredito(parametrofactuDataAccess.getFormatoNotaCredito(connexion,parametrofactu));
				continue;
			}

			if(clas.clas.equals(Formato.class)) {
				parametrofactu.setFormatoInventario(parametrofactuDataAccess.getFormatoInventario(connexion,parametrofactu));
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
			parametrofactu.setEmpresa(parametrofactuDataAccess.getEmpresa(connexion,parametrofactu));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			parametrofactu.setSucursal(parametrofactuDataAccess.getSucursal(connexion,parametrofactu));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(CuentaContable.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			parametrofactu.setCuentaContableFactu(parametrofactuDataAccess.getCuentaContableFactu(connexion,parametrofactu));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(CuentaContable.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			parametrofactu.setCuentaContableFinan(parametrofactuDataAccess.getCuentaContableFinan(connexion,parametrofactu));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(CuentaContable.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			parametrofactu.setCuentaContableOtro(parametrofactuDataAccess.getCuentaContableOtro(connexion,parametrofactu));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Formato.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			parametrofactu.setFormatoProforma(parametrofactuDataAccess.getFormatoProforma(connexion,parametrofactu));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Formato.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			parametrofactu.setFormatoPedido(parametrofactuDataAccess.getFormatoPedido(connexion,parametrofactu));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Formato.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			parametrofactu.setFormatoFactura(parametrofactuDataAccess.getFormatoFactura(connexion,parametrofactu));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Formato.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			parametrofactu.setFormatoNotaCredito(parametrofactuDataAccess.getFormatoNotaCredito(connexion,parametrofactu));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Formato.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			parametrofactu.setFormatoInventario(parametrofactuDataAccess.getFormatoInventario(connexion,parametrofactu));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		parametrofactu.setEmpresa(parametrofactuDataAccess.getEmpresa(connexion,parametrofactu));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(parametrofactu.getEmpresa(),isDeep,deepLoadType,clases);
				
		parametrofactu.setSucursal(parametrofactuDataAccess.getSucursal(connexion,parametrofactu));
		SucursalLogic sucursalLogic= new SucursalLogic(connexion);
		sucursalLogic.deepLoad(parametrofactu.getSucursal(),isDeep,deepLoadType,clases);
				
		parametrofactu.setCuentaContableFactu(parametrofactuDataAccess.getCuentaContableFactu(connexion,parametrofactu));
		CuentaContableLogic cuentacontablefactuLogic= new CuentaContableLogic(connexion);
		cuentacontablefactuLogic.deepLoad(parametrofactu.getCuentaContableFactu(),isDeep,deepLoadType,clases);
				
		parametrofactu.setCuentaContableFinan(parametrofactuDataAccess.getCuentaContableFinan(connexion,parametrofactu));
		CuentaContableLogic cuentacontablefinanLogic= new CuentaContableLogic(connexion);
		cuentacontablefinanLogic.deepLoad(parametrofactu.getCuentaContableFinan(),isDeep,deepLoadType,clases);
				
		parametrofactu.setCuentaContableOtro(parametrofactuDataAccess.getCuentaContableOtro(connexion,parametrofactu));
		CuentaContableLogic cuentacontableotroLogic= new CuentaContableLogic(connexion);
		cuentacontableotroLogic.deepLoad(parametrofactu.getCuentaContableOtro(),isDeep,deepLoadType,clases);
				
		parametrofactu.setFormatoProforma(parametrofactuDataAccess.getFormatoProforma(connexion,parametrofactu));
		FormatoLogic formatoproformaLogic= new FormatoLogic(connexion);
		formatoproformaLogic.deepLoad(parametrofactu.getFormatoProforma(),isDeep,deepLoadType,clases);
				
		parametrofactu.setFormatoPedido(parametrofactuDataAccess.getFormatoPedido(connexion,parametrofactu));
		FormatoLogic formatopedidoLogic= new FormatoLogic(connexion);
		formatopedidoLogic.deepLoad(parametrofactu.getFormatoPedido(),isDeep,deepLoadType,clases);
				
		parametrofactu.setFormatoFactura(parametrofactuDataAccess.getFormatoFactura(connexion,parametrofactu));
		FormatoLogic formatofacturaLogic= new FormatoLogic(connexion);
		formatofacturaLogic.deepLoad(parametrofactu.getFormatoFactura(),isDeep,deepLoadType,clases);
				
		parametrofactu.setFormatoNotaCredito(parametrofactuDataAccess.getFormatoNotaCredito(connexion,parametrofactu));
		FormatoLogic formatonotacreditoLogic= new FormatoLogic(connexion);
		formatonotacreditoLogic.deepLoad(parametrofactu.getFormatoNotaCredito(),isDeep,deepLoadType,clases);
				
		parametrofactu.setFormatoInventario(parametrofactuDataAccess.getFormatoInventario(connexion,parametrofactu));
		FormatoLogic formatoinventarioLogic= new FormatoLogic(connexion);
		formatoinventarioLogic.deepLoad(parametrofactu.getFormatoInventario(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				parametrofactu.setEmpresa(parametrofactuDataAccess.getEmpresa(connexion,parametrofactu));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(parametrofactu.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				parametrofactu.setSucursal(parametrofactuDataAccess.getSucursal(connexion,parametrofactu));
				SucursalLogic sucursalLogic= new SucursalLogic(connexion);
				sucursalLogic.deepLoad(parametrofactu.getSucursal(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				parametrofactu.setCuentaContableFactu(parametrofactuDataAccess.getCuentaContableFactu(connexion,parametrofactu));
				CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
				cuentacontableLogic.deepLoad(parametrofactu.getCuentaContableFactu(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				parametrofactu.setCuentaContableFinan(parametrofactuDataAccess.getCuentaContableFinan(connexion,parametrofactu));
				CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
				cuentacontableLogic.deepLoad(parametrofactu.getCuentaContableFinan(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				parametrofactu.setCuentaContableOtro(parametrofactuDataAccess.getCuentaContableOtro(connexion,parametrofactu));
				CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
				cuentacontableLogic.deepLoad(parametrofactu.getCuentaContableOtro(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Formato.class)) {
				parametrofactu.setFormatoProforma(parametrofactuDataAccess.getFormatoProforma(connexion,parametrofactu));
				FormatoLogic formatoLogic= new FormatoLogic(connexion);
				formatoLogic.deepLoad(parametrofactu.getFormatoProforma(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Formato.class)) {
				parametrofactu.setFormatoPedido(parametrofactuDataAccess.getFormatoPedido(connexion,parametrofactu));
				FormatoLogic formatoLogic= new FormatoLogic(connexion);
				formatoLogic.deepLoad(parametrofactu.getFormatoPedido(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Formato.class)) {
				parametrofactu.setFormatoFactura(parametrofactuDataAccess.getFormatoFactura(connexion,parametrofactu));
				FormatoLogic formatoLogic= new FormatoLogic(connexion);
				formatoLogic.deepLoad(parametrofactu.getFormatoFactura(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Formato.class)) {
				parametrofactu.setFormatoNotaCredito(parametrofactuDataAccess.getFormatoNotaCredito(connexion,parametrofactu));
				FormatoLogic formatoLogic= new FormatoLogic(connexion);
				formatoLogic.deepLoad(parametrofactu.getFormatoNotaCredito(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Formato.class)) {
				parametrofactu.setFormatoInventario(parametrofactuDataAccess.getFormatoInventario(connexion,parametrofactu));
				FormatoLogic formatoLogic= new FormatoLogic(connexion);
				formatoLogic.deepLoad(parametrofactu.getFormatoInventario(),isDeep,deepLoadType,clases);				
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
			parametrofactu.setEmpresa(parametrofactuDataAccess.getEmpresa(connexion,parametrofactu));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(parametrofactu.getEmpresa(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			parametrofactu.setSucursal(parametrofactuDataAccess.getSucursal(connexion,parametrofactu));
			SucursalLogic sucursalLogic= new SucursalLogic(connexion);
			sucursalLogic.deepLoad(parametrofactu.getSucursal(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(CuentaContable.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			parametrofactu.setCuentaContableFactu(parametrofactuDataAccess.getCuentaContableFactu(connexion,parametrofactu));
			CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
			cuentacontableLogic.deepLoad(parametrofactu.getCuentaContableFactu(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(CuentaContable.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			parametrofactu.setCuentaContableFinan(parametrofactuDataAccess.getCuentaContableFinan(connexion,parametrofactu));
			CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
			cuentacontableLogic.deepLoad(parametrofactu.getCuentaContableFinan(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(CuentaContable.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			parametrofactu.setCuentaContableOtro(parametrofactuDataAccess.getCuentaContableOtro(connexion,parametrofactu));
			CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
			cuentacontableLogic.deepLoad(parametrofactu.getCuentaContableOtro(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Formato.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			parametrofactu.setFormatoProforma(parametrofactuDataAccess.getFormatoProforma(connexion,parametrofactu));
			FormatoLogic formatoLogic= new FormatoLogic(connexion);
			formatoLogic.deepLoad(parametrofactu.getFormatoProforma(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Formato.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			parametrofactu.setFormatoPedido(parametrofactuDataAccess.getFormatoPedido(connexion,parametrofactu));
			FormatoLogic formatoLogic= new FormatoLogic(connexion);
			formatoLogic.deepLoad(parametrofactu.getFormatoPedido(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Formato.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			parametrofactu.setFormatoFactura(parametrofactuDataAccess.getFormatoFactura(connexion,parametrofactu));
			FormatoLogic formatoLogic= new FormatoLogic(connexion);
			formatoLogic.deepLoad(parametrofactu.getFormatoFactura(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Formato.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			parametrofactu.setFormatoNotaCredito(parametrofactuDataAccess.getFormatoNotaCredito(connexion,parametrofactu));
			FormatoLogic formatoLogic= new FormatoLogic(connexion);
			formatoLogic.deepLoad(parametrofactu.getFormatoNotaCredito(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Formato.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			parametrofactu.setFormatoInventario(parametrofactuDataAccess.getFormatoInventario(connexion,parametrofactu));
			FormatoLogic formatoLogic= new FormatoLogic(connexion);
			formatoLogic.deepLoad(parametrofactu.getFormatoInventario(),isDeep,deepLoadType,clases);
				
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(ParametroFactu parametrofactu,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			ParametroFactuLogicAdditional.updateParametroFactuToSave(parametrofactu,this.arrDatoGeneral);
			
ParametroFactuDataAccess.save(parametrofactu, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(parametrofactu.getEmpresa(),connexion);

		SucursalDataAccess.save(parametrofactu.getSucursal(),connexion);

		CuentaContableDataAccess.save(parametrofactu.getCuentaContableFactu(),connexion);

		CuentaContableDataAccess.save(parametrofactu.getCuentaContableFinan(),connexion);

		CuentaContableDataAccess.save(parametrofactu.getCuentaContableOtro(),connexion);

		FormatoDataAccess.save(parametrofactu.getFormatoProforma(),connexion);

		FormatoDataAccess.save(parametrofactu.getFormatoPedido(),connexion);

		FormatoDataAccess.save(parametrofactu.getFormatoFactura(),connexion);

		FormatoDataAccess.save(parametrofactu.getFormatoNotaCredito(),connexion);

		FormatoDataAccess.save(parametrofactu.getFormatoInventario(),connexion);
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(parametrofactu.getEmpresa(),connexion);
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				SucursalDataAccess.save(parametrofactu.getSucursal(),connexion);
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				CuentaContableDataAccess.save(parametrofactu.getCuentaContableFactu(),connexion);
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				CuentaContableDataAccess.save(parametrofactu.getCuentaContableFinan(),connexion);
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				CuentaContableDataAccess.save(parametrofactu.getCuentaContableOtro(),connexion);
				continue;
			}

			if(clas.clas.equals(Formato.class)) {
				FormatoDataAccess.save(parametrofactu.getFormatoProforma(),connexion);
				continue;
			}

			if(clas.clas.equals(Formato.class)) {
				FormatoDataAccess.save(parametrofactu.getFormatoPedido(),connexion);
				continue;
			}

			if(clas.clas.equals(Formato.class)) {
				FormatoDataAccess.save(parametrofactu.getFormatoFactura(),connexion);
				continue;
			}

			if(clas.clas.equals(Formato.class)) {
				FormatoDataAccess.save(parametrofactu.getFormatoNotaCredito(),connexion);
				continue;
			}

			if(clas.clas.equals(Formato.class)) {
				FormatoDataAccess.save(parametrofactu.getFormatoInventario(),connexion);
				continue;
			}

		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(parametrofactu.getEmpresa(),connexion);
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(parametrofactu.getEmpresa(),isDeep,deepLoadType,clases);
				

		SucursalDataAccess.save(parametrofactu.getSucursal(),connexion);
		SucursalLogic sucursalLogic= new SucursalLogic(connexion);
		sucursalLogic.deepLoad(parametrofactu.getSucursal(),isDeep,deepLoadType,clases);
				

		CuentaContableDataAccess.save(parametrofactu.getCuentaContableFactu(),connexion);
		CuentaContableLogic cuentacontablefactuLogic= new CuentaContableLogic(connexion);
		cuentacontablefactuLogic.deepLoad(parametrofactu.getCuentaContableFactu(),isDeep,deepLoadType,clases);
				

		CuentaContableDataAccess.save(parametrofactu.getCuentaContableFinan(),connexion);
		CuentaContableLogic cuentacontablefinanLogic= new CuentaContableLogic(connexion);
		cuentacontablefinanLogic.deepLoad(parametrofactu.getCuentaContableFinan(),isDeep,deepLoadType,clases);
				

		CuentaContableDataAccess.save(parametrofactu.getCuentaContableOtro(),connexion);
		CuentaContableLogic cuentacontableotroLogic= new CuentaContableLogic(connexion);
		cuentacontableotroLogic.deepLoad(parametrofactu.getCuentaContableOtro(),isDeep,deepLoadType,clases);
				

		FormatoDataAccess.save(parametrofactu.getFormatoProforma(),connexion);
		FormatoLogic formatoproformaLogic= new FormatoLogic(connexion);
		formatoproformaLogic.deepLoad(parametrofactu.getFormatoProforma(),isDeep,deepLoadType,clases);
				

		FormatoDataAccess.save(parametrofactu.getFormatoPedido(),connexion);
		FormatoLogic formatopedidoLogic= new FormatoLogic(connexion);
		formatopedidoLogic.deepLoad(parametrofactu.getFormatoPedido(),isDeep,deepLoadType,clases);
				

		FormatoDataAccess.save(parametrofactu.getFormatoFactura(),connexion);
		FormatoLogic formatofacturaLogic= new FormatoLogic(connexion);
		formatofacturaLogic.deepLoad(parametrofactu.getFormatoFactura(),isDeep,deepLoadType,clases);
				

		FormatoDataAccess.save(parametrofactu.getFormatoNotaCredito(),connexion);
		FormatoLogic formatonotacreditoLogic= new FormatoLogic(connexion);
		formatonotacreditoLogic.deepLoad(parametrofactu.getFormatoNotaCredito(),isDeep,deepLoadType,clases);
				

		FormatoDataAccess.save(parametrofactu.getFormatoInventario(),connexion);
		FormatoLogic formatoinventarioLogic= new FormatoLogic(connexion);
		formatoinventarioLogic.deepLoad(parametrofactu.getFormatoInventario(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(parametrofactu.getEmpresa(),connexion);
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepSave(parametrofactu.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				SucursalDataAccess.save(parametrofactu.getSucursal(),connexion);
				SucursalLogic sucursalLogic= new SucursalLogic(connexion);
				sucursalLogic.deepSave(parametrofactu.getSucursal(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				CuentaContableDataAccess.save(parametrofactu.getCuentaContableFactu(),connexion);
				CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
				cuentacontableLogic.deepSave(parametrofactu.getCuentaContableFactu(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				CuentaContableDataAccess.save(parametrofactu.getCuentaContableFinan(),connexion);
				CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
				cuentacontableLogic.deepSave(parametrofactu.getCuentaContableFinan(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				CuentaContableDataAccess.save(parametrofactu.getCuentaContableOtro(),connexion);
				CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
				cuentacontableLogic.deepSave(parametrofactu.getCuentaContableOtro(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Formato.class)) {
				FormatoDataAccess.save(parametrofactu.getFormatoProforma(),connexion);
				FormatoLogic formatoLogic= new FormatoLogic(connexion);
				formatoLogic.deepSave(parametrofactu.getFormatoProforma(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Formato.class)) {
				FormatoDataAccess.save(parametrofactu.getFormatoPedido(),connexion);
				FormatoLogic formatoLogic= new FormatoLogic(connexion);
				formatoLogic.deepSave(parametrofactu.getFormatoPedido(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Formato.class)) {
				FormatoDataAccess.save(parametrofactu.getFormatoFactura(),connexion);
				FormatoLogic formatoLogic= new FormatoLogic(connexion);
				formatoLogic.deepSave(parametrofactu.getFormatoFactura(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Formato.class)) {
				FormatoDataAccess.save(parametrofactu.getFormatoNotaCredito(),connexion);
				FormatoLogic formatoLogic= new FormatoLogic(connexion);
				formatoLogic.deepSave(parametrofactu.getFormatoNotaCredito(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Formato.class)) {
				FormatoDataAccess.save(parametrofactu.getFormatoInventario(),connexion);
				FormatoLogic formatoLogic= new FormatoLogic(connexion);
				formatoLogic.deepSave(parametrofactu.getFormatoInventario(),isDeep,deepLoadType,clases);				
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
			this.getNewConnexionToDeep(ParametroFactu.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(parametrofactu,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				ParametroFactuConstantesFunciones.refrescarForeignKeysDescripcionesParametroFactu(parametrofactu);
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
			this.deepLoad(this.parametrofactu,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				ParametroFactuConstantesFunciones.refrescarForeignKeysDescripcionesParametroFactu(this.parametrofactu);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(ParametroFactu.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(parametrofactus!=null) {
				for(ParametroFactu parametrofactu:parametrofactus) {
					this.deepLoad(parametrofactu,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					ParametroFactuConstantesFunciones.refrescarForeignKeysDescripcionesParametroFactu(parametrofactus);
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
			if(parametrofactus!=null) {
				for(ParametroFactu parametrofactu:parametrofactus) {
					this.deepLoad(parametrofactu,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					ParametroFactuConstantesFunciones.refrescarForeignKeysDescripcionesParametroFactu(parametrofactus);
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
			this.getNewConnexionToDeep(ParametroFactu.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(parametrofactu,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(ParametroFactu.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(parametrofactus!=null) {
				for(ParametroFactu parametrofactu:parametrofactus) {
					this.deepSave(parametrofactu,isDeep,deepLoadType,clases);
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
			if(parametrofactus!=null) {
				for(ParametroFactu parametrofactu:parametrofactus) {
					this.deepSave(parametrofactu,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getParametroFactusFK_IdCuentaContableFactuWithConnection(String sFinalQuery,Pagination pagination,Long id_cuenta_contable_factu)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroFactu.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCuentaContableFactu= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCuentaContableFactu.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cuenta_contable_factu,ParametroFactuConstantesFunciones.IDCUENTACONTABLEFACTU,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCuentaContableFactu);

			ParametroFactuLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCuentaContableFactu","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			parametrofactus=parametrofactuDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ParametroFactuConstantesFunciones.refrescarForeignKeysDescripcionesParametroFactu(this.parametrofactus);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getParametroFactusFK_IdCuentaContableFactu(String sFinalQuery,Pagination pagination,Long id_cuenta_contable_factu)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCuentaContableFactu= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCuentaContableFactu.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cuenta_contable_factu,ParametroFactuConstantesFunciones.IDCUENTACONTABLEFACTU,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCuentaContableFactu);

			ParametroFactuLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCuentaContableFactu","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			parametrofactus=parametrofactuDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ParametroFactuConstantesFunciones.refrescarForeignKeysDescripcionesParametroFactu(this.parametrofactus);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getParametroFactusFK_IdCuentaContableFinanWithConnection(String sFinalQuery,Pagination pagination,Long id_cuenta_contable_finan)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroFactu.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCuentaContableFinan= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCuentaContableFinan.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cuenta_contable_finan,ParametroFactuConstantesFunciones.IDCUENTACONTABLEFINAN,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCuentaContableFinan);

			ParametroFactuLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCuentaContableFinan","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			parametrofactus=parametrofactuDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ParametroFactuConstantesFunciones.refrescarForeignKeysDescripcionesParametroFactu(this.parametrofactus);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getParametroFactusFK_IdCuentaContableFinan(String sFinalQuery,Pagination pagination,Long id_cuenta_contable_finan)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCuentaContableFinan= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCuentaContableFinan.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cuenta_contable_finan,ParametroFactuConstantesFunciones.IDCUENTACONTABLEFINAN,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCuentaContableFinan);

			ParametroFactuLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCuentaContableFinan","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			parametrofactus=parametrofactuDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ParametroFactuConstantesFunciones.refrescarForeignKeysDescripcionesParametroFactu(this.parametrofactus);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getParametroFactusFK_IdCuentaContableOtroWithConnection(String sFinalQuery,Pagination pagination,Long id_cuenta_contable_otro)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroFactu.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCuentaContableOtro= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCuentaContableOtro.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cuenta_contable_otro,ParametroFactuConstantesFunciones.IDCUENTACONTABLEOTRO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCuentaContableOtro);

			ParametroFactuLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCuentaContableOtro","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			parametrofactus=parametrofactuDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ParametroFactuConstantesFunciones.refrescarForeignKeysDescripcionesParametroFactu(this.parametrofactus);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getParametroFactusFK_IdCuentaContableOtro(String sFinalQuery,Pagination pagination,Long id_cuenta_contable_otro)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCuentaContableOtro= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCuentaContableOtro.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cuenta_contable_otro,ParametroFactuConstantesFunciones.IDCUENTACONTABLEOTRO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCuentaContableOtro);

			ParametroFactuLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCuentaContableOtro","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			parametrofactus=parametrofactuDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ParametroFactuConstantesFunciones.refrescarForeignKeysDescripcionesParametroFactu(this.parametrofactus);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getParametroFactusFK_IdEmpresaWithConnection(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroFactu.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,ParametroFactuConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			ParametroFactuLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			parametrofactus=parametrofactuDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ParametroFactuConstantesFunciones.refrescarForeignKeysDescripcionesParametroFactu(this.parametrofactus);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getParametroFactusFK_IdEmpresa(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,ParametroFactuConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			ParametroFactuLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			parametrofactus=parametrofactuDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ParametroFactuConstantesFunciones.refrescarForeignKeysDescripcionesParametroFactu(this.parametrofactus);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getParametroFactusFK_IdFormatoFacturaWithConnection(String sFinalQuery,Pagination pagination,Long id_formato_factura)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroFactu.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidFormatoFactura= new ParameterSelectionGeneral();
			parameterSelectionGeneralidFormatoFactura.setParameterSelectionGeneralEqual(ParameterType.LONG,id_formato_factura,ParametroFactuConstantesFunciones.IDFORMATOFACTURA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidFormatoFactura);

			ParametroFactuLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdFormatoFactura","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			parametrofactus=parametrofactuDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ParametroFactuConstantesFunciones.refrescarForeignKeysDescripcionesParametroFactu(this.parametrofactus);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getParametroFactusFK_IdFormatoFactura(String sFinalQuery,Pagination pagination,Long id_formato_factura)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidFormatoFactura= new ParameterSelectionGeneral();
			parameterSelectionGeneralidFormatoFactura.setParameterSelectionGeneralEqual(ParameterType.LONG,id_formato_factura,ParametroFactuConstantesFunciones.IDFORMATOFACTURA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidFormatoFactura);

			ParametroFactuLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdFormatoFactura","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			parametrofactus=parametrofactuDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ParametroFactuConstantesFunciones.refrescarForeignKeysDescripcionesParametroFactu(this.parametrofactus);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getParametroFactusFK_IdFormatoInventarioWithConnection(String sFinalQuery,Pagination pagination,Long id_formato_inventario)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroFactu.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidFormatoInventario= new ParameterSelectionGeneral();
			parameterSelectionGeneralidFormatoInventario.setParameterSelectionGeneralEqual(ParameterType.LONG,id_formato_inventario,ParametroFactuConstantesFunciones.IDFORMATOINVENTARIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidFormatoInventario);

			ParametroFactuLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdFormatoInventario","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			parametrofactus=parametrofactuDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ParametroFactuConstantesFunciones.refrescarForeignKeysDescripcionesParametroFactu(this.parametrofactus);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getParametroFactusFK_IdFormatoInventario(String sFinalQuery,Pagination pagination,Long id_formato_inventario)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidFormatoInventario= new ParameterSelectionGeneral();
			parameterSelectionGeneralidFormatoInventario.setParameterSelectionGeneralEqual(ParameterType.LONG,id_formato_inventario,ParametroFactuConstantesFunciones.IDFORMATOINVENTARIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidFormatoInventario);

			ParametroFactuLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdFormatoInventario","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			parametrofactus=parametrofactuDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ParametroFactuConstantesFunciones.refrescarForeignKeysDescripcionesParametroFactu(this.parametrofactus);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getParametroFactusFK_IdFormatoNotaCreditoWithConnection(String sFinalQuery,Pagination pagination,Long id_formato_nota_credito)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroFactu.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidFormatoNotaCredito= new ParameterSelectionGeneral();
			parameterSelectionGeneralidFormatoNotaCredito.setParameterSelectionGeneralEqual(ParameterType.LONG,id_formato_nota_credito,ParametroFactuConstantesFunciones.IDFORMATONOTACREDITO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidFormatoNotaCredito);

			ParametroFactuLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdFormatoNotaCredito","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			parametrofactus=parametrofactuDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ParametroFactuConstantesFunciones.refrescarForeignKeysDescripcionesParametroFactu(this.parametrofactus);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getParametroFactusFK_IdFormatoNotaCredito(String sFinalQuery,Pagination pagination,Long id_formato_nota_credito)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidFormatoNotaCredito= new ParameterSelectionGeneral();
			parameterSelectionGeneralidFormatoNotaCredito.setParameterSelectionGeneralEqual(ParameterType.LONG,id_formato_nota_credito,ParametroFactuConstantesFunciones.IDFORMATONOTACREDITO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidFormatoNotaCredito);

			ParametroFactuLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdFormatoNotaCredito","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			parametrofactus=parametrofactuDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ParametroFactuConstantesFunciones.refrescarForeignKeysDescripcionesParametroFactu(this.parametrofactus);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getParametroFactusFK_IdFormatoPedoWithConnection(String sFinalQuery,Pagination pagination,Long id_formato_pedido)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroFactu.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidFormatoPedido= new ParameterSelectionGeneral();
			parameterSelectionGeneralidFormatoPedido.setParameterSelectionGeneralEqual(ParameterType.LONG,id_formato_pedido,ParametroFactuConstantesFunciones.IDFORMATOPEDIDO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidFormatoPedido);

			ParametroFactuLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdFormatoPedo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			parametrofactus=parametrofactuDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ParametroFactuConstantesFunciones.refrescarForeignKeysDescripcionesParametroFactu(this.parametrofactus);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getParametroFactusFK_IdFormatoPedo(String sFinalQuery,Pagination pagination,Long id_formato_pedido)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidFormatoPedido= new ParameterSelectionGeneral();
			parameterSelectionGeneralidFormatoPedido.setParameterSelectionGeneralEqual(ParameterType.LONG,id_formato_pedido,ParametroFactuConstantesFunciones.IDFORMATOPEDIDO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidFormatoPedido);

			ParametroFactuLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdFormatoPedo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			parametrofactus=parametrofactuDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ParametroFactuConstantesFunciones.refrescarForeignKeysDescripcionesParametroFactu(this.parametrofactus);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getParametroFactusFK_IdFormatoProformaWithConnection(String sFinalQuery,Pagination pagination,Long id_formato_proforma)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroFactu.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidFormatoProforma= new ParameterSelectionGeneral();
			parameterSelectionGeneralidFormatoProforma.setParameterSelectionGeneralEqual(ParameterType.LONG,id_formato_proforma,ParametroFactuConstantesFunciones.IDFORMATOPROFORMA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidFormatoProforma);

			ParametroFactuLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdFormatoProforma","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			parametrofactus=parametrofactuDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ParametroFactuConstantesFunciones.refrescarForeignKeysDescripcionesParametroFactu(this.parametrofactus);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getParametroFactusFK_IdFormatoProforma(String sFinalQuery,Pagination pagination,Long id_formato_proforma)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidFormatoProforma= new ParameterSelectionGeneral();
			parameterSelectionGeneralidFormatoProforma.setParameterSelectionGeneralEqual(ParameterType.LONG,id_formato_proforma,ParametroFactuConstantesFunciones.IDFORMATOPROFORMA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidFormatoProforma);

			ParametroFactuLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdFormatoProforma","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			parametrofactus=parametrofactuDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ParametroFactuConstantesFunciones.refrescarForeignKeysDescripcionesParametroFactu(this.parametrofactus);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getParametroFactusFK_IdSucursalWithConnection(String sFinalQuery,Pagination pagination,Long id_sucursal)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroFactu.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidSucursal= new ParameterSelectionGeneral();
			parameterSelectionGeneralidSucursal.setParameterSelectionGeneralEqual(ParameterType.LONG,id_sucursal,ParametroFactuConstantesFunciones.IDSUCURSAL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidSucursal);

			ParametroFactuLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdSucursal","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			parametrofactus=parametrofactuDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ParametroFactuConstantesFunciones.refrescarForeignKeysDescripcionesParametroFactu(this.parametrofactus);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getParametroFactusFK_IdSucursal(String sFinalQuery,Pagination pagination,Long id_sucursal)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidSucursal= new ParameterSelectionGeneral();
			parameterSelectionGeneralidSucursal.setParameterSelectionGeneralEqual(ParameterType.LONG,id_sucursal,ParametroFactuConstantesFunciones.IDSUCURSAL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidSucursal);

			ParametroFactuLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdSucursal","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			parametrofactus=parametrofactuDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ParametroFactuConstantesFunciones.refrescarForeignKeysDescripcionesParametroFactu(this.parametrofactus);
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
			if(ParametroFactuConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,ParametroFactuDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,ParametroFactu parametrofactu,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(ParametroFactuConstantesFunciones.ISCONAUDITORIA) {
				if(parametrofactu.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,ParametroFactuDataAccess.TABLENAME, parametrofactu.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(ParametroFactuConstantesFunciones.ISCONAUDITORIADETALLE) {
						////ParametroFactuLogic.registrarAuditoriaDetallesParametroFactu(connexion,parametrofactu,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(parametrofactu.getIsDeleted()) {
					/*if(!parametrofactu.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,ParametroFactuDataAccess.TABLENAME, parametrofactu.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////ParametroFactuLogic.registrarAuditoriaDetallesParametroFactu(connexion,parametrofactu,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,ParametroFactuDataAccess.TABLENAME, parametrofactu.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(parametrofactu.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,ParametroFactuDataAccess.TABLENAME, parametrofactu.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(ParametroFactuConstantesFunciones.ISCONAUDITORIADETALLE) {
						////ParametroFactuLogic.registrarAuditoriaDetallesParametroFactu(connexion,parametrofactu,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesParametroFactu(Connexion connexion,ParametroFactu parametrofactu)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(parametrofactu.getIsNew()||!parametrofactu.getid_empresa().equals(parametrofactu.getParametroFactuOriginal().getid_empresa()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(parametrofactu.getParametroFactuOriginal().getid_empresa()!=null)
				{
					strValorActual=parametrofactu.getParametroFactuOriginal().getid_empresa().toString();
				}
				if(parametrofactu.getid_empresa()!=null)
				{
					strValorNuevo=parametrofactu.getid_empresa().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ParametroFactuConstantesFunciones.IDEMPRESA,strValorActual,strValorNuevo);
			}	
			
			if(parametrofactu.getIsNew()||!parametrofactu.getid_sucursal().equals(parametrofactu.getParametroFactuOriginal().getid_sucursal()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(parametrofactu.getParametroFactuOriginal().getid_sucursal()!=null)
				{
					strValorActual=parametrofactu.getParametroFactuOriginal().getid_sucursal().toString();
				}
				if(parametrofactu.getid_sucursal()!=null)
				{
					strValorNuevo=parametrofactu.getid_sucursal().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ParametroFactuConstantesFunciones.IDSUCURSAL,strValorActual,strValorNuevo);
			}	
			
			if(parametrofactu.getIsNew()||!parametrofactu.getid_cuenta_contable_factu().equals(parametrofactu.getParametroFactuOriginal().getid_cuenta_contable_factu()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(parametrofactu.getParametroFactuOriginal().getid_cuenta_contable_factu()!=null)
				{
					strValorActual=parametrofactu.getParametroFactuOriginal().getid_cuenta_contable_factu().toString();
				}
				if(parametrofactu.getid_cuenta_contable_factu()!=null)
				{
					strValorNuevo=parametrofactu.getid_cuenta_contable_factu().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ParametroFactuConstantesFunciones.IDCUENTACONTABLEFACTU,strValorActual,strValorNuevo);
			}	
			
			if(parametrofactu.getIsNew()||!parametrofactu.getid_cuenta_contable_finan().equals(parametrofactu.getParametroFactuOriginal().getid_cuenta_contable_finan()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(parametrofactu.getParametroFactuOriginal().getid_cuenta_contable_finan()!=null)
				{
					strValorActual=parametrofactu.getParametroFactuOriginal().getid_cuenta_contable_finan().toString();
				}
				if(parametrofactu.getid_cuenta_contable_finan()!=null)
				{
					strValorNuevo=parametrofactu.getid_cuenta_contable_finan().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ParametroFactuConstantesFunciones.IDCUENTACONTABLEFINAN,strValorActual,strValorNuevo);
			}	
			
			if(parametrofactu.getIsNew()||!parametrofactu.getid_cuenta_contable_otro().equals(parametrofactu.getParametroFactuOriginal().getid_cuenta_contable_otro()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(parametrofactu.getParametroFactuOriginal().getid_cuenta_contable_otro()!=null)
				{
					strValorActual=parametrofactu.getParametroFactuOriginal().getid_cuenta_contable_otro().toString();
				}
				if(parametrofactu.getid_cuenta_contable_otro()!=null)
				{
					strValorNuevo=parametrofactu.getid_cuenta_contable_otro().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ParametroFactuConstantesFunciones.IDCUENTACONTABLEOTRO,strValorActual,strValorNuevo);
			}	
			
			if(parametrofactu.getIsNew()||!parametrofactu.getid_formato_proforma().equals(parametrofactu.getParametroFactuOriginal().getid_formato_proforma()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(parametrofactu.getParametroFactuOriginal().getid_formato_proforma()!=null)
				{
					strValorActual=parametrofactu.getParametroFactuOriginal().getid_formato_proforma().toString();
				}
				if(parametrofactu.getid_formato_proforma()!=null)
				{
					strValorNuevo=parametrofactu.getid_formato_proforma().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ParametroFactuConstantesFunciones.IDFORMATOPROFORMA,strValorActual,strValorNuevo);
			}	
			
			if(parametrofactu.getIsNew()||!parametrofactu.getid_formato_pedido().equals(parametrofactu.getParametroFactuOriginal().getid_formato_pedido()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(parametrofactu.getParametroFactuOriginal().getid_formato_pedido()!=null)
				{
					strValorActual=parametrofactu.getParametroFactuOriginal().getid_formato_pedido().toString();
				}
				if(parametrofactu.getid_formato_pedido()!=null)
				{
					strValorNuevo=parametrofactu.getid_formato_pedido().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ParametroFactuConstantesFunciones.IDFORMATOPEDIDO,strValorActual,strValorNuevo);
			}	
			
			if(parametrofactu.getIsNew()||!parametrofactu.getid_formato_factura().equals(parametrofactu.getParametroFactuOriginal().getid_formato_factura()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(parametrofactu.getParametroFactuOriginal().getid_formato_factura()!=null)
				{
					strValorActual=parametrofactu.getParametroFactuOriginal().getid_formato_factura().toString();
				}
				if(parametrofactu.getid_formato_factura()!=null)
				{
					strValorNuevo=parametrofactu.getid_formato_factura().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ParametroFactuConstantesFunciones.IDFORMATOFACTURA,strValorActual,strValorNuevo);
			}	
			
			if(parametrofactu.getIsNew()||!parametrofactu.getid_formato_nota_credito().equals(parametrofactu.getParametroFactuOriginal().getid_formato_nota_credito()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(parametrofactu.getParametroFactuOriginal().getid_formato_nota_credito()!=null)
				{
					strValorActual=parametrofactu.getParametroFactuOriginal().getid_formato_nota_credito().toString();
				}
				if(parametrofactu.getid_formato_nota_credito()!=null)
				{
					strValorNuevo=parametrofactu.getid_formato_nota_credito().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ParametroFactuConstantesFunciones.IDFORMATONOTACREDITO,strValorActual,strValorNuevo);
			}	
			
			if(parametrofactu.getIsNew()||!parametrofactu.getid_formato_inventario().equals(parametrofactu.getParametroFactuOriginal().getid_formato_inventario()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(parametrofactu.getParametroFactuOriginal().getid_formato_inventario()!=null)
				{
					strValorActual=parametrofactu.getParametroFactuOriginal().getid_formato_inventario().toString();
				}
				if(parametrofactu.getid_formato_inventario()!=null)
				{
					strValorNuevo=parametrofactu.getid_formato_inventario().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ParametroFactuConstantesFunciones.IDFORMATOINVENTARIO,strValorActual,strValorNuevo);
			}	
			
			if(parametrofactu.getIsNew()||!parametrofactu.getsecuencial_proforma().equals(parametrofactu.getParametroFactuOriginal().getsecuencial_proforma()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(parametrofactu.getParametroFactuOriginal().getsecuencial_proforma()!=null)
				{
					strValorActual=parametrofactu.getParametroFactuOriginal().getsecuencial_proforma();
				}
				if(parametrofactu.getsecuencial_proforma()!=null)
				{
					strValorNuevo=parametrofactu.getsecuencial_proforma() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ParametroFactuConstantesFunciones.SECUENCIALPROFORMA,strValorActual,strValorNuevo);
			}	
			
			if(parametrofactu.getIsNew()||!parametrofactu.getsecuancial_pedido().equals(parametrofactu.getParametroFactuOriginal().getsecuancial_pedido()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(parametrofactu.getParametroFactuOriginal().getsecuancial_pedido()!=null)
				{
					strValorActual=parametrofactu.getParametroFactuOriginal().getsecuancial_pedido();
				}
				if(parametrofactu.getsecuancial_pedido()!=null)
				{
					strValorNuevo=parametrofactu.getsecuancial_pedido() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ParametroFactuConstantesFunciones.SECUANCIALPEDIDO,strValorActual,strValorNuevo);
			}	
			
			if(parametrofactu.getIsNew()||!parametrofactu.getsecuencial_factura().equals(parametrofactu.getParametroFactuOriginal().getsecuencial_factura()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(parametrofactu.getParametroFactuOriginal().getsecuencial_factura()!=null)
				{
					strValorActual=parametrofactu.getParametroFactuOriginal().getsecuencial_factura();
				}
				if(parametrofactu.getsecuencial_factura()!=null)
				{
					strValorNuevo=parametrofactu.getsecuencial_factura() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ParametroFactuConstantesFunciones.SECUENCIALFACTURA,strValorActual,strValorNuevo);
			}	
			
			if(parametrofactu.getIsNew()||!parametrofactu.getsecuencial_nota_credito().equals(parametrofactu.getParametroFactuOriginal().getsecuencial_nota_credito()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(parametrofactu.getParametroFactuOriginal().getsecuencial_nota_credito()!=null)
				{
					strValorActual=parametrofactu.getParametroFactuOriginal().getsecuencial_nota_credito();
				}
				if(parametrofactu.getsecuencial_nota_credito()!=null)
				{
					strValorNuevo=parametrofactu.getsecuencial_nota_credito() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ParametroFactuConstantesFunciones.SECUENCIALNOTACREDITO,strValorActual,strValorNuevo);
			}	
			
			if(parametrofactu.getIsNew()||!parametrofactu.getitem_proforma().equals(parametrofactu.getParametroFactuOriginal().getitem_proforma()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(parametrofactu.getParametroFactuOriginal().getitem_proforma()!=null)
				{
					strValorActual=parametrofactu.getParametroFactuOriginal().getitem_proforma().toString();
				}
				if(parametrofactu.getitem_proforma()!=null)
				{
					strValorNuevo=parametrofactu.getitem_proforma().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ParametroFactuConstantesFunciones.ITEMPROFORMA,strValorActual,strValorNuevo);
			}	
			
			if(parametrofactu.getIsNew()||!parametrofactu.getitem_pedido().equals(parametrofactu.getParametroFactuOriginal().getitem_pedido()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(parametrofactu.getParametroFactuOriginal().getitem_pedido()!=null)
				{
					strValorActual=parametrofactu.getParametroFactuOriginal().getitem_pedido().toString();
				}
				if(parametrofactu.getitem_pedido()!=null)
				{
					strValorNuevo=parametrofactu.getitem_pedido().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ParametroFactuConstantesFunciones.ITEMPEDIDO,strValorActual,strValorNuevo);
			}	
			
			if(parametrofactu.getIsNew()||!parametrofactu.getitem_factura().equals(parametrofactu.getParametroFactuOriginal().getitem_factura()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(parametrofactu.getParametroFactuOriginal().getitem_factura()!=null)
				{
					strValorActual=parametrofactu.getParametroFactuOriginal().getitem_factura().toString();
				}
				if(parametrofactu.getitem_factura()!=null)
				{
					strValorNuevo=parametrofactu.getitem_factura().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ParametroFactuConstantesFunciones.ITEMFACTURA,strValorActual,strValorNuevo);
			}	
			
			if(parametrofactu.getIsNew()||!parametrofactu.getitem_nota_credito().equals(parametrofactu.getParametroFactuOriginal().getitem_nota_credito()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(parametrofactu.getParametroFactuOriginal().getitem_nota_credito()!=null)
				{
					strValorActual=parametrofactu.getParametroFactuOriginal().getitem_nota_credito().toString();
				}
				if(parametrofactu.getitem_nota_credito()!=null)
				{
					strValorNuevo=parametrofactu.getitem_nota_credito().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ParametroFactuConstantesFunciones.ITEMNOTACREDITO,strValorActual,strValorNuevo);
			}	
			
			if(parametrofactu.getIsNew()||!parametrofactu.getitem_inventario().equals(parametrofactu.getParametroFactuOriginal().getitem_inventario()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(parametrofactu.getParametroFactuOriginal().getitem_inventario()!=null)
				{
					strValorActual=parametrofactu.getParametroFactuOriginal().getitem_inventario().toString();
				}
				if(parametrofactu.getitem_inventario()!=null)
				{
					strValorNuevo=parametrofactu.getitem_inventario().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ParametroFactuConstantesFunciones.ITEMINVENTARIO,strValorActual,strValorNuevo);
			}	
			
			if(parametrofactu.getIsNew()||!parametrofactu.getcon_detalle_proforma().equals(parametrofactu.getParametroFactuOriginal().getcon_detalle_proforma()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(parametrofactu.getParametroFactuOriginal().getcon_detalle_proforma()!=null)
				{
					strValorActual=parametrofactu.getParametroFactuOriginal().getcon_detalle_proforma().toString();
				}
				if(parametrofactu.getcon_detalle_proforma()!=null)
				{
					strValorNuevo=parametrofactu.getcon_detalle_proforma().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ParametroFactuConstantesFunciones.CONDETALLEPROFORMA,strValorActual,strValorNuevo);
			}	
			
			if(parametrofactu.getIsNew()||!parametrofactu.getcon_detalle_pedido().equals(parametrofactu.getParametroFactuOriginal().getcon_detalle_pedido()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(parametrofactu.getParametroFactuOriginal().getcon_detalle_pedido()!=null)
				{
					strValorActual=parametrofactu.getParametroFactuOriginal().getcon_detalle_pedido().toString();
				}
				if(parametrofactu.getcon_detalle_pedido()!=null)
				{
					strValorNuevo=parametrofactu.getcon_detalle_pedido().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ParametroFactuConstantesFunciones.CONDETALLEPEDIDO,strValorActual,strValorNuevo);
			}	
			
			if(parametrofactu.getIsNew()||!parametrofactu.getcon_detalle_factura().equals(parametrofactu.getParametroFactuOriginal().getcon_detalle_factura()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(parametrofactu.getParametroFactuOriginal().getcon_detalle_factura()!=null)
				{
					strValorActual=parametrofactu.getParametroFactuOriginal().getcon_detalle_factura().toString();
				}
				if(parametrofactu.getcon_detalle_factura()!=null)
				{
					strValorNuevo=parametrofactu.getcon_detalle_factura().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ParametroFactuConstantesFunciones.CONDETALLEFACTURA,strValorActual,strValorNuevo);
			}	
			
			if(parametrofactu.getIsNew()||!parametrofactu.getcon_detalle_nota_credito().equals(parametrofactu.getParametroFactuOriginal().getcon_detalle_nota_credito()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(parametrofactu.getParametroFactuOriginal().getcon_detalle_nota_credito()!=null)
				{
					strValorActual=parametrofactu.getParametroFactuOriginal().getcon_detalle_nota_credito().toString();
				}
				if(parametrofactu.getcon_detalle_nota_credito()!=null)
				{
					strValorNuevo=parametrofactu.getcon_detalle_nota_credito().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ParametroFactuConstantesFunciones.CONDETALLENOTACREDITO,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void saveParametroFactuRelacionesWithConnection(ParametroFactu parametrofactu) throws Exception {

		if(!parametrofactu.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveParametroFactuRelacionesBase(parametrofactu,true);
		}
	}

	public void saveParametroFactuRelaciones(ParametroFactu parametrofactu)throws Exception {

		if(!parametrofactu.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveParametroFactuRelacionesBase(parametrofactu,false);
		}
	}

	public void saveParametroFactuRelacionesBase(ParametroFactu parametrofactu,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("ParametroFactu-saveRelacionesWithConnection");}
	

			this.setParametroFactu(parametrofactu);

			if(ParametroFactuLogicAdditional.validarSaveRelaciones(parametrofactu,this)) {

				ParametroFactuLogicAdditional.updateRelacionesToSave(parametrofactu,this);

				if((parametrofactu.getIsNew()||parametrofactu.getIsChanged())&&!parametrofactu.getIsDeleted()) {
					this.saveParametroFactu();
					this.saveParametroFactuRelacionesDetalles();

				} else if(parametrofactu.getIsDeleted()) {
					this.saveParametroFactuRelacionesDetalles();
					this.saveParametroFactu();
				}

				ParametroFactuLogicAdditional.updateRelacionesToSaveAfter(parametrofactu,this);

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
	
	
	private void saveParametroFactuRelacionesDetalles()throws Exception {
		try {
	

		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfParametroFactu(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=ParametroFactuConstantesFunciones.getClassesForeignKeysOfParametroFactu(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfParametroFactu(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=ParametroFactuConstantesFunciones.getClassesRelationshipsOfParametroFactu(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}
