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
import com.bydan.erp.facturacion.util.DetallePedidoExporConstantesFunciones;
import com.bydan.erp.facturacion.util.DetallePedidoExporParameterReturnGeneral;
//import com.bydan.erp.facturacion.util.DetallePedidoExporParameterGeneral;
import com.bydan.erp.facturacion.business.entity.DetallePedidoExpor;
import com.bydan.erp.facturacion.business.logic.DetallePedidoExporLogicAdditional;
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
public class DetallePedidoExporLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(DetallePedidoExporLogic.class);
	
	protected DetallePedidoExporDataAccess detallepedidoexporDataAccess; 	
	protected DetallePedidoExpor detallepedidoexpor;
	protected List<DetallePedidoExpor> detallepedidoexpors;
	protected Object detallepedidoexporObject;	
	protected List<Object> detallepedidoexporsObject;
	
	public static ClassValidator<DetallePedidoExpor> detallepedidoexporValidator = new ClassValidator<DetallePedidoExpor>(DetallePedidoExpor.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected DetallePedidoExporLogicAdditional detallepedidoexporLogicAdditional=null;
	
	public DetallePedidoExporLogicAdditional getDetallePedidoExporLogicAdditional() {
		return this.detallepedidoexporLogicAdditional;
	}
	
	public void setDetallePedidoExporLogicAdditional(DetallePedidoExporLogicAdditional detallepedidoexporLogicAdditional) {
		try {
			this.detallepedidoexporLogicAdditional=detallepedidoexporLogicAdditional;
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
	
	
	
	
	public  DetallePedidoExporLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.detallepedidoexporDataAccess = new DetallePedidoExporDataAccess();
			
			this.detallepedidoexpors= new ArrayList<DetallePedidoExpor>();
			this.detallepedidoexpor= new DetallePedidoExpor();
			
			this.detallepedidoexporObject=new Object();
			this.detallepedidoexporsObject=new ArrayList<Object>();
				
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
			
			this.detallepedidoexporDataAccess.setConnexionType(this.connexionType);
			this.detallepedidoexporDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  DetallePedidoExporLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.detallepedidoexporDataAccess = new DetallePedidoExporDataAccess();
			this.detallepedidoexpors= new ArrayList<DetallePedidoExpor>();
			this.detallepedidoexpor= new DetallePedidoExpor();
			this.detallepedidoexporObject=new Object();
			this.detallepedidoexporsObject=new ArrayList<Object>();
			
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
			
			this.detallepedidoexporDataAccess.setConnexionType(this.connexionType);
			this.detallepedidoexporDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public DetallePedidoExpor getDetallePedidoExpor() throws Exception {	
		DetallePedidoExporLogicAdditional.checkDetallePedidoExporToGet(detallepedidoexpor,this.datosCliente,this.arrDatoGeneral);
		DetallePedidoExporLogicAdditional.updateDetallePedidoExporToGet(detallepedidoexpor,this.arrDatoGeneral);
		
		return detallepedidoexpor;
	}
		
	public void setDetallePedidoExpor(DetallePedidoExpor newDetallePedidoExpor) {
		this.detallepedidoexpor = newDetallePedidoExpor;
	}
	
	public DetallePedidoExporDataAccess getDetallePedidoExporDataAccess() {
		return detallepedidoexporDataAccess;
	}
	
	public void setDetallePedidoExporDataAccess(DetallePedidoExporDataAccess newdetallepedidoexporDataAccess) {
		this.detallepedidoexporDataAccess = newdetallepedidoexporDataAccess;
	}
	
	public List<DetallePedidoExpor> getDetallePedidoExpors() throws Exception {		
		this.quitarDetallePedidoExporsNulos();
		
		DetallePedidoExporLogicAdditional.checkDetallePedidoExporToGets(detallepedidoexpors,this.datosCliente,this.arrDatoGeneral);
		
		for (DetallePedidoExpor detallepedidoexporLocal: detallepedidoexpors ) {
			DetallePedidoExporLogicAdditional.updateDetallePedidoExporToGet(detallepedidoexporLocal,this.arrDatoGeneral);
		}
		
		return detallepedidoexpors;
	}
	
	public void setDetallePedidoExpors(List<DetallePedidoExpor> newDetallePedidoExpors) {
		this.detallepedidoexpors = newDetallePedidoExpors;
	}
	
	public Object getDetallePedidoExporObject() {	
		this.detallepedidoexporObject=this.detallepedidoexporDataAccess.getEntityObject();
		return this.detallepedidoexporObject;
	}
		
	public void setDetallePedidoExporObject(Object newDetallePedidoExporObject) {
		this.detallepedidoexporObject = newDetallePedidoExporObject;
	}
	
	public List<Object> getDetallePedidoExporsObject() {		
		this.detallepedidoexporsObject=this.detallepedidoexporDataAccess.getEntitiesObject();
		return this.detallepedidoexporsObject;
	}
		
	public void setDetallePedidoExporsObject(List<Object> newDetallePedidoExporsObject) {
		this.detallepedidoexporsObject = newDetallePedidoExporsObject;
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
		
		if(this.detallepedidoexporDataAccess!=null) {
			this.detallepedidoexporDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetallePedidoExpor.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			detallepedidoexporDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			detallepedidoexporDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		detallepedidoexpor = new  DetallePedidoExpor();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetallePedidoExpor.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			detallepedidoexpor=detallepedidoexporDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.detallepedidoexpor,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				DetallePedidoExporConstantesFunciones.refrescarForeignKeysDescripcionesDetallePedidoExpor(this.detallepedidoexpor);
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
		detallepedidoexpor = new  DetallePedidoExpor();
		  		  
        try {
			
			detallepedidoexpor=detallepedidoexporDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.detallepedidoexpor,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				DetallePedidoExporConstantesFunciones.refrescarForeignKeysDescripcionesDetallePedidoExpor(this.detallepedidoexpor);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		detallepedidoexpor = new  DetallePedidoExpor();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetallePedidoExpor.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			detallepedidoexpor=detallepedidoexporDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.detallepedidoexpor,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				DetallePedidoExporConstantesFunciones.refrescarForeignKeysDescripcionesDetallePedidoExpor(this.detallepedidoexpor);
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
		detallepedidoexpor = new  DetallePedidoExpor();
		  		  
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
		detallepedidoexpor = new  DetallePedidoExpor();
		  		  
        try {
			
			detallepedidoexpor=detallepedidoexporDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.detallepedidoexpor,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				DetallePedidoExporConstantesFunciones.refrescarForeignKeysDescripcionesDetallePedidoExpor(this.detallepedidoexpor);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		detallepedidoexpor = new  DetallePedidoExpor();
		  		  
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
		detallepedidoexpor = new  DetallePedidoExpor();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetallePedidoExpor.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =detallepedidoexporDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		detallepedidoexpor = new  DetallePedidoExpor();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=detallepedidoexporDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		detallepedidoexpor = new  DetallePedidoExpor();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetallePedidoExpor.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =detallepedidoexporDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		detallepedidoexpor = new  DetallePedidoExpor();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=detallepedidoexporDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		detallepedidoexpor = new  DetallePedidoExpor();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetallePedidoExpor.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =detallepedidoexporDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		detallepedidoexpor = new  DetallePedidoExpor();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=detallepedidoexporDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		detallepedidoexpors = new  ArrayList<DetallePedidoExpor>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetallePedidoExpor.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			DetallePedidoExporLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detallepedidoexpors=detallepedidoexporDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarDetallePedidoExpor(detallepedidoexpors);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetallePedidoExporConstantesFunciones.refrescarForeignKeysDescripcionesDetallePedidoExpor(this.detallepedidoexpors);
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
		detallepedidoexpors = new  ArrayList<DetallePedidoExpor>();
		  		  
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
		detallepedidoexpors = new  ArrayList<DetallePedidoExpor>();
		  		  
        try {			
			DetallePedidoExporLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detallepedidoexpors=detallepedidoexporDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarDetallePedidoExpor(detallepedidoexpors);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetallePedidoExporConstantesFunciones.refrescarForeignKeysDescripcionesDetallePedidoExpor(this.detallepedidoexpors);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		detallepedidoexpors = new  ArrayList<DetallePedidoExpor>();
		  		  
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
		detallepedidoexpors = new  ArrayList<DetallePedidoExpor>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetallePedidoExpor.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			DetallePedidoExporLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detallepedidoexpors=detallepedidoexporDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarDetallePedidoExpor(detallepedidoexpors);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetallePedidoExporConstantesFunciones.refrescarForeignKeysDescripcionesDetallePedidoExpor(this.detallepedidoexpors);
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
		detallepedidoexpors = new  ArrayList<DetallePedidoExpor>();
		  		  
        try {
			DetallePedidoExporLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detallepedidoexpors=detallepedidoexporDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarDetallePedidoExpor(detallepedidoexpors);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetallePedidoExporConstantesFunciones.refrescarForeignKeysDescripcionesDetallePedidoExpor(this.detallepedidoexpors);
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
		detallepedidoexpors = new  ArrayList<DetallePedidoExpor>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetallePedidoExpor.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			DetallePedidoExporLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detallepedidoexpors=detallepedidoexporDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarDetallePedidoExpor(detallepedidoexpors);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetallePedidoExporConstantesFunciones.refrescarForeignKeysDescripcionesDetallePedidoExpor(this.detallepedidoexpors);
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
		detallepedidoexpors = new  ArrayList<DetallePedidoExpor>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			DetallePedidoExporLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detallepedidoexpors=detallepedidoexporDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarDetallePedidoExpor(detallepedidoexpors);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetallePedidoExporConstantesFunciones.refrescarForeignKeysDescripcionesDetallePedidoExpor(this.detallepedidoexpors);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		detallepedidoexpor = new  DetallePedidoExpor();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetallePedidoExpor.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			DetallePedidoExporLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detallepedidoexpor=detallepedidoexporDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarDetallePedidoExpor(detallepedidoexpor);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetallePedidoExporConstantesFunciones.refrescarForeignKeysDescripcionesDetallePedidoExpor(this.detallepedidoexpor);
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
		detallepedidoexpor = new  DetallePedidoExpor();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			DetallePedidoExporLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detallepedidoexpor=detallepedidoexporDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarDetallePedidoExpor(detallepedidoexpor);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetallePedidoExporConstantesFunciones.refrescarForeignKeysDescripcionesDetallePedidoExpor(this.detallepedidoexpor);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		detallepedidoexpors = new  ArrayList<DetallePedidoExpor>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetallePedidoExpor.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			DetallePedidoExporLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detallepedidoexpors=detallepedidoexporDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarDetallePedidoExpor(detallepedidoexpors);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetallePedidoExporConstantesFunciones.refrescarForeignKeysDescripcionesDetallePedidoExpor(this.detallepedidoexpors);
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
		detallepedidoexpors = new  ArrayList<DetallePedidoExpor>();
		  		  
        try {
			DetallePedidoExporLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detallepedidoexpors=detallepedidoexporDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarDetallePedidoExpor(detallepedidoexpors);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetallePedidoExporConstantesFunciones.refrescarForeignKeysDescripcionesDetallePedidoExpor(this.detallepedidoexpors);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosDetallePedidoExporsWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		detallepedidoexpors = new  ArrayList<DetallePedidoExpor>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetallePedidoExpor.class.getSimpleName()+"-getTodosDetallePedidoExporsWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			DetallePedidoExporLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detallepedidoexpors=detallepedidoexporDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarDetallePedidoExpor(detallepedidoexpors);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetallePedidoExporConstantesFunciones.refrescarForeignKeysDescripcionesDetallePedidoExpor(this.detallepedidoexpors);
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
	
	public  void  getTodosDetallePedidoExpors(String sFinalQuery,Pagination pagination)throws Exception {
		detallepedidoexpors = new  ArrayList<DetallePedidoExpor>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			DetallePedidoExporLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detallepedidoexpors=detallepedidoexporDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarDetallePedidoExpor(detallepedidoexpors);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetallePedidoExporConstantesFunciones.refrescarForeignKeysDescripcionesDetallePedidoExpor(this.detallepedidoexpors);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarDetallePedidoExpor(DetallePedidoExpor detallepedidoexpor) throws Exception {
		Boolean estaValidado=false;
		
		if(detallepedidoexpor.getIsNew() || detallepedidoexpor.getIsChanged()) { 
			this.invalidValues = detallepedidoexporValidator.getInvalidValues(detallepedidoexpor);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(detallepedidoexpor);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarDetallePedidoExpor(List<DetallePedidoExpor> DetallePedidoExpors) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(DetallePedidoExpor detallepedidoexporLocal:detallepedidoexpors) {				
			estaValidadoObjeto=this.validarGuardarDetallePedidoExpor(detallepedidoexporLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarDetallePedidoExpor(List<DetallePedidoExpor> DetallePedidoExpors) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarDetallePedidoExpor(detallepedidoexpors)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarDetallePedidoExpor(DetallePedidoExpor DetallePedidoExpor) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarDetallePedidoExpor(detallepedidoexpor)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(DetallePedidoExpor detallepedidoexpor) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+detallepedidoexpor.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=DetallePedidoExporConstantesFunciones.getDetallePedidoExporLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"detallepedidoexpor","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(DetallePedidoExporConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(DetallePedidoExporConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveDetallePedidoExporWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetallePedidoExpor.class.getSimpleName()+"-saveDetallePedidoExporWithConnection");connexion.begin();			
			
			DetallePedidoExporLogicAdditional.checkDetallePedidoExporToSave(this.detallepedidoexpor,this.datosCliente,connexion,this.arrDatoGeneral);
			
			DetallePedidoExporLogicAdditional.updateDetallePedidoExporToSave(this.detallepedidoexpor,this.arrDatoGeneral);
			
			DetallePedidoExporLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.detallepedidoexpor,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowDetallePedidoExpor();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarDetallePedidoExpor(this.detallepedidoexpor)) {
				DetallePedidoExporDataAccess.save(this.detallepedidoexpor, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.detallepedidoexpor,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			DetallePedidoExporLogicAdditional.checkDetallePedidoExporToSaveAfter(this.detallepedidoexpor,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowDetallePedidoExpor();
			
			connexion.commit();			
			
			if(this.detallepedidoexpor.getIsDeleted()) {
				this.detallepedidoexpor=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveDetallePedidoExpor()throws Exception {	
		try {	
			
			DetallePedidoExporLogicAdditional.checkDetallePedidoExporToSave(this.detallepedidoexpor,this.datosCliente,connexion,this.arrDatoGeneral);
			
			DetallePedidoExporLogicAdditional.updateDetallePedidoExporToSave(this.detallepedidoexpor,this.arrDatoGeneral);
			
			DetallePedidoExporLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.detallepedidoexpor,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarDetallePedidoExpor(this.detallepedidoexpor)) {			
				DetallePedidoExporDataAccess.save(this.detallepedidoexpor, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.detallepedidoexpor,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			DetallePedidoExporLogicAdditional.checkDetallePedidoExporToSaveAfter(this.detallepedidoexpor,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.detallepedidoexpor.getIsDeleted()) {
				this.detallepedidoexpor=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveDetallePedidoExporsWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetallePedidoExpor.class.getSimpleName()+"-saveDetallePedidoExporsWithConnection");connexion.begin();			
			
			DetallePedidoExporLogicAdditional.checkDetallePedidoExporToSaves(detallepedidoexpors,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowDetallePedidoExpors();
			
			Boolean validadoTodosDetallePedidoExpor=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(DetallePedidoExpor detallepedidoexporLocal:detallepedidoexpors) {		
				if(detallepedidoexporLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				DetallePedidoExporLogicAdditional.updateDetallePedidoExporToSave(detallepedidoexporLocal,this.arrDatoGeneral);
	        	
				DetallePedidoExporLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),detallepedidoexporLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarDetallePedidoExpor(detallepedidoexporLocal)) {
					DetallePedidoExporDataAccess.save(detallepedidoexporLocal, connexion);				
				} else {
					validadoTodosDetallePedidoExpor=false;
				}
			}
			
			if(!validadoTodosDetallePedidoExpor) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			DetallePedidoExporLogicAdditional.checkDetallePedidoExporToSavesAfter(detallepedidoexpors,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowDetallePedidoExpors();
			
			connexion.commit();		
			
			this.quitarDetallePedidoExporsEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveDetallePedidoExpors()throws Exception {				
		 try {	
			DetallePedidoExporLogicAdditional.checkDetallePedidoExporToSaves(detallepedidoexpors,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosDetallePedidoExpor=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(DetallePedidoExpor detallepedidoexporLocal:detallepedidoexpors) {				
				if(detallepedidoexporLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				DetallePedidoExporLogicAdditional.updateDetallePedidoExporToSave(detallepedidoexporLocal,this.arrDatoGeneral);
	        	
				DetallePedidoExporLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),detallepedidoexporLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarDetallePedidoExpor(detallepedidoexporLocal)) {				
					DetallePedidoExporDataAccess.save(detallepedidoexporLocal, connexion);				
				} else {
					validadoTodosDetallePedidoExpor=false;
				}
			}
			
			if(!validadoTodosDetallePedidoExpor) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			DetallePedidoExporLogicAdditional.checkDetallePedidoExporToSavesAfter(detallepedidoexpors,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarDetallePedidoExporsEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public DetallePedidoExporParameterReturnGeneral procesarAccionDetallePedidoExpors(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<DetallePedidoExpor> detallepedidoexpors,DetallePedidoExporParameterReturnGeneral detallepedidoexporParameterGeneral)throws Exception {
		 try {	
			DetallePedidoExporParameterReturnGeneral detallepedidoexporReturnGeneral=new DetallePedidoExporParameterReturnGeneral();
	
			DetallePedidoExporLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,detallepedidoexpors,detallepedidoexporParameterGeneral,detallepedidoexporReturnGeneral);
			
			return detallepedidoexporReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public DetallePedidoExporParameterReturnGeneral procesarAccionDetallePedidoExporsWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<DetallePedidoExpor> detallepedidoexpors,DetallePedidoExporParameterReturnGeneral detallepedidoexporParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetallePedidoExpor.class.getSimpleName()+"-procesarAccionDetallePedidoExporsWithConnection");connexion.begin();			
			
			DetallePedidoExporParameterReturnGeneral detallepedidoexporReturnGeneral=new DetallePedidoExporParameterReturnGeneral();
	
			DetallePedidoExporLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,detallepedidoexpors,detallepedidoexporParameterGeneral,detallepedidoexporReturnGeneral);
			
			this.connexion.commit();
			
			return detallepedidoexporReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public DetallePedidoExporParameterReturnGeneral procesarEventosDetallePedidoExpors(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<DetallePedidoExpor> detallepedidoexpors,DetallePedidoExpor detallepedidoexpor,DetallePedidoExporParameterReturnGeneral detallepedidoexporParameterGeneral,Boolean isEsNuevoDetallePedidoExpor,ArrayList<Classe> clases)throws Exception {
		 try {	
			DetallePedidoExporParameterReturnGeneral detallepedidoexporReturnGeneral=new DetallePedidoExporParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				detallepedidoexporReturnGeneral.setConRecargarPropiedades(true);
			}
			
			DetallePedidoExporLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,detallepedidoexpors,detallepedidoexpor,detallepedidoexporParameterGeneral,detallepedidoexporReturnGeneral,isEsNuevoDetallePedidoExpor,clases);
			
			return detallepedidoexporReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public DetallePedidoExporParameterReturnGeneral procesarEventosDetallePedidoExporsWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<DetallePedidoExpor> detallepedidoexpors,DetallePedidoExpor detallepedidoexpor,DetallePedidoExporParameterReturnGeneral detallepedidoexporParameterGeneral,Boolean isEsNuevoDetallePedidoExpor,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetallePedidoExpor.class.getSimpleName()+"-procesarEventosDetallePedidoExporsWithConnection");connexion.begin();			
			
			DetallePedidoExporParameterReturnGeneral detallepedidoexporReturnGeneral=new DetallePedidoExporParameterReturnGeneral();
	
			detallepedidoexporReturnGeneral.setDetallePedidoExpor(detallepedidoexpor);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				detallepedidoexporReturnGeneral.setConRecargarPropiedades(true);
			}
			
			DetallePedidoExporLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,detallepedidoexpors,detallepedidoexpor,detallepedidoexporParameterGeneral,detallepedidoexporReturnGeneral,isEsNuevoDetallePedidoExpor,clases);
			
			this.connexion.commit();
			
			return detallepedidoexporReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public DetallePedidoExporParameterReturnGeneral procesarImportacionDetallePedidoExporsWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,DetallePedidoExporParameterReturnGeneral detallepedidoexporParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetallePedidoExpor.class.getSimpleName()+"-procesarImportacionDetallePedidoExporsWithConnection");connexion.begin();			
			
			DetallePedidoExporParameterReturnGeneral detallepedidoexporReturnGeneral=new DetallePedidoExporParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.detallepedidoexpors=new ArrayList<DetallePedidoExpor>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.detallepedidoexpor=new DetallePedidoExpor();
				
				
				if(conColumnasBase) {this.detallepedidoexpor.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.detallepedidoexpor.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.detallepedidoexpor.setcantidad(Integer.parseInt(arrColumnas[iColumn++]));
				this.detallepedidoexpor.setprecio(Double.parseDouble(arrColumnas[iColumn++]));
				this.detallepedidoexpor.setdescuento_porcentaje(Double.parseDouble(arrColumnas[iColumn++]));
				this.detallepedidoexpor.setdescuento_valor(Double.parseDouble(arrColumnas[iColumn++]));
				this.detallepedidoexpor.setiva(Double.parseDouble(arrColumnas[iColumn++]));
				this.detallepedidoexpor.settotal(Double.parseDouble(arrColumnas[iColumn++]));
				
				this.detallepedidoexpors.add(this.detallepedidoexpor);
			}
			
			this.saveDetallePedidoExpors();
			
			this.connexion.commit();
			
			detallepedidoexporReturnGeneral.setConRetornoEstaProcesado(true);
			detallepedidoexporReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return detallepedidoexporReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarDetallePedidoExporsEliminados() throws Exception {				
		
		List<DetallePedidoExpor> detallepedidoexporsAux= new ArrayList<DetallePedidoExpor>();
		
		for(DetallePedidoExpor detallepedidoexpor:detallepedidoexpors) {
			if(!detallepedidoexpor.getIsDeleted()) {
				detallepedidoexporsAux.add(detallepedidoexpor);
			}
		}
		
		detallepedidoexpors=detallepedidoexporsAux;
	}
	
	public void quitarDetallePedidoExporsNulos() throws Exception {				
		
		List<DetallePedidoExpor> detallepedidoexporsAux= new ArrayList<DetallePedidoExpor>();
		
		for(DetallePedidoExpor detallepedidoexpor : this.detallepedidoexpors) {
			if(detallepedidoexpor==null) {
				detallepedidoexporsAux.add(detallepedidoexpor);
			}
		}
		
		//this.detallepedidoexpors=detallepedidoexporsAux;
		
		this.detallepedidoexpors.removeAll(detallepedidoexporsAux);
	}
	
	public void getSetVersionRowDetallePedidoExporWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(detallepedidoexpor.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((detallepedidoexpor.getIsDeleted() || (detallepedidoexpor.getIsChanged()&&!detallepedidoexpor.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=detallepedidoexporDataAccess.getSetVersionRowDetallePedidoExpor(connexion,detallepedidoexpor.getId());
				
				if(!detallepedidoexpor.getVersionRow().equals(timestamp)) {	
					detallepedidoexpor.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				detallepedidoexpor.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowDetallePedidoExpor()throws Exception {	
		
		if(detallepedidoexpor.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((detallepedidoexpor.getIsDeleted() || (detallepedidoexpor.getIsChanged()&&!detallepedidoexpor.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=detallepedidoexporDataAccess.getSetVersionRowDetallePedidoExpor(connexion,detallepedidoexpor.getId());
			
			try {							
				if(!detallepedidoexpor.getVersionRow().equals(timestamp)) {	
					detallepedidoexpor.setVersionRow(timestamp);
				}
				
				detallepedidoexpor.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowDetallePedidoExporsWithConnection()throws Exception {	
		if(detallepedidoexpors!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(DetallePedidoExpor detallepedidoexporAux:detallepedidoexpors) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(detallepedidoexporAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(detallepedidoexporAux.getIsDeleted() || (detallepedidoexporAux.getIsChanged()&&!detallepedidoexporAux.getIsNew())) {
						
						timestamp=detallepedidoexporDataAccess.getSetVersionRowDetallePedidoExpor(connexion,detallepedidoexporAux.getId());
						
						if(!detallepedidoexpor.getVersionRow().equals(timestamp)) {	
							detallepedidoexporAux.setVersionRow(timestamp);
						}
								
						detallepedidoexporAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowDetallePedidoExpors()throws Exception {	
		if(detallepedidoexpors!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(DetallePedidoExpor detallepedidoexporAux:detallepedidoexpors) {
					if(detallepedidoexporAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(detallepedidoexporAux.getIsDeleted() || (detallepedidoexporAux.getIsChanged()&&!detallepedidoexporAux.getIsNew())) {
						
						timestamp=detallepedidoexporDataAccess.getSetVersionRowDetallePedidoExpor(connexion,detallepedidoexporAux.getId());
						
						if(!detallepedidoexporAux.getVersionRow().equals(timestamp)) {	
							detallepedidoexporAux.setVersionRow(timestamp);
						}
						
													
						detallepedidoexporAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public DetallePedidoExporParameterReturnGeneral cargarCombosLoteForeignKeyDetallePedidoExporWithConnection(String finalQueryGlobalEmpresa,String finalQueryGlobalSucursal,String finalQueryGlobalEjercicio,String finalQueryGlobalPeriodo,String finalQueryGlobalAnio,String finalQueryGlobalMes,String finalQueryGlobalPedidoExpor,String finalQueryGlobalBodega,String finalQueryGlobalProducto,String finalQueryGlobalUnidad,String finalQueryGlobalEstadoDetallePedidoExpor) throws Exception {
		DetallePedidoExporParameterReturnGeneral  detallepedidoexporReturnGeneral =new DetallePedidoExporParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetallePedidoExpor.class.getSimpleName()+"-cargarCombosLoteForeignKeyDetallePedidoExporWithConnection");connexion.begin();
			
			detallepedidoexporReturnGeneral =new DetallePedidoExporParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			detallepedidoexporReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Sucursal> sucursalsForeignKey=new ArrayList<Sucursal>();
			SucursalLogic sucursalLogic=new SucursalLogic();
			sucursalLogic.setConnexion(this.connexion);
			//sucursalLogic.getSucursalDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalSucursal.equals("NONE")) {
				sucursalLogic.getTodosSucursals(finalQueryGlobalSucursal,new Pagination());
				sucursalsForeignKey=sucursalLogic.getSucursals();
			}

			detallepedidoexporReturnGeneral.setsucursalsForeignKey(sucursalsForeignKey);


			List<Ejercicio> ejerciciosForeignKey=new ArrayList<Ejercicio>();
			EjercicioLogic ejercicioLogic=new EjercicioLogic();
			ejercicioLogic.setConnexion(this.connexion);
			//ejercicioLogic.getEjercicioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEjercicio.equals("NONE")) {
				ejercicioLogic.getTodosEjercicios(finalQueryGlobalEjercicio,new Pagination());
				ejerciciosForeignKey=ejercicioLogic.getEjercicios();
			}

			detallepedidoexporReturnGeneral.setejerciciosForeignKey(ejerciciosForeignKey);


			List<Periodo> periodosForeignKey=new ArrayList<Periodo>();
			PeriodoLogic periodoLogic=new PeriodoLogic();
			periodoLogic.setConnexion(this.connexion);
			//periodoLogic.getPeriodoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalPeriodo.equals("NONE")) {
				periodoLogic.getTodosPeriodos(finalQueryGlobalPeriodo,new Pagination());
				periodosForeignKey=periodoLogic.getPeriodos();
			}

			detallepedidoexporReturnGeneral.setperiodosForeignKey(periodosForeignKey);


			List<Anio> aniosForeignKey=new ArrayList<Anio>();
			AnioLogic anioLogic=new AnioLogic();
			anioLogic.setConnexion(this.connexion);
			anioLogic.getAnioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalAnio.equals("NONE")) {
				anioLogic.getTodosAnios(finalQueryGlobalAnio,new Pagination());
				aniosForeignKey=anioLogic.getAnios();
			}

			detallepedidoexporReturnGeneral.setaniosForeignKey(aniosForeignKey);


			List<Mes> messForeignKey=new ArrayList<Mes>();
			MesLogic mesLogic=new MesLogic();
			mesLogic.setConnexion(this.connexion);
			mesLogic.getMesDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalMes.equals("NONE")) {
				mesLogic.getTodosMess(finalQueryGlobalMes,new Pagination());
				messForeignKey=mesLogic.getMess();
			}

			detallepedidoexporReturnGeneral.setmessForeignKey(messForeignKey);


			List<PedidoExpor> pedidoexporsForeignKey=new ArrayList<PedidoExpor>();
			PedidoExporLogic pedidoexporLogic=new PedidoExporLogic();
			pedidoexporLogic.setConnexion(this.connexion);
			pedidoexporLogic.getPedidoExporDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalPedidoExpor.equals("NONE")) {
				pedidoexporLogic.getTodosPedidoExpors(finalQueryGlobalPedidoExpor,new Pagination());
				pedidoexporsForeignKey=pedidoexporLogic.getPedidoExpors();
			}

			detallepedidoexporReturnGeneral.setpedidoexporsForeignKey(pedidoexporsForeignKey);


			List<Bodega> bodegasForeignKey=new ArrayList<Bodega>();
			BodegaLogic bodegaLogic=new BodegaLogic();
			bodegaLogic.setConnexion(this.connexion);
			bodegaLogic.getBodegaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalBodega.equals("NONE")) {
				bodegaLogic.getTodosBodegas(finalQueryGlobalBodega,new Pagination());
				bodegasForeignKey=bodegaLogic.getBodegas();
			}

			detallepedidoexporReturnGeneral.setbodegasForeignKey(bodegasForeignKey);


			List<Producto> productosForeignKey=new ArrayList<Producto>();
			ProductoLogic productoLogic=new ProductoLogic();
			productoLogic.setConnexion(this.connexion);
			//productoLogic.getProductoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalProducto.equals("NONE")) {
				productoLogic.getTodosProductos(finalQueryGlobalProducto,new Pagination());
				productosForeignKey=productoLogic.getProductos();
			}

			detallepedidoexporReturnGeneral.setproductosForeignKey(productosForeignKey);


			List<Unidad> unidadsForeignKey=new ArrayList<Unidad>();
			UnidadLogic unidadLogic=new UnidadLogic();
			unidadLogic.setConnexion(this.connexion);
			unidadLogic.getUnidadDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalUnidad.equals("NONE")) {
				unidadLogic.getTodosUnidads(finalQueryGlobalUnidad,new Pagination());
				unidadsForeignKey=unidadLogic.getUnidads();
			}

			detallepedidoexporReturnGeneral.setunidadsForeignKey(unidadsForeignKey);


			List<EstadoDetallePedido> estadodetallepedidoexporsForeignKey=new ArrayList<EstadoDetallePedido>();
			EstadoDetallePedidoLogic estadodetallepedidoexporLogic=new EstadoDetallePedidoLogic();
			estadodetallepedidoexporLogic.setConnexion(this.connexion);
			estadodetallepedidoexporLogic.getEstadoDetallePedidoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEstadoDetallePedidoExpor.equals("NONE")) {
				estadodetallepedidoexporLogic.getTodosEstadoDetallePedidos(finalQueryGlobalEstadoDetallePedidoExpor,new Pagination());
				estadodetallepedidoexporsForeignKey=estadodetallepedidoexporLogic.getEstadoDetallePedidos();
			}

			detallepedidoexporReturnGeneral.setestadodetallepedidoexporsForeignKey(estadodetallepedidoexporsForeignKey);

			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
		
		return detallepedidoexporReturnGeneral;
	}
	
	public DetallePedidoExporParameterReturnGeneral cargarCombosLoteForeignKeyDetallePedidoExpor(String finalQueryGlobalEmpresa,String finalQueryGlobalSucursal,String finalQueryGlobalEjercicio,String finalQueryGlobalPeriodo,String finalQueryGlobalAnio,String finalQueryGlobalMes,String finalQueryGlobalPedidoExpor,String finalQueryGlobalBodega,String finalQueryGlobalProducto,String finalQueryGlobalUnidad,String finalQueryGlobalEstadoDetallePedidoExpor) throws Exception {
		DetallePedidoExporParameterReturnGeneral  detallepedidoexporReturnGeneral =new DetallePedidoExporParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {						
			detallepedidoexporReturnGeneral =new DetallePedidoExporParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			detallepedidoexporReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Sucursal> sucursalsForeignKey=new ArrayList<Sucursal>();
			SucursalLogic sucursalLogic=new SucursalLogic();
			sucursalLogic.setConnexion(this.connexion);
			//sucursalLogic.getSucursalDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalSucursal.equals("NONE")) {
				sucursalLogic.getTodosSucursals(finalQueryGlobalSucursal,new Pagination());
				sucursalsForeignKey=sucursalLogic.getSucursals();
			}

			detallepedidoexporReturnGeneral.setsucursalsForeignKey(sucursalsForeignKey);


			List<Ejercicio> ejerciciosForeignKey=new ArrayList<Ejercicio>();
			EjercicioLogic ejercicioLogic=new EjercicioLogic();
			ejercicioLogic.setConnexion(this.connexion);
			//ejercicioLogic.getEjercicioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEjercicio.equals("NONE")) {
				ejercicioLogic.getTodosEjercicios(finalQueryGlobalEjercicio,new Pagination());
				ejerciciosForeignKey=ejercicioLogic.getEjercicios();
			}

			detallepedidoexporReturnGeneral.setejerciciosForeignKey(ejerciciosForeignKey);


			List<Periodo> periodosForeignKey=new ArrayList<Periodo>();
			PeriodoLogic periodoLogic=new PeriodoLogic();
			periodoLogic.setConnexion(this.connexion);
			//periodoLogic.getPeriodoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalPeriodo.equals("NONE")) {
				periodoLogic.getTodosPeriodos(finalQueryGlobalPeriodo,new Pagination());
				periodosForeignKey=periodoLogic.getPeriodos();
			}

			detallepedidoexporReturnGeneral.setperiodosForeignKey(periodosForeignKey);


			List<Anio> aniosForeignKey=new ArrayList<Anio>();
			AnioLogic anioLogic=new AnioLogic();
			anioLogic.setConnexion(this.connexion);
			anioLogic.getAnioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalAnio.equals("NONE")) {
				anioLogic.getTodosAnios(finalQueryGlobalAnio,new Pagination());
				aniosForeignKey=anioLogic.getAnios();
			}

			detallepedidoexporReturnGeneral.setaniosForeignKey(aniosForeignKey);


			List<Mes> messForeignKey=new ArrayList<Mes>();
			MesLogic mesLogic=new MesLogic();
			mesLogic.setConnexion(this.connexion);
			mesLogic.getMesDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalMes.equals("NONE")) {
				mesLogic.getTodosMess(finalQueryGlobalMes,new Pagination());
				messForeignKey=mesLogic.getMess();
			}

			detallepedidoexporReturnGeneral.setmessForeignKey(messForeignKey);


			List<PedidoExpor> pedidoexporsForeignKey=new ArrayList<PedidoExpor>();
			PedidoExporLogic pedidoexporLogic=new PedidoExporLogic();
			pedidoexporLogic.setConnexion(this.connexion);
			pedidoexporLogic.getPedidoExporDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalPedidoExpor.equals("NONE")) {
				pedidoexporLogic.getTodosPedidoExpors(finalQueryGlobalPedidoExpor,new Pagination());
				pedidoexporsForeignKey=pedidoexporLogic.getPedidoExpors();
			}

			detallepedidoexporReturnGeneral.setpedidoexporsForeignKey(pedidoexporsForeignKey);


			List<Bodega> bodegasForeignKey=new ArrayList<Bodega>();
			BodegaLogic bodegaLogic=new BodegaLogic();
			bodegaLogic.setConnexion(this.connexion);
			bodegaLogic.getBodegaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalBodega.equals("NONE")) {
				bodegaLogic.getTodosBodegas(finalQueryGlobalBodega,new Pagination());
				bodegasForeignKey=bodegaLogic.getBodegas();
			}

			detallepedidoexporReturnGeneral.setbodegasForeignKey(bodegasForeignKey);


			List<Producto> productosForeignKey=new ArrayList<Producto>();
			ProductoLogic productoLogic=new ProductoLogic();
			productoLogic.setConnexion(this.connexion);
			//productoLogic.getProductoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalProducto.equals("NONE")) {
				productoLogic.getTodosProductos(finalQueryGlobalProducto,new Pagination());
				productosForeignKey=productoLogic.getProductos();
			}

			detallepedidoexporReturnGeneral.setproductosForeignKey(productosForeignKey);


			List<Unidad> unidadsForeignKey=new ArrayList<Unidad>();
			UnidadLogic unidadLogic=new UnidadLogic();
			unidadLogic.setConnexion(this.connexion);
			unidadLogic.getUnidadDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalUnidad.equals("NONE")) {
				unidadLogic.getTodosUnidads(finalQueryGlobalUnidad,new Pagination());
				unidadsForeignKey=unidadLogic.getUnidads();
			}

			detallepedidoexporReturnGeneral.setunidadsForeignKey(unidadsForeignKey);


			List<EstadoDetallePedido> estadodetallepedidoexporsForeignKey=new ArrayList<EstadoDetallePedido>();
			EstadoDetallePedidoLogic estadodetallepedidoexporLogic=new EstadoDetallePedidoLogic();
			estadodetallepedidoexporLogic.setConnexion(this.connexion);
			estadodetallepedidoexporLogic.getEstadoDetallePedidoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEstadoDetallePedidoExpor.equals("NONE")) {
				estadodetallepedidoexporLogic.getTodosEstadoDetallePedidos(finalQueryGlobalEstadoDetallePedidoExpor,new Pagination());
				estadodetallepedidoexporsForeignKey=estadodetallepedidoexporLogic.getEstadoDetallePedidos();
			}

			detallepedidoexporReturnGeneral.setestadodetallepedidoexporsForeignKey(estadodetallepedidoexporsForeignKey);
						
			
		} catch(Exception e) {			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			
		}
		
		return detallepedidoexporReturnGeneral;
	}
	
	
	public void deepLoad(DetallePedidoExpor detallepedidoexpor,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			DetallePedidoExporLogicAdditional.updateDetallePedidoExporToGet(detallepedidoexpor,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		detallepedidoexpor.setEmpresa(detallepedidoexporDataAccess.getEmpresa(connexion,detallepedidoexpor));
		detallepedidoexpor.setSucursal(detallepedidoexporDataAccess.getSucursal(connexion,detallepedidoexpor));
		detallepedidoexpor.setEjercicio(detallepedidoexporDataAccess.getEjercicio(connexion,detallepedidoexpor));
		detallepedidoexpor.setPeriodo(detallepedidoexporDataAccess.getPeriodo(connexion,detallepedidoexpor));
		detallepedidoexpor.setAnio(detallepedidoexporDataAccess.getAnio(connexion,detallepedidoexpor));
		detallepedidoexpor.setMes(detallepedidoexporDataAccess.getMes(connexion,detallepedidoexpor));
		detallepedidoexpor.setPedidoExpor(detallepedidoexporDataAccess.getPedidoExpor(connexion,detallepedidoexpor));
		detallepedidoexpor.setBodega(detallepedidoexporDataAccess.getBodega(connexion,detallepedidoexpor));
		detallepedidoexpor.setProducto(detallepedidoexporDataAccess.getProducto(connexion,detallepedidoexpor));
		detallepedidoexpor.setUnidad(detallepedidoexporDataAccess.getUnidad(connexion,detallepedidoexpor));
		detallepedidoexpor.setEstadoDetallePedidoExpor(detallepedidoexporDataAccess.getEstadoDetallePedidoExpor(connexion,detallepedidoexpor));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				detallepedidoexpor.setEmpresa(detallepedidoexporDataAccess.getEmpresa(connexion,detallepedidoexpor));
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				detallepedidoexpor.setSucursal(detallepedidoexporDataAccess.getSucursal(connexion,detallepedidoexpor));
				continue;
			}

			if(clas.clas.equals(Ejercicio.class)) {
				detallepedidoexpor.setEjercicio(detallepedidoexporDataAccess.getEjercicio(connexion,detallepedidoexpor));
				continue;
			}

			if(clas.clas.equals(Periodo.class)) {
				detallepedidoexpor.setPeriodo(detallepedidoexporDataAccess.getPeriodo(connexion,detallepedidoexpor));
				continue;
			}

			if(clas.clas.equals(Anio.class)) {
				detallepedidoexpor.setAnio(detallepedidoexporDataAccess.getAnio(connexion,detallepedidoexpor));
				continue;
			}

			if(clas.clas.equals(Mes.class)) {
				detallepedidoexpor.setMes(detallepedidoexporDataAccess.getMes(connexion,detallepedidoexpor));
				continue;
			}

			if(clas.clas.equals(PedidoExpor.class)) {
				detallepedidoexpor.setPedidoExpor(detallepedidoexporDataAccess.getPedidoExpor(connexion,detallepedidoexpor));
				continue;
			}

			if(clas.clas.equals(Bodega.class)) {
				detallepedidoexpor.setBodega(detallepedidoexporDataAccess.getBodega(connexion,detallepedidoexpor));
				continue;
			}

			if(clas.clas.equals(Producto.class)) {
				detallepedidoexpor.setProducto(detallepedidoexporDataAccess.getProducto(connexion,detallepedidoexpor));
				continue;
			}

			if(clas.clas.equals(Unidad.class)) {
				detallepedidoexpor.setUnidad(detallepedidoexporDataAccess.getUnidad(connexion,detallepedidoexpor));
				continue;
			}

			if(clas.clas.equals(EstadoDetallePedido.class)) {
				detallepedidoexpor.setEstadoDetallePedidoExpor(detallepedidoexporDataAccess.getEstadoDetallePedidoExpor(connexion,detallepedidoexpor));
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
			detallepedidoexpor.setEmpresa(detallepedidoexporDataAccess.getEmpresa(connexion,detallepedidoexpor));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detallepedidoexpor.setSucursal(detallepedidoexporDataAccess.getSucursal(connexion,detallepedidoexpor));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Ejercicio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detallepedidoexpor.setEjercicio(detallepedidoexporDataAccess.getEjercicio(connexion,detallepedidoexpor));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Periodo.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detallepedidoexpor.setPeriodo(detallepedidoexporDataAccess.getPeriodo(connexion,detallepedidoexpor));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Anio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detallepedidoexpor.setAnio(detallepedidoexporDataAccess.getAnio(connexion,detallepedidoexpor));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Mes.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detallepedidoexpor.setMes(detallepedidoexporDataAccess.getMes(connexion,detallepedidoexpor));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(PedidoExpor.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detallepedidoexpor.setPedidoExpor(detallepedidoexporDataAccess.getPedidoExpor(connexion,detallepedidoexpor));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Bodega.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detallepedidoexpor.setBodega(detallepedidoexporDataAccess.getBodega(connexion,detallepedidoexpor));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Producto.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detallepedidoexpor.setProducto(detallepedidoexporDataAccess.getProducto(connexion,detallepedidoexpor));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Unidad.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detallepedidoexpor.setUnidad(detallepedidoexporDataAccess.getUnidad(connexion,detallepedidoexpor));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(EstadoDetallePedido.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detallepedidoexpor.setEstadoDetallePedidoExpor(detallepedidoexporDataAccess.getEstadoDetallePedidoExpor(connexion,detallepedidoexpor));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		detallepedidoexpor.setEmpresa(detallepedidoexporDataAccess.getEmpresa(connexion,detallepedidoexpor));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(detallepedidoexpor.getEmpresa(),isDeep,deepLoadType,clases);
				
		detallepedidoexpor.setSucursal(detallepedidoexporDataAccess.getSucursal(connexion,detallepedidoexpor));
		SucursalLogic sucursalLogic= new SucursalLogic(connexion);
		sucursalLogic.deepLoad(detallepedidoexpor.getSucursal(),isDeep,deepLoadType,clases);
				
		detallepedidoexpor.setEjercicio(detallepedidoexporDataAccess.getEjercicio(connexion,detallepedidoexpor));
		EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
		ejercicioLogic.deepLoad(detallepedidoexpor.getEjercicio(),isDeep,deepLoadType,clases);
				
		detallepedidoexpor.setPeriodo(detallepedidoexporDataAccess.getPeriodo(connexion,detallepedidoexpor));
		PeriodoLogic periodoLogic= new PeriodoLogic(connexion);
		periodoLogic.deepLoad(detallepedidoexpor.getPeriodo(),isDeep,deepLoadType,clases);
				
		detallepedidoexpor.setAnio(detallepedidoexporDataAccess.getAnio(connexion,detallepedidoexpor));
		AnioLogic anioLogic= new AnioLogic(connexion);
		anioLogic.deepLoad(detallepedidoexpor.getAnio(),isDeep,deepLoadType,clases);
				
		detallepedidoexpor.setMes(detallepedidoexporDataAccess.getMes(connexion,detallepedidoexpor));
		MesLogic mesLogic= new MesLogic(connexion);
		mesLogic.deepLoad(detallepedidoexpor.getMes(),isDeep,deepLoadType,clases);
				
		detallepedidoexpor.setPedidoExpor(detallepedidoexporDataAccess.getPedidoExpor(connexion,detallepedidoexpor));
		PedidoExporLogic pedidoexporLogic= new PedidoExporLogic(connexion);
		pedidoexporLogic.deepLoad(detallepedidoexpor.getPedidoExpor(),isDeep,deepLoadType,clases);
				
		detallepedidoexpor.setBodega(detallepedidoexporDataAccess.getBodega(connexion,detallepedidoexpor));
		BodegaLogic bodegaLogic= new BodegaLogic(connexion);
		bodegaLogic.deepLoad(detallepedidoexpor.getBodega(),isDeep,deepLoadType,clases);
				
		detallepedidoexpor.setProducto(detallepedidoexporDataAccess.getProducto(connexion,detallepedidoexpor));
		ProductoLogic productoLogic= new ProductoLogic(connexion);
		productoLogic.deepLoad(detallepedidoexpor.getProducto(),isDeep,deepLoadType,clases);
				
		detallepedidoexpor.setUnidad(detallepedidoexporDataAccess.getUnidad(connexion,detallepedidoexpor));
		UnidadLogic unidadLogic= new UnidadLogic(connexion);
		unidadLogic.deepLoad(detallepedidoexpor.getUnidad(),isDeep,deepLoadType,clases);
				
		detallepedidoexpor.setEstadoDetallePedidoExpor(detallepedidoexporDataAccess.getEstadoDetallePedidoExpor(connexion,detallepedidoexpor));
		EstadoDetallePedidoLogic estadodetallepedidoexporLogic= new EstadoDetallePedidoLogic(connexion);
		estadodetallepedidoexporLogic.deepLoad(detallepedidoexpor.getEstadoDetallePedidoExpor(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				detallepedidoexpor.setEmpresa(detallepedidoexporDataAccess.getEmpresa(connexion,detallepedidoexpor));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(detallepedidoexpor.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				detallepedidoexpor.setSucursal(detallepedidoexporDataAccess.getSucursal(connexion,detallepedidoexpor));
				SucursalLogic sucursalLogic= new SucursalLogic(connexion);
				sucursalLogic.deepLoad(detallepedidoexpor.getSucursal(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Ejercicio.class)) {
				detallepedidoexpor.setEjercicio(detallepedidoexporDataAccess.getEjercicio(connexion,detallepedidoexpor));
				EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
				ejercicioLogic.deepLoad(detallepedidoexpor.getEjercicio(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Periodo.class)) {
				detallepedidoexpor.setPeriodo(detallepedidoexporDataAccess.getPeriodo(connexion,detallepedidoexpor));
				PeriodoLogic periodoLogic= new PeriodoLogic(connexion);
				periodoLogic.deepLoad(detallepedidoexpor.getPeriodo(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Anio.class)) {
				detallepedidoexpor.setAnio(detallepedidoexporDataAccess.getAnio(connexion,detallepedidoexpor));
				AnioLogic anioLogic= new AnioLogic(connexion);
				anioLogic.deepLoad(detallepedidoexpor.getAnio(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Mes.class)) {
				detallepedidoexpor.setMes(detallepedidoexporDataAccess.getMes(connexion,detallepedidoexpor));
				MesLogic mesLogic= new MesLogic(connexion);
				mesLogic.deepLoad(detallepedidoexpor.getMes(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(PedidoExpor.class)) {
				detallepedidoexpor.setPedidoExpor(detallepedidoexporDataAccess.getPedidoExpor(connexion,detallepedidoexpor));
				PedidoExporLogic pedidoexporLogic= new PedidoExporLogic(connexion);
				pedidoexporLogic.deepLoad(detallepedidoexpor.getPedidoExpor(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Bodega.class)) {
				detallepedidoexpor.setBodega(detallepedidoexporDataAccess.getBodega(connexion,detallepedidoexpor));
				BodegaLogic bodegaLogic= new BodegaLogic(connexion);
				bodegaLogic.deepLoad(detallepedidoexpor.getBodega(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Producto.class)) {
				detallepedidoexpor.setProducto(detallepedidoexporDataAccess.getProducto(connexion,detallepedidoexpor));
				ProductoLogic productoLogic= new ProductoLogic(connexion);
				productoLogic.deepLoad(detallepedidoexpor.getProducto(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Unidad.class)) {
				detallepedidoexpor.setUnidad(detallepedidoexporDataAccess.getUnidad(connexion,detallepedidoexpor));
				UnidadLogic unidadLogic= new UnidadLogic(connexion);
				unidadLogic.deepLoad(detallepedidoexpor.getUnidad(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(EstadoDetallePedido.class)) {
				detallepedidoexpor.setEstadoDetallePedidoExpor(detallepedidoexporDataAccess.getEstadoDetallePedidoExpor(connexion,detallepedidoexpor));
				EstadoDetallePedidoLogic estadodetallepedidoLogic= new EstadoDetallePedidoLogic(connexion);
				estadodetallepedidoLogic.deepLoad(detallepedidoexpor.getEstadoDetallePedidoExpor(),isDeep,deepLoadType,clases);				
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
			detallepedidoexpor.setEmpresa(detallepedidoexporDataAccess.getEmpresa(connexion,detallepedidoexpor));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(detallepedidoexpor.getEmpresa(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detallepedidoexpor.setSucursal(detallepedidoexporDataAccess.getSucursal(connexion,detallepedidoexpor));
			SucursalLogic sucursalLogic= new SucursalLogic(connexion);
			sucursalLogic.deepLoad(detallepedidoexpor.getSucursal(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Ejercicio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detallepedidoexpor.setEjercicio(detallepedidoexporDataAccess.getEjercicio(connexion,detallepedidoexpor));
			EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
			ejercicioLogic.deepLoad(detallepedidoexpor.getEjercicio(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Periodo.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detallepedidoexpor.setPeriodo(detallepedidoexporDataAccess.getPeriodo(connexion,detallepedidoexpor));
			PeriodoLogic periodoLogic= new PeriodoLogic(connexion);
			periodoLogic.deepLoad(detallepedidoexpor.getPeriodo(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Anio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detallepedidoexpor.setAnio(detallepedidoexporDataAccess.getAnio(connexion,detallepedidoexpor));
			AnioLogic anioLogic= new AnioLogic(connexion);
			anioLogic.deepLoad(detallepedidoexpor.getAnio(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Mes.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detallepedidoexpor.setMes(detallepedidoexporDataAccess.getMes(connexion,detallepedidoexpor));
			MesLogic mesLogic= new MesLogic(connexion);
			mesLogic.deepLoad(detallepedidoexpor.getMes(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(PedidoExpor.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detallepedidoexpor.setPedidoExpor(detallepedidoexporDataAccess.getPedidoExpor(connexion,detallepedidoexpor));
			PedidoExporLogic pedidoexporLogic= new PedidoExporLogic(connexion);
			pedidoexporLogic.deepLoad(detallepedidoexpor.getPedidoExpor(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Bodega.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detallepedidoexpor.setBodega(detallepedidoexporDataAccess.getBodega(connexion,detallepedidoexpor));
			BodegaLogic bodegaLogic= new BodegaLogic(connexion);
			bodegaLogic.deepLoad(detallepedidoexpor.getBodega(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Producto.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detallepedidoexpor.setProducto(detallepedidoexporDataAccess.getProducto(connexion,detallepedidoexpor));
			ProductoLogic productoLogic= new ProductoLogic(connexion);
			productoLogic.deepLoad(detallepedidoexpor.getProducto(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Unidad.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detallepedidoexpor.setUnidad(detallepedidoexporDataAccess.getUnidad(connexion,detallepedidoexpor));
			UnidadLogic unidadLogic= new UnidadLogic(connexion);
			unidadLogic.deepLoad(detallepedidoexpor.getUnidad(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(EstadoDetallePedido.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detallepedidoexpor.setEstadoDetallePedidoExpor(detallepedidoexporDataAccess.getEstadoDetallePedidoExpor(connexion,detallepedidoexpor));
			EstadoDetallePedidoLogic estadodetallepedidoLogic= new EstadoDetallePedidoLogic(connexion);
			estadodetallepedidoLogic.deepLoad(detallepedidoexpor.getEstadoDetallePedidoExpor(),isDeep,deepLoadType,clases);
				
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(DetallePedidoExpor detallepedidoexpor,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			DetallePedidoExporLogicAdditional.updateDetallePedidoExporToSave(detallepedidoexpor,this.arrDatoGeneral);
			
DetallePedidoExporDataAccess.save(detallepedidoexpor, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(detallepedidoexpor.getEmpresa(),connexion);

		SucursalDataAccess.save(detallepedidoexpor.getSucursal(),connexion);

		EjercicioDataAccess.save(detallepedidoexpor.getEjercicio(),connexion);

		PeriodoDataAccess.save(detallepedidoexpor.getPeriodo(),connexion);

		AnioDataAccess.save(detallepedidoexpor.getAnio(),connexion);

		MesDataAccess.save(detallepedidoexpor.getMes(),connexion);

		PedidoExporDataAccess.save(detallepedidoexpor.getPedidoExpor(),connexion);

		BodegaDataAccess.save(detallepedidoexpor.getBodega(),connexion);

		ProductoDataAccess.save(detallepedidoexpor.getProducto(),connexion);

		UnidadDataAccess.save(detallepedidoexpor.getUnidad(),connexion);

		EstadoDetallePedidoDataAccess.save(detallepedidoexpor.getEstadoDetallePedidoExpor(),connexion);
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(detallepedidoexpor.getEmpresa(),connexion);
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				SucursalDataAccess.save(detallepedidoexpor.getSucursal(),connexion);
				continue;
			}

			if(clas.clas.equals(Ejercicio.class)) {
				EjercicioDataAccess.save(detallepedidoexpor.getEjercicio(),connexion);
				continue;
			}

			if(clas.clas.equals(Periodo.class)) {
				PeriodoDataAccess.save(detallepedidoexpor.getPeriodo(),connexion);
				continue;
			}

			if(clas.clas.equals(Anio.class)) {
				AnioDataAccess.save(detallepedidoexpor.getAnio(),connexion);
				continue;
			}

			if(clas.clas.equals(Mes.class)) {
				MesDataAccess.save(detallepedidoexpor.getMes(),connexion);
				continue;
			}

			if(clas.clas.equals(PedidoExpor.class)) {
				PedidoExporDataAccess.save(detallepedidoexpor.getPedidoExpor(),connexion);
				continue;
			}

			if(clas.clas.equals(Bodega.class)) {
				BodegaDataAccess.save(detallepedidoexpor.getBodega(),connexion);
				continue;
			}

			if(clas.clas.equals(Producto.class)) {
				ProductoDataAccess.save(detallepedidoexpor.getProducto(),connexion);
				continue;
			}

			if(clas.clas.equals(Unidad.class)) {
				UnidadDataAccess.save(detallepedidoexpor.getUnidad(),connexion);
				continue;
			}

			if(clas.clas.equals(EstadoDetallePedido.class)) {
				EstadoDetallePedidoDataAccess.save(detallepedidoexpor.getEstadoDetallePedidoExpor(),connexion);
				continue;
			}

		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(detallepedidoexpor.getEmpresa(),connexion);
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(detallepedidoexpor.getEmpresa(),isDeep,deepLoadType,clases);
				

		SucursalDataAccess.save(detallepedidoexpor.getSucursal(),connexion);
		SucursalLogic sucursalLogic= new SucursalLogic(connexion);
		sucursalLogic.deepLoad(detallepedidoexpor.getSucursal(),isDeep,deepLoadType,clases);
				

		EjercicioDataAccess.save(detallepedidoexpor.getEjercicio(),connexion);
		EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
		ejercicioLogic.deepLoad(detallepedidoexpor.getEjercicio(),isDeep,deepLoadType,clases);
				

		PeriodoDataAccess.save(detallepedidoexpor.getPeriodo(),connexion);
		PeriodoLogic periodoLogic= new PeriodoLogic(connexion);
		periodoLogic.deepLoad(detallepedidoexpor.getPeriodo(),isDeep,deepLoadType,clases);
				

		AnioDataAccess.save(detallepedidoexpor.getAnio(),connexion);
		AnioLogic anioLogic= new AnioLogic(connexion);
		anioLogic.deepLoad(detallepedidoexpor.getAnio(),isDeep,deepLoadType,clases);
				

		MesDataAccess.save(detallepedidoexpor.getMes(),connexion);
		MesLogic mesLogic= new MesLogic(connexion);
		mesLogic.deepLoad(detallepedidoexpor.getMes(),isDeep,deepLoadType,clases);
				

		PedidoExporDataAccess.save(detallepedidoexpor.getPedidoExpor(),connexion);
		PedidoExporLogic pedidoexporLogic= new PedidoExporLogic(connexion);
		pedidoexporLogic.deepLoad(detallepedidoexpor.getPedidoExpor(),isDeep,deepLoadType,clases);
				

		BodegaDataAccess.save(detallepedidoexpor.getBodega(),connexion);
		BodegaLogic bodegaLogic= new BodegaLogic(connexion);
		bodegaLogic.deepLoad(detallepedidoexpor.getBodega(),isDeep,deepLoadType,clases);
				

		ProductoDataAccess.save(detallepedidoexpor.getProducto(),connexion);
		ProductoLogic productoLogic= new ProductoLogic(connexion);
		productoLogic.deepLoad(detallepedidoexpor.getProducto(),isDeep,deepLoadType,clases);
				

		UnidadDataAccess.save(detallepedidoexpor.getUnidad(),connexion);
		UnidadLogic unidadLogic= new UnidadLogic(connexion);
		unidadLogic.deepLoad(detallepedidoexpor.getUnidad(),isDeep,deepLoadType,clases);
				

		EstadoDetallePedidoDataAccess.save(detallepedidoexpor.getEstadoDetallePedidoExpor(),connexion);
		EstadoDetallePedidoLogic estadodetallepedidoexporLogic= new EstadoDetallePedidoLogic(connexion);
		estadodetallepedidoexporLogic.deepLoad(detallepedidoexpor.getEstadoDetallePedidoExpor(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(detallepedidoexpor.getEmpresa(),connexion);
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepSave(detallepedidoexpor.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				SucursalDataAccess.save(detallepedidoexpor.getSucursal(),connexion);
				SucursalLogic sucursalLogic= new SucursalLogic(connexion);
				sucursalLogic.deepSave(detallepedidoexpor.getSucursal(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Ejercicio.class)) {
				EjercicioDataAccess.save(detallepedidoexpor.getEjercicio(),connexion);
				EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
				ejercicioLogic.deepSave(detallepedidoexpor.getEjercicio(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Periodo.class)) {
				PeriodoDataAccess.save(detallepedidoexpor.getPeriodo(),connexion);
				PeriodoLogic periodoLogic= new PeriodoLogic(connexion);
				periodoLogic.deepSave(detallepedidoexpor.getPeriodo(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Anio.class)) {
				AnioDataAccess.save(detallepedidoexpor.getAnio(),connexion);
				AnioLogic anioLogic= new AnioLogic(connexion);
				anioLogic.deepSave(detallepedidoexpor.getAnio(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Mes.class)) {
				MesDataAccess.save(detallepedidoexpor.getMes(),connexion);
				MesLogic mesLogic= new MesLogic(connexion);
				mesLogic.deepSave(detallepedidoexpor.getMes(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(PedidoExpor.class)) {
				PedidoExporDataAccess.save(detallepedidoexpor.getPedidoExpor(),connexion);
				PedidoExporLogic pedidoexporLogic= new PedidoExporLogic(connexion);
				pedidoexporLogic.deepSave(detallepedidoexpor.getPedidoExpor(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Bodega.class)) {
				BodegaDataAccess.save(detallepedidoexpor.getBodega(),connexion);
				BodegaLogic bodegaLogic= new BodegaLogic(connexion);
				bodegaLogic.deepSave(detallepedidoexpor.getBodega(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Producto.class)) {
				ProductoDataAccess.save(detallepedidoexpor.getProducto(),connexion);
				ProductoLogic productoLogic= new ProductoLogic(connexion);
				productoLogic.deepSave(detallepedidoexpor.getProducto(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Unidad.class)) {
				UnidadDataAccess.save(detallepedidoexpor.getUnidad(),connexion);
				UnidadLogic unidadLogic= new UnidadLogic(connexion);
				unidadLogic.deepSave(detallepedidoexpor.getUnidad(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(EstadoDetallePedido.class)) {
				EstadoDetallePedidoDataAccess.save(detallepedidoexpor.getEstadoDetallePedidoExpor(),connexion);
				EstadoDetallePedidoLogic estadodetallepedidoLogic= new EstadoDetallePedidoLogic(connexion);
				estadodetallepedidoLogic.deepSave(detallepedidoexpor.getEstadoDetallePedidoExpor(),isDeep,deepLoadType,clases);				
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
			this.getNewConnexionToDeep(DetallePedidoExpor.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(detallepedidoexpor,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				DetallePedidoExporConstantesFunciones.refrescarForeignKeysDescripcionesDetallePedidoExpor(detallepedidoexpor);
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
			this.deepLoad(this.detallepedidoexpor,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				DetallePedidoExporConstantesFunciones.refrescarForeignKeysDescripcionesDetallePedidoExpor(this.detallepedidoexpor);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(DetallePedidoExpor.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(detallepedidoexpors!=null) {
				for(DetallePedidoExpor detallepedidoexpor:detallepedidoexpors) {
					this.deepLoad(detallepedidoexpor,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					DetallePedidoExporConstantesFunciones.refrescarForeignKeysDescripcionesDetallePedidoExpor(detallepedidoexpors);
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
			if(detallepedidoexpors!=null) {
				for(DetallePedidoExpor detallepedidoexpor:detallepedidoexpors) {
					this.deepLoad(detallepedidoexpor,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					DetallePedidoExporConstantesFunciones.refrescarForeignKeysDescripcionesDetallePedidoExpor(detallepedidoexpors);
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
			this.getNewConnexionToDeep(DetallePedidoExpor.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(detallepedidoexpor,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(DetallePedidoExpor.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(detallepedidoexpors!=null) {
				for(DetallePedidoExpor detallepedidoexpor:detallepedidoexpors) {
					this.deepSave(detallepedidoexpor,isDeep,deepLoadType,clases);
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
			if(detallepedidoexpors!=null) {
				for(DetallePedidoExpor detallepedidoexpor:detallepedidoexpors) {
					this.deepSave(detallepedidoexpor,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getDetallePedidoExporsFK_IdAnioWithConnection(String sFinalQuery,Pagination pagination,Long id_anio)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetallePedidoExpor.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidAnio= new ParameterSelectionGeneral();
			parameterSelectionGeneralidAnio.setParameterSelectionGeneralEqual(ParameterType.LONG,id_anio,DetallePedidoExporConstantesFunciones.IDANIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidAnio);

			DetallePedidoExporLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdAnio","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detallepedidoexpors=detallepedidoexporDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetallePedidoExporConstantesFunciones.refrescarForeignKeysDescripcionesDetallePedidoExpor(this.detallepedidoexpors);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getDetallePedidoExporsFK_IdAnio(String sFinalQuery,Pagination pagination,Long id_anio)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidAnio= new ParameterSelectionGeneral();
			parameterSelectionGeneralidAnio.setParameterSelectionGeneralEqual(ParameterType.LONG,id_anio,DetallePedidoExporConstantesFunciones.IDANIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidAnio);

			DetallePedidoExporLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdAnio","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detallepedidoexpors=detallepedidoexporDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetallePedidoExporConstantesFunciones.refrescarForeignKeysDescripcionesDetallePedidoExpor(this.detallepedidoexpors);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getDetallePedidoExporsFK_IdBodegaWithConnection(String sFinalQuery,Pagination pagination,Long id_bodega)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetallePedidoExpor.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidBodega= new ParameterSelectionGeneral();
			parameterSelectionGeneralidBodega.setParameterSelectionGeneralEqual(ParameterType.LONG,id_bodega,DetallePedidoExporConstantesFunciones.IDBODEGA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidBodega);

			DetallePedidoExporLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdBodega","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detallepedidoexpors=detallepedidoexporDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetallePedidoExporConstantesFunciones.refrescarForeignKeysDescripcionesDetallePedidoExpor(this.detallepedidoexpors);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getDetallePedidoExporsFK_IdBodega(String sFinalQuery,Pagination pagination,Long id_bodega)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidBodega= new ParameterSelectionGeneral();
			parameterSelectionGeneralidBodega.setParameterSelectionGeneralEqual(ParameterType.LONG,id_bodega,DetallePedidoExporConstantesFunciones.IDBODEGA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidBodega);

			DetallePedidoExporLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdBodega","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detallepedidoexpors=detallepedidoexporDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetallePedidoExporConstantesFunciones.refrescarForeignKeysDescripcionesDetallePedidoExpor(this.detallepedidoexpors);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getDetallePedidoExporsFK_IdEjercicioWithConnection(String sFinalQuery,Pagination pagination,Long id_ejercicio)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetallePedidoExpor.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEjercicio= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEjercicio.setParameterSelectionGeneralEqual(ParameterType.LONG,id_ejercicio,DetallePedidoExporConstantesFunciones.IDEJERCICIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEjercicio);

			DetallePedidoExporLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEjercicio","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detallepedidoexpors=detallepedidoexporDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetallePedidoExporConstantesFunciones.refrescarForeignKeysDescripcionesDetallePedidoExpor(this.detallepedidoexpors);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getDetallePedidoExporsFK_IdEjercicio(String sFinalQuery,Pagination pagination,Long id_ejercicio)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEjercicio= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEjercicio.setParameterSelectionGeneralEqual(ParameterType.LONG,id_ejercicio,DetallePedidoExporConstantesFunciones.IDEJERCICIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEjercicio);

			DetallePedidoExporLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEjercicio","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detallepedidoexpors=detallepedidoexporDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetallePedidoExporConstantesFunciones.refrescarForeignKeysDescripcionesDetallePedidoExpor(this.detallepedidoexpors);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getDetallePedidoExporsFK_IdEmpresaWithConnection(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetallePedidoExpor.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,DetallePedidoExporConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			DetallePedidoExporLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detallepedidoexpors=detallepedidoexporDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetallePedidoExporConstantesFunciones.refrescarForeignKeysDescripcionesDetallePedidoExpor(this.detallepedidoexpors);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getDetallePedidoExporsFK_IdEmpresa(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,DetallePedidoExporConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			DetallePedidoExporLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detallepedidoexpors=detallepedidoexporDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetallePedidoExporConstantesFunciones.refrescarForeignKeysDescripcionesDetallePedidoExpor(this.detallepedidoexpors);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getDetallePedidoExporsFK_IdEstadoDetallePedidoExporWithConnection(String sFinalQuery,Pagination pagination,Long id_estado_detalle_pedido)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetallePedidoExpor.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEstadoDetallePedidoExpor= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEstadoDetallePedidoExpor.setParameterSelectionGeneralEqual(ParameterType.LONG,id_estado_detalle_pedido,DetallePedidoExporConstantesFunciones.IDESTADODETALLEPEDIDOEXPOR,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEstadoDetallePedidoExpor);

			DetallePedidoExporLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEstadoDetallePedidoExpor","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detallepedidoexpors=detallepedidoexporDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetallePedidoExporConstantesFunciones.refrescarForeignKeysDescripcionesDetallePedidoExpor(this.detallepedidoexpors);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getDetallePedidoExporsFK_IdEstadoDetallePedidoExpor(String sFinalQuery,Pagination pagination,Long id_estado_detalle_pedido)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEstadoDetallePedidoExpor= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEstadoDetallePedidoExpor.setParameterSelectionGeneralEqual(ParameterType.LONG,id_estado_detalle_pedido,DetallePedidoExporConstantesFunciones.IDESTADODETALLEPEDIDOEXPOR,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEstadoDetallePedidoExpor);

			DetallePedidoExporLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEstadoDetallePedidoExpor","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detallepedidoexpors=detallepedidoexporDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetallePedidoExporConstantesFunciones.refrescarForeignKeysDescripcionesDetallePedidoExpor(this.detallepedidoexpors);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getDetallePedidoExporsFK_IdMesWithConnection(String sFinalQuery,Pagination pagination,Long id_mes)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetallePedidoExpor.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidMes= new ParameterSelectionGeneral();
			parameterSelectionGeneralidMes.setParameterSelectionGeneralEqual(ParameterType.LONG,id_mes,DetallePedidoExporConstantesFunciones.IDMES,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidMes);

			DetallePedidoExporLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdMes","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detallepedidoexpors=detallepedidoexporDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetallePedidoExporConstantesFunciones.refrescarForeignKeysDescripcionesDetallePedidoExpor(this.detallepedidoexpors);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getDetallePedidoExporsFK_IdMes(String sFinalQuery,Pagination pagination,Long id_mes)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidMes= new ParameterSelectionGeneral();
			parameterSelectionGeneralidMes.setParameterSelectionGeneralEqual(ParameterType.LONG,id_mes,DetallePedidoExporConstantesFunciones.IDMES,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidMes);

			DetallePedidoExporLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdMes","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detallepedidoexpors=detallepedidoexporDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetallePedidoExporConstantesFunciones.refrescarForeignKeysDescripcionesDetallePedidoExpor(this.detallepedidoexpors);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getDetallePedidoExporsFK_IdPedidoExporWithConnection(String sFinalQuery,Pagination pagination,Long id_pedido_expor)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetallePedidoExpor.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidPedidoExpor= new ParameterSelectionGeneral();
			parameterSelectionGeneralidPedidoExpor.setParameterSelectionGeneralEqual(ParameterType.LONG,id_pedido_expor,DetallePedidoExporConstantesFunciones.IDPEDIDOEXPOR,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidPedidoExpor);

			DetallePedidoExporLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdPedidoExpor","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detallepedidoexpors=detallepedidoexporDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetallePedidoExporConstantesFunciones.refrescarForeignKeysDescripcionesDetallePedidoExpor(this.detallepedidoexpors);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getDetallePedidoExporsFK_IdPedidoExpor(String sFinalQuery,Pagination pagination,Long id_pedido_expor)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidPedidoExpor= new ParameterSelectionGeneral();
			parameterSelectionGeneralidPedidoExpor.setParameterSelectionGeneralEqual(ParameterType.LONG,id_pedido_expor,DetallePedidoExporConstantesFunciones.IDPEDIDOEXPOR,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidPedidoExpor);

			DetallePedidoExporLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdPedidoExpor","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detallepedidoexpors=detallepedidoexporDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetallePedidoExporConstantesFunciones.refrescarForeignKeysDescripcionesDetallePedidoExpor(this.detallepedidoexpors);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getDetallePedidoExporsFK_IdPeriodoWithConnection(String sFinalQuery,Pagination pagination,Long id_periodo)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetallePedidoExpor.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidPeriodo= new ParameterSelectionGeneral();
			parameterSelectionGeneralidPeriodo.setParameterSelectionGeneralEqual(ParameterType.LONG,id_periodo,DetallePedidoExporConstantesFunciones.IDPERIODO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidPeriodo);

			DetallePedidoExporLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdPeriodo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detallepedidoexpors=detallepedidoexporDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetallePedidoExporConstantesFunciones.refrescarForeignKeysDescripcionesDetallePedidoExpor(this.detallepedidoexpors);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getDetallePedidoExporsFK_IdPeriodo(String sFinalQuery,Pagination pagination,Long id_periodo)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidPeriodo= new ParameterSelectionGeneral();
			parameterSelectionGeneralidPeriodo.setParameterSelectionGeneralEqual(ParameterType.LONG,id_periodo,DetallePedidoExporConstantesFunciones.IDPERIODO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidPeriodo);

			DetallePedidoExporLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdPeriodo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detallepedidoexpors=detallepedidoexporDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetallePedidoExporConstantesFunciones.refrescarForeignKeysDescripcionesDetallePedidoExpor(this.detallepedidoexpors);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getDetallePedidoExporsFK_IdProductoWithConnection(String sFinalQuery,Pagination pagination,Long id_producto)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetallePedidoExpor.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidProducto= new ParameterSelectionGeneral();
			parameterSelectionGeneralidProducto.setParameterSelectionGeneralEqual(ParameterType.LONG,id_producto,DetallePedidoExporConstantesFunciones.IDPRODUCTO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidProducto);

			DetallePedidoExporLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdProducto","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detallepedidoexpors=detallepedidoexporDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetallePedidoExporConstantesFunciones.refrescarForeignKeysDescripcionesDetallePedidoExpor(this.detallepedidoexpors);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getDetallePedidoExporsFK_IdProducto(String sFinalQuery,Pagination pagination,Long id_producto)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidProducto= new ParameterSelectionGeneral();
			parameterSelectionGeneralidProducto.setParameterSelectionGeneralEqual(ParameterType.LONG,id_producto,DetallePedidoExporConstantesFunciones.IDPRODUCTO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidProducto);

			DetallePedidoExporLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdProducto","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detallepedidoexpors=detallepedidoexporDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetallePedidoExporConstantesFunciones.refrescarForeignKeysDescripcionesDetallePedidoExpor(this.detallepedidoexpors);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getDetallePedidoExporsFK_IdSucursalWithConnection(String sFinalQuery,Pagination pagination,Long id_sucursal)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetallePedidoExpor.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidSucursal= new ParameterSelectionGeneral();
			parameterSelectionGeneralidSucursal.setParameterSelectionGeneralEqual(ParameterType.LONG,id_sucursal,DetallePedidoExporConstantesFunciones.IDSUCURSAL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidSucursal);

			DetallePedidoExporLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdSucursal","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detallepedidoexpors=detallepedidoexporDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetallePedidoExporConstantesFunciones.refrescarForeignKeysDescripcionesDetallePedidoExpor(this.detallepedidoexpors);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getDetallePedidoExporsFK_IdSucursal(String sFinalQuery,Pagination pagination,Long id_sucursal)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidSucursal= new ParameterSelectionGeneral();
			parameterSelectionGeneralidSucursal.setParameterSelectionGeneralEqual(ParameterType.LONG,id_sucursal,DetallePedidoExporConstantesFunciones.IDSUCURSAL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidSucursal);

			DetallePedidoExporLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdSucursal","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detallepedidoexpors=detallepedidoexporDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetallePedidoExporConstantesFunciones.refrescarForeignKeysDescripcionesDetallePedidoExpor(this.detallepedidoexpors);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getDetallePedidoExporsFK_IdUnidadWithConnection(String sFinalQuery,Pagination pagination,Long id_unidad)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetallePedidoExpor.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidUnidad= new ParameterSelectionGeneral();
			parameterSelectionGeneralidUnidad.setParameterSelectionGeneralEqual(ParameterType.LONG,id_unidad,DetallePedidoExporConstantesFunciones.IDUNIDAD,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidUnidad);

			DetallePedidoExporLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdUnidad","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detallepedidoexpors=detallepedidoexporDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetallePedidoExporConstantesFunciones.refrescarForeignKeysDescripcionesDetallePedidoExpor(this.detallepedidoexpors);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getDetallePedidoExporsFK_IdUnidad(String sFinalQuery,Pagination pagination,Long id_unidad)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidUnidad= new ParameterSelectionGeneral();
			parameterSelectionGeneralidUnidad.setParameterSelectionGeneralEqual(ParameterType.LONG,id_unidad,DetallePedidoExporConstantesFunciones.IDUNIDAD,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidUnidad);

			DetallePedidoExporLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdUnidad","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detallepedidoexpors=detallepedidoexporDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetallePedidoExporConstantesFunciones.refrescarForeignKeysDescripcionesDetallePedidoExpor(this.detallepedidoexpors);
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
			if(DetallePedidoExporConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,DetallePedidoExporDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,DetallePedidoExpor detallepedidoexpor,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(DetallePedidoExporConstantesFunciones.ISCONAUDITORIA) {
				if(detallepedidoexpor.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,DetallePedidoExporDataAccess.TABLENAME, detallepedidoexpor.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(DetallePedidoExporConstantesFunciones.ISCONAUDITORIADETALLE) {
						////DetallePedidoExporLogic.registrarAuditoriaDetallesDetallePedidoExpor(connexion,detallepedidoexpor,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(detallepedidoexpor.getIsDeleted()) {
					/*if(!detallepedidoexpor.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,DetallePedidoExporDataAccess.TABLENAME, detallepedidoexpor.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////DetallePedidoExporLogic.registrarAuditoriaDetallesDetallePedidoExpor(connexion,detallepedidoexpor,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,DetallePedidoExporDataAccess.TABLENAME, detallepedidoexpor.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(detallepedidoexpor.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,DetallePedidoExporDataAccess.TABLENAME, detallepedidoexpor.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(DetallePedidoExporConstantesFunciones.ISCONAUDITORIADETALLE) {
						////DetallePedidoExporLogic.registrarAuditoriaDetallesDetallePedidoExpor(connexion,detallepedidoexpor,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesDetallePedidoExpor(Connexion connexion,DetallePedidoExpor detallepedidoexpor)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(detallepedidoexpor.getIsNew()||!detallepedidoexpor.getid_empresa().equals(detallepedidoexpor.getDetallePedidoExporOriginal().getid_empresa()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detallepedidoexpor.getDetallePedidoExporOriginal().getid_empresa()!=null)
				{
					strValorActual=detallepedidoexpor.getDetallePedidoExporOriginal().getid_empresa().toString();
				}
				if(detallepedidoexpor.getid_empresa()!=null)
				{
					strValorNuevo=detallepedidoexpor.getid_empresa().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetallePedidoExporConstantesFunciones.IDEMPRESA,strValorActual,strValorNuevo);
			}	
			
			if(detallepedidoexpor.getIsNew()||!detallepedidoexpor.getid_sucursal().equals(detallepedidoexpor.getDetallePedidoExporOriginal().getid_sucursal()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detallepedidoexpor.getDetallePedidoExporOriginal().getid_sucursal()!=null)
				{
					strValorActual=detallepedidoexpor.getDetallePedidoExporOriginal().getid_sucursal().toString();
				}
				if(detallepedidoexpor.getid_sucursal()!=null)
				{
					strValorNuevo=detallepedidoexpor.getid_sucursal().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetallePedidoExporConstantesFunciones.IDSUCURSAL,strValorActual,strValorNuevo);
			}	
			
			if(detallepedidoexpor.getIsNew()||!detallepedidoexpor.getid_ejercicio().equals(detallepedidoexpor.getDetallePedidoExporOriginal().getid_ejercicio()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detallepedidoexpor.getDetallePedidoExporOriginal().getid_ejercicio()!=null)
				{
					strValorActual=detallepedidoexpor.getDetallePedidoExporOriginal().getid_ejercicio().toString();
				}
				if(detallepedidoexpor.getid_ejercicio()!=null)
				{
					strValorNuevo=detallepedidoexpor.getid_ejercicio().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetallePedidoExporConstantesFunciones.IDEJERCICIO,strValorActual,strValorNuevo);
			}	
			
			if(detallepedidoexpor.getIsNew()||!detallepedidoexpor.getid_periodo().equals(detallepedidoexpor.getDetallePedidoExporOriginal().getid_periodo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detallepedidoexpor.getDetallePedidoExporOriginal().getid_periodo()!=null)
				{
					strValorActual=detallepedidoexpor.getDetallePedidoExporOriginal().getid_periodo().toString();
				}
				if(detallepedidoexpor.getid_periodo()!=null)
				{
					strValorNuevo=detallepedidoexpor.getid_periodo().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetallePedidoExporConstantesFunciones.IDPERIODO,strValorActual,strValorNuevo);
			}	
			
			if(detallepedidoexpor.getIsNew()||!detallepedidoexpor.getid_anio().equals(detallepedidoexpor.getDetallePedidoExporOriginal().getid_anio()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detallepedidoexpor.getDetallePedidoExporOriginal().getid_anio()!=null)
				{
					strValorActual=detallepedidoexpor.getDetallePedidoExporOriginal().getid_anio().toString();
				}
				if(detallepedidoexpor.getid_anio()!=null)
				{
					strValorNuevo=detallepedidoexpor.getid_anio().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetallePedidoExporConstantesFunciones.IDANIO,strValorActual,strValorNuevo);
			}	
			
			if(detallepedidoexpor.getIsNew()||!detallepedidoexpor.getid_mes().equals(detallepedidoexpor.getDetallePedidoExporOriginal().getid_mes()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detallepedidoexpor.getDetallePedidoExporOriginal().getid_mes()!=null)
				{
					strValorActual=detallepedidoexpor.getDetallePedidoExporOriginal().getid_mes().toString();
				}
				if(detallepedidoexpor.getid_mes()!=null)
				{
					strValorNuevo=detallepedidoexpor.getid_mes().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetallePedidoExporConstantesFunciones.IDMES,strValorActual,strValorNuevo);
			}	
			
			if(detallepedidoexpor.getIsNew()||!detallepedidoexpor.getid_pedido_expor().equals(detallepedidoexpor.getDetallePedidoExporOriginal().getid_pedido_expor()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detallepedidoexpor.getDetallePedidoExporOriginal().getid_pedido_expor()!=null)
				{
					strValorActual=detallepedidoexpor.getDetallePedidoExporOriginal().getid_pedido_expor().toString();
				}
				if(detallepedidoexpor.getid_pedido_expor()!=null)
				{
					strValorNuevo=detallepedidoexpor.getid_pedido_expor().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetallePedidoExporConstantesFunciones.IDPEDIDOEXPOR,strValorActual,strValorNuevo);
			}	
			
			if(detallepedidoexpor.getIsNew()||!detallepedidoexpor.getid_bodega().equals(detallepedidoexpor.getDetallePedidoExporOriginal().getid_bodega()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detallepedidoexpor.getDetallePedidoExporOriginal().getid_bodega()!=null)
				{
					strValorActual=detallepedidoexpor.getDetallePedidoExporOriginal().getid_bodega().toString();
				}
				if(detallepedidoexpor.getid_bodega()!=null)
				{
					strValorNuevo=detallepedidoexpor.getid_bodega().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetallePedidoExporConstantesFunciones.IDBODEGA,strValorActual,strValorNuevo);
			}	
			
			if(detallepedidoexpor.getIsNew()||!detallepedidoexpor.getid_producto().equals(detallepedidoexpor.getDetallePedidoExporOriginal().getid_producto()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detallepedidoexpor.getDetallePedidoExporOriginal().getid_producto()!=null)
				{
					strValorActual=detallepedidoexpor.getDetallePedidoExporOriginal().getid_producto().toString();
				}
				if(detallepedidoexpor.getid_producto()!=null)
				{
					strValorNuevo=detallepedidoexpor.getid_producto().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetallePedidoExporConstantesFunciones.IDPRODUCTO,strValorActual,strValorNuevo);
			}	
			
			if(detallepedidoexpor.getIsNew()||!detallepedidoexpor.getid_unidad().equals(detallepedidoexpor.getDetallePedidoExporOriginal().getid_unidad()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detallepedidoexpor.getDetallePedidoExporOriginal().getid_unidad()!=null)
				{
					strValorActual=detallepedidoexpor.getDetallePedidoExporOriginal().getid_unidad().toString();
				}
				if(detallepedidoexpor.getid_unidad()!=null)
				{
					strValorNuevo=detallepedidoexpor.getid_unidad().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetallePedidoExporConstantesFunciones.IDUNIDAD,strValorActual,strValorNuevo);
			}	
			
			if(detallepedidoexpor.getIsNew()||!detallepedidoexpor.getid_estado_detalle_pedido().equals(detallepedidoexpor.getDetallePedidoExporOriginal().getid_estado_detalle_pedido()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detallepedidoexpor.getDetallePedidoExporOriginal().getid_estado_detalle_pedido()!=null)
				{
					strValorActual=detallepedidoexpor.getDetallePedidoExporOriginal().getid_estado_detalle_pedido().toString();
				}
				if(detallepedidoexpor.getid_estado_detalle_pedido()!=null)
				{
					strValorNuevo=detallepedidoexpor.getid_estado_detalle_pedido().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetallePedidoExporConstantesFunciones.IDESTADODETALLEPEDIDOEXPOR,strValorActual,strValorNuevo);
			}	
			
			if(detallepedidoexpor.getIsNew()||!detallepedidoexpor.getcantidad().equals(detallepedidoexpor.getDetallePedidoExporOriginal().getcantidad()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detallepedidoexpor.getDetallePedidoExporOriginal().getcantidad()!=null)
				{
					strValorActual=detallepedidoexpor.getDetallePedidoExporOriginal().getcantidad().toString();
				}
				if(detallepedidoexpor.getcantidad()!=null)
				{
					strValorNuevo=detallepedidoexpor.getcantidad().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetallePedidoExporConstantesFunciones.CANTIDAD,strValorActual,strValorNuevo);
			}	
			
			if(detallepedidoexpor.getIsNew()||!detallepedidoexpor.getprecio().equals(detallepedidoexpor.getDetallePedidoExporOriginal().getprecio()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detallepedidoexpor.getDetallePedidoExporOriginal().getprecio()!=null)
				{
					strValorActual=detallepedidoexpor.getDetallePedidoExporOriginal().getprecio().toString();
				}
				if(detallepedidoexpor.getprecio()!=null)
				{
					strValorNuevo=detallepedidoexpor.getprecio().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetallePedidoExporConstantesFunciones.PRECIO,strValorActual,strValorNuevo);
			}	
			
			if(detallepedidoexpor.getIsNew()||!detallepedidoexpor.getdescuento_porcentaje().equals(detallepedidoexpor.getDetallePedidoExporOriginal().getdescuento_porcentaje()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detallepedidoexpor.getDetallePedidoExporOriginal().getdescuento_porcentaje()!=null)
				{
					strValorActual=detallepedidoexpor.getDetallePedidoExporOriginal().getdescuento_porcentaje().toString();
				}
				if(detallepedidoexpor.getdescuento_porcentaje()!=null)
				{
					strValorNuevo=detallepedidoexpor.getdescuento_porcentaje().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetallePedidoExporConstantesFunciones.DESCUENTOPORCENTAJE,strValorActual,strValorNuevo);
			}	
			
			if(detallepedidoexpor.getIsNew()||!detallepedidoexpor.getdescuento_valor().equals(detallepedidoexpor.getDetallePedidoExporOriginal().getdescuento_valor()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detallepedidoexpor.getDetallePedidoExporOriginal().getdescuento_valor()!=null)
				{
					strValorActual=detallepedidoexpor.getDetallePedidoExporOriginal().getdescuento_valor().toString();
				}
				if(detallepedidoexpor.getdescuento_valor()!=null)
				{
					strValorNuevo=detallepedidoexpor.getdescuento_valor().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetallePedidoExporConstantesFunciones.DESCUENTOVALOR,strValorActual,strValorNuevo);
			}	
			
			if(detallepedidoexpor.getIsNew()||!detallepedidoexpor.getiva().equals(detallepedidoexpor.getDetallePedidoExporOriginal().getiva()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detallepedidoexpor.getDetallePedidoExporOriginal().getiva()!=null)
				{
					strValorActual=detallepedidoexpor.getDetallePedidoExporOriginal().getiva().toString();
				}
				if(detallepedidoexpor.getiva()!=null)
				{
					strValorNuevo=detallepedidoexpor.getiva().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetallePedidoExporConstantesFunciones.IVA,strValorActual,strValorNuevo);
			}	
			
			if(detallepedidoexpor.getIsNew()||!detallepedidoexpor.gettotal().equals(detallepedidoexpor.getDetallePedidoExporOriginal().gettotal()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detallepedidoexpor.getDetallePedidoExporOriginal().gettotal()!=null)
				{
					strValorActual=detallepedidoexpor.getDetallePedidoExporOriginal().gettotal().toString();
				}
				if(detallepedidoexpor.gettotal()!=null)
				{
					strValorNuevo=detallepedidoexpor.gettotal().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetallePedidoExporConstantesFunciones.TOTAL,strValorActual,strValorNuevo);
			}	
			
			if(detallepedidoexpor.getIsNew()||!detallepedidoexpor.getice().equals(detallepedidoexpor.getDetallePedidoExporOriginal().getice()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detallepedidoexpor.getDetallePedidoExporOriginal().getice()!=null)
				{
					strValorActual=detallepedidoexpor.getDetallePedidoExporOriginal().getice().toString();
				}
				if(detallepedidoexpor.getice()!=null)
				{
					strValorNuevo=detallepedidoexpor.getice().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetallePedidoExporConstantesFunciones.ICE,strValorActual,strValorNuevo);
			}	
			
			if(detallepedidoexpor.getIsNew()||!detallepedidoexpor.getcosto().equals(detallepedidoexpor.getDetallePedidoExporOriginal().getcosto()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detallepedidoexpor.getDetallePedidoExporOriginal().getcosto()!=null)
				{
					strValorActual=detallepedidoexpor.getDetallePedidoExporOriginal().getcosto().toString();
				}
				if(detallepedidoexpor.getcosto()!=null)
				{
					strValorNuevo=detallepedidoexpor.getcosto().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetallePedidoExporConstantesFunciones.COSTO,strValorActual,strValorNuevo);
			}	
			
			if(detallepedidoexpor.getIsNew()||!detallepedidoexpor.getutilidad().equals(detallepedidoexpor.getDetallePedidoExporOriginal().getutilidad()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detallepedidoexpor.getDetallePedidoExporOriginal().getutilidad()!=null)
				{
					strValorActual=detallepedidoexpor.getDetallePedidoExporOriginal().getutilidad().toString();
				}
				if(detallepedidoexpor.getutilidad()!=null)
				{
					strValorNuevo=detallepedidoexpor.getutilidad().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetallePedidoExporConstantesFunciones.UTILIDAD,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void saveDetallePedidoExporRelacionesWithConnection(DetallePedidoExpor detallepedidoexpor) throws Exception {

		if(!detallepedidoexpor.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveDetallePedidoExporRelacionesBase(detallepedidoexpor,true);
		}
	}

	public void saveDetallePedidoExporRelaciones(DetallePedidoExpor detallepedidoexpor)throws Exception {

		if(!detallepedidoexpor.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveDetallePedidoExporRelacionesBase(detallepedidoexpor,false);
		}
	}

	public void saveDetallePedidoExporRelacionesBase(DetallePedidoExpor detallepedidoexpor,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("DetallePedidoExpor-saveRelacionesWithConnection");}
	

			this.setDetallePedidoExpor(detallepedidoexpor);

			if(DetallePedidoExporLogicAdditional.validarSaveRelaciones(detallepedidoexpor,this)) {

				DetallePedidoExporLogicAdditional.updateRelacionesToSave(detallepedidoexpor,this);

				if((detallepedidoexpor.getIsNew()||detallepedidoexpor.getIsChanged())&&!detallepedidoexpor.getIsDeleted()) {
					this.saveDetallePedidoExpor();
					this.saveDetallePedidoExporRelacionesDetalles();

				} else if(detallepedidoexpor.getIsDeleted()) {
					this.saveDetallePedidoExporRelacionesDetalles();
					this.saveDetallePedidoExpor();
				}

				DetallePedidoExporLogicAdditional.updateRelacionesToSaveAfter(detallepedidoexpor,this);

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
	
	
	private void saveDetallePedidoExporRelacionesDetalles()throws Exception {
		try {
	

		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfDetallePedidoExpor(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=DetallePedidoExporConstantesFunciones.getClassesForeignKeysOfDetallePedidoExpor(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfDetallePedidoExpor(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=DetallePedidoExporConstantesFunciones.getClassesRelationshipsOfDetallePedidoExpor(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}
