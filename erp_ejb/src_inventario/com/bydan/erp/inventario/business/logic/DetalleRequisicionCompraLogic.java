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
package com.bydan.erp.inventario.business.logic;

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
import com.bydan.erp.inventario.util.*;
import com.bydan.erp.inventario.util.DetalleRequisicionCompraConstantesFunciones;
import com.bydan.erp.inventario.util.DetalleRequisicionCompraParameterReturnGeneral;
//import com.bydan.erp.inventario.util.DetalleRequisicionCompraParameterGeneral;
import com.bydan.erp.inventario.business.entity.DetalleRequisicionCompra;
import com.bydan.erp.inventario.business.logic.DetalleRequisicionCompraLogicAdditional;
import com.bydan.erp.inventario.business.dataaccess.*;
import com.bydan.erp.inventario.business.entity.*;

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
public class DetalleRequisicionCompraLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(DetalleRequisicionCompraLogic.class);
	
	protected DetalleRequisicionCompraDataAccess detallerequisicioncompraDataAccess; 	
	protected DetalleRequisicionCompra detallerequisicioncompra;
	protected List<DetalleRequisicionCompra> detallerequisicioncompras;
	protected Object detallerequisicioncompraObject;	
	protected List<Object> detallerequisicioncomprasObject;
	
	public static ClassValidator<DetalleRequisicionCompra> detallerequisicioncompraValidator = new ClassValidator<DetalleRequisicionCompra>(DetalleRequisicionCompra.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected DetalleRequisicionCompraLogicAdditional detallerequisicioncompraLogicAdditional=null;
	
	public DetalleRequisicionCompraLogicAdditional getDetalleRequisicionCompraLogicAdditional() {
		return this.detallerequisicioncompraLogicAdditional;
	}
	
	public void setDetalleRequisicionCompraLogicAdditional(DetalleRequisicionCompraLogicAdditional detallerequisicioncompraLogicAdditional) {
		try {
			this.detallerequisicioncompraLogicAdditional=detallerequisicioncompraLogicAdditional;
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
	
	
	
	
	public  DetalleRequisicionCompraLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.detallerequisicioncompraDataAccess = new DetalleRequisicionCompraDataAccess();
			
			this.detallerequisicioncompras= new ArrayList<DetalleRequisicionCompra>();
			this.detallerequisicioncompra= new DetalleRequisicionCompra();
			
			this.detallerequisicioncompraObject=new Object();
			this.detallerequisicioncomprasObject=new ArrayList<Object>();
				
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
			
			this.detallerequisicioncompraDataAccess.setConnexionType(this.connexionType);
			this.detallerequisicioncompraDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  DetalleRequisicionCompraLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.detallerequisicioncompraDataAccess = new DetalleRequisicionCompraDataAccess();
			this.detallerequisicioncompras= new ArrayList<DetalleRequisicionCompra>();
			this.detallerequisicioncompra= new DetalleRequisicionCompra();
			this.detallerequisicioncompraObject=new Object();
			this.detallerequisicioncomprasObject=new ArrayList<Object>();
			
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
			
			this.detallerequisicioncompraDataAccess.setConnexionType(this.connexionType);
			this.detallerequisicioncompraDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public DetalleRequisicionCompra getDetalleRequisicionCompra() throws Exception {	
		DetalleRequisicionCompraLogicAdditional.checkDetalleRequisicionCompraToGet(detallerequisicioncompra,this.datosCliente,this.arrDatoGeneral);
		DetalleRequisicionCompraLogicAdditional.updateDetalleRequisicionCompraToGet(detallerequisicioncompra,this.arrDatoGeneral);
		
		return detallerequisicioncompra;
	}
		
	public void setDetalleRequisicionCompra(DetalleRequisicionCompra newDetalleRequisicionCompra) {
		this.detallerequisicioncompra = newDetalleRequisicionCompra;
	}
	
	public DetalleRequisicionCompraDataAccess getDetalleRequisicionCompraDataAccess() {
		return detallerequisicioncompraDataAccess;
	}
	
	public void setDetalleRequisicionCompraDataAccess(DetalleRequisicionCompraDataAccess newdetallerequisicioncompraDataAccess) {
		this.detallerequisicioncompraDataAccess = newdetallerequisicioncompraDataAccess;
	}
	
	public List<DetalleRequisicionCompra> getDetalleRequisicionCompras() throws Exception {		
		this.quitarDetalleRequisicionComprasNulos();
		
		DetalleRequisicionCompraLogicAdditional.checkDetalleRequisicionCompraToGets(detallerequisicioncompras,this.datosCliente,this.arrDatoGeneral);
		
		for (DetalleRequisicionCompra detallerequisicioncompraLocal: detallerequisicioncompras ) {
			DetalleRequisicionCompraLogicAdditional.updateDetalleRequisicionCompraToGet(detallerequisicioncompraLocal,this.arrDatoGeneral);
		}
		
		return detallerequisicioncompras;
	}
	
	public void setDetalleRequisicionCompras(List<DetalleRequisicionCompra> newDetalleRequisicionCompras) {
		this.detallerequisicioncompras = newDetalleRequisicionCompras;
	}
	
	public Object getDetalleRequisicionCompraObject() {	
		this.detallerequisicioncompraObject=this.detallerequisicioncompraDataAccess.getEntityObject();
		return this.detallerequisicioncompraObject;
	}
		
	public void setDetalleRequisicionCompraObject(Object newDetalleRequisicionCompraObject) {
		this.detallerequisicioncompraObject = newDetalleRequisicionCompraObject;
	}
	
	public List<Object> getDetalleRequisicionComprasObject() {		
		this.detallerequisicioncomprasObject=this.detallerequisicioncompraDataAccess.getEntitiesObject();
		return this.detallerequisicioncomprasObject;
	}
		
	public void setDetalleRequisicionComprasObject(List<Object> newDetalleRequisicionComprasObject) {
		this.detallerequisicioncomprasObject = newDetalleRequisicionComprasObject;
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
		
		if(this.detallerequisicioncompraDataAccess!=null) {
			this.detallerequisicioncompraDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleRequisicionCompra.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			detallerequisicioncompraDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			detallerequisicioncompraDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		detallerequisicioncompra = new  DetalleRequisicionCompra();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleRequisicionCompra.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			detallerequisicioncompra=detallerequisicioncompraDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.detallerequisicioncompra,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				DetalleRequisicionCompraConstantesFunciones.refrescarForeignKeysDescripcionesDetalleRequisicionCompra(this.detallerequisicioncompra);
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
		detallerequisicioncompra = new  DetalleRequisicionCompra();
		  		  
        try {
			
			detallerequisicioncompra=detallerequisicioncompraDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.detallerequisicioncompra,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				DetalleRequisicionCompraConstantesFunciones.refrescarForeignKeysDescripcionesDetalleRequisicionCompra(this.detallerequisicioncompra);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		detallerequisicioncompra = new  DetalleRequisicionCompra();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleRequisicionCompra.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			detallerequisicioncompra=detallerequisicioncompraDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.detallerequisicioncompra,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				DetalleRequisicionCompraConstantesFunciones.refrescarForeignKeysDescripcionesDetalleRequisicionCompra(this.detallerequisicioncompra);
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
		detallerequisicioncompra = new  DetalleRequisicionCompra();
		  		  
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
		detallerequisicioncompra = new  DetalleRequisicionCompra();
		  		  
        try {
			
			detallerequisicioncompra=detallerequisicioncompraDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.detallerequisicioncompra,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				DetalleRequisicionCompraConstantesFunciones.refrescarForeignKeysDescripcionesDetalleRequisicionCompra(this.detallerequisicioncompra);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		detallerequisicioncompra = new  DetalleRequisicionCompra();
		  		  
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
		detallerequisicioncompra = new  DetalleRequisicionCompra();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleRequisicionCompra.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =detallerequisicioncompraDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		detallerequisicioncompra = new  DetalleRequisicionCompra();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=detallerequisicioncompraDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		detallerequisicioncompra = new  DetalleRequisicionCompra();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleRequisicionCompra.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =detallerequisicioncompraDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		detallerequisicioncompra = new  DetalleRequisicionCompra();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=detallerequisicioncompraDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		detallerequisicioncompra = new  DetalleRequisicionCompra();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleRequisicionCompra.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =detallerequisicioncompraDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		detallerequisicioncompra = new  DetalleRequisicionCompra();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=detallerequisicioncompraDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		detallerequisicioncompras = new  ArrayList<DetalleRequisicionCompra>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleRequisicionCompra.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			DetalleRequisicionCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detallerequisicioncompras=detallerequisicioncompraDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarDetalleRequisicionCompra(detallerequisicioncompras);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetalleRequisicionCompraConstantesFunciones.refrescarForeignKeysDescripcionesDetalleRequisicionCompra(this.detallerequisicioncompras);
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
		detallerequisicioncompras = new  ArrayList<DetalleRequisicionCompra>();
		  		  
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
		detallerequisicioncompras = new  ArrayList<DetalleRequisicionCompra>();
		  		  
        try {			
			DetalleRequisicionCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detallerequisicioncompras=detallerequisicioncompraDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarDetalleRequisicionCompra(detallerequisicioncompras);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetalleRequisicionCompraConstantesFunciones.refrescarForeignKeysDescripcionesDetalleRequisicionCompra(this.detallerequisicioncompras);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		detallerequisicioncompras = new  ArrayList<DetalleRequisicionCompra>();
		  		  
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
		detallerequisicioncompras = new  ArrayList<DetalleRequisicionCompra>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleRequisicionCompra.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			DetalleRequisicionCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detallerequisicioncompras=detallerequisicioncompraDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarDetalleRequisicionCompra(detallerequisicioncompras);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetalleRequisicionCompraConstantesFunciones.refrescarForeignKeysDescripcionesDetalleRequisicionCompra(this.detallerequisicioncompras);
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
		detallerequisicioncompras = new  ArrayList<DetalleRequisicionCompra>();
		  		  
        try {
			DetalleRequisicionCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detallerequisicioncompras=detallerequisicioncompraDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarDetalleRequisicionCompra(detallerequisicioncompras);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetalleRequisicionCompraConstantesFunciones.refrescarForeignKeysDescripcionesDetalleRequisicionCompra(this.detallerequisicioncompras);
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
		detallerequisicioncompras = new  ArrayList<DetalleRequisicionCompra>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleRequisicionCompra.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			DetalleRequisicionCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detallerequisicioncompras=detallerequisicioncompraDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarDetalleRequisicionCompra(detallerequisicioncompras);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetalleRequisicionCompraConstantesFunciones.refrescarForeignKeysDescripcionesDetalleRequisicionCompra(this.detallerequisicioncompras);
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
		detallerequisicioncompras = new  ArrayList<DetalleRequisicionCompra>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			DetalleRequisicionCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detallerequisicioncompras=detallerequisicioncompraDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarDetalleRequisicionCompra(detallerequisicioncompras);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetalleRequisicionCompraConstantesFunciones.refrescarForeignKeysDescripcionesDetalleRequisicionCompra(this.detallerequisicioncompras);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		detallerequisicioncompra = new  DetalleRequisicionCompra();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleRequisicionCompra.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			DetalleRequisicionCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detallerequisicioncompra=detallerequisicioncompraDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarDetalleRequisicionCompra(detallerequisicioncompra);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetalleRequisicionCompraConstantesFunciones.refrescarForeignKeysDescripcionesDetalleRequisicionCompra(this.detallerequisicioncompra);
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
		detallerequisicioncompra = new  DetalleRequisicionCompra();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			DetalleRequisicionCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detallerequisicioncompra=detallerequisicioncompraDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarDetalleRequisicionCompra(detallerequisicioncompra);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetalleRequisicionCompraConstantesFunciones.refrescarForeignKeysDescripcionesDetalleRequisicionCompra(this.detallerequisicioncompra);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		detallerequisicioncompras = new  ArrayList<DetalleRequisicionCompra>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleRequisicionCompra.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			DetalleRequisicionCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detallerequisicioncompras=detallerequisicioncompraDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarDetalleRequisicionCompra(detallerequisicioncompras);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetalleRequisicionCompraConstantesFunciones.refrescarForeignKeysDescripcionesDetalleRequisicionCompra(this.detallerequisicioncompras);
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
		detallerequisicioncompras = new  ArrayList<DetalleRequisicionCompra>();
		  		  
        try {
			DetalleRequisicionCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detallerequisicioncompras=detallerequisicioncompraDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarDetalleRequisicionCompra(detallerequisicioncompras);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetalleRequisicionCompraConstantesFunciones.refrescarForeignKeysDescripcionesDetalleRequisicionCompra(this.detallerequisicioncompras);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosDetalleRequisicionComprasWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		detallerequisicioncompras = new  ArrayList<DetalleRequisicionCompra>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleRequisicionCompra.class.getSimpleName()+"-getTodosDetalleRequisicionComprasWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			DetalleRequisicionCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detallerequisicioncompras=detallerequisicioncompraDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarDetalleRequisicionCompra(detallerequisicioncompras);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetalleRequisicionCompraConstantesFunciones.refrescarForeignKeysDescripcionesDetalleRequisicionCompra(this.detallerequisicioncompras);
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
	
	public  void  getTodosDetalleRequisicionCompras(String sFinalQuery,Pagination pagination)throws Exception {
		detallerequisicioncompras = new  ArrayList<DetalleRequisicionCompra>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			DetalleRequisicionCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detallerequisicioncompras=detallerequisicioncompraDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarDetalleRequisicionCompra(detallerequisicioncompras);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetalleRequisicionCompraConstantesFunciones.refrescarForeignKeysDescripcionesDetalleRequisicionCompra(this.detallerequisicioncompras);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarDetalleRequisicionCompra(DetalleRequisicionCompra detallerequisicioncompra) throws Exception {
		Boolean estaValidado=false;
		
		if(detallerequisicioncompra.getIsNew() || detallerequisicioncompra.getIsChanged()) { 
			this.invalidValues = detallerequisicioncompraValidator.getInvalidValues(detallerequisicioncompra);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(detallerequisicioncompra);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarDetalleRequisicionCompra(List<DetalleRequisicionCompra> DetalleRequisicionCompras) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(DetalleRequisicionCompra detallerequisicioncompraLocal:detallerequisicioncompras) {				
			estaValidadoObjeto=this.validarGuardarDetalleRequisicionCompra(detallerequisicioncompraLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarDetalleRequisicionCompra(List<DetalleRequisicionCompra> DetalleRequisicionCompras) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarDetalleRequisicionCompra(detallerequisicioncompras)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarDetalleRequisicionCompra(DetalleRequisicionCompra DetalleRequisicionCompra) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarDetalleRequisicionCompra(detallerequisicioncompra)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(DetalleRequisicionCompra detallerequisicioncompra) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+detallerequisicioncompra.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=DetalleRequisicionCompraConstantesFunciones.getDetalleRequisicionCompraLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"detallerequisicioncompra","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(DetalleRequisicionCompraConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(DetalleRequisicionCompraConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveDetalleRequisicionCompraWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleRequisicionCompra.class.getSimpleName()+"-saveDetalleRequisicionCompraWithConnection");connexion.begin();			
			
			DetalleRequisicionCompraLogicAdditional.checkDetalleRequisicionCompraToSave(this.detallerequisicioncompra,this.datosCliente,connexion,this.arrDatoGeneral);
			
			DetalleRequisicionCompraLogicAdditional.updateDetalleRequisicionCompraToSave(this.detallerequisicioncompra,this.arrDatoGeneral);
			
			DetalleRequisicionCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.detallerequisicioncompra,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowDetalleRequisicionCompra();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarDetalleRequisicionCompra(this.detallerequisicioncompra)) {
				DetalleRequisicionCompraDataAccess.save(this.detallerequisicioncompra, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.detallerequisicioncompra,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			DetalleRequisicionCompraLogicAdditional.checkDetalleRequisicionCompraToSaveAfter(this.detallerequisicioncompra,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowDetalleRequisicionCompra();
			
			connexion.commit();			
			
			if(this.detallerequisicioncompra.getIsDeleted()) {
				this.detallerequisicioncompra=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveDetalleRequisicionCompra()throws Exception {	
		try {	
			
			DetalleRequisicionCompraLogicAdditional.checkDetalleRequisicionCompraToSave(this.detallerequisicioncompra,this.datosCliente,connexion,this.arrDatoGeneral);
			
			DetalleRequisicionCompraLogicAdditional.updateDetalleRequisicionCompraToSave(this.detallerequisicioncompra,this.arrDatoGeneral);
			
			DetalleRequisicionCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.detallerequisicioncompra,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarDetalleRequisicionCompra(this.detallerequisicioncompra)) {			
				DetalleRequisicionCompraDataAccess.save(this.detallerequisicioncompra, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.detallerequisicioncompra,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			DetalleRequisicionCompraLogicAdditional.checkDetalleRequisicionCompraToSaveAfter(this.detallerequisicioncompra,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.detallerequisicioncompra.getIsDeleted()) {
				this.detallerequisicioncompra=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveDetalleRequisicionComprasWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleRequisicionCompra.class.getSimpleName()+"-saveDetalleRequisicionComprasWithConnection");connexion.begin();			
			
			DetalleRequisicionCompraLogicAdditional.checkDetalleRequisicionCompraToSaves(detallerequisicioncompras,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowDetalleRequisicionCompras();
			
			Boolean validadoTodosDetalleRequisicionCompra=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(DetalleRequisicionCompra detallerequisicioncompraLocal:detallerequisicioncompras) {		
				if(detallerequisicioncompraLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				DetalleRequisicionCompraLogicAdditional.updateDetalleRequisicionCompraToSave(detallerequisicioncompraLocal,this.arrDatoGeneral);
	        	
				DetalleRequisicionCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),detallerequisicioncompraLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarDetalleRequisicionCompra(detallerequisicioncompraLocal)) {
					DetalleRequisicionCompraDataAccess.save(detallerequisicioncompraLocal, connexion);				
				} else {
					validadoTodosDetalleRequisicionCompra=false;
				}
			}
			
			if(!validadoTodosDetalleRequisicionCompra) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			DetalleRequisicionCompraLogicAdditional.checkDetalleRequisicionCompraToSavesAfter(detallerequisicioncompras,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowDetalleRequisicionCompras();
			
			connexion.commit();		
			
			this.quitarDetalleRequisicionComprasEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveDetalleRequisicionCompras()throws Exception {				
		 try {	
			DetalleRequisicionCompraLogicAdditional.checkDetalleRequisicionCompraToSaves(detallerequisicioncompras,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosDetalleRequisicionCompra=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(DetalleRequisicionCompra detallerequisicioncompraLocal:detallerequisicioncompras) {				
				if(detallerequisicioncompraLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				DetalleRequisicionCompraLogicAdditional.updateDetalleRequisicionCompraToSave(detallerequisicioncompraLocal,this.arrDatoGeneral);
	        	
				DetalleRequisicionCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),detallerequisicioncompraLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarDetalleRequisicionCompra(detallerequisicioncompraLocal)) {				
					DetalleRequisicionCompraDataAccess.save(detallerequisicioncompraLocal, connexion);				
				} else {
					validadoTodosDetalleRequisicionCompra=false;
				}
			}
			
			if(!validadoTodosDetalleRequisicionCompra) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			DetalleRequisicionCompraLogicAdditional.checkDetalleRequisicionCompraToSavesAfter(detallerequisicioncompras,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarDetalleRequisicionComprasEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public DetalleRequisicionCompraParameterReturnGeneral procesarAccionDetalleRequisicionCompras(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<DetalleRequisicionCompra> detallerequisicioncompras,DetalleRequisicionCompraParameterReturnGeneral detallerequisicioncompraParameterGeneral)throws Exception {
		 try {	
			DetalleRequisicionCompraParameterReturnGeneral detallerequisicioncompraReturnGeneral=new DetalleRequisicionCompraParameterReturnGeneral();
	
			DetalleRequisicionCompraLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,detallerequisicioncompras,detallerequisicioncompraParameterGeneral,detallerequisicioncompraReturnGeneral);
			
			return detallerequisicioncompraReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public DetalleRequisicionCompraParameterReturnGeneral procesarAccionDetalleRequisicionComprasWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<DetalleRequisicionCompra> detallerequisicioncompras,DetalleRequisicionCompraParameterReturnGeneral detallerequisicioncompraParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleRequisicionCompra.class.getSimpleName()+"-procesarAccionDetalleRequisicionComprasWithConnection");connexion.begin();			
			
			DetalleRequisicionCompraParameterReturnGeneral detallerequisicioncompraReturnGeneral=new DetalleRequisicionCompraParameterReturnGeneral();
	
			DetalleRequisicionCompraLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,detallerequisicioncompras,detallerequisicioncompraParameterGeneral,detallerequisicioncompraReturnGeneral);
			
			this.connexion.commit();
			
			return detallerequisicioncompraReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public DetalleRequisicionCompraParameterReturnGeneral procesarEventosDetalleRequisicionCompras(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<DetalleRequisicionCompra> detallerequisicioncompras,DetalleRequisicionCompra detallerequisicioncompra,DetalleRequisicionCompraParameterReturnGeneral detallerequisicioncompraParameterGeneral,Boolean isEsNuevoDetalleRequisicionCompra,ArrayList<Classe> clases)throws Exception {
		 try {	
			DetalleRequisicionCompraParameterReturnGeneral detallerequisicioncompraReturnGeneral=new DetalleRequisicionCompraParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				detallerequisicioncompraReturnGeneral.setConRecargarPropiedades(true);
			}
			
			DetalleRequisicionCompraLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,detallerequisicioncompras,detallerequisicioncompra,detallerequisicioncompraParameterGeneral,detallerequisicioncompraReturnGeneral,isEsNuevoDetalleRequisicionCompra,clases);
			
			return detallerequisicioncompraReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public DetalleRequisicionCompraParameterReturnGeneral procesarEventosDetalleRequisicionComprasWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<DetalleRequisicionCompra> detallerequisicioncompras,DetalleRequisicionCompra detallerequisicioncompra,DetalleRequisicionCompraParameterReturnGeneral detallerequisicioncompraParameterGeneral,Boolean isEsNuevoDetalleRequisicionCompra,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleRequisicionCompra.class.getSimpleName()+"-procesarEventosDetalleRequisicionComprasWithConnection");connexion.begin();			
			
			DetalleRequisicionCompraParameterReturnGeneral detallerequisicioncompraReturnGeneral=new DetalleRequisicionCompraParameterReturnGeneral();
	
			detallerequisicioncompraReturnGeneral.setDetalleRequisicionCompra(detallerequisicioncompra);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				detallerequisicioncompraReturnGeneral.setConRecargarPropiedades(true);
			}
			
			DetalleRequisicionCompraLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,detallerequisicioncompras,detallerequisicioncompra,detallerequisicioncompraParameterGeneral,detallerequisicioncompraReturnGeneral,isEsNuevoDetalleRequisicionCompra,clases);
			
			this.connexion.commit();
			
			return detallerequisicioncompraReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public DetalleRequisicionCompraParameterReturnGeneral procesarImportacionDetalleRequisicionComprasWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,DetalleRequisicionCompraParameterReturnGeneral detallerequisicioncompraParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleRequisicionCompra.class.getSimpleName()+"-procesarImportacionDetalleRequisicionComprasWithConnection");connexion.begin();			
			
			DetalleRequisicionCompraParameterReturnGeneral detallerequisicioncompraReturnGeneral=new DetalleRequisicionCompraParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.detallerequisicioncompras=new ArrayList<DetalleRequisicionCompra>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.detallerequisicioncompra=new DetalleRequisicionCompra();
				
				
				if(conColumnasBase) {this.detallerequisicioncompra.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.detallerequisicioncompra.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.detallerequisicioncompra.setcantidad_requisicion(Integer.parseInt(arrColumnas[iColumn++]));
				this.detallerequisicioncompra.setcosto_unitario(Double.parseDouble(arrColumnas[iColumn++]));
				this.detallerequisicioncompra.setcosto_total(Double.parseDouble(arrColumnas[iColumn++]));
				this.detallerequisicioncompra.setdescripcion(arrColumnas[iColumn++]);
				this.detallerequisicioncompra.setcantidad_entregada(Integer.parseInt(arrColumnas[iColumn++]));
				this.detallerequisicioncompra.setcantidad_pendiente(Integer.parseInt(arrColumnas[iColumn++]));
				
				this.detallerequisicioncompras.add(this.detallerequisicioncompra);
			}
			
			this.saveDetalleRequisicionCompras();
			
			this.connexion.commit();
			
			detallerequisicioncompraReturnGeneral.setConRetornoEstaProcesado(true);
			detallerequisicioncompraReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return detallerequisicioncompraReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarDetalleRequisicionComprasEliminados() throws Exception {				
		
		List<DetalleRequisicionCompra> detallerequisicioncomprasAux= new ArrayList<DetalleRequisicionCompra>();
		
		for(DetalleRequisicionCompra detallerequisicioncompra:detallerequisicioncompras) {
			if(!detallerequisicioncompra.getIsDeleted()) {
				detallerequisicioncomprasAux.add(detallerequisicioncompra);
			}
		}
		
		detallerequisicioncompras=detallerequisicioncomprasAux;
	}
	
	public void quitarDetalleRequisicionComprasNulos() throws Exception {				
		
		List<DetalleRequisicionCompra> detallerequisicioncomprasAux= new ArrayList<DetalleRequisicionCompra>();
		
		for(DetalleRequisicionCompra detallerequisicioncompra : this.detallerequisicioncompras) {
			if(detallerequisicioncompra==null) {
				detallerequisicioncomprasAux.add(detallerequisicioncompra);
			}
		}
		
		//this.detallerequisicioncompras=detallerequisicioncomprasAux;
		
		this.detallerequisicioncompras.removeAll(detallerequisicioncomprasAux);
	}
	
	public void getSetVersionRowDetalleRequisicionCompraWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(detallerequisicioncompra.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((detallerequisicioncompra.getIsDeleted() || (detallerequisicioncompra.getIsChanged()&&!detallerequisicioncompra.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=detallerequisicioncompraDataAccess.getSetVersionRowDetalleRequisicionCompra(connexion,detallerequisicioncompra.getId());
				
				if(!detallerequisicioncompra.getVersionRow().equals(timestamp)) {	
					detallerequisicioncompra.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				detallerequisicioncompra.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowDetalleRequisicionCompra()throws Exception {	
		
		if(detallerequisicioncompra.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((detallerequisicioncompra.getIsDeleted() || (detallerequisicioncompra.getIsChanged()&&!detallerequisicioncompra.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=detallerequisicioncompraDataAccess.getSetVersionRowDetalleRequisicionCompra(connexion,detallerequisicioncompra.getId());
			
			try {							
				if(!detallerequisicioncompra.getVersionRow().equals(timestamp)) {	
					detallerequisicioncompra.setVersionRow(timestamp);
				}
				
				detallerequisicioncompra.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowDetalleRequisicionComprasWithConnection()throws Exception {	
		if(detallerequisicioncompras!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(DetalleRequisicionCompra detallerequisicioncompraAux:detallerequisicioncompras) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(detallerequisicioncompraAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(detallerequisicioncompraAux.getIsDeleted() || (detallerequisicioncompraAux.getIsChanged()&&!detallerequisicioncompraAux.getIsNew())) {
						
						timestamp=detallerequisicioncompraDataAccess.getSetVersionRowDetalleRequisicionCompra(connexion,detallerequisicioncompraAux.getId());
						
						if(!detallerequisicioncompra.getVersionRow().equals(timestamp)) {	
							detallerequisicioncompraAux.setVersionRow(timestamp);
						}
								
						detallerequisicioncompraAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowDetalleRequisicionCompras()throws Exception {	
		if(detallerequisicioncompras!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(DetalleRequisicionCompra detallerequisicioncompraAux:detallerequisicioncompras) {
					if(detallerequisicioncompraAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(detallerequisicioncompraAux.getIsDeleted() || (detallerequisicioncompraAux.getIsChanged()&&!detallerequisicioncompraAux.getIsNew())) {
						
						timestamp=detallerequisicioncompraDataAccess.getSetVersionRowDetalleRequisicionCompra(connexion,detallerequisicioncompraAux.getId());
						
						if(!detallerequisicioncompraAux.getVersionRow().equals(timestamp)) {	
							detallerequisicioncompraAux.setVersionRow(timestamp);
						}
						
													
						detallerequisicioncompraAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public DetalleRequisicionCompraParameterReturnGeneral cargarCombosLoteForeignKeyDetalleRequisicionCompraWithConnection(String finalQueryGlobalRequisicionCompra,String finalQueryGlobalEmpresa,String finalQueryGlobalSucursal,String finalQueryGlobalEjercicio,String finalQueryGlobalPeriodo,String finalQueryGlobalAnio,String finalQueryGlobalMes,String finalQueryGlobalBodega,String finalQueryGlobalProducto,String finalQueryGlobalUnidad,String finalQueryGlobalCentroCosto) throws Exception {
		DetalleRequisicionCompraParameterReturnGeneral  detallerequisicioncompraReturnGeneral =new DetalleRequisicionCompraParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleRequisicionCompra.class.getSimpleName()+"-cargarCombosLoteForeignKeyDetalleRequisicionCompraWithConnection");connexion.begin();
			
			detallerequisicioncompraReturnGeneral =new DetalleRequisicionCompraParameterReturnGeneral();
			
			

			List<RequisicionCompra> requisicioncomprasForeignKey=new ArrayList<RequisicionCompra>();
			RequisicionCompraLogic requisicioncompraLogic=new RequisicionCompraLogic();
			requisicioncompraLogic.setConnexion(this.connexion);
			requisicioncompraLogic.getRequisicionCompraDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalRequisicionCompra.equals("NONE")) {
				requisicioncompraLogic.getTodosRequisicionCompras(finalQueryGlobalRequisicionCompra,new Pagination());
				requisicioncomprasForeignKey=requisicioncompraLogic.getRequisicionCompras();
			}

			detallerequisicioncompraReturnGeneral.setrequisicioncomprasForeignKey(requisicioncomprasForeignKey);


			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			detallerequisicioncompraReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Sucursal> sucursalsForeignKey=new ArrayList<Sucursal>();
			SucursalLogic sucursalLogic=new SucursalLogic();
			sucursalLogic.setConnexion(this.connexion);
			//sucursalLogic.getSucursalDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalSucursal.equals("NONE")) {
				sucursalLogic.getTodosSucursals(finalQueryGlobalSucursal,new Pagination());
				sucursalsForeignKey=sucursalLogic.getSucursals();
			}

			detallerequisicioncompraReturnGeneral.setsucursalsForeignKey(sucursalsForeignKey);


			List<Ejercicio> ejerciciosForeignKey=new ArrayList<Ejercicio>();
			EjercicioLogic ejercicioLogic=new EjercicioLogic();
			ejercicioLogic.setConnexion(this.connexion);
			//ejercicioLogic.getEjercicioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEjercicio.equals("NONE")) {
				ejercicioLogic.getTodosEjercicios(finalQueryGlobalEjercicio,new Pagination());
				ejerciciosForeignKey=ejercicioLogic.getEjercicios();
			}

			detallerequisicioncompraReturnGeneral.setejerciciosForeignKey(ejerciciosForeignKey);


			List<Periodo> periodosForeignKey=new ArrayList<Periodo>();
			PeriodoLogic periodoLogic=new PeriodoLogic();
			periodoLogic.setConnexion(this.connexion);
			//periodoLogic.getPeriodoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalPeriodo.equals("NONE")) {
				periodoLogic.getTodosPeriodos(finalQueryGlobalPeriodo,new Pagination());
				periodosForeignKey=periodoLogic.getPeriodos();
			}

			detallerequisicioncompraReturnGeneral.setperiodosForeignKey(periodosForeignKey);


			List<Anio> aniosForeignKey=new ArrayList<Anio>();
			AnioLogic anioLogic=new AnioLogic();
			anioLogic.setConnexion(this.connexion);
			anioLogic.getAnioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalAnio.equals("NONE")) {
				anioLogic.getTodosAnios(finalQueryGlobalAnio,new Pagination());
				aniosForeignKey=anioLogic.getAnios();
			}

			detallerequisicioncompraReturnGeneral.setaniosForeignKey(aniosForeignKey);


			List<Mes> messForeignKey=new ArrayList<Mes>();
			MesLogic mesLogic=new MesLogic();
			mesLogic.setConnexion(this.connexion);
			mesLogic.getMesDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalMes.equals("NONE")) {
				mesLogic.getTodosMess(finalQueryGlobalMes,new Pagination());
				messForeignKey=mesLogic.getMess();
			}

			detallerequisicioncompraReturnGeneral.setmessForeignKey(messForeignKey);


			List<Bodega> bodegasForeignKey=new ArrayList<Bodega>();
			BodegaLogic bodegaLogic=new BodegaLogic();
			bodegaLogic.setConnexion(this.connexion);
			bodegaLogic.getBodegaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalBodega.equals("NONE")) {
				bodegaLogic.getTodosBodegas(finalQueryGlobalBodega,new Pagination());
				bodegasForeignKey=bodegaLogic.getBodegas();
			}

			detallerequisicioncompraReturnGeneral.setbodegasForeignKey(bodegasForeignKey);


			List<Producto> productosForeignKey=new ArrayList<Producto>();
			ProductoLogic productoLogic=new ProductoLogic();
			productoLogic.setConnexion(this.connexion);
			//productoLogic.getProductoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalProducto.equals("NONE")) {
				productoLogic.getTodosProductos(finalQueryGlobalProducto,new Pagination());
				productosForeignKey=productoLogic.getProductos();
			}

			detallerequisicioncompraReturnGeneral.setproductosForeignKey(productosForeignKey);


			List<Unidad> unidadsForeignKey=new ArrayList<Unidad>();
			UnidadLogic unidadLogic=new UnidadLogic();
			unidadLogic.setConnexion(this.connexion);
			unidadLogic.getUnidadDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalUnidad.equals("NONE")) {
				unidadLogic.getTodosUnidads(finalQueryGlobalUnidad,new Pagination());
				unidadsForeignKey=unidadLogic.getUnidads();
			}

			detallerequisicioncompraReturnGeneral.setunidadsForeignKey(unidadsForeignKey);


			List<CentroCosto> centrocostosForeignKey=new ArrayList<CentroCosto>();
			CentroCostoLogic centrocostoLogic=new CentroCostoLogic();
			centrocostoLogic.setConnexion(this.connexion);
			centrocostoLogic.getCentroCostoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCentroCosto.equals("NONE")) {
				centrocostoLogic.getTodosCentroCostos(finalQueryGlobalCentroCosto,new Pagination());
				centrocostosForeignKey=centrocostoLogic.getCentroCostos();
			}

			detallerequisicioncompraReturnGeneral.setcentrocostosForeignKey(centrocostosForeignKey);

			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
		
		return detallerequisicioncompraReturnGeneral;
	}
	
	public DetalleRequisicionCompraParameterReturnGeneral cargarCombosLoteForeignKeyDetalleRequisicionCompra(String finalQueryGlobalRequisicionCompra,String finalQueryGlobalEmpresa,String finalQueryGlobalSucursal,String finalQueryGlobalEjercicio,String finalQueryGlobalPeriodo,String finalQueryGlobalAnio,String finalQueryGlobalMes,String finalQueryGlobalBodega,String finalQueryGlobalProducto,String finalQueryGlobalUnidad,String finalQueryGlobalCentroCosto) throws Exception {
		DetalleRequisicionCompraParameterReturnGeneral  detallerequisicioncompraReturnGeneral =new DetalleRequisicionCompraParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {						
			detallerequisicioncompraReturnGeneral =new DetalleRequisicionCompraParameterReturnGeneral();
			
			

			List<RequisicionCompra> requisicioncomprasForeignKey=new ArrayList<RequisicionCompra>();
			RequisicionCompraLogic requisicioncompraLogic=new RequisicionCompraLogic();
			requisicioncompraLogic.setConnexion(this.connexion);
			requisicioncompraLogic.getRequisicionCompraDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalRequisicionCompra.equals("NONE")) {
				requisicioncompraLogic.getTodosRequisicionCompras(finalQueryGlobalRequisicionCompra,new Pagination());
				requisicioncomprasForeignKey=requisicioncompraLogic.getRequisicionCompras();
			}

			detallerequisicioncompraReturnGeneral.setrequisicioncomprasForeignKey(requisicioncomprasForeignKey);


			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			detallerequisicioncompraReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Sucursal> sucursalsForeignKey=new ArrayList<Sucursal>();
			SucursalLogic sucursalLogic=new SucursalLogic();
			sucursalLogic.setConnexion(this.connexion);
			//sucursalLogic.getSucursalDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalSucursal.equals("NONE")) {
				sucursalLogic.getTodosSucursals(finalQueryGlobalSucursal,new Pagination());
				sucursalsForeignKey=sucursalLogic.getSucursals();
			}

			detallerequisicioncompraReturnGeneral.setsucursalsForeignKey(sucursalsForeignKey);


			List<Ejercicio> ejerciciosForeignKey=new ArrayList<Ejercicio>();
			EjercicioLogic ejercicioLogic=new EjercicioLogic();
			ejercicioLogic.setConnexion(this.connexion);
			//ejercicioLogic.getEjercicioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEjercicio.equals("NONE")) {
				ejercicioLogic.getTodosEjercicios(finalQueryGlobalEjercicio,new Pagination());
				ejerciciosForeignKey=ejercicioLogic.getEjercicios();
			}

			detallerequisicioncompraReturnGeneral.setejerciciosForeignKey(ejerciciosForeignKey);


			List<Periodo> periodosForeignKey=new ArrayList<Periodo>();
			PeriodoLogic periodoLogic=new PeriodoLogic();
			periodoLogic.setConnexion(this.connexion);
			//periodoLogic.getPeriodoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalPeriodo.equals("NONE")) {
				periodoLogic.getTodosPeriodos(finalQueryGlobalPeriodo,new Pagination());
				periodosForeignKey=periodoLogic.getPeriodos();
			}

			detallerequisicioncompraReturnGeneral.setperiodosForeignKey(periodosForeignKey);


			List<Anio> aniosForeignKey=new ArrayList<Anio>();
			AnioLogic anioLogic=new AnioLogic();
			anioLogic.setConnexion(this.connexion);
			anioLogic.getAnioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalAnio.equals("NONE")) {
				anioLogic.getTodosAnios(finalQueryGlobalAnio,new Pagination());
				aniosForeignKey=anioLogic.getAnios();
			}

			detallerequisicioncompraReturnGeneral.setaniosForeignKey(aniosForeignKey);


			List<Mes> messForeignKey=new ArrayList<Mes>();
			MesLogic mesLogic=new MesLogic();
			mesLogic.setConnexion(this.connexion);
			mesLogic.getMesDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalMes.equals("NONE")) {
				mesLogic.getTodosMess(finalQueryGlobalMes,new Pagination());
				messForeignKey=mesLogic.getMess();
			}

			detallerequisicioncompraReturnGeneral.setmessForeignKey(messForeignKey);


			List<Bodega> bodegasForeignKey=new ArrayList<Bodega>();
			BodegaLogic bodegaLogic=new BodegaLogic();
			bodegaLogic.setConnexion(this.connexion);
			bodegaLogic.getBodegaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalBodega.equals("NONE")) {
				bodegaLogic.getTodosBodegas(finalQueryGlobalBodega,new Pagination());
				bodegasForeignKey=bodegaLogic.getBodegas();
			}

			detallerequisicioncompraReturnGeneral.setbodegasForeignKey(bodegasForeignKey);


			List<Producto> productosForeignKey=new ArrayList<Producto>();
			ProductoLogic productoLogic=new ProductoLogic();
			productoLogic.setConnexion(this.connexion);
			//productoLogic.getProductoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalProducto.equals("NONE")) {
				productoLogic.getTodosProductos(finalQueryGlobalProducto,new Pagination());
				productosForeignKey=productoLogic.getProductos();
			}

			detallerequisicioncompraReturnGeneral.setproductosForeignKey(productosForeignKey);


			List<Unidad> unidadsForeignKey=new ArrayList<Unidad>();
			UnidadLogic unidadLogic=new UnidadLogic();
			unidadLogic.setConnexion(this.connexion);
			unidadLogic.getUnidadDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalUnidad.equals("NONE")) {
				unidadLogic.getTodosUnidads(finalQueryGlobalUnidad,new Pagination());
				unidadsForeignKey=unidadLogic.getUnidads();
			}

			detallerequisicioncompraReturnGeneral.setunidadsForeignKey(unidadsForeignKey);


			List<CentroCosto> centrocostosForeignKey=new ArrayList<CentroCosto>();
			CentroCostoLogic centrocostoLogic=new CentroCostoLogic();
			centrocostoLogic.setConnexion(this.connexion);
			centrocostoLogic.getCentroCostoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCentroCosto.equals("NONE")) {
				centrocostoLogic.getTodosCentroCostos(finalQueryGlobalCentroCosto,new Pagination());
				centrocostosForeignKey=centrocostoLogic.getCentroCostos();
			}

			detallerequisicioncompraReturnGeneral.setcentrocostosForeignKey(centrocostosForeignKey);
						
			
		} catch(Exception e) {			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			
		}
		
		return detallerequisicioncompraReturnGeneral;
	}
	
	
	public void deepLoad(DetalleRequisicionCompra detallerequisicioncompra,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			DetalleRequisicionCompraLogicAdditional.updateDetalleRequisicionCompraToGet(detallerequisicioncompra,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		detallerequisicioncompra.setRequisicionCompra(detallerequisicioncompraDataAccess.getRequisicionCompra(connexion,detallerequisicioncompra));
		detallerequisicioncompra.setEmpresa(detallerequisicioncompraDataAccess.getEmpresa(connexion,detallerequisicioncompra));
		detallerequisicioncompra.setSucursal(detallerequisicioncompraDataAccess.getSucursal(connexion,detallerequisicioncompra));
		detallerequisicioncompra.setEjercicio(detallerequisicioncompraDataAccess.getEjercicio(connexion,detallerequisicioncompra));
		detallerequisicioncompra.setPeriodo(detallerequisicioncompraDataAccess.getPeriodo(connexion,detallerequisicioncompra));
		detallerequisicioncompra.setAnio(detallerequisicioncompraDataAccess.getAnio(connexion,detallerequisicioncompra));
		detallerequisicioncompra.setMes(detallerequisicioncompraDataAccess.getMes(connexion,detallerequisicioncompra));
		detallerequisicioncompra.setBodega(detallerequisicioncompraDataAccess.getBodega(connexion,detallerequisicioncompra));
		detallerequisicioncompra.setProducto(detallerequisicioncompraDataAccess.getProducto(connexion,detallerequisicioncompra));
		detallerequisicioncompra.setUnidad(detallerequisicioncompraDataAccess.getUnidad(connexion,detallerequisicioncompra));
		detallerequisicioncompra.setCentroCosto(detallerequisicioncompraDataAccess.getCentroCosto(connexion,detallerequisicioncompra));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(RequisicionCompra.class)) {
				detallerequisicioncompra.setRequisicionCompra(detallerequisicioncompraDataAccess.getRequisicionCompra(connexion,detallerequisicioncompra));
				continue;
			}

			if(clas.clas.equals(Empresa.class)) {
				detallerequisicioncompra.setEmpresa(detallerequisicioncompraDataAccess.getEmpresa(connexion,detallerequisicioncompra));
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				detallerequisicioncompra.setSucursal(detallerequisicioncompraDataAccess.getSucursal(connexion,detallerequisicioncompra));
				continue;
			}

			if(clas.clas.equals(Ejercicio.class)) {
				detallerequisicioncompra.setEjercicio(detallerequisicioncompraDataAccess.getEjercicio(connexion,detallerequisicioncompra));
				continue;
			}

			if(clas.clas.equals(Periodo.class)) {
				detallerequisicioncompra.setPeriodo(detallerequisicioncompraDataAccess.getPeriodo(connexion,detallerequisicioncompra));
				continue;
			}

			if(clas.clas.equals(Anio.class)) {
				detallerequisicioncompra.setAnio(detallerequisicioncompraDataAccess.getAnio(connexion,detallerequisicioncompra));
				continue;
			}

			if(clas.clas.equals(Mes.class)) {
				detallerequisicioncompra.setMes(detallerequisicioncompraDataAccess.getMes(connexion,detallerequisicioncompra));
				continue;
			}

			if(clas.clas.equals(Bodega.class)) {
				detallerequisicioncompra.setBodega(detallerequisicioncompraDataAccess.getBodega(connexion,detallerequisicioncompra));
				continue;
			}

			if(clas.clas.equals(Producto.class)) {
				detallerequisicioncompra.setProducto(detallerequisicioncompraDataAccess.getProducto(connexion,detallerequisicioncompra));
				continue;
			}

			if(clas.clas.equals(Unidad.class)) {
				detallerequisicioncompra.setUnidad(detallerequisicioncompraDataAccess.getUnidad(connexion,detallerequisicioncompra));
				continue;
			}

			if(clas.clas.equals(CentroCosto.class)) {
				detallerequisicioncompra.setCentroCosto(detallerequisicioncompraDataAccess.getCentroCosto(connexion,detallerequisicioncompra));
				continue;
			}
		}
	}
	else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(RequisicionCompra.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detallerequisicioncompra.setRequisicionCompra(detallerequisicioncompraDataAccess.getRequisicionCompra(connexion,detallerequisicioncompra));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detallerequisicioncompra.setEmpresa(detallerequisicioncompraDataAccess.getEmpresa(connexion,detallerequisicioncompra));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detallerequisicioncompra.setSucursal(detallerequisicioncompraDataAccess.getSucursal(connexion,detallerequisicioncompra));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Ejercicio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detallerequisicioncompra.setEjercicio(detallerequisicioncompraDataAccess.getEjercicio(connexion,detallerequisicioncompra));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Periodo.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detallerequisicioncompra.setPeriodo(detallerequisicioncompraDataAccess.getPeriodo(connexion,detallerequisicioncompra));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Anio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detallerequisicioncompra.setAnio(detallerequisicioncompraDataAccess.getAnio(connexion,detallerequisicioncompra));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Mes.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detallerequisicioncompra.setMes(detallerequisicioncompraDataAccess.getMes(connexion,detallerequisicioncompra));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Bodega.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detallerequisicioncompra.setBodega(detallerequisicioncompraDataAccess.getBodega(connexion,detallerequisicioncompra));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Producto.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detallerequisicioncompra.setProducto(detallerequisicioncompraDataAccess.getProducto(connexion,detallerequisicioncompra));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Unidad.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detallerequisicioncompra.setUnidad(detallerequisicioncompraDataAccess.getUnidad(connexion,detallerequisicioncompra));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(CentroCosto.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detallerequisicioncompra.setCentroCosto(detallerequisicioncompraDataAccess.getCentroCosto(connexion,detallerequisicioncompra));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		detallerequisicioncompra.setRequisicionCompra(detallerequisicioncompraDataAccess.getRequisicionCompra(connexion,detallerequisicioncompra));
		RequisicionCompraLogic requisicioncompraLogic= new RequisicionCompraLogic(connexion);
		requisicioncompraLogic.deepLoad(detallerequisicioncompra.getRequisicionCompra(),isDeep,deepLoadType,clases);
				
		detallerequisicioncompra.setEmpresa(detallerequisicioncompraDataAccess.getEmpresa(connexion,detallerequisicioncompra));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(detallerequisicioncompra.getEmpresa(),isDeep,deepLoadType,clases);
				
		detallerequisicioncompra.setSucursal(detallerequisicioncompraDataAccess.getSucursal(connexion,detallerequisicioncompra));
		SucursalLogic sucursalLogic= new SucursalLogic(connexion);
		sucursalLogic.deepLoad(detallerequisicioncompra.getSucursal(),isDeep,deepLoadType,clases);
				
		detallerequisicioncompra.setEjercicio(detallerequisicioncompraDataAccess.getEjercicio(connexion,detallerequisicioncompra));
		EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
		ejercicioLogic.deepLoad(detallerequisicioncompra.getEjercicio(),isDeep,deepLoadType,clases);
				
		detallerequisicioncompra.setPeriodo(detallerequisicioncompraDataAccess.getPeriodo(connexion,detallerequisicioncompra));
		PeriodoLogic periodoLogic= new PeriodoLogic(connexion);
		periodoLogic.deepLoad(detallerequisicioncompra.getPeriodo(),isDeep,deepLoadType,clases);
				
		detallerequisicioncompra.setAnio(detallerequisicioncompraDataAccess.getAnio(connexion,detallerequisicioncompra));
		AnioLogic anioLogic= new AnioLogic(connexion);
		anioLogic.deepLoad(detallerequisicioncompra.getAnio(),isDeep,deepLoadType,clases);
				
		detallerequisicioncompra.setMes(detallerequisicioncompraDataAccess.getMes(connexion,detallerequisicioncompra));
		MesLogic mesLogic= new MesLogic(connexion);
		mesLogic.deepLoad(detallerequisicioncompra.getMes(),isDeep,deepLoadType,clases);
				
		detallerequisicioncompra.setBodega(detallerequisicioncompraDataAccess.getBodega(connexion,detallerequisicioncompra));
		BodegaLogic bodegaLogic= new BodegaLogic(connexion);
		bodegaLogic.deepLoad(detallerequisicioncompra.getBodega(),isDeep,deepLoadType,clases);
				
		detallerequisicioncompra.setProducto(detallerequisicioncompraDataAccess.getProducto(connexion,detallerequisicioncompra));
		ProductoLogic productoLogic= new ProductoLogic(connexion);
		productoLogic.deepLoad(detallerequisicioncompra.getProducto(),isDeep,deepLoadType,clases);
				
		detallerequisicioncompra.setUnidad(detallerequisicioncompraDataAccess.getUnidad(connexion,detallerequisicioncompra));
		UnidadLogic unidadLogic= new UnidadLogic(connexion);
		unidadLogic.deepLoad(detallerequisicioncompra.getUnidad(),isDeep,deepLoadType,clases);
				
		detallerequisicioncompra.setCentroCosto(detallerequisicioncompraDataAccess.getCentroCosto(connexion,detallerequisicioncompra));
		CentroCostoLogic centrocostoLogic= new CentroCostoLogic(connexion);
		centrocostoLogic.deepLoad(detallerequisicioncompra.getCentroCosto(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(RequisicionCompra.class)) {
				detallerequisicioncompra.setRequisicionCompra(detallerequisicioncompraDataAccess.getRequisicionCompra(connexion,detallerequisicioncompra));
				RequisicionCompraLogic requisicioncompraLogic= new RequisicionCompraLogic(connexion);
				requisicioncompraLogic.deepLoad(detallerequisicioncompra.getRequisicionCompra(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Empresa.class)) {
				detallerequisicioncompra.setEmpresa(detallerequisicioncompraDataAccess.getEmpresa(connexion,detallerequisicioncompra));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(detallerequisicioncompra.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				detallerequisicioncompra.setSucursal(detallerequisicioncompraDataAccess.getSucursal(connexion,detallerequisicioncompra));
				SucursalLogic sucursalLogic= new SucursalLogic(connexion);
				sucursalLogic.deepLoad(detallerequisicioncompra.getSucursal(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Ejercicio.class)) {
				detallerequisicioncompra.setEjercicio(detallerequisicioncompraDataAccess.getEjercicio(connexion,detallerequisicioncompra));
				EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
				ejercicioLogic.deepLoad(detallerequisicioncompra.getEjercicio(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Periodo.class)) {
				detallerequisicioncompra.setPeriodo(detallerequisicioncompraDataAccess.getPeriodo(connexion,detallerequisicioncompra));
				PeriodoLogic periodoLogic= new PeriodoLogic(connexion);
				periodoLogic.deepLoad(detallerequisicioncompra.getPeriodo(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Anio.class)) {
				detallerequisicioncompra.setAnio(detallerequisicioncompraDataAccess.getAnio(connexion,detallerequisicioncompra));
				AnioLogic anioLogic= new AnioLogic(connexion);
				anioLogic.deepLoad(detallerequisicioncompra.getAnio(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Mes.class)) {
				detallerequisicioncompra.setMes(detallerequisicioncompraDataAccess.getMes(connexion,detallerequisicioncompra));
				MesLogic mesLogic= new MesLogic(connexion);
				mesLogic.deepLoad(detallerequisicioncompra.getMes(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Bodega.class)) {
				detallerequisicioncompra.setBodega(detallerequisicioncompraDataAccess.getBodega(connexion,detallerequisicioncompra));
				BodegaLogic bodegaLogic= new BodegaLogic(connexion);
				bodegaLogic.deepLoad(detallerequisicioncompra.getBodega(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Producto.class)) {
				detallerequisicioncompra.setProducto(detallerequisicioncompraDataAccess.getProducto(connexion,detallerequisicioncompra));
				ProductoLogic productoLogic= new ProductoLogic(connexion);
				productoLogic.deepLoad(detallerequisicioncompra.getProducto(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Unidad.class)) {
				detallerequisicioncompra.setUnidad(detallerequisicioncompraDataAccess.getUnidad(connexion,detallerequisicioncompra));
				UnidadLogic unidadLogic= new UnidadLogic(connexion);
				unidadLogic.deepLoad(detallerequisicioncompra.getUnidad(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(CentroCosto.class)) {
				detallerequisicioncompra.setCentroCosto(detallerequisicioncompraDataAccess.getCentroCosto(connexion,detallerequisicioncompra));
				CentroCostoLogic centrocostoLogic= new CentroCostoLogic(connexion);
				centrocostoLogic.deepLoad(detallerequisicioncompra.getCentroCosto(),isDeep,deepLoadType,clases);				
				continue;
			}

		}
	}
	else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {


		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(RequisicionCompra.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detallerequisicioncompra.setRequisicionCompra(detallerequisicioncompraDataAccess.getRequisicionCompra(connexion,detallerequisicioncompra));
			RequisicionCompraLogic requisicioncompraLogic= new RequisicionCompraLogic(connexion);
			requisicioncompraLogic.deepLoad(detallerequisicioncompra.getRequisicionCompra(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detallerequisicioncompra.setEmpresa(detallerequisicioncompraDataAccess.getEmpresa(connexion,detallerequisicioncompra));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(detallerequisicioncompra.getEmpresa(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detallerequisicioncompra.setSucursal(detallerequisicioncompraDataAccess.getSucursal(connexion,detallerequisicioncompra));
			SucursalLogic sucursalLogic= new SucursalLogic(connexion);
			sucursalLogic.deepLoad(detallerequisicioncompra.getSucursal(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Ejercicio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detallerequisicioncompra.setEjercicio(detallerequisicioncompraDataAccess.getEjercicio(connexion,detallerequisicioncompra));
			EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
			ejercicioLogic.deepLoad(detallerequisicioncompra.getEjercicio(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Periodo.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detallerequisicioncompra.setPeriodo(detallerequisicioncompraDataAccess.getPeriodo(connexion,detallerequisicioncompra));
			PeriodoLogic periodoLogic= new PeriodoLogic(connexion);
			periodoLogic.deepLoad(detallerequisicioncompra.getPeriodo(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Anio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detallerequisicioncompra.setAnio(detallerequisicioncompraDataAccess.getAnio(connexion,detallerequisicioncompra));
			AnioLogic anioLogic= new AnioLogic(connexion);
			anioLogic.deepLoad(detallerequisicioncompra.getAnio(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Mes.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detallerequisicioncompra.setMes(detallerequisicioncompraDataAccess.getMes(connexion,detallerequisicioncompra));
			MesLogic mesLogic= new MesLogic(connexion);
			mesLogic.deepLoad(detallerequisicioncompra.getMes(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Bodega.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detallerequisicioncompra.setBodega(detallerequisicioncompraDataAccess.getBodega(connexion,detallerequisicioncompra));
			BodegaLogic bodegaLogic= new BodegaLogic(connexion);
			bodegaLogic.deepLoad(detallerequisicioncompra.getBodega(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Producto.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detallerequisicioncompra.setProducto(detallerequisicioncompraDataAccess.getProducto(connexion,detallerequisicioncompra));
			ProductoLogic productoLogic= new ProductoLogic(connexion);
			productoLogic.deepLoad(detallerequisicioncompra.getProducto(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Unidad.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detallerequisicioncompra.setUnidad(detallerequisicioncompraDataAccess.getUnidad(connexion,detallerequisicioncompra));
			UnidadLogic unidadLogic= new UnidadLogic(connexion);
			unidadLogic.deepLoad(detallerequisicioncompra.getUnidad(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(CentroCosto.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detallerequisicioncompra.setCentroCosto(detallerequisicioncompraDataAccess.getCentroCosto(connexion,detallerequisicioncompra));
			CentroCostoLogic centrocostoLogic= new CentroCostoLogic(connexion);
			centrocostoLogic.deepLoad(detallerequisicioncompra.getCentroCosto(),isDeep,deepLoadType,clases);
				
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(DetalleRequisicionCompra detallerequisicioncompra,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			DetalleRequisicionCompraLogicAdditional.updateDetalleRequisicionCompraToSave(detallerequisicioncompra,this.arrDatoGeneral);
			
DetalleRequisicionCompraDataAccess.save(detallerequisicioncompra, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		RequisicionCompraDataAccess.save(detallerequisicioncompra.getRequisicionCompra(),connexion);

		EmpresaDataAccess.save(detallerequisicioncompra.getEmpresa(),connexion);

		SucursalDataAccess.save(detallerequisicioncompra.getSucursal(),connexion);

		EjercicioDataAccess.save(detallerequisicioncompra.getEjercicio(),connexion);

		PeriodoDataAccess.save(detallerequisicioncompra.getPeriodo(),connexion);

		AnioDataAccess.save(detallerequisicioncompra.getAnio(),connexion);

		MesDataAccess.save(detallerequisicioncompra.getMes(),connexion);

		BodegaDataAccess.save(detallerequisicioncompra.getBodega(),connexion);

		ProductoDataAccess.save(detallerequisicioncompra.getProducto(),connexion);

		UnidadDataAccess.save(detallerequisicioncompra.getUnidad(),connexion);

		CentroCostoDataAccess.save(detallerequisicioncompra.getCentroCosto(),connexion);
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(RequisicionCompra.class)) {
				RequisicionCompraDataAccess.save(detallerequisicioncompra.getRequisicionCompra(),connexion);
				continue;
			}

			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(detallerequisicioncompra.getEmpresa(),connexion);
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				SucursalDataAccess.save(detallerequisicioncompra.getSucursal(),connexion);
				continue;
			}

			if(clas.clas.equals(Ejercicio.class)) {
				EjercicioDataAccess.save(detallerequisicioncompra.getEjercicio(),connexion);
				continue;
			}

			if(clas.clas.equals(Periodo.class)) {
				PeriodoDataAccess.save(detallerequisicioncompra.getPeriodo(),connexion);
				continue;
			}

			if(clas.clas.equals(Anio.class)) {
				AnioDataAccess.save(detallerequisicioncompra.getAnio(),connexion);
				continue;
			}

			if(clas.clas.equals(Mes.class)) {
				MesDataAccess.save(detallerequisicioncompra.getMes(),connexion);
				continue;
			}

			if(clas.clas.equals(Bodega.class)) {
				BodegaDataAccess.save(detallerequisicioncompra.getBodega(),connexion);
				continue;
			}

			if(clas.clas.equals(Producto.class)) {
				ProductoDataAccess.save(detallerequisicioncompra.getProducto(),connexion);
				continue;
			}

			if(clas.clas.equals(Unidad.class)) {
				UnidadDataAccess.save(detallerequisicioncompra.getUnidad(),connexion);
				continue;
			}

			if(clas.clas.equals(CentroCosto.class)) {
				CentroCostoDataAccess.save(detallerequisicioncompra.getCentroCosto(),connexion);
				continue;
			}

		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		RequisicionCompraDataAccess.save(detallerequisicioncompra.getRequisicionCompra(),connexion);
		RequisicionCompraLogic requisicioncompraLogic= new RequisicionCompraLogic(connexion);
		requisicioncompraLogic.deepLoad(detallerequisicioncompra.getRequisicionCompra(),isDeep,deepLoadType,clases);
				

		EmpresaDataAccess.save(detallerequisicioncompra.getEmpresa(),connexion);
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(detallerequisicioncompra.getEmpresa(),isDeep,deepLoadType,clases);
				

		SucursalDataAccess.save(detallerequisicioncompra.getSucursal(),connexion);
		SucursalLogic sucursalLogic= new SucursalLogic(connexion);
		sucursalLogic.deepLoad(detallerequisicioncompra.getSucursal(),isDeep,deepLoadType,clases);
				

		EjercicioDataAccess.save(detallerequisicioncompra.getEjercicio(),connexion);
		EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
		ejercicioLogic.deepLoad(detallerequisicioncompra.getEjercicio(),isDeep,deepLoadType,clases);
				

		PeriodoDataAccess.save(detallerequisicioncompra.getPeriodo(),connexion);
		PeriodoLogic periodoLogic= new PeriodoLogic(connexion);
		periodoLogic.deepLoad(detallerequisicioncompra.getPeriodo(),isDeep,deepLoadType,clases);
				

		AnioDataAccess.save(detallerequisicioncompra.getAnio(),connexion);
		AnioLogic anioLogic= new AnioLogic(connexion);
		anioLogic.deepLoad(detallerequisicioncompra.getAnio(),isDeep,deepLoadType,clases);
				

		MesDataAccess.save(detallerequisicioncompra.getMes(),connexion);
		MesLogic mesLogic= new MesLogic(connexion);
		mesLogic.deepLoad(detallerequisicioncompra.getMes(),isDeep,deepLoadType,clases);
				

		BodegaDataAccess.save(detallerequisicioncompra.getBodega(),connexion);
		BodegaLogic bodegaLogic= new BodegaLogic(connexion);
		bodegaLogic.deepLoad(detallerequisicioncompra.getBodega(),isDeep,deepLoadType,clases);
				

		ProductoDataAccess.save(detallerequisicioncompra.getProducto(),connexion);
		ProductoLogic productoLogic= new ProductoLogic(connexion);
		productoLogic.deepLoad(detallerequisicioncompra.getProducto(),isDeep,deepLoadType,clases);
				

		UnidadDataAccess.save(detallerequisicioncompra.getUnidad(),connexion);
		UnidadLogic unidadLogic= new UnidadLogic(connexion);
		unidadLogic.deepLoad(detallerequisicioncompra.getUnidad(),isDeep,deepLoadType,clases);
				

		CentroCostoDataAccess.save(detallerequisicioncompra.getCentroCosto(),connexion);
		CentroCostoLogic centrocostoLogic= new CentroCostoLogic(connexion);
		centrocostoLogic.deepLoad(detallerequisicioncompra.getCentroCosto(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(RequisicionCompra.class)) {
				RequisicionCompraDataAccess.save(detallerequisicioncompra.getRequisicionCompra(),connexion);
				RequisicionCompraLogic requisicioncompraLogic= new RequisicionCompraLogic(connexion);
				requisicioncompraLogic.deepSave(detallerequisicioncompra.getRequisicionCompra(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(detallerequisicioncompra.getEmpresa(),connexion);
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepSave(detallerequisicioncompra.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				SucursalDataAccess.save(detallerequisicioncompra.getSucursal(),connexion);
				SucursalLogic sucursalLogic= new SucursalLogic(connexion);
				sucursalLogic.deepSave(detallerequisicioncompra.getSucursal(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Ejercicio.class)) {
				EjercicioDataAccess.save(detallerequisicioncompra.getEjercicio(),connexion);
				EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
				ejercicioLogic.deepSave(detallerequisicioncompra.getEjercicio(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Periodo.class)) {
				PeriodoDataAccess.save(detallerequisicioncompra.getPeriodo(),connexion);
				PeriodoLogic periodoLogic= new PeriodoLogic(connexion);
				periodoLogic.deepSave(detallerequisicioncompra.getPeriodo(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Anio.class)) {
				AnioDataAccess.save(detallerequisicioncompra.getAnio(),connexion);
				AnioLogic anioLogic= new AnioLogic(connexion);
				anioLogic.deepSave(detallerequisicioncompra.getAnio(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Mes.class)) {
				MesDataAccess.save(detallerequisicioncompra.getMes(),connexion);
				MesLogic mesLogic= new MesLogic(connexion);
				mesLogic.deepSave(detallerequisicioncompra.getMes(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Bodega.class)) {
				BodegaDataAccess.save(detallerequisicioncompra.getBodega(),connexion);
				BodegaLogic bodegaLogic= new BodegaLogic(connexion);
				bodegaLogic.deepSave(detallerequisicioncompra.getBodega(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Producto.class)) {
				ProductoDataAccess.save(detallerequisicioncompra.getProducto(),connexion);
				ProductoLogic productoLogic= new ProductoLogic(connexion);
				productoLogic.deepSave(detallerequisicioncompra.getProducto(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Unidad.class)) {
				UnidadDataAccess.save(detallerequisicioncompra.getUnidad(),connexion);
				UnidadLogic unidadLogic= new UnidadLogic(connexion);
				unidadLogic.deepSave(detallerequisicioncompra.getUnidad(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(CentroCosto.class)) {
				CentroCostoDataAccess.save(detallerequisicioncompra.getCentroCosto(),connexion);
				CentroCostoLogic centrocostoLogic= new CentroCostoLogic(connexion);
				centrocostoLogic.deepSave(detallerequisicioncompra.getCentroCosto(),isDeep,deepLoadType,clases);				
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
			this.getNewConnexionToDeep(DetalleRequisicionCompra.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(detallerequisicioncompra,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				DetalleRequisicionCompraConstantesFunciones.refrescarForeignKeysDescripcionesDetalleRequisicionCompra(detallerequisicioncompra);
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
			this.deepLoad(this.detallerequisicioncompra,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				DetalleRequisicionCompraConstantesFunciones.refrescarForeignKeysDescripcionesDetalleRequisicionCompra(this.detallerequisicioncompra);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(DetalleRequisicionCompra.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(detallerequisicioncompras!=null) {
				for(DetalleRequisicionCompra detallerequisicioncompra:detallerequisicioncompras) {
					this.deepLoad(detallerequisicioncompra,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					DetalleRequisicionCompraConstantesFunciones.refrescarForeignKeysDescripcionesDetalleRequisicionCompra(detallerequisicioncompras);
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
			if(detallerequisicioncompras!=null) {
				for(DetalleRequisicionCompra detallerequisicioncompra:detallerequisicioncompras) {
					this.deepLoad(detallerequisicioncompra,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					DetalleRequisicionCompraConstantesFunciones.refrescarForeignKeysDescripcionesDetalleRequisicionCompra(detallerequisicioncompras);
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
			this.getNewConnexionToDeep(DetalleRequisicionCompra.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(detallerequisicioncompra,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(DetalleRequisicionCompra.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(detallerequisicioncompras!=null) {
				for(DetalleRequisicionCompra detallerequisicioncompra:detallerequisicioncompras) {
					this.deepSave(detallerequisicioncompra,isDeep,deepLoadType,clases);
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
			if(detallerequisicioncompras!=null) {
				for(DetalleRequisicionCompra detallerequisicioncompra:detallerequisicioncompras) {
					this.deepSave(detallerequisicioncompra,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getDetalleRequisicionComprasFK_IdAnioWithConnection(String sFinalQuery,Pagination pagination,Long id_anio)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleRequisicionCompra.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidAnio= new ParameterSelectionGeneral();
			parameterSelectionGeneralidAnio.setParameterSelectionGeneralEqual(ParameterType.LONG,id_anio,DetalleRequisicionCompraConstantesFunciones.IDANIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidAnio);

			DetalleRequisicionCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdAnio","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detallerequisicioncompras=detallerequisicioncompraDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleRequisicionCompraConstantesFunciones.refrescarForeignKeysDescripcionesDetalleRequisicionCompra(this.detallerequisicioncompras);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getDetalleRequisicionComprasFK_IdAnio(String sFinalQuery,Pagination pagination,Long id_anio)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidAnio= new ParameterSelectionGeneral();
			parameterSelectionGeneralidAnio.setParameterSelectionGeneralEqual(ParameterType.LONG,id_anio,DetalleRequisicionCompraConstantesFunciones.IDANIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidAnio);

			DetalleRequisicionCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdAnio","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detallerequisicioncompras=detallerequisicioncompraDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleRequisicionCompraConstantesFunciones.refrescarForeignKeysDescripcionesDetalleRequisicionCompra(this.detallerequisicioncompras);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getDetalleRequisicionComprasFK_IdBodegaWithConnection(String sFinalQuery,Pagination pagination,Long id_bodega)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleRequisicionCompra.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidBodega= new ParameterSelectionGeneral();
			parameterSelectionGeneralidBodega.setParameterSelectionGeneralEqual(ParameterType.LONG,id_bodega,DetalleRequisicionCompraConstantesFunciones.IDBODEGA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidBodega);

			DetalleRequisicionCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdBodega","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detallerequisicioncompras=detallerequisicioncompraDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleRequisicionCompraConstantesFunciones.refrescarForeignKeysDescripcionesDetalleRequisicionCompra(this.detallerequisicioncompras);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getDetalleRequisicionComprasFK_IdBodega(String sFinalQuery,Pagination pagination,Long id_bodega)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidBodega= new ParameterSelectionGeneral();
			parameterSelectionGeneralidBodega.setParameterSelectionGeneralEqual(ParameterType.LONG,id_bodega,DetalleRequisicionCompraConstantesFunciones.IDBODEGA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidBodega);

			DetalleRequisicionCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdBodega","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detallerequisicioncompras=detallerequisicioncompraDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleRequisicionCompraConstantesFunciones.refrescarForeignKeysDescripcionesDetalleRequisicionCompra(this.detallerequisicioncompras);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getDetalleRequisicionComprasFK_IdCentroCostoWithConnection(String sFinalQuery,Pagination pagination,Long id_centro_costo)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleRequisicionCompra.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCentroCosto= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCentroCosto.setParameterSelectionGeneralEqual(ParameterType.LONG,id_centro_costo,DetalleRequisicionCompraConstantesFunciones.IDCENTROCOSTO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCentroCosto);

			DetalleRequisicionCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCentroCosto","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detallerequisicioncompras=detallerequisicioncompraDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleRequisicionCompraConstantesFunciones.refrescarForeignKeysDescripcionesDetalleRequisicionCompra(this.detallerequisicioncompras);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getDetalleRequisicionComprasFK_IdCentroCosto(String sFinalQuery,Pagination pagination,Long id_centro_costo)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCentroCosto= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCentroCosto.setParameterSelectionGeneralEqual(ParameterType.LONG,id_centro_costo,DetalleRequisicionCompraConstantesFunciones.IDCENTROCOSTO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCentroCosto);

			DetalleRequisicionCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCentroCosto","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detallerequisicioncompras=detallerequisicioncompraDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleRequisicionCompraConstantesFunciones.refrescarForeignKeysDescripcionesDetalleRequisicionCompra(this.detallerequisicioncompras);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getDetalleRequisicionComprasFK_IdEjercicioWithConnection(String sFinalQuery,Pagination pagination,Long id_ejercicio)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleRequisicionCompra.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEjercicio= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEjercicio.setParameterSelectionGeneralEqual(ParameterType.LONG,id_ejercicio,DetalleRequisicionCompraConstantesFunciones.IDEJERCICIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEjercicio);

			DetalleRequisicionCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEjercicio","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detallerequisicioncompras=detallerequisicioncompraDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleRequisicionCompraConstantesFunciones.refrescarForeignKeysDescripcionesDetalleRequisicionCompra(this.detallerequisicioncompras);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getDetalleRequisicionComprasFK_IdEjercicio(String sFinalQuery,Pagination pagination,Long id_ejercicio)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEjercicio= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEjercicio.setParameterSelectionGeneralEqual(ParameterType.LONG,id_ejercicio,DetalleRequisicionCompraConstantesFunciones.IDEJERCICIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEjercicio);

			DetalleRequisicionCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEjercicio","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detallerequisicioncompras=detallerequisicioncompraDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleRequisicionCompraConstantesFunciones.refrescarForeignKeysDescripcionesDetalleRequisicionCompra(this.detallerequisicioncompras);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getDetalleRequisicionComprasFK_IdEmpresaWithConnection(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleRequisicionCompra.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,DetalleRequisicionCompraConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			DetalleRequisicionCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detallerequisicioncompras=detallerequisicioncompraDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleRequisicionCompraConstantesFunciones.refrescarForeignKeysDescripcionesDetalleRequisicionCompra(this.detallerequisicioncompras);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getDetalleRequisicionComprasFK_IdEmpresa(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,DetalleRequisicionCompraConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			DetalleRequisicionCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detallerequisicioncompras=detallerequisicioncompraDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleRequisicionCompraConstantesFunciones.refrescarForeignKeysDescripcionesDetalleRequisicionCompra(this.detallerequisicioncompras);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getDetalleRequisicionComprasFK_IdMesWithConnection(String sFinalQuery,Pagination pagination,Long id_mes)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleRequisicionCompra.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidMes= new ParameterSelectionGeneral();
			parameterSelectionGeneralidMes.setParameterSelectionGeneralEqual(ParameterType.LONG,id_mes,DetalleRequisicionCompraConstantesFunciones.IDMES,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidMes);

			DetalleRequisicionCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdMes","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detallerequisicioncompras=detallerequisicioncompraDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleRequisicionCompraConstantesFunciones.refrescarForeignKeysDescripcionesDetalleRequisicionCompra(this.detallerequisicioncompras);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getDetalleRequisicionComprasFK_IdMes(String sFinalQuery,Pagination pagination,Long id_mes)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidMes= new ParameterSelectionGeneral();
			parameterSelectionGeneralidMes.setParameterSelectionGeneralEqual(ParameterType.LONG,id_mes,DetalleRequisicionCompraConstantesFunciones.IDMES,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidMes);

			DetalleRequisicionCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdMes","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detallerequisicioncompras=detallerequisicioncompraDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleRequisicionCompraConstantesFunciones.refrescarForeignKeysDescripcionesDetalleRequisicionCompra(this.detallerequisicioncompras);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getDetalleRequisicionComprasFK_IdPeriodoWithConnection(String sFinalQuery,Pagination pagination,Long id_periodo)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleRequisicionCompra.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidPeriodo= new ParameterSelectionGeneral();
			parameterSelectionGeneralidPeriodo.setParameterSelectionGeneralEqual(ParameterType.LONG,id_periodo,DetalleRequisicionCompraConstantesFunciones.IDPERIODO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidPeriodo);

			DetalleRequisicionCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdPeriodo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detallerequisicioncompras=detallerequisicioncompraDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleRequisicionCompraConstantesFunciones.refrescarForeignKeysDescripcionesDetalleRequisicionCompra(this.detallerequisicioncompras);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getDetalleRequisicionComprasFK_IdPeriodo(String sFinalQuery,Pagination pagination,Long id_periodo)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidPeriodo= new ParameterSelectionGeneral();
			parameterSelectionGeneralidPeriodo.setParameterSelectionGeneralEqual(ParameterType.LONG,id_periodo,DetalleRequisicionCompraConstantesFunciones.IDPERIODO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidPeriodo);

			DetalleRequisicionCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdPeriodo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detallerequisicioncompras=detallerequisicioncompraDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleRequisicionCompraConstantesFunciones.refrescarForeignKeysDescripcionesDetalleRequisicionCompra(this.detallerequisicioncompras);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getDetalleRequisicionComprasFK_IdProductoWithConnection(String sFinalQuery,Pagination pagination,Long id_producto)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleRequisicionCompra.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidProducto= new ParameterSelectionGeneral();
			parameterSelectionGeneralidProducto.setParameterSelectionGeneralEqual(ParameterType.LONG,id_producto,DetalleRequisicionCompraConstantesFunciones.IDPRODUCTO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidProducto);

			DetalleRequisicionCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdProducto","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detallerequisicioncompras=detallerequisicioncompraDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleRequisicionCompraConstantesFunciones.refrescarForeignKeysDescripcionesDetalleRequisicionCompra(this.detallerequisicioncompras);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getDetalleRequisicionComprasFK_IdProducto(String sFinalQuery,Pagination pagination,Long id_producto)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidProducto= new ParameterSelectionGeneral();
			parameterSelectionGeneralidProducto.setParameterSelectionGeneralEqual(ParameterType.LONG,id_producto,DetalleRequisicionCompraConstantesFunciones.IDPRODUCTO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidProducto);

			DetalleRequisicionCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdProducto","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detallerequisicioncompras=detallerequisicioncompraDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleRequisicionCompraConstantesFunciones.refrescarForeignKeysDescripcionesDetalleRequisicionCompra(this.detallerequisicioncompras);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getDetalleRequisicionComprasFK_IdRequisicionCompraWithConnection(String sFinalQuery,Pagination pagination,Long id_requisicion_compra)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleRequisicionCompra.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidRequisicionCompra= new ParameterSelectionGeneral();
			parameterSelectionGeneralidRequisicionCompra.setParameterSelectionGeneralEqual(ParameterType.LONG,id_requisicion_compra,DetalleRequisicionCompraConstantesFunciones.IDREQUISICIONCOMPRA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidRequisicionCompra);

			DetalleRequisicionCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdRequisicionCompra","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detallerequisicioncompras=detallerequisicioncompraDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleRequisicionCompraConstantesFunciones.refrescarForeignKeysDescripcionesDetalleRequisicionCompra(this.detallerequisicioncompras);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getDetalleRequisicionComprasFK_IdRequisicionCompra(String sFinalQuery,Pagination pagination,Long id_requisicion_compra)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidRequisicionCompra= new ParameterSelectionGeneral();
			parameterSelectionGeneralidRequisicionCompra.setParameterSelectionGeneralEqual(ParameterType.LONG,id_requisicion_compra,DetalleRequisicionCompraConstantesFunciones.IDREQUISICIONCOMPRA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidRequisicionCompra);

			DetalleRequisicionCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdRequisicionCompra","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detallerequisicioncompras=detallerequisicioncompraDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleRequisicionCompraConstantesFunciones.refrescarForeignKeysDescripcionesDetalleRequisicionCompra(this.detallerequisicioncompras);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getDetalleRequisicionComprasFK_IdSucursalWithConnection(String sFinalQuery,Pagination pagination,Long id_sucursal)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleRequisicionCompra.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidSucursal= new ParameterSelectionGeneral();
			parameterSelectionGeneralidSucursal.setParameterSelectionGeneralEqual(ParameterType.LONG,id_sucursal,DetalleRequisicionCompraConstantesFunciones.IDSUCURSAL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidSucursal);

			DetalleRequisicionCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdSucursal","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detallerequisicioncompras=detallerequisicioncompraDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleRequisicionCompraConstantesFunciones.refrescarForeignKeysDescripcionesDetalleRequisicionCompra(this.detallerequisicioncompras);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getDetalleRequisicionComprasFK_IdSucursal(String sFinalQuery,Pagination pagination,Long id_sucursal)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidSucursal= new ParameterSelectionGeneral();
			parameterSelectionGeneralidSucursal.setParameterSelectionGeneralEqual(ParameterType.LONG,id_sucursal,DetalleRequisicionCompraConstantesFunciones.IDSUCURSAL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidSucursal);

			DetalleRequisicionCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdSucursal","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detallerequisicioncompras=detallerequisicioncompraDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleRequisicionCompraConstantesFunciones.refrescarForeignKeysDescripcionesDetalleRequisicionCompra(this.detallerequisicioncompras);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getDetalleRequisicionComprasFK_IdUnidadWithConnection(String sFinalQuery,Pagination pagination,Long id_unidad)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleRequisicionCompra.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidUnidad= new ParameterSelectionGeneral();
			parameterSelectionGeneralidUnidad.setParameterSelectionGeneralEqual(ParameterType.LONG,id_unidad,DetalleRequisicionCompraConstantesFunciones.IDUNIDAD,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidUnidad);

			DetalleRequisicionCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdUnidad","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detallerequisicioncompras=detallerequisicioncompraDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleRequisicionCompraConstantesFunciones.refrescarForeignKeysDescripcionesDetalleRequisicionCompra(this.detallerequisicioncompras);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getDetalleRequisicionComprasFK_IdUnidad(String sFinalQuery,Pagination pagination,Long id_unidad)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidUnidad= new ParameterSelectionGeneral();
			parameterSelectionGeneralidUnidad.setParameterSelectionGeneralEqual(ParameterType.LONG,id_unidad,DetalleRequisicionCompraConstantesFunciones.IDUNIDAD,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidUnidad);

			DetalleRequisicionCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdUnidad","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detallerequisicioncompras=detallerequisicioncompraDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleRequisicionCompraConstantesFunciones.refrescarForeignKeysDescripcionesDetalleRequisicionCompra(this.detallerequisicioncompras);
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
			if(DetalleRequisicionCompraConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,DetalleRequisicionCompraDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,DetalleRequisicionCompra detallerequisicioncompra,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(DetalleRequisicionCompraConstantesFunciones.ISCONAUDITORIA) {
				if(detallerequisicioncompra.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,DetalleRequisicionCompraDataAccess.TABLENAME, detallerequisicioncompra.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(DetalleRequisicionCompraConstantesFunciones.ISCONAUDITORIADETALLE) {
						////DetalleRequisicionCompraLogic.registrarAuditoriaDetallesDetalleRequisicionCompra(connexion,detallerequisicioncompra,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(detallerequisicioncompra.getIsDeleted()) {
					/*if(!detallerequisicioncompra.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,DetalleRequisicionCompraDataAccess.TABLENAME, detallerequisicioncompra.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////DetalleRequisicionCompraLogic.registrarAuditoriaDetallesDetalleRequisicionCompra(connexion,detallerequisicioncompra,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,DetalleRequisicionCompraDataAccess.TABLENAME, detallerequisicioncompra.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(detallerequisicioncompra.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,DetalleRequisicionCompraDataAccess.TABLENAME, detallerequisicioncompra.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(DetalleRequisicionCompraConstantesFunciones.ISCONAUDITORIADETALLE) {
						////DetalleRequisicionCompraLogic.registrarAuditoriaDetallesDetalleRequisicionCompra(connexion,detallerequisicioncompra,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesDetalleRequisicionCompra(Connexion connexion,DetalleRequisicionCompra detallerequisicioncompra)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(detallerequisicioncompra.getIsNew()||!detallerequisicioncompra.getid_requisicion_compra().equals(detallerequisicioncompra.getDetalleRequisicionCompraOriginal().getid_requisicion_compra()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detallerequisicioncompra.getDetalleRequisicionCompraOriginal().getid_requisicion_compra()!=null)
				{
					strValorActual=detallerequisicioncompra.getDetalleRequisicionCompraOriginal().getid_requisicion_compra().toString();
				}
				if(detallerequisicioncompra.getid_requisicion_compra()!=null)
				{
					strValorNuevo=detallerequisicioncompra.getid_requisicion_compra().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleRequisicionCompraConstantesFunciones.IDREQUISICIONCOMPRA,strValorActual,strValorNuevo);
			}	
			
			if(detallerequisicioncompra.getIsNew()||!detallerequisicioncompra.getid_empresa().equals(detallerequisicioncompra.getDetalleRequisicionCompraOriginal().getid_empresa()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detallerequisicioncompra.getDetalleRequisicionCompraOriginal().getid_empresa()!=null)
				{
					strValorActual=detallerequisicioncompra.getDetalleRequisicionCompraOriginal().getid_empresa().toString();
				}
				if(detallerequisicioncompra.getid_empresa()!=null)
				{
					strValorNuevo=detallerequisicioncompra.getid_empresa().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleRequisicionCompraConstantesFunciones.IDEMPRESA,strValorActual,strValorNuevo);
			}	
			
			if(detallerequisicioncompra.getIsNew()||!detallerequisicioncompra.getid_sucursal().equals(detallerequisicioncompra.getDetalleRequisicionCompraOriginal().getid_sucursal()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detallerequisicioncompra.getDetalleRequisicionCompraOriginal().getid_sucursal()!=null)
				{
					strValorActual=detallerequisicioncompra.getDetalleRequisicionCompraOriginal().getid_sucursal().toString();
				}
				if(detallerequisicioncompra.getid_sucursal()!=null)
				{
					strValorNuevo=detallerequisicioncompra.getid_sucursal().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleRequisicionCompraConstantesFunciones.IDSUCURSAL,strValorActual,strValorNuevo);
			}	
			
			if(detallerequisicioncompra.getIsNew()||!detallerequisicioncompra.getid_ejercicio().equals(detallerequisicioncompra.getDetalleRequisicionCompraOriginal().getid_ejercicio()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detallerequisicioncompra.getDetalleRequisicionCompraOriginal().getid_ejercicio()!=null)
				{
					strValorActual=detallerequisicioncompra.getDetalleRequisicionCompraOriginal().getid_ejercicio().toString();
				}
				if(detallerequisicioncompra.getid_ejercicio()!=null)
				{
					strValorNuevo=detallerequisicioncompra.getid_ejercicio().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleRequisicionCompraConstantesFunciones.IDEJERCICIO,strValorActual,strValorNuevo);
			}	
			
			if(detallerequisicioncompra.getIsNew()||!detallerequisicioncompra.getid_periodo().equals(detallerequisicioncompra.getDetalleRequisicionCompraOriginal().getid_periodo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detallerequisicioncompra.getDetalleRequisicionCompraOriginal().getid_periodo()!=null)
				{
					strValorActual=detallerequisicioncompra.getDetalleRequisicionCompraOriginal().getid_periodo().toString();
				}
				if(detallerequisicioncompra.getid_periodo()!=null)
				{
					strValorNuevo=detallerequisicioncompra.getid_periodo().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleRequisicionCompraConstantesFunciones.IDPERIODO,strValorActual,strValorNuevo);
			}	
			
			if(detallerequisicioncompra.getIsNew()||!detallerequisicioncompra.getid_anio().equals(detallerequisicioncompra.getDetalleRequisicionCompraOriginal().getid_anio()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detallerequisicioncompra.getDetalleRequisicionCompraOriginal().getid_anio()!=null)
				{
					strValorActual=detallerequisicioncompra.getDetalleRequisicionCompraOriginal().getid_anio().toString();
				}
				if(detallerequisicioncompra.getid_anio()!=null)
				{
					strValorNuevo=detallerequisicioncompra.getid_anio().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleRequisicionCompraConstantesFunciones.IDANIO,strValorActual,strValorNuevo);
			}	
			
			if(detallerequisicioncompra.getIsNew()||!detallerequisicioncompra.getid_mes().equals(detallerequisicioncompra.getDetalleRequisicionCompraOriginal().getid_mes()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detallerequisicioncompra.getDetalleRequisicionCompraOriginal().getid_mes()!=null)
				{
					strValorActual=detallerequisicioncompra.getDetalleRequisicionCompraOriginal().getid_mes().toString();
				}
				if(detallerequisicioncompra.getid_mes()!=null)
				{
					strValorNuevo=detallerequisicioncompra.getid_mes().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleRequisicionCompraConstantesFunciones.IDMES,strValorActual,strValorNuevo);
			}	
			
			if(detallerequisicioncompra.getIsNew()||!detallerequisicioncompra.getid_bodega().equals(detallerequisicioncompra.getDetalleRequisicionCompraOriginal().getid_bodega()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detallerequisicioncompra.getDetalleRequisicionCompraOriginal().getid_bodega()!=null)
				{
					strValorActual=detallerequisicioncompra.getDetalleRequisicionCompraOriginal().getid_bodega().toString();
				}
				if(detallerequisicioncompra.getid_bodega()!=null)
				{
					strValorNuevo=detallerequisicioncompra.getid_bodega().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleRequisicionCompraConstantesFunciones.IDBODEGA,strValorActual,strValorNuevo);
			}	
			
			if(detallerequisicioncompra.getIsNew()||!detallerequisicioncompra.getid_producto().equals(detallerequisicioncompra.getDetalleRequisicionCompraOriginal().getid_producto()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detallerequisicioncompra.getDetalleRequisicionCompraOriginal().getid_producto()!=null)
				{
					strValorActual=detallerequisicioncompra.getDetalleRequisicionCompraOriginal().getid_producto().toString();
				}
				if(detallerequisicioncompra.getid_producto()!=null)
				{
					strValorNuevo=detallerequisicioncompra.getid_producto().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleRequisicionCompraConstantesFunciones.IDPRODUCTO,strValorActual,strValorNuevo);
			}	
			
			if(detallerequisicioncompra.getIsNew()||!detallerequisicioncompra.getid_unidad().equals(detallerequisicioncompra.getDetalleRequisicionCompraOriginal().getid_unidad()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detallerequisicioncompra.getDetalleRequisicionCompraOriginal().getid_unidad()!=null)
				{
					strValorActual=detallerequisicioncompra.getDetalleRequisicionCompraOriginal().getid_unidad().toString();
				}
				if(detallerequisicioncompra.getid_unidad()!=null)
				{
					strValorNuevo=detallerequisicioncompra.getid_unidad().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleRequisicionCompraConstantesFunciones.IDUNIDAD,strValorActual,strValorNuevo);
			}	
			
			if(detallerequisicioncompra.getIsNew()||!detallerequisicioncompra.getid_centro_costo().equals(detallerequisicioncompra.getDetalleRequisicionCompraOriginal().getid_centro_costo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detallerequisicioncompra.getDetalleRequisicionCompraOriginal().getid_centro_costo()!=null)
				{
					strValorActual=detallerequisicioncompra.getDetalleRequisicionCompraOriginal().getid_centro_costo().toString();
				}
				if(detallerequisicioncompra.getid_centro_costo()!=null)
				{
					strValorNuevo=detallerequisicioncompra.getid_centro_costo().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleRequisicionCompraConstantesFunciones.IDCENTROCOSTO,strValorActual,strValorNuevo);
			}	
			
			if(detallerequisicioncompra.getIsNew()||!detallerequisicioncompra.getcantidad_requisicion().equals(detallerequisicioncompra.getDetalleRequisicionCompraOriginal().getcantidad_requisicion()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detallerequisicioncompra.getDetalleRequisicionCompraOriginal().getcantidad_requisicion()!=null)
				{
					strValorActual=detallerequisicioncompra.getDetalleRequisicionCompraOriginal().getcantidad_requisicion().toString();
				}
				if(detallerequisicioncompra.getcantidad_requisicion()!=null)
				{
					strValorNuevo=detallerequisicioncompra.getcantidad_requisicion().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleRequisicionCompraConstantesFunciones.CANTIDADREQUISICION,strValorActual,strValorNuevo);
			}	
			
			if(detallerequisicioncompra.getIsNew()||!detallerequisicioncompra.getcosto_unitario().equals(detallerequisicioncompra.getDetalleRequisicionCompraOriginal().getcosto_unitario()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detallerequisicioncompra.getDetalleRequisicionCompraOriginal().getcosto_unitario()!=null)
				{
					strValorActual=detallerequisicioncompra.getDetalleRequisicionCompraOriginal().getcosto_unitario().toString();
				}
				if(detallerequisicioncompra.getcosto_unitario()!=null)
				{
					strValorNuevo=detallerequisicioncompra.getcosto_unitario().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleRequisicionCompraConstantesFunciones.COSTOUNITARIO,strValorActual,strValorNuevo);
			}	
			
			if(detallerequisicioncompra.getIsNew()||!detallerequisicioncompra.getcosto_total().equals(detallerequisicioncompra.getDetalleRequisicionCompraOriginal().getcosto_total()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detallerequisicioncompra.getDetalleRequisicionCompraOriginal().getcosto_total()!=null)
				{
					strValorActual=detallerequisicioncompra.getDetalleRequisicionCompraOriginal().getcosto_total().toString();
				}
				if(detallerequisicioncompra.getcosto_total()!=null)
				{
					strValorNuevo=detallerequisicioncompra.getcosto_total().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleRequisicionCompraConstantesFunciones.COSTOTOTAL,strValorActual,strValorNuevo);
			}	
			
			if(detallerequisicioncompra.getIsNew()||!detallerequisicioncompra.getdescripcion().equals(detallerequisicioncompra.getDetalleRequisicionCompraOriginal().getdescripcion()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detallerequisicioncompra.getDetalleRequisicionCompraOriginal().getdescripcion()!=null)
				{
					strValorActual=detallerequisicioncompra.getDetalleRequisicionCompraOriginal().getdescripcion();
				}
				if(detallerequisicioncompra.getdescripcion()!=null)
				{
					strValorNuevo=detallerequisicioncompra.getdescripcion() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleRequisicionCompraConstantesFunciones.DESCRIPCION,strValorActual,strValorNuevo);
			}	
			
			if(detallerequisicioncompra.getIsNew()||!detallerequisicioncompra.getcantidad_entregada().equals(detallerequisicioncompra.getDetalleRequisicionCompraOriginal().getcantidad_entregada()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detallerequisicioncompra.getDetalleRequisicionCompraOriginal().getcantidad_entregada()!=null)
				{
					strValorActual=detallerequisicioncompra.getDetalleRequisicionCompraOriginal().getcantidad_entregada().toString();
				}
				if(detallerequisicioncompra.getcantidad_entregada()!=null)
				{
					strValorNuevo=detallerequisicioncompra.getcantidad_entregada().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleRequisicionCompraConstantesFunciones.CANTIDADENTREGADA,strValorActual,strValorNuevo);
			}	
			
			if(detallerequisicioncompra.getIsNew()||!detallerequisicioncompra.getcantidad_pendiente().equals(detallerequisicioncompra.getDetalleRequisicionCompraOriginal().getcantidad_pendiente()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detallerequisicioncompra.getDetalleRequisicionCompraOriginal().getcantidad_pendiente()!=null)
				{
					strValorActual=detallerequisicioncompra.getDetalleRequisicionCompraOriginal().getcantidad_pendiente().toString();
				}
				if(detallerequisicioncompra.getcantidad_pendiente()!=null)
				{
					strValorNuevo=detallerequisicioncompra.getcantidad_pendiente().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleRequisicionCompraConstantesFunciones.CANTIDADPENDIENTE,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void saveDetalleRequisicionCompraRelacionesWithConnection(DetalleRequisicionCompra detallerequisicioncompra) throws Exception {

		if(!detallerequisicioncompra.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveDetalleRequisicionCompraRelacionesBase(detallerequisicioncompra,true);
		}
	}

	public void saveDetalleRequisicionCompraRelaciones(DetalleRequisicionCompra detallerequisicioncompra)throws Exception {

		if(!detallerequisicioncompra.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveDetalleRequisicionCompraRelacionesBase(detallerequisicioncompra,false);
		}
	}

	public void saveDetalleRequisicionCompraRelacionesBase(DetalleRequisicionCompra detallerequisicioncompra,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("DetalleRequisicionCompra-saveRelacionesWithConnection");}
	

			this.setDetalleRequisicionCompra(detallerequisicioncompra);

			if(DetalleRequisicionCompraLogicAdditional.validarSaveRelaciones(detallerequisicioncompra,this)) {

				DetalleRequisicionCompraLogicAdditional.updateRelacionesToSave(detallerequisicioncompra,this);

				if((detallerequisicioncompra.getIsNew()||detallerequisicioncompra.getIsChanged())&&!detallerequisicioncompra.getIsDeleted()) {
					this.saveDetalleRequisicionCompra();
					this.saveDetalleRequisicionCompraRelacionesDetalles();

				} else if(detallerequisicioncompra.getIsDeleted()) {
					this.saveDetalleRequisicionCompraRelacionesDetalles();
					this.saveDetalleRequisicionCompra();
				}

				DetalleRequisicionCompraLogicAdditional.updateRelacionesToSaveAfter(detallerequisicioncompra,this);

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
	
	
	private void saveDetalleRequisicionCompraRelacionesDetalles()throws Exception {
		try {
	

		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfDetalleRequisicionCompra(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=DetalleRequisicionCompraConstantesFunciones.getClassesForeignKeysOfDetalleRequisicionCompra(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfDetalleRequisicionCompra(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=DetalleRequisicionCompraConstantesFunciones.getClassesRelationshipsOfDetalleRequisicionCompra(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}
