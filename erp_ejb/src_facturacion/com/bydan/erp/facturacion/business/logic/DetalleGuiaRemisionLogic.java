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
import com.bydan.erp.facturacion.util.DetalleGuiaRemisionConstantesFunciones;
import com.bydan.erp.facturacion.util.DetalleGuiaRemisionParameterReturnGeneral;
//import com.bydan.erp.facturacion.util.DetalleGuiaRemisionParameterGeneral;
import com.bydan.erp.facturacion.business.entity.DetalleGuiaRemision;
import com.bydan.erp.facturacion.business.logic.DetalleGuiaRemisionLogicAdditional;
import com.bydan.erp.facturacion.business.dataaccess.*;
import com.bydan.erp.facturacion.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.inventario.business.entity.*;


import com.bydan.erp.seguridad.business.logic.*;
import com.bydan.erp.contabilidad.business.logic.*;
import com.bydan.erp.inventario.business.logic.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.contabilidad.util.*;
import com.bydan.erp.inventario.util.*;


import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.contabilidad.business.dataaccess.*;
import com.bydan.erp.inventario.business.dataaccess.*;








@SuppressWarnings("unused")
public class DetalleGuiaRemisionLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(DetalleGuiaRemisionLogic.class);
	
	protected DetalleGuiaRemisionDataAccess detalleguiaremisionDataAccess; 	
	protected DetalleGuiaRemision detalleguiaremision;
	protected List<DetalleGuiaRemision> detalleguiaremisions;
	protected Object detalleguiaremisionObject;	
	protected List<Object> detalleguiaremisionsObject;
	
	public static ClassValidator<DetalleGuiaRemision> detalleguiaremisionValidator = new ClassValidator<DetalleGuiaRemision>(DetalleGuiaRemision.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected DetalleGuiaRemisionLogicAdditional detalleguiaremisionLogicAdditional=null;
	
	public DetalleGuiaRemisionLogicAdditional getDetalleGuiaRemisionLogicAdditional() {
		return this.detalleguiaremisionLogicAdditional;
	}
	
	public void setDetalleGuiaRemisionLogicAdditional(DetalleGuiaRemisionLogicAdditional detalleguiaremisionLogicAdditional) {
		try {
			this.detalleguiaremisionLogicAdditional=detalleguiaremisionLogicAdditional;
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
	
	
	
	
	public  DetalleGuiaRemisionLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.detalleguiaremisionDataAccess = new DetalleGuiaRemisionDataAccess();
			
			this.detalleguiaremisions= new ArrayList<DetalleGuiaRemision>();
			this.detalleguiaremision= new DetalleGuiaRemision();
			
			this.detalleguiaremisionObject=new Object();
			this.detalleguiaremisionsObject=new ArrayList<Object>();
				
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
			
			this.detalleguiaremisionDataAccess.setConnexionType(this.connexionType);
			this.detalleguiaremisionDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  DetalleGuiaRemisionLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.detalleguiaremisionDataAccess = new DetalleGuiaRemisionDataAccess();
			this.detalleguiaremisions= new ArrayList<DetalleGuiaRemision>();
			this.detalleguiaremision= new DetalleGuiaRemision();
			this.detalleguiaremisionObject=new Object();
			this.detalleguiaremisionsObject=new ArrayList<Object>();
			
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
			
			this.detalleguiaremisionDataAccess.setConnexionType(this.connexionType);
			this.detalleguiaremisionDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public DetalleGuiaRemision getDetalleGuiaRemision() throws Exception {	
		DetalleGuiaRemisionLogicAdditional.checkDetalleGuiaRemisionToGet(detalleguiaremision,this.datosCliente,this.arrDatoGeneral);
		DetalleGuiaRemisionLogicAdditional.updateDetalleGuiaRemisionToGet(detalleguiaremision,this.arrDatoGeneral);
		
		return detalleguiaremision;
	}
		
	public void setDetalleGuiaRemision(DetalleGuiaRemision newDetalleGuiaRemision) {
		this.detalleguiaremision = newDetalleGuiaRemision;
	}
	
	public DetalleGuiaRemisionDataAccess getDetalleGuiaRemisionDataAccess() {
		return detalleguiaremisionDataAccess;
	}
	
	public void setDetalleGuiaRemisionDataAccess(DetalleGuiaRemisionDataAccess newdetalleguiaremisionDataAccess) {
		this.detalleguiaremisionDataAccess = newdetalleguiaremisionDataAccess;
	}
	
	public List<DetalleGuiaRemision> getDetalleGuiaRemisions() throws Exception {		
		this.quitarDetalleGuiaRemisionsNulos();
		
		DetalleGuiaRemisionLogicAdditional.checkDetalleGuiaRemisionToGets(detalleguiaremisions,this.datosCliente,this.arrDatoGeneral);
		
		for (DetalleGuiaRemision detalleguiaremisionLocal: detalleguiaremisions ) {
			DetalleGuiaRemisionLogicAdditional.updateDetalleGuiaRemisionToGet(detalleguiaremisionLocal,this.arrDatoGeneral);
		}
		
		return detalleguiaremisions;
	}
	
	public void setDetalleGuiaRemisions(List<DetalleGuiaRemision> newDetalleGuiaRemisions) {
		this.detalleguiaremisions = newDetalleGuiaRemisions;
	}
	
	public Object getDetalleGuiaRemisionObject() {	
		this.detalleguiaremisionObject=this.detalleguiaremisionDataAccess.getEntityObject();
		return this.detalleguiaremisionObject;
	}
		
	public void setDetalleGuiaRemisionObject(Object newDetalleGuiaRemisionObject) {
		this.detalleguiaremisionObject = newDetalleGuiaRemisionObject;
	}
	
	public List<Object> getDetalleGuiaRemisionsObject() {		
		this.detalleguiaremisionsObject=this.detalleguiaremisionDataAccess.getEntitiesObject();
		return this.detalleguiaremisionsObject;
	}
		
	public void setDetalleGuiaRemisionsObject(List<Object> newDetalleGuiaRemisionsObject) {
		this.detalleguiaremisionsObject = newDetalleGuiaRemisionsObject;
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
		
		if(this.detalleguiaremisionDataAccess!=null) {
			this.detalleguiaremisionDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleGuiaRemision.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			detalleguiaremisionDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			detalleguiaremisionDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		detalleguiaremision = new  DetalleGuiaRemision();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleGuiaRemision.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			detalleguiaremision=detalleguiaremisionDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.detalleguiaremision,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				DetalleGuiaRemisionConstantesFunciones.refrescarForeignKeysDescripcionesDetalleGuiaRemision(this.detalleguiaremision);
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
		detalleguiaremision = new  DetalleGuiaRemision();
		  		  
        try {
			
			detalleguiaremision=detalleguiaremisionDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.detalleguiaremision,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				DetalleGuiaRemisionConstantesFunciones.refrescarForeignKeysDescripcionesDetalleGuiaRemision(this.detalleguiaremision);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		detalleguiaremision = new  DetalleGuiaRemision();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleGuiaRemision.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			detalleguiaremision=detalleguiaremisionDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.detalleguiaremision,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				DetalleGuiaRemisionConstantesFunciones.refrescarForeignKeysDescripcionesDetalleGuiaRemision(this.detalleguiaremision);
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
		detalleguiaremision = new  DetalleGuiaRemision();
		  		  
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
		detalleguiaremision = new  DetalleGuiaRemision();
		  		  
        try {
			
			detalleguiaremision=detalleguiaremisionDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.detalleguiaremision,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				DetalleGuiaRemisionConstantesFunciones.refrescarForeignKeysDescripcionesDetalleGuiaRemision(this.detalleguiaremision);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		detalleguiaremision = new  DetalleGuiaRemision();
		  		  
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
		detalleguiaremision = new  DetalleGuiaRemision();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleGuiaRemision.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =detalleguiaremisionDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		detalleguiaremision = new  DetalleGuiaRemision();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=detalleguiaremisionDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		detalleguiaremision = new  DetalleGuiaRemision();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleGuiaRemision.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =detalleguiaremisionDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		detalleguiaremision = new  DetalleGuiaRemision();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=detalleguiaremisionDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		detalleguiaremision = new  DetalleGuiaRemision();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleGuiaRemision.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =detalleguiaremisionDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		detalleguiaremision = new  DetalleGuiaRemision();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=detalleguiaremisionDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		detalleguiaremisions = new  ArrayList<DetalleGuiaRemision>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleGuiaRemision.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			DetalleGuiaRemisionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detalleguiaremisions=detalleguiaremisionDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarDetalleGuiaRemision(detalleguiaremisions);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetalleGuiaRemisionConstantesFunciones.refrescarForeignKeysDescripcionesDetalleGuiaRemision(this.detalleguiaremisions);
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
		detalleguiaremisions = new  ArrayList<DetalleGuiaRemision>();
		  		  
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
		detalleguiaremisions = new  ArrayList<DetalleGuiaRemision>();
		  		  
        try {			
			DetalleGuiaRemisionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detalleguiaremisions=detalleguiaremisionDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarDetalleGuiaRemision(detalleguiaremisions);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetalleGuiaRemisionConstantesFunciones.refrescarForeignKeysDescripcionesDetalleGuiaRemision(this.detalleguiaremisions);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		detalleguiaremisions = new  ArrayList<DetalleGuiaRemision>();
		  		  
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
		detalleguiaremisions = new  ArrayList<DetalleGuiaRemision>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleGuiaRemision.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			DetalleGuiaRemisionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detalleguiaremisions=detalleguiaremisionDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarDetalleGuiaRemision(detalleguiaremisions);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetalleGuiaRemisionConstantesFunciones.refrescarForeignKeysDescripcionesDetalleGuiaRemision(this.detalleguiaremisions);
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
		detalleguiaremisions = new  ArrayList<DetalleGuiaRemision>();
		  		  
        try {
			DetalleGuiaRemisionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detalleguiaremisions=detalleguiaremisionDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarDetalleGuiaRemision(detalleguiaremisions);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetalleGuiaRemisionConstantesFunciones.refrescarForeignKeysDescripcionesDetalleGuiaRemision(this.detalleguiaremisions);
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
		detalleguiaremisions = new  ArrayList<DetalleGuiaRemision>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleGuiaRemision.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			DetalleGuiaRemisionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detalleguiaremisions=detalleguiaremisionDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarDetalleGuiaRemision(detalleguiaremisions);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetalleGuiaRemisionConstantesFunciones.refrescarForeignKeysDescripcionesDetalleGuiaRemision(this.detalleguiaremisions);
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
		detalleguiaremisions = new  ArrayList<DetalleGuiaRemision>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			DetalleGuiaRemisionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detalleguiaremisions=detalleguiaremisionDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarDetalleGuiaRemision(detalleguiaremisions);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetalleGuiaRemisionConstantesFunciones.refrescarForeignKeysDescripcionesDetalleGuiaRemision(this.detalleguiaremisions);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		detalleguiaremision = new  DetalleGuiaRemision();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleGuiaRemision.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			DetalleGuiaRemisionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detalleguiaremision=detalleguiaremisionDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarDetalleGuiaRemision(detalleguiaremision);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetalleGuiaRemisionConstantesFunciones.refrescarForeignKeysDescripcionesDetalleGuiaRemision(this.detalleguiaremision);
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
		detalleguiaremision = new  DetalleGuiaRemision();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			DetalleGuiaRemisionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detalleguiaremision=detalleguiaremisionDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarDetalleGuiaRemision(detalleguiaremision);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetalleGuiaRemisionConstantesFunciones.refrescarForeignKeysDescripcionesDetalleGuiaRemision(this.detalleguiaremision);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		detalleguiaremisions = new  ArrayList<DetalleGuiaRemision>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleGuiaRemision.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			DetalleGuiaRemisionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detalleguiaremisions=detalleguiaremisionDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarDetalleGuiaRemision(detalleguiaremisions);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetalleGuiaRemisionConstantesFunciones.refrescarForeignKeysDescripcionesDetalleGuiaRemision(this.detalleguiaremisions);
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
		detalleguiaremisions = new  ArrayList<DetalleGuiaRemision>();
		  		  
        try {
			DetalleGuiaRemisionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detalleguiaremisions=detalleguiaremisionDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarDetalleGuiaRemision(detalleguiaremisions);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetalleGuiaRemisionConstantesFunciones.refrescarForeignKeysDescripcionesDetalleGuiaRemision(this.detalleguiaremisions);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosDetalleGuiaRemisionsWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		detalleguiaremisions = new  ArrayList<DetalleGuiaRemision>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleGuiaRemision.class.getSimpleName()+"-getTodosDetalleGuiaRemisionsWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			DetalleGuiaRemisionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detalleguiaremisions=detalleguiaremisionDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarDetalleGuiaRemision(detalleguiaremisions);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetalleGuiaRemisionConstantesFunciones.refrescarForeignKeysDescripcionesDetalleGuiaRemision(this.detalleguiaremisions);
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
	
	public  void  getTodosDetalleGuiaRemisions(String sFinalQuery,Pagination pagination)throws Exception {
		detalleguiaremisions = new  ArrayList<DetalleGuiaRemision>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			DetalleGuiaRemisionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detalleguiaremisions=detalleguiaremisionDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarDetalleGuiaRemision(detalleguiaremisions);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetalleGuiaRemisionConstantesFunciones.refrescarForeignKeysDescripcionesDetalleGuiaRemision(this.detalleguiaremisions);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarDetalleGuiaRemision(DetalleGuiaRemision detalleguiaremision) throws Exception {
		Boolean estaValidado=false;
		
		if(detalleguiaremision.getIsNew() || detalleguiaremision.getIsChanged()) { 
			this.invalidValues = detalleguiaremisionValidator.getInvalidValues(detalleguiaremision);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(detalleguiaremision);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarDetalleGuiaRemision(List<DetalleGuiaRemision> DetalleGuiaRemisions) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(DetalleGuiaRemision detalleguiaremisionLocal:detalleguiaremisions) {				
			estaValidadoObjeto=this.validarGuardarDetalleGuiaRemision(detalleguiaremisionLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarDetalleGuiaRemision(List<DetalleGuiaRemision> DetalleGuiaRemisions) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarDetalleGuiaRemision(detalleguiaremisions)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarDetalleGuiaRemision(DetalleGuiaRemision DetalleGuiaRemision) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarDetalleGuiaRemision(detalleguiaremision)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(DetalleGuiaRemision detalleguiaremision) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+detalleguiaremision.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=DetalleGuiaRemisionConstantesFunciones.getDetalleGuiaRemisionLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"detalleguiaremision","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(DetalleGuiaRemisionConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(DetalleGuiaRemisionConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveDetalleGuiaRemisionWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleGuiaRemision.class.getSimpleName()+"-saveDetalleGuiaRemisionWithConnection");connexion.begin();			
			
			DetalleGuiaRemisionLogicAdditional.checkDetalleGuiaRemisionToSave(this.detalleguiaremision,this.datosCliente,connexion,this.arrDatoGeneral);
			
			DetalleGuiaRemisionLogicAdditional.updateDetalleGuiaRemisionToSave(this.detalleguiaremision,this.arrDatoGeneral);
			
			DetalleGuiaRemisionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.detalleguiaremision,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowDetalleGuiaRemision();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarDetalleGuiaRemision(this.detalleguiaremision)) {
				DetalleGuiaRemisionDataAccess.save(this.detalleguiaremision, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.detalleguiaremision,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			DetalleGuiaRemisionLogicAdditional.checkDetalleGuiaRemisionToSaveAfter(this.detalleguiaremision,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowDetalleGuiaRemision();
			
			connexion.commit();			
			
			if(this.detalleguiaremision.getIsDeleted()) {
				this.detalleguiaremision=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveDetalleGuiaRemision()throws Exception {	
		try {	
			
			DetalleGuiaRemisionLogicAdditional.checkDetalleGuiaRemisionToSave(this.detalleguiaremision,this.datosCliente,connexion,this.arrDatoGeneral);
			
			DetalleGuiaRemisionLogicAdditional.updateDetalleGuiaRemisionToSave(this.detalleguiaremision,this.arrDatoGeneral);
			
			DetalleGuiaRemisionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.detalleguiaremision,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarDetalleGuiaRemision(this.detalleguiaremision)) {			
				DetalleGuiaRemisionDataAccess.save(this.detalleguiaremision, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.detalleguiaremision,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			DetalleGuiaRemisionLogicAdditional.checkDetalleGuiaRemisionToSaveAfter(this.detalleguiaremision,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.detalleguiaremision.getIsDeleted()) {
				this.detalleguiaremision=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveDetalleGuiaRemisionsWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleGuiaRemision.class.getSimpleName()+"-saveDetalleGuiaRemisionsWithConnection");connexion.begin();			
			
			DetalleGuiaRemisionLogicAdditional.checkDetalleGuiaRemisionToSaves(detalleguiaremisions,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowDetalleGuiaRemisions();
			
			Boolean validadoTodosDetalleGuiaRemision=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(DetalleGuiaRemision detalleguiaremisionLocal:detalleguiaremisions) {		
				if(detalleguiaremisionLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				DetalleGuiaRemisionLogicAdditional.updateDetalleGuiaRemisionToSave(detalleguiaremisionLocal,this.arrDatoGeneral);
	        	
				DetalleGuiaRemisionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),detalleguiaremisionLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarDetalleGuiaRemision(detalleguiaremisionLocal)) {
					DetalleGuiaRemisionDataAccess.save(detalleguiaremisionLocal, connexion);				
				} else {
					validadoTodosDetalleGuiaRemision=false;
				}
			}
			
			if(!validadoTodosDetalleGuiaRemision) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			DetalleGuiaRemisionLogicAdditional.checkDetalleGuiaRemisionToSavesAfter(detalleguiaremisions,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowDetalleGuiaRemisions();
			
			connexion.commit();		
			
			this.quitarDetalleGuiaRemisionsEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveDetalleGuiaRemisions()throws Exception {				
		 try {	
			DetalleGuiaRemisionLogicAdditional.checkDetalleGuiaRemisionToSaves(detalleguiaremisions,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosDetalleGuiaRemision=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(DetalleGuiaRemision detalleguiaremisionLocal:detalleguiaremisions) {				
				if(detalleguiaremisionLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				DetalleGuiaRemisionLogicAdditional.updateDetalleGuiaRemisionToSave(detalleguiaremisionLocal,this.arrDatoGeneral);
	        	
				DetalleGuiaRemisionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),detalleguiaremisionLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarDetalleGuiaRemision(detalleguiaremisionLocal)) {				
					DetalleGuiaRemisionDataAccess.save(detalleguiaremisionLocal, connexion);				
				} else {
					validadoTodosDetalleGuiaRemision=false;
				}
			}
			
			if(!validadoTodosDetalleGuiaRemision) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			DetalleGuiaRemisionLogicAdditional.checkDetalleGuiaRemisionToSavesAfter(detalleguiaremisions,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarDetalleGuiaRemisionsEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public DetalleGuiaRemisionParameterReturnGeneral procesarAccionDetalleGuiaRemisions(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<DetalleGuiaRemision> detalleguiaremisions,DetalleGuiaRemisionParameterReturnGeneral detalleguiaremisionParameterGeneral)throws Exception {
		 try {	
			DetalleGuiaRemisionParameterReturnGeneral detalleguiaremisionReturnGeneral=new DetalleGuiaRemisionParameterReturnGeneral();
	
			DetalleGuiaRemisionLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,detalleguiaremisions,detalleguiaremisionParameterGeneral,detalleguiaremisionReturnGeneral);
			
			return detalleguiaremisionReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public DetalleGuiaRemisionParameterReturnGeneral procesarAccionDetalleGuiaRemisionsWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<DetalleGuiaRemision> detalleguiaremisions,DetalleGuiaRemisionParameterReturnGeneral detalleguiaremisionParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleGuiaRemision.class.getSimpleName()+"-procesarAccionDetalleGuiaRemisionsWithConnection");connexion.begin();			
			
			DetalleGuiaRemisionParameterReturnGeneral detalleguiaremisionReturnGeneral=new DetalleGuiaRemisionParameterReturnGeneral();
	
			DetalleGuiaRemisionLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,detalleguiaremisions,detalleguiaremisionParameterGeneral,detalleguiaremisionReturnGeneral);
			
			this.connexion.commit();
			
			return detalleguiaremisionReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public DetalleGuiaRemisionParameterReturnGeneral procesarEventosDetalleGuiaRemisions(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<DetalleGuiaRemision> detalleguiaremisions,DetalleGuiaRemision detalleguiaremision,DetalleGuiaRemisionParameterReturnGeneral detalleguiaremisionParameterGeneral,Boolean isEsNuevoDetalleGuiaRemision,ArrayList<Classe> clases)throws Exception {
		 try {	
			DetalleGuiaRemisionParameterReturnGeneral detalleguiaremisionReturnGeneral=new DetalleGuiaRemisionParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				detalleguiaremisionReturnGeneral.setConRecargarPropiedades(true);
			}
			
			DetalleGuiaRemisionLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,detalleguiaremisions,detalleguiaremision,detalleguiaremisionParameterGeneral,detalleguiaremisionReturnGeneral,isEsNuevoDetalleGuiaRemision,clases);
			
			return detalleguiaremisionReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public DetalleGuiaRemisionParameterReturnGeneral procesarEventosDetalleGuiaRemisionsWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<DetalleGuiaRemision> detalleguiaremisions,DetalleGuiaRemision detalleguiaremision,DetalleGuiaRemisionParameterReturnGeneral detalleguiaremisionParameterGeneral,Boolean isEsNuevoDetalleGuiaRemision,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleGuiaRemision.class.getSimpleName()+"-procesarEventosDetalleGuiaRemisionsWithConnection");connexion.begin();			
			
			DetalleGuiaRemisionParameterReturnGeneral detalleguiaremisionReturnGeneral=new DetalleGuiaRemisionParameterReturnGeneral();
	
			detalleguiaremisionReturnGeneral.setDetalleGuiaRemision(detalleguiaremision);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				detalleguiaremisionReturnGeneral.setConRecargarPropiedades(true);
			}
			
			DetalleGuiaRemisionLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,detalleguiaremisions,detalleguiaremision,detalleguiaremisionParameterGeneral,detalleguiaremisionReturnGeneral,isEsNuevoDetalleGuiaRemision,clases);
			
			this.connexion.commit();
			
			return detalleguiaremisionReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public DetalleGuiaRemisionParameterReturnGeneral procesarImportacionDetalleGuiaRemisionsWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,DetalleGuiaRemisionParameterReturnGeneral detalleguiaremisionParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleGuiaRemision.class.getSimpleName()+"-procesarImportacionDetalleGuiaRemisionsWithConnection");connexion.begin();			
			
			DetalleGuiaRemisionParameterReturnGeneral detalleguiaremisionReturnGeneral=new DetalleGuiaRemisionParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.detalleguiaremisions=new ArrayList<DetalleGuiaRemision>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.detalleguiaremision=new DetalleGuiaRemision();
				
				
				if(conColumnasBase) {this.detalleguiaremision.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.detalleguiaremision.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.detalleguiaremision.setcantidad_envases(Integer.parseInt(arrColumnas[iColumn++]));
				this.detalleguiaremision.setcantidad_auxiliar(Integer.parseInt(arrColumnas[iColumn++]));
			this.detalleguiaremision.setdescripcion(arrColumnas[iColumn++]);
				this.detalleguiaremision.setcantidad(Integer.parseInt(arrColumnas[iColumn++]));
				this.detalleguiaremision.setmonto(Double.parseDouble(arrColumnas[iColumn++]));
				this.detalleguiaremision.setprecio(Double.parseDouble(arrColumnas[iColumn++]));
				this.detalleguiaremision.setporcentaje_descuento(Double.parseDouble(arrColumnas[iColumn++]));
				this.detalleguiaremision.setdescuento(Double.parseDouble(arrColumnas[iColumn++]));
				this.detalleguiaremision.setdescuento2(Double.parseDouble(arrColumnas[iColumn++]));
				this.detalleguiaremision.setdescuento3(Double.parseDouble(arrColumnas[iColumn++]));
				this.detalleguiaremision.setporcentaje_iva(Double.parseDouble(arrColumnas[iColumn++]));
				this.detalleguiaremision.setiva(Double.parseDouble(arrColumnas[iColumn++]));
				this.detalleguiaremision.settotal_descuento(Double.parseDouble(arrColumnas[iColumn++]));
				this.detalleguiaremision.settotal_impuesto(Double.parseDouble(arrColumnas[iColumn++]));
				this.detalleguiaremision.setsub_total(Double.parseDouble(arrColumnas[iColumn++]));
				this.detalleguiaremision.settotal(Double.parseDouble(arrColumnas[iColumn++]));
				this.detalleguiaremision.setlote(arrColumnas[iColumn++]);
				this.detalleguiaremision.setlote_cliente(arrColumnas[iColumn++]);
				this.detalleguiaremision.setorden_compra(arrColumnas[iColumn++]);
				this.detalleguiaremision.setarea(arrColumnas[iColumn++]);
				this.detalleguiaremision.setmedidas(arrColumnas[iColumn++]);
				this.detalleguiaremision.setacabado(arrColumnas[iColumn++]);
				this.detalleguiaremision.setacabado2(arrColumnas[iColumn++]);
				
				this.detalleguiaremisions.add(this.detalleguiaremision);
			}
			
			this.saveDetalleGuiaRemisions();
			
			this.connexion.commit();
			
			detalleguiaremisionReturnGeneral.setConRetornoEstaProcesado(true);
			detalleguiaremisionReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return detalleguiaremisionReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarDetalleGuiaRemisionsEliminados() throws Exception {				
		
		List<DetalleGuiaRemision> detalleguiaremisionsAux= new ArrayList<DetalleGuiaRemision>();
		
		for(DetalleGuiaRemision detalleguiaremision:detalleguiaremisions) {
			if(!detalleguiaremision.getIsDeleted()) {
				detalleguiaremisionsAux.add(detalleguiaremision);
			}
		}
		
		detalleguiaremisions=detalleguiaremisionsAux;
	}
	
	public void quitarDetalleGuiaRemisionsNulos() throws Exception {				
		
		List<DetalleGuiaRemision> detalleguiaremisionsAux= new ArrayList<DetalleGuiaRemision>();
		
		for(DetalleGuiaRemision detalleguiaremision : this.detalleguiaremisions) {
			if(detalleguiaremision==null) {
				detalleguiaremisionsAux.add(detalleguiaremision);
			}
		}
		
		//this.detalleguiaremisions=detalleguiaremisionsAux;
		
		this.detalleguiaremisions.removeAll(detalleguiaremisionsAux);
	}
	
	public void getSetVersionRowDetalleGuiaRemisionWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(detalleguiaremision.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((detalleguiaremision.getIsDeleted() || (detalleguiaremision.getIsChanged()&&!detalleguiaremision.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=detalleguiaremisionDataAccess.getSetVersionRowDetalleGuiaRemision(connexion,detalleguiaremision.getId());
				
				if(!detalleguiaremision.getVersionRow().equals(timestamp)) {	
					detalleguiaremision.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				detalleguiaremision.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowDetalleGuiaRemision()throws Exception {	
		
		if(detalleguiaremision.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((detalleguiaremision.getIsDeleted() || (detalleguiaremision.getIsChanged()&&!detalleguiaremision.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=detalleguiaremisionDataAccess.getSetVersionRowDetalleGuiaRemision(connexion,detalleguiaremision.getId());
			
			try {							
				if(!detalleguiaremision.getVersionRow().equals(timestamp)) {	
					detalleguiaremision.setVersionRow(timestamp);
				}
				
				detalleguiaremision.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowDetalleGuiaRemisionsWithConnection()throws Exception {	
		if(detalleguiaremisions!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(DetalleGuiaRemision detalleguiaremisionAux:detalleguiaremisions) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(detalleguiaremisionAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(detalleguiaremisionAux.getIsDeleted() || (detalleguiaremisionAux.getIsChanged()&&!detalleguiaremisionAux.getIsNew())) {
						
						timestamp=detalleguiaremisionDataAccess.getSetVersionRowDetalleGuiaRemision(connexion,detalleguiaremisionAux.getId());
						
						if(!detalleguiaremision.getVersionRow().equals(timestamp)) {	
							detalleguiaremisionAux.setVersionRow(timestamp);
						}
								
						detalleguiaremisionAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowDetalleGuiaRemisions()throws Exception {	
		if(detalleguiaremisions!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(DetalleGuiaRemision detalleguiaremisionAux:detalleguiaremisions) {
					if(detalleguiaremisionAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(detalleguiaremisionAux.getIsDeleted() || (detalleguiaremisionAux.getIsChanged()&&!detalleguiaremisionAux.getIsNew())) {
						
						timestamp=detalleguiaremisionDataAccess.getSetVersionRowDetalleGuiaRemision(connexion,detalleguiaremisionAux.getId());
						
						if(!detalleguiaremisionAux.getVersionRow().equals(timestamp)) {	
							detalleguiaremisionAux.setVersionRow(timestamp);
						}
						
													
						detalleguiaremisionAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public DetalleGuiaRemisionParameterReturnGeneral cargarCombosLoteForeignKeyDetalleGuiaRemisionWithConnection(String finalQueryGlobalEmpresa,String finalQueryGlobalSucursal,String finalQueryGlobalEjercicio,String finalQueryGlobalPeriodo,String finalQueryGlobalGuiaRemision,String finalQueryGlobalBodega,String finalQueryGlobalProducto,String finalQueryGlobalUnidad,String finalQueryGlobalCentroCosto) throws Exception {
		DetalleGuiaRemisionParameterReturnGeneral  detalleguiaremisionReturnGeneral =new DetalleGuiaRemisionParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleGuiaRemision.class.getSimpleName()+"-cargarCombosLoteForeignKeyDetalleGuiaRemisionWithConnection");connexion.begin();
			
			detalleguiaremisionReturnGeneral =new DetalleGuiaRemisionParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			detalleguiaremisionReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Sucursal> sucursalsForeignKey=new ArrayList<Sucursal>();
			SucursalLogic sucursalLogic=new SucursalLogic();
			sucursalLogic.setConnexion(this.connexion);
			//sucursalLogic.getSucursalDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalSucursal.equals("NONE")) {
				sucursalLogic.getTodosSucursals(finalQueryGlobalSucursal,new Pagination());
				sucursalsForeignKey=sucursalLogic.getSucursals();
			}

			detalleguiaremisionReturnGeneral.setsucursalsForeignKey(sucursalsForeignKey);


			List<Ejercicio> ejerciciosForeignKey=new ArrayList<Ejercicio>();
			EjercicioLogic ejercicioLogic=new EjercicioLogic();
			ejercicioLogic.setConnexion(this.connexion);
			//ejercicioLogic.getEjercicioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEjercicio.equals("NONE")) {
				ejercicioLogic.getTodosEjercicios(finalQueryGlobalEjercicio,new Pagination());
				ejerciciosForeignKey=ejercicioLogic.getEjercicios();
			}

			detalleguiaremisionReturnGeneral.setejerciciosForeignKey(ejerciciosForeignKey);


			List<Periodo> periodosForeignKey=new ArrayList<Periodo>();
			PeriodoLogic periodoLogic=new PeriodoLogic();
			periodoLogic.setConnexion(this.connexion);
			//periodoLogic.getPeriodoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalPeriodo.equals("NONE")) {
				periodoLogic.getTodosPeriodos(finalQueryGlobalPeriodo,new Pagination());
				periodosForeignKey=periodoLogic.getPeriodos();
			}

			detalleguiaremisionReturnGeneral.setperiodosForeignKey(periodosForeignKey);


			List<GuiaRemision> guiaremisionsForeignKey=new ArrayList<GuiaRemision>();
			GuiaRemisionLogic guiaremisionLogic=new GuiaRemisionLogic();
			guiaremisionLogic.setConnexion(this.connexion);
			guiaremisionLogic.getGuiaRemisionDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalGuiaRemision.equals("NONE")) {
				guiaremisionLogic.getTodosGuiaRemisions(finalQueryGlobalGuiaRemision,new Pagination());
				guiaremisionsForeignKey=guiaremisionLogic.getGuiaRemisions();
			}

			detalleguiaremisionReturnGeneral.setguiaremisionsForeignKey(guiaremisionsForeignKey);


			List<Bodega> bodegasForeignKey=new ArrayList<Bodega>();
			BodegaLogic bodegaLogic=new BodegaLogic();
			bodegaLogic.setConnexion(this.connexion);
			bodegaLogic.getBodegaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalBodega.equals("NONE")) {
				bodegaLogic.getTodosBodegas(finalQueryGlobalBodega,new Pagination());
				bodegasForeignKey=bodegaLogic.getBodegas();
			}

			detalleguiaremisionReturnGeneral.setbodegasForeignKey(bodegasForeignKey);


			List<Producto> productosForeignKey=new ArrayList<Producto>();
			ProductoLogic productoLogic=new ProductoLogic();
			productoLogic.setConnexion(this.connexion);
			//productoLogic.getProductoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalProducto.equals("NONE")) {
				productoLogic.getTodosProductos(finalQueryGlobalProducto,new Pagination());
				productosForeignKey=productoLogic.getProductos();
			}

			detalleguiaremisionReturnGeneral.setproductosForeignKey(productosForeignKey);


			List<Unidad> unidadsForeignKey=new ArrayList<Unidad>();
			UnidadLogic unidadLogic=new UnidadLogic();
			unidadLogic.setConnexion(this.connexion);
			unidadLogic.getUnidadDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalUnidad.equals("NONE")) {
				unidadLogic.getTodosUnidads(finalQueryGlobalUnidad,new Pagination());
				unidadsForeignKey=unidadLogic.getUnidads();
			}

			detalleguiaremisionReturnGeneral.setunidadsForeignKey(unidadsForeignKey);


			List<CentroCosto> centrocostosForeignKey=new ArrayList<CentroCosto>();
			CentroCostoLogic centrocostoLogic=new CentroCostoLogic();
			centrocostoLogic.setConnexion(this.connexion);
			centrocostoLogic.getCentroCostoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCentroCosto.equals("NONE")) {
				centrocostoLogic.getTodosCentroCostos(finalQueryGlobalCentroCosto,new Pagination());
				centrocostosForeignKey=centrocostoLogic.getCentroCostos();
			}

			detalleguiaremisionReturnGeneral.setcentrocostosForeignKey(centrocostosForeignKey);

			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
		
		return detalleguiaremisionReturnGeneral;
	}
	
	public DetalleGuiaRemisionParameterReturnGeneral cargarCombosLoteForeignKeyDetalleGuiaRemision(String finalQueryGlobalEmpresa,String finalQueryGlobalSucursal,String finalQueryGlobalEjercicio,String finalQueryGlobalPeriodo,String finalQueryGlobalGuiaRemision,String finalQueryGlobalBodega,String finalQueryGlobalProducto,String finalQueryGlobalUnidad,String finalQueryGlobalCentroCosto) throws Exception {
		DetalleGuiaRemisionParameterReturnGeneral  detalleguiaremisionReturnGeneral =new DetalleGuiaRemisionParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {						
			detalleguiaremisionReturnGeneral =new DetalleGuiaRemisionParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			detalleguiaremisionReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Sucursal> sucursalsForeignKey=new ArrayList<Sucursal>();
			SucursalLogic sucursalLogic=new SucursalLogic();
			sucursalLogic.setConnexion(this.connexion);
			//sucursalLogic.getSucursalDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalSucursal.equals("NONE")) {
				sucursalLogic.getTodosSucursals(finalQueryGlobalSucursal,new Pagination());
				sucursalsForeignKey=sucursalLogic.getSucursals();
			}

			detalleguiaremisionReturnGeneral.setsucursalsForeignKey(sucursalsForeignKey);


			List<Ejercicio> ejerciciosForeignKey=new ArrayList<Ejercicio>();
			EjercicioLogic ejercicioLogic=new EjercicioLogic();
			ejercicioLogic.setConnexion(this.connexion);
			//ejercicioLogic.getEjercicioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEjercicio.equals("NONE")) {
				ejercicioLogic.getTodosEjercicios(finalQueryGlobalEjercicio,new Pagination());
				ejerciciosForeignKey=ejercicioLogic.getEjercicios();
			}

			detalleguiaremisionReturnGeneral.setejerciciosForeignKey(ejerciciosForeignKey);


			List<Periodo> periodosForeignKey=new ArrayList<Periodo>();
			PeriodoLogic periodoLogic=new PeriodoLogic();
			periodoLogic.setConnexion(this.connexion);
			//periodoLogic.getPeriodoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalPeriodo.equals("NONE")) {
				periodoLogic.getTodosPeriodos(finalQueryGlobalPeriodo,new Pagination());
				periodosForeignKey=periodoLogic.getPeriodos();
			}

			detalleguiaremisionReturnGeneral.setperiodosForeignKey(periodosForeignKey);


			List<GuiaRemision> guiaremisionsForeignKey=new ArrayList<GuiaRemision>();
			GuiaRemisionLogic guiaremisionLogic=new GuiaRemisionLogic();
			guiaremisionLogic.setConnexion(this.connexion);
			guiaremisionLogic.getGuiaRemisionDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalGuiaRemision.equals("NONE")) {
				guiaremisionLogic.getTodosGuiaRemisions(finalQueryGlobalGuiaRemision,new Pagination());
				guiaremisionsForeignKey=guiaremisionLogic.getGuiaRemisions();
			}

			detalleguiaremisionReturnGeneral.setguiaremisionsForeignKey(guiaremisionsForeignKey);


			List<Bodega> bodegasForeignKey=new ArrayList<Bodega>();
			BodegaLogic bodegaLogic=new BodegaLogic();
			bodegaLogic.setConnexion(this.connexion);
			bodegaLogic.getBodegaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalBodega.equals("NONE")) {
				bodegaLogic.getTodosBodegas(finalQueryGlobalBodega,new Pagination());
				bodegasForeignKey=bodegaLogic.getBodegas();
			}

			detalleguiaremisionReturnGeneral.setbodegasForeignKey(bodegasForeignKey);


			List<Producto> productosForeignKey=new ArrayList<Producto>();
			ProductoLogic productoLogic=new ProductoLogic();
			productoLogic.setConnexion(this.connexion);
			//productoLogic.getProductoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalProducto.equals("NONE")) {
				productoLogic.getTodosProductos(finalQueryGlobalProducto,new Pagination());
				productosForeignKey=productoLogic.getProductos();
			}

			detalleguiaremisionReturnGeneral.setproductosForeignKey(productosForeignKey);


			List<Unidad> unidadsForeignKey=new ArrayList<Unidad>();
			UnidadLogic unidadLogic=new UnidadLogic();
			unidadLogic.setConnexion(this.connexion);
			unidadLogic.getUnidadDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalUnidad.equals("NONE")) {
				unidadLogic.getTodosUnidads(finalQueryGlobalUnidad,new Pagination());
				unidadsForeignKey=unidadLogic.getUnidads();
			}

			detalleguiaremisionReturnGeneral.setunidadsForeignKey(unidadsForeignKey);


			List<CentroCosto> centrocostosForeignKey=new ArrayList<CentroCosto>();
			CentroCostoLogic centrocostoLogic=new CentroCostoLogic();
			centrocostoLogic.setConnexion(this.connexion);
			centrocostoLogic.getCentroCostoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCentroCosto.equals("NONE")) {
				centrocostoLogic.getTodosCentroCostos(finalQueryGlobalCentroCosto,new Pagination());
				centrocostosForeignKey=centrocostoLogic.getCentroCostos();
			}

			detalleguiaremisionReturnGeneral.setcentrocostosForeignKey(centrocostosForeignKey);
						
			
		} catch(Exception e) {			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			
		}
		
		return detalleguiaremisionReturnGeneral;
	}
	
	
	public void deepLoad(DetalleGuiaRemision detalleguiaremision,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			DetalleGuiaRemisionLogicAdditional.updateDetalleGuiaRemisionToGet(detalleguiaremision,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		detalleguiaremision.setEmpresa(detalleguiaremisionDataAccess.getEmpresa(connexion,detalleguiaremision));
		detalleguiaremision.setSucursal(detalleguiaremisionDataAccess.getSucursal(connexion,detalleguiaremision));
		detalleguiaremision.setEjercicio(detalleguiaremisionDataAccess.getEjercicio(connexion,detalleguiaremision));
		detalleguiaremision.setPeriodo(detalleguiaremisionDataAccess.getPeriodo(connexion,detalleguiaremision));
		detalleguiaremision.setGuiaRemision(detalleguiaremisionDataAccess.getGuiaRemision(connexion,detalleguiaremision));
		detalleguiaremision.setBodega(detalleguiaremisionDataAccess.getBodega(connexion,detalleguiaremision));
		detalleguiaremision.setProducto(detalleguiaremisionDataAccess.getProducto(connexion,detalleguiaremision));
		detalleguiaremision.setUnidad(detalleguiaremisionDataAccess.getUnidad(connexion,detalleguiaremision));
		detalleguiaremision.setCentroCosto(detalleguiaremisionDataAccess.getCentroCosto(connexion,detalleguiaremision));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				detalleguiaremision.setEmpresa(detalleguiaremisionDataAccess.getEmpresa(connexion,detalleguiaremision));
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				detalleguiaremision.setSucursal(detalleguiaremisionDataAccess.getSucursal(connexion,detalleguiaremision));
				continue;
			}

			if(clas.clas.equals(Ejercicio.class)) {
				detalleguiaremision.setEjercicio(detalleguiaremisionDataAccess.getEjercicio(connexion,detalleguiaremision));
				continue;
			}

			if(clas.clas.equals(Periodo.class)) {
				detalleguiaremision.setPeriodo(detalleguiaremisionDataAccess.getPeriodo(connexion,detalleguiaremision));
				continue;
			}

			if(clas.clas.equals(GuiaRemision.class)) {
				detalleguiaremision.setGuiaRemision(detalleguiaremisionDataAccess.getGuiaRemision(connexion,detalleguiaremision));
				continue;
			}

			if(clas.clas.equals(Bodega.class)) {
				detalleguiaremision.setBodega(detalleguiaremisionDataAccess.getBodega(connexion,detalleguiaremision));
				continue;
			}

			if(clas.clas.equals(Producto.class)) {
				detalleguiaremision.setProducto(detalleguiaremisionDataAccess.getProducto(connexion,detalleguiaremision));
				continue;
			}

			if(clas.clas.equals(Unidad.class)) {
				detalleguiaremision.setUnidad(detalleguiaremisionDataAccess.getUnidad(connexion,detalleguiaremision));
				continue;
			}

			if(clas.clas.equals(CentroCosto.class)) {
				detalleguiaremision.setCentroCosto(detalleguiaremisionDataAccess.getCentroCosto(connexion,detalleguiaremision));
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
			detalleguiaremision.setEmpresa(detalleguiaremisionDataAccess.getEmpresa(connexion,detalleguiaremision));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detalleguiaremision.setSucursal(detalleguiaremisionDataAccess.getSucursal(connexion,detalleguiaremision));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Ejercicio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detalleguiaremision.setEjercicio(detalleguiaremisionDataAccess.getEjercicio(connexion,detalleguiaremision));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Periodo.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detalleguiaremision.setPeriodo(detalleguiaremisionDataAccess.getPeriodo(connexion,detalleguiaremision));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(GuiaRemision.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detalleguiaremision.setGuiaRemision(detalleguiaremisionDataAccess.getGuiaRemision(connexion,detalleguiaremision));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Bodega.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detalleguiaremision.setBodega(detalleguiaremisionDataAccess.getBodega(connexion,detalleguiaremision));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Producto.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detalleguiaremision.setProducto(detalleguiaremisionDataAccess.getProducto(connexion,detalleguiaremision));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Unidad.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detalleguiaremision.setUnidad(detalleguiaremisionDataAccess.getUnidad(connexion,detalleguiaremision));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(CentroCosto.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detalleguiaremision.setCentroCosto(detalleguiaremisionDataAccess.getCentroCosto(connexion,detalleguiaremision));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		detalleguiaremision.setEmpresa(detalleguiaremisionDataAccess.getEmpresa(connexion,detalleguiaremision));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(detalleguiaremision.getEmpresa(),isDeep,deepLoadType,clases);
				
		detalleguiaremision.setSucursal(detalleguiaremisionDataAccess.getSucursal(connexion,detalleguiaremision));
		SucursalLogic sucursalLogic= new SucursalLogic(connexion);
		sucursalLogic.deepLoad(detalleguiaremision.getSucursal(),isDeep,deepLoadType,clases);
				
		detalleguiaremision.setEjercicio(detalleguiaremisionDataAccess.getEjercicio(connexion,detalleguiaremision));
		EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
		ejercicioLogic.deepLoad(detalleguiaremision.getEjercicio(),isDeep,deepLoadType,clases);
				
		detalleguiaremision.setPeriodo(detalleguiaremisionDataAccess.getPeriodo(connexion,detalleguiaremision));
		PeriodoLogic periodoLogic= new PeriodoLogic(connexion);
		periodoLogic.deepLoad(detalleguiaremision.getPeriodo(),isDeep,deepLoadType,clases);
				
		detalleguiaremision.setGuiaRemision(detalleguiaremisionDataAccess.getGuiaRemision(connexion,detalleguiaremision));
		GuiaRemisionLogic guiaremisionLogic= new GuiaRemisionLogic(connexion);
		guiaremisionLogic.deepLoad(detalleguiaremision.getGuiaRemision(),isDeep,deepLoadType,clases);
				
		detalleguiaremision.setBodega(detalleguiaremisionDataAccess.getBodega(connexion,detalleguiaremision));
		BodegaLogic bodegaLogic= new BodegaLogic(connexion);
		bodegaLogic.deepLoad(detalleguiaremision.getBodega(),isDeep,deepLoadType,clases);
				
		detalleguiaremision.setProducto(detalleguiaremisionDataAccess.getProducto(connexion,detalleguiaremision));
		ProductoLogic productoLogic= new ProductoLogic(connexion);
		productoLogic.deepLoad(detalleguiaremision.getProducto(),isDeep,deepLoadType,clases);
				
		detalleguiaremision.setUnidad(detalleguiaremisionDataAccess.getUnidad(connexion,detalleguiaremision));
		UnidadLogic unidadLogic= new UnidadLogic(connexion);
		unidadLogic.deepLoad(detalleguiaremision.getUnidad(),isDeep,deepLoadType,clases);
				
		detalleguiaremision.setCentroCosto(detalleguiaremisionDataAccess.getCentroCosto(connexion,detalleguiaremision));
		CentroCostoLogic centrocostoLogic= new CentroCostoLogic(connexion);
		centrocostoLogic.deepLoad(detalleguiaremision.getCentroCosto(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				detalleguiaremision.setEmpresa(detalleguiaremisionDataAccess.getEmpresa(connexion,detalleguiaremision));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(detalleguiaremision.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				detalleguiaremision.setSucursal(detalleguiaremisionDataAccess.getSucursal(connexion,detalleguiaremision));
				SucursalLogic sucursalLogic= new SucursalLogic(connexion);
				sucursalLogic.deepLoad(detalleguiaremision.getSucursal(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Ejercicio.class)) {
				detalleguiaremision.setEjercicio(detalleguiaremisionDataAccess.getEjercicio(connexion,detalleguiaremision));
				EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
				ejercicioLogic.deepLoad(detalleguiaremision.getEjercicio(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Periodo.class)) {
				detalleguiaremision.setPeriodo(detalleguiaremisionDataAccess.getPeriodo(connexion,detalleguiaremision));
				PeriodoLogic periodoLogic= new PeriodoLogic(connexion);
				periodoLogic.deepLoad(detalleguiaremision.getPeriodo(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(GuiaRemision.class)) {
				detalleguiaremision.setGuiaRemision(detalleguiaremisionDataAccess.getGuiaRemision(connexion,detalleguiaremision));
				GuiaRemisionLogic guiaremisionLogic= new GuiaRemisionLogic(connexion);
				guiaremisionLogic.deepLoad(detalleguiaremision.getGuiaRemision(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Bodega.class)) {
				detalleguiaremision.setBodega(detalleguiaremisionDataAccess.getBodega(connexion,detalleguiaremision));
				BodegaLogic bodegaLogic= new BodegaLogic(connexion);
				bodegaLogic.deepLoad(detalleguiaremision.getBodega(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Producto.class)) {
				detalleguiaremision.setProducto(detalleguiaremisionDataAccess.getProducto(connexion,detalleguiaremision));
				ProductoLogic productoLogic= new ProductoLogic(connexion);
				productoLogic.deepLoad(detalleguiaremision.getProducto(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Unidad.class)) {
				detalleguiaremision.setUnidad(detalleguiaremisionDataAccess.getUnidad(connexion,detalleguiaremision));
				UnidadLogic unidadLogic= new UnidadLogic(connexion);
				unidadLogic.deepLoad(detalleguiaremision.getUnidad(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(CentroCosto.class)) {
				detalleguiaremision.setCentroCosto(detalleguiaremisionDataAccess.getCentroCosto(connexion,detalleguiaremision));
				CentroCostoLogic centrocostoLogic= new CentroCostoLogic(connexion);
				centrocostoLogic.deepLoad(detalleguiaremision.getCentroCosto(),isDeep,deepLoadType,clases);				
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
			detalleguiaremision.setEmpresa(detalleguiaremisionDataAccess.getEmpresa(connexion,detalleguiaremision));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(detalleguiaremision.getEmpresa(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detalleguiaremision.setSucursal(detalleguiaremisionDataAccess.getSucursal(connexion,detalleguiaremision));
			SucursalLogic sucursalLogic= new SucursalLogic(connexion);
			sucursalLogic.deepLoad(detalleguiaremision.getSucursal(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Ejercicio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detalleguiaremision.setEjercicio(detalleguiaremisionDataAccess.getEjercicio(connexion,detalleguiaremision));
			EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
			ejercicioLogic.deepLoad(detalleguiaremision.getEjercicio(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Periodo.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detalleguiaremision.setPeriodo(detalleguiaremisionDataAccess.getPeriodo(connexion,detalleguiaremision));
			PeriodoLogic periodoLogic= new PeriodoLogic(connexion);
			periodoLogic.deepLoad(detalleguiaremision.getPeriodo(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(GuiaRemision.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detalleguiaremision.setGuiaRemision(detalleguiaremisionDataAccess.getGuiaRemision(connexion,detalleguiaremision));
			GuiaRemisionLogic guiaremisionLogic= new GuiaRemisionLogic(connexion);
			guiaremisionLogic.deepLoad(detalleguiaremision.getGuiaRemision(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Bodega.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detalleguiaremision.setBodega(detalleguiaremisionDataAccess.getBodega(connexion,detalleguiaremision));
			BodegaLogic bodegaLogic= new BodegaLogic(connexion);
			bodegaLogic.deepLoad(detalleguiaremision.getBodega(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Producto.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detalleguiaremision.setProducto(detalleguiaremisionDataAccess.getProducto(connexion,detalleguiaremision));
			ProductoLogic productoLogic= new ProductoLogic(connexion);
			productoLogic.deepLoad(detalleguiaremision.getProducto(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Unidad.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detalleguiaremision.setUnidad(detalleguiaremisionDataAccess.getUnidad(connexion,detalleguiaremision));
			UnidadLogic unidadLogic= new UnidadLogic(connexion);
			unidadLogic.deepLoad(detalleguiaremision.getUnidad(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(CentroCosto.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detalleguiaremision.setCentroCosto(detalleguiaremisionDataAccess.getCentroCosto(connexion,detalleguiaremision));
			CentroCostoLogic centrocostoLogic= new CentroCostoLogic(connexion);
			centrocostoLogic.deepLoad(detalleguiaremision.getCentroCosto(),isDeep,deepLoadType,clases);
				
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(DetalleGuiaRemision detalleguiaremision,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			DetalleGuiaRemisionLogicAdditional.updateDetalleGuiaRemisionToSave(detalleguiaremision,this.arrDatoGeneral);
			
DetalleGuiaRemisionDataAccess.save(detalleguiaremision, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(detalleguiaremision.getEmpresa(),connexion);

		SucursalDataAccess.save(detalleguiaremision.getSucursal(),connexion);

		EjercicioDataAccess.save(detalleguiaremision.getEjercicio(),connexion);

		PeriodoDataAccess.save(detalleguiaremision.getPeriodo(),connexion);

		GuiaRemisionDataAccess.save(detalleguiaremision.getGuiaRemision(),connexion);

		BodegaDataAccess.save(detalleguiaremision.getBodega(),connexion);

		ProductoDataAccess.save(detalleguiaremision.getProducto(),connexion);

		UnidadDataAccess.save(detalleguiaremision.getUnidad(),connexion);

		CentroCostoDataAccess.save(detalleguiaremision.getCentroCosto(),connexion);
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(detalleguiaremision.getEmpresa(),connexion);
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				SucursalDataAccess.save(detalleguiaremision.getSucursal(),connexion);
				continue;
			}

			if(clas.clas.equals(Ejercicio.class)) {
				EjercicioDataAccess.save(detalleguiaremision.getEjercicio(),connexion);
				continue;
			}

			if(clas.clas.equals(Periodo.class)) {
				PeriodoDataAccess.save(detalleguiaremision.getPeriodo(),connexion);
				continue;
			}

			if(clas.clas.equals(GuiaRemision.class)) {
				GuiaRemisionDataAccess.save(detalleguiaremision.getGuiaRemision(),connexion);
				continue;
			}

			if(clas.clas.equals(Bodega.class)) {
				BodegaDataAccess.save(detalleguiaremision.getBodega(),connexion);
				continue;
			}

			if(clas.clas.equals(Producto.class)) {
				ProductoDataAccess.save(detalleguiaremision.getProducto(),connexion);
				continue;
			}

			if(clas.clas.equals(Unidad.class)) {
				UnidadDataAccess.save(detalleguiaremision.getUnidad(),connexion);
				continue;
			}

			if(clas.clas.equals(CentroCosto.class)) {
				CentroCostoDataAccess.save(detalleguiaremision.getCentroCosto(),connexion);
				continue;
			}

		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(detalleguiaremision.getEmpresa(),connexion);
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(detalleguiaremision.getEmpresa(),isDeep,deepLoadType,clases);
				

		SucursalDataAccess.save(detalleguiaremision.getSucursal(),connexion);
		SucursalLogic sucursalLogic= new SucursalLogic(connexion);
		sucursalLogic.deepLoad(detalleguiaremision.getSucursal(),isDeep,deepLoadType,clases);
				

		EjercicioDataAccess.save(detalleguiaremision.getEjercicio(),connexion);
		EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
		ejercicioLogic.deepLoad(detalleguiaremision.getEjercicio(),isDeep,deepLoadType,clases);
				

		PeriodoDataAccess.save(detalleguiaremision.getPeriodo(),connexion);
		PeriodoLogic periodoLogic= new PeriodoLogic(connexion);
		periodoLogic.deepLoad(detalleguiaremision.getPeriodo(),isDeep,deepLoadType,clases);
				

		GuiaRemisionDataAccess.save(detalleguiaremision.getGuiaRemision(),connexion);
		GuiaRemisionLogic guiaremisionLogic= new GuiaRemisionLogic(connexion);
		guiaremisionLogic.deepLoad(detalleguiaremision.getGuiaRemision(),isDeep,deepLoadType,clases);
				

		BodegaDataAccess.save(detalleguiaremision.getBodega(),connexion);
		BodegaLogic bodegaLogic= new BodegaLogic(connexion);
		bodegaLogic.deepLoad(detalleguiaremision.getBodega(),isDeep,deepLoadType,clases);
				

		ProductoDataAccess.save(detalleguiaremision.getProducto(),connexion);
		ProductoLogic productoLogic= new ProductoLogic(connexion);
		productoLogic.deepLoad(detalleguiaremision.getProducto(),isDeep,deepLoadType,clases);
				

		UnidadDataAccess.save(detalleguiaremision.getUnidad(),connexion);
		UnidadLogic unidadLogic= new UnidadLogic(connexion);
		unidadLogic.deepLoad(detalleguiaremision.getUnidad(),isDeep,deepLoadType,clases);
				

		CentroCostoDataAccess.save(detalleguiaremision.getCentroCosto(),connexion);
		CentroCostoLogic centrocostoLogic= new CentroCostoLogic(connexion);
		centrocostoLogic.deepLoad(detalleguiaremision.getCentroCosto(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(detalleguiaremision.getEmpresa(),connexion);
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepSave(detalleguiaremision.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				SucursalDataAccess.save(detalleguiaremision.getSucursal(),connexion);
				SucursalLogic sucursalLogic= new SucursalLogic(connexion);
				sucursalLogic.deepSave(detalleguiaremision.getSucursal(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Ejercicio.class)) {
				EjercicioDataAccess.save(detalleguiaremision.getEjercicio(),connexion);
				EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
				ejercicioLogic.deepSave(detalleguiaremision.getEjercicio(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Periodo.class)) {
				PeriodoDataAccess.save(detalleguiaremision.getPeriodo(),connexion);
				PeriodoLogic periodoLogic= new PeriodoLogic(connexion);
				periodoLogic.deepSave(detalleguiaremision.getPeriodo(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(GuiaRemision.class)) {
				GuiaRemisionDataAccess.save(detalleguiaremision.getGuiaRemision(),connexion);
				GuiaRemisionLogic guiaremisionLogic= new GuiaRemisionLogic(connexion);
				guiaremisionLogic.deepSave(detalleguiaremision.getGuiaRemision(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Bodega.class)) {
				BodegaDataAccess.save(detalleguiaremision.getBodega(),connexion);
				BodegaLogic bodegaLogic= new BodegaLogic(connexion);
				bodegaLogic.deepSave(detalleguiaremision.getBodega(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Producto.class)) {
				ProductoDataAccess.save(detalleguiaremision.getProducto(),connexion);
				ProductoLogic productoLogic= new ProductoLogic(connexion);
				productoLogic.deepSave(detalleguiaremision.getProducto(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Unidad.class)) {
				UnidadDataAccess.save(detalleguiaremision.getUnidad(),connexion);
				UnidadLogic unidadLogic= new UnidadLogic(connexion);
				unidadLogic.deepSave(detalleguiaremision.getUnidad(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(CentroCosto.class)) {
				CentroCostoDataAccess.save(detalleguiaremision.getCentroCosto(),connexion);
				CentroCostoLogic centrocostoLogic= new CentroCostoLogic(connexion);
				centrocostoLogic.deepSave(detalleguiaremision.getCentroCosto(),isDeep,deepLoadType,clases);				
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
			this.getNewConnexionToDeep(DetalleGuiaRemision.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(detalleguiaremision,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				DetalleGuiaRemisionConstantesFunciones.refrescarForeignKeysDescripcionesDetalleGuiaRemision(detalleguiaremision);
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
			this.deepLoad(this.detalleguiaremision,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				DetalleGuiaRemisionConstantesFunciones.refrescarForeignKeysDescripcionesDetalleGuiaRemision(this.detalleguiaremision);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(DetalleGuiaRemision.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(detalleguiaremisions!=null) {
				for(DetalleGuiaRemision detalleguiaremision:detalleguiaremisions) {
					this.deepLoad(detalleguiaremision,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					DetalleGuiaRemisionConstantesFunciones.refrescarForeignKeysDescripcionesDetalleGuiaRemision(detalleguiaremisions);
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
			if(detalleguiaremisions!=null) {
				for(DetalleGuiaRemision detalleguiaremision:detalleguiaremisions) {
					this.deepLoad(detalleguiaremision,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					DetalleGuiaRemisionConstantesFunciones.refrescarForeignKeysDescripcionesDetalleGuiaRemision(detalleguiaremisions);
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
			this.getNewConnexionToDeep(DetalleGuiaRemision.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(detalleguiaremision,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(DetalleGuiaRemision.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(detalleguiaremisions!=null) {
				for(DetalleGuiaRemision detalleguiaremision:detalleguiaremisions) {
					this.deepSave(detalleguiaremision,isDeep,deepLoadType,clases);
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
			if(detalleguiaremisions!=null) {
				for(DetalleGuiaRemision detalleguiaremision:detalleguiaremisions) {
					this.deepSave(detalleguiaremision,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getDetalleGuiaRemisionsFK_IdBodegaWithConnection(String sFinalQuery,Pagination pagination,Long id_bodega)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleGuiaRemision.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidBodega= new ParameterSelectionGeneral();
			parameterSelectionGeneralidBodega.setParameterSelectionGeneralEqual(ParameterType.LONG,id_bodega,DetalleGuiaRemisionConstantesFunciones.IDBODEGA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidBodega);

			DetalleGuiaRemisionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdBodega","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detalleguiaremisions=detalleguiaremisionDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleGuiaRemisionConstantesFunciones.refrescarForeignKeysDescripcionesDetalleGuiaRemision(this.detalleguiaremisions);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getDetalleGuiaRemisionsFK_IdBodega(String sFinalQuery,Pagination pagination,Long id_bodega)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidBodega= new ParameterSelectionGeneral();
			parameterSelectionGeneralidBodega.setParameterSelectionGeneralEqual(ParameterType.LONG,id_bodega,DetalleGuiaRemisionConstantesFunciones.IDBODEGA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidBodega);

			DetalleGuiaRemisionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdBodega","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detalleguiaremisions=detalleguiaremisionDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleGuiaRemisionConstantesFunciones.refrescarForeignKeysDescripcionesDetalleGuiaRemision(this.detalleguiaremisions);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getDetalleGuiaRemisionsFK_IdCentroCostoWithConnection(String sFinalQuery,Pagination pagination,Long id_centro_costo)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleGuiaRemision.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCentroCosto= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCentroCosto.setParameterSelectionGeneralEqual(ParameterType.LONG,id_centro_costo,DetalleGuiaRemisionConstantesFunciones.IDCENTROCOSTO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCentroCosto);

			DetalleGuiaRemisionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCentroCosto","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detalleguiaremisions=detalleguiaremisionDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleGuiaRemisionConstantesFunciones.refrescarForeignKeysDescripcionesDetalleGuiaRemision(this.detalleguiaremisions);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getDetalleGuiaRemisionsFK_IdCentroCosto(String sFinalQuery,Pagination pagination,Long id_centro_costo)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCentroCosto= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCentroCosto.setParameterSelectionGeneralEqual(ParameterType.LONG,id_centro_costo,DetalleGuiaRemisionConstantesFunciones.IDCENTROCOSTO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCentroCosto);

			DetalleGuiaRemisionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCentroCosto","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detalleguiaremisions=detalleguiaremisionDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleGuiaRemisionConstantesFunciones.refrescarForeignKeysDescripcionesDetalleGuiaRemision(this.detalleguiaremisions);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getDetalleGuiaRemisionsFK_IdEjercicioWithConnection(String sFinalQuery,Pagination pagination,Long id_ejercicio)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleGuiaRemision.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEjercicio= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEjercicio.setParameterSelectionGeneralEqual(ParameterType.LONG,id_ejercicio,DetalleGuiaRemisionConstantesFunciones.IDEJERCICIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEjercicio);

			DetalleGuiaRemisionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEjercicio","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detalleguiaremisions=detalleguiaremisionDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleGuiaRemisionConstantesFunciones.refrescarForeignKeysDescripcionesDetalleGuiaRemision(this.detalleguiaremisions);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getDetalleGuiaRemisionsFK_IdEjercicio(String sFinalQuery,Pagination pagination,Long id_ejercicio)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEjercicio= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEjercicio.setParameterSelectionGeneralEqual(ParameterType.LONG,id_ejercicio,DetalleGuiaRemisionConstantesFunciones.IDEJERCICIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEjercicio);

			DetalleGuiaRemisionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEjercicio","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detalleguiaremisions=detalleguiaremisionDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleGuiaRemisionConstantesFunciones.refrescarForeignKeysDescripcionesDetalleGuiaRemision(this.detalleguiaremisions);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getDetalleGuiaRemisionsFK_IdEmpresaWithConnection(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleGuiaRemision.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,DetalleGuiaRemisionConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			DetalleGuiaRemisionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detalleguiaremisions=detalleguiaremisionDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleGuiaRemisionConstantesFunciones.refrescarForeignKeysDescripcionesDetalleGuiaRemision(this.detalleguiaremisions);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getDetalleGuiaRemisionsFK_IdEmpresa(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,DetalleGuiaRemisionConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			DetalleGuiaRemisionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detalleguiaremisions=detalleguiaremisionDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleGuiaRemisionConstantesFunciones.refrescarForeignKeysDescripcionesDetalleGuiaRemision(this.detalleguiaremisions);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getDetalleGuiaRemisionsFK_IdGuiaRemisionWithConnection(String sFinalQuery,Pagination pagination,Long id_guia_remision)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleGuiaRemision.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidGuiaRemision= new ParameterSelectionGeneral();
			parameterSelectionGeneralidGuiaRemision.setParameterSelectionGeneralEqual(ParameterType.LONG,id_guia_remision,DetalleGuiaRemisionConstantesFunciones.IDGUIAREMISION,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidGuiaRemision);

			DetalleGuiaRemisionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdGuiaRemision","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detalleguiaremisions=detalleguiaremisionDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleGuiaRemisionConstantesFunciones.refrescarForeignKeysDescripcionesDetalleGuiaRemision(this.detalleguiaremisions);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getDetalleGuiaRemisionsFK_IdGuiaRemision(String sFinalQuery,Pagination pagination,Long id_guia_remision)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidGuiaRemision= new ParameterSelectionGeneral();
			parameterSelectionGeneralidGuiaRemision.setParameterSelectionGeneralEqual(ParameterType.LONG,id_guia_remision,DetalleGuiaRemisionConstantesFunciones.IDGUIAREMISION,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidGuiaRemision);

			DetalleGuiaRemisionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdGuiaRemision","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detalleguiaremisions=detalleguiaremisionDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleGuiaRemisionConstantesFunciones.refrescarForeignKeysDescripcionesDetalleGuiaRemision(this.detalleguiaremisions);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getDetalleGuiaRemisionsFK_IdPeriodoWithConnection(String sFinalQuery,Pagination pagination,Long id_periodo)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleGuiaRemision.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidPeriodo= new ParameterSelectionGeneral();
			parameterSelectionGeneralidPeriodo.setParameterSelectionGeneralEqual(ParameterType.LONG,id_periodo,DetalleGuiaRemisionConstantesFunciones.IDPERIODO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidPeriodo);

			DetalleGuiaRemisionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdPeriodo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detalleguiaremisions=detalleguiaremisionDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleGuiaRemisionConstantesFunciones.refrescarForeignKeysDescripcionesDetalleGuiaRemision(this.detalleguiaremisions);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getDetalleGuiaRemisionsFK_IdPeriodo(String sFinalQuery,Pagination pagination,Long id_periodo)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidPeriodo= new ParameterSelectionGeneral();
			parameterSelectionGeneralidPeriodo.setParameterSelectionGeneralEqual(ParameterType.LONG,id_periodo,DetalleGuiaRemisionConstantesFunciones.IDPERIODO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidPeriodo);

			DetalleGuiaRemisionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdPeriodo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detalleguiaremisions=detalleguiaremisionDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleGuiaRemisionConstantesFunciones.refrescarForeignKeysDescripcionesDetalleGuiaRemision(this.detalleguiaremisions);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getDetalleGuiaRemisionsFK_IdProductoWithConnection(String sFinalQuery,Pagination pagination,Long id_producto)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleGuiaRemision.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidProducto= new ParameterSelectionGeneral();
			parameterSelectionGeneralidProducto.setParameterSelectionGeneralEqual(ParameterType.LONG,id_producto,DetalleGuiaRemisionConstantesFunciones.IDPRODUCTO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidProducto);

			DetalleGuiaRemisionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdProducto","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detalleguiaremisions=detalleguiaremisionDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleGuiaRemisionConstantesFunciones.refrescarForeignKeysDescripcionesDetalleGuiaRemision(this.detalleguiaremisions);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getDetalleGuiaRemisionsFK_IdProducto(String sFinalQuery,Pagination pagination,Long id_producto)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidProducto= new ParameterSelectionGeneral();
			parameterSelectionGeneralidProducto.setParameterSelectionGeneralEqual(ParameterType.LONG,id_producto,DetalleGuiaRemisionConstantesFunciones.IDPRODUCTO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidProducto);

			DetalleGuiaRemisionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdProducto","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detalleguiaremisions=detalleguiaremisionDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleGuiaRemisionConstantesFunciones.refrescarForeignKeysDescripcionesDetalleGuiaRemision(this.detalleguiaremisions);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getDetalleGuiaRemisionsFK_IdSucursalWithConnection(String sFinalQuery,Pagination pagination,Long id_sucursal)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleGuiaRemision.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidSucursal= new ParameterSelectionGeneral();
			parameterSelectionGeneralidSucursal.setParameterSelectionGeneralEqual(ParameterType.LONG,id_sucursal,DetalleGuiaRemisionConstantesFunciones.IDSUCURSAL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidSucursal);

			DetalleGuiaRemisionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdSucursal","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detalleguiaremisions=detalleguiaremisionDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleGuiaRemisionConstantesFunciones.refrescarForeignKeysDescripcionesDetalleGuiaRemision(this.detalleguiaremisions);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getDetalleGuiaRemisionsFK_IdSucursal(String sFinalQuery,Pagination pagination,Long id_sucursal)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidSucursal= new ParameterSelectionGeneral();
			parameterSelectionGeneralidSucursal.setParameterSelectionGeneralEqual(ParameterType.LONG,id_sucursal,DetalleGuiaRemisionConstantesFunciones.IDSUCURSAL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidSucursal);

			DetalleGuiaRemisionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdSucursal","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detalleguiaremisions=detalleguiaremisionDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleGuiaRemisionConstantesFunciones.refrescarForeignKeysDescripcionesDetalleGuiaRemision(this.detalleguiaremisions);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getDetalleGuiaRemisionsFK_IdUnidadWithConnection(String sFinalQuery,Pagination pagination,Long id_unidad)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleGuiaRemision.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidUnidad= new ParameterSelectionGeneral();
			parameterSelectionGeneralidUnidad.setParameterSelectionGeneralEqual(ParameterType.LONG,id_unidad,DetalleGuiaRemisionConstantesFunciones.IDUNIDAD,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidUnidad);

			DetalleGuiaRemisionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdUnidad","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detalleguiaremisions=detalleguiaremisionDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleGuiaRemisionConstantesFunciones.refrescarForeignKeysDescripcionesDetalleGuiaRemision(this.detalleguiaremisions);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getDetalleGuiaRemisionsFK_IdUnidad(String sFinalQuery,Pagination pagination,Long id_unidad)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidUnidad= new ParameterSelectionGeneral();
			parameterSelectionGeneralidUnidad.setParameterSelectionGeneralEqual(ParameterType.LONG,id_unidad,DetalleGuiaRemisionConstantesFunciones.IDUNIDAD,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidUnidad);

			DetalleGuiaRemisionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdUnidad","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detalleguiaremisions=detalleguiaremisionDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleGuiaRemisionConstantesFunciones.refrescarForeignKeysDescripcionesDetalleGuiaRemision(this.detalleguiaremisions);
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
			if(DetalleGuiaRemisionConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,DetalleGuiaRemisionDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,DetalleGuiaRemision detalleguiaremision,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(DetalleGuiaRemisionConstantesFunciones.ISCONAUDITORIA) {
				if(detalleguiaremision.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,DetalleGuiaRemisionDataAccess.TABLENAME, detalleguiaremision.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(DetalleGuiaRemisionConstantesFunciones.ISCONAUDITORIADETALLE) {
						////DetalleGuiaRemisionLogic.registrarAuditoriaDetallesDetalleGuiaRemision(connexion,detalleguiaremision,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(detalleguiaremision.getIsDeleted()) {
					/*if(!detalleguiaremision.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,DetalleGuiaRemisionDataAccess.TABLENAME, detalleguiaremision.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////DetalleGuiaRemisionLogic.registrarAuditoriaDetallesDetalleGuiaRemision(connexion,detalleguiaremision,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,DetalleGuiaRemisionDataAccess.TABLENAME, detalleguiaremision.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(detalleguiaremision.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,DetalleGuiaRemisionDataAccess.TABLENAME, detalleguiaremision.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(DetalleGuiaRemisionConstantesFunciones.ISCONAUDITORIADETALLE) {
						////DetalleGuiaRemisionLogic.registrarAuditoriaDetallesDetalleGuiaRemision(connexion,detalleguiaremision,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesDetalleGuiaRemision(Connexion connexion,DetalleGuiaRemision detalleguiaremision)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(detalleguiaremision.getIsNew()||!detalleguiaremision.getid_empresa().equals(detalleguiaremision.getDetalleGuiaRemisionOriginal().getid_empresa()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detalleguiaremision.getDetalleGuiaRemisionOriginal().getid_empresa()!=null)
				{
					strValorActual=detalleguiaremision.getDetalleGuiaRemisionOriginal().getid_empresa().toString();
				}
				if(detalleguiaremision.getid_empresa()!=null)
				{
					strValorNuevo=detalleguiaremision.getid_empresa().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleGuiaRemisionConstantesFunciones.IDEMPRESA,strValorActual,strValorNuevo);
			}	
			
			if(detalleguiaremision.getIsNew()||!detalleguiaremision.getid_sucursal().equals(detalleguiaremision.getDetalleGuiaRemisionOriginal().getid_sucursal()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detalleguiaremision.getDetalleGuiaRemisionOriginal().getid_sucursal()!=null)
				{
					strValorActual=detalleguiaremision.getDetalleGuiaRemisionOriginal().getid_sucursal().toString();
				}
				if(detalleguiaremision.getid_sucursal()!=null)
				{
					strValorNuevo=detalleguiaremision.getid_sucursal().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleGuiaRemisionConstantesFunciones.IDSUCURSAL,strValorActual,strValorNuevo);
			}	
			
			if(detalleguiaremision.getIsNew()||!detalleguiaremision.getid_ejercicio().equals(detalleguiaremision.getDetalleGuiaRemisionOriginal().getid_ejercicio()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detalleguiaremision.getDetalleGuiaRemisionOriginal().getid_ejercicio()!=null)
				{
					strValorActual=detalleguiaremision.getDetalleGuiaRemisionOriginal().getid_ejercicio().toString();
				}
				if(detalleguiaremision.getid_ejercicio()!=null)
				{
					strValorNuevo=detalleguiaremision.getid_ejercicio().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleGuiaRemisionConstantesFunciones.IDEJERCICIO,strValorActual,strValorNuevo);
			}	
			
			if(detalleguiaremision.getIsNew()||!detalleguiaremision.getid_periodo().equals(detalleguiaremision.getDetalleGuiaRemisionOriginal().getid_periodo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detalleguiaremision.getDetalleGuiaRemisionOriginal().getid_periodo()!=null)
				{
					strValorActual=detalleguiaremision.getDetalleGuiaRemisionOriginal().getid_periodo().toString();
				}
				if(detalleguiaremision.getid_periodo()!=null)
				{
					strValorNuevo=detalleguiaremision.getid_periodo().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleGuiaRemisionConstantesFunciones.IDPERIODO,strValorActual,strValorNuevo);
			}	
			
			if(detalleguiaremision.getIsNew()||!detalleguiaremision.getid_guia_remision().equals(detalleguiaremision.getDetalleGuiaRemisionOriginal().getid_guia_remision()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detalleguiaremision.getDetalleGuiaRemisionOriginal().getid_guia_remision()!=null)
				{
					strValorActual=detalleguiaremision.getDetalleGuiaRemisionOriginal().getid_guia_remision().toString();
				}
				if(detalleguiaremision.getid_guia_remision()!=null)
				{
					strValorNuevo=detalleguiaremision.getid_guia_remision().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleGuiaRemisionConstantesFunciones.IDGUIAREMISION,strValorActual,strValorNuevo);
			}	
			
			if(detalleguiaremision.getIsNew()||!detalleguiaremision.getid_bodega().equals(detalleguiaremision.getDetalleGuiaRemisionOriginal().getid_bodega()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detalleguiaremision.getDetalleGuiaRemisionOriginal().getid_bodega()!=null)
				{
					strValorActual=detalleguiaremision.getDetalleGuiaRemisionOriginal().getid_bodega().toString();
				}
				if(detalleguiaremision.getid_bodega()!=null)
				{
					strValorNuevo=detalleguiaremision.getid_bodega().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleGuiaRemisionConstantesFunciones.IDBODEGA,strValorActual,strValorNuevo);
			}	
			
			if(detalleguiaremision.getIsNew()||!detalleguiaremision.getid_producto().equals(detalleguiaremision.getDetalleGuiaRemisionOriginal().getid_producto()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detalleguiaremision.getDetalleGuiaRemisionOriginal().getid_producto()!=null)
				{
					strValorActual=detalleguiaremision.getDetalleGuiaRemisionOriginal().getid_producto().toString();
				}
				if(detalleguiaremision.getid_producto()!=null)
				{
					strValorNuevo=detalleguiaremision.getid_producto().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleGuiaRemisionConstantesFunciones.IDPRODUCTO,strValorActual,strValorNuevo);
			}	
			
			if(detalleguiaremision.getIsNew()||!detalleguiaremision.getid_unidad().equals(detalleguiaremision.getDetalleGuiaRemisionOriginal().getid_unidad()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detalleguiaremision.getDetalleGuiaRemisionOriginal().getid_unidad()!=null)
				{
					strValorActual=detalleguiaremision.getDetalleGuiaRemisionOriginal().getid_unidad().toString();
				}
				if(detalleguiaremision.getid_unidad()!=null)
				{
					strValorNuevo=detalleguiaremision.getid_unidad().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleGuiaRemisionConstantesFunciones.IDUNIDAD,strValorActual,strValorNuevo);
			}	
			
			if(detalleguiaremision.getIsNew()||!detalleguiaremision.getid_centro_costo().equals(detalleguiaremision.getDetalleGuiaRemisionOriginal().getid_centro_costo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detalleguiaremision.getDetalleGuiaRemisionOriginal().getid_centro_costo()!=null)
				{
					strValorActual=detalleguiaremision.getDetalleGuiaRemisionOriginal().getid_centro_costo().toString();
				}
				if(detalleguiaremision.getid_centro_costo()!=null)
				{
					strValorNuevo=detalleguiaremision.getid_centro_costo().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleGuiaRemisionConstantesFunciones.IDCENTROCOSTO,strValorActual,strValorNuevo);
			}	
			
			if(detalleguiaremision.getIsNew()||!detalleguiaremision.getcantidad_envases().equals(detalleguiaremision.getDetalleGuiaRemisionOriginal().getcantidad_envases()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detalleguiaremision.getDetalleGuiaRemisionOriginal().getcantidad_envases()!=null)
				{
					strValorActual=detalleguiaremision.getDetalleGuiaRemisionOriginal().getcantidad_envases().toString();
				}
				if(detalleguiaremision.getcantidad_envases()!=null)
				{
					strValorNuevo=detalleguiaremision.getcantidad_envases().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleGuiaRemisionConstantesFunciones.CANTIDADENVASES,strValorActual,strValorNuevo);
			}	
			
			if(detalleguiaremision.getIsNew()||!detalleguiaremision.getcantidad_auxiliar().equals(detalleguiaremision.getDetalleGuiaRemisionOriginal().getcantidad_auxiliar()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detalleguiaremision.getDetalleGuiaRemisionOriginal().getcantidad_auxiliar()!=null)
				{
					strValorActual=detalleguiaremision.getDetalleGuiaRemisionOriginal().getcantidad_auxiliar().toString();
				}
				if(detalleguiaremision.getcantidad_auxiliar()!=null)
				{
					strValorNuevo=detalleguiaremision.getcantidad_auxiliar().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleGuiaRemisionConstantesFunciones.CANTIDADAUXILIAR,strValorActual,strValorNuevo);
			}	
			
			if(detalleguiaremision.getIsNew()||!detalleguiaremision.getdescripcion().equals(detalleguiaremision.getDetalleGuiaRemisionOriginal().getdescripcion()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detalleguiaremision.getDetalleGuiaRemisionOriginal().getdescripcion()!=null)
				{
					strValorActual=detalleguiaremision.getDetalleGuiaRemisionOriginal().getdescripcion();
				}
				if(detalleguiaremision.getdescripcion()!=null)
				{
					strValorNuevo=detalleguiaremision.getdescripcion() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleGuiaRemisionConstantesFunciones.DESCRIPCION,strValorActual,strValorNuevo);
			}	
			
			if(detalleguiaremision.getIsNew()||!detalleguiaremision.getcantidad().equals(detalleguiaremision.getDetalleGuiaRemisionOriginal().getcantidad()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detalleguiaremision.getDetalleGuiaRemisionOriginal().getcantidad()!=null)
				{
					strValorActual=detalleguiaremision.getDetalleGuiaRemisionOriginal().getcantidad().toString();
				}
				if(detalleguiaremision.getcantidad()!=null)
				{
					strValorNuevo=detalleguiaremision.getcantidad().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleGuiaRemisionConstantesFunciones.CANTIDAD,strValorActual,strValorNuevo);
			}	
			
			if(detalleguiaremision.getIsNew()||!detalleguiaremision.getmonto().equals(detalleguiaremision.getDetalleGuiaRemisionOriginal().getmonto()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detalleguiaremision.getDetalleGuiaRemisionOriginal().getmonto()!=null)
				{
					strValorActual=detalleguiaremision.getDetalleGuiaRemisionOriginal().getmonto().toString();
				}
				if(detalleguiaremision.getmonto()!=null)
				{
					strValorNuevo=detalleguiaremision.getmonto().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleGuiaRemisionConstantesFunciones.MONTO,strValorActual,strValorNuevo);
			}	
			
			if(detalleguiaremision.getIsNew()||!detalleguiaremision.getprecio().equals(detalleguiaremision.getDetalleGuiaRemisionOriginal().getprecio()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detalleguiaremision.getDetalleGuiaRemisionOriginal().getprecio()!=null)
				{
					strValorActual=detalleguiaremision.getDetalleGuiaRemisionOriginal().getprecio().toString();
				}
				if(detalleguiaremision.getprecio()!=null)
				{
					strValorNuevo=detalleguiaremision.getprecio().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleGuiaRemisionConstantesFunciones.PRECIO,strValorActual,strValorNuevo);
			}	
			
			if(detalleguiaremision.getIsNew()||!detalleguiaremision.getporcentaje_descuento().equals(detalleguiaremision.getDetalleGuiaRemisionOriginal().getporcentaje_descuento()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detalleguiaremision.getDetalleGuiaRemisionOriginal().getporcentaje_descuento()!=null)
				{
					strValorActual=detalleguiaremision.getDetalleGuiaRemisionOriginal().getporcentaje_descuento().toString();
				}
				if(detalleguiaremision.getporcentaje_descuento()!=null)
				{
					strValorNuevo=detalleguiaremision.getporcentaje_descuento().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleGuiaRemisionConstantesFunciones.PORCENTAJEDESCUENTO,strValorActual,strValorNuevo);
			}	
			
			if(detalleguiaremision.getIsNew()||!detalleguiaremision.getdescuento().equals(detalleguiaremision.getDetalleGuiaRemisionOriginal().getdescuento()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detalleguiaremision.getDetalleGuiaRemisionOriginal().getdescuento()!=null)
				{
					strValorActual=detalleguiaremision.getDetalleGuiaRemisionOriginal().getdescuento().toString();
				}
				if(detalleguiaremision.getdescuento()!=null)
				{
					strValorNuevo=detalleguiaremision.getdescuento().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleGuiaRemisionConstantesFunciones.DESCUENTO,strValorActual,strValorNuevo);
			}	
			
			if(detalleguiaremision.getIsNew()||!detalleguiaremision.getdescuento2().equals(detalleguiaremision.getDetalleGuiaRemisionOriginal().getdescuento2()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detalleguiaremision.getDetalleGuiaRemisionOriginal().getdescuento2()!=null)
				{
					strValorActual=detalleguiaremision.getDetalleGuiaRemisionOriginal().getdescuento2().toString();
				}
				if(detalleguiaremision.getdescuento2()!=null)
				{
					strValorNuevo=detalleguiaremision.getdescuento2().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleGuiaRemisionConstantesFunciones.DESCUENTO2,strValorActual,strValorNuevo);
			}	
			
			if(detalleguiaremision.getIsNew()||!detalleguiaremision.getdescuento3().equals(detalleguiaremision.getDetalleGuiaRemisionOriginal().getdescuento3()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detalleguiaremision.getDetalleGuiaRemisionOriginal().getdescuento3()!=null)
				{
					strValorActual=detalleguiaremision.getDetalleGuiaRemisionOriginal().getdescuento3().toString();
				}
				if(detalleguiaremision.getdescuento3()!=null)
				{
					strValorNuevo=detalleguiaremision.getdescuento3().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleGuiaRemisionConstantesFunciones.DESCUENTO3,strValorActual,strValorNuevo);
			}	
			
			if(detalleguiaremision.getIsNew()||!detalleguiaremision.getporcentaje_iva().equals(detalleguiaremision.getDetalleGuiaRemisionOriginal().getporcentaje_iva()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detalleguiaremision.getDetalleGuiaRemisionOriginal().getporcentaje_iva()!=null)
				{
					strValorActual=detalleguiaremision.getDetalleGuiaRemisionOriginal().getporcentaje_iva().toString();
				}
				if(detalleguiaremision.getporcentaje_iva()!=null)
				{
					strValorNuevo=detalleguiaremision.getporcentaje_iva().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleGuiaRemisionConstantesFunciones.PORCENTAJEIVA,strValorActual,strValorNuevo);
			}	
			
			if(detalleguiaremision.getIsNew()||!detalleguiaremision.getiva().equals(detalleguiaremision.getDetalleGuiaRemisionOriginal().getiva()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detalleguiaremision.getDetalleGuiaRemisionOriginal().getiva()!=null)
				{
					strValorActual=detalleguiaremision.getDetalleGuiaRemisionOriginal().getiva().toString();
				}
				if(detalleguiaremision.getiva()!=null)
				{
					strValorNuevo=detalleguiaremision.getiva().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleGuiaRemisionConstantesFunciones.IVA,strValorActual,strValorNuevo);
			}	
			
			if(detalleguiaremision.getIsNew()||!detalleguiaremision.gettotal_descuento().equals(detalleguiaremision.getDetalleGuiaRemisionOriginal().gettotal_descuento()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detalleguiaremision.getDetalleGuiaRemisionOriginal().gettotal_descuento()!=null)
				{
					strValorActual=detalleguiaremision.getDetalleGuiaRemisionOriginal().gettotal_descuento().toString();
				}
				if(detalleguiaremision.gettotal_descuento()!=null)
				{
					strValorNuevo=detalleguiaremision.gettotal_descuento().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleGuiaRemisionConstantesFunciones.TOTALDESCUENTO,strValorActual,strValorNuevo);
			}	
			
			if(detalleguiaremision.getIsNew()||!detalleguiaremision.gettotal_impuesto().equals(detalleguiaremision.getDetalleGuiaRemisionOriginal().gettotal_impuesto()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detalleguiaremision.getDetalleGuiaRemisionOriginal().gettotal_impuesto()!=null)
				{
					strValorActual=detalleguiaremision.getDetalleGuiaRemisionOriginal().gettotal_impuesto().toString();
				}
				if(detalleguiaremision.gettotal_impuesto()!=null)
				{
					strValorNuevo=detalleguiaremision.gettotal_impuesto().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleGuiaRemisionConstantesFunciones.TOTALIMPUESTO,strValorActual,strValorNuevo);
			}	
			
			if(detalleguiaremision.getIsNew()||!detalleguiaremision.getsub_total().equals(detalleguiaremision.getDetalleGuiaRemisionOriginal().getsub_total()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detalleguiaremision.getDetalleGuiaRemisionOriginal().getsub_total()!=null)
				{
					strValorActual=detalleguiaremision.getDetalleGuiaRemisionOriginal().getsub_total().toString();
				}
				if(detalleguiaremision.getsub_total()!=null)
				{
					strValorNuevo=detalleguiaremision.getsub_total().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleGuiaRemisionConstantesFunciones.SUBTOTAL,strValorActual,strValorNuevo);
			}	
			
			if(detalleguiaremision.getIsNew()||!detalleguiaremision.gettotal().equals(detalleguiaremision.getDetalleGuiaRemisionOriginal().gettotal()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detalleguiaremision.getDetalleGuiaRemisionOriginal().gettotal()!=null)
				{
					strValorActual=detalleguiaremision.getDetalleGuiaRemisionOriginal().gettotal().toString();
				}
				if(detalleguiaremision.gettotal()!=null)
				{
					strValorNuevo=detalleguiaremision.gettotal().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleGuiaRemisionConstantesFunciones.TOTAL,strValorActual,strValorNuevo);
			}	
			
			if(detalleguiaremision.getIsNew()||!detalleguiaremision.getlote().equals(detalleguiaremision.getDetalleGuiaRemisionOriginal().getlote()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detalleguiaremision.getDetalleGuiaRemisionOriginal().getlote()!=null)
				{
					strValorActual=detalleguiaremision.getDetalleGuiaRemisionOriginal().getlote();
				}
				if(detalleguiaremision.getlote()!=null)
				{
					strValorNuevo=detalleguiaremision.getlote() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleGuiaRemisionConstantesFunciones.LOTE,strValorActual,strValorNuevo);
			}	
			
			if(detalleguiaremision.getIsNew()||!detalleguiaremision.getlote_cliente().equals(detalleguiaremision.getDetalleGuiaRemisionOriginal().getlote_cliente()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detalleguiaremision.getDetalleGuiaRemisionOriginal().getlote_cliente()!=null)
				{
					strValorActual=detalleguiaremision.getDetalleGuiaRemisionOriginal().getlote_cliente();
				}
				if(detalleguiaremision.getlote_cliente()!=null)
				{
					strValorNuevo=detalleguiaremision.getlote_cliente() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleGuiaRemisionConstantesFunciones.LOTECLIENTE,strValorActual,strValorNuevo);
			}	
			
			if(detalleguiaremision.getIsNew()||!detalleguiaremision.getorden_compra().equals(detalleguiaremision.getDetalleGuiaRemisionOriginal().getorden_compra()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detalleguiaremision.getDetalleGuiaRemisionOriginal().getorden_compra()!=null)
				{
					strValorActual=detalleguiaremision.getDetalleGuiaRemisionOriginal().getorden_compra();
				}
				if(detalleguiaremision.getorden_compra()!=null)
				{
					strValorNuevo=detalleguiaremision.getorden_compra() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleGuiaRemisionConstantesFunciones.ORDENCOMPRA,strValorActual,strValorNuevo);
			}	
			
			if(detalleguiaremision.getIsNew()||!detalleguiaremision.getarea().equals(detalleguiaremision.getDetalleGuiaRemisionOriginal().getarea()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detalleguiaremision.getDetalleGuiaRemisionOriginal().getarea()!=null)
				{
					strValorActual=detalleguiaremision.getDetalleGuiaRemisionOriginal().getarea();
				}
				if(detalleguiaremision.getarea()!=null)
				{
					strValorNuevo=detalleguiaremision.getarea() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleGuiaRemisionConstantesFunciones.AREA,strValorActual,strValorNuevo);
			}	
			
			if(detalleguiaremision.getIsNew()||!detalleguiaremision.getmedidas().equals(detalleguiaremision.getDetalleGuiaRemisionOriginal().getmedidas()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detalleguiaremision.getDetalleGuiaRemisionOriginal().getmedidas()!=null)
				{
					strValorActual=detalleguiaremision.getDetalleGuiaRemisionOriginal().getmedidas();
				}
				if(detalleguiaremision.getmedidas()!=null)
				{
					strValorNuevo=detalleguiaremision.getmedidas() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleGuiaRemisionConstantesFunciones.MEDIDAS,strValorActual,strValorNuevo);
			}	
			
			if(detalleguiaremision.getIsNew()||!detalleguiaremision.getacabado().equals(detalleguiaremision.getDetalleGuiaRemisionOriginal().getacabado()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detalleguiaremision.getDetalleGuiaRemisionOriginal().getacabado()!=null)
				{
					strValorActual=detalleguiaremision.getDetalleGuiaRemisionOriginal().getacabado();
				}
				if(detalleguiaremision.getacabado()!=null)
				{
					strValorNuevo=detalleguiaremision.getacabado() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleGuiaRemisionConstantesFunciones.ACABADO,strValorActual,strValorNuevo);
			}	
			
			if(detalleguiaremision.getIsNew()||!detalleguiaremision.getacabado2().equals(detalleguiaremision.getDetalleGuiaRemisionOriginal().getacabado2()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detalleguiaremision.getDetalleGuiaRemisionOriginal().getacabado2()!=null)
				{
					strValorActual=detalleguiaremision.getDetalleGuiaRemisionOriginal().getacabado2();
				}
				if(detalleguiaremision.getacabado2()!=null)
				{
					strValorNuevo=detalleguiaremision.getacabado2() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleGuiaRemisionConstantesFunciones.ACABADO2,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void saveDetalleGuiaRemisionRelacionesWithConnection(DetalleGuiaRemision detalleguiaremision) throws Exception {

		if(!detalleguiaremision.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveDetalleGuiaRemisionRelacionesBase(detalleguiaremision,true);
		}
	}

	public void saveDetalleGuiaRemisionRelaciones(DetalleGuiaRemision detalleguiaremision)throws Exception {

		if(!detalleguiaremision.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveDetalleGuiaRemisionRelacionesBase(detalleguiaremision,false);
		}
	}

	public void saveDetalleGuiaRemisionRelacionesBase(DetalleGuiaRemision detalleguiaremision,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("DetalleGuiaRemision-saveRelacionesWithConnection");}
	

			this.setDetalleGuiaRemision(detalleguiaremision);

			if(DetalleGuiaRemisionLogicAdditional.validarSaveRelaciones(detalleguiaremision,this)) {

				DetalleGuiaRemisionLogicAdditional.updateRelacionesToSave(detalleguiaremision,this);

				if((detalleguiaremision.getIsNew()||detalleguiaremision.getIsChanged())&&!detalleguiaremision.getIsDeleted()) {
					this.saveDetalleGuiaRemision();
					this.saveDetalleGuiaRemisionRelacionesDetalles();

				} else if(detalleguiaremision.getIsDeleted()) {
					this.saveDetalleGuiaRemisionRelacionesDetalles();
					this.saveDetalleGuiaRemision();
				}

				DetalleGuiaRemisionLogicAdditional.updateRelacionesToSaveAfter(detalleguiaremision,this);

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
	
	
	private void saveDetalleGuiaRemisionRelacionesDetalles()throws Exception {
		try {
	

		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfDetalleGuiaRemision(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=DetalleGuiaRemisionConstantesFunciones.getClassesForeignKeysOfDetalleGuiaRemision(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfDetalleGuiaRemision(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=DetalleGuiaRemisionConstantesFunciones.getClassesRelationshipsOfDetalleGuiaRemision(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}
