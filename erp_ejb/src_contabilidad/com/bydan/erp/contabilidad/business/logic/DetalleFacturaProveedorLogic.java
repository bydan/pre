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
import com.bydan.erp.contabilidad.util.DetalleFacturaProveedorConstantesFunciones;
import com.bydan.erp.contabilidad.util.DetalleFacturaProveedorParameterReturnGeneral;
//import com.bydan.erp.contabilidad.util.DetalleFacturaProveedorParameterGeneral;
import com.bydan.erp.contabilidad.business.entity.DetalleFacturaProveedor;
import com.bydan.erp.contabilidad.business.logic.DetalleFacturaProveedorLogicAdditional;
import com.bydan.erp.contabilidad.business.dataaccess.*;
import com.bydan.erp.contabilidad.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.inventario.business.entity.*;


import com.bydan.erp.seguridad.business.logic.*;
import com.bydan.erp.inventario.business.logic.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.inventario.util.*;


import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.inventario.business.dataaccess.*;








@SuppressWarnings("unused")
public class DetalleFacturaProveedorLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(DetalleFacturaProveedorLogic.class);
	
	protected DetalleFacturaProveedorDataAccess detallefacturaproveedorDataAccess; 	
	protected DetalleFacturaProveedor detallefacturaproveedor;
	protected List<DetalleFacturaProveedor> detallefacturaproveedors;
	protected Object detallefacturaproveedorObject;	
	protected List<Object> detallefacturaproveedorsObject;
	
	public static ClassValidator<DetalleFacturaProveedor> detallefacturaproveedorValidator = new ClassValidator<DetalleFacturaProveedor>(DetalleFacturaProveedor.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected DetalleFacturaProveedorLogicAdditional detallefacturaproveedorLogicAdditional=null;
	
	public DetalleFacturaProveedorLogicAdditional getDetalleFacturaProveedorLogicAdditional() {
		return this.detallefacturaproveedorLogicAdditional;
	}
	
	public void setDetalleFacturaProveedorLogicAdditional(DetalleFacturaProveedorLogicAdditional detallefacturaproveedorLogicAdditional) {
		try {
			this.detallefacturaproveedorLogicAdditional=detallefacturaproveedorLogicAdditional;
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
	
	
	
	
	public  DetalleFacturaProveedorLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.detallefacturaproveedorDataAccess = new DetalleFacturaProveedorDataAccess();
			
			this.detallefacturaproveedors= new ArrayList<DetalleFacturaProveedor>();
			this.detallefacturaproveedor= new DetalleFacturaProveedor();
			
			this.detallefacturaproveedorObject=new Object();
			this.detallefacturaproveedorsObject=new ArrayList<Object>();
				
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
			
			this.detallefacturaproveedorDataAccess.setConnexionType(this.connexionType);
			this.detallefacturaproveedorDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  DetalleFacturaProveedorLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.detallefacturaproveedorDataAccess = new DetalleFacturaProveedorDataAccess();
			this.detallefacturaproveedors= new ArrayList<DetalleFacturaProveedor>();
			this.detallefacturaproveedor= new DetalleFacturaProveedor();
			this.detallefacturaproveedorObject=new Object();
			this.detallefacturaproveedorsObject=new ArrayList<Object>();
			
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
			
			this.detallefacturaproveedorDataAccess.setConnexionType(this.connexionType);
			this.detallefacturaproveedorDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public DetalleFacturaProveedor getDetalleFacturaProveedor() throws Exception {	
		DetalleFacturaProveedorLogicAdditional.checkDetalleFacturaProveedorToGet(detallefacturaproveedor,this.datosCliente,this.arrDatoGeneral);
		DetalleFacturaProveedorLogicAdditional.updateDetalleFacturaProveedorToGet(detallefacturaproveedor,this.arrDatoGeneral);
		
		return detallefacturaproveedor;
	}
		
	public void setDetalleFacturaProveedor(DetalleFacturaProveedor newDetalleFacturaProveedor) {
		this.detallefacturaproveedor = newDetalleFacturaProveedor;
	}
	
	public DetalleFacturaProveedorDataAccess getDetalleFacturaProveedorDataAccess() {
		return detallefacturaproveedorDataAccess;
	}
	
	public void setDetalleFacturaProveedorDataAccess(DetalleFacturaProveedorDataAccess newdetallefacturaproveedorDataAccess) {
		this.detallefacturaproveedorDataAccess = newdetallefacturaproveedorDataAccess;
	}
	
	public List<DetalleFacturaProveedor> getDetalleFacturaProveedors() throws Exception {		
		this.quitarDetalleFacturaProveedorsNulos();
		
		DetalleFacturaProveedorLogicAdditional.checkDetalleFacturaProveedorToGets(detallefacturaproveedors,this.datosCliente,this.arrDatoGeneral);
		
		for (DetalleFacturaProveedor detallefacturaproveedorLocal: detallefacturaproveedors ) {
			DetalleFacturaProveedorLogicAdditional.updateDetalleFacturaProveedorToGet(detallefacturaproveedorLocal,this.arrDatoGeneral);
		}
		
		return detallefacturaproveedors;
	}
	
	public void setDetalleFacturaProveedors(List<DetalleFacturaProveedor> newDetalleFacturaProveedors) {
		this.detallefacturaproveedors = newDetalleFacturaProveedors;
	}
	
	public Object getDetalleFacturaProveedorObject() {	
		this.detallefacturaproveedorObject=this.detallefacturaproveedorDataAccess.getEntityObject();
		return this.detallefacturaproveedorObject;
	}
		
	public void setDetalleFacturaProveedorObject(Object newDetalleFacturaProveedorObject) {
		this.detallefacturaproveedorObject = newDetalleFacturaProveedorObject;
	}
	
	public List<Object> getDetalleFacturaProveedorsObject() {		
		this.detallefacturaproveedorsObject=this.detallefacturaproveedorDataAccess.getEntitiesObject();
		return this.detallefacturaproveedorsObject;
	}
		
	public void setDetalleFacturaProveedorsObject(List<Object> newDetalleFacturaProveedorsObject) {
		this.detallefacturaproveedorsObject = newDetalleFacturaProveedorsObject;
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
		
		if(this.detallefacturaproveedorDataAccess!=null) {
			this.detallefacturaproveedorDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleFacturaProveedor.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			detallefacturaproveedorDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			detallefacturaproveedorDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		detallefacturaproveedor = new  DetalleFacturaProveedor();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleFacturaProveedor.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			detallefacturaproveedor=detallefacturaproveedorDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.detallefacturaproveedor,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				DetalleFacturaProveedorConstantesFunciones.refrescarForeignKeysDescripcionesDetalleFacturaProveedor(this.detallefacturaproveedor);
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
		detallefacturaproveedor = new  DetalleFacturaProveedor();
		  		  
        try {
			
			detallefacturaproveedor=detallefacturaproveedorDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.detallefacturaproveedor,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				DetalleFacturaProveedorConstantesFunciones.refrescarForeignKeysDescripcionesDetalleFacturaProveedor(this.detallefacturaproveedor);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		detallefacturaproveedor = new  DetalleFacturaProveedor();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleFacturaProveedor.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			detallefacturaproveedor=detallefacturaproveedorDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.detallefacturaproveedor,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				DetalleFacturaProveedorConstantesFunciones.refrescarForeignKeysDescripcionesDetalleFacturaProveedor(this.detallefacturaproveedor);
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
		detallefacturaproveedor = new  DetalleFacturaProveedor();
		  		  
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
		detallefacturaproveedor = new  DetalleFacturaProveedor();
		  		  
        try {
			
			detallefacturaproveedor=detallefacturaproveedorDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.detallefacturaproveedor,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				DetalleFacturaProveedorConstantesFunciones.refrescarForeignKeysDescripcionesDetalleFacturaProveedor(this.detallefacturaproveedor);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		detallefacturaproveedor = new  DetalleFacturaProveedor();
		  		  
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
		detallefacturaproveedor = new  DetalleFacturaProveedor();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleFacturaProveedor.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =detallefacturaproveedorDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		detallefacturaproveedor = new  DetalleFacturaProveedor();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=detallefacturaproveedorDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		detallefacturaproveedor = new  DetalleFacturaProveedor();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleFacturaProveedor.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =detallefacturaproveedorDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		detallefacturaproveedor = new  DetalleFacturaProveedor();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=detallefacturaproveedorDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		detallefacturaproveedor = new  DetalleFacturaProveedor();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleFacturaProveedor.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =detallefacturaproveedorDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		detallefacturaproveedor = new  DetalleFacturaProveedor();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=detallefacturaproveedorDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		detallefacturaproveedors = new  ArrayList<DetalleFacturaProveedor>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleFacturaProveedor.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			DetalleFacturaProveedorLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detallefacturaproveedors=detallefacturaproveedorDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarDetalleFacturaProveedor(detallefacturaproveedors);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetalleFacturaProveedorConstantesFunciones.refrescarForeignKeysDescripcionesDetalleFacturaProveedor(this.detallefacturaproveedors);
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
		detallefacturaproveedors = new  ArrayList<DetalleFacturaProveedor>();
		  		  
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
		detallefacturaproveedors = new  ArrayList<DetalleFacturaProveedor>();
		  		  
        try {			
			DetalleFacturaProveedorLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detallefacturaproveedors=detallefacturaproveedorDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarDetalleFacturaProveedor(detallefacturaproveedors);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetalleFacturaProveedorConstantesFunciones.refrescarForeignKeysDescripcionesDetalleFacturaProveedor(this.detallefacturaproveedors);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		detallefacturaproveedors = new  ArrayList<DetalleFacturaProveedor>();
		  		  
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
		detallefacturaproveedors = new  ArrayList<DetalleFacturaProveedor>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleFacturaProveedor.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			DetalleFacturaProveedorLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detallefacturaproveedors=detallefacturaproveedorDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarDetalleFacturaProveedor(detallefacturaproveedors);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetalleFacturaProveedorConstantesFunciones.refrescarForeignKeysDescripcionesDetalleFacturaProveedor(this.detallefacturaproveedors);
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
		detallefacturaproveedors = new  ArrayList<DetalleFacturaProveedor>();
		  		  
        try {
			DetalleFacturaProveedorLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detallefacturaproveedors=detallefacturaproveedorDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarDetalleFacturaProveedor(detallefacturaproveedors);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetalleFacturaProveedorConstantesFunciones.refrescarForeignKeysDescripcionesDetalleFacturaProveedor(this.detallefacturaproveedors);
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
		detallefacturaproveedors = new  ArrayList<DetalleFacturaProveedor>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleFacturaProveedor.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			DetalleFacturaProveedorLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detallefacturaproveedors=detallefacturaproveedorDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarDetalleFacturaProveedor(detallefacturaproveedors);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetalleFacturaProveedorConstantesFunciones.refrescarForeignKeysDescripcionesDetalleFacturaProveedor(this.detallefacturaproveedors);
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
		detallefacturaproveedors = new  ArrayList<DetalleFacturaProveedor>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			DetalleFacturaProveedorLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detallefacturaproveedors=detallefacturaproveedorDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarDetalleFacturaProveedor(detallefacturaproveedors);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetalleFacturaProveedorConstantesFunciones.refrescarForeignKeysDescripcionesDetalleFacturaProveedor(this.detallefacturaproveedors);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		detallefacturaproveedor = new  DetalleFacturaProveedor();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleFacturaProveedor.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			DetalleFacturaProveedorLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detallefacturaproveedor=detallefacturaproveedorDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarDetalleFacturaProveedor(detallefacturaproveedor);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetalleFacturaProveedorConstantesFunciones.refrescarForeignKeysDescripcionesDetalleFacturaProveedor(this.detallefacturaproveedor);
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
		detallefacturaproveedor = new  DetalleFacturaProveedor();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			DetalleFacturaProveedorLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detallefacturaproveedor=detallefacturaproveedorDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarDetalleFacturaProveedor(detallefacturaproveedor);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetalleFacturaProveedorConstantesFunciones.refrescarForeignKeysDescripcionesDetalleFacturaProveedor(this.detallefacturaproveedor);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		detallefacturaproveedors = new  ArrayList<DetalleFacturaProveedor>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleFacturaProveedor.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			DetalleFacturaProveedorLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detallefacturaproveedors=detallefacturaproveedorDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarDetalleFacturaProveedor(detallefacturaproveedors);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetalleFacturaProveedorConstantesFunciones.refrescarForeignKeysDescripcionesDetalleFacturaProveedor(this.detallefacturaproveedors);
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
		detallefacturaproveedors = new  ArrayList<DetalleFacturaProveedor>();
		  		  
        try {
			DetalleFacturaProveedorLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detallefacturaproveedors=detallefacturaproveedorDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarDetalleFacturaProveedor(detallefacturaproveedors);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetalleFacturaProveedorConstantesFunciones.refrescarForeignKeysDescripcionesDetalleFacturaProveedor(this.detallefacturaproveedors);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosDetalleFacturaProveedorsWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		detallefacturaproveedors = new  ArrayList<DetalleFacturaProveedor>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleFacturaProveedor.class.getSimpleName()+"-getTodosDetalleFacturaProveedorsWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			DetalleFacturaProveedorLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detallefacturaproveedors=detallefacturaproveedorDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarDetalleFacturaProveedor(detallefacturaproveedors);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetalleFacturaProveedorConstantesFunciones.refrescarForeignKeysDescripcionesDetalleFacturaProveedor(this.detallefacturaproveedors);
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
	
	public  void  getTodosDetalleFacturaProveedors(String sFinalQuery,Pagination pagination)throws Exception {
		detallefacturaproveedors = new  ArrayList<DetalleFacturaProveedor>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			DetalleFacturaProveedorLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detallefacturaproveedors=detallefacturaproveedorDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarDetalleFacturaProveedor(detallefacturaproveedors);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetalleFacturaProveedorConstantesFunciones.refrescarForeignKeysDescripcionesDetalleFacturaProveedor(this.detallefacturaproveedors);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarDetalleFacturaProveedor(DetalleFacturaProveedor detallefacturaproveedor) throws Exception {
		Boolean estaValidado=false;
		
		if(detallefacturaproveedor.getIsNew() || detallefacturaproveedor.getIsChanged()) { 
			this.invalidValues = detallefacturaproveedorValidator.getInvalidValues(detallefacturaproveedor);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(detallefacturaproveedor);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarDetalleFacturaProveedor(List<DetalleFacturaProveedor> DetalleFacturaProveedors) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(DetalleFacturaProveedor detallefacturaproveedorLocal:detallefacturaproveedors) {				
			estaValidadoObjeto=this.validarGuardarDetalleFacturaProveedor(detallefacturaproveedorLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarDetalleFacturaProveedor(List<DetalleFacturaProveedor> DetalleFacturaProveedors) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarDetalleFacturaProveedor(detallefacturaproveedors)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarDetalleFacturaProveedor(DetalleFacturaProveedor DetalleFacturaProveedor) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarDetalleFacturaProveedor(detallefacturaproveedor)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(DetalleFacturaProveedor detallefacturaproveedor) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+detallefacturaproveedor.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=DetalleFacturaProveedorConstantesFunciones.getDetalleFacturaProveedorLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"detallefacturaproveedor","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(DetalleFacturaProveedorConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(DetalleFacturaProveedorConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveDetalleFacturaProveedorWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleFacturaProveedor.class.getSimpleName()+"-saveDetalleFacturaProveedorWithConnection");connexion.begin();			
			
			DetalleFacturaProveedorLogicAdditional.checkDetalleFacturaProveedorToSave(this.detallefacturaproveedor,this.datosCliente,connexion,this.arrDatoGeneral);
			
			DetalleFacturaProveedorLogicAdditional.updateDetalleFacturaProveedorToSave(this.detallefacturaproveedor,this.arrDatoGeneral);
			
			DetalleFacturaProveedorLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.detallefacturaproveedor,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowDetalleFacturaProveedor();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarDetalleFacturaProveedor(this.detallefacturaproveedor)) {
				DetalleFacturaProveedorDataAccess.save(this.detallefacturaproveedor, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.detallefacturaproveedor,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			DetalleFacturaProveedorLogicAdditional.checkDetalleFacturaProveedorToSaveAfter(this.detallefacturaproveedor,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowDetalleFacturaProveedor();
			
			connexion.commit();			
			
			if(this.detallefacturaproveedor.getIsDeleted()) {
				this.detallefacturaproveedor=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveDetalleFacturaProveedor()throws Exception {	
		try {	
			
			DetalleFacturaProveedorLogicAdditional.checkDetalleFacturaProveedorToSave(this.detallefacturaproveedor,this.datosCliente,connexion,this.arrDatoGeneral);
			
			DetalleFacturaProveedorLogicAdditional.updateDetalleFacturaProveedorToSave(this.detallefacturaproveedor,this.arrDatoGeneral);
			
			DetalleFacturaProveedorLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.detallefacturaproveedor,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarDetalleFacturaProveedor(this.detallefacturaproveedor)) {			
				DetalleFacturaProveedorDataAccess.save(this.detallefacturaproveedor, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.detallefacturaproveedor,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			DetalleFacturaProveedorLogicAdditional.checkDetalleFacturaProveedorToSaveAfter(this.detallefacturaproveedor,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.detallefacturaproveedor.getIsDeleted()) {
				this.detallefacturaproveedor=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveDetalleFacturaProveedorsWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleFacturaProveedor.class.getSimpleName()+"-saveDetalleFacturaProveedorsWithConnection");connexion.begin();			
			
			DetalleFacturaProveedorLogicAdditional.checkDetalleFacturaProveedorToSaves(detallefacturaproveedors,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowDetalleFacturaProveedors();
			
			Boolean validadoTodosDetalleFacturaProveedor=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(DetalleFacturaProveedor detallefacturaproveedorLocal:detallefacturaproveedors) {		
				if(detallefacturaproveedorLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				DetalleFacturaProveedorLogicAdditional.updateDetalleFacturaProveedorToSave(detallefacturaproveedorLocal,this.arrDatoGeneral);
	        	
				DetalleFacturaProveedorLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),detallefacturaproveedorLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarDetalleFacturaProveedor(detallefacturaproveedorLocal)) {
					DetalleFacturaProveedorDataAccess.save(detallefacturaproveedorLocal, connexion);				
				} else {
					validadoTodosDetalleFacturaProveedor=false;
				}
			}
			
			if(!validadoTodosDetalleFacturaProveedor) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			DetalleFacturaProveedorLogicAdditional.checkDetalleFacturaProveedorToSavesAfter(detallefacturaproveedors,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowDetalleFacturaProveedors();
			
			connexion.commit();		
			
			this.quitarDetalleFacturaProveedorsEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveDetalleFacturaProveedors()throws Exception {				
		 try {	
			DetalleFacturaProveedorLogicAdditional.checkDetalleFacturaProveedorToSaves(detallefacturaproveedors,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosDetalleFacturaProveedor=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(DetalleFacturaProveedor detallefacturaproveedorLocal:detallefacturaproveedors) {				
				if(detallefacturaproveedorLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				DetalleFacturaProveedorLogicAdditional.updateDetalleFacturaProveedorToSave(detallefacturaproveedorLocal,this.arrDatoGeneral);
	        	
				DetalleFacturaProveedorLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),detallefacturaproveedorLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarDetalleFacturaProveedor(detallefacturaproveedorLocal)) {				
					DetalleFacturaProveedorDataAccess.save(detallefacturaproveedorLocal, connexion);				
				} else {
					validadoTodosDetalleFacturaProveedor=false;
				}
			}
			
			if(!validadoTodosDetalleFacturaProveedor) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			DetalleFacturaProveedorLogicAdditional.checkDetalleFacturaProveedorToSavesAfter(detallefacturaproveedors,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarDetalleFacturaProveedorsEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public DetalleFacturaProveedorParameterReturnGeneral procesarAccionDetalleFacturaProveedors(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<DetalleFacturaProveedor> detallefacturaproveedors,DetalleFacturaProveedorParameterReturnGeneral detallefacturaproveedorParameterGeneral)throws Exception {
		 try {	
			DetalleFacturaProveedorParameterReturnGeneral detallefacturaproveedorReturnGeneral=new DetalleFacturaProveedorParameterReturnGeneral();
	
			DetalleFacturaProveedorLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,detallefacturaproveedors,detallefacturaproveedorParameterGeneral,detallefacturaproveedorReturnGeneral);
			
			return detallefacturaproveedorReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public DetalleFacturaProveedorParameterReturnGeneral procesarAccionDetalleFacturaProveedorsWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<DetalleFacturaProveedor> detallefacturaproveedors,DetalleFacturaProveedorParameterReturnGeneral detallefacturaproveedorParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleFacturaProveedor.class.getSimpleName()+"-procesarAccionDetalleFacturaProveedorsWithConnection");connexion.begin();			
			
			DetalleFacturaProveedorParameterReturnGeneral detallefacturaproveedorReturnGeneral=new DetalleFacturaProveedorParameterReturnGeneral();
	
			DetalleFacturaProveedorLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,detallefacturaproveedors,detallefacturaproveedorParameterGeneral,detallefacturaproveedorReturnGeneral);
			
			this.connexion.commit();
			
			return detallefacturaproveedorReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public DetalleFacturaProveedorParameterReturnGeneral procesarEventosDetalleFacturaProveedors(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<DetalleFacturaProveedor> detallefacturaproveedors,DetalleFacturaProveedor detallefacturaproveedor,DetalleFacturaProveedorParameterReturnGeneral detallefacturaproveedorParameterGeneral,Boolean isEsNuevoDetalleFacturaProveedor,ArrayList<Classe> clases)throws Exception {
		 try {	
			DetalleFacturaProveedorParameterReturnGeneral detallefacturaproveedorReturnGeneral=new DetalleFacturaProveedorParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				detallefacturaproveedorReturnGeneral.setConRecargarPropiedades(true);
			}
			
			DetalleFacturaProveedorLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,detallefacturaproveedors,detallefacturaproveedor,detallefacturaproveedorParameterGeneral,detallefacturaproveedorReturnGeneral,isEsNuevoDetalleFacturaProveedor,clases);
			
			return detallefacturaproveedorReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public DetalleFacturaProveedorParameterReturnGeneral procesarEventosDetalleFacturaProveedorsWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<DetalleFacturaProveedor> detallefacturaproveedors,DetalleFacturaProveedor detallefacturaproveedor,DetalleFacturaProveedorParameterReturnGeneral detallefacturaproveedorParameterGeneral,Boolean isEsNuevoDetalleFacturaProveedor,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleFacturaProveedor.class.getSimpleName()+"-procesarEventosDetalleFacturaProveedorsWithConnection");connexion.begin();			
			
			DetalleFacturaProveedorParameterReturnGeneral detallefacturaproveedorReturnGeneral=new DetalleFacturaProveedorParameterReturnGeneral();
	
			detallefacturaproveedorReturnGeneral.setDetalleFacturaProveedor(detallefacturaproveedor);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				detallefacturaproveedorReturnGeneral.setConRecargarPropiedades(true);
			}
			
			DetalleFacturaProveedorLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,detallefacturaproveedors,detallefacturaproveedor,detallefacturaproveedorParameterGeneral,detallefacturaproveedorReturnGeneral,isEsNuevoDetalleFacturaProveedor,clases);
			
			this.connexion.commit();
			
			return detallefacturaproveedorReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public DetalleFacturaProveedorParameterReturnGeneral procesarImportacionDetalleFacturaProveedorsWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,DetalleFacturaProveedorParameterReturnGeneral detallefacturaproveedorParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleFacturaProveedor.class.getSimpleName()+"-procesarImportacionDetalleFacturaProveedorsWithConnection");connexion.begin();			
			
			DetalleFacturaProveedorParameterReturnGeneral detallefacturaproveedorReturnGeneral=new DetalleFacturaProveedorParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.detallefacturaproveedors=new ArrayList<DetalleFacturaProveedor>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.detallefacturaproveedor=new DetalleFacturaProveedor();
				
				
				if(conColumnasBase) {this.detallefacturaproveedor.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.detallefacturaproveedor.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.detallefacturaproveedor.setnumero_comprobante(arrColumnas[iColumn++]);
				this.detallefacturaproveedor.setcantidad(Integer.parseInt(arrColumnas[iColumn++]));
				this.detallefacturaproveedor.setcantidad_auxiliar(Integer.parseInt(arrColumnas[iColumn++]));
				this.detallefacturaproveedor.setdescuento(Double.parseDouble(arrColumnas[iColumn++]));
				this.detallefacturaproveedor.setiva(Double.parseDouble(arrColumnas[iColumn++]));
				this.detallefacturaproveedor.setlote(arrColumnas[iColumn++]);
				this.detallefacturaproveedor.setfecha_elaboracion_lote(Funciones.ConvertToDate(arrColumnas[iColumn++]));
				this.detallefacturaproveedor.setfecha_caducidad_lote(Funciones.ConvertToDate(arrColumnas[iColumn++]));
				this.detallefacturaproveedor.setcosto_iva(Boolean.parseBoolean(arrColumnas[iColumn++]));
				this.detallefacturaproveedor.setcosto_unitario(Double.parseDouble(arrColumnas[iColumn++]));
				this.detallefacturaproveedor.setcosto_total(Double.parseDouble(arrColumnas[iColumn++]));
				this.detallefacturaproveedor.setice(Double.parseDouble(arrColumnas[iColumn++]));
				this.detallefacturaproveedor.setdescuento1(Double.parseDouble(arrColumnas[iColumn++]));
				this.detallefacturaproveedor.setdescuento2(Double.parseDouble(arrColumnas[iColumn++]));
				this.detallefacturaproveedor.setdescripcion(arrColumnas[iColumn++]);
				this.detallefacturaproveedor.setprecio_venta(Double.parseDouble(arrColumnas[iColumn++]));
				this.detallefacturaproveedor.setlote_cliente(arrColumnas[iColumn++]);
				this.detallefacturaproveedor.setdisponible(Double.parseDouble(arrColumnas[iColumn++]));
				this.detallefacturaproveedor.setserie(arrColumnas[iColumn++]);
				this.detallefacturaproveedor.setice_valor(Double.parseDouble(arrColumnas[iColumn++]));
				
				this.detallefacturaproveedors.add(this.detallefacturaproveedor);
			}
			
			this.saveDetalleFacturaProveedors();
			
			this.connexion.commit();
			
			detallefacturaproveedorReturnGeneral.setConRetornoEstaProcesado(true);
			detallefacturaproveedorReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return detallefacturaproveedorReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarDetalleFacturaProveedorsEliminados() throws Exception {				
		
		List<DetalleFacturaProveedor> detallefacturaproveedorsAux= new ArrayList<DetalleFacturaProveedor>();
		
		for(DetalleFacturaProveedor detallefacturaproveedor:detallefacturaproveedors) {
			if(!detallefacturaproveedor.getIsDeleted()) {
				detallefacturaproveedorsAux.add(detallefacturaproveedor);
			}
		}
		
		detallefacturaproveedors=detallefacturaproveedorsAux;
	}
	
	public void quitarDetalleFacturaProveedorsNulos() throws Exception {				
		
		List<DetalleFacturaProveedor> detallefacturaproveedorsAux= new ArrayList<DetalleFacturaProveedor>();
		
		for(DetalleFacturaProveedor detallefacturaproveedor : this.detallefacturaproveedors) {
			if(detallefacturaproveedor==null) {
				detallefacturaproveedorsAux.add(detallefacturaproveedor);
			}
		}
		
		//this.detallefacturaproveedors=detallefacturaproveedorsAux;
		
		this.detallefacturaproveedors.removeAll(detallefacturaproveedorsAux);
	}
	
	public void getSetVersionRowDetalleFacturaProveedorWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(detallefacturaproveedor.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((detallefacturaproveedor.getIsDeleted() || (detallefacturaproveedor.getIsChanged()&&!detallefacturaproveedor.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=detallefacturaproveedorDataAccess.getSetVersionRowDetalleFacturaProveedor(connexion,detallefacturaproveedor.getId());
				
				if(!detallefacturaproveedor.getVersionRow().equals(timestamp)) {	
					detallefacturaproveedor.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				detallefacturaproveedor.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowDetalleFacturaProveedor()throws Exception {	
		
		if(detallefacturaproveedor.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((detallefacturaproveedor.getIsDeleted() || (detallefacturaproveedor.getIsChanged()&&!detallefacturaproveedor.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=detallefacturaproveedorDataAccess.getSetVersionRowDetalleFacturaProveedor(connexion,detallefacturaproveedor.getId());
			
			try {							
				if(!detallefacturaproveedor.getVersionRow().equals(timestamp)) {	
					detallefacturaproveedor.setVersionRow(timestamp);
				}
				
				detallefacturaproveedor.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowDetalleFacturaProveedorsWithConnection()throws Exception {	
		if(detallefacturaproveedors!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(DetalleFacturaProveedor detallefacturaproveedorAux:detallefacturaproveedors) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(detallefacturaproveedorAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(detallefacturaproveedorAux.getIsDeleted() || (detallefacturaproveedorAux.getIsChanged()&&!detallefacturaproveedorAux.getIsNew())) {
						
						timestamp=detallefacturaproveedorDataAccess.getSetVersionRowDetalleFacturaProveedor(connexion,detallefacturaproveedorAux.getId());
						
						if(!detallefacturaproveedor.getVersionRow().equals(timestamp)) {	
							detallefacturaproveedorAux.setVersionRow(timestamp);
						}
								
						detallefacturaproveedorAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowDetalleFacturaProveedors()throws Exception {	
		if(detallefacturaproveedors!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(DetalleFacturaProveedor detallefacturaproveedorAux:detallefacturaproveedors) {
					if(detallefacturaproveedorAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(detallefacturaproveedorAux.getIsDeleted() || (detallefacturaproveedorAux.getIsChanged()&&!detallefacturaproveedorAux.getIsNew())) {
						
						timestamp=detallefacturaproveedorDataAccess.getSetVersionRowDetalleFacturaProveedor(connexion,detallefacturaproveedorAux.getId());
						
						if(!detallefacturaproveedorAux.getVersionRow().equals(timestamp)) {	
							detallefacturaproveedorAux.setVersionRow(timestamp);
						}
						
													
						detallefacturaproveedorAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public DetalleFacturaProveedorParameterReturnGeneral cargarCombosLoteForeignKeyDetalleFacturaProveedorWithConnection(String finalQueryGlobalFacturaProveedor,String finalQueryGlobalEmpresa,String finalQueryGlobalSucursal,String finalQueryGlobalBodega,String finalQueryGlobalProducto,String finalQueryGlobalUnidad,String finalQueryGlobalEjercicio,String finalQueryGlobalPeriodo,String finalQueryGlobalNovedadProducto,String finalQueryGlobalCentroCosto,String finalQueryGlobalCuentaContableCosto,String finalQueryGlobalBodegaEnviar,String finalQueryGlobalAnio,String finalQueryGlobalMes) throws Exception {
		DetalleFacturaProveedorParameterReturnGeneral  detallefacturaproveedorReturnGeneral =new DetalleFacturaProveedorParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleFacturaProveedor.class.getSimpleName()+"-cargarCombosLoteForeignKeyDetalleFacturaProveedorWithConnection");connexion.begin();
			
			detallefacturaproveedorReturnGeneral =new DetalleFacturaProveedorParameterReturnGeneral();
			
			

			List<FacturaProveedor> facturaproveedorsForeignKey=new ArrayList<FacturaProveedor>();
			FacturaProveedorLogic facturaproveedorLogic=new FacturaProveedorLogic();
			facturaproveedorLogic.setConnexion(this.connexion);
			facturaproveedorLogic.getFacturaProveedorDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalFacturaProveedor.equals("NONE")) {
				facturaproveedorLogic.getTodosFacturaProveedors(finalQueryGlobalFacturaProveedor,new Pagination());
				facturaproveedorsForeignKey=facturaproveedorLogic.getFacturaProveedors();
			}

			detallefacturaproveedorReturnGeneral.setfacturaproveedorsForeignKey(facturaproveedorsForeignKey);


			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			detallefacturaproveedorReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Sucursal> sucursalsForeignKey=new ArrayList<Sucursal>();
			SucursalLogic sucursalLogic=new SucursalLogic();
			sucursalLogic.setConnexion(this.connexion);
			//sucursalLogic.getSucursalDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalSucursal.equals("NONE")) {
				sucursalLogic.getTodosSucursals(finalQueryGlobalSucursal,new Pagination());
				sucursalsForeignKey=sucursalLogic.getSucursals();
			}

			detallefacturaproveedorReturnGeneral.setsucursalsForeignKey(sucursalsForeignKey);


			List<Bodega> bodegasForeignKey=new ArrayList<Bodega>();
			BodegaLogic bodegaLogic=new BodegaLogic();
			bodegaLogic.setConnexion(this.connexion);
			bodegaLogic.getBodegaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalBodega.equals("NONE")) {
				bodegaLogic.getTodosBodegas(finalQueryGlobalBodega,new Pagination());
				bodegasForeignKey=bodegaLogic.getBodegas();
			}

			detallefacturaproveedorReturnGeneral.setbodegasForeignKey(bodegasForeignKey);


			List<Producto> productosForeignKey=new ArrayList<Producto>();
			ProductoLogic productoLogic=new ProductoLogic();
			productoLogic.setConnexion(this.connexion);
			//productoLogic.getProductoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalProducto.equals("NONE")) {
				productoLogic.getTodosProductos(finalQueryGlobalProducto,new Pagination());
				productosForeignKey=productoLogic.getProductos();
			}

			detallefacturaproveedorReturnGeneral.setproductosForeignKey(productosForeignKey);


			List<Unidad> unidadsForeignKey=new ArrayList<Unidad>();
			UnidadLogic unidadLogic=new UnidadLogic();
			unidadLogic.setConnexion(this.connexion);
			unidadLogic.getUnidadDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalUnidad.equals("NONE")) {
				unidadLogic.getTodosUnidads(finalQueryGlobalUnidad,new Pagination());
				unidadsForeignKey=unidadLogic.getUnidads();
			}

			detallefacturaproveedorReturnGeneral.setunidadsForeignKey(unidadsForeignKey);


			List<Ejercicio> ejerciciosForeignKey=new ArrayList<Ejercicio>();
			EjercicioLogic ejercicioLogic=new EjercicioLogic();
			ejercicioLogic.setConnexion(this.connexion);
			//ejercicioLogic.getEjercicioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEjercicio.equals("NONE")) {
				ejercicioLogic.getTodosEjercicios(finalQueryGlobalEjercicio,new Pagination());
				ejerciciosForeignKey=ejercicioLogic.getEjercicios();
			}

			detallefacturaproveedorReturnGeneral.setejerciciosForeignKey(ejerciciosForeignKey);


			List<Periodo> periodosForeignKey=new ArrayList<Periodo>();
			PeriodoLogic periodoLogic=new PeriodoLogic();
			periodoLogic.setConnexion(this.connexion);
			//periodoLogic.getPeriodoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalPeriodo.equals("NONE")) {
				periodoLogic.getTodosPeriodos(finalQueryGlobalPeriodo,new Pagination());
				periodosForeignKey=periodoLogic.getPeriodos();
			}

			detallefacturaproveedorReturnGeneral.setperiodosForeignKey(periodosForeignKey);


			List<NovedadProducto> novedadproductosForeignKey=new ArrayList<NovedadProducto>();
			NovedadProductoLogic novedadproductoLogic=new NovedadProductoLogic();
			novedadproductoLogic.setConnexion(this.connexion);
			novedadproductoLogic.getNovedadProductoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalNovedadProducto.equals("NONE")) {
				novedadproductoLogic.getTodosNovedadProductos(finalQueryGlobalNovedadProducto,new Pagination());
				novedadproductosForeignKey=novedadproductoLogic.getNovedadProductos();
			}

			detallefacturaproveedorReturnGeneral.setnovedadproductosForeignKey(novedadproductosForeignKey);


			List<CentroCosto> centrocostosForeignKey=new ArrayList<CentroCosto>();
			CentroCostoLogic centrocostoLogic=new CentroCostoLogic();
			centrocostoLogic.setConnexion(this.connexion);
			centrocostoLogic.getCentroCostoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCentroCosto.equals("NONE")) {
				centrocostoLogic.getTodosCentroCostos(finalQueryGlobalCentroCosto,new Pagination());
				centrocostosForeignKey=centrocostoLogic.getCentroCostos();
			}

			detallefacturaproveedorReturnGeneral.setcentrocostosForeignKey(centrocostosForeignKey);


			List<CuentaContable> cuentacontablecostosForeignKey=new ArrayList<CuentaContable>();
			CuentaContableLogic cuentacontablecostoLogic=new CuentaContableLogic();
			cuentacontablecostoLogic.setConnexion(this.connexion);
			cuentacontablecostoLogic.getCuentaContableDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCuentaContableCosto.equals("NONE")) {
				cuentacontablecostoLogic.getTodosCuentaContables(finalQueryGlobalCuentaContableCosto,new Pagination());
				cuentacontablecostosForeignKey=cuentacontablecostoLogic.getCuentaContables();
			}

			detallefacturaproveedorReturnGeneral.setcuentacontablecostosForeignKey(cuentacontablecostosForeignKey);


			List<Bodega> bodegaenviarsForeignKey=new ArrayList<Bodega>();
			BodegaLogic bodegaenviarLogic=new BodegaLogic();
			bodegaenviarLogic.setConnexion(this.connexion);
			bodegaenviarLogic.getBodegaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalBodegaEnviar.equals("NONE")) {
				bodegaenviarLogic.getTodosBodegas(finalQueryGlobalBodegaEnviar,new Pagination());
				bodegaenviarsForeignKey=bodegaenviarLogic.getBodegas();
			}

			detallefacturaproveedorReturnGeneral.setbodegaenviarsForeignKey(bodegaenviarsForeignKey);


			List<Anio> aniosForeignKey=new ArrayList<Anio>();
			AnioLogic anioLogic=new AnioLogic();
			anioLogic.setConnexion(this.connexion);
			anioLogic.getAnioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalAnio.equals("NONE")) {
				anioLogic.getTodosAnios(finalQueryGlobalAnio,new Pagination());
				aniosForeignKey=anioLogic.getAnios();
			}

			detallefacturaproveedorReturnGeneral.setaniosForeignKey(aniosForeignKey);


			List<Mes> messForeignKey=new ArrayList<Mes>();
			MesLogic mesLogic=new MesLogic();
			mesLogic.setConnexion(this.connexion);
			mesLogic.getMesDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalMes.equals("NONE")) {
				mesLogic.getTodosMess(finalQueryGlobalMes,new Pagination());
				messForeignKey=mesLogic.getMess();
			}

			detallefacturaproveedorReturnGeneral.setmessForeignKey(messForeignKey);

			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
		
		return detallefacturaproveedorReturnGeneral;
	}
	
	public DetalleFacturaProveedorParameterReturnGeneral cargarCombosLoteForeignKeyDetalleFacturaProveedor(String finalQueryGlobalFacturaProveedor,String finalQueryGlobalEmpresa,String finalQueryGlobalSucursal,String finalQueryGlobalBodega,String finalQueryGlobalProducto,String finalQueryGlobalUnidad,String finalQueryGlobalEjercicio,String finalQueryGlobalPeriodo,String finalQueryGlobalNovedadProducto,String finalQueryGlobalCentroCosto,String finalQueryGlobalCuentaContableCosto,String finalQueryGlobalBodegaEnviar,String finalQueryGlobalAnio,String finalQueryGlobalMes) throws Exception {
		DetalleFacturaProveedorParameterReturnGeneral  detallefacturaproveedorReturnGeneral =new DetalleFacturaProveedorParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {						
			detallefacturaproveedorReturnGeneral =new DetalleFacturaProveedorParameterReturnGeneral();
			
			

			List<FacturaProveedor> facturaproveedorsForeignKey=new ArrayList<FacturaProveedor>();
			FacturaProveedorLogic facturaproveedorLogic=new FacturaProveedorLogic();
			facturaproveedorLogic.setConnexion(this.connexion);
			facturaproveedorLogic.getFacturaProveedorDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalFacturaProveedor.equals("NONE")) {
				facturaproveedorLogic.getTodosFacturaProveedors(finalQueryGlobalFacturaProveedor,new Pagination());
				facturaproveedorsForeignKey=facturaproveedorLogic.getFacturaProveedors();
			}

			detallefacturaproveedorReturnGeneral.setfacturaproveedorsForeignKey(facturaproveedorsForeignKey);


			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			detallefacturaproveedorReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Sucursal> sucursalsForeignKey=new ArrayList<Sucursal>();
			SucursalLogic sucursalLogic=new SucursalLogic();
			sucursalLogic.setConnexion(this.connexion);
			//sucursalLogic.getSucursalDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalSucursal.equals("NONE")) {
				sucursalLogic.getTodosSucursals(finalQueryGlobalSucursal,new Pagination());
				sucursalsForeignKey=sucursalLogic.getSucursals();
			}

			detallefacturaproveedorReturnGeneral.setsucursalsForeignKey(sucursalsForeignKey);


			List<Bodega> bodegasForeignKey=new ArrayList<Bodega>();
			BodegaLogic bodegaLogic=new BodegaLogic();
			bodegaLogic.setConnexion(this.connexion);
			bodegaLogic.getBodegaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalBodega.equals("NONE")) {
				bodegaLogic.getTodosBodegas(finalQueryGlobalBodega,new Pagination());
				bodegasForeignKey=bodegaLogic.getBodegas();
			}

			detallefacturaproveedorReturnGeneral.setbodegasForeignKey(bodegasForeignKey);


			List<Producto> productosForeignKey=new ArrayList<Producto>();
			ProductoLogic productoLogic=new ProductoLogic();
			productoLogic.setConnexion(this.connexion);
			//productoLogic.getProductoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalProducto.equals("NONE")) {
				productoLogic.getTodosProductos(finalQueryGlobalProducto,new Pagination());
				productosForeignKey=productoLogic.getProductos();
			}

			detallefacturaproveedorReturnGeneral.setproductosForeignKey(productosForeignKey);


			List<Unidad> unidadsForeignKey=new ArrayList<Unidad>();
			UnidadLogic unidadLogic=new UnidadLogic();
			unidadLogic.setConnexion(this.connexion);
			unidadLogic.getUnidadDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalUnidad.equals("NONE")) {
				unidadLogic.getTodosUnidads(finalQueryGlobalUnidad,new Pagination());
				unidadsForeignKey=unidadLogic.getUnidads();
			}

			detallefacturaproveedorReturnGeneral.setunidadsForeignKey(unidadsForeignKey);


			List<Ejercicio> ejerciciosForeignKey=new ArrayList<Ejercicio>();
			EjercicioLogic ejercicioLogic=new EjercicioLogic();
			ejercicioLogic.setConnexion(this.connexion);
			//ejercicioLogic.getEjercicioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEjercicio.equals("NONE")) {
				ejercicioLogic.getTodosEjercicios(finalQueryGlobalEjercicio,new Pagination());
				ejerciciosForeignKey=ejercicioLogic.getEjercicios();
			}

			detallefacturaproveedorReturnGeneral.setejerciciosForeignKey(ejerciciosForeignKey);


			List<Periodo> periodosForeignKey=new ArrayList<Periodo>();
			PeriodoLogic periodoLogic=new PeriodoLogic();
			periodoLogic.setConnexion(this.connexion);
			//periodoLogic.getPeriodoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalPeriodo.equals("NONE")) {
				periodoLogic.getTodosPeriodos(finalQueryGlobalPeriodo,new Pagination());
				periodosForeignKey=periodoLogic.getPeriodos();
			}

			detallefacturaproveedorReturnGeneral.setperiodosForeignKey(periodosForeignKey);


			List<NovedadProducto> novedadproductosForeignKey=new ArrayList<NovedadProducto>();
			NovedadProductoLogic novedadproductoLogic=new NovedadProductoLogic();
			novedadproductoLogic.setConnexion(this.connexion);
			novedadproductoLogic.getNovedadProductoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalNovedadProducto.equals("NONE")) {
				novedadproductoLogic.getTodosNovedadProductos(finalQueryGlobalNovedadProducto,new Pagination());
				novedadproductosForeignKey=novedadproductoLogic.getNovedadProductos();
			}

			detallefacturaproveedorReturnGeneral.setnovedadproductosForeignKey(novedadproductosForeignKey);


			List<CentroCosto> centrocostosForeignKey=new ArrayList<CentroCosto>();
			CentroCostoLogic centrocostoLogic=new CentroCostoLogic();
			centrocostoLogic.setConnexion(this.connexion);
			centrocostoLogic.getCentroCostoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCentroCosto.equals("NONE")) {
				centrocostoLogic.getTodosCentroCostos(finalQueryGlobalCentroCosto,new Pagination());
				centrocostosForeignKey=centrocostoLogic.getCentroCostos();
			}

			detallefacturaproveedorReturnGeneral.setcentrocostosForeignKey(centrocostosForeignKey);


			List<CuentaContable> cuentacontablecostosForeignKey=new ArrayList<CuentaContable>();
			CuentaContableLogic cuentacontablecostoLogic=new CuentaContableLogic();
			cuentacontablecostoLogic.setConnexion(this.connexion);
			cuentacontablecostoLogic.getCuentaContableDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCuentaContableCosto.equals("NONE")) {
				cuentacontablecostoLogic.getTodosCuentaContables(finalQueryGlobalCuentaContableCosto,new Pagination());
				cuentacontablecostosForeignKey=cuentacontablecostoLogic.getCuentaContables();
			}

			detallefacturaproveedorReturnGeneral.setcuentacontablecostosForeignKey(cuentacontablecostosForeignKey);


			List<Bodega> bodegaenviarsForeignKey=new ArrayList<Bodega>();
			BodegaLogic bodegaenviarLogic=new BodegaLogic();
			bodegaenviarLogic.setConnexion(this.connexion);
			bodegaenviarLogic.getBodegaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalBodegaEnviar.equals("NONE")) {
				bodegaenviarLogic.getTodosBodegas(finalQueryGlobalBodegaEnviar,new Pagination());
				bodegaenviarsForeignKey=bodegaenviarLogic.getBodegas();
			}

			detallefacturaproveedorReturnGeneral.setbodegaenviarsForeignKey(bodegaenviarsForeignKey);


			List<Anio> aniosForeignKey=new ArrayList<Anio>();
			AnioLogic anioLogic=new AnioLogic();
			anioLogic.setConnexion(this.connexion);
			anioLogic.getAnioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalAnio.equals("NONE")) {
				anioLogic.getTodosAnios(finalQueryGlobalAnio,new Pagination());
				aniosForeignKey=anioLogic.getAnios();
			}

			detallefacturaproveedorReturnGeneral.setaniosForeignKey(aniosForeignKey);


			List<Mes> messForeignKey=new ArrayList<Mes>();
			MesLogic mesLogic=new MesLogic();
			mesLogic.setConnexion(this.connexion);
			mesLogic.getMesDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalMes.equals("NONE")) {
				mesLogic.getTodosMess(finalQueryGlobalMes,new Pagination());
				messForeignKey=mesLogic.getMess();
			}

			detallefacturaproveedorReturnGeneral.setmessForeignKey(messForeignKey);
						
			
		} catch(Exception e) {			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			
		}
		
		return detallefacturaproveedorReturnGeneral;
	}
	
	
	public void deepLoad(DetalleFacturaProveedor detallefacturaproveedor,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			DetalleFacturaProveedorLogicAdditional.updateDetalleFacturaProveedorToGet(detallefacturaproveedor,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		detallefacturaproveedor.setFacturaProveedor(detallefacturaproveedorDataAccess.getFacturaProveedor(connexion,detallefacturaproveedor));
		detallefacturaproveedor.setEmpresa(detallefacturaproveedorDataAccess.getEmpresa(connexion,detallefacturaproveedor));
		detallefacturaproveedor.setSucursal(detallefacturaproveedorDataAccess.getSucursal(connexion,detallefacturaproveedor));
		detallefacturaproveedor.setBodega(detallefacturaproveedorDataAccess.getBodega(connexion,detallefacturaproveedor));
		detallefacturaproveedor.setProducto(detallefacturaproveedorDataAccess.getProducto(connexion,detallefacturaproveedor));
		detallefacturaproveedor.setUnidad(detallefacturaproveedorDataAccess.getUnidad(connexion,detallefacturaproveedor));
		detallefacturaproveedor.setEjercicio(detallefacturaproveedorDataAccess.getEjercicio(connexion,detallefacturaproveedor));
		detallefacturaproveedor.setPeriodo(detallefacturaproveedorDataAccess.getPeriodo(connexion,detallefacturaproveedor));
		detallefacturaproveedor.setNovedadProducto(detallefacturaproveedorDataAccess.getNovedadProducto(connexion,detallefacturaproveedor));
		detallefacturaproveedor.setCentroCosto(detallefacturaproveedorDataAccess.getCentroCosto(connexion,detallefacturaproveedor));
		detallefacturaproveedor.setCuentaContableCosto(detallefacturaproveedorDataAccess.getCuentaContableCosto(connexion,detallefacturaproveedor));
		detallefacturaproveedor.setBodegaEnviar(detallefacturaproveedorDataAccess.getBodegaEnviar(connexion,detallefacturaproveedor));
		detallefacturaproveedor.setAnio(detallefacturaproveedorDataAccess.getAnio(connexion,detallefacturaproveedor));
		detallefacturaproveedor.setMes(detallefacturaproveedorDataAccess.getMes(connexion,detallefacturaproveedor));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(FacturaProveedor.class)) {
				detallefacturaproveedor.setFacturaProveedor(detallefacturaproveedorDataAccess.getFacturaProveedor(connexion,detallefacturaproveedor));
				continue;
			}

			if(clas.clas.equals(Empresa.class)) {
				detallefacturaproveedor.setEmpresa(detallefacturaproveedorDataAccess.getEmpresa(connexion,detallefacturaproveedor));
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				detallefacturaproveedor.setSucursal(detallefacturaproveedorDataAccess.getSucursal(connexion,detallefacturaproveedor));
				continue;
			}

			if(clas.clas.equals(Bodega.class)) {
				detallefacturaproveedor.setBodega(detallefacturaproveedorDataAccess.getBodega(connexion,detallefacturaproveedor));
				continue;
			}

			if(clas.clas.equals(Producto.class)) {
				detallefacturaproveedor.setProducto(detallefacturaproveedorDataAccess.getProducto(connexion,detallefacturaproveedor));
				continue;
			}

			if(clas.clas.equals(Unidad.class)) {
				detallefacturaproveedor.setUnidad(detallefacturaproveedorDataAccess.getUnidad(connexion,detallefacturaproveedor));
				continue;
			}

			if(clas.clas.equals(Ejercicio.class)) {
				detallefacturaproveedor.setEjercicio(detallefacturaproveedorDataAccess.getEjercicio(connexion,detallefacturaproveedor));
				continue;
			}

			if(clas.clas.equals(Periodo.class)) {
				detallefacturaproveedor.setPeriodo(detallefacturaproveedorDataAccess.getPeriodo(connexion,detallefacturaproveedor));
				continue;
			}

			if(clas.clas.equals(NovedadProducto.class)) {
				detallefacturaproveedor.setNovedadProducto(detallefacturaproveedorDataAccess.getNovedadProducto(connexion,detallefacturaproveedor));
				continue;
			}

			if(clas.clas.equals(CentroCosto.class)) {
				detallefacturaproveedor.setCentroCosto(detallefacturaproveedorDataAccess.getCentroCosto(connexion,detallefacturaproveedor));
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				detallefacturaproveedor.setCuentaContableCosto(detallefacturaproveedorDataAccess.getCuentaContableCosto(connexion,detallefacturaproveedor));
				continue;
			}

			if(clas.clas.equals(Bodega.class)) {
				detallefacturaproveedor.setBodegaEnviar(detallefacturaproveedorDataAccess.getBodegaEnviar(connexion,detallefacturaproveedor));
				continue;
			}

			if(clas.clas.equals(Anio.class)) {
				detallefacturaproveedor.setAnio(detallefacturaproveedorDataAccess.getAnio(connexion,detallefacturaproveedor));
				continue;
			}

			if(clas.clas.equals(Mes.class)) {
				detallefacturaproveedor.setMes(detallefacturaproveedorDataAccess.getMes(connexion,detallefacturaproveedor));
				continue;
			}
		}
	}
	else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(FacturaProveedor.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detallefacturaproveedor.setFacturaProveedor(detallefacturaproveedorDataAccess.getFacturaProveedor(connexion,detallefacturaproveedor));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detallefacturaproveedor.setEmpresa(detallefacturaproveedorDataAccess.getEmpresa(connexion,detallefacturaproveedor));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detallefacturaproveedor.setSucursal(detallefacturaproveedorDataAccess.getSucursal(connexion,detallefacturaproveedor));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Bodega.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detallefacturaproveedor.setBodega(detallefacturaproveedorDataAccess.getBodega(connexion,detallefacturaproveedor));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Producto.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detallefacturaproveedor.setProducto(detallefacturaproveedorDataAccess.getProducto(connexion,detallefacturaproveedor));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Unidad.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detallefacturaproveedor.setUnidad(detallefacturaproveedorDataAccess.getUnidad(connexion,detallefacturaproveedor));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Ejercicio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detallefacturaproveedor.setEjercicio(detallefacturaproveedorDataAccess.getEjercicio(connexion,detallefacturaproveedor));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Periodo.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detallefacturaproveedor.setPeriodo(detallefacturaproveedorDataAccess.getPeriodo(connexion,detallefacturaproveedor));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(NovedadProducto.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detallefacturaproveedor.setNovedadProducto(detallefacturaproveedorDataAccess.getNovedadProducto(connexion,detallefacturaproveedor));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(CentroCosto.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detallefacturaproveedor.setCentroCosto(detallefacturaproveedorDataAccess.getCentroCosto(connexion,detallefacturaproveedor));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(CuentaContable.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detallefacturaproveedor.setCuentaContableCosto(detallefacturaproveedorDataAccess.getCuentaContableCosto(connexion,detallefacturaproveedor));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Bodega.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detallefacturaproveedor.setBodegaEnviar(detallefacturaproveedorDataAccess.getBodegaEnviar(connexion,detallefacturaproveedor));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Anio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detallefacturaproveedor.setAnio(detallefacturaproveedorDataAccess.getAnio(connexion,detallefacturaproveedor));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Mes.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detallefacturaproveedor.setMes(detallefacturaproveedorDataAccess.getMes(connexion,detallefacturaproveedor));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		detallefacturaproveedor.setFacturaProveedor(detallefacturaproveedorDataAccess.getFacturaProveedor(connexion,detallefacturaproveedor));
		FacturaProveedorLogic facturaproveedorLogic= new FacturaProveedorLogic(connexion);
		facturaproveedorLogic.deepLoad(detallefacturaproveedor.getFacturaProveedor(),isDeep,deepLoadType,clases);
				
		detallefacturaproveedor.setEmpresa(detallefacturaproveedorDataAccess.getEmpresa(connexion,detallefacturaproveedor));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(detallefacturaproveedor.getEmpresa(),isDeep,deepLoadType,clases);
				
		detallefacturaproveedor.setSucursal(detallefacturaproveedorDataAccess.getSucursal(connexion,detallefacturaproveedor));
		SucursalLogic sucursalLogic= new SucursalLogic(connexion);
		sucursalLogic.deepLoad(detallefacturaproveedor.getSucursal(),isDeep,deepLoadType,clases);
				
		detallefacturaproveedor.setBodega(detallefacturaproveedorDataAccess.getBodega(connexion,detallefacturaproveedor));
		BodegaLogic bodegaLogic= new BodegaLogic(connexion);
		bodegaLogic.deepLoad(detallefacturaproveedor.getBodega(),isDeep,deepLoadType,clases);
				
		detallefacturaproveedor.setProducto(detallefacturaproveedorDataAccess.getProducto(connexion,detallefacturaproveedor));
		ProductoLogic productoLogic= new ProductoLogic(connexion);
		productoLogic.deepLoad(detallefacturaproveedor.getProducto(),isDeep,deepLoadType,clases);
				
		detallefacturaproveedor.setUnidad(detallefacturaproveedorDataAccess.getUnidad(connexion,detallefacturaproveedor));
		UnidadLogic unidadLogic= new UnidadLogic(connexion);
		unidadLogic.deepLoad(detallefacturaproveedor.getUnidad(),isDeep,deepLoadType,clases);
				
		detallefacturaproveedor.setEjercicio(detallefacturaproveedorDataAccess.getEjercicio(connexion,detallefacturaproveedor));
		EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
		ejercicioLogic.deepLoad(detallefacturaproveedor.getEjercicio(),isDeep,deepLoadType,clases);
				
		detallefacturaproveedor.setPeriodo(detallefacturaproveedorDataAccess.getPeriodo(connexion,detallefacturaproveedor));
		PeriodoLogic periodoLogic= new PeriodoLogic(connexion);
		periodoLogic.deepLoad(detallefacturaproveedor.getPeriodo(),isDeep,deepLoadType,clases);
				
		detallefacturaproveedor.setNovedadProducto(detallefacturaproveedorDataAccess.getNovedadProducto(connexion,detallefacturaproveedor));
		NovedadProductoLogic novedadproductoLogic= new NovedadProductoLogic(connexion);
		novedadproductoLogic.deepLoad(detallefacturaproveedor.getNovedadProducto(),isDeep,deepLoadType,clases);
				
		detallefacturaproveedor.setCentroCosto(detallefacturaproveedorDataAccess.getCentroCosto(connexion,detallefacturaproveedor));
		CentroCostoLogic centrocostoLogic= new CentroCostoLogic(connexion);
		centrocostoLogic.deepLoad(detallefacturaproveedor.getCentroCosto(),isDeep,deepLoadType,clases);
				
		detallefacturaproveedor.setCuentaContableCosto(detallefacturaproveedorDataAccess.getCuentaContableCosto(connexion,detallefacturaproveedor));
		CuentaContableLogic cuentacontablecostoLogic= new CuentaContableLogic(connexion);
		cuentacontablecostoLogic.deepLoad(detallefacturaproveedor.getCuentaContableCosto(),isDeep,deepLoadType,clases);
				
		detallefacturaproveedor.setBodegaEnviar(detallefacturaproveedorDataAccess.getBodegaEnviar(connexion,detallefacturaproveedor));
		BodegaLogic bodegaenviarLogic= new BodegaLogic(connexion);
		bodegaenviarLogic.deepLoad(detallefacturaproveedor.getBodegaEnviar(),isDeep,deepLoadType,clases);
				
		detallefacturaproveedor.setAnio(detallefacturaproveedorDataAccess.getAnio(connexion,detallefacturaproveedor));
		AnioLogic anioLogic= new AnioLogic(connexion);
		anioLogic.deepLoad(detallefacturaproveedor.getAnio(),isDeep,deepLoadType,clases);
				
		detallefacturaproveedor.setMes(detallefacturaproveedorDataAccess.getMes(connexion,detallefacturaproveedor));
		MesLogic mesLogic= new MesLogic(connexion);
		mesLogic.deepLoad(detallefacturaproveedor.getMes(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(FacturaProveedor.class)) {
				detallefacturaproveedor.setFacturaProveedor(detallefacturaproveedorDataAccess.getFacturaProveedor(connexion,detallefacturaproveedor));
				FacturaProveedorLogic facturaproveedorLogic= new FacturaProveedorLogic(connexion);
				facturaproveedorLogic.deepLoad(detallefacturaproveedor.getFacturaProveedor(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Empresa.class)) {
				detallefacturaproveedor.setEmpresa(detallefacturaproveedorDataAccess.getEmpresa(connexion,detallefacturaproveedor));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(detallefacturaproveedor.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				detallefacturaproveedor.setSucursal(detallefacturaproveedorDataAccess.getSucursal(connexion,detallefacturaproveedor));
				SucursalLogic sucursalLogic= new SucursalLogic(connexion);
				sucursalLogic.deepLoad(detallefacturaproveedor.getSucursal(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Bodega.class)) {
				detallefacturaproveedor.setBodega(detallefacturaproveedorDataAccess.getBodega(connexion,detallefacturaproveedor));
				BodegaLogic bodegaLogic= new BodegaLogic(connexion);
				bodegaLogic.deepLoad(detallefacturaproveedor.getBodega(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Producto.class)) {
				detallefacturaproveedor.setProducto(detallefacturaproveedorDataAccess.getProducto(connexion,detallefacturaproveedor));
				ProductoLogic productoLogic= new ProductoLogic(connexion);
				productoLogic.deepLoad(detallefacturaproveedor.getProducto(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Unidad.class)) {
				detallefacturaproveedor.setUnidad(detallefacturaproveedorDataAccess.getUnidad(connexion,detallefacturaproveedor));
				UnidadLogic unidadLogic= new UnidadLogic(connexion);
				unidadLogic.deepLoad(detallefacturaproveedor.getUnidad(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Ejercicio.class)) {
				detallefacturaproveedor.setEjercicio(detallefacturaproveedorDataAccess.getEjercicio(connexion,detallefacturaproveedor));
				EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
				ejercicioLogic.deepLoad(detallefacturaproveedor.getEjercicio(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Periodo.class)) {
				detallefacturaproveedor.setPeriodo(detallefacturaproveedorDataAccess.getPeriodo(connexion,detallefacturaproveedor));
				PeriodoLogic periodoLogic= new PeriodoLogic(connexion);
				periodoLogic.deepLoad(detallefacturaproveedor.getPeriodo(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(NovedadProducto.class)) {
				detallefacturaproveedor.setNovedadProducto(detallefacturaproveedorDataAccess.getNovedadProducto(connexion,detallefacturaproveedor));
				NovedadProductoLogic novedadproductoLogic= new NovedadProductoLogic(connexion);
				novedadproductoLogic.deepLoad(detallefacturaproveedor.getNovedadProducto(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(CentroCosto.class)) {
				detallefacturaproveedor.setCentroCosto(detallefacturaproveedorDataAccess.getCentroCosto(connexion,detallefacturaproveedor));
				CentroCostoLogic centrocostoLogic= new CentroCostoLogic(connexion);
				centrocostoLogic.deepLoad(detallefacturaproveedor.getCentroCosto(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				detallefacturaproveedor.setCuentaContableCosto(detallefacturaproveedorDataAccess.getCuentaContableCosto(connexion,detallefacturaproveedor));
				CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
				cuentacontableLogic.deepLoad(detallefacturaproveedor.getCuentaContableCosto(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Bodega.class)) {
				detallefacturaproveedor.setBodegaEnviar(detallefacturaproveedorDataAccess.getBodegaEnviar(connexion,detallefacturaproveedor));
				BodegaLogic bodegaLogic= new BodegaLogic(connexion);
				bodegaLogic.deepLoad(detallefacturaproveedor.getBodegaEnviar(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Anio.class)) {
				detallefacturaproveedor.setAnio(detallefacturaproveedorDataAccess.getAnio(connexion,detallefacturaproveedor));
				AnioLogic anioLogic= new AnioLogic(connexion);
				anioLogic.deepLoad(detallefacturaproveedor.getAnio(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Mes.class)) {
				detallefacturaproveedor.setMes(detallefacturaproveedorDataAccess.getMes(connexion,detallefacturaproveedor));
				MesLogic mesLogic= new MesLogic(connexion);
				mesLogic.deepLoad(detallefacturaproveedor.getMes(),isDeep,deepLoadType,clases);				
				continue;
			}

		}
	}
	else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {


		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(FacturaProveedor.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detallefacturaproveedor.setFacturaProveedor(detallefacturaproveedorDataAccess.getFacturaProveedor(connexion,detallefacturaproveedor));
			FacturaProveedorLogic facturaproveedorLogic= new FacturaProveedorLogic(connexion);
			facturaproveedorLogic.deepLoad(detallefacturaproveedor.getFacturaProveedor(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detallefacturaproveedor.setEmpresa(detallefacturaproveedorDataAccess.getEmpresa(connexion,detallefacturaproveedor));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(detallefacturaproveedor.getEmpresa(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detallefacturaproveedor.setSucursal(detallefacturaproveedorDataAccess.getSucursal(connexion,detallefacturaproveedor));
			SucursalLogic sucursalLogic= new SucursalLogic(connexion);
			sucursalLogic.deepLoad(detallefacturaproveedor.getSucursal(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Bodega.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detallefacturaproveedor.setBodega(detallefacturaproveedorDataAccess.getBodega(connexion,detallefacturaproveedor));
			BodegaLogic bodegaLogic= new BodegaLogic(connexion);
			bodegaLogic.deepLoad(detallefacturaproveedor.getBodega(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Producto.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detallefacturaproveedor.setProducto(detallefacturaproveedorDataAccess.getProducto(connexion,detallefacturaproveedor));
			ProductoLogic productoLogic= new ProductoLogic(connexion);
			productoLogic.deepLoad(detallefacturaproveedor.getProducto(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Unidad.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detallefacturaproveedor.setUnidad(detallefacturaproveedorDataAccess.getUnidad(connexion,detallefacturaproveedor));
			UnidadLogic unidadLogic= new UnidadLogic(connexion);
			unidadLogic.deepLoad(detallefacturaproveedor.getUnidad(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Ejercicio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detallefacturaproveedor.setEjercicio(detallefacturaproveedorDataAccess.getEjercicio(connexion,detallefacturaproveedor));
			EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
			ejercicioLogic.deepLoad(detallefacturaproveedor.getEjercicio(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Periodo.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detallefacturaproveedor.setPeriodo(detallefacturaproveedorDataAccess.getPeriodo(connexion,detallefacturaproveedor));
			PeriodoLogic periodoLogic= new PeriodoLogic(connexion);
			periodoLogic.deepLoad(detallefacturaproveedor.getPeriodo(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(NovedadProducto.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detallefacturaproveedor.setNovedadProducto(detallefacturaproveedorDataAccess.getNovedadProducto(connexion,detallefacturaproveedor));
			NovedadProductoLogic novedadproductoLogic= new NovedadProductoLogic(connexion);
			novedadproductoLogic.deepLoad(detallefacturaproveedor.getNovedadProducto(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(CentroCosto.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detallefacturaproveedor.setCentroCosto(detallefacturaproveedorDataAccess.getCentroCosto(connexion,detallefacturaproveedor));
			CentroCostoLogic centrocostoLogic= new CentroCostoLogic(connexion);
			centrocostoLogic.deepLoad(detallefacturaproveedor.getCentroCosto(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(CuentaContable.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detallefacturaproveedor.setCuentaContableCosto(detallefacturaproveedorDataAccess.getCuentaContableCosto(connexion,detallefacturaproveedor));
			CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
			cuentacontableLogic.deepLoad(detallefacturaproveedor.getCuentaContableCosto(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Bodega.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detallefacturaproveedor.setBodegaEnviar(detallefacturaproveedorDataAccess.getBodegaEnviar(connexion,detallefacturaproveedor));
			BodegaLogic bodegaLogic= new BodegaLogic(connexion);
			bodegaLogic.deepLoad(detallefacturaproveedor.getBodegaEnviar(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Anio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detallefacturaproveedor.setAnio(detallefacturaproveedorDataAccess.getAnio(connexion,detallefacturaproveedor));
			AnioLogic anioLogic= new AnioLogic(connexion);
			anioLogic.deepLoad(detallefacturaproveedor.getAnio(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Mes.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detallefacturaproveedor.setMes(detallefacturaproveedorDataAccess.getMes(connexion,detallefacturaproveedor));
			MesLogic mesLogic= new MesLogic(connexion);
			mesLogic.deepLoad(detallefacturaproveedor.getMes(),isDeep,deepLoadType,clases);
				
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(DetalleFacturaProveedor detallefacturaproveedor,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			DetalleFacturaProveedorLogicAdditional.updateDetalleFacturaProveedorToSave(detallefacturaproveedor,this.arrDatoGeneral);
			
DetalleFacturaProveedorDataAccess.save(detallefacturaproveedor, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		FacturaProveedorDataAccess.save(detallefacturaproveedor.getFacturaProveedor(),connexion);

		EmpresaDataAccess.save(detallefacturaproveedor.getEmpresa(),connexion);

		SucursalDataAccess.save(detallefacturaproveedor.getSucursal(),connexion);

		BodegaDataAccess.save(detallefacturaproveedor.getBodega(),connexion);

		ProductoDataAccess.save(detallefacturaproveedor.getProducto(),connexion);

		UnidadDataAccess.save(detallefacturaproveedor.getUnidad(),connexion);

		EjercicioDataAccess.save(detallefacturaproveedor.getEjercicio(),connexion);

		PeriodoDataAccess.save(detallefacturaproveedor.getPeriodo(),connexion);

		NovedadProductoDataAccess.save(detallefacturaproveedor.getNovedadProducto(),connexion);

		CentroCostoDataAccess.save(detallefacturaproveedor.getCentroCosto(),connexion);

		CuentaContableDataAccess.save(detallefacturaproveedor.getCuentaContableCosto(),connexion);

		BodegaDataAccess.save(detallefacturaproveedor.getBodegaEnviar(),connexion);

		AnioDataAccess.save(detallefacturaproveedor.getAnio(),connexion);

		MesDataAccess.save(detallefacturaproveedor.getMes(),connexion);
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(FacturaProveedor.class)) {
				FacturaProveedorDataAccess.save(detallefacturaproveedor.getFacturaProveedor(),connexion);
				continue;
			}

			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(detallefacturaproveedor.getEmpresa(),connexion);
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				SucursalDataAccess.save(detallefacturaproveedor.getSucursal(),connexion);
				continue;
			}

			if(clas.clas.equals(Bodega.class)) {
				BodegaDataAccess.save(detallefacturaproveedor.getBodega(),connexion);
				continue;
			}

			if(clas.clas.equals(Producto.class)) {
				ProductoDataAccess.save(detallefacturaproveedor.getProducto(),connexion);
				continue;
			}

			if(clas.clas.equals(Unidad.class)) {
				UnidadDataAccess.save(detallefacturaproveedor.getUnidad(),connexion);
				continue;
			}

			if(clas.clas.equals(Ejercicio.class)) {
				EjercicioDataAccess.save(detallefacturaproveedor.getEjercicio(),connexion);
				continue;
			}

			if(clas.clas.equals(Periodo.class)) {
				PeriodoDataAccess.save(detallefacturaproveedor.getPeriodo(),connexion);
				continue;
			}

			if(clas.clas.equals(NovedadProducto.class)) {
				NovedadProductoDataAccess.save(detallefacturaproveedor.getNovedadProducto(),connexion);
				continue;
			}

			if(clas.clas.equals(CentroCosto.class)) {
				CentroCostoDataAccess.save(detallefacturaproveedor.getCentroCosto(),connexion);
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				CuentaContableDataAccess.save(detallefacturaproveedor.getCuentaContableCosto(),connexion);
				continue;
			}

			if(clas.clas.equals(Bodega.class)) {
				BodegaDataAccess.save(detallefacturaproveedor.getBodegaEnviar(),connexion);
				continue;
			}

			if(clas.clas.equals(Anio.class)) {
				AnioDataAccess.save(detallefacturaproveedor.getAnio(),connexion);
				continue;
			}

			if(clas.clas.equals(Mes.class)) {
				MesDataAccess.save(detallefacturaproveedor.getMes(),connexion);
				continue;
			}

		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		FacturaProveedorDataAccess.save(detallefacturaproveedor.getFacturaProveedor(),connexion);
		FacturaProveedorLogic facturaproveedorLogic= new FacturaProveedorLogic(connexion);
		facturaproveedorLogic.deepLoad(detallefacturaproveedor.getFacturaProveedor(),isDeep,deepLoadType,clases);
				

		EmpresaDataAccess.save(detallefacturaproveedor.getEmpresa(),connexion);
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(detallefacturaproveedor.getEmpresa(),isDeep,deepLoadType,clases);
				

		SucursalDataAccess.save(detallefacturaproveedor.getSucursal(),connexion);
		SucursalLogic sucursalLogic= new SucursalLogic(connexion);
		sucursalLogic.deepLoad(detallefacturaproveedor.getSucursal(),isDeep,deepLoadType,clases);
				

		BodegaDataAccess.save(detallefacturaproveedor.getBodega(),connexion);
		BodegaLogic bodegaLogic= new BodegaLogic(connexion);
		bodegaLogic.deepLoad(detallefacturaproveedor.getBodega(),isDeep,deepLoadType,clases);
				

		ProductoDataAccess.save(detallefacturaproveedor.getProducto(),connexion);
		ProductoLogic productoLogic= new ProductoLogic(connexion);
		productoLogic.deepLoad(detallefacturaproveedor.getProducto(),isDeep,deepLoadType,clases);
				

		UnidadDataAccess.save(detallefacturaproveedor.getUnidad(),connexion);
		UnidadLogic unidadLogic= new UnidadLogic(connexion);
		unidadLogic.deepLoad(detallefacturaproveedor.getUnidad(),isDeep,deepLoadType,clases);
				

		EjercicioDataAccess.save(detallefacturaproveedor.getEjercicio(),connexion);
		EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
		ejercicioLogic.deepLoad(detallefacturaproveedor.getEjercicio(),isDeep,deepLoadType,clases);
				

		PeriodoDataAccess.save(detallefacturaproveedor.getPeriodo(),connexion);
		PeriodoLogic periodoLogic= new PeriodoLogic(connexion);
		periodoLogic.deepLoad(detallefacturaproveedor.getPeriodo(),isDeep,deepLoadType,clases);
				

		NovedadProductoDataAccess.save(detallefacturaproveedor.getNovedadProducto(),connexion);
		NovedadProductoLogic novedadproductoLogic= new NovedadProductoLogic(connexion);
		novedadproductoLogic.deepLoad(detallefacturaproveedor.getNovedadProducto(),isDeep,deepLoadType,clases);
				

		CentroCostoDataAccess.save(detallefacturaproveedor.getCentroCosto(),connexion);
		CentroCostoLogic centrocostoLogic= new CentroCostoLogic(connexion);
		centrocostoLogic.deepLoad(detallefacturaproveedor.getCentroCosto(),isDeep,deepLoadType,clases);
				

		CuentaContableDataAccess.save(detallefacturaproveedor.getCuentaContableCosto(),connexion);
		CuentaContableLogic cuentacontablecostoLogic= new CuentaContableLogic(connexion);
		cuentacontablecostoLogic.deepLoad(detallefacturaproveedor.getCuentaContableCosto(),isDeep,deepLoadType,clases);
				

		BodegaDataAccess.save(detallefacturaproveedor.getBodegaEnviar(),connexion);
		BodegaLogic bodegaenviarLogic= new BodegaLogic(connexion);
		bodegaenviarLogic.deepLoad(detallefacturaproveedor.getBodegaEnviar(),isDeep,deepLoadType,clases);
				

		AnioDataAccess.save(detallefacturaproveedor.getAnio(),connexion);
		AnioLogic anioLogic= new AnioLogic(connexion);
		anioLogic.deepLoad(detallefacturaproveedor.getAnio(),isDeep,deepLoadType,clases);
				

		MesDataAccess.save(detallefacturaproveedor.getMes(),connexion);
		MesLogic mesLogic= new MesLogic(connexion);
		mesLogic.deepLoad(detallefacturaproveedor.getMes(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(FacturaProveedor.class)) {
				FacturaProveedorDataAccess.save(detallefacturaproveedor.getFacturaProveedor(),connexion);
				FacturaProveedorLogic facturaproveedorLogic= new FacturaProveedorLogic(connexion);
				facturaproveedorLogic.deepSave(detallefacturaproveedor.getFacturaProveedor(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(detallefacturaproveedor.getEmpresa(),connexion);
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepSave(detallefacturaproveedor.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				SucursalDataAccess.save(detallefacturaproveedor.getSucursal(),connexion);
				SucursalLogic sucursalLogic= new SucursalLogic(connexion);
				sucursalLogic.deepSave(detallefacturaproveedor.getSucursal(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Bodega.class)) {
				BodegaDataAccess.save(detallefacturaproveedor.getBodega(),connexion);
				BodegaLogic bodegaLogic= new BodegaLogic(connexion);
				bodegaLogic.deepSave(detallefacturaproveedor.getBodega(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Producto.class)) {
				ProductoDataAccess.save(detallefacturaproveedor.getProducto(),connexion);
				ProductoLogic productoLogic= new ProductoLogic(connexion);
				productoLogic.deepSave(detallefacturaproveedor.getProducto(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Unidad.class)) {
				UnidadDataAccess.save(detallefacturaproveedor.getUnidad(),connexion);
				UnidadLogic unidadLogic= new UnidadLogic(connexion);
				unidadLogic.deepSave(detallefacturaproveedor.getUnidad(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Ejercicio.class)) {
				EjercicioDataAccess.save(detallefacturaproveedor.getEjercicio(),connexion);
				EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
				ejercicioLogic.deepSave(detallefacturaproveedor.getEjercicio(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Periodo.class)) {
				PeriodoDataAccess.save(detallefacturaproveedor.getPeriodo(),connexion);
				PeriodoLogic periodoLogic= new PeriodoLogic(connexion);
				periodoLogic.deepSave(detallefacturaproveedor.getPeriodo(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(NovedadProducto.class)) {
				NovedadProductoDataAccess.save(detallefacturaproveedor.getNovedadProducto(),connexion);
				NovedadProductoLogic novedadproductoLogic= new NovedadProductoLogic(connexion);
				novedadproductoLogic.deepSave(detallefacturaproveedor.getNovedadProducto(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(CentroCosto.class)) {
				CentroCostoDataAccess.save(detallefacturaproveedor.getCentroCosto(),connexion);
				CentroCostoLogic centrocostoLogic= new CentroCostoLogic(connexion);
				centrocostoLogic.deepSave(detallefacturaproveedor.getCentroCosto(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				CuentaContableDataAccess.save(detallefacturaproveedor.getCuentaContableCosto(),connexion);
				CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
				cuentacontableLogic.deepSave(detallefacturaproveedor.getCuentaContableCosto(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Bodega.class)) {
				BodegaDataAccess.save(detallefacturaproveedor.getBodegaEnviar(),connexion);
				BodegaLogic bodegaLogic= new BodegaLogic(connexion);
				bodegaLogic.deepSave(detallefacturaproveedor.getBodegaEnviar(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Anio.class)) {
				AnioDataAccess.save(detallefacturaproveedor.getAnio(),connexion);
				AnioLogic anioLogic= new AnioLogic(connexion);
				anioLogic.deepSave(detallefacturaproveedor.getAnio(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Mes.class)) {
				MesDataAccess.save(detallefacturaproveedor.getMes(),connexion);
				MesLogic mesLogic= new MesLogic(connexion);
				mesLogic.deepSave(detallefacturaproveedor.getMes(),isDeep,deepLoadType,clases);				
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
			this.getNewConnexionToDeep(DetalleFacturaProveedor.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(detallefacturaproveedor,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				DetalleFacturaProveedorConstantesFunciones.refrescarForeignKeysDescripcionesDetalleFacturaProveedor(detallefacturaproveedor);
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
			this.deepLoad(this.detallefacturaproveedor,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				DetalleFacturaProveedorConstantesFunciones.refrescarForeignKeysDescripcionesDetalleFacturaProveedor(this.detallefacturaproveedor);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(DetalleFacturaProveedor.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(detallefacturaproveedors!=null) {
				for(DetalleFacturaProveedor detallefacturaproveedor:detallefacturaproveedors) {
					this.deepLoad(detallefacturaproveedor,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					DetalleFacturaProveedorConstantesFunciones.refrescarForeignKeysDescripcionesDetalleFacturaProveedor(detallefacturaproveedors);
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
			if(detallefacturaproveedors!=null) {
				for(DetalleFacturaProveedor detallefacturaproveedor:detallefacturaproveedors) {
					this.deepLoad(detallefacturaproveedor,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					DetalleFacturaProveedorConstantesFunciones.refrescarForeignKeysDescripcionesDetalleFacturaProveedor(detallefacturaproveedors);
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
			this.getNewConnexionToDeep(DetalleFacturaProveedor.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(detallefacturaproveedor,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(DetalleFacturaProveedor.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(detallefacturaproveedors!=null) {
				for(DetalleFacturaProveedor detallefacturaproveedor:detallefacturaproveedors) {
					this.deepSave(detallefacturaproveedor,isDeep,deepLoadType,clases);
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
			if(detallefacturaproveedors!=null) {
				for(DetalleFacturaProveedor detallefacturaproveedor:detallefacturaproveedors) {
					this.deepSave(detallefacturaproveedor,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getDetalleFacturaProveedorsFK_IdAnioWithConnection(String sFinalQuery,Pagination pagination,Long id_anio)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleFacturaProveedor.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidAnio= new ParameterSelectionGeneral();
			parameterSelectionGeneralidAnio.setParameterSelectionGeneralEqual(ParameterType.LONG,id_anio,DetalleFacturaProveedorConstantesFunciones.IDANIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidAnio);

			DetalleFacturaProveedorLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdAnio","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detallefacturaproveedors=detallefacturaproveedorDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleFacturaProveedorConstantesFunciones.refrescarForeignKeysDescripcionesDetalleFacturaProveedor(this.detallefacturaproveedors);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getDetalleFacturaProveedorsFK_IdAnio(String sFinalQuery,Pagination pagination,Long id_anio)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidAnio= new ParameterSelectionGeneral();
			parameterSelectionGeneralidAnio.setParameterSelectionGeneralEqual(ParameterType.LONG,id_anio,DetalleFacturaProveedorConstantesFunciones.IDANIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidAnio);

			DetalleFacturaProveedorLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdAnio","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detallefacturaproveedors=detallefacturaproveedorDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleFacturaProveedorConstantesFunciones.refrescarForeignKeysDescripcionesDetalleFacturaProveedor(this.detallefacturaproveedors);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getDetalleFacturaProveedorsFK_IdBodegaWithConnection(String sFinalQuery,Pagination pagination,Long id_bodega)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleFacturaProveedor.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidBodega= new ParameterSelectionGeneral();
			parameterSelectionGeneralidBodega.setParameterSelectionGeneralEqual(ParameterType.LONG,id_bodega,DetalleFacturaProveedorConstantesFunciones.IDBODEGA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidBodega);

			DetalleFacturaProveedorLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdBodega","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detallefacturaproveedors=detallefacturaproveedorDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleFacturaProveedorConstantesFunciones.refrescarForeignKeysDescripcionesDetalleFacturaProveedor(this.detallefacturaproveedors);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getDetalleFacturaProveedorsFK_IdBodega(String sFinalQuery,Pagination pagination,Long id_bodega)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidBodega= new ParameterSelectionGeneral();
			parameterSelectionGeneralidBodega.setParameterSelectionGeneralEqual(ParameterType.LONG,id_bodega,DetalleFacturaProveedorConstantesFunciones.IDBODEGA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidBodega);

			DetalleFacturaProveedorLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdBodega","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detallefacturaproveedors=detallefacturaproveedorDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleFacturaProveedorConstantesFunciones.refrescarForeignKeysDescripcionesDetalleFacturaProveedor(this.detallefacturaproveedors);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getDetalleFacturaProveedorsFK_IdBodegaEnviarWithConnection(String sFinalQuery,Pagination pagination,Long id_bodega_enviar)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleFacturaProveedor.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidBodegaEnviar= new ParameterSelectionGeneral();
			parameterSelectionGeneralidBodegaEnviar.setParameterSelectionGeneralEqual(ParameterType.LONG,id_bodega_enviar,DetalleFacturaProveedorConstantesFunciones.IDBODEGAENVIAR,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidBodegaEnviar);

			DetalleFacturaProveedorLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdBodegaEnviar","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detallefacturaproveedors=detallefacturaproveedorDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleFacturaProveedorConstantesFunciones.refrescarForeignKeysDescripcionesDetalleFacturaProveedor(this.detallefacturaproveedors);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getDetalleFacturaProveedorsFK_IdBodegaEnviar(String sFinalQuery,Pagination pagination,Long id_bodega_enviar)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidBodegaEnviar= new ParameterSelectionGeneral();
			parameterSelectionGeneralidBodegaEnviar.setParameterSelectionGeneralEqual(ParameterType.LONG,id_bodega_enviar,DetalleFacturaProveedorConstantesFunciones.IDBODEGAENVIAR,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidBodegaEnviar);

			DetalleFacturaProveedorLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdBodegaEnviar","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detallefacturaproveedors=detallefacturaproveedorDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleFacturaProveedorConstantesFunciones.refrescarForeignKeysDescripcionesDetalleFacturaProveedor(this.detallefacturaproveedors);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getDetalleFacturaProveedorsFK_IdCentroCostoWithConnection(String sFinalQuery,Pagination pagination,Long id_centro_costo)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleFacturaProveedor.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCentroCosto= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCentroCosto.setParameterSelectionGeneralEqual(ParameterType.LONG,id_centro_costo,DetalleFacturaProveedorConstantesFunciones.IDCENTROCOSTO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCentroCosto);

			DetalleFacturaProveedorLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCentroCosto","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detallefacturaproveedors=detallefacturaproveedorDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleFacturaProveedorConstantesFunciones.refrescarForeignKeysDescripcionesDetalleFacturaProveedor(this.detallefacturaproveedors);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getDetalleFacturaProveedorsFK_IdCentroCosto(String sFinalQuery,Pagination pagination,Long id_centro_costo)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCentroCosto= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCentroCosto.setParameterSelectionGeneralEqual(ParameterType.LONG,id_centro_costo,DetalleFacturaProveedorConstantesFunciones.IDCENTROCOSTO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCentroCosto);

			DetalleFacturaProveedorLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCentroCosto","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detallefacturaproveedors=detallefacturaproveedorDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleFacturaProveedorConstantesFunciones.refrescarForeignKeysDescripcionesDetalleFacturaProveedor(this.detallefacturaproveedors);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getDetalleFacturaProveedorsFK_IdCuentaContableCostoWithConnection(String sFinalQuery,Pagination pagination,Long id_cuenta_contable_costo)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleFacturaProveedor.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCuentaContableCosto= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCuentaContableCosto.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cuenta_contable_costo,DetalleFacturaProveedorConstantesFunciones.IDCUENTACONTABLECOSTO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCuentaContableCosto);

			DetalleFacturaProveedorLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCuentaContableCosto","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detallefacturaproveedors=detallefacturaproveedorDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleFacturaProveedorConstantesFunciones.refrescarForeignKeysDescripcionesDetalleFacturaProveedor(this.detallefacturaproveedors);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getDetalleFacturaProveedorsFK_IdCuentaContableCosto(String sFinalQuery,Pagination pagination,Long id_cuenta_contable_costo)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCuentaContableCosto= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCuentaContableCosto.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cuenta_contable_costo,DetalleFacturaProveedorConstantesFunciones.IDCUENTACONTABLECOSTO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCuentaContableCosto);

			DetalleFacturaProveedorLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCuentaContableCosto","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detallefacturaproveedors=detallefacturaproveedorDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleFacturaProveedorConstantesFunciones.refrescarForeignKeysDescripcionesDetalleFacturaProveedor(this.detallefacturaproveedors);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getDetalleFacturaProveedorsFK_IdEjercicioWithConnection(String sFinalQuery,Pagination pagination,Long id_ejercicio)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleFacturaProveedor.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEjercicio= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEjercicio.setParameterSelectionGeneralEqual(ParameterType.LONG,id_ejercicio,DetalleFacturaProveedorConstantesFunciones.IDEJERCICIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEjercicio);

			DetalleFacturaProveedorLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEjercicio","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detallefacturaproveedors=detallefacturaproveedorDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleFacturaProveedorConstantesFunciones.refrescarForeignKeysDescripcionesDetalleFacturaProveedor(this.detallefacturaproveedors);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getDetalleFacturaProveedorsFK_IdEjercicio(String sFinalQuery,Pagination pagination,Long id_ejercicio)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEjercicio= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEjercicio.setParameterSelectionGeneralEqual(ParameterType.LONG,id_ejercicio,DetalleFacturaProveedorConstantesFunciones.IDEJERCICIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEjercicio);

			DetalleFacturaProveedorLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEjercicio","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detallefacturaproveedors=detallefacturaproveedorDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleFacturaProveedorConstantesFunciones.refrescarForeignKeysDescripcionesDetalleFacturaProveedor(this.detallefacturaproveedors);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getDetalleFacturaProveedorsFK_IdEmpresaWithConnection(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleFacturaProveedor.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,DetalleFacturaProveedorConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			DetalleFacturaProveedorLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detallefacturaproveedors=detallefacturaproveedorDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleFacturaProveedorConstantesFunciones.refrescarForeignKeysDescripcionesDetalleFacturaProveedor(this.detallefacturaproveedors);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getDetalleFacturaProveedorsFK_IdEmpresa(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,DetalleFacturaProveedorConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			DetalleFacturaProveedorLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detallefacturaproveedors=detallefacturaproveedorDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleFacturaProveedorConstantesFunciones.refrescarForeignKeysDescripcionesDetalleFacturaProveedor(this.detallefacturaproveedors);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getDetalleFacturaProveedorsFK_IdFacturaProveedorWithConnection(String sFinalQuery,Pagination pagination,Long id_factura_proveedor)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleFacturaProveedor.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidFacturaProveedor= new ParameterSelectionGeneral();
			parameterSelectionGeneralidFacturaProveedor.setParameterSelectionGeneralEqual(ParameterType.LONG,id_factura_proveedor,DetalleFacturaProveedorConstantesFunciones.IDFACTURAPROVEEDOR,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidFacturaProveedor);

			DetalleFacturaProveedorLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdFacturaProveedor","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detallefacturaproveedors=detallefacturaproveedorDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleFacturaProveedorConstantesFunciones.refrescarForeignKeysDescripcionesDetalleFacturaProveedor(this.detallefacturaproveedors);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getDetalleFacturaProveedorsFK_IdFacturaProveedor(String sFinalQuery,Pagination pagination,Long id_factura_proveedor)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidFacturaProveedor= new ParameterSelectionGeneral();
			parameterSelectionGeneralidFacturaProveedor.setParameterSelectionGeneralEqual(ParameterType.LONG,id_factura_proveedor,DetalleFacturaProveedorConstantesFunciones.IDFACTURAPROVEEDOR,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidFacturaProveedor);

			DetalleFacturaProveedorLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdFacturaProveedor","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detallefacturaproveedors=detallefacturaproveedorDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleFacturaProveedorConstantesFunciones.refrescarForeignKeysDescripcionesDetalleFacturaProveedor(this.detallefacturaproveedors);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getDetalleFacturaProveedorsFK_IdMesWithConnection(String sFinalQuery,Pagination pagination,Long id_mes)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleFacturaProveedor.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidMes= new ParameterSelectionGeneral();
			parameterSelectionGeneralidMes.setParameterSelectionGeneralEqual(ParameterType.LONG,id_mes,DetalleFacturaProveedorConstantesFunciones.IDMES,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidMes);

			DetalleFacturaProveedorLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdMes","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detallefacturaproveedors=detallefacturaproveedorDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleFacturaProveedorConstantesFunciones.refrescarForeignKeysDescripcionesDetalleFacturaProveedor(this.detallefacturaproveedors);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getDetalleFacturaProveedorsFK_IdMes(String sFinalQuery,Pagination pagination,Long id_mes)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidMes= new ParameterSelectionGeneral();
			parameterSelectionGeneralidMes.setParameterSelectionGeneralEqual(ParameterType.LONG,id_mes,DetalleFacturaProveedorConstantesFunciones.IDMES,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidMes);

			DetalleFacturaProveedorLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdMes","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detallefacturaproveedors=detallefacturaproveedorDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleFacturaProveedorConstantesFunciones.refrescarForeignKeysDescripcionesDetalleFacturaProveedor(this.detallefacturaproveedors);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getDetalleFacturaProveedorsFK_IdNovedadProductoWithConnection(String sFinalQuery,Pagination pagination,Long id_novedad_producto)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleFacturaProveedor.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidNovedadProducto= new ParameterSelectionGeneral();
			parameterSelectionGeneralidNovedadProducto.setParameterSelectionGeneralEqual(ParameterType.LONG,id_novedad_producto,DetalleFacturaProveedorConstantesFunciones.IDNOVEDADPRODUCTO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidNovedadProducto);

			DetalleFacturaProveedorLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdNovedadProducto","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detallefacturaproveedors=detallefacturaproveedorDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleFacturaProveedorConstantesFunciones.refrescarForeignKeysDescripcionesDetalleFacturaProveedor(this.detallefacturaproveedors);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getDetalleFacturaProveedorsFK_IdNovedadProducto(String sFinalQuery,Pagination pagination,Long id_novedad_producto)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidNovedadProducto= new ParameterSelectionGeneral();
			parameterSelectionGeneralidNovedadProducto.setParameterSelectionGeneralEqual(ParameterType.LONG,id_novedad_producto,DetalleFacturaProveedorConstantesFunciones.IDNOVEDADPRODUCTO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidNovedadProducto);

			DetalleFacturaProveedorLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdNovedadProducto","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detallefacturaproveedors=detallefacturaproveedorDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleFacturaProveedorConstantesFunciones.refrescarForeignKeysDescripcionesDetalleFacturaProveedor(this.detallefacturaproveedors);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getDetalleFacturaProveedorsFK_IdPeriodoWithConnection(String sFinalQuery,Pagination pagination,Long id_periodo)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleFacturaProveedor.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidPeriodo= new ParameterSelectionGeneral();
			parameterSelectionGeneralidPeriodo.setParameterSelectionGeneralEqual(ParameterType.LONG,id_periodo,DetalleFacturaProveedorConstantesFunciones.IDPERIODO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidPeriodo);

			DetalleFacturaProveedorLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdPeriodo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detallefacturaproveedors=detallefacturaproveedorDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleFacturaProveedorConstantesFunciones.refrescarForeignKeysDescripcionesDetalleFacturaProveedor(this.detallefacturaproveedors);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getDetalleFacturaProveedorsFK_IdPeriodo(String sFinalQuery,Pagination pagination,Long id_periodo)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidPeriodo= new ParameterSelectionGeneral();
			parameterSelectionGeneralidPeriodo.setParameterSelectionGeneralEqual(ParameterType.LONG,id_periodo,DetalleFacturaProveedorConstantesFunciones.IDPERIODO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidPeriodo);

			DetalleFacturaProveedorLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdPeriodo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detallefacturaproveedors=detallefacturaproveedorDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleFacturaProveedorConstantesFunciones.refrescarForeignKeysDescripcionesDetalleFacturaProveedor(this.detallefacturaproveedors);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getDetalleFacturaProveedorsFK_IdProductoWithConnection(String sFinalQuery,Pagination pagination,Long id_producto)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleFacturaProveedor.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidProducto= new ParameterSelectionGeneral();
			parameterSelectionGeneralidProducto.setParameterSelectionGeneralEqual(ParameterType.LONG,id_producto,DetalleFacturaProveedorConstantesFunciones.IDPRODUCTO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidProducto);

			DetalleFacturaProveedorLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdProducto","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detallefacturaproveedors=detallefacturaproveedorDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleFacturaProveedorConstantesFunciones.refrescarForeignKeysDescripcionesDetalleFacturaProveedor(this.detallefacturaproveedors);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getDetalleFacturaProveedorsFK_IdProducto(String sFinalQuery,Pagination pagination,Long id_producto)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidProducto= new ParameterSelectionGeneral();
			parameterSelectionGeneralidProducto.setParameterSelectionGeneralEqual(ParameterType.LONG,id_producto,DetalleFacturaProveedorConstantesFunciones.IDPRODUCTO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidProducto);

			DetalleFacturaProveedorLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdProducto","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detallefacturaproveedors=detallefacturaproveedorDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleFacturaProveedorConstantesFunciones.refrescarForeignKeysDescripcionesDetalleFacturaProveedor(this.detallefacturaproveedors);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getDetalleFacturaProveedorsFK_IdSucursalWithConnection(String sFinalQuery,Pagination pagination,Long id_sucursal)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleFacturaProveedor.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidSucursal= new ParameterSelectionGeneral();
			parameterSelectionGeneralidSucursal.setParameterSelectionGeneralEqual(ParameterType.LONG,id_sucursal,DetalleFacturaProveedorConstantesFunciones.IDSUCURSAL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidSucursal);

			DetalleFacturaProveedorLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdSucursal","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detallefacturaproveedors=detallefacturaproveedorDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleFacturaProveedorConstantesFunciones.refrescarForeignKeysDescripcionesDetalleFacturaProveedor(this.detallefacturaproveedors);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getDetalleFacturaProveedorsFK_IdSucursal(String sFinalQuery,Pagination pagination,Long id_sucursal)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidSucursal= new ParameterSelectionGeneral();
			parameterSelectionGeneralidSucursal.setParameterSelectionGeneralEqual(ParameterType.LONG,id_sucursal,DetalleFacturaProveedorConstantesFunciones.IDSUCURSAL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidSucursal);

			DetalleFacturaProveedorLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdSucursal","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detallefacturaproveedors=detallefacturaproveedorDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleFacturaProveedorConstantesFunciones.refrescarForeignKeysDescripcionesDetalleFacturaProveedor(this.detallefacturaproveedors);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getDetalleFacturaProveedorsFK_IdUnidadWithConnection(String sFinalQuery,Pagination pagination,Long id_unidad)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleFacturaProveedor.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidUnidad= new ParameterSelectionGeneral();
			parameterSelectionGeneralidUnidad.setParameterSelectionGeneralEqual(ParameterType.LONG,id_unidad,DetalleFacturaProveedorConstantesFunciones.IDUNIDAD,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidUnidad);

			DetalleFacturaProveedorLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdUnidad","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detallefacturaproveedors=detallefacturaproveedorDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleFacturaProveedorConstantesFunciones.refrescarForeignKeysDescripcionesDetalleFacturaProveedor(this.detallefacturaproveedors);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getDetalleFacturaProveedorsFK_IdUnidad(String sFinalQuery,Pagination pagination,Long id_unidad)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidUnidad= new ParameterSelectionGeneral();
			parameterSelectionGeneralidUnidad.setParameterSelectionGeneralEqual(ParameterType.LONG,id_unidad,DetalleFacturaProveedorConstantesFunciones.IDUNIDAD,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidUnidad);

			DetalleFacturaProveedorLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdUnidad","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detallefacturaproveedors=detallefacturaproveedorDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleFacturaProveedorConstantesFunciones.refrescarForeignKeysDescripcionesDetalleFacturaProveedor(this.detallefacturaproveedors);
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
			if(DetalleFacturaProveedorConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,DetalleFacturaProveedorDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,DetalleFacturaProveedor detallefacturaproveedor,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(DetalleFacturaProveedorConstantesFunciones.ISCONAUDITORIA) {
				if(detallefacturaproveedor.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,DetalleFacturaProveedorDataAccess.TABLENAME, detallefacturaproveedor.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(DetalleFacturaProveedorConstantesFunciones.ISCONAUDITORIADETALLE) {
						////DetalleFacturaProveedorLogic.registrarAuditoriaDetallesDetalleFacturaProveedor(connexion,detallefacturaproveedor,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(detallefacturaproveedor.getIsDeleted()) {
					/*if(!detallefacturaproveedor.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,DetalleFacturaProveedorDataAccess.TABLENAME, detallefacturaproveedor.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////DetalleFacturaProveedorLogic.registrarAuditoriaDetallesDetalleFacturaProveedor(connexion,detallefacturaproveedor,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,DetalleFacturaProveedorDataAccess.TABLENAME, detallefacturaproveedor.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(detallefacturaproveedor.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,DetalleFacturaProveedorDataAccess.TABLENAME, detallefacturaproveedor.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(DetalleFacturaProveedorConstantesFunciones.ISCONAUDITORIADETALLE) {
						////DetalleFacturaProveedorLogic.registrarAuditoriaDetallesDetalleFacturaProveedor(connexion,detallefacturaproveedor,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesDetalleFacturaProveedor(Connexion connexion,DetalleFacturaProveedor detallefacturaproveedor)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(detallefacturaproveedor.getIsNew()||!detallefacturaproveedor.getid_factura_proveedor().equals(detallefacturaproveedor.getDetalleFacturaProveedorOriginal().getid_factura_proveedor()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detallefacturaproveedor.getDetalleFacturaProveedorOriginal().getid_factura_proveedor()!=null)
				{
					strValorActual=detallefacturaproveedor.getDetalleFacturaProveedorOriginal().getid_factura_proveedor().toString();
				}
				if(detallefacturaproveedor.getid_factura_proveedor()!=null)
				{
					strValorNuevo=detallefacturaproveedor.getid_factura_proveedor().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleFacturaProveedorConstantesFunciones.IDFACTURAPROVEEDOR,strValorActual,strValorNuevo);
			}	
			
			if(detallefacturaproveedor.getIsNew()||!detallefacturaproveedor.getid_empresa().equals(detallefacturaproveedor.getDetalleFacturaProveedorOriginal().getid_empresa()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detallefacturaproveedor.getDetalleFacturaProveedorOriginal().getid_empresa()!=null)
				{
					strValorActual=detallefacturaproveedor.getDetalleFacturaProveedorOriginal().getid_empresa().toString();
				}
				if(detallefacturaproveedor.getid_empresa()!=null)
				{
					strValorNuevo=detallefacturaproveedor.getid_empresa().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleFacturaProveedorConstantesFunciones.IDEMPRESA,strValorActual,strValorNuevo);
			}	
			
			if(detallefacturaproveedor.getIsNew()||!detallefacturaproveedor.getid_sucursal().equals(detallefacturaproveedor.getDetalleFacturaProveedorOriginal().getid_sucursal()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detallefacturaproveedor.getDetalleFacturaProveedorOriginal().getid_sucursal()!=null)
				{
					strValorActual=detallefacturaproveedor.getDetalleFacturaProveedorOriginal().getid_sucursal().toString();
				}
				if(detallefacturaproveedor.getid_sucursal()!=null)
				{
					strValorNuevo=detallefacturaproveedor.getid_sucursal().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleFacturaProveedorConstantesFunciones.IDSUCURSAL,strValorActual,strValorNuevo);
			}	
			
			if(detallefacturaproveedor.getIsNew()||!detallefacturaproveedor.getid_bodega().equals(detallefacturaproveedor.getDetalleFacturaProveedorOriginal().getid_bodega()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detallefacturaproveedor.getDetalleFacturaProveedorOriginal().getid_bodega()!=null)
				{
					strValorActual=detallefacturaproveedor.getDetalleFacturaProveedorOriginal().getid_bodega().toString();
				}
				if(detallefacturaproveedor.getid_bodega()!=null)
				{
					strValorNuevo=detallefacturaproveedor.getid_bodega().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleFacturaProveedorConstantesFunciones.IDBODEGA,strValorActual,strValorNuevo);
			}	
			
			if(detallefacturaproveedor.getIsNew()||!detallefacturaproveedor.getid_producto().equals(detallefacturaproveedor.getDetalleFacturaProveedorOriginal().getid_producto()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detallefacturaproveedor.getDetalleFacturaProveedorOriginal().getid_producto()!=null)
				{
					strValorActual=detallefacturaproveedor.getDetalleFacturaProveedorOriginal().getid_producto().toString();
				}
				if(detallefacturaproveedor.getid_producto()!=null)
				{
					strValorNuevo=detallefacturaproveedor.getid_producto().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleFacturaProveedorConstantesFunciones.IDPRODUCTO,strValorActual,strValorNuevo);
			}	
			
			if(detallefacturaproveedor.getIsNew()||!detallefacturaproveedor.getid_unidad().equals(detallefacturaproveedor.getDetalleFacturaProveedorOriginal().getid_unidad()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detallefacturaproveedor.getDetalleFacturaProveedorOriginal().getid_unidad()!=null)
				{
					strValorActual=detallefacturaproveedor.getDetalleFacturaProveedorOriginal().getid_unidad().toString();
				}
				if(detallefacturaproveedor.getid_unidad()!=null)
				{
					strValorNuevo=detallefacturaproveedor.getid_unidad().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleFacturaProveedorConstantesFunciones.IDUNIDAD,strValorActual,strValorNuevo);
			}	
			
			if(detallefacturaproveedor.getIsNew()||!detallefacturaproveedor.getid_ejercicio().equals(detallefacturaproveedor.getDetalleFacturaProveedorOriginal().getid_ejercicio()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detallefacturaproveedor.getDetalleFacturaProveedorOriginal().getid_ejercicio()!=null)
				{
					strValorActual=detallefacturaproveedor.getDetalleFacturaProveedorOriginal().getid_ejercicio().toString();
				}
				if(detallefacturaproveedor.getid_ejercicio()!=null)
				{
					strValorNuevo=detallefacturaproveedor.getid_ejercicio().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleFacturaProveedorConstantesFunciones.IDEJERCICIO,strValorActual,strValorNuevo);
			}	
			
			if(detallefacturaproveedor.getIsNew()||!detallefacturaproveedor.getid_periodo().equals(detallefacturaproveedor.getDetalleFacturaProveedorOriginal().getid_periodo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detallefacturaproveedor.getDetalleFacturaProveedorOriginal().getid_periodo()!=null)
				{
					strValorActual=detallefacturaproveedor.getDetalleFacturaProveedorOriginal().getid_periodo().toString();
				}
				if(detallefacturaproveedor.getid_periodo()!=null)
				{
					strValorNuevo=detallefacturaproveedor.getid_periodo().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleFacturaProveedorConstantesFunciones.IDPERIODO,strValorActual,strValorNuevo);
			}	
			
			if(detallefacturaproveedor.getIsNew()||!detallefacturaproveedor.getnumero_comprobante().equals(detallefacturaproveedor.getDetalleFacturaProveedorOriginal().getnumero_comprobante()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detallefacturaproveedor.getDetalleFacturaProveedorOriginal().getnumero_comprobante()!=null)
				{
					strValorActual=detallefacturaproveedor.getDetalleFacturaProveedorOriginal().getnumero_comprobante();
				}
				if(detallefacturaproveedor.getnumero_comprobante()!=null)
				{
					strValorNuevo=detallefacturaproveedor.getnumero_comprobante() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleFacturaProveedorConstantesFunciones.NUMEROCOMPROBANTE,strValorActual,strValorNuevo);
			}	
			
			if(detallefacturaproveedor.getIsNew()||!detallefacturaproveedor.getcantidad().equals(detallefacturaproveedor.getDetalleFacturaProveedorOriginal().getcantidad()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detallefacturaproveedor.getDetalleFacturaProveedorOriginal().getcantidad()!=null)
				{
					strValorActual=detallefacturaproveedor.getDetalleFacturaProveedorOriginal().getcantidad().toString();
				}
				if(detallefacturaproveedor.getcantidad()!=null)
				{
					strValorNuevo=detallefacturaproveedor.getcantidad().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleFacturaProveedorConstantesFunciones.CANTIDAD,strValorActual,strValorNuevo);
			}	
			
			if(detallefacturaproveedor.getIsNew()||!detallefacturaproveedor.getcantidad_auxiliar().equals(detallefacturaproveedor.getDetalleFacturaProveedorOriginal().getcantidad_auxiliar()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detallefacturaproveedor.getDetalleFacturaProveedorOriginal().getcantidad_auxiliar()!=null)
				{
					strValorActual=detallefacturaproveedor.getDetalleFacturaProveedorOriginal().getcantidad_auxiliar().toString();
				}
				if(detallefacturaproveedor.getcantidad_auxiliar()!=null)
				{
					strValorNuevo=detallefacturaproveedor.getcantidad_auxiliar().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleFacturaProveedorConstantesFunciones.CANTIDADAUXILIAR,strValorActual,strValorNuevo);
			}	
			
			if(detallefacturaproveedor.getIsNew()||!detallefacturaproveedor.getdescuento().equals(detallefacturaproveedor.getDetalleFacturaProveedorOriginal().getdescuento()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detallefacturaproveedor.getDetalleFacturaProveedorOriginal().getdescuento()!=null)
				{
					strValorActual=detallefacturaproveedor.getDetalleFacturaProveedorOriginal().getdescuento().toString();
				}
				if(detallefacturaproveedor.getdescuento()!=null)
				{
					strValorNuevo=detallefacturaproveedor.getdescuento().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleFacturaProveedorConstantesFunciones.DESCUENTO,strValorActual,strValorNuevo);
			}	
			
			if(detallefacturaproveedor.getIsNew()||!detallefacturaproveedor.getiva().equals(detallefacturaproveedor.getDetalleFacturaProveedorOriginal().getiva()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detallefacturaproveedor.getDetalleFacturaProveedorOriginal().getiva()!=null)
				{
					strValorActual=detallefacturaproveedor.getDetalleFacturaProveedorOriginal().getiva().toString();
				}
				if(detallefacturaproveedor.getiva()!=null)
				{
					strValorNuevo=detallefacturaproveedor.getiva().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleFacturaProveedorConstantesFunciones.IVA,strValorActual,strValorNuevo);
			}	
			
			if(detallefacturaproveedor.getIsNew()||!detallefacturaproveedor.getlote().equals(detallefacturaproveedor.getDetalleFacturaProveedorOriginal().getlote()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detallefacturaproveedor.getDetalleFacturaProveedorOriginal().getlote()!=null)
				{
					strValorActual=detallefacturaproveedor.getDetalleFacturaProveedorOriginal().getlote();
				}
				if(detallefacturaproveedor.getlote()!=null)
				{
					strValorNuevo=detallefacturaproveedor.getlote() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleFacturaProveedorConstantesFunciones.LOTE,strValorActual,strValorNuevo);
			}	
			
			if(detallefacturaproveedor.getIsNew()||!detallefacturaproveedor.getfecha_elaboracion_lote().equals(detallefacturaproveedor.getDetalleFacturaProveedorOriginal().getfecha_elaboracion_lote()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detallefacturaproveedor.getDetalleFacturaProveedorOriginal().getfecha_elaboracion_lote()!=null)
				{
					strValorActual=detallefacturaproveedor.getDetalleFacturaProveedorOriginal().getfecha_elaboracion_lote().toString();
				}
				if(detallefacturaproveedor.getfecha_elaboracion_lote()!=null)
				{
					strValorNuevo=detallefacturaproveedor.getfecha_elaboracion_lote().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleFacturaProveedorConstantesFunciones.FECHAELABORACIONLOTE,strValorActual,strValorNuevo);
			}	
			
			if(detallefacturaproveedor.getIsNew()||!detallefacturaproveedor.getfecha_caducidad_lote().equals(detallefacturaproveedor.getDetalleFacturaProveedorOriginal().getfecha_caducidad_lote()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detallefacturaproveedor.getDetalleFacturaProveedorOriginal().getfecha_caducidad_lote()!=null)
				{
					strValorActual=detallefacturaproveedor.getDetalleFacturaProveedorOriginal().getfecha_caducidad_lote().toString();
				}
				if(detallefacturaproveedor.getfecha_caducidad_lote()!=null)
				{
					strValorNuevo=detallefacturaproveedor.getfecha_caducidad_lote().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleFacturaProveedorConstantesFunciones.FECHACADUCIDADLOTE,strValorActual,strValorNuevo);
			}	
			
			if(detallefacturaproveedor.getIsNew()||!detallefacturaproveedor.getcosto_iva().equals(detallefacturaproveedor.getDetalleFacturaProveedorOriginal().getcosto_iva()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detallefacturaproveedor.getDetalleFacturaProveedorOriginal().getcosto_iva()!=null)
				{
					strValorActual=detallefacturaproveedor.getDetalleFacturaProveedorOriginal().getcosto_iva().toString();
				}
				if(detallefacturaproveedor.getcosto_iva()!=null)
				{
					strValorNuevo=detallefacturaproveedor.getcosto_iva().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleFacturaProveedorConstantesFunciones.COSTOIVA,strValorActual,strValorNuevo);
			}	
			
			if(detallefacturaproveedor.getIsNew()||!detallefacturaproveedor.getcosto_unitario().equals(detallefacturaproveedor.getDetalleFacturaProveedorOriginal().getcosto_unitario()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detallefacturaproveedor.getDetalleFacturaProveedorOriginal().getcosto_unitario()!=null)
				{
					strValorActual=detallefacturaproveedor.getDetalleFacturaProveedorOriginal().getcosto_unitario().toString();
				}
				if(detallefacturaproveedor.getcosto_unitario()!=null)
				{
					strValorNuevo=detallefacturaproveedor.getcosto_unitario().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleFacturaProveedorConstantesFunciones.COSTOUNITARIO,strValorActual,strValorNuevo);
			}	
			
			if(detallefacturaproveedor.getIsNew()||!detallefacturaproveedor.getcosto_total().equals(detallefacturaproveedor.getDetalleFacturaProveedorOriginal().getcosto_total()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detallefacturaproveedor.getDetalleFacturaProveedorOriginal().getcosto_total()!=null)
				{
					strValorActual=detallefacturaproveedor.getDetalleFacturaProveedorOriginal().getcosto_total().toString();
				}
				if(detallefacturaproveedor.getcosto_total()!=null)
				{
					strValorNuevo=detallefacturaproveedor.getcosto_total().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleFacturaProveedorConstantesFunciones.COSTOTOTAL,strValorActual,strValorNuevo);
			}	
			
			if(detallefacturaproveedor.getIsNew()||!detallefacturaproveedor.getice().equals(detallefacturaproveedor.getDetalleFacturaProveedorOriginal().getice()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detallefacturaproveedor.getDetalleFacturaProveedorOriginal().getice()!=null)
				{
					strValorActual=detallefacturaproveedor.getDetalleFacturaProveedorOriginal().getice().toString();
				}
				if(detallefacturaproveedor.getice()!=null)
				{
					strValorNuevo=detallefacturaproveedor.getice().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleFacturaProveedorConstantesFunciones.ICE,strValorActual,strValorNuevo);
			}	
			
			if(detallefacturaproveedor.getIsNew()||!detallefacturaproveedor.getdescuento1().equals(detallefacturaproveedor.getDetalleFacturaProveedorOriginal().getdescuento1()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detallefacturaproveedor.getDetalleFacturaProveedorOriginal().getdescuento1()!=null)
				{
					strValorActual=detallefacturaproveedor.getDetalleFacturaProveedorOriginal().getdescuento1().toString();
				}
				if(detallefacturaproveedor.getdescuento1()!=null)
				{
					strValorNuevo=detallefacturaproveedor.getdescuento1().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleFacturaProveedorConstantesFunciones.DESCUENTO1,strValorActual,strValorNuevo);
			}	
			
			if(detallefacturaproveedor.getIsNew()||!detallefacturaproveedor.getdescuento2().equals(detallefacturaproveedor.getDetalleFacturaProveedorOriginal().getdescuento2()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detallefacturaproveedor.getDetalleFacturaProveedorOriginal().getdescuento2()!=null)
				{
					strValorActual=detallefacturaproveedor.getDetalleFacturaProveedorOriginal().getdescuento2().toString();
				}
				if(detallefacturaproveedor.getdescuento2()!=null)
				{
					strValorNuevo=detallefacturaproveedor.getdescuento2().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleFacturaProveedorConstantesFunciones.DESCUENTO2,strValorActual,strValorNuevo);
			}	
			
			if(detallefacturaproveedor.getIsNew()||!detallefacturaproveedor.getdescripcion().equals(detallefacturaproveedor.getDetalleFacturaProveedorOriginal().getdescripcion()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detallefacturaproveedor.getDetalleFacturaProveedorOriginal().getdescripcion()!=null)
				{
					strValorActual=detallefacturaproveedor.getDetalleFacturaProveedorOriginal().getdescripcion();
				}
				if(detallefacturaproveedor.getdescripcion()!=null)
				{
					strValorNuevo=detallefacturaproveedor.getdescripcion() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleFacturaProveedorConstantesFunciones.DESCRIPCION,strValorActual,strValorNuevo);
			}	
			
			if(detallefacturaproveedor.getIsNew()||!detallefacturaproveedor.getprecio_venta().equals(detallefacturaproveedor.getDetalleFacturaProveedorOriginal().getprecio_venta()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detallefacturaproveedor.getDetalleFacturaProveedorOriginal().getprecio_venta()!=null)
				{
					strValorActual=detallefacturaproveedor.getDetalleFacturaProveedorOriginal().getprecio_venta().toString();
				}
				if(detallefacturaproveedor.getprecio_venta()!=null)
				{
					strValorNuevo=detallefacturaproveedor.getprecio_venta().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleFacturaProveedorConstantesFunciones.PRECIOVENTA,strValorActual,strValorNuevo);
			}	
			
			if(detallefacturaproveedor.getIsNew()||!detallefacturaproveedor.getid_novedad_producto().equals(detallefacturaproveedor.getDetalleFacturaProveedorOriginal().getid_novedad_producto()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detallefacturaproveedor.getDetalleFacturaProveedorOriginal().getid_novedad_producto()!=null)
				{
					strValorActual=detallefacturaproveedor.getDetalleFacturaProveedorOriginal().getid_novedad_producto().toString();
				}
				if(detallefacturaproveedor.getid_novedad_producto()!=null)
				{
					strValorNuevo=detallefacturaproveedor.getid_novedad_producto().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleFacturaProveedorConstantesFunciones.IDNOVEDADPRODUCTO,strValorActual,strValorNuevo);
			}	
			
			if(detallefacturaproveedor.getIsNew()||!detallefacturaproveedor.getid_centro_costo().equals(detallefacturaproveedor.getDetalleFacturaProveedorOriginal().getid_centro_costo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detallefacturaproveedor.getDetalleFacturaProveedorOriginal().getid_centro_costo()!=null)
				{
					strValorActual=detallefacturaproveedor.getDetalleFacturaProveedorOriginal().getid_centro_costo().toString();
				}
				if(detallefacturaproveedor.getid_centro_costo()!=null)
				{
					strValorNuevo=detallefacturaproveedor.getid_centro_costo().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleFacturaProveedorConstantesFunciones.IDCENTROCOSTO,strValorActual,strValorNuevo);
			}	
			
			if(detallefacturaproveedor.getIsNew()||!detallefacturaproveedor.getid_cuenta_contable_costo().equals(detallefacturaproveedor.getDetalleFacturaProveedorOriginal().getid_cuenta_contable_costo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detallefacturaproveedor.getDetalleFacturaProveedorOriginal().getid_cuenta_contable_costo()!=null)
				{
					strValorActual=detallefacturaproveedor.getDetalleFacturaProveedorOriginal().getid_cuenta_contable_costo().toString();
				}
				if(detallefacturaproveedor.getid_cuenta_contable_costo()!=null)
				{
					strValorNuevo=detallefacturaproveedor.getid_cuenta_contable_costo().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleFacturaProveedorConstantesFunciones.IDCUENTACONTABLECOSTO,strValorActual,strValorNuevo);
			}	
			
			if(detallefacturaproveedor.getIsNew()||!detallefacturaproveedor.getid_bodega_enviar().equals(detallefacturaproveedor.getDetalleFacturaProveedorOriginal().getid_bodega_enviar()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detallefacturaproveedor.getDetalleFacturaProveedorOriginal().getid_bodega_enviar()!=null)
				{
					strValorActual=detallefacturaproveedor.getDetalleFacturaProveedorOriginal().getid_bodega_enviar().toString();
				}
				if(detallefacturaproveedor.getid_bodega_enviar()!=null)
				{
					strValorNuevo=detallefacturaproveedor.getid_bodega_enviar().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleFacturaProveedorConstantesFunciones.IDBODEGAENVIAR,strValorActual,strValorNuevo);
			}	
			
			if(detallefacturaproveedor.getIsNew()||!detallefacturaproveedor.getlote_cliente().equals(detallefacturaproveedor.getDetalleFacturaProveedorOriginal().getlote_cliente()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detallefacturaproveedor.getDetalleFacturaProveedorOriginal().getlote_cliente()!=null)
				{
					strValorActual=detallefacturaproveedor.getDetalleFacturaProveedorOriginal().getlote_cliente();
				}
				if(detallefacturaproveedor.getlote_cliente()!=null)
				{
					strValorNuevo=detallefacturaproveedor.getlote_cliente() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleFacturaProveedorConstantesFunciones.LOTECLIENTE,strValorActual,strValorNuevo);
			}	
			
			if(detallefacturaproveedor.getIsNew()||!detallefacturaproveedor.getdisponible().equals(detallefacturaproveedor.getDetalleFacturaProveedorOriginal().getdisponible()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detallefacturaproveedor.getDetalleFacturaProveedorOriginal().getdisponible()!=null)
				{
					strValorActual=detallefacturaproveedor.getDetalleFacturaProveedorOriginal().getdisponible().toString();
				}
				if(detallefacturaproveedor.getdisponible()!=null)
				{
					strValorNuevo=detallefacturaproveedor.getdisponible().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleFacturaProveedorConstantesFunciones.DISPONIBLE,strValorActual,strValorNuevo);
			}	
			
			if(detallefacturaproveedor.getIsNew()||!detallefacturaproveedor.getserie().equals(detallefacturaproveedor.getDetalleFacturaProveedorOriginal().getserie()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detallefacturaproveedor.getDetalleFacturaProveedorOriginal().getserie()!=null)
				{
					strValorActual=detallefacturaproveedor.getDetalleFacturaProveedorOriginal().getserie();
				}
				if(detallefacturaproveedor.getserie()!=null)
				{
					strValorNuevo=detallefacturaproveedor.getserie() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleFacturaProveedorConstantesFunciones.SERIE,strValorActual,strValorNuevo);
			}	
			
			if(detallefacturaproveedor.getIsNew()||!detallefacturaproveedor.getice_valor().equals(detallefacturaproveedor.getDetalleFacturaProveedorOriginal().getice_valor()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detallefacturaproveedor.getDetalleFacturaProveedorOriginal().getice_valor()!=null)
				{
					strValorActual=detallefacturaproveedor.getDetalleFacturaProveedorOriginal().getice_valor().toString();
				}
				if(detallefacturaproveedor.getice_valor()!=null)
				{
					strValorNuevo=detallefacturaproveedor.getice_valor().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleFacturaProveedorConstantesFunciones.ICEVALOR,strValorActual,strValorNuevo);
			}	
			
			if(detallefacturaproveedor.getIsNew()||!detallefacturaproveedor.getid_anio().equals(detallefacturaproveedor.getDetalleFacturaProveedorOriginal().getid_anio()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detallefacturaproveedor.getDetalleFacturaProveedorOriginal().getid_anio()!=null)
				{
					strValorActual=detallefacturaproveedor.getDetalleFacturaProveedorOriginal().getid_anio().toString();
				}
				if(detallefacturaproveedor.getid_anio()!=null)
				{
					strValorNuevo=detallefacturaproveedor.getid_anio().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleFacturaProveedorConstantesFunciones.IDANIO,strValorActual,strValorNuevo);
			}	
			
			if(detallefacturaproveedor.getIsNew()||!detallefacturaproveedor.getid_mes().equals(detallefacturaproveedor.getDetalleFacturaProveedorOriginal().getid_mes()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detallefacturaproveedor.getDetalleFacturaProveedorOriginal().getid_mes()!=null)
				{
					strValorActual=detallefacturaproveedor.getDetalleFacturaProveedorOriginal().getid_mes().toString();
				}
				if(detallefacturaproveedor.getid_mes()!=null)
				{
					strValorNuevo=detallefacturaproveedor.getid_mes().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleFacturaProveedorConstantesFunciones.IDMES,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void saveDetalleFacturaProveedorRelacionesWithConnection(DetalleFacturaProveedor detallefacturaproveedor) throws Exception {

		if(!detallefacturaproveedor.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveDetalleFacturaProveedorRelacionesBase(detallefacturaproveedor,true);
		}
	}

	public void saveDetalleFacturaProveedorRelaciones(DetalleFacturaProveedor detallefacturaproveedor)throws Exception {

		if(!detallefacturaproveedor.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveDetalleFacturaProveedorRelacionesBase(detallefacturaproveedor,false);
		}
	}

	public void saveDetalleFacturaProveedorRelacionesBase(DetalleFacturaProveedor detallefacturaproveedor,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("DetalleFacturaProveedor-saveRelacionesWithConnection");}
	

			this.setDetalleFacturaProveedor(detallefacturaproveedor);

			if(DetalleFacturaProveedorLogicAdditional.validarSaveRelaciones(detallefacturaproveedor,this)) {

				DetalleFacturaProveedorLogicAdditional.updateRelacionesToSave(detallefacturaproveedor,this);

				if((detallefacturaproveedor.getIsNew()||detallefacturaproveedor.getIsChanged())&&!detallefacturaproveedor.getIsDeleted()) {
					this.saveDetalleFacturaProveedor();
					this.saveDetalleFacturaProveedorRelacionesDetalles();

				} else if(detallefacturaproveedor.getIsDeleted()) {
					this.saveDetalleFacturaProveedorRelacionesDetalles();
					this.saveDetalleFacturaProveedor();
				}

				DetalleFacturaProveedorLogicAdditional.updateRelacionesToSaveAfter(detallefacturaproveedor,this);

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
	
	
	private void saveDetalleFacturaProveedorRelacionesDetalles()throws Exception {
		try {
	

		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfDetalleFacturaProveedor(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=DetalleFacturaProveedorConstantesFunciones.getClassesForeignKeysOfDetalleFacturaProveedor(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfDetalleFacturaProveedor(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=DetalleFacturaProveedorConstantesFunciones.getClassesRelationshipsOfDetalleFacturaProveedor(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}
