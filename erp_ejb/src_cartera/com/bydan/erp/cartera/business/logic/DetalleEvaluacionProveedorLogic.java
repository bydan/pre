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
import com.bydan.erp.cartera.util.DetalleEvaluacionProveedorConstantesFunciones;
import com.bydan.erp.cartera.util.DetalleEvaluacionProveedorParameterReturnGeneral;
//import com.bydan.erp.cartera.util.DetalleEvaluacionProveedorParameterGeneral;
import com.bydan.erp.cartera.business.entity.DetalleEvaluacionProveedor;
import com.bydan.erp.cartera.business.logic.DetalleEvaluacionProveedorLogicAdditional;
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
public class DetalleEvaluacionProveedorLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(DetalleEvaluacionProveedorLogic.class);
	
	protected DetalleEvaluacionProveedorDataAccess detalleevaluacionproveedorDataAccess; 	
	protected DetalleEvaluacionProveedor detalleevaluacionproveedor;
	protected List<DetalleEvaluacionProveedor> detalleevaluacionproveedors;
	protected Object detalleevaluacionproveedorObject;	
	protected List<Object> detalleevaluacionproveedorsObject;
	
	public static ClassValidator<DetalleEvaluacionProveedor> detalleevaluacionproveedorValidator = new ClassValidator<DetalleEvaluacionProveedor>(DetalleEvaluacionProveedor.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected DetalleEvaluacionProveedorLogicAdditional detalleevaluacionproveedorLogicAdditional=null;
	
	public DetalleEvaluacionProveedorLogicAdditional getDetalleEvaluacionProveedorLogicAdditional() {
		return this.detalleevaluacionproveedorLogicAdditional;
	}
	
	public void setDetalleEvaluacionProveedorLogicAdditional(DetalleEvaluacionProveedorLogicAdditional detalleevaluacionproveedorLogicAdditional) {
		try {
			this.detalleevaluacionproveedorLogicAdditional=detalleevaluacionproveedorLogicAdditional;
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
	
	
	
	
	public  DetalleEvaluacionProveedorLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.detalleevaluacionproveedorDataAccess = new DetalleEvaluacionProveedorDataAccess();
			
			this.detalleevaluacionproveedors= new ArrayList<DetalleEvaluacionProveedor>();
			this.detalleevaluacionproveedor= new DetalleEvaluacionProveedor();
			
			this.detalleevaluacionproveedorObject=new Object();
			this.detalleevaluacionproveedorsObject=new ArrayList<Object>();
				
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
			
			this.detalleevaluacionproveedorDataAccess.setConnexionType(this.connexionType);
			this.detalleevaluacionproveedorDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  DetalleEvaluacionProveedorLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.detalleevaluacionproveedorDataAccess = new DetalleEvaluacionProveedorDataAccess();
			this.detalleevaluacionproveedors= new ArrayList<DetalleEvaluacionProveedor>();
			this.detalleevaluacionproveedor= new DetalleEvaluacionProveedor();
			this.detalleevaluacionproveedorObject=new Object();
			this.detalleevaluacionproveedorsObject=new ArrayList<Object>();
			
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
			
			this.detalleevaluacionproveedorDataAccess.setConnexionType(this.connexionType);
			this.detalleevaluacionproveedorDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public DetalleEvaluacionProveedor getDetalleEvaluacionProveedor() throws Exception {	
		DetalleEvaluacionProveedorLogicAdditional.checkDetalleEvaluacionProveedorToGet(detalleevaluacionproveedor,this.datosCliente,this.arrDatoGeneral);
		DetalleEvaluacionProveedorLogicAdditional.updateDetalleEvaluacionProveedorToGet(detalleevaluacionproveedor,this.arrDatoGeneral);
		
		return detalleevaluacionproveedor;
	}
		
	public void setDetalleEvaluacionProveedor(DetalleEvaluacionProveedor newDetalleEvaluacionProveedor) {
		this.detalleevaluacionproveedor = newDetalleEvaluacionProveedor;
	}
	
	public DetalleEvaluacionProveedorDataAccess getDetalleEvaluacionProveedorDataAccess() {
		return detalleevaluacionproveedorDataAccess;
	}
	
	public void setDetalleEvaluacionProveedorDataAccess(DetalleEvaluacionProveedorDataAccess newdetalleevaluacionproveedorDataAccess) {
		this.detalleevaluacionproveedorDataAccess = newdetalleevaluacionproveedorDataAccess;
	}
	
	public List<DetalleEvaluacionProveedor> getDetalleEvaluacionProveedors() throws Exception {		
		this.quitarDetalleEvaluacionProveedorsNulos();
		
		DetalleEvaluacionProveedorLogicAdditional.checkDetalleEvaluacionProveedorToGets(detalleevaluacionproveedors,this.datosCliente,this.arrDatoGeneral);
		
		for (DetalleEvaluacionProveedor detalleevaluacionproveedorLocal: detalleevaluacionproveedors ) {
			DetalleEvaluacionProveedorLogicAdditional.updateDetalleEvaluacionProveedorToGet(detalleevaluacionproveedorLocal,this.arrDatoGeneral);
		}
		
		return detalleevaluacionproveedors;
	}
	
	public void setDetalleEvaluacionProveedors(List<DetalleEvaluacionProveedor> newDetalleEvaluacionProveedors) {
		this.detalleevaluacionproveedors = newDetalleEvaluacionProveedors;
	}
	
	public Object getDetalleEvaluacionProveedorObject() {	
		this.detalleevaluacionproveedorObject=this.detalleevaluacionproveedorDataAccess.getEntityObject();
		return this.detalleevaluacionproveedorObject;
	}
		
	public void setDetalleEvaluacionProveedorObject(Object newDetalleEvaluacionProveedorObject) {
		this.detalleevaluacionproveedorObject = newDetalleEvaluacionProveedorObject;
	}
	
	public List<Object> getDetalleEvaluacionProveedorsObject() {		
		this.detalleevaluacionproveedorsObject=this.detalleevaluacionproveedorDataAccess.getEntitiesObject();
		return this.detalleevaluacionproveedorsObject;
	}
		
	public void setDetalleEvaluacionProveedorsObject(List<Object> newDetalleEvaluacionProveedorsObject) {
		this.detalleevaluacionproveedorsObject = newDetalleEvaluacionProveedorsObject;
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
		
		if(this.detalleevaluacionproveedorDataAccess!=null) {
			this.detalleevaluacionproveedorDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleEvaluacionProveedor.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			detalleevaluacionproveedorDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			detalleevaluacionproveedorDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		detalleevaluacionproveedor = new  DetalleEvaluacionProveedor();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleEvaluacionProveedor.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			detalleevaluacionproveedor=detalleevaluacionproveedorDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.detalleevaluacionproveedor,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				DetalleEvaluacionProveedorConstantesFunciones.refrescarForeignKeysDescripcionesDetalleEvaluacionProveedor(this.detalleevaluacionproveedor);
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
		detalleevaluacionproveedor = new  DetalleEvaluacionProveedor();
		  		  
        try {
			
			detalleevaluacionproveedor=detalleevaluacionproveedorDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.detalleevaluacionproveedor,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				DetalleEvaluacionProveedorConstantesFunciones.refrescarForeignKeysDescripcionesDetalleEvaluacionProveedor(this.detalleevaluacionproveedor);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		detalleevaluacionproveedor = new  DetalleEvaluacionProveedor();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleEvaluacionProveedor.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			detalleevaluacionproveedor=detalleevaluacionproveedorDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.detalleevaluacionproveedor,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				DetalleEvaluacionProveedorConstantesFunciones.refrescarForeignKeysDescripcionesDetalleEvaluacionProveedor(this.detalleevaluacionproveedor);
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
		detalleevaluacionproveedor = new  DetalleEvaluacionProveedor();
		  		  
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
		detalleevaluacionproveedor = new  DetalleEvaluacionProveedor();
		  		  
        try {
			
			detalleevaluacionproveedor=detalleevaluacionproveedorDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.detalleevaluacionproveedor,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				DetalleEvaluacionProveedorConstantesFunciones.refrescarForeignKeysDescripcionesDetalleEvaluacionProveedor(this.detalleevaluacionproveedor);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		detalleevaluacionproveedor = new  DetalleEvaluacionProveedor();
		  		  
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
		detalleevaluacionproveedor = new  DetalleEvaluacionProveedor();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleEvaluacionProveedor.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =detalleevaluacionproveedorDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		detalleevaluacionproveedor = new  DetalleEvaluacionProveedor();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=detalleevaluacionproveedorDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		detalleevaluacionproveedor = new  DetalleEvaluacionProveedor();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleEvaluacionProveedor.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =detalleevaluacionproveedorDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		detalleevaluacionproveedor = new  DetalleEvaluacionProveedor();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=detalleevaluacionproveedorDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		detalleevaluacionproveedor = new  DetalleEvaluacionProveedor();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleEvaluacionProveedor.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =detalleevaluacionproveedorDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		detalleevaluacionproveedor = new  DetalleEvaluacionProveedor();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=detalleevaluacionproveedorDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		detalleevaluacionproveedors = new  ArrayList<DetalleEvaluacionProveedor>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleEvaluacionProveedor.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			DetalleEvaluacionProveedorLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detalleevaluacionproveedors=detalleevaluacionproveedorDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarDetalleEvaluacionProveedor(detalleevaluacionproveedors);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetalleEvaluacionProveedorConstantesFunciones.refrescarForeignKeysDescripcionesDetalleEvaluacionProveedor(this.detalleevaluacionproveedors);
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
		detalleevaluacionproveedors = new  ArrayList<DetalleEvaluacionProveedor>();
		  		  
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
		detalleevaluacionproveedors = new  ArrayList<DetalleEvaluacionProveedor>();
		  		  
        try {			
			DetalleEvaluacionProveedorLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detalleevaluacionproveedors=detalleevaluacionproveedorDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarDetalleEvaluacionProveedor(detalleevaluacionproveedors);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetalleEvaluacionProveedorConstantesFunciones.refrescarForeignKeysDescripcionesDetalleEvaluacionProveedor(this.detalleevaluacionproveedors);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		detalleevaluacionproveedors = new  ArrayList<DetalleEvaluacionProveedor>();
		  		  
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
		detalleevaluacionproveedors = new  ArrayList<DetalleEvaluacionProveedor>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleEvaluacionProveedor.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			DetalleEvaluacionProveedorLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detalleevaluacionproveedors=detalleevaluacionproveedorDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarDetalleEvaluacionProveedor(detalleevaluacionproveedors);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetalleEvaluacionProveedorConstantesFunciones.refrescarForeignKeysDescripcionesDetalleEvaluacionProveedor(this.detalleevaluacionproveedors);
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
		detalleevaluacionproveedors = new  ArrayList<DetalleEvaluacionProveedor>();
		  		  
        try {
			DetalleEvaluacionProveedorLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detalleevaluacionproveedors=detalleevaluacionproveedorDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarDetalleEvaluacionProveedor(detalleevaluacionproveedors);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetalleEvaluacionProveedorConstantesFunciones.refrescarForeignKeysDescripcionesDetalleEvaluacionProveedor(this.detalleevaluacionproveedors);
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
		detalleevaluacionproveedors = new  ArrayList<DetalleEvaluacionProveedor>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleEvaluacionProveedor.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			DetalleEvaluacionProveedorLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detalleevaluacionproveedors=detalleevaluacionproveedorDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarDetalleEvaluacionProveedor(detalleevaluacionproveedors);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetalleEvaluacionProveedorConstantesFunciones.refrescarForeignKeysDescripcionesDetalleEvaluacionProveedor(this.detalleevaluacionproveedors);
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
		detalleevaluacionproveedors = new  ArrayList<DetalleEvaluacionProveedor>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			DetalleEvaluacionProveedorLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detalleevaluacionproveedors=detalleevaluacionproveedorDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarDetalleEvaluacionProveedor(detalleevaluacionproveedors);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetalleEvaluacionProveedorConstantesFunciones.refrescarForeignKeysDescripcionesDetalleEvaluacionProveedor(this.detalleevaluacionproveedors);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		detalleevaluacionproveedor = new  DetalleEvaluacionProveedor();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleEvaluacionProveedor.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			DetalleEvaluacionProveedorLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detalleevaluacionproveedor=detalleevaluacionproveedorDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarDetalleEvaluacionProveedor(detalleevaluacionproveedor);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetalleEvaluacionProveedorConstantesFunciones.refrescarForeignKeysDescripcionesDetalleEvaluacionProveedor(this.detalleevaluacionproveedor);
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
		detalleevaluacionproveedor = new  DetalleEvaluacionProveedor();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			DetalleEvaluacionProveedorLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detalleevaluacionproveedor=detalleevaluacionproveedorDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarDetalleEvaluacionProveedor(detalleevaluacionproveedor);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetalleEvaluacionProveedorConstantesFunciones.refrescarForeignKeysDescripcionesDetalleEvaluacionProveedor(this.detalleevaluacionproveedor);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		detalleevaluacionproveedors = new  ArrayList<DetalleEvaluacionProveedor>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleEvaluacionProveedor.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			DetalleEvaluacionProveedorLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detalleevaluacionproveedors=detalleevaluacionproveedorDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarDetalleEvaluacionProveedor(detalleevaluacionproveedors);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetalleEvaluacionProveedorConstantesFunciones.refrescarForeignKeysDescripcionesDetalleEvaluacionProveedor(this.detalleevaluacionproveedors);
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
		detalleevaluacionproveedors = new  ArrayList<DetalleEvaluacionProveedor>();
		  		  
        try {
			DetalleEvaluacionProveedorLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detalleevaluacionproveedors=detalleevaluacionproveedorDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarDetalleEvaluacionProveedor(detalleevaluacionproveedors);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetalleEvaluacionProveedorConstantesFunciones.refrescarForeignKeysDescripcionesDetalleEvaluacionProveedor(this.detalleevaluacionproveedors);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosDetalleEvaluacionProveedorsWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		detalleevaluacionproveedors = new  ArrayList<DetalleEvaluacionProveedor>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleEvaluacionProveedor.class.getSimpleName()+"-getTodosDetalleEvaluacionProveedorsWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			DetalleEvaluacionProveedorLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detalleevaluacionproveedors=detalleevaluacionproveedorDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarDetalleEvaluacionProveedor(detalleevaluacionproveedors);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetalleEvaluacionProveedorConstantesFunciones.refrescarForeignKeysDescripcionesDetalleEvaluacionProveedor(this.detalleevaluacionproveedors);
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
	
	public  void  getTodosDetalleEvaluacionProveedors(String sFinalQuery,Pagination pagination)throws Exception {
		detalleevaluacionproveedors = new  ArrayList<DetalleEvaluacionProveedor>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			DetalleEvaluacionProveedorLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detalleevaluacionproveedors=detalleevaluacionproveedorDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarDetalleEvaluacionProveedor(detalleevaluacionproveedors);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetalleEvaluacionProveedorConstantesFunciones.refrescarForeignKeysDescripcionesDetalleEvaluacionProveedor(this.detalleevaluacionproveedors);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarDetalleEvaluacionProveedor(DetalleEvaluacionProveedor detalleevaluacionproveedor) throws Exception {
		Boolean estaValidado=false;
		
		if(detalleevaluacionproveedor.getIsNew() || detalleevaluacionproveedor.getIsChanged()) { 
			this.invalidValues = detalleevaluacionproveedorValidator.getInvalidValues(detalleevaluacionproveedor);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(detalleevaluacionproveedor);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarDetalleEvaluacionProveedor(List<DetalleEvaluacionProveedor> DetalleEvaluacionProveedors) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(DetalleEvaluacionProveedor detalleevaluacionproveedorLocal:detalleevaluacionproveedors) {				
			estaValidadoObjeto=this.validarGuardarDetalleEvaluacionProveedor(detalleevaluacionproveedorLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarDetalleEvaluacionProveedor(List<DetalleEvaluacionProveedor> DetalleEvaluacionProveedors) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarDetalleEvaluacionProveedor(detalleevaluacionproveedors)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarDetalleEvaluacionProveedor(DetalleEvaluacionProveedor DetalleEvaluacionProveedor) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarDetalleEvaluacionProveedor(detalleevaluacionproveedor)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(DetalleEvaluacionProveedor detalleevaluacionproveedor) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+detalleevaluacionproveedor.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=DetalleEvaluacionProveedorConstantesFunciones.getDetalleEvaluacionProveedorLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"detalleevaluacionproveedor","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(DetalleEvaluacionProveedorConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(DetalleEvaluacionProveedorConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveDetalleEvaluacionProveedorWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleEvaluacionProveedor.class.getSimpleName()+"-saveDetalleEvaluacionProveedorWithConnection");connexion.begin();			
			
			DetalleEvaluacionProveedorLogicAdditional.checkDetalleEvaluacionProveedorToSave(this.detalleevaluacionproveedor,this.datosCliente,connexion,this.arrDatoGeneral);
			
			DetalleEvaluacionProveedorLogicAdditional.updateDetalleEvaluacionProveedorToSave(this.detalleevaluacionproveedor,this.arrDatoGeneral);
			
			DetalleEvaluacionProveedorLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.detalleevaluacionproveedor,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowDetalleEvaluacionProveedor();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarDetalleEvaluacionProveedor(this.detalleevaluacionproveedor)) {
				DetalleEvaluacionProveedorDataAccess.save(this.detalleevaluacionproveedor, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.detalleevaluacionproveedor,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			DetalleEvaluacionProveedorLogicAdditional.checkDetalleEvaluacionProveedorToSaveAfter(this.detalleevaluacionproveedor,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowDetalleEvaluacionProveedor();
			
			connexion.commit();			
			
			if(this.detalleevaluacionproveedor.getIsDeleted()) {
				this.detalleevaluacionproveedor=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveDetalleEvaluacionProveedor()throws Exception {	
		try {	
			
			DetalleEvaluacionProveedorLogicAdditional.checkDetalleEvaluacionProveedorToSave(this.detalleevaluacionproveedor,this.datosCliente,connexion,this.arrDatoGeneral);
			
			DetalleEvaluacionProveedorLogicAdditional.updateDetalleEvaluacionProveedorToSave(this.detalleevaluacionproveedor,this.arrDatoGeneral);
			
			DetalleEvaluacionProveedorLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.detalleevaluacionproveedor,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarDetalleEvaluacionProveedor(this.detalleevaluacionproveedor)) {			
				DetalleEvaluacionProveedorDataAccess.save(this.detalleevaluacionproveedor, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.detalleevaluacionproveedor,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			DetalleEvaluacionProveedorLogicAdditional.checkDetalleEvaluacionProveedorToSaveAfter(this.detalleevaluacionproveedor,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.detalleevaluacionproveedor.getIsDeleted()) {
				this.detalleevaluacionproveedor=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveDetalleEvaluacionProveedorsWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleEvaluacionProveedor.class.getSimpleName()+"-saveDetalleEvaluacionProveedorsWithConnection");connexion.begin();			
			
			DetalleEvaluacionProveedorLogicAdditional.checkDetalleEvaluacionProveedorToSaves(detalleevaluacionproveedors,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowDetalleEvaluacionProveedors();
			
			Boolean validadoTodosDetalleEvaluacionProveedor=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(DetalleEvaluacionProveedor detalleevaluacionproveedorLocal:detalleevaluacionproveedors) {		
				if(detalleevaluacionproveedorLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				DetalleEvaluacionProveedorLogicAdditional.updateDetalleEvaluacionProveedorToSave(detalleevaluacionproveedorLocal,this.arrDatoGeneral);
	        	
				DetalleEvaluacionProveedorLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),detalleevaluacionproveedorLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarDetalleEvaluacionProveedor(detalleevaluacionproveedorLocal)) {
					DetalleEvaluacionProveedorDataAccess.save(detalleevaluacionproveedorLocal, connexion);				
				} else {
					validadoTodosDetalleEvaluacionProveedor=false;
				}
			}
			
			if(!validadoTodosDetalleEvaluacionProveedor) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			DetalleEvaluacionProveedorLogicAdditional.checkDetalleEvaluacionProveedorToSavesAfter(detalleevaluacionproveedors,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowDetalleEvaluacionProveedors();
			
			connexion.commit();		
			
			this.quitarDetalleEvaluacionProveedorsEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveDetalleEvaluacionProveedors()throws Exception {				
		 try {	
			DetalleEvaluacionProveedorLogicAdditional.checkDetalleEvaluacionProveedorToSaves(detalleevaluacionproveedors,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosDetalleEvaluacionProveedor=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(DetalleEvaluacionProveedor detalleevaluacionproveedorLocal:detalleevaluacionproveedors) {				
				if(detalleevaluacionproveedorLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				DetalleEvaluacionProveedorLogicAdditional.updateDetalleEvaluacionProveedorToSave(detalleevaluacionproveedorLocal,this.arrDatoGeneral);
	        	
				DetalleEvaluacionProveedorLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),detalleevaluacionproveedorLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarDetalleEvaluacionProveedor(detalleevaluacionproveedorLocal)) {				
					DetalleEvaluacionProveedorDataAccess.save(detalleevaluacionproveedorLocal, connexion);				
				} else {
					validadoTodosDetalleEvaluacionProveedor=false;
				}
			}
			
			if(!validadoTodosDetalleEvaluacionProveedor) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			DetalleEvaluacionProveedorLogicAdditional.checkDetalleEvaluacionProveedorToSavesAfter(detalleevaluacionproveedors,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarDetalleEvaluacionProveedorsEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public DetalleEvaluacionProveedorParameterReturnGeneral procesarAccionDetalleEvaluacionProveedors(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<DetalleEvaluacionProveedor> detalleevaluacionproveedors,DetalleEvaluacionProveedorParameterReturnGeneral detalleevaluacionproveedorParameterGeneral)throws Exception {
		 try {	
			DetalleEvaluacionProveedorParameterReturnGeneral detalleevaluacionproveedorReturnGeneral=new DetalleEvaluacionProveedorParameterReturnGeneral();
	
			DetalleEvaluacionProveedorLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,detalleevaluacionproveedors,detalleevaluacionproveedorParameterGeneral,detalleevaluacionproveedorReturnGeneral);
			
			return detalleevaluacionproveedorReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public DetalleEvaluacionProveedorParameterReturnGeneral procesarAccionDetalleEvaluacionProveedorsWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<DetalleEvaluacionProveedor> detalleevaluacionproveedors,DetalleEvaluacionProveedorParameterReturnGeneral detalleevaluacionproveedorParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleEvaluacionProveedor.class.getSimpleName()+"-procesarAccionDetalleEvaluacionProveedorsWithConnection");connexion.begin();			
			
			DetalleEvaluacionProveedorParameterReturnGeneral detalleevaluacionproveedorReturnGeneral=new DetalleEvaluacionProveedorParameterReturnGeneral();
	
			DetalleEvaluacionProveedorLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,detalleevaluacionproveedors,detalleevaluacionproveedorParameterGeneral,detalleevaluacionproveedorReturnGeneral);
			
			this.connexion.commit();
			
			return detalleevaluacionproveedorReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public DetalleEvaluacionProveedorParameterReturnGeneral procesarEventosDetalleEvaluacionProveedors(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<DetalleEvaluacionProveedor> detalleevaluacionproveedors,DetalleEvaluacionProveedor detalleevaluacionproveedor,DetalleEvaluacionProveedorParameterReturnGeneral detalleevaluacionproveedorParameterGeneral,Boolean isEsNuevoDetalleEvaluacionProveedor,ArrayList<Classe> clases)throws Exception {
		 try {	
			DetalleEvaluacionProveedorParameterReturnGeneral detalleevaluacionproveedorReturnGeneral=new DetalleEvaluacionProveedorParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				detalleevaluacionproveedorReturnGeneral.setConRecargarPropiedades(true);
			}
			
			DetalleEvaluacionProveedorLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,detalleevaluacionproveedors,detalleevaluacionproveedor,detalleevaluacionproveedorParameterGeneral,detalleevaluacionproveedorReturnGeneral,isEsNuevoDetalleEvaluacionProveedor,clases);
			
			return detalleevaluacionproveedorReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public DetalleEvaluacionProveedorParameterReturnGeneral procesarEventosDetalleEvaluacionProveedorsWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<DetalleEvaluacionProveedor> detalleevaluacionproveedors,DetalleEvaluacionProveedor detalleevaluacionproveedor,DetalleEvaluacionProveedorParameterReturnGeneral detalleevaluacionproveedorParameterGeneral,Boolean isEsNuevoDetalleEvaluacionProveedor,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleEvaluacionProveedor.class.getSimpleName()+"-procesarEventosDetalleEvaluacionProveedorsWithConnection");connexion.begin();			
			
			DetalleEvaluacionProveedorParameterReturnGeneral detalleevaluacionproveedorReturnGeneral=new DetalleEvaluacionProveedorParameterReturnGeneral();
	
			detalleevaluacionproveedorReturnGeneral.setDetalleEvaluacionProveedor(detalleevaluacionproveedor);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				detalleevaluacionproveedorReturnGeneral.setConRecargarPropiedades(true);
			}
			
			DetalleEvaluacionProveedorLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,detalleevaluacionproveedors,detalleevaluacionproveedor,detalleevaluacionproveedorParameterGeneral,detalleevaluacionproveedorReturnGeneral,isEsNuevoDetalleEvaluacionProveedor,clases);
			
			this.connexion.commit();
			
			return detalleevaluacionproveedorReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public DetalleEvaluacionProveedorParameterReturnGeneral procesarImportacionDetalleEvaluacionProveedorsWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,DetalleEvaluacionProveedorParameterReturnGeneral detalleevaluacionproveedorParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleEvaluacionProveedor.class.getSimpleName()+"-procesarImportacionDetalleEvaluacionProveedorsWithConnection");connexion.begin();			
			
			DetalleEvaluacionProveedorParameterReturnGeneral detalleevaluacionproveedorReturnGeneral=new DetalleEvaluacionProveedorParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.detalleevaluacionproveedors=new ArrayList<DetalleEvaluacionProveedor>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.detalleevaluacionproveedor=new DetalleEvaluacionProveedor();
				
				
				if(conColumnasBase) {this.detalleevaluacionproveedor.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.detalleevaluacionproveedor.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.detalleevaluacionproveedor.setdescripcion(arrColumnas[iColumn++]);
				
				this.detalleevaluacionproveedors.add(this.detalleevaluacionproveedor);
			}
			
			this.saveDetalleEvaluacionProveedors();
			
			this.connexion.commit();
			
			detalleevaluacionproveedorReturnGeneral.setConRetornoEstaProcesado(true);
			detalleevaluacionproveedorReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return detalleevaluacionproveedorReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarDetalleEvaluacionProveedorsEliminados() throws Exception {				
		
		List<DetalleEvaluacionProveedor> detalleevaluacionproveedorsAux= new ArrayList<DetalleEvaluacionProveedor>();
		
		for(DetalleEvaluacionProveedor detalleevaluacionproveedor:detalleevaluacionproveedors) {
			if(!detalleevaluacionproveedor.getIsDeleted()) {
				detalleevaluacionproveedorsAux.add(detalleevaluacionproveedor);
			}
		}
		
		detalleevaluacionproveedors=detalleevaluacionproveedorsAux;
	}
	
	public void quitarDetalleEvaluacionProveedorsNulos() throws Exception {				
		
		List<DetalleEvaluacionProveedor> detalleevaluacionproveedorsAux= new ArrayList<DetalleEvaluacionProveedor>();
		
		for(DetalleEvaluacionProveedor detalleevaluacionproveedor : this.detalleevaluacionproveedors) {
			if(detalleevaluacionproveedor==null) {
				detalleevaluacionproveedorsAux.add(detalleevaluacionproveedor);
			}
		}
		
		//this.detalleevaluacionproveedors=detalleevaluacionproveedorsAux;
		
		this.detalleevaluacionproveedors.removeAll(detalleevaluacionproveedorsAux);
	}
	
	public void getSetVersionRowDetalleEvaluacionProveedorWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(detalleevaluacionproveedor.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((detalleevaluacionproveedor.getIsDeleted() || (detalleevaluacionproveedor.getIsChanged()&&!detalleevaluacionproveedor.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=detalleevaluacionproveedorDataAccess.getSetVersionRowDetalleEvaluacionProveedor(connexion,detalleevaluacionproveedor.getId());
				
				if(!detalleevaluacionproveedor.getVersionRow().equals(timestamp)) {	
					detalleevaluacionproveedor.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				detalleevaluacionproveedor.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowDetalleEvaluacionProveedor()throws Exception {	
		
		if(detalleevaluacionproveedor.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((detalleevaluacionproveedor.getIsDeleted() || (detalleevaluacionproveedor.getIsChanged()&&!detalleevaluacionproveedor.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=detalleevaluacionproveedorDataAccess.getSetVersionRowDetalleEvaluacionProveedor(connexion,detalleevaluacionproveedor.getId());
			
			try {							
				if(!detalleevaluacionproveedor.getVersionRow().equals(timestamp)) {	
					detalleevaluacionproveedor.setVersionRow(timestamp);
				}
				
				detalleevaluacionproveedor.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowDetalleEvaluacionProveedorsWithConnection()throws Exception {	
		if(detalleevaluacionproveedors!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(DetalleEvaluacionProveedor detalleevaluacionproveedorAux:detalleevaluacionproveedors) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(detalleevaluacionproveedorAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(detalleevaluacionproveedorAux.getIsDeleted() || (detalleevaluacionproveedorAux.getIsChanged()&&!detalleevaluacionproveedorAux.getIsNew())) {
						
						timestamp=detalleevaluacionproveedorDataAccess.getSetVersionRowDetalleEvaluacionProveedor(connexion,detalleevaluacionproveedorAux.getId());
						
						if(!detalleevaluacionproveedor.getVersionRow().equals(timestamp)) {	
							detalleevaluacionproveedorAux.setVersionRow(timestamp);
						}
								
						detalleevaluacionproveedorAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowDetalleEvaluacionProveedors()throws Exception {	
		if(detalleevaluacionproveedors!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(DetalleEvaluacionProveedor detalleevaluacionproveedorAux:detalleevaluacionproveedors) {
					if(detalleevaluacionproveedorAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(detalleevaluacionproveedorAux.getIsDeleted() || (detalleevaluacionproveedorAux.getIsChanged()&&!detalleevaluacionproveedorAux.getIsNew())) {
						
						timestamp=detalleevaluacionproveedorDataAccess.getSetVersionRowDetalleEvaluacionProveedor(connexion,detalleevaluacionproveedorAux.getId());
						
						if(!detalleevaluacionproveedorAux.getVersionRow().equals(timestamp)) {	
							detalleevaluacionproveedorAux.setVersionRow(timestamp);
						}
						
													
						detalleevaluacionproveedorAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public DetalleEvaluacionProveedorParameterReturnGeneral cargarCombosLoteForeignKeyDetalleEvaluacionProveedorWithConnection(String finalQueryGlobalEmpresa,String finalQueryGlobalSucursal,String finalQueryGlobalEjercicio,String finalQueryGlobalPeriodo,String finalQueryGlobalEvaluacionProveedor,String finalQueryGlobalPreguntaEvaluacion,String finalQueryGlobalSubPreguntaEvaluacion,String finalQueryGlobalSiNo) throws Exception {
		DetalleEvaluacionProveedorParameterReturnGeneral  detalleevaluacionproveedorReturnGeneral =new DetalleEvaluacionProveedorParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleEvaluacionProveedor.class.getSimpleName()+"-cargarCombosLoteForeignKeyDetalleEvaluacionProveedorWithConnection");connexion.begin();
			
			detalleevaluacionproveedorReturnGeneral =new DetalleEvaluacionProveedorParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			detalleevaluacionproveedorReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Sucursal> sucursalsForeignKey=new ArrayList<Sucursal>();
			SucursalLogic sucursalLogic=new SucursalLogic();
			sucursalLogic.setConnexion(this.connexion);
			//sucursalLogic.getSucursalDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalSucursal.equals("NONE")) {
				sucursalLogic.getTodosSucursals(finalQueryGlobalSucursal,new Pagination());
				sucursalsForeignKey=sucursalLogic.getSucursals();
			}

			detalleevaluacionproveedorReturnGeneral.setsucursalsForeignKey(sucursalsForeignKey);


			List<Ejercicio> ejerciciosForeignKey=new ArrayList<Ejercicio>();
			EjercicioLogic ejercicioLogic=new EjercicioLogic();
			ejercicioLogic.setConnexion(this.connexion);
			//ejercicioLogic.getEjercicioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEjercicio.equals("NONE")) {
				ejercicioLogic.getTodosEjercicios(finalQueryGlobalEjercicio,new Pagination());
				ejerciciosForeignKey=ejercicioLogic.getEjercicios();
			}

			detalleevaluacionproveedorReturnGeneral.setejerciciosForeignKey(ejerciciosForeignKey);


			List<Periodo> periodosForeignKey=new ArrayList<Periodo>();
			PeriodoLogic periodoLogic=new PeriodoLogic();
			periodoLogic.setConnexion(this.connexion);
			//periodoLogic.getPeriodoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalPeriodo.equals("NONE")) {
				periodoLogic.getTodosPeriodos(finalQueryGlobalPeriodo,new Pagination());
				periodosForeignKey=periodoLogic.getPeriodos();
			}

			detalleevaluacionproveedorReturnGeneral.setperiodosForeignKey(periodosForeignKey);


			List<EvaluacionProveedor> evaluacionproveedorsForeignKey=new ArrayList<EvaluacionProveedor>();
			EvaluacionProveedorLogic evaluacionproveedorLogic=new EvaluacionProveedorLogic();
			evaluacionproveedorLogic.setConnexion(this.connexion);
			evaluacionproveedorLogic.getEvaluacionProveedorDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEvaluacionProveedor.equals("NONE")) {
				evaluacionproveedorLogic.getTodosEvaluacionProveedors(finalQueryGlobalEvaluacionProveedor,new Pagination());
				evaluacionproveedorsForeignKey=evaluacionproveedorLogic.getEvaluacionProveedors();
			}

			detalleevaluacionproveedorReturnGeneral.setevaluacionproveedorsForeignKey(evaluacionproveedorsForeignKey);


			List<PreguntaEvaluacion> preguntaevaluacionsForeignKey=new ArrayList<PreguntaEvaluacion>();
			PreguntaEvaluacionLogic preguntaevaluacionLogic=new PreguntaEvaluacionLogic();
			preguntaevaluacionLogic.setConnexion(this.connexion);
			preguntaevaluacionLogic.getPreguntaEvaluacionDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalPreguntaEvaluacion.equals("NONE")) {
				preguntaevaluacionLogic.getTodosPreguntaEvaluacions(finalQueryGlobalPreguntaEvaluacion,new Pagination());
				preguntaevaluacionsForeignKey=preguntaevaluacionLogic.getPreguntaEvaluacions();
			}

			detalleevaluacionproveedorReturnGeneral.setpreguntaevaluacionsForeignKey(preguntaevaluacionsForeignKey);


			List<SubPreguntaEvaluacion> subpreguntaevaluacionsForeignKey=new ArrayList<SubPreguntaEvaluacion>();
			SubPreguntaEvaluacionLogic subpreguntaevaluacionLogic=new SubPreguntaEvaluacionLogic();
			subpreguntaevaluacionLogic.setConnexion(this.connexion);
			subpreguntaevaluacionLogic.getSubPreguntaEvaluacionDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalSubPreguntaEvaluacion.equals("NONE")) {
				subpreguntaevaluacionLogic.getTodosSubPreguntaEvaluacions(finalQueryGlobalSubPreguntaEvaluacion,new Pagination());
				subpreguntaevaluacionsForeignKey=subpreguntaevaluacionLogic.getSubPreguntaEvaluacions();
			}

			detalleevaluacionproveedorReturnGeneral.setsubpreguntaevaluacionsForeignKey(subpreguntaevaluacionsForeignKey);


			List<SiNo> sinosForeignKey=new ArrayList<SiNo>();
			SiNoLogic sinoLogic=new SiNoLogic();
			sinoLogic.setConnexion(this.connexion);
			sinoLogic.getSiNoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalSiNo.equals("NONE")) {
				sinoLogic.getTodosSiNos(finalQueryGlobalSiNo,new Pagination());
				sinosForeignKey=sinoLogic.getSiNos();
			}

			detalleevaluacionproveedorReturnGeneral.setsinosForeignKey(sinosForeignKey);

			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
		
		return detalleevaluacionproveedorReturnGeneral;
	}
	
	public DetalleEvaluacionProveedorParameterReturnGeneral cargarCombosLoteForeignKeyDetalleEvaluacionProveedor(String finalQueryGlobalEmpresa,String finalQueryGlobalSucursal,String finalQueryGlobalEjercicio,String finalQueryGlobalPeriodo,String finalQueryGlobalEvaluacionProveedor,String finalQueryGlobalPreguntaEvaluacion,String finalQueryGlobalSubPreguntaEvaluacion,String finalQueryGlobalSiNo) throws Exception {
		DetalleEvaluacionProveedorParameterReturnGeneral  detalleevaluacionproveedorReturnGeneral =new DetalleEvaluacionProveedorParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {						
			detalleevaluacionproveedorReturnGeneral =new DetalleEvaluacionProveedorParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			detalleevaluacionproveedorReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Sucursal> sucursalsForeignKey=new ArrayList<Sucursal>();
			SucursalLogic sucursalLogic=new SucursalLogic();
			sucursalLogic.setConnexion(this.connexion);
			//sucursalLogic.getSucursalDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalSucursal.equals("NONE")) {
				sucursalLogic.getTodosSucursals(finalQueryGlobalSucursal,new Pagination());
				sucursalsForeignKey=sucursalLogic.getSucursals();
			}

			detalleevaluacionproveedorReturnGeneral.setsucursalsForeignKey(sucursalsForeignKey);


			List<Ejercicio> ejerciciosForeignKey=new ArrayList<Ejercicio>();
			EjercicioLogic ejercicioLogic=new EjercicioLogic();
			ejercicioLogic.setConnexion(this.connexion);
			//ejercicioLogic.getEjercicioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEjercicio.equals("NONE")) {
				ejercicioLogic.getTodosEjercicios(finalQueryGlobalEjercicio,new Pagination());
				ejerciciosForeignKey=ejercicioLogic.getEjercicios();
			}

			detalleevaluacionproveedorReturnGeneral.setejerciciosForeignKey(ejerciciosForeignKey);


			List<Periodo> periodosForeignKey=new ArrayList<Periodo>();
			PeriodoLogic periodoLogic=new PeriodoLogic();
			periodoLogic.setConnexion(this.connexion);
			//periodoLogic.getPeriodoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalPeriodo.equals("NONE")) {
				periodoLogic.getTodosPeriodos(finalQueryGlobalPeriodo,new Pagination());
				periodosForeignKey=periodoLogic.getPeriodos();
			}

			detalleevaluacionproveedorReturnGeneral.setperiodosForeignKey(periodosForeignKey);


			List<EvaluacionProveedor> evaluacionproveedorsForeignKey=new ArrayList<EvaluacionProveedor>();
			EvaluacionProveedorLogic evaluacionproveedorLogic=new EvaluacionProveedorLogic();
			evaluacionproveedorLogic.setConnexion(this.connexion);
			evaluacionproveedorLogic.getEvaluacionProveedorDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEvaluacionProveedor.equals("NONE")) {
				evaluacionproveedorLogic.getTodosEvaluacionProveedors(finalQueryGlobalEvaluacionProveedor,new Pagination());
				evaluacionproveedorsForeignKey=evaluacionproveedorLogic.getEvaluacionProveedors();
			}

			detalleevaluacionproveedorReturnGeneral.setevaluacionproveedorsForeignKey(evaluacionproveedorsForeignKey);


			List<PreguntaEvaluacion> preguntaevaluacionsForeignKey=new ArrayList<PreguntaEvaluacion>();
			PreguntaEvaluacionLogic preguntaevaluacionLogic=new PreguntaEvaluacionLogic();
			preguntaevaluacionLogic.setConnexion(this.connexion);
			preguntaevaluacionLogic.getPreguntaEvaluacionDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalPreguntaEvaluacion.equals("NONE")) {
				preguntaevaluacionLogic.getTodosPreguntaEvaluacions(finalQueryGlobalPreguntaEvaluacion,new Pagination());
				preguntaevaluacionsForeignKey=preguntaevaluacionLogic.getPreguntaEvaluacions();
			}

			detalleevaluacionproveedorReturnGeneral.setpreguntaevaluacionsForeignKey(preguntaevaluacionsForeignKey);


			List<SubPreguntaEvaluacion> subpreguntaevaluacionsForeignKey=new ArrayList<SubPreguntaEvaluacion>();
			SubPreguntaEvaluacionLogic subpreguntaevaluacionLogic=new SubPreguntaEvaluacionLogic();
			subpreguntaevaluacionLogic.setConnexion(this.connexion);
			subpreguntaevaluacionLogic.getSubPreguntaEvaluacionDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalSubPreguntaEvaluacion.equals("NONE")) {
				subpreguntaevaluacionLogic.getTodosSubPreguntaEvaluacions(finalQueryGlobalSubPreguntaEvaluacion,new Pagination());
				subpreguntaevaluacionsForeignKey=subpreguntaevaluacionLogic.getSubPreguntaEvaluacions();
			}

			detalleevaluacionproveedorReturnGeneral.setsubpreguntaevaluacionsForeignKey(subpreguntaevaluacionsForeignKey);


			List<SiNo> sinosForeignKey=new ArrayList<SiNo>();
			SiNoLogic sinoLogic=new SiNoLogic();
			sinoLogic.setConnexion(this.connexion);
			sinoLogic.getSiNoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalSiNo.equals("NONE")) {
				sinoLogic.getTodosSiNos(finalQueryGlobalSiNo,new Pagination());
				sinosForeignKey=sinoLogic.getSiNos();
			}

			detalleevaluacionproveedorReturnGeneral.setsinosForeignKey(sinosForeignKey);
						
			
		} catch(Exception e) {			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			
		}
		
		return detalleevaluacionproveedorReturnGeneral;
	}
	
	
	public void deepLoad(DetalleEvaluacionProveedor detalleevaluacionproveedor,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			DetalleEvaluacionProveedorLogicAdditional.updateDetalleEvaluacionProveedorToGet(detalleevaluacionproveedor,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		detalleevaluacionproveedor.setEmpresa(detalleevaluacionproveedorDataAccess.getEmpresa(connexion,detalleevaluacionproveedor));
		detalleevaluacionproveedor.setSucursal(detalleevaluacionproveedorDataAccess.getSucursal(connexion,detalleevaluacionproveedor));
		detalleevaluacionproveedor.setEjercicio(detalleevaluacionproveedorDataAccess.getEjercicio(connexion,detalleevaluacionproveedor));
		detalleevaluacionproveedor.setPeriodo(detalleevaluacionproveedorDataAccess.getPeriodo(connexion,detalleevaluacionproveedor));
		detalleevaluacionproveedor.setEvaluacionProveedor(detalleevaluacionproveedorDataAccess.getEvaluacionProveedor(connexion,detalleevaluacionproveedor));
		detalleevaluacionproveedor.setPreguntaEvaluacion(detalleevaluacionproveedorDataAccess.getPreguntaEvaluacion(connexion,detalleevaluacionproveedor));
		detalleevaluacionproveedor.setSubPreguntaEvaluacion(detalleevaluacionproveedorDataAccess.getSubPreguntaEvaluacion(connexion,detalleevaluacionproveedor));
		detalleevaluacionproveedor.setSiNo(detalleevaluacionproveedorDataAccess.getSiNo(connexion,detalleevaluacionproveedor));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				detalleevaluacionproveedor.setEmpresa(detalleevaluacionproveedorDataAccess.getEmpresa(connexion,detalleevaluacionproveedor));
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				detalleevaluacionproveedor.setSucursal(detalleevaluacionproveedorDataAccess.getSucursal(connexion,detalleevaluacionproveedor));
				continue;
			}

			if(clas.clas.equals(Ejercicio.class)) {
				detalleevaluacionproveedor.setEjercicio(detalleevaluacionproveedorDataAccess.getEjercicio(connexion,detalleevaluacionproveedor));
				continue;
			}

			if(clas.clas.equals(Periodo.class)) {
				detalleevaluacionproveedor.setPeriodo(detalleevaluacionproveedorDataAccess.getPeriodo(connexion,detalleevaluacionproveedor));
				continue;
			}

			if(clas.clas.equals(EvaluacionProveedor.class)) {
				detalleevaluacionproveedor.setEvaluacionProveedor(detalleevaluacionproveedorDataAccess.getEvaluacionProveedor(connexion,detalleevaluacionproveedor));
				continue;
			}

			if(clas.clas.equals(PreguntaEvaluacion.class)) {
				detalleevaluacionproveedor.setPreguntaEvaluacion(detalleevaluacionproveedorDataAccess.getPreguntaEvaluacion(connexion,detalleevaluacionproveedor));
				continue;
			}

			if(clas.clas.equals(SubPreguntaEvaluacion.class)) {
				detalleevaluacionproveedor.setSubPreguntaEvaluacion(detalleevaluacionproveedorDataAccess.getSubPreguntaEvaluacion(connexion,detalleevaluacionproveedor));
				continue;
			}

			if(clas.clas.equals(SiNo.class)) {
				detalleevaluacionproveedor.setSiNo(detalleevaluacionproveedorDataAccess.getSiNo(connexion,detalleevaluacionproveedor));
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
			detalleevaluacionproveedor.setEmpresa(detalleevaluacionproveedorDataAccess.getEmpresa(connexion,detalleevaluacionproveedor));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detalleevaluacionproveedor.setSucursal(detalleevaluacionproveedorDataAccess.getSucursal(connexion,detalleevaluacionproveedor));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Ejercicio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detalleevaluacionproveedor.setEjercicio(detalleevaluacionproveedorDataAccess.getEjercicio(connexion,detalleevaluacionproveedor));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Periodo.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detalleevaluacionproveedor.setPeriodo(detalleevaluacionproveedorDataAccess.getPeriodo(connexion,detalleevaluacionproveedor));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(EvaluacionProveedor.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detalleevaluacionproveedor.setEvaluacionProveedor(detalleevaluacionproveedorDataAccess.getEvaluacionProveedor(connexion,detalleevaluacionproveedor));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(PreguntaEvaluacion.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detalleevaluacionproveedor.setPreguntaEvaluacion(detalleevaluacionproveedorDataAccess.getPreguntaEvaluacion(connexion,detalleevaluacionproveedor));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(SubPreguntaEvaluacion.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detalleevaluacionproveedor.setSubPreguntaEvaluacion(detalleevaluacionproveedorDataAccess.getSubPreguntaEvaluacion(connexion,detalleevaluacionproveedor));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(SiNo.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detalleevaluacionproveedor.setSiNo(detalleevaluacionproveedorDataAccess.getSiNo(connexion,detalleevaluacionproveedor));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		detalleevaluacionproveedor.setEmpresa(detalleevaluacionproveedorDataAccess.getEmpresa(connexion,detalleevaluacionproveedor));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(detalleevaluacionproveedor.getEmpresa(),isDeep,deepLoadType,clases);
				
		detalleevaluacionproveedor.setSucursal(detalleevaluacionproveedorDataAccess.getSucursal(connexion,detalleevaluacionproveedor));
		SucursalLogic sucursalLogic= new SucursalLogic(connexion);
		sucursalLogic.deepLoad(detalleevaluacionproveedor.getSucursal(),isDeep,deepLoadType,clases);
				
		detalleevaluacionproveedor.setEjercicio(detalleevaluacionproveedorDataAccess.getEjercicio(connexion,detalleevaluacionproveedor));
		EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
		ejercicioLogic.deepLoad(detalleevaluacionproveedor.getEjercicio(),isDeep,deepLoadType,clases);
				
		detalleevaluacionproveedor.setPeriodo(detalleevaluacionproveedorDataAccess.getPeriodo(connexion,detalleevaluacionproveedor));
		PeriodoLogic periodoLogic= new PeriodoLogic(connexion);
		periodoLogic.deepLoad(detalleevaluacionproveedor.getPeriodo(),isDeep,deepLoadType,clases);
				
		detalleevaluacionproveedor.setEvaluacionProveedor(detalleevaluacionproveedorDataAccess.getEvaluacionProveedor(connexion,detalleevaluacionproveedor));
		EvaluacionProveedorLogic evaluacionproveedorLogic= new EvaluacionProveedorLogic(connexion);
		evaluacionproveedorLogic.deepLoad(detalleevaluacionproveedor.getEvaluacionProveedor(),isDeep,deepLoadType,clases);
				
		detalleevaluacionproveedor.setPreguntaEvaluacion(detalleevaluacionproveedorDataAccess.getPreguntaEvaluacion(connexion,detalleevaluacionproveedor));
		PreguntaEvaluacionLogic preguntaevaluacionLogic= new PreguntaEvaluacionLogic(connexion);
		preguntaevaluacionLogic.deepLoad(detalleevaluacionproveedor.getPreguntaEvaluacion(),isDeep,deepLoadType,clases);
				
		detalleevaluacionproveedor.setSubPreguntaEvaluacion(detalleevaluacionproveedorDataAccess.getSubPreguntaEvaluacion(connexion,detalleevaluacionproveedor));
		SubPreguntaEvaluacionLogic subpreguntaevaluacionLogic= new SubPreguntaEvaluacionLogic(connexion);
		subpreguntaevaluacionLogic.deepLoad(detalleevaluacionproveedor.getSubPreguntaEvaluacion(),isDeep,deepLoadType,clases);
				
		detalleevaluacionproveedor.setSiNo(detalleevaluacionproveedorDataAccess.getSiNo(connexion,detalleevaluacionproveedor));
		SiNoLogic sinoLogic= new SiNoLogic(connexion);
		sinoLogic.deepLoad(detalleevaluacionproveedor.getSiNo(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				detalleevaluacionproveedor.setEmpresa(detalleevaluacionproveedorDataAccess.getEmpresa(connexion,detalleevaluacionproveedor));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(detalleevaluacionproveedor.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				detalleevaluacionproveedor.setSucursal(detalleevaluacionproveedorDataAccess.getSucursal(connexion,detalleevaluacionproveedor));
				SucursalLogic sucursalLogic= new SucursalLogic(connexion);
				sucursalLogic.deepLoad(detalleevaluacionproveedor.getSucursal(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Ejercicio.class)) {
				detalleevaluacionproveedor.setEjercicio(detalleevaluacionproveedorDataAccess.getEjercicio(connexion,detalleevaluacionproveedor));
				EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
				ejercicioLogic.deepLoad(detalleevaluacionproveedor.getEjercicio(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Periodo.class)) {
				detalleevaluacionproveedor.setPeriodo(detalleevaluacionproveedorDataAccess.getPeriodo(connexion,detalleevaluacionproveedor));
				PeriodoLogic periodoLogic= new PeriodoLogic(connexion);
				periodoLogic.deepLoad(detalleevaluacionproveedor.getPeriodo(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(EvaluacionProveedor.class)) {
				detalleevaluacionproveedor.setEvaluacionProveedor(detalleevaluacionproveedorDataAccess.getEvaluacionProveedor(connexion,detalleevaluacionproveedor));
				EvaluacionProveedorLogic evaluacionproveedorLogic= new EvaluacionProveedorLogic(connexion);
				evaluacionproveedorLogic.deepLoad(detalleevaluacionproveedor.getEvaluacionProveedor(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(PreguntaEvaluacion.class)) {
				detalleevaluacionproveedor.setPreguntaEvaluacion(detalleevaluacionproveedorDataAccess.getPreguntaEvaluacion(connexion,detalleevaluacionproveedor));
				PreguntaEvaluacionLogic preguntaevaluacionLogic= new PreguntaEvaluacionLogic(connexion);
				preguntaevaluacionLogic.deepLoad(detalleevaluacionproveedor.getPreguntaEvaluacion(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(SubPreguntaEvaluacion.class)) {
				detalleevaluacionproveedor.setSubPreguntaEvaluacion(detalleevaluacionproveedorDataAccess.getSubPreguntaEvaluacion(connexion,detalleevaluacionproveedor));
				SubPreguntaEvaluacionLogic subpreguntaevaluacionLogic= new SubPreguntaEvaluacionLogic(connexion);
				subpreguntaevaluacionLogic.deepLoad(detalleevaluacionproveedor.getSubPreguntaEvaluacion(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(SiNo.class)) {
				detalleevaluacionproveedor.setSiNo(detalleevaluacionproveedorDataAccess.getSiNo(connexion,detalleevaluacionproveedor));
				SiNoLogic sinoLogic= new SiNoLogic(connexion);
				sinoLogic.deepLoad(detalleevaluacionproveedor.getSiNo(),isDeep,deepLoadType,clases);				
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
			detalleevaluacionproveedor.setEmpresa(detalleevaluacionproveedorDataAccess.getEmpresa(connexion,detalleevaluacionproveedor));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(detalleevaluacionproveedor.getEmpresa(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detalleevaluacionproveedor.setSucursal(detalleevaluacionproveedorDataAccess.getSucursal(connexion,detalleevaluacionproveedor));
			SucursalLogic sucursalLogic= new SucursalLogic(connexion);
			sucursalLogic.deepLoad(detalleevaluacionproveedor.getSucursal(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Ejercicio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detalleevaluacionproveedor.setEjercicio(detalleevaluacionproveedorDataAccess.getEjercicio(connexion,detalleevaluacionproveedor));
			EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
			ejercicioLogic.deepLoad(detalleevaluacionproveedor.getEjercicio(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Periodo.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detalleevaluacionproveedor.setPeriodo(detalleevaluacionproveedorDataAccess.getPeriodo(connexion,detalleevaluacionproveedor));
			PeriodoLogic periodoLogic= new PeriodoLogic(connexion);
			periodoLogic.deepLoad(detalleevaluacionproveedor.getPeriodo(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(EvaluacionProveedor.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detalleevaluacionproveedor.setEvaluacionProveedor(detalleevaluacionproveedorDataAccess.getEvaluacionProveedor(connexion,detalleevaluacionproveedor));
			EvaluacionProveedorLogic evaluacionproveedorLogic= new EvaluacionProveedorLogic(connexion);
			evaluacionproveedorLogic.deepLoad(detalleevaluacionproveedor.getEvaluacionProveedor(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(PreguntaEvaluacion.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detalleevaluacionproveedor.setPreguntaEvaluacion(detalleevaluacionproveedorDataAccess.getPreguntaEvaluacion(connexion,detalleevaluacionproveedor));
			PreguntaEvaluacionLogic preguntaevaluacionLogic= new PreguntaEvaluacionLogic(connexion);
			preguntaevaluacionLogic.deepLoad(detalleevaluacionproveedor.getPreguntaEvaluacion(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(SubPreguntaEvaluacion.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detalleevaluacionproveedor.setSubPreguntaEvaluacion(detalleevaluacionproveedorDataAccess.getSubPreguntaEvaluacion(connexion,detalleevaluacionproveedor));
			SubPreguntaEvaluacionLogic subpreguntaevaluacionLogic= new SubPreguntaEvaluacionLogic(connexion);
			subpreguntaevaluacionLogic.deepLoad(detalleevaluacionproveedor.getSubPreguntaEvaluacion(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(SiNo.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detalleevaluacionproveedor.setSiNo(detalleevaluacionproveedorDataAccess.getSiNo(connexion,detalleevaluacionproveedor));
			SiNoLogic sinoLogic= new SiNoLogic(connexion);
			sinoLogic.deepLoad(detalleevaluacionproveedor.getSiNo(),isDeep,deepLoadType,clases);
				
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(DetalleEvaluacionProveedor detalleevaluacionproveedor,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			DetalleEvaluacionProveedorLogicAdditional.updateDetalleEvaluacionProveedorToSave(detalleevaluacionproveedor,this.arrDatoGeneral);
			
DetalleEvaluacionProveedorDataAccess.save(detalleevaluacionproveedor, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(detalleevaluacionproveedor.getEmpresa(),connexion);

		SucursalDataAccess.save(detalleevaluacionproveedor.getSucursal(),connexion);

		EjercicioDataAccess.save(detalleevaluacionproveedor.getEjercicio(),connexion);

		PeriodoDataAccess.save(detalleevaluacionproveedor.getPeriodo(),connexion);

		EvaluacionProveedorDataAccess.save(detalleevaluacionproveedor.getEvaluacionProveedor(),connexion);

		PreguntaEvaluacionDataAccess.save(detalleevaluacionproveedor.getPreguntaEvaluacion(),connexion);

		SubPreguntaEvaluacionDataAccess.save(detalleevaluacionproveedor.getSubPreguntaEvaluacion(),connexion);

		SiNoDataAccess.save(detalleevaluacionproveedor.getSiNo(),connexion);
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(detalleevaluacionproveedor.getEmpresa(),connexion);
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				SucursalDataAccess.save(detalleevaluacionproveedor.getSucursal(),connexion);
				continue;
			}

			if(clas.clas.equals(Ejercicio.class)) {
				EjercicioDataAccess.save(detalleevaluacionproveedor.getEjercicio(),connexion);
				continue;
			}

			if(clas.clas.equals(Periodo.class)) {
				PeriodoDataAccess.save(detalleevaluacionproveedor.getPeriodo(),connexion);
				continue;
			}

			if(clas.clas.equals(EvaluacionProveedor.class)) {
				EvaluacionProveedorDataAccess.save(detalleevaluacionproveedor.getEvaluacionProveedor(),connexion);
				continue;
			}

			if(clas.clas.equals(PreguntaEvaluacion.class)) {
				PreguntaEvaluacionDataAccess.save(detalleevaluacionproveedor.getPreguntaEvaluacion(),connexion);
				continue;
			}

			if(clas.clas.equals(SubPreguntaEvaluacion.class)) {
				SubPreguntaEvaluacionDataAccess.save(detalleevaluacionproveedor.getSubPreguntaEvaluacion(),connexion);
				continue;
			}

			if(clas.clas.equals(SiNo.class)) {
				SiNoDataAccess.save(detalleevaluacionproveedor.getSiNo(),connexion);
				continue;
			}

		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(detalleevaluacionproveedor.getEmpresa(),connexion);
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(detalleevaluacionproveedor.getEmpresa(),isDeep,deepLoadType,clases);
				

		SucursalDataAccess.save(detalleevaluacionproveedor.getSucursal(),connexion);
		SucursalLogic sucursalLogic= new SucursalLogic(connexion);
		sucursalLogic.deepLoad(detalleevaluacionproveedor.getSucursal(),isDeep,deepLoadType,clases);
				

		EjercicioDataAccess.save(detalleevaluacionproveedor.getEjercicio(),connexion);
		EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
		ejercicioLogic.deepLoad(detalleevaluacionproveedor.getEjercicio(),isDeep,deepLoadType,clases);
				

		PeriodoDataAccess.save(detalleevaluacionproveedor.getPeriodo(),connexion);
		PeriodoLogic periodoLogic= new PeriodoLogic(connexion);
		periodoLogic.deepLoad(detalleevaluacionproveedor.getPeriodo(),isDeep,deepLoadType,clases);
				

		EvaluacionProveedorDataAccess.save(detalleevaluacionproveedor.getEvaluacionProveedor(),connexion);
		EvaluacionProveedorLogic evaluacionproveedorLogic= new EvaluacionProveedorLogic(connexion);
		evaluacionproveedorLogic.deepLoad(detalleevaluacionproveedor.getEvaluacionProveedor(),isDeep,deepLoadType,clases);
				

		PreguntaEvaluacionDataAccess.save(detalleevaluacionproveedor.getPreguntaEvaluacion(),connexion);
		PreguntaEvaluacionLogic preguntaevaluacionLogic= new PreguntaEvaluacionLogic(connexion);
		preguntaevaluacionLogic.deepLoad(detalleevaluacionproveedor.getPreguntaEvaluacion(),isDeep,deepLoadType,clases);
				

		SubPreguntaEvaluacionDataAccess.save(detalleevaluacionproveedor.getSubPreguntaEvaluacion(),connexion);
		SubPreguntaEvaluacionLogic subpreguntaevaluacionLogic= new SubPreguntaEvaluacionLogic(connexion);
		subpreguntaevaluacionLogic.deepLoad(detalleevaluacionproveedor.getSubPreguntaEvaluacion(),isDeep,deepLoadType,clases);
				

		SiNoDataAccess.save(detalleevaluacionproveedor.getSiNo(),connexion);
		SiNoLogic sinoLogic= new SiNoLogic(connexion);
		sinoLogic.deepLoad(detalleevaluacionproveedor.getSiNo(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(detalleevaluacionproveedor.getEmpresa(),connexion);
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepSave(detalleevaluacionproveedor.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				SucursalDataAccess.save(detalleevaluacionproveedor.getSucursal(),connexion);
				SucursalLogic sucursalLogic= new SucursalLogic(connexion);
				sucursalLogic.deepSave(detalleevaluacionproveedor.getSucursal(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Ejercicio.class)) {
				EjercicioDataAccess.save(detalleevaluacionproveedor.getEjercicio(),connexion);
				EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
				ejercicioLogic.deepSave(detalleevaluacionproveedor.getEjercicio(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Periodo.class)) {
				PeriodoDataAccess.save(detalleevaluacionproveedor.getPeriodo(),connexion);
				PeriodoLogic periodoLogic= new PeriodoLogic(connexion);
				periodoLogic.deepSave(detalleevaluacionproveedor.getPeriodo(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(EvaluacionProveedor.class)) {
				EvaluacionProveedorDataAccess.save(detalleevaluacionproveedor.getEvaluacionProveedor(),connexion);
				EvaluacionProveedorLogic evaluacionproveedorLogic= new EvaluacionProveedorLogic(connexion);
				evaluacionproveedorLogic.deepSave(detalleevaluacionproveedor.getEvaluacionProveedor(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(PreguntaEvaluacion.class)) {
				PreguntaEvaluacionDataAccess.save(detalleevaluacionproveedor.getPreguntaEvaluacion(),connexion);
				PreguntaEvaluacionLogic preguntaevaluacionLogic= new PreguntaEvaluacionLogic(connexion);
				preguntaevaluacionLogic.deepSave(detalleevaluacionproveedor.getPreguntaEvaluacion(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(SubPreguntaEvaluacion.class)) {
				SubPreguntaEvaluacionDataAccess.save(detalleevaluacionproveedor.getSubPreguntaEvaluacion(),connexion);
				SubPreguntaEvaluacionLogic subpreguntaevaluacionLogic= new SubPreguntaEvaluacionLogic(connexion);
				subpreguntaevaluacionLogic.deepSave(detalleevaluacionproveedor.getSubPreguntaEvaluacion(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(SiNo.class)) {
				SiNoDataAccess.save(detalleevaluacionproveedor.getSiNo(),connexion);
				SiNoLogic sinoLogic= new SiNoLogic(connexion);
				sinoLogic.deepSave(detalleevaluacionproveedor.getSiNo(),isDeep,deepLoadType,clases);				
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
			this.getNewConnexionToDeep(DetalleEvaluacionProveedor.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(detalleevaluacionproveedor,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				DetalleEvaluacionProveedorConstantesFunciones.refrescarForeignKeysDescripcionesDetalleEvaluacionProveedor(detalleevaluacionproveedor);
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
			this.deepLoad(this.detalleevaluacionproveedor,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				DetalleEvaluacionProveedorConstantesFunciones.refrescarForeignKeysDescripcionesDetalleEvaluacionProveedor(this.detalleevaluacionproveedor);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(DetalleEvaluacionProveedor.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(detalleevaluacionproveedors!=null) {
				for(DetalleEvaluacionProveedor detalleevaluacionproveedor:detalleevaluacionproveedors) {
					this.deepLoad(detalleevaluacionproveedor,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					DetalleEvaluacionProveedorConstantesFunciones.refrescarForeignKeysDescripcionesDetalleEvaluacionProveedor(detalleevaluacionproveedors);
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
			if(detalleevaluacionproveedors!=null) {
				for(DetalleEvaluacionProveedor detalleevaluacionproveedor:detalleevaluacionproveedors) {
					this.deepLoad(detalleevaluacionproveedor,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					DetalleEvaluacionProveedorConstantesFunciones.refrescarForeignKeysDescripcionesDetalleEvaluacionProveedor(detalleevaluacionproveedors);
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
			this.getNewConnexionToDeep(DetalleEvaluacionProveedor.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(detalleevaluacionproveedor,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(DetalleEvaluacionProveedor.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(detalleevaluacionproveedors!=null) {
				for(DetalleEvaluacionProveedor detalleevaluacionproveedor:detalleevaluacionproveedors) {
					this.deepSave(detalleevaluacionproveedor,isDeep,deepLoadType,clases);
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
			if(detalleevaluacionproveedors!=null) {
				for(DetalleEvaluacionProveedor detalleevaluacionproveedor:detalleevaluacionproveedors) {
					this.deepSave(detalleevaluacionproveedor,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getDetalleEvaluacionProveedorsFK_IdEjercicioWithConnection(String sFinalQuery,Pagination pagination,Long id_ejercicio)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleEvaluacionProveedor.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEjercicio= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEjercicio.setParameterSelectionGeneralEqual(ParameterType.LONG,id_ejercicio,DetalleEvaluacionProveedorConstantesFunciones.IDEJERCICIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEjercicio);

			DetalleEvaluacionProveedorLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEjercicio","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detalleevaluacionproveedors=detalleevaluacionproveedorDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleEvaluacionProveedorConstantesFunciones.refrescarForeignKeysDescripcionesDetalleEvaluacionProveedor(this.detalleevaluacionproveedors);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getDetalleEvaluacionProveedorsFK_IdEjercicio(String sFinalQuery,Pagination pagination,Long id_ejercicio)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEjercicio= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEjercicio.setParameterSelectionGeneralEqual(ParameterType.LONG,id_ejercicio,DetalleEvaluacionProveedorConstantesFunciones.IDEJERCICIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEjercicio);

			DetalleEvaluacionProveedorLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEjercicio","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detalleevaluacionproveedors=detalleevaluacionproveedorDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleEvaluacionProveedorConstantesFunciones.refrescarForeignKeysDescripcionesDetalleEvaluacionProveedor(this.detalleevaluacionproveedors);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getDetalleEvaluacionProveedorsFK_IdEmpresaWithConnection(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleEvaluacionProveedor.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,DetalleEvaluacionProveedorConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			DetalleEvaluacionProveedorLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detalleevaluacionproveedors=detalleevaluacionproveedorDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleEvaluacionProveedorConstantesFunciones.refrescarForeignKeysDescripcionesDetalleEvaluacionProveedor(this.detalleevaluacionproveedors);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getDetalleEvaluacionProveedorsFK_IdEmpresa(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,DetalleEvaluacionProveedorConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			DetalleEvaluacionProveedorLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detalleevaluacionproveedors=detalleevaluacionproveedorDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleEvaluacionProveedorConstantesFunciones.refrescarForeignKeysDescripcionesDetalleEvaluacionProveedor(this.detalleevaluacionproveedors);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getDetalleEvaluacionProveedorsFK_IdEvaluacionProveedorWithConnection(String sFinalQuery,Pagination pagination,Long id_evaluacion_proveedor)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleEvaluacionProveedor.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEvaluacionProveedor= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEvaluacionProveedor.setParameterSelectionGeneralEqual(ParameterType.LONG,id_evaluacion_proveedor,DetalleEvaluacionProveedorConstantesFunciones.IDEVALUACIONPROVEEDOR,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEvaluacionProveedor);

			DetalleEvaluacionProveedorLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEvaluacionProveedor","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detalleevaluacionproveedors=detalleevaluacionproveedorDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleEvaluacionProveedorConstantesFunciones.refrescarForeignKeysDescripcionesDetalleEvaluacionProveedor(this.detalleevaluacionproveedors);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getDetalleEvaluacionProveedorsFK_IdEvaluacionProveedor(String sFinalQuery,Pagination pagination,Long id_evaluacion_proveedor)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEvaluacionProveedor= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEvaluacionProveedor.setParameterSelectionGeneralEqual(ParameterType.LONG,id_evaluacion_proveedor,DetalleEvaluacionProveedorConstantesFunciones.IDEVALUACIONPROVEEDOR,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEvaluacionProveedor);

			DetalleEvaluacionProveedorLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEvaluacionProveedor","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detalleevaluacionproveedors=detalleevaluacionproveedorDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleEvaluacionProveedorConstantesFunciones.refrescarForeignKeysDescripcionesDetalleEvaluacionProveedor(this.detalleevaluacionproveedors);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getDetalleEvaluacionProveedorsFK_IdPeriodoWithConnection(String sFinalQuery,Pagination pagination,Long id_periodo)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleEvaluacionProveedor.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidPeriodo= new ParameterSelectionGeneral();
			parameterSelectionGeneralidPeriodo.setParameterSelectionGeneralEqual(ParameterType.LONG,id_periodo,DetalleEvaluacionProveedorConstantesFunciones.IDPERIODO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidPeriodo);

			DetalleEvaluacionProveedorLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdPeriodo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detalleevaluacionproveedors=detalleevaluacionproveedorDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleEvaluacionProveedorConstantesFunciones.refrescarForeignKeysDescripcionesDetalleEvaluacionProveedor(this.detalleevaluacionproveedors);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getDetalleEvaluacionProveedorsFK_IdPeriodo(String sFinalQuery,Pagination pagination,Long id_periodo)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidPeriodo= new ParameterSelectionGeneral();
			parameterSelectionGeneralidPeriodo.setParameterSelectionGeneralEqual(ParameterType.LONG,id_periodo,DetalleEvaluacionProveedorConstantesFunciones.IDPERIODO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidPeriodo);

			DetalleEvaluacionProveedorLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdPeriodo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detalleevaluacionproveedors=detalleevaluacionproveedorDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleEvaluacionProveedorConstantesFunciones.refrescarForeignKeysDescripcionesDetalleEvaluacionProveedor(this.detalleevaluacionproveedors);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getDetalleEvaluacionProveedorsFK_IdPreguntaEvaluacionWithConnection(String sFinalQuery,Pagination pagination,Long id_pregunta_evaluacion)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleEvaluacionProveedor.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidPreguntaEvaluacion= new ParameterSelectionGeneral();
			parameterSelectionGeneralidPreguntaEvaluacion.setParameterSelectionGeneralEqual(ParameterType.LONG,id_pregunta_evaluacion,DetalleEvaluacionProveedorConstantesFunciones.IDPREGUNTAEVALUACION,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidPreguntaEvaluacion);

			DetalleEvaluacionProveedorLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdPreguntaEvaluacion","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detalleevaluacionproveedors=detalleevaluacionproveedorDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleEvaluacionProveedorConstantesFunciones.refrescarForeignKeysDescripcionesDetalleEvaluacionProveedor(this.detalleevaluacionproveedors);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getDetalleEvaluacionProveedorsFK_IdPreguntaEvaluacion(String sFinalQuery,Pagination pagination,Long id_pregunta_evaluacion)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidPreguntaEvaluacion= new ParameterSelectionGeneral();
			parameterSelectionGeneralidPreguntaEvaluacion.setParameterSelectionGeneralEqual(ParameterType.LONG,id_pregunta_evaluacion,DetalleEvaluacionProveedorConstantesFunciones.IDPREGUNTAEVALUACION,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidPreguntaEvaluacion);

			DetalleEvaluacionProveedorLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdPreguntaEvaluacion","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detalleevaluacionproveedors=detalleevaluacionproveedorDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleEvaluacionProveedorConstantesFunciones.refrescarForeignKeysDescripcionesDetalleEvaluacionProveedor(this.detalleevaluacionproveedors);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getDetalleEvaluacionProveedorsFK_IdSiNoWithConnection(String sFinalQuery,Pagination pagination,Long id_si_no)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleEvaluacionProveedor.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidSiNo= new ParameterSelectionGeneral();
			parameterSelectionGeneralidSiNo.setParameterSelectionGeneralEqual(ParameterType.LONG,id_si_no,DetalleEvaluacionProveedorConstantesFunciones.IDSINO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidSiNo);

			DetalleEvaluacionProveedorLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdSiNo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detalleevaluacionproveedors=detalleevaluacionproveedorDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleEvaluacionProveedorConstantesFunciones.refrescarForeignKeysDescripcionesDetalleEvaluacionProveedor(this.detalleevaluacionproveedors);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getDetalleEvaluacionProveedorsFK_IdSiNo(String sFinalQuery,Pagination pagination,Long id_si_no)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidSiNo= new ParameterSelectionGeneral();
			parameterSelectionGeneralidSiNo.setParameterSelectionGeneralEqual(ParameterType.LONG,id_si_no,DetalleEvaluacionProveedorConstantesFunciones.IDSINO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidSiNo);

			DetalleEvaluacionProveedorLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdSiNo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detalleevaluacionproveedors=detalleevaluacionproveedorDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleEvaluacionProveedorConstantesFunciones.refrescarForeignKeysDescripcionesDetalleEvaluacionProveedor(this.detalleevaluacionproveedors);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getDetalleEvaluacionProveedorsFK_IdSubPreguntaEvaluacionWithConnection(String sFinalQuery,Pagination pagination,Long id_sub_pregunta_evaluacion)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleEvaluacionProveedor.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidSubPreguntaEvaluacion= new ParameterSelectionGeneral();
			parameterSelectionGeneralidSubPreguntaEvaluacion.setParameterSelectionGeneralEqual(ParameterType.LONG,id_sub_pregunta_evaluacion,DetalleEvaluacionProveedorConstantesFunciones.IDSUBPREGUNTAEVALUACION,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidSubPreguntaEvaluacion);

			DetalleEvaluacionProveedorLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdSubPreguntaEvaluacion","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detalleevaluacionproveedors=detalleevaluacionproveedorDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleEvaluacionProveedorConstantesFunciones.refrescarForeignKeysDescripcionesDetalleEvaluacionProveedor(this.detalleevaluacionproveedors);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getDetalleEvaluacionProveedorsFK_IdSubPreguntaEvaluacion(String sFinalQuery,Pagination pagination,Long id_sub_pregunta_evaluacion)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidSubPreguntaEvaluacion= new ParameterSelectionGeneral();
			parameterSelectionGeneralidSubPreguntaEvaluacion.setParameterSelectionGeneralEqual(ParameterType.LONG,id_sub_pregunta_evaluacion,DetalleEvaluacionProveedorConstantesFunciones.IDSUBPREGUNTAEVALUACION,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidSubPreguntaEvaluacion);

			DetalleEvaluacionProveedorLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdSubPreguntaEvaluacion","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detalleevaluacionproveedors=detalleevaluacionproveedorDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleEvaluacionProveedorConstantesFunciones.refrescarForeignKeysDescripcionesDetalleEvaluacionProveedor(this.detalleevaluacionproveedors);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getDetalleEvaluacionProveedorsFK_IdSucursalWithConnection(String sFinalQuery,Pagination pagination,Long id_sucursal)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleEvaluacionProveedor.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidSucursal= new ParameterSelectionGeneral();
			parameterSelectionGeneralidSucursal.setParameterSelectionGeneralEqual(ParameterType.LONG,id_sucursal,DetalleEvaluacionProveedorConstantesFunciones.IDSUCURSAL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidSucursal);

			DetalleEvaluacionProveedorLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdSucursal","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detalleevaluacionproveedors=detalleevaluacionproveedorDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleEvaluacionProveedorConstantesFunciones.refrescarForeignKeysDescripcionesDetalleEvaluacionProveedor(this.detalleevaluacionproveedors);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getDetalleEvaluacionProveedorsFK_IdSucursal(String sFinalQuery,Pagination pagination,Long id_sucursal)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidSucursal= new ParameterSelectionGeneral();
			parameterSelectionGeneralidSucursal.setParameterSelectionGeneralEqual(ParameterType.LONG,id_sucursal,DetalleEvaluacionProveedorConstantesFunciones.IDSUCURSAL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidSucursal);

			DetalleEvaluacionProveedorLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdSucursal","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detalleevaluacionproveedors=detalleevaluacionproveedorDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleEvaluacionProveedorConstantesFunciones.refrescarForeignKeysDescripcionesDetalleEvaluacionProveedor(this.detalleevaluacionproveedors);
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
			if(DetalleEvaluacionProveedorConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,DetalleEvaluacionProveedorDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,DetalleEvaluacionProveedor detalleevaluacionproveedor,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(DetalleEvaluacionProveedorConstantesFunciones.ISCONAUDITORIA) {
				if(detalleevaluacionproveedor.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,DetalleEvaluacionProveedorDataAccess.TABLENAME, detalleevaluacionproveedor.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(DetalleEvaluacionProveedorConstantesFunciones.ISCONAUDITORIADETALLE) {
						////DetalleEvaluacionProveedorLogic.registrarAuditoriaDetallesDetalleEvaluacionProveedor(connexion,detalleevaluacionproveedor,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(detalleevaluacionproveedor.getIsDeleted()) {
					/*if(!detalleevaluacionproveedor.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,DetalleEvaluacionProveedorDataAccess.TABLENAME, detalleevaluacionproveedor.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////DetalleEvaluacionProveedorLogic.registrarAuditoriaDetallesDetalleEvaluacionProveedor(connexion,detalleevaluacionproveedor,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,DetalleEvaluacionProveedorDataAccess.TABLENAME, detalleevaluacionproveedor.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(detalleevaluacionproveedor.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,DetalleEvaluacionProveedorDataAccess.TABLENAME, detalleevaluacionproveedor.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(DetalleEvaluacionProveedorConstantesFunciones.ISCONAUDITORIADETALLE) {
						////DetalleEvaluacionProveedorLogic.registrarAuditoriaDetallesDetalleEvaluacionProveedor(connexion,detalleevaluacionproveedor,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesDetalleEvaluacionProveedor(Connexion connexion,DetalleEvaluacionProveedor detalleevaluacionproveedor)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(detalleevaluacionproveedor.getIsNew()||!detalleevaluacionproveedor.getid_empresa().equals(detalleevaluacionproveedor.getDetalleEvaluacionProveedorOriginal().getid_empresa()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detalleevaluacionproveedor.getDetalleEvaluacionProveedorOriginal().getid_empresa()!=null)
				{
					strValorActual=detalleevaluacionproveedor.getDetalleEvaluacionProveedorOriginal().getid_empresa().toString();
				}
				if(detalleevaluacionproveedor.getid_empresa()!=null)
				{
					strValorNuevo=detalleevaluacionproveedor.getid_empresa().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleEvaluacionProveedorConstantesFunciones.IDEMPRESA,strValorActual,strValorNuevo);
			}	
			
			if(detalleevaluacionproveedor.getIsNew()||!detalleevaluacionproveedor.getid_sucursal().equals(detalleevaluacionproveedor.getDetalleEvaluacionProveedorOriginal().getid_sucursal()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detalleevaluacionproveedor.getDetalleEvaluacionProveedorOriginal().getid_sucursal()!=null)
				{
					strValorActual=detalleevaluacionproveedor.getDetalleEvaluacionProveedorOriginal().getid_sucursal().toString();
				}
				if(detalleevaluacionproveedor.getid_sucursal()!=null)
				{
					strValorNuevo=detalleevaluacionproveedor.getid_sucursal().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleEvaluacionProveedorConstantesFunciones.IDSUCURSAL,strValorActual,strValorNuevo);
			}	
			
			if(detalleevaluacionproveedor.getIsNew()||!detalleevaluacionproveedor.getid_ejercicio().equals(detalleevaluacionproveedor.getDetalleEvaluacionProveedorOriginal().getid_ejercicio()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detalleevaluacionproveedor.getDetalleEvaluacionProveedorOriginal().getid_ejercicio()!=null)
				{
					strValorActual=detalleevaluacionproveedor.getDetalleEvaluacionProveedorOriginal().getid_ejercicio().toString();
				}
				if(detalleevaluacionproveedor.getid_ejercicio()!=null)
				{
					strValorNuevo=detalleevaluacionproveedor.getid_ejercicio().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleEvaluacionProveedorConstantesFunciones.IDEJERCICIO,strValorActual,strValorNuevo);
			}	
			
			if(detalleevaluacionproveedor.getIsNew()||!detalleevaluacionproveedor.getid_periodo().equals(detalleevaluacionproveedor.getDetalleEvaluacionProveedorOriginal().getid_periodo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detalleevaluacionproveedor.getDetalleEvaluacionProveedorOriginal().getid_periodo()!=null)
				{
					strValorActual=detalleevaluacionproveedor.getDetalleEvaluacionProveedorOriginal().getid_periodo().toString();
				}
				if(detalleevaluacionproveedor.getid_periodo()!=null)
				{
					strValorNuevo=detalleevaluacionproveedor.getid_periodo().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleEvaluacionProveedorConstantesFunciones.IDPERIODO,strValorActual,strValorNuevo);
			}	
			
			if(detalleevaluacionproveedor.getIsNew()||!detalleevaluacionproveedor.getid_evaluacion_proveedor().equals(detalleevaluacionproveedor.getDetalleEvaluacionProveedorOriginal().getid_evaluacion_proveedor()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detalleevaluacionproveedor.getDetalleEvaluacionProveedorOriginal().getid_evaluacion_proveedor()!=null)
				{
					strValorActual=detalleevaluacionproveedor.getDetalleEvaluacionProveedorOriginal().getid_evaluacion_proveedor().toString();
				}
				if(detalleevaluacionproveedor.getid_evaluacion_proveedor()!=null)
				{
					strValorNuevo=detalleevaluacionproveedor.getid_evaluacion_proveedor().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleEvaluacionProveedorConstantesFunciones.IDEVALUACIONPROVEEDOR,strValorActual,strValorNuevo);
			}	
			
			if(detalleevaluacionproveedor.getIsNew()||!detalleevaluacionproveedor.getid_pregunta_evaluacion().equals(detalleevaluacionproveedor.getDetalleEvaluacionProveedorOriginal().getid_pregunta_evaluacion()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detalleevaluacionproveedor.getDetalleEvaluacionProveedorOriginal().getid_pregunta_evaluacion()!=null)
				{
					strValorActual=detalleevaluacionproveedor.getDetalleEvaluacionProveedorOriginal().getid_pregunta_evaluacion().toString();
				}
				if(detalleevaluacionproveedor.getid_pregunta_evaluacion()!=null)
				{
					strValorNuevo=detalleevaluacionproveedor.getid_pregunta_evaluacion().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleEvaluacionProveedorConstantesFunciones.IDPREGUNTAEVALUACION,strValorActual,strValorNuevo);
			}	
			
			if(detalleevaluacionproveedor.getIsNew()||!detalleevaluacionproveedor.getid_sub_pregunta_evaluacion().equals(detalleevaluacionproveedor.getDetalleEvaluacionProveedorOriginal().getid_sub_pregunta_evaluacion()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detalleevaluacionproveedor.getDetalleEvaluacionProveedorOriginal().getid_sub_pregunta_evaluacion()!=null)
				{
					strValorActual=detalleevaluacionproveedor.getDetalleEvaluacionProveedorOriginal().getid_sub_pregunta_evaluacion().toString();
				}
				if(detalleevaluacionproveedor.getid_sub_pregunta_evaluacion()!=null)
				{
					strValorNuevo=detalleevaluacionproveedor.getid_sub_pregunta_evaluacion().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleEvaluacionProveedorConstantesFunciones.IDSUBPREGUNTAEVALUACION,strValorActual,strValorNuevo);
			}	
			
			if(detalleevaluacionproveedor.getIsNew()||!detalleevaluacionproveedor.getid_si_no().equals(detalleevaluacionproveedor.getDetalleEvaluacionProveedorOriginal().getid_si_no()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detalleevaluacionproveedor.getDetalleEvaluacionProveedorOriginal().getid_si_no()!=null)
				{
					strValorActual=detalleevaluacionproveedor.getDetalleEvaluacionProveedorOriginal().getid_si_no().toString();
				}
				if(detalleevaluacionproveedor.getid_si_no()!=null)
				{
					strValorNuevo=detalleevaluacionproveedor.getid_si_no().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleEvaluacionProveedorConstantesFunciones.IDSINO,strValorActual,strValorNuevo);
			}	
			
			if(detalleevaluacionproveedor.getIsNew()||!detalleevaluacionproveedor.getdescripcion().equals(detalleevaluacionproveedor.getDetalleEvaluacionProveedorOriginal().getdescripcion()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detalleevaluacionproveedor.getDetalleEvaluacionProveedorOriginal().getdescripcion()!=null)
				{
					strValorActual=detalleevaluacionproveedor.getDetalleEvaluacionProveedorOriginal().getdescripcion();
				}
				if(detalleevaluacionproveedor.getdescripcion()!=null)
				{
					strValorNuevo=detalleevaluacionproveedor.getdescripcion() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleEvaluacionProveedorConstantesFunciones.DESCRIPCION,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void saveDetalleEvaluacionProveedorRelacionesWithConnection(DetalleEvaluacionProveedor detalleevaluacionproveedor) throws Exception {

		if(!detalleevaluacionproveedor.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveDetalleEvaluacionProveedorRelacionesBase(detalleevaluacionproveedor,true);
		}
	}

	public void saveDetalleEvaluacionProveedorRelaciones(DetalleEvaluacionProveedor detalleevaluacionproveedor)throws Exception {

		if(!detalleevaluacionproveedor.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveDetalleEvaluacionProveedorRelacionesBase(detalleevaluacionproveedor,false);
		}
	}

	public void saveDetalleEvaluacionProveedorRelacionesBase(DetalleEvaluacionProveedor detalleevaluacionproveedor,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("DetalleEvaluacionProveedor-saveRelacionesWithConnection");}
	

			this.setDetalleEvaluacionProveedor(detalleevaluacionproveedor);

			if(DetalleEvaluacionProveedorLogicAdditional.validarSaveRelaciones(detalleevaluacionproveedor,this)) {

				DetalleEvaluacionProveedorLogicAdditional.updateRelacionesToSave(detalleevaluacionproveedor,this);

				if((detalleevaluacionproveedor.getIsNew()||detalleevaluacionproveedor.getIsChanged())&&!detalleevaluacionproveedor.getIsDeleted()) {
					this.saveDetalleEvaluacionProveedor();
					this.saveDetalleEvaluacionProveedorRelacionesDetalles();

				} else if(detalleevaluacionproveedor.getIsDeleted()) {
					this.saveDetalleEvaluacionProveedorRelacionesDetalles();
					this.saveDetalleEvaluacionProveedor();
				}

				DetalleEvaluacionProveedorLogicAdditional.updateRelacionesToSaveAfter(detalleevaluacionproveedor,this);

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
	
	
	private void saveDetalleEvaluacionProveedorRelacionesDetalles()throws Exception {
		try {
	

		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfDetalleEvaluacionProveedor(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=DetalleEvaluacionProveedorConstantesFunciones.getClassesForeignKeysOfDetalleEvaluacionProveedor(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfDetalleEvaluacionProveedor(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=DetalleEvaluacionProveedorConstantesFunciones.getClassesRelationshipsOfDetalleEvaluacionProveedor(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}
