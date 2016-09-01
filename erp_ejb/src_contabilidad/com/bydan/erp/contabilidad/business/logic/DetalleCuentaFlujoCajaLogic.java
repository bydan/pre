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
package com.bydan.erp.contabilidad.business.logic;

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
import com.bydan.erp.contabilidad.util.*;
import com.bydan.erp.contabilidad.util.DetalleCuentaFlujoCajaConstantesFunciones;
import com.bydan.erp.contabilidad.util.DetalleCuentaFlujoCajaParameterReturnGeneral;
//import com.bydan.erp.contabilidad.util.DetalleCuentaFlujoCajaParameterGeneral;
import com.bydan.erp.contabilidad.business.entity.DetalleCuentaFlujoCaja;
import com.bydan.erp.contabilidad.business.logic.DetalleCuentaFlujoCajaLogicAdditional;
import com.bydan.erp.contabilidad.business.dataaccess.*;
import com.bydan.erp.contabilidad.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.logic.*;


import com.bydan.erp.seguridad.util.*;


import com.bydan.erp.seguridad.business.dataaccess.*;








@SuppressWarnings("unused")
public class DetalleCuentaFlujoCajaLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(DetalleCuentaFlujoCajaLogic.class);
	
	protected DetalleCuentaFlujoCajaDataAccess detallecuentaflujocajaDataAccess; 	
	protected DetalleCuentaFlujoCaja detallecuentaflujocaja;
	protected List<DetalleCuentaFlujoCaja> detallecuentaflujocajas;
	protected Object detallecuentaflujocajaObject;	
	protected List<Object> detallecuentaflujocajasObject;
	
	public static ClassValidator<DetalleCuentaFlujoCaja> detallecuentaflujocajaValidator = new ClassValidator<DetalleCuentaFlujoCaja>(DetalleCuentaFlujoCaja.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected DetalleCuentaFlujoCajaLogicAdditional detallecuentaflujocajaLogicAdditional=null;
	
	public DetalleCuentaFlujoCajaLogicAdditional getDetalleCuentaFlujoCajaLogicAdditional() {
		return this.detallecuentaflujocajaLogicAdditional;
	}
	
	public void setDetalleCuentaFlujoCajaLogicAdditional(DetalleCuentaFlujoCajaLogicAdditional detallecuentaflujocajaLogicAdditional) {
		try {
			this.detallecuentaflujocajaLogicAdditional=detallecuentaflujocajaLogicAdditional;
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
	
	
	
	
	public  DetalleCuentaFlujoCajaLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.detallecuentaflujocajaDataAccess = new DetalleCuentaFlujoCajaDataAccess();
			
			this.detallecuentaflujocajas= new ArrayList<DetalleCuentaFlujoCaja>();
			this.detallecuentaflujocaja= new DetalleCuentaFlujoCaja();
			
			this.detallecuentaflujocajaObject=new Object();
			this.detallecuentaflujocajasObject=new ArrayList<Object>();
				
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
			
			this.detallecuentaflujocajaDataAccess.setConnexionType(this.connexionType);
			this.detallecuentaflujocajaDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  DetalleCuentaFlujoCajaLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.detallecuentaflujocajaDataAccess = new DetalleCuentaFlujoCajaDataAccess();
			this.detallecuentaflujocajas= new ArrayList<DetalleCuentaFlujoCaja>();
			this.detallecuentaflujocaja= new DetalleCuentaFlujoCaja();
			this.detallecuentaflujocajaObject=new Object();
			this.detallecuentaflujocajasObject=new ArrayList<Object>();
			
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
			
			this.detallecuentaflujocajaDataAccess.setConnexionType(this.connexionType);
			this.detallecuentaflujocajaDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public DetalleCuentaFlujoCaja getDetalleCuentaFlujoCaja() throws Exception {	
		DetalleCuentaFlujoCajaLogicAdditional.checkDetalleCuentaFlujoCajaToGet(detallecuentaflujocaja,this.datosCliente,this.arrDatoGeneral);
		DetalleCuentaFlujoCajaLogicAdditional.updateDetalleCuentaFlujoCajaToGet(detallecuentaflujocaja,this.arrDatoGeneral);
		
		return detallecuentaflujocaja;
	}
		
	public void setDetalleCuentaFlujoCaja(DetalleCuentaFlujoCaja newDetalleCuentaFlujoCaja) {
		this.detallecuentaflujocaja = newDetalleCuentaFlujoCaja;
	}
	
	public DetalleCuentaFlujoCajaDataAccess getDetalleCuentaFlujoCajaDataAccess() {
		return detallecuentaflujocajaDataAccess;
	}
	
	public void setDetalleCuentaFlujoCajaDataAccess(DetalleCuentaFlujoCajaDataAccess newdetallecuentaflujocajaDataAccess) {
		this.detallecuentaflujocajaDataAccess = newdetallecuentaflujocajaDataAccess;
	}
	
	public List<DetalleCuentaFlujoCaja> getDetalleCuentaFlujoCajas() throws Exception {		
		this.quitarDetalleCuentaFlujoCajasNulos();
		
		DetalleCuentaFlujoCajaLogicAdditional.checkDetalleCuentaFlujoCajaToGets(detallecuentaflujocajas,this.datosCliente,this.arrDatoGeneral);
		
		for (DetalleCuentaFlujoCaja detallecuentaflujocajaLocal: detallecuentaflujocajas ) {
			DetalleCuentaFlujoCajaLogicAdditional.updateDetalleCuentaFlujoCajaToGet(detallecuentaflujocajaLocal,this.arrDatoGeneral);
		}
		
		return detallecuentaflujocajas;
	}
	
	public void setDetalleCuentaFlujoCajas(List<DetalleCuentaFlujoCaja> newDetalleCuentaFlujoCajas) {
		this.detallecuentaflujocajas = newDetalleCuentaFlujoCajas;
	}
	
	public Object getDetalleCuentaFlujoCajaObject() {	
		this.detallecuentaflujocajaObject=this.detallecuentaflujocajaDataAccess.getEntityObject();
		return this.detallecuentaflujocajaObject;
	}
		
	public void setDetalleCuentaFlujoCajaObject(Object newDetalleCuentaFlujoCajaObject) {
		this.detallecuentaflujocajaObject = newDetalleCuentaFlujoCajaObject;
	}
	
	public List<Object> getDetalleCuentaFlujoCajasObject() {		
		this.detallecuentaflujocajasObject=this.detallecuentaflujocajaDataAccess.getEntitiesObject();
		return this.detallecuentaflujocajasObject;
	}
		
	public void setDetalleCuentaFlujoCajasObject(List<Object> newDetalleCuentaFlujoCajasObject) {
		this.detallecuentaflujocajasObject = newDetalleCuentaFlujoCajasObject;
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
		
		if(this.detallecuentaflujocajaDataAccess!=null) {
			this.detallecuentaflujocajaDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleCuentaFlujoCaja.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			detallecuentaflujocajaDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			detallecuentaflujocajaDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		detallecuentaflujocaja = new  DetalleCuentaFlujoCaja();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleCuentaFlujoCaja.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			detallecuentaflujocaja=detallecuentaflujocajaDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.detallecuentaflujocaja,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				DetalleCuentaFlujoCajaConstantesFunciones.refrescarForeignKeysDescripcionesDetalleCuentaFlujoCaja(this.detallecuentaflujocaja);
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
		detallecuentaflujocaja = new  DetalleCuentaFlujoCaja();
		  		  
        try {
			
			detallecuentaflujocaja=detallecuentaflujocajaDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.detallecuentaflujocaja,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				DetalleCuentaFlujoCajaConstantesFunciones.refrescarForeignKeysDescripcionesDetalleCuentaFlujoCaja(this.detallecuentaflujocaja);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		detallecuentaflujocaja = new  DetalleCuentaFlujoCaja();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleCuentaFlujoCaja.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			detallecuentaflujocaja=detallecuentaflujocajaDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.detallecuentaflujocaja,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				DetalleCuentaFlujoCajaConstantesFunciones.refrescarForeignKeysDescripcionesDetalleCuentaFlujoCaja(this.detallecuentaflujocaja);
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
		detallecuentaflujocaja = new  DetalleCuentaFlujoCaja();
		  		  
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
		detallecuentaflujocaja = new  DetalleCuentaFlujoCaja();
		  		  
        try {
			
			detallecuentaflujocaja=detallecuentaflujocajaDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.detallecuentaflujocaja,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				DetalleCuentaFlujoCajaConstantesFunciones.refrescarForeignKeysDescripcionesDetalleCuentaFlujoCaja(this.detallecuentaflujocaja);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		detallecuentaflujocaja = new  DetalleCuentaFlujoCaja();
		  		  
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
		detallecuentaflujocaja = new  DetalleCuentaFlujoCaja();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleCuentaFlujoCaja.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =detallecuentaflujocajaDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		detallecuentaflujocaja = new  DetalleCuentaFlujoCaja();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=detallecuentaflujocajaDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		detallecuentaflujocaja = new  DetalleCuentaFlujoCaja();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleCuentaFlujoCaja.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =detallecuentaflujocajaDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		detallecuentaflujocaja = new  DetalleCuentaFlujoCaja();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=detallecuentaflujocajaDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		detallecuentaflujocaja = new  DetalleCuentaFlujoCaja();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleCuentaFlujoCaja.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =detallecuentaflujocajaDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		detallecuentaflujocaja = new  DetalleCuentaFlujoCaja();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=detallecuentaflujocajaDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		detallecuentaflujocajas = new  ArrayList<DetalleCuentaFlujoCaja>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleCuentaFlujoCaja.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			DetalleCuentaFlujoCajaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detallecuentaflujocajas=detallecuentaflujocajaDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarDetalleCuentaFlujoCaja(detallecuentaflujocajas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetalleCuentaFlujoCajaConstantesFunciones.refrescarForeignKeysDescripcionesDetalleCuentaFlujoCaja(this.detallecuentaflujocajas);
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
		detallecuentaflujocajas = new  ArrayList<DetalleCuentaFlujoCaja>();
		  		  
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
		detallecuentaflujocajas = new  ArrayList<DetalleCuentaFlujoCaja>();
		  		  
        try {			
			DetalleCuentaFlujoCajaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detallecuentaflujocajas=detallecuentaflujocajaDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarDetalleCuentaFlujoCaja(detallecuentaflujocajas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetalleCuentaFlujoCajaConstantesFunciones.refrescarForeignKeysDescripcionesDetalleCuentaFlujoCaja(this.detallecuentaflujocajas);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		detallecuentaflujocajas = new  ArrayList<DetalleCuentaFlujoCaja>();
		  		  
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
		detallecuentaflujocajas = new  ArrayList<DetalleCuentaFlujoCaja>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleCuentaFlujoCaja.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			DetalleCuentaFlujoCajaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detallecuentaflujocajas=detallecuentaflujocajaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarDetalleCuentaFlujoCaja(detallecuentaflujocajas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetalleCuentaFlujoCajaConstantesFunciones.refrescarForeignKeysDescripcionesDetalleCuentaFlujoCaja(this.detallecuentaflujocajas);
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
		detallecuentaflujocajas = new  ArrayList<DetalleCuentaFlujoCaja>();
		  		  
        try {
			DetalleCuentaFlujoCajaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detallecuentaflujocajas=detallecuentaflujocajaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarDetalleCuentaFlujoCaja(detallecuentaflujocajas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetalleCuentaFlujoCajaConstantesFunciones.refrescarForeignKeysDescripcionesDetalleCuentaFlujoCaja(this.detallecuentaflujocajas);
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
		detallecuentaflujocajas = new  ArrayList<DetalleCuentaFlujoCaja>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleCuentaFlujoCaja.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			DetalleCuentaFlujoCajaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detallecuentaflujocajas=detallecuentaflujocajaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarDetalleCuentaFlujoCaja(detallecuentaflujocajas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetalleCuentaFlujoCajaConstantesFunciones.refrescarForeignKeysDescripcionesDetalleCuentaFlujoCaja(this.detallecuentaflujocajas);
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
		detallecuentaflujocajas = new  ArrayList<DetalleCuentaFlujoCaja>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			DetalleCuentaFlujoCajaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detallecuentaflujocajas=detallecuentaflujocajaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarDetalleCuentaFlujoCaja(detallecuentaflujocajas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetalleCuentaFlujoCajaConstantesFunciones.refrescarForeignKeysDescripcionesDetalleCuentaFlujoCaja(this.detallecuentaflujocajas);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		detallecuentaflujocaja = new  DetalleCuentaFlujoCaja();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleCuentaFlujoCaja.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			DetalleCuentaFlujoCajaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detallecuentaflujocaja=detallecuentaflujocajaDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarDetalleCuentaFlujoCaja(detallecuentaflujocaja);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetalleCuentaFlujoCajaConstantesFunciones.refrescarForeignKeysDescripcionesDetalleCuentaFlujoCaja(this.detallecuentaflujocaja);
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
		detallecuentaflujocaja = new  DetalleCuentaFlujoCaja();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			DetalleCuentaFlujoCajaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detallecuentaflujocaja=detallecuentaflujocajaDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarDetalleCuentaFlujoCaja(detallecuentaflujocaja);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetalleCuentaFlujoCajaConstantesFunciones.refrescarForeignKeysDescripcionesDetalleCuentaFlujoCaja(this.detallecuentaflujocaja);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		detallecuentaflujocajas = new  ArrayList<DetalleCuentaFlujoCaja>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleCuentaFlujoCaja.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			DetalleCuentaFlujoCajaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detallecuentaflujocajas=detallecuentaflujocajaDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarDetalleCuentaFlujoCaja(detallecuentaflujocajas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetalleCuentaFlujoCajaConstantesFunciones.refrescarForeignKeysDescripcionesDetalleCuentaFlujoCaja(this.detallecuentaflujocajas);
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
		detallecuentaflujocajas = new  ArrayList<DetalleCuentaFlujoCaja>();
		  		  
        try {
			DetalleCuentaFlujoCajaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detallecuentaflujocajas=detallecuentaflujocajaDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarDetalleCuentaFlujoCaja(detallecuentaflujocajas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetalleCuentaFlujoCajaConstantesFunciones.refrescarForeignKeysDescripcionesDetalleCuentaFlujoCaja(this.detallecuentaflujocajas);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosDetalleCuentaFlujoCajasWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		detallecuentaflujocajas = new  ArrayList<DetalleCuentaFlujoCaja>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleCuentaFlujoCaja.class.getSimpleName()+"-getTodosDetalleCuentaFlujoCajasWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			DetalleCuentaFlujoCajaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detallecuentaflujocajas=detallecuentaflujocajaDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarDetalleCuentaFlujoCaja(detallecuentaflujocajas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetalleCuentaFlujoCajaConstantesFunciones.refrescarForeignKeysDescripcionesDetalleCuentaFlujoCaja(this.detallecuentaflujocajas);
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
	
	public  void  getTodosDetalleCuentaFlujoCajas(String sFinalQuery,Pagination pagination)throws Exception {
		detallecuentaflujocajas = new  ArrayList<DetalleCuentaFlujoCaja>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			DetalleCuentaFlujoCajaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detallecuentaflujocajas=detallecuentaflujocajaDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarDetalleCuentaFlujoCaja(detallecuentaflujocajas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetalleCuentaFlujoCajaConstantesFunciones.refrescarForeignKeysDescripcionesDetalleCuentaFlujoCaja(this.detallecuentaflujocajas);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarDetalleCuentaFlujoCaja(DetalleCuentaFlujoCaja detallecuentaflujocaja) throws Exception {
		Boolean estaValidado=false;
		
		if(detallecuentaflujocaja.getIsNew() || detallecuentaflujocaja.getIsChanged()) { 
			this.invalidValues = detallecuentaflujocajaValidator.getInvalidValues(detallecuentaflujocaja);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(detallecuentaflujocaja);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarDetalleCuentaFlujoCaja(List<DetalleCuentaFlujoCaja> DetalleCuentaFlujoCajas) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(DetalleCuentaFlujoCaja detallecuentaflujocajaLocal:detallecuentaflujocajas) {				
			estaValidadoObjeto=this.validarGuardarDetalleCuentaFlujoCaja(detallecuentaflujocajaLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarDetalleCuentaFlujoCaja(List<DetalleCuentaFlujoCaja> DetalleCuentaFlujoCajas) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarDetalleCuentaFlujoCaja(detallecuentaflujocajas)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarDetalleCuentaFlujoCaja(DetalleCuentaFlujoCaja DetalleCuentaFlujoCaja) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarDetalleCuentaFlujoCaja(detallecuentaflujocaja)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(DetalleCuentaFlujoCaja detallecuentaflujocaja) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+detallecuentaflujocaja.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=DetalleCuentaFlujoCajaConstantesFunciones.getDetalleCuentaFlujoCajaLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"detallecuentaflujocaja","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(DetalleCuentaFlujoCajaConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(DetalleCuentaFlujoCajaConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveDetalleCuentaFlujoCajaWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleCuentaFlujoCaja.class.getSimpleName()+"-saveDetalleCuentaFlujoCajaWithConnection");connexion.begin();			
			
			DetalleCuentaFlujoCajaLogicAdditional.checkDetalleCuentaFlujoCajaToSave(this.detallecuentaflujocaja,this.datosCliente,connexion,this.arrDatoGeneral);
			
			DetalleCuentaFlujoCajaLogicAdditional.updateDetalleCuentaFlujoCajaToSave(this.detallecuentaflujocaja,this.arrDatoGeneral);
			
			DetalleCuentaFlujoCajaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.detallecuentaflujocaja,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowDetalleCuentaFlujoCaja();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarDetalleCuentaFlujoCaja(this.detallecuentaflujocaja)) {
				DetalleCuentaFlujoCajaDataAccess.save(this.detallecuentaflujocaja, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.detallecuentaflujocaja,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			DetalleCuentaFlujoCajaLogicAdditional.checkDetalleCuentaFlujoCajaToSaveAfter(this.detallecuentaflujocaja,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowDetalleCuentaFlujoCaja();
			
			connexion.commit();			
			
			if(this.detallecuentaflujocaja.getIsDeleted()) {
				this.detallecuentaflujocaja=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveDetalleCuentaFlujoCaja()throws Exception {	
		try {	
			
			DetalleCuentaFlujoCajaLogicAdditional.checkDetalleCuentaFlujoCajaToSave(this.detallecuentaflujocaja,this.datosCliente,connexion,this.arrDatoGeneral);
			
			DetalleCuentaFlujoCajaLogicAdditional.updateDetalleCuentaFlujoCajaToSave(this.detallecuentaflujocaja,this.arrDatoGeneral);
			
			DetalleCuentaFlujoCajaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.detallecuentaflujocaja,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarDetalleCuentaFlujoCaja(this.detallecuentaflujocaja)) {			
				DetalleCuentaFlujoCajaDataAccess.save(this.detallecuentaflujocaja, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.detallecuentaflujocaja,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			DetalleCuentaFlujoCajaLogicAdditional.checkDetalleCuentaFlujoCajaToSaveAfter(this.detallecuentaflujocaja,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.detallecuentaflujocaja.getIsDeleted()) {
				this.detallecuentaflujocaja=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveDetalleCuentaFlujoCajasWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleCuentaFlujoCaja.class.getSimpleName()+"-saveDetalleCuentaFlujoCajasWithConnection");connexion.begin();			
			
			DetalleCuentaFlujoCajaLogicAdditional.checkDetalleCuentaFlujoCajaToSaves(detallecuentaflujocajas,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowDetalleCuentaFlujoCajas();
			
			Boolean validadoTodosDetalleCuentaFlujoCaja=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(DetalleCuentaFlujoCaja detallecuentaflujocajaLocal:detallecuentaflujocajas) {		
				if(detallecuentaflujocajaLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				DetalleCuentaFlujoCajaLogicAdditional.updateDetalleCuentaFlujoCajaToSave(detallecuentaflujocajaLocal,this.arrDatoGeneral);
	        	
				DetalleCuentaFlujoCajaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),detallecuentaflujocajaLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarDetalleCuentaFlujoCaja(detallecuentaflujocajaLocal)) {
					DetalleCuentaFlujoCajaDataAccess.save(detallecuentaflujocajaLocal, connexion);				
				} else {
					validadoTodosDetalleCuentaFlujoCaja=false;
				}
			}
			
			if(!validadoTodosDetalleCuentaFlujoCaja) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			DetalleCuentaFlujoCajaLogicAdditional.checkDetalleCuentaFlujoCajaToSavesAfter(detallecuentaflujocajas,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowDetalleCuentaFlujoCajas();
			
			connexion.commit();		
			
			this.quitarDetalleCuentaFlujoCajasEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveDetalleCuentaFlujoCajas()throws Exception {				
		 try {	
			DetalleCuentaFlujoCajaLogicAdditional.checkDetalleCuentaFlujoCajaToSaves(detallecuentaflujocajas,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosDetalleCuentaFlujoCaja=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(DetalleCuentaFlujoCaja detallecuentaflujocajaLocal:detallecuentaflujocajas) {				
				if(detallecuentaflujocajaLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				DetalleCuentaFlujoCajaLogicAdditional.updateDetalleCuentaFlujoCajaToSave(detallecuentaflujocajaLocal,this.arrDatoGeneral);
	        	
				DetalleCuentaFlujoCajaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),detallecuentaflujocajaLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarDetalleCuentaFlujoCaja(detallecuentaflujocajaLocal)) {				
					DetalleCuentaFlujoCajaDataAccess.save(detallecuentaflujocajaLocal, connexion);				
				} else {
					validadoTodosDetalleCuentaFlujoCaja=false;
				}
			}
			
			if(!validadoTodosDetalleCuentaFlujoCaja) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			DetalleCuentaFlujoCajaLogicAdditional.checkDetalleCuentaFlujoCajaToSavesAfter(detallecuentaflujocajas,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarDetalleCuentaFlujoCajasEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public DetalleCuentaFlujoCajaParameterReturnGeneral procesarAccionDetalleCuentaFlujoCajas(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<DetalleCuentaFlujoCaja> detallecuentaflujocajas,DetalleCuentaFlujoCajaParameterReturnGeneral detallecuentaflujocajaParameterGeneral)throws Exception {
		 try {	
			DetalleCuentaFlujoCajaParameterReturnGeneral detallecuentaflujocajaReturnGeneral=new DetalleCuentaFlujoCajaParameterReturnGeneral();
	
			DetalleCuentaFlujoCajaLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,detallecuentaflujocajas,detallecuentaflujocajaParameterGeneral,detallecuentaflujocajaReturnGeneral);
			
			return detallecuentaflujocajaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public DetalleCuentaFlujoCajaParameterReturnGeneral procesarAccionDetalleCuentaFlujoCajasWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<DetalleCuentaFlujoCaja> detallecuentaflujocajas,DetalleCuentaFlujoCajaParameterReturnGeneral detallecuentaflujocajaParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleCuentaFlujoCaja.class.getSimpleName()+"-procesarAccionDetalleCuentaFlujoCajasWithConnection");connexion.begin();			
			
			DetalleCuentaFlujoCajaParameterReturnGeneral detallecuentaflujocajaReturnGeneral=new DetalleCuentaFlujoCajaParameterReturnGeneral();
	
			DetalleCuentaFlujoCajaLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,detallecuentaflujocajas,detallecuentaflujocajaParameterGeneral,detallecuentaflujocajaReturnGeneral);
			
			this.connexion.commit();
			
			return detallecuentaflujocajaReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public DetalleCuentaFlujoCajaParameterReturnGeneral procesarEventosDetalleCuentaFlujoCajas(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<DetalleCuentaFlujoCaja> detallecuentaflujocajas,DetalleCuentaFlujoCaja detallecuentaflujocaja,DetalleCuentaFlujoCajaParameterReturnGeneral detallecuentaflujocajaParameterGeneral,Boolean isEsNuevoDetalleCuentaFlujoCaja,ArrayList<Classe> clases)throws Exception {
		 try {	
			DetalleCuentaFlujoCajaParameterReturnGeneral detallecuentaflujocajaReturnGeneral=new DetalleCuentaFlujoCajaParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				detallecuentaflujocajaReturnGeneral.setConRecargarPropiedades(true);
			}
			
			DetalleCuentaFlujoCajaLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,detallecuentaflujocajas,detallecuentaflujocaja,detallecuentaflujocajaParameterGeneral,detallecuentaflujocajaReturnGeneral,isEsNuevoDetalleCuentaFlujoCaja,clases);
			
			return detallecuentaflujocajaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public DetalleCuentaFlujoCajaParameterReturnGeneral procesarEventosDetalleCuentaFlujoCajasWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<DetalleCuentaFlujoCaja> detallecuentaflujocajas,DetalleCuentaFlujoCaja detallecuentaflujocaja,DetalleCuentaFlujoCajaParameterReturnGeneral detallecuentaflujocajaParameterGeneral,Boolean isEsNuevoDetalleCuentaFlujoCaja,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleCuentaFlujoCaja.class.getSimpleName()+"-procesarEventosDetalleCuentaFlujoCajasWithConnection");connexion.begin();			
			
			DetalleCuentaFlujoCajaParameterReturnGeneral detallecuentaflujocajaReturnGeneral=new DetalleCuentaFlujoCajaParameterReturnGeneral();
	
			detallecuentaflujocajaReturnGeneral.setDetalleCuentaFlujoCaja(detallecuentaflujocaja);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				detallecuentaflujocajaReturnGeneral.setConRecargarPropiedades(true);
			}
			
			DetalleCuentaFlujoCajaLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,detallecuentaflujocajas,detallecuentaflujocaja,detallecuentaflujocajaParameterGeneral,detallecuentaflujocajaReturnGeneral,isEsNuevoDetalleCuentaFlujoCaja,clases);
			
			this.connexion.commit();
			
			return detallecuentaflujocajaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public DetalleCuentaFlujoCajaParameterReturnGeneral procesarImportacionDetalleCuentaFlujoCajasWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,DetalleCuentaFlujoCajaParameterReturnGeneral detallecuentaflujocajaParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleCuentaFlujoCaja.class.getSimpleName()+"-procesarImportacionDetalleCuentaFlujoCajasWithConnection");connexion.begin();			
			
			DetalleCuentaFlujoCajaParameterReturnGeneral detallecuentaflujocajaReturnGeneral=new DetalleCuentaFlujoCajaParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.detallecuentaflujocajas=new ArrayList<DetalleCuentaFlujoCaja>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.detallecuentaflujocaja=new DetalleCuentaFlujoCaja();
				
				
				if(conColumnasBase) {this.detallecuentaflujocaja.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.detallecuentaflujocaja.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.detallecuentaflujocaja.setesta_activo(Boolean.parseBoolean(arrColumnas[iColumn++]));
				
				this.detallecuentaflujocajas.add(this.detallecuentaflujocaja);
			}
			
			this.saveDetalleCuentaFlujoCajas();
			
			this.connexion.commit();
			
			detallecuentaflujocajaReturnGeneral.setConRetornoEstaProcesado(true);
			detallecuentaflujocajaReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return detallecuentaflujocajaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarDetalleCuentaFlujoCajasEliminados() throws Exception {				
		
		List<DetalleCuentaFlujoCaja> detallecuentaflujocajasAux= new ArrayList<DetalleCuentaFlujoCaja>();
		
		for(DetalleCuentaFlujoCaja detallecuentaflujocaja:detallecuentaflujocajas) {
			if(!detallecuentaflujocaja.getIsDeleted()) {
				detallecuentaflujocajasAux.add(detallecuentaflujocaja);
			}
		}
		
		detallecuentaflujocajas=detallecuentaflujocajasAux;
	}
	
	public void quitarDetalleCuentaFlujoCajasNulos() throws Exception {				
		
		List<DetalleCuentaFlujoCaja> detallecuentaflujocajasAux= new ArrayList<DetalleCuentaFlujoCaja>();
		
		for(DetalleCuentaFlujoCaja detallecuentaflujocaja : this.detallecuentaflujocajas) {
			if(detallecuentaflujocaja==null) {
				detallecuentaflujocajasAux.add(detallecuentaflujocaja);
			}
		}
		
		//this.detallecuentaflujocajas=detallecuentaflujocajasAux;
		
		this.detallecuentaflujocajas.removeAll(detallecuentaflujocajasAux);
	}
	
	public void getSetVersionRowDetalleCuentaFlujoCajaWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(detallecuentaflujocaja.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((detallecuentaflujocaja.getIsDeleted() || (detallecuentaflujocaja.getIsChanged()&&!detallecuentaflujocaja.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=detallecuentaflujocajaDataAccess.getSetVersionRowDetalleCuentaFlujoCaja(connexion,detallecuentaflujocaja.getId());
				
				if(!detallecuentaflujocaja.getVersionRow().equals(timestamp)) {	
					detallecuentaflujocaja.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				detallecuentaflujocaja.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowDetalleCuentaFlujoCaja()throws Exception {	
		
		if(detallecuentaflujocaja.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((detallecuentaflujocaja.getIsDeleted() || (detallecuentaflujocaja.getIsChanged()&&!detallecuentaflujocaja.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=detallecuentaflujocajaDataAccess.getSetVersionRowDetalleCuentaFlujoCaja(connexion,detallecuentaflujocaja.getId());
			
			try {							
				if(!detallecuentaflujocaja.getVersionRow().equals(timestamp)) {	
					detallecuentaflujocaja.setVersionRow(timestamp);
				}
				
				detallecuentaflujocaja.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowDetalleCuentaFlujoCajasWithConnection()throws Exception {	
		if(detallecuentaflujocajas!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(DetalleCuentaFlujoCaja detallecuentaflujocajaAux:detallecuentaflujocajas) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(detallecuentaflujocajaAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(detallecuentaflujocajaAux.getIsDeleted() || (detallecuentaflujocajaAux.getIsChanged()&&!detallecuentaflujocajaAux.getIsNew())) {
						
						timestamp=detallecuentaflujocajaDataAccess.getSetVersionRowDetalleCuentaFlujoCaja(connexion,detallecuentaflujocajaAux.getId());
						
						if(!detallecuentaflujocaja.getVersionRow().equals(timestamp)) {	
							detallecuentaflujocajaAux.setVersionRow(timestamp);
						}
								
						detallecuentaflujocajaAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowDetalleCuentaFlujoCajas()throws Exception {	
		if(detallecuentaflujocajas!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(DetalleCuentaFlujoCaja detallecuentaflujocajaAux:detallecuentaflujocajas) {
					if(detallecuentaflujocajaAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(detallecuentaflujocajaAux.getIsDeleted() || (detallecuentaflujocajaAux.getIsChanged()&&!detallecuentaflujocajaAux.getIsNew())) {
						
						timestamp=detallecuentaflujocajaDataAccess.getSetVersionRowDetalleCuentaFlujoCaja(connexion,detallecuentaflujocajaAux.getId());
						
						if(!detallecuentaflujocajaAux.getVersionRow().equals(timestamp)) {	
							detallecuentaflujocajaAux.setVersionRow(timestamp);
						}
						
													
						detallecuentaflujocajaAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public DetalleCuentaFlujoCajaParameterReturnGeneral cargarCombosLoteForeignKeyDetalleCuentaFlujoCajaWithConnection(String finalQueryGlobalTipoOperacion,String finalQueryGlobalCuentaFlujoCaja,String finalQueryGlobalCuentaContable) throws Exception {
		DetalleCuentaFlujoCajaParameterReturnGeneral  detallecuentaflujocajaReturnGeneral =new DetalleCuentaFlujoCajaParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleCuentaFlujoCaja.class.getSimpleName()+"-cargarCombosLoteForeignKeyDetalleCuentaFlujoCajaWithConnection");connexion.begin();
			
			detallecuentaflujocajaReturnGeneral =new DetalleCuentaFlujoCajaParameterReturnGeneral();
			
			

			List<TipoOperacion> tipooperacionsForeignKey=new ArrayList<TipoOperacion>();
			TipoOperacionLogic tipooperacionLogic=new TipoOperacionLogic();
			tipooperacionLogic.setConnexion(this.connexion);
			tipooperacionLogic.getTipoOperacionDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoOperacion.equals("NONE")) {
				tipooperacionLogic.getTodosTipoOperacions(finalQueryGlobalTipoOperacion,new Pagination());
				tipooperacionsForeignKey=tipooperacionLogic.getTipoOperacions();
			}

			detallecuentaflujocajaReturnGeneral.settipooperacionsForeignKey(tipooperacionsForeignKey);


			List<CuentaFlujoCaja> cuentaflujocajasForeignKey=new ArrayList<CuentaFlujoCaja>();
			CuentaFlujoCajaLogic cuentaflujocajaLogic=new CuentaFlujoCajaLogic();
			cuentaflujocajaLogic.setConnexion(this.connexion);
			cuentaflujocajaLogic.getCuentaFlujoCajaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCuentaFlujoCaja.equals("NONE")) {
				cuentaflujocajaLogic.getTodosCuentaFlujoCajas(finalQueryGlobalCuentaFlujoCaja,new Pagination());
				cuentaflujocajasForeignKey=cuentaflujocajaLogic.getCuentaFlujoCajas();
			}

			detallecuentaflujocajaReturnGeneral.setcuentaflujocajasForeignKey(cuentaflujocajasForeignKey);


			List<CuentaContable> cuentacontablesForeignKey=new ArrayList<CuentaContable>();
			CuentaContableLogic cuentacontableLogic=new CuentaContableLogic();
			cuentacontableLogic.setConnexion(this.connexion);
			cuentacontableLogic.getCuentaContableDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCuentaContable.equals("NONE")) {
				cuentacontableLogic.getTodosCuentaContables(finalQueryGlobalCuentaContable,new Pagination());
				cuentacontablesForeignKey=cuentacontableLogic.getCuentaContables();
			}

			detallecuentaflujocajaReturnGeneral.setcuentacontablesForeignKey(cuentacontablesForeignKey);

			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
		
		return detallecuentaflujocajaReturnGeneral;
	}
	
	public DetalleCuentaFlujoCajaParameterReturnGeneral cargarCombosLoteForeignKeyDetalleCuentaFlujoCaja(String finalQueryGlobalTipoOperacion,String finalQueryGlobalCuentaFlujoCaja,String finalQueryGlobalCuentaContable) throws Exception {
		DetalleCuentaFlujoCajaParameterReturnGeneral  detallecuentaflujocajaReturnGeneral =new DetalleCuentaFlujoCajaParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {						
			detallecuentaflujocajaReturnGeneral =new DetalleCuentaFlujoCajaParameterReturnGeneral();
			
			

			List<TipoOperacion> tipooperacionsForeignKey=new ArrayList<TipoOperacion>();
			TipoOperacionLogic tipooperacionLogic=new TipoOperacionLogic();
			tipooperacionLogic.setConnexion(this.connexion);
			tipooperacionLogic.getTipoOperacionDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoOperacion.equals("NONE")) {
				tipooperacionLogic.getTodosTipoOperacions(finalQueryGlobalTipoOperacion,new Pagination());
				tipooperacionsForeignKey=tipooperacionLogic.getTipoOperacions();
			}

			detallecuentaflujocajaReturnGeneral.settipooperacionsForeignKey(tipooperacionsForeignKey);


			List<CuentaFlujoCaja> cuentaflujocajasForeignKey=new ArrayList<CuentaFlujoCaja>();
			CuentaFlujoCajaLogic cuentaflujocajaLogic=new CuentaFlujoCajaLogic();
			cuentaflujocajaLogic.setConnexion(this.connexion);
			cuentaflujocajaLogic.getCuentaFlujoCajaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCuentaFlujoCaja.equals("NONE")) {
				cuentaflujocajaLogic.getTodosCuentaFlujoCajas(finalQueryGlobalCuentaFlujoCaja,new Pagination());
				cuentaflujocajasForeignKey=cuentaflujocajaLogic.getCuentaFlujoCajas();
			}

			detallecuentaflujocajaReturnGeneral.setcuentaflujocajasForeignKey(cuentaflujocajasForeignKey);


			List<CuentaContable> cuentacontablesForeignKey=new ArrayList<CuentaContable>();
			CuentaContableLogic cuentacontableLogic=new CuentaContableLogic();
			cuentacontableLogic.setConnexion(this.connexion);
			cuentacontableLogic.getCuentaContableDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCuentaContable.equals("NONE")) {
				cuentacontableLogic.getTodosCuentaContables(finalQueryGlobalCuentaContable,new Pagination());
				cuentacontablesForeignKey=cuentacontableLogic.getCuentaContables();
			}

			detallecuentaflujocajaReturnGeneral.setcuentacontablesForeignKey(cuentacontablesForeignKey);
						
			
		} catch(Exception e) {			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			
		}
		
		return detallecuentaflujocajaReturnGeneral;
	}
	
	
	public void deepLoad(DetalleCuentaFlujoCaja detallecuentaflujocaja,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			DetalleCuentaFlujoCajaLogicAdditional.updateDetalleCuentaFlujoCajaToGet(detallecuentaflujocaja,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		detallecuentaflujocaja.setTipoOperacion(detallecuentaflujocajaDataAccess.getTipoOperacion(connexion,detallecuentaflujocaja));
		detallecuentaflujocaja.setCuentaFlujoCaja(detallecuentaflujocajaDataAccess.getCuentaFlujoCaja(connexion,detallecuentaflujocaja));
		detallecuentaflujocaja.setCuentaContable(detallecuentaflujocajaDataAccess.getCuentaContable(connexion,detallecuentaflujocaja));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(TipoOperacion.class)) {
				detallecuentaflujocaja.setTipoOperacion(detallecuentaflujocajaDataAccess.getTipoOperacion(connexion,detallecuentaflujocaja));
				continue;
			}

			if(clas.clas.equals(CuentaFlujoCaja.class)) {
				detallecuentaflujocaja.setCuentaFlujoCaja(detallecuentaflujocajaDataAccess.getCuentaFlujoCaja(connexion,detallecuentaflujocaja));
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				detallecuentaflujocaja.setCuentaContable(detallecuentaflujocajaDataAccess.getCuentaContable(connexion,detallecuentaflujocaja));
				continue;
			}
		}
	}
	else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(TipoOperacion.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detallecuentaflujocaja.setTipoOperacion(detallecuentaflujocajaDataAccess.getTipoOperacion(connexion,detallecuentaflujocaja));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(CuentaFlujoCaja.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detallecuentaflujocaja.setCuentaFlujoCaja(detallecuentaflujocajaDataAccess.getCuentaFlujoCaja(connexion,detallecuentaflujocaja));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(CuentaContable.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detallecuentaflujocaja.setCuentaContable(detallecuentaflujocajaDataAccess.getCuentaContable(connexion,detallecuentaflujocaja));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		detallecuentaflujocaja.setTipoOperacion(detallecuentaflujocajaDataAccess.getTipoOperacion(connexion,detallecuentaflujocaja));
		TipoOperacionLogic tipooperacionLogic= new TipoOperacionLogic(connexion);
		tipooperacionLogic.deepLoad(detallecuentaflujocaja.getTipoOperacion(),isDeep,deepLoadType,clases);
				
		detallecuentaflujocaja.setCuentaFlujoCaja(detallecuentaflujocajaDataAccess.getCuentaFlujoCaja(connexion,detallecuentaflujocaja));
		CuentaFlujoCajaLogic cuentaflujocajaLogic= new CuentaFlujoCajaLogic(connexion);
		cuentaflujocajaLogic.deepLoad(detallecuentaflujocaja.getCuentaFlujoCaja(),isDeep,deepLoadType,clases);
				
		detallecuentaflujocaja.setCuentaContable(detallecuentaflujocajaDataAccess.getCuentaContable(connexion,detallecuentaflujocaja));
		CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
		cuentacontableLogic.deepLoad(detallecuentaflujocaja.getCuentaContable(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(TipoOperacion.class)) {
				detallecuentaflujocaja.setTipoOperacion(detallecuentaflujocajaDataAccess.getTipoOperacion(connexion,detallecuentaflujocaja));
				TipoOperacionLogic tipooperacionLogic= new TipoOperacionLogic(connexion);
				tipooperacionLogic.deepLoad(detallecuentaflujocaja.getTipoOperacion(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(CuentaFlujoCaja.class)) {
				detallecuentaflujocaja.setCuentaFlujoCaja(detallecuentaflujocajaDataAccess.getCuentaFlujoCaja(connexion,detallecuentaflujocaja));
				CuentaFlujoCajaLogic cuentaflujocajaLogic= new CuentaFlujoCajaLogic(connexion);
				cuentaflujocajaLogic.deepLoad(detallecuentaflujocaja.getCuentaFlujoCaja(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				detallecuentaflujocaja.setCuentaContable(detallecuentaflujocajaDataAccess.getCuentaContable(connexion,detallecuentaflujocaja));
				CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
				cuentacontableLogic.deepLoad(detallecuentaflujocaja.getCuentaContable(),isDeep,deepLoadType,clases);				
				continue;
			}

		}
	}
	else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {


		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(TipoOperacion.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detallecuentaflujocaja.setTipoOperacion(detallecuentaflujocajaDataAccess.getTipoOperacion(connexion,detallecuentaflujocaja));
			TipoOperacionLogic tipooperacionLogic= new TipoOperacionLogic(connexion);
			tipooperacionLogic.deepLoad(detallecuentaflujocaja.getTipoOperacion(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(CuentaFlujoCaja.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detallecuentaflujocaja.setCuentaFlujoCaja(detallecuentaflujocajaDataAccess.getCuentaFlujoCaja(connexion,detallecuentaflujocaja));
			CuentaFlujoCajaLogic cuentaflujocajaLogic= new CuentaFlujoCajaLogic(connexion);
			cuentaflujocajaLogic.deepLoad(detallecuentaflujocaja.getCuentaFlujoCaja(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(CuentaContable.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detallecuentaflujocaja.setCuentaContable(detallecuentaflujocajaDataAccess.getCuentaContable(connexion,detallecuentaflujocaja));
			CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
			cuentacontableLogic.deepLoad(detallecuentaflujocaja.getCuentaContable(),isDeep,deepLoadType,clases);
				
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(DetalleCuentaFlujoCaja detallecuentaflujocaja,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			DetalleCuentaFlujoCajaLogicAdditional.updateDetalleCuentaFlujoCajaToSave(detallecuentaflujocaja,this.arrDatoGeneral);
			
DetalleCuentaFlujoCajaDataAccess.save(detallecuentaflujocaja, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		TipoOperacionDataAccess.save(detallecuentaflujocaja.getTipoOperacion(),connexion);

		CuentaFlujoCajaDataAccess.save(detallecuentaflujocaja.getCuentaFlujoCaja(),connexion);

		CuentaContableDataAccess.save(detallecuentaflujocaja.getCuentaContable(),connexion);
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(TipoOperacion.class)) {
				TipoOperacionDataAccess.save(detallecuentaflujocaja.getTipoOperacion(),connexion);
				continue;
			}

			if(clas.clas.equals(CuentaFlujoCaja.class)) {
				CuentaFlujoCajaDataAccess.save(detallecuentaflujocaja.getCuentaFlujoCaja(),connexion);
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				CuentaContableDataAccess.save(detallecuentaflujocaja.getCuentaContable(),connexion);
				continue;
			}

		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		TipoOperacionDataAccess.save(detallecuentaflujocaja.getTipoOperacion(),connexion);
		TipoOperacionLogic tipooperacionLogic= new TipoOperacionLogic(connexion);
		tipooperacionLogic.deepLoad(detallecuentaflujocaja.getTipoOperacion(),isDeep,deepLoadType,clases);
				

		CuentaFlujoCajaDataAccess.save(detallecuentaflujocaja.getCuentaFlujoCaja(),connexion);
		CuentaFlujoCajaLogic cuentaflujocajaLogic= new CuentaFlujoCajaLogic(connexion);
		cuentaflujocajaLogic.deepLoad(detallecuentaflujocaja.getCuentaFlujoCaja(),isDeep,deepLoadType,clases);
				

		CuentaContableDataAccess.save(detallecuentaflujocaja.getCuentaContable(),connexion);
		CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
		cuentacontableLogic.deepLoad(detallecuentaflujocaja.getCuentaContable(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(TipoOperacion.class)) {
				TipoOperacionDataAccess.save(detallecuentaflujocaja.getTipoOperacion(),connexion);
				TipoOperacionLogic tipooperacionLogic= new TipoOperacionLogic(connexion);
				tipooperacionLogic.deepSave(detallecuentaflujocaja.getTipoOperacion(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(CuentaFlujoCaja.class)) {
				CuentaFlujoCajaDataAccess.save(detallecuentaflujocaja.getCuentaFlujoCaja(),connexion);
				CuentaFlujoCajaLogic cuentaflujocajaLogic= new CuentaFlujoCajaLogic(connexion);
				cuentaflujocajaLogic.deepSave(detallecuentaflujocaja.getCuentaFlujoCaja(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				CuentaContableDataAccess.save(detallecuentaflujocaja.getCuentaContable(),connexion);
				CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
				cuentacontableLogic.deepSave(detallecuentaflujocaja.getCuentaContable(),isDeep,deepLoadType,clases);				
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
			this.getNewConnexionToDeep(DetalleCuentaFlujoCaja.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(detallecuentaflujocaja,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				DetalleCuentaFlujoCajaConstantesFunciones.refrescarForeignKeysDescripcionesDetalleCuentaFlujoCaja(detallecuentaflujocaja);
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
			this.deepLoad(this.detallecuentaflujocaja,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				DetalleCuentaFlujoCajaConstantesFunciones.refrescarForeignKeysDescripcionesDetalleCuentaFlujoCaja(this.detallecuentaflujocaja);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(DetalleCuentaFlujoCaja.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(detallecuentaflujocajas!=null) {
				for(DetalleCuentaFlujoCaja detallecuentaflujocaja:detallecuentaflujocajas) {
					this.deepLoad(detallecuentaflujocaja,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					DetalleCuentaFlujoCajaConstantesFunciones.refrescarForeignKeysDescripcionesDetalleCuentaFlujoCaja(detallecuentaflujocajas);
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
			if(detallecuentaflujocajas!=null) {
				for(DetalleCuentaFlujoCaja detallecuentaflujocaja:detallecuentaflujocajas) {
					this.deepLoad(detallecuentaflujocaja,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					DetalleCuentaFlujoCajaConstantesFunciones.refrescarForeignKeysDescripcionesDetalleCuentaFlujoCaja(detallecuentaflujocajas);
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
			this.getNewConnexionToDeep(DetalleCuentaFlujoCaja.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(detallecuentaflujocaja,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(DetalleCuentaFlujoCaja.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(detallecuentaflujocajas!=null) {
				for(DetalleCuentaFlujoCaja detallecuentaflujocaja:detallecuentaflujocajas) {
					this.deepSave(detallecuentaflujocaja,isDeep,deepLoadType,clases);
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
			if(detallecuentaflujocajas!=null) {
				for(DetalleCuentaFlujoCaja detallecuentaflujocaja:detallecuentaflujocajas) {
					this.deepSave(detallecuentaflujocaja,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getDetalleCuentaFlujoCajasFK_IdCuentaContableWithConnection(String sFinalQuery,Pagination pagination,Long id_cuenta_contable)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleCuentaFlujoCaja.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCuentaContable= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCuentaContable.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cuenta_contable,DetalleCuentaFlujoCajaConstantesFunciones.IDCUENTACONTABLE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCuentaContable);

			DetalleCuentaFlujoCajaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCuentaContable","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detallecuentaflujocajas=detallecuentaflujocajaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleCuentaFlujoCajaConstantesFunciones.refrescarForeignKeysDescripcionesDetalleCuentaFlujoCaja(this.detallecuentaflujocajas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getDetalleCuentaFlujoCajasFK_IdCuentaContable(String sFinalQuery,Pagination pagination,Long id_cuenta_contable)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCuentaContable= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCuentaContable.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cuenta_contable,DetalleCuentaFlujoCajaConstantesFunciones.IDCUENTACONTABLE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCuentaContable);

			DetalleCuentaFlujoCajaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCuentaContable","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detallecuentaflujocajas=detallecuentaflujocajaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleCuentaFlujoCajaConstantesFunciones.refrescarForeignKeysDescripcionesDetalleCuentaFlujoCaja(this.detallecuentaflujocajas);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getDetalleCuentaFlujoCajasFK_IdCuentaFlujoCajaWithConnection(String sFinalQuery,Pagination pagination,Long id_cuenta_flujo_caja)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleCuentaFlujoCaja.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCuentaFlujoCaja= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCuentaFlujoCaja.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cuenta_flujo_caja,DetalleCuentaFlujoCajaConstantesFunciones.IDCUENTAFLUJOCAJA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCuentaFlujoCaja);

			DetalleCuentaFlujoCajaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCuentaFlujoCaja","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detallecuentaflujocajas=detallecuentaflujocajaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleCuentaFlujoCajaConstantesFunciones.refrescarForeignKeysDescripcionesDetalleCuentaFlujoCaja(this.detallecuentaflujocajas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getDetalleCuentaFlujoCajasFK_IdCuentaFlujoCaja(String sFinalQuery,Pagination pagination,Long id_cuenta_flujo_caja)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCuentaFlujoCaja= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCuentaFlujoCaja.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cuenta_flujo_caja,DetalleCuentaFlujoCajaConstantesFunciones.IDCUENTAFLUJOCAJA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCuentaFlujoCaja);

			DetalleCuentaFlujoCajaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCuentaFlujoCaja","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detallecuentaflujocajas=detallecuentaflujocajaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleCuentaFlujoCajaConstantesFunciones.refrescarForeignKeysDescripcionesDetalleCuentaFlujoCaja(this.detallecuentaflujocajas);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getDetalleCuentaFlujoCajasFK_IdTipoOperacionWithConnection(String sFinalQuery,Pagination pagination,Long id_tipo_operacion)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleCuentaFlujoCaja.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoOperacion= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoOperacion.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_operacion,DetalleCuentaFlujoCajaConstantesFunciones.IDTIPOOPERACION,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoOperacion);

			DetalleCuentaFlujoCajaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoOperacion","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detallecuentaflujocajas=detallecuentaflujocajaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleCuentaFlujoCajaConstantesFunciones.refrescarForeignKeysDescripcionesDetalleCuentaFlujoCaja(this.detallecuentaflujocajas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getDetalleCuentaFlujoCajasFK_IdTipoOperacion(String sFinalQuery,Pagination pagination,Long id_tipo_operacion)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoOperacion= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoOperacion.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_operacion,DetalleCuentaFlujoCajaConstantesFunciones.IDTIPOOPERACION,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoOperacion);

			DetalleCuentaFlujoCajaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoOperacion","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detallecuentaflujocajas=detallecuentaflujocajaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleCuentaFlujoCajaConstantesFunciones.refrescarForeignKeysDescripcionesDetalleCuentaFlujoCaja(this.detallecuentaflujocajas);
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
			if(DetalleCuentaFlujoCajaConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,DetalleCuentaFlujoCajaDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,DetalleCuentaFlujoCaja detallecuentaflujocaja,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(DetalleCuentaFlujoCajaConstantesFunciones.ISCONAUDITORIA) {
				if(detallecuentaflujocaja.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,DetalleCuentaFlujoCajaDataAccess.TABLENAME, detallecuentaflujocaja.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(DetalleCuentaFlujoCajaConstantesFunciones.ISCONAUDITORIADETALLE) {
						////DetalleCuentaFlujoCajaLogic.registrarAuditoriaDetallesDetalleCuentaFlujoCaja(connexion,detallecuentaflujocaja,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(detallecuentaflujocaja.getIsDeleted()) {
					/*if(!detallecuentaflujocaja.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,DetalleCuentaFlujoCajaDataAccess.TABLENAME, detallecuentaflujocaja.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////DetalleCuentaFlujoCajaLogic.registrarAuditoriaDetallesDetalleCuentaFlujoCaja(connexion,detallecuentaflujocaja,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,DetalleCuentaFlujoCajaDataAccess.TABLENAME, detallecuentaflujocaja.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(detallecuentaflujocaja.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,DetalleCuentaFlujoCajaDataAccess.TABLENAME, detallecuentaflujocaja.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(DetalleCuentaFlujoCajaConstantesFunciones.ISCONAUDITORIADETALLE) {
						////DetalleCuentaFlujoCajaLogic.registrarAuditoriaDetallesDetalleCuentaFlujoCaja(connexion,detallecuentaflujocaja,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesDetalleCuentaFlujoCaja(Connexion connexion,DetalleCuentaFlujoCaja detallecuentaflujocaja)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(detallecuentaflujocaja.getIsNew()||!detallecuentaflujocaja.getid_tipo_operacion().equals(detallecuentaflujocaja.getDetalleCuentaFlujoCajaOriginal().getid_tipo_operacion()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detallecuentaflujocaja.getDetalleCuentaFlujoCajaOriginal().getid_tipo_operacion()!=null)
				{
					strValorActual=detallecuentaflujocaja.getDetalleCuentaFlujoCajaOriginal().getid_tipo_operacion().toString();
				}
				if(detallecuentaflujocaja.getid_tipo_operacion()!=null)
				{
					strValorNuevo=detallecuentaflujocaja.getid_tipo_operacion().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleCuentaFlujoCajaConstantesFunciones.IDTIPOOPERACION,strValorActual,strValorNuevo);
			}	
			
			if(detallecuentaflujocaja.getIsNew()||!detallecuentaflujocaja.getid_cuenta_flujo_caja().equals(detallecuentaflujocaja.getDetalleCuentaFlujoCajaOriginal().getid_cuenta_flujo_caja()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detallecuentaflujocaja.getDetalleCuentaFlujoCajaOriginal().getid_cuenta_flujo_caja()!=null)
				{
					strValorActual=detallecuentaflujocaja.getDetalleCuentaFlujoCajaOriginal().getid_cuenta_flujo_caja().toString();
				}
				if(detallecuentaflujocaja.getid_cuenta_flujo_caja()!=null)
				{
					strValorNuevo=detallecuentaflujocaja.getid_cuenta_flujo_caja().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleCuentaFlujoCajaConstantesFunciones.IDCUENTAFLUJOCAJA,strValorActual,strValorNuevo);
			}	
			
			if(detallecuentaflujocaja.getIsNew()||!detallecuentaflujocaja.getid_cuenta_contable().equals(detallecuentaflujocaja.getDetalleCuentaFlujoCajaOriginal().getid_cuenta_contable()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detallecuentaflujocaja.getDetalleCuentaFlujoCajaOriginal().getid_cuenta_contable()!=null)
				{
					strValorActual=detallecuentaflujocaja.getDetalleCuentaFlujoCajaOriginal().getid_cuenta_contable().toString();
				}
				if(detallecuentaflujocaja.getid_cuenta_contable()!=null)
				{
					strValorNuevo=detallecuentaflujocaja.getid_cuenta_contable().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleCuentaFlujoCajaConstantesFunciones.IDCUENTACONTABLE,strValorActual,strValorNuevo);
			}	
			
			if(detallecuentaflujocaja.getIsNew()||!detallecuentaflujocaja.getesta_activo().equals(detallecuentaflujocaja.getDetalleCuentaFlujoCajaOriginal().getesta_activo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detallecuentaflujocaja.getDetalleCuentaFlujoCajaOriginal().getesta_activo()!=null)
				{
					strValorActual=detallecuentaflujocaja.getDetalleCuentaFlujoCajaOriginal().getesta_activo().toString();
				}
				if(detallecuentaflujocaja.getesta_activo()!=null)
				{
					strValorNuevo=detallecuentaflujocaja.getesta_activo().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleCuentaFlujoCajaConstantesFunciones.ESTAACTIVO,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void saveDetalleCuentaFlujoCajaRelacionesWithConnection(DetalleCuentaFlujoCaja detallecuentaflujocaja) throws Exception {

		if(!detallecuentaflujocaja.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveDetalleCuentaFlujoCajaRelacionesBase(detallecuentaflujocaja,true);
		}
	}

	public void saveDetalleCuentaFlujoCajaRelaciones(DetalleCuentaFlujoCaja detallecuentaflujocaja)throws Exception {

		if(!detallecuentaflujocaja.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveDetalleCuentaFlujoCajaRelacionesBase(detallecuentaflujocaja,false);
		}
	}

	public void saveDetalleCuentaFlujoCajaRelacionesBase(DetalleCuentaFlujoCaja detallecuentaflujocaja,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("DetalleCuentaFlujoCaja-saveRelacionesWithConnection");}
	

			this.setDetalleCuentaFlujoCaja(detallecuentaflujocaja);

			if(DetalleCuentaFlujoCajaLogicAdditional.validarSaveRelaciones(detallecuentaflujocaja,this)) {

				DetalleCuentaFlujoCajaLogicAdditional.updateRelacionesToSave(detallecuentaflujocaja,this);

				if((detallecuentaflujocaja.getIsNew()||detallecuentaflujocaja.getIsChanged())&&!detallecuentaflujocaja.getIsDeleted()) {
					this.saveDetalleCuentaFlujoCaja();
					this.saveDetalleCuentaFlujoCajaRelacionesDetalles();

				} else if(detallecuentaflujocaja.getIsDeleted()) {
					this.saveDetalleCuentaFlujoCajaRelacionesDetalles();
					this.saveDetalleCuentaFlujoCaja();
				}

				DetalleCuentaFlujoCajaLogicAdditional.updateRelacionesToSaveAfter(detallecuentaflujocaja,this);

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
	
	
	private void saveDetalleCuentaFlujoCajaRelacionesDetalles()throws Exception {
		try {
	

		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfDetalleCuentaFlujoCaja(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=DetalleCuentaFlujoCajaConstantesFunciones.getClassesForeignKeysOfDetalleCuentaFlujoCaja(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfDetalleCuentaFlujoCaja(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=DetalleCuentaFlujoCajaConstantesFunciones.getClassesRelationshipsOfDetalleCuentaFlujoCaja(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}
