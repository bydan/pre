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
import com.bydan.erp.cartera.util.DetalleRecapConstantesFunciones;
import com.bydan.erp.cartera.util.DetalleRecapParameterReturnGeneral;
//import com.bydan.erp.cartera.util.DetalleRecapParameterGeneral;
import com.bydan.erp.cartera.business.entity.DetalleRecap;
import com.bydan.erp.cartera.business.logic.DetalleRecapLogicAdditional;
import com.bydan.erp.cartera.business.dataaccess.*;
import com.bydan.erp.cartera.business.entity.*;

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
public class DetalleRecapLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(DetalleRecapLogic.class);
	
	protected DetalleRecapDataAccess detallerecapDataAccess; 	
	protected DetalleRecap detallerecap;
	protected List<DetalleRecap> detallerecaps;
	protected Object detallerecapObject;	
	protected List<Object> detallerecapsObject;
	
	public static ClassValidator<DetalleRecap> detallerecapValidator = new ClassValidator<DetalleRecap>(DetalleRecap.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected DetalleRecapLogicAdditional detallerecapLogicAdditional=null;
	
	public DetalleRecapLogicAdditional getDetalleRecapLogicAdditional() {
		return this.detallerecapLogicAdditional;
	}
	
	public void setDetalleRecapLogicAdditional(DetalleRecapLogicAdditional detallerecapLogicAdditional) {
		try {
			this.detallerecapLogicAdditional=detallerecapLogicAdditional;
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
	
	
	
	
	public  DetalleRecapLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.detallerecapDataAccess = new DetalleRecapDataAccess();
			
			this.detallerecaps= new ArrayList<DetalleRecap>();
			this.detallerecap= new DetalleRecap();
			
			this.detallerecapObject=new Object();
			this.detallerecapsObject=new ArrayList<Object>();
				
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
			
			this.detallerecapDataAccess.setConnexionType(this.connexionType);
			this.detallerecapDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  DetalleRecapLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.detallerecapDataAccess = new DetalleRecapDataAccess();
			this.detallerecaps= new ArrayList<DetalleRecap>();
			this.detallerecap= new DetalleRecap();
			this.detallerecapObject=new Object();
			this.detallerecapsObject=new ArrayList<Object>();
			
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
			
			this.detallerecapDataAccess.setConnexionType(this.connexionType);
			this.detallerecapDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public DetalleRecap getDetalleRecap() throws Exception {	
		DetalleRecapLogicAdditional.checkDetalleRecapToGet(detallerecap,this.datosCliente,this.arrDatoGeneral);
		DetalleRecapLogicAdditional.updateDetalleRecapToGet(detallerecap,this.arrDatoGeneral);
		
		return detallerecap;
	}
		
	public void setDetalleRecap(DetalleRecap newDetalleRecap) {
		this.detallerecap = newDetalleRecap;
	}
	
	public DetalleRecapDataAccess getDetalleRecapDataAccess() {
		return detallerecapDataAccess;
	}
	
	public void setDetalleRecapDataAccess(DetalleRecapDataAccess newdetallerecapDataAccess) {
		this.detallerecapDataAccess = newdetallerecapDataAccess;
	}
	
	public List<DetalleRecap> getDetalleRecaps() throws Exception {		
		this.quitarDetalleRecapsNulos();
		
		DetalleRecapLogicAdditional.checkDetalleRecapToGets(detallerecaps,this.datosCliente,this.arrDatoGeneral);
		
		for (DetalleRecap detallerecapLocal: detallerecaps ) {
			DetalleRecapLogicAdditional.updateDetalleRecapToGet(detallerecapLocal,this.arrDatoGeneral);
		}
		
		return detallerecaps;
	}
	
	public void setDetalleRecaps(List<DetalleRecap> newDetalleRecaps) {
		this.detallerecaps = newDetalleRecaps;
	}
	
	public Object getDetalleRecapObject() {	
		this.detallerecapObject=this.detallerecapDataAccess.getEntityObject();
		return this.detallerecapObject;
	}
		
	public void setDetalleRecapObject(Object newDetalleRecapObject) {
		this.detallerecapObject = newDetalleRecapObject;
	}
	
	public List<Object> getDetalleRecapsObject() {		
		this.detallerecapsObject=this.detallerecapDataAccess.getEntitiesObject();
		return this.detallerecapsObject;
	}
		
	public void setDetalleRecapsObject(List<Object> newDetalleRecapsObject) {
		this.detallerecapsObject = newDetalleRecapsObject;
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
		
		if(this.detallerecapDataAccess!=null) {
			this.detallerecapDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleRecap.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			detallerecapDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			detallerecapDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		detallerecap = new  DetalleRecap();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleRecap.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			detallerecap=detallerecapDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.detallerecap,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				DetalleRecapConstantesFunciones.refrescarForeignKeysDescripcionesDetalleRecap(this.detallerecap);
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
		detallerecap = new  DetalleRecap();
		  		  
        try {
			
			detallerecap=detallerecapDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.detallerecap,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				DetalleRecapConstantesFunciones.refrescarForeignKeysDescripcionesDetalleRecap(this.detallerecap);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		detallerecap = new  DetalleRecap();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleRecap.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			detallerecap=detallerecapDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.detallerecap,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				DetalleRecapConstantesFunciones.refrescarForeignKeysDescripcionesDetalleRecap(this.detallerecap);
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
		detallerecap = new  DetalleRecap();
		  		  
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
		detallerecap = new  DetalleRecap();
		  		  
        try {
			
			detallerecap=detallerecapDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.detallerecap,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				DetalleRecapConstantesFunciones.refrescarForeignKeysDescripcionesDetalleRecap(this.detallerecap);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		detallerecap = new  DetalleRecap();
		  		  
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
		detallerecap = new  DetalleRecap();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleRecap.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =detallerecapDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		detallerecap = new  DetalleRecap();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=detallerecapDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		detallerecap = new  DetalleRecap();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleRecap.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =detallerecapDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		detallerecap = new  DetalleRecap();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=detallerecapDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		detallerecap = new  DetalleRecap();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleRecap.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =detallerecapDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		detallerecap = new  DetalleRecap();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=detallerecapDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		detallerecaps = new  ArrayList<DetalleRecap>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleRecap.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			DetalleRecapLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detallerecaps=detallerecapDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarDetalleRecap(detallerecaps);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetalleRecapConstantesFunciones.refrescarForeignKeysDescripcionesDetalleRecap(this.detallerecaps);
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
		detallerecaps = new  ArrayList<DetalleRecap>();
		  		  
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
		detallerecaps = new  ArrayList<DetalleRecap>();
		  		  
        try {			
			DetalleRecapLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detallerecaps=detallerecapDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarDetalleRecap(detallerecaps);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetalleRecapConstantesFunciones.refrescarForeignKeysDescripcionesDetalleRecap(this.detallerecaps);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		detallerecaps = new  ArrayList<DetalleRecap>();
		  		  
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
		detallerecaps = new  ArrayList<DetalleRecap>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleRecap.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			DetalleRecapLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detallerecaps=detallerecapDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarDetalleRecap(detallerecaps);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetalleRecapConstantesFunciones.refrescarForeignKeysDescripcionesDetalleRecap(this.detallerecaps);
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
		detallerecaps = new  ArrayList<DetalleRecap>();
		  		  
        try {
			DetalleRecapLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detallerecaps=detallerecapDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarDetalleRecap(detallerecaps);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetalleRecapConstantesFunciones.refrescarForeignKeysDescripcionesDetalleRecap(this.detallerecaps);
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
		detallerecaps = new  ArrayList<DetalleRecap>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleRecap.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			DetalleRecapLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detallerecaps=detallerecapDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarDetalleRecap(detallerecaps);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetalleRecapConstantesFunciones.refrescarForeignKeysDescripcionesDetalleRecap(this.detallerecaps);
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
		detallerecaps = new  ArrayList<DetalleRecap>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			DetalleRecapLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detallerecaps=detallerecapDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarDetalleRecap(detallerecaps);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetalleRecapConstantesFunciones.refrescarForeignKeysDescripcionesDetalleRecap(this.detallerecaps);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		detallerecap = new  DetalleRecap();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleRecap.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			DetalleRecapLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detallerecap=detallerecapDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarDetalleRecap(detallerecap);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetalleRecapConstantesFunciones.refrescarForeignKeysDescripcionesDetalleRecap(this.detallerecap);
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
		detallerecap = new  DetalleRecap();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			DetalleRecapLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detallerecap=detallerecapDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarDetalleRecap(detallerecap);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetalleRecapConstantesFunciones.refrescarForeignKeysDescripcionesDetalleRecap(this.detallerecap);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		detallerecaps = new  ArrayList<DetalleRecap>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleRecap.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			DetalleRecapLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detallerecaps=detallerecapDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarDetalleRecap(detallerecaps);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetalleRecapConstantesFunciones.refrescarForeignKeysDescripcionesDetalleRecap(this.detallerecaps);
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
		detallerecaps = new  ArrayList<DetalleRecap>();
		  		  
        try {
			DetalleRecapLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detallerecaps=detallerecapDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarDetalleRecap(detallerecaps);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetalleRecapConstantesFunciones.refrescarForeignKeysDescripcionesDetalleRecap(this.detallerecaps);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosDetalleRecapsWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		detallerecaps = new  ArrayList<DetalleRecap>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleRecap.class.getSimpleName()+"-getTodosDetalleRecapsWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			DetalleRecapLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detallerecaps=detallerecapDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarDetalleRecap(detallerecaps);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetalleRecapConstantesFunciones.refrescarForeignKeysDescripcionesDetalleRecap(this.detallerecaps);
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
	
	public  void  getTodosDetalleRecaps(String sFinalQuery,Pagination pagination)throws Exception {
		detallerecaps = new  ArrayList<DetalleRecap>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			DetalleRecapLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detallerecaps=detallerecapDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarDetalleRecap(detallerecaps);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetalleRecapConstantesFunciones.refrescarForeignKeysDescripcionesDetalleRecap(this.detallerecaps);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarDetalleRecap(DetalleRecap detallerecap) throws Exception {
		Boolean estaValidado=false;
		
		if(detallerecap.getIsNew() || detallerecap.getIsChanged()) { 
			this.invalidValues = detallerecapValidator.getInvalidValues(detallerecap);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(detallerecap);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarDetalleRecap(List<DetalleRecap> DetalleRecaps) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(DetalleRecap detallerecapLocal:detallerecaps) {				
			estaValidadoObjeto=this.validarGuardarDetalleRecap(detallerecapLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarDetalleRecap(List<DetalleRecap> DetalleRecaps) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarDetalleRecap(detallerecaps)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarDetalleRecap(DetalleRecap DetalleRecap) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarDetalleRecap(detallerecap)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(DetalleRecap detallerecap) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+detallerecap.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=DetalleRecapConstantesFunciones.getDetalleRecapLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"detallerecap","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(DetalleRecapConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(DetalleRecapConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveDetalleRecapWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleRecap.class.getSimpleName()+"-saveDetalleRecapWithConnection");connexion.begin();			
			
			DetalleRecapLogicAdditional.checkDetalleRecapToSave(this.detallerecap,this.datosCliente,connexion,this.arrDatoGeneral);
			
			DetalleRecapLogicAdditional.updateDetalleRecapToSave(this.detallerecap,this.arrDatoGeneral);
			
			DetalleRecapLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.detallerecap,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowDetalleRecap();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarDetalleRecap(this.detallerecap)) {
				DetalleRecapDataAccess.save(this.detallerecap, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.detallerecap,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			DetalleRecapLogicAdditional.checkDetalleRecapToSaveAfter(this.detallerecap,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowDetalleRecap();
			
			connexion.commit();			
			
			if(this.detallerecap.getIsDeleted()) {
				this.detallerecap=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveDetalleRecap()throws Exception {	
		try {	
			
			DetalleRecapLogicAdditional.checkDetalleRecapToSave(this.detallerecap,this.datosCliente,connexion,this.arrDatoGeneral);
			
			DetalleRecapLogicAdditional.updateDetalleRecapToSave(this.detallerecap,this.arrDatoGeneral);
			
			DetalleRecapLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.detallerecap,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarDetalleRecap(this.detallerecap)) {			
				DetalleRecapDataAccess.save(this.detallerecap, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.detallerecap,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			DetalleRecapLogicAdditional.checkDetalleRecapToSaveAfter(this.detallerecap,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.detallerecap.getIsDeleted()) {
				this.detallerecap=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveDetalleRecapsWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleRecap.class.getSimpleName()+"-saveDetalleRecapsWithConnection");connexion.begin();			
			
			DetalleRecapLogicAdditional.checkDetalleRecapToSaves(detallerecaps,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowDetalleRecaps();
			
			Boolean validadoTodosDetalleRecap=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(DetalleRecap detallerecapLocal:detallerecaps) {		
				if(detallerecapLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				DetalleRecapLogicAdditional.updateDetalleRecapToSave(detallerecapLocal,this.arrDatoGeneral);
	        	
				DetalleRecapLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),detallerecapLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarDetalleRecap(detallerecapLocal)) {
					DetalleRecapDataAccess.save(detallerecapLocal, connexion);				
				} else {
					validadoTodosDetalleRecap=false;
				}
			}
			
			if(!validadoTodosDetalleRecap) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			DetalleRecapLogicAdditional.checkDetalleRecapToSavesAfter(detallerecaps,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowDetalleRecaps();
			
			connexion.commit();		
			
			this.quitarDetalleRecapsEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveDetalleRecaps()throws Exception {				
		 try {	
			DetalleRecapLogicAdditional.checkDetalleRecapToSaves(detallerecaps,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosDetalleRecap=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(DetalleRecap detallerecapLocal:detallerecaps) {				
				if(detallerecapLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				DetalleRecapLogicAdditional.updateDetalleRecapToSave(detallerecapLocal,this.arrDatoGeneral);
	        	
				DetalleRecapLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),detallerecapLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarDetalleRecap(detallerecapLocal)) {				
					DetalleRecapDataAccess.save(detallerecapLocal, connexion);				
				} else {
					validadoTodosDetalleRecap=false;
				}
			}
			
			if(!validadoTodosDetalleRecap) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			DetalleRecapLogicAdditional.checkDetalleRecapToSavesAfter(detallerecaps,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarDetalleRecapsEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public DetalleRecapParameterReturnGeneral procesarAccionDetalleRecaps(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<DetalleRecap> detallerecaps,DetalleRecapParameterReturnGeneral detallerecapParameterGeneral)throws Exception {
		 try {	
			DetalleRecapParameterReturnGeneral detallerecapReturnGeneral=new DetalleRecapParameterReturnGeneral();
	
			DetalleRecapLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,detallerecaps,detallerecapParameterGeneral,detallerecapReturnGeneral);
			
			return detallerecapReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public DetalleRecapParameterReturnGeneral procesarAccionDetalleRecapsWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<DetalleRecap> detallerecaps,DetalleRecapParameterReturnGeneral detallerecapParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleRecap.class.getSimpleName()+"-procesarAccionDetalleRecapsWithConnection");connexion.begin();			
			
			DetalleRecapParameterReturnGeneral detallerecapReturnGeneral=new DetalleRecapParameterReturnGeneral();
	
			DetalleRecapLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,detallerecaps,detallerecapParameterGeneral,detallerecapReturnGeneral);
			
			this.connexion.commit();
			
			return detallerecapReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public DetalleRecapParameterReturnGeneral procesarEventosDetalleRecaps(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<DetalleRecap> detallerecaps,DetalleRecap detallerecap,DetalleRecapParameterReturnGeneral detallerecapParameterGeneral,Boolean isEsNuevoDetalleRecap,ArrayList<Classe> clases)throws Exception {
		 try {	
			DetalleRecapParameterReturnGeneral detallerecapReturnGeneral=new DetalleRecapParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				detallerecapReturnGeneral.setConRecargarPropiedades(true);
			}
			
			DetalleRecapLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,detallerecaps,detallerecap,detallerecapParameterGeneral,detallerecapReturnGeneral,isEsNuevoDetalleRecap,clases);
			
			return detallerecapReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public DetalleRecapParameterReturnGeneral procesarEventosDetalleRecapsWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<DetalleRecap> detallerecaps,DetalleRecap detallerecap,DetalleRecapParameterReturnGeneral detallerecapParameterGeneral,Boolean isEsNuevoDetalleRecap,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleRecap.class.getSimpleName()+"-procesarEventosDetalleRecapsWithConnection");connexion.begin();			
			
			DetalleRecapParameterReturnGeneral detallerecapReturnGeneral=new DetalleRecapParameterReturnGeneral();
	
			detallerecapReturnGeneral.setDetalleRecap(detallerecap);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				detallerecapReturnGeneral.setConRecargarPropiedades(true);
			}
			
			DetalleRecapLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,detallerecaps,detallerecap,detallerecapParameterGeneral,detallerecapReturnGeneral,isEsNuevoDetalleRecap,clases);
			
			this.connexion.commit();
			
			return detallerecapReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public DetalleRecapParameterReturnGeneral procesarImportacionDetalleRecapsWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,DetalleRecapParameterReturnGeneral detallerecapParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleRecap.class.getSimpleName()+"-procesarImportacionDetalleRecapsWithConnection");connexion.begin();			
			
			DetalleRecapParameterReturnGeneral detallerecapReturnGeneral=new DetalleRecapParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.detallerecaps=new ArrayList<DetalleRecap>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.detallerecap=new DetalleRecap();
				
				
				if(conColumnasBase) {this.detallerecap.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.detallerecap.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.detallerecap.setvalor(Double.parseDouble(arrColumnas[iColumn++]));
				this.detallerecap.setiva_porcentaje(Double.parseDouble(arrColumnas[iColumn++]));
				this.detallerecap.settotal(Double.parseDouble(arrColumnas[iColumn++]));
				
				this.detallerecaps.add(this.detallerecap);
			}
			
			this.saveDetalleRecaps();
			
			this.connexion.commit();
			
			detallerecapReturnGeneral.setConRetornoEstaProcesado(true);
			detallerecapReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return detallerecapReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarDetalleRecapsEliminados() throws Exception {				
		
		List<DetalleRecap> detallerecapsAux= new ArrayList<DetalleRecap>();
		
		for(DetalleRecap detallerecap:detallerecaps) {
			if(!detallerecap.getIsDeleted()) {
				detallerecapsAux.add(detallerecap);
			}
		}
		
		detallerecaps=detallerecapsAux;
	}
	
	public void quitarDetalleRecapsNulos() throws Exception {				
		
		List<DetalleRecap> detallerecapsAux= new ArrayList<DetalleRecap>();
		
		for(DetalleRecap detallerecap : this.detallerecaps) {
			if(detallerecap==null) {
				detallerecapsAux.add(detallerecap);
			}
		}
		
		//this.detallerecaps=detallerecapsAux;
		
		this.detallerecaps.removeAll(detallerecapsAux);
	}
	
	public void getSetVersionRowDetalleRecapWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(detallerecap.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((detallerecap.getIsDeleted() || (detallerecap.getIsChanged()&&!detallerecap.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=detallerecapDataAccess.getSetVersionRowDetalleRecap(connexion,detallerecap.getId());
				
				if(!detallerecap.getVersionRow().equals(timestamp)) {	
					detallerecap.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				detallerecap.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowDetalleRecap()throws Exception {	
		
		if(detallerecap.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((detallerecap.getIsDeleted() || (detallerecap.getIsChanged()&&!detallerecap.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=detallerecapDataAccess.getSetVersionRowDetalleRecap(connexion,detallerecap.getId());
			
			try {							
				if(!detallerecap.getVersionRow().equals(timestamp)) {	
					detallerecap.setVersionRow(timestamp);
				}
				
				detallerecap.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowDetalleRecapsWithConnection()throws Exception {	
		if(detallerecaps!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(DetalleRecap detallerecapAux:detallerecaps) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(detallerecapAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(detallerecapAux.getIsDeleted() || (detallerecapAux.getIsChanged()&&!detallerecapAux.getIsNew())) {
						
						timestamp=detallerecapDataAccess.getSetVersionRowDetalleRecap(connexion,detallerecapAux.getId());
						
						if(!detallerecap.getVersionRow().equals(timestamp)) {	
							detallerecapAux.setVersionRow(timestamp);
						}
								
						detallerecapAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowDetalleRecaps()throws Exception {	
		if(detallerecaps!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(DetalleRecap detallerecapAux:detallerecaps) {
					if(detallerecapAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(detallerecapAux.getIsDeleted() || (detallerecapAux.getIsChanged()&&!detallerecapAux.getIsNew())) {
						
						timestamp=detallerecapDataAccess.getSetVersionRowDetalleRecap(connexion,detallerecapAux.getId());
						
						if(!detallerecapAux.getVersionRow().equals(timestamp)) {	
							detallerecapAux.setVersionRow(timestamp);
						}
						
													
						detallerecapAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public DetalleRecapParameterReturnGeneral cargarCombosLoteForeignKeyDetalleRecapWithConnection(String finalQueryGlobalRecap,String finalQueryGlobalEmpresa,String finalQueryGlobalSucursal,String finalQueryGlobalEjercicio,String finalQueryGlobalDetalleCliente,String finalQueryGlobalCliente) throws Exception {
		DetalleRecapParameterReturnGeneral  detallerecapReturnGeneral =new DetalleRecapParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleRecap.class.getSimpleName()+"-cargarCombosLoteForeignKeyDetalleRecapWithConnection");connexion.begin();
			
			detallerecapReturnGeneral =new DetalleRecapParameterReturnGeneral();
			
			

			List<Recap> recapsForeignKey=new ArrayList<Recap>();
			RecapLogic recapLogic=new RecapLogic();
			recapLogic.setConnexion(this.connexion);
			recapLogic.getRecapDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalRecap.equals("NONE")) {
				recapLogic.getTodosRecaps(finalQueryGlobalRecap,new Pagination());
				recapsForeignKey=recapLogic.getRecaps();
			}

			detallerecapReturnGeneral.setrecapsForeignKey(recapsForeignKey);


			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			detallerecapReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Sucursal> sucursalsForeignKey=new ArrayList<Sucursal>();
			SucursalLogic sucursalLogic=new SucursalLogic();
			sucursalLogic.setConnexion(this.connexion);
			//sucursalLogic.getSucursalDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalSucursal.equals("NONE")) {
				sucursalLogic.getTodosSucursals(finalQueryGlobalSucursal,new Pagination());
				sucursalsForeignKey=sucursalLogic.getSucursals();
			}

			detallerecapReturnGeneral.setsucursalsForeignKey(sucursalsForeignKey);


			List<Ejercicio> ejerciciosForeignKey=new ArrayList<Ejercicio>();
			EjercicioLogic ejercicioLogic=new EjercicioLogic();
			ejercicioLogic.setConnexion(this.connexion);
			//ejercicioLogic.getEjercicioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEjercicio.equals("NONE")) {
				ejercicioLogic.getTodosEjercicios(finalQueryGlobalEjercicio,new Pagination());
				ejerciciosForeignKey=ejercicioLogic.getEjercicios();
			}

			detallerecapReturnGeneral.setejerciciosForeignKey(ejerciciosForeignKey);


			List<DetalleCliente> detalleclientesForeignKey=new ArrayList<DetalleCliente>();
			DetalleClienteLogic detalleclienteLogic=new DetalleClienteLogic();
			detalleclienteLogic.setConnexion(this.connexion);
			detalleclienteLogic.getDetalleClienteDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalDetalleCliente.equals("NONE")) {
				detalleclienteLogic.getTodosDetalleClientes(finalQueryGlobalDetalleCliente,new Pagination());
				detalleclientesForeignKey=detalleclienteLogic.getDetalleClientes();
			}

			detallerecapReturnGeneral.setdetalleclientesForeignKey(detalleclientesForeignKey);


			List<Cliente> clientesForeignKey=new ArrayList<Cliente>();
			ClienteLogic clienteLogic=new ClienteLogic();
			clienteLogic.setConnexion(this.connexion);
			clienteLogic.getClienteDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCliente.equals("NONE")) {
				clienteLogic.getTodosClientes(finalQueryGlobalCliente,new Pagination());
				clientesForeignKey=clienteLogic.getClientes();
			}

			detallerecapReturnGeneral.setclientesForeignKey(clientesForeignKey);

			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
		
		return detallerecapReturnGeneral;
	}
	
	public DetalleRecapParameterReturnGeneral cargarCombosLoteForeignKeyDetalleRecap(String finalQueryGlobalRecap,String finalQueryGlobalEmpresa,String finalQueryGlobalSucursal,String finalQueryGlobalEjercicio,String finalQueryGlobalDetalleCliente,String finalQueryGlobalCliente) throws Exception {
		DetalleRecapParameterReturnGeneral  detallerecapReturnGeneral =new DetalleRecapParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {						
			detallerecapReturnGeneral =new DetalleRecapParameterReturnGeneral();
			
			

			List<Recap> recapsForeignKey=new ArrayList<Recap>();
			RecapLogic recapLogic=new RecapLogic();
			recapLogic.setConnexion(this.connexion);
			recapLogic.getRecapDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalRecap.equals("NONE")) {
				recapLogic.getTodosRecaps(finalQueryGlobalRecap,new Pagination());
				recapsForeignKey=recapLogic.getRecaps();
			}

			detallerecapReturnGeneral.setrecapsForeignKey(recapsForeignKey);


			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			detallerecapReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Sucursal> sucursalsForeignKey=new ArrayList<Sucursal>();
			SucursalLogic sucursalLogic=new SucursalLogic();
			sucursalLogic.setConnexion(this.connexion);
			//sucursalLogic.getSucursalDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalSucursal.equals("NONE")) {
				sucursalLogic.getTodosSucursals(finalQueryGlobalSucursal,new Pagination());
				sucursalsForeignKey=sucursalLogic.getSucursals();
			}

			detallerecapReturnGeneral.setsucursalsForeignKey(sucursalsForeignKey);


			List<Ejercicio> ejerciciosForeignKey=new ArrayList<Ejercicio>();
			EjercicioLogic ejercicioLogic=new EjercicioLogic();
			ejercicioLogic.setConnexion(this.connexion);
			//ejercicioLogic.getEjercicioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEjercicio.equals("NONE")) {
				ejercicioLogic.getTodosEjercicios(finalQueryGlobalEjercicio,new Pagination());
				ejerciciosForeignKey=ejercicioLogic.getEjercicios();
			}

			detallerecapReturnGeneral.setejerciciosForeignKey(ejerciciosForeignKey);


			List<DetalleCliente> detalleclientesForeignKey=new ArrayList<DetalleCliente>();
			DetalleClienteLogic detalleclienteLogic=new DetalleClienteLogic();
			detalleclienteLogic.setConnexion(this.connexion);
			detalleclienteLogic.getDetalleClienteDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalDetalleCliente.equals("NONE")) {
				detalleclienteLogic.getTodosDetalleClientes(finalQueryGlobalDetalleCliente,new Pagination());
				detalleclientesForeignKey=detalleclienteLogic.getDetalleClientes();
			}

			detallerecapReturnGeneral.setdetalleclientesForeignKey(detalleclientesForeignKey);


			List<Cliente> clientesForeignKey=new ArrayList<Cliente>();
			ClienteLogic clienteLogic=new ClienteLogic();
			clienteLogic.setConnexion(this.connexion);
			clienteLogic.getClienteDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCliente.equals("NONE")) {
				clienteLogic.getTodosClientes(finalQueryGlobalCliente,new Pagination());
				clientesForeignKey=clienteLogic.getClientes();
			}

			detallerecapReturnGeneral.setclientesForeignKey(clientesForeignKey);
						
			
		} catch(Exception e) {			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			
		}
		
		return detallerecapReturnGeneral;
	}
	
	
	public void deepLoad(DetalleRecap detallerecap,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			DetalleRecapLogicAdditional.updateDetalleRecapToGet(detallerecap,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		detallerecap.setRecap(detallerecapDataAccess.getRecap(connexion,detallerecap));
		detallerecap.setEmpresa(detallerecapDataAccess.getEmpresa(connexion,detallerecap));
		detallerecap.setSucursal(detallerecapDataAccess.getSucursal(connexion,detallerecap));
		detallerecap.setEjercicio(detallerecapDataAccess.getEjercicio(connexion,detallerecap));
		detallerecap.setDetalleCliente(detallerecapDataAccess.getDetalleCliente(connexion,detallerecap));
		detallerecap.setCliente(detallerecapDataAccess.getCliente(connexion,detallerecap));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Recap.class)) {
				detallerecap.setRecap(detallerecapDataAccess.getRecap(connexion,detallerecap));
				continue;
			}

			if(clas.clas.equals(Empresa.class)) {
				detallerecap.setEmpresa(detallerecapDataAccess.getEmpresa(connexion,detallerecap));
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				detallerecap.setSucursal(detallerecapDataAccess.getSucursal(connexion,detallerecap));
				continue;
			}

			if(clas.clas.equals(Ejercicio.class)) {
				detallerecap.setEjercicio(detallerecapDataAccess.getEjercicio(connexion,detallerecap));
				continue;
			}

			if(clas.clas.equals(DetalleCliente.class)) {
				detallerecap.setDetalleCliente(detallerecapDataAccess.getDetalleCliente(connexion,detallerecap));
				continue;
			}

			if(clas.clas.equals(Cliente.class)) {
				detallerecap.setCliente(detallerecapDataAccess.getCliente(connexion,detallerecap));
				continue;
			}
		}
	}
	else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Recap.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detallerecap.setRecap(detallerecapDataAccess.getRecap(connexion,detallerecap));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detallerecap.setEmpresa(detallerecapDataAccess.getEmpresa(connexion,detallerecap));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detallerecap.setSucursal(detallerecapDataAccess.getSucursal(connexion,detallerecap));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Ejercicio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detallerecap.setEjercicio(detallerecapDataAccess.getEjercicio(connexion,detallerecap));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(DetalleCliente.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detallerecap.setDetalleCliente(detallerecapDataAccess.getDetalleCliente(connexion,detallerecap));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Cliente.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detallerecap.setCliente(detallerecapDataAccess.getCliente(connexion,detallerecap));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		detallerecap.setRecap(detallerecapDataAccess.getRecap(connexion,detallerecap));
		RecapLogic recapLogic= new RecapLogic(connexion);
		recapLogic.deepLoad(detallerecap.getRecap(),isDeep,deepLoadType,clases);
				
		detallerecap.setEmpresa(detallerecapDataAccess.getEmpresa(connexion,detallerecap));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(detallerecap.getEmpresa(),isDeep,deepLoadType,clases);
				
		detallerecap.setSucursal(detallerecapDataAccess.getSucursal(connexion,detallerecap));
		SucursalLogic sucursalLogic= new SucursalLogic(connexion);
		sucursalLogic.deepLoad(detallerecap.getSucursal(),isDeep,deepLoadType,clases);
				
		detallerecap.setEjercicio(detallerecapDataAccess.getEjercicio(connexion,detallerecap));
		EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
		ejercicioLogic.deepLoad(detallerecap.getEjercicio(),isDeep,deepLoadType,clases);
				
		detallerecap.setDetalleCliente(detallerecapDataAccess.getDetalleCliente(connexion,detallerecap));
		DetalleClienteLogic detalleclienteLogic= new DetalleClienteLogic(connexion);
		detalleclienteLogic.deepLoad(detallerecap.getDetalleCliente(),isDeep,deepLoadType,clases);
				
		detallerecap.setCliente(detallerecapDataAccess.getCliente(connexion,detallerecap));
		ClienteLogic clienteLogic= new ClienteLogic(connexion);
		clienteLogic.deepLoad(detallerecap.getCliente(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Recap.class)) {
				detallerecap.setRecap(detallerecapDataAccess.getRecap(connexion,detallerecap));
				RecapLogic recapLogic= new RecapLogic(connexion);
				recapLogic.deepLoad(detallerecap.getRecap(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Empresa.class)) {
				detallerecap.setEmpresa(detallerecapDataAccess.getEmpresa(connexion,detallerecap));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(detallerecap.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				detallerecap.setSucursal(detallerecapDataAccess.getSucursal(connexion,detallerecap));
				SucursalLogic sucursalLogic= new SucursalLogic(connexion);
				sucursalLogic.deepLoad(detallerecap.getSucursal(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Ejercicio.class)) {
				detallerecap.setEjercicio(detallerecapDataAccess.getEjercicio(connexion,detallerecap));
				EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
				ejercicioLogic.deepLoad(detallerecap.getEjercicio(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(DetalleCliente.class)) {
				detallerecap.setDetalleCliente(detallerecapDataAccess.getDetalleCliente(connexion,detallerecap));
				DetalleClienteLogic detalleclienteLogic= new DetalleClienteLogic(connexion);
				detalleclienteLogic.deepLoad(detallerecap.getDetalleCliente(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Cliente.class)) {
				detallerecap.setCliente(detallerecapDataAccess.getCliente(connexion,detallerecap));
				ClienteLogic clienteLogic= new ClienteLogic(connexion);
				clienteLogic.deepLoad(detallerecap.getCliente(),isDeep,deepLoadType,clases);				
				continue;
			}

		}
	}
	else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {


		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Recap.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detallerecap.setRecap(detallerecapDataAccess.getRecap(connexion,detallerecap));
			RecapLogic recapLogic= new RecapLogic(connexion);
			recapLogic.deepLoad(detallerecap.getRecap(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detallerecap.setEmpresa(detallerecapDataAccess.getEmpresa(connexion,detallerecap));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(detallerecap.getEmpresa(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detallerecap.setSucursal(detallerecapDataAccess.getSucursal(connexion,detallerecap));
			SucursalLogic sucursalLogic= new SucursalLogic(connexion);
			sucursalLogic.deepLoad(detallerecap.getSucursal(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Ejercicio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detallerecap.setEjercicio(detallerecapDataAccess.getEjercicio(connexion,detallerecap));
			EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
			ejercicioLogic.deepLoad(detallerecap.getEjercicio(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(DetalleCliente.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detallerecap.setDetalleCliente(detallerecapDataAccess.getDetalleCliente(connexion,detallerecap));
			DetalleClienteLogic detalleclienteLogic= new DetalleClienteLogic(connexion);
			detalleclienteLogic.deepLoad(detallerecap.getDetalleCliente(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Cliente.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detallerecap.setCliente(detallerecapDataAccess.getCliente(connexion,detallerecap));
			ClienteLogic clienteLogic= new ClienteLogic(connexion);
			clienteLogic.deepLoad(detallerecap.getCliente(),isDeep,deepLoadType,clases);
				
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(DetalleRecap detallerecap,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			DetalleRecapLogicAdditional.updateDetalleRecapToSave(detallerecap,this.arrDatoGeneral);
			
DetalleRecapDataAccess.save(detallerecap, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		RecapDataAccess.save(detallerecap.getRecap(),connexion);

		EmpresaDataAccess.save(detallerecap.getEmpresa(),connexion);

		SucursalDataAccess.save(detallerecap.getSucursal(),connexion);

		EjercicioDataAccess.save(detallerecap.getEjercicio(),connexion);

		DetalleClienteDataAccess.save(detallerecap.getDetalleCliente(),connexion);

		ClienteDataAccess.save(detallerecap.getCliente(),connexion);
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Recap.class)) {
				RecapDataAccess.save(detallerecap.getRecap(),connexion);
				continue;
			}

			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(detallerecap.getEmpresa(),connexion);
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				SucursalDataAccess.save(detallerecap.getSucursal(),connexion);
				continue;
			}

			if(clas.clas.equals(Ejercicio.class)) {
				EjercicioDataAccess.save(detallerecap.getEjercicio(),connexion);
				continue;
			}

			if(clas.clas.equals(DetalleCliente.class)) {
				DetalleClienteDataAccess.save(detallerecap.getDetalleCliente(),connexion);
				continue;
			}

			if(clas.clas.equals(Cliente.class)) {
				ClienteDataAccess.save(detallerecap.getCliente(),connexion);
				continue;
			}

		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		RecapDataAccess.save(detallerecap.getRecap(),connexion);
		RecapLogic recapLogic= new RecapLogic(connexion);
		recapLogic.deepLoad(detallerecap.getRecap(),isDeep,deepLoadType,clases);
				

		EmpresaDataAccess.save(detallerecap.getEmpresa(),connexion);
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(detallerecap.getEmpresa(),isDeep,deepLoadType,clases);
				

		SucursalDataAccess.save(detallerecap.getSucursal(),connexion);
		SucursalLogic sucursalLogic= new SucursalLogic(connexion);
		sucursalLogic.deepLoad(detallerecap.getSucursal(),isDeep,deepLoadType,clases);
				

		EjercicioDataAccess.save(detallerecap.getEjercicio(),connexion);
		EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
		ejercicioLogic.deepLoad(detallerecap.getEjercicio(),isDeep,deepLoadType,clases);
				

		DetalleClienteDataAccess.save(detallerecap.getDetalleCliente(),connexion);
		DetalleClienteLogic detalleclienteLogic= new DetalleClienteLogic(connexion);
		detalleclienteLogic.deepLoad(detallerecap.getDetalleCliente(),isDeep,deepLoadType,clases);
				

		ClienteDataAccess.save(detallerecap.getCliente(),connexion);
		ClienteLogic clienteLogic= new ClienteLogic(connexion);
		clienteLogic.deepLoad(detallerecap.getCliente(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Recap.class)) {
				RecapDataAccess.save(detallerecap.getRecap(),connexion);
				RecapLogic recapLogic= new RecapLogic(connexion);
				recapLogic.deepSave(detallerecap.getRecap(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(detallerecap.getEmpresa(),connexion);
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepSave(detallerecap.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				SucursalDataAccess.save(detallerecap.getSucursal(),connexion);
				SucursalLogic sucursalLogic= new SucursalLogic(connexion);
				sucursalLogic.deepSave(detallerecap.getSucursal(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Ejercicio.class)) {
				EjercicioDataAccess.save(detallerecap.getEjercicio(),connexion);
				EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
				ejercicioLogic.deepSave(detallerecap.getEjercicio(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(DetalleCliente.class)) {
				DetalleClienteDataAccess.save(detallerecap.getDetalleCliente(),connexion);
				DetalleClienteLogic detalleclienteLogic= new DetalleClienteLogic(connexion);
				detalleclienteLogic.deepSave(detallerecap.getDetalleCliente(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Cliente.class)) {
				ClienteDataAccess.save(detallerecap.getCliente(),connexion);
				ClienteLogic clienteLogic= new ClienteLogic(connexion);
				clienteLogic.deepSave(detallerecap.getCliente(),isDeep,deepLoadType,clases);				
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
			this.getNewConnexionToDeep(DetalleRecap.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(detallerecap,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				DetalleRecapConstantesFunciones.refrescarForeignKeysDescripcionesDetalleRecap(detallerecap);
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
			this.deepLoad(this.detallerecap,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				DetalleRecapConstantesFunciones.refrescarForeignKeysDescripcionesDetalleRecap(this.detallerecap);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(DetalleRecap.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(detallerecaps!=null) {
				for(DetalleRecap detallerecap:detallerecaps) {
					this.deepLoad(detallerecap,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					DetalleRecapConstantesFunciones.refrescarForeignKeysDescripcionesDetalleRecap(detallerecaps);
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
			if(detallerecaps!=null) {
				for(DetalleRecap detallerecap:detallerecaps) {
					this.deepLoad(detallerecap,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					DetalleRecapConstantesFunciones.refrescarForeignKeysDescripcionesDetalleRecap(detallerecaps);
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
			this.getNewConnexionToDeep(DetalleRecap.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(detallerecap,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(DetalleRecap.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(detallerecaps!=null) {
				for(DetalleRecap detallerecap:detallerecaps) {
					this.deepSave(detallerecap,isDeep,deepLoadType,clases);
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
			if(detallerecaps!=null) {
				for(DetalleRecap detallerecap:detallerecaps) {
					this.deepSave(detallerecap,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getDetalleRecapsFK_IdClienteWithConnection(String sFinalQuery,Pagination pagination,Long id_cliente)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleRecap.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCliente= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCliente.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cliente,DetalleRecapConstantesFunciones.IDCLIENTE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCliente);

			DetalleRecapLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCliente","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detallerecaps=detallerecapDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleRecapConstantesFunciones.refrescarForeignKeysDescripcionesDetalleRecap(this.detallerecaps);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getDetalleRecapsFK_IdCliente(String sFinalQuery,Pagination pagination,Long id_cliente)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCliente= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCliente.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cliente,DetalleRecapConstantesFunciones.IDCLIENTE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCliente);

			DetalleRecapLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCliente","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detallerecaps=detallerecapDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleRecapConstantesFunciones.refrescarForeignKeysDescripcionesDetalleRecap(this.detallerecaps);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getDetalleRecapsFK_IdDetalleClienteWithConnection(String sFinalQuery,Pagination pagination,Long id_detalle_cliente)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleRecap.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidDetalleCliente= new ParameterSelectionGeneral();
			parameterSelectionGeneralidDetalleCliente.setParameterSelectionGeneralEqual(ParameterType.LONG,id_detalle_cliente,DetalleRecapConstantesFunciones.IDDETALLECLIENTE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidDetalleCliente);

			DetalleRecapLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdDetalleCliente","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detallerecaps=detallerecapDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleRecapConstantesFunciones.refrescarForeignKeysDescripcionesDetalleRecap(this.detallerecaps);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getDetalleRecapsFK_IdDetalleCliente(String sFinalQuery,Pagination pagination,Long id_detalle_cliente)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidDetalleCliente= new ParameterSelectionGeneral();
			parameterSelectionGeneralidDetalleCliente.setParameterSelectionGeneralEqual(ParameterType.LONG,id_detalle_cliente,DetalleRecapConstantesFunciones.IDDETALLECLIENTE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidDetalleCliente);

			DetalleRecapLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdDetalleCliente","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detallerecaps=detallerecapDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleRecapConstantesFunciones.refrescarForeignKeysDescripcionesDetalleRecap(this.detallerecaps);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getDetalleRecapsFK_IdEjercicioWithConnection(String sFinalQuery,Pagination pagination,Long id_ejercicio)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleRecap.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEjercicio= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEjercicio.setParameterSelectionGeneralEqual(ParameterType.LONG,id_ejercicio,DetalleRecapConstantesFunciones.IDEJERCICIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEjercicio);

			DetalleRecapLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEjercicio","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detallerecaps=detallerecapDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleRecapConstantesFunciones.refrescarForeignKeysDescripcionesDetalleRecap(this.detallerecaps);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getDetalleRecapsFK_IdEjercicio(String sFinalQuery,Pagination pagination,Long id_ejercicio)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEjercicio= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEjercicio.setParameterSelectionGeneralEqual(ParameterType.LONG,id_ejercicio,DetalleRecapConstantesFunciones.IDEJERCICIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEjercicio);

			DetalleRecapLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEjercicio","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detallerecaps=detallerecapDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleRecapConstantesFunciones.refrescarForeignKeysDescripcionesDetalleRecap(this.detallerecaps);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getDetalleRecapsFK_IdEmpresaWithConnection(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleRecap.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,DetalleRecapConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			DetalleRecapLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detallerecaps=detallerecapDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleRecapConstantesFunciones.refrescarForeignKeysDescripcionesDetalleRecap(this.detallerecaps);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getDetalleRecapsFK_IdEmpresa(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,DetalleRecapConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			DetalleRecapLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detallerecaps=detallerecapDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleRecapConstantesFunciones.refrescarForeignKeysDescripcionesDetalleRecap(this.detallerecaps);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getDetalleRecapsFK_IdRecapWithConnection(String sFinalQuery,Pagination pagination,Long id_recap)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleRecap.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidRecap= new ParameterSelectionGeneral();
			parameterSelectionGeneralidRecap.setParameterSelectionGeneralEqual(ParameterType.LONG,id_recap,DetalleRecapConstantesFunciones.IDRECAP,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidRecap);

			DetalleRecapLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdRecap","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detallerecaps=detallerecapDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleRecapConstantesFunciones.refrescarForeignKeysDescripcionesDetalleRecap(this.detallerecaps);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getDetalleRecapsFK_IdRecap(String sFinalQuery,Pagination pagination,Long id_recap)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidRecap= new ParameterSelectionGeneral();
			parameterSelectionGeneralidRecap.setParameterSelectionGeneralEqual(ParameterType.LONG,id_recap,DetalleRecapConstantesFunciones.IDRECAP,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidRecap);

			DetalleRecapLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdRecap","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detallerecaps=detallerecapDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleRecapConstantesFunciones.refrescarForeignKeysDescripcionesDetalleRecap(this.detallerecaps);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getDetalleRecapsFK_IdSucursalWithConnection(String sFinalQuery,Pagination pagination,Long id_sucursal)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleRecap.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidSucursal= new ParameterSelectionGeneral();
			parameterSelectionGeneralidSucursal.setParameterSelectionGeneralEqual(ParameterType.LONG,id_sucursal,DetalleRecapConstantesFunciones.IDSUCURSAL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidSucursal);

			DetalleRecapLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdSucursal","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detallerecaps=detallerecapDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleRecapConstantesFunciones.refrescarForeignKeysDescripcionesDetalleRecap(this.detallerecaps);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getDetalleRecapsFK_IdSucursal(String sFinalQuery,Pagination pagination,Long id_sucursal)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidSucursal= new ParameterSelectionGeneral();
			parameterSelectionGeneralidSucursal.setParameterSelectionGeneralEqual(ParameterType.LONG,id_sucursal,DetalleRecapConstantesFunciones.IDSUCURSAL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidSucursal);

			DetalleRecapLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdSucursal","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detallerecaps=detallerecapDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleRecapConstantesFunciones.refrescarForeignKeysDescripcionesDetalleRecap(this.detallerecaps);
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
			if(DetalleRecapConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,DetalleRecapDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,DetalleRecap detallerecap,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(DetalleRecapConstantesFunciones.ISCONAUDITORIA) {
				if(detallerecap.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,DetalleRecapDataAccess.TABLENAME, detallerecap.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(DetalleRecapConstantesFunciones.ISCONAUDITORIADETALLE) {
						////DetalleRecapLogic.registrarAuditoriaDetallesDetalleRecap(connexion,detallerecap,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(detallerecap.getIsDeleted()) {
					/*if(!detallerecap.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,DetalleRecapDataAccess.TABLENAME, detallerecap.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////DetalleRecapLogic.registrarAuditoriaDetallesDetalleRecap(connexion,detallerecap,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,DetalleRecapDataAccess.TABLENAME, detallerecap.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(detallerecap.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,DetalleRecapDataAccess.TABLENAME, detallerecap.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(DetalleRecapConstantesFunciones.ISCONAUDITORIADETALLE) {
						////DetalleRecapLogic.registrarAuditoriaDetallesDetalleRecap(connexion,detallerecap,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesDetalleRecap(Connexion connexion,DetalleRecap detallerecap)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(detallerecap.getIsNew()||!detallerecap.getid_recap().equals(detallerecap.getDetalleRecapOriginal().getid_recap()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detallerecap.getDetalleRecapOriginal().getid_recap()!=null)
				{
					strValorActual=detallerecap.getDetalleRecapOriginal().getid_recap().toString();
				}
				if(detallerecap.getid_recap()!=null)
				{
					strValorNuevo=detallerecap.getid_recap().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleRecapConstantesFunciones.IDRECAP,strValorActual,strValorNuevo);
			}	
			
			if(detallerecap.getIsNew()||!detallerecap.getid_empresa().equals(detallerecap.getDetalleRecapOriginal().getid_empresa()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detallerecap.getDetalleRecapOriginal().getid_empresa()!=null)
				{
					strValorActual=detallerecap.getDetalleRecapOriginal().getid_empresa().toString();
				}
				if(detallerecap.getid_empresa()!=null)
				{
					strValorNuevo=detallerecap.getid_empresa().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleRecapConstantesFunciones.IDEMPRESA,strValorActual,strValorNuevo);
			}	
			
			if(detallerecap.getIsNew()||!detallerecap.getid_sucursal().equals(detallerecap.getDetalleRecapOriginal().getid_sucursal()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detallerecap.getDetalleRecapOriginal().getid_sucursal()!=null)
				{
					strValorActual=detallerecap.getDetalleRecapOriginal().getid_sucursal().toString();
				}
				if(detallerecap.getid_sucursal()!=null)
				{
					strValorNuevo=detallerecap.getid_sucursal().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleRecapConstantesFunciones.IDSUCURSAL,strValorActual,strValorNuevo);
			}	
			
			if(detallerecap.getIsNew()||!detallerecap.getid_ejercicio().equals(detallerecap.getDetalleRecapOriginal().getid_ejercicio()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detallerecap.getDetalleRecapOriginal().getid_ejercicio()!=null)
				{
					strValorActual=detallerecap.getDetalleRecapOriginal().getid_ejercicio().toString();
				}
				if(detallerecap.getid_ejercicio()!=null)
				{
					strValorNuevo=detallerecap.getid_ejercicio().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleRecapConstantesFunciones.IDEJERCICIO,strValorActual,strValorNuevo);
			}	
			
			if(detallerecap.getIsNew()||!detallerecap.getid_detalle_cliente().equals(detallerecap.getDetalleRecapOriginal().getid_detalle_cliente()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detallerecap.getDetalleRecapOriginal().getid_detalle_cliente()!=null)
				{
					strValorActual=detallerecap.getDetalleRecapOriginal().getid_detalle_cliente().toString();
				}
				if(detallerecap.getid_detalle_cliente()!=null)
				{
					strValorNuevo=detallerecap.getid_detalle_cliente().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleRecapConstantesFunciones.IDDETALLECLIENTE,strValorActual,strValorNuevo);
			}	
			
			if(detallerecap.getIsNew()||!detallerecap.getid_cliente().equals(detallerecap.getDetalleRecapOriginal().getid_cliente()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detallerecap.getDetalleRecapOriginal().getid_cliente()!=null)
				{
					strValorActual=detallerecap.getDetalleRecapOriginal().getid_cliente().toString();
				}
				if(detallerecap.getid_cliente()!=null)
				{
					strValorNuevo=detallerecap.getid_cliente().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleRecapConstantesFunciones.IDCLIENTE,strValorActual,strValorNuevo);
			}	
			
			if(detallerecap.getIsNew()||!detallerecap.getvalor().equals(detallerecap.getDetalleRecapOriginal().getvalor()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detallerecap.getDetalleRecapOriginal().getvalor()!=null)
				{
					strValorActual=detallerecap.getDetalleRecapOriginal().getvalor().toString();
				}
				if(detallerecap.getvalor()!=null)
				{
					strValorNuevo=detallerecap.getvalor().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleRecapConstantesFunciones.VALOR,strValorActual,strValorNuevo);
			}	
			
			if(detallerecap.getIsNew()||!detallerecap.getiva_porcentaje().equals(detallerecap.getDetalleRecapOriginal().getiva_porcentaje()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detallerecap.getDetalleRecapOriginal().getiva_porcentaje()!=null)
				{
					strValorActual=detallerecap.getDetalleRecapOriginal().getiva_porcentaje().toString();
				}
				if(detallerecap.getiva_porcentaje()!=null)
				{
					strValorNuevo=detallerecap.getiva_porcentaje().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleRecapConstantesFunciones.IVAPORCENTAJE,strValorActual,strValorNuevo);
			}	
			
			if(detallerecap.getIsNew()||!detallerecap.gettotal().equals(detallerecap.getDetalleRecapOriginal().gettotal()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detallerecap.getDetalleRecapOriginal().gettotal()!=null)
				{
					strValorActual=detallerecap.getDetalleRecapOriginal().gettotal().toString();
				}
				if(detallerecap.gettotal()!=null)
				{
					strValorNuevo=detallerecap.gettotal().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleRecapConstantesFunciones.TOTAL,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void saveDetalleRecapRelacionesWithConnection(DetalleRecap detallerecap) throws Exception {

		if(!detallerecap.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveDetalleRecapRelacionesBase(detallerecap,true);
		}
	}

	public void saveDetalleRecapRelaciones(DetalleRecap detallerecap)throws Exception {

		if(!detallerecap.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveDetalleRecapRelacionesBase(detallerecap,false);
		}
	}

	public void saveDetalleRecapRelacionesBase(DetalleRecap detallerecap,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("DetalleRecap-saveRelacionesWithConnection");}
	

			this.setDetalleRecap(detallerecap);

			if(DetalleRecapLogicAdditional.validarSaveRelaciones(detallerecap,this)) {

				DetalleRecapLogicAdditional.updateRelacionesToSave(detallerecap,this);

				if((detallerecap.getIsNew()||detallerecap.getIsChanged())&&!detallerecap.getIsDeleted()) {
					this.saveDetalleRecap();
					this.saveDetalleRecapRelacionesDetalles();

				} else if(detallerecap.getIsDeleted()) {
					this.saveDetalleRecapRelacionesDetalles();
					this.saveDetalleRecap();
				}

				DetalleRecapLogicAdditional.updateRelacionesToSaveAfter(detallerecap,this);

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
	
	
	private void saveDetalleRecapRelacionesDetalles()throws Exception {
		try {
	

		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfDetalleRecap(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=DetalleRecapConstantesFunciones.getClassesForeignKeysOfDetalleRecap(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfDetalleRecap(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=DetalleRecapConstantesFunciones.getClassesRelationshipsOfDetalleRecap(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}
