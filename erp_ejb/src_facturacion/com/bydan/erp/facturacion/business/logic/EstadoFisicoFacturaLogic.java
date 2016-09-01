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
import com.bydan.erp.facturacion.util.EstadoFisicoFacturaConstantesFunciones;
import com.bydan.erp.facturacion.util.EstadoFisicoFacturaParameterReturnGeneral;
//import com.bydan.erp.facturacion.util.EstadoFisicoFacturaParameterGeneral;
import com.bydan.erp.facturacion.business.entity.EstadoFisicoFactura;
//import com.bydan.erp.facturacion.business.logic.EstadoFisicoFacturaLogicAdditional;
import com.bydan.erp.facturacion.business.dataaccess.*;
import com.bydan.erp.facturacion.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.logic.*;


import com.bydan.erp.seguridad.util.*;


import com.bydan.erp.seguridad.business.dataaccess.*;








@SuppressWarnings("unused")
public class EstadoFisicoFacturaLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(EstadoFisicoFacturaLogic.class);
	
	protected EstadoFisicoFacturaDataAccess estadofisicofacturaDataAccess; 	
	protected EstadoFisicoFactura estadofisicofactura;
	protected List<EstadoFisicoFactura> estadofisicofacturas;
	protected Object estadofisicofacturaObject;	
	protected List<Object> estadofisicofacturasObject;
	
	public static ClassValidator<EstadoFisicoFactura> estadofisicofacturaValidator = new ClassValidator<EstadoFisicoFactura>(EstadoFisicoFactura.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
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
	
	
	
	
	public  EstadoFisicoFacturaLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.estadofisicofacturaDataAccess = new EstadoFisicoFacturaDataAccess();
			
			this.estadofisicofacturas= new ArrayList<EstadoFisicoFactura>();
			this.estadofisicofactura= new EstadoFisicoFactura();
			
			this.estadofisicofacturaObject=new Object();
			this.estadofisicofacturasObject=new ArrayList<Object>();
				
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
			
			this.estadofisicofacturaDataAccess.setConnexionType(this.connexionType);
			this.estadofisicofacturaDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  EstadoFisicoFacturaLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.estadofisicofacturaDataAccess = new EstadoFisicoFacturaDataAccess();
			this.estadofisicofacturas= new ArrayList<EstadoFisicoFactura>();
			this.estadofisicofactura= new EstadoFisicoFactura();
			this.estadofisicofacturaObject=new Object();
			this.estadofisicofacturasObject=new ArrayList<Object>();
			
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
			
			this.estadofisicofacturaDataAccess.setConnexionType(this.connexionType);
			this.estadofisicofacturaDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public EstadoFisicoFactura getEstadoFisicoFactura() throws Exception {	
		//EstadoFisicoFacturaLogicAdditional.checkEstadoFisicoFacturaToGet(estadofisicofactura,this.datosCliente,this.arrDatoGeneral);
		//EstadoFisicoFacturaLogicAdditional.updateEstadoFisicoFacturaToGet(estadofisicofactura,this.arrDatoGeneral);
		
		return estadofisicofactura;
	}
		
	public void setEstadoFisicoFactura(EstadoFisicoFactura newEstadoFisicoFactura) {
		this.estadofisicofactura = newEstadoFisicoFactura;
	}
	
	public EstadoFisicoFacturaDataAccess getEstadoFisicoFacturaDataAccess() {
		return estadofisicofacturaDataAccess;
	}
	
	public void setEstadoFisicoFacturaDataAccess(EstadoFisicoFacturaDataAccess newestadofisicofacturaDataAccess) {
		this.estadofisicofacturaDataAccess = newestadofisicofacturaDataAccess;
	}
	
	public List<EstadoFisicoFactura> getEstadoFisicoFacturas() throws Exception {		
		this.quitarEstadoFisicoFacturasNulos();
		
		//EstadoFisicoFacturaLogicAdditional.checkEstadoFisicoFacturaToGets(estadofisicofacturas,this.datosCliente,this.arrDatoGeneral);
		
		for (EstadoFisicoFactura estadofisicofacturaLocal: estadofisicofacturas ) {
			//EstadoFisicoFacturaLogicAdditional.updateEstadoFisicoFacturaToGet(estadofisicofacturaLocal,this.arrDatoGeneral);
		}
		
		return estadofisicofacturas;
	}
	
	public void setEstadoFisicoFacturas(List<EstadoFisicoFactura> newEstadoFisicoFacturas) {
		this.estadofisicofacturas = newEstadoFisicoFacturas;
	}
	
	public Object getEstadoFisicoFacturaObject() {	
		this.estadofisicofacturaObject=this.estadofisicofacturaDataAccess.getEntityObject();
		return this.estadofisicofacturaObject;
	}
		
	public void setEstadoFisicoFacturaObject(Object newEstadoFisicoFacturaObject) {
		this.estadofisicofacturaObject = newEstadoFisicoFacturaObject;
	}
	
	public List<Object> getEstadoFisicoFacturasObject() {		
		this.estadofisicofacturasObject=this.estadofisicofacturaDataAccess.getEntitiesObject();
		return this.estadofisicofacturasObject;
	}
		
	public void setEstadoFisicoFacturasObject(List<Object> newEstadoFisicoFacturasObject) {
		this.estadofisicofacturasObject = newEstadoFisicoFacturasObject;
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
		
		if(this.estadofisicofacturaDataAccess!=null) {
			this.estadofisicofacturaDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoFisicoFactura.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			estadofisicofacturaDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			estadofisicofacturaDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		estadofisicofactura = new  EstadoFisicoFactura();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoFisicoFactura.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			estadofisicofactura=estadofisicofacturaDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.estadofisicofactura,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				EstadoFisicoFacturaConstantesFunciones.refrescarForeignKeysDescripcionesEstadoFisicoFactura(this.estadofisicofactura);
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
		estadofisicofactura = new  EstadoFisicoFactura();
		  		  
        try {
			
			estadofisicofactura=estadofisicofacturaDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.estadofisicofactura,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				EstadoFisicoFacturaConstantesFunciones.refrescarForeignKeysDescripcionesEstadoFisicoFactura(this.estadofisicofactura);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		estadofisicofactura = new  EstadoFisicoFactura();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoFisicoFactura.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			estadofisicofactura=estadofisicofacturaDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.estadofisicofactura,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				EstadoFisicoFacturaConstantesFunciones.refrescarForeignKeysDescripcionesEstadoFisicoFactura(this.estadofisicofactura);
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
		estadofisicofactura = new  EstadoFisicoFactura();
		  		  
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
		estadofisicofactura = new  EstadoFisicoFactura();
		  		  
        try {
			
			estadofisicofactura=estadofisicofacturaDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.estadofisicofactura,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				EstadoFisicoFacturaConstantesFunciones.refrescarForeignKeysDescripcionesEstadoFisicoFactura(this.estadofisicofactura);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		estadofisicofactura = new  EstadoFisicoFactura();
		  		  
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
		estadofisicofactura = new  EstadoFisicoFactura();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoFisicoFactura.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =estadofisicofacturaDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		estadofisicofactura = new  EstadoFisicoFactura();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=estadofisicofacturaDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		estadofisicofactura = new  EstadoFisicoFactura();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoFisicoFactura.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =estadofisicofacturaDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		estadofisicofactura = new  EstadoFisicoFactura();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=estadofisicofacturaDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		estadofisicofactura = new  EstadoFisicoFactura();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoFisicoFactura.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =estadofisicofacturaDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		estadofisicofactura = new  EstadoFisicoFactura();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=estadofisicofacturaDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		estadofisicofacturas = new  ArrayList<EstadoFisicoFactura>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoFisicoFactura.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			EstadoFisicoFacturaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			estadofisicofacturas=estadofisicofacturaDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarEstadoFisicoFactura(estadofisicofacturas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EstadoFisicoFacturaConstantesFunciones.refrescarForeignKeysDescripcionesEstadoFisicoFactura(this.estadofisicofacturas);
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
		estadofisicofacturas = new  ArrayList<EstadoFisicoFactura>();
		  		  
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
		estadofisicofacturas = new  ArrayList<EstadoFisicoFactura>();
		  		  
        try {			
			EstadoFisicoFacturaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			estadofisicofacturas=estadofisicofacturaDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarEstadoFisicoFactura(estadofisicofacturas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EstadoFisicoFacturaConstantesFunciones.refrescarForeignKeysDescripcionesEstadoFisicoFactura(this.estadofisicofacturas);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		estadofisicofacturas = new  ArrayList<EstadoFisicoFactura>();
		  		  
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
		estadofisicofacturas = new  ArrayList<EstadoFisicoFactura>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoFisicoFactura.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			EstadoFisicoFacturaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			estadofisicofacturas=estadofisicofacturaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarEstadoFisicoFactura(estadofisicofacturas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EstadoFisicoFacturaConstantesFunciones.refrescarForeignKeysDescripcionesEstadoFisicoFactura(this.estadofisicofacturas);
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
		estadofisicofacturas = new  ArrayList<EstadoFisicoFactura>();
		  		  
        try {
			EstadoFisicoFacturaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			estadofisicofacturas=estadofisicofacturaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarEstadoFisicoFactura(estadofisicofacturas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EstadoFisicoFacturaConstantesFunciones.refrescarForeignKeysDescripcionesEstadoFisicoFactura(this.estadofisicofacturas);
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
		estadofisicofacturas = new  ArrayList<EstadoFisicoFactura>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoFisicoFactura.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			EstadoFisicoFacturaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			estadofisicofacturas=estadofisicofacturaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarEstadoFisicoFactura(estadofisicofacturas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EstadoFisicoFacturaConstantesFunciones.refrescarForeignKeysDescripcionesEstadoFisicoFactura(this.estadofisicofacturas);
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
		estadofisicofacturas = new  ArrayList<EstadoFisicoFactura>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			EstadoFisicoFacturaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			estadofisicofacturas=estadofisicofacturaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarEstadoFisicoFactura(estadofisicofacturas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EstadoFisicoFacturaConstantesFunciones.refrescarForeignKeysDescripcionesEstadoFisicoFactura(this.estadofisicofacturas);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		estadofisicofactura = new  EstadoFisicoFactura();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoFisicoFactura.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			EstadoFisicoFacturaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			estadofisicofactura=estadofisicofacturaDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarEstadoFisicoFactura(estadofisicofactura);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EstadoFisicoFacturaConstantesFunciones.refrescarForeignKeysDescripcionesEstadoFisicoFactura(this.estadofisicofactura);
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
		estadofisicofactura = new  EstadoFisicoFactura();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			EstadoFisicoFacturaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			estadofisicofactura=estadofisicofacturaDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarEstadoFisicoFactura(estadofisicofactura);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EstadoFisicoFacturaConstantesFunciones.refrescarForeignKeysDescripcionesEstadoFisicoFactura(this.estadofisicofactura);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	
	
	public void getTodosEstadoFisicoFacturasWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		estadofisicofacturas = new  ArrayList<EstadoFisicoFactura>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoFisicoFactura.class.getSimpleName()+"-getTodosEstadoFisicoFacturasWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			EstadoFisicoFacturaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			estadofisicofacturas=estadofisicofacturaDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarEstadoFisicoFactura(estadofisicofacturas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EstadoFisicoFacturaConstantesFunciones.refrescarForeignKeysDescripcionesEstadoFisicoFactura(this.estadofisicofacturas);
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
	
	public  void  getTodosEstadoFisicoFacturas(String sFinalQuery,Pagination pagination)throws Exception {
		estadofisicofacturas = new  ArrayList<EstadoFisicoFactura>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			EstadoFisicoFacturaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			estadofisicofacturas=estadofisicofacturaDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarEstadoFisicoFactura(estadofisicofacturas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EstadoFisicoFacturaConstantesFunciones.refrescarForeignKeysDescripcionesEstadoFisicoFactura(this.estadofisicofacturas);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarEstadoFisicoFactura(EstadoFisicoFactura estadofisicofactura) throws Exception {
		Boolean estaValidado=false;
		
		if(estadofisicofactura.getIsNew() || estadofisicofactura.getIsChanged()) { 
			this.invalidValues = estadofisicofacturaValidator.getInvalidValues(estadofisicofactura);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(estadofisicofactura);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarEstadoFisicoFactura(List<EstadoFisicoFactura> EstadoFisicoFacturas) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(EstadoFisicoFactura estadofisicofacturaLocal:estadofisicofacturas) {				
			estaValidadoObjeto=this.validarGuardarEstadoFisicoFactura(estadofisicofacturaLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarEstadoFisicoFactura(List<EstadoFisicoFactura> EstadoFisicoFacturas) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarEstadoFisicoFactura(estadofisicofacturas)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarEstadoFisicoFactura(EstadoFisicoFactura EstadoFisicoFactura) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarEstadoFisicoFactura(estadofisicofactura)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(EstadoFisicoFactura estadofisicofactura) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+estadofisicofactura.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=EstadoFisicoFacturaConstantesFunciones.getEstadoFisicoFacturaLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"estadofisicofactura","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(EstadoFisicoFacturaConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(EstadoFisicoFacturaConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveEstadoFisicoFacturaWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoFisicoFactura.class.getSimpleName()+"-saveEstadoFisicoFacturaWithConnection");connexion.begin();			
			
			//EstadoFisicoFacturaLogicAdditional.checkEstadoFisicoFacturaToSave(this.estadofisicofactura,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//EstadoFisicoFacturaLogicAdditional.updateEstadoFisicoFacturaToSave(this.estadofisicofactura,this.arrDatoGeneral);
			
			EstadoFisicoFacturaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.estadofisicofactura,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowEstadoFisicoFactura();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarEstadoFisicoFactura(this.estadofisicofactura)) {
				EstadoFisicoFacturaDataAccess.save(this.estadofisicofactura, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.estadofisicofactura,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			//EstadoFisicoFacturaLogicAdditional.checkEstadoFisicoFacturaToSaveAfter(this.estadofisicofactura,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowEstadoFisicoFactura();
			
			connexion.commit();			
			
			if(this.estadofisicofactura.getIsDeleted()) {
				this.estadofisicofactura=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveEstadoFisicoFactura()throws Exception {	
		try {	
			
			//EstadoFisicoFacturaLogicAdditional.checkEstadoFisicoFacturaToSave(this.estadofisicofactura,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//EstadoFisicoFacturaLogicAdditional.updateEstadoFisicoFacturaToSave(this.estadofisicofactura,this.arrDatoGeneral);
			
			EstadoFisicoFacturaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.estadofisicofactura,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarEstadoFisicoFactura(this.estadofisicofactura)) {			
				EstadoFisicoFacturaDataAccess.save(this.estadofisicofactura, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.estadofisicofactura,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			//EstadoFisicoFacturaLogicAdditional.checkEstadoFisicoFacturaToSaveAfter(this.estadofisicofactura,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.estadofisicofactura.getIsDeleted()) {
				this.estadofisicofactura=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveEstadoFisicoFacturasWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoFisicoFactura.class.getSimpleName()+"-saveEstadoFisicoFacturasWithConnection");connexion.begin();			
			
			//EstadoFisicoFacturaLogicAdditional.checkEstadoFisicoFacturaToSaves(estadofisicofacturas,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowEstadoFisicoFacturas();
			
			Boolean validadoTodosEstadoFisicoFactura=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(EstadoFisicoFactura estadofisicofacturaLocal:estadofisicofacturas) {		
				if(estadofisicofacturaLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				//EstadoFisicoFacturaLogicAdditional.updateEstadoFisicoFacturaToSave(estadofisicofacturaLocal,this.arrDatoGeneral);
	        	
				EstadoFisicoFacturaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),estadofisicofacturaLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarEstadoFisicoFactura(estadofisicofacturaLocal)) {
					EstadoFisicoFacturaDataAccess.save(estadofisicofacturaLocal, connexion);				
				} else {
					validadoTodosEstadoFisicoFactura=false;
				}
			}
			
			if(!validadoTodosEstadoFisicoFactura) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			//EstadoFisicoFacturaLogicAdditional.checkEstadoFisicoFacturaToSavesAfter(estadofisicofacturas,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowEstadoFisicoFacturas();
			
			connexion.commit();		
			
			this.quitarEstadoFisicoFacturasEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveEstadoFisicoFacturas()throws Exception {				
		 try {	
			//EstadoFisicoFacturaLogicAdditional.checkEstadoFisicoFacturaToSaves(estadofisicofacturas,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosEstadoFisicoFactura=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(EstadoFisicoFactura estadofisicofacturaLocal:estadofisicofacturas) {				
				if(estadofisicofacturaLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				//EstadoFisicoFacturaLogicAdditional.updateEstadoFisicoFacturaToSave(estadofisicofacturaLocal,this.arrDatoGeneral);
	        	
				EstadoFisicoFacturaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),estadofisicofacturaLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarEstadoFisicoFactura(estadofisicofacturaLocal)) {				
					EstadoFisicoFacturaDataAccess.save(estadofisicofacturaLocal, connexion);				
				} else {
					validadoTodosEstadoFisicoFactura=false;
				}
			}
			
			if(!validadoTodosEstadoFisicoFactura) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			//EstadoFisicoFacturaLogicAdditional.checkEstadoFisicoFacturaToSavesAfter(estadofisicofacturas,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarEstadoFisicoFacturasEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public EstadoFisicoFacturaParameterReturnGeneral procesarAccionEstadoFisicoFacturas(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<EstadoFisicoFactura> estadofisicofacturas,EstadoFisicoFacturaParameterReturnGeneral estadofisicofacturaParameterGeneral)throws Exception {
		 try {	
			EstadoFisicoFacturaParameterReturnGeneral estadofisicofacturaReturnGeneral=new EstadoFisicoFacturaParameterReturnGeneral();
	
			
			return estadofisicofacturaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public EstadoFisicoFacturaParameterReturnGeneral procesarAccionEstadoFisicoFacturasWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<EstadoFisicoFactura> estadofisicofacturas,EstadoFisicoFacturaParameterReturnGeneral estadofisicofacturaParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoFisicoFactura.class.getSimpleName()+"-procesarAccionEstadoFisicoFacturasWithConnection");connexion.begin();			
			
			EstadoFisicoFacturaParameterReturnGeneral estadofisicofacturaReturnGeneral=new EstadoFisicoFacturaParameterReturnGeneral();
	
			
			this.connexion.commit();
			
			return estadofisicofacturaReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public EstadoFisicoFacturaParameterReturnGeneral procesarEventosEstadoFisicoFacturas(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<EstadoFisicoFactura> estadofisicofacturas,EstadoFisicoFactura estadofisicofactura,EstadoFisicoFacturaParameterReturnGeneral estadofisicofacturaParameterGeneral,Boolean isEsNuevoEstadoFisicoFactura,ArrayList<Classe> clases)throws Exception {
		 try {	
			EstadoFisicoFacturaParameterReturnGeneral estadofisicofacturaReturnGeneral=new EstadoFisicoFacturaParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				estadofisicofacturaReturnGeneral.setConRecargarPropiedades(true);
			}
			
			
			return estadofisicofacturaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public EstadoFisicoFacturaParameterReturnGeneral procesarEventosEstadoFisicoFacturasWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<EstadoFisicoFactura> estadofisicofacturas,EstadoFisicoFactura estadofisicofactura,EstadoFisicoFacturaParameterReturnGeneral estadofisicofacturaParameterGeneral,Boolean isEsNuevoEstadoFisicoFactura,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoFisicoFactura.class.getSimpleName()+"-procesarEventosEstadoFisicoFacturasWithConnection");connexion.begin();			
			
			EstadoFisicoFacturaParameterReturnGeneral estadofisicofacturaReturnGeneral=new EstadoFisicoFacturaParameterReturnGeneral();
	
			estadofisicofacturaReturnGeneral.setEstadoFisicoFactura(estadofisicofactura);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				estadofisicofacturaReturnGeneral.setConRecargarPropiedades(true);
			}
			
			
			this.connexion.commit();
			
			return estadofisicofacturaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public EstadoFisicoFacturaParameterReturnGeneral procesarImportacionEstadoFisicoFacturasWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,EstadoFisicoFacturaParameterReturnGeneral estadofisicofacturaParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoFisicoFactura.class.getSimpleName()+"-procesarImportacionEstadoFisicoFacturasWithConnection");connexion.begin();			
			
			EstadoFisicoFacturaParameterReturnGeneral estadofisicofacturaReturnGeneral=new EstadoFisicoFacturaParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.estadofisicofacturas=new ArrayList<EstadoFisicoFactura>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.estadofisicofactura=new EstadoFisicoFactura();
				
				
				if(conColumnasBase) {this.estadofisicofactura.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.estadofisicofactura.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.estadofisicofactura.setnombre(arrColumnas[iColumn++]);
				
				this.estadofisicofacturas.add(this.estadofisicofactura);
			}
			
			this.saveEstadoFisicoFacturas();
			
			this.connexion.commit();
			
			estadofisicofacturaReturnGeneral.setConRetornoEstaProcesado(true);
			estadofisicofacturaReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return estadofisicofacturaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarEstadoFisicoFacturasEliminados() throws Exception {				
		
		List<EstadoFisicoFactura> estadofisicofacturasAux= new ArrayList<EstadoFisicoFactura>();
		
		for(EstadoFisicoFactura estadofisicofactura:estadofisicofacturas) {
			if(!estadofisicofactura.getIsDeleted()) {
				estadofisicofacturasAux.add(estadofisicofactura);
			}
		}
		
		estadofisicofacturas=estadofisicofacturasAux;
	}
	
	public void quitarEstadoFisicoFacturasNulos() throws Exception {				
		
		List<EstadoFisicoFactura> estadofisicofacturasAux= new ArrayList<EstadoFisicoFactura>();
		
		for(EstadoFisicoFactura estadofisicofactura : this.estadofisicofacturas) {
			if(estadofisicofactura==null) {
				estadofisicofacturasAux.add(estadofisicofactura);
			}
		}
		
		//this.estadofisicofacturas=estadofisicofacturasAux;
		
		this.estadofisicofacturas.removeAll(estadofisicofacturasAux);
	}
	
	public void getSetVersionRowEstadoFisicoFacturaWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(estadofisicofactura.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((estadofisicofactura.getIsDeleted() || (estadofisicofactura.getIsChanged()&&!estadofisicofactura.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=estadofisicofacturaDataAccess.getSetVersionRowEstadoFisicoFactura(connexion,estadofisicofactura.getId());
				
				if(!estadofisicofactura.getVersionRow().equals(timestamp)) {	
					estadofisicofactura.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				estadofisicofactura.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowEstadoFisicoFactura()throws Exception {	
		
		if(estadofisicofactura.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((estadofisicofactura.getIsDeleted() || (estadofisicofactura.getIsChanged()&&!estadofisicofactura.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=estadofisicofacturaDataAccess.getSetVersionRowEstadoFisicoFactura(connexion,estadofisicofactura.getId());
			
			try {							
				if(!estadofisicofactura.getVersionRow().equals(timestamp)) {	
					estadofisicofactura.setVersionRow(timestamp);
				}
				
				estadofisicofactura.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowEstadoFisicoFacturasWithConnection()throws Exception {	
		if(estadofisicofacturas!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(EstadoFisicoFactura estadofisicofacturaAux:estadofisicofacturas) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(estadofisicofacturaAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(estadofisicofacturaAux.getIsDeleted() || (estadofisicofacturaAux.getIsChanged()&&!estadofisicofacturaAux.getIsNew())) {
						
						timestamp=estadofisicofacturaDataAccess.getSetVersionRowEstadoFisicoFactura(connexion,estadofisicofacturaAux.getId());
						
						if(!estadofisicofactura.getVersionRow().equals(timestamp)) {	
							estadofisicofacturaAux.setVersionRow(timestamp);
						}
								
						estadofisicofacturaAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowEstadoFisicoFacturas()throws Exception {	
		if(estadofisicofacturas!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(EstadoFisicoFactura estadofisicofacturaAux:estadofisicofacturas) {
					if(estadofisicofacturaAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(estadofisicofacturaAux.getIsDeleted() || (estadofisicofacturaAux.getIsChanged()&&!estadofisicofacturaAux.getIsNew())) {
						
						timestamp=estadofisicofacturaDataAccess.getSetVersionRowEstadoFisicoFactura(connexion,estadofisicofacturaAux.getId());
						
						if(!estadofisicofacturaAux.getVersionRow().equals(timestamp)) {	
							estadofisicofacturaAux.setVersionRow(timestamp);
						}
						
													
						estadofisicofacturaAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public EstadoFisicoFacturaParameterReturnGeneral cargarCombosLoteForeignKeyEstadoFisicoFacturaWithConnection(String finalQueryGlobalPais) throws Exception {
		EstadoFisicoFacturaParameterReturnGeneral  estadofisicofacturaReturnGeneral =new EstadoFisicoFacturaParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoFisicoFactura.class.getSimpleName()+"-cargarCombosLoteForeignKeyEstadoFisicoFacturaWithConnection");connexion.begin();
			
			estadofisicofacturaReturnGeneral =new EstadoFisicoFacturaParameterReturnGeneral();
			
			

			List<Pais> paissForeignKey=new ArrayList<Pais>();
			PaisLogic paisLogic=new PaisLogic();
			paisLogic.setConnexion(this.connexion);
			paisLogic.getPaisDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalPais.equals("NONE")) {
				paisLogic.getTodosPaiss(finalQueryGlobalPais,new Pagination());
				paissForeignKey=paisLogic.getPaiss();
			}

			estadofisicofacturaReturnGeneral.setpaissForeignKey(paissForeignKey);

			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
		
		return estadofisicofacturaReturnGeneral;
	}
	
	public EstadoFisicoFacturaParameterReturnGeneral cargarCombosLoteForeignKeyEstadoFisicoFactura(String finalQueryGlobalPais) throws Exception {
		EstadoFisicoFacturaParameterReturnGeneral  estadofisicofacturaReturnGeneral =new EstadoFisicoFacturaParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {						
			estadofisicofacturaReturnGeneral =new EstadoFisicoFacturaParameterReturnGeneral();
			
			

			List<Pais> paissForeignKey=new ArrayList<Pais>();
			PaisLogic paisLogic=new PaisLogic();
			paisLogic.setConnexion(this.connexion);
			paisLogic.getPaisDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalPais.equals("NONE")) {
				paisLogic.getTodosPaiss(finalQueryGlobalPais,new Pagination());
				paissForeignKey=paisLogic.getPaiss();
			}

			estadofisicofacturaReturnGeneral.setpaissForeignKey(paissForeignKey);
						
			
		} catch(Exception e) {			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			
		}
		
		return estadofisicofacturaReturnGeneral;
	}
	
	
	public void deepLoad(EstadoFisicoFactura estadofisicofactura,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			//EstadoFisicoFacturaLogicAdditional.updateEstadoFisicoFacturaToGet(estadofisicofactura,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		estadofisicofactura.setPais(estadofisicofacturaDataAccess.getPais(connexion,estadofisicofactura));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Pais.class)) {
				estadofisicofactura.setPais(estadofisicofacturaDataAccess.getPais(connexion,estadofisicofactura));
				continue;
			}
		}
	}
	else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Pais.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			estadofisicofactura.setPais(estadofisicofacturaDataAccess.getPais(connexion,estadofisicofactura));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		estadofisicofactura.setPais(estadofisicofacturaDataAccess.getPais(connexion,estadofisicofactura));
		PaisLogic paisLogic= new PaisLogic(connexion);
		paisLogic.deepLoad(estadofisicofactura.getPais(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Pais.class)) {
				estadofisicofactura.setPais(estadofisicofacturaDataAccess.getPais(connexion,estadofisicofactura));
				PaisLogic paisLogic= new PaisLogic(connexion);
				paisLogic.deepLoad(estadofisicofactura.getPais(),isDeep,deepLoadType,clases);				
				continue;
			}

		}
	}
	else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {


		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Pais.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			estadofisicofactura.setPais(estadofisicofacturaDataAccess.getPais(connexion,estadofisicofactura));
			PaisLogic paisLogic= new PaisLogic(connexion);
			paisLogic.deepLoad(estadofisicofactura.getPais(),isDeep,deepLoadType,clases);
				
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(EstadoFisicoFactura estadofisicofactura,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}	
	}
	
	public void deepLoadWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(EstadoFisicoFactura.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(estadofisicofactura,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				EstadoFisicoFacturaConstantesFunciones.refrescarForeignKeysDescripcionesEstadoFisicoFactura(estadofisicofactura);
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
			this.deepLoad(this.estadofisicofactura,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				EstadoFisicoFacturaConstantesFunciones.refrescarForeignKeysDescripcionesEstadoFisicoFactura(this.estadofisicofactura);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(EstadoFisicoFactura.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(estadofisicofacturas!=null) {
				for(EstadoFisicoFactura estadofisicofactura:estadofisicofacturas) {
					this.deepLoad(estadofisicofactura,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					EstadoFisicoFacturaConstantesFunciones.refrescarForeignKeysDescripcionesEstadoFisicoFactura(estadofisicofacturas);
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
			if(estadofisicofacturas!=null) {
				for(EstadoFisicoFactura estadofisicofactura:estadofisicofacturas) {
					this.deepLoad(estadofisicofactura,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					EstadoFisicoFacturaConstantesFunciones.refrescarForeignKeysDescripcionesEstadoFisicoFactura(estadofisicofacturas);
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
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getEstadoFisicoFacturasFK_IdPaisWithConnection(String sFinalQuery,Pagination pagination,Long id_pais)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoFisicoFactura.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidPais= new ParameterSelectionGeneral();
			parameterSelectionGeneralidPais.setParameterSelectionGeneralEqual(ParameterType.LONG,id_pais,EstadoFisicoFacturaConstantesFunciones.IDPAIS,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidPais);

			EstadoFisicoFacturaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdPais","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			estadofisicofacturas=estadofisicofacturaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				EstadoFisicoFacturaConstantesFunciones.refrescarForeignKeysDescripcionesEstadoFisicoFactura(this.estadofisicofacturas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getEstadoFisicoFacturasFK_IdPais(String sFinalQuery,Pagination pagination,Long id_pais)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidPais= new ParameterSelectionGeneral();
			parameterSelectionGeneralidPais.setParameterSelectionGeneralEqual(ParameterType.LONG,id_pais,EstadoFisicoFacturaConstantesFunciones.IDPAIS,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidPais);

			EstadoFisicoFacturaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdPais","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			estadofisicofacturas=estadofisicofacturaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				EstadoFisicoFacturaConstantesFunciones.refrescarForeignKeysDescripcionesEstadoFisicoFactura(this.estadofisicofacturas);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getEstadoFisicoFacturaPorNombreWithConnection(String nombre)throws Exception {
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoFisicoFactura.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			ParameterSelectionGeneral parameterSelectionGeneralNombre= new ParameterSelectionGeneral();
			parameterSelectionGeneralNombre.setParameterSelectionGeneralEqual(ParameterType.STRING,nombre,EstadoFisicoFacturaConstantesFunciones.NOMBRE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralNombre);

			estadofisicofactura=estadofisicofacturaDataAccess.getEntity(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoad(this.estadofisicofactura,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());

				EstadoFisicoFacturaConstantesFunciones.refrescarForeignKeysDescripcionesEstadoFisicoFactura(this.estadofisicofactura);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getEstadoFisicoFacturaPorNombre(String nombre)throws Exception {
		try {

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			ParameterSelectionGeneral parameterSelectionGeneralNombre= new ParameterSelectionGeneral();
			parameterSelectionGeneralNombre.setParameterSelectionGeneralEqual(ParameterType.STRING,nombre,EstadoFisicoFacturaConstantesFunciones.NOMBRE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralNombre);

			estadofisicofactura=estadofisicofacturaDataAccess.getEntity(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoad(this.estadofisicofactura,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());

				EstadoFisicoFacturaConstantesFunciones.refrescarForeignKeysDescripcionesEstadoFisicoFactura(this.estadofisicofactura);
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
			if(EstadoFisicoFacturaConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,EstadoFisicoFacturaDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,EstadoFisicoFactura estadofisicofactura,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(EstadoFisicoFacturaConstantesFunciones.ISCONAUDITORIA) {
				if(estadofisicofactura.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,EstadoFisicoFacturaDataAccess.TABLENAME, estadofisicofactura.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(EstadoFisicoFacturaConstantesFunciones.ISCONAUDITORIADETALLE) {
						////EstadoFisicoFacturaLogic.registrarAuditoriaDetallesEstadoFisicoFactura(connexion,estadofisicofactura,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(estadofisicofactura.getIsDeleted()) {
					/*if(!estadofisicofactura.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,EstadoFisicoFacturaDataAccess.TABLENAME, estadofisicofactura.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////EstadoFisicoFacturaLogic.registrarAuditoriaDetallesEstadoFisicoFactura(connexion,estadofisicofactura,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,EstadoFisicoFacturaDataAccess.TABLENAME, estadofisicofactura.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(estadofisicofactura.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,EstadoFisicoFacturaDataAccess.TABLENAME, estadofisicofactura.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(EstadoFisicoFacturaConstantesFunciones.ISCONAUDITORIADETALLE) {
						////EstadoFisicoFacturaLogic.registrarAuditoriaDetallesEstadoFisicoFactura(connexion,estadofisicofactura,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesEstadoFisicoFactura(Connexion connexion,EstadoFisicoFactura estadofisicofactura)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(estadofisicofactura.getIsNew()||!estadofisicofactura.getid_pais().equals(estadofisicofactura.getEstadoFisicoFacturaOriginal().getid_pais()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(estadofisicofactura.getEstadoFisicoFacturaOriginal().getid_pais()!=null)
				{
					strValorActual=estadofisicofactura.getEstadoFisicoFacturaOriginal().getid_pais().toString();
				}
				if(estadofisicofactura.getid_pais()!=null)
				{
					strValorNuevo=estadofisicofactura.getid_pais().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),EstadoFisicoFacturaConstantesFunciones.IDPAIS,strValorActual,strValorNuevo);
			}	
			
			if(estadofisicofactura.getIsNew()||!estadofisicofactura.getnombre().equals(estadofisicofactura.getEstadoFisicoFacturaOriginal().getnombre()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(estadofisicofactura.getEstadoFisicoFacturaOriginal().getnombre()!=null)
				{
					strValorActual=estadofisicofactura.getEstadoFisicoFacturaOriginal().getnombre();
				}
				if(estadofisicofactura.getnombre()!=null)
				{
					strValorNuevo=estadofisicofactura.getnombre() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),EstadoFisicoFacturaConstantesFunciones.NOMBRE,strValorActual,strValorNuevo);
			}	
	}
	
	
//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfEstadoFisicoFactura(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=EstadoFisicoFacturaConstantesFunciones.getClassesForeignKeysOfEstadoFisicoFactura(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfEstadoFisicoFactura(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=EstadoFisicoFacturaConstantesFunciones.getClassesRelationshipsOfEstadoFisicoFactura(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
}
