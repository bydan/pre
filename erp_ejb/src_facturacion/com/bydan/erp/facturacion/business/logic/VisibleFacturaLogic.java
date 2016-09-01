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
import com.bydan.erp.facturacion.util.VisibleFacturaConstantesFunciones;
import com.bydan.erp.facturacion.util.VisibleFacturaParameterReturnGeneral;
//import com.bydan.erp.facturacion.util.VisibleFacturaParameterGeneral;
import com.bydan.erp.facturacion.business.entity.VisibleFactura;
import com.bydan.erp.facturacion.business.logic.VisibleFacturaLogicAdditional;
import com.bydan.erp.facturacion.business.dataaccess.*;
import com.bydan.erp.facturacion.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.logic.*;


import com.bydan.erp.seguridad.util.*;


import com.bydan.erp.seguridad.business.dataaccess.*;








@SuppressWarnings("unused")
public class VisibleFacturaLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(VisibleFacturaLogic.class);
	
	protected VisibleFacturaDataAccess visiblefacturaDataAccess; 	
	protected VisibleFactura visiblefactura;
	protected List<VisibleFactura> visiblefacturas;
	protected Object visiblefacturaObject;	
	protected List<Object> visiblefacturasObject;
	
	public static ClassValidator<VisibleFactura> visiblefacturaValidator = new ClassValidator<VisibleFactura>(VisibleFactura.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected VisibleFacturaLogicAdditional visiblefacturaLogicAdditional=null;
	
	public VisibleFacturaLogicAdditional getVisibleFacturaLogicAdditional() {
		return this.visiblefacturaLogicAdditional;
	}
	
	public void setVisibleFacturaLogicAdditional(VisibleFacturaLogicAdditional visiblefacturaLogicAdditional) {
		try {
			this.visiblefacturaLogicAdditional=visiblefacturaLogicAdditional;
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
	
	
	
	
	public  VisibleFacturaLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.visiblefacturaDataAccess = new VisibleFacturaDataAccess();
			
			this.visiblefacturas= new ArrayList<VisibleFactura>();
			this.visiblefactura= new VisibleFactura();
			
			this.visiblefacturaObject=new Object();
			this.visiblefacturasObject=new ArrayList<Object>();
				
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
			
			this.visiblefacturaDataAccess.setConnexionType(this.connexionType);
			this.visiblefacturaDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  VisibleFacturaLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.visiblefacturaDataAccess = new VisibleFacturaDataAccess();
			this.visiblefacturas= new ArrayList<VisibleFactura>();
			this.visiblefactura= new VisibleFactura();
			this.visiblefacturaObject=new Object();
			this.visiblefacturasObject=new ArrayList<Object>();
			
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
			
			this.visiblefacturaDataAccess.setConnexionType(this.connexionType);
			this.visiblefacturaDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public VisibleFactura getVisibleFactura() throws Exception {	
		VisibleFacturaLogicAdditional.checkVisibleFacturaToGet(visiblefactura,this.datosCliente,this.arrDatoGeneral);
		VisibleFacturaLogicAdditional.updateVisibleFacturaToGet(visiblefactura,this.arrDatoGeneral);
		
		return visiblefactura;
	}
		
	public void setVisibleFactura(VisibleFactura newVisibleFactura) {
		this.visiblefactura = newVisibleFactura;
	}
	
	public VisibleFacturaDataAccess getVisibleFacturaDataAccess() {
		return visiblefacturaDataAccess;
	}
	
	public void setVisibleFacturaDataAccess(VisibleFacturaDataAccess newvisiblefacturaDataAccess) {
		this.visiblefacturaDataAccess = newvisiblefacturaDataAccess;
	}
	
	public List<VisibleFactura> getVisibleFacturas() throws Exception {		
		this.quitarVisibleFacturasNulos();
		
		VisibleFacturaLogicAdditional.checkVisibleFacturaToGets(visiblefacturas,this.datosCliente,this.arrDatoGeneral);
		
		for (VisibleFactura visiblefacturaLocal: visiblefacturas ) {
			VisibleFacturaLogicAdditional.updateVisibleFacturaToGet(visiblefacturaLocal,this.arrDatoGeneral);
		}
		
		return visiblefacturas;
	}
	
	public void setVisibleFacturas(List<VisibleFactura> newVisibleFacturas) {
		this.visiblefacturas = newVisibleFacturas;
	}
	
	public Object getVisibleFacturaObject() {	
		this.visiblefacturaObject=this.visiblefacturaDataAccess.getEntityObject();
		return this.visiblefacturaObject;
	}
		
	public void setVisibleFacturaObject(Object newVisibleFacturaObject) {
		this.visiblefacturaObject = newVisibleFacturaObject;
	}
	
	public List<Object> getVisibleFacturasObject() {		
		this.visiblefacturasObject=this.visiblefacturaDataAccess.getEntitiesObject();
		return this.visiblefacturasObject;
	}
		
	public void setVisibleFacturasObject(List<Object> newVisibleFacturasObject) {
		this.visiblefacturasObject = newVisibleFacturasObject;
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
		
		if(this.visiblefacturaDataAccess!=null) {
			this.visiblefacturaDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,VisibleFactura.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			visiblefacturaDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			visiblefacturaDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		visiblefactura = new  VisibleFactura();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,VisibleFactura.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			visiblefactura=visiblefacturaDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.visiblefactura,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				VisibleFacturaConstantesFunciones.refrescarForeignKeysDescripcionesVisibleFactura(this.visiblefactura);
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
		visiblefactura = new  VisibleFactura();
		  		  
        try {
			
			visiblefactura=visiblefacturaDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.visiblefactura,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				VisibleFacturaConstantesFunciones.refrescarForeignKeysDescripcionesVisibleFactura(this.visiblefactura);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		visiblefactura = new  VisibleFactura();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,VisibleFactura.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			visiblefactura=visiblefacturaDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.visiblefactura,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				VisibleFacturaConstantesFunciones.refrescarForeignKeysDescripcionesVisibleFactura(this.visiblefactura);
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
		visiblefactura = new  VisibleFactura();
		  		  
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
		visiblefactura = new  VisibleFactura();
		  		  
        try {
			
			visiblefactura=visiblefacturaDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.visiblefactura,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				VisibleFacturaConstantesFunciones.refrescarForeignKeysDescripcionesVisibleFactura(this.visiblefactura);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		visiblefactura = new  VisibleFactura();
		  		  
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
		visiblefactura = new  VisibleFactura();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,VisibleFactura.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =visiblefacturaDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		visiblefactura = new  VisibleFactura();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=visiblefacturaDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		visiblefactura = new  VisibleFactura();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,VisibleFactura.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =visiblefacturaDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		visiblefactura = new  VisibleFactura();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=visiblefacturaDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		visiblefactura = new  VisibleFactura();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,VisibleFactura.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =visiblefacturaDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		visiblefactura = new  VisibleFactura();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=visiblefacturaDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		visiblefacturas = new  ArrayList<VisibleFactura>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,VisibleFactura.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			VisibleFacturaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			visiblefacturas=visiblefacturaDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarVisibleFactura(visiblefacturas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				VisibleFacturaConstantesFunciones.refrescarForeignKeysDescripcionesVisibleFactura(this.visiblefacturas);
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
		visiblefacturas = new  ArrayList<VisibleFactura>();
		  		  
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
		visiblefacturas = new  ArrayList<VisibleFactura>();
		  		  
        try {			
			VisibleFacturaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			visiblefacturas=visiblefacturaDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarVisibleFactura(visiblefacturas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				VisibleFacturaConstantesFunciones.refrescarForeignKeysDescripcionesVisibleFactura(this.visiblefacturas);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		visiblefacturas = new  ArrayList<VisibleFactura>();
		  		  
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
		visiblefacturas = new  ArrayList<VisibleFactura>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,VisibleFactura.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			VisibleFacturaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			visiblefacturas=visiblefacturaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarVisibleFactura(visiblefacturas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				VisibleFacturaConstantesFunciones.refrescarForeignKeysDescripcionesVisibleFactura(this.visiblefacturas);
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
		visiblefacturas = new  ArrayList<VisibleFactura>();
		  		  
        try {
			VisibleFacturaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			visiblefacturas=visiblefacturaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarVisibleFactura(visiblefacturas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				VisibleFacturaConstantesFunciones.refrescarForeignKeysDescripcionesVisibleFactura(this.visiblefacturas);
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
		visiblefacturas = new  ArrayList<VisibleFactura>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,VisibleFactura.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			VisibleFacturaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			visiblefacturas=visiblefacturaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarVisibleFactura(visiblefacturas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				VisibleFacturaConstantesFunciones.refrescarForeignKeysDescripcionesVisibleFactura(this.visiblefacturas);
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
		visiblefacturas = new  ArrayList<VisibleFactura>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			VisibleFacturaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			visiblefacturas=visiblefacturaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarVisibleFactura(visiblefacturas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				VisibleFacturaConstantesFunciones.refrescarForeignKeysDescripcionesVisibleFactura(this.visiblefacturas);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		visiblefactura = new  VisibleFactura();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,VisibleFactura.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			VisibleFacturaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			visiblefactura=visiblefacturaDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarVisibleFactura(visiblefactura);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				VisibleFacturaConstantesFunciones.refrescarForeignKeysDescripcionesVisibleFactura(this.visiblefactura);
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
		visiblefactura = new  VisibleFactura();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			VisibleFacturaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			visiblefactura=visiblefacturaDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarVisibleFactura(visiblefactura);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				VisibleFacturaConstantesFunciones.refrescarForeignKeysDescripcionesVisibleFactura(this.visiblefactura);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		visiblefacturas = new  ArrayList<VisibleFactura>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,VisibleFactura.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			VisibleFacturaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			visiblefacturas=visiblefacturaDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarVisibleFactura(visiblefacturas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				VisibleFacturaConstantesFunciones.refrescarForeignKeysDescripcionesVisibleFactura(this.visiblefacturas);
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
		visiblefacturas = new  ArrayList<VisibleFactura>();
		  		  
        try {
			VisibleFacturaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			visiblefacturas=visiblefacturaDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarVisibleFactura(visiblefacturas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				VisibleFacturaConstantesFunciones.refrescarForeignKeysDescripcionesVisibleFactura(this.visiblefacturas);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosVisibleFacturasWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		visiblefacturas = new  ArrayList<VisibleFactura>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,VisibleFactura.class.getSimpleName()+"-getTodosVisibleFacturasWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			VisibleFacturaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			visiblefacturas=visiblefacturaDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarVisibleFactura(visiblefacturas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				VisibleFacturaConstantesFunciones.refrescarForeignKeysDescripcionesVisibleFactura(this.visiblefacturas);
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
	
	public  void  getTodosVisibleFacturas(String sFinalQuery,Pagination pagination)throws Exception {
		visiblefacturas = new  ArrayList<VisibleFactura>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			VisibleFacturaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			visiblefacturas=visiblefacturaDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarVisibleFactura(visiblefacturas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				VisibleFacturaConstantesFunciones.refrescarForeignKeysDescripcionesVisibleFactura(this.visiblefacturas);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarVisibleFactura(VisibleFactura visiblefactura) throws Exception {
		Boolean estaValidado=false;
		
		if(visiblefactura.getIsNew() || visiblefactura.getIsChanged()) { 
			this.invalidValues = visiblefacturaValidator.getInvalidValues(visiblefactura);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(visiblefactura);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarVisibleFactura(List<VisibleFactura> VisibleFacturas) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(VisibleFactura visiblefacturaLocal:visiblefacturas) {				
			estaValidadoObjeto=this.validarGuardarVisibleFactura(visiblefacturaLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarVisibleFactura(List<VisibleFactura> VisibleFacturas) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarVisibleFactura(visiblefacturas)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarVisibleFactura(VisibleFactura VisibleFactura) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarVisibleFactura(visiblefactura)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(VisibleFactura visiblefactura) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+visiblefactura.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=VisibleFacturaConstantesFunciones.getVisibleFacturaLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"visiblefactura","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(VisibleFacturaConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(VisibleFacturaConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveVisibleFacturaWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,VisibleFactura.class.getSimpleName()+"-saveVisibleFacturaWithConnection");connexion.begin();			
			
			VisibleFacturaLogicAdditional.checkVisibleFacturaToSave(this.visiblefactura,this.datosCliente,connexion,this.arrDatoGeneral);
			
			VisibleFacturaLogicAdditional.updateVisibleFacturaToSave(this.visiblefactura,this.arrDatoGeneral);
			
			VisibleFacturaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.visiblefactura,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowVisibleFactura();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarVisibleFactura(this.visiblefactura)) {
				VisibleFacturaDataAccess.save(this.visiblefactura, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.visiblefactura,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			VisibleFacturaLogicAdditional.checkVisibleFacturaToSaveAfter(this.visiblefactura,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowVisibleFactura();
			
			connexion.commit();			
			
			if(this.visiblefactura.getIsDeleted()) {
				this.visiblefactura=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveVisibleFactura()throws Exception {	
		try {	
			
			VisibleFacturaLogicAdditional.checkVisibleFacturaToSave(this.visiblefactura,this.datosCliente,connexion,this.arrDatoGeneral);
			
			VisibleFacturaLogicAdditional.updateVisibleFacturaToSave(this.visiblefactura,this.arrDatoGeneral);
			
			VisibleFacturaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.visiblefactura,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarVisibleFactura(this.visiblefactura)) {			
				VisibleFacturaDataAccess.save(this.visiblefactura, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.visiblefactura,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			VisibleFacturaLogicAdditional.checkVisibleFacturaToSaveAfter(this.visiblefactura,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.visiblefactura.getIsDeleted()) {
				this.visiblefactura=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveVisibleFacturasWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,VisibleFactura.class.getSimpleName()+"-saveVisibleFacturasWithConnection");connexion.begin();			
			
			VisibleFacturaLogicAdditional.checkVisibleFacturaToSaves(visiblefacturas,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowVisibleFacturas();
			
			Boolean validadoTodosVisibleFactura=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(VisibleFactura visiblefacturaLocal:visiblefacturas) {		
				if(visiblefacturaLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				VisibleFacturaLogicAdditional.updateVisibleFacturaToSave(visiblefacturaLocal,this.arrDatoGeneral);
	        	
				VisibleFacturaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),visiblefacturaLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarVisibleFactura(visiblefacturaLocal)) {
					VisibleFacturaDataAccess.save(visiblefacturaLocal, connexion);				
				} else {
					validadoTodosVisibleFactura=false;
				}
			}
			
			if(!validadoTodosVisibleFactura) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			VisibleFacturaLogicAdditional.checkVisibleFacturaToSavesAfter(visiblefacturas,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowVisibleFacturas();
			
			connexion.commit();		
			
			this.quitarVisibleFacturasEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveVisibleFacturas()throws Exception {				
		 try {	
			VisibleFacturaLogicAdditional.checkVisibleFacturaToSaves(visiblefacturas,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosVisibleFactura=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(VisibleFactura visiblefacturaLocal:visiblefacturas) {				
				if(visiblefacturaLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				VisibleFacturaLogicAdditional.updateVisibleFacturaToSave(visiblefacturaLocal,this.arrDatoGeneral);
	        	
				VisibleFacturaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),visiblefacturaLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarVisibleFactura(visiblefacturaLocal)) {				
					VisibleFacturaDataAccess.save(visiblefacturaLocal, connexion);				
				} else {
					validadoTodosVisibleFactura=false;
				}
			}
			
			if(!validadoTodosVisibleFactura) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			VisibleFacturaLogicAdditional.checkVisibleFacturaToSavesAfter(visiblefacturas,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarVisibleFacturasEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public VisibleFacturaParameterReturnGeneral procesarAccionVisibleFacturas(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<VisibleFactura> visiblefacturas,VisibleFacturaParameterReturnGeneral visiblefacturaParameterGeneral)throws Exception {
		 try {	
			VisibleFacturaParameterReturnGeneral visiblefacturaReturnGeneral=new VisibleFacturaParameterReturnGeneral();
	
			VisibleFacturaLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,visiblefacturas,visiblefacturaParameterGeneral,visiblefacturaReturnGeneral);
			
			return visiblefacturaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public VisibleFacturaParameterReturnGeneral procesarAccionVisibleFacturasWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<VisibleFactura> visiblefacturas,VisibleFacturaParameterReturnGeneral visiblefacturaParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,VisibleFactura.class.getSimpleName()+"-procesarAccionVisibleFacturasWithConnection");connexion.begin();			
			
			VisibleFacturaParameterReturnGeneral visiblefacturaReturnGeneral=new VisibleFacturaParameterReturnGeneral();
	
			VisibleFacturaLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,visiblefacturas,visiblefacturaParameterGeneral,visiblefacturaReturnGeneral);
			
			this.connexion.commit();
			
			return visiblefacturaReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public VisibleFacturaParameterReturnGeneral procesarEventosVisibleFacturas(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<VisibleFactura> visiblefacturas,VisibleFactura visiblefactura,VisibleFacturaParameterReturnGeneral visiblefacturaParameterGeneral,Boolean isEsNuevoVisibleFactura,ArrayList<Classe> clases)throws Exception {
		 try {	
			VisibleFacturaParameterReturnGeneral visiblefacturaReturnGeneral=new VisibleFacturaParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				visiblefacturaReturnGeneral.setConRecargarPropiedades(true);
			}
			
			VisibleFacturaLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,visiblefacturas,visiblefactura,visiblefacturaParameterGeneral,visiblefacturaReturnGeneral,isEsNuevoVisibleFactura,clases);
			
			return visiblefacturaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public VisibleFacturaParameterReturnGeneral procesarEventosVisibleFacturasWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<VisibleFactura> visiblefacturas,VisibleFactura visiblefactura,VisibleFacturaParameterReturnGeneral visiblefacturaParameterGeneral,Boolean isEsNuevoVisibleFactura,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,VisibleFactura.class.getSimpleName()+"-procesarEventosVisibleFacturasWithConnection");connexion.begin();			
			
			VisibleFacturaParameterReturnGeneral visiblefacturaReturnGeneral=new VisibleFacturaParameterReturnGeneral();
	
			visiblefacturaReturnGeneral.setVisibleFactura(visiblefactura);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				visiblefacturaReturnGeneral.setConRecargarPropiedades(true);
			}
			
			VisibleFacturaLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,visiblefacturas,visiblefactura,visiblefacturaParameterGeneral,visiblefacturaReturnGeneral,isEsNuevoVisibleFactura,clases);
			
			this.connexion.commit();
			
			return visiblefacturaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public VisibleFacturaParameterReturnGeneral procesarImportacionVisibleFacturasWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,VisibleFacturaParameterReturnGeneral visiblefacturaParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,VisibleFactura.class.getSimpleName()+"-procesarImportacionVisibleFacturasWithConnection");connexion.begin();			
			
			VisibleFacturaParameterReturnGeneral visiblefacturaReturnGeneral=new VisibleFacturaParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.visiblefacturas=new ArrayList<VisibleFactura>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.visiblefactura=new VisibleFactura();
				
				
				if(conColumnasBase) {this.visiblefactura.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.visiblefactura.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.visiblefactura.setcabe_consignatario(Boolean.parseBoolean(arrColumnas[iColumn++]));
				this.visiblefactura.setcabe_tipo_tasa(Boolean.parseBoolean(arrColumnas[iColumn++]));
				this.visiblefactura.setcabe_consultor(Boolean.parseBoolean(arrColumnas[iColumn++]));
				this.visiblefactura.setcabe_ice(Boolean.parseBoolean(arrColumnas[iColumn++]));
				this.visiblefactura.setcabe_transporte(Boolean.parseBoolean(arrColumnas[iColumn++]));
				this.visiblefactura.setcabe_fue(Boolean.parseBoolean(arrColumnas[iColumn++]));
				this.visiblefactura.setcabe_orden(Boolean.parseBoolean(arrColumnas[iColumn++]));
				this.visiblefactura.setdeta_autori_precio(Boolean.parseBoolean(arrColumnas[iColumn++]));
				this.visiblefactura.setdeta_area(Boolean.parseBoolean(arrColumnas[iColumn++]));
				this.visiblefactura.setdeta_foto(Boolean.parseBoolean(arrColumnas[iColumn++]));
				
				this.visiblefacturas.add(this.visiblefactura);
			}
			
			this.saveVisibleFacturas();
			
			this.connexion.commit();
			
			visiblefacturaReturnGeneral.setConRetornoEstaProcesado(true);
			visiblefacturaReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return visiblefacturaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarVisibleFacturasEliminados() throws Exception {				
		
		List<VisibleFactura> visiblefacturasAux= new ArrayList<VisibleFactura>();
		
		for(VisibleFactura visiblefactura:visiblefacturas) {
			if(!visiblefactura.getIsDeleted()) {
				visiblefacturasAux.add(visiblefactura);
			}
		}
		
		visiblefacturas=visiblefacturasAux;
	}
	
	public void quitarVisibleFacturasNulos() throws Exception {				
		
		List<VisibleFactura> visiblefacturasAux= new ArrayList<VisibleFactura>();
		
		for(VisibleFactura visiblefactura : this.visiblefacturas) {
			if(visiblefactura==null) {
				visiblefacturasAux.add(visiblefactura);
			}
		}
		
		//this.visiblefacturas=visiblefacturasAux;
		
		this.visiblefacturas.removeAll(visiblefacturasAux);
	}
	
	public void getSetVersionRowVisibleFacturaWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(visiblefactura.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((visiblefactura.getIsDeleted() || (visiblefactura.getIsChanged()&&!visiblefactura.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=visiblefacturaDataAccess.getSetVersionRowVisibleFactura(connexion,visiblefactura.getId());
				
				if(!visiblefactura.getVersionRow().equals(timestamp)) {	
					visiblefactura.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				visiblefactura.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowVisibleFactura()throws Exception {	
		
		if(visiblefactura.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((visiblefactura.getIsDeleted() || (visiblefactura.getIsChanged()&&!visiblefactura.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=visiblefacturaDataAccess.getSetVersionRowVisibleFactura(connexion,visiblefactura.getId());
			
			try {							
				if(!visiblefactura.getVersionRow().equals(timestamp)) {	
					visiblefactura.setVersionRow(timestamp);
				}
				
				visiblefactura.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowVisibleFacturasWithConnection()throws Exception {	
		if(visiblefacturas!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(VisibleFactura visiblefacturaAux:visiblefacturas) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(visiblefacturaAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(visiblefacturaAux.getIsDeleted() || (visiblefacturaAux.getIsChanged()&&!visiblefacturaAux.getIsNew())) {
						
						timestamp=visiblefacturaDataAccess.getSetVersionRowVisibleFactura(connexion,visiblefacturaAux.getId());
						
						if(!visiblefactura.getVersionRow().equals(timestamp)) {	
							visiblefacturaAux.setVersionRow(timestamp);
						}
								
						visiblefacturaAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowVisibleFacturas()throws Exception {	
		if(visiblefacturas!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(VisibleFactura visiblefacturaAux:visiblefacturas) {
					if(visiblefacturaAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(visiblefacturaAux.getIsDeleted() || (visiblefacturaAux.getIsChanged()&&!visiblefacturaAux.getIsNew())) {
						
						timestamp=visiblefacturaDataAccess.getSetVersionRowVisibleFactura(connexion,visiblefacturaAux.getId());
						
						if(!visiblefacturaAux.getVersionRow().equals(timestamp)) {	
							visiblefacturaAux.setVersionRow(timestamp);
						}
						
													
						visiblefacturaAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public VisibleFacturaParameterReturnGeneral cargarCombosLoteForeignKeyVisibleFacturaWithConnection(String finalQueryGlobalEmpresa) throws Exception {
		VisibleFacturaParameterReturnGeneral  visiblefacturaReturnGeneral =new VisibleFacturaParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,VisibleFactura.class.getSimpleName()+"-cargarCombosLoteForeignKeyVisibleFacturaWithConnection");connexion.begin();
			
			visiblefacturaReturnGeneral =new VisibleFacturaParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			visiblefacturaReturnGeneral.setempresasForeignKey(empresasForeignKey);

			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
		
		return visiblefacturaReturnGeneral;
	}
	
	public VisibleFacturaParameterReturnGeneral cargarCombosLoteForeignKeyVisibleFactura(String finalQueryGlobalEmpresa) throws Exception {
		VisibleFacturaParameterReturnGeneral  visiblefacturaReturnGeneral =new VisibleFacturaParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {						
			visiblefacturaReturnGeneral =new VisibleFacturaParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			visiblefacturaReturnGeneral.setempresasForeignKey(empresasForeignKey);
						
			
		} catch(Exception e) {			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			
		}
		
		return visiblefacturaReturnGeneral;
	}
	
	
	public void deepLoad(VisibleFactura visiblefactura,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			VisibleFacturaLogicAdditional.updateVisibleFacturaToGet(visiblefactura,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		visiblefactura.setEmpresa(visiblefacturaDataAccess.getEmpresa(connexion,visiblefactura));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				visiblefactura.setEmpresa(visiblefacturaDataAccess.getEmpresa(connexion,visiblefactura));
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
			visiblefactura.setEmpresa(visiblefacturaDataAccess.getEmpresa(connexion,visiblefactura));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		visiblefactura.setEmpresa(visiblefacturaDataAccess.getEmpresa(connexion,visiblefactura));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(visiblefactura.getEmpresa(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				visiblefactura.setEmpresa(visiblefacturaDataAccess.getEmpresa(connexion,visiblefactura));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(visiblefactura.getEmpresa(),isDeep,deepLoadType,clases);				
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
			visiblefactura.setEmpresa(visiblefacturaDataAccess.getEmpresa(connexion,visiblefactura));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(visiblefactura.getEmpresa(),isDeep,deepLoadType,clases);
				
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(VisibleFactura visiblefactura,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			VisibleFacturaLogicAdditional.updateVisibleFacturaToSave(visiblefactura,this.arrDatoGeneral);
			
VisibleFacturaDataAccess.save(visiblefactura, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(visiblefactura.getEmpresa(),connexion);
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(visiblefactura.getEmpresa(),connexion);
				continue;
			}

		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(visiblefactura.getEmpresa(),connexion);
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(visiblefactura.getEmpresa(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(visiblefactura.getEmpresa(),connexion);
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepSave(visiblefactura.getEmpresa(),isDeep,deepLoadType,clases);				
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
			this.getNewConnexionToDeep(VisibleFactura.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(visiblefactura,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				VisibleFacturaConstantesFunciones.refrescarForeignKeysDescripcionesVisibleFactura(visiblefactura);
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
			this.deepLoad(this.visiblefactura,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				VisibleFacturaConstantesFunciones.refrescarForeignKeysDescripcionesVisibleFactura(this.visiblefactura);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(VisibleFactura.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(visiblefacturas!=null) {
				for(VisibleFactura visiblefactura:visiblefacturas) {
					this.deepLoad(visiblefactura,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					VisibleFacturaConstantesFunciones.refrescarForeignKeysDescripcionesVisibleFactura(visiblefacturas);
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
			if(visiblefacturas!=null) {
				for(VisibleFactura visiblefactura:visiblefacturas) {
					this.deepLoad(visiblefactura,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					VisibleFacturaConstantesFunciones.refrescarForeignKeysDescripcionesVisibleFactura(visiblefacturas);
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
			this.getNewConnexionToDeep(VisibleFactura.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(visiblefactura,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(VisibleFactura.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(visiblefacturas!=null) {
				for(VisibleFactura visiblefactura:visiblefacturas) {
					this.deepSave(visiblefactura,isDeep,deepLoadType,clases);
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
			if(visiblefacturas!=null) {
				for(VisibleFactura visiblefactura:visiblefacturas) {
					this.deepSave(visiblefactura,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getVisibleFacturasFK_IdEmpresaWithConnection(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,VisibleFactura.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,VisibleFacturaConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			VisibleFacturaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			visiblefacturas=visiblefacturaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				VisibleFacturaConstantesFunciones.refrescarForeignKeysDescripcionesVisibleFactura(this.visiblefacturas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getVisibleFacturasFK_IdEmpresa(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,VisibleFacturaConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			VisibleFacturaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			visiblefacturas=visiblefacturaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				VisibleFacturaConstantesFunciones.refrescarForeignKeysDescripcionesVisibleFactura(this.visiblefacturas);
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
			if(VisibleFacturaConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,VisibleFacturaDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,VisibleFactura visiblefactura,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(VisibleFacturaConstantesFunciones.ISCONAUDITORIA) {
				if(visiblefactura.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,VisibleFacturaDataAccess.TABLENAME, visiblefactura.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(VisibleFacturaConstantesFunciones.ISCONAUDITORIADETALLE) {
						////VisibleFacturaLogic.registrarAuditoriaDetallesVisibleFactura(connexion,visiblefactura,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(visiblefactura.getIsDeleted()) {
					/*if(!visiblefactura.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,VisibleFacturaDataAccess.TABLENAME, visiblefactura.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////VisibleFacturaLogic.registrarAuditoriaDetallesVisibleFactura(connexion,visiblefactura,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,VisibleFacturaDataAccess.TABLENAME, visiblefactura.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(visiblefactura.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,VisibleFacturaDataAccess.TABLENAME, visiblefactura.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(VisibleFacturaConstantesFunciones.ISCONAUDITORIADETALLE) {
						////VisibleFacturaLogic.registrarAuditoriaDetallesVisibleFactura(connexion,visiblefactura,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesVisibleFactura(Connexion connexion,VisibleFactura visiblefactura)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(visiblefactura.getIsNew()||!visiblefactura.getid_empresa().equals(visiblefactura.getVisibleFacturaOriginal().getid_empresa()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(visiblefactura.getVisibleFacturaOriginal().getid_empresa()!=null)
				{
					strValorActual=visiblefactura.getVisibleFacturaOriginal().getid_empresa().toString();
				}
				if(visiblefactura.getid_empresa()!=null)
				{
					strValorNuevo=visiblefactura.getid_empresa().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),VisibleFacturaConstantesFunciones.IDEMPRESA,strValorActual,strValorNuevo);
			}	
			
			if(visiblefactura.getIsNew()||!visiblefactura.getcabe_consignatario().equals(visiblefactura.getVisibleFacturaOriginal().getcabe_consignatario()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(visiblefactura.getVisibleFacturaOriginal().getcabe_consignatario()!=null)
				{
					strValorActual=visiblefactura.getVisibleFacturaOriginal().getcabe_consignatario().toString();
				}
				if(visiblefactura.getcabe_consignatario()!=null)
				{
					strValorNuevo=visiblefactura.getcabe_consignatario().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),VisibleFacturaConstantesFunciones.CABECONSIGNATARIO,strValorActual,strValorNuevo);
			}	
			
			if(visiblefactura.getIsNew()||!visiblefactura.getcabe_tipo_tasa().equals(visiblefactura.getVisibleFacturaOriginal().getcabe_tipo_tasa()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(visiblefactura.getVisibleFacturaOriginal().getcabe_tipo_tasa()!=null)
				{
					strValorActual=visiblefactura.getVisibleFacturaOriginal().getcabe_tipo_tasa().toString();
				}
				if(visiblefactura.getcabe_tipo_tasa()!=null)
				{
					strValorNuevo=visiblefactura.getcabe_tipo_tasa().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),VisibleFacturaConstantesFunciones.CABETIPOTASA,strValorActual,strValorNuevo);
			}	
			
			if(visiblefactura.getIsNew()||!visiblefactura.getcabe_consultor().equals(visiblefactura.getVisibleFacturaOriginal().getcabe_consultor()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(visiblefactura.getVisibleFacturaOriginal().getcabe_consultor()!=null)
				{
					strValorActual=visiblefactura.getVisibleFacturaOriginal().getcabe_consultor().toString();
				}
				if(visiblefactura.getcabe_consultor()!=null)
				{
					strValorNuevo=visiblefactura.getcabe_consultor().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),VisibleFacturaConstantesFunciones.CABECONSULTOR,strValorActual,strValorNuevo);
			}	
			
			if(visiblefactura.getIsNew()||!visiblefactura.getcabe_ice().equals(visiblefactura.getVisibleFacturaOriginal().getcabe_ice()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(visiblefactura.getVisibleFacturaOriginal().getcabe_ice()!=null)
				{
					strValorActual=visiblefactura.getVisibleFacturaOriginal().getcabe_ice().toString();
				}
				if(visiblefactura.getcabe_ice()!=null)
				{
					strValorNuevo=visiblefactura.getcabe_ice().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),VisibleFacturaConstantesFunciones.CABEICE,strValorActual,strValorNuevo);
			}	
			
			if(visiblefactura.getIsNew()||!visiblefactura.getcabe_transporte().equals(visiblefactura.getVisibleFacturaOriginal().getcabe_transporte()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(visiblefactura.getVisibleFacturaOriginal().getcabe_transporte()!=null)
				{
					strValorActual=visiblefactura.getVisibleFacturaOriginal().getcabe_transporte().toString();
				}
				if(visiblefactura.getcabe_transporte()!=null)
				{
					strValorNuevo=visiblefactura.getcabe_transporte().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),VisibleFacturaConstantesFunciones.CABETRANSPORTE,strValorActual,strValorNuevo);
			}	
			
			if(visiblefactura.getIsNew()||!visiblefactura.getcabe_fue().equals(visiblefactura.getVisibleFacturaOriginal().getcabe_fue()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(visiblefactura.getVisibleFacturaOriginal().getcabe_fue()!=null)
				{
					strValorActual=visiblefactura.getVisibleFacturaOriginal().getcabe_fue().toString();
				}
				if(visiblefactura.getcabe_fue()!=null)
				{
					strValorNuevo=visiblefactura.getcabe_fue().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),VisibleFacturaConstantesFunciones.CABEFUE,strValorActual,strValorNuevo);
			}	
			
			if(visiblefactura.getIsNew()||!visiblefactura.getcabe_orden().equals(visiblefactura.getVisibleFacturaOriginal().getcabe_orden()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(visiblefactura.getVisibleFacturaOriginal().getcabe_orden()!=null)
				{
					strValorActual=visiblefactura.getVisibleFacturaOriginal().getcabe_orden().toString();
				}
				if(visiblefactura.getcabe_orden()!=null)
				{
					strValorNuevo=visiblefactura.getcabe_orden().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),VisibleFacturaConstantesFunciones.CABEORDEN,strValorActual,strValorNuevo);
			}	
			
			if(visiblefactura.getIsNew()||!visiblefactura.getdeta_autori_precio().equals(visiblefactura.getVisibleFacturaOriginal().getdeta_autori_precio()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(visiblefactura.getVisibleFacturaOriginal().getdeta_autori_precio()!=null)
				{
					strValorActual=visiblefactura.getVisibleFacturaOriginal().getdeta_autori_precio().toString();
				}
				if(visiblefactura.getdeta_autori_precio()!=null)
				{
					strValorNuevo=visiblefactura.getdeta_autori_precio().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),VisibleFacturaConstantesFunciones.DETAAUTORIPRECIO,strValorActual,strValorNuevo);
			}	
			
			if(visiblefactura.getIsNew()||!visiblefactura.getdeta_area().equals(visiblefactura.getVisibleFacturaOriginal().getdeta_area()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(visiblefactura.getVisibleFacturaOriginal().getdeta_area()!=null)
				{
					strValorActual=visiblefactura.getVisibleFacturaOriginal().getdeta_area().toString();
				}
				if(visiblefactura.getdeta_area()!=null)
				{
					strValorNuevo=visiblefactura.getdeta_area().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),VisibleFacturaConstantesFunciones.DETAAREA,strValorActual,strValorNuevo);
			}	
			
			if(visiblefactura.getIsNew()||!visiblefactura.getdeta_foto().equals(visiblefactura.getVisibleFacturaOriginal().getdeta_foto()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(visiblefactura.getVisibleFacturaOriginal().getdeta_foto()!=null)
				{
					strValorActual=visiblefactura.getVisibleFacturaOriginal().getdeta_foto().toString();
				}
				if(visiblefactura.getdeta_foto()!=null)
				{
					strValorNuevo=visiblefactura.getdeta_foto().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),VisibleFacturaConstantesFunciones.DETAFOTO,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void saveVisibleFacturaRelacionesWithConnection(VisibleFactura visiblefactura) throws Exception {

		if(!visiblefactura.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveVisibleFacturaRelacionesBase(visiblefactura,true);
		}
	}

	public void saveVisibleFacturaRelaciones(VisibleFactura visiblefactura)throws Exception {

		if(!visiblefactura.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveVisibleFacturaRelacionesBase(visiblefactura,false);
		}
	}

	public void saveVisibleFacturaRelacionesBase(VisibleFactura visiblefactura,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("VisibleFactura-saveRelacionesWithConnection");}
	

			this.setVisibleFactura(visiblefactura);

			if(VisibleFacturaLogicAdditional.validarSaveRelaciones(visiblefactura,this)) {

				VisibleFacturaLogicAdditional.updateRelacionesToSave(visiblefactura,this);

				if((visiblefactura.getIsNew()||visiblefactura.getIsChanged())&&!visiblefactura.getIsDeleted()) {
					this.saveVisibleFactura();
					this.saveVisibleFacturaRelacionesDetalles();

				} else if(visiblefactura.getIsDeleted()) {
					this.saveVisibleFacturaRelacionesDetalles();
					this.saveVisibleFactura();
				}

				VisibleFacturaLogicAdditional.updateRelacionesToSaveAfter(visiblefactura,this);

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
	
	
	private void saveVisibleFacturaRelacionesDetalles()throws Exception {
		try {
	

		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfVisibleFactura(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=VisibleFacturaConstantesFunciones.getClassesForeignKeysOfVisibleFactura(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfVisibleFactura(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=VisibleFacturaConstantesFunciones.getClassesRelationshipsOfVisibleFactura(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}
