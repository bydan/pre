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
import com.bydan.erp.inventario.util.DetalleOrdenCompraConstantesFunciones;
import com.bydan.erp.inventario.util.DetalleOrdenCompraParameterReturnGeneral;
//import com.bydan.erp.inventario.util.DetalleOrdenCompraParameterGeneral;
import com.bydan.erp.inventario.business.entity.DetalleOrdenCompra;
import com.bydan.erp.inventario.business.logic.DetalleOrdenCompraLogicAdditional;
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
public class DetalleOrdenCompraLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(DetalleOrdenCompraLogic.class);
	
	protected DetalleOrdenCompraDataAccess detalleordencompraDataAccess; 	
	protected DetalleOrdenCompra detalleordencompra;
	protected List<DetalleOrdenCompra> detalleordencompras;
	protected Object detalleordencompraObject;	
	protected List<Object> detalleordencomprasObject;
	
	public static ClassValidator<DetalleOrdenCompra> detalleordencompraValidator = new ClassValidator<DetalleOrdenCompra>(DetalleOrdenCompra.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected DetalleOrdenCompraLogicAdditional detalleordencompraLogicAdditional=null;
	
	public DetalleOrdenCompraLogicAdditional getDetalleOrdenCompraLogicAdditional() {
		return this.detalleordencompraLogicAdditional;
	}
	
	public void setDetalleOrdenCompraLogicAdditional(DetalleOrdenCompraLogicAdditional detalleordencompraLogicAdditional) {
		try {
			this.detalleordencompraLogicAdditional=detalleordencompraLogicAdditional;
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
	
	
	
	
	public  DetalleOrdenCompraLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.detalleordencompraDataAccess = new DetalleOrdenCompraDataAccess();
			
			this.detalleordencompras= new ArrayList<DetalleOrdenCompra>();
			this.detalleordencompra= new DetalleOrdenCompra();
			
			this.detalleordencompraObject=new Object();
			this.detalleordencomprasObject=new ArrayList<Object>();
				
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
			
			this.detalleordencompraDataAccess.setConnexionType(this.connexionType);
			this.detalleordencompraDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  DetalleOrdenCompraLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.detalleordencompraDataAccess = new DetalleOrdenCompraDataAccess();
			this.detalleordencompras= new ArrayList<DetalleOrdenCompra>();
			this.detalleordencompra= new DetalleOrdenCompra();
			this.detalleordencompraObject=new Object();
			this.detalleordencomprasObject=new ArrayList<Object>();
			
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
			
			this.detalleordencompraDataAccess.setConnexionType(this.connexionType);
			this.detalleordencompraDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public DetalleOrdenCompra getDetalleOrdenCompra() throws Exception {	
		DetalleOrdenCompraLogicAdditional.checkDetalleOrdenCompraToGet(detalleordencompra,this.datosCliente,this.arrDatoGeneral);
		DetalleOrdenCompraLogicAdditional.updateDetalleOrdenCompraToGet(detalleordencompra,this.arrDatoGeneral);
		
		return detalleordencompra;
	}
		
	public void setDetalleOrdenCompra(DetalleOrdenCompra newDetalleOrdenCompra) {
		this.detalleordencompra = newDetalleOrdenCompra;
	}
	
	public DetalleOrdenCompraDataAccess getDetalleOrdenCompraDataAccess() {
		return detalleordencompraDataAccess;
	}
	
	public void setDetalleOrdenCompraDataAccess(DetalleOrdenCompraDataAccess newdetalleordencompraDataAccess) {
		this.detalleordencompraDataAccess = newdetalleordencompraDataAccess;
	}
	
	public List<DetalleOrdenCompra> getDetalleOrdenCompras() throws Exception {		
		this.quitarDetalleOrdenComprasNulos();
		
		DetalleOrdenCompraLogicAdditional.checkDetalleOrdenCompraToGets(detalleordencompras,this.datosCliente,this.arrDatoGeneral);
		
		for (DetalleOrdenCompra detalleordencompraLocal: detalleordencompras ) {
			DetalleOrdenCompraLogicAdditional.updateDetalleOrdenCompraToGet(detalleordencompraLocal,this.arrDatoGeneral);
		}
		
		return detalleordencompras;
	}
	
	public void setDetalleOrdenCompras(List<DetalleOrdenCompra> newDetalleOrdenCompras) {
		this.detalleordencompras = newDetalleOrdenCompras;
	}
	
	public Object getDetalleOrdenCompraObject() {	
		this.detalleordencompraObject=this.detalleordencompraDataAccess.getEntityObject();
		return this.detalleordencompraObject;
	}
		
	public void setDetalleOrdenCompraObject(Object newDetalleOrdenCompraObject) {
		this.detalleordencompraObject = newDetalleOrdenCompraObject;
	}
	
	public List<Object> getDetalleOrdenComprasObject() {		
		this.detalleordencomprasObject=this.detalleordencompraDataAccess.getEntitiesObject();
		return this.detalleordencomprasObject;
	}
		
	public void setDetalleOrdenComprasObject(List<Object> newDetalleOrdenComprasObject) {
		this.detalleordencomprasObject = newDetalleOrdenComprasObject;
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
		
		if(this.detalleordencompraDataAccess!=null) {
			this.detalleordencompraDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleOrdenCompra.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			detalleordencompraDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			detalleordencompraDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		detalleordencompra = new  DetalleOrdenCompra();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleOrdenCompra.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			detalleordencompra=detalleordencompraDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.detalleordencompra,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				DetalleOrdenCompraConstantesFunciones.refrescarForeignKeysDescripcionesDetalleOrdenCompra(this.detalleordencompra);
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
		detalleordencompra = new  DetalleOrdenCompra();
		  		  
        try {
			
			detalleordencompra=detalleordencompraDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.detalleordencompra,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				DetalleOrdenCompraConstantesFunciones.refrescarForeignKeysDescripcionesDetalleOrdenCompra(this.detalleordencompra);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		detalleordencompra = new  DetalleOrdenCompra();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleOrdenCompra.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			detalleordencompra=detalleordencompraDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.detalleordencompra,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				DetalleOrdenCompraConstantesFunciones.refrescarForeignKeysDescripcionesDetalleOrdenCompra(this.detalleordencompra);
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
		detalleordencompra = new  DetalleOrdenCompra();
		  		  
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
		detalleordencompra = new  DetalleOrdenCompra();
		  		  
        try {
			
			detalleordencompra=detalleordencompraDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.detalleordencompra,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				DetalleOrdenCompraConstantesFunciones.refrescarForeignKeysDescripcionesDetalleOrdenCompra(this.detalleordencompra);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		detalleordencompra = new  DetalleOrdenCompra();
		  		  
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
		detalleordencompra = new  DetalleOrdenCompra();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleOrdenCompra.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =detalleordencompraDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		detalleordencompra = new  DetalleOrdenCompra();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=detalleordencompraDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		detalleordencompra = new  DetalleOrdenCompra();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleOrdenCompra.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =detalleordencompraDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		detalleordencompra = new  DetalleOrdenCompra();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=detalleordencompraDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		detalleordencompra = new  DetalleOrdenCompra();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleOrdenCompra.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =detalleordencompraDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		detalleordencompra = new  DetalleOrdenCompra();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=detalleordencompraDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		detalleordencompras = new  ArrayList<DetalleOrdenCompra>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleOrdenCompra.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			DetalleOrdenCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detalleordencompras=detalleordencompraDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarDetalleOrdenCompra(detalleordencompras);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetalleOrdenCompraConstantesFunciones.refrescarForeignKeysDescripcionesDetalleOrdenCompra(this.detalleordencompras);
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
		detalleordencompras = new  ArrayList<DetalleOrdenCompra>();
		  		  
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
		detalleordencompras = new  ArrayList<DetalleOrdenCompra>();
		  		  
        try {			
			DetalleOrdenCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detalleordencompras=detalleordencompraDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarDetalleOrdenCompra(detalleordencompras);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetalleOrdenCompraConstantesFunciones.refrescarForeignKeysDescripcionesDetalleOrdenCompra(this.detalleordencompras);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		detalleordencompras = new  ArrayList<DetalleOrdenCompra>();
		  		  
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
		detalleordencompras = new  ArrayList<DetalleOrdenCompra>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleOrdenCompra.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			DetalleOrdenCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detalleordencompras=detalleordencompraDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarDetalleOrdenCompra(detalleordencompras);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetalleOrdenCompraConstantesFunciones.refrescarForeignKeysDescripcionesDetalleOrdenCompra(this.detalleordencompras);
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
		detalleordencompras = new  ArrayList<DetalleOrdenCompra>();
		  		  
        try {
			DetalleOrdenCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detalleordencompras=detalleordencompraDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarDetalleOrdenCompra(detalleordencompras);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetalleOrdenCompraConstantesFunciones.refrescarForeignKeysDescripcionesDetalleOrdenCompra(this.detalleordencompras);
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
		detalleordencompras = new  ArrayList<DetalleOrdenCompra>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleOrdenCompra.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			DetalleOrdenCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detalleordencompras=detalleordencompraDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarDetalleOrdenCompra(detalleordencompras);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetalleOrdenCompraConstantesFunciones.refrescarForeignKeysDescripcionesDetalleOrdenCompra(this.detalleordencompras);
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
		detalleordencompras = new  ArrayList<DetalleOrdenCompra>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			DetalleOrdenCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detalleordencompras=detalleordencompraDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarDetalleOrdenCompra(detalleordencompras);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetalleOrdenCompraConstantesFunciones.refrescarForeignKeysDescripcionesDetalleOrdenCompra(this.detalleordencompras);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		detalleordencompra = new  DetalleOrdenCompra();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleOrdenCompra.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			DetalleOrdenCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detalleordencompra=detalleordencompraDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarDetalleOrdenCompra(detalleordencompra);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetalleOrdenCompraConstantesFunciones.refrescarForeignKeysDescripcionesDetalleOrdenCompra(this.detalleordencompra);
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
		detalleordencompra = new  DetalleOrdenCompra();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			DetalleOrdenCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detalleordencompra=detalleordencompraDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarDetalleOrdenCompra(detalleordencompra);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetalleOrdenCompraConstantesFunciones.refrescarForeignKeysDescripcionesDetalleOrdenCompra(this.detalleordencompra);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		detalleordencompras = new  ArrayList<DetalleOrdenCompra>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleOrdenCompra.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			DetalleOrdenCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detalleordencompras=detalleordencompraDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarDetalleOrdenCompra(detalleordencompras);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetalleOrdenCompraConstantesFunciones.refrescarForeignKeysDescripcionesDetalleOrdenCompra(this.detalleordencompras);
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
		detalleordencompras = new  ArrayList<DetalleOrdenCompra>();
		  		  
        try {
			DetalleOrdenCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detalleordencompras=detalleordencompraDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarDetalleOrdenCompra(detalleordencompras);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetalleOrdenCompraConstantesFunciones.refrescarForeignKeysDescripcionesDetalleOrdenCompra(this.detalleordencompras);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosDetalleOrdenComprasWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		detalleordencompras = new  ArrayList<DetalleOrdenCompra>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleOrdenCompra.class.getSimpleName()+"-getTodosDetalleOrdenComprasWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			DetalleOrdenCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detalleordencompras=detalleordencompraDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarDetalleOrdenCompra(detalleordencompras);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetalleOrdenCompraConstantesFunciones.refrescarForeignKeysDescripcionesDetalleOrdenCompra(this.detalleordencompras);
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
	
	public  void  getTodosDetalleOrdenCompras(String sFinalQuery,Pagination pagination)throws Exception {
		detalleordencompras = new  ArrayList<DetalleOrdenCompra>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			DetalleOrdenCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detalleordencompras=detalleordencompraDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarDetalleOrdenCompra(detalleordencompras);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetalleOrdenCompraConstantesFunciones.refrescarForeignKeysDescripcionesDetalleOrdenCompra(this.detalleordencompras);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarDetalleOrdenCompra(DetalleOrdenCompra detalleordencompra) throws Exception {
		Boolean estaValidado=false;
		
		if(detalleordencompra.getIsNew() || detalleordencompra.getIsChanged()) { 
			this.invalidValues = detalleordencompraValidator.getInvalidValues(detalleordencompra);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(detalleordencompra);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarDetalleOrdenCompra(List<DetalleOrdenCompra> DetalleOrdenCompras) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(DetalleOrdenCompra detalleordencompraLocal:detalleordencompras) {				
			estaValidadoObjeto=this.validarGuardarDetalleOrdenCompra(detalleordencompraLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarDetalleOrdenCompra(List<DetalleOrdenCompra> DetalleOrdenCompras) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarDetalleOrdenCompra(detalleordencompras)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarDetalleOrdenCompra(DetalleOrdenCompra DetalleOrdenCompra) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarDetalleOrdenCompra(detalleordencompra)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(DetalleOrdenCompra detalleordencompra) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+detalleordencompra.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=DetalleOrdenCompraConstantesFunciones.getDetalleOrdenCompraLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"detalleordencompra","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(DetalleOrdenCompraConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(DetalleOrdenCompraConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveDetalleOrdenCompraWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleOrdenCompra.class.getSimpleName()+"-saveDetalleOrdenCompraWithConnection");connexion.begin();			
			
			DetalleOrdenCompraLogicAdditional.checkDetalleOrdenCompraToSave(this.detalleordencompra,this.datosCliente,connexion,this.arrDatoGeneral);
			
			DetalleOrdenCompraLogicAdditional.updateDetalleOrdenCompraToSave(this.detalleordencompra,this.arrDatoGeneral);
			
			DetalleOrdenCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.detalleordencompra,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowDetalleOrdenCompra();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarDetalleOrdenCompra(this.detalleordencompra)) {
				DetalleOrdenCompraDataAccess.save(this.detalleordencompra, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.detalleordencompra,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			DetalleOrdenCompraLogicAdditional.checkDetalleOrdenCompraToSaveAfter(this.detalleordencompra,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowDetalleOrdenCompra();
			
			connexion.commit();			
			
			if(this.detalleordencompra.getIsDeleted()) {
				this.detalleordencompra=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveDetalleOrdenCompra()throws Exception {	
		try {	
			
			DetalleOrdenCompraLogicAdditional.checkDetalleOrdenCompraToSave(this.detalleordencompra,this.datosCliente,connexion,this.arrDatoGeneral);
			
			DetalleOrdenCompraLogicAdditional.updateDetalleOrdenCompraToSave(this.detalleordencompra,this.arrDatoGeneral);
			
			DetalleOrdenCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.detalleordencompra,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarDetalleOrdenCompra(this.detalleordencompra)) {			
				DetalleOrdenCompraDataAccess.save(this.detalleordencompra, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.detalleordencompra,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			DetalleOrdenCompraLogicAdditional.checkDetalleOrdenCompraToSaveAfter(this.detalleordencompra,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.detalleordencompra.getIsDeleted()) {
				this.detalleordencompra=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveDetalleOrdenComprasWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleOrdenCompra.class.getSimpleName()+"-saveDetalleOrdenComprasWithConnection");connexion.begin();			
			
			DetalleOrdenCompraLogicAdditional.checkDetalleOrdenCompraToSaves(detalleordencompras,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowDetalleOrdenCompras();
			
			Boolean validadoTodosDetalleOrdenCompra=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(DetalleOrdenCompra detalleordencompraLocal:detalleordencompras) {		
				if(detalleordencompraLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				DetalleOrdenCompraLogicAdditional.updateDetalleOrdenCompraToSave(detalleordencompraLocal,this.arrDatoGeneral);
	        	
				DetalleOrdenCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),detalleordencompraLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarDetalleOrdenCompra(detalleordencompraLocal)) {
					DetalleOrdenCompraDataAccess.save(detalleordencompraLocal, connexion);				
				} else {
					validadoTodosDetalleOrdenCompra=false;
				}
			}
			
			if(!validadoTodosDetalleOrdenCompra) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			DetalleOrdenCompraLogicAdditional.checkDetalleOrdenCompraToSavesAfter(detalleordencompras,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowDetalleOrdenCompras();
			
			connexion.commit();		
			
			this.quitarDetalleOrdenComprasEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveDetalleOrdenCompras()throws Exception {				
		 try {	
			DetalleOrdenCompraLogicAdditional.checkDetalleOrdenCompraToSaves(detalleordencompras,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosDetalleOrdenCompra=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(DetalleOrdenCompra detalleordencompraLocal:detalleordencompras) {				
				if(detalleordencompraLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				DetalleOrdenCompraLogicAdditional.updateDetalleOrdenCompraToSave(detalleordencompraLocal,this.arrDatoGeneral);
	        	
				DetalleOrdenCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),detalleordencompraLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarDetalleOrdenCompra(detalleordencompraLocal)) {				
					DetalleOrdenCompraDataAccess.save(detalleordencompraLocal, connexion);				
				} else {
					validadoTodosDetalleOrdenCompra=false;
				}
			}
			
			if(!validadoTodosDetalleOrdenCompra) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			DetalleOrdenCompraLogicAdditional.checkDetalleOrdenCompraToSavesAfter(detalleordencompras,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarDetalleOrdenComprasEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public DetalleOrdenCompraParameterReturnGeneral procesarAccionDetalleOrdenCompras(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<DetalleOrdenCompra> detalleordencompras,DetalleOrdenCompraParameterReturnGeneral detalleordencompraParameterGeneral)throws Exception {
		 try {	
			DetalleOrdenCompraParameterReturnGeneral detalleordencompraReturnGeneral=new DetalleOrdenCompraParameterReturnGeneral();
	
			DetalleOrdenCompraLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,detalleordencompras,detalleordencompraParameterGeneral,detalleordencompraReturnGeneral);
			
			return detalleordencompraReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public DetalleOrdenCompraParameterReturnGeneral procesarAccionDetalleOrdenComprasWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<DetalleOrdenCompra> detalleordencompras,DetalleOrdenCompraParameterReturnGeneral detalleordencompraParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleOrdenCompra.class.getSimpleName()+"-procesarAccionDetalleOrdenComprasWithConnection");connexion.begin();			
			
			DetalleOrdenCompraParameterReturnGeneral detalleordencompraReturnGeneral=new DetalleOrdenCompraParameterReturnGeneral();
	
			DetalleOrdenCompraLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,detalleordencompras,detalleordencompraParameterGeneral,detalleordencompraReturnGeneral);
			
			this.connexion.commit();
			
			return detalleordencompraReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public DetalleOrdenCompraParameterReturnGeneral procesarEventosDetalleOrdenCompras(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<DetalleOrdenCompra> detalleordencompras,DetalleOrdenCompra detalleordencompra,DetalleOrdenCompraParameterReturnGeneral detalleordencompraParameterGeneral,Boolean isEsNuevoDetalleOrdenCompra,ArrayList<Classe> clases)throws Exception {
		 try {	
			DetalleOrdenCompraParameterReturnGeneral detalleordencompraReturnGeneral=new DetalleOrdenCompraParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				detalleordencompraReturnGeneral.setConRecargarPropiedades(true);
			}
			
			DetalleOrdenCompraLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,detalleordencompras,detalleordencompra,detalleordencompraParameterGeneral,detalleordencompraReturnGeneral,isEsNuevoDetalleOrdenCompra,clases);
			
			return detalleordencompraReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public DetalleOrdenCompraParameterReturnGeneral procesarEventosDetalleOrdenComprasWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<DetalleOrdenCompra> detalleordencompras,DetalleOrdenCompra detalleordencompra,DetalleOrdenCompraParameterReturnGeneral detalleordencompraParameterGeneral,Boolean isEsNuevoDetalleOrdenCompra,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleOrdenCompra.class.getSimpleName()+"-procesarEventosDetalleOrdenComprasWithConnection");connexion.begin();			
			
			DetalleOrdenCompraParameterReturnGeneral detalleordencompraReturnGeneral=new DetalleOrdenCompraParameterReturnGeneral();
	
			detalleordencompraReturnGeneral.setDetalleOrdenCompra(detalleordencompra);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				detalleordencompraReturnGeneral.setConRecargarPropiedades(true);
			}
			
			DetalleOrdenCompraLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,detalleordencompras,detalleordencompra,detalleordencompraParameterGeneral,detalleordencompraReturnGeneral,isEsNuevoDetalleOrdenCompra,clases);
			
			this.connexion.commit();
			
			return detalleordencompraReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public DetalleOrdenCompraParameterReturnGeneral procesarImportacionDetalleOrdenComprasWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,DetalleOrdenCompraParameterReturnGeneral detalleordencompraParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleOrdenCompra.class.getSimpleName()+"-procesarImportacionDetalleOrdenComprasWithConnection");connexion.begin();			
			
			DetalleOrdenCompraParameterReturnGeneral detalleordencompraReturnGeneral=new DetalleOrdenCompraParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.detalleordencompras=new ArrayList<DetalleOrdenCompra>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.detalleordencompra=new DetalleOrdenCompra();
				
				
				if(conColumnasBase) {this.detalleordencompra.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.detalleordencompra.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.detalleordencompra.setdescripcion(arrColumnas[iColumn++]);
				this.detalleordencompra.setcantidad(Integer.parseInt(arrColumnas[iColumn++]));
				this.detalleordencompra.setcosto_unitario(Double.parseDouble(arrColumnas[iColumn++]));
				this.detalleordencompra.setiva(Double.parseDouble(arrColumnas[iColumn++]));
				this.detalleordencompra.setiva_valor(Double.parseDouble(arrColumnas[iColumn++]));
				this.detalleordencompra.setcosto_total(Double.parseDouble(arrColumnas[iColumn++]));
				this.detalleordencompra.setdisponible(Integer.parseInt(arrColumnas[iColumn++]));
				
				this.detalleordencompras.add(this.detalleordencompra);
			}
			
			this.saveDetalleOrdenCompras();
			
			this.connexion.commit();
			
			detalleordencompraReturnGeneral.setConRetornoEstaProcesado(true);
			detalleordencompraReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return detalleordencompraReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarDetalleOrdenComprasEliminados() throws Exception {				
		
		List<DetalleOrdenCompra> detalleordencomprasAux= new ArrayList<DetalleOrdenCompra>();
		
		for(DetalleOrdenCompra detalleordencompra:detalleordencompras) {
			if(!detalleordencompra.getIsDeleted()) {
				detalleordencomprasAux.add(detalleordencompra);
			}
		}
		
		detalleordencompras=detalleordencomprasAux;
	}
	
	public void quitarDetalleOrdenComprasNulos() throws Exception {				
		
		List<DetalleOrdenCompra> detalleordencomprasAux= new ArrayList<DetalleOrdenCompra>();
		
		for(DetalleOrdenCompra detalleordencompra : this.detalleordencompras) {
			if(detalleordencompra==null) {
				detalleordencomprasAux.add(detalleordencompra);
			}
		}
		
		//this.detalleordencompras=detalleordencomprasAux;
		
		this.detalleordencompras.removeAll(detalleordencomprasAux);
	}
	
	public void getSetVersionRowDetalleOrdenCompraWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(detalleordencompra.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((detalleordencompra.getIsDeleted() || (detalleordencompra.getIsChanged()&&!detalleordencompra.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=detalleordencompraDataAccess.getSetVersionRowDetalleOrdenCompra(connexion,detalleordencompra.getId());
				
				if(!detalleordencompra.getVersionRow().equals(timestamp)) {	
					detalleordencompra.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				detalleordencompra.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowDetalleOrdenCompra()throws Exception {	
		
		if(detalleordencompra.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((detalleordencompra.getIsDeleted() || (detalleordencompra.getIsChanged()&&!detalleordencompra.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=detalleordencompraDataAccess.getSetVersionRowDetalleOrdenCompra(connexion,detalleordencompra.getId());
			
			try {							
				if(!detalleordencompra.getVersionRow().equals(timestamp)) {	
					detalleordencompra.setVersionRow(timestamp);
				}
				
				detalleordencompra.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowDetalleOrdenComprasWithConnection()throws Exception {	
		if(detalleordencompras!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(DetalleOrdenCompra detalleordencompraAux:detalleordencompras) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(detalleordencompraAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(detalleordencompraAux.getIsDeleted() || (detalleordencompraAux.getIsChanged()&&!detalleordencompraAux.getIsNew())) {
						
						timestamp=detalleordencompraDataAccess.getSetVersionRowDetalleOrdenCompra(connexion,detalleordencompraAux.getId());
						
						if(!detalleordencompra.getVersionRow().equals(timestamp)) {	
							detalleordencompraAux.setVersionRow(timestamp);
						}
								
						detalleordencompraAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowDetalleOrdenCompras()throws Exception {	
		if(detalleordencompras!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(DetalleOrdenCompra detalleordencompraAux:detalleordencompras) {
					if(detalleordencompraAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(detalleordencompraAux.getIsDeleted() || (detalleordencompraAux.getIsChanged()&&!detalleordencompraAux.getIsNew())) {
						
						timestamp=detalleordencompraDataAccess.getSetVersionRowDetalleOrdenCompra(connexion,detalleordencompraAux.getId());
						
						if(!detalleordencompraAux.getVersionRow().equals(timestamp)) {	
							detalleordencompraAux.setVersionRow(timestamp);
						}
						
													
						detalleordencompraAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public DetalleOrdenCompraParameterReturnGeneral cargarCombosLoteForeignKeyDetalleOrdenCompraWithConnection(String finalQueryGlobalOrdenCompra,String finalQueryGlobalEmpresa,String finalQueryGlobalSucursal,String finalQueryGlobalEjercicio,String finalQueryGlobalPeriodo,String finalQueryGlobalAnio,String finalQueryGlobalMes,String finalQueryGlobalBodega,String finalQueryGlobalProducto,String finalQueryGlobalUnidad,String finalQueryGlobalNovedadProducto,String finalQueryGlobalEstadoDetalleOrdenCompra) throws Exception {
		DetalleOrdenCompraParameterReturnGeneral  detalleordencompraReturnGeneral =new DetalleOrdenCompraParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleOrdenCompra.class.getSimpleName()+"-cargarCombosLoteForeignKeyDetalleOrdenCompraWithConnection");connexion.begin();
			
			detalleordencompraReturnGeneral =new DetalleOrdenCompraParameterReturnGeneral();
			
			

			List<OrdenCompra> ordencomprasForeignKey=new ArrayList<OrdenCompra>();
			OrdenCompraLogic ordencompraLogic=new OrdenCompraLogic();
			ordencompraLogic.setConnexion(this.connexion);
			ordencompraLogic.getOrdenCompraDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalOrdenCompra.equals("NONE")) {
				ordencompraLogic.getTodosOrdenCompras(finalQueryGlobalOrdenCompra,new Pagination());
				ordencomprasForeignKey=ordencompraLogic.getOrdenCompras();
			}

			detalleordencompraReturnGeneral.setordencomprasForeignKey(ordencomprasForeignKey);


			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			detalleordencompraReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Sucursal> sucursalsForeignKey=new ArrayList<Sucursal>();
			SucursalLogic sucursalLogic=new SucursalLogic();
			sucursalLogic.setConnexion(this.connexion);
			//sucursalLogic.getSucursalDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalSucursal.equals("NONE")) {
				sucursalLogic.getTodosSucursals(finalQueryGlobalSucursal,new Pagination());
				sucursalsForeignKey=sucursalLogic.getSucursals();
			}

			detalleordencompraReturnGeneral.setsucursalsForeignKey(sucursalsForeignKey);


			List<Ejercicio> ejerciciosForeignKey=new ArrayList<Ejercicio>();
			EjercicioLogic ejercicioLogic=new EjercicioLogic();
			ejercicioLogic.setConnexion(this.connexion);
			//ejercicioLogic.getEjercicioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEjercicio.equals("NONE")) {
				ejercicioLogic.getTodosEjercicios(finalQueryGlobalEjercicio,new Pagination());
				ejerciciosForeignKey=ejercicioLogic.getEjercicios();
			}

			detalleordencompraReturnGeneral.setejerciciosForeignKey(ejerciciosForeignKey);


			List<Periodo> periodosForeignKey=new ArrayList<Periodo>();
			PeriodoLogic periodoLogic=new PeriodoLogic();
			periodoLogic.setConnexion(this.connexion);
			//periodoLogic.getPeriodoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalPeriodo.equals("NONE")) {
				periodoLogic.getTodosPeriodos(finalQueryGlobalPeriodo,new Pagination());
				periodosForeignKey=periodoLogic.getPeriodos();
			}

			detalleordencompraReturnGeneral.setperiodosForeignKey(periodosForeignKey);


			List<Anio> aniosForeignKey=new ArrayList<Anio>();
			AnioLogic anioLogic=new AnioLogic();
			anioLogic.setConnexion(this.connexion);
			anioLogic.getAnioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalAnio.equals("NONE")) {
				anioLogic.getTodosAnios(finalQueryGlobalAnio,new Pagination());
				aniosForeignKey=anioLogic.getAnios();
			}

			detalleordencompraReturnGeneral.setaniosForeignKey(aniosForeignKey);


			List<Mes> messForeignKey=new ArrayList<Mes>();
			MesLogic mesLogic=new MesLogic();
			mesLogic.setConnexion(this.connexion);
			mesLogic.getMesDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalMes.equals("NONE")) {
				mesLogic.getTodosMess(finalQueryGlobalMes,new Pagination());
				messForeignKey=mesLogic.getMess();
			}

			detalleordencompraReturnGeneral.setmessForeignKey(messForeignKey);


			List<Bodega> bodegasForeignKey=new ArrayList<Bodega>();
			BodegaLogic bodegaLogic=new BodegaLogic();
			bodegaLogic.setConnexion(this.connexion);
			bodegaLogic.getBodegaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalBodega.equals("NONE")) {
				bodegaLogic.getTodosBodegas(finalQueryGlobalBodega,new Pagination());
				bodegasForeignKey=bodegaLogic.getBodegas();
			}

			detalleordencompraReturnGeneral.setbodegasForeignKey(bodegasForeignKey);


			List<Producto> productosForeignKey=new ArrayList<Producto>();
			ProductoLogic productoLogic=new ProductoLogic();
			productoLogic.setConnexion(this.connexion);
			//productoLogic.getProductoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalProducto.equals("NONE")) {
				productoLogic.getTodosProductos(finalQueryGlobalProducto,new Pagination());
				productosForeignKey=productoLogic.getProductos();
			}

			detalleordencompraReturnGeneral.setproductosForeignKey(productosForeignKey);


			List<Unidad> unidadsForeignKey=new ArrayList<Unidad>();
			UnidadLogic unidadLogic=new UnidadLogic();
			unidadLogic.setConnexion(this.connexion);
			unidadLogic.getUnidadDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalUnidad.equals("NONE")) {
				unidadLogic.getTodosUnidads(finalQueryGlobalUnidad,new Pagination());
				unidadsForeignKey=unidadLogic.getUnidads();
			}

			detalleordencompraReturnGeneral.setunidadsForeignKey(unidadsForeignKey);


			List<NovedadProducto> novedadproductosForeignKey=new ArrayList<NovedadProducto>();
			NovedadProductoLogic novedadproductoLogic=new NovedadProductoLogic();
			novedadproductoLogic.setConnexion(this.connexion);
			novedadproductoLogic.getNovedadProductoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalNovedadProducto.equals("NONE")) {
				novedadproductoLogic.getTodosNovedadProductos(finalQueryGlobalNovedadProducto,new Pagination());
				novedadproductosForeignKey=novedadproductoLogic.getNovedadProductos();
			}

			detalleordencompraReturnGeneral.setnovedadproductosForeignKey(novedadproductosForeignKey);


			List<EstadoDetalleOrdenCompra> estadodetalleordencomprasForeignKey=new ArrayList<EstadoDetalleOrdenCompra>();
			EstadoDetalleOrdenCompraLogic estadodetalleordencompraLogic=new EstadoDetalleOrdenCompraLogic();
			estadodetalleordencompraLogic.setConnexion(this.connexion);
			estadodetalleordencompraLogic.getEstadoDetalleOrdenCompraDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEstadoDetalleOrdenCompra.equals("NONE")) {
				estadodetalleordencompraLogic.getTodosEstadoDetalleOrdenCompras(finalQueryGlobalEstadoDetalleOrdenCompra,new Pagination());
				estadodetalleordencomprasForeignKey=estadodetalleordencompraLogic.getEstadoDetalleOrdenCompras();
			}

			detalleordencompraReturnGeneral.setestadodetalleordencomprasForeignKey(estadodetalleordencomprasForeignKey);

			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
		
		return detalleordencompraReturnGeneral;
	}
	
	public DetalleOrdenCompraParameterReturnGeneral cargarCombosLoteForeignKeyDetalleOrdenCompra(String finalQueryGlobalOrdenCompra,String finalQueryGlobalEmpresa,String finalQueryGlobalSucursal,String finalQueryGlobalEjercicio,String finalQueryGlobalPeriodo,String finalQueryGlobalAnio,String finalQueryGlobalMes,String finalQueryGlobalBodega,String finalQueryGlobalProducto,String finalQueryGlobalUnidad,String finalQueryGlobalNovedadProducto,String finalQueryGlobalEstadoDetalleOrdenCompra) throws Exception {
		DetalleOrdenCompraParameterReturnGeneral  detalleordencompraReturnGeneral =new DetalleOrdenCompraParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {						
			detalleordencompraReturnGeneral =new DetalleOrdenCompraParameterReturnGeneral();
			
			

			List<OrdenCompra> ordencomprasForeignKey=new ArrayList<OrdenCompra>();
			OrdenCompraLogic ordencompraLogic=new OrdenCompraLogic();
			ordencompraLogic.setConnexion(this.connexion);
			ordencompraLogic.getOrdenCompraDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalOrdenCompra.equals("NONE")) {
				ordencompraLogic.getTodosOrdenCompras(finalQueryGlobalOrdenCompra,new Pagination());
				ordencomprasForeignKey=ordencompraLogic.getOrdenCompras();
			}

			detalleordencompraReturnGeneral.setordencomprasForeignKey(ordencomprasForeignKey);


			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			detalleordencompraReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Sucursal> sucursalsForeignKey=new ArrayList<Sucursal>();
			SucursalLogic sucursalLogic=new SucursalLogic();
			sucursalLogic.setConnexion(this.connexion);
			//sucursalLogic.getSucursalDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalSucursal.equals("NONE")) {
				sucursalLogic.getTodosSucursals(finalQueryGlobalSucursal,new Pagination());
				sucursalsForeignKey=sucursalLogic.getSucursals();
			}

			detalleordencompraReturnGeneral.setsucursalsForeignKey(sucursalsForeignKey);


			List<Ejercicio> ejerciciosForeignKey=new ArrayList<Ejercicio>();
			EjercicioLogic ejercicioLogic=new EjercicioLogic();
			ejercicioLogic.setConnexion(this.connexion);
			//ejercicioLogic.getEjercicioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEjercicio.equals("NONE")) {
				ejercicioLogic.getTodosEjercicios(finalQueryGlobalEjercicio,new Pagination());
				ejerciciosForeignKey=ejercicioLogic.getEjercicios();
			}

			detalleordencompraReturnGeneral.setejerciciosForeignKey(ejerciciosForeignKey);


			List<Periodo> periodosForeignKey=new ArrayList<Periodo>();
			PeriodoLogic periodoLogic=new PeriodoLogic();
			periodoLogic.setConnexion(this.connexion);
			//periodoLogic.getPeriodoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalPeriodo.equals("NONE")) {
				periodoLogic.getTodosPeriodos(finalQueryGlobalPeriodo,new Pagination());
				periodosForeignKey=periodoLogic.getPeriodos();
			}

			detalleordencompraReturnGeneral.setperiodosForeignKey(periodosForeignKey);


			List<Anio> aniosForeignKey=new ArrayList<Anio>();
			AnioLogic anioLogic=new AnioLogic();
			anioLogic.setConnexion(this.connexion);
			anioLogic.getAnioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalAnio.equals("NONE")) {
				anioLogic.getTodosAnios(finalQueryGlobalAnio,new Pagination());
				aniosForeignKey=anioLogic.getAnios();
			}

			detalleordencompraReturnGeneral.setaniosForeignKey(aniosForeignKey);


			List<Mes> messForeignKey=new ArrayList<Mes>();
			MesLogic mesLogic=new MesLogic();
			mesLogic.setConnexion(this.connexion);
			mesLogic.getMesDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalMes.equals("NONE")) {
				mesLogic.getTodosMess(finalQueryGlobalMes,new Pagination());
				messForeignKey=mesLogic.getMess();
			}

			detalleordencompraReturnGeneral.setmessForeignKey(messForeignKey);


			List<Bodega> bodegasForeignKey=new ArrayList<Bodega>();
			BodegaLogic bodegaLogic=new BodegaLogic();
			bodegaLogic.setConnexion(this.connexion);
			bodegaLogic.getBodegaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalBodega.equals("NONE")) {
				bodegaLogic.getTodosBodegas(finalQueryGlobalBodega,new Pagination());
				bodegasForeignKey=bodegaLogic.getBodegas();
			}

			detalleordencompraReturnGeneral.setbodegasForeignKey(bodegasForeignKey);


			List<Producto> productosForeignKey=new ArrayList<Producto>();
			ProductoLogic productoLogic=new ProductoLogic();
			productoLogic.setConnexion(this.connexion);
			//productoLogic.getProductoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalProducto.equals("NONE")) {
				productoLogic.getTodosProductos(finalQueryGlobalProducto,new Pagination());
				productosForeignKey=productoLogic.getProductos();
			}

			detalleordencompraReturnGeneral.setproductosForeignKey(productosForeignKey);


			List<Unidad> unidadsForeignKey=new ArrayList<Unidad>();
			UnidadLogic unidadLogic=new UnidadLogic();
			unidadLogic.setConnexion(this.connexion);
			unidadLogic.getUnidadDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalUnidad.equals("NONE")) {
				unidadLogic.getTodosUnidads(finalQueryGlobalUnidad,new Pagination());
				unidadsForeignKey=unidadLogic.getUnidads();
			}

			detalleordencompraReturnGeneral.setunidadsForeignKey(unidadsForeignKey);


			List<NovedadProducto> novedadproductosForeignKey=new ArrayList<NovedadProducto>();
			NovedadProductoLogic novedadproductoLogic=new NovedadProductoLogic();
			novedadproductoLogic.setConnexion(this.connexion);
			novedadproductoLogic.getNovedadProductoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalNovedadProducto.equals("NONE")) {
				novedadproductoLogic.getTodosNovedadProductos(finalQueryGlobalNovedadProducto,new Pagination());
				novedadproductosForeignKey=novedadproductoLogic.getNovedadProductos();
			}

			detalleordencompraReturnGeneral.setnovedadproductosForeignKey(novedadproductosForeignKey);


			List<EstadoDetalleOrdenCompra> estadodetalleordencomprasForeignKey=new ArrayList<EstadoDetalleOrdenCompra>();
			EstadoDetalleOrdenCompraLogic estadodetalleordencompraLogic=new EstadoDetalleOrdenCompraLogic();
			estadodetalleordencompraLogic.setConnexion(this.connexion);
			estadodetalleordencompraLogic.getEstadoDetalleOrdenCompraDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEstadoDetalleOrdenCompra.equals("NONE")) {
				estadodetalleordencompraLogic.getTodosEstadoDetalleOrdenCompras(finalQueryGlobalEstadoDetalleOrdenCompra,new Pagination());
				estadodetalleordencomprasForeignKey=estadodetalleordencompraLogic.getEstadoDetalleOrdenCompras();
			}

			detalleordencompraReturnGeneral.setestadodetalleordencomprasForeignKey(estadodetalleordencomprasForeignKey);
						
			
		} catch(Exception e) {			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			
		}
		
		return detalleordencompraReturnGeneral;
	}
	
	
	public void deepLoad(DetalleOrdenCompra detalleordencompra,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			DetalleOrdenCompraLogicAdditional.updateDetalleOrdenCompraToGet(detalleordencompra,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		detalleordencompra.setOrdenCompra(detalleordencompraDataAccess.getOrdenCompra(connexion,detalleordencompra));
		detalleordencompra.setEmpresa(detalleordencompraDataAccess.getEmpresa(connexion,detalleordencompra));
		detalleordencompra.setSucursal(detalleordencompraDataAccess.getSucursal(connexion,detalleordencompra));
		detalleordencompra.setEjercicio(detalleordencompraDataAccess.getEjercicio(connexion,detalleordencompra));
		detalleordencompra.setPeriodo(detalleordencompraDataAccess.getPeriodo(connexion,detalleordencompra));
		detalleordencompra.setAnio(detalleordencompraDataAccess.getAnio(connexion,detalleordencompra));
		detalleordencompra.setMes(detalleordencompraDataAccess.getMes(connexion,detalleordencompra));
		detalleordencompra.setBodega(detalleordencompraDataAccess.getBodega(connexion,detalleordencompra));
		detalleordencompra.setProducto(detalleordencompraDataAccess.getProducto(connexion,detalleordencompra));
		detalleordencompra.setUnidad(detalleordencompraDataAccess.getUnidad(connexion,detalleordencompra));
		detalleordencompra.setNovedadProducto(detalleordencompraDataAccess.getNovedadProducto(connexion,detalleordencompra));
		detalleordencompra.setEstadoDetalleOrdenCompra(detalleordencompraDataAccess.getEstadoDetalleOrdenCompra(connexion,detalleordencompra));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(OrdenCompra.class)) {
				detalleordencompra.setOrdenCompra(detalleordencompraDataAccess.getOrdenCompra(connexion,detalleordencompra));
				continue;
			}

			if(clas.clas.equals(Empresa.class)) {
				detalleordencompra.setEmpresa(detalleordencompraDataAccess.getEmpresa(connexion,detalleordencompra));
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				detalleordencompra.setSucursal(detalleordencompraDataAccess.getSucursal(connexion,detalleordencompra));
				continue;
			}

			if(clas.clas.equals(Ejercicio.class)) {
				detalleordencompra.setEjercicio(detalleordencompraDataAccess.getEjercicio(connexion,detalleordencompra));
				continue;
			}

			if(clas.clas.equals(Periodo.class)) {
				detalleordencompra.setPeriodo(detalleordencompraDataAccess.getPeriodo(connexion,detalleordencompra));
				continue;
			}

			if(clas.clas.equals(Anio.class)) {
				detalleordencompra.setAnio(detalleordencompraDataAccess.getAnio(connexion,detalleordencompra));
				continue;
			}

			if(clas.clas.equals(Mes.class)) {
				detalleordencompra.setMes(detalleordencompraDataAccess.getMes(connexion,detalleordencompra));
				continue;
			}

			if(clas.clas.equals(Bodega.class)) {
				detalleordencompra.setBodega(detalleordencompraDataAccess.getBodega(connexion,detalleordencompra));
				continue;
			}

			if(clas.clas.equals(Producto.class)) {
				detalleordencompra.setProducto(detalleordencompraDataAccess.getProducto(connexion,detalleordencompra));
				continue;
			}

			if(clas.clas.equals(Unidad.class)) {
				detalleordencompra.setUnidad(detalleordencompraDataAccess.getUnidad(connexion,detalleordencompra));
				continue;
			}

			if(clas.clas.equals(NovedadProducto.class)) {
				detalleordencompra.setNovedadProducto(detalleordencompraDataAccess.getNovedadProducto(connexion,detalleordencompra));
				continue;
			}

			if(clas.clas.equals(EstadoDetalleOrdenCompra.class)) {
				detalleordencompra.setEstadoDetalleOrdenCompra(detalleordencompraDataAccess.getEstadoDetalleOrdenCompra(connexion,detalleordencompra));
				continue;
			}
		}
	}
	else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(OrdenCompra.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detalleordencompra.setOrdenCompra(detalleordencompraDataAccess.getOrdenCompra(connexion,detalleordencompra));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detalleordencompra.setEmpresa(detalleordencompraDataAccess.getEmpresa(connexion,detalleordencompra));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detalleordencompra.setSucursal(detalleordencompraDataAccess.getSucursal(connexion,detalleordencompra));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Ejercicio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detalleordencompra.setEjercicio(detalleordencompraDataAccess.getEjercicio(connexion,detalleordencompra));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Periodo.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detalleordencompra.setPeriodo(detalleordencompraDataAccess.getPeriodo(connexion,detalleordencompra));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Anio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detalleordencompra.setAnio(detalleordencompraDataAccess.getAnio(connexion,detalleordencompra));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Mes.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detalleordencompra.setMes(detalleordencompraDataAccess.getMes(connexion,detalleordencompra));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Bodega.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detalleordencompra.setBodega(detalleordencompraDataAccess.getBodega(connexion,detalleordencompra));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Producto.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detalleordencompra.setProducto(detalleordencompraDataAccess.getProducto(connexion,detalleordencompra));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Unidad.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detalleordencompra.setUnidad(detalleordencompraDataAccess.getUnidad(connexion,detalleordencompra));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(NovedadProducto.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detalleordencompra.setNovedadProducto(detalleordencompraDataAccess.getNovedadProducto(connexion,detalleordencompra));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(EstadoDetalleOrdenCompra.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detalleordencompra.setEstadoDetalleOrdenCompra(detalleordencompraDataAccess.getEstadoDetalleOrdenCompra(connexion,detalleordencompra));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		detalleordencompra.setOrdenCompra(detalleordencompraDataAccess.getOrdenCompra(connexion,detalleordencompra));
		OrdenCompraLogic ordencompraLogic= new OrdenCompraLogic(connexion);
		ordencompraLogic.deepLoad(detalleordencompra.getOrdenCompra(),isDeep,deepLoadType,clases);
				
		detalleordencompra.setEmpresa(detalleordencompraDataAccess.getEmpresa(connexion,detalleordencompra));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(detalleordencompra.getEmpresa(),isDeep,deepLoadType,clases);
				
		detalleordencompra.setSucursal(detalleordencompraDataAccess.getSucursal(connexion,detalleordencompra));
		SucursalLogic sucursalLogic= new SucursalLogic(connexion);
		sucursalLogic.deepLoad(detalleordencompra.getSucursal(),isDeep,deepLoadType,clases);
				
		detalleordencompra.setEjercicio(detalleordencompraDataAccess.getEjercicio(connexion,detalleordencompra));
		EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
		ejercicioLogic.deepLoad(detalleordencompra.getEjercicio(),isDeep,deepLoadType,clases);
				
		detalleordencompra.setPeriodo(detalleordencompraDataAccess.getPeriodo(connexion,detalleordencompra));
		PeriodoLogic periodoLogic= new PeriodoLogic(connexion);
		periodoLogic.deepLoad(detalleordencompra.getPeriodo(),isDeep,deepLoadType,clases);
				
		detalleordencompra.setAnio(detalleordencompraDataAccess.getAnio(connexion,detalleordencompra));
		AnioLogic anioLogic= new AnioLogic(connexion);
		anioLogic.deepLoad(detalleordencompra.getAnio(),isDeep,deepLoadType,clases);
				
		detalleordencompra.setMes(detalleordencompraDataAccess.getMes(connexion,detalleordencompra));
		MesLogic mesLogic= new MesLogic(connexion);
		mesLogic.deepLoad(detalleordencompra.getMes(),isDeep,deepLoadType,clases);
				
		detalleordencompra.setBodega(detalleordencompraDataAccess.getBodega(connexion,detalleordencompra));
		BodegaLogic bodegaLogic= new BodegaLogic(connexion);
		bodegaLogic.deepLoad(detalleordencompra.getBodega(),isDeep,deepLoadType,clases);
				
		detalleordencompra.setProducto(detalleordencompraDataAccess.getProducto(connexion,detalleordencompra));
		ProductoLogic productoLogic= new ProductoLogic(connexion);
		productoLogic.deepLoad(detalleordencompra.getProducto(),isDeep,deepLoadType,clases);
				
		detalleordencompra.setUnidad(detalleordencompraDataAccess.getUnidad(connexion,detalleordencompra));
		UnidadLogic unidadLogic= new UnidadLogic(connexion);
		unidadLogic.deepLoad(detalleordencompra.getUnidad(),isDeep,deepLoadType,clases);
				
		detalleordencompra.setNovedadProducto(detalleordencompraDataAccess.getNovedadProducto(connexion,detalleordencompra));
		NovedadProductoLogic novedadproductoLogic= new NovedadProductoLogic(connexion);
		novedadproductoLogic.deepLoad(detalleordencompra.getNovedadProducto(),isDeep,deepLoadType,clases);
				
		detalleordencompra.setEstadoDetalleOrdenCompra(detalleordencompraDataAccess.getEstadoDetalleOrdenCompra(connexion,detalleordencompra));
		EstadoDetalleOrdenCompraLogic estadodetalleordencompraLogic= new EstadoDetalleOrdenCompraLogic(connexion);
		estadodetalleordencompraLogic.deepLoad(detalleordencompra.getEstadoDetalleOrdenCompra(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(OrdenCompra.class)) {
				detalleordencompra.setOrdenCompra(detalleordencompraDataAccess.getOrdenCompra(connexion,detalleordencompra));
				OrdenCompraLogic ordencompraLogic= new OrdenCompraLogic(connexion);
				ordencompraLogic.deepLoad(detalleordencompra.getOrdenCompra(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Empresa.class)) {
				detalleordencompra.setEmpresa(detalleordencompraDataAccess.getEmpresa(connexion,detalleordencompra));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(detalleordencompra.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				detalleordencompra.setSucursal(detalleordencompraDataAccess.getSucursal(connexion,detalleordencompra));
				SucursalLogic sucursalLogic= new SucursalLogic(connexion);
				sucursalLogic.deepLoad(detalleordencompra.getSucursal(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Ejercicio.class)) {
				detalleordencompra.setEjercicio(detalleordencompraDataAccess.getEjercicio(connexion,detalleordencompra));
				EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
				ejercicioLogic.deepLoad(detalleordencompra.getEjercicio(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Periodo.class)) {
				detalleordencompra.setPeriodo(detalleordencompraDataAccess.getPeriodo(connexion,detalleordencompra));
				PeriodoLogic periodoLogic= new PeriodoLogic(connexion);
				periodoLogic.deepLoad(detalleordencompra.getPeriodo(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Anio.class)) {
				detalleordencompra.setAnio(detalleordencompraDataAccess.getAnio(connexion,detalleordencompra));
				AnioLogic anioLogic= new AnioLogic(connexion);
				anioLogic.deepLoad(detalleordencompra.getAnio(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Mes.class)) {
				detalleordencompra.setMes(detalleordencompraDataAccess.getMes(connexion,detalleordencompra));
				MesLogic mesLogic= new MesLogic(connexion);
				mesLogic.deepLoad(detalleordencompra.getMes(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Bodega.class)) {
				detalleordencompra.setBodega(detalleordencompraDataAccess.getBodega(connexion,detalleordencompra));
				BodegaLogic bodegaLogic= new BodegaLogic(connexion);
				bodegaLogic.deepLoad(detalleordencompra.getBodega(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Producto.class)) {
				detalleordencompra.setProducto(detalleordencompraDataAccess.getProducto(connexion,detalleordencompra));
				ProductoLogic productoLogic= new ProductoLogic(connexion);
				productoLogic.deepLoad(detalleordencompra.getProducto(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Unidad.class)) {
				detalleordencompra.setUnidad(detalleordencompraDataAccess.getUnidad(connexion,detalleordencompra));
				UnidadLogic unidadLogic= new UnidadLogic(connexion);
				unidadLogic.deepLoad(detalleordencompra.getUnidad(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(NovedadProducto.class)) {
				detalleordencompra.setNovedadProducto(detalleordencompraDataAccess.getNovedadProducto(connexion,detalleordencompra));
				NovedadProductoLogic novedadproductoLogic= new NovedadProductoLogic(connexion);
				novedadproductoLogic.deepLoad(detalleordencompra.getNovedadProducto(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(EstadoDetalleOrdenCompra.class)) {
				detalleordencompra.setEstadoDetalleOrdenCompra(detalleordencompraDataAccess.getEstadoDetalleOrdenCompra(connexion,detalleordencompra));
				EstadoDetalleOrdenCompraLogic estadodetalleordencompraLogic= new EstadoDetalleOrdenCompraLogic(connexion);
				estadodetalleordencompraLogic.deepLoad(detalleordencompra.getEstadoDetalleOrdenCompra(),isDeep,deepLoadType,clases);				
				continue;
			}

		}
	}
	else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {


		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(OrdenCompra.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detalleordencompra.setOrdenCompra(detalleordencompraDataAccess.getOrdenCompra(connexion,detalleordencompra));
			OrdenCompraLogic ordencompraLogic= new OrdenCompraLogic(connexion);
			ordencompraLogic.deepLoad(detalleordencompra.getOrdenCompra(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detalleordencompra.setEmpresa(detalleordencompraDataAccess.getEmpresa(connexion,detalleordencompra));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(detalleordencompra.getEmpresa(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detalleordencompra.setSucursal(detalleordencompraDataAccess.getSucursal(connexion,detalleordencompra));
			SucursalLogic sucursalLogic= new SucursalLogic(connexion);
			sucursalLogic.deepLoad(detalleordencompra.getSucursal(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Ejercicio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detalleordencompra.setEjercicio(detalleordencompraDataAccess.getEjercicio(connexion,detalleordencompra));
			EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
			ejercicioLogic.deepLoad(detalleordencompra.getEjercicio(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Periodo.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detalleordencompra.setPeriodo(detalleordencompraDataAccess.getPeriodo(connexion,detalleordencompra));
			PeriodoLogic periodoLogic= new PeriodoLogic(connexion);
			periodoLogic.deepLoad(detalleordencompra.getPeriodo(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Anio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detalleordencompra.setAnio(detalleordencompraDataAccess.getAnio(connexion,detalleordencompra));
			AnioLogic anioLogic= new AnioLogic(connexion);
			anioLogic.deepLoad(detalleordencompra.getAnio(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Mes.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detalleordencompra.setMes(detalleordencompraDataAccess.getMes(connexion,detalleordencompra));
			MesLogic mesLogic= new MesLogic(connexion);
			mesLogic.deepLoad(detalleordencompra.getMes(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Bodega.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detalleordencompra.setBodega(detalleordencompraDataAccess.getBodega(connexion,detalleordencompra));
			BodegaLogic bodegaLogic= new BodegaLogic(connexion);
			bodegaLogic.deepLoad(detalleordencompra.getBodega(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Producto.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detalleordencompra.setProducto(detalleordencompraDataAccess.getProducto(connexion,detalleordencompra));
			ProductoLogic productoLogic= new ProductoLogic(connexion);
			productoLogic.deepLoad(detalleordencompra.getProducto(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Unidad.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detalleordencompra.setUnidad(detalleordencompraDataAccess.getUnidad(connexion,detalleordencompra));
			UnidadLogic unidadLogic= new UnidadLogic(connexion);
			unidadLogic.deepLoad(detalleordencompra.getUnidad(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(NovedadProducto.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detalleordencompra.setNovedadProducto(detalleordencompraDataAccess.getNovedadProducto(connexion,detalleordencompra));
			NovedadProductoLogic novedadproductoLogic= new NovedadProductoLogic(connexion);
			novedadproductoLogic.deepLoad(detalleordencompra.getNovedadProducto(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(EstadoDetalleOrdenCompra.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detalleordencompra.setEstadoDetalleOrdenCompra(detalleordencompraDataAccess.getEstadoDetalleOrdenCompra(connexion,detalleordencompra));
			EstadoDetalleOrdenCompraLogic estadodetalleordencompraLogic= new EstadoDetalleOrdenCompraLogic(connexion);
			estadodetalleordencompraLogic.deepLoad(detalleordencompra.getEstadoDetalleOrdenCompra(),isDeep,deepLoadType,clases);
				
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(DetalleOrdenCompra detalleordencompra,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			DetalleOrdenCompraLogicAdditional.updateDetalleOrdenCompraToSave(detalleordencompra,this.arrDatoGeneral);
			
DetalleOrdenCompraDataAccess.save(detalleordencompra, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		OrdenCompraDataAccess.save(detalleordencompra.getOrdenCompra(),connexion);

		EmpresaDataAccess.save(detalleordencompra.getEmpresa(),connexion);

		SucursalDataAccess.save(detalleordencompra.getSucursal(),connexion);

		EjercicioDataAccess.save(detalleordencompra.getEjercicio(),connexion);

		PeriodoDataAccess.save(detalleordencompra.getPeriodo(),connexion);

		AnioDataAccess.save(detalleordencompra.getAnio(),connexion);

		MesDataAccess.save(detalleordencompra.getMes(),connexion);

		BodegaDataAccess.save(detalleordencompra.getBodega(),connexion);

		ProductoDataAccess.save(detalleordencompra.getProducto(),connexion);

		UnidadDataAccess.save(detalleordencompra.getUnidad(),connexion);

		NovedadProductoDataAccess.save(detalleordencompra.getNovedadProducto(),connexion);

		EstadoDetalleOrdenCompraDataAccess.save(detalleordencompra.getEstadoDetalleOrdenCompra(),connexion);
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(OrdenCompra.class)) {
				OrdenCompraDataAccess.save(detalleordencompra.getOrdenCompra(),connexion);
				continue;
			}

			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(detalleordencompra.getEmpresa(),connexion);
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				SucursalDataAccess.save(detalleordencompra.getSucursal(),connexion);
				continue;
			}

			if(clas.clas.equals(Ejercicio.class)) {
				EjercicioDataAccess.save(detalleordencompra.getEjercicio(),connexion);
				continue;
			}

			if(clas.clas.equals(Periodo.class)) {
				PeriodoDataAccess.save(detalleordencompra.getPeriodo(),connexion);
				continue;
			}

			if(clas.clas.equals(Anio.class)) {
				AnioDataAccess.save(detalleordencompra.getAnio(),connexion);
				continue;
			}

			if(clas.clas.equals(Mes.class)) {
				MesDataAccess.save(detalleordencompra.getMes(),connexion);
				continue;
			}

			if(clas.clas.equals(Bodega.class)) {
				BodegaDataAccess.save(detalleordencompra.getBodega(),connexion);
				continue;
			}

			if(clas.clas.equals(Producto.class)) {
				ProductoDataAccess.save(detalleordencompra.getProducto(),connexion);
				continue;
			}

			if(clas.clas.equals(Unidad.class)) {
				UnidadDataAccess.save(detalleordencompra.getUnidad(),connexion);
				continue;
			}

			if(clas.clas.equals(NovedadProducto.class)) {
				NovedadProductoDataAccess.save(detalleordencompra.getNovedadProducto(),connexion);
				continue;
			}

			if(clas.clas.equals(EstadoDetalleOrdenCompra.class)) {
				EstadoDetalleOrdenCompraDataAccess.save(detalleordencompra.getEstadoDetalleOrdenCompra(),connexion);
				continue;
			}

		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		OrdenCompraDataAccess.save(detalleordencompra.getOrdenCompra(),connexion);
		OrdenCompraLogic ordencompraLogic= new OrdenCompraLogic(connexion);
		ordencompraLogic.deepLoad(detalleordencompra.getOrdenCompra(),isDeep,deepLoadType,clases);
				

		EmpresaDataAccess.save(detalleordencompra.getEmpresa(),connexion);
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(detalleordencompra.getEmpresa(),isDeep,deepLoadType,clases);
				

		SucursalDataAccess.save(detalleordencompra.getSucursal(),connexion);
		SucursalLogic sucursalLogic= new SucursalLogic(connexion);
		sucursalLogic.deepLoad(detalleordencompra.getSucursal(),isDeep,deepLoadType,clases);
				

		EjercicioDataAccess.save(detalleordencompra.getEjercicio(),connexion);
		EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
		ejercicioLogic.deepLoad(detalleordencompra.getEjercicio(),isDeep,deepLoadType,clases);
				

		PeriodoDataAccess.save(detalleordencompra.getPeriodo(),connexion);
		PeriodoLogic periodoLogic= new PeriodoLogic(connexion);
		periodoLogic.deepLoad(detalleordencompra.getPeriodo(),isDeep,deepLoadType,clases);
				

		AnioDataAccess.save(detalleordencompra.getAnio(),connexion);
		AnioLogic anioLogic= new AnioLogic(connexion);
		anioLogic.deepLoad(detalleordencompra.getAnio(),isDeep,deepLoadType,clases);
				

		MesDataAccess.save(detalleordencompra.getMes(),connexion);
		MesLogic mesLogic= new MesLogic(connexion);
		mesLogic.deepLoad(detalleordencompra.getMes(),isDeep,deepLoadType,clases);
				

		BodegaDataAccess.save(detalleordencompra.getBodega(),connexion);
		BodegaLogic bodegaLogic= new BodegaLogic(connexion);
		bodegaLogic.deepLoad(detalleordencompra.getBodega(),isDeep,deepLoadType,clases);
				

		ProductoDataAccess.save(detalleordencompra.getProducto(),connexion);
		ProductoLogic productoLogic= new ProductoLogic(connexion);
		productoLogic.deepLoad(detalleordencompra.getProducto(),isDeep,deepLoadType,clases);
				

		UnidadDataAccess.save(detalleordencompra.getUnidad(),connexion);
		UnidadLogic unidadLogic= new UnidadLogic(connexion);
		unidadLogic.deepLoad(detalleordencompra.getUnidad(),isDeep,deepLoadType,clases);
				

		NovedadProductoDataAccess.save(detalleordencompra.getNovedadProducto(),connexion);
		NovedadProductoLogic novedadproductoLogic= new NovedadProductoLogic(connexion);
		novedadproductoLogic.deepLoad(detalleordencompra.getNovedadProducto(),isDeep,deepLoadType,clases);
				

		EstadoDetalleOrdenCompraDataAccess.save(detalleordencompra.getEstadoDetalleOrdenCompra(),connexion);
		EstadoDetalleOrdenCompraLogic estadodetalleordencompraLogic= new EstadoDetalleOrdenCompraLogic(connexion);
		estadodetalleordencompraLogic.deepLoad(detalleordencompra.getEstadoDetalleOrdenCompra(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(OrdenCompra.class)) {
				OrdenCompraDataAccess.save(detalleordencompra.getOrdenCompra(),connexion);
				OrdenCompraLogic ordencompraLogic= new OrdenCompraLogic(connexion);
				ordencompraLogic.deepSave(detalleordencompra.getOrdenCompra(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(detalleordencompra.getEmpresa(),connexion);
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepSave(detalleordencompra.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				SucursalDataAccess.save(detalleordencompra.getSucursal(),connexion);
				SucursalLogic sucursalLogic= new SucursalLogic(connexion);
				sucursalLogic.deepSave(detalleordencompra.getSucursal(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Ejercicio.class)) {
				EjercicioDataAccess.save(detalleordencompra.getEjercicio(),connexion);
				EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
				ejercicioLogic.deepSave(detalleordencompra.getEjercicio(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Periodo.class)) {
				PeriodoDataAccess.save(detalleordencompra.getPeriodo(),connexion);
				PeriodoLogic periodoLogic= new PeriodoLogic(connexion);
				periodoLogic.deepSave(detalleordencompra.getPeriodo(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Anio.class)) {
				AnioDataAccess.save(detalleordencompra.getAnio(),connexion);
				AnioLogic anioLogic= new AnioLogic(connexion);
				anioLogic.deepSave(detalleordencompra.getAnio(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Mes.class)) {
				MesDataAccess.save(detalleordencompra.getMes(),connexion);
				MesLogic mesLogic= new MesLogic(connexion);
				mesLogic.deepSave(detalleordencompra.getMes(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Bodega.class)) {
				BodegaDataAccess.save(detalleordencompra.getBodega(),connexion);
				BodegaLogic bodegaLogic= new BodegaLogic(connexion);
				bodegaLogic.deepSave(detalleordencompra.getBodega(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Producto.class)) {
				ProductoDataAccess.save(detalleordencompra.getProducto(),connexion);
				ProductoLogic productoLogic= new ProductoLogic(connexion);
				productoLogic.deepSave(detalleordencompra.getProducto(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Unidad.class)) {
				UnidadDataAccess.save(detalleordencompra.getUnidad(),connexion);
				UnidadLogic unidadLogic= new UnidadLogic(connexion);
				unidadLogic.deepSave(detalleordencompra.getUnidad(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(NovedadProducto.class)) {
				NovedadProductoDataAccess.save(detalleordencompra.getNovedadProducto(),connexion);
				NovedadProductoLogic novedadproductoLogic= new NovedadProductoLogic(connexion);
				novedadproductoLogic.deepSave(detalleordencompra.getNovedadProducto(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(EstadoDetalleOrdenCompra.class)) {
				EstadoDetalleOrdenCompraDataAccess.save(detalleordencompra.getEstadoDetalleOrdenCompra(),connexion);
				EstadoDetalleOrdenCompraLogic estadodetalleordencompraLogic= new EstadoDetalleOrdenCompraLogic(connexion);
				estadodetalleordencompraLogic.deepSave(detalleordencompra.getEstadoDetalleOrdenCompra(),isDeep,deepLoadType,clases);				
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
			this.getNewConnexionToDeep(DetalleOrdenCompra.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(detalleordencompra,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				DetalleOrdenCompraConstantesFunciones.refrescarForeignKeysDescripcionesDetalleOrdenCompra(detalleordencompra);
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
			this.deepLoad(this.detalleordencompra,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				DetalleOrdenCompraConstantesFunciones.refrescarForeignKeysDescripcionesDetalleOrdenCompra(this.detalleordencompra);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(DetalleOrdenCompra.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(detalleordencompras!=null) {
				for(DetalleOrdenCompra detalleordencompra:detalleordencompras) {
					this.deepLoad(detalleordencompra,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					DetalleOrdenCompraConstantesFunciones.refrescarForeignKeysDescripcionesDetalleOrdenCompra(detalleordencompras);
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
			if(detalleordencompras!=null) {
				for(DetalleOrdenCompra detalleordencompra:detalleordencompras) {
					this.deepLoad(detalleordencompra,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					DetalleOrdenCompraConstantesFunciones.refrescarForeignKeysDescripcionesDetalleOrdenCompra(detalleordencompras);
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
			this.getNewConnexionToDeep(DetalleOrdenCompra.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(detalleordencompra,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(DetalleOrdenCompra.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(detalleordencompras!=null) {
				for(DetalleOrdenCompra detalleordencompra:detalleordencompras) {
					this.deepSave(detalleordencompra,isDeep,deepLoadType,clases);
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
			if(detalleordencompras!=null) {
				for(DetalleOrdenCompra detalleordencompra:detalleordencompras) {
					this.deepSave(detalleordencompra,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getDetalleOrdenComprasFK_IdAnioWithConnection(String sFinalQuery,Pagination pagination,Long id_anio)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleOrdenCompra.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidAnio= new ParameterSelectionGeneral();
			parameterSelectionGeneralidAnio.setParameterSelectionGeneralEqual(ParameterType.LONG,id_anio,DetalleOrdenCompraConstantesFunciones.IDANIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidAnio);

			DetalleOrdenCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdAnio","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detalleordencompras=detalleordencompraDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleOrdenCompraConstantesFunciones.refrescarForeignKeysDescripcionesDetalleOrdenCompra(this.detalleordencompras);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getDetalleOrdenComprasFK_IdAnio(String sFinalQuery,Pagination pagination,Long id_anio)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidAnio= new ParameterSelectionGeneral();
			parameterSelectionGeneralidAnio.setParameterSelectionGeneralEqual(ParameterType.LONG,id_anio,DetalleOrdenCompraConstantesFunciones.IDANIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidAnio);

			DetalleOrdenCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdAnio","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detalleordencompras=detalleordencompraDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleOrdenCompraConstantesFunciones.refrescarForeignKeysDescripcionesDetalleOrdenCompra(this.detalleordencompras);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getDetalleOrdenComprasFK_IdBodegaWithConnection(String sFinalQuery,Pagination pagination,Long id_bodega)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleOrdenCompra.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidBodega= new ParameterSelectionGeneral();
			parameterSelectionGeneralidBodega.setParameterSelectionGeneralEqual(ParameterType.LONG,id_bodega,DetalleOrdenCompraConstantesFunciones.IDBODEGA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidBodega);

			DetalleOrdenCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdBodega","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detalleordencompras=detalleordencompraDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleOrdenCompraConstantesFunciones.refrescarForeignKeysDescripcionesDetalleOrdenCompra(this.detalleordencompras);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getDetalleOrdenComprasFK_IdBodega(String sFinalQuery,Pagination pagination,Long id_bodega)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidBodega= new ParameterSelectionGeneral();
			parameterSelectionGeneralidBodega.setParameterSelectionGeneralEqual(ParameterType.LONG,id_bodega,DetalleOrdenCompraConstantesFunciones.IDBODEGA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidBodega);

			DetalleOrdenCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdBodega","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detalleordencompras=detalleordencompraDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleOrdenCompraConstantesFunciones.refrescarForeignKeysDescripcionesDetalleOrdenCompra(this.detalleordencompras);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getDetalleOrdenComprasFK_IdEjercicioWithConnection(String sFinalQuery,Pagination pagination,Long id_ejercicio)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleOrdenCompra.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEjercicio= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEjercicio.setParameterSelectionGeneralEqual(ParameterType.LONG,id_ejercicio,DetalleOrdenCompraConstantesFunciones.IDEJERCICIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEjercicio);

			DetalleOrdenCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEjercicio","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detalleordencompras=detalleordencompraDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleOrdenCompraConstantesFunciones.refrescarForeignKeysDescripcionesDetalleOrdenCompra(this.detalleordencompras);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getDetalleOrdenComprasFK_IdEjercicio(String sFinalQuery,Pagination pagination,Long id_ejercicio)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEjercicio= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEjercicio.setParameterSelectionGeneralEqual(ParameterType.LONG,id_ejercicio,DetalleOrdenCompraConstantesFunciones.IDEJERCICIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEjercicio);

			DetalleOrdenCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEjercicio","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detalleordencompras=detalleordencompraDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleOrdenCompraConstantesFunciones.refrescarForeignKeysDescripcionesDetalleOrdenCompra(this.detalleordencompras);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getDetalleOrdenComprasFK_IdEmpresaWithConnection(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleOrdenCompra.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,DetalleOrdenCompraConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			DetalleOrdenCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detalleordencompras=detalleordencompraDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleOrdenCompraConstantesFunciones.refrescarForeignKeysDescripcionesDetalleOrdenCompra(this.detalleordencompras);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getDetalleOrdenComprasFK_IdEmpresa(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,DetalleOrdenCompraConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			DetalleOrdenCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detalleordencompras=detalleordencompraDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleOrdenCompraConstantesFunciones.refrescarForeignKeysDescripcionesDetalleOrdenCompra(this.detalleordencompras);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getDetalleOrdenComprasFK_IdEstadoDetalleOrdenCompraWithConnection(String sFinalQuery,Pagination pagination,Long id_estado_detalle_orden_compra)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleOrdenCompra.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEstadoDetalleOrdenCompra= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEstadoDetalleOrdenCompra.setParameterSelectionGeneralEqual(ParameterType.LONG,id_estado_detalle_orden_compra,DetalleOrdenCompraConstantesFunciones.IDESTADODETALLEORDENCOMPRA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEstadoDetalleOrdenCompra);

			DetalleOrdenCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEstadoDetalleOrdenCompra","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detalleordencompras=detalleordencompraDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleOrdenCompraConstantesFunciones.refrescarForeignKeysDescripcionesDetalleOrdenCompra(this.detalleordencompras);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getDetalleOrdenComprasFK_IdEstadoDetalleOrdenCompra(String sFinalQuery,Pagination pagination,Long id_estado_detalle_orden_compra)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEstadoDetalleOrdenCompra= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEstadoDetalleOrdenCompra.setParameterSelectionGeneralEqual(ParameterType.LONG,id_estado_detalle_orden_compra,DetalleOrdenCompraConstantesFunciones.IDESTADODETALLEORDENCOMPRA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEstadoDetalleOrdenCompra);

			DetalleOrdenCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEstadoDetalleOrdenCompra","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detalleordencompras=detalleordencompraDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleOrdenCompraConstantesFunciones.refrescarForeignKeysDescripcionesDetalleOrdenCompra(this.detalleordencompras);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getDetalleOrdenComprasFK_IdMesWithConnection(String sFinalQuery,Pagination pagination,Long id_mes)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleOrdenCompra.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidMes= new ParameterSelectionGeneral();
			parameterSelectionGeneralidMes.setParameterSelectionGeneralEqual(ParameterType.LONG,id_mes,DetalleOrdenCompraConstantesFunciones.IDMES,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidMes);

			DetalleOrdenCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdMes","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detalleordencompras=detalleordencompraDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleOrdenCompraConstantesFunciones.refrescarForeignKeysDescripcionesDetalleOrdenCompra(this.detalleordencompras);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getDetalleOrdenComprasFK_IdMes(String sFinalQuery,Pagination pagination,Long id_mes)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidMes= new ParameterSelectionGeneral();
			parameterSelectionGeneralidMes.setParameterSelectionGeneralEqual(ParameterType.LONG,id_mes,DetalleOrdenCompraConstantesFunciones.IDMES,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidMes);

			DetalleOrdenCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdMes","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detalleordencompras=detalleordencompraDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleOrdenCompraConstantesFunciones.refrescarForeignKeysDescripcionesDetalleOrdenCompra(this.detalleordencompras);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getDetalleOrdenComprasFK_IdNovedadProductoWithConnection(String sFinalQuery,Pagination pagination,Long id_novedad_producto)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleOrdenCompra.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidNovedadProducto= new ParameterSelectionGeneral();
			parameterSelectionGeneralidNovedadProducto.setParameterSelectionGeneralEqual(ParameterType.LONG,id_novedad_producto,DetalleOrdenCompraConstantesFunciones.IDNOVEDADPRODUCTO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidNovedadProducto);

			DetalleOrdenCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdNovedadProducto","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detalleordencompras=detalleordencompraDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleOrdenCompraConstantesFunciones.refrescarForeignKeysDescripcionesDetalleOrdenCompra(this.detalleordencompras);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getDetalleOrdenComprasFK_IdNovedadProducto(String sFinalQuery,Pagination pagination,Long id_novedad_producto)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidNovedadProducto= new ParameterSelectionGeneral();
			parameterSelectionGeneralidNovedadProducto.setParameterSelectionGeneralEqual(ParameterType.LONG,id_novedad_producto,DetalleOrdenCompraConstantesFunciones.IDNOVEDADPRODUCTO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidNovedadProducto);

			DetalleOrdenCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdNovedadProducto","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detalleordencompras=detalleordencompraDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleOrdenCompraConstantesFunciones.refrescarForeignKeysDescripcionesDetalleOrdenCompra(this.detalleordencompras);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getDetalleOrdenComprasFK_IdOrdenCompraWithConnection(String sFinalQuery,Pagination pagination,Long id_orden_compra)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleOrdenCompra.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidOrdenCompra= new ParameterSelectionGeneral();
			parameterSelectionGeneralidOrdenCompra.setParameterSelectionGeneralEqual(ParameterType.LONG,id_orden_compra,DetalleOrdenCompraConstantesFunciones.IDORDENCOMPRA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidOrdenCompra);

			DetalleOrdenCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdOrdenCompra","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detalleordencompras=detalleordencompraDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleOrdenCompraConstantesFunciones.refrescarForeignKeysDescripcionesDetalleOrdenCompra(this.detalleordencompras);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getDetalleOrdenComprasFK_IdOrdenCompra(String sFinalQuery,Pagination pagination,Long id_orden_compra)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidOrdenCompra= new ParameterSelectionGeneral();
			parameterSelectionGeneralidOrdenCompra.setParameterSelectionGeneralEqual(ParameterType.LONG,id_orden_compra,DetalleOrdenCompraConstantesFunciones.IDORDENCOMPRA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidOrdenCompra);

			DetalleOrdenCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdOrdenCompra","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detalleordencompras=detalleordencompraDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleOrdenCompraConstantesFunciones.refrescarForeignKeysDescripcionesDetalleOrdenCompra(this.detalleordencompras);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getDetalleOrdenComprasFK_IdPeriodoWithConnection(String sFinalQuery,Pagination pagination,Long id_periodo)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleOrdenCompra.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidPeriodo= new ParameterSelectionGeneral();
			parameterSelectionGeneralidPeriodo.setParameterSelectionGeneralEqual(ParameterType.LONG,id_periodo,DetalleOrdenCompraConstantesFunciones.IDPERIODO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidPeriodo);

			DetalleOrdenCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdPeriodo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detalleordencompras=detalleordencompraDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleOrdenCompraConstantesFunciones.refrescarForeignKeysDescripcionesDetalleOrdenCompra(this.detalleordencompras);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getDetalleOrdenComprasFK_IdPeriodo(String sFinalQuery,Pagination pagination,Long id_periodo)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidPeriodo= new ParameterSelectionGeneral();
			parameterSelectionGeneralidPeriodo.setParameterSelectionGeneralEqual(ParameterType.LONG,id_periodo,DetalleOrdenCompraConstantesFunciones.IDPERIODO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidPeriodo);

			DetalleOrdenCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdPeriodo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detalleordencompras=detalleordencompraDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleOrdenCompraConstantesFunciones.refrescarForeignKeysDescripcionesDetalleOrdenCompra(this.detalleordencompras);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getDetalleOrdenComprasFK_IdProductoWithConnection(String sFinalQuery,Pagination pagination,Long id_producto)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleOrdenCompra.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidProducto= new ParameterSelectionGeneral();
			parameterSelectionGeneralidProducto.setParameterSelectionGeneralEqual(ParameterType.LONG,id_producto,DetalleOrdenCompraConstantesFunciones.IDPRODUCTO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidProducto);

			DetalleOrdenCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdProducto","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detalleordencompras=detalleordencompraDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleOrdenCompraConstantesFunciones.refrescarForeignKeysDescripcionesDetalleOrdenCompra(this.detalleordencompras);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getDetalleOrdenComprasFK_IdProducto(String sFinalQuery,Pagination pagination,Long id_producto)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidProducto= new ParameterSelectionGeneral();
			parameterSelectionGeneralidProducto.setParameterSelectionGeneralEqual(ParameterType.LONG,id_producto,DetalleOrdenCompraConstantesFunciones.IDPRODUCTO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidProducto);

			DetalleOrdenCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdProducto","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detalleordencompras=detalleordencompraDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleOrdenCompraConstantesFunciones.refrescarForeignKeysDescripcionesDetalleOrdenCompra(this.detalleordencompras);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getDetalleOrdenComprasFK_IdSucursalWithConnection(String sFinalQuery,Pagination pagination,Long id_sucursal)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleOrdenCompra.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidSucursal= new ParameterSelectionGeneral();
			parameterSelectionGeneralidSucursal.setParameterSelectionGeneralEqual(ParameterType.LONG,id_sucursal,DetalleOrdenCompraConstantesFunciones.IDSUCURSAL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidSucursal);

			DetalleOrdenCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdSucursal","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detalleordencompras=detalleordencompraDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleOrdenCompraConstantesFunciones.refrescarForeignKeysDescripcionesDetalleOrdenCompra(this.detalleordencompras);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getDetalleOrdenComprasFK_IdSucursal(String sFinalQuery,Pagination pagination,Long id_sucursal)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidSucursal= new ParameterSelectionGeneral();
			parameterSelectionGeneralidSucursal.setParameterSelectionGeneralEqual(ParameterType.LONG,id_sucursal,DetalleOrdenCompraConstantesFunciones.IDSUCURSAL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidSucursal);

			DetalleOrdenCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdSucursal","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detalleordencompras=detalleordencompraDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleOrdenCompraConstantesFunciones.refrescarForeignKeysDescripcionesDetalleOrdenCompra(this.detalleordencompras);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getDetalleOrdenComprasFK_IdUnidadWithConnection(String sFinalQuery,Pagination pagination,Long id_unidad)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleOrdenCompra.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidUnidad= new ParameterSelectionGeneral();
			parameterSelectionGeneralidUnidad.setParameterSelectionGeneralEqual(ParameterType.LONG,id_unidad,DetalleOrdenCompraConstantesFunciones.IDUNIDAD,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidUnidad);

			DetalleOrdenCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdUnidad","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detalleordencompras=detalleordencompraDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleOrdenCompraConstantesFunciones.refrescarForeignKeysDescripcionesDetalleOrdenCompra(this.detalleordencompras);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getDetalleOrdenComprasFK_IdUnidad(String sFinalQuery,Pagination pagination,Long id_unidad)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidUnidad= new ParameterSelectionGeneral();
			parameterSelectionGeneralidUnidad.setParameterSelectionGeneralEqual(ParameterType.LONG,id_unidad,DetalleOrdenCompraConstantesFunciones.IDUNIDAD,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidUnidad);

			DetalleOrdenCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdUnidad","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detalleordencompras=detalleordencompraDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleOrdenCompraConstantesFunciones.refrescarForeignKeysDescripcionesDetalleOrdenCompra(this.detalleordencompras);
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
			if(DetalleOrdenCompraConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,DetalleOrdenCompraDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,DetalleOrdenCompra detalleordencompra,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(DetalleOrdenCompraConstantesFunciones.ISCONAUDITORIA) {
				if(detalleordencompra.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,DetalleOrdenCompraDataAccess.TABLENAME, detalleordencompra.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(DetalleOrdenCompraConstantesFunciones.ISCONAUDITORIADETALLE) {
						////DetalleOrdenCompraLogic.registrarAuditoriaDetallesDetalleOrdenCompra(connexion,detalleordencompra,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(detalleordencompra.getIsDeleted()) {
					/*if(!detalleordencompra.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,DetalleOrdenCompraDataAccess.TABLENAME, detalleordencompra.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////DetalleOrdenCompraLogic.registrarAuditoriaDetallesDetalleOrdenCompra(connexion,detalleordencompra,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,DetalleOrdenCompraDataAccess.TABLENAME, detalleordencompra.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(detalleordencompra.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,DetalleOrdenCompraDataAccess.TABLENAME, detalleordencompra.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(DetalleOrdenCompraConstantesFunciones.ISCONAUDITORIADETALLE) {
						////DetalleOrdenCompraLogic.registrarAuditoriaDetallesDetalleOrdenCompra(connexion,detalleordencompra,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesDetalleOrdenCompra(Connexion connexion,DetalleOrdenCompra detalleordencompra)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(detalleordencompra.getIsNew()||!detalleordencompra.getid_orden_compra().equals(detalleordencompra.getDetalleOrdenCompraOriginal().getid_orden_compra()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detalleordencompra.getDetalleOrdenCompraOriginal().getid_orden_compra()!=null)
				{
					strValorActual=detalleordencompra.getDetalleOrdenCompraOriginal().getid_orden_compra().toString();
				}
				if(detalleordencompra.getid_orden_compra()!=null)
				{
					strValorNuevo=detalleordencompra.getid_orden_compra().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleOrdenCompraConstantesFunciones.IDORDENCOMPRA,strValorActual,strValorNuevo);
			}	
			
			if(detalleordencompra.getIsNew()||!detalleordencompra.getid_empresa().equals(detalleordencompra.getDetalleOrdenCompraOriginal().getid_empresa()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detalleordencompra.getDetalleOrdenCompraOriginal().getid_empresa()!=null)
				{
					strValorActual=detalleordencompra.getDetalleOrdenCompraOriginal().getid_empresa().toString();
				}
				if(detalleordencompra.getid_empresa()!=null)
				{
					strValorNuevo=detalleordencompra.getid_empresa().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleOrdenCompraConstantesFunciones.IDEMPRESA,strValorActual,strValorNuevo);
			}	
			
			if(detalleordencompra.getIsNew()||!detalleordencompra.getid_sucursal().equals(detalleordencompra.getDetalleOrdenCompraOriginal().getid_sucursal()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detalleordencompra.getDetalleOrdenCompraOriginal().getid_sucursal()!=null)
				{
					strValorActual=detalleordencompra.getDetalleOrdenCompraOriginal().getid_sucursal().toString();
				}
				if(detalleordencompra.getid_sucursal()!=null)
				{
					strValorNuevo=detalleordencompra.getid_sucursal().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleOrdenCompraConstantesFunciones.IDSUCURSAL,strValorActual,strValorNuevo);
			}	
			
			if(detalleordencompra.getIsNew()||!detalleordencompra.getid_ejercicio().equals(detalleordencompra.getDetalleOrdenCompraOriginal().getid_ejercicio()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detalleordencompra.getDetalleOrdenCompraOriginal().getid_ejercicio()!=null)
				{
					strValorActual=detalleordencompra.getDetalleOrdenCompraOriginal().getid_ejercicio().toString();
				}
				if(detalleordencompra.getid_ejercicio()!=null)
				{
					strValorNuevo=detalleordencompra.getid_ejercicio().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleOrdenCompraConstantesFunciones.IDEJERCICIO,strValorActual,strValorNuevo);
			}	
			
			if(detalleordencompra.getIsNew()||!detalleordencompra.getid_periodo().equals(detalleordencompra.getDetalleOrdenCompraOriginal().getid_periodo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detalleordencompra.getDetalleOrdenCompraOriginal().getid_periodo()!=null)
				{
					strValorActual=detalleordencompra.getDetalleOrdenCompraOriginal().getid_periodo().toString();
				}
				if(detalleordencompra.getid_periodo()!=null)
				{
					strValorNuevo=detalleordencompra.getid_periodo().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleOrdenCompraConstantesFunciones.IDPERIODO,strValorActual,strValorNuevo);
			}	
			
			if(detalleordencompra.getIsNew()||!detalleordencompra.getid_anio().equals(detalleordencompra.getDetalleOrdenCompraOriginal().getid_anio()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detalleordencompra.getDetalleOrdenCompraOriginal().getid_anio()!=null)
				{
					strValorActual=detalleordencompra.getDetalleOrdenCompraOriginal().getid_anio().toString();
				}
				if(detalleordencompra.getid_anio()!=null)
				{
					strValorNuevo=detalleordencompra.getid_anio().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleOrdenCompraConstantesFunciones.IDANIO,strValorActual,strValorNuevo);
			}	
			
			if(detalleordencompra.getIsNew()||!detalleordencompra.getid_mes().equals(detalleordencompra.getDetalleOrdenCompraOriginal().getid_mes()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detalleordencompra.getDetalleOrdenCompraOriginal().getid_mes()!=null)
				{
					strValorActual=detalleordencompra.getDetalleOrdenCompraOriginal().getid_mes().toString();
				}
				if(detalleordencompra.getid_mes()!=null)
				{
					strValorNuevo=detalleordencompra.getid_mes().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleOrdenCompraConstantesFunciones.IDMES,strValorActual,strValorNuevo);
			}	
			
			if(detalleordencompra.getIsNew()||!detalleordencompra.getid_bodega().equals(detalleordencompra.getDetalleOrdenCompraOriginal().getid_bodega()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detalleordencompra.getDetalleOrdenCompraOriginal().getid_bodega()!=null)
				{
					strValorActual=detalleordencompra.getDetalleOrdenCompraOriginal().getid_bodega().toString();
				}
				if(detalleordencompra.getid_bodega()!=null)
				{
					strValorNuevo=detalleordencompra.getid_bodega().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleOrdenCompraConstantesFunciones.IDBODEGA,strValorActual,strValorNuevo);
			}	
			
			if(detalleordencompra.getIsNew()||!detalleordencompra.getid_producto().equals(detalleordencompra.getDetalleOrdenCompraOriginal().getid_producto()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detalleordencompra.getDetalleOrdenCompraOriginal().getid_producto()!=null)
				{
					strValorActual=detalleordencompra.getDetalleOrdenCompraOriginal().getid_producto().toString();
				}
				if(detalleordencompra.getid_producto()!=null)
				{
					strValorNuevo=detalleordencompra.getid_producto().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleOrdenCompraConstantesFunciones.IDPRODUCTO,strValorActual,strValorNuevo);
			}	
			
			if(detalleordencompra.getIsNew()||!detalleordencompra.getid_unidad().equals(detalleordencompra.getDetalleOrdenCompraOriginal().getid_unidad()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detalleordencompra.getDetalleOrdenCompraOriginal().getid_unidad()!=null)
				{
					strValorActual=detalleordencompra.getDetalleOrdenCompraOriginal().getid_unidad().toString();
				}
				if(detalleordencompra.getid_unidad()!=null)
				{
					strValorNuevo=detalleordencompra.getid_unidad().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleOrdenCompraConstantesFunciones.IDUNIDAD,strValorActual,strValorNuevo);
			}	
			
			if(detalleordencompra.getIsNew()||!detalleordencompra.getdescripcion().equals(detalleordencompra.getDetalleOrdenCompraOriginal().getdescripcion()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detalleordencompra.getDetalleOrdenCompraOriginal().getdescripcion()!=null)
				{
					strValorActual=detalleordencompra.getDetalleOrdenCompraOriginal().getdescripcion();
				}
				if(detalleordencompra.getdescripcion()!=null)
				{
					strValorNuevo=detalleordencompra.getdescripcion() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleOrdenCompraConstantesFunciones.DESCRIPCION,strValorActual,strValorNuevo);
			}	
			
			if(detalleordencompra.getIsNew()||!detalleordencompra.getcantidad().equals(detalleordencompra.getDetalleOrdenCompraOriginal().getcantidad()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detalleordencompra.getDetalleOrdenCompraOriginal().getcantidad()!=null)
				{
					strValorActual=detalleordencompra.getDetalleOrdenCompraOriginal().getcantidad().toString();
				}
				if(detalleordencompra.getcantidad()!=null)
				{
					strValorNuevo=detalleordencompra.getcantidad().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleOrdenCompraConstantesFunciones.CANTIDAD,strValorActual,strValorNuevo);
			}	
			
			if(detalleordencompra.getIsNew()||!detalleordencompra.getdescuento().equals(detalleordencompra.getDetalleOrdenCompraOriginal().getdescuento()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detalleordencompra.getDetalleOrdenCompraOriginal().getdescuento()!=null)
				{
					strValorActual=detalleordencompra.getDetalleOrdenCompraOriginal().getdescuento().toString();
				}
				if(detalleordencompra.getdescuento()!=null)
				{
					strValorNuevo=detalleordencompra.getdescuento().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleOrdenCompraConstantesFunciones.DESCUENTO,strValorActual,strValorNuevo);
			}	
			
			if(detalleordencompra.getIsNew()||!detalleordencompra.getcosto_unitario().equals(detalleordencompra.getDetalleOrdenCompraOriginal().getcosto_unitario()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detalleordencompra.getDetalleOrdenCompraOriginal().getcosto_unitario()!=null)
				{
					strValorActual=detalleordencompra.getDetalleOrdenCompraOriginal().getcosto_unitario().toString();
				}
				if(detalleordencompra.getcosto_unitario()!=null)
				{
					strValorNuevo=detalleordencompra.getcosto_unitario().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleOrdenCompraConstantesFunciones.COSTOUNITARIO,strValorActual,strValorNuevo);
			}	
			
			if(detalleordencompra.getIsNew()||!detalleordencompra.getiva().equals(detalleordencompra.getDetalleOrdenCompraOriginal().getiva()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detalleordencompra.getDetalleOrdenCompraOriginal().getiva()!=null)
				{
					strValorActual=detalleordencompra.getDetalleOrdenCompraOriginal().getiva().toString();
				}
				if(detalleordencompra.getiva()!=null)
				{
					strValorNuevo=detalleordencompra.getiva().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleOrdenCompraConstantesFunciones.IVA,strValorActual,strValorNuevo);
			}	
			
			if(detalleordencompra.getIsNew()||!detalleordencompra.getiva_valor().equals(detalleordencompra.getDetalleOrdenCompraOriginal().getiva_valor()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detalleordencompra.getDetalleOrdenCompraOriginal().getiva_valor()!=null)
				{
					strValorActual=detalleordencompra.getDetalleOrdenCompraOriginal().getiva_valor().toString();
				}
				if(detalleordencompra.getiva_valor()!=null)
				{
					strValorNuevo=detalleordencompra.getiva_valor().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleOrdenCompraConstantesFunciones.IVAVALOR,strValorActual,strValorNuevo);
			}	
			
			if(detalleordencompra.getIsNew()||!detalleordencompra.getcosto_total().equals(detalleordencompra.getDetalleOrdenCompraOriginal().getcosto_total()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detalleordencompra.getDetalleOrdenCompraOriginal().getcosto_total()!=null)
				{
					strValorActual=detalleordencompra.getDetalleOrdenCompraOriginal().getcosto_total().toString();
				}
				if(detalleordencompra.getcosto_total()!=null)
				{
					strValorNuevo=detalleordencompra.getcosto_total().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleOrdenCompraConstantesFunciones.COSTOTOTAL,strValorActual,strValorNuevo);
			}	
			
			if(detalleordencompra.getIsNew()||!detalleordencompra.getdisponible().equals(detalleordencompra.getDetalleOrdenCompraOriginal().getdisponible()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detalleordencompra.getDetalleOrdenCompraOriginal().getdisponible()!=null)
				{
					strValorActual=detalleordencompra.getDetalleOrdenCompraOriginal().getdisponible().toString();
				}
				if(detalleordencompra.getdisponible()!=null)
				{
					strValorNuevo=detalleordencompra.getdisponible().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleOrdenCompraConstantesFunciones.DISPONIBLE,strValorActual,strValorNuevo);
			}	
			
			if(detalleordencompra.getIsNew()||!detalleordencompra.getid_novedad_producto().equals(detalleordencompra.getDetalleOrdenCompraOriginal().getid_novedad_producto()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detalleordencompra.getDetalleOrdenCompraOriginal().getid_novedad_producto()!=null)
				{
					strValorActual=detalleordencompra.getDetalleOrdenCompraOriginal().getid_novedad_producto().toString();
				}
				if(detalleordencompra.getid_novedad_producto()!=null)
				{
					strValorNuevo=detalleordencompra.getid_novedad_producto().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleOrdenCompraConstantesFunciones.IDNOVEDADPRODUCTO,strValorActual,strValorNuevo);
			}	
			
			if(detalleordencompra.getIsNew()||!detalleordencompra.getid_estado_detalle_orden_compra().equals(detalleordencompra.getDetalleOrdenCompraOriginal().getid_estado_detalle_orden_compra()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detalleordencompra.getDetalleOrdenCompraOriginal().getid_estado_detalle_orden_compra()!=null)
				{
					strValorActual=detalleordencompra.getDetalleOrdenCompraOriginal().getid_estado_detalle_orden_compra().toString();
				}
				if(detalleordencompra.getid_estado_detalle_orden_compra()!=null)
				{
					strValorNuevo=detalleordencompra.getid_estado_detalle_orden_compra().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleOrdenCompraConstantesFunciones.IDESTADODETALLEORDENCOMPRA,strValorActual,strValorNuevo);
			}	
			
			if(detalleordencompra.getIsNew()||!detalleordencompra.getnumero_comprobante().equals(detalleordencompra.getDetalleOrdenCompraOriginal().getnumero_comprobante()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detalleordencompra.getDetalleOrdenCompraOriginal().getnumero_comprobante()!=null)
				{
					strValorActual=detalleordencompra.getDetalleOrdenCompraOriginal().getnumero_comprobante();
				}
				if(detalleordencompra.getnumero_comprobante()!=null)
				{
					strValorNuevo=detalleordencompra.getnumero_comprobante() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleOrdenCompraConstantesFunciones.NUMEROCOMPROBANTE,strValorActual,strValorNuevo);
			}	
			
			if(detalleordencompra.getIsNew()||!detalleordencompra.getlote_cliente().equals(detalleordencompra.getDetalleOrdenCompraOriginal().getlote_cliente()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detalleordencompra.getDetalleOrdenCompraOriginal().getlote_cliente()!=null)
				{
					strValorActual=detalleordencompra.getDetalleOrdenCompraOriginal().getlote_cliente();
				}
				if(detalleordencompra.getlote_cliente()!=null)
				{
					strValorNuevo=detalleordencompra.getlote_cliente() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleOrdenCompraConstantesFunciones.LOTECLIENTE,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void saveDetalleOrdenCompraRelacionesWithConnection(DetalleOrdenCompra detalleordencompra) throws Exception {

		if(!detalleordencompra.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveDetalleOrdenCompraRelacionesBase(detalleordencompra,true);
		}
	}

	public void saveDetalleOrdenCompraRelaciones(DetalleOrdenCompra detalleordencompra)throws Exception {

		if(!detalleordencompra.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveDetalleOrdenCompraRelacionesBase(detalleordencompra,false);
		}
	}

	public void saveDetalleOrdenCompraRelacionesBase(DetalleOrdenCompra detalleordencompra,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("DetalleOrdenCompra-saveRelacionesWithConnection");}
	

			this.setDetalleOrdenCompra(detalleordencompra);

			if(DetalleOrdenCompraLogicAdditional.validarSaveRelaciones(detalleordencompra,this)) {

				DetalleOrdenCompraLogicAdditional.updateRelacionesToSave(detalleordencompra,this);

				if((detalleordencompra.getIsNew()||detalleordencompra.getIsChanged())&&!detalleordencompra.getIsDeleted()) {
					this.saveDetalleOrdenCompra();
					this.saveDetalleOrdenCompraRelacionesDetalles();

				} else if(detalleordencompra.getIsDeleted()) {
					this.saveDetalleOrdenCompraRelacionesDetalles();
					this.saveDetalleOrdenCompra();
				}

				DetalleOrdenCompraLogicAdditional.updateRelacionesToSaveAfter(detalleordencompra,this);

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
	
	
	private void saveDetalleOrdenCompraRelacionesDetalles()throws Exception {
		try {
	

		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfDetalleOrdenCompra(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=DetalleOrdenCompraConstantesFunciones.getClassesForeignKeysOfDetalleOrdenCompra(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfDetalleOrdenCompra(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=DetalleOrdenCompraConstantesFunciones.getClassesRelationshipsOfDetalleOrdenCompra(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}
