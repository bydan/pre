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
import com.bydan.erp.contabilidad.util.FacturaProveedorConstantesFunciones;
import com.bydan.erp.contabilidad.util.FacturaProveedorParameterReturnGeneral;
//import com.bydan.erp.contabilidad.util.FacturaProveedorParameterGeneral;
import com.bydan.erp.contabilidad.business.entity.FacturaProveedor;
import com.bydan.erp.contabilidad.business.logic.FacturaProveedorLogicAdditional;
import com.bydan.erp.contabilidad.business.dataaccess.*;
import com.bydan.erp.contabilidad.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.facturacion.business.entity.*;
import com.bydan.erp.tesoreria.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.nomina.business.entity.*;


import com.bydan.erp.seguridad.business.logic.*;
import com.bydan.erp.facturacion.business.logic.*;
import com.bydan.erp.tesoreria.business.logic.*;
import com.bydan.erp.cartera.business.logic.*;
import com.bydan.erp.nomina.business.logic.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.facturacion.util.*;
import com.bydan.erp.tesoreria.util.*;
import com.bydan.erp.cartera.util.*;
import com.bydan.erp.nomina.util.*;


import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.facturacion.business.dataaccess.*;
import com.bydan.erp.tesoreria.business.dataaccess.*;
import com.bydan.erp.cartera.business.dataaccess.*;
import com.bydan.erp.nomina.business.dataaccess.*;








@SuppressWarnings("unused")
public class FacturaProveedorLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(FacturaProveedorLogic.class);
	
	protected FacturaProveedorDataAccess facturaproveedorDataAccess; 	
	protected FacturaProveedor facturaproveedor;
	protected List<FacturaProveedor> facturaproveedors;
	protected Object facturaproveedorObject;	
	protected List<Object> facturaproveedorsObject;
	
	public static ClassValidator<FacturaProveedor> facturaproveedorValidator = new ClassValidator<FacturaProveedor>(FacturaProveedor.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected FacturaProveedorLogicAdditional facturaproveedorLogicAdditional=null;
	
	public FacturaProveedorLogicAdditional getFacturaProveedorLogicAdditional() {
		return this.facturaproveedorLogicAdditional;
	}
	
	public void setFacturaProveedorLogicAdditional(FacturaProveedorLogicAdditional facturaproveedorLogicAdditional) {
		try {
			this.facturaproveedorLogicAdditional=facturaproveedorLogicAdditional;
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
	
	
	
	
	public  FacturaProveedorLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.facturaproveedorDataAccess = new FacturaProveedorDataAccess();
			
			this.facturaproveedors= new ArrayList<FacturaProveedor>();
			this.facturaproveedor= new FacturaProveedor();
			
			this.facturaproveedorObject=new Object();
			this.facturaproveedorsObject=new ArrayList<Object>();
				
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
			
			this.facturaproveedorDataAccess.setConnexionType(this.connexionType);
			this.facturaproveedorDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  FacturaProveedorLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.facturaproveedorDataAccess = new FacturaProveedorDataAccess();
			this.facturaproveedors= new ArrayList<FacturaProveedor>();
			this.facturaproveedor= new FacturaProveedor();
			this.facturaproveedorObject=new Object();
			this.facturaproveedorsObject=new ArrayList<Object>();
			
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
			
			this.facturaproveedorDataAccess.setConnexionType(this.connexionType);
			this.facturaproveedorDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public FacturaProveedor getFacturaProveedor() throws Exception {	
		FacturaProveedorLogicAdditional.checkFacturaProveedorToGet(facturaproveedor,this.datosCliente,this.arrDatoGeneral);
		FacturaProveedorLogicAdditional.updateFacturaProveedorToGet(facturaproveedor,this.arrDatoGeneral);
		
		return facturaproveedor;
	}
		
	public void setFacturaProveedor(FacturaProveedor newFacturaProveedor) {
		this.facturaproveedor = newFacturaProveedor;
	}
	
	public FacturaProveedorDataAccess getFacturaProveedorDataAccess() {
		return facturaproveedorDataAccess;
	}
	
	public void setFacturaProveedorDataAccess(FacturaProveedorDataAccess newfacturaproveedorDataAccess) {
		this.facturaproveedorDataAccess = newfacturaproveedorDataAccess;
	}
	
	public List<FacturaProveedor> getFacturaProveedors() throws Exception {		
		this.quitarFacturaProveedorsNulos();
		
		FacturaProveedorLogicAdditional.checkFacturaProveedorToGets(facturaproveedors,this.datosCliente,this.arrDatoGeneral);
		
		for (FacturaProveedor facturaproveedorLocal: facturaproveedors ) {
			FacturaProveedorLogicAdditional.updateFacturaProveedorToGet(facturaproveedorLocal,this.arrDatoGeneral);
		}
		
		return facturaproveedors;
	}
	
	public void setFacturaProveedors(List<FacturaProveedor> newFacturaProveedors) {
		this.facturaproveedors = newFacturaProveedors;
	}
	
	public Object getFacturaProveedorObject() {	
		this.facturaproveedorObject=this.facturaproveedorDataAccess.getEntityObject();
		return this.facturaproveedorObject;
	}
		
	public void setFacturaProveedorObject(Object newFacturaProveedorObject) {
		this.facturaproveedorObject = newFacturaProveedorObject;
	}
	
	public List<Object> getFacturaProveedorsObject() {		
		this.facturaproveedorsObject=this.facturaproveedorDataAccess.getEntitiesObject();
		return this.facturaproveedorsObject;
	}
		
	public void setFacturaProveedorsObject(List<Object> newFacturaProveedorsObject) {
		this.facturaproveedorsObject = newFacturaProveedorsObject;
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
		
		if(this.facturaproveedorDataAccess!=null) {
			this.facturaproveedorDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FacturaProveedor.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			facturaproveedorDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			facturaproveedorDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		facturaproveedor = new  FacturaProveedor();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FacturaProveedor.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			facturaproveedor=facturaproveedorDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.facturaproveedor,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				FacturaProveedorConstantesFunciones.refrescarForeignKeysDescripcionesFacturaProveedor(this.facturaproveedor);
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
		facturaproveedor = new  FacturaProveedor();
		  		  
        try {
			
			facturaproveedor=facturaproveedorDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.facturaproveedor,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				FacturaProveedorConstantesFunciones.refrescarForeignKeysDescripcionesFacturaProveedor(this.facturaproveedor);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		facturaproveedor = new  FacturaProveedor();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FacturaProveedor.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			facturaproveedor=facturaproveedorDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.facturaproveedor,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				FacturaProveedorConstantesFunciones.refrescarForeignKeysDescripcionesFacturaProveedor(this.facturaproveedor);
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
		facturaproveedor = new  FacturaProveedor();
		  		  
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
		facturaproveedor = new  FacturaProveedor();
		  		  
        try {
			
			facturaproveedor=facturaproveedorDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.facturaproveedor,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				FacturaProveedorConstantesFunciones.refrescarForeignKeysDescripcionesFacturaProveedor(this.facturaproveedor);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		facturaproveedor = new  FacturaProveedor();
		  		  
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
		facturaproveedor = new  FacturaProveedor();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FacturaProveedor.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =facturaproveedorDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		facturaproveedor = new  FacturaProveedor();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=facturaproveedorDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		facturaproveedor = new  FacturaProveedor();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FacturaProveedor.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =facturaproveedorDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		facturaproveedor = new  FacturaProveedor();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=facturaproveedorDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		facturaproveedor = new  FacturaProveedor();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FacturaProveedor.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =facturaproveedorDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		facturaproveedor = new  FacturaProveedor();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=facturaproveedorDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		facturaproveedors = new  ArrayList<FacturaProveedor>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FacturaProveedor.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			FacturaProveedorLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			facturaproveedors=facturaproveedorDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarFacturaProveedor(facturaproveedors);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				FacturaProveedorConstantesFunciones.refrescarForeignKeysDescripcionesFacturaProveedor(this.facturaproveedors);
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
		facturaproveedors = new  ArrayList<FacturaProveedor>();
		  		  
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
		facturaproveedors = new  ArrayList<FacturaProveedor>();
		  		  
        try {			
			FacturaProveedorLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			facturaproveedors=facturaproveedorDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarFacturaProveedor(facturaproveedors);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				FacturaProveedorConstantesFunciones.refrescarForeignKeysDescripcionesFacturaProveedor(this.facturaproveedors);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		facturaproveedors = new  ArrayList<FacturaProveedor>();
		  		  
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
		facturaproveedors = new  ArrayList<FacturaProveedor>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FacturaProveedor.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			FacturaProveedorLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			facturaproveedors=facturaproveedorDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarFacturaProveedor(facturaproveedors);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				FacturaProveedorConstantesFunciones.refrescarForeignKeysDescripcionesFacturaProveedor(this.facturaproveedors);
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
		facturaproveedors = new  ArrayList<FacturaProveedor>();
		  		  
        try {
			FacturaProveedorLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			facturaproveedors=facturaproveedorDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarFacturaProveedor(facturaproveedors);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				FacturaProveedorConstantesFunciones.refrescarForeignKeysDescripcionesFacturaProveedor(this.facturaproveedors);
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
		facturaproveedors = new  ArrayList<FacturaProveedor>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FacturaProveedor.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			FacturaProveedorLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			facturaproveedors=facturaproveedorDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarFacturaProveedor(facturaproveedors);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				FacturaProveedorConstantesFunciones.refrescarForeignKeysDescripcionesFacturaProveedor(this.facturaproveedors);
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
		facturaproveedors = new  ArrayList<FacturaProveedor>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			FacturaProveedorLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			facturaproveedors=facturaproveedorDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarFacturaProveedor(facturaproveedors);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				FacturaProveedorConstantesFunciones.refrescarForeignKeysDescripcionesFacturaProveedor(this.facturaproveedors);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		facturaproveedor = new  FacturaProveedor();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FacturaProveedor.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			FacturaProveedorLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			facturaproveedor=facturaproveedorDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarFacturaProveedor(facturaproveedor);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				FacturaProveedorConstantesFunciones.refrescarForeignKeysDescripcionesFacturaProveedor(this.facturaproveedor);
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
		facturaproveedor = new  FacturaProveedor();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			FacturaProveedorLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			facturaproveedor=facturaproveedorDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarFacturaProveedor(facturaproveedor);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				FacturaProveedorConstantesFunciones.refrescarForeignKeysDescripcionesFacturaProveedor(this.facturaproveedor);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		facturaproveedors = new  ArrayList<FacturaProveedor>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FacturaProveedor.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			FacturaProveedorLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			facturaproveedors=facturaproveedorDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarFacturaProveedor(facturaproveedors);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				FacturaProveedorConstantesFunciones.refrescarForeignKeysDescripcionesFacturaProveedor(this.facturaproveedors);
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
		facturaproveedors = new  ArrayList<FacturaProveedor>();
		  		  
        try {
			FacturaProveedorLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			facturaproveedors=facturaproveedorDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarFacturaProveedor(facturaproveedors);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				FacturaProveedorConstantesFunciones.refrescarForeignKeysDescripcionesFacturaProveedor(this.facturaproveedors);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosFacturaProveedorsWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		facturaproveedors = new  ArrayList<FacturaProveedor>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FacturaProveedor.class.getSimpleName()+"-getTodosFacturaProveedorsWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			FacturaProveedorLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			facturaproveedors=facturaproveedorDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarFacturaProveedor(facturaproveedors);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				FacturaProveedorConstantesFunciones.refrescarForeignKeysDescripcionesFacturaProveedor(this.facturaproveedors);
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
	
	public  void  getTodosFacturaProveedors(String sFinalQuery,Pagination pagination)throws Exception {
		facturaproveedors = new  ArrayList<FacturaProveedor>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			FacturaProveedorLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			facturaproveedors=facturaproveedorDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarFacturaProveedor(facturaproveedors);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				FacturaProveedorConstantesFunciones.refrescarForeignKeysDescripcionesFacturaProveedor(this.facturaproveedors);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarFacturaProveedor(FacturaProveedor facturaproveedor) throws Exception {
		Boolean estaValidado=false;
		
		if(facturaproveedor.getIsNew() || facturaproveedor.getIsChanged()) { 
			this.invalidValues = facturaproveedorValidator.getInvalidValues(facturaproveedor);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(facturaproveedor);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarFacturaProveedor(List<FacturaProveedor> FacturaProveedors) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(FacturaProveedor facturaproveedorLocal:facturaproveedors) {				
			estaValidadoObjeto=this.validarGuardarFacturaProveedor(facturaproveedorLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarFacturaProveedor(List<FacturaProveedor> FacturaProveedors) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarFacturaProveedor(facturaproveedors)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarFacturaProveedor(FacturaProveedor FacturaProveedor) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarFacturaProveedor(facturaproveedor)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(FacturaProveedor facturaproveedor) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+facturaproveedor.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=FacturaProveedorConstantesFunciones.getFacturaProveedorLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"facturaproveedor","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(FacturaProveedorConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(FacturaProveedorConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveFacturaProveedorWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FacturaProveedor.class.getSimpleName()+"-saveFacturaProveedorWithConnection");connexion.begin();			
			
			FacturaProveedorLogicAdditional.checkFacturaProveedorToSave(this.facturaproveedor,this.datosCliente,connexion,this.arrDatoGeneral);
			
			FacturaProveedorLogicAdditional.updateFacturaProveedorToSave(this.facturaproveedor,this.arrDatoGeneral);
			
			FacturaProveedorLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.facturaproveedor,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowFacturaProveedor();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarFacturaProveedor(this.facturaproveedor)) {
				FacturaProveedorDataAccess.save(this.facturaproveedor, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.facturaproveedor,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			FacturaProveedorLogicAdditional.checkFacturaProveedorToSaveAfter(this.facturaproveedor,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowFacturaProveedor();
			
			connexion.commit();			
			
			if(this.facturaproveedor.getIsDeleted()) {
				this.facturaproveedor=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveFacturaProveedor()throws Exception {	
		try {	
			
			FacturaProveedorLogicAdditional.checkFacturaProveedorToSave(this.facturaproveedor,this.datosCliente,connexion,this.arrDatoGeneral);
			
			FacturaProveedorLogicAdditional.updateFacturaProveedorToSave(this.facturaproveedor,this.arrDatoGeneral);
			
			FacturaProveedorLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.facturaproveedor,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarFacturaProveedor(this.facturaproveedor)) {			
				FacturaProveedorDataAccess.save(this.facturaproveedor, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.facturaproveedor,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			FacturaProveedorLogicAdditional.checkFacturaProveedorToSaveAfter(this.facturaproveedor,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.facturaproveedor.getIsDeleted()) {
				this.facturaproveedor=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveFacturaProveedorsWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FacturaProveedor.class.getSimpleName()+"-saveFacturaProveedorsWithConnection");connexion.begin();			
			
			FacturaProveedorLogicAdditional.checkFacturaProveedorToSaves(facturaproveedors,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowFacturaProveedors();
			
			Boolean validadoTodosFacturaProveedor=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(FacturaProveedor facturaproveedorLocal:facturaproveedors) {		
				if(facturaproveedorLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				FacturaProveedorLogicAdditional.updateFacturaProveedorToSave(facturaproveedorLocal,this.arrDatoGeneral);
	        	
				FacturaProveedorLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),facturaproveedorLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarFacturaProveedor(facturaproveedorLocal)) {
					FacturaProveedorDataAccess.save(facturaproveedorLocal, connexion);				
				} else {
					validadoTodosFacturaProveedor=false;
				}
			}
			
			if(!validadoTodosFacturaProveedor) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			FacturaProveedorLogicAdditional.checkFacturaProveedorToSavesAfter(facturaproveedors,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowFacturaProveedors();
			
			connexion.commit();		
			
			this.quitarFacturaProveedorsEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveFacturaProveedors()throws Exception {				
		 try {	
			FacturaProveedorLogicAdditional.checkFacturaProveedorToSaves(facturaproveedors,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosFacturaProveedor=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(FacturaProveedor facturaproveedorLocal:facturaproveedors) {				
				if(facturaproveedorLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				FacturaProveedorLogicAdditional.updateFacturaProveedorToSave(facturaproveedorLocal,this.arrDatoGeneral);
	        	
				FacturaProveedorLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),facturaproveedorLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarFacturaProveedor(facturaproveedorLocal)) {				
					FacturaProveedorDataAccess.save(facturaproveedorLocal, connexion);				
				} else {
					validadoTodosFacturaProveedor=false;
				}
			}
			
			if(!validadoTodosFacturaProveedor) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			FacturaProveedorLogicAdditional.checkFacturaProveedorToSavesAfter(facturaproveedors,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarFacturaProveedorsEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public FacturaProveedorParameterReturnGeneral procesarAccionFacturaProveedors(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<FacturaProveedor> facturaproveedors,FacturaProveedorParameterReturnGeneral facturaproveedorParameterGeneral)throws Exception {
		 try {	
			FacturaProveedorParameterReturnGeneral facturaproveedorReturnGeneral=new FacturaProveedorParameterReturnGeneral();
	
			FacturaProveedorLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,facturaproveedors,facturaproveedorParameterGeneral,facturaproveedorReturnGeneral);
			
			return facturaproveedorReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public FacturaProveedorParameterReturnGeneral procesarAccionFacturaProveedorsWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<FacturaProveedor> facturaproveedors,FacturaProveedorParameterReturnGeneral facturaproveedorParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FacturaProveedor.class.getSimpleName()+"-procesarAccionFacturaProveedorsWithConnection");connexion.begin();			
			
			FacturaProveedorParameterReturnGeneral facturaproveedorReturnGeneral=new FacturaProveedorParameterReturnGeneral();
	
			FacturaProveedorLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,facturaproveedors,facturaproveedorParameterGeneral,facturaproveedorReturnGeneral);
			
			this.connexion.commit();
			
			return facturaproveedorReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public FacturaProveedorParameterReturnGeneral procesarEventosFacturaProveedors(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<FacturaProveedor> facturaproveedors,FacturaProveedor facturaproveedor,FacturaProveedorParameterReturnGeneral facturaproveedorParameterGeneral,Boolean isEsNuevoFacturaProveedor,ArrayList<Classe> clases)throws Exception {
		 try {	
			FacturaProveedorParameterReturnGeneral facturaproveedorReturnGeneral=new FacturaProveedorParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				facturaproveedorReturnGeneral.setConRecargarPropiedades(true);
			}
			
			FacturaProveedorLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,facturaproveedors,facturaproveedor,facturaproveedorParameterGeneral,facturaproveedorReturnGeneral,isEsNuevoFacturaProveedor,clases);
			
			return facturaproveedorReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public FacturaProveedorParameterReturnGeneral procesarEventosFacturaProveedorsWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<FacturaProveedor> facturaproveedors,FacturaProveedor facturaproveedor,FacturaProveedorParameterReturnGeneral facturaproveedorParameterGeneral,Boolean isEsNuevoFacturaProveedor,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FacturaProveedor.class.getSimpleName()+"-procesarEventosFacturaProveedorsWithConnection");connexion.begin();			
			
			FacturaProveedorParameterReturnGeneral facturaproveedorReturnGeneral=new FacturaProveedorParameterReturnGeneral();
	
			facturaproveedorReturnGeneral.setFacturaProveedor(facturaproveedor);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				facturaproveedorReturnGeneral.setConRecargarPropiedades(true);
			}
			
			FacturaProveedorLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,facturaproveedors,facturaproveedor,facturaproveedorParameterGeneral,facturaproveedorReturnGeneral,isEsNuevoFacturaProveedor,clases);
			
			this.connexion.commit();
			
			return facturaproveedorReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public FacturaProveedorParameterReturnGeneral procesarImportacionFacturaProveedorsWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,FacturaProveedorParameterReturnGeneral facturaproveedorParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FacturaProveedor.class.getSimpleName()+"-procesarImportacionFacturaProveedorsWithConnection");connexion.begin();			
			
			FacturaProveedorParameterReturnGeneral facturaproveedorReturnGeneral=new FacturaProveedorParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.facturaproveedors=new ArrayList<FacturaProveedor>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.facturaproveedor=new FacturaProveedor();
				
				
				if(conColumnasBase) {this.facturaproveedor.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.facturaproveedor.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.facturaproveedor.setplazo(Integer.parseInt(arrColumnas[iColumn++]));
				this.facturaproveedor.setnumero_factura(arrColumnas[iColumn++]);
				this.facturaproveedor.setfecha_emision(Funciones.ConvertToDate(arrColumnas[iColumn++]));
				this.facturaproveedor.setruc(arrColumnas[iColumn++]);
				this.facturaproveedor.setfecha_vence(Funciones.ConvertToDate(arrColumnas[iColumn++]));
				this.facturaproveedor.setcon_activos(Boolean.parseBoolean(arrColumnas[iColumn++]));
				this.facturaproveedor.setcon_rise(Boolean.parseBoolean(arrColumnas[iColumn++]));
				this.facturaproveedor.setcon_sitios(Boolean.parseBoolean(arrColumnas[iColumn++]));
				this.facturaproveedor.setdetalle(arrColumnas[iColumn++]);
				this.facturaproveedor.setvalor_bienes12(Double.parseDouble(arrColumnas[iColumn++]));
				this.facturaproveedor.setvalor_servicios12(Double.parseDouble(arrColumnas[iColumn++]));
				this.facturaproveedor.settotal_valor12(Double.parseDouble(arrColumnas[iColumn++]));
				this.facturaproveedor.setvalor_bienes0(Double.parseDouble(arrColumnas[iColumn++]));
				this.facturaproveedor.setvalor_servicios0(Double.parseDouble(arrColumnas[iColumn++]));
				this.facturaproveedor.settotal_valor0(Double.parseDouble(arrColumnas[iColumn++]));
				this.facturaproveedor.setbienes_ice(Double.parseDouble(arrColumnas[iColumn++]));
				this.facturaproveedor.setservicios_ice(Double.parseDouble(arrColumnas[iColumn++]));
				this.facturaproveedor.settotal_ice(Double.parseDouble(arrColumnas[iColumn++]));
				this.facturaproveedor.setbienes_iva(Double.parseDouble(arrColumnas[iColumn++]));
				this.facturaproveedor.setservicios_iva(Double.parseDouble(arrColumnas[iColumn++]));
				this.facturaproveedor.settotal_iva(Double.parseDouble(arrColumnas[iColumn++]));
				this.facturaproveedor.setiva_porcentaje(Double.parseDouble(arrColumnas[iColumn++]));
				this.facturaproveedor.settotal(Double.parseDouble(arrColumnas[iColumn++]));
				this.facturaproveedor.setcon_monto_objeto_iva(Boolean.parseBoolean(arrColumnas[iColumn++]));
				this.facturaproveedor.setnumero_retencion(arrColumnas[iColumn++]);
				this.facturaproveedor.setnumero_serie(arrColumnas[iColumn++]);
				this.facturaproveedor.setnumero_autorizacion(arrColumnas[iColumn++]);
				this.facturaproveedor.setfecha_validez(Funciones.ConvertToDate(arrColumnas[iColumn++]));
				this.facturaproveedor.setret_fuente1_porcentaje(Double.parseDouble(arrColumnas[iColumn++]));
				this.facturaproveedor.setret_fuente1_base(Double.parseDouble(arrColumnas[iColumn++]));
				this.facturaproveedor.setret_fuente1_retenido(Double.parseDouble(arrColumnas[iColumn++]));
				this.facturaproveedor.setret_fuente2_porcentaje(Double.parseDouble(arrColumnas[iColumn++]));
				this.facturaproveedor.setret_fuente2_base(Double.parseDouble(arrColumnas[iColumn++]));
				this.facturaproveedor.setret_fuente2_retenido(Double.parseDouble(arrColumnas[iColumn++]));
				this.facturaproveedor.setret_iva_bien_porcentaje(Double.parseDouble(arrColumnas[iColumn++]));
				this.facturaproveedor.setret_iva_bien_base(Double.parseDouble(arrColumnas[iColumn++]));
				this.facturaproveedor.setret_iva_bien_retenido(Double.parseDouble(arrColumnas[iColumn++]));
				this.facturaproveedor.setret_iva_servicio_porcentaje(Double.parseDouble(arrColumnas[iColumn++]));
				this.facturaproveedor.setret_iva_servicio_base(Double.parseDouble(arrColumnas[iColumn++]));
				this.facturaproveedor.setret_iva_servicio_retenido(Double.parseDouble(arrColumnas[iColumn++]));
				this.facturaproveedor.setanexo_numero_autorizacion(arrColumnas[iColumn++]);
				this.facturaproveedor.setanexo_numeso_serie(arrColumnas[iColumn++]);
				this.facturaproveedor.setanexo_fecha_validez(Funciones.ConvertToDate(arrColumnas[iColumn++]));
				this.facturaproveedor.setanexo_factura_inicio(arrColumnas[iColumn++]);
				this.facturaproveedor.setanexo_factura_fin(arrColumnas[iColumn++]);
				this.facturaproveedor.setsecuencial(arrColumnas[iColumn++]);
				this.facturaproveedor.setgasto_valor(Double.parseDouble(arrColumnas[iColumn++]));
				this.facturaproveedor.setgasto_valor2(Double.parseDouble(arrColumnas[iColumn++]));
				
				this.facturaproveedors.add(this.facturaproveedor);
			}
			
			this.saveFacturaProveedors();
			
			this.connexion.commit();
			
			facturaproveedorReturnGeneral.setConRetornoEstaProcesado(true);
			facturaproveedorReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return facturaproveedorReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarFacturaProveedorsEliminados() throws Exception {				
		
		List<FacturaProveedor> facturaproveedorsAux= new ArrayList<FacturaProveedor>();
		
		for(FacturaProveedor facturaproveedor:facturaproveedors) {
			if(!facturaproveedor.getIsDeleted()) {
				facturaproveedorsAux.add(facturaproveedor);
			}
		}
		
		facturaproveedors=facturaproveedorsAux;
	}
	
	public void quitarFacturaProveedorsNulos() throws Exception {				
		
		List<FacturaProveedor> facturaproveedorsAux= new ArrayList<FacturaProveedor>();
		
		for(FacturaProveedor facturaproveedor : this.facturaproveedors) {
			if(facturaproveedor==null) {
				facturaproveedorsAux.add(facturaproveedor);
			}
		}
		
		//this.facturaproveedors=facturaproveedorsAux;
		
		this.facturaproveedors.removeAll(facturaproveedorsAux);
	}
	
	public void getSetVersionRowFacturaProveedorWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(facturaproveedor.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((facturaproveedor.getIsDeleted() || (facturaproveedor.getIsChanged()&&!facturaproveedor.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=facturaproveedorDataAccess.getSetVersionRowFacturaProveedor(connexion,facturaproveedor.getId());
				
				if(!facturaproveedor.getVersionRow().equals(timestamp)) {	
					facturaproveedor.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				facturaproveedor.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowFacturaProveedor()throws Exception {	
		
		if(facturaproveedor.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((facturaproveedor.getIsDeleted() || (facturaproveedor.getIsChanged()&&!facturaproveedor.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=facturaproveedorDataAccess.getSetVersionRowFacturaProveedor(connexion,facturaproveedor.getId());
			
			try {							
				if(!facturaproveedor.getVersionRow().equals(timestamp)) {	
					facturaproveedor.setVersionRow(timestamp);
				}
				
				facturaproveedor.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowFacturaProveedorsWithConnection()throws Exception {	
		if(facturaproveedors!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(FacturaProveedor facturaproveedorAux:facturaproveedors) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(facturaproveedorAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(facturaproveedorAux.getIsDeleted() || (facturaproveedorAux.getIsChanged()&&!facturaproveedorAux.getIsNew())) {
						
						timestamp=facturaproveedorDataAccess.getSetVersionRowFacturaProveedor(connexion,facturaproveedorAux.getId());
						
						if(!facturaproveedor.getVersionRow().equals(timestamp)) {	
							facturaproveedorAux.setVersionRow(timestamp);
						}
								
						facturaproveedorAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowFacturaProveedors()throws Exception {	
		if(facturaproveedors!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(FacturaProveedor facturaproveedorAux:facturaproveedors) {
					if(facturaproveedorAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(facturaproveedorAux.getIsDeleted() || (facturaproveedorAux.getIsChanged()&&!facturaproveedorAux.getIsNew())) {
						
						timestamp=facturaproveedorDataAccess.getSetVersionRowFacturaProveedor(connexion,facturaproveedorAux.getId());
						
						if(!facturaproveedorAux.getVersionRow().equals(timestamp)) {	
							facturaproveedorAux.setVersionRow(timestamp);
						}
						
													
						facturaproveedorAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public FacturaProveedorParameterReturnGeneral cargarCombosLoteForeignKeyFacturaProveedorWithConnection(String finalQueryGlobalEmpresa,String finalQueryGlobalSucursal,String finalQueryGlobalEjercicio,String finalQueryGlobalPeriodo,String finalQueryGlobalAnio,String finalQueryGlobalMes,String finalQueryGlobalModulo,String finalQueryGlobalPlantillaFactura,String finalQueryGlobalTipoDocumento,String finalQueryGlobalFactura,String finalQueryGlobalTransaccion,String finalQueryGlobalCliente,String finalQueryGlobalEmpleadoSolicita,String finalQueryGlobalMoneda,String finalQueryGlobalEmpleado,String finalQueryGlobalTipoRetencionFuente1,String finalQueryGlobalTipoRetencionFuente2,String finalQueryGlobalTipoRetencionIva1,String finalQueryGlobalTipoRetencionIva2,String finalQueryGlobalTipoTributario,String finalQueryGlobalCuentaContableCreditoFiscalBienes,String finalQueryGlobalResponsableFondo,String finalQueryGlobalCuentaContableCreditoFiscalServicios,String finalQueryGlobalCuentaContableGasto,String finalQueryGlobalCuentaContableGasto2,String finalQueryGlobalCuentaContableCreditoFin,String finalQueryGlobalCuentaContableCreditoFin2,String finalQueryGlobalCuentaContableCredito,String finalQueryGlobalTipoMovimiento,String finalQueryGlobalTipoMovimientoModulo,String finalQueryGlobalTipoTransaccionModulo) throws Exception {
		FacturaProveedorParameterReturnGeneral  facturaproveedorReturnGeneral =new FacturaProveedorParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FacturaProveedor.class.getSimpleName()+"-cargarCombosLoteForeignKeyFacturaProveedorWithConnection");connexion.begin();
			
			facturaproveedorReturnGeneral =new FacturaProveedorParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			facturaproveedorReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Sucursal> sucursalsForeignKey=new ArrayList<Sucursal>();
			SucursalLogic sucursalLogic=new SucursalLogic();
			sucursalLogic.setConnexion(this.connexion);
			//sucursalLogic.getSucursalDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalSucursal.equals("NONE")) {
				sucursalLogic.getTodosSucursals(finalQueryGlobalSucursal,new Pagination());
				sucursalsForeignKey=sucursalLogic.getSucursals();
			}

			facturaproveedorReturnGeneral.setsucursalsForeignKey(sucursalsForeignKey);


			List<Ejercicio> ejerciciosForeignKey=new ArrayList<Ejercicio>();
			EjercicioLogic ejercicioLogic=new EjercicioLogic();
			ejercicioLogic.setConnexion(this.connexion);
			//ejercicioLogic.getEjercicioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEjercicio.equals("NONE")) {
				ejercicioLogic.getTodosEjercicios(finalQueryGlobalEjercicio,new Pagination());
				ejerciciosForeignKey=ejercicioLogic.getEjercicios();
			}

			facturaproveedorReturnGeneral.setejerciciosForeignKey(ejerciciosForeignKey);


			List<Periodo> periodosForeignKey=new ArrayList<Periodo>();
			PeriodoLogic periodoLogic=new PeriodoLogic();
			periodoLogic.setConnexion(this.connexion);
			//periodoLogic.getPeriodoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalPeriodo.equals("NONE")) {
				periodoLogic.getTodosPeriodos(finalQueryGlobalPeriodo,new Pagination());
				periodosForeignKey=periodoLogic.getPeriodos();
			}

			facturaproveedorReturnGeneral.setperiodosForeignKey(periodosForeignKey);


			List<Anio> aniosForeignKey=new ArrayList<Anio>();
			AnioLogic anioLogic=new AnioLogic();
			anioLogic.setConnexion(this.connexion);
			anioLogic.getAnioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalAnio.equals("NONE")) {
				anioLogic.getTodosAnios(finalQueryGlobalAnio,new Pagination());
				aniosForeignKey=anioLogic.getAnios();
			}

			facturaproveedorReturnGeneral.setaniosForeignKey(aniosForeignKey);


			List<Mes> messForeignKey=new ArrayList<Mes>();
			MesLogic mesLogic=new MesLogic();
			mesLogic.setConnexion(this.connexion);
			mesLogic.getMesDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalMes.equals("NONE")) {
				mesLogic.getTodosMess(finalQueryGlobalMes,new Pagination());
				messForeignKey=mesLogic.getMess();
			}

			facturaproveedorReturnGeneral.setmessForeignKey(messForeignKey);


			List<Modulo> modulosForeignKey=new ArrayList<Modulo>();
			ModuloLogic moduloLogic=new ModuloLogic();
			moduloLogic.setConnexion(this.connexion);
			moduloLogic.getModuloDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalModulo.equals("NONE")) {
				moduloLogic.getTodosModulos(finalQueryGlobalModulo,new Pagination());
				modulosForeignKey=moduloLogic.getModulos();
			}

			facturaproveedorReturnGeneral.setmodulosForeignKey(modulosForeignKey);


			List<PlantillaFactura> plantillafacturasForeignKey=new ArrayList<PlantillaFactura>();
			PlantillaFacturaLogic plantillafacturaLogic=new PlantillaFacturaLogic();
			plantillafacturaLogic.setConnexion(this.connexion);
			plantillafacturaLogic.getPlantillaFacturaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalPlantillaFactura.equals("NONE")) {
				plantillafacturaLogic.getTodosPlantillaFacturas(finalQueryGlobalPlantillaFactura,new Pagination());
				plantillafacturasForeignKey=plantillafacturaLogic.getPlantillaFacturas();
			}

			facturaproveedorReturnGeneral.setplantillafacturasForeignKey(plantillafacturasForeignKey);


			List<TipoDocumento> tipodocumentosForeignKey=new ArrayList<TipoDocumento>();
			TipoDocumentoLogic tipodocumentoLogic=new TipoDocumentoLogic();
			tipodocumentoLogic.setConnexion(this.connexion);
			tipodocumentoLogic.getTipoDocumentoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoDocumento.equals("NONE")) {
				tipodocumentoLogic.getTodosTipoDocumentos(finalQueryGlobalTipoDocumento,new Pagination());
				tipodocumentosForeignKey=tipodocumentoLogic.getTipoDocumentos();
			}

			facturaproveedorReturnGeneral.settipodocumentosForeignKey(tipodocumentosForeignKey);


			List<Factura> facturasForeignKey=new ArrayList<Factura>();
			FacturaLogic facturaLogic=new FacturaLogic();
			facturaLogic.setConnexion(this.connexion);
			facturaLogic.getFacturaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalFactura.equals("NONE")) {
				facturaLogic.getTodosFacturas(finalQueryGlobalFactura,new Pagination());
				facturasForeignKey=facturaLogic.getFacturas();
			}

			facturaproveedorReturnGeneral.setfacturasForeignKey(facturasForeignKey);


			List<Transaccion> transaccionsForeignKey=new ArrayList<Transaccion>();
			TransaccionLogic transaccionLogic=new TransaccionLogic();
			transaccionLogic.setConnexion(this.connexion);
			transaccionLogic.getTransaccionDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTransaccion.equals("NONE")) {
				transaccionLogic.getTodosTransaccions(finalQueryGlobalTransaccion,new Pagination());
				transaccionsForeignKey=transaccionLogic.getTransaccions();
			}

			facturaproveedorReturnGeneral.settransaccionsForeignKey(transaccionsForeignKey);


			List<Cliente> clientesForeignKey=new ArrayList<Cliente>();
			ClienteLogic clienteLogic=new ClienteLogic();
			clienteLogic.setConnexion(this.connexion);
			clienteLogic.getClienteDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCliente.equals("NONE")) {
				clienteLogic.getTodosClientes(finalQueryGlobalCliente,new Pagination());
				clientesForeignKey=clienteLogic.getClientes();
			}

			facturaproveedorReturnGeneral.setclientesForeignKey(clientesForeignKey);


			List<Empleado> empleadosolicitasForeignKey=new ArrayList<Empleado>();
			EmpleadoLogic empleadosolicitaLogic=new EmpleadoLogic();
			empleadosolicitaLogic.setConnexion(this.connexion);
			empleadosolicitaLogic.getEmpleadoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpleadoSolicita.equals("NONE")) {
				empleadosolicitaLogic.getTodosEmpleados(finalQueryGlobalEmpleadoSolicita,new Pagination());
				empleadosolicitasForeignKey=empleadosolicitaLogic.getEmpleados();
			}

			facturaproveedorReturnGeneral.setempleadosolicitasForeignKey(empleadosolicitasForeignKey);


			List<Moneda> monedasForeignKey=new ArrayList<Moneda>();
			MonedaLogic monedaLogic=new MonedaLogic();
			monedaLogic.setConnexion(this.connexion);
			//monedaLogic.getMonedaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalMoneda.equals("NONE")) {
				monedaLogic.getTodosMonedas(finalQueryGlobalMoneda,new Pagination());
				monedasForeignKey=monedaLogic.getMonedas();
			}

			facturaproveedorReturnGeneral.setmonedasForeignKey(monedasForeignKey);


			List<Empleado> empleadosForeignKey=new ArrayList<Empleado>();
			EmpleadoLogic empleadoLogic=new EmpleadoLogic();
			empleadoLogic.setConnexion(this.connexion);
			empleadoLogic.getEmpleadoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpleado.equals("NONE")) {
				empleadoLogic.getTodosEmpleados(finalQueryGlobalEmpleado,new Pagination());
				empleadosForeignKey=empleadoLogic.getEmpleados();
			}

			facturaproveedorReturnGeneral.setempleadosForeignKey(empleadosForeignKey);


			List<TipoRetencion> tiporetencionfuente1sForeignKey=new ArrayList<TipoRetencion>();
			TipoRetencionLogic tiporetencionfuente1Logic=new TipoRetencionLogic();
			tiporetencionfuente1Logic.setConnexion(this.connexion);
			tiporetencionfuente1Logic.getTipoRetencionDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoRetencionFuente1.equals("NONE")) {
				tiporetencionfuente1Logic.getTodosTipoRetencions(finalQueryGlobalTipoRetencionFuente1,new Pagination());
				tiporetencionfuente1sForeignKey=tiporetencionfuente1Logic.getTipoRetencions();
			}

			facturaproveedorReturnGeneral.settiporetencionfuente1sForeignKey(tiporetencionfuente1sForeignKey);


			List<TipoRetencion> tiporetencionfuente2sForeignKey=new ArrayList<TipoRetencion>();
			TipoRetencionLogic tiporetencionfuente2Logic=new TipoRetencionLogic();
			tiporetencionfuente2Logic.setConnexion(this.connexion);
			tiporetencionfuente2Logic.getTipoRetencionDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoRetencionFuente2.equals("NONE")) {
				tiporetencionfuente2Logic.getTodosTipoRetencions(finalQueryGlobalTipoRetencionFuente2,new Pagination());
				tiporetencionfuente2sForeignKey=tiporetencionfuente2Logic.getTipoRetencions();
			}

			facturaproveedorReturnGeneral.settiporetencionfuente2sForeignKey(tiporetencionfuente2sForeignKey);


			List<TipoRetencion> tiporetencioniva1sForeignKey=new ArrayList<TipoRetencion>();
			TipoRetencionLogic tiporetencioniva1Logic=new TipoRetencionLogic();
			tiporetencioniva1Logic.setConnexion(this.connexion);
			tiporetencioniva1Logic.getTipoRetencionDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoRetencionIva1.equals("NONE")) {
				tiporetencioniva1Logic.getTodosTipoRetencions(finalQueryGlobalTipoRetencionIva1,new Pagination());
				tiporetencioniva1sForeignKey=tiporetencioniva1Logic.getTipoRetencions();
			}

			facturaproveedorReturnGeneral.settiporetencioniva1sForeignKey(tiporetencioniva1sForeignKey);


			List<TipoRetencion> tiporetencioniva2sForeignKey=new ArrayList<TipoRetencion>();
			TipoRetencionLogic tiporetencioniva2Logic=new TipoRetencionLogic();
			tiporetencioniva2Logic.setConnexion(this.connexion);
			tiporetencioniva2Logic.getTipoRetencionDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoRetencionIva2.equals("NONE")) {
				tiporetencioniva2Logic.getTodosTipoRetencions(finalQueryGlobalTipoRetencionIva2,new Pagination());
				tiporetencioniva2sForeignKey=tiporetencioniva2Logic.getTipoRetencions();
			}

			facturaproveedorReturnGeneral.settiporetencioniva2sForeignKey(tiporetencioniva2sForeignKey);


			List<TipoTributario> tipotributariosForeignKey=new ArrayList<TipoTributario>();
			TipoTributarioLogic tipotributarioLogic=new TipoTributarioLogic();
			tipotributarioLogic.setConnexion(this.connexion);
			tipotributarioLogic.getTipoTributarioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoTributario.equals("NONE")) {
				tipotributarioLogic.getTodosTipoTributarios(finalQueryGlobalTipoTributario,new Pagination());
				tipotributariosForeignKey=tipotributarioLogic.getTipoTributarios();
			}

			facturaproveedorReturnGeneral.settipotributariosForeignKey(tipotributariosForeignKey);


			List<CuentaContable> cuentacontablecreditofiscalbienessForeignKey=new ArrayList<CuentaContable>();
			CuentaContableLogic cuentacontablecreditofiscalbienesLogic=new CuentaContableLogic();
			cuentacontablecreditofiscalbienesLogic.setConnexion(this.connexion);
			cuentacontablecreditofiscalbienesLogic.getCuentaContableDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCuentaContableCreditoFiscalBienes.equals("NONE")) {
				cuentacontablecreditofiscalbienesLogic.getTodosCuentaContables(finalQueryGlobalCuentaContableCreditoFiscalBienes,new Pagination());
				cuentacontablecreditofiscalbienessForeignKey=cuentacontablecreditofiscalbienesLogic.getCuentaContables();
			}

			facturaproveedorReturnGeneral.setcuentacontablecreditofiscalbienessForeignKey(cuentacontablecreditofiscalbienessForeignKey);


			List<ResponsableFondo> responsablefondosForeignKey=new ArrayList<ResponsableFondo>();
			ResponsableFondoLogic responsablefondoLogic=new ResponsableFondoLogic();
			responsablefondoLogic.setConnexion(this.connexion);
			responsablefondoLogic.getResponsableFondoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalResponsableFondo.equals("NONE")) {
				responsablefondoLogic.getTodosResponsableFondos(finalQueryGlobalResponsableFondo,new Pagination());
				responsablefondosForeignKey=responsablefondoLogic.getResponsableFondos();
			}

			facturaproveedorReturnGeneral.setresponsablefondosForeignKey(responsablefondosForeignKey);


			List<CuentaContable> cuentacontablecreditofiscalserviciossForeignKey=new ArrayList<CuentaContable>();
			CuentaContableLogic cuentacontablecreditofiscalserviciosLogic=new CuentaContableLogic();
			cuentacontablecreditofiscalserviciosLogic.setConnexion(this.connexion);
			cuentacontablecreditofiscalserviciosLogic.getCuentaContableDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCuentaContableCreditoFiscalServicios.equals("NONE")) {
				cuentacontablecreditofiscalserviciosLogic.getTodosCuentaContables(finalQueryGlobalCuentaContableCreditoFiscalServicios,new Pagination());
				cuentacontablecreditofiscalserviciossForeignKey=cuentacontablecreditofiscalserviciosLogic.getCuentaContables();
			}

			facturaproveedorReturnGeneral.setcuentacontablecreditofiscalserviciossForeignKey(cuentacontablecreditofiscalserviciossForeignKey);


			List<CuentaContable> cuentacontablegastosForeignKey=new ArrayList<CuentaContable>();
			CuentaContableLogic cuentacontablegastoLogic=new CuentaContableLogic();
			cuentacontablegastoLogic.setConnexion(this.connexion);
			cuentacontablegastoLogic.getCuentaContableDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCuentaContableGasto.equals("NONE")) {
				cuentacontablegastoLogic.getTodosCuentaContables(finalQueryGlobalCuentaContableGasto,new Pagination());
				cuentacontablegastosForeignKey=cuentacontablegastoLogic.getCuentaContables();
			}

			facturaproveedorReturnGeneral.setcuentacontablegastosForeignKey(cuentacontablegastosForeignKey);


			List<CuentaContable> cuentacontablegasto2sForeignKey=new ArrayList<CuentaContable>();
			CuentaContableLogic cuentacontablegasto2Logic=new CuentaContableLogic();
			cuentacontablegasto2Logic.setConnexion(this.connexion);
			cuentacontablegasto2Logic.getCuentaContableDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCuentaContableGasto2.equals("NONE")) {
				cuentacontablegasto2Logic.getTodosCuentaContables(finalQueryGlobalCuentaContableGasto2,new Pagination());
				cuentacontablegasto2sForeignKey=cuentacontablegasto2Logic.getCuentaContables();
			}

			facturaproveedorReturnGeneral.setcuentacontablegasto2sForeignKey(cuentacontablegasto2sForeignKey);


			List<CuentaContable> cuentacontablecreditofinsForeignKey=new ArrayList<CuentaContable>();
			CuentaContableLogic cuentacontablecreditofinLogic=new CuentaContableLogic();
			cuentacontablecreditofinLogic.setConnexion(this.connexion);
			cuentacontablecreditofinLogic.getCuentaContableDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCuentaContableCreditoFin.equals("NONE")) {
				cuentacontablecreditofinLogic.getTodosCuentaContables(finalQueryGlobalCuentaContableCreditoFin,new Pagination());
				cuentacontablecreditofinsForeignKey=cuentacontablecreditofinLogic.getCuentaContables();
			}

			facturaproveedorReturnGeneral.setcuentacontablecreditofinsForeignKey(cuentacontablecreditofinsForeignKey);


			List<CuentaContable> cuentacontablecreditofin2sForeignKey=new ArrayList<CuentaContable>();
			CuentaContableLogic cuentacontablecreditofin2Logic=new CuentaContableLogic();
			cuentacontablecreditofin2Logic.setConnexion(this.connexion);
			cuentacontablecreditofin2Logic.getCuentaContableDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCuentaContableCreditoFin2.equals("NONE")) {
				cuentacontablecreditofin2Logic.getTodosCuentaContables(finalQueryGlobalCuentaContableCreditoFin2,new Pagination());
				cuentacontablecreditofin2sForeignKey=cuentacontablecreditofin2Logic.getCuentaContables();
			}

			facturaproveedorReturnGeneral.setcuentacontablecreditofin2sForeignKey(cuentacontablecreditofin2sForeignKey);


			List<CuentaContable> cuentacontablecreditosForeignKey=new ArrayList<CuentaContable>();
			CuentaContableLogic cuentacontablecreditoLogic=new CuentaContableLogic();
			cuentacontablecreditoLogic.setConnexion(this.connexion);
			cuentacontablecreditoLogic.getCuentaContableDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCuentaContableCredito.equals("NONE")) {
				cuentacontablecreditoLogic.getTodosCuentaContables(finalQueryGlobalCuentaContableCredito,new Pagination());
				cuentacontablecreditosForeignKey=cuentacontablecreditoLogic.getCuentaContables();
			}

			facturaproveedorReturnGeneral.setcuentacontablecreditosForeignKey(cuentacontablecreditosForeignKey);


			List<TipoMovimiento> tipomovimientosForeignKey=new ArrayList<TipoMovimiento>();
			TipoMovimientoLogic tipomovimientoLogic=new TipoMovimientoLogic();
			tipomovimientoLogic.setConnexion(this.connexion);
			tipomovimientoLogic.getTipoMovimientoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoMovimiento.equals("NONE")) {
				tipomovimientoLogic.getTodosTipoMovimientos(finalQueryGlobalTipoMovimiento,new Pagination());
				tipomovimientosForeignKey=tipomovimientoLogic.getTipoMovimientos();
			}

			facturaproveedorReturnGeneral.settipomovimientosForeignKey(tipomovimientosForeignKey);


			List<TipoMovimientoModulo> tipomovimientomodulosForeignKey=new ArrayList<TipoMovimientoModulo>();
			TipoMovimientoModuloLogic tipomovimientomoduloLogic=new TipoMovimientoModuloLogic();
			tipomovimientomoduloLogic.setConnexion(this.connexion);
			tipomovimientomoduloLogic.getTipoMovimientoModuloDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoMovimientoModulo.equals("NONE")) {
				tipomovimientomoduloLogic.getTodosTipoMovimientoModulos(finalQueryGlobalTipoMovimientoModulo,new Pagination());
				tipomovimientomodulosForeignKey=tipomovimientomoduloLogic.getTipoMovimientoModulos();
			}

			facturaproveedorReturnGeneral.settipomovimientomodulosForeignKey(tipomovimientomodulosForeignKey);


			List<TipoTransaccionModulo> tipotransaccionmodulosForeignKey=new ArrayList<TipoTransaccionModulo>();
			TipoTransaccionModuloLogic tipotransaccionmoduloLogic=new TipoTransaccionModuloLogic();
			tipotransaccionmoduloLogic.setConnexion(this.connexion);
			tipotransaccionmoduloLogic.getTipoTransaccionModuloDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoTransaccionModulo.equals("NONE")) {
				tipotransaccionmoduloLogic.getTodosTipoTransaccionModulos(finalQueryGlobalTipoTransaccionModulo,new Pagination());
				tipotransaccionmodulosForeignKey=tipotransaccionmoduloLogic.getTipoTransaccionModulos();
			}

			facturaproveedorReturnGeneral.settipotransaccionmodulosForeignKey(tipotransaccionmodulosForeignKey);

			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
		
		return facturaproveedorReturnGeneral;
	}
	
	public FacturaProveedorParameterReturnGeneral cargarCombosLoteForeignKeyFacturaProveedor(String finalQueryGlobalEmpresa,String finalQueryGlobalSucursal,String finalQueryGlobalEjercicio,String finalQueryGlobalPeriodo,String finalQueryGlobalAnio,String finalQueryGlobalMes,String finalQueryGlobalModulo,String finalQueryGlobalPlantillaFactura,String finalQueryGlobalTipoDocumento,String finalQueryGlobalFactura,String finalQueryGlobalTransaccion,String finalQueryGlobalCliente,String finalQueryGlobalEmpleadoSolicita,String finalQueryGlobalMoneda,String finalQueryGlobalEmpleado,String finalQueryGlobalTipoRetencionFuente1,String finalQueryGlobalTipoRetencionFuente2,String finalQueryGlobalTipoRetencionIva1,String finalQueryGlobalTipoRetencionIva2,String finalQueryGlobalTipoTributario,String finalQueryGlobalCuentaContableCreditoFiscalBienes,String finalQueryGlobalResponsableFondo,String finalQueryGlobalCuentaContableCreditoFiscalServicios,String finalQueryGlobalCuentaContableGasto,String finalQueryGlobalCuentaContableGasto2,String finalQueryGlobalCuentaContableCreditoFin,String finalQueryGlobalCuentaContableCreditoFin2,String finalQueryGlobalCuentaContableCredito,String finalQueryGlobalTipoMovimiento,String finalQueryGlobalTipoMovimientoModulo,String finalQueryGlobalTipoTransaccionModulo) throws Exception {
		FacturaProveedorParameterReturnGeneral  facturaproveedorReturnGeneral =new FacturaProveedorParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {						
			facturaproveedorReturnGeneral =new FacturaProveedorParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			facturaproveedorReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Sucursal> sucursalsForeignKey=new ArrayList<Sucursal>();
			SucursalLogic sucursalLogic=new SucursalLogic();
			sucursalLogic.setConnexion(this.connexion);
			//sucursalLogic.getSucursalDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalSucursal.equals("NONE")) {
				sucursalLogic.getTodosSucursals(finalQueryGlobalSucursal,new Pagination());
				sucursalsForeignKey=sucursalLogic.getSucursals();
			}

			facturaproveedorReturnGeneral.setsucursalsForeignKey(sucursalsForeignKey);


			List<Ejercicio> ejerciciosForeignKey=new ArrayList<Ejercicio>();
			EjercicioLogic ejercicioLogic=new EjercicioLogic();
			ejercicioLogic.setConnexion(this.connexion);
			//ejercicioLogic.getEjercicioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEjercicio.equals("NONE")) {
				ejercicioLogic.getTodosEjercicios(finalQueryGlobalEjercicio,new Pagination());
				ejerciciosForeignKey=ejercicioLogic.getEjercicios();
			}

			facturaproveedorReturnGeneral.setejerciciosForeignKey(ejerciciosForeignKey);


			List<Periodo> periodosForeignKey=new ArrayList<Periodo>();
			PeriodoLogic periodoLogic=new PeriodoLogic();
			periodoLogic.setConnexion(this.connexion);
			//periodoLogic.getPeriodoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalPeriodo.equals("NONE")) {
				periodoLogic.getTodosPeriodos(finalQueryGlobalPeriodo,new Pagination());
				periodosForeignKey=periodoLogic.getPeriodos();
			}

			facturaproveedorReturnGeneral.setperiodosForeignKey(periodosForeignKey);


			List<Anio> aniosForeignKey=new ArrayList<Anio>();
			AnioLogic anioLogic=new AnioLogic();
			anioLogic.setConnexion(this.connexion);
			anioLogic.getAnioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalAnio.equals("NONE")) {
				anioLogic.getTodosAnios(finalQueryGlobalAnio,new Pagination());
				aniosForeignKey=anioLogic.getAnios();
			}

			facturaproveedorReturnGeneral.setaniosForeignKey(aniosForeignKey);


			List<Mes> messForeignKey=new ArrayList<Mes>();
			MesLogic mesLogic=new MesLogic();
			mesLogic.setConnexion(this.connexion);
			mesLogic.getMesDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalMes.equals("NONE")) {
				mesLogic.getTodosMess(finalQueryGlobalMes,new Pagination());
				messForeignKey=mesLogic.getMess();
			}

			facturaproveedorReturnGeneral.setmessForeignKey(messForeignKey);


			List<Modulo> modulosForeignKey=new ArrayList<Modulo>();
			ModuloLogic moduloLogic=new ModuloLogic();
			moduloLogic.setConnexion(this.connexion);
			moduloLogic.getModuloDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalModulo.equals("NONE")) {
				moduloLogic.getTodosModulos(finalQueryGlobalModulo,new Pagination());
				modulosForeignKey=moduloLogic.getModulos();
			}

			facturaproveedorReturnGeneral.setmodulosForeignKey(modulosForeignKey);


			List<PlantillaFactura> plantillafacturasForeignKey=new ArrayList<PlantillaFactura>();
			PlantillaFacturaLogic plantillafacturaLogic=new PlantillaFacturaLogic();
			plantillafacturaLogic.setConnexion(this.connexion);
			plantillafacturaLogic.getPlantillaFacturaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalPlantillaFactura.equals("NONE")) {
				plantillafacturaLogic.getTodosPlantillaFacturas(finalQueryGlobalPlantillaFactura,new Pagination());
				plantillafacturasForeignKey=plantillafacturaLogic.getPlantillaFacturas();
			}

			facturaproveedorReturnGeneral.setplantillafacturasForeignKey(plantillafacturasForeignKey);


			List<TipoDocumento> tipodocumentosForeignKey=new ArrayList<TipoDocumento>();
			TipoDocumentoLogic tipodocumentoLogic=new TipoDocumentoLogic();
			tipodocumentoLogic.setConnexion(this.connexion);
			tipodocumentoLogic.getTipoDocumentoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoDocumento.equals("NONE")) {
				tipodocumentoLogic.getTodosTipoDocumentos(finalQueryGlobalTipoDocumento,new Pagination());
				tipodocumentosForeignKey=tipodocumentoLogic.getTipoDocumentos();
			}

			facturaproveedorReturnGeneral.settipodocumentosForeignKey(tipodocumentosForeignKey);


			List<Factura> facturasForeignKey=new ArrayList<Factura>();
			FacturaLogic facturaLogic=new FacturaLogic();
			facturaLogic.setConnexion(this.connexion);
			facturaLogic.getFacturaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalFactura.equals("NONE")) {
				facturaLogic.getTodosFacturas(finalQueryGlobalFactura,new Pagination());
				facturasForeignKey=facturaLogic.getFacturas();
			}

			facturaproveedorReturnGeneral.setfacturasForeignKey(facturasForeignKey);


			List<Transaccion> transaccionsForeignKey=new ArrayList<Transaccion>();
			TransaccionLogic transaccionLogic=new TransaccionLogic();
			transaccionLogic.setConnexion(this.connexion);
			transaccionLogic.getTransaccionDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTransaccion.equals("NONE")) {
				transaccionLogic.getTodosTransaccions(finalQueryGlobalTransaccion,new Pagination());
				transaccionsForeignKey=transaccionLogic.getTransaccions();
			}

			facturaproveedorReturnGeneral.settransaccionsForeignKey(transaccionsForeignKey);


			List<Cliente> clientesForeignKey=new ArrayList<Cliente>();
			ClienteLogic clienteLogic=new ClienteLogic();
			clienteLogic.setConnexion(this.connexion);
			clienteLogic.getClienteDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCliente.equals("NONE")) {
				clienteLogic.getTodosClientes(finalQueryGlobalCliente,new Pagination());
				clientesForeignKey=clienteLogic.getClientes();
			}

			facturaproveedorReturnGeneral.setclientesForeignKey(clientesForeignKey);


			List<Empleado> empleadosolicitasForeignKey=new ArrayList<Empleado>();
			EmpleadoLogic empleadosolicitaLogic=new EmpleadoLogic();
			empleadosolicitaLogic.setConnexion(this.connexion);
			empleadosolicitaLogic.getEmpleadoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpleadoSolicita.equals("NONE")) {
				empleadosolicitaLogic.getTodosEmpleados(finalQueryGlobalEmpleadoSolicita,new Pagination());
				empleadosolicitasForeignKey=empleadosolicitaLogic.getEmpleados();
			}

			facturaproveedorReturnGeneral.setempleadosolicitasForeignKey(empleadosolicitasForeignKey);


			List<Moneda> monedasForeignKey=new ArrayList<Moneda>();
			MonedaLogic monedaLogic=new MonedaLogic();
			monedaLogic.setConnexion(this.connexion);
			//monedaLogic.getMonedaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalMoneda.equals("NONE")) {
				monedaLogic.getTodosMonedas(finalQueryGlobalMoneda,new Pagination());
				monedasForeignKey=monedaLogic.getMonedas();
			}

			facturaproveedorReturnGeneral.setmonedasForeignKey(monedasForeignKey);


			List<Empleado> empleadosForeignKey=new ArrayList<Empleado>();
			EmpleadoLogic empleadoLogic=new EmpleadoLogic();
			empleadoLogic.setConnexion(this.connexion);
			empleadoLogic.getEmpleadoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpleado.equals("NONE")) {
				empleadoLogic.getTodosEmpleados(finalQueryGlobalEmpleado,new Pagination());
				empleadosForeignKey=empleadoLogic.getEmpleados();
			}

			facturaproveedorReturnGeneral.setempleadosForeignKey(empleadosForeignKey);


			List<TipoRetencion> tiporetencionfuente1sForeignKey=new ArrayList<TipoRetencion>();
			TipoRetencionLogic tiporetencionfuente1Logic=new TipoRetencionLogic();
			tiporetencionfuente1Logic.setConnexion(this.connexion);
			tiporetencionfuente1Logic.getTipoRetencionDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoRetencionFuente1.equals("NONE")) {
				tiporetencionfuente1Logic.getTodosTipoRetencions(finalQueryGlobalTipoRetencionFuente1,new Pagination());
				tiporetencionfuente1sForeignKey=tiporetencionfuente1Logic.getTipoRetencions();
			}

			facturaproveedorReturnGeneral.settiporetencionfuente1sForeignKey(tiporetencionfuente1sForeignKey);


			List<TipoRetencion> tiporetencionfuente2sForeignKey=new ArrayList<TipoRetencion>();
			TipoRetencionLogic tiporetencionfuente2Logic=new TipoRetencionLogic();
			tiporetencionfuente2Logic.setConnexion(this.connexion);
			tiporetencionfuente2Logic.getTipoRetencionDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoRetencionFuente2.equals("NONE")) {
				tiporetencionfuente2Logic.getTodosTipoRetencions(finalQueryGlobalTipoRetencionFuente2,new Pagination());
				tiporetencionfuente2sForeignKey=tiporetencionfuente2Logic.getTipoRetencions();
			}

			facturaproveedorReturnGeneral.settiporetencionfuente2sForeignKey(tiporetencionfuente2sForeignKey);


			List<TipoRetencion> tiporetencioniva1sForeignKey=new ArrayList<TipoRetencion>();
			TipoRetencionLogic tiporetencioniva1Logic=new TipoRetencionLogic();
			tiporetencioniva1Logic.setConnexion(this.connexion);
			tiporetencioniva1Logic.getTipoRetencionDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoRetencionIva1.equals("NONE")) {
				tiporetencioniva1Logic.getTodosTipoRetencions(finalQueryGlobalTipoRetencionIva1,new Pagination());
				tiporetencioniva1sForeignKey=tiporetencioniva1Logic.getTipoRetencions();
			}

			facturaproveedorReturnGeneral.settiporetencioniva1sForeignKey(tiporetencioniva1sForeignKey);


			List<TipoRetencion> tiporetencioniva2sForeignKey=new ArrayList<TipoRetencion>();
			TipoRetencionLogic tiporetencioniva2Logic=new TipoRetencionLogic();
			tiporetencioniva2Logic.setConnexion(this.connexion);
			tiporetencioniva2Logic.getTipoRetencionDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoRetencionIva2.equals("NONE")) {
				tiporetencioniva2Logic.getTodosTipoRetencions(finalQueryGlobalTipoRetencionIva2,new Pagination());
				tiporetencioniva2sForeignKey=tiporetencioniva2Logic.getTipoRetencions();
			}

			facturaproveedorReturnGeneral.settiporetencioniva2sForeignKey(tiporetencioniva2sForeignKey);


			List<TipoTributario> tipotributariosForeignKey=new ArrayList<TipoTributario>();
			TipoTributarioLogic tipotributarioLogic=new TipoTributarioLogic();
			tipotributarioLogic.setConnexion(this.connexion);
			tipotributarioLogic.getTipoTributarioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoTributario.equals("NONE")) {
				tipotributarioLogic.getTodosTipoTributarios(finalQueryGlobalTipoTributario,new Pagination());
				tipotributariosForeignKey=tipotributarioLogic.getTipoTributarios();
			}

			facturaproveedorReturnGeneral.settipotributariosForeignKey(tipotributariosForeignKey);


			List<CuentaContable> cuentacontablecreditofiscalbienessForeignKey=new ArrayList<CuentaContable>();
			CuentaContableLogic cuentacontablecreditofiscalbienesLogic=new CuentaContableLogic();
			cuentacontablecreditofiscalbienesLogic.setConnexion(this.connexion);
			cuentacontablecreditofiscalbienesLogic.getCuentaContableDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCuentaContableCreditoFiscalBienes.equals("NONE")) {
				cuentacontablecreditofiscalbienesLogic.getTodosCuentaContables(finalQueryGlobalCuentaContableCreditoFiscalBienes,new Pagination());
				cuentacontablecreditofiscalbienessForeignKey=cuentacontablecreditofiscalbienesLogic.getCuentaContables();
			}

			facturaproveedorReturnGeneral.setcuentacontablecreditofiscalbienessForeignKey(cuentacontablecreditofiscalbienessForeignKey);


			List<ResponsableFondo> responsablefondosForeignKey=new ArrayList<ResponsableFondo>();
			ResponsableFondoLogic responsablefondoLogic=new ResponsableFondoLogic();
			responsablefondoLogic.setConnexion(this.connexion);
			responsablefondoLogic.getResponsableFondoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalResponsableFondo.equals("NONE")) {
				responsablefondoLogic.getTodosResponsableFondos(finalQueryGlobalResponsableFondo,new Pagination());
				responsablefondosForeignKey=responsablefondoLogic.getResponsableFondos();
			}

			facturaproveedorReturnGeneral.setresponsablefondosForeignKey(responsablefondosForeignKey);


			List<CuentaContable> cuentacontablecreditofiscalserviciossForeignKey=new ArrayList<CuentaContable>();
			CuentaContableLogic cuentacontablecreditofiscalserviciosLogic=new CuentaContableLogic();
			cuentacontablecreditofiscalserviciosLogic.setConnexion(this.connexion);
			cuentacontablecreditofiscalserviciosLogic.getCuentaContableDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCuentaContableCreditoFiscalServicios.equals("NONE")) {
				cuentacontablecreditofiscalserviciosLogic.getTodosCuentaContables(finalQueryGlobalCuentaContableCreditoFiscalServicios,new Pagination());
				cuentacontablecreditofiscalserviciossForeignKey=cuentacontablecreditofiscalserviciosLogic.getCuentaContables();
			}

			facturaproveedorReturnGeneral.setcuentacontablecreditofiscalserviciossForeignKey(cuentacontablecreditofiscalserviciossForeignKey);


			List<CuentaContable> cuentacontablegastosForeignKey=new ArrayList<CuentaContable>();
			CuentaContableLogic cuentacontablegastoLogic=new CuentaContableLogic();
			cuentacontablegastoLogic.setConnexion(this.connexion);
			cuentacontablegastoLogic.getCuentaContableDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCuentaContableGasto.equals("NONE")) {
				cuentacontablegastoLogic.getTodosCuentaContables(finalQueryGlobalCuentaContableGasto,new Pagination());
				cuentacontablegastosForeignKey=cuentacontablegastoLogic.getCuentaContables();
			}

			facturaproveedorReturnGeneral.setcuentacontablegastosForeignKey(cuentacontablegastosForeignKey);


			List<CuentaContable> cuentacontablegasto2sForeignKey=new ArrayList<CuentaContable>();
			CuentaContableLogic cuentacontablegasto2Logic=new CuentaContableLogic();
			cuentacontablegasto2Logic.setConnexion(this.connexion);
			cuentacontablegasto2Logic.getCuentaContableDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCuentaContableGasto2.equals("NONE")) {
				cuentacontablegasto2Logic.getTodosCuentaContables(finalQueryGlobalCuentaContableGasto2,new Pagination());
				cuentacontablegasto2sForeignKey=cuentacontablegasto2Logic.getCuentaContables();
			}

			facturaproveedorReturnGeneral.setcuentacontablegasto2sForeignKey(cuentacontablegasto2sForeignKey);


			List<CuentaContable> cuentacontablecreditofinsForeignKey=new ArrayList<CuentaContable>();
			CuentaContableLogic cuentacontablecreditofinLogic=new CuentaContableLogic();
			cuentacontablecreditofinLogic.setConnexion(this.connexion);
			cuentacontablecreditofinLogic.getCuentaContableDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCuentaContableCreditoFin.equals("NONE")) {
				cuentacontablecreditofinLogic.getTodosCuentaContables(finalQueryGlobalCuentaContableCreditoFin,new Pagination());
				cuentacontablecreditofinsForeignKey=cuentacontablecreditofinLogic.getCuentaContables();
			}

			facturaproveedorReturnGeneral.setcuentacontablecreditofinsForeignKey(cuentacontablecreditofinsForeignKey);


			List<CuentaContable> cuentacontablecreditofin2sForeignKey=new ArrayList<CuentaContable>();
			CuentaContableLogic cuentacontablecreditofin2Logic=new CuentaContableLogic();
			cuentacontablecreditofin2Logic.setConnexion(this.connexion);
			cuentacontablecreditofin2Logic.getCuentaContableDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCuentaContableCreditoFin2.equals("NONE")) {
				cuentacontablecreditofin2Logic.getTodosCuentaContables(finalQueryGlobalCuentaContableCreditoFin2,new Pagination());
				cuentacontablecreditofin2sForeignKey=cuentacontablecreditofin2Logic.getCuentaContables();
			}

			facturaproveedorReturnGeneral.setcuentacontablecreditofin2sForeignKey(cuentacontablecreditofin2sForeignKey);


			List<CuentaContable> cuentacontablecreditosForeignKey=new ArrayList<CuentaContable>();
			CuentaContableLogic cuentacontablecreditoLogic=new CuentaContableLogic();
			cuentacontablecreditoLogic.setConnexion(this.connexion);
			cuentacontablecreditoLogic.getCuentaContableDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCuentaContableCredito.equals("NONE")) {
				cuentacontablecreditoLogic.getTodosCuentaContables(finalQueryGlobalCuentaContableCredito,new Pagination());
				cuentacontablecreditosForeignKey=cuentacontablecreditoLogic.getCuentaContables();
			}

			facturaproveedorReturnGeneral.setcuentacontablecreditosForeignKey(cuentacontablecreditosForeignKey);


			List<TipoMovimiento> tipomovimientosForeignKey=new ArrayList<TipoMovimiento>();
			TipoMovimientoLogic tipomovimientoLogic=new TipoMovimientoLogic();
			tipomovimientoLogic.setConnexion(this.connexion);
			tipomovimientoLogic.getTipoMovimientoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoMovimiento.equals("NONE")) {
				tipomovimientoLogic.getTodosTipoMovimientos(finalQueryGlobalTipoMovimiento,new Pagination());
				tipomovimientosForeignKey=tipomovimientoLogic.getTipoMovimientos();
			}

			facturaproveedorReturnGeneral.settipomovimientosForeignKey(tipomovimientosForeignKey);


			List<TipoMovimientoModulo> tipomovimientomodulosForeignKey=new ArrayList<TipoMovimientoModulo>();
			TipoMovimientoModuloLogic tipomovimientomoduloLogic=new TipoMovimientoModuloLogic();
			tipomovimientomoduloLogic.setConnexion(this.connexion);
			tipomovimientomoduloLogic.getTipoMovimientoModuloDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoMovimientoModulo.equals("NONE")) {
				tipomovimientomoduloLogic.getTodosTipoMovimientoModulos(finalQueryGlobalTipoMovimientoModulo,new Pagination());
				tipomovimientomodulosForeignKey=tipomovimientomoduloLogic.getTipoMovimientoModulos();
			}

			facturaproveedorReturnGeneral.settipomovimientomodulosForeignKey(tipomovimientomodulosForeignKey);


			List<TipoTransaccionModulo> tipotransaccionmodulosForeignKey=new ArrayList<TipoTransaccionModulo>();
			TipoTransaccionModuloLogic tipotransaccionmoduloLogic=new TipoTransaccionModuloLogic();
			tipotransaccionmoduloLogic.setConnexion(this.connexion);
			tipotransaccionmoduloLogic.getTipoTransaccionModuloDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoTransaccionModulo.equals("NONE")) {
				tipotransaccionmoduloLogic.getTodosTipoTransaccionModulos(finalQueryGlobalTipoTransaccionModulo,new Pagination());
				tipotransaccionmodulosForeignKey=tipotransaccionmoduloLogic.getTipoTransaccionModulos();
			}

			facturaproveedorReturnGeneral.settipotransaccionmodulosForeignKey(tipotransaccionmodulosForeignKey);
						
			
		} catch(Exception e) {			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			
		}
		
		return facturaproveedorReturnGeneral;
	}
	
	public void cargarRelacionesLoteForeignKeyFacturaProveedorWithConnection() throws Exception {
		ArrayList<Classe> classes=new ArrayList<Classe>();		
		
		
			DetalleFacturaProveedorLogic detallefacturaproveedorLogic=new DetalleFacturaProveedorLogic();
		
		try {
			
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FacturaProveedor.class.getSimpleName()+"-cargarRelacionesLoteForeignKeyFacturaProveedorWithConnection");connexion.begin();
			
			
			classes.add(new Classe(DetalleFacturaProveedor.class));
											
			

			detallefacturaproveedorLogic.setConnexion(this.getConnexion());
			detallefacturaproveedorLogic.setDatosCliente(this.datosCliente);
			detallefacturaproveedorLogic.setIsConRefrescarForeignKeys(true);
			
			this.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
			
			for(FacturaProveedor facturaproveedor:this.facturaproveedors) {
				

				classes=new ArrayList<Classe>();
				classes=DetalleFacturaProveedorConstantesFunciones.getClassesForeignKeysOfDetalleFacturaProveedor(new ArrayList<Classe>(),DeepLoadType.NONE);

				detallefacturaproveedorLogic.setDetalleFacturaProveedors(facturaproveedor.detallefacturaproveedors);
				detallefacturaproveedorLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
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
	
	public void deepLoad(FacturaProveedor facturaproveedor,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			FacturaProveedorLogicAdditional.updateFacturaProveedorToGet(facturaproveedor,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		facturaproveedor.setEmpresa(facturaproveedorDataAccess.getEmpresa(connexion,facturaproveedor));
		facturaproveedor.setSucursal(facturaproveedorDataAccess.getSucursal(connexion,facturaproveedor));
		facturaproveedor.setEjercicio(facturaproveedorDataAccess.getEjercicio(connexion,facturaproveedor));
		facturaproveedor.setPeriodo(facturaproveedorDataAccess.getPeriodo(connexion,facturaproveedor));
		facturaproveedor.setAnio(facturaproveedorDataAccess.getAnio(connexion,facturaproveedor));
		facturaproveedor.setMes(facturaproveedorDataAccess.getMes(connexion,facturaproveedor));
		facturaproveedor.setModulo(facturaproveedorDataAccess.getModulo(connexion,facturaproveedor));
		facturaproveedor.setPlantillaFactura(facturaproveedorDataAccess.getPlantillaFactura(connexion,facturaproveedor));
		facturaproveedor.setTipoDocumento(facturaproveedorDataAccess.getTipoDocumento(connexion,facturaproveedor));
		facturaproveedor.setFactura(facturaproveedorDataAccess.getFactura(connexion,facturaproveedor));
		facturaproveedor.setTransaccion(facturaproveedorDataAccess.getTransaccion(connexion,facturaproveedor));
		facturaproveedor.setCliente(facturaproveedorDataAccess.getCliente(connexion,facturaproveedor));
		facturaproveedor.setEmpleadoSolicita(facturaproveedorDataAccess.getEmpleadoSolicita(connexion,facturaproveedor));
		facturaproveedor.setMoneda(facturaproveedorDataAccess.getMoneda(connexion,facturaproveedor));
		facturaproveedor.setEmpleado(facturaproveedorDataAccess.getEmpleado(connexion,facturaproveedor));
		facturaproveedor.setTipoRetencionFuente1(facturaproveedorDataAccess.getTipoRetencionFuente1(connexion,facturaproveedor));
		facturaproveedor.setTipoRetencionFuente2(facturaproveedorDataAccess.getTipoRetencionFuente2(connexion,facturaproveedor));
		facturaproveedor.setTipoRetencionIva1(facturaproveedorDataAccess.getTipoRetencionIva1(connexion,facturaproveedor));
		facturaproveedor.setTipoRetencionIva2(facturaproveedorDataAccess.getTipoRetencionIva2(connexion,facturaproveedor));
		facturaproveedor.setTipoTributario(facturaproveedorDataAccess.getTipoTributario(connexion,facturaproveedor));
		facturaproveedor.setCuentaContableCreditoFiscalBienes(facturaproveedorDataAccess.getCuentaContableCreditoFiscalBienes(connexion,facturaproveedor));
		facturaproveedor.setResponsableFondo(facturaproveedorDataAccess.getResponsableFondo(connexion,facturaproveedor));
		facturaproveedor.setCuentaContableCreditoFiscalServicios(facturaproveedorDataAccess.getCuentaContableCreditoFiscalServicios(connexion,facturaproveedor));
		facturaproveedor.setCuentaContableGasto(facturaproveedorDataAccess.getCuentaContableGasto(connexion,facturaproveedor));
		facturaproveedor.setCuentaContableGasto2(facturaproveedorDataAccess.getCuentaContableGasto2(connexion,facturaproveedor));
		facturaproveedor.setCuentaContableCreditoFin(facturaproveedorDataAccess.getCuentaContableCreditoFin(connexion,facturaproveedor));
		facturaproveedor.setCuentaContableCreditoFin2(facturaproveedorDataAccess.getCuentaContableCreditoFin2(connexion,facturaproveedor));
		facturaproveedor.setCuentaContableCredito(facturaproveedorDataAccess.getCuentaContableCredito(connexion,facturaproveedor));
		facturaproveedor.setTipoMovimiento(facturaproveedorDataAccess.getTipoMovimiento(connexion,facturaproveedor));
		facturaproveedor.setTipoMovimientoModulo(facturaproveedorDataAccess.getTipoMovimientoModulo(connexion,facturaproveedor));
		facturaproveedor.setTipoTransaccionModulo(facturaproveedorDataAccess.getTipoTransaccionModulo(connexion,facturaproveedor));
		facturaproveedor.setDetalleFacturaProveedors(facturaproveedorDataAccess.getDetalleFacturaProveedors(connexion,facturaproveedor));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				facturaproveedor.setEmpresa(facturaproveedorDataAccess.getEmpresa(connexion,facturaproveedor));
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				facturaproveedor.setSucursal(facturaproveedorDataAccess.getSucursal(connexion,facturaproveedor));
				continue;
			}

			if(clas.clas.equals(Ejercicio.class)) {
				facturaproveedor.setEjercicio(facturaproveedorDataAccess.getEjercicio(connexion,facturaproveedor));
				continue;
			}

			if(clas.clas.equals(Periodo.class)) {
				facturaproveedor.setPeriodo(facturaproveedorDataAccess.getPeriodo(connexion,facturaproveedor));
				continue;
			}

			if(clas.clas.equals(Anio.class)) {
				facturaproveedor.setAnio(facturaproveedorDataAccess.getAnio(connexion,facturaproveedor));
				continue;
			}

			if(clas.clas.equals(Mes.class)) {
				facturaproveedor.setMes(facturaproveedorDataAccess.getMes(connexion,facturaproveedor));
				continue;
			}

			if(clas.clas.equals(Modulo.class)) {
				facturaproveedor.setModulo(facturaproveedorDataAccess.getModulo(connexion,facturaproveedor));
				continue;
			}

			if(clas.clas.equals(PlantillaFactura.class)) {
				facturaproveedor.setPlantillaFactura(facturaproveedorDataAccess.getPlantillaFactura(connexion,facturaproveedor));
				continue;
			}

			if(clas.clas.equals(TipoDocumento.class)) {
				facturaproveedor.setTipoDocumento(facturaproveedorDataAccess.getTipoDocumento(connexion,facturaproveedor));
				continue;
			}

			if(clas.clas.equals(Factura.class)) {
				facturaproveedor.setFactura(facturaproveedorDataAccess.getFactura(connexion,facturaproveedor));
				continue;
			}

			if(clas.clas.equals(Transaccion.class)) {
				facturaproveedor.setTransaccion(facturaproveedorDataAccess.getTransaccion(connexion,facturaproveedor));
				continue;
			}

			if(clas.clas.equals(Cliente.class)) {
				facturaproveedor.setCliente(facturaproveedorDataAccess.getCliente(connexion,facturaproveedor));
				continue;
			}

			if(clas.clas.equals(Empleado.class)) {
				facturaproveedor.setEmpleadoSolicita(facturaproveedorDataAccess.getEmpleadoSolicita(connexion,facturaproveedor));
				continue;
			}

			if(clas.clas.equals(Moneda.class)) {
				facturaproveedor.setMoneda(facturaproveedorDataAccess.getMoneda(connexion,facturaproveedor));
				continue;
			}

			if(clas.clas.equals(Empleado.class)) {
				facturaproveedor.setEmpleado(facturaproveedorDataAccess.getEmpleado(connexion,facturaproveedor));
				continue;
			}

			if(clas.clas.equals(TipoRetencion.class)) {
				facturaproveedor.setTipoRetencionFuente1(facturaproveedorDataAccess.getTipoRetencionFuente1(connexion,facturaproveedor));
				continue;
			}

			if(clas.clas.equals(TipoRetencion.class)) {
				facturaproveedor.setTipoRetencionFuente2(facturaproveedorDataAccess.getTipoRetencionFuente2(connexion,facturaproveedor));
				continue;
			}

			if(clas.clas.equals(TipoRetencion.class)) {
				facturaproveedor.setTipoRetencionIva1(facturaproveedorDataAccess.getTipoRetencionIva1(connexion,facturaproveedor));
				continue;
			}

			if(clas.clas.equals(TipoRetencion.class)) {
				facturaproveedor.setTipoRetencionIva2(facturaproveedorDataAccess.getTipoRetencionIva2(connexion,facturaproveedor));
				continue;
			}

			if(clas.clas.equals(TipoTributario.class)) {
				facturaproveedor.setTipoTributario(facturaproveedorDataAccess.getTipoTributario(connexion,facturaproveedor));
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				facturaproveedor.setCuentaContableCreditoFiscalBienes(facturaproveedorDataAccess.getCuentaContableCreditoFiscalBienes(connexion,facturaproveedor));
				continue;
			}

			if(clas.clas.equals(ResponsableFondo.class)) {
				facturaproveedor.setResponsableFondo(facturaproveedorDataAccess.getResponsableFondo(connexion,facturaproveedor));
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				facturaproveedor.setCuentaContableCreditoFiscalServicios(facturaproveedorDataAccess.getCuentaContableCreditoFiscalServicios(connexion,facturaproveedor));
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				facturaproveedor.setCuentaContableGasto(facturaproveedorDataAccess.getCuentaContableGasto(connexion,facturaproveedor));
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				facturaproveedor.setCuentaContableGasto2(facturaproveedorDataAccess.getCuentaContableGasto2(connexion,facturaproveedor));
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				facturaproveedor.setCuentaContableCreditoFin(facturaproveedorDataAccess.getCuentaContableCreditoFin(connexion,facturaproveedor));
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				facturaproveedor.setCuentaContableCreditoFin2(facturaproveedorDataAccess.getCuentaContableCreditoFin2(connexion,facturaproveedor));
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				facturaproveedor.setCuentaContableCredito(facturaproveedorDataAccess.getCuentaContableCredito(connexion,facturaproveedor));
				continue;
			}

			if(clas.clas.equals(TipoMovimiento.class)) {
				facturaproveedor.setTipoMovimiento(facturaproveedorDataAccess.getTipoMovimiento(connexion,facturaproveedor));
				continue;
			}

			if(clas.clas.equals(TipoMovimientoModulo.class)) {
				facturaproveedor.setTipoMovimientoModulo(facturaproveedorDataAccess.getTipoMovimientoModulo(connexion,facturaproveedor));
				continue;
			}

			if(clas.clas.equals(TipoTransaccionModulo.class)) {
				facturaproveedor.setTipoTransaccionModulo(facturaproveedorDataAccess.getTipoTransaccionModulo(connexion,facturaproveedor));
				continue;
			}

			if(clas.clas.equals(DetalleFacturaProveedor.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				facturaproveedor.setDetalleFacturaProveedors(facturaproveedorDataAccess.getDetalleFacturaProveedors(connexion,facturaproveedor));

				if(this.isConDeep) {
					DetalleFacturaProveedorLogic detallefacturaproveedorLogic= new DetalleFacturaProveedorLogic(this.connexion);
					detallefacturaproveedorLogic.setDetalleFacturaProveedors(facturaproveedor.getDetalleFacturaProveedors());
					ArrayList<Classe> classesLocal=DetalleFacturaProveedorConstantesFunciones.getClassesForeignKeysOfDetalleFacturaProveedor(new ArrayList<Classe>(),DeepLoadType.NONE);
					detallefacturaproveedorLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					DetalleFacturaProveedorConstantesFunciones.refrescarForeignKeysDescripcionesDetalleFacturaProveedor(detallefacturaproveedorLogic.getDetalleFacturaProveedors());
					facturaproveedor.setDetalleFacturaProveedors(detallefacturaproveedorLogic.getDetalleFacturaProveedors());
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
			facturaproveedor.setEmpresa(facturaproveedorDataAccess.getEmpresa(connexion,facturaproveedor));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			facturaproveedor.setSucursal(facturaproveedorDataAccess.getSucursal(connexion,facturaproveedor));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Ejercicio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			facturaproveedor.setEjercicio(facturaproveedorDataAccess.getEjercicio(connexion,facturaproveedor));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Periodo.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			facturaproveedor.setPeriodo(facturaproveedorDataAccess.getPeriodo(connexion,facturaproveedor));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Anio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			facturaproveedor.setAnio(facturaproveedorDataAccess.getAnio(connexion,facturaproveedor));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Mes.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			facturaproveedor.setMes(facturaproveedorDataAccess.getMes(connexion,facturaproveedor));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Modulo.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			facturaproveedor.setModulo(facturaproveedorDataAccess.getModulo(connexion,facturaproveedor));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(PlantillaFactura.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			facturaproveedor.setPlantillaFactura(facturaproveedorDataAccess.getPlantillaFactura(connexion,facturaproveedor));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(TipoDocumento.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			facturaproveedor.setTipoDocumento(facturaproveedorDataAccess.getTipoDocumento(connexion,facturaproveedor));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Factura.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			facturaproveedor.setFactura(facturaproveedorDataAccess.getFactura(connexion,facturaproveedor));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Transaccion.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			facturaproveedor.setTransaccion(facturaproveedorDataAccess.getTransaccion(connexion,facturaproveedor));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Cliente.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			facturaproveedor.setCliente(facturaproveedorDataAccess.getCliente(connexion,facturaproveedor));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Empleado.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			facturaproveedor.setEmpleadoSolicita(facturaproveedorDataAccess.getEmpleadoSolicita(connexion,facturaproveedor));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Moneda.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			facturaproveedor.setMoneda(facturaproveedorDataAccess.getMoneda(connexion,facturaproveedor));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Empleado.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			facturaproveedor.setEmpleado(facturaproveedorDataAccess.getEmpleado(connexion,facturaproveedor));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(TipoRetencion.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			facturaproveedor.setTipoRetencionFuente1(facturaproveedorDataAccess.getTipoRetencionFuente1(connexion,facturaproveedor));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(TipoRetencion.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			facturaproveedor.setTipoRetencionFuente2(facturaproveedorDataAccess.getTipoRetencionFuente2(connexion,facturaproveedor));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(TipoRetencion.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			facturaproveedor.setTipoRetencionIva1(facturaproveedorDataAccess.getTipoRetencionIva1(connexion,facturaproveedor));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(TipoRetencion.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			facturaproveedor.setTipoRetencionIva2(facturaproveedorDataAccess.getTipoRetencionIva2(connexion,facturaproveedor));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(TipoTributario.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			facturaproveedor.setTipoTributario(facturaproveedorDataAccess.getTipoTributario(connexion,facturaproveedor));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(CuentaContable.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			facturaproveedor.setCuentaContableCreditoFiscalBienes(facturaproveedorDataAccess.getCuentaContableCreditoFiscalBienes(connexion,facturaproveedor));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(ResponsableFondo.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			facturaproveedor.setResponsableFondo(facturaproveedorDataAccess.getResponsableFondo(connexion,facturaproveedor));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(CuentaContable.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			facturaproveedor.setCuentaContableCreditoFiscalServicios(facturaproveedorDataAccess.getCuentaContableCreditoFiscalServicios(connexion,facturaproveedor));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(CuentaContable.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			facturaproveedor.setCuentaContableGasto(facturaproveedorDataAccess.getCuentaContableGasto(connexion,facturaproveedor));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(CuentaContable.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			facturaproveedor.setCuentaContableGasto2(facturaproveedorDataAccess.getCuentaContableGasto2(connexion,facturaproveedor));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(CuentaContable.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			facturaproveedor.setCuentaContableCreditoFin(facturaproveedorDataAccess.getCuentaContableCreditoFin(connexion,facturaproveedor));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(CuentaContable.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			facturaproveedor.setCuentaContableCreditoFin2(facturaproveedorDataAccess.getCuentaContableCreditoFin2(connexion,facturaproveedor));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(CuentaContable.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			facturaproveedor.setCuentaContableCredito(facturaproveedorDataAccess.getCuentaContableCredito(connexion,facturaproveedor));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(TipoMovimiento.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			facturaproveedor.setTipoMovimiento(facturaproveedorDataAccess.getTipoMovimiento(connexion,facturaproveedor));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(TipoMovimientoModulo.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			facturaproveedor.setTipoMovimientoModulo(facturaproveedorDataAccess.getTipoMovimientoModulo(connexion,facturaproveedor));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(TipoTransaccionModulo.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			facturaproveedor.setTipoTransaccionModulo(facturaproveedorDataAccess.getTipoTransaccionModulo(connexion,facturaproveedor));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(DetalleFacturaProveedor.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(DetalleFacturaProveedor.class));
			facturaproveedor.setDetalleFacturaProveedors(facturaproveedorDataAccess.getDetalleFacturaProveedors(connexion,facturaproveedor));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		facturaproveedor.setEmpresa(facturaproveedorDataAccess.getEmpresa(connexion,facturaproveedor));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(facturaproveedor.getEmpresa(),isDeep,deepLoadType,clases);
				
		facturaproveedor.setSucursal(facturaproveedorDataAccess.getSucursal(connexion,facturaproveedor));
		SucursalLogic sucursalLogic= new SucursalLogic(connexion);
		sucursalLogic.deepLoad(facturaproveedor.getSucursal(),isDeep,deepLoadType,clases);
				
		facturaproveedor.setEjercicio(facturaproveedorDataAccess.getEjercicio(connexion,facturaproveedor));
		EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
		ejercicioLogic.deepLoad(facturaproveedor.getEjercicio(),isDeep,deepLoadType,clases);
				
		facturaproveedor.setPeriodo(facturaproveedorDataAccess.getPeriodo(connexion,facturaproveedor));
		PeriodoLogic periodoLogic= new PeriodoLogic(connexion);
		periodoLogic.deepLoad(facturaproveedor.getPeriodo(),isDeep,deepLoadType,clases);
				
		facturaproveedor.setAnio(facturaproveedorDataAccess.getAnio(connexion,facturaproveedor));
		AnioLogic anioLogic= new AnioLogic(connexion);
		anioLogic.deepLoad(facturaproveedor.getAnio(),isDeep,deepLoadType,clases);
				
		facturaproveedor.setMes(facturaproveedorDataAccess.getMes(connexion,facturaproveedor));
		MesLogic mesLogic= new MesLogic(connexion);
		mesLogic.deepLoad(facturaproveedor.getMes(),isDeep,deepLoadType,clases);
				
		facturaproveedor.setModulo(facturaproveedorDataAccess.getModulo(connexion,facturaproveedor));
		ModuloLogic moduloLogic= new ModuloLogic(connexion);
		moduloLogic.deepLoad(facturaproveedor.getModulo(),isDeep,deepLoadType,clases);
				
		facturaproveedor.setPlantillaFactura(facturaproveedorDataAccess.getPlantillaFactura(connexion,facturaproveedor));
		PlantillaFacturaLogic plantillafacturaLogic= new PlantillaFacturaLogic(connexion);
		plantillafacturaLogic.deepLoad(facturaproveedor.getPlantillaFactura(),isDeep,deepLoadType,clases);
				
		facturaproveedor.setTipoDocumento(facturaproveedorDataAccess.getTipoDocumento(connexion,facturaproveedor));
		TipoDocumentoLogic tipodocumentoLogic= new TipoDocumentoLogic(connexion);
		tipodocumentoLogic.deepLoad(facturaproveedor.getTipoDocumento(),isDeep,deepLoadType,clases);
				
		facturaproveedor.setFactura(facturaproveedorDataAccess.getFactura(connexion,facturaproveedor));
		FacturaLogic facturaLogic= new FacturaLogic(connexion);
		facturaLogic.deepLoad(facturaproveedor.getFactura(),isDeep,deepLoadType,clases);
				
		facturaproveedor.setTransaccion(facturaproveedorDataAccess.getTransaccion(connexion,facturaproveedor));
		TransaccionLogic transaccionLogic= new TransaccionLogic(connexion);
		transaccionLogic.deepLoad(facturaproveedor.getTransaccion(),isDeep,deepLoadType,clases);
				
		facturaproveedor.setCliente(facturaproveedorDataAccess.getCliente(connexion,facturaproveedor));
		ClienteLogic clienteLogic= new ClienteLogic(connexion);
		clienteLogic.deepLoad(facturaproveedor.getCliente(),isDeep,deepLoadType,clases);
				
		facturaproveedor.setEmpleadoSolicita(facturaproveedorDataAccess.getEmpleadoSolicita(connexion,facturaproveedor));
		EmpleadoLogic empleadosolicitaLogic= new EmpleadoLogic(connexion);
		empleadosolicitaLogic.deepLoad(facturaproveedor.getEmpleadoSolicita(),isDeep,deepLoadType,clases);
				
		facturaproveedor.setMoneda(facturaproveedorDataAccess.getMoneda(connexion,facturaproveedor));
		MonedaLogic monedaLogic= new MonedaLogic(connexion);
		monedaLogic.deepLoad(facturaproveedor.getMoneda(),isDeep,deepLoadType,clases);
				
		facturaproveedor.setEmpleado(facturaproveedorDataAccess.getEmpleado(connexion,facturaproveedor));
		EmpleadoLogic empleadoLogic= new EmpleadoLogic(connexion);
		empleadoLogic.deepLoad(facturaproveedor.getEmpleado(),isDeep,deepLoadType,clases);
				
		facturaproveedor.setTipoRetencionFuente1(facturaproveedorDataAccess.getTipoRetencionFuente1(connexion,facturaproveedor));
		TipoRetencionLogic tiporetencionfuente1Logic= new TipoRetencionLogic(connexion);
		tiporetencionfuente1Logic.deepLoad(facturaproveedor.getTipoRetencionFuente1(),isDeep,deepLoadType,clases);
				
		facturaproveedor.setTipoRetencionFuente2(facturaproveedorDataAccess.getTipoRetencionFuente2(connexion,facturaproveedor));
		TipoRetencionLogic tiporetencionfuente2Logic= new TipoRetencionLogic(connexion);
		tiporetencionfuente2Logic.deepLoad(facturaproveedor.getTipoRetencionFuente2(),isDeep,deepLoadType,clases);
				
		facturaproveedor.setTipoRetencionIva1(facturaproveedorDataAccess.getTipoRetencionIva1(connexion,facturaproveedor));
		TipoRetencionLogic tiporetencioniva1Logic= new TipoRetencionLogic(connexion);
		tiporetencioniva1Logic.deepLoad(facturaproveedor.getTipoRetencionIva1(),isDeep,deepLoadType,clases);
				
		facturaproveedor.setTipoRetencionIva2(facturaproveedorDataAccess.getTipoRetencionIva2(connexion,facturaproveedor));
		TipoRetencionLogic tiporetencioniva2Logic= new TipoRetencionLogic(connexion);
		tiporetencioniva2Logic.deepLoad(facturaproveedor.getTipoRetencionIva2(),isDeep,deepLoadType,clases);
				
		facturaproveedor.setTipoTributario(facturaproveedorDataAccess.getTipoTributario(connexion,facturaproveedor));
		TipoTributarioLogic tipotributarioLogic= new TipoTributarioLogic(connexion);
		tipotributarioLogic.deepLoad(facturaproveedor.getTipoTributario(),isDeep,deepLoadType,clases);
				
		facturaproveedor.setCuentaContableCreditoFiscalBienes(facturaproveedorDataAccess.getCuentaContableCreditoFiscalBienes(connexion,facturaproveedor));
		CuentaContableLogic cuentacontablecreditofiscalbienesLogic= new CuentaContableLogic(connexion);
		cuentacontablecreditofiscalbienesLogic.deepLoad(facturaproveedor.getCuentaContableCreditoFiscalBienes(),isDeep,deepLoadType,clases);
				
		facturaproveedor.setResponsableFondo(facturaproveedorDataAccess.getResponsableFondo(connexion,facturaproveedor));
		ResponsableFondoLogic responsablefondoLogic= new ResponsableFondoLogic(connexion);
		responsablefondoLogic.deepLoad(facturaproveedor.getResponsableFondo(),isDeep,deepLoadType,clases);
				
		facturaproveedor.setCuentaContableCreditoFiscalServicios(facturaproveedorDataAccess.getCuentaContableCreditoFiscalServicios(connexion,facturaproveedor));
		CuentaContableLogic cuentacontablecreditofiscalserviciosLogic= new CuentaContableLogic(connexion);
		cuentacontablecreditofiscalserviciosLogic.deepLoad(facturaproveedor.getCuentaContableCreditoFiscalServicios(),isDeep,deepLoadType,clases);
				
		facturaproveedor.setCuentaContableGasto(facturaproveedorDataAccess.getCuentaContableGasto(connexion,facturaproveedor));
		CuentaContableLogic cuentacontablegastoLogic= new CuentaContableLogic(connexion);
		cuentacontablegastoLogic.deepLoad(facturaproveedor.getCuentaContableGasto(),isDeep,deepLoadType,clases);
				
		facturaproveedor.setCuentaContableGasto2(facturaproveedorDataAccess.getCuentaContableGasto2(connexion,facturaproveedor));
		CuentaContableLogic cuentacontablegasto2Logic= new CuentaContableLogic(connexion);
		cuentacontablegasto2Logic.deepLoad(facturaproveedor.getCuentaContableGasto2(),isDeep,deepLoadType,clases);
				
		facturaproveedor.setCuentaContableCreditoFin(facturaproveedorDataAccess.getCuentaContableCreditoFin(connexion,facturaproveedor));
		CuentaContableLogic cuentacontablecreditofinLogic= new CuentaContableLogic(connexion);
		cuentacontablecreditofinLogic.deepLoad(facturaproveedor.getCuentaContableCreditoFin(),isDeep,deepLoadType,clases);
				
		facturaproveedor.setCuentaContableCreditoFin2(facturaproveedorDataAccess.getCuentaContableCreditoFin2(connexion,facturaproveedor));
		CuentaContableLogic cuentacontablecreditofin2Logic= new CuentaContableLogic(connexion);
		cuentacontablecreditofin2Logic.deepLoad(facturaproveedor.getCuentaContableCreditoFin2(),isDeep,deepLoadType,clases);
				
		facturaproveedor.setCuentaContableCredito(facturaproveedorDataAccess.getCuentaContableCredito(connexion,facturaproveedor));
		CuentaContableLogic cuentacontablecreditoLogic= new CuentaContableLogic(connexion);
		cuentacontablecreditoLogic.deepLoad(facturaproveedor.getCuentaContableCredito(),isDeep,deepLoadType,clases);
				
		facturaproveedor.setTipoMovimiento(facturaproveedorDataAccess.getTipoMovimiento(connexion,facturaproveedor));
		TipoMovimientoLogic tipomovimientoLogic= new TipoMovimientoLogic(connexion);
		tipomovimientoLogic.deepLoad(facturaproveedor.getTipoMovimiento(),isDeep,deepLoadType,clases);
				
		facturaproveedor.setTipoMovimientoModulo(facturaproveedorDataAccess.getTipoMovimientoModulo(connexion,facturaproveedor));
		TipoMovimientoModuloLogic tipomovimientomoduloLogic= new TipoMovimientoModuloLogic(connexion);
		tipomovimientomoduloLogic.deepLoad(facturaproveedor.getTipoMovimientoModulo(),isDeep,deepLoadType,clases);
				
		facturaproveedor.setTipoTransaccionModulo(facturaproveedorDataAccess.getTipoTransaccionModulo(connexion,facturaproveedor));
		TipoTransaccionModuloLogic tipotransaccionmoduloLogic= new TipoTransaccionModuloLogic(connexion);
		tipotransaccionmoduloLogic.deepLoad(facturaproveedor.getTipoTransaccionModulo(),isDeep,deepLoadType,clases);
				

		facturaproveedor.setDetalleFacturaProveedors(facturaproveedorDataAccess.getDetalleFacturaProveedors(connexion,facturaproveedor));

		for(DetalleFacturaProveedor detallefacturaproveedor:facturaproveedor.getDetalleFacturaProveedors()) {
			DetalleFacturaProveedorLogic detallefacturaproveedorLogic= new DetalleFacturaProveedorLogic(connexion);
			detallefacturaproveedorLogic.deepLoad(detallefacturaproveedor,isDeep,deepLoadType,clases);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				facturaproveedor.setEmpresa(facturaproveedorDataAccess.getEmpresa(connexion,facturaproveedor));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(facturaproveedor.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				facturaproveedor.setSucursal(facturaproveedorDataAccess.getSucursal(connexion,facturaproveedor));
				SucursalLogic sucursalLogic= new SucursalLogic(connexion);
				sucursalLogic.deepLoad(facturaproveedor.getSucursal(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Ejercicio.class)) {
				facturaproveedor.setEjercicio(facturaproveedorDataAccess.getEjercicio(connexion,facturaproveedor));
				EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
				ejercicioLogic.deepLoad(facturaproveedor.getEjercicio(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Periodo.class)) {
				facturaproveedor.setPeriodo(facturaproveedorDataAccess.getPeriodo(connexion,facturaproveedor));
				PeriodoLogic periodoLogic= new PeriodoLogic(connexion);
				periodoLogic.deepLoad(facturaproveedor.getPeriodo(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Anio.class)) {
				facturaproveedor.setAnio(facturaproveedorDataAccess.getAnio(connexion,facturaproveedor));
				AnioLogic anioLogic= new AnioLogic(connexion);
				anioLogic.deepLoad(facturaproveedor.getAnio(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Mes.class)) {
				facturaproveedor.setMes(facturaproveedorDataAccess.getMes(connexion,facturaproveedor));
				MesLogic mesLogic= new MesLogic(connexion);
				mesLogic.deepLoad(facturaproveedor.getMes(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Modulo.class)) {
				facturaproveedor.setModulo(facturaproveedorDataAccess.getModulo(connexion,facturaproveedor));
				ModuloLogic moduloLogic= new ModuloLogic(connexion);
				moduloLogic.deepLoad(facturaproveedor.getModulo(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(PlantillaFactura.class)) {
				facturaproveedor.setPlantillaFactura(facturaproveedorDataAccess.getPlantillaFactura(connexion,facturaproveedor));
				PlantillaFacturaLogic plantillafacturaLogic= new PlantillaFacturaLogic(connexion);
				plantillafacturaLogic.deepLoad(facturaproveedor.getPlantillaFactura(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoDocumento.class)) {
				facturaproveedor.setTipoDocumento(facturaproveedorDataAccess.getTipoDocumento(connexion,facturaproveedor));
				TipoDocumentoLogic tipodocumentoLogic= new TipoDocumentoLogic(connexion);
				tipodocumentoLogic.deepLoad(facturaproveedor.getTipoDocumento(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Factura.class)) {
				facturaproveedor.setFactura(facturaproveedorDataAccess.getFactura(connexion,facturaproveedor));
				FacturaLogic facturaLogic= new FacturaLogic(connexion);
				facturaLogic.deepLoad(facturaproveedor.getFactura(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Transaccion.class)) {
				facturaproveedor.setTransaccion(facturaproveedorDataAccess.getTransaccion(connexion,facturaproveedor));
				TransaccionLogic transaccionLogic= new TransaccionLogic(connexion);
				transaccionLogic.deepLoad(facturaproveedor.getTransaccion(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Cliente.class)) {
				facturaproveedor.setCliente(facturaproveedorDataAccess.getCliente(connexion,facturaproveedor));
				ClienteLogic clienteLogic= new ClienteLogic(connexion);
				clienteLogic.deepLoad(facturaproveedor.getCliente(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Empleado.class)) {
				facturaproveedor.setEmpleadoSolicita(facturaproveedorDataAccess.getEmpleadoSolicita(connexion,facturaproveedor));
				EmpleadoLogic empleadoLogic= new EmpleadoLogic(connexion);
				empleadoLogic.deepLoad(facturaproveedor.getEmpleadoSolicita(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Moneda.class)) {
				facturaproveedor.setMoneda(facturaproveedorDataAccess.getMoneda(connexion,facturaproveedor));
				MonedaLogic monedaLogic= new MonedaLogic(connexion);
				monedaLogic.deepLoad(facturaproveedor.getMoneda(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Empleado.class)) {
				facturaproveedor.setEmpleado(facturaproveedorDataAccess.getEmpleado(connexion,facturaproveedor));
				EmpleadoLogic empleadoLogic= new EmpleadoLogic(connexion);
				empleadoLogic.deepLoad(facturaproveedor.getEmpleado(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoRetencion.class)) {
				facturaproveedor.setTipoRetencionFuente1(facturaproveedorDataAccess.getTipoRetencionFuente1(connexion,facturaproveedor));
				TipoRetencionLogic tiporetencionLogic= new TipoRetencionLogic(connexion);
				tiporetencionLogic.deepLoad(facturaproveedor.getTipoRetencionFuente1(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoRetencion.class)) {
				facturaproveedor.setTipoRetencionFuente2(facturaproveedorDataAccess.getTipoRetencionFuente2(connexion,facturaproveedor));
				TipoRetencionLogic tiporetencionLogic= new TipoRetencionLogic(connexion);
				tiporetencionLogic.deepLoad(facturaproveedor.getTipoRetencionFuente2(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoRetencion.class)) {
				facturaproveedor.setTipoRetencionIva1(facturaproveedorDataAccess.getTipoRetencionIva1(connexion,facturaproveedor));
				TipoRetencionLogic tiporetencionLogic= new TipoRetencionLogic(connexion);
				tiporetencionLogic.deepLoad(facturaproveedor.getTipoRetencionIva1(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoRetencion.class)) {
				facturaproveedor.setTipoRetencionIva2(facturaproveedorDataAccess.getTipoRetencionIva2(connexion,facturaproveedor));
				TipoRetencionLogic tiporetencionLogic= new TipoRetencionLogic(connexion);
				tiporetencionLogic.deepLoad(facturaproveedor.getTipoRetencionIva2(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoTributario.class)) {
				facturaproveedor.setTipoTributario(facturaproveedorDataAccess.getTipoTributario(connexion,facturaproveedor));
				TipoTributarioLogic tipotributarioLogic= new TipoTributarioLogic(connexion);
				tipotributarioLogic.deepLoad(facturaproveedor.getTipoTributario(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				facturaproveedor.setCuentaContableCreditoFiscalBienes(facturaproveedorDataAccess.getCuentaContableCreditoFiscalBienes(connexion,facturaproveedor));
				CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
				cuentacontableLogic.deepLoad(facturaproveedor.getCuentaContableCreditoFiscalBienes(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(ResponsableFondo.class)) {
				facturaproveedor.setResponsableFondo(facturaproveedorDataAccess.getResponsableFondo(connexion,facturaproveedor));
				ResponsableFondoLogic responsablefondoLogic= new ResponsableFondoLogic(connexion);
				responsablefondoLogic.deepLoad(facturaproveedor.getResponsableFondo(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				facturaproveedor.setCuentaContableCreditoFiscalServicios(facturaproveedorDataAccess.getCuentaContableCreditoFiscalServicios(connexion,facturaproveedor));
				CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
				cuentacontableLogic.deepLoad(facturaproveedor.getCuentaContableCreditoFiscalServicios(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				facturaproveedor.setCuentaContableGasto(facturaproveedorDataAccess.getCuentaContableGasto(connexion,facturaproveedor));
				CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
				cuentacontableLogic.deepLoad(facturaproveedor.getCuentaContableGasto(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				facturaproveedor.setCuentaContableGasto2(facturaproveedorDataAccess.getCuentaContableGasto2(connexion,facturaproveedor));
				CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
				cuentacontableLogic.deepLoad(facturaproveedor.getCuentaContableGasto2(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				facturaproveedor.setCuentaContableCreditoFin(facturaproveedorDataAccess.getCuentaContableCreditoFin(connexion,facturaproveedor));
				CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
				cuentacontableLogic.deepLoad(facturaproveedor.getCuentaContableCreditoFin(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				facturaproveedor.setCuentaContableCreditoFin2(facturaproveedorDataAccess.getCuentaContableCreditoFin2(connexion,facturaproveedor));
				CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
				cuentacontableLogic.deepLoad(facturaproveedor.getCuentaContableCreditoFin2(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				facturaproveedor.setCuentaContableCredito(facturaproveedorDataAccess.getCuentaContableCredito(connexion,facturaproveedor));
				CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
				cuentacontableLogic.deepLoad(facturaproveedor.getCuentaContableCredito(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoMovimiento.class)) {
				facturaproveedor.setTipoMovimiento(facturaproveedorDataAccess.getTipoMovimiento(connexion,facturaproveedor));
				TipoMovimientoLogic tipomovimientoLogic= new TipoMovimientoLogic(connexion);
				tipomovimientoLogic.deepLoad(facturaproveedor.getTipoMovimiento(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoMovimientoModulo.class)) {
				facturaproveedor.setTipoMovimientoModulo(facturaproveedorDataAccess.getTipoMovimientoModulo(connexion,facturaproveedor));
				TipoMovimientoModuloLogic tipomovimientomoduloLogic= new TipoMovimientoModuloLogic(connexion);
				tipomovimientomoduloLogic.deepLoad(facturaproveedor.getTipoMovimientoModulo(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoTransaccionModulo.class)) {
				facturaproveedor.setTipoTransaccionModulo(facturaproveedorDataAccess.getTipoTransaccionModulo(connexion,facturaproveedor));
				TipoTransaccionModuloLogic tipotransaccionmoduloLogic= new TipoTransaccionModuloLogic(connexion);
				tipotransaccionmoduloLogic.deepLoad(facturaproveedor.getTipoTransaccionModulo(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(DetalleFacturaProveedor.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				facturaproveedor.setDetalleFacturaProveedors(facturaproveedorDataAccess.getDetalleFacturaProveedors(connexion,facturaproveedor));

				for(DetalleFacturaProveedor detallefacturaproveedor:facturaproveedor.getDetalleFacturaProveedors()) {
					DetalleFacturaProveedorLogic detallefacturaproveedorLogic= new DetalleFacturaProveedorLogic(connexion);
					detallefacturaproveedorLogic.deepLoad(detallefacturaproveedor,isDeep,deepLoadType,clases);
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
			facturaproveedor.setEmpresa(facturaproveedorDataAccess.getEmpresa(connexion,facturaproveedor));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(facturaproveedor.getEmpresa(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			facturaproveedor.setSucursal(facturaproveedorDataAccess.getSucursal(connexion,facturaproveedor));
			SucursalLogic sucursalLogic= new SucursalLogic(connexion);
			sucursalLogic.deepLoad(facturaproveedor.getSucursal(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Ejercicio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			facturaproveedor.setEjercicio(facturaproveedorDataAccess.getEjercicio(connexion,facturaproveedor));
			EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
			ejercicioLogic.deepLoad(facturaproveedor.getEjercicio(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Periodo.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			facturaproveedor.setPeriodo(facturaproveedorDataAccess.getPeriodo(connexion,facturaproveedor));
			PeriodoLogic periodoLogic= new PeriodoLogic(connexion);
			periodoLogic.deepLoad(facturaproveedor.getPeriodo(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Anio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			facturaproveedor.setAnio(facturaproveedorDataAccess.getAnio(connexion,facturaproveedor));
			AnioLogic anioLogic= new AnioLogic(connexion);
			anioLogic.deepLoad(facturaproveedor.getAnio(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Mes.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			facturaproveedor.setMes(facturaproveedorDataAccess.getMes(connexion,facturaproveedor));
			MesLogic mesLogic= new MesLogic(connexion);
			mesLogic.deepLoad(facturaproveedor.getMes(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Modulo.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			facturaproveedor.setModulo(facturaproveedorDataAccess.getModulo(connexion,facturaproveedor));
			ModuloLogic moduloLogic= new ModuloLogic(connexion);
			moduloLogic.deepLoad(facturaproveedor.getModulo(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(PlantillaFactura.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			facturaproveedor.setPlantillaFactura(facturaproveedorDataAccess.getPlantillaFactura(connexion,facturaproveedor));
			PlantillaFacturaLogic plantillafacturaLogic= new PlantillaFacturaLogic(connexion);
			plantillafacturaLogic.deepLoad(facturaproveedor.getPlantillaFactura(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(TipoDocumento.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			facturaproveedor.setTipoDocumento(facturaproveedorDataAccess.getTipoDocumento(connexion,facturaproveedor));
			TipoDocumentoLogic tipodocumentoLogic= new TipoDocumentoLogic(connexion);
			tipodocumentoLogic.deepLoad(facturaproveedor.getTipoDocumento(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Factura.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			facturaproveedor.setFactura(facturaproveedorDataAccess.getFactura(connexion,facturaproveedor));
			FacturaLogic facturaLogic= new FacturaLogic(connexion);
			facturaLogic.deepLoad(facturaproveedor.getFactura(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Transaccion.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			facturaproveedor.setTransaccion(facturaproveedorDataAccess.getTransaccion(connexion,facturaproveedor));
			TransaccionLogic transaccionLogic= new TransaccionLogic(connexion);
			transaccionLogic.deepLoad(facturaproveedor.getTransaccion(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Cliente.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			facturaproveedor.setCliente(facturaproveedorDataAccess.getCliente(connexion,facturaproveedor));
			ClienteLogic clienteLogic= new ClienteLogic(connexion);
			clienteLogic.deepLoad(facturaproveedor.getCliente(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Empleado.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			facturaproveedor.setEmpleadoSolicita(facturaproveedorDataAccess.getEmpleadoSolicita(connexion,facturaproveedor));
			EmpleadoLogic empleadoLogic= new EmpleadoLogic(connexion);
			empleadoLogic.deepLoad(facturaproveedor.getEmpleadoSolicita(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Moneda.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			facturaproveedor.setMoneda(facturaproveedorDataAccess.getMoneda(connexion,facturaproveedor));
			MonedaLogic monedaLogic= new MonedaLogic(connexion);
			monedaLogic.deepLoad(facturaproveedor.getMoneda(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Empleado.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			facturaproveedor.setEmpleado(facturaproveedorDataAccess.getEmpleado(connexion,facturaproveedor));
			EmpleadoLogic empleadoLogic= new EmpleadoLogic(connexion);
			empleadoLogic.deepLoad(facturaproveedor.getEmpleado(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(TipoRetencion.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			facturaproveedor.setTipoRetencionFuente1(facturaproveedorDataAccess.getTipoRetencionFuente1(connexion,facturaproveedor));
			TipoRetencionLogic tiporetencionLogic= new TipoRetencionLogic(connexion);
			tiporetencionLogic.deepLoad(facturaproveedor.getTipoRetencionFuente1(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(TipoRetencion.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			facturaproveedor.setTipoRetencionFuente2(facturaproveedorDataAccess.getTipoRetencionFuente2(connexion,facturaproveedor));
			TipoRetencionLogic tiporetencionLogic= new TipoRetencionLogic(connexion);
			tiporetencionLogic.deepLoad(facturaproveedor.getTipoRetencionFuente2(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(TipoRetencion.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			facturaproveedor.setTipoRetencionIva1(facturaproveedorDataAccess.getTipoRetencionIva1(connexion,facturaproveedor));
			TipoRetencionLogic tiporetencionLogic= new TipoRetencionLogic(connexion);
			tiporetencionLogic.deepLoad(facturaproveedor.getTipoRetencionIva1(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(TipoRetencion.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			facturaproveedor.setTipoRetencionIva2(facturaproveedorDataAccess.getTipoRetencionIva2(connexion,facturaproveedor));
			TipoRetencionLogic tiporetencionLogic= new TipoRetencionLogic(connexion);
			tiporetencionLogic.deepLoad(facturaproveedor.getTipoRetencionIva2(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(TipoTributario.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			facturaproveedor.setTipoTributario(facturaproveedorDataAccess.getTipoTributario(connexion,facturaproveedor));
			TipoTributarioLogic tipotributarioLogic= new TipoTributarioLogic(connexion);
			tipotributarioLogic.deepLoad(facturaproveedor.getTipoTributario(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(CuentaContable.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			facturaproveedor.setCuentaContableCreditoFiscalBienes(facturaproveedorDataAccess.getCuentaContableCreditoFiscalBienes(connexion,facturaproveedor));
			CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
			cuentacontableLogic.deepLoad(facturaproveedor.getCuentaContableCreditoFiscalBienes(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(ResponsableFondo.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			facturaproveedor.setResponsableFondo(facturaproveedorDataAccess.getResponsableFondo(connexion,facturaproveedor));
			ResponsableFondoLogic responsablefondoLogic= new ResponsableFondoLogic(connexion);
			responsablefondoLogic.deepLoad(facturaproveedor.getResponsableFondo(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(CuentaContable.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			facturaproveedor.setCuentaContableCreditoFiscalServicios(facturaproveedorDataAccess.getCuentaContableCreditoFiscalServicios(connexion,facturaproveedor));
			CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
			cuentacontableLogic.deepLoad(facturaproveedor.getCuentaContableCreditoFiscalServicios(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(CuentaContable.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			facturaproveedor.setCuentaContableGasto(facturaproveedorDataAccess.getCuentaContableGasto(connexion,facturaproveedor));
			CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
			cuentacontableLogic.deepLoad(facturaproveedor.getCuentaContableGasto(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(CuentaContable.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			facturaproveedor.setCuentaContableGasto2(facturaproveedorDataAccess.getCuentaContableGasto2(connexion,facturaproveedor));
			CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
			cuentacontableLogic.deepLoad(facturaproveedor.getCuentaContableGasto2(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(CuentaContable.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			facturaproveedor.setCuentaContableCreditoFin(facturaproveedorDataAccess.getCuentaContableCreditoFin(connexion,facturaproveedor));
			CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
			cuentacontableLogic.deepLoad(facturaproveedor.getCuentaContableCreditoFin(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(CuentaContable.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			facturaproveedor.setCuentaContableCreditoFin2(facturaproveedorDataAccess.getCuentaContableCreditoFin2(connexion,facturaproveedor));
			CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
			cuentacontableLogic.deepLoad(facturaproveedor.getCuentaContableCreditoFin2(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(CuentaContable.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			facturaproveedor.setCuentaContableCredito(facturaproveedorDataAccess.getCuentaContableCredito(connexion,facturaproveedor));
			CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
			cuentacontableLogic.deepLoad(facturaproveedor.getCuentaContableCredito(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(TipoMovimiento.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			facturaproveedor.setTipoMovimiento(facturaproveedorDataAccess.getTipoMovimiento(connexion,facturaproveedor));
			TipoMovimientoLogic tipomovimientoLogic= new TipoMovimientoLogic(connexion);
			tipomovimientoLogic.deepLoad(facturaproveedor.getTipoMovimiento(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(TipoMovimientoModulo.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			facturaproveedor.setTipoMovimientoModulo(facturaproveedorDataAccess.getTipoMovimientoModulo(connexion,facturaproveedor));
			TipoMovimientoModuloLogic tipomovimientomoduloLogic= new TipoMovimientoModuloLogic(connexion);
			tipomovimientomoduloLogic.deepLoad(facturaproveedor.getTipoMovimientoModulo(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(TipoTransaccionModulo.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			facturaproveedor.setTipoTransaccionModulo(facturaproveedorDataAccess.getTipoTransaccionModulo(connexion,facturaproveedor));
			TipoTransaccionModuloLogic tipotransaccionmoduloLogic= new TipoTransaccionModuloLogic(connexion);
			tipotransaccionmoduloLogic.deepLoad(facturaproveedor.getTipoTransaccionModulo(),isDeep,deepLoadType,clases);
				
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(DetalleFacturaProveedor.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(DetalleFacturaProveedor.class));
			facturaproveedor.setDetalleFacturaProveedors(facturaproveedorDataAccess.getDetalleFacturaProveedors(connexion,facturaproveedor));

			for(DetalleFacturaProveedor detallefacturaproveedor:facturaproveedor.getDetalleFacturaProveedors()) {
				DetalleFacturaProveedorLogic detallefacturaproveedorLogic= new DetalleFacturaProveedorLogic(connexion);
				detallefacturaproveedorLogic.deepLoad(detallefacturaproveedor,isDeep,deepLoadType,clases);
			}
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(FacturaProveedor facturaproveedor,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			FacturaProveedorLogicAdditional.updateFacturaProveedorToSave(facturaproveedor,this.arrDatoGeneral);
			
FacturaProveedorDataAccess.save(facturaproveedor, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(facturaproveedor.getEmpresa(),connexion);

		SucursalDataAccess.save(facturaproveedor.getSucursal(),connexion);

		EjercicioDataAccess.save(facturaproveedor.getEjercicio(),connexion);

		PeriodoDataAccess.save(facturaproveedor.getPeriodo(),connexion);

		AnioDataAccess.save(facturaproveedor.getAnio(),connexion);

		MesDataAccess.save(facturaproveedor.getMes(),connexion);

		ModuloDataAccess.save(facturaproveedor.getModulo(),connexion);

		PlantillaFacturaDataAccess.save(facturaproveedor.getPlantillaFactura(),connexion);

		TipoDocumentoDataAccess.save(facturaproveedor.getTipoDocumento(),connexion);

		FacturaDataAccess.save(facturaproveedor.getFactura(),connexion);

		TransaccionDataAccess.save(facturaproveedor.getTransaccion(),connexion);

		ClienteDataAccess.save(facturaproveedor.getCliente(),connexion);

		EmpleadoDataAccess.save(facturaproveedor.getEmpleadoSolicita(),connexion);

		MonedaDataAccess.save(facturaproveedor.getMoneda(),connexion);

		EmpleadoDataAccess.save(facturaproveedor.getEmpleado(),connexion);

		TipoRetencionDataAccess.save(facturaproveedor.getTipoRetencionFuente1(),connexion);

		TipoRetencionDataAccess.save(facturaproveedor.getTipoRetencionFuente2(),connexion);

		TipoRetencionDataAccess.save(facturaproveedor.getTipoRetencionIva1(),connexion);

		TipoRetencionDataAccess.save(facturaproveedor.getTipoRetencionIva2(),connexion);

		TipoTributarioDataAccess.save(facturaproveedor.getTipoTributario(),connexion);

		CuentaContableDataAccess.save(facturaproveedor.getCuentaContableCreditoFiscalBienes(),connexion);

		ResponsableFondoDataAccess.save(facturaproveedor.getResponsableFondo(),connexion);

		CuentaContableDataAccess.save(facturaproveedor.getCuentaContableCreditoFiscalServicios(),connexion);

		CuentaContableDataAccess.save(facturaproveedor.getCuentaContableGasto(),connexion);

		CuentaContableDataAccess.save(facturaproveedor.getCuentaContableGasto2(),connexion);

		CuentaContableDataAccess.save(facturaproveedor.getCuentaContableCreditoFin(),connexion);

		CuentaContableDataAccess.save(facturaproveedor.getCuentaContableCreditoFin2(),connexion);

		CuentaContableDataAccess.save(facturaproveedor.getCuentaContableCredito(),connexion);

		TipoMovimientoDataAccess.save(facturaproveedor.getTipoMovimiento(),connexion);

		TipoMovimientoModuloDataAccess.save(facturaproveedor.getTipoMovimientoModulo(),connexion);

		TipoTransaccionModuloDataAccess.save(facturaproveedor.getTipoTransaccionModulo(),connexion);

		for(DetalleFacturaProveedor detallefacturaproveedor:facturaproveedor.getDetalleFacturaProveedors()) {
			detallefacturaproveedor.setid_factura_proveedor(facturaproveedor.getId());
			DetalleFacturaProveedorDataAccess.save(detallefacturaproveedor,connexion);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(facturaproveedor.getEmpresa(),connexion);
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				SucursalDataAccess.save(facturaproveedor.getSucursal(),connexion);
				continue;
			}

			if(clas.clas.equals(Ejercicio.class)) {
				EjercicioDataAccess.save(facturaproveedor.getEjercicio(),connexion);
				continue;
			}

			if(clas.clas.equals(Periodo.class)) {
				PeriodoDataAccess.save(facturaproveedor.getPeriodo(),connexion);
				continue;
			}

			if(clas.clas.equals(Anio.class)) {
				AnioDataAccess.save(facturaproveedor.getAnio(),connexion);
				continue;
			}

			if(clas.clas.equals(Mes.class)) {
				MesDataAccess.save(facturaproveedor.getMes(),connexion);
				continue;
			}

			if(clas.clas.equals(Modulo.class)) {
				ModuloDataAccess.save(facturaproveedor.getModulo(),connexion);
				continue;
			}

			if(clas.clas.equals(PlantillaFactura.class)) {
				PlantillaFacturaDataAccess.save(facturaproveedor.getPlantillaFactura(),connexion);
				continue;
			}

			if(clas.clas.equals(TipoDocumento.class)) {
				TipoDocumentoDataAccess.save(facturaproveedor.getTipoDocumento(),connexion);
				continue;
			}

			if(clas.clas.equals(Factura.class)) {
				FacturaDataAccess.save(facturaproveedor.getFactura(),connexion);
				continue;
			}

			if(clas.clas.equals(Transaccion.class)) {
				TransaccionDataAccess.save(facturaproveedor.getTransaccion(),connexion);
				continue;
			}

			if(clas.clas.equals(Cliente.class)) {
				ClienteDataAccess.save(facturaproveedor.getCliente(),connexion);
				continue;
			}

			if(clas.clas.equals(Empleado.class)) {
				EmpleadoDataAccess.save(facturaproveedor.getEmpleadoSolicita(),connexion);
				continue;
			}

			if(clas.clas.equals(Moneda.class)) {
				MonedaDataAccess.save(facturaproveedor.getMoneda(),connexion);
				continue;
			}

			if(clas.clas.equals(Empleado.class)) {
				EmpleadoDataAccess.save(facturaproveedor.getEmpleado(),connexion);
				continue;
			}

			if(clas.clas.equals(TipoRetencion.class)) {
				TipoRetencionDataAccess.save(facturaproveedor.getTipoRetencionFuente1(),connexion);
				continue;
			}

			if(clas.clas.equals(TipoRetencion.class)) {
				TipoRetencionDataAccess.save(facturaproveedor.getTipoRetencionFuente2(),connexion);
				continue;
			}

			if(clas.clas.equals(TipoRetencion.class)) {
				TipoRetencionDataAccess.save(facturaproveedor.getTipoRetencionIva1(),connexion);
				continue;
			}

			if(clas.clas.equals(TipoRetencion.class)) {
				TipoRetencionDataAccess.save(facturaproveedor.getTipoRetencionIva2(),connexion);
				continue;
			}

			if(clas.clas.equals(TipoTributario.class)) {
				TipoTributarioDataAccess.save(facturaproveedor.getTipoTributario(),connexion);
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				CuentaContableDataAccess.save(facturaproveedor.getCuentaContableCreditoFiscalBienes(),connexion);
				continue;
			}

			if(clas.clas.equals(ResponsableFondo.class)) {
				ResponsableFondoDataAccess.save(facturaproveedor.getResponsableFondo(),connexion);
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				CuentaContableDataAccess.save(facturaproveedor.getCuentaContableCreditoFiscalServicios(),connexion);
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				CuentaContableDataAccess.save(facturaproveedor.getCuentaContableGasto(),connexion);
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				CuentaContableDataAccess.save(facturaproveedor.getCuentaContableGasto2(),connexion);
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				CuentaContableDataAccess.save(facturaproveedor.getCuentaContableCreditoFin(),connexion);
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				CuentaContableDataAccess.save(facturaproveedor.getCuentaContableCreditoFin2(),connexion);
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				CuentaContableDataAccess.save(facturaproveedor.getCuentaContableCredito(),connexion);
				continue;
			}

			if(clas.clas.equals(TipoMovimiento.class)) {
				TipoMovimientoDataAccess.save(facturaproveedor.getTipoMovimiento(),connexion);
				continue;
			}

			if(clas.clas.equals(TipoMovimientoModulo.class)) {
				TipoMovimientoModuloDataAccess.save(facturaproveedor.getTipoMovimientoModulo(),connexion);
				continue;
			}

			if(clas.clas.equals(TipoTransaccionModulo.class)) {
				TipoTransaccionModuloDataAccess.save(facturaproveedor.getTipoTransaccionModulo(),connexion);
				continue;
			}


			if(clas.clas.equals(DetalleFacturaProveedor.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(DetalleFacturaProveedor detallefacturaproveedor:facturaproveedor.getDetalleFacturaProveedors()) {
					detallefacturaproveedor.setid_factura_proveedor(facturaproveedor.getId());
					DetalleFacturaProveedorDataAccess.save(detallefacturaproveedor,connexion);
				}
				continue;
			}
		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(facturaproveedor.getEmpresa(),connexion);
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(facturaproveedor.getEmpresa(),isDeep,deepLoadType,clases);
				

		SucursalDataAccess.save(facturaproveedor.getSucursal(),connexion);
		SucursalLogic sucursalLogic= new SucursalLogic(connexion);
		sucursalLogic.deepLoad(facturaproveedor.getSucursal(),isDeep,deepLoadType,clases);
				

		EjercicioDataAccess.save(facturaproveedor.getEjercicio(),connexion);
		EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
		ejercicioLogic.deepLoad(facturaproveedor.getEjercicio(),isDeep,deepLoadType,clases);
				

		PeriodoDataAccess.save(facturaproveedor.getPeriodo(),connexion);
		PeriodoLogic periodoLogic= new PeriodoLogic(connexion);
		periodoLogic.deepLoad(facturaproveedor.getPeriodo(),isDeep,deepLoadType,clases);
				

		AnioDataAccess.save(facturaproveedor.getAnio(),connexion);
		AnioLogic anioLogic= new AnioLogic(connexion);
		anioLogic.deepLoad(facturaproveedor.getAnio(),isDeep,deepLoadType,clases);
				

		MesDataAccess.save(facturaproveedor.getMes(),connexion);
		MesLogic mesLogic= new MesLogic(connexion);
		mesLogic.deepLoad(facturaproveedor.getMes(),isDeep,deepLoadType,clases);
				

		ModuloDataAccess.save(facturaproveedor.getModulo(),connexion);
		ModuloLogic moduloLogic= new ModuloLogic(connexion);
		moduloLogic.deepLoad(facturaproveedor.getModulo(),isDeep,deepLoadType,clases);
				

		PlantillaFacturaDataAccess.save(facturaproveedor.getPlantillaFactura(),connexion);
		PlantillaFacturaLogic plantillafacturaLogic= new PlantillaFacturaLogic(connexion);
		plantillafacturaLogic.deepLoad(facturaproveedor.getPlantillaFactura(),isDeep,deepLoadType,clases);
				

		TipoDocumentoDataAccess.save(facturaproveedor.getTipoDocumento(),connexion);
		TipoDocumentoLogic tipodocumentoLogic= new TipoDocumentoLogic(connexion);
		tipodocumentoLogic.deepLoad(facturaproveedor.getTipoDocumento(),isDeep,deepLoadType,clases);
				

		FacturaDataAccess.save(facturaproveedor.getFactura(),connexion);
		FacturaLogic facturaLogic= new FacturaLogic(connexion);
		facturaLogic.deepLoad(facturaproveedor.getFactura(),isDeep,deepLoadType,clases);
				

		TransaccionDataAccess.save(facturaproveedor.getTransaccion(),connexion);
		TransaccionLogic transaccionLogic= new TransaccionLogic(connexion);
		transaccionLogic.deepLoad(facturaproveedor.getTransaccion(),isDeep,deepLoadType,clases);
				

		ClienteDataAccess.save(facturaproveedor.getCliente(),connexion);
		ClienteLogic clienteLogic= new ClienteLogic(connexion);
		clienteLogic.deepLoad(facturaproveedor.getCliente(),isDeep,deepLoadType,clases);
				

		EmpleadoDataAccess.save(facturaproveedor.getEmpleadoSolicita(),connexion);
		EmpleadoLogic empleadosolicitaLogic= new EmpleadoLogic(connexion);
		empleadosolicitaLogic.deepLoad(facturaproveedor.getEmpleadoSolicita(),isDeep,deepLoadType,clases);
				

		MonedaDataAccess.save(facturaproveedor.getMoneda(),connexion);
		MonedaLogic monedaLogic= new MonedaLogic(connexion);
		monedaLogic.deepLoad(facturaproveedor.getMoneda(),isDeep,deepLoadType,clases);
				

		EmpleadoDataAccess.save(facturaproveedor.getEmpleado(),connexion);
		EmpleadoLogic empleadoLogic= new EmpleadoLogic(connexion);
		empleadoLogic.deepLoad(facturaproveedor.getEmpleado(),isDeep,deepLoadType,clases);
				

		TipoRetencionDataAccess.save(facturaproveedor.getTipoRetencionFuente1(),connexion);
		TipoRetencionLogic tiporetencionfuente1Logic= new TipoRetencionLogic(connexion);
		tiporetencionfuente1Logic.deepLoad(facturaproveedor.getTipoRetencionFuente1(),isDeep,deepLoadType,clases);
				

		TipoRetencionDataAccess.save(facturaproveedor.getTipoRetencionFuente2(),connexion);
		TipoRetencionLogic tiporetencionfuente2Logic= new TipoRetencionLogic(connexion);
		tiporetencionfuente2Logic.deepLoad(facturaproveedor.getTipoRetencionFuente2(),isDeep,deepLoadType,clases);
				

		TipoRetencionDataAccess.save(facturaproveedor.getTipoRetencionIva1(),connexion);
		TipoRetencionLogic tiporetencioniva1Logic= new TipoRetencionLogic(connexion);
		tiporetencioniva1Logic.deepLoad(facturaproveedor.getTipoRetencionIva1(),isDeep,deepLoadType,clases);
				

		TipoRetencionDataAccess.save(facturaproveedor.getTipoRetencionIva2(),connexion);
		TipoRetencionLogic tiporetencioniva2Logic= new TipoRetencionLogic(connexion);
		tiporetencioniva2Logic.deepLoad(facturaproveedor.getTipoRetencionIva2(),isDeep,deepLoadType,clases);
				

		TipoTributarioDataAccess.save(facturaproveedor.getTipoTributario(),connexion);
		TipoTributarioLogic tipotributarioLogic= new TipoTributarioLogic(connexion);
		tipotributarioLogic.deepLoad(facturaproveedor.getTipoTributario(),isDeep,deepLoadType,clases);
				

		CuentaContableDataAccess.save(facturaproveedor.getCuentaContableCreditoFiscalBienes(),connexion);
		CuentaContableLogic cuentacontablecreditofiscalbienesLogic= new CuentaContableLogic(connexion);
		cuentacontablecreditofiscalbienesLogic.deepLoad(facturaproveedor.getCuentaContableCreditoFiscalBienes(),isDeep,deepLoadType,clases);
				

		ResponsableFondoDataAccess.save(facturaproveedor.getResponsableFondo(),connexion);
		ResponsableFondoLogic responsablefondoLogic= new ResponsableFondoLogic(connexion);
		responsablefondoLogic.deepLoad(facturaproveedor.getResponsableFondo(),isDeep,deepLoadType,clases);
				

		CuentaContableDataAccess.save(facturaproveedor.getCuentaContableCreditoFiscalServicios(),connexion);
		CuentaContableLogic cuentacontablecreditofiscalserviciosLogic= new CuentaContableLogic(connexion);
		cuentacontablecreditofiscalserviciosLogic.deepLoad(facturaproveedor.getCuentaContableCreditoFiscalServicios(),isDeep,deepLoadType,clases);
				

		CuentaContableDataAccess.save(facturaproveedor.getCuentaContableGasto(),connexion);
		CuentaContableLogic cuentacontablegastoLogic= new CuentaContableLogic(connexion);
		cuentacontablegastoLogic.deepLoad(facturaproveedor.getCuentaContableGasto(),isDeep,deepLoadType,clases);
				

		CuentaContableDataAccess.save(facturaproveedor.getCuentaContableGasto2(),connexion);
		CuentaContableLogic cuentacontablegasto2Logic= new CuentaContableLogic(connexion);
		cuentacontablegasto2Logic.deepLoad(facturaproveedor.getCuentaContableGasto2(),isDeep,deepLoadType,clases);
				

		CuentaContableDataAccess.save(facturaproveedor.getCuentaContableCreditoFin(),connexion);
		CuentaContableLogic cuentacontablecreditofinLogic= new CuentaContableLogic(connexion);
		cuentacontablecreditofinLogic.deepLoad(facturaproveedor.getCuentaContableCreditoFin(),isDeep,deepLoadType,clases);
				

		CuentaContableDataAccess.save(facturaproveedor.getCuentaContableCreditoFin2(),connexion);
		CuentaContableLogic cuentacontablecreditofin2Logic= new CuentaContableLogic(connexion);
		cuentacontablecreditofin2Logic.deepLoad(facturaproveedor.getCuentaContableCreditoFin2(),isDeep,deepLoadType,clases);
				

		CuentaContableDataAccess.save(facturaproveedor.getCuentaContableCredito(),connexion);
		CuentaContableLogic cuentacontablecreditoLogic= new CuentaContableLogic(connexion);
		cuentacontablecreditoLogic.deepLoad(facturaproveedor.getCuentaContableCredito(),isDeep,deepLoadType,clases);
				

		TipoMovimientoDataAccess.save(facturaproveedor.getTipoMovimiento(),connexion);
		TipoMovimientoLogic tipomovimientoLogic= new TipoMovimientoLogic(connexion);
		tipomovimientoLogic.deepLoad(facturaproveedor.getTipoMovimiento(),isDeep,deepLoadType,clases);
				

		TipoMovimientoModuloDataAccess.save(facturaproveedor.getTipoMovimientoModulo(),connexion);
		TipoMovimientoModuloLogic tipomovimientomoduloLogic= new TipoMovimientoModuloLogic(connexion);
		tipomovimientomoduloLogic.deepLoad(facturaproveedor.getTipoMovimientoModulo(),isDeep,deepLoadType,clases);
				

		TipoTransaccionModuloDataAccess.save(facturaproveedor.getTipoTransaccionModulo(),connexion);
		TipoTransaccionModuloLogic tipotransaccionmoduloLogic= new TipoTransaccionModuloLogic(connexion);
		tipotransaccionmoduloLogic.deepLoad(facturaproveedor.getTipoTransaccionModulo(),isDeep,deepLoadType,clases);
				

		for(DetalleFacturaProveedor detallefacturaproveedor:facturaproveedor.getDetalleFacturaProveedors()) {
			DetalleFacturaProveedorLogic detallefacturaproveedorLogic= new DetalleFacturaProveedorLogic(connexion);
			detallefacturaproveedor.setid_factura_proveedor(facturaproveedor.getId());
			DetalleFacturaProveedorDataAccess.save(detallefacturaproveedor,connexion);
			detallefacturaproveedorLogic.deepSave(detallefacturaproveedor,isDeep,deepLoadType,clases);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(facturaproveedor.getEmpresa(),connexion);
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepSave(facturaproveedor.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				SucursalDataAccess.save(facturaproveedor.getSucursal(),connexion);
				SucursalLogic sucursalLogic= new SucursalLogic(connexion);
				sucursalLogic.deepSave(facturaproveedor.getSucursal(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Ejercicio.class)) {
				EjercicioDataAccess.save(facturaproveedor.getEjercicio(),connexion);
				EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
				ejercicioLogic.deepSave(facturaproveedor.getEjercicio(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Periodo.class)) {
				PeriodoDataAccess.save(facturaproveedor.getPeriodo(),connexion);
				PeriodoLogic periodoLogic= new PeriodoLogic(connexion);
				periodoLogic.deepSave(facturaproveedor.getPeriodo(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Anio.class)) {
				AnioDataAccess.save(facturaproveedor.getAnio(),connexion);
				AnioLogic anioLogic= new AnioLogic(connexion);
				anioLogic.deepSave(facturaproveedor.getAnio(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Mes.class)) {
				MesDataAccess.save(facturaproveedor.getMes(),connexion);
				MesLogic mesLogic= new MesLogic(connexion);
				mesLogic.deepSave(facturaproveedor.getMes(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Modulo.class)) {
				ModuloDataAccess.save(facturaproveedor.getModulo(),connexion);
				ModuloLogic moduloLogic= new ModuloLogic(connexion);
				moduloLogic.deepSave(facturaproveedor.getModulo(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(PlantillaFactura.class)) {
				PlantillaFacturaDataAccess.save(facturaproveedor.getPlantillaFactura(),connexion);
				PlantillaFacturaLogic plantillafacturaLogic= new PlantillaFacturaLogic(connexion);
				plantillafacturaLogic.deepSave(facturaproveedor.getPlantillaFactura(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoDocumento.class)) {
				TipoDocumentoDataAccess.save(facturaproveedor.getTipoDocumento(),connexion);
				TipoDocumentoLogic tipodocumentoLogic= new TipoDocumentoLogic(connexion);
				tipodocumentoLogic.deepSave(facturaproveedor.getTipoDocumento(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Factura.class)) {
				FacturaDataAccess.save(facturaproveedor.getFactura(),connexion);
				FacturaLogic facturaLogic= new FacturaLogic(connexion);
				facturaLogic.deepSave(facturaproveedor.getFactura(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Transaccion.class)) {
				TransaccionDataAccess.save(facturaproveedor.getTransaccion(),connexion);
				TransaccionLogic transaccionLogic= new TransaccionLogic(connexion);
				transaccionLogic.deepSave(facturaproveedor.getTransaccion(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Cliente.class)) {
				ClienteDataAccess.save(facturaproveedor.getCliente(),connexion);
				ClienteLogic clienteLogic= new ClienteLogic(connexion);
				clienteLogic.deepSave(facturaproveedor.getCliente(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Empleado.class)) {
				EmpleadoDataAccess.save(facturaproveedor.getEmpleadoSolicita(),connexion);
				EmpleadoLogic empleadoLogic= new EmpleadoLogic(connexion);
				empleadoLogic.deepSave(facturaproveedor.getEmpleadoSolicita(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Moneda.class)) {
				MonedaDataAccess.save(facturaproveedor.getMoneda(),connexion);
				MonedaLogic monedaLogic= new MonedaLogic(connexion);
				monedaLogic.deepSave(facturaproveedor.getMoneda(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Empleado.class)) {
				EmpleadoDataAccess.save(facturaproveedor.getEmpleado(),connexion);
				EmpleadoLogic empleadoLogic= new EmpleadoLogic(connexion);
				empleadoLogic.deepSave(facturaproveedor.getEmpleado(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoRetencion.class)) {
				TipoRetencionDataAccess.save(facturaproveedor.getTipoRetencionFuente1(),connexion);
				TipoRetencionLogic tiporetencionLogic= new TipoRetencionLogic(connexion);
				tiporetencionLogic.deepSave(facturaproveedor.getTipoRetencionFuente1(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoRetencion.class)) {
				TipoRetencionDataAccess.save(facturaproveedor.getTipoRetencionFuente2(),connexion);
				TipoRetencionLogic tiporetencionLogic= new TipoRetencionLogic(connexion);
				tiporetencionLogic.deepSave(facturaproveedor.getTipoRetencionFuente2(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoRetencion.class)) {
				TipoRetencionDataAccess.save(facturaproveedor.getTipoRetencionIva1(),connexion);
				TipoRetencionLogic tiporetencionLogic= new TipoRetencionLogic(connexion);
				tiporetencionLogic.deepSave(facturaproveedor.getTipoRetencionIva1(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoRetencion.class)) {
				TipoRetencionDataAccess.save(facturaproveedor.getTipoRetencionIva2(),connexion);
				TipoRetencionLogic tiporetencionLogic= new TipoRetencionLogic(connexion);
				tiporetencionLogic.deepSave(facturaproveedor.getTipoRetencionIva2(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoTributario.class)) {
				TipoTributarioDataAccess.save(facturaproveedor.getTipoTributario(),connexion);
				TipoTributarioLogic tipotributarioLogic= new TipoTributarioLogic(connexion);
				tipotributarioLogic.deepSave(facturaproveedor.getTipoTributario(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				CuentaContableDataAccess.save(facturaproveedor.getCuentaContableCreditoFiscalBienes(),connexion);
				CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
				cuentacontableLogic.deepSave(facturaproveedor.getCuentaContableCreditoFiscalBienes(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(ResponsableFondo.class)) {
				ResponsableFondoDataAccess.save(facturaproveedor.getResponsableFondo(),connexion);
				ResponsableFondoLogic responsablefondoLogic= new ResponsableFondoLogic(connexion);
				responsablefondoLogic.deepSave(facturaproveedor.getResponsableFondo(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				CuentaContableDataAccess.save(facturaproveedor.getCuentaContableCreditoFiscalServicios(),connexion);
				CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
				cuentacontableLogic.deepSave(facturaproveedor.getCuentaContableCreditoFiscalServicios(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				CuentaContableDataAccess.save(facturaproveedor.getCuentaContableGasto(),connexion);
				CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
				cuentacontableLogic.deepSave(facturaproveedor.getCuentaContableGasto(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				CuentaContableDataAccess.save(facturaproveedor.getCuentaContableGasto2(),connexion);
				CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
				cuentacontableLogic.deepSave(facturaproveedor.getCuentaContableGasto2(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				CuentaContableDataAccess.save(facturaproveedor.getCuentaContableCreditoFin(),connexion);
				CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
				cuentacontableLogic.deepSave(facturaproveedor.getCuentaContableCreditoFin(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				CuentaContableDataAccess.save(facturaproveedor.getCuentaContableCreditoFin2(),connexion);
				CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
				cuentacontableLogic.deepSave(facturaproveedor.getCuentaContableCreditoFin2(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				CuentaContableDataAccess.save(facturaproveedor.getCuentaContableCredito(),connexion);
				CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
				cuentacontableLogic.deepSave(facturaproveedor.getCuentaContableCredito(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoMovimiento.class)) {
				TipoMovimientoDataAccess.save(facturaproveedor.getTipoMovimiento(),connexion);
				TipoMovimientoLogic tipomovimientoLogic= new TipoMovimientoLogic(connexion);
				tipomovimientoLogic.deepSave(facturaproveedor.getTipoMovimiento(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoMovimientoModulo.class)) {
				TipoMovimientoModuloDataAccess.save(facturaproveedor.getTipoMovimientoModulo(),connexion);
				TipoMovimientoModuloLogic tipomovimientomoduloLogic= new TipoMovimientoModuloLogic(connexion);
				tipomovimientomoduloLogic.deepSave(facturaproveedor.getTipoMovimientoModulo(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoTransaccionModulo.class)) {
				TipoTransaccionModuloDataAccess.save(facturaproveedor.getTipoTransaccionModulo(),connexion);
				TipoTransaccionModuloLogic tipotransaccionmoduloLogic= new TipoTransaccionModuloLogic(connexion);
				tipotransaccionmoduloLogic.deepSave(facturaproveedor.getTipoTransaccionModulo(),isDeep,deepLoadType,clases);				
				continue;
			}


			if(clas.clas.equals(DetalleFacturaProveedor.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(DetalleFacturaProveedor detallefacturaproveedor:facturaproveedor.getDetalleFacturaProveedors()) {
					DetalleFacturaProveedorLogic detallefacturaproveedorLogic= new DetalleFacturaProveedorLogic(connexion);
					detallefacturaproveedor.setid_factura_proveedor(facturaproveedor.getId());
					DetalleFacturaProveedorDataAccess.save(detallefacturaproveedor,connexion);
					detallefacturaproveedorLogic.deepSave(detallefacturaproveedor,isDeep,deepLoadType,clases);
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
			this.getNewConnexionToDeep(FacturaProveedor.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(facturaproveedor,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				FacturaProveedorConstantesFunciones.refrescarForeignKeysDescripcionesFacturaProveedor(facturaproveedor);
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
			this.deepLoad(this.facturaproveedor,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				FacturaProveedorConstantesFunciones.refrescarForeignKeysDescripcionesFacturaProveedor(this.facturaproveedor);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(FacturaProveedor.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(facturaproveedors!=null) {
				for(FacturaProveedor facturaproveedor:facturaproveedors) {
					this.deepLoad(facturaproveedor,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					FacturaProveedorConstantesFunciones.refrescarForeignKeysDescripcionesFacturaProveedor(facturaproveedors);
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
			if(facturaproveedors!=null) {
				for(FacturaProveedor facturaproveedor:facturaproveedors) {
					this.deepLoad(facturaproveedor,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					FacturaProveedorConstantesFunciones.refrescarForeignKeysDescripcionesFacturaProveedor(facturaproveedors);
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
			this.getNewConnexionToDeep(FacturaProveedor.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(facturaproveedor,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(FacturaProveedor.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(facturaproveedors!=null) {
				for(FacturaProveedor facturaproveedor:facturaproveedors) {
					this.deepSave(facturaproveedor,isDeep,deepLoadType,clases);
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
			if(facturaproveedors!=null) {
				for(FacturaProveedor facturaproveedor:facturaproveedors) {
					this.deepSave(facturaproveedor,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getFacturaProveedorsFK_IdAnioWithConnection(String sFinalQuery,Pagination pagination,Long id_anio)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FacturaProveedor.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidAnio= new ParameterSelectionGeneral();
			parameterSelectionGeneralidAnio.setParameterSelectionGeneralEqual(ParameterType.LONG,id_anio,FacturaProveedorConstantesFunciones.IDANIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidAnio);

			FacturaProveedorLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdAnio","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			facturaproveedors=facturaproveedorDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				FacturaProveedorConstantesFunciones.refrescarForeignKeysDescripcionesFacturaProveedor(this.facturaproveedors);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getFacturaProveedorsFK_IdAnio(String sFinalQuery,Pagination pagination,Long id_anio)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidAnio= new ParameterSelectionGeneral();
			parameterSelectionGeneralidAnio.setParameterSelectionGeneralEqual(ParameterType.LONG,id_anio,FacturaProveedorConstantesFunciones.IDANIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidAnio);

			FacturaProveedorLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdAnio","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			facturaproveedors=facturaproveedorDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				FacturaProveedorConstantesFunciones.refrescarForeignKeysDescripcionesFacturaProveedor(this.facturaproveedors);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getFacturaProveedorsFK_IdClienteWithConnection(String sFinalQuery,Pagination pagination,Long id_cliente)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FacturaProveedor.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCliente= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCliente.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cliente,FacturaProveedorConstantesFunciones.IDCLIENTE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCliente);

			FacturaProveedorLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCliente","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			facturaproveedors=facturaproveedorDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				FacturaProveedorConstantesFunciones.refrescarForeignKeysDescripcionesFacturaProveedor(this.facturaproveedors);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getFacturaProveedorsFK_IdCliente(String sFinalQuery,Pagination pagination,Long id_cliente)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCliente= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCliente.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cliente,FacturaProveedorConstantesFunciones.IDCLIENTE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCliente);

			FacturaProveedorLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCliente","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			facturaproveedors=facturaproveedorDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				FacturaProveedorConstantesFunciones.refrescarForeignKeysDescripcionesFacturaProveedor(this.facturaproveedors);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getFacturaProveedorsFK_IdCuentaContableCreditoWithConnection(String sFinalQuery,Pagination pagination,Long id_cuenta_contable_credito)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FacturaProveedor.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCuentaContableCredito= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCuentaContableCredito.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cuenta_contable_credito,FacturaProveedorConstantesFunciones.IDCUENTACONTABLECREDITO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCuentaContableCredito);

			FacturaProveedorLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCuentaContableCredito","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			facturaproveedors=facturaproveedorDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				FacturaProveedorConstantesFunciones.refrescarForeignKeysDescripcionesFacturaProveedor(this.facturaproveedors);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getFacturaProveedorsFK_IdCuentaContableCredito(String sFinalQuery,Pagination pagination,Long id_cuenta_contable_credito)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCuentaContableCredito= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCuentaContableCredito.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cuenta_contable_credito,FacturaProveedorConstantesFunciones.IDCUENTACONTABLECREDITO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCuentaContableCredito);

			FacturaProveedorLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCuentaContableCredito","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			facturaproveedors=facturaproveedorDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				FacturaProveedorConstantesFunciones.refrescarForeignKeysDescripcionesFacturaProveedor(this.facturaproveedors);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getFacturaProveedorsFK_IdCuentaContableCreditoFinWithConnection(String sFinalQuery,Pagination pagination,Long id_cuenta_contable_credito_fin)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FacturaProveedor.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCuentaContableCreditoFin= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCuentaContableCreditoFin.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cuenta_contable_credito_fin,FacturaProveedorConstantesFunciones.IDCUENTACONTABLECREDITOFIN,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCuentaContableCreditoFin);

			FacturaProveedorLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCuentaContableCreditoFin","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			facturaproveedors=facturaproveedorDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				FacturaProveedorConstantesFunciones.refrescarForeignKeysDescripcionesFacturaProveedor(this.facturaproveedors);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getFacturaProveedorsFK_IdCuentaContableCreditoFin(String sFinalQuery,Pagination pagination,Long id_cuenta_contable_credito_fin)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCuentaContableCreditoFin= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCuentaContableCreditoFin.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cuenta_contable_credito_fin,FacturaProveedorConstantesFunciones.IDCUENTACONTABLECREDITOFIN,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCuentaContableCreditoFin);

			FacturaProveedorLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCuentaContableCreditoFin","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			facturaproveedors=facturaproveedorDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				FacturaProveedorConstantesFunciones.refrescarForeignKeysDescripcionesFacturaProveedor(this.facturaproveedors);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getFacturaProveedorsFK_IdCuentaContableCreditoFin2WithConnection(String sFinalQuery,Pagination pagination,Long id_cuenta_contable_credito_fin2)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FacturaProveedor.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCuentaContableCreditoFin2= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCuentaContableCreditoFin2.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cuenta_contable_credito_fin2,FacturaProveedorConstantesFunciones.IDCUENTACONTABLECREDITOFIN2,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCuentaContableCreditoFin2);

			FacturaProveedorLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCuentaContableCreditoFin2","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			facturaproveedors=facturaproveedorDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				FacturaProveedorConstantesFunciones.refrescarForeignKeysDescripcionesFacturaProveedor(this.facturaproveedors);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getFacturaProveedorsFK_IdCuentaContableCreditoFin2(String sFinalQuery,Pagination pagination,Long id_cuenta_contable_credito_fin2)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCuentaContableCreditoFin2= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCuentaContableCreditoFin2.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cuenta_contable_credito_fin2,FacturaProveedorConstantesFunciones.IDCUENTACONTABLECREDITOFIN2,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCuentaContableCreditoFin2);

			FacturaProveedorLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCuentaContableCreditoFin2","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			facturaproveedors=facturaproveedorDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				FacturaProveedorConstantesFunciones.refrescarForeignKeysDescripcionesFacturaProveedor(this.facturaproveedors);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getFacturaProveedorsFK_IdCuentaContableCreditoFiscalBienesWithConnection(String sFinalQuery,Pagination pagination,Long id_cuenta_contable_credito_fiscal_bienes)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FacturaProveedor.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCuentaContableCreditoFiscalBienes= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCuentaContableCreditoFiscalBienes.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cuenta_contable_credito_fiscal_bienes,FacturaProveedorConstantesFunciones.IDCUENTACONTABLECREDITOFISCALBIENES,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCuentaContableCreditoFiscalBienes);

			FacturaProveedorLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCuentaContableCreditoFiscalBienes","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			facturaproveedors=facturaproveedorDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				FacturaProveedorConstantesFunciones.refrescarForeignKeysDescripcionesFacturaProveedor(this.facturaproveedors);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getFacturaProveedorsFK_IdCuentaContableCreditoFiscalBienes(String sFinalQuery,Pagination pagination,Long id_cuenta_contable_credito_fiscal_bienes)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCuentaContableCreditoFiscalBienes= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCuentaContableCreditoFiscalBienes.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cuenta_contable_credito_fiscal_bienes,FacturaProveedorConstantesFunciones.IDCUENTACONTABLECREDITOFISCALBIENES,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCuentaContableCreditoFiscalBienes);

			FacturaProveedorLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCuentaContableCreditoFiscalBienes","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			facturaproveedors=facturaproveedorDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				FacturaProveedorConstantesFunciones.refrescarForeignKeysDescripcionesFacturaProveedor(this.facturaproveedors);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getFacturaProveedorsFK_IdCuentaContableCreditoFiscalServiciosWithConnection(String sFinalQuery,Pagination pagination,Long id_cuenta_contable_credito_fiscal_servicios)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FacturaProveedor.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCuentaContableCreditoFiscalServicios= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCuentaContableCreditoFiscalServicios.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cuenta_contable_credito_fiscal_servicios,FacturaProveedorConstantesFunciones.IDCUENTACONTABLECREDITOFISCALSERVICIOS,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCuentaContableCreditoFiscalServicios);

			FacturaProveedorLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCuentaContableCreditoFiscalServicios","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			facturaproveedors=facturaproveedorDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				FacturaProveedorConstantesFunciones.refrescarForeignKeysDescripcionesFacturaProveedor(this.facturaproveedors);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getFacturaProveedorsFK_IdCuentaContableCreditoFiscalServicios(String sFinalQuery,Pagination pagination,Long id_cuenta_contable_credito_fiscal_servicios)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCuentaContableCreditoFiscalServicios= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCuentaContableCreditoFiscalServicios.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cuenta_contable_credito_fiscal_servicios,FacturaProveedorConstantesFunciones.IDCUENTACONTABLECREDITOFISCALSERVICIOS,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCuentaContableCreditoFiscalServicios);

			FacturaProveedorLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCuentaContableCreditoFiscalServicios","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			facturaproveedors=facturaproveedorDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				FacturaProveedorConstantesFunciones.refrescarForeignKeysDescripcionesFacturaProveedor(this.facturaproveedors);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getFacturaProveedorsFK_IdCuentaContableGastoWithConnection(String sFinalQuery,Pagination pagination,Long id_cuenta_contable_gasto)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FacturaProveedor.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCuentaContableGasto= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCuentaContableGasto.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cuenta_contable_gasto,FacturaProveedorConstantesFunciones.IDCUENTACONTABLEGASTO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCuentaContableGasto);

			FacturaProveedorLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCuentaContableGasto","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			facturaproveedors=facturaproveedorDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				FacturaProveedorConstantesFunciones.refrescarForeignKeysDescripcionesFacturaProveedor(this.facturaproveedors);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getFacturaProveedorsFK_IdCuentaContableGasto(String sFinalQuery,Pagination pagination,Long id_cuenta_contable_gasto)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCuentaContableGasto= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCuentaContableGasto.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cuenta_contable_gasto,FacturaProveedorConstantesFunciones.IDCUENTACONTABLEGASTO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCuentaContableGasto);

			FacturaProveedorLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCuentaContableGasto","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			facturaproveedors=facturaproveedorDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				FacturaProveedorConstantesFunciones.refrescarForeignKeysDescripcionesFacturaProveedor(this.facturaproveedors);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getFacturaProveedorsFK_IdCuentaContableGasto2WithConnection(String sFinalQuery,Pagination pagination,Long id_cuenta_contable_gasto2)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FacturaProveedor.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCuentaContableGasto2= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCuentaContableGasto2.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cuenta_contable_gasto2,FacturaProveedorConstantesFunciones.IDCUENTACONTABLEGASTO2,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCuentaContableGasto2);

			FacturaProveedorLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCuentaContableGasto2","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			facturaproveedors=facturaproveedorDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				FacturaProveedorConstantesFunciones.refrescarForeignKeysDescripcionesFacturaProveedor(this.facturaproveedors);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getFacturaProveedorsFK_IdCuentaContableGasto2(String sFinalQuery,Pagination pagination,Long id_cuenta_contable_gasto2)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCuentaContableGasto2= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCuentaContableGasto2.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cuenta_contable_gasto2,FacturaProveedorConstantesFunciones.IDCUENTACONTABLEGASTO2,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCuentaContableGasto2);

			FacturaProveedorLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCuentaContableGasto2","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			facturaproveedors=facturaproveedorDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				FacturaProveedorConstantesFunciones.refrescarForeignKeysDescripcionesFacturaProveedor(this.facturaproveedors);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getFacturaProveedorsFK_IdEjercicioWithConnection(String sFinalQuery,Pagination pagination,Long id_ejercicio)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FacturaProveedor.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEjercicio= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEjercicio.setParameterSelectionGeneralEqual(ParameterType.LONG,id_ejercicio,FacturaProveedorConstantesFunciones.IDEJERCICIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEjercicio);

			FacturaProveedorLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEjercicio","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			facturaproveedors=facturaproveedorDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				FacturaProveedorConstantesFunciones.refrescarForeignKeysDescripcionesFacturaProveedor(this.facturaproveedors);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getFacturaProveedorsFK_IdEjercicio(String sFinalQuery,Pagination pagination,Long id_ejercicio)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEjercicio= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEjercicio.setParameterSelectionGeneralEqual(ParameterType.LONG,id_ejercicio,FacturaProveedorConstantesFunciones.IDEJERCICIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEjercicio);

			FacturaProveedorLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEjercicio","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			facturaproveedors=facturaproveedorDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				FacturaProveedorConstantesFunciones.refrescarForeignKeysDescripcionesFacturaProveedor(this.facturaproveedors);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getFacturaProveedorsFK_IdEmpleadoWithConnection(String sFinalQuery,Pagination pagination,Long id_empleado)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FacturaProveedor.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpleado= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpleado.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empleado,FacturaProveedorConstantesFunciones.IDEMPLEADO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpleado);

			FacturaProveedorLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpleado","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			facturaproveedors=facturaproveedorDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				FacturaProveedorConstantesFunciones.refrescarForeignKeysDescripcionesFacturaProveedor(this.facturaproveedors);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getFacturaProveedorsFK_IdEmpleado(String sFinalQuery,Pagination pagination,Long id_empleado)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpleado= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpleado.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empleado,FacturaProveedorConstantesFunciones.IDEMPLEADO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpleado);

			FacturaProveedorLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpleado","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			facturaproveedors=facturaproveedorDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				FacturaProveedorConstantesFunciones.refrescarForeignKeysDescripcionesFacturaProveedor(this.facturaproveedors);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getFacturaProveedorsFK_IdEmpleadoSolicitaWithConnection(String sFinalQuery,Pagination pagination,Long id_empleado_solicita)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FacturaProveedor.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpleadoSolicita= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpleadoSolicita.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empleado_solicita,FacturaProveedorConstantesFunciones.IDEMPLEADOSOLICITA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpleadoSolicita);

			FacturaProveedorLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpleadoSolicita","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			facturaproveedors=facturaproveedorDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				FacturaProveedorConstantesFunciones.refrescarForeignKeysDescripcionesFacturaProveedor(this.facturaproveedors);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getFacturaProveedorsFK_IdEmpleadoSolicita(String sFinalQuery,Pagination pagination,Long id_empleado_solicita)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpleadoSolicita= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpleadoSolicita.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empleado_solicita,FacturaProveedorConstantesFunciones.IDEMPLEADOSOLICITA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpleadoSolicita);

			FacturaProveedorLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpleadoSolicita","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			facturaproveedors=facturaproveedorDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				FacturaProveedorConstantesFunciones.refrescarForeignKeysDescripcionesFacturaProveedor(this.facturaproveedors);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getFacturaProveedorsFK_IdEmpresaWithConnection(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FacturaProveedor.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,FacturaProveedorConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			FacturaProveedorLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			facturaproveedors=facturaproveedorDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				FacturaProveedorConstantesFunciones.refrescarForeignKeysDescripcionesFacturaProveedor(this.facturaproveedors);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getFacturaProveedorsFK_IdEmpresa(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,FacturaProveedorConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			FacturaProveedorLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			facturaproveedors=facturaproveedorDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				FacturaProveedorConstantesFunciones.refrescarForeignKeysDescripcionesFacturaProveedor(this.facturaproveedors);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getFacturaProveedorsFK_IdFacturaWithConnection(String sFinalQuery,Pagination pagination,Long id_factura)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FacturaProveedor.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidFactura= new ParameterSelectionGeneral();
			parameterSelectionGeneralidFactura.setParameterSelectionGeneralEqual(ParameterType.LONG,id_factura,FacturaProveedorConstantesFunciones.IDFACTURA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidFactura);

			FacturaProveedorLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdFactura","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			facturaproveedors=facturaproveedorDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				FacturaProveedorConstantesFunciones.refrescarForeignKeysDescripcionesFacturaProveedor(this.facturaproveedors);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getFacturaProveedorsFK_IdFactura(String sFinalQuery,Pagination pagination,Long id_factura)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidFactura= new ParameterSelectionGeneral();
			parameterSelectionGeneralidFactura.setParameterSelectionGeneralEqual(ParameterType.LONG,id_factura,FacturaProveedorConstantesFunciones.IDFACTURA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidFactura);

			FacturaProveedorLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdFactura","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			facturaproveedors=facturaproveedorDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				FacturaProveedorConstantesFunciones.refrescarForeignKeysDescripcionesFacturaProveedor(this.facturaproveedors);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getFacturaProveedorsFK_IdMesWithConnection(String sFinalQuery,Pagination pagination,Long id_mes)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FacturaProveedor.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidMes= new ParameterSelectionGeneral();
			parameterSelectionGeneralidMes.setParameterSelectionGeneralEqual(ParameterType.LONG,id_mes,FacturaProveedorConstantesFunciones.IDMES,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidMes);

			FacturaProveedorLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdMes","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			facturaproveedors=facturaproveedorDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				FacturaProveedorConstantesFunciones.refrescarForeignKeysDescripcionesFacturaProveedor(this.facturaproveedors);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getFacturaProveedorsFK_IdMes(String sFinalQuery,Pagination pagination,Long id_mes)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidMes= new ParameterSelectionGeneral();
			parameterSelectionGeneralidMes.setParameterSelectionGeneralEqual(ParameterType.LONG,id_mes,FacturaProveedorConstantesFunciones.IDMES,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidMes);

			FacturaProveedorLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdMes","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			facturaproveedors=facturaproveedorDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				FacturaProveedorConstantesFunciones.refrescarForeignKeysDescripcionesFacturaProveedor(this.facturaproveedors);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getFacturaProveedorsFK_IdModuloWithConnection(String sFinalQuery,Pagination pagination,Long id_modulo)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FacturaProveedor.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidModulo= new ParameterSelectionGeneral();
			parameterSelectionGeneralidModulo.setParameterSelectionGeneralEqual(ParameterType.LONG,id_modulo,FacturaProveedorConstantesFunciones.IDMODULO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidModulo);

			FacturaProveedorLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdModulo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			facturaproveedors=facturaproveedorDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				FacturaProveedorConstantesFunciones.refrescarForeignKeysDescripcionesFacturaProveedor(this.facturaproveedors);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getFacturaProveedorsFK_IdModulo(String sFinalQuery,Pagination pagination,Long id_modulo)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidModulo= new ParameterSelectionGeneral();
			parameterSelectionGeneralidModulo.setParameterSelectionGeneralEqual(ParameterType.LONG,id_modulo,FacturaProveedorConstantesFunciones.IDMODULO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidModulo);

			FacturaProveedorLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdModulo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			facturaproveedors=facturaproveedorDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				FacturaProveedorConstantesFunciones.refrescarForeignKeysDescripcionesFacturaProveedor(this.facturaproveedors);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getFacturaProveedorsFK_IdMonedaWithConnection(String sFinalQuery,Pagination pagination,Long id_moneda)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FacturaProveedor.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidMoneda= new ParameterSelectionGeneral();
			parameterSelectionGeneralidMoneda.setParameterSelectionGeneralEqual(ParameterType.LONG,id_moneda,FacturaProveedorConstantesFunciones.IDMONEDA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidMoneda);

			FacturaProveedorLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdMoneda","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			facturaproveedors=facturaproveedorDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				FacturaProveedorConstantesFunciones.refrescarForeignKeysDescripcionesFacturaProveedor(this.facturaproveedors);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getFacturaProveedorsFK_IdMoneda(String sFinalQuery,Pagination pagination,Long id_moneda)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidMoneda= new ParameterSelectionGeneral();
			parameterSelectionGeneralidMoneda.setParameterSelectionGeneralEqual(ParameterType.LONG,id_moneda,FacturaProveedorConstantesFunciones.IDMONEDA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidMoneda);

			FacturaProveedorLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdMoneda","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			facturaproveedors=facturaproveedorDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				FacturaProveedorConstantesFunciones.refrescarForeignKeysDescripcionesFacturaProveedor(this.facturaproveedors);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getFacturaProveedorsFK_IdPeriodoWithConnection(String sFinalQuery,Pagination pagination,Long id_periodo)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FacturaProveedor.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidPeriodo= new ParameterSelectionGeneral();
			parameterSelectionGeneralidPeriodo.setParameterSelectionGeneralEqual(ParameterType.LONG,id_periodo,FacturaProveedorConstantesFunciones.IDPERIODO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidPeriodo);

			FacturaProveedorLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdPeriodo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			facturaproveedors=facturaproveedorDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				FacturaProveedorConstantesFunciones.refrescarForeignKeysDescripcionesFacturaProveedor(this.facturaproveedors);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getFacturaProveedorsFK_IdPeriodo(String sFinalQuery,Pagination pagination,Long id_periodo)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidPeriodo= new ParameterSelectionGeneral();
			parameterSelectionGeneralidPeriodo.setParameterSelectionGeneralEqual(ParameterType.LONG,id_periodo,FacturaProveedorConstantesFunciones.IDPERIODO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidPeriodo);

			FacturaProveedorLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdPeriodo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			facturaproveedors=facturaproveedorDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				FacturaProveedorConstantesFunciones.refrescarForeignKeysDescripcionesFacturaProveedor(this.facturaproveedors);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getFacturaProveedorsFK_IdPlantillaFacturaWithConnection(String sFinalQuery,Pagination pagination,Long id_plantilla_factura)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FacturaProveedor.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidPlantillaFactura= new ParameterSelectionGeneral();
			parameterSelectionGeneralidPlantillaFactura.setParameterSelectionGeneralEqual(ParameterType.LONG,id_plantilla_factura,FacturaProveedorConstantesFunciones.IDPLANTILLAFACTURA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidPlantillaFactura);

			FacturaProveedorLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdPlantillaFactura","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			facturaproveedors=facturaproveedorDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				FacturaProveedorConstantesFunciones.refrescarForeignKeysDescripcionesFacturaProveedor(this.facturaproveedors);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getFacturaProveedorsFK_IdPlantillaFactura(String sFinalQuery,Pagination pagination,Long id_plantilla_factura)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidPlantillaFactura= new ParameterSelectionGeneral();
			parameterSelectionGeneralidPlantillaFactura.setParameterSelectionGeneralEqual(ParameterType.LONG,id_plantilla_factura,FacturaProveedorConstantesFunciones.IDPLANTILLAFACTURA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidPlantillaFactura);

			FacturaProveedorLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdPlantillaFactura","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			facturaproveedors=facturaproveedorDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				FacturaProveedorConstantesFunciones.refrescarForeignKeysDescripcionesFacturaProveedor(this.facturaproveedors);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getFacturaProveedorsFK_IdResponsableFondoWithConnection(String sFinalQuery,Pagination pagination,Long id_responsable_fondo)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FacturaProveedor.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidResponsableFondo= new ParameterSelectionGeneral();
			parameterSelectionGeneralidResponsableFondo.setParameterSelectionGeneralEqual(ParameterType.LONG,id_responsable_fondo,FacturaProveedorConstantesFunciones.IDRESPONSABLEFONDO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidResponsableFondo);

			FacturaProveedorLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdResponsableFondo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			facturaproveedors=facturaproveedorDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				FacturaProveedorConstantesFunciones.refrescarForeignKeysDescripcionesFacturaProveedor(this.facturaproveedors);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getFacturaProveedorsFK_IdResponsableFondo(String sFinalQuery,Pagination pagination,Long id_responsable_fondo)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidResponsableFondo= new ParameterSelectionGeneral();
			parameterSelectionGeneralidResponsableFondo.setParameterSelectionGeneralEqual(ParameterType.LONG,id_responsable_fondo,FacturaProveedorConstantesFunciones.IDRESPONSABLEFONDO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidResponsableFondo);

			FacturaProveedorLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdResponsableFondo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			facturaproveedors=facturaproveedorDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				FacturaProveedorConstantesFunciones.refrescarForeignKeysDescripcionesFacturaProveedor(this.facturaproveedors);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getFacturaProveedorsFK_IdSucursalWithConnection(String sFinalQuery,Pagination pagination,Long id_sucursal)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FacturaProveedor.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidSucursal= new ParameterSelectionGeneral();
			parameterSelectionGeneralidSucursal.setParameterSelectionGeneralEqual(ParameterType.LONG,id_sucursal,FacturaProveedorConstantesFunciones.IDSUCURSAL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidSucursal);

			FacturaProveedorLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdSucursal","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			facturaproveedors=facturaproveedorDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				FacturaProveedorConstantesFunciones.refrescarForeignKeysDescripcionesFacturaProveedor(this.facturaproveedors);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getFacturaProveedorsFK_IdSucursal(String sFinalQuery,Pagination pagination,Long id_sucursal)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidSucursal= new ParameterSelectionGeneral();
			parameterSelectionGeneralidSucursal.setParameterSelectionGeneralEqual(ParameterType.LONG,id_sucursal,FacturaProveedorConstantesFunciones.IDSUCURSAL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidSucursal);

			FacturaProveedorLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdSucursal","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			facturaproveedors=facturaproveedorDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				FacturaProveedorConstantesFunciones.refrescarForeignKeysDescripcionesFacturaProveedor(this.facturaproveedors);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getFacturaProveedorsFK_IdTipoDocumentoWithConnection(String sFinalQuery,Pagination pagination,Long id_tipo_documento)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FacturaProveedor.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoDocumento= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoDocumento.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_documento,FacturaProveedorConstantesFunciones.IDTIPODOCUMENTO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoDocumento);

			FacturaProveedorLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoDocumento","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			facturaproveedors=facturaproveedorDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				FacturaProveedorConstantesFunciones.refrescarForeignKeysDescripcionesFacturaProveedor(this.facturaproveedors);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getFacturaProveedorsFK_IdTipoDocumento(String sFinalQuery,Pagination pagination,Long id_tipo_documento)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoDocumento= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoDocumento.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_documento,FacturaProveedorConstantesFunciones.IDTIPODOCUMENTO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoDocumento);

			FacturaProveedorLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoDocumento","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			facturaproveedors=facturaproveedorDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				FacturaProveedorConstantesFunciones.refrescarForeignKeysDescripcionesFacturaProveedor(this.facturaproveedors);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getFacturaProveedorsFK_IdTipoMovimientoWithConnection(String sFinalQuery,Pagination pagination,Long id_tipo_movimiento)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FacturaProveedor.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoMovimiento= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoMovimiento.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_movimiento,FacturaProveedorConstantesFunciones.IDTIPOMOVIMIENTO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoMovimiento);

			FacturaProveedorLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoMovimiento","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			facturaproveedors=facturaproveedorDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				FacturaProveedorConstantesFunciones.refrescarForeignKeysDescripcionesFacturaProveedor(this.facturaproveedors);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getFacturaProveedorsFK_IdTipoMovimiento(String sFinalQuery,Pagination pagination,Long id_tipo_movimiento)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoMovimiento= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoMovimiento.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_movimiento,FacturaProveedorConstantesFunciones.IDTIPOMOVIMIENTO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoMovimiento);

			FacturaProveedorLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoMovimiento","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			facturaproveedors=facturaproveedorDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				FacturaProveedorConstantesFunciones.refrescarForeignKeysDescripcionesFacturaProveedor(this.facturaproveedors);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getFacturaProveedorsFK_IdTipoMovimientoModuloWithConnection(String sFinalQuery,Pagination pagination,Long id_tipo_movimiento_modulo)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FacturaProveedor.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoMovimientoModulo= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoMovimientoModulo.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_movimiento_modulo,FacturaProveedorConstantesFunciones.IDTIPOMOVIMIENTOMODULO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoMovimientoModulo);

			FacturaProveedorLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoMovimientoModulo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			facturaproveedors=facturaproveedorDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				FacturaProveedorConstantesFunciones.refrescarForeignKeysDescripcionesFacturaProveedor(this.facturaproveedors);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getFacturaProveedorsFK_IdTipoMovimientoModulo(String sFinalQuery,Pagination pagination,Long id_tipo_movimiento_modulo)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoMovimientoModulo= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoMovimientoModulo.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_movimiento_modulo,FacturaProveedorConstantesFunciones.IDTIPOMOVIMIENTOMODULO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoMovimientoModulo);

			FacturaProveedorLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoMovimientoModulo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			facturaproveedors=facturaproveedorDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				FacturaProveedorConstantesFunciones.refrescarForeignKeysDescripcionesFacturaProveedor(this.facturaproveedors);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getFacturaProveedorsFK_IdTipoRetencionFuente1WithConnection(String sFinalQuery,Pagination pagination,Long id_tipo_retencion_fuente1)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FacturaProveedor.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoRetencionFuente1= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoRetencionFuente1.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_retencion_fuente1,FacturaProveedorConstantesFunciones.IDTIPORETENCIONFUENTE1,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoRetencionFuente1);

			FacturaProveedorLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoRetencionFuente1","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			facturaproveedors=facturaproveedorDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				FacturaProveedorConstantesFunciones.refrescarForeignKeysDescripcionesFacturaProveedor(this.facturaproveedors);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getFacturaProveedorsFK_IdTipoRetencionFuente1(String sFinalQuery,Pagination pagination,Long id_tipo_retencion_fuente1)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoRetencionFuente1= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoRetencionFuente1.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_retencion_fuente1,FacturaProveedorConstantesFunciones.IDTIPORETENCIONFUENTE1,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoRetencionFuente1);

			FacturaProveedorLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoRetencionFuente1","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			facturaproveedors=facturaproveedorDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				FacturaProveedorConstantesFunciones.refrescarForeignKeysDescripcionesFacturaProveedor(this.facturaproveedors);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getFacturaProveedorsFK_IdTipoRetencionFuente2WithConnection(String sFinalQuery,Pagination pagination,Long id_tipo_retencion_fuente2)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FacturaProveedor.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoRetencionFuente2= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoRetencionFuente2.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_retencion_fuente2,FacturaProveedorConstantesFunciones.IDTIPORETENCIONFUENTE2,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoRetencionFuente2);

			FacturaProveedorLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoRetencionFuente2","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			facturaproveedors=facturaproveedorDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				FacturaProveedorConstantesFunciones.refrescarForeignKeysDescripcionesFacturaProveedor(this.facturaproveedors);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getFacturaProveedorsFK_IdTipoRetencionFuente2(String sFinalQuery,Pagination pagination,Long id_tipo_retencion_fuente2)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoRetencionFuente2= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoRetencionFuente2.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_retencion_fuente2,FacturaProveedorConstantesFunciones.IDTIPORETENCIONFUENTE2,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoRetencionFuente2);

			FacturaProveedorLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoRetencionFuente2","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			facturaproveedors=facturaproveedorDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				FacturaProveedorConstantesFunciones.refrescarForeignKeysDescripcionesFacturaProveedor(this.facturaproveedors);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getFacturaProveedorsFK_IdTipoRetencionIva1WithConnection(String sFinalQuery,Pagination pagination,Long id_tipo_retencion_iva1)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FacturaProveedor.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoRetencionIva1= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoRetencionIva1.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_retencion_iva1,FacturaProveedorConstantesFunciones.IDTIPORETENCIONIVA1,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoRetencionIva1);

			FacturaProveedorLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoRetencionIva1","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			facturaproveedors=facturaproveedorDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				FacturaProveedorConstantesFunciones.refrescarForeignKeysDescripcionesFacturaProveedor(this.facturaproveedors);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getFacturaProveedorsFK_IdTipoRetencionIva1(String sFinalQuery,Pagination pagination,Long id_tipo_retencion_iva1)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoRetencionIva1= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoRetencionIva1.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_retencion_iva1,FacturaProveedorConstantesFunciones.IDTIPORETENCIONIVA1,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoRetencionIva1);

			FacturaProveedorLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoRetencionIva1","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			facturaproveedors=facturaproveedorDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				FacturaProveedorConstantesFunciones.refrescarForeignKeysDescripcionesFacturaProveedor(this.facturaproveedors);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getFacturaProveedorsFK_IdTipoRetencionIva2WithConnection(String sFinalQuery,Pagination pagination,Long id_tipo_retencion_iva2)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FacturaProveedor.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoRetencionIva2= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoRetencionIva2.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_retencion_iva2,FacturaProveedorConstantesFunciones.IDTIPORETENCIONIVA2,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoRetencionIva2);

			FacturaProveedorLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoRetencionIva2","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			facturaproveedors=facturaproveedorDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				FacturaProveedorConstantesFunciones.refrescarForeignKeysDescripcionesFacturaProveedor(this.facturaproveedors);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getFacturaProveedorsFK_IdTipoRetencionIva2(String sFinalQuery,Pagination pagination,Long id_tipo_retencion_iva2)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoRetencionIva2= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoRetencionIva2.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_retencion_iva2,FacturaProveedorConstantesFunciones.IDTIPORETENCIONIVA2,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoRetencionIva2);

			FacturaProveedorLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoRetencionIva2","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			facturaproveedors=facturaproveedorDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				FacturaProveedorConstantesFunciones.refrescarForeignKeysDescripcionesFacturaProveedor(this.facturaproveedors);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getFacturaProveedorsFK_IdTipoTransaccionModuloWithConnection(String sFinalQuery,Pagination pagination,Long id_tipo_transaccion_modulo)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FacturaProveedor.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoTransaccionModulo= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoTransaccionModulo.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_transaccion_modulo,FacturaProveedorConstantesFunciones.IDTIPOTRANSACCIONMODULO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoTransaccionModulo);

			FacturaProveedorLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoTransaccionModulo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			facturaproveedors=facturaproveedorDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				FacturaProveedorConstantesFunciones.refrescarForeignKeysDescripcionesFacturaProveedor(this.facturaproveedors);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getFacturaProveedorsFK_IdTipoTransaccionModulo(String sFinalQuery,Pagination pagination,Long id_tipo_transaccion_modulo)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoTransaccionModulo= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoTransaccionModulo.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_transaccion_modulo,FacturaProveedorConstantesFunciones.IDTIPOTRANSACCIONMODULO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoTransaccionModulo);

			FacturaProveedorLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoTransaccionModulo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			facturaproveedors=facturaproveedorDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				FacturaProveedorConstantesFunciones.refrescarForeignKeysDescripcionesFacturaProveedor(this.facturaproveedors);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getFacturaProveedorsFK_IdTipoTributarioWithConnection(String sFinalQuery,Pagination pagination,Long id_tipo_tributario)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FacturaProveedor.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoTributario= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoTributario.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_tributario,FacturaProveedorConstantesFunciones.IDTIPOTRIBUTARIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoTributario);

			FacturaProveedorLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoTributario","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			facturaproveedors=facturaproveedorDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				FacturaProveedorConstantesFunciones.refrescarForeignKeysDescripcionesFacturaProveedor(this.facturaproveedors);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getFacturaProveedorsFK_IdTipoTributario(String sFinalQuery,Pagination pagination,Long id_tipo_tributario)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoTributario= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoTributario.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_tributario,FacturaProveedorConstantesFunciones.IDTIPOTRIBUTARIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoTributario);

			FacturaProveedorLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoTributario","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			facturaproveedors=facturaproveedorDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				FacturaProveedorConstantesFunciones.refrescarForeignKeysDescripcionesFacturaProveedor(this.facturaproveedors);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getFacturaProveedorsFK_IdTransaccionWithConnection(String sFinalQuery,Pagination pagination,Long id_transaccion)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FacturaProveedor.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTransaccion= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTransaccion.setParameterSelectionGeneralEqual(ParameterType.LONG,id_transaccion,FacturaProveedorConstantesFunciones.IDTRANSACCION,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTransaccion);

			FacturaProveedorLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTransaccion","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			facturaproveedors=facturaproveedorDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				FacturaProveedorConstantesFunciones.refrescarForeignKeysDescripcionesFacturaProveedor(this.facturaproveedors);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getFacturaProveedorsFK_IdTransaccion(String sFinalQuery,Pagination pagination,Long id_transaccion)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTransaccion= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTransaccion.setParameterSelectionGeneralEqual(ParameterType.LONG,id_transaccion,FacturaProveedorConstantesFunciones.IDTRANSACCION,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTransaccion);

			FacturaProveedorLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTransaccion","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			facturaproveedors=facturaproveedorDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				FacturaProveedorConstantesFunciones.refrescarForeignKeysDescripcionesFacturaProveedor(this.facturaproveedors);
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
			if(FacturaProveedorConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,FacturaProveedorDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,FacturaProveedor facturaproveedor,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(FacturaProveedorConstantesFunciones.ISCONAUDITORIA) {
				if(facturaproveedor.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,FacturaProveedorDataAccess.TABLENAME, facturaproveedor.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(FacturaProveedorConstantesFunciones.ISCONAUDITORIADETALLE) {
						////FacturaProveedorLogic.registrarAuditoriaDetallesFacturaProveedor(connexion,facturaproveedor,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(facturaproveedor.getIsDeleted()) {
					/*if(!facturaproveedor.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,FacturaProveedorDataAccess.TABLENAME, facturaproveedor.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////FacturaProveedorLogic.registrarAuditoriaDetallesFacturaProveedor(connexion,facturaproveedor,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,FacturaProveedorDataAccess.TABLENAME, facturaproveedor.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(facturaproveedor.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,FacturaProveedorDataAccess.TABLENAME, facturaproveedor.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(FacturaProveedorConstantesFunciones.ISCONAUDITORIADETALLE) {
						////FacturaProveedorLogic.registrarAuditoriaDetallesFacturaProveedor(connexion,facturaproveedor,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesFacturaProveedor(Connexion connexion,FacturaProveedor facturaproveedor)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(facturaproveedor.getIsNew()||!facturaproveedor.getid_empresa().equals(facturaproveedor.getFacturaProveedorOriginal().getid_empresa()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(facturaproveedor.getFacturaProveedorOriginal().getid_empresa()!=null)
				{
					strValorActual=facturaproveedor.getFacturaProveedorOriginal().getid_empresa().toString();
				}
				if(facturaproveedor.getid_empresa()!=null)
				{
					strValorNuevo=facturaproveedor.getid_empresa().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),FacturaProveedorConstantesFunciones.IDEMPRESA,strValorActual,strValorNuevo);
			}	
			
			if(facturaproveedor.getIsNew()||!facturaproveedor.getid_sucursal().equals(facturaproveedor.getFacturaProveedorOriginal().getid_sucursal()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(facturaproveedor.getFacturaProveedorOriginal().getid_sucursal()!=null)
				{
					strValorActual=facturaproveedor.getFacturaProveedorOriginal().getid_sucursal().toString();
				}
				if(facturaproveedor.getid_sucursal()!=null)
				{
					strValorNuevo=facturaproveedor.getid_sucursal().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),FacturaProveedorConstantesFunciones.IDSUCURSAL,strValorActual,strValorNuevo);
			}	
			
			if(facturaproveedor.getIsNew()||!facturaproveedor.getid_ejercicio().equals(facturaproveedor.getFacturaProveedorOriginal().getid_ejercicio()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(facturaproveedor.getFacturaProveedorOriginal().getid_ejercicio()!=null)
				{
					strValorActual=facturaproveedor.getFacturaProveedorOriginal().getid_ejercicio().toString();
				}
				if(facturaproveedor.getid_ejercicio()!=null)
				{
					strValorNuevo=facturaproveedor.getid_ejercicio().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),FacturaProveedorConstantesFunciones.IDEJERCICIO,strValorActual,strValorNuevo);
			}	
			
			if(facturaproveedor.getIsNew()||!facturaproveedor.getid_periodo().equals(facturaproveedor.getFacturaProveedorOriginal().getid_periodo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(facturaproveedor.getFacturaProveedorOriginal().getid_periodo()!=null)
				{
					strValorActual=facturaproveedor.getFacturaProveedorOriginal().getid_periodo().toString();
				}
				if(facturaproveedor.getid_periodo()!=null)
				{
					strValorNuevo=facturaproveedor.getid_periodo().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),FacturaProveedorConstantesFunciones.IDPERIODO,strValorActual,strValorNuevo);
			}	
			
			if(facturaproveedor.getIsNew()||!facturaproveedor.getid_anio().equals(facturaproveedor.getFacturaProveedorOriginal().getid_anio()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(facturaproveedor.getFacturaProveedorOriginal().getid_anio()!=null)
				{
					strValorActual=facturaproveedor.getFacturaProveedorOriginal().getid_anio().toString();
				}
				if(facturaproveedor.getid_anio()!=null)
				{
					strValorNuevo=facturaproveedor.getid_anio().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),FacturaProveedorConstantesFunciones.IDANIO,strValorActual,strValorNuevo);
			}	
			
			if(facturaproveedor.getIsNew()||!facturaproveedor.getid_mes().equals(facturaproveedor.getFacturaProveedorOriginal().getid_mes()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(facturaproveedor.getFacturaProveedorOriginal().getid_mes()!=null)
				{
					strValorActual=facturaproveedor.getFacturaProveedorOriginal().getid_mes().toString();
				}
				if(facturaproveedor.getid_mes()!=null)
				{
					strValorNuevo=facturaproveedor.getid_mes().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),FacturaProveedorConstantesFunciones.IDMES,strValorActual,strValorNuevo);
			}	
			
			if(facturaproveedor.getIsNew()||!facturaproveedor.getid_modulo().equals(facturaproveedor.getFacturaProveedorOriginal().getid_modulo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(facturaproveedor.getFacturaProveedorOriginal().getid_modulo()!=null)
				{
					strValorActual=facturaproveedor.getFacturaProveedorOriginal().getid_modulo().toString();
				}
				if(facturaproveedor.getid_modulo()!=null)
				{
					strValorNuevo=facturaproveedor.getid_modulo().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),FacturaProveedorConstantesFunciones.IDMODULO,strValorActual,strValorNuevo);
			}	
			
			if(facturaproveedor.getIsNew()||!facturaproveedor.getid_plantilla_factura().equals(facturaproveedor.getFacturaProveedorOriginal().getid_plantilla_factura()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(facturaproveedor.getFacturaProveedorOriginal().getid_plantilla_factura()!=null)
				{
					strValorActual=facturaproveedor.getFacturaProveedorOriginal().getid_plantilla_factura().toString();
				}
				if(facturaproveedor.getid_plantilla_factura()!=null)
				{
					strValorNuevo=facturaproveedor.getid_plantilla_factura().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),FacturaProveedorConstantesFunciones.IDPLANTILLAFACTURA,strValorActual,strValorNuevo);
			}	
			
			if(facturaproveedor.getIsNew()||!facturaproveedor.getid_tipo_documento().equals(facturaproveedor.getFacturaProveedorOriginal().getid_tipo_documento()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(facturaproveedor.getFacturaProveedorOriginal().getid_tipo_documento()!=null)
				{
					strValorActual=facturaproveedor.getFacturaProveedorOriginal().getid_tipo_documento().toString();
				}
				if(facturaproveedor.getid_tipo_documento()!=null)
				{
					strValorNuevo=facturaproveedor.getid_tipo_documento().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),FacturaProveedorConstantesFunciones.IDTIPODOCUMENTO,strValorActual,strValorNuevo);
			}	
			
			if(facturaproveedor.getIsNew()||!facturaproveedor.getplazo().equals(facturaproveedor.getFacturaProveedorOriginal().getplazo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(facturaproveedor.getFacturaProveedorOriginal().getplazo()!=null)
				{
					strValorActual=facturaproveedor.getFacturaProveedorOriginal().getplazo().toString();
				}
				if(facturaproveedor.getplazo()!=null)
				{
					strValorNuevo=facturaproveedor.getplazo().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),FacturaProveedorConstantesFunciones.PLAZO,strValorActual,strValorNuevo);
			}	
			
			if(facturaproveedor.getIsNew()||!facturaproveedor.getid_factura().equals(facturaproveedor.getFacturaProveedorOriginal().getid_factura()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(facturaproveedor.getFacturaProveedorOriginal().getid_factura()!=null)
				{
					strValorActual=facturaproveedor.getFacturaProveedorOriginal().getid_factura().toString();
				}
				if(facturaproveedor.getid_factura()!=null)
				{
					strValorNuevo=facturaproveedor.getid_factura().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),FacturaProveedorConstantesFunciones.IDFACTURA,strValorActual,strValorNuevo);
			}	
			
			if(facturaproveedor.getIsNew()||!facturaproveedor.getnumero_factura().equals(facturaproveedor.getFacturaProveedorOriginal().getnumero_factura()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(facturaproveedor.getFacturaProveedorOriginal().getnumero_factura()!=null)
				{
					strValorActual=facturaproveedor.getFacturaProveedorOriginal().getnumero_factura();
				}
				if(facturaproveedor.getnumero_factura()!=null)
				{
					strValorNuevo=facturaproveedor.getnumero_factura() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),FacturaProveedorConstantesFunciones.NUMEROFACTURA,strValorActual,strValorNuevo);
			}	
			
			if(facturaproveedor.getIsNew()||!facturaproveedor.getid_transaccion().equals(facturaproveedor.getFacturaProveedorOriginal().getid_transaccion()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(facturaproveedor.getFacturaProveedorOriginal().getid_transaccion()!=null)
				{
					strValorActual=facturaproveedor.getFacturaProveedorOriginal().getid_transaccion().toString();
				}
				if(facturaproveedor.getid_transaccion()!=null)
				{
					strValorNuevo=facturaproveedor.getid_transaccion().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),FacturaProveedorConstantesFunciones.IDTRANSACCION,strValorActual,strValorNuevo);
			}	
			
			if(facturaproveedor.getIsNew()||!facturaproveedor.getfecha_emision().equals(facturaproveedor.getFacturaProveedorOriginal().getfecha_emision()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(facturaproveedor.getFacturaProveedorOriginal().getfecha_emision()!=null)
				{
					strValorActual=facturaproveedor.getFacturaProveedorOriginal().getfecha_emision().toString();
				}
				if(facturaproveedor.getfecha_emision()!=null)
				{
					strValorNuevo=facturaproveedor.getfecha_emision().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),FacturaProveedorConstantesFunciones.FECHAEMISION,strValorActual,strValorNuevo);
			}	
			
			if(facturaproveedor.getIsNew()||!facturaproveedor.getid_cliente().equals(facturaproveedor.getFacturaProveedorOriginal().getid_cliente()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(facturaproveedor.getFacturaProveedorOriginal().getid_cliente()!=null)
				{
					strValorActual=facturaproveedor.getFacturaProveedorOriginal().getid_cliente().toString();
				}
				if(facturaproveedor.getid_cliente()!=null)
				{
					strValorNuevo=facturaproveedor.getid_cliente().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),FacturaProveedorConstantesFunciones.IDCLIENTE,strValorActual,strValorNuevo);
			}	
			
			if(facturaproveedor.getIsNew()||!facturaproveedor.getruc().equals(facturaproveedor.getFacturaProveedorOriginal().getruc()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(facturaproveedor.getFacturaProveedorOriginal().getruc()!=null)
				{
					strValorActual=facturaproveedor.getFacturaProveedorOriginal().getruc();
				}
				if(facturaproveedor.getruc()!=null)
				{
					strValorNuevo=facturaproveedor.getruc() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),FacturaProveedorConstantesFunciones.RUC,strValorActual,strValorNuevo);
			}	
			
			if(facturaproveedor.getIsNew()||!facturaproveedor.getid_empleado_solicita().equals(facturaproveedor.getFacturaProveedorOriginal().getid_empleado_solicita()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(facturaproveedor.getFacturaProveedorOriginal().getid_empleado_solicita()!=null)
				{
					strValorActual=facturaproveedor.getFacturaProveedorOriginal().getid_empleado_solicita().toString();
				}
				if(facturaproveedor.getid_empleado_solicita()!=null)
				{
					strValorNuevo=facturaproveedor.getid_empleado_solicita().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),FacturaProveedorConstantesFunciones.IDEMPLEADOSOLICITA,strValorActual,strValorNuevo);
			}	
			
			if(facturaproveedor.getIsNew()||!facturaproveedor.getfecha_vence().equals(facturaproveedor.getFacturaProveedorOriginal().getfecha_vence()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(facturaproveedor.getFacturaProveedorOriginal().getfecha_vence()!=null)
				{
					strValorActual=facturaproveedor.getFacturaProveedorOriginal().getfecha_vence().toString();
				}
				if(facturaproveedor.getfecha_vence()!=null)
				{
					strValorNuevo=facturaproveedor.getfecha_vence().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),FacturaProveedorConstantesFunciones.FECHAVENCE,strValorActual,strValorNuevo);
			}	
			
			if(facturaproveedor.getIsNew()||!facturaproveedor.getid_moneda().equals(facturaproveedor.getFacturaProveedorOriginal().getid_moneda()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(facturaproveedor.getFacturaProveedorOriginal().getid_moneda()!=null)
				{
					strValorActual=facturaproveedor.getFacturaProveedorOriginal().getid_moneda().toString();
				}
				if(facturaproveedor.getid_moneda()!=null)
				{
					strValorNuevo=facturaproveedor.getid_moneda().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),FacturaProveedorConstantesFunciones.IDMONEDA,strValorActual,strValorNuevo);
			}	
			
			if(facturaproveedor.getIsNew()||!facturaproveedor.getid_empleado().equals(facturaproveedor.getFacturaProveedorOriginal().getid_empleado()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(facturaproveedor.getFacturaProveedorOriginal().getid_empleado()!=null)
				{
					strValorActual=facturaproveedor.getFacturaProveedorOriginal().getid_empleado().toString();
				}
				if(facturaproveedor.getid_empleado()!=null)
				{
					strValorNuevo=facturaproveedor.getid_empleado().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),FacturaProveedorConstantesFunciones.IDEMPLEADO,strValorActual,strValorNuevo);
			}	
			
			if(facturaproveedor.getIsNew()||!facturaproveedor.getcon_activos().equals(facturaproveedor.getFacturaProveedorOriginal().getcon_activos()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(facturaproveedor.getFacturaProveedorOriginal().getcon_activos()!=null)
				{
					strValorActual=facturaproveedor.getFacturaProveedorOriginal().getcon_activos().toString();
				}
				if(facturaproveedor.getcon_activos()!=null)
				{
					strValorNuevo=facturaproveedor.getcon_activos().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),FacturaProveedorConstantesFunciones.CONACTIVOS,strValorActual,strValorNuevo);
			}	
			
			if(facturaproveedor.getIsNew()||!facturaproveedor.getcon_rise().equals(facturaproveedor.getFacturaProveedorOriginal().getcon_rise()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(facturaproveedor.getFacturaProveedorOriginal().getcon_rise()!=null)
				{
					strValorActual=facturaproveedor.getFacturaProveedorOriginal().getcon_rise().toString();
				}
				if(facturaproveedor.getcon_rise()!=null)
				{
					strValorNuevo=facturaproveedor.getcon_rise().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),FacturaProveedorConstantesFunciones.CONRISE,strValorActual,strValorNuevo);
			}	
			
			if(facturaproveedor.getIsNew()||!facturaproveedor.getcon_sitios().equals(facturaproveedor.getFacturaProveedorOriginal().getcon_sitios()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(facturaproveedor.getFacturaProveedorOriginal().getcon_sitios()!=null)
				{
					strValorActual=facturaproveedor.getFacturaProveedorOriginal().getcon_sitios().toString();
				}
				if(facturaproveedor.getcon_sitios()!=null)
				{
					strValorNuevo=facturaproveedor.getcon_sitios().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),FacturaProveedorConstantesFunciones.CONSITIOS,strValorActual,strValorNuevo);
			}	
			
			if(facturaproveedor.getIsNew()||!facturaproveedor.getdetalle().equals(facturaproveedor.getFacturaProveedorOriginal().getdetalle()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(facturaproveedor.getFacturaProveedorOriginal().getdetalle()!=null)
				{
					strValorActual=facturaproveedor.getFacturaProveedorOriginal().getdetalle();
				}
				if(facturaproveedor.getdetalle()!=null)
				{
					strValorNuevo=facturaproveedor.getdetalle() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),FacturaProveedorConstantesFunciones.DETALLE,strValorActual,strValorNuevo);
			}	
			
			if(facturaproveedor.getIsNew()||!facturaproveedor.getvalor_bienes12().equals(facturaproveedor.getFacturaProveedorOriginal().getvalor_bienes12()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(facturaproveedor.getFacturaProveedorOriginal().getvalor_bienes12()!=null)
				{
					strValorActual=facturaproveedor.getFacturaProveedorOriginal().getvalor_bienes12().toString();
				}
				if(facturaproveedor.getvalor_bienes12()!=null)
				{
					strValorNuevo=facturaproveedor.getvalor_bienes12().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),FacturaProveedorConstantesFunciones.VALORBIENES12,strValorActual,strValorNuevo);
			}	
			
			if(facturaproveedor.getIsNew()||!facturaproveedor.getvalor_servicios12().equals(facturaproveedor.getFacturaProveedorOriginal().getvalor_servicios12()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(facturaproveedor.getFacturaProveedorOriginal().getvalor_servicios12()!=null)
				{
					strValorActual=facturaproveedor.getFacturaProveedorOriginal().getvalor_servicios12().toString();
				}
				if(facturaproveedor.getvalor_servicios12()!=null)
				{
					strValorNuevo=facturaproveedor.getvalor_servicios12().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),FacturaProveedorConstantesFunciones.VALORSERVICIOS12,strValorActual,strValorNuevo);
			}	
			
			if(facturaproveedor.getIsNew()||!facturaproveedor.gettotal_valor12().equals(facturaproveedor.getFacturaProveedorOriginal().gettotal_valor12()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(facturaproveedor.getFacturaProveedorOriginal().gettotal_valor12()!=null)
				{
					strValorActual=facturaproveedor.getFacturaProveedorOriginal().gettotal_valor12().toString();
				}
				if(facturaproveedor.gettotal_valor12()!=null)
				{
					strValorNuevo=facturaproveedor.gettotal_valor12().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),FacturaProveedorConstantesFunciones.TOTALVALOR12,strValorActual,strValorNuevo);
			}	
			
			if(facturaproveedor.getIsNew()||!facturaproveedor.getvalor_bienes0().equals(facturaproveedor.getFacturaProveedorOriginal().getvalor_bienes0()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(facturaproveedor.getFacturaProveedorOriginal().getvalor_bienes0()!=null)
				{
					strValorActual=facturaproveedor.getFacturaProveedorOriginal().getvalor_bienes0().toString();
				}
				if(facturaproveedor.getvalor_bienes0()!=null)
				{
					strValorNuevo=facturaproveedor.getvalor_bienes0().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),FacturaProveedorConstantesFunciones.VALORBIENES0,strValorActual,strValorNuevo);
			}	
			
			if(facturaproveedor.getIsNew()||!facturaproveedor.getvalor_servicios0().equals(facturaproveedor.getFacturaProveedorOriginal().getvalor_servicios0()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(facturaproveedor.getFacturaProveedorOriginal().getvalor_servicios0()!=null)
				{
					strValorActual=facturaproveedor.getFacturaProveedorOriginal().getvalor_servicios0().toString();
				}
				if(facturaproveedor.getvalor_servicios0()!=null)
				{
					strValorNuevo=facturaproveedor.getvalor_servicios0().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),FacturaProveedorConstantesFunciones.VALORSERVICIOS0,strValorActual,strValorNuevo);
			}	
			
			if(facturaproveedor.getIsNew()||!facturaproveedor.gettotal_valor0().equals(facturaproveedor.getFacturaProveedorOriginal().gettotal_valor0()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(facturaproveedor.getFacturaProveedorOriginal().gettotal_valor0()!=null)
				{
					strValorActual=facturaproveedor.getFacturaProveedorOriginal().gettotal_valor0().toString();
				}
				if(facturaproveedor.gettotal_valor0()!=null)
				{
					strValorNuevo=facturaproveedor.gettotal_valor0().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),FacturaProveedorConstantesFunciones.TOTALVALOR0,strValorActual,strValorNuevo);
			}	
			
			if(facturaproveedor.getIsNew()||!facturaproveedor.getbienes_ice().equals(facturaproveedor.getFacturaProveedorOriginal().getbienes_ice()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(facturaproveedor.getFacturaProveedorOriginal().getbienes_ice()!=null)
				{
					strValorActual=facturaproveedor.getFacturaProveedorOriginal().getbienes_ice().toString();
				}
				if(facturaproveedor.getbienes_ice()!=null)
				{
					strValorNuevo=facturaproveedor.getbienes_ice().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),FacturaProveedorConstantesFunciones.BIENESICE,strValorActual,strValorNuevo);
			}	
			
			if(facturaproveedor.getIsNew()||!facturaproveedor.getservicios_ice().equals(facturaproveedor.getFacturaProveedorOriginal().getservicios_ice()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(facturaproveedor.getFacturaProveedorOriginal().getservicios_ice()!=null)
				{
					strValorActual=facturaproveedor.getFacturaProveedorOriginal().getservicios_ice().toString();
				}
				if(facturaproveedor.getservicios_ice()!=null)
				{
					strValorNuevo=facturaproveedor.getservicios_ice().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),FacturaProveedorConstantesFunciones.SERVICIOSICE,strValorActual,strValorNuevo);
			}	
			
			if(facturaproveedor.getIsNew()||!facturaproveedor.gettotal_ice().equals(facturaproveedor.getFacturaProveedorOriginal().gettotal_ice()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(facturaproveedor.getFacturaProveedorOriginal().gettotal_ice()!=null)
				{
					strValorActual=facturaproveedor.getFacturaProveedorOriginal().gettotal_ice().toString();
				}
				if(facturaproveedor.gettotal_ice()!=null)
				{
					strValorNuevo=facturaproveedor.gettotal_ice().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),FacturaProveedorConstantesFunciones.TOTALICE,strValorActual,strValorNuevo);
			}	
			
			if(facturaproveedor.getIsNew()||!facturaproveedor.getbienes_iva().equals(facturaproveedor.getFacturaProveedorOriginal().getbienes_iva()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(facturaproveedor.getFacturaProveedorOriginal().getbienes_iva()!=null)
				{
					strValorActual=facturaproveedor.getFacturaProveedorOriginal().getbienes_iva().toString();
				}
				if(facturaproveedor.getbienes_iva()!=null)
				{
					strValorNuevo=facturaproveedor.getbienes_iva().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),FacturaProveedorConstantesFunciones.BIENESIVA,strValorActual,strValorNuevo);
			}	
			
			if(facturaproveedor.getIsNew()||!facturaproveedor.getservicios_iva().equals(facturaproveedor.getFacturaProveedorOriginal().getservicios_iva()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(facturaproveedor.getFacturaProveedorOriginal().getservicios_iva()!=null)
				{
					strValorActual=facturaproveedor.getFacturaProveedorOriginal().getservicios_iva().toString();
				}
				if(facturaproveedor.getservicios_iva()!=null)
				{
					strValorNuevo=facturaproveedor.getservicios_iva().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),FacturaProveedorConstantesFunciones.SERVICIOSIVA,strValorActual,strValorNuevo);
			}	
			
			if(facturaproveedor.getIsNew()||!facturaproveedor.gettotal_iva().equals(facturaproveedor.getFacturaProveedorOriginal().gettotal_iva()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(facturaproveedor.getFacturaProveedorOriginal().gettotal_iva()!=null)
				{
					strValorActual=facturaproveedor.getFacturaProveedorOriginal().gettotal_iva().toString();
				}
				if(facturaproveedor.gettotal_iva()!=null)
				{
					strValorNuevo=facturaproveedor.gettotal_iva().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),FacturaProveedorConstantesFunciones.TOTALIVA,strValorActual,strValorNuevo);
			}	
			
			if(facturaproveedor.getIsNew()||!facturaproveedor.getiva_porcentaje().equals(facturaproveedor.getFacturaProveedorOriginal().getiva_porcentaje()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(facturaproveedor.getFacturaProveedorOriginal().getiva_porcentaje()!=null)
				{
					strValorActual=facturaproveedor.getFacturaProveedorOriginal().getiva_porcentaje().toString();
				}
				if(facturaproveedor.getiva_porcentaje()!=null)
				{
					strValorNuevo=facturaproveedor.getiva_porcentaje().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),FacturaProveedorConstantesFunciones.IVAPORCENTAJE,strValorActual,strValorNuevo);
			}	
			
			if(facturaproveedor.getIsNew()||!facturaproveedor.gettotal().equals(facturaproveedor.getFacturaProveedorOriginal().gettotal()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(facturaproveedor.getFacturaProveedorOriginal().gettotal()!=null)
				{
					strValorActual=facturaproveedor.getFacturaProveedorOriginal().gettotal().toString();
				}
				if(facturaproveedor.gettotal()!=null)
				{
					strValorNuevo=facturaproveedor.gettotal().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),FacturaProveedorConstantesFunciones.TOTAL,strValorActual,strValorNuevo);
			}	
			
			if(facturaproveedor.getIsNew()||!facturaproveedor.getcon_monto_objeto_iva().equals(facturaproveedor.getFacturaProveedorOriginal().getcon_monto_objeto_iva()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(facturaproveedor.getFacturaProveedorOriginal().getcon_monto_objeto_iva()!=null)
				{
					strValorActual=facturaproveedor.getFacturaProveedorOriginal().getcon_monto_objeto_iva().toString();
				}
				if(facturaproveedor.getcon_monto_objeto_iva()!=null)
				{
					strValorNuevo=facturaproveedor.getcon_monto_objeto_iva().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),FacturaProveedorConstantesFunciones.CONMONTOOBJETOIVA,strValorActual,strValorNuevo);
			}	
			
			if(facturaproveedor.getIsNew()||!facturaproveedor.getnumero_retencion().equals(facturaproveedor.getFacturaProveedorOriginal().getnumero_retencion()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(facturaproveedor.getFacturaProveedorOriginal().getnumero_retencion()!=null)
				{
					strValorActual=facturaproveedor.getFacturaProveedorOriginal().getnumero_retencion();
				}
				if(facturaproveedor.getnumero_retencion()!=null)
				{
					strValorNuevo=facturaproveedor.getnumero_retencion() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),FacturaProveedorConstantesFunciones.NUMERORETENCION,strValorActual,strValorNuevo);
			}	
			
			if(facturaproveedor.getIsNew()||!facturaproveedor.getnumero_serie().equals(facturaproveedor.getFacturaProveedorOriginal().getnumero_serie()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(facturaproveedor.getFacturaProveedorOriginal().getnumero_serie()!=null)
				{
					strValorActual=facturaproveedor.getFacturaProveedorOriginal().getnumero_serie();
				}
				if(facturaproveedor.getnumero_serie()!=null)
				{
					strValorNuevo=facturaproveedor.getnumero_serie() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),FacturaProveedorConstantesFunciones.NUMEROSERIE,strValorActual,strValorNuevo);
			}	
			
			if(facturaproveedor.getIsNew()||!facturaproveedor.getnumero_autorizacion().equals(facturaproveedor.getFacturaProveedorOriginal().getnumero_autorizacion()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(facturaproveedor.getFacturaProveedorOriginal().getnumero_autorizacion()!=null)
				{
					strValorActual=facturaproveedor.getFacturaProveedorOriginal().getnumero_autorizacion();
				}
				if(facturaproveedor.getnumero_autorizacion()!=null)
				{
					strValorNuevo=facturaproveedor.getnumero_autorizacion() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),FacturaProveedorConstantesFunciones.NUMEROAUTORIZACION,strValorActual,strValorNuevo);
			}	
			
			if(facturaproveedor.getIsNew()||!facturaproveedor.getfecha_validez().equals(facturaproveedor.getFacturaProveedorOriginal().getfecha_validez()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(facturaproveedor.getFacturaProveedorOriginal().getfecha_validez()!=null)
				{
					strValorActual=facturaproveedor.getFacturaProveedorOriginal().getfecha_validez().toString();
				}
				if(facturaproveedor.getfecha_validez()!=null)
				{
					strValorNuevo=facturaproveedor.getfecha_validez().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),FacturaProveedorConstantesFunciones.FECHAVALIDEZ,strValorActual,strValorNuevo);
			}	
			
			if(facturaproveedor.getIsNew()||!facturaproveedor.getid_tipo_retencion_fuente1().equals(facturaproveedor.getFacturaProveedorOriginal().getid_tipo_retencion_fuente1()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(facturaproveedor.getFacturaProveedorOriginal().getid_tipo_retencion_fuente1()!=null)
				{
					strValorActual=facturaproveedor.getFacturaProveedorOriginal().getid_tipo_retencion_fuente1().toString();
				}
				if(facturaproveedor.getid_tipo_retencion_fuente1()!=null)
				{
					strValorNuevo=facturaproveedor.getid_tipo_retencion_fuente1().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),FacturaProveedorConstantesFunciones.IDTIPORETENCIONFUENTE1,strValorActual,strValorNuevo);
			}	
			
			if(facturaproveedor.getIsNew()||!facturaproveedor.getret_fuente1_porcentaje().equals(facturaproveedor.getFacturaProveedorOriginal().getret_fuente1_porcentaje()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(facturaproveedor.getFacturaProveedorOriginal().getret_fuente1_porcentaje()!=null)
				{
					strValorActual=facturaproveedor.getFacturaProveedorOriginal().getret_fuente1_porcentaje().toString();
				}
				if(facturaproveedor.getret_fuente1_porcentaje()!=null)
				{
					strValorNuevo=facturaproveedor.getret_fuente1_porcentaje().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),FacturaProveedorConstantesFunciones.RETFUENTE1PORCENTAJE,strValorActual,strValorNuevo);
			}	
			
			if(facturaproveedor.getIsNew()||!facturaproveedor.getret_fuente1_base().equals(facturaproveedor.getFacturaProveedorOriginal().getret_fuente1_base()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(facturaproveedor.getFacturaProveedorOriginal().getret_fuente1_base()!=null)
				{
					strValorActual=facturaproveedor.getFacturaProveedorOriginal().getret_fuente1_base().toString();
				}
				if(facturaproveedor.getret_fuente1_base()!=null)
				{
					strValorNuevo=facturaproveedor.getret_fuente1_base().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),FacturaProveedorConstantesFunciones.RETFUENTE1BASE,strValorActual,strValorNuevo);
			}	
			
			if(facturaproveedor.getIsNew()||!facturaproveedor.getret_fuente1_retenido().equals(facturaproveedor.getFacturaProveedorOriginal().getret_fuente1_retenido()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(facturaproveedor.getFacturaProveedorOriginal().getret_fuente1_retenido()!=null)
				{
					strValorActual=facturaproveedor.getFacturaProveedorOriginal().getret_fuente1_retenido().toString();
				}
				if(facturaproveedor.getret_fuente1_retenido()!=null)
				{
					strValorNuevo=facturaproveedor.getret_fuente1_retenido().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),FacturaProveedorConstantesFunciones.RETFUENTE1RETENIDO,strValorActual,strValorNuevo);
			}	
			
			if(facturaproveedor.getIsNew()||!facturaproveedor.getid_tipo_retencion_fuente2().equals(facturaproveedor.getFacturaProveedorOriginal().getid_tipo_retencion_fuente2()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(facturaproveedor.getFacturaProveedorOriginal().getid_tipo_retencion_fuente2()!=null)
				{
					strValorActual=facturaproveedor.getFacturaProveedorOriginal().getid_tipo_retencion_fuente2().toString();
				}
				if(facturaproveedor.getid_tipo_retencion_fuente2()!=null)
				{
					strValorNuevo=facturaproveedor.getid_tipo_retencion_fuente2().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),FacturaProveedorConstantesFunciones.IDTIPORETENCIONFUENTE2,strValorActual,strValorNuevo);
			}	
			
			if(facturaproveedor.getIsNew()||!facturaproveedor.getret_fuente2_porcentaje().equals(facturaproveedor.getFacturaProveedorOriginal().getret_fuente2_porcentaje()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(facturaproveedor.getFacturaProveedorOriginal().getret_fuente2_porcentaje()!=null)
				{
					strValorActual=facturaproveedor.getFacturaProveedorOriginal().getret_fuente2_porcentaje().toString();
				}
				if(facturaproveedor.getret_fuente2_porcentaje()!=null)
				{
					strValorNuevo=facturaproveedor.getret_fuente2_porcentaje().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),FacturaProveedorConstantesFunciones.RETFUENTE2PORCENTAJE,strValorActual,strValorNuevo);
			}	
			
			if(facturaproveedor.getIsNew()||!facturaproveedor.getret_fuente2_base().equals(facturaproveedor.getFacturaProveedorOriginal().getret_fuente2_base()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(facturaproveedor.getFacturaProveedorOriginal().getret_fuente2_base()!=null)
				{
					strValorActual=facturaproveedor.getFacturaProveedorOriginal().getret_fuente2_base().toString();
				}
				if(facturaproveedor.getret_fuente2_base()!=null)
				{
					strValorNuevo=facturaproveedor.getret_fuente2_base().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),FacturaProveedorConstantesFunciones.RETFUENTE2BASE,strValorActual,strValorNuevo);
			}	
			
			if(facturaproveedor.getIsNew()||!facturaproveedor.getret_fuente2_retenido().equals(facturaproveedor.getFacturaProveedorOriginal().getret_fuente2_retenido()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(facturaproveedor.getFacturaProveedorOriginal().getret_fuente2_retenido()!=null)
				{
					strValorActual=facturaproveedor.getFacturaProveedorOriginal().getret_fuente2_retenido().toString();
				}
				if(facturaproveedor.getret_fuente2_retenido()!=null)
				{
					strValorNuevo=facturaproveedor.getret_fuente2_retenido().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),FacturaProveedorConstantesFunciones.RETFUENTE2RETENIDO,strValorActual,strValorNuevo);
			}	
			
			if(facturaproveedor.getIsNew()||!facturaproveedor.getid_tipo_retencion_iva1().equals(facturaproveedor.getFacturaProveedorOriginal().getid_tipo_retencion_iva1()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(facturaproveedor.getFacturaProveedorOriginal().getid_tipo_retencion_iva1()!=null)
				{
					strValorActual=facturaproveedor.getFacturaProveedorOriginal().getid_tipo_retencion_iva1().toString();
				}
				if(facturaproveedor.getid_tipo_retencion_iva1()!=null)
				{
					strValorNuevo=facturaproveedor.getid_tipo_retencion_iva1().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),FacturaProveedorConstantesFunciones.IDTIPORETENCIONIVA1,strValorActual,strValorNuevo);
			}	
			
			if(facturaproveedor.getIsNew()||!facturaproveedor.getret_iva_bien_porcentaje().equals(facturaproveedor.getFacturaProveedorOriginal().getret_iva_bien_porcentaje()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(facturaproveedor.getFacturaProveedorOriginal().getret_iva_bien_porcentaje()!=null)
				{
					strValorActual=facturaproveedor.getFacturaProveedorOriginal().getret_iva_bien_porcentaje().toString();
				}
				if(facturaproveedor.getret_iva_bien_porcentaje()!=null)
				{
					strValorNuevo=facturaproveedor.getret_iva_bien_porcentaje().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),FacturaProveedorConstantesFunciones.RETIVABIENPORCENTAJE,strValorActual,strValorNuevo);
			}	
			
			if(facturaproveedor.getIsNew()||!facturaproveedor.getret_iva_bien_base().equals(facturaproveedor.getFacturaProveedorOriginal().getret_iva_bien_base()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(facturaproveedor.getFacturaProveedorOriginal().getret_iva_bien_base()!=null)
				{
					strValorActual=facturaproveedor.getFacturaProveedorOriginal().getret_iva_bien_base().toString();
				}
				if(facturaproveedor.getret_iva_bien_base()!=null)
				{
					strValorNuevo=facturaproveedor.getret_iva_bien_base().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),FacturaProveedorConstantesFunciones.RETIVABIENBASE,strValorActual,strValorNuevo);
			}	
			
			if(facturaproveedor.getIsNew()||!facturaproveedor.getret_iva_bien_retenido().equals(facturaproveedor.getFacturaProveedorOriginal().getret_iva_bien_retenido()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(facturaproveedor.getFacturaProveedorOriginal().getret_iva_bien_retenido()!=null)
				{
					strValorActual=facturaproveedor.getFacturaProveedorOriginal().getret_iva_bien_retenido().toString();
				}
				if(facturaproveedor.getret_iva_bien_retenido()!=null)
				{
					strValorNuevo=facturaproveedor.getret_iva_bien_retenido().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),FacturaProveedorConstantesFunciones.RETIVABIENRETENIDO,strValorActual,strValorNuevo);
			}	
			
			if(facturaproveedor.getIsNew()||!facturaproveedor.getid_tipo_retencion_iva2().equals(facturaproveedor.getFacturaProveedorOriginal().getid_tipo_retencion_iva2()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(facturaproveedor.getFacturaProveedorOriginal().getid_tipo_retencion_iva2()!=null)
				{
					strValorActual=facturaproveedor.getFacturaProveedorOriginal().getid_tipo_retencion_iva2().toString();
				}
				if(facturaproveedor.getid_tipo_retencion_iva2()!=null)
				{
					strValorNuevo=facturaproveedor.getid_tipo_retencion_iva2().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),FacturaProveedorConstantesFunciones.IDTIPORETENCIONIVA2,strValorActual,strValorNuevo);
			}	
			
			if(facturaproveedor.getIsNew()||!facturaproveedor.getret_iva_servicio_porcentaje().equals(facturaproveedor.getFacturaProveedorOriginal().getret_iva_servicio_porcentaje()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(facturaproveedor.getFacturaProveedorOriginal().getret_iva_servicio_porcentaje()!=null)
				{
					strValorActual=facturaproveedor.getFacturaProveedorOriginal().getret_iva_servicio_porcentaje().toString();
				}
				if(facturaproveedor.getret_iva_servicio_porcentaje()!=null)
				{
					strValorNuevo=facturaproveedor.getret_iva_servicio_porcentaje().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),FacturaProveedorConstantesFunciones.RETIVASERVICIOPORCENTAJE,strValorActual,strValorNuevo);
			}	
			
			if(facturaproveedor.getIsNew()||!facturaproveedor.getret_iva_servicio_base().equals(facturaproveedor.getFacturaProveedorOriginal().getret_iva_servicio_base()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(facturaproveedor.getFacturaProveedorOriginal().getret_iva_servicio_base()!=null)
				{
					strValorActual=facturaproveedor.getFacturaProveedorOriginal().getret_iva_servicio_base().toString();
				}
				if(facturaproveedor.getret_iva_servicio_base()!=null)
				{
					strValorNuevo=facturaproveedor.getret_iva_servicio_base().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),FacturaProveedorConstantesFunciones.RETIVASERVICIOBASE,strValorActual,strValorNuevo);
			}	
			
			if(facturaproveedor.getIsNew()||!facturaproveedor.getret_iva_servicio_retenido().equals(facturaproveedor.getFacturaProveedorOriginal().getret_iva_servicio_retenido()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(facturaproveedor.getFacturaProveedorOriginal().getret_iva_servicio_retenido()!=null)
				{
					strValorActual=facturaproveedor.getFacturaProveedorOriginal().getret_iva_servicio_retenido().toString();
				}
				if(facturaproveedor.getret_iva_servicio_retenido()!=null)
				{
					strValorNuevo=facturaproveedor.getret_iva_servicio_retenido().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),FacturaProveedorConstantesFunciones.RETIVASERVICIORETENIDO,strValorActual,strValorNuevo);
			}	
			
			if(facturaproveedor.getIsNew()||!facturaproveedor.getanexo_numero_autorizacion().equals(facturaproveedor.getFacturaProveedorOriginal().getanexo_numero_autorizacion()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(facturaproveedor.getFacturaProveedorOriginal().getanexo_numero_autorizacion()!=null)
				{
					strValorActual=facturaproveedor.getFacturaProveedorOriginal().getanexo_numero_autorizacion();
				}
				if(facturaproveedor.getanexo_numero_autorizacion()!=null)
				{
					strValorNuevo=facturaproveedor.getanexo_numero_autorizacion() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),FacturaProveedorConstantesFunciones.ANEXONUMEROAUTORIZACION,strValorActual,strValorNuevo);
			}	
			
			if(facturaproveedor.getIsNew()||!facturaproveedor.getanexo_numeso_serie().equals(facturaproveedor.getFacturaProveedorOriginal().getanexo_numeso_serie()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(facturaproveedor.getFacturaProveedorOriginal().getanexo_numeso_serie()!=null)
				{
					strValorActual=facturaproveedor.getFacturaProveedorOriginal().getanexo_numeso_serie();
				}
				if(facturaproveedor.getanexo_numeso_serie()!=null)
				{
					strValorNuevo=facturaproveedor.getanexo_numeso_serie() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),FacturaProveedorConstantesFunciones.ANEXONUMESOSERIE,strValorActual,strValorNuevo);
			}	
			
			if(facturaproveedor.getIsNew()||!facturaproveedor.getanexo_fecha_validez().equals(facturaproveedor.getFacturaProveedorOriginal().getanexo_fecha_validez()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(facturaproveedor.getFacturaProveedorOriginal().getanexo_fecha_validez()!=null)
				{
					strValorActual=facturaproveedor.getFacturaProveedorOriginal().getanexo_fecha_validez().toString();
				}
				if(facturaproveedor.getanexo_fecha_validez()!=null)
				{
					strValorNuevo=facturaproveedor.getanexo_fecha_validez().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),FacturaProveedorConstantesFunciones.ANEXOFECHAVALIDEZ,strValorActual,strValorNuevo);
			}	
			
			if(facturaproveedor.getIsNew()||!facturaproveedor.getid_tipo_tributario().equals(facturaproveedor.getFacturaProveedorOriginal().getid_tipo_tributario()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(facturaproveedor.getFacturaProveedorOriginal().getid_tipo_tributario()!=null)
				{
					strValorActual=facturaproveedor.getFacturaProveedorOriginal().getid_tipo_tributario().toString();
				}
				if(facturaproveedor.getid_tipo_tributario()!=null)
				{
					strValorNuevo=facturaproveedor.getid_tipo_tributario().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),FacturaProveedorConstantesFunciones.IDTIPOTRIBUTARIO,strValorActual,strValorNuevo);
			}	
			
			if(facturaproveedor.getIsNew()||!facturaproveedor.getanexo_factura_inicio().equals(facturaproveedor.getFacturaProveedorOriginal().getanexo_factura_inicio()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(facturaproveedor.getFacturaProveedorOriginal().getanexo_factura_inicio()!=null)
				{
					strValorActual=facturaproveedor.getFacturaProveedorOriginal().getanexo_factura_inicio();
				}
				if(facturaproveedor.getanexo_factura_inicio()!=null)
				{
					strValorNuevo=facturaproveedor.getanexo_factura_inicio() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),FacturaProveedorConstantesFunciones.ANEXOFACTURAINICIO,strValorActual,strValorNuevo);
			}	
			
			if(facturaproveedor.getIsNew()||!facturaproveedor.getanexo_factura_fin().equals(facturaproveedor.getFacturaProveedorOriginal().getanexo_factura_fin()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(facturaproveedor.getFacturaProveedorOriginal().getanexo_factura_fin()!=null)
				{
					strValorActual=facturaproveedor.getFacturaProveedorOriginal().getanexo_factura_fin();
				}
				if(facturaproveedor.getanexo_factura_fin()!=null)
				{
					strValorNuevo=facturaproveedor.getanexo_factura_fin() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),FacturaProveedorConstantesFunciones.ANEXOFACTURAFIN,strValorActual,strValorNuevo);
			}	
			
			if(facturaproveedor.getIsNew()||!facturaproveedor.getid_cuenta_contable_credito_fiscal_bienes().equals(facturaproveedor.getFacturaProveedorOriginal().getid_cuenta_contable_credito_fiscal_bienes()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(facturaproveedor.getFacturaProveedorOriginal().getid_cuenta_contable_credito_fiscal_bienes()!=null)
				{
					strValorActual=facturaproveedor.getFacturaProveedorOriginal().getid_cuenta_contable_credito_fiscal_bienes().toString();
				}
				if(facturaproveedor.getid_cuenta_contable_credito_fiscal_bienes()!=null)
				{
					strValorNuevo=facturaproveedor.getid_cuenta_contable_credito_fiscal_bienes().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),FacturaProveedorConstantesFunciones.IDCUENTACONTABLECREDITOFISCALBIENES,strValorActual,strValorNuevo);
			}	
			
			if(facturaproveedor.getIsNew()||!facturaproveedor.getid_responsable_fondo().equals(facturaproveedor.getFacturaProveedorOriginal().getid_responsable_fondo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(facturaproveedor.getFacturaProveedorOriginal().getid_responsable_fondo()!=null)
				{
					strValorActual=facturaproveedor.getFacturaProveedorOriginal().getid_responsable_fondo().toString();
				}
				if(facturaproveedor.getid_responsable_fondo()!=null)
				{
					strValorNuevo=facturaproveedor.getid_responsable_fondo().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),FacturaProveedorConstantesFunciones.IDRESPONSABLEFONDO,strValorActual,strValorNuevo);
			}	
			
			if(facturaproveedor.getIsNew()||!facturaproveedor.getid_cuenta_contable_credito_fiscal_servicios().equals(facturaproveedor.getFacturaProveedorOriginal().getid_cuenta_contable_credito_fiscal_servicios()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(facturaproveedor.getFacturaProveedorOriginal().getid_cuenta_contable_credito_fiscal_servicios()!=null)
				{
					strValorActual=facturaproveedor.getFacturaProveedorOriginal().getid_cuenta_contable_credito_fiscal_servicios().toString();
				}
				if(facturaproveedor.getid_cuenta_contable_credito_fiscal_servicios()!=null)
				{
					strValorNuevo=facturaproveedor.getid_cuenta_contable_credito_fiscal_servicios().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),FacturaProveedorConstantesFunciones.IDCUENTACONTABLECREDITOFISCALSERVICIOS,strValorActual,strValorNuevo);
			}	
			
			if(facturaproveedor.getIsNew()||!facturaproveedor.getsecuencial().equals(facturaproveedor.getFacturaProveedorOriginal().getsecuencial()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(facturaproveedor.getFacturaProveedorOriginal().getsecuencial()!=null)
				{
					strValorActual=facturaproveedor.getFacturaProveedorOriginal().getsecuencial();
				}
				if(facturaproveedor.getsecuencial()!=null)
				{
					strValorNuevo=facturaproveedor.getsecuencial() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),FacturaProveedorConstantesFunciones.SECUENCIAL,strValorActual,strValorNuevo);
			}	
			
			if(facturaproveedor.getIsNew()||!facturaproveedor.getid_cuenta_contable_gasto().equals(facturaproveedor.getFacturaProveedorOriginal().getid_cuenta_contable_gasto()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(facturaproveedor.getFacturaProveedorOriginal().getid_cuenta_contable_gasto()!=null)
				{
					strValorActual=facturaproveedor.getFacturaProveedorOriginal().getid_cuenta_contable_gasto().toString();
				}
				if(facturaproveedor.getid_cuenta_contable_gasto()!=null)
				{
					strValorNuevo=facturaproveedor.getid_cuenta_contable_gasto().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),FacturaProveedorConstantesFunciones.IDCUENTACONTABLEGASTO,strValorActual,strValorNuevo);
			}	
			
			if(facturaproveedor.getIsNew()||!facturaproveedor.getgasto_valor().equals(facturaproveedor.getFacturaProveedorOriginal().getgasto_valor()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(facturaproveedor.getFacturaProveedorOriginal().getgasto_valor()!=null)
				{
					strValorActual=facturaproveedor.getFacturaProveedorOriginal().getgasto_valor().toString();
				}
				if(facturaproveedor.getgasto_valor()!=null)
				{
					strValorNuevo=facturaproveedor.getgasto_valor().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),FacturaProveedorConstantesFunciones.GASTOVALOR,strValorActual,strValorNuevo);
			}	
			
			if(facturaproveedor.getIsNew()||!facturaproveedor.getid_cuenta_contable_gasto2().equals(facturaproveedor.getFacturaProveedorOriginal().getid_cuenta_contable_gasto2()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(facturaproveedor.getFacturaProveedorOriginal().getid_cuenta_contable_gasto2()!=null)
				{
					strValorActual=facturaproveedor.getFacturaProveedorOriginal().getid_cuenta_contable_gasto2().toString();
				}
				if(facturaproveedor.getid_cuenta_contable_gasto2()!=null)
				{
					strValorNuevo=facturaproveedor.getid_cuenta_contable_gasto2().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),FacturaProveedorConstantesFunciones.IDCUENTACONTABLEGASTO2,strValorActual,strValorNuevo);
			}	
			
			if(facturaproveedor.getIsNew()||!facturaproveedor.getgasto_valor2().equals(facturaproveedor.getFacturaProveedorOriginal().getgasto_valor2()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(facturaproveedor.getFacturaProveedorOriginal().getgasto_valor2()!=null)
				{
					strValorActual=facturaproveedor.getFacturaProveedorOriginal().getgasto_valor2().toString();
				}
				if(facturaproveedor.getgasto_valor2()!=null)
				{
					strValorNuevo=facturaproveedor.getgasto_valor2().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),FacturaProveedorConstantesFunciones.GASTOVALOR2,strValorActual,strValorNuevo);
			}	
			
			if(facturaproveedor.getIsNew()||!facturaproveedor.getgasto_nombre().equals(facturaproveedor.getFacturaProveedorOriginal().getgasto_nombre()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(facturaproveedor.getFacturaProveedorOriginal().getgasto_nombre()!=null)
				{
					strValorActual=facturaproveedor.getFacturaProveedorOriginal().getgasto_nombre();
				}
				if(facturaproveedor.getgasto_nombre()!=null)
				{
					strValorNuevo=facturaproveedor.getgasto_nombre() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),FacturaProveedorConstantesFunciones.GASTONOMBRE,strValorActual,strValorNuevo);
			}	
			
			if(facturaproveedor.getIsNew()||!facturaproveedor.getgasto_nombre2().equals(facturaproveedor.getFacturaProveedorOriginal().getgasto_nombre2()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(facturaproveedor.getFacturaProveedorOriginal().getgasto_nombre2()!=null)
				{
					strValorActual=facturaproveedor.getFacturaProveedorOriginal().getgasto_nombre2();
				}
				if(facturaproveedor.getgasto_nombre2()!=null)
				{
					strValorNuevo=facturaproveedor.getgasto_nombre2() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),FacturaProveedorConstantesFunciones.GASTONOMBRE2,strValorActual,strValorNuevo);
			}	
			
			if(facturaproveedor.getIsNew()||!facturaproveedor.getid_cuenta_contable_credito_fin().equals(facturaproveedor.getFacturaProveedorOriginal().getid_cuenta_contable_credito_fin()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(facturaproveedor.getFacturaProveedorOriginal().getid_cuenta_contable_credito_fin()!=null)
				{
					strValorActual=facturaproveedor.getFacturaProveedorOriginal().getid_cuenta_contable_credito_fin().toString();
				}
				if(facturaproveedor.getid_cuenta_contable_credito_fin()!=null)
				{
					strValorNuevo=facturaproveedor.getid_cuenta_contable_credito_fin().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),FacturaProveedorConstantesFunciones.IDCUENTACONTABLECREDITOFIN,strValorActual,strValorNuevo);
			}	
			
			if(facturaproveedor.getIsNew()||!facturaproveedor.getid_cuenta_contable_credito_fin2().equals(facturaproveedor.getFacturaProveedorOriginal().getid_cuenta_contable_credito_fin2()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(facturaproveedor.getFacturaProveedorOriginal().getid_cuenta_contable_credito_fin2()!=null)
				{
					strValorActual=facturaproveedor.getFacturaProveedorOriginal().getid_cuenta_contable_credito_fin2().toString();
				}
				if(facturaproveedor.getid_cuenta_contable_credito_fin2()!=null)
				{
					strValorNuevo=facturaproveedor.getid_cuenta_contable_credito_fin2().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),FacturaProveedorConstantesFunciones.IDCUENTACONTABLECREDITOFIN2,strValorActual,strValorNuevo);
			}	
			
			if(facturaproveedor.getIsNew()||!facturaproveedor.getid_cuenta_contable_credito().equals(facturaproveedor.getFacturaProveedorOriginal().getid_cuenta_contable_credito()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(facturaproveedor.getFacturaProveedorOriginal().getid_cuenta_contable_credito()!=null)
				{
					strValorActual=facturaproveedor.getFacturaProveedorOriginal().getid_cuenta_contable_credito().toString();
				}
				if(facturaproveedor.getid_cuenta_contable_credito()!=null)
				{
					strValorNuevo=facturaproveedor.getid_cuenta_contable_credito().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),FacturaProveedorConstantesFunciones.IDCUENTACONTABLECREDITO,strValorActual,strValorNuevo);
			}	
			
			if(facturaproveedor.getIsNew()||!facturaproveedor.getdescripcion().equals(facturaproveedor.getFacturaProveedorOriginal().getdescripcion()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(facturaproveedor.getFacturaProveedorOriginal().getdescripcion()!=null)
				{
					strValorActual=facturaproveedor.getFacturaProveedorOriginal().getdescripcion();
				}
				if(facturaproveedor.getdescripcion()!=null)
				{
					strValorNuevo=facturaproveedor.getdescripcion() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),FacturaProveedorConstantesFunciones.DESCRIPCION,strValorActual,strValorNuevo);
			}	
			
			if(facturaproveedor.getIsNew()||!facturaproveedor.getid_tipo_movimiento().equals(facturaproveedor.getFacturaProveedorOriginal().getid_tipo_movimiento()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(facturaproveedor.getFacturaProveedorOriginal().getid_tipo_movimiento()!=null)
				{
					strValorActual=facturaproveedor.getFacturaProveedorOriginal().getid_tipo_movimiento().toString();
				}
				if(facturaproveedor.getid_tipo_movimiento()!=null)
				{
					strValorNuevo=facturaproveedor.getid_tipo_movimiento().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),FacturaProveedorConstantesFunciones.IDTIPOMOVIMIENTO,strValorActual,strValorNuevo);
			}	
			
			if(facturaproveedor.getIsNew()||!facturaproveedor.getid_tipo_movimiento_modulo().equals(facturaproveedor.getFacturaProveedorOriginal().getid_tipo_movimiento_modulo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(facturaproveedor.getFacturaProveedorOriginal().getid_tipo_movimiento_modulo()!=null)
				{
					strValorActual=facturaproveedor.getFacturaProveedorOriginal().getid_tipo_movimiento_modulo().toString();
				}
				if(facturaproveedor.getid_tipo_movimiento_modulo()!=null)
				{
					strValorNuevo=facturaproveedor.getid_tipo_movimiento_modulo().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),FacturaProveedorConstantesFunciones.IDTIPOMOVIMIENTOMODULO,strValorActual,strValorNuevo);
			}	
			
			if(facturaproveedor.getIsNew()||!facturaproveedor.getid_tipo_transaccion_modulo().equals(facturaproveedor.getFacturaProveedorOriginal().getid_tipo_transaccion_modulo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(facturaproveedor.getFacturaProveedorOriginal().getid_tipo_transaccion_modulo()!=null)
				{
					strValorActual=facturaproveedor.getFacturaProveedorOriginal().getid_tipo_transaccion_modulo().toString();
				}
				if(facturaproveedor.getid_tipo_transaccion_modulo()!=null)
				{
					strValorNuevo=facturaproveedor.getid_tipo_transaccion_modulo().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),FacturaProveedorConstantesFunciones.IDTIPOTRANSACCIONMODULO,strValorActual,strValorNuevo);
			}	
			
			if(facturaproveedor.getIsNew()||!facturaproveedor.getnumero_mayor().equals(facturaproveedor.getFacturaProveedorOriginal().getnumero_mayor()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(facturaproveedor.getFacturaProveedorOriginal().getnumero_mayor()!=null)
				{
					strValorActual=facturaproveedor.getFacturaProveedorOriginal().getnumero_mayor();
				}
				if(facturaproveedor.getnumero_mayor()!=null)
				{
					strValorNuevo=facturaproveedor.getnumero_mayor() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),FacturaProveedorConstantesFunciones.NUMEROMAYOR,strValorActual,strValorNuevo);
			}	
			
			if(facturaproveedor.getIsNew()||!facturaproveedor.getcodigo_asiento().equals(facturaproveedor.getFacturaProveedorOriginal().getcodigo_asiento()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(facturaproveedor.getFacturaProveedorOriginal().getcodigo_asiento()!=null)
				{
					strValorActual=facturaproveedor.getFacturaProveedorOriginal().getcodigo_asiento();
				}
				if(facturaproveedor.getcodigo_asiento()!=null)
				{
					strValorNuevo=facturaproveedor.getcodigo_asiento() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),FacturaProveedorConstantesFunciones.CODIGOASIENTO,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void saveFacturaProveedorRelacionesWithConnection(FacturaProveedor facturaproveedor,List<DetalleFacturaProveedor> detallefacturaproveedors) throws Exception {

		if(!facturaproveedor.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveFacturaProveedorRelacionesBase(facturaproveedor,detallefacturaproveedors,true);
		}
	}

	public void saveFacturaProveedorRelaciones(FacturaProveedor facturaproveedor,List<DetalleFacturaProveedor> detallefacturaproveedors)throws Exception {

		if(!facturaproveedor.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveFacturaProveedorRelacionesBase(facturaproveedor,detallefacturaproveedors,false);
		}
	}

	public void saveFacturaProveedorRelacionesBase(FacturaProveedor facturaproveedor,List<DetalleFacturaProveedor> detallefacturaproveedors,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("FacturaProveedor-saveRelacionesWithConnection");}
	
			facturaproveedor.setDetalleFacturaProveedors(detallefacturaproveedors);

			this.setFacturaProveedor(facturaproveedor);

			if(FacturaProveedorLogicAdditional.validarSaveRelaciones(facturaproveedor,this)) {

				FacturaProveedorLogicAdditional.updateRelacionesToSave(facturaproveedor,this);

				if((facturaproveedor.getIsNew()||facturaproveedor.getIsChanged())&&!facturaproveedor.getIsDeleted()) {
					this.saveFacturaProveedor();
					this.saveFacturaProveedorRelacionesDetalles(detallefacturaproveedors);

				} else if(facturaproveedor.getIsDeleted()) {
					this.saveFacturaProveedorRelacionesDetalles(detallefacturaproveedors);
					this.saveFacturaProveedor();
				}

				FacturaProveedorLogicAdditional.updateRelacionesToSaveAfter(facturaproveedor,this);

			} else {
				throw new Exception("LOS DATOS SON INVALIDOS");
			}

			if(conConexion) {connexion.commit();}

		} catch(Exception e) {
			
			DetalleFacturaProveedorConstantesFunciones.InicializarGeneralEntityAuxiliaresDetalleFacturaProveedors(detallefacturaproveedors,true,true);

			if(conConexion){connexion.rollback();}
			Funciones.manageException(logger,e);
			throw e;

		} finally {
			if(conConexion){this.closeNewConnexionToDeep();}
		}
	}
	
	
	private void saveFacturaProveedorRelacionesDetalles(List<DetalleFacturaProveedor> detallefacturaproveedors)throws Exception {
		try {
	

			Long idFacturaProveedorActual=this.getFacturaProveedor().getId();

			DetalleFacturaProveedorLogic detallefacturaproveedorLogic_Desde_FacturaProveedor=new DetalleFacturaProveedorLogic();
			detallefacturaproveedorLogic_Desde_FacturaProveedor.setDetalleFacturaProveedors(detallefacturaproveedors);

			detallefacturaproveedorLogic_Desde_FacturaProveedor.setConnexion(this.getConnexion());
			detallefacturaproveedorLogic_Desde_FacturaProveedor.setDatosCliente(this.datosCliente);

			for(DetalleFacturaProveedor detallefacturaproveedor_Desde_FacturaProveedor:detallefacturaproveedorLogic_Desde_FacturaProveedor.getDetalleFacturaProveedors()) {
				detallefacturaproveedor_Desde_FacturaProveedor.setid_factura_proveedor(idFacturaProveedorActual);
			}

			detallefacturaproveedorLogic_Desde_FacturaProveedor.saveDetalleFacturaProveedors();

		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfFacturaProveedor(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=FacturaProveedorConstantesFunciones.getClassesForeignKeysOfFacturaProveedor(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfFacturaProveedor(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=FacturaProveedorConstantesFunciones.getClassesRelationshipsOfFacturaProveedor(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}
