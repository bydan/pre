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
import com.bydan.erp.inventario.util.DetallePlaneacionCompraConstantesFunciones;
import com.bydan.erp.inventario.util.DetallePlaneacionCompraParameterReturnGeneral;
//import com.bydan.erp.inventario.util.DetallePlaneacionCompraParameterGeneral;
import com.bydan.erp.inventario.business.entity.DetallePlaneacionCompra;
import com.bydan.erp.inventario.business.logic.DetallePlaneacionCompraLogicAdditional;
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
public class DetallePlaneacionCompraLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(DetallePlaneacionCompraLogic.class);
	
	protected DetallePlaneacionCompraDataAccess detalleplaneacioncompraDataAccess; 	
	protected DetallePlaneacionCompra detalleplaneacioncompra;
	protected List<DetallePlaneacionCompra> detalleplaneacioncompras;
	protected Object detalleplaneacioncompraObject;	
	protected List<Object> detalleplaneacioncomprasObject;
	
	public static ClassValidator<DetallePlaneacionCompra> detalleplaneacioncompraValidator = new ClassValidator<DetallePlaneacionCompra>(DetallePlaneacionCompra.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected DetallePlaneacionCompraLogicAdditional detalleplaneacioncompraLogicAdditional=null;
	
	public DetallePlaneacionCompraLogicAdditional getDetallePlaneacionCompraLogicAdditional() {
		return this.detalleplaneacioncompraLogicAdditional;
	}
	
	public void setDetallePlaneacionCompraLogicAdditional(DetallePlaneacionCompraLogicAdditional detalleplaneacioncompraLogicAdditional) {
		try {
			this.detalleplaneacioncompraLogicAdditional=detalleplaneacioncompraLogicAdditional;
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
	
	
	
	
	public  DetallePlaneacionCompraLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.detalleplaneacioncompraDataAccess = new DetallePlaneacionCompraDataAccess();
			
			this.detalleplaneacioncompras= new ArrayList<DetallePlaneacionCompra>();
			this.detalleplaneacioncompra= new DetallePlaneacionCompra();
			
			this.detalleplaneacioncompraObject=new Object();
			this.detalleplaneacioncomprasObject=new ArrayList<Object>();
				
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
			
			this.detalleplaneacioncompraDataAccess.setConnexionType(this.connexionType);
			this.detalleplaneacioncompraDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  DetallePlaneacionCompraLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.detalleplaneacioncompraDataAccess = new DetallePlaneacionCompraDataAccess();
			this.detalleplaneacioncompras= new ArrayList<DetallePlaneacionCompra>();
			this.detalleplaneacioncompra= new DetallePlaneacionCompra();
			this.detalleplaneacioncompraObject=new Object();
			this.detalleplaneacioncomprasObject=new ArrayList<Object>();
			
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
			
			this.detalleplaneacioncompraDataAccess.setConnexionType(this.connexionType);
			this.detalleplaneacioncompraDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public DetallePlaneacionCompra getDetallePlaneacionCompra() throws Exception {	
		DetallePlaneacionCompraLogicAdditional.checkDetallePlaneacionCompraToGet(detalleplaneacioncompra,this.datosCliente,this.arrDatoGeneral);
		DetallePlaneacionCompraLogicAdditional.updateDetallePlaneacionCompraToGet(detalleplaneacioncompra,this.arrDatoGeneral);
		
		return detalleplaneacioncompra;
	}
		
	public void setDetallePlaneacionCompra(DetallePlaneacionCompra newDetallePlaneacionCompra) {
		this.detalleplaneacioncompra = newDetallePlaneacionCompra;
	}
	
	public DetallePlaneacionCompraDataAccess getDetallePlaneacionCompraDataAccess() {
		return detalleplaneacioncompraDataAccess;
	}
	
	public void setDetallePlaneacionCompraDataAccess(DetallePlaneacionCompraDataAccess newdetalleplaneacioncompraDataAccess) {
		this.detalleplaneacioncompraDataAccess = newdetalleplaneacioncompraDataAccess;
	}
	
	public List<DetallePlaneacionCompra> getDetallePlaneacionCompras() throws Exception {		
		this.quitarDetallePlaneacionComprasNulos();
		
		DetallePlaneacionCompraLogicAdditional.checkDetallePlaneacionCompraToGets(detalleplaneacioncompras,this.datosCliente,this.arrDatoGeneral);
		
		for (DetallePlaneacionCompra detalleplaneacioncompraLocal: detalleplaneacioncompras ) {
			DetallePlaneacionCompraLogicAdditional.updateDetallePlaneacionCompraToGet(detalleplaneacioncompraLocal,this.arrDatoGeneral);
		}
		
		return detalleplaneacioncompras;
	}
	
	public void setDetallePlaneacionCompras(List<DetallePlaneacionCompra> newDetallePlaneacionCompras) {
		this.detalleplaneacioncompras = newDetallePlaneacionCompras;
	}
	
	public Object getDetallePlaneacionCompraObject() {	
		this.detalleplaneacioncompraObject=this.detalleplaneacioncompraDataAccess.getEntityObject();
		return this.detalleplaneacioncompraObject;
	}
		
	public void setDetallePlaneacionCompraObject(Object newDetallePlaneacionCompraObject) {
		this.detalleplaneacioncompraObject = newDetallePlaneacionCompraObject;
	}
	
	public List<Object> getDetallePlaneacionComprasObject() {		
		this.detalleplaneacioncomprasObject=this.detalleplaneacioncompraDataAccess.getEntitiesObject();
		return this.detalleplaneacioncomprasObject;
	}
		
	public void setDetallePlaneacionComprasObject(List<Object> newDetallePlaneacionComprasObject) {
		this.detalleplaneacioncomprasObject = newDetallePlaneacionComprasObject;
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
		
		if(this.detalleplaneacioncompraDataAccess!=null) {
			this.detalleplaneacioncompraDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetallePlaneacionCompra.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			detalleplaneacioncompraDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			detalleplaneacioncompraDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		detalleplaneacioncompra = new  DetallePlaneacionCompra();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetallePlaneacionCompra.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			detalleplaneacioncompra=detalleplaneacioncompraDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.detalleplaneacioncompra,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				DetallePlaneacionCompraConstantesFunciones.refrescarForeignKeysDescripcionesDetallePlaneacionCompra(this.detalleplaneacioncompra);
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
		detalleplaneacioncompra = new  DetallePlaneacionCompra();
		  		  
        try {
			
			detalleplaneacioncompra=detalleplaneacioncompraDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.detalleplaneacioncompra,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				DetallePlaneacionCompraConstantesFunciones.refrescarForeignKeysDescripcionesDetallePlaneacionCompra(this.detalleplaneacioncompra);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		detalleplaneacioncompra = new  DetallePlaneacionCompra();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetallePlaneacionCompra.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			detalleplaneacioncompra=detalleplaneacioncompraDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.detalleplaneacioncompra,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				DetallePlaneacionCompraConstantesFunciones.refrescarForeignKeysDescripcionesDetallePlaneacionCompra(this.detalleplaneacioncompra);
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
		detalleplaneacioncompra = new  DetallePlaneacionCompra();
		  		  
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
		detalleplaneacioncompra = new  DetallePlaneacionCompra();
		  		  
        try {
			
			detalleplaneacioncompra=detalleplaneacioncompraDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.detalleplaneacioncompra,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				DetallePlaneacionCompraConstantesFunciones.refrescarForeignKeysDescripcionesDetallePlaneacionCompra(this.detalleplaneacioncompra);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		detalleplaneacioncompra = new  DetallePlaneacionCompra();
		  		  
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
		detalleplaneacioncompra = new  DetallePlaneacionCompra();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetallePlaneacionCompra.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =detalleplaneacioncompraDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		detalleplaneacioncompra = new  DetallePlaneacionCompra();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=detalleplaneacioncompraDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		detalleplaneacioncompra = new  DetallePlaneacionCompra();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetallePlaneacionCompra.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =detalleplaneacioncompraDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		detalleplaneacioncompra = new  DetallePlaneacionCompra();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=detalleplaneacioncompraDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		detalleplaneacioncompra = new  DetallePlaneacionCompra();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetallePlaneacionCompra.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =detalleplaneacioncompraDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		detalleplaneacioncompra = new  DetallePlaneacionCompra();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=detalleplaneacioncompraDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		detalleplaneacioncompras = new  ArrayList<DetallePlaneacionCompra>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetallePlaneacionCompra.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			DetallePlaneacionCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detalleplaneacioncompras=detalleplaneacioncompraDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarDetallePlaneacionCompra(detalleplaneacioncompras);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetallePlaneacionCompraConstantesFunciones.refrescarForeignKeysDescripcionesDetallePlaneacionCompra(this.detalleplaneacioncompras);
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
		detalleplaneacioncompras = new  ArrayList<DetallePlaneacionCompra>();
		  		  
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
		detalleplaneacioncompras = new  ArrayList<DetallePlaneacionCompra>();
		  		  
        try {			
			DetallePlaneacionCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detalleplaneacioncompras=detalleplaneacioncompraDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarDetallePlaneacionCompra(detalleplaneacioncompras);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetallePlaneacionCompraConstantesFunciones.refrescarForeignKeysDescripcionesDetallePlaneacionCompra(this.detalleplaneacioncompras);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		detalleplaneacioncompras = new  ArrayList<DetallePlaneacionCompra>();
		  		  
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
		detalleplaneacioncompras = new  ArrayList<DetallePlaneacionCompra>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetallePlaneacionCompra.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			DetallePlaneacionCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detalleplaneacioncompras=detalleplaneacioncompraDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarDetallePlaneacionCompra(detalleplaneacioncompras);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetallePlaneacionCompraConstantesFunciones.refrescarForeignKeysDescripcionesDetallePlaneacionCompra(this.detalleplaneacioncompras);
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
		detalleplaneacioncompras = new  ArrayList<DetallePlaneacionCompra>();
		  		  
        try {
			DetallePlaneacionCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detalleplaneacioncompras=detalleplaneacioncompraDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarDetallePlaneacionCompra(detalleplaneacioncompras);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetallePlaneacionCompraConstantesFunciones.refrescarForeignKeysDescripcionesDetallePlaneacionCompra(this.detalleplaneacioncompras);
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
		detalleplaneacioncompras = new  ArrayList<DetallePlaneacionCompra>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetallePlaneacionCompra.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			DetallePlaneacionCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detalleplaneacioncompras=detalleplaneacioncompraDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarDetallePlaneacionCompra(detalleplaneacioncompras);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetallePlaneacionCompraConstantesFunciones.refrescarForeignKeysDescripcionesDetallePlaneacionCompra(this.detalleplaneacioncompras);
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
		detalleplaneacioncompras = new  ArrayList<DetallePlaneacionCompra>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			DetallePlaneacionCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detalleplaneacioncompras=detalleplaneacioncompraDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarDetallePlaneacionCompra(detalleplaneacioncompras);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetallePlaneacionCompraConstantesFunciones.refrescarForeignKeysDescripcionesDetallePlaneacionCompra(this.detalleplaneacioncompras);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		detalleplaneacioncompra = new  DetallePlaneacionCompra();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetallePlaneacionCompra.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			DetallePlaneacionCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detalleplaneacioncompra=detalleplaneacioncompraDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarDetallePlaneacionCompra(detalleplaneacioncompra);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetallePlaneacionCompraConstantesFunciones.refrescarForeignKeysDescripcionesDetallePlaneacionCompra(this.detalleplaneacioncompra);
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
		detalleplaneacioncompra = new  DetallePlaneacionCompra();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			DetallePlaneacionCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detalleplaneacioncompra=detalleplaneacioncompraDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarDetallePlaneacionCompra(detalleplaneacioncompra);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetallePlaneacionCompraConstantesFunciones.refrescarForeignKeysDescripcionesDetallePlaneacionCompra(this.detalleplaneacioncompra);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		detalleplaneacioncompras = new  ArrayList<DetallePlaneacionCompra>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetallePlaneacionCompra.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			DetallePlaneacionCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detalleplaneacioncompras=detalleplaneacioncompraDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarDetallePlaneacionCompra(detalleplaneacioncompras);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetallePlaneacionCompraConstantesFunciones.refrescarForeignKeysDescripcionesDetallePlaneacionCompra(this.detalleplaneacioncompras);
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
		detalleplaneacioncompras = new  ArrayList<DetallePlaneacionCompra>();
		  		  
        try {
			DetallePlaneacionCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detalleplaneacioncompras=detalleplaneacioncompraDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarDetallePlaneacionCompra(detalleplaneacioncompras);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetallePlaneacionCompraConstantesFunciones.refrescarForeignKeysDescripcionesDetallePlaneacionCompra(this.detalleplaneacioncompras);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosDetallePlaneacionComprasWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		detalleplaneacioncompras = new  ArrayList<DetallePlaneacionCompra>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetallePlaneacionCompra.class.getSimpleName()+"-getTodosDetallePlaneacionComprasWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			DetallePlaneacionCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detalleplaneacioncompras=detalleplaneacioncompraDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarDetallePlaneacionCompra(detalleplaneacioncompras);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetallePlaneacionCompraConstantesFunciones.refrescarForeignKeysDescripcionesDetallePlaneacionCompra(this.detalleplaneacioncompras);
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
	
	public  void  getTodosDetallePlaneacionCompras(String sFinalQuery,Pagination pagination)throws Exception {
		detalleplaneacioncompras = new  ArrayList<DetallePlaneacionCompra>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			DetallePlaneacionCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detalleplaneacioncompras=detalleplaneacioncompraDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarDetallePlaneacionCompra(detalleplaneacioncompras);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetallePlaneacionCompraConstantesFunciones.refrescarForeignKeysDescripcionesDetallePlaneacionCompra(this.detalleplaneacioncompras);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarDetallePlaneacionCompra(DetallePlaneacionCompra detalleplaneacioncompra) throws Exception {
		Boolean estaValidado=false;
		
		if(detalleplaneacioncompra.getIsNew() || detalleplaneacioncompra.getIsChanged()) { 
			this.invalidValues = detalleplaneacioncompraValidator.getInvalidValues(detalleplaneacioncompra);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(detalleplaneacioncompra);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarDetallePlaneacionCompra(List<DetallePlaneacionCompra> DetallePlaneacionCompras) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(DetallePlaneacionCompra detalleplaneacioncompraLocal:detalleplaneacioncompras) {				
			estaValidadoObjeto=this.validarGuardarDetallePlaneacionCompra(detalleplaneacioncompraLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarDetallePlaneacionCompra(List<DetallePlaneacionCompra> DetallePlaneacionCompras) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarDetallePlaneacionCompra(detalleplaneacioncompras)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarDetallePlaneacionCompra(DetallePlaneacionCompra DetallePlaneacionCompra) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarDetallePlaneacionCompra(detalleplaneacioncompra)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(DetallePlaneacionCompra detalleplaneacioncompra) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+detalleplaneacioncompra.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=DetallePlaneacionCompraConstantesFunciones.getDetallePlaneacionCompraLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"detalleplaneacioncompra","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(DetallePlaneacionCompraConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(DetallePlaneacionCompraConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveDetallePlaneacionCompraWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetallePlaneacionCompra.class.getSimpleName()+"-saveDetallePlaneacionCompraWithConnection");connexion.begin();			
			
			DetallePlaneacionCompraLogicAdditional.checkDetallePlaneacionCompraToSave(this.detalleplaneacioncompra,this.datosCliente,connexion,this.arrDatoGeneral);
			
			DetallePlaneacionCompraLogicAdditional.updateDetallePlaneacionCompraToSave(this.detalleplaneacioncompra,this.arrDatoGeneral);
			
			DetallePlaneacionCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.detalleplaneacioncompra,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowDetallePlaneacionCompra();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarDetallePlaneacionCompra(this.detalleplaneacioncompra)) {
				DetallePlaneacionCompraDataAccess.save(this.detalleplaneacioncompra, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.detalleplaneacioncompra,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			DetallePlaneacionCompraLogicAdditional.checkDetallePlaneacionCompraToSaveAfter(this.detalleplaneacioncompra,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowDetallePlaneacionCompra();
			
			connexion.commit();			
			
			if(this.detalleplaneacioncompra.getIsDeleted()) {
				this.detalleplaneacioncompra=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveDetallePlaneacionCompra()throws Exception {	
		try {	
			
			DetallePlaneacionCompraLogicAdditional.checkDetallePlaneacionCompraToSave(this.detalleplaneacioncompra,this.datosCliente,connexion,this.arrDatoGeneral);
			
			DetallePlaneacionCompraLogicAdditional.updateDetallePlaneacionCompraToSave(this.detalleplaneacioncompra,this.arrDatoGeneral);
			
			DetallePlaneacionCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.detalleplaneacioncompra,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarDetallePlaneacionCompra(this.detalleplaneacioncompra)) {			
				DetallePlaneacionCompraDataAccess.save(this.detalleplaneacioncompra, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.detalleplaneacioncompra,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			DetallePlaneacionCompraLogicAdditional.checkDetallePlaneacionCompraToSaveAfter(this.detalleplaneacioncompra,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.detalleplaneacioncompra.getIsDeleted()) {
				this.detalleplaneacioncompra=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveDetallePlaneacionComprasWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetallePlaneacionCompra.class.getSimpleName()+"-saveDetallePlaneacionComprasWithConnection");connexion.begin();			
			
			DetallePlaneacionCompraLogicAdditional.checkDetallePlaneacionCompraToSaves(detalleplaneacioncompras,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowDetallePlaneacionCompras();
			
			Boolean validadoTodosDetallePlaneacionCompra=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(DetallePlaneacionCompra detalleplaneacioncompraLocal:detalleplaneacioncompras) {		
				if(detalleplaneacioncompraLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				DetallePlaneacionCompraLogicAdditional.updateDetallePlaneacionCompraToSave(detalleplaneacioncompraLocal,this.arrDatoGeneral);
	        	
				DetallePlaneacionCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),detalleplaneacioncompraLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarDetallePlaneacionCompra(detalleplaneacioncompraLocal)) {
					DetallePlaneacionCompraDataAccess.save(detalleplaneacioncompraLocal, connexion);				
				} else {
					validadoTodosDetallePlaneacionCompra=false;
				}
			}
			
			if(!validadoTodosDetallePlaneacionCompra) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			DetallePlaneacionCompraLogicAdditional.checkDetallePlaneacionCompraToSavesAfter(detalleplaneacioncompras,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowDetallePlaneacionCompras();
			
			connexion.commit();		
			
			this.quitarDetallePlaneacionComprasEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveDetallePlaneacionCompras()throws Exception {				
		 try {	
			DetallePlaneacionCompraLogicAdditional.checkDetallePlaneacionCompraToSaves(detalleplaneacioncompras,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosDetallePlaneacionCompra=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(DetallePlaneacionCompra detalleplaneacioncompraLocal:detalleplaneacioncompras) {				
				if(detalleplaneacioncompraLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				DetallePlaneacionCompraLogicAdditional.updateDetallePlaneacionCompraToSave(detalleplaneacioncompraLocal,this.arrDatoGeneral);
	        	
				DetallePlaneacionCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),detalleplaneacioncompraLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarDetallePlaneacionCompra(detalleplaneacioncompraLocal)) {				
					DetallePlaneacionCompraDataAccess.save(detalleplaneacioncompraLocal, connexion);				
				} else {
					validadoTodosDetallePlaneacionCompra=false;
				}
			}
			
			if(!validadoTodosDetallePlaneacionCompra) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			DetallePlaneacionCompraLogicAdditional.checkDetallePlaneacionCompraToSavesAfter(detalleplaneacioncompras,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarDetallePlaneacionComprasEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public DetallePlaneacionCompraParameterReturnGeneral procesarAccionDetallePlaneacionCompras(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<DetallePlaneacionCompra> detalleplaneacioncompras,DetallePlaneacionCompraParameterReturnGeneral detalleplaneacioncompraParameterGeneral)throws Exception {
		 try {	
			DetallePlaneacionCompraParameterReturnGeneral detalleplaneacioncompraReturnGeneral=new DetallePlaneacionCompraParameterReturnGeneral();
	
			DetallePlaneacionCompraLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,detalleplaneacioncompras,detalleplaneacioncompraParameterGeneral,detalleplaneacioncompraReturnGeneral);
			
			return detalleplaneacioncompraReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public DetallePlaneacionCompraParameterReturnGeneral procesarAccionDetallePlaneacionComprasWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<DetallePlaneacionCompra> detalleplaneacioncompras,DetallePlaneacionCompraParameterReturnGeneral detalleplaneacioncompraParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetallePlaneacionCompra.class.getSimpleName()+"-procesarAccionDetallePlaneacionComprasWithConnection");connexion.begin();			
			
			DetallePlaneacionCompraParameterReturnGeneral detalleplaneacioncompraReturnGeneral=new DetallePlaneacionCompraParameterReturnGeneral();
	
			DetallePlaneacionCompraLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,detalleplaneacioncompras,detalleplaneacioncompraParameterGeneral,detalleplaneacioncompraReturnGeneral);
			
			this.connexion.commit();
			
			return detalleplaneacioncompraReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public DetallePlaneacionCompraParameterReturnGeneral procesarEventosDetallePlaneacionCompras(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<DetallePlaneacionCompra> detalleplaneacioncompras,DetallePlaneacionCompra detalleplaneacioncompra,DetallePlaneacionCompraParameterReturnGeneral detalleplaneacioncompraParameterGeneral,Boolean isEsNuevoDetallePlaneacionCompra,ArrayList<Classe> clases)throws Exception {
		 try {	
			DetallePlaneacionCompraParameterReturnGeneral detalleplaneacioncompraReturnGeneral=new DetallePlaneacionCompraParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				detalleplaneacioncompraReturnGeneral.setConRecargarPropiedades(true);
			}
			
			DetallePlaneacionCompraLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,detalleplaneacioncompras,detalleplaneacioncompra,detalleplaneacioncompraParameterGeneral,detalleplaneacioncompraReturnGeneral,isEsNuevoDetallePlaneacionCompra,clases);
			
			return detalleplaneacioncompraReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public DetallePlaneacionCompraParameterReturnGeneral procesarEventosDetallePlaneacionComprasWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<DetallePlaneacionCompra> detalleplaneacioncompras,DetallePlaneacionCompra detalleplaneacioncompra,DetallePlaneacionCompraParameterReturnGeneral detalleplaneacioncompraParameterGeneral,Boolean isEsNuevoDetallePlaneacionCompra,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetallePlaneacionCompra.class.getSimpleName()+"-procesarEventosDetallePlaneacionComprasWithConnection");connexion.begin();			
			
			DetallePlaneacionCompraParameterReturnGeneral detalleplaneacioncompraReturnGeneral=new DetallePlaneacionCompraParameterReturnGeneral();
	
			detalleplaneacioncompraReturnGeneral.setDetallePlaneacionCompra(detalleplaneacioncompra);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				detalleplaneacioncompraReturnGeneral.setConRecargarPropiedades(true);
			}
			
			DetallePlaneacionCompraLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,detalleplaneacioncompras,detalleplaneacioncompra,detalleplaneacioncompraParameterGeneral,detalleplaneacioncompraReturnGeneral,isEsNuevoDetallePlaneacionCompra,clases);
			
			this.connexion.commit();
			
			return detalleplaneacioncompraReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public DetallePlaneacionCompraParameterReturnGeneral procesarImportacionDetallePlaneacionComprasWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,DetallePlaneacionCompraParameterReturnGeneral detalleplaneacioncompraParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetallePlaneacionCompra.class.getSimpleName()+"-procesarImportacionDetallePlaneacionComprasWithConnection");connexion.begin();			
			
			DetallePlaneacionCompraParameterReturnGeneral detalleplaneacioncompraReturnGeneral=new DetallePlaneacionCompraParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.detalleplaneacioncompras=new ArrayList<DetallePlaneacionCompra>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.detalleplaneacioncompra=new DetallePlaneacionCompra();
				
				
				if(conColumnasBase) {this.detalleplaneacioncompra.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.detalleplaneacioncompra.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.detalleplaneacioncompra.setstock(Double.parseDouble(arrColumnas[iColumn++]));
				this.detalleplaneacioncompra.setdia_minimo(Integer.parseInt(arrColumnas[iColumn++]));
				this.detalleplaneacioncompra.setstock_minimo(Double.parseDouble(arrColumnas[iColumn++]));
				this.detalleplaneacioncompra.setdia_maximo(Integer.parseInt(arrColumnas[iColumn++]));
				this.detalleplaneacioncompra.setstock_maximo(Double.parseDouble(arrColumnas[iColumn++]));
				this.detalleplaneacioncompra.setsalida(Double.parseDouble(arrColumnas[iColumn++]));
				this.detalleplaneacioncompra.setstock_mensual(Double.parseDouble(arrColumnas[iColumn++]));
			this.detalleplaneacioncompra.setdescripcion(arrColumnas[iColumn++]);
				
				this.detalleplaneacioncompras.add(this.detalleplaneacioncompra);
			}
			
			this.saveDetallePlaneacionCompras();
			
			this.connexion.commit();
			
			detalleplaneacioncompraReturnGeneral.setConRetornoEstaProcesado(true);
			detalleplaneacioncompraReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return detalleplaneacioncompraReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarDetallePlaneacionComprasEliminados() throws Exception {				
		
		List<DetallePlaneacionCompra> detalleplaneacioncomprasAux= new ArrayList<DetallePlaneacionCompra>();
		
		for(DetallePlaneacionCompra detalleplaneacioncompra:detalleplaneacioncompras) {
			if(!detalleplaneacioncompra.getIsDeleted()) {
				detalleplaneacioncomprasAux.add(detalleplaneacioncompra);
			}
		}
		
		detalleplaneacioncompras=detalleplaneacioncomprasAux;
	}
	
	public void quitarDetallePlaneacionComprasNulos() throws Exception {				
		
		List<DetallePlaneacionCompra> detalleplaneacioncomprasAux= new ArrayList<DetallePlaneacionCompra>();
		
		for(DetallePlaneacionCompra detalleplaneacioncompra : this.detalleplaneacioncompras) {
			if(detalleplaneacioncompra==null) {
				detalleplaneacioncomprasAux.add(detalleplaneacioncompra);
			}
		}
		
		//this.detalleplaneacioncompras=detalleplaneacioncomprasAux;
		
		this.detalleplaneacioncompras.removeAll(detalleplaneacioncomprasAux);
	}
	
	public void getSetVersionRowDetallePlaneacionCompraWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(detalleplaneacioncompra.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((detalleplaneacioncompra.getIsDeleted() || (detalleplaneacioncompra.getIsChanged()&&!detalleplaneacioncompra.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=detalleplaneacioncompraDataAccess.getSetVersionRowDetallePlaneacionCompra(connexion,detalleplaneacioncompra.getId());
				
				if(!detalleplaneacioncompra.getVersionRow().equals(timestamp)) {	
					detalleplaneacioncompra.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				detalleplaneacioncompra.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowDetallePlaneacionCompra()throws Exception {	
		
		if(detalleplaneacioncompra.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((detalleplaneacioncompra.getIsDeleted() || (detalleplaneacioncompra.getIsChanged()&&!detalleplaneacioncompra.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=detalleplaneacioncompraDataAccess.getSetVersionRowDetallePlaneacionCompra(connexion,detalleplaneacioncompra.getId());
			
			try {							
				if(!detalleplaneacioncompra.getVersionRow().equals(timestamp)) {	
					detalleplaneacioncompra.setVersionRow(timestamp);
				}
				
				detalleplaneacioncompra.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowDetallePlaneacionComprasWithConnection()throws Exception {	
		if(detalleplaneacioncompras!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(DetallePlaneacionCompra detalleplaneacioncompraAux:detalleplaneacioncompras) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(detalleplaneacioncompraAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(detalleplaneacioncompraAux.getIsDeleted() || (detalleplaneacioncompraAux.getIsChanged()&&!detalleplaneacioncompraAux.getIsNew())) {
						
						timestamp=detalleplaneacioncompraDataAccess.getSetVersionRowDetallePlaneacionCompra(connexion,detalleplaneacioncompraAux.getId());
						
						if(!detalleplaneacioncompra.getVersionRow().equals(timestamp)) {	
							detalleplaneacioncompraAux.setVersionRow(timestamp);
						}
								
						detalleplaneacioncompraAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowDetallePlaneacionCompras()throws Exception {	
		if(detalleplaneacioncompras!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(DetallePlaneacionCompra detalleplaneacioncompraAux:detalleplaneacioncompras) {
					if(detalleplaneacioncompraAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(detalleplaneacioncompraAux.getIsDeleted() || (detalleplaneacioncompraAux.getIsChanged()&&!detalleplaneacioncompraAux.getIsNew())) {
						
						timestamp=detalleplaneacioncompraDataAccess.getSetVersionRowDetallePlaneacionCompra(connexion,detalleplaneacioncompraAux.getId());
						
						if(!detalleplaneacioncompraAux.getVersionRow().equals(timestamp)) {	
							detalleplaneacioncompraAux.setVersionRow(timestamp);
						}
						
													
						detalleplaneacioncompraAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public DetallePlaneacionCompraParameterReturnGeneral cargarCombosLoteForeignKeyDetallePlaneacionCompraWithConnection(String finalQueryGlobalEmpresa,String finalQueryGlobalSucursal,String finalQueryGlobalEjercicio,String finalQueryGlobalPeriodo,String finalQueryGlobalPlaneacionCompra,String finalQueryGlobalLinea,String finalQueryGlobalProducto,String finalQueryGlobalUnidad) throws Exception {
		DetallePlaneacionCompraParameterReturnGeneral  detalleplaneacioncompraReturnGeneral =new DetallePlaneacionCompraParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetallePlaneacionCompra.class.getSimpleName()+"-cargarCombosLoteForeignKeyDetallePlaneacionCompraWithConnection");connexion.begin();
			
			detalleplaneacioncompraReturnGeneral =new DetallePlaneacionCompraParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			detalleplaneacioncompraReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Sucursal> sucursalsForeignKey=new ArrayList<Sucursal>();
			SucursalLogic sucursalLogic=new SucursalLogic();
			sucursalLogic.setConnexion(this.connexion);
			//sucursalLogic.getSucursalDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalSucursal.equals("NONE")) {
				sucursalLogic.getTodosSucursals(finalQueryGlobalSucursal,new Pagination());
				sucursalsForeignKey=sucursalLogic.getSucursals();
			}

			detalleplaneacioncompraReturnGeneral.setsucursalsForeignKey(sucursalsForeignKey);


			List<Ejercicio> ejerciciosForeignKey=new ArrayList<Ejercicio>();
			EjercicioLogic ejercicioLogic=new EjercicioLogic();
			ejercicioLogic.setConnexion(this.connexion);
			//ejercicioLogic.getEjercicioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEjercicio.equals("NONE")) {
				ejercicioLogic.getTodosEjercicios(finalQueryGlobalEjercicio,new Pagination());
				ejerciciosForeignKey=ejercicioLogic.getEjercicios();
			}

			detalleplaneacioncompraReturnGeneral.setejerciciosForeignKey(ejerciciosForeignKey);


			List<Periodo> periodosForeignKey=new ArrayList<Periodo>();
			PeriodoLogic periodoLogic=new PeriodoLogic();
			periodoLogic.setConnexion(this.connexion);
			//periodoLogic.getPeriodoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalPeriodo.equals("NONE")) {
				periodoLogic.getTodosPeriodos(finalQueryGlobalPeriodo,new Pagination());
				periodosForeignKey=periodoLogic.getPeriodos();
			}

			detalleplaneacioncompraReturnGeneral.setperiodosForeignKey(periodosForeignKey);


			List<PlaneacionCompra> planeacioncomprasForeignKey=new ArrayList<PlaneacionCompra>();
			PlaneacionCompraLogic planeacioncompraLogic=new PlaneacionCompraLogic();
			planeacioncompraLogic.setConnexion(this.connexion);
			planeacioncompraLogic.getPlaneacionCompraDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalPlaneacionCompra.equals("NONE")) {
				planeacioncompraLogic.getTodosPlaneacionCompras(finalQueryGlobalPlaneacionCompra,new Pagination());
				planeacioncomprasForeignKey=planeacioncompraLogic.getPlaneacionCompras();
			}

			detalleplaneacioncompraReturnGeneral.setplaneacioncomprasForeignKey(planeacioncomprasForeignKey);


			List<Linea> lineasForeignKey=new ArrayList<Linea>();
			LineaLogic lineaLogic=new LineaLogic();
			lineaLogic.setConnexion(this.connexion);
			lineaLogic.getLineaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalLinea.equals("NONE")) {
				lineaLogic.getTodosLineas(finalQueryGlobalLinea,new Pagination());
				lineasForeignKey=lineaLogic.getLineas();
			}

			detalleplaneacioncompraReturnGeneral.setlineasForeignKey(lineasForeignKey);


			List<Producto> productosForeignKey=new ArrayList<Producto>();
			ProductoLogic productoLogic=new ProductoLogic();
			productoLogic.setConnexion(this.connexion);
			productoLogic.getProductoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalProducto.equals("NONE")) {
				productoLogic.getTodosProductos(finalQueryGlobalProducto,new Pagination());
				productosForeignKey=productoLogic.getProductos();
			}

			detalleplaneacioncompraReturnGeneral.setproductosForeignKey(productosForeignKey);


			List<Unidad> unidadsForeignKey=new ArrayList<Unidad>();
			UnidadLogic unidadLogic=new UnidadLogic();
			unidadLogic.setConnexion(this.connexion);
			unidadLogic.getUnidadDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalUnidad.equals("NONE")) {
				unidadLogic.getTodosUnidads(finalQueryGlobalUnidad,new Pagination());
				unidadsForeignKey=unidadLogic.getUnidads();
			}

			detalleplaneacioncompraReturnGeneral.setunidadsForeignKey(unidadsForeignKey);

			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
		
		return detalleplaneacioncompraReturnGeneral;
	}
	
	public DetallePlaneacionCompraParameterReturnGeneral cargarCombosLoteForeignKeyDetallePlaneacionCompra(String finalQueryGlobalEmpresa,String finalQueryGlobalSucursal,String finalQueryGlobalEjercicio,String finalQueryGlobalPeriodo,String finalQueryGlobalPlaneacionCompra,String finalQueryGlobalLinea,String finalQueryGlobalProducto,String finalQueryGlobalUnidad) throws Exception {
		DetallePlaneacionCompraParameterReturnGeneral  detalleplaneacioncompraReturnGeneral =new DetallePlaneacionCompraParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {						
			detalleplaneacioncompraReturnGeneral =new DetallePlaneacionCompraParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			detalleplaneacioncompraReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Sucursal> sucursalsForeignKey=new ArrayList<Sucursal>();
			SucursalLogic sucursalLogic=new SucursalLogic();
			sucursalLogic.setConnexion(this.connexion);
			//sucursalLogic.getSucursalDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalSucursal.equals("NONE")) {
				sucursalLogic.getTodosSucursals(finalQueryGlobalSucursal,new Pagination());
				sucursalsForeignKey=sucursalLogic.getSucursals();
			}

			detalleplaneacioncompraReturnGeneral.setsucursalsForeignKey(sucursalsForeignKey);


			List<Ejercicio> ejerciciosForeignKey=new ArrayList<Ejercicio>();
			EjercicioLogic ejercicioLogic=new EjercicioLogic();
			ejercicioLogic.setConnexion(this.connexion);
			//ejercicioLogic.getEjercicioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEjercicio.equals("NONE")) {
				ejercicioLogic.getTodosEjercicios(finalQueryGlobalEjercicio,new Pagination());
				ejerciciosForeignKey=ejercicioLogic.getEjercicios();
			}

			detalleplaneacioncompraReturnGeneral.setejerciciosForeignKey(ejerciciosForeignKey);


			List<Periodo> periodosForeignKey=new ArrayList<Periodo>();
			PeriodoLogic periodoLogic=new PeriodoLogic();
			periodoLogic.setConnexion(this.connexion);
			//periodoLogic.getPeriodoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalPeriodo.equals("NONE")) {
				periodoLogic.getTodosPeriodos(finalQueryGlobalPeriodo,new Pagination());
				periodosForeignKey=periodoLogic.getPeriodos();
			}

			detalleplaneacioncompraReturnGeneral.setperiodosForeignKey(periodosForeignKey);


			List<PlaneacionCompra> planeacioncomprasForeignKey=new ArrayList<PlaneacionCompra>();
			PlaneacionCompraLogic planeacioncompraLogic=new PlaneacionCompraLogic();
			planeacioncompraLogic.setConnexion(this.connexion);
			planeacioncompraLogic.getPlaneacionCompraDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalPlaneacionCompra.equals("NONE")) {
				planeacioncompraLogic.getTodosPlaneacionCompras(finalQueryGlobalPlaneacionCompra,new Pagination());
				planeacioncomprasForeignKey=planeacioncompraLogic.getPlaneacionCompras();
			}

			detalleplaneacioncompraReturnGeneral.setplaneacioncomprasForeignKey(planeacioncomprasForeignKey);


			List<Linea> lineasForeignKey=new ArrayList<Linea>();
			LineaLogic lineaLogic=new LineaLogic();
			lineaLogic.setConnexion(this.connexion);
			lineaLogic.getLineaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalLinea.equals("NONE")) {
				lineaLogic.getTodosLineas(finalQueryGlobalLinea,new Pagination());
				lineasForeignKey=lineaLogic.getLineas();
			}

			detalleplaneacioncompraReturnGeneral.setlineasForeignKey(lineasForeignKey);


			List<Producto> productosForeignKey=new ArrayList<Producto>();
			ProductoLogic productoLogic=new ProductoLogic();
			productoLogic.setConnexion(this.connexion);
			productoLogic.getProductoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalProducto.equals("NONE")) {
				productoLogic.getTodosProductos(finalQueryGlobalProducto,new Pagination());
				productosForeignKey=productoLogic.getProductos();
			}

			detalleplaneacioncompraReturnGeneral.setproductosForeignKey(productosForeignKey);


			List<Unidad> unidadsForeignKey=new ArrayList<Unidad>();
			UnidadLogic unidadLogic=new UnidadLogic();
			unidadLogic.setConnexion(this.connexion);
			unidadLogic.getUnidadDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalUnidad.equals("NONE")) {
				unidadLogic.getTodosUnidads(finalQueryGlobalUnidad,new Pagination());
				unidadsForeignKey=unidadLogic.getUnidads();
			}

			detalleplaneacioncompraReturnGeneral.setunidadsForeignKey(unidadsForeignKey);
						
			
		} catch(Exception e) {			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			
		}
		
		return detalleplaneacioncompraReturnGeneral;
	}
	
	
	public void deepLoad(DetallePlaneacionCompra detalleplaneacioncompra,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			DetallePlaneacionCompraLogicAdditional.updateDetallePlaneacionCompraToGet(detalleplaneacioncompra,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		detalleplaneacioncompra.setEmpresa(detalleplaneacioncompraDataAccess.getEmpresa(connexion,detalleplaneacioncompra));
		detalleplaneacioncompra.setSucursal(detalleplaneacioncompraDataAccess.getSucursal(connexion,detalleplaneacioncompra));
		detalleplaneacioncompra.setEjercicio(detalleplaneacioncompraDataAccess.getEjercicio(connexion,detalleplaneacioncompra));
		detalleplaneacioncompra.setPeriodo(detalleplaneacioncompraDataAccess.getPeriodo(connexion,detalleplaneacioncompra));
		detalleplaneacioncompra.setPlaneacionCompra(detalleplaneacioncompraDataAccess.getPlaneacionCompra(connexion,detalleplaneacioncompra));
		detalleplaneacioncompra.setLinea(detalleplaneacioncompraDataAccess.getLinea(connexion,detalleplaneacioncompra));
		detalleplaneacioncompra.setProducto(detalleplaneacioncompraDataAccess.getProducto(connexion,detalleplaneacioncompra));
		detalleplaneacioncompra.setUnidad(detalleplaneacioncompraDataAccess.getUnidad(connexion,detalleplaneacioncompra));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				detalleplaneacioncompra.setEmpresa(detalleplaneacioncompraDataAccess.getEmpresa(connexion,detalleplaneacioncompra));
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				detalleplaneacioncompra.setSucursal(detalleplaneacioncompraDataAccess.getSucursal(connexion,detalleplaneacioncompra));
				continue;
			}

			if(clas.clas.equals(Ejercicio.class)) {
				detalleplaneacioncompra.setEjercicio(detalleplaneacioncompraDataAccess.getEjercicio(connexion,detalleplaneacioncompra));
				continue;
			}

			if(clas.clas.equals(Periodo.class)) {
				detalleplaneacioncompra.setPeriodo(detalleplaneacioncompraDataAccess.getPeriodo(connexion,detalleplaneacioncompra));
				continue;
			}

			if(clas.clas.equals(PlaneacionCompra.class)) {
				detalleplaneacioncompra.setPlaneacionCompra(detalleplaneacioncompraDataAccess.getPlaneacionCompra(connexion,detalleplaneacioncompra));
				continue;
			}

			if(clas.clas.equals(Linea.class)) {
				detalleplaneacioncompra.setLinea(detalleplaneacioncompraDataAccess.getLinea(connexion,detalleplaneacioncompra));
				continue;
			}

			if(clas.clas.equals(Producto.class)) {
				detalleplaneacioncompra.setProducto(detalleplaneacioncompraDataAccess.getProducto(connexion,detalleplaneacioncompra));
				continue;
			}

			if(clas.clas.equals(Unidad.class)) {
				detalleplaneacioncompra.setUnidad(detalleplaneacioncompraDataAccess.getUnidad(connexion,detalleplaneacioncompra));
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
			detalleplaneacioncompra.setEmpresa(detalleplaneacioncompraDataAccess.getEmpresa(connexion,detalleplaneacioncompra));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detalleplaneacioncompra.setSucursal(detalleplaneacioncompraDataAccess.getSucursal(connexion,detalleplaneacioncompra));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Ejercicio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detalleplaneacioncompra.setEjercicio(detalleplaneacioncompraDataAccess.getEjercicio(connexion,detalleplaneacioncompra));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Periodo.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detalleplaneacioncompra.setPeriodo(detalleplaneacioncompraDataAccess.getPeriodo(connexion,detalleplaneacioncompra));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(PlaneacionCompra.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detalleplaneacioncompra.setPlaneacionCompra(detalleplaneacioncompraDataAccess.getPlaneacionCompra(connexion,detalleplaneacioncompra));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Linea.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detalleplaneacioncompra.setLinea(detalleplaneacioncompraDataAccess.getLinea(connexion,detalleplaneacioncompra));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Producto.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detalleplaneacioncompra.setProducto(detalleplaneacioncompraDataAccess.getProducto(connexion,detalleplaneacioncompra));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Unidad.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detalleplaneacioncompra.setUnidad(detalleplaneacioncompraDataAccess.getUnidad(connexion,detalleplaneacioncompra));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		detalleplaneacioncompra.setEmpresa(detalleplaneacioncompraDataAccess.getEmpresa(connexion,detalleplaneacioncompra));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(detalleplaneacioncompra.getEmpresa(),isDeep,deepLoadType,clases);
				
		detalleplaneacioncompra.setSucursal(detalleplaneacioncompraDataAccess.getSucursal(connexion,detalleplaneacioncompra));
		SucursalLogic sucursalLogic= new SucursalLogic(connexion);
		sucursalLogic.deepLoad(detalleplaneacioncompra.getSucursal(),isDeep,deepLoadType,clases);
				
		detalleplaneacioncompra.setEjercicio(detalleplaneacioncompraDataAccess.getEjercicio(connexion,detalleplaneacioncompra));
		EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
		ejercicioLogic.deepLoad(detalleplaneacioncompra.getEjercicio(),isDeep,deepLoadType,clases);
				
		detalleplaneacioncompra.setPeriodo(detalleplaneacioncompraDataAccess.getPeriodo(connexion,detalleplaneacioncompra));
		PeriodoLogic periodoLogic= new PeriodoLogic(connexion);
		periodoLogic.deepLoad(detalleplaneacioncompra.getPeriodo(),isDeep,deepLoadType,clases);
				
		detalleplaneacioncompra.setPlaneacionCompra(detalleplaneacioncompraDataAccess.getPlaneacionCompra(connexion,detalleplaneacioncompra));
		PlaneacionCompraLogic planeacioncompraLogic= new PlaneacionCompraLogic(connexion);
		planeacioncompraLogic.deepLoad(detalleplaneacioncompra.getPlaneacionCompra(),isDeep,deepLoadType,clases);
				
		detalleplaneacioncompra.setLinea(detalleplaneacioncompraDataAccess.getLinea(connexion,detalleplaneacioncompra));
		LineaLogic lineaLogic= new LineaLogic(connexion);
		lineaLogic.deepLoad(detalleplaneacioncompra.getLinea(),isDeep,deepLoadType,clases);
				
		detalleplaneacioncompra.setProducto(detalleplaneacioncompraDataAccess.getProducto(connexion,detalleplaneacioncompra));
		ProductoLogic productoLogic= new ProductoLogic(connexion);
		productoLogic.deepLoad(detalleplaneacioncompra.getProducto(),isDeep,deepLoadType,clases);
				
		detalleplaneacioncompra.setUnidad(detalleplaneacioncompraDataAccess.getUnidad(connexion,detalleplaneacioncompra));
		UnidadLogic unidadLogic= new UnidadLogic(connexion);
		unidadLogic.deepLoad(detalleplaneacioncompra.getUnidad(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				detalleplaneacioncompra.setEmpresa(detalleplaneacioncompraDataAccess.getEmpresa(connexion,detalleplaneacioncompra));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(detalleplaneacioncompra.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				detalleplaneacioncompra.setSucursal(detalleplaneacioncompraDataAccess.getSucursal(connexion,detalleplaneacioncompra));
				SucursalLogic sucursalLogic= new SucursalLogic(connexion);
				sucursalLogic.deepLoad(detalleplaneacioncompra.getSucursal(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Ejercicio.class)) {
				detalleplaneacioncompra.setEjercicio(detalleplaneacioncompraDataAccess.getEjercicio(connexion,detalleplaneacioncompra));
				EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
				ejercicioLogic.deepLoad(detalleplaneacioncompra.getEjercicio(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Periodo.class)) {
				detalleplaneacioncompra.setPeriodo(detalleplaneacioncompraDataAccess.getPeriodo(connexion,detalleplaneacioncompra));
				PeriodoLogic periodoLogic= new PeriodoLogic(connexion);
				periodoLogic.deepLoad(detalleplaneacioncompra.getPeriodo(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(PlaneacionCompra.class)) {
				detalleplaneacioncompra.setPlaneacionCompra(detalleplaneacioncompraDataAccess.getPlaneacionCompra(connexion,detalleplaneacioncompra));
				PlaneacionCompraLogic planeacioncompraLogic= new PlaneacionCompraLogic(connexion);
				planeacioncompraLogic.deepLoad(detalleplaneacioncompra.getPlaneacionCompra(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Linea.class)) {
				detalleplaneacioncompra.setLinea(detalleplaneacioncompraDataAccess.getLinea(connexion,detalleplaneacioncompra));
				LineaLogic lineaLogic= new LineaLogic(connexion);
				lineaLogic.deepLoad(detalleplaneacioncompra.getLinea(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Producto.class)) {
				detalleplaneacioncompra.setProducto(detalleplaneacioncompraDataAccess.getProducto(connexion,detalleplaneacioncompra));
				ProductoLogic productoLogic= new ProductoLogic(connexion);
				productoLogic.deepLoad(detalleplaneacioncompra.getProducto(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Unidad.class)) {
				detalleplaneacioncompra.setUnidad(detalleplaneacioncompraDataAccess.getUnidad(connexion,detalleplaneacioncompra));
				UnidadLogic unidadLogic= new UnidadLogic(connexion);
				unidadLogic.deepLoad(detalleplaneacioncompra.getUnidad(),isDeep,deepLoadType,clases);				
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
			detalleplaneacioncompra.setEmpresa(detalleplaneacioncompraDataAccess.getEmpresa(connexion,detalleplaneacioncompra));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(detalleplaneacioncompra.getEmpresa(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detalleplaneacioncompra.setSucursal(detalleplaneacioncompraDataAccess.getSucursal(connexion,detalleplaneacioncompra));
			SucursalLogic sucursalLogic= new SucursalLogic(connexion);
			sucursalLogic.deepLoad(detalleplaneacioncompra.getSucursal(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Ejercicio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detalleplaneacioncompra.setEjercicio(detalleplaneacioncompraDataAccess.getEjercicio(connexion,detalleplaneacioncompra));
			EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
			ejercicioLogic.deepLoad(detalleplaneacioncompra.getEjercicio(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Periodo.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detalleplaneacioncompra.setPeriodo(detalleplaneacioncompraDataAccess.getPeriodo(connexion,detalleplaneacioncompra));
			PeriodoLogic periodoLogic= new PeriodoLogic(connexion);
			periodoLogic.deepLoad(detalleplaneacioncompra.getPeriodo(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(PlaneacionCompra.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detalleplaneacioncompra.setPlaneacionCompra(detalleplaneacioncompraDataAccess.getPlaneacionCompra(connexion,detalleplaneacioncompra));
			PlaneacionCompraLogic planeacioncompraLogic= new PlaneacionCompraLogic(connexion);
			planeacioncompraLogic.deepLoad(detalleplaneacioncompra.getPlaneacionCompra(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Linea.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detalleplaneacioncompra.setLinea(detalleplaneacioncompraDataAccess.getLinea(connexion,detalleplaneacioncompra));
			LineaLogic lineaLogic= new LineaLogic(connexion);
			lineaLogic.deepLoad(detalleplaneacioncompra.getLinea(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Producto.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detalleplaneacioncompra.setProducto(detalleplaneacioncompraDataAccess.getProducto(connexion,detalleplaneacioncompra));
			ProductoLogic productoLogic= new ProductoLogic(connexion);
			productoLogic.deepLoad(detalleplaneacioncompra.getProducto(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Unidad.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detalleplaneacioncompra.setUnidad(detalleplaneacioncompraDataAccess.getUnidad(connexion,detalleplaneacioncompra));
			UnidadLogic unidadLogic= new UnidadLogic(connexion);
			unidadLogic.deepLoad(detalleplaneacioncompra.getUnidad(),isDeep,deepLoadType,clases);
				
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(DetallePlaneacionCompra detalleplaneacioncompra,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			DetallePlaneacionCompraLogicAdditional.updateDetallePlaneacionCompraToSave(detalleplaneacioncompra,this.arrDatoGeneral);
			
DetallePlaneacionCompraDataAccess.save(detalleplaneacioncompra, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(detalleplaneacioncompra.getEmpresa(),connexion);

		SucursalDataAccess.save(detalleplaneacioncompra.getSucursal(),connexion);

		EjercicioDataAccess.save(detalleplaneacioncompra.getEjercicio(),connexion);

		PeriodoDataAccess.save(detalleplaneacioncompra.getPeriodo(),connexion);

		PlaneacionCompraDataAccess.save(detalleplaneacioncompra.getPlaneacionCompra(),connexion);

		LineaDataAccess.save(detalleplaneacioncompra.getLinea(),connexion);

		ProductoDataAccess.save(detalleplaneacioncompra.getProducto(),connexion);

		UnidadDataAccess.save(detalleplaneacioncompra.getUnidad(),connexion);
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(detalleplaneacioncompra.getEmpresa(),connexion);
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				SucursalDataAccess.save(detalleplaneacioncompra.getSucursal(),connexion);
				continue;
			}

			if(clas.clas.equals(Ejercicio.class)) {
				EjercicioDataAccess.save(detalleplaneacioncompra.getEjercicio(),connexion);
				continue;
			}

			if(clas.clas.equals(Periodo.class)) {
				PeriodoDataAccess.save(detalleplaneacioncompra.getPeriodo(),connexion);
				continue;
			}

			if(clas.clas.equals(PlaneacionCompra.class)) {
				PlaneacionCompraDataAccess.save(detalleplaneacioncompra.getPlaneacionCompra(),connexion);
				continue;
			}

			if(clas.clas.equals(Linea.class)) {
				LineaDataAccess.save(detalleplaneacioncompra.getLinea(),connexion);
				continue;
			}

			if(clas.clas.equals(Producto.class)) {
				ProductoDataAccess.save(detalleplaneacioncompra.getProducto(),connexion);
				continue;
			}

			if(clas.clas.equals(Unidad.class)) {
				UnidadDataAccess.save(detalleplaneacioncompra.getUnidad(),connexion);
				continue;
			}

		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(detalleplaneacioncompra.getEmpresa(),connexion);
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(detalleplaneacioncompra.getEmpresa(),isDeep,deepLoadType,clases);
				

		SucursalDataAccess.save(detalleplaneacioncompra.getSucursal(),connexion);
		SucursalLogic sucursalLogic= new SucursalLogic(connexion);
		sucursalLogic.deepLoad(detalleplaneacioncompra.getSucursal(),isDeep,deepLoadType,clases);
				

		EjercicioDataAccess.save(detalleplaneacioncompra.getEjercicio(),connexion);
		EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
		ejercicioLogic.deepLoad(detalleplaneacioncompra.getEjercicio(),isDeep,deepLoadType,clases);
				

		PeriodoDataAccess.save(detalleplaneacioncompra.getPeriodo(),connexion);
		PeriodoLogic periodoLogic= new PeriodoLogic(connexion);
		periodoLogic.deepLoad(detalleplaneacioncompra.getPeriodo(),isDeep,deepLoadType,clases);
				

		PlaneacionCompraDataAccess.save(detalleplaneacioncompra.getPlaneacionCompra(),connexion);
		PlaneacionCompraLogic planeacioncompraLogic= new PlaneacionCompraLogic(connexion);
		planeacioncompraLogic.deepLoad(detalleplaneacioncompra.getPlaneacionCompra(),isDeep,deepLoadType,clases);
				

		LineaDataAccess.save(detalleplaneacioncompra.getLinea(),connexion);
		LineaLogic lineaLogic= new LineaLogic(connexion);
		lineaLogic.deepLoad(detalleplaneacioncompra.getLinea(),isDeep,deepLoadType,clases);
				

		ProductoDataAccess.save(detalleplaneacioncompra.getProducto(),connexion);
		ProductoLogic productoLogic= new ProductoLogic(connexion);
		productoLogic.deepLoad(detalleplaneacioncompra.getProducto(),isDeep,deepLoadType,clases);
				

		UnidadDataAccess.save(detalleplaneacioncompra.getUnidad(),connexion);
		UnidadLogic unidadLogic= new UnidadLogic(connexion);
		unidadLogic.deepLoad(detalleplaneacioncompra.getUnidad(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(detalleplaneacioncompra.getEmpresa(),connexion);
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepSave(detalleplaneacioncompra.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				SucursalDataAccess.save(detalleplaneacioncompra.getSucursal(),connexion);
				SucursalLogic sucursalLogic= new SucursalLogic(connexion);
				sucursalLogic.deepSave(detalleplaneacioncompra.getSucursal(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Ejercicio.class)) {
				EjercicioDataAccess.save(detalleplaneacioncompra.getEjercicio(),connexion);
				EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
				ejercicioLogic.deepSave(detalleplaneacioncompra.getEjercicio(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Periodo.class)) {
				PeriodoDataAccess.save(detalleplaneacioncompra.getPeriodo(),connexion);
				PeriodoLogic periodoLogic= new PeriodoLogic(connexion);
				periodoLogic.deepSave(detalleplaneacioncompra.getPeriodo(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(PlaneacionCompra.class)) {
				PlaneacionCompraDataAccess.save(detalleplaneacioncompra.getPlaneacionCompra(),connexion);
				PlaneacionCompraLogic planeacioncompraLogic= new PlaneacionCompraLogic(connexion);
				planeacioncompraLogic.deepSave(detalleplaneacioncompra.getPlaneacionCompra(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Linea.class)) {
				LineaDataAccess.save(detalleplaneacioncompra.getLinea(),connexion);
				LineaLogic lineaLogic= new LineaLogic(connexion);
				lineaLogic.deepSave(detalleplaneacioncompra.getLinea(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Producto.class)) {
				ProductoDataAccess.save(detalleplaneacioncompra.getProducto(),connexion);
				ProductoLogic productoLogic= new ProductoLogic(connexion);
				productoLogic.deepSave(detalleplaneacioncompra.getProducto(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Unidad.class)) {
				UnidadDataAccess.save(detalleplaneacioncompra.getUnidad(),connexion);
				UnidadLogic unidadLogic= new UnidadLogic(connexion);
				unidadLogic.deepSave(detalleplaneacioncompra.getUnidad(),isDeep,deepLoadType,clases);				
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
			this.getNewConnexionToDeep(DetallePlaneacionCompra.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(detalleplaneacioncompra,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				DetallePlaneacionCompraConstantesFunciones.refrescarForeignKeysDescripcionesDetallePlaneacionCompra(detalleplaneacioncompra);
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
			this.deepLoad(this.detalleplaneacioncompra,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				DetallePlaneacionCompraConstantesFunciones.refrescarForeignKeysDescripcionesDetallePlaneacionCompra(this.detalleplaneacioncompra);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(DetallePlaneacionCompra.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(detalleplaneacioncompras!=null) {
				for(DetallePlaneacionCompra detalleplaneacioncompra:detalleplaneacioncompras) {
					this.deepLoad(detalleplaneacioncompra,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					DetallePlaneacionCompraConstantesFunciones.refrescarForeignKeysDescripcionesDetallePlaneacionCompra(detalleplaneacioncompras);
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
			if(detalleplaneacioncompras!=null) {
				for(DetallePlaneacionCompra detalleplaneacioncompra:detalleplaneacioncompras) {
					this.deepLoad(detalleplaneacioncompra,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					DetallePlaneacionCompraConstantesFunciones.refrescarForeignKeysDescripcionesDetallePlaneacionCompra(detalleplaneacioncompras);
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
			this.getNewConnexionToDeep(DetallePlaneacionCompra.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(detalleplaneacioncompra,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(DetallePlaneacionCompra.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(detalleplaneacioncompras!=null) {
				for(DetallePlaneacionCompra detalleplaneacioncompra:detalleplaneacioncompras) {
					this.deepSave(detalleplaneacioncompra,isDeep,deepLoadType,clases);
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
			if(detalleplaneacioncompras!=null) {
				for(DetallePlaneacionCompra detalleplaneacioncompra:detalleplaneacioncompras) {
					this.deepSave(detalleplaneacioncompra,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getDetallePlaneacionComprasFK_IdEjercicioWithConnection(String sFinalQuery,Pagination pagination,Long id_ejercicio)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetallePlaneacionCompra.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEjercicio= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEjercicio.setParameterSelectionGeneralEqual(ParameterType.LONG,id_ejercicio,DetallePlaneacionCompraConstantesFunciones.IDEJERCICIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEjercicio);

			DetallePlaneacionCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEjercicio","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detalleplaneacioncompras=detalleplaneacioncompraDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetallePlaneacionCompraConstantesFunciones.refrescarForeignKeysDescripcionesDetallePlaneacionCompra(this.detalleplaneacioncompras);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getDetallePlaneacionComprasFK_IdEjercicio(String sFinalQuery,Pagination pagination,Long id_ejercicio)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEjercicio= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEjercicio.setParameterSelectionGeneralEqual(ParameterType.LONG,id_ejercicio,DetallePlaneacionCompraConstantesFunciones.IDEJERCICIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEjercicio);

			DetallePlaneacionCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEjercicio","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detalleplaneacioncompras=detalleplaneacioncompraDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetallePlaneacionCompraConstantesFunciones.refrescarForeignKeysDescripcionesDetallePlaneacionCompra(this.detalleplaneacioncompras);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getDetallePlaneacionComprasFK_IdEmpresaWithConnection(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetallePlaneacionCompra.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,DetallePlaneacionCompraConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			DetallePlaneacionCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detalleplaneacioncompras=detalleplaneacioncompraDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetallePlaneacionCompraConstantesFunciones.refrescarForeignKeysDescripcionesDetallePlaneacionCompra(this.detalleplaneacioncompras);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getDetallePlaneacionComprasFK_IdEmpresa(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,DetallePlaneacionCompraConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			DetallePlaneacionCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detalleplaneacioncompras=detalleplaneacioncompraDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetallePlaneacionCompraConstantesFunciones.refrescarForeignKeysDescripcionesDetallePlaneacionCompra(this.detalleplaneacioncompras);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getDetallePlaneacionComprasFK_IdLineaWithConnection(String sFinalQuery,Pagination pagination,Long id_linea)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetallePlaneacionCompra.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidLinea= new ParameterSelectionGeneral();
			parameterSelectionGeneralidLinea.setParameterSelectionGeneralEqual(ParameterType.LONG,id_linea,DetallePlaneacionCompraConstantesFunciones.IDLINEA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidLinea);

			DetallePlaneacionCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdLinea","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detalleplaneacioncompras=detalleplaneacioncompraDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetallePlaneacionCompraConstantesFunciones.refrescarForeignKeysDescripcionesDetallePlaneacionCompra(this.detalleplaneacioncompras);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getDetallePlaneacionComprasFK_IdLinea(String sFinalQuery,Pagination pagination,Long id_linea)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidLinea= new ParameterSelectionGeneral();
			parameterSelectionGeneralidLinea.setParameterSelectionGeneralEqual(ParameterType.LONG,id_linea,DetallePlaneacionCompraConstantesFunciones.IDLINEA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidLinea);

			DetallePlaneacionCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdLinea","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detalleplaneacioncompras=detalleplaneacioncompraDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetallePlaneacionCompraConstantesFunciones.refrescarForeignKeysDescripcionesDetallePlaneacionCompra(this.detalleplaneacioncompras);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getDetallePlaneacionComprasFK_IdPeriodoWithConnection(String sFinalQuery,Pagination pagination,Long id_periodo)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetallePlaneacionCompra.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidPeriodo= new ParameterSelectionGeneral();
			parameterSelectionGeneralidPeriodo.setParameterSelectionGeneralEqual(ParameterType.LONG,id_periodo,DetallePlaneacionCompraConstantesFunciones.IDPERIODO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidPeriodo);

			DetallePlaneacionCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdPeriodo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detalleplaneacioncompras=detalleplaneacioncompraDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetallePlaneacionCompraConstantesFunciones.refrescarForeignKeysDescripcionesDetallePlaneacionCompra(this.detalleplaneacioncompras);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getDetallePlaneacionComprasFK_IdPeriodo(String sFinalQuery,Pagination pagination,Long id_periodo)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidPeriodo= new ParameterSelectionGeneral();
			parameterSelectionGeneralidPeriodo.setParameterSelectionGeneralEqual(ParameterType.LONG,id_periodo,DetallePlaneacionCompraConstantesFunciones.IDPERIODO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidPeriodo);

			DetallePlaneacionCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdPeriodo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detalleplaneacioncompras=detalleplaneacioncompraDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetallePlaneacionCompraConstantesFunciones.refrescarForeignKeysDescripcionesDetallePlaneacionCompra(this.detalleplaneacioncompras);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getDetallePlaneacionComprasFK_IdPlaneacionCompraWithConnection(String sFinalQuery,Pagination pagination,Long id_planeacion_compra)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetallePlaneacionCompra.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidPlaneacionCompra= new ParameterSelectionGeneral();
			parameterSelectionGeneralidPlaneacionCompra.setParameterSelectionGeneralEqual(ParameterType.LONG,id_planeacion_compra,DetallePlaneacionCompraConstantesFunciones.IDPLANEACIONCOMPRA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidPlaneacionCompra);

			DetallePlaneacionCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdPlaneacionCompra","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detalleplaneacioncompras=detalleplaneacioncompraDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetallePlaneacionCompraConstantesFunciones.refrescarForeignKeysDescripcionesDetallePlaneacionCompra(this.detalleplaneacioncompras);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getDetallePlaneacionComprasFK_IdPlaneacionCompra(String sFinalQuery,Pagination pagination,Long id_planeacion_compra)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidPlaneacionCompra= new ParameterSelectionGeneral();
			parameterSelectionGeneralidPlaneacionCompra.setParameterSelectionGeneralEqual(ParameterType.LONG,id_planeacion_compra,DetallePlaneacionCompraConstantesFunciones.IDPLANEACIONCOMPRA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidPlaneacionCompra);

			DetallePlaneacionCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdPlaneacionCompra","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detalleplaneacioncompras=detalleplaneacioncompraDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetallePlaneacionCompraConstantesFunciones.refrescarForeignKeysDescripcionesDetallePlaneacionCompra(this.detalleplaneacioncompras);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getDetallePlaneacionComprasFK_IdProductoWithConnection(String sFinalQuery,Pagination pagination,Long id_producto)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetallePlaneacionCompra.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidProducto= new ParameterSelectionGeneral();
			parameterSelectionGeneralidProducto.setParameterSelectionGeneralEqual(ParameterType.LONG,id_producto,DetallePlaneacionCompraConstantesFunciones.IDPRODUCTO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidProducto);

			DetallePlaneacionCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdProducto","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detalleplaneacioncompras=detalleplaneacioncompraDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetallePlaneacionCompraConstantesFunciones.refrescarForeignKeysDescripcionesDetallePlaneacionCompra(this.detalleplaneacioncompras);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getDetallePlaneacionComprasFK_IdProducto(String sFinalQuery,Pagination pagination,Long id_producto)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidProducto= new ParameterSelectionGeneral();
			parameterSelectionGeneralidProducto.setParameterSelectionGeneralEqual(ParameterType.LONG,id_producto,DetallePlaneacionCompraConstantesFunciones.IDPRODUCTO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidProducto);

			DetallePlaneacionCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdProducto","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detalleplaneacioncompras=detalleplaneacioncompraDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetallePlaneacionCompraConstantesFunciones.refrescarForeignKeysDescripcionesDetallePlaneacionCompra(this.detalleplaneacioncompras);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getDetallePlaneacionComprasFK_IdSucursalWithConnection(String sFinalQuery,Pagination pagination,Long id_sucursal)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetallePlaneacionCompra.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidSucursal= new ParameterSelectionGeneral();
			parameterSelectionGeneralidSucursal.setParameterSelectionGeneralEqual(ParameterType.LONG,id_sucursal,DetallePlaneacionCompraConstantesFunciones.IDSUCURSAL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidSucursal);

			DetallePlaneacionCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdSucursal","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detalleplaneacioncompras=detalleplaneacioncompraDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetallePlaneacionCompraConstantesFunciones.refrescarForeignKeysDescripcionesDetallePlaneacionCompra(this.detalleplaneacioncompras);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getDetallePlaneacionComprasFK_IdSucursal(String sFinalQuery,Pagination pagination,Long id_sucursal)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidSucursal= new ParameterSelectionGeneral();
			parameterSelectionGeneralidSucursal.setParameterSelectionGeneralEqual(ParameterType.LONG,id_sucursal,DetallePlaneacionCompraConstantesFunciones.IDSUCURSAL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidSucursal);

			DetallePlaneacionCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdSucursal","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detalleplaneacioncompras=detalleplaneacioncompraDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetallePlaneacionCompraConstantesFunciones.refrescarForeignKeysDescripcionesDetallePlaneacionCompra(this.detalleplaneacioncompras);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getDetallePlaneacionComprasFK_IdUnidadWithConnection(String sFinalQuery,Pagination pagination,Long id_unidad)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetallePlaneacionCompra.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidUnidad= new ParameterSelectionGeneral();
			parameterSelectionGeneralidUnidad.setParameterSelectionGeneralEqual(ParameterType.LONG,id_unidad,DetallePlaneacionCompraConstantesFunciones.IDUNIDAD,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidUnidad);

			DetallePlaneacionCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdUnidad","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detalleplaneacioncompras=detalleplaneacioncompraDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetallePlaneacionCompraConstantesFunciones.refrescarForeignKeysDescripcionesDetallePlaneacionCompra(this.detalleplaneacioncompras);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getDetallePlaneacionComprasFK_IdUnidad(String sFinalQuery,Pagination pagination,Long id_unidad)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidUnidad= new ParameterSelectionGeneral();
			parameterSelectionGeneralidUnidad.setParameterSelectionGeneralEqual(ParameterType.LONG,id_unidad,DetallePlaneacionCompraConstantesFunciones.IDUNIDAD,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidUnidad);

			DetallePlaneacionCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdUnidad","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detalleplaneacioncompras=detalleplaneacioncompraDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetallePlaneacionCompraConstantesFunciones.refrescarForeignKeysDescripcionesDetallePlaneacionCompra(this.detalleplaneacioncompras);
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
			if(DetallePlaneacionCompraConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,DetallePlaneacionCompraDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,DetallePlaneacionCompra detalleplaneacioncompra,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(DetallePlaneacionCompraConstantesFunciones.ISCONAUDITORIA) {
				if(detalleplaneacioncompra.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,DetallePlaneacionCompraDataAccess.TABLENAME, detalleplaneacioncompra.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(DetallePlaneacionCompraConstantesFunciones.ISCONAUDITORIADETALLE) {
						////DetallePlaneacionCompraLogic.registrarAuditoriaDetallesDetallePlaneacionCompra(connexion,detalleplaneacioncompra,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(detalleplaneacioncompra.getIsDeleted()) {
					/*if(!detalleplaneacioncompra.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,DetallePlaneacionCompraDataAccess.TABLENAME, detalleplaneacioncompra.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////DetallePlaneacionCompraLogic.registrarAuditoriaDetallesDetallePlaneacionCompra(connexion,detalleplaneacioncompra,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,DetallePlaneacionCompraDataAccess.TABLENAME, detalleplaneacioncompra.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(detalleplaneacioncompra.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,DetallePlaneacionCompraDataAccess.TABLENAME, detalleplaneacioncompra.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(DetallePlaneacionCompraConstantesFunciones.ISCONAUDITORIADETALLE) {
						////DetallePlaneacionCompraLogic.registrarAuditoriaDetallesDetallePlaneacionCompra(connexion,detalleplaneacioncompra,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesDetallePlaneacionCompra(Connexion connexion,DetallePlaneacionCompra detalleplaneacioncompra)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(detalleplaneacioncompra.getIsNew()||!detalleplaneacioncompra.getid_empresa().equals(detalleplaneacioncompra.getDetallePlaneacionCompraOriginal().getid_empresa()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detalleplaneacioncompra.getDetallePlaneacionCompraOriginal().getid_empresa()!=null)
				{
					strValorActual=detalleplaneacioncompra.getDetallePlaneacionCompraOriginal().getid_empresa().toString();
				}
				if(detalleplaneacioncompra.getid_empresa()!=null)
				{
					strValorNuevo=detalleplaneacioncompra.getid_empresa().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetallePlaneacionCompraConstantesFunciones.IDEMPRESA,strValorActual,strValorNuevo);
			}	
			
			if(detalleplaneacioncompra.getIsNew()||!detalleplaneacioncompra.getid_sucursal().equals(detalleplaneacioncompra.getDetallePlaneacionCompraOriginal().getid_sucursal()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detalleplaneacioncompra.getDetallePlaneacionCompraOriginal().getid_sucursal()!=null)
				{
					strValorActual=detalleplaneacioncompra.getDetallePlaneacionCompraOriginal().getid_sucursal().toString();
				}
				if(detalleplaneacioncompra.getid_sucursal()!=null)
				{
					strValorNuevo=detalleplaneacioncompra.getid_sucursal().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetallePlaneacionCompraConstantesFunciones.IDSUCURSAL,strValorActual,strValorNuevo);
			}	
			
			if(detalleplaneacioncompra.getIsNew()||!detalleplaneacioncompra.getid_ejercicio().equals(detalleplaneacioncompra.getDetallePlaneacionCompraOriginal().getid_ejercicio()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detalleplaneacioncompra.getDetallePlaneacionCompraOriginal().getid_ejercicio()!=null)
				{
					strValorActual=detalleplaneacioncompra.getDetallePlaneacionCompraOriginal().getid_ejercicio().toString();
				}
				if(detalleplaneacioncompra.getid_ejercicio()!=null)
				{
					strValorNuevo=detalleplaneacioncompra.getid_ejercicio().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetallePlaneacionCompraConstantesFunciones.IDEJERCICIO,strValorActual,strValorNuevo);
			}	
			
			if(detalleplaneacioncompra.getIsNew()||!detalleplaneacioncompra.getid_periodo().equals(detalleplaneacioncompra.getDetallePlaneacionCompraOriginal().getid_periodo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detalleplaneacioncompra.getDetallePlaneacionCompraOriginal().getid_periodo()!=null)
				{
					strValorActual=detalleplaneacioncompra.getDetallePlaneacionCompraOriginal().getid_periodo().toString();
				}
				if(detalleplaneacioncompra.getid_periodo()!=null)
				{
					strValorNuevo=detalleplaneacioncompra.getid_periodo().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetallePlaneacionCompraConstantesFunciones.IDPERIODO,strValorActual,strValorNuevo);
			}	
			
			if(detalleplaneacioncompra.getIsNew()||!detalleplaneacioncompra.getid_planeacion_compra().equals(detalleplaneacioncompra.getDetallePlaneacionCompraOriginal().getid_planeacion_compra()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detalleplaneacioncompra.getDetallePlaneacionCompraOriginal().getid_planeacion_compra()!=null)
				{
					strValorActual=detalleplaneacioncompra.getDetallePlaneacionCompraOriginal().getid_planeacion_compra().toString();
				}
				if(detalleplaneacioncompra.getid_planeacion_compra()!=null)
				{
					strValorNuevo=detalleplaneacioncompra.getid_planeacion_compra().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetallePlaneacionCompraConstantesFunciones.IDPLANEACIONCOMPRA,strValorActual,strValorNuevo);
			}	
			
			if(detalleplaneacioncompra.getIsNew()||!detalleplaneacioncompra.getid_linea().equals(detalleplaneacioncompra.getDetallePlaneacionCompraOriginal().getid_linea()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detalleplaneacioncompra.getDetallePlaneacionCompraOriginal().getid_linea()!=null)
				{
					strValorActual=detalleplaneacioncompra.getDetallePlaneacionCompraOriginal().getid_linea().toString();
				}
				if(detalleplaneacioncompra.getid_linea()!=null)
				{
					strValorNuevo=detalleplaneacioncompra.getid_linea().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetallePlaneacionCompraConstantesFunciones.IDLINEA,strValorActual,strValorNuevo);
			}	
			
			if(detalleplaneacioncompra.getIsNew()||!detalleplaneacioncompra.getid_producto().equals(detalleplaneacioncompra.getDetallePlaneacionCompraOriginal().getid_producto()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detalleplaneacioncompra.getDetallePlaneacionCompraOriginal().getid_producto()!=null)
				{
					strValorActual=detalleplaneacioncompra.getDetallePlaneacionCompraOriginal().getid_producto().toString();
				}
				if(detalleplaneacioncompra.getid_producto()!=null)
				{
					strValorNuevo=detalleplaneacioncompra.getid_producto().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetallePlaneacionCompraConstantesFunciones.IDPRODUCTO,strValorActual,strValorNuevo);
			}	
			
			if(detalleplaneacioncompra.getIsNew()||!detalleplaneacioncompra.getid_unidad().equals(detalleplaneacioncompra.getDetallePlaneacionCompraOriginal().getid_unidad()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detalleplaneacioncompra.getDetallePlaneacionCompraOriginal().getid_unidad()!=null)
				{
					strValorActual=detalleplaneacioncompra.getDetallePlaneacionCompraOriginal().getid_unidad().toString();
				}
				if(detalleplaneacioncompra.getid_unidad()!=null)
				{
					strValorNuevo=detalleplaneacioncompra.getid_unidad().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetallePlaneacionCompraConstantesFunciones.IDUNIDAD,strValorActual,strValorNuevo);
			}	
			
			if(detalleplaneacioncompra.getIsNew()||!detalleplaneacioncompra.getstock().equals(detalleplaneacioncompra.getDetallePlaneacionCompraOriginal().getstock()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detalleplaneacioncompra.getDetallePlaneacionCompraOriginal().getstock()!=null)
				{
					strValorActual=detalleplaneacioncompra.getDetallePlaneacionCompraOriginal().getstock().toString();
				}
				if(detalleplaneacioncompra.getstock()!=null)
				{
					strValorNuevo=detalleplaneacioncompra.getstock().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetallePlaneacionCompraConstantesFunciones.STOCK,strValorActual,strValorNuevo);
			}	
			
			if(detalleplaneacioncompra.getIsNew()||!detalleplaneacioncompra.getdia_minimo().equals(detalleplaneacioncompra.getDetallePlaneacionCompraOriginal().getdia_minimo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detalleplaneacioncompra.getDetallePlaneacionCompraOriginal().getdia_minimo()!=null)
				{
					strValorActual=detalleplaneacioncompra.getDetallePlaneacionCompraOriginal().getdia_minimo().toString();
				}
				if(detalleplaneacioncompra.getdia_minimo()!=null)
				{
					strValorNuevo=detalleplaneacioncompra.getdia_minimo().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetallePlaneacionCompraConstantesFunciones.DIAMINIMO,strValorActual,strValorNuevo);
			}	
			
			if(detalleplaneacioncompra.getIsNew()||!detalleplaneacioncompra.getstock_minimo().equals(detalleplaneacioncompra.getDetallePlaneacionCompraOriginal().getstock_minimo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detalleplaneacioncompra.getDetallePlaneacionCompraOriginal().getstock_minimo()!=null)
				{
					strValorActual=detalleplaneacioncompra.getDetallePlaneacionCompraOriginal().getstock_minimo().toString();
				}
				if(detalleplaneacioncompra.getstock_minimo()!=null)
				{
					strValorNuevo=detalleplaneacioncompra.getstock_minimo().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetallePlaneacionCompraConstantesFunciones.STOCKMINIMO,strValorActual,strValorNuevo);
			}	
			
			if(detalleplaneacioncompra.getIsNew()||!detalleplaneacioncompra.getdia_maximo().equals(detalleplaneacioncompra.getDetallePlaneacionCompraOriginal().getdia_maximo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detalleplaneacioncompra.getDetallePlaneacionCompraOriginal().getdia_maximo()!=null)
				{
					strValorActual=detalleplaneacioncompra.getDetallePlaneacionCompraOriginal().getdia_maximo().toString();
				}
				if(detalleplaneacioncompra.getdia_maximo()!=null)
				{
					strValorNuevo=detalleplaneacioncompra.getdia_maximo().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetallePlaneacionCompraConstantesFunciones.DIAMAXIMO,strValorActual,strValorNuevo);
			}	
			
			if(detalleplaneacioncompra.getIsNew()||!detalleplaneacioncompra.getstock_maximo().equals(detalleplaneacioncompra.getDetallePlaneacionCompraOriginal().getstock_maximo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detalleplaneacioncompra.getDetallePlaneacionCompraOriginal().getstock_maximo()!=null)
				{
					strValorActual=detalleplaneacioncompra.getDetallePlaneacionCompraOriginal().getstock_maximo().toString();
				}
				if(detalleplaneacioncompra.getstock_maximo()!=null)
				{
					strValorNuevo=detalleplaneacioncompra.getstock_maximo().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetallePlaneacionCompraConstantesFunciones.STOCKMAXIMO,strValorActual,strValorNuevo);
			}	
			
			if(detalleplaneacioncompra.getIsNew()||!detalleplaneacioncompra.getsalida().equals(detalleplaneacioncompra.getDetallePlaneacionCompraOriginal().getsalida()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detalleplaneacioncompra.getDetallePlaneacionCompraOriginal().getsalida()!=null)
				{
					strValorActual=detalleplaneacioncompra.getDetallePlaneacionCompraOriginal().getsalida().toString();
				}
				if(detalleplaneacioncompra.getsalida()!=null)
				{
					strValorNuevo=detalleplaneacioncompra.getsalida().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetallePlaneacionCompraConstantesFunciones.SALIDA,strValorActual,strValorNuevo);
			}	
			
			if(detalleplaneacioncompra.getIsNew()||!detalleplaneacioncompra.getstock_mensual().equals(detalleplaneacioncompra.getDetallePlaneacionCompraOriginal().getstock_mensual()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detalleplaneacioncompra.getDetallePlaneacionCompraOriginal().getstock_mensual()!=null)
				{
					strValorActual=detalleplaneacioncompra.getDetallePlaneacionCompraOriginal().getstock_mensual().toString();
				}
				if(detalleplaneacioncompra.getstock_mensual()!=null)
				{
					strValorNuevo=detalleplaneacioncompra.getstock_mensual().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetallePlaneacionCompraConstantesFunciones.STOCKMENSUAL,strValorActual,strValorNuevo);
			}	
			
			if(detalleplaneacioncompra.getIsNew()||!detalleplaneacioncompra.getdescripcion().equals(detalleplaneacioncompra.getDetallePlaneacionCompraOriginal().getdescripcion()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detalleplaneacioncompra.getDetallePlaneacionCompraOriginal().getdescripcion()!=null)
				{
					strValorActual=detalleplaneacioncompra.getDetallePlaneacionCompraOriginal().getdescripcion();
				}
				if(detalleplaneacioncompra.getdescripcion()!=null)
				{
					strValorNuevo=detalleplaneacioncompra.getdescripcion() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetallePlaneacionCompraConstantesFunciones.DESCRIPCION,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void saveDetallePlaneacionCompraRelacionesWithConnection(DetallePlaneacionCompra detalleplaneacioncompra) throws Exception {

		if(!detalleplaneacioncompra.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveDetallePlaneacionCompraRelacionesBase(detalleplaneacioncompra,true);
		}
	}

	public void saveDetallePlaneacionCompraRelaciones(DetallePlaneacionCompra detalleplaneacioncompra)throws Exception {

		if(!detalleplaneacioncompra.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveDetallePlaneacionCompraRelacionesBase(detalleplaneacioncompra,false);
		}
	}

	public void saveDetallePlaneacionCompraRelacionesBase(DetallePlaneacionCompra detalleplaneacioncompra,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("DetallePlaneacionCompra-saveRelacionesWithConnection");}
	

			this.setDetallePlaneacionCompra(detalleplaneacioncompra);

			if(DetallePlaneacionCompraLogicAdditional.validarSaveRelaciones(detalleplaneacioncompra,this)) {

				DetallePlaneacionCompraLogicAdditional.updateRelacionesToSave(detalleplaneacioncompra,this);

				if((detalleplaneacioncompra.getIsNew()||detalleplaneacioncompra.getIsChanged())&&!detalleplaneacioncompra.getIsDeleted()) {
					this.saveDetallePlaneacionCompra();
					this.saveDetallePlaneacionCompraRelacionesDetalles();

				} else if(detalleplaneacioncompra.getIsDeleted()) {
					this.saveDetallePlaneacionCompraRelacionesDetalles();
					this.saveDetallePlaneacionCompra();
				}

				DetallePlaneacionCompraLogicAdditional.updateRelacionesToSaveAfter(detalleplaneacioncompra,this);

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
	
	
	private void saveDetallePlaneacionCompraRelacionesDetalles()throws Exception {
		try {
	

		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfDetallePlaneacionCompra(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=DetallePlaneacionCompraConstantesFunciones.getClassesForeignKeysOfDetallePlaneacionCompra(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfDetallePlaneacionCompra(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=DetallePlaneacionCompraConstantesFunciones.getClassesRelationshipsOfDetallePlaneacionCompra(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}
