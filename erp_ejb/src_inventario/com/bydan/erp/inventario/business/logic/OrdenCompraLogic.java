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
import com.bydan.erp.inventario.util.OrdenCompraConstantesFunciones;
import com.bydan.erp.inventario.util.OrdenCompraParameterReturnGeneral;
//import com.bydan.erp.inventario.util.OrdenCompraParameterGeneral;
import com.bydan.erp.inventario.business.entity.OrdenCompra;
import com.bydan.erp.inventario.business.logic.OrdenCompraLogicAdditional;
import com.bydan.erp.inventario.business.dataaccess.*;
import com.bydan.erp.inventario.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.facturacion.business.entity.*;
import com.bydan.erp.nomina.business.entity.*;
import com.bydan.erp.tesoreria.business.entity.*;
import com.bydan.erp.inventario.business.entity.*;
import com.bydan.erp.sris.business.entity.*;


import com.bydan.erp.seguridad.business.logic.*;
import com.bydan.erp.contabilidad.business.logic.*;
import com.bydan.erp.cartera.business.logic.*;
import com.bydan.erp.facturacion.business.logic.*;
import com.bydan.erp.nomina.business.logic.*;
import com.bydan.erp.tesoreria.business.logic.*;
import com.bydan.erp.inventario.business.logic.*;
import com.bydan.erp.sris.business.logic.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.contabilidad.util.*;
import com.bydan.erp.cartera.util.*;
import com.bydan.erp.facturacion.util.*;
import com.bydan.erp.nomina.util.*;
import com.bydan.erp.tesoreria.util.*;
import com.bydan.erp.inventario.util.*;
import com.bydan.erp.sris.util.*;


import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.contabilidad.business.dataaccess.*;
import com.bydan.erp.cartera.business.dataaccess.*;
import com.bydan.erp.facturacion.business.dataaccess.*;
import com.bydan.erp.nomina.business.dataaccess.*;
import com.bydan.erp.tesoreria.business.dataaccess.*;
import com.bydan.erp.inventario.business.dataaccess.*;
import com.bydan.erp.sris.business.dataaccess.*;








@SuppressWarnings("unused")
public class OrdenCompraLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(OrdenCompraLogic.class);
	
	protected OrdenCompraDataAccess ordencompraDataAccess; 	
	protected OrdenCompra ordencompra;
	protected List<OrdenCompra> ordencompras;
	protected Object ordencompraObject;	
	protected List<Object> ordencomprasObject;
	
	public static ClassValidator<OrdenCompra> ordencompraValidator = new ClassValidator<OrdenCompra>(OrdenCompra.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected OrdenCompraLogicAdditional ordencompraLogicAdditional=null;
	
	public OrdenCompraLogicAdditional getOrdenCompraLogicAdditional() {
		return this.ordencompraLogicAdditional;
	}
	
	public void setOrdenCompraLogicAdditional(OrdenCompraLogicAdditional ordencompraLogicAdditional) {
		try {
			this.ordencompraLogicAdditional=ordencompraLogicAdditional;
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
	
	
	
	
	public  OrdenCompraLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.ordencompraDataAccess = new OrdenCompraDataAccess();
			
			this.ordencompras= new ArrayList<OrdenCompra>();
			this.ordencompra= new OrdenCompra();
			
			this.ordencompraObject=new Object();
			this.ordencomprasObject=new ArrayList<Object>();
				
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
			
			this.ordencompraDataAccess.setConnexionType(this.connexionType);
			this.ordencompraDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  OrdenCompraLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.ordencompraDataAccess = new OrdenCompraDataAccess();
			this.ordencompras= new ArrayList<OrdenCompra>();
			this.ordencompra= new OrdenCompra();
			this.ordencompraObject=new Object();
			this.ordencomprasObject=new ArrayList<Object>();
			
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
			
			this.ordencompraDataAccess.setConnexionType(this.connexionType);
			this.ordencompraDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public OrdenCompra getOrdenCompra() throws Exception {	
		OrdenCompraLogicAdditional.checkOrdenCompraToGet(ordencompra,this.datosCliente,this.arrDatoGeneral);
		OrdenCompraLogicAdditional.updateOrdenCompraToGet(ordencompra,this.arrDatoGeneral);
		
		return ordencompra;
	}
		
	public void setOrdenCompra(OrdenCompra newOrdenCompra) {
		this.ordencompra = newOrdenCompra;
	}
	
	public OrdenCompraDataAccess getOrdenCompraDataAccess() {
		return ordencompraDataAccess;
	}
	
	public void setOrdenCompraDataAccess(OrdenCompraDataAccess newordencompraDataAccess) {
		this.ordencompraDataAccess = newordencompraDataAccess;
	}
	
	public List<OrdenCompra> getOrdenCompras() throws Exception {		
		this.quitarOrdenComprasNulos();
		
		OrdenCompraLogicAdditional.checkOrdenCompraToGets(ordencompras,this.datosCliente,this.arrDatoGeneral);
		
		for (OrdenCompra ordencompraLocal: ordencompras ) {
			OrdenCompraLogicAdditional.updateOrdenCompraToGet(ordencompraLocal,this.arrDatoGeneral);
		}
		
		return ordencompras;
	}
	
	public void setOrdenCompras(List<OrdenCompra> newOrdenCompras) {
		this.ordencompras = newOrdenCompras;
	}
	
	public Object getOrdenCompraObject() {	
		this.ordencompraObject=this.ordencompraDataAccess.getEntityObject();
		return this.ordencompraObject;
	}
		
	public void setOrdenCompraObject(Object newOrdenCompraObject) {
		this.ordencompraObject = newOrdenCompraObject;
	}
	
	public List<Object> getOrdenComprasObject() {		
		this.ordencomprasObject=this.ordencompraDataAccess.getEntitiesObject();
		return this.ordencomprasObject;
	}
		
	public void setOrdenComprasObject(List<Object> newOrdenComprasObject) {
		this.ordencomprasObject = newOrdenComprasObject;
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
		
		if(this.ordencompraDataAccess!=null) {
			this.ordencompraDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,OrdenCompra.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			ordencompraDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			ordencompraDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		ordencompra = new  OrdenCompra();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,OrdenCompra.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			ordencompra=ordencompraDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.ordencompra,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				OrdenCompraConstantesFunciones.refrescarForeignKeysDescripcionesOrdenCompra(this.ordencompra);
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
		ordencompra = new  OrdenCompra();
		  		  
        try {
			
			ordencompra=ordencompraDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.ordencompra,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				OrdenCompraConstantesFunciones.refrescarForeignKeysDescripcionesOrdenCompra(this.ordencompra);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		ordencompra = new  OrdenCompra();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,OrdenCompra.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			ordencompra=ordencompraDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.ordencompra,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				OrdenCompraConstantesFunciones.refrescarForeignKeysDescripcionesOrdenCompra(this.ordencompra);
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
		ordencompra = new  OrdenCompra();
		  		  
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
		ordencompra = new  OrdenCompra();
		  		  
        try {
			
			ordencompra=ordencompraDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.ordencompra,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				OrdenCompraConstantesFunciones.refrescarForeignKeysDescripcionesOrdenCompra(this.ordencompra);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		ordencompra = new  OrdenCompra();
		  		  
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
		ordencompra = new  OrdenCompra();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,OrdenCompra.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =ordencompraDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		ordencompra = new  OrdenCompra();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=ordencompraDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		ordencompra = new  OrdenCompra();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,OrdenCompra.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =ordencompraDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		ordencompra = new  OrdenCompra();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=ordencompraDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		ordencompra = new  OrdenCompra();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,OrdenCompra.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =ordencompraDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		ordencompra = new  OrdenCompra();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=ordencompraDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		ordencompras = new  ArrayList<OrdenCompra>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,OrdenCompra.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			OrdenCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			ordencompras=ordencompraDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarOrdenCompra(ordencompras);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				OrdenCompraConstantesFunciones.refrescarForeignKeysDescripcionesOrdenCompra(this.ordencompras);
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
		ordencompras = new  ArrayList<OrdenCompra>();
		  		  
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
		ordencompras = new  ArrayList<OrdenCompra>();
		  		  
        try {			
			OrdenCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			ordencompras=ordencompraDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarOrdenCompra(ordencompras);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				OrdenCompraConstantesFunciones.refrescarForeignKeysDescripcionesOrdenCompra(this.ordencompras);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		ordencompras = new  ArrayList<OrdenCompra>();
		  		  
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
		ordencompras = new  ArrayList<OrdenCompra>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,OrdenCompra.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			OrdenCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			ordencompras=ordencompraDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarOrdenCompra(ordencompras);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				OrdenCompraConstantesFunciones.refrescarForeignKeysDescripcionesOrdenCompra(this.ordencompras);
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
		ordencompras = new  ArrayList<OrdenCompra>();
		  		  
        try {
			OrdenCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			ordencompras=ordencompraDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarOrdenCompra(ordencompras);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				OrdenCompraConstantesFunciones.refrescarForeignKeysDescripcionesOrdenCompra(this.ordencompras);
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
		ordencompras = new  ArrayList<OrdenCompra>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,OrdenCompra.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			OrdenCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			ordencompras=ordencompraDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarOrdenCompra(ordencompras);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				OrdenCompraConstantesFunciones.refrescarForeignKeysDescripcionesOrdenCompra(this.ordencompras);
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
		ordencompras = new  ArrayList<OrdenCompra>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			OrdenCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			ordencompras=ordencompraDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarOrdenCompra(ordencompras);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				OrdenCompraConstantesFunciones.refrescarForeignKeysDescripcionesOrdenCompra(this.ordencompras);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		ordencompra = new  OrdenCompra();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,OrdenCompra.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			OrdenCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			ordencompra=ordencompraDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarOrdenCompra(ordencompra);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				OrdenCompraConstantesFunciones.refrescarForeignKeysDescripcionesOrdenCompra(this.ordencompra);
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
		ordencompra = new  OrdenCompra();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			OrdenCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			ordencompra=ordencompraDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarOrdenCompra(ordencompra);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				OrdenCompraConstantesFunciones.refrescarForeignKeysDescripcionesOrdenCompra(this.ordencompra);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		ordencompras = new  ArrayList<OrdenCompra>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,OrdenCompra.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			OrdenCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			ordencompras=ordencompraDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarOrdenCompra(ordencompras);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				OrdenCompraConstantesFunciones.refrescarForeignKeysDescripcionesOrdenCompra(this.ordencompras);
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
		ordencompras = new  ArrayList<OrdenCompra>();
		  		  
        try {
			OrdenCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			ordencompras=ordencompraDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarOrdenCompra(ordencompras);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				OrdenCompraConstantesFunciones.refrescarForeignKeysDescripcionesOrdenCompra(this.ordencompras);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosOrdenComprasWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		ordencompras = new  ArrayList<OrdenCompra>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,OrdenCompra.class.getSimpleName()+"-getTodosOrdenComprasWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			OrdenCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			ordencompras=ordencompraDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarOrdenCompra(ordencompras);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				OrdenCompraConstantesFunciones.refrescarForeignKeysDescripcionesOrdenCompra(this.ordencompras);
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
	
	public  void  getTodosOrdenCompras(String sFinalQuery,Pagination pagination)throws Exception {
		ordencompras = new  ArrayList<OrdenCompra>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			OrdenCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			ordencompras=ordencompraDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarOrdenCompra(ordencompras);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				OrdenCompraConstantesFunciones.refrescarForeignKeysDescripcionesOrdenCompra(this.ordencompras);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarOrdenCompra(OrdenCompra ordencompra) throws Exception {
		Boolean estaValidado=false;
		
		if(ordencompra.getIsNew() || ordencompra.getIsChanged()) { 
			this.invalidValues = ordencompraValidator.getInvalidValues(ordencompra);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(ordencompra);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarOrdenCompra(List<OrdenCompra> OrdenCompras) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(OrdenCompra ordencompraLocal:ordencompras) {				
			estaValidadoObjeto=this.validarGuardarOrdenCompra(ordencompraLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarOrdenCompra(List<OrdenCompra> OrdenCompras) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarOrdenCompra(ordencompras)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarOrdenCompra(OrdenCompra OrdenCompra) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarOrdenCompra(ordencompra)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(OrdenCompra ordencompra) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+ordencompra.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=OrdenCompraConstantesFunciones.getOrdenCompraLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"ordencompra","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(OrdenCompraConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(OrdenCompraConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveOrdenCompraWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,OrdenCompra.class.getSimpleName()+"-saveOrdenCompraWithConnection");connexion.begin();			
			
			OrdenCompraLogicAdditional.checkOrdenCompraToSave(this.ordencompra,this.datosCliente,connexion,this.arrDatoGeneral);
			
			OrdenCompraLogicAdditional.updateOrdenCompraToSave(this.ordencompra,this.arrDatoGeneral);
			
			OrdenCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.ordencompra,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowOrdenCompra();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarOrdenCompra(this.ordencompra)) {
				OrdenCompraDataAccess.save(this.ordencompra, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.ordencompra,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			OrdenCompraLogicAdditional.checkOrdenCompraToSaveAfter(this.ordencompra,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowOrdenCompra();
			
			connexion.commit();			
			
			if(this.ordencompra.getIsDeleted()) {
				this.ordencompra=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveOrdenCompra()throws Exception {	
		try {	
			
			OrdenCompraLogicAdditional.checkOrdenCompraToSave(this.ordencompra,this.datosCliente,connexion,this.arrDatoGeneral);
			
			OrdenCompraLogicAdditional.updateOrdenCompraToSave(this.ordencompra,this.arrDatoGeneral);
			
			OrdenCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.ordencompra,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarOrdenCompra(this.ordencompra)) {			
				OrdenCompraDataAccess.save(this.ordencompra, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.ordencompra,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			OrdenCompraLogicAdditional.checkOrdenCompraToSaveAfter(this.ordencompra,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.ordencompra.getIsDeleted()) {
				this.ordencompra=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveOrdenComprasWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,OrdenCompra.class.getSimpleName()+"-saveOrdenComprasWithConnection");connexion.begin();			
			
			OrdenCompraLogicAdditional.checkOrdenCompraToSaves(ordencompras,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowOrdenCompras();
			
			Boolean validadoTodosOrdenCompra=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(OrdenCompra ordencompraLocal:ordencompras) {		
				if(ordencompraLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				OrdenCompraLogicAdditional.updateOrdenCompraToSave(ordencompraLocal,this.arrDatoGeneral);
	        	
				OrdenCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),ordencompraLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarOrdenCompra(ordencompraLocal)) {
					OrdenCompraDataAccess.save(ordencompraLocal, connexion);				
				} else {
					validadoTodosOrdenCompra=false;
				}
			}
			
			if(!validadoTodosOrdenCompra) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			OrdenCompraLogicAdditional.checkOrdenCompraToSavesAfter(ordencompras,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowOrdenCompras();
			
			connexion.commit();		
			
			this.quitarOrdenComprasEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveOrdenCompras()throws Exception {				
		 try {	
			OrdenCompraLogicAdditional.checkOrdenCompraToSaves(ordencompras,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosOrdenCompra=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(OrdenCompra ordencompraLocal:ordencompras) {				
				if(ordencompraLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				OrdenCompraLogicAdditional.updateOrdenCompraToSave(ordencompraLocal,this.arrDatoGeneral);
	        	
				OrdenCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),ordencompraLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarOrdenCompra(ordencompraLocal)) {				
					OrdenCompraDataAccess.save(ordencompraLocal, connexion);				
				} else {
					validadoTodosOrdenCompra=false;
				}
			}
			
			if(!validadoTodosOrdenCompra) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			OrdenCompraLogicAdditional.checkOrdenCompraToSavesAfter(ordencompras,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarOrdenComprasEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public OrdenCompraParameterReturnGeneral procesarAccionOrdenCompras(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<OrdenCompra> ordencompras,OrdenCompraParameterReturnGeneral ordencompraParameterGeneral)throws Exception {
		 try {	
			OrdenCompraParameterReturnGeneral ordencompraReturnGeneral=new OrdenCompraParameterReturnGeneral();
	
			OrdenCompraLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,ordencompras,ordencompraParameterGeneral,ordencompraReturnGeneral);
			
			return ordencompraReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public OrdenCompraParameterReturnGeneral procesarAccionOrdenComprasWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<OrdenCompra> ordencompras,OrdenCompraParameterReturnGeneral ordencompraParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,OrdenCompra.class.getSimpleName()+"-procesarAccionOrdenComprasWithConnection");connexion.begin();			
			
			OrdenCompraParameterReturnGeneral ordencompraReturnGeneral=new OrdenCompraParameterReturnGeneral();
	
			OrdenCompraLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,ordencompras,ordencompraParameterGeneral,ordencompraReturnGeneral);
			
			this.connexion.commit();
			
			return ordencompraReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public OrdenCompraParameterReturnGeneral procesarEventosOrdenCompras(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<OrdenCompra> ordencompras,OrdenCompra ordencompra,OrdenCompraParameterReturnGeneral ordencompraParameterGeneral,Boolean isEsNuevoOrdenCompra,ArrayList<Classe> clases)throws Exception {
		 try {	
			OrdenCompraParameterReturnGeneral ordencompraReturnGeneral=new OrdenCompraParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				ordencompraReturnGeneral.setConRecargarPropiedades(true);
			}
			
			OrdenCompraLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,ordencompras,ordencompra,ordencompraParameterGeneral,ordencompraReturnGeneral,isEsNuevoOrdenCompra,clases);
			
			return ordencompraReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public OrdenCompraParameterReturnGeneral procesarEventosOrdenComprasWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<OrdenCompra> ordencompras,OrdenCompra ordencompra,OrdenCompraParameterReturnGeneral ordencompraParameterGeneral,Boolean isEsNuevoOrdenCompra,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,OrdenCompra.class.getSimpleName()+"-procesarEventosOrdenComprasWithConnection");connexion.begin();			
			
			OrdenCompraParameterReturnGeneral ordencompraReturnGeneral=new OrdenCompraParameterReturnGeneral();
	
			ordencompraReturnGeneral.setOrdenCompra(ordencompra);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				ordencompraReturnGeneral.setConRecargarPropiedades(true);
			}
			
			OrdenCompraLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,ordencompras,ordencompra,ordencompraParameterGeneral,ordencompraReturnGeneral,isEsNuevoOrdenCompra,clases);
			
			this.connexion.commit();
			
			return ordencompraReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public OrdenCompraParameterReturnGeneral procesarImportacionOrdenComprasWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,OrdenCompraParameterReturnGeneral ordencompraParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,OrdenCompra.class.getSimpleName()+"-procesarImportacionOrdenComprasWithConnection");connexion.begin();			
			
			OrdenCompraParameterReturnGeneral ordencompraReturnGeneral=new OrdenCompraParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.ordencompras=new ArrayList<OrdenCompra>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.ordencompra=new OrdenCompra();
				
				
				if(conColumnasBase) {this.ordencompra.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.ordencompra.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.ordencompra.setfecha_emision(Funciones.ConvertToDate(arrColumnas[iColumn++]));
				this.ordencompra.setfecha_entrega(Funciones.ConvertToDate(arrColumnas[iColumn++]));
				this.ordencompra.setnumero_secuencial(arrColumnas[iColumn++]);
				this.ordencompra.setdescripcion(arrColumnas[iColumn++]);
				this.ordencompra.setporcentaje_descuento(Double.parseDouble(arrColumnas[iColumn++]));
				this.ordencompra.setsuman(Double.parseDouble(arrColumnas[iColumn++]));
				this.ordencompra.setice(Double.parseDouble(arrColumnas[iColumn++]));
				this.ordencompra.setvalor_descuento(Double.parseDouble(arrColumnas[iColumn++]));
				this.ordencompra.settotal_descuento(Double.parseDouble(arrColumnas[iColumn++]));
				this.ordencompra.setiva(Double.parseDouble(arrColumnas[iColumn++]));
				this.ordencompra.setstock(Double.parseDouble(arrColumnas[iColumn++]));
				this.ordencompra.setsub_total(Double.parseDouble(arrColumnas[iColumn++]));
				this.ordencompra.settotal_otro(Double.parseDouble(arrColumnas[iColumn++]));
				this.ordencompra.setultimo_costo(Double.parseDouble(arrColumnas[iColumn++]));
				this.ordencompra.setnumero_items(Double.parseDouble(arrColumnas[iColumn++]));
				this.ordencompra.setretencion(Double.parseDouble(arrColumnas[iColumn++]));
				this.ordencompra.settotal(Double.parseDouble(arrColumnas[iColumn++]));
				
				this.ordencompras.add(this.ordencompra);
			}
			
			this.saveOrdenCompras();
			
			this.connexion.commit();
			
			ordencompraReturnGeneral.setConRetornoEstaProcesado(true);
			ordencompraReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return ordencompraReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarOrdenComprasEliminados() throws Exception {				
		
		List<OrdenCompra> ordencomprasAux= new ArrayList<OrdenCompra>();
		
		for(OrdenCompra ordencompra:ordencompras) {
			if(!ordencompra.getIsDeleted()) {
				ordencomprasAux.add(ordencompra);
			}
		}
		
		ordencompras=ordencomprasAux;
	}
	
	public void quitarOrdenComprasNulos() throws Exception {				
		
		List<OrdenCompra> ordencomprasAux= new ArrayList<OrdenCompra>();
		
		for(OrdenCompra ordencompra : this.ordencompras) {
			if(ordencompra==null) {
				ordencomprasAux.add(ordencompra);
			}
		}
		
		//this.ordencompras=ordencomprasAux;
		
		this.ordencompras.removeAll(ordencomprasAux);
	}
	
	public void getSetVersionRowOrdenCompraWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(ordencompra.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((ordencompra.getIsDeleted() || (ordencompra.getIsChanged()&&!ordencompra.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=ordencompraDataAccess.getSetVersionRowOrdenCompra(connexion,ordencompra.getId());
				
				if(!ordencompra.getVersionRow().equals(timestamp)) {	
					ordencompra.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				ordencompra.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowOrdenCompra()throws Exception {	
		
		if(ordencompra.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((ordencompra.getIsDeleted() || (ordencompra.getIsChanged()&&!ordencompra.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=ordencompraDataAccess.getSetVersionRowOrdenCompra(connexion,ordencompra.getId());
			
			try {							
				if(!ordencompra.getVersionRow().equals(timestamp)) {	
					ordencompra.setVersionRow(timestamp);
				}
				
				ordencompra.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowOrdenComprasWithConnection()throws Exception {	
		if(ordencompras!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(OrdenCompra ordencompraAux:ordencompras) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(ordencompraAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(ordencompraAux.getIsDeleted() || (ordencompraAux.getIsChanged()&&!ordencompraAux.getIsNew())) {
						
						timestamp=ordencompraDataAccess.getSetVersionRowOrdenCompra(connexion,ordencompraAux.getId());
						
						if(!ordencompra.getVersionRow().equals(timestamp)) {	
							ordencompraAux.setVersionRow(timestamp);
						}
								
						ordencompraAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowOrdenCompras()throws Exception {	
		if(ordencompras!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(OrdenCompra ordencompraAux:ordencompras) {
					if(ordencompraAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(ordencompraAux.getIsDeleted() || (ordencompraAux.getIsChanged()&&!ordencompraAux.getIsNew())) {
						
						timestamp=ordencompraDataAccess.getSetVersionRowOrdenCompra(connexion,ordencompraAux.getId());
						
						if(!ordencompraAux.getVersionRow().equals(timestamp)) {	
							ordencompraAux.setVersionRow(timestamp);
						}
						
													
						ordencompraAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public OrdenCompraParameterReturnGeneral cargarCombosLoteForeignKeyOrdenCompraWithConnection(String finalQueryGlobalEmpresa,String finalQueryGlobalSucursal,String finalQueryGlobalModulo,String finalQueryGlobalEjercicio,String finalQueryGlobalPeriodo,String finalQueryGlobalAnio,String finalQueryGlobalMes,String finalQueryGlobalUsuario,String finalQueryGlobalMoneda,String finalQueryGlobalTipoCambio,String finalQueryGlobalEstadoOrdenCompra,String finalQueryGlobalCliente,String finalQueryGlobalFormato,String finalQueryGlobalTransportista,String finalQueryGlobalEmpleado,String finalQueryGlobalTipoTransaccionModulo,String finalQueryGlobalOrdenCompra,String finalQueryGlobalAsientoContable) throws Exception {
		OrdenCompraParameterReturnGeneral  ordencompraReturnGeneral =new OrdenCompraParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,OrdenCompra.class.getSimpleName()+"-cargarCombosLoteForeignKeyOrdenCompraWithConnection");connexion.begin();
			
			ordencompraReturnGeneral =new OrdenCompraParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			ordencompraReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Sucursal> sucursalsForeignKey=new ArrayList<Sucursal>();
			SucursalLogic sucursalLogic=new SucursalLogic();
			sucursalLogic.setConnexion(this.connexion);
			//sucursalLogic.getSucursalDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalSucursal.equals("NONE")) {
				sucursalLogic.getTodosSucursals(finalQueryGlobalSucursal,new Pagination());
				sucursalsForeignKey=sucursalLogic.getSucursals();
			}

			ordencompraReturnGeneral.setsucursalsForeignKey(sucursalsForeignKey);


			List<Modulo> modulosForeignKey=new ArrayList<Modulo>();
			ModuloLogic moduloLogic=new ModuloLogic();
			moduloLogic.setConnexion(this.connexion);
			moduloLogic.getModuloDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalModulo.equals("NONE")) {
				moduloLogic.getTodosModulos(finalQueryGlobalModulo,new Pagination());
				modulosForeignKey=moduloLogic.getModulos();
			}

			ordencompraReturnGeneral.setmodulosForeignKey(modulosForeignKey);


			List<Ejercicio> ejerciciosForeignKey=new ArrayList<Ejercicio>();
			EjercicioLogic ejercicioLogic=new EjercicioLogic();
			ejercicioLogic.setConnexion(this.connexion);
			//ejercicioLogic.getEjercicioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEjercicio.equals("NONE")) {
				ejercicioLogic.getTodosEjercicios(finalQueryGlobalEjercicio,new Pagination());
				ejerciciosForeignKey=ejercicioLogic.getEjercicios();
			}

			ordencompraReturnGeneral.setejerciciosForeignKey(ejerciciosForeignKey);


			List<Periodo> periodosForeignKey=new ArrayList<Periodo>();
			PeriodoLogic periodoLogic=new PeriodoLogic();
			periodoLogic.setConnexion(this.connexion);
			//periodoLogic.getPeriodoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalPeriodo.equals("NONE")) {
				periodoLogic.getTodosPeriodos(finalQueryGlobalPeriodo,new Pagination());
				periodosForeignKey=periodoLogic.getPeriodos();
			}

			ordencompraReturnGeneral.setperiodosForeignKey(periodosForeignKey);


			List<Anio> aniosForeignKey=new ArrayList<Anio>();
			AnioLogic anioLogic=new AnioLogic();
			anioLogic.setConnexion(this.connexion);
			anioLogic.getAnioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalAnio.equals("NONE")) {
				anioLogic.getTodosAnios(finalQueryGlobalAnio,new Pagination());
				aniosForeignKey=anioLogic.getAnios();
			}

			ordencompraReturnGeneral.setaniosForeignKey(aniosForeignKey);


			List<Mes> messForeignKey=new ArrayList<Mes>();
			MesLogic mesLogic=new MesLogic();
			mesLogic.setConnexion(this.connexion);
			mesLogic.getMesDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalMes.equals("NONE")) {
				mesLogic.getTodosMess(finalQueryGlobalMes,new Pagination());
				messForeignKey=mesLogic.getMess();
			}

			ordencompraReturnGeneral.setmessForeignKey(messForeignKey);


			List<Usuario> usuariosForeignKey=new ArrayList<Usuario>();
			UsuarioLogic usuarioLogic=new UsuarioLogic();
			usuarioLogic.setConnexion(this.connexion);
			//usuarioLogic.getUsuarioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalUsuario.equals("NONE")) {
				usuarioLogic.getTodosUsuarios(finalQueryGlobalUsuario,new Pagination());
				usuariosForeignKey=usuarioLogic.getUsuarios();
			}

			ordencompraReturnGeneral.setusuariosForeignKey(usuariosForeignKey);


			List<Moneda> monedasForeignKey=new ArrayList<Moneda>();
			MonedaLogic monedaLogic=new MonedaLogic();
			monedaLogic.setConnexion(this.connexion);
			//monedaLogic.getMonedaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalMoneda.equals("NONE")) {
				monedaLogic.getTodosMonedas(finalQueryGlobalMoneda,new Pagination());
				monedasForeignKey=monedaLogic.getMonedas();
			}

			ordencompraReturnGeneral.setmonedasForeignKey(monedasForeignKey);


			List<TipoCambio> tipocambiosForeignKey=new ArrayList<TipoCambio>();
			TipoCambioLogic tipocambioLogic=new TipoCambioLogic();
			tipocambioLogic.setConnexion(this.connexion);
			tipocambioLogic.getTipoCambioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoCambio.equals("NONE")) {
				tipocambioLogic.getTodosTipoCambios(finalQueryGlobalTipoCambio,new Pagination());
				tipocambiosForeignKey=tipocambioLogic.getTipoCambios();
			}

			ordencompraReturnGeneral.settipocambiosForeignKey(tipocambiosForeignKey);


			List<EstadoOrdenCompra> estadoordencomprasForeignKey=new ArrayList<EstadoOrdenCompra>();
			EstadoOrdenCompraLogic estadoordencompraLogic=new EstadoOrdenCompraLogic();
			estadoordencompraLogic.setConnexion(this.connexion);
			estadoordencompraLogic.getEstadoOrdenCompraDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEstadoOrdenCompra.equals("NONE")) {
				estadoordencompraLogic.getTodosEstadoOrdenCompras(finalQueryGlobalEstadoOrdenCompra,new Pagination());
				estadoordencomprasForeignKey=estadoordencompraLogic.getEstadoOrdenCompras();
			}

			ordencompraReturnGeneral.setestadoordencomprasForeignKey(estadoordencomprasForeignKey);


			List<Cliente> clientesForeignKey=new ArrayList<Cliente>();
			ClienteLogic clienteLogic=new ClienteLogic();
			clienteLogic.setConnexion(this.connexion);
			clienteLogic.getClienteDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCliente.equals("NONE")) {
				clienteLogic.getTodosClientes(finalQueryGlobalCliente,new Pagination());
				clientesForeignKey=clienteLogic.getClientes();
			}

			ordencompraReturnGeneral.setclientesForeignKey(clientesForeignKey);


			List<Formato> formatosForeignKey=new ArrayList<Formato>();
			FormatoLogic formatoLogic=new FormatoLogic();
			formatoLogic.setConnexion(this.connexion);
			formatoLogic.getFormatoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalFormato.equals("NONE")) {
				formatoLogic.getTodosFormatos(finalQueryGlobalFormato,new Pagination());
				formatosForeignKey=formatoLogic.getFormatos();
			}

			ordencompraReturnGeneral.setformatosForeignKey(formatosForeignKey);


			List<Transportista> transportistasForeignKey=new ArrayList<Transportista>();
			TransportistaLogic transportistaLogic=new TransportistaLogic();
			transportistaLogic.setConnexion(this.connexion);
			transportistaLogic.getTransportistaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTransportista.equals("NONE")) {
				transportistaLogic.getTodosTransportistas(finalQueryGlobalTransportista,new Pagination());
				transportistasForeignKey=transportistaLogic.getTransportistas();
			}

			ordencompraReturnGeneral.settransportistasForeignKey(transportistasForeignKey);


			List<Empleado> empleadosForeignKey=new ArrayList<Empleado>();
			EmpleadoLogic empleadoLogic=new EmpleadoLogic();
			empleadoLogic.setConnexion(this.connexion);
			empleadoLogic.getEmpleadoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpleado.equals("NONE")) {
				empleadoLogic.getTodosEmpleados(finalQueryGlobalEmpleado,new Pagination());
				empleadosForeignKey=empleadoLogic.getEmpleados();
			}

			ordencompraReturnGeneral.setempleadosForeignKey(empleadosForeignKey);


			List<TipoTransaccionModulo> tipotransaccionmodulosForeignKey=new ArrayList<TipoTransaccionModulo>();
			TipoTransaccionModuloLogic tipotransaccionmoduloLogic=new TipoTransaccionModuloLogic();
			tipotransaccionmoduloLogic.setConnexion(this.connexion);
			tipotransaccionmoduloLogic.getTipoTransaccionModuloDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoTransaccionModulo.equals("NONE")) {
				tipotransaccionmoduloLogic.getTodosTipoTransaccionModulos(finalQueryGlobalTipoTransaccionModulo,new Pagination());
				tipotransaccionmodulosForeignKey=tipotransaccionmoduloLogic.getTipoTransaccionModulos();
			}

			ordencompraReturnGeneral.settipotransaccionmodulosForeignKey(tipotransaccionmodulosForeignKey);


			List<OrdenCompra> ordencomprasForeignKey=new ArrayList<OrdenCompra>();
			OrdenCompraLogic ordencompraLogic=new OrdenCompraLogic();
			ordencompraLogic.setConnexion(this.connexion);
			ordencompraLogic.getOrdenCompraDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalOrdenCompra.equals("NONE")) {
				ordencompraLogic.getTodosOrdenCompras(finalQueryGlobalOrdenCompra,new Pagination());
				ordencomprasForeignKey=ordencompraLogic.getOrdenCompras();
			}

			ordencompraReturnGeneral.setordencomprasForeignKey(ordencomprasForeignKey);


			List<AsientoContable> asientocontablesForeignKey=new ArrayList<AsientoContable>();
			AsientoContableLogic asientocontableLogic=new AsientoContableLogic();
			asientocontableLogic.setConnexion(this.connexion);
			asientocontableLogic.getAsientoContableDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalAsientoContable.equals("NONE")) {
				asientocontableLogic.getTodosAsientoContables(finalQueryGlobalAsientoContable,new Pagination());
				asientocontablesForeignKey=asientocontableLogic.getAsientoContables();
			}

			ordencompraReturnGeneral.setasientocontablesForeignKey(asientocontablesForeignKey);

			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
		
		return ordencompraReturnGeneral;
	}
	
	public OrdenCompraParameterReturnGeneral cargarCombosLoteForeignKeyOrdenCompra(String finalQueryGlobalEmpresa,String finalQueryGlobalSucursal,String finalQueryGlobalModulo,String finalQueryGlobalEjercicio,String finalQueryGlobalPeriodo,String finalQueryGlobalAnio,String finalQueryGlobalMes,String finalQueryGlobalUsuario,String finalQueryGlobalMoneda,String finalQueryGlobalTipoCambio,String finalQueryGlobalEstadoOrdenCompra,String finalQueryGlobalCliente,String finalQueryGlobalFormato,String finalQueryGlobalTransportista,String finalQueryGlobalEmpleado,String finalQueryGlobalTipoTransaccionModulo,String finalQueryGlobalOrdenCompra,String finalQueryGlobalAsientoContable) throws Exception {
		OrdenCompraParameterReturnGeneral  ordencompraReturnGeneral =new OrdenCompraParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {						
			ordencompraReturnGeneral =new OrdenCompraParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			ordencompraReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Sucursal> sucursalsForeignKey=new ArrayList<Sucursal>();
			SucursalLogic sucursalLogic=new SucursalLogic();
			sucursalLogic.setConnexion(this.connexion);
			//sucursalLogic.getSucursalDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalSucursal.equals("NONE")) {
				sucursalLogic.getTodosSucursals(finalQueryGlobalSucursal,new Pagination());
				sucursalsForeignKey=sucursalLogic.getSucursals();
			}

			ordencompraReturnGeneral.setsucursalsForeignKey(sucursalsForeignKey);


			List<Modulo> modulosForeignKey=new ArrayList<Modulo>();
			ModuloLogic moduloLogic=new ModuloLogic();
			moduloLogic.setConnexion(this.connexion);
			moduloLogic.getModuloDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalModulo.equals("NONE")) {
				moduloLogic.getTodosModulos(finalQueryGlobalModulo,new Pagination());
				modulosForeignKey=moduloLogic.getModulos();
			}

			ordencompraReturnGeneral.setmodulosForeignKey(modulosForeignKey);


			List<Ejercicio> ejerciciosForeignKey=new ArrayList<Ejercicio>();
			EjercicioLogic ejercicioLogic=new EjercicioLogic();
			ejercicioLogic.setConnexion(this.connexion);
			//ejercicioLogic.getEjercicioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEjercicio.equals("NONE")) {
				ejercicioLogic.getTodosEjercicios(finalQueryGlobalEjercicio,new Pagination());
				ejerciciosForeignKey=ejercicioLogic.getEjercicios();
			}

			ordencompraReturnGeneral.setejerciciosForeignKey(ejerciciosForeignKey);


			List<Periodo> periodosForeignKey=new ArrayList<Periodo>();
			PeriodoLogic periodoLogic=new PeriodoLogic();
			periodoLogic.setConnexion(this.connexion);
			//periodoLogic.getPeriodoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalPeriodo.equals("NONE")) {
				periodoLogic.getTodosPeriodos(finalQueryGlobalPeriodo,new Pagination());
				periodosForeignKey=periodoLogic.getPeriodos();
			}

			ordencompraReturnGeneral.setperiodosForeignKey(periodosForeignKey);


			List<Anio> aniosForeignKey=new ArrayList<Anio>();
			AnioLogic anioLogic=new AnioLogic();
			anioLogic.setConnexion(this.connexion);
			anioLogic.getAnioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalAnio.equals("NONE")) {
				anioLogic.getTodosAnios(finalQueryGlobalAnio,new Pagination());
				aniosForeignKey=anioLogic.getAnios();
			}

			ordencompraReturnGeneral.setaniosForeignKey(aniosForeignKey);


			List<Mes> messForeignKey=new ArrayList<Mes>();
			MesLogic mesLogic=new MesLogic();
			mesLogic.setConnexion(this.connexion);
			mesLogic.getMesDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalMes.equals("NONE")) {
				mesLogic.getTodosMess(finalQueryGlobalMes,new Pagination());
				messForeignKey=mesLogic.getMess();
			}

			ordencompraReturnGeneral.setmessForeignKey(messForeignKey);


			List<Usuario> usuariosForeignKey=new ArrayList<Usuario>();
			UsuarioLogic usuarioLogic=new UsuarioLogic();
			usuarioLogic.setConnexion(this.connexion);
			//usuarioLogic.getUsuarioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalUsuario.equals("NONE")) {
				usuarioLogic.getTodosUsuarios(finalQueryGlobalUsuario,new Pagination());
				usuariosForeignKey=usuarioLogic.getUsuarios();
			}

			ordencompraReturnGeneral.setusuariosForeignKey(usuariosForeignKey);


			List<Moneda> monedasForeignKey=new ArrayList<Moneda>();
			MonedaLogic monedaLogic=new MonedaLogic();
			monedaLogic.setConnexion(this.connexion);
			//monedaLogic.getMonedaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalMoneda.equals("NONE")) {
				monedaLogic.getTodosMonedas(finalQueryGlobalMoneda,new Pagination());
				monedasForeignKey=monedaLogic.getMonedas();
			}

			ordencompraReturnGeneral.setmonedasForeignKey(monedasForeignKey);


			List<TipoCambio> tipocambiosForeignKey=new ArrayList<TipoCambio>();
			TipoCambioLogic tipocambioLogic=new TipoCambioLogic();
			tipocambioLogic.setConnexion(this.connexion);
			tipocambioLogic.getTipoCambioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoCambio.equals("NONE")) {
				tipocambioLogic.getTodosTipoCambios(finalQueryGlobalTipoCambio,new Pagination());
				tipocambiosForeignKey=tipocambioLogic.getTipoCambios();
			}

			ordencompraReturnGeneral.settipocambiosForeignKey(tipocambiosForeignKey);


			List<EstadoOrdenCompra> estadoordencomprasForeignKey=new ArrayList<EstadoOrdenCompra>();
			EstadoOrdenCompraLogic estadoordencompraLogic=new EstadoOrdenCompraLogic();
			estadoordencompraLogic.setConnexion(this.connexion);
			estadoordencompraLogic.getEstadoOrdenCompraDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEstadoOrdenCompra.equals("NONE")) {
				estadoordencompraLogic.getTodosEstadoOrdenCompras(finalQueryGlobalEstadoOrdenCompra,new Pagination());
				estadoordencomprasForeignKey=estadoordencompraLogic.getEstadoOrdenCompras();
			}

			ordencompraReturnGeneral.setestadoordencomprasForeignKey(estadoordencomprasForeignKey);


			List<Cliente> clientesForeignKey=new ArrayList<Cliente>();
			ClienteLogic clienteLogic=new ClienteLogic();
			clienteLogic.setConnexion(this.connexion);
			clienteLogic.getClienteDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCliente.equals("NONE")) {
				clienteLogic.getTodosClientes(finalQueryGlobalCliente,new Pagination());
				clientesForeignKey=clienteLogic.getClientes();
			}

			ordencompraReturnGeneral.setclientesForeignKey(clientesForeignKey);


			List<Formato> formatosForeignKey=new ArrayList<Formato>();
			FormatoLogic formatoLogic=new FormatoLogic();
			formatoLogic.setConnexion(this.connexion);
			formatoLogic.getFormatoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalFormato.equals("NONE")) {
				formatoLogic.getTodosFormatos(finalQueryGlobalFormato,new Pagination());
				formatosForeignKey=formatoLogic.getFormatos();
			}

			ordencompraReturnGeneral.setformatosForeignKey(formatosForeignKey);


			List<Transportista> transportistasForeignKey=new ArrayList<Transportista>();
			TransportistaLogic transportistaLogic=new TransportistaLogic();
			transportistaLogic.setConnexion(this.connexion);
			transportistaLogic.getTransportistaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTransportista.equals("NONE")) {
				transportistaLogic.getTodosTransportistas(finalQueryGlobalTransportista,new Pagination());
				transportistasForeignKey=transportistaLogic.getTransportistas();
			}

			ordencompraReturnGeneral.settransportistasForeignKey(transportistasForeignKey);


			List<Empleado> empleadosForeignKey=new ArrayList<Empleado>();
			EmpleadoLogic empleadoLogic=new EmpleadoLogic();
			empleadoLogic.setConnexion(this.connexion);
			empleadoLogic.getEmpleadoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpleado.equals("NONE")) {
				empleadoLogic.getTodosEmpleados(finalQueryGlobalEmpleado,new Pagination());
				empleadosForeignKey=empleadoLogic.getEmpleados();
			}

			ordencompraReturnGeneral.setempleadosForeignKey(empleadosForeignKey);


			List<TipoTransaccionModulo> tipotransaccionmodulosForeignKey=new ArrayList<TipoTransaccionModulo>();
			TipoTransaccionModuloLogic tipotransaccionmoduloLogic=new TipoTransaccionModuloLogic();
			tipotransaccionmoduloLogic.setConnexion(this.connexion);
			tipotransaccionmoduloLogic.getTipoTransaccionModuloDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoTransaccionModulo.equals("NONE")) {
				tipotransaccionmoduloLogic.getTodosTipoTransaccionModulos(finalQueryGlobalTipoTransaccionModulo,new Pagination());
				tipotransaccionmodulosForeignKey=tipotransaccionmoduloLogic.getTipoTransaccionModulos();
			}

			ordencompraReturnGeneral.settipotransaccionmodulosForeignKey(tipotransaccionmodulosForeignKey);


			List<OrdenCompra> ordencomprasForeignKey=new ArrayList<OrdenCompra>();
			OrdenCompraLogic ordencompraLogic=new OrdenCompraLogic();
			ordencompraLogic.setConnexion(this.connexion);
			ordencompraLogic.getOrdenCompraDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalOrdenCompra.equals("NONE")) {
				ordencompraLogic.getTodosOrdenCompras(finalQueryGlobalOrdenCompra,new Pagination());
				ordencomprasForeignKey=ordencompraLogic.getOrdenCompras();
			}

			ordencompraReturnGeneral.setordencomprasForeignKey(ordencomprasForeignKey);


			List<AsientoContable> asientocontablesForeignKey=new ArrayList<AsientoContable>();
			AsientoContableLogic asientocontableLogic=new AsientoContableLogic();
			asientocontableLogic.setConnexion(this.connexion);
			asientocontableLogic.getAsientoContableDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalAsientoContable.equals("NONE")) {
				asientocontableLogic.getTodosAsientoContables(finalQueryGlobalAsientoContable,new Pagination());
				asientocontablesForeignKey=asientocontableLogic.getAsientoContables();
			}

			ordencompraReturnGeneral.setasientocontablesForeignKey(asientocontablesForeignKey);
						
			
		} catch(Exception e) {			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			
		}
		
		return ordencompraReturnGeneral;
	}
	
	public void cargarRelacionesLoteForeignKeyOrdenCompraWithConnection() throws Exception {
		ArrayList<Classe> classes=new ArrayList<Classe>();		
		
		
			DetalleOrdenCompraLogic detalleordencompraLogic=new DetalleOrdenCompraLogic();
		
		try {
			
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,OrdenCompra.class.getSimpleName()+"-cargarRelacionesLoteForeignKeyOrdenCompraWithConnection");connexion.begin();
			
			
			classes.add(new Classe(DetalleOrdenCompra.class));
											
			

			detalleordencompraLogic.setConnexion(this.getConnexion());
			detalleordencompraLogic.setDatosCliente(this.datosCliente);
			detalleordencompraLogic.setIsConRefrescarForeignKeys(true);
			
			this.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
			
			for(OrdenCompra ordencompra:this.ordencompras) {
				

				classes=new ArrayList<Classe>();
				classes=DetalleOrdenCompraConstantesFunciones.getClassesForeignKeysOfDetalleOrdenCompra(new ArrayList<Classe>(),DeepLoadType.NONE);

				detalleordencompraLogic.setDetalleOrdenCompras(ordencompra.detalleordencompras);
				detalleordencompraLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
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
	
	public void deepLoad(OrdenCompra ordencompra,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			OrdenCompraLogicAdditional.updateOrdenCompraToGet(ordencompra,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		ordencompra.setEmpresa(ordencompraDataAccess.getEmpresa(connexion,ordencompra));
		ordencompra.setSucursal(ordencompraDataAccess.getSucursal(connexion,ordencompra));
		ordencompra.setModulo(ordencompraDataAccess.getModulo(connexion,ordencompra));
		ordencompra.setEjercicio(ordencompraDataAccess.getEjercicio(connexion,ordencompra));
		ordencompra.setPeriodo(ordencompraDataAccess.getPeriodo(connexion,ordencompra));
		ordencompra.setAnio(ordencompraDataAccess.getAnio(connexion,ordencompra));
		ordencompra.setMes(ordencompraDataAccess.getMes(connexion,ordencompra));
		ordencompra.setUsuario(ordencompraDataAccess.getUsuario(connexion,ordencompra));
		ordencompra.setMoneda(ordencompraDataAccess.getMoneda(connexion,ordencompra));
		ordencompra.setTipoCambio(ordencompraDataAccess.getTipoCambio(connexion,ordencompra));
		ordencompra.setEstadoOrdenCompra(ordencompraDataAccess.getEstadoOrdenCompra(connexion,ordencompra));
		ordencompra.setCliente(ordencompraDataAccess.getCliente(connexion,ordencompra));
		ordencompra.setFormato(ordencompraDataAccess.getFormato(connexion,ordencompra));
		ordencompra.setTransportista(ordencompraDataAccess.getTransportista(connexion,ordencompra));
		ordencompra.setEmpleado(ordencompraDataAccess.getEmpleado(connexion,ordencompra));
		ordencompra.setTipoTransaccionModulo(ordencompraDataAccess.getTipoTransaccionModulo(connexion,ordencompra));
		ordencompra.setOrdenCompra(ordencompraDataAccess.getOrdenCompra(connexion,ordencompra));
		ordencompra.setAsientoContable(ordencompraDataAccess.getAsientoContable(connexion,ordencompra));
		ordencompra.setDetalleOrdenCompras(ordencompraDataAccess.getDetalleOrdenCompras(connexion,ordencompra));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				ordencompra.setEmpresa(ordencompraDataAccess.getEmpresa(connexion,ordencompra));
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				ordencompra.setSucursal(ordencompraDataAccess.getSucursal(connexion,ordencompra));
				continue;
			}

			if(clas.clas.equals(Modulo.class)) {
				ordencompra.setModulo(ordencompraDataAccess.getModulo(connexion,ordencompra));
				continue;
			}

			if(clas.clas.equals(Ejercicio.class)) {
				ordencompra.setEjercicio(ordencompraDataAccess.getEjercicio(connexion,ordencompra));
				continue;
			}

			if(clas.clas.equals(Periodo.class)) {
				ordencompra.setPeriodo(ordencompraDataAccess.getPeriodo(connexion,ordencompra));
				continue;
			}

			if(clas.clas.equals(Anio.class)) {
				ordencompra.setAnio(ordencompraDataAccess.getAnio(connexion,ordencompra));
				continue;
			}

			if(clas.clas.equals(Mes.class)) {
				ordencompra.setMes(ordencompraDataAccess.getMes(connexion,ordencompra));
				continue;
			}

			if(clas.clas.equals(Usuario.class)) {
				ordencompra.setUsuario(ordencompraDataAccess.getUsuario(connexion,ordencompra));
				continue;
			}

			if(clas.clas.equals(Moneda.class)) {
				ordencompra.setMoneda(ordencompraDataAccess.getMoneda(connexion,ordencompra));
				continue;
			}

			if(clas.clas.equals(TipoCambio.class)) {
				ordencompra.setTipoCambio(ordencompraDataAccess.getTipoCambio(connexion,ordencompra));
				continue;
			}

			if(clas.clas.equals(EstadoOrdenCompra.class)) {
				ordencompra.setEstadoOrdenCompra(ordencompraDataAccess.getEstadoOrdenCompra(connexion,ordencompra));
				continue;
			}

			if(clas.clas.equals(Cliente.class)) {
				ordencompra.setCliente(ordencompraDataAccess.getCliente(connexion,ordencompra));
				continue;
			}

			if(clas.clas.equals(Formato.class)) {
				ordencompra.setFormato(ordencompraDataAccess.getFormato(connexion,ordencompra));
				continue;
			}

			if(clas.clas.equals(Transportista.class)) {
				ordencompra.setTransportista(ordencompraDataAccess.getTransportista(connexion,ordencompra));
				continue;
			}

			if(clas.clas.equals(Empleado.class)) {
				ordencompra.setEmpleado(ordencompraDataAccess.getEmpleado(connexion,ordencompra));
				continue;
			}

			if(clas.clas.equals(TipoTransaccionModulo.class)) {
				ordencompra.setTipoTransaccionModulo(ordencompraDataAccess.getTipoTransaccionModulo(connexion,ordencompra));
				continue;
			}

			if(clas.clas.equals(OrdenCompra.class)) {
				ordencompra.setOrdenCompra(ordencompraDataAccess.getOrdenCompra(connexion,ordencompra));
				continue;
			}

			if(clas.clas.equals(AsientoContable.class)) {
				ordencompra.setAsientoContable(ordencompraDataAccess.getAsientoContable(connexion,ordencompra));
				continue;
			}

			if(clas.clas.equals(DetalleOrdenCompra.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				ordencompra.setDetalleOrdenCompras(ordencompraDataAccess.getDetalleOrdenCompras(connexion,ordencompra));

				if(this.isConDeep) {
					DetalleOrdenCompraLogic detalleordencompraLogic= new DetalleOrdenCompraLogic(this.connexion);
					detalleordencompraLogic.setDetalleOrdenCompras(ordencompra.getDetalleOrdenCompras());
					ArrayList<Classe> classesLocal=DetalleOrdenCompraConstantesFunciones.getClassesForeignKeysOfDetalleOrdenCompra(new ArrayList<Classe>(),DeepLoadType.NONE);
					detalleordencompraLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					DetalleOrdenCompraConstantesFunciones.refrescarForeignKeysDescripcionesDetalleOrdenCompra(detalleordencompraLogic.getDetalleOrdenCompras());
					ordencompra.setDetalleOrdenCompras(detalleordencompraLogic.getDetalleOrdenCompras());
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
			ordencompra.setEmpresa(ordencompraDataAccess.getEmpresa(connexion,ordencompra));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			ordencompra.setSucursal(ordencompraDataAccess.getSucursal(connexion,ordencompra));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Modulo.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			ordencompra.setModulo(ordencompraDataAccess.getModulo(connexion,ordencompra));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Ejercicio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			ordencompra.setEjercicio(ordencompraDataAccess.getEjercicio(connexion,ordencompra));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Periodo.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			ordencompra.setPeriodo(ordencompraDataAccess.getPeriodo(connexion,ordencompra));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Anio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			ordencompra.setAnio(ordencompraDataAccess.getAnio(connexion,ordencompra));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Mes.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			ordencompra.setMes(ordencompraDataAccess.getMes(connexion,ordencompra));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Usuario.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			ordencompra.setUsuario(ordencompraDataAccess.getUsuario(connexion,ordencompra));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Moneda.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			ordencompra.setMoneda(ordencompraDataAccess.getMoneda(connexion,ordencompra));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(TipoCambio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			ordencompra.setTipoCambio(ordencompraDataAccess.getTipoCambio(connexion,ordencompra));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(EstadoOrdenCompra.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			ordencompra.setEstadoOrdenCompra(ordencompraDataAccess.getEstadoOrdenCompra(connexion,ordencompra));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Cliente.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			ordencompra.setCliente(ordencompraDataAccess.getCliente(connexion,ordencompra));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Formato.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			ordencompra.setFormato(ordencompraDataAccess.getFormato(connexion,ordencompra));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Transportista.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			ordencompra.setTransportista(ordencompraDataAccess.getTransportista(connexion,ordencompra));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Empleado.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			ordencompra.setEmpleado(ordencompraDataAccess.getEmpleado(connexion,ordencompra));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(TipoTransaccionModulo.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			ordencompra.setTipoTransaccionModulo(ordencompraDataAccess.getTipoTransaccionModulo(connexion,ordencompra));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(OrdenCompra.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			ordencompra.setOrdenCompra(ordencompraDataAccess.getOrdenCompra(connexion,ordencompra));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(AsientoContable.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			ordencompra.setAsientoContable(ordencompraDataAccess.getAsientoContable(connexion,ordencompra));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(DetalleOrdenCompra.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(DetalleOrdenCompra.class));
			ordencompra.setDetalleOrdenCompras(ordencompraDataAccess.getDetalleOrdenCompras(connexion,ordencompra));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		ordencompra.setEmpresa(ordencompraDataAccess.getEmpresa(connexion,ordencompra));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(ordencompra.getEmpresa(),isDeep,deepLoadType,clases);
				
		ordencompra.setSucursal(ordencompraDataAccess.getSucursal(connexion,ordencompra));
		SucursalLogic sucursalLogic= new SucursalLogic(connexion);
		sucursalLogic.deepLoad(ordencompra.getSucursal(),isDeep,deepLoadType,clases);
				
		ordencompra.setModulo(ordencompraDataAccess.getModulo(connexion,ordencompra));
		ModuloLogic moduloLogic= new ModuloLogic(connexion);
		moduloLogic.deepLoad(ordencompra.getModulo(),isDeep,deepLoadType,clases);
				
		ordencompra.setEjercicio(ordencompraDataAccess.getEjercicio(connexion,ordencompra));
		EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
		ejercicioLogic.deepLoad(ordencompra.getEjercicio(),isDeep,deepLoadType,clases);
				
		ordencompra.setPeriodo(ordencompraDataAccess.getPeriodo(connexion,ordencompra));
		PeriodoLogic periodoLogic= new PeriodoLogic(connexion);
		periodoLogic.deepLoad(ordencompra.getPeriodo(),isDeep,deepLoadType,clases);
				
		ordencompra.setAnio(ordencompraDataAccess.getAnio(connexion,ordencompra));
		AnioLogic anioLogic= new AnioLogic(connexion);
		anioLogic.deepLoad(ordencompra.getAnio(),isDeep,deepLoadType,clases);
				
		ordencompra.setMes(ordencompraDataAccess.getMes(connexion,ordencompra));
		MesLogic mesLogic= new MesLogic(connexion);
		mesLogic.deepLoad(ordencompra.getMes(),isDeep,deepLoadType,clases);
				
		ordencompra.setUsuario(ordencompraDataAccess.getUsuario(connexion,ordencompra));
		UsuarioLogic usuarioLogic= new UsuarioLogic(connexion);
		usuarioLogic.deepLoad(ordencompra.getUsuario(),isDeep,deepLoadType,clases);
				
		ordencompra.setMoneda(ordencompraDataAccess.getMoneda(connexion,ordencompra));
		MonedaLogic monedaLogic= new MonedaLogic(connexion);
		monedaLogic.deepLoad(ordencompra.getMoneda(),isDeep,deepLoadType,clases);
				
		ordencompra.setTipoCambio(ordencompraDataAccess.getTipoCambio(connexion,ordencompra));
		TipoCambioLogic tipocambioLogic= new TipoCambioLogic(connexion);
		tipocambioLogic.deepLoad(ordencompra.getTipoCambio(),isDeep,deepLoadType,clases);
				
		ordencompra.setEstadoOrdenCompra(ordencompraDataAccess.getEstadoOrdenCompra(connexion,ordencompra));
		EstadoOrdenCompraLogic estadoordencompraLogic= new EstadoOrdenCompraLogic(connexion);
		estadoordencompraLogic.deepLoad(ordencompra.getEstadoOrdenCompra(),isDeep,deepLoadType,clases);
				
		ordencompra.setCliente(ordencompraDataAccess.getCliente(connexion,ordencompra));
		ClienteLogic clienteLogic= new ClienteLogic(connexion);
		clienteLogic.deepLoad(ordencompra.getCliente(),isDeep,deepLoadType,clases);
				
		ordencompra.setFormato(ordencompraDataAccess.getFormato(connexion,ordencompra));
		FormatoLogic formatoLogic= new FormatoLogic(connexion);
		formatoLogic.deepLoad(ordencompra.getFormato(),isDeep,deepLoadType,clases);
				
		ordencompra.setTransportista(ordencompraDataAccess.getTransportista(connexion,ordencompra));
		TransportistaLogic transportistaLogic= new TransportistaLogic(connexion);
		transportistaLogic.deepLoad(ordencompra.getTransportista(),isDeep,deepLoadType,clases);
				
		ordencompra.setEmpleado(ordencompraDataAccess.getEmpleado(connexion,ordencompra));
		EmpleadoLogic empleadoLogic= new EmpleadoLogic(connexion);
		empleadoLogic.deepLoad(ordencompra.getEmpleado(),isDeep,deepLoadType,clases);
				
		ordencompra.setTipoTransaccionModulo(ordencompraDataAccess.getTipoTransaccionModulo(connexion,ordencompra));
		TipoTransaccionModuloLogic tipotransaccionmoduloLogic= new TipoTransaccionModuloLogic(connexion);
		tipotransaccionmoduloLogic.deepLoad(ordencompra.getTipoTransaccionModulo(),isDeep,deepLoadType,clases);
				
		ordencompra.setOrdenCompra(ordencompraDataAccess.getOrdenCompra(connexion,ordencompra));
		OrdenCompraLogic ordencompraLogic= new OrdenCompraLogic(connexion);
		ordencompraLogic.deepLoad(ordencompra.getOrdenCompra(),isDeep,deepLoadType,clases);
				
		ordencompra.setAsientoContable(ordencompraDataAccess.getAsientoContable(connexion,ordencompra));
		AsientoContableLogic asientocontableLogic= new AsientoContableLogic(connexion);
		asientocontableLogic.deepLoad(ordencompra.getAsientoContable(),isDeep,deepLoadType,clases);
				

		ordencompra.setDetalleOrdenCompras(ordencompraDataAccess.getDetalleOrdenCompras(connexion,ordencompra));

		for(DetalleOrdenCompra detalleordencompra:ordencompra.getDetalleOrdenCompras()) {
			DetalleOrdenCompraLogic detalleordencompraLogic= new DetalleOrdenCompraLogic(connexion);
			detalleordencompraLogic.deepLoad(detalleordencompra,isDeep,deepLoadType,clases);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				ordencompra.setEmpresa(ordencompraDataAccess.getEmpresa(connexion,ordencompra));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(ordencompra.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				ordencompra.setSucursal(ordencompraDataAccess.getSucursal(connexion,ordencompra));
				SucursalLogic sucursalLogic= new SucursalLogic(connexion);
				sucursalLogic.deepLoad(ordencompra.getSucursal(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Modulo.class)) {
				ordencompra.setModulo(ordencompraDataAccess.getModulo(connexion,ordencompra));
				ModuloLogic moduloLogic= new ModuloLogic(connexion);
				moduloLogic.deepLoad(ordencompra.getModulo(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Ejercicio.class)) {
				ordencompra.setEjercicio(ordencompraDataAccess.getEjercicio(connexion,ordencompra));
				EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
				ejercicioLogic.deepLoad(ordencompra.getEjercicio(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Periodo.class)) {
				ordencompra.setPeriodo(ordencompraDataAccess.getPeriodo(connexion,ordencompra));
				PeriodoLogic periodoLogic= new PeriodoLogic(connexion);
				periodoLogic.deepLoad(ordencompra.getPeriodo(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Anio.class)) {
				ordencompra.setAnio(ordencompraDataAccess.getAnio(connexion,ordencompra));
				AnioLogic anioLogic= new AnioLogic(connexion);
				anioLogic.deepLoad(ordencompra.getAnio(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Mes.class)) {
				ordencompra.setMes(ordencompraDataAccess.getMes(connexion,ordencompra));
				MesLogic mesLogic= new MesLogic(connexion);
				mesLogic.deepLoad(ordencompra.getMes(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Usuario.class)) {
				ordencompra.setUsuario(ordencompraDataAccess.getUsuario(connexion,ordencompra));
				UsuarioLogic usuarioLogic= new UsuarioLogic(connexion);
				usuarioLogic.deepLoad(ordencompra.getUsuario(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Moneda.class)) {
				ordencompra.setMoneda(ordencompraDataAccess.getMoneda(connexion,ordencompra));
				MonedaLogic monedaLogic= new MonedaLogic(connexion);
				monedaLogic.deepLoad(ordencompra.getMoneda(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoCambio.class)) {
				ordencompra.setTipoCambio(ordencompraDataAccess.getTipoCambio(connexion,ordencompra));
				TipoCambioLogic tipocambioLogic= new TipoCambioLogic(connexion);
				tipocambioLogic.deepLoad(ordencompra.getTipoCambio(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(EstadoOrdenCompra.class)) {
				ordencompra.setEstadoOrdenCompra(ordencompraDataAccess.getEstadoOrdenCompra(connexion,ordencompra));
				EstadoOrdenCompraLogic estadoordencompraLogic= new EstadoOrdenCompraLogic(connexion);
				estadoordencompraLogic.deepLoad(ordencompra.getEstadoOrdenCompra(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Cliente.class)) {
				ordencompra.setCliente(ordencompraDataAccess.getCliente(connexion,ordencompra));
				ClienteLogic clienteLogic= new ClienteLogic(connexion);
				clienteLogic.deepLoad(ordencompra.getCliente(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Formato.class)) {
				ordencompra.setFormato(ordencompraDataAccess.getFormato(connexion,ordencompra));
				FormatoLogic formatoLogic= new FormatoLogic(connexion);
				formatoLogic.deepLoad(ordencompra.getFormato(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Transportista.class)) {
				ordencompra.setTransportista(ordencompraDataAccess.getTransportista(connexion,ordencompra));
				TransportistaLogic transportistaLogic= new TransportistaLogic(connexion);
				transportistaLogic.deepLoad(ordencompra.getTransportista(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Empleado.class)) {
				ordencompra.setEmpleado(ordencompraDataAccess.getEmpleado(connexion,ordencompra));
				EmpleadoLogic empleadoLogic= new EmpleadoLogic(connexion);
				empleadoLogic.deepLoad(ordencompra.getEmpleado(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoTransaccionModulo.class)) {
				ordencompra.setTipoTransaccionModulo(ordencompraDataAccess.getTipoTransaccionModulo(connexion,ordencompra));
				TipoTransaccionModuloLogic tipotransaccionmoduloLogic= new TipoTransaccionModuloLogic(connexion);
				tipotransaccionmoduloLogic.deepLoad(ordencompra.getTipoTransaccionModulo(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(OrdenCompra.class)) {
				ordencompra.setOrdenCompra(ordencompraDataAccess.getOrdenCompra(connexion,ordencompra));
				OrdenCompraLogic ordencompraLogic= new OrdenCompraLogic(connexion);
				ordencompraLogic.deepLoad(ordencompra.getOrdenCompra(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(AsientoContable.class)) {
				ordencompra.setAsientoContable(ordencompraDataAccess.getAsientoContable(connexion,ordencompra));
				AsientoContableLogic asientocontableLogic= new AsientoContableLogic(connexion);
				asientocontableLogic.deepLoad(ordencompra.getAsientoContable(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(DetalleOrdenCompra.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				ordencompra.setDetalleOrdenCompras(ordencompraDataAccess.getDetalleOrdenCompras(connexion,ordencompra));

				for(DetalleOrdenCompra detalleordencompra:ordencompra.getDetalleOrdenCompras()) {
					DetalleOrdenCompraLogic detalleordencompraLogic= new DetalleOrdenCompraLogic(connexion);
					detalleordencompraLogic.deepLoad(detalleordencompra,isDeep,deepLoadType,clases);
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
			ordencompra.setEmpresa(ordencompraDataAccess.getEmpresa(connexion,ordencompra));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(ordencompra.getEmpresa(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			ordencompra.setSucursal(ordencompraDataAccess.getSucursal(connexion,ordencompra));
			SucursalLogic sucursalLogic= new SucursalLogic(connexion);
			sucursalLogic.deepLoad(ordencompra.getSucursal(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Modulo.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			ordencompra.setModulo(ordencompraDataAccess.getModulo(connexion,ordencompra));
			ModuloLogic moduloLogic= new ModuloLogic(connexion);
			moduloLogic.deepLoad(ordencompra.getModulo(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Ejercicio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			ordencompra.setEjercicio(ordencompraDataAccess.getEjercicio(connexion,ordencompra));
			EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
			ejercicioLogic.deepLoad(ordencompra.getEjercicio(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Periodo.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			ordencompra.setPeriodo(ordencompraDataAccess.getPeriodo(connexion,ordencompra));
			PeriodoLogic periodoLogic= new PeriodoLogic(connexion);
			periodoLogic.deepLoad(ordencompra.getPeriodo(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Anio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			ordencompra.setAnio(ordencompraDataAccess.getAnio(connexion,ordencompra));
			AnioLogic anioLogic= new AnioLogic(connexion);
			anioLogic.deepLoad(ordencompra.getAnio(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Mes.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			ordencompra.setMes(ordencompraDataAccess.getMes(connexion,ordencompra));
			MesLogic mesLogic= new MesLogic(connexion);
			mesLogic.deepLoad(ordencompra.getMes(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Usuario.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			ordencompra.setUsuario(ordencompraDataAccess.getUsuario(connexion,ordencompra));
			UsuarioLogic usuarioLogic= new UsuarioLogic(connexion);
			usuarioLogic.deepLoad(ordencompra.getUsuario(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Moneda.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			ordencompra.setMoneda(ordencompraDataAccess.getMoneda(connexion,ordencompra));
			MonedaLogic monedaLogic= new MonedaLogic(connexion);
			monedaLogic.deepLoad(ordencompra.getMoneda(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(TipoCambio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			ordencompra.setTipoCambio(ordencompraDataAccess.getTipoCambio(connexion,ordencompra));
			TipoCambioLogic tipocambioLogic= new TipoCambioLogic(connexion);
			tipocambioLogic.deepLoad(ordencompra.getTipoCambio(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(EstadoOrdenCompra.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			ordencompra.setEstadoOrdenCompra(ordencompraDataAccess.getEstadoOrdenCompra(connexion,ordencompra));
			EstadoOrdenCompraLogic estadoordencompraLogic= new EstadoOrdenCompraLogic(connexion);
			estadoordencompraLogic.deepLoad(ordencompra.getEstadoOrdenCompra(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Cliente.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			ordencompra.setCliente(ordencompraDataAccess.getCliente(connexion,ordencompra));
			ClienteLogic clienteLogic= new ClienteLogic(connexion);
			clienteLogic.deepLoad(ordencompra.getCliente(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Formato.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			ordencompra.setFormato(ordencompraDataAccess.getFormato(connexion,ordencompra));
			FormatoLogic formatoLogic= new FormatoLogic(connexion);
			formatoLogic.deepLoad(ordencompra.getFormato(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Transportista.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			ordencompra.setTransportista(ordencompraDataAccess.getTransportista(connexion,ordencompra));
			TransportistaLogic transportistaLogic= new TransportistaLogic(connexion);
			transportistaLogic.deepLoad(ordencompra.getTransportista(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Empleado.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			ordencompra.setEmpleado(ordencompraDataAccess.getEmpleado(connexion,ordencompra));
			EmpleadoLogic empleadoLogic= new EmpleadoLogic(connexion);
			empleadoLogic.deepLoad(ordencompra.getEmpleado(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(TipoTransaccionModulo.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			ordencompra.setTipoTransaccionModulo(ordencompraDataAccess.getTipoTransaccionModulo(connexion,ordencompra));
			TipoTransaccionModuloLogic tipotransaccionmoduloLogic= new TipoTransaccionModuloLogic(connexion);
			tipotransaccionmoduloLogic.deepLoad(ordencompra.getTipoTransaccionModulo(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(OrdenCompra.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			ordencompra.setOrdenCompra(ordencompraDataAccess.getOrdenCompra(connexion,ordencompra));
			OrdenCompraLogic ordencompraLogic= new OrdenCompraLogic(connexion);
			ordencompraLogic.deepLoad(ordencompra.getOrdenCompra(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(AsientoContable.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			ordencompra.setAsientoContable(ordencompraDataAccess.getAsientoContable(connexion,ordencompra));
			AsientoContableLogic asientocontableLogic= new AsientoContableLogic(connexion);
			asientocontableLogic.deepLoad(ordencompra.getAsientoContable(),isDeep,deepLoadType,clases);
				
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(DetalleOrdenCompra.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(DetalleOrdenCompra.class));
			ordencompra.setDetalleOrdenCompras(ordencompraDataAccess.getDetalleOrdenCompras(connexion,ordencompra));

			for(DetalleOrdenCompra detalleordencompra:ordencompra.getDetalleOrdenCompras()) {
				DetalleOrdenCompraLogic detalleordencompraLogic= new DetalleOrdenCompraLogic(connexion);
				detalleordencompraLogic.deepLoad(detalleordencompra,isDeep,deepLoadType,clases);
			}
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(OrdenCompra ordencompra,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			OrdenCompraLogicAdditional.updateOrdenCompraToSave(ordencompra,this.arrDatoGeneral);
			
OrdenCompraDataAccess.save(ordencompra, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(ordencompra.getEmpresa(),connexion);

		SucursalDataAccess.save(ordencompra.getSucursal(),connexion);

		ModuloDataAccess.save(ordencompra.getModulo(),connexion);

		EjercicioDataAccess.save(ordencompra.getEjercicio(),connexion);

		PeriodoDataAccess.save(ordencompra.getPeriodo(),connexion);

		AnioDataAccess.save(ordencompra.getAnio(),connexion);

		MesDataAccess.save(ordencompra.getMes(),connexion);

		UsuarioDataAccess.save(ordencompra.getUsuario(),connexion);

		MonedaDataAccess.save(ordencompra.getMoneda(),connexion);

		TipoCambioDataAccess.save(ordencompra.getTipoCambio(),connexion);

		EstadoOrdenCompraDataAccess.save(ordencompra.getEstadoOrdenCompra(),connexion);

		ClienteDataAccess.save(ordencompra.getCliente(),connexion);

		FormatoDataAccess.save(ordencompra.getFormato(),connexion);

		TransportistaDataAccess.save(ordencompra.getTransportista(),connexion);

		EmpleadoDataAccess.save(ordencompra.getEmpleado(),connexion);

		TipoTransaccionModuloDataAccess.save(ordencompra.getTipoTransaccionModulo(),connexion);

		OrdenCompraDataAccess.save(ordencompra.getOrdenCompra(),connexion);

		AsientoContableDataAccess.save(ordencompra.getAsientoContable(),connexion);

		for(DetalleOrdenCompra detalleordencompra:ordencompra.getDetalleOrdenCompras()) {
			detalleordencompra.setid_orden_compra(ordencompra.getId());
			DetalleOrdenCompraDataAccess.save(detalleordencompra,connexion);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(ordencompra.getEmpresa(),connexion);
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				SucursalDataAccess.save(ordencompra.getSucursal(),connexion);
				continue;
			}

			if(clas.clas.equals(Modulo.class)) {
				ModuloDataAccess.save(ordencompra.getModulo(),connexion);
				continue;
			}

			if(clas.clas.equals(Ejercicio.class)) {
				EjercicioDataAccess.save(ordencompra.getEjercicio(),connexion);
				continue;
			}

			if(clas.clas.equals(Periodo.class)) {
				PeriodoDataAccess.save(ordencompra.getPeriodo(),connexion);
				continue;
			}

			if(clas.clas.equals(Anio.class)) {
				AnioDataAccess.save(ordencompra.getAnio(),connexion);
				continue;
			}

			if(clas.clas.equals(Mes.class)) {
				MesDataAccess.save(ordencompra.getMes(),connexion);
				continue;
			}

			if(clas.clas.equals(Usuario.class)) {
				UsuarioDataAccess.save(ordencompra.getUsuario(),connexion);
				continue;
			}

			if(clas.clas.equals(Moneda.class)) {
				MonedaDataAccess.save(ordencompra.getMoneda(),connexion);
				continue;
			}

			if(clas.clas.equals(TipoCambio.class)) {
				TipoCambioDataAccess.save(ordencompra.getTipoCambio(),connexion);
				continue;
			}

			if(clas.clas.equals(EstadoOrdenCompra.class)) {
				EstadoOrdenCompraDataAccess.save(ordencompra.getEstadoOrdenCompra(),connexion);
				continue;
			}

			if(clas.clas.equals(Cliente.class)) {
				ClienteDataAccess.save(ordencompra.getCliente(),connexion);
				continue;
			}

			if(clas.clas.equals(Formato.class)) {
				FormatoDataAccess.save(ordencompra.getFormato(),connexion);
				continue;
			}

			if(clas.clas.equals(Transportista.class)) {
				TransportistaDataAccess.save(ordencompra.getTransportista(),connexion);
				continue;
			}

			if(clas.clas.equals(Empleado.class)) {
				EmpleadoDataAccess.save(ordencompra.getEmpleado(),connexion);
				continue;
			}

			if(clas.clas.equals(TipoTransaccionModulo.class)) {
				TipoTransaccionModuloDataAccess.save(ordencompra.getTipoTransaccionModulo(),connexion);
				continue;
			}

			if(clas.clas.equals(OrdenCompra.class)) {
				OrdenCompraDataAccess.save(ordencompra.getOrdenCompra(),connexion);
				continue;
			}

			if(clas.clas.equals(AsientoContable.class)) {
				AsientoContableDataAccess.save(ordencompra.getAsientoContable(),connexion);
				continue;
			}


			if(clas.clas.equals(DetalleOrdenCompra.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(DetalleOrdenCompra detalleordencompra:ordencompra.getDetalleOrdenCompras()) {
					detalleordencompra.setid_orden_compra(ordencompra.getId());
					DetalleOrdenCompraDataAccess.save(detalleordencompra,connexion);
				}
				continue;
			}
		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(ordencompra.getEmpresa(),connexion);
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(ordencompra.getEmpresa(),isDeep,deepLoadType,clases);
				

		SucursalDataAccess.save(ordencompra.getSucursal(),connexion);
		SucursalLogic sucursalLogic= new SucursalLogic(connexion);
		sucursalLogic.deepLoad(ordencompra.getSucursal(),isDeep,deepLoadType,clases);
				

		ModuloDataAccess.save(ordencompra.getModulo(),connexion);
		ModuloLogic moduloLogic= new ModuloLogic(connexion);
		moduloLogic.deepLoad(ordencompra.getModulo(),isDeep,deepLoadType,clases);
				

		EjercicioDataAccess.save(ordencompra.getEjercicio(),connexion);
		EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
		ejercicioLogic.deepLoad(ordencompra.getEjercicio(),isDeep,deepLoadType,clases);
				

		PeriodoDataAccess.save(ordencompra.getPeriodo(),connexion);
		PeriodoLogic periodoLogic= new PeriodoLogic(connexion);
		periodoLogic.deepLoad(ordencompra.getPeriodo(),isDeep,deepLoadType,clases);
				

		AnioDataAccess.save(ordencompra.getAnio(),connexion);
		AnioLogic anioLogic= new AnioLogic(connexion);
		anioLogic.deepLoad(ordencompra.getAnio(),isDeep,deepLoadType,clases);
				

		MesDataAccess.save(ordencompra.getMes(),connexion);
		MesLogic mesLogic= new MesLogic(connexion);
		mesLogic.deepLoad(ordencompra.getMes(),isDeep,deepLoadType,clases);
				

		UsuarioDataAccess.save(ordencompra.getUsuario(),connexion);
		UsuarioLogic usuarioLogic= new UsuarioLogic(connexion);
		usuarioLogic.deepLoad(ordencompra.getUsuario(),isDeep,deepLoadType,clases);
				

		MonedaDataAccess.save(ordencompra.getMoneda(),connexion);
		MonedaLogic monedaLogic= new MonedaLogic(connexion);
		monedaLogic.deepLoad(ordencompra.getMoneda(),isDeep,deepLoadType,clases);
				

		TipoCambioDataAccess.save(ordencompra.getTipoCambio(),connexion);
		TipoCambioLogic tipocambioLogic= new TipoCambioLogic(connexion);
		tipocambioLogic.deepLoad(ordencompra.getTipoCambio(),isDeep,deepLoadType,clases);
				

		EstadoOrdenCompraDataAccess.save(ordencompra.getEstadoOrdenCompra(),connexion);
		EstadoOrdenCompraLogic estadoordencompraLogic= new EstadoOrdenCompraLogic(connexion);
		estadoordencompraLogic.deepLoad(ordencompra.getEstadoOrdenCompra(),isDeep,deepLoadType,clases);
				

		ClienteDataAccess.save(ordencompra.getCliente(),connexion);
		ClienteLogic clienteLogic= new ClienteLogic(connexion);
		clienteLogic.deepLoad(ordencompra.getCliente(),isDeep,deepLoadType,clases);
				

		FormatoDataAccess.save(ordencompra.getFormato(),connexion);
		FormatoLogic formatoLogic= new FormatoLogic(connexion);
		formatoLogic.deepLoad(ordencompra.getFormato(),isDeep,deepLoadType,clases);
				

		TransportistaDataAccess.save(ordencompra.getTransportista(),connexion);
		TransportistaLogic transportistaLogic= new TransportistaLogic(connexion);
		transportistaLogic.deepLoad(ordencompra.getTransportista(),isDeep,deepLoadType,clases);
				

		EmpleadoDataAccess.save(ordencompra.getEmpleado(),connexion);
		EmpleadoLogic empleadoLogic= new EmpleadoLogic(connexion);
		empleadoLogic.deepLoad(ordencompra.getEmpleado(),isDeep,deepLoadType,clases);
				

		TipoTransaccionModuloDataAccess.save(ordencompra.getTipoTransaccionModulo(),connexion);
		TipoTransaccionModuloLogic tipotransaccionmoduloLogic= new TipoTransaccionModuloLogic(connexion);
		tipotransaccionmoduloLogic.deepLoad(ordencompra.getTipoTransaccionModulo(),isDeep,deepLoadType,clases);
				

		OrdenCompraDataAccess.save(ordencompra.getOrdenCompra(),connexion);
		OrdenCompraLogic ordencompraLogic= new OrdenCompraLogic(connexion);
		ordencompraLogic.deepLoad(ordencompra.getOrdenCompra(),isDeep,deepLoadType,clases);
				

		AsientoContableDataAccess.save(ordencompra.getAsientoContable(),connexion);
		AsientoContableLogic asientocontableLogic= new AsientoContableLogic(connexion);
		asientocontableLogic.deepLoad(ordencompra.getAsientoContable(),isDeep,deepLoadType,clases);
				

		for(DetalleOrdenCompra detalleordencompra:ordencompra.getDetalleOrdenCompras()) {
			DetalleOrdenCompraLogic detalleordencompraLogic= new DetalleOrdenCompraLogic(connexion);
			detalleordencompra.setid_orden_compra(ordencompra.getId());
			DetalleOrdenCompraDataAccess.save(detalleordencompra,connexion);
			detalleordencompraLogic.deepSave(detalleordencompra,isDeep,deepLoadType,clases);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(ordencompra.getEmpresa(),connexion);
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepSave(ordencompra.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				SucursalDataAccess.save(ordencompra.getSucursal(),connexion);
				SucursalLogic sucursalLogic= new SucursalLogic(connexion);
				sucursalLogic.deepSave(ordencompra.getSucursal(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Modulo.class)) {
				ModuloDataAccess.save(ordencompra.getModulo(),connexion);
				ModuloLogic moduloLogic= new ModuloLogic(connexion);
				moduloLogic.deepSave(ordencompra.getModulo(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Ejercicio.class)) {
				EjercicioDataAccess.save(ordencompra.getEjercicio(),connexion);
				EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
				ejercicioLogic.deepSave(ordencompra.getEjercicio(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Periodo.class)) {
				PeriodoDataAccess.save(ordencompra.getPeriodo(),connexion);
				PeriodoLogic periodoLogic= new PeriodoLogic(connexion);
				periodoLogic.deepSave(ordencompra.getPeriodo(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Anio.class)) {
				AnioDataAccess.save(ordencompra.getAnio(),connexion);
				AnioLogic anioLogic= new AnioLogic(connexion);
				anioLogic.deepSave(ordencompra.getAnio(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Mes.class)) {
				MesDataAccess.save(ordencompra.getMes(),connexion);
				MesLogic mesLogic= new MesLogic(connexion);
				mesLogic.deepSave(ordencompra.getMes(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Usuario.class)) {
				UsuarioDataAccess.save(ordencompra.getUsuario(),connexion);
				UsuarioLogic usuarioLogic= new UsuarioLogic(connexion);
				usuarioLogic.deepSave(ordencompra.getUsuario(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Moneda.class)) {
				MonedaDataAccess.save(ordencompra.getMoneda(),connexion);
				MonedaLogic monedaLogic= new MonedaLogic(connexion);
				monedaLogic.deepSave(ordencompra.getMoneda(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoCambio.class)) {
				TipoCambioDataAccess.save(ordencompra.getTipoCambio(),connexion);
				TipoCambioLogic tipocambioLogic= new TipoCambioLogic(connexion);
				tipocambioLogic.deepSave(ordencompra.getTipoCambio(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(EstadoOrdenCompra.class)) {
				EstadoOrdenCompraDataAccess.save(ordencompra.getEstadoOrdenCompra(),connexion);
				EstadoOrdenCompraLogic estadoordencompraLogic= new EstadoOrdenCompraLogic(connexion);
				estadoordencompraLogic.deepSave(ordencompra.getEstadoOrdenCompra(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Cliente.class)) {
				ClienteDataAccess.save(ordencompra.getCliente(),connexion);
				ClienteLogic clienteLogic= new ClienteLogic(connexion);
				clienteLogic.deepSave(ordencompra.getCliente(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Formato.class)) {
				FormatoDataAccess.save(ordencompra.getFormato(),connexion);
				FormatoLogic formatoLogic= new FormatoLogic(connexion);
				formatoLogic.deepSave(ordencompra.getFormato(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Transportista.class)) {
				TransportistaDataAccess.save(ordencompra.getTransportista(),connexion);
				TransportistaLogic transportistaLogic= new TransportistaLogic(connexion);
				transportistaLogic.deepSave(ordencompra.getTransportista(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Empleado.class)) {
				EmpleadoDataAccess.save(ordencompra.getEmpleado(),connexion);
				EmpleadoLogic empleadoLogic= new EmpleadoLogic(connexion);
				empleadoLogic.deepSave(ordencompra.getEmpleado(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoTransaccionModulo.class)) {
				TipoTransaccionModuloDataAccess.save(ordencompra.getTipoTransaccionModulo(),connexion);
				TipoTransaccionModuloLogic tipotransaccionmoduloLogic= new TipoTransaccionModuloLogic(connexion);
				tipotransaccionmoduloLogic.deepSave(ordencompra.getTipoTransaccionModulo(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(OrdenCompra.class)) {
				OrdenCompraDataAccess.save(ordencompra.getOrdenCompra(),connexion);
				OrdenCompraLogic ordencompraLogic= new OrdenCompraLogic(connexion);
				ordencompraLogic.deepSave(ordencompra.getOrdenCompra(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(AsientoContable.class)) {
				AsientoContableDataAccess.save(ordencompra.getAsientoContable(),connexion);
				AsientoContableLogic asientocontableLogic= new AsientoContableLogic(connexion);
				asientocontableLogic.deepSave(ordencompra.getAsientoContable(),isDeep,deepLoadType,clases);				
				continue;
			}


			if(clas.clas.equals(DetalleOrdenCompra.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(DetalleOrdenCompra detalleordencompra:ordencompra.getDetalleOrdenCompras()) {
					DetalleOrdenCompraLogic detalleordencompraLogic= new DetalleOrdenCompraLogic(connexion);
					detalleordencompra.setid_orden_compra(ordencompra.getId());
					DetalleOrdenCompraDataAccess.save(detalleordencompra,connexion);
					detalleordencompraLogic.deepSave(detalleordencompra,isDeep,deepLoadType,clases);
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
			this.getNewConnexionToDeep(OrdenCompra.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(ordencompra,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				OrdenCompraConstantesFunciones.refrescarForeignKeysDescripcionesOrdenCompra(ordencompra);
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
			this.deepLoad(this.ordencompra,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				OrdenCompraConstantesFunciones.refrescarForeignKeysDescripcionesOrdenCompra(this.ordencompra);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(OrdenCompra.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(ordencompras!=null) {
				for(OrdenCompra ordencompra:ordencompras) {
					this.deepLoad(ordencompra,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					OrdenCompraConstantesFunciones.refrescarForeignKeysDescripcionesOrdenCompra(ordencompras);
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
			if(ordencompras!=null) {
				for(OrdenCompra ordencompra:ordencompras) {
					this.deepLoad(ordencompra,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					OrdenCompraConstantesFunciones.refrescarForeignKeysDescripcionesOrdenCompra(ordencompras);
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
			this.getNewConnexionToDeep(OrdenCompra.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(ordencompra,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(OrdenCompra.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(ordencompras!=null) {
				for(OrdenCompra ordencompra:ordencompras) {
					this.deepSave(ordencompra,isDeep,deepLoadType,clases);
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
			if(ordencompras!=null) {
				for(OrdenCompra ordencompra:ordencompras) {
					this.deepSave(ordencompra,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getOrdenComprasFK_IdAnioWithConnection(String sFinalQuery,Pagination pagination,Long id_anio)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,OrdenCompra.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidAnio= new ParameterSelectionGeneral();
			parameterSelectionGeneralidAnio.setParameterSelectionGeneralEqual(ParameterType.LONG,id_anio,OrdenCompraConstantesFunciones.IDANIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidAnio);

			OrdenCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdAnio","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			ordencompras=ordencompraDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				OrdenCompraConstantesFunciones.refrescarForeignKeysDescripcionesOrdenCompra(this.ordencompras);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getOrdenComprasFK_IdAnio(String sFinalQuery,Pagination pagination,Long id_anio)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidAnio= new ParameterSelectionGeneral();
			parameterSelectionGeneralidAnio.setParameterSelectionGeneralEqual(ParameterType.LONG,id_anio,OrdenCompraConstantesFunciones.IDANIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidAnio);

			OrdenCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdAnio","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			ordencompras=ordencompraDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				OrdenCompraConstantesFunciones.refrescarForeignKeysDescripcionesOrdenCompra(this.ordencompras);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getOrdenComprasFK_IdAsientoContableWithConnection(String sFinalQuery,Pagination pagination,Long id_asiento_contable)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,OrdenCompra.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidAsientoContable= new ParameterSelectionGeneral();
			parameterSelectionGeneralidAsientoContable.setParameterSelectionGeneralEqual(ParameterType.LONG,id_asiento_contable,OrdenCompraConstantesFunciones.IDASIENTOCONTABLE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidAsientoContable);

			OrdenCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdAsientoContable","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			ordencompras=ordencompraDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				OrdenCompraConstantesFunciones.refrescarForeignKeysDescripcionesOrdenCompra(this.ordencompras);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getOrdenComprasFK_IdAsientoContable(String sFinalQuery,Pagination pagination,Long id_asiento_contable)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidAsientoContable= new ParameterSelectionGeneral();
			parameterSelectionGeneralidAsientoContable.setParameterSelectionGeneralEqual(ParameterType.LONG,id_asiento_contable,OrdenCompraConstantesFunciones.IDASIENTOCONTABLE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidAsientoContable);

			OrdenCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdAsientoContable","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			ordencompras=ordencompraDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				OrdenCompraConstantesFunciones.refrescarForeignKeysDescripcionesOrdenCompra(this.ordencompras);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getOrdenComprasFK_IdClienteWithConnection(String sFinalQuery,Pagination pagination,Long id_cliente)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,OrdenCompra.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCliente= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCliente.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cliente,OrdenCompraConstantesFunciones.IDCLIENTE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCliente);

			OrdenCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCliente","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			ordencompras=ordencompraDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				OrdenCompraConstantesFunciones.refrescarForeignKeysDescripcionesOrdenCompra(this.ordencompras);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getOrdenComprasFK_IdCliente(String sFinalQuery,Pagination pagination,Long id_cliente)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCliente= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCliente.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cliente,OrdenCompraConstantesFunciones.IDCLIENTE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCliente);

			OrdenCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCliente","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			ordencompras=ordencompraDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				OrdenCompraConstantesFunciones.refrescarForeignKeysDescripcionesOrdenCompra(this.ordencompras);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getOrdenComprasFK_IdEjercicioWithConnection(String sFinalQuery,Pagination pagination,Long id_ejercicio)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,OrdenCompra.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEjercicio= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEjercicio.setParameterSelectionGeneralEqual(ParameterType.LONG,id_ejercicio,OrdenCompraConstantesFunciones.IDEJERCICIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEjercicio);

			OrdenCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEjercicio","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			ordencompras=ordencompraDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				OrdenCompraConstantesFunciones.refrescarForeignKeysDescripcionesOrdenCompra(this.ordencompras);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getOrdenComprasFK_IdEjercicio(String sFinalQuery,Pagination pagination,Long id_ejercicio)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEjercicio= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEjercicio.setParameterSelectionGeneralEqual(ParameterType.LONG,id_ejercicio,OrdenCompraConstantesFunciones.IDEJERCICIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEjercicio);

			OrdenCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEjercicio","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			ordencompras=ordencompraDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				OrdenCompraConstantesFunciones.refrescarForeignKeysDescripcionesOrdenCompra(this.ordencompras);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getOrdenComprasFK_IdEmpleadoWithConnection(String sFinalQuery,Pagination pagination,Long id_empleado)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,OrdenCompra.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpleado= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpleado.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empleado,OrdenCompraConstantesFunciones.IDEMPLEADO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpleado);

			OrdenCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpleado","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			ordencompras=ordencompraDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				OrdenCompraConstantesFunciones.refrescarForeignKeysDescripcionesOrdenCompra(this.ordencompras);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getOrdenComprasFK_IdEmpleado(String sFinalQuery,Pagination pagination,Long id_empleado)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpleado= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpleado.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empleado,OrdenCompraConstantesFunciones.IDEMPLEADO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpleado);

			OrdenCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpleado","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			ordencompras=ordencompraDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				OrdenCompraConstantesFunciones.refrescarForeignKeysDescripcionesOrdenCompra(this.ordencompras);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getOrdenComprasFK_IdEmpresaWithConnection(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,OrdenCompra.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,OrdenCompraConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			OrdenCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			ordencompras=ordencompraDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				OrdenCompraConstantesFunciones.refrescarForeignKeysDescripcionesOrdenCompra(this.ordencompras);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getOrdenComprasFK_IdEmpresa(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,OrdenCompraConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			OrdenCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			ordencompras=ordencompraDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				OrdenCompraConstantesFunciones.refrescarForeignKeysDescripcionesOrdenCompra(this.ordencompras);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getOrdenComprasFK_IdEstadoOrdenCompraWithConnection(String sFinalQuery,Pagination pagination,Long id_estado_orden_compra)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,OrdenCompra.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEstadoOrdenCompra= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEstadoOrdenCompra.setParameterSelectionGeneralEqual(ParameterType.LONG,id_estado_orden_compra,OrdenCompraConstantesFunciones.IDESTADOORDENCOMPRA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEstadoOrdenCompra);

			OrdenCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEstadoOrdenCompra","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			ordencompras=ordencompraDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				OrdenCompraConstantesFunciones.refrescarForeignKeysDescripcionesOrdenCompra(this.ordencompras);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getOrdenComprasFK_IdEstadoOrdenCompra(String sFinalQuery,Pagination pagination,Long id_estado_orden_compra)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEstadoOrdenCompra= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEstadoOrdenCompra.setParameterSelectionGeneralEqual(ParameterType.LONG,id_estado_orden_compra,OrdenCompraConstantesFunciones.IDESTADOORDENCOMPRA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEstadoOrdenCompra);

			OrdenCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEstadoOrdenCompra","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			ordencompras=ordencompraDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				OrdenCompraConstantesFunciones.refrescarForeignKeysDescripcionesOrdenCompra(this.ordencompras);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getOrdenComprasFK_IdFormatoWithConnection(String sFinalQuery,Pagination pagination,Long id_formato)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,OrdenCompra.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidFormato= new ParameterSelectionGeneral();
			parameterSelectionGeneralidFormato.setParameterSelectionGeneralEqual(ParameterType.LONG,id_formato,OrdenCompraConstantesFunciones.IDFORMATO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidFormato);

			OrdenCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdFormato","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			ordencompras=ordencompraDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				OrdenCompraConstantesFunciones.refrescarForeignKeysDescripcionesOrdenCompra(this.ordencompras);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getOrdenComprasFK_IdFormato(String sFinalQuery,Pagination pagination,Long id_formato)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidFormato= new ParameterSelectionGeneral();
			parameterSelectionGeneralidFormato.setParameterSelectionGeneralEqual(ParameterType.LONG,id_formato,OrdenCompraConstantesFunciones.IDFORMATO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidFormato);

			OrdenCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdFormato","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			ordencompras=ordencompraDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				OrdenCompraConstantesFunciones.refrescarForeignKeysDescripcionesOrdenCompra(this.ordencompras);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getOrdenComprasFK_IdMesWithConnection(String sFinalQuery,Pagination pagination,Long id_mes)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,OrdenCompra.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidMes= new ParameterSelectionGeneral();
			parameterSelectionGeneralidMes.setParameterSelectionGeneralEqual(ParameterType.LONG,id_mes,OrdenCompraConstantesFunciones.IDMES,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidMes);

			OrdenCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdMes","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			ordencompras=ordencompraDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				OrdenCompraConstantesFunciones.refrescarForeignKeysDescripcionesOrdenCompra(this.ordencompras);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getOrdenComprasFK_IdMes(String sFinalQuery,Pagination pagination,Long id_mes)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidMes= new ParameterSelectionGeneral();
			parameterSelectionGeneralidMes.setParameterSelectionGeneralEqual(ParameterType.LONG,id_mes,OrdenCompraConstantesFunciones.IDMES,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidMes);

			OrdenCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdMes","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			ordencompras=ordencompraDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				OrdenCompraConstantesFunciones.refrescarForeignKeysDescripcionesOrdenCompra(this.ordencompras);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getOrdenComprasFK_IdModuloWithConnection(String sFinalQuery,Pagination pagination,Long id_modulo)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,OrdenCompra.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidModulo= new ParameterSelectionGeneral();
			parameterSelectionGeneralidModulo.setParameterSelectionGeneralEqual(ParameterType.LONG,id_modulo,OrdenCompraConstantesFunciones.IDMODULO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidModulo);

			OrdenCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdModulo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			ordencompras=ordencompraDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				OrdenCompraConstantesFunciones.refrescarForeignKeysDescripcionesOrdenCompra(this.ordencompras);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getOrdenComprasFK_IdModulo(String sFinalQuery,Pagination pagination,Long id_modulo)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidModulo= new ParameterSelectionGeneral();
			parameterSelectionGeneralidModulo.setParameterSelectionGeneralEqual(ParameterType.LONG,id_modulo,OrdenCompraConstantesFunciones.IDMODULO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidModulo);

			OrdenCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdModulo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			ordencompras=ordencompraDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				OrdenCompraConstantesFunciones.refrescarForeignKeysDescripcionesOrdenCompra(this.ordencompras);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getOrdenComprasFK_IdMonedaWithConnection(String sFinalQuery,Pagination pagination,Long id_moneda)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,OrdenCompra.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidMoneda= new ParameterSelectionGeneral();
			parameterSelectionGeneralidMoneda.setParameterSelectionGeneralEqual(ParameterType.LONG,id_moneda,OrdenCompraConstantesFunciones.IDMONEDA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidMoneda);

			OrdenCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdMoneda","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			ordencompras=ordencompraDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				OrdenCompraConstantesFunciones.refrescarForeignKeysDescripcionesOrdenCompra(this.ordencompras);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getOrdenComprasFK_IdMoneda(String sFinalQuery,Pagination pagination,Long id_moneda)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidMoneda= new ParameterSelectionGeneral();
			parameterSelectionGeneralidMoneda.setParameterSelectionGeneralEqual(ParameterType.LONG,id_moneda,OrdenCompraConstantesFunciones.IDMONEDA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidMoneda);

			OrdenCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdMoneda","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			ordencompras=ordencompraDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				OrdenCompraConstantesFunciones.refrescarForeignKeysDescripcionesOrdenCompra(this.ordencompras);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getOrdenComprasFK_IdOrdenCompraWithConnection(String sFinalQuery,Pagination pagination,Long id_orden_compra)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,OrdenCompra.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidOrdenCompra= new ParameterSelectionGeneral();
			parameterSelectionGeneralidOrdenCompra.setParameterSelectionGeneralEqual(ParameterType.LONG,id_orden_compra,OrdenCompraConstantesFunciones.IDORDENCOMPRA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidOrdenCompra);

			OrdenCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdOrdenCompra","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			ordencompras=ordencompraDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				OrdenCompraConstantesFunciones.refrescarForeignKeysDescripcionesOrdenCompra(this.ordencompras);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getOrdenComprasFK_IdOrdenCompra(String sFinalQuery,Pagination pagination,Long id_orden_compra)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidOrdenCompra= new ParameterSelectionGeneral();
			parameterSelectionGeneralidOrdenCompra.setParameterSelectionGeneralEqual(ParameterType.LONG,id_orden_compra,OrdenCompraConstantesFunciones.IDORDENCOMPRA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidOrdenCompra);

			OrdenCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdOrdenCompra","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			ordencompras=ordencompraDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				OrdenCompraConstantesFunciones.refrescarForeignKeysDescripcionesOrdenCompra(this.ordencompras);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getOrdenComprasFK_IdPeriodoWithConnection(String sFinalQuery,Pagination pagination,Long id_periodo)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,OrdenCompra.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidPeriodo= new ParameterSelectionGeneral();
			parameterSelectionGeneralidPeriodo.setParameterSelectionGeneralEqual(ParameterType.LONG,id_periodo,OrdenCompraConstantesFunciones.IDPERIODO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidPeriodo);

			OrdenCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdPeriodo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			ordencompras=ordencompraDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				OrdenCompraConstantesFunciones.refrescarForeignKeysDescripcionesOrdenCompra(this.ordencompras);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getOrdenComprasFK_IdPeriodo(String sFinalQuery,Pagination pagination,Long id_periodo)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidPeriodo= new ParameterSelectionGeneral();
			parameterSelectionGeneralidPeriodo.setParameterSelectionGeneralEqual(ParameterType.LONG,id_periodo,OrdenCompraConstantesFunciones.IDPERIODO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidPeriodo);

			OrdenCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdPeriodo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			ordencompras=ordencompraDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				OrdenCompraConstantesFunciones.refrescarForeignKeysDescripcionesOrdenCompra(this.ordencompras);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getOrdenComprasFK_IdSucursalWithConnection(String sFinalQuery,Pagination pagination,Long id_sucursal)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,OrdenCompra.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidSucursal= new ParameterSelectionGeneral();
			parameterSelectionGeneralidSucursal.setParameterSelectionGeneralEqual(ParameterType.LONG,id_sucursal,OrdenCompraConstantesFunciones.IDSUCURSAL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidSucursal);

			OrdenCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdSucursal","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			ordencompras=ordencompraDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				OrdenCompraConstantesFunciones.refrescarForeignKeysDescripcionesOrdenCompra(this.ordencompras);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getOrdenComprasFK_IdSucursal(String sFinalQuery,Pagination pagination,Long id_sucursal)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidSucursal= new ParameterSelectionGeneral();
			parameterSelectionGeneralidSucursal.setParameterSelectionGeneralEqual(ParameterType.LONG,id_sucursal,OrdenCompraConstantesFunciones.IDSUCURSAL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidSucursal);

			OrdenCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdSucursal","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			ordencompras=ordencompraDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				OrdenCompraConstantesFunciones.refrescarForeignKeysDescripcionesOrdenCompra(this.ordencompras);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getOrdenComprasFK_IdTipoCambioWithConnection(String sFinalQuery,Pagination pagination,Long id_tipo_cambio)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,OrdenCompra.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoCambio= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoCambio.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_cambio,OrdenCompraConstantesFunciones.IDTIPOCAMBIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoCambio);

			OrdenCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoCambio","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			ordencompras=ordencompraDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				OrdenCompraConstantesFunciones.refrescarForeignKeysDescripcionesOrdenCompra(this.ordencompras);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getOrdenComprasFK_IdTipoCambio(String sFinalQuery,Pagination pagination,Long id_tipo_cambio)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoCambio= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoCambio.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_cambio,OrdenCompraConstantesFunciones.IDTIPOCAMBIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoCambio);

			OrdenCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoCambio","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			ordencompras=ordencompraDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				OrdenCompraConstantesFunciones.refrescarForeignKeysDescripcionesOrdenCompra(this.ordencompras);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getOrdenComprasFK_IdTipoTransaccionModuloWithConnection(String sFinalQuery,Pagination pagination,Long id_tipo_transaccion_modulo)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,OrdenCompra.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoTransaccionModulo= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoTransaccionModulo.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_transaccion_modulo,OrdenCompraConstantesFunciones.IDTIPOTRANSACCIONMODULO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoTransaccionModulo);

			OrdenCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoTransaccionModulo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			ordencompras=ordencompraDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				OrdenCompraConstantesFunciones.refrescarForeignKeysDescripcionesOrdenCompra(this.ordencompras);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getOrdenComprasFK_IdTipoTransaccionModulo(String sFinalQuery,Pagination pagination,Long id_tipo_transaccion_modulo)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoTransaccionModulo= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoTransaccionModulo.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_transaccion_modulo,OrdenCompraConstantesFunciones.IDTIPOTRANSACCIONMODULO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoTransaccionModulo);

			OrdenCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoTransaccionModulo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			ordencompras=ordencompraDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				OrdenCompraConstantesFunciones.refrescarForeignKeysDescripcionesOrdenCompra(this.ordencompras);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getOrdenComprasFK_IdTransportistaWithConnection(String sFinalQuery,Pagination pagination,Long id_transportista)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,OrdenCompra.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTransportista= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTransportista.setParameterSelectionGeneralEqual(ParameterType.LONG,id_transportista,OrdenCompraConstantesFunciones.IDTRANSPORTISTA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTransportista);

			OrdenCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTransportista","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			ordencompras=ordencompraDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				OrdenCompraConstantesFunciones.refrescarForeignKeysDescripcionesOrdenCompra(this.ordencompras);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getOrdenComprasFK_IdTransportista(String sFinalQuery,Pagination pagination,Long id_transportista)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTransportista= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTransportista.setParameterSelectionGeneralEqual(ParameterType.LONG,id_transportista,OrdenCompraConstantesFunciones.IDTRANSPORTISTA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTransportista);

			OrdenCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTransportista","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			ordencompras=ordencompraDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				OrdenCompraConstantesFunciones.refrescarForeignKeysDescripcionesOrdenCompra(this.ordencompras);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getOrdenComprasFK_IdUsuarioWithConnection(String sFinalQuery,Pagination pagination,Long id_usuario)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,OrdenCompra.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidUsuario= new ParameterSelectionGeneral();
			parameterSelectionGeneralidUsuario.setParameterSelectionGeneralEqual(ParameterType.LONG,id_usuario,OrdenCompraConstantesFunciones.IDUSUARIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidUsuario);

			OrdenCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdUsuario","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			ordencompras=ordencompraDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				OrdenCompraConstantesFunciones.refrescarForeignKeysDescripcionesOrdenCompra(this.ordencompras);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getOrdenComprasFK_IdUsuario(String sFinalQuery,Pagination pagination,Long id_usuario)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidUsuario= new ParameterSelectionGeneral();
			parameterSelectionGeneralidUsuario.setParameterSelectionGeneralEqual(ParameterType.LONG,id_usuario,OrdenCompraConstantesFunciones.IDUSUARIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidUsuario);

			OrdenCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdUsuario","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			ordencompras=ordencompraDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				OrdenCompraConstantesFunciones.refrescarForeignKeysDescripcionesOrdenCompra(this.ordencompras);
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
			if(OrdenCompraConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,OrdenCompraDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,OrdenCompra ordencompra,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(OrdenCompraConstantesFunciones.ISCONAUDITORIA) {
				if(ordencompra.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,OrdenCompraDataAccess.TABLENAME, ordencompra.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(OrdenCompraConstantesFunciones.ISCONAUDITORIADETALLE) {
						////OrdenCompraLogic.registrarAuditoriaDetallesOrdenCompra(connexion,ordencompra,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(ordencompra.getIsDeleted()) {
					/*if(!ordencompra.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,OrdenCompraDataAccess.TABLENAME, ordencompra.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////OrdenCompraLogic.registrarAuditoriaDetallesOrdenCompra(connexion,ordencompra,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,OrdenCompraDataAccess.TABLENAME, ordencompra.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(ordencompra.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,OrdenCompraDataAccess.TABLENAME, ordencompra.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(OrdenCompraConstantesFunciones.ISCONAUDITORIADETALLE) {
						////OrdenCompraLogic.registrarAuditoriaDetallesOrdenCompra(connexion,ordencompra,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesOrdenCompra(Connexion connexion,OrdenCompra ordencompra)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(ordencompra.getIsNew()||!ordencompra.getid_empresa().equals(ordencompra.getOrdenCompraOriginal().getid_empresa()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(ordencompra.getOrdenCompraOriginal().getid_empresa()!=null)
				{
					strValorActual=ordencompra.getOrdenCompraOriginal().getid_empresa().toString();
				}
				if(ordencompra.getid_empresa()!=null)
				{
					strValorNuevo=ordencompra.getid_empresa().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),OrdenCompraConstantesFunciones.IDEMPRESA,strValorActual,strValorNuevo);
			}	
			
			if(ordencompra.getIsNew()||!ordencompra.getid_sucursal().equals(ordencompra.getOrdenCompraOriginal().getid_sucursal()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(ordencompra.getOrdenCompraOriginal().getid_sucursal()!=null)
				{
					strValorActual=ordencompra.getOrdenCompraOriginal().getid_sucursal().toString();
				}
				if(ordencompra.getid_sucursal()!=null)
				{
					strValorNuevo=ordencompra.getid_sucursal().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),OrdenCompraConstantesFunciones.IDSUCURSAL,strValorActual,strValorNuevo);
			}	
			
			if(ordencompra.getIsNew()||!ordencompra.getid_modulo().equals(ordencompra.getOrdenCompraOriginal().getid_modulo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(ordencompra.getOrdenCompraOriginal().getid_modulo()!=null)
				{
					strValorActual=ordencompra.getOrdenCompraOriginal().getid_modulo().toString();
				}
				if(ordencompra.getid_modulo()!=null)
				{
					strValorNuevo=ordencompra.getid_modulo().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),OrdenCompraConstantesFunciones.IDMODULO,strValorActual,strValorNuevo);
			}	
			
			if(ordencompra.getIsNew()||!ordencompra.getid_ejercicio().equals(ordencompra.getOrdenCompraOriginal().getid_ejercicio()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(ordencompra.getOrdenCompraOriginal().getid_ejercicio()!=null)
				{
					strValorActual=ordencompra.getOrdenCompraOriginal().getid_ejercicio().toString();
				}
				if(ordencompra.getid_ejercicio()!=null)
				{
					strValorNuevo=ordencompra.getid_ejercicio().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),OrdenCompraConstantesFunciones.IDEJERCICIO,strValorActual,strValorNuevo);
			}	
			
			if(ordencompra.getIsNew()||!ordencompra.getid_periodo().equals(ordencompra.getOrdenCompraOriginal().getid_periodo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(ordencompra.getOrdenCompraOriginal().getid_periodo()!=null)
				{
					strValorActual=ordencompra.getOrdenCompraOriginal().getid_periodo().toString();
				}
				if(ordencompra.getid_periodo()!=null)
				{
					strValorNuevo=ordencompra.getid_periodo().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),OrdenCompraConstantesFunciones.IDPERIODO,strValorActual,strValorNuevo);
			}	
			
			if(ordencompra.getIsNew()||!ordencompra.getid_anio().equals(ordencompra.getOrdenCompraOriginal().getid_anio()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(ordencompra.getOrdenCompraOriginal().getid_anio()!=null)
				{
					strValorActual=ordencompra.getOrdenCompraOriginal().getid_anio().toString();
				}
				if(ordencompra.getid_anio()!=null)
				{
					strValorNuevo=ordencompra.getid_anio().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),OrdenCompraConstantesFunciones.IDANIO,strValorActual,strValorNuevo);
			}	
			
			if(ordencompra.getIsNew()||!ordencompra.getid_mes().equals(ordencompra.getOrdenCompraOriginal().getid_mes()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(ordencompra.getOrdenCompraOriginal().getid_mes()!=null)
				{
					strValorActual=ordencompra.getOrdenCompraOriginal().getid_mes().toString();
				}
				if(ordencompra.getid_mes()!=null)
				{
					strValorNuevo=ordencompra.getid_mes().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),OrdenCompraConstantesFunciones.IDMES,strValorActual,strValorNuevo);
			}	
			
			if(ordencompra.getIsNew()||!ordencompra.getid_usuario().equals(ordencompra.getOrdenCompraOriginal().getid_usuario()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(ordencompra.getOrdenCompraOriginal().getid_usuario()!=null)
				{
					strValorActual=ordencompra.getOrdenCompraOriginal().getid_usuario().toString();
				}
				if(ordencompra.getid_usuario()!=null)
				{
					strValorNuevo=ordencompra.getid_usuario().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),OrdenCompraConstantesFunciones.IDUSUARIO,strValorActual,strValorNuevo);
			}	
			
			if(ordencompra.getIsNew()||!ordencompra.getfecha_emision().equals(ordencompra.getOrdenCompraOriginal().getfecha_emision()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(ordencompra.getOrdenCompraOriginal().getfecha_emision()!=null)
				{
					strValorActual=ordencompra.getOrdenCompraOriginal().getfecha_emision().toString();
				}
				if(ordencompra.getfecha_emision()!=null)
				{
					strValorNuevo=ordencompra.getfecha_emision().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),OrdenCompraConstantesFunciones.FECHAEMISION,strValorActual,strValorNuevo);
			}	
			
			if(ordencompra.getIsNew()||!ordencompra.getfecha_entrega().equals(ordencompra.getOrdenCompraOriginal().getfecha_entrega()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(ordencompra.getOrdenCompraOriginal().getfecha_entrega()!=null)
				{
					strValorActual=ordencompra.getOrdenCompraOriginal().getfecha_entrega().toString();
				}
				if(ordencompra.getfecha_entrega()!=null)
				{
					strValorNuevo=ordencompra.getfecha_entrega().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),OrdenCompraConstantesFunciones.FECHAENTREGA,strValorActual,strValorNuevo);
			}	
			
			if(ordencompra.getIsNew()||!ordencompra.getnumero_secuencial().equals(ordencompra.getOrdenCompraOriginal().getnumero_secuencial()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(ordencompra.getOrdenCompraOriginal().getnumero_secuencial()!=null)
				{
					strValorActual=ordencompra.getOrdenCompraOriginal().getnumero_secuencial();
				}
				if(ordencompra.getnumero_secuencial()!=null)
				{
					strValorNuevo=ordencompra.getnumero_secuencial() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),OrdenCompraConstantesFunciones.NUMEROSECUENCIAL,strValorActual,strValorNuevo);
			}	
			
			if(ordencompra.getIsNew()||!ordencompra.getid_moneda().equals(ordencompra.getOrdenCompraOriginal().getid_moneda()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(ordencompra.getOrdenCompraOriginal().getid_moneda()!=null)
				{
					strValorActual=ordencompra.getOrdenCompraOriginal().getid_moneda().toString();
				}
				if(ordencompra.getid_moneda()!=null)
				{
					strValorNuevo=ordencompra.getid_moneda().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),OrdenCompraConstantesFunciones.IDMONEDA,strValorActual,strValorNuevo);
			}	
			
			if(ordencompra.getIsNew()||!ordencompra.getid_tipo_cambio().equals(ordencompra.getOrdenCompraOriginal().getid_tipo_cambio()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(ordencompra.getOrdenCompraOriginal().getid_tipo_cambio()!=null)
				{
					strValorActual=ordencompra.getOrdenCompraOriginal().getid_tipo_cambio().toString();
				}
				if(ordencompra.getid_tipo_cambio()!=null)
				{
					strValorNuevo=ordencompra.getid_tipo_cambio().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),OrdenCompraConstantesFunciones.IDTIPOCAMBIO,strValorActual,strValorNuevo);
			}	
			
			if(ordencompra.getIsNew()||!ordencompra.getid_estado_orden_compra().equals(ordencompra.getOrdenCompraOriginal().getid_estado_orden_compra()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(ordencompra.getOrdenCompraOriginal().getid_estado_orden_compra()!=null)
				{
					strValorActual=ordencompra.getOrdenCompraOriginal().getid_estado_orden_compra().toString();
				}
				if(ordencompra.getid_estado_orden_compra()!=null)
				{
					strValorNuevo=ordencompra.getid_estado_orden_compra().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),OrdenCompraConstantesFunciones.IDESTADOORDENCOMPRA,strValorActual,strValorNuevo);
			}	
			
			if(ordencompra.getIsNew()||!ordencompra.getid_cliente().equals(ordencompra.getOrdenCompraOriginal().getid_cliente()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(ordencompra.getOrdenCompraOriginal().getid_cliente()!=null)
				{
					strValorActual=ordencompra.getOrdenCompraOriginal().getid_cliente().toString();
				}
				if(ordencompra.getid_cliente()!=null)
				{
					strValorNuevo=ordencompra.getid_cliente().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),OrdenCompraConstantesFunciones.IDCLIENTE,strValorActual,strValorNuevo);
			}	
			
			if(ordencompra.getIsNew()||!ordencompra.getid_formato().equals(ordencompra.getOrdenCompraOriginal().getid_formato()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(ordencompra.getOrdenCompraOriginal().getid_formato()!=null)
				{
					strValorActual=ordencompra.getOrdenCompraOriginal().getid_formato().toString();
				}
				if(ordencompra.getid_formato()!=null)
				{
					strValorNuevo=ordencompra.getid_formato().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),OrdenCompraConstantesFunciones.IDFORMATO,strValorActual,strValorNuevo);
			}	
			
			if(ordencompra.getIsNew()||!ordencompra.getid_transportista().equals(ordencompra.getOrdenCompraOriginal().getid_transportista()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(ordencompra.getOrdenCompraOriginal().getid_transportista()!=null)
				{
					strValorActual=ordencompra.getOrdenCompraOriginal().getid_transportista().toString();
				}
				if(ordencompra.getid_transportista()!=null)
				{
					strValorNuevo=ordencompra.getid_transportista().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),OrdenCompraConstantesFunciones.IDTRANSPORTISTA,strValorActual,strValorNuevo);
			}	
			
			if(ordencompra.getIsNew()||!ordencompra.getid_empleado().equals(ordencompra.getOrdenCompraOriginal().getid_empleado()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(ordencompra.getOrdenCompraOriginal().getid_empleado()!=null)
				{
					strValorActual=ordencompra.getOrdenCompraOriginal().getid_empleado().toString();
				}
				if(ordencompra.getid_empleado()!=null)
				{
					strValorNuevo=ordencompra.getid_empleado().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),OrdenCompraConstantesFunciones.IDEMPLEADO,strValorActual,strValorNuevo);
			}	
			
			if(ordencompra.getIsNew()||!ordencompra.getdescripcion().equals(ordencompra.getOrdenCompraOriginal().getdescripcion()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(ordencompra.getOrdenCompraOriginal().getdescripcion()!=null)
				{
					strValorActual=ordencompra.getOrdenCompraOriginal().getdescripcion();
				}
				if(ordencompra.getdescripcion()!=null)
				{
					strValorNuevo=ordencompra.getdescripcion() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),OrdenCompraConstantesFunciones.DESCRIPCION,strValorActual,strValorNuevo);
			}	
			
			if(ordencompra.getIsNew()||!ordencompra.getporcentaje_descuento().equals(ordencompra.getOrdenCompraOriginal().getporcentaje_descuento()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(ordencompra.getOrdenCompraOriginal().getporcentaje_descuento()!=null)
				{
					strValorActual=ordencompra.getOrdenCompraOriginal().getporcentaje_descuento().toString();
				}
				if(ordencompra.getporcentaje_descuento()!=null)
				{
					strValorNuevo=ordencompra.getporcentaje_descuento().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),OrdenCompraConstantesFunciones.PORCENTAJEDESCUENTO,strValorActual,strValorNuevo);
			}	
			
			if(ordencompra.getIsNew()||!ordencompra.getsuman().equals(ordencompra.getOrdenCompraOriginal().getsuman()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(ordencompra.getOrdenCompraOriginal().getsuman()!=null)
				{
					strValorActual=ordencompra.getOrdenCompraOriginal().getsuman().toString();
				}
				if(ordencompra.getsuman()!=null)
				{
					strValorNuevo=ordencompra.getsuman().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),OrdenCompraConstantesFunciones.SUMAN,strValorActual,strValorNuevo);
			}	
			
			if(ordencompra.getIsNew()||!ordencompra.getice().equals(ordencompra.getOrdenCompraOriginal().getice()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(ordencompra.getOrdenCompraOriginal().getice()!=null)
				{
					strValorActual=ordencompra.getOrdenCompraOriginal().getice().toString();
				}
				if(ordencompra.getice()!=null)
				{
					strValorNuevo=ordencompra.getice().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),OrdenCompraConstantesFunciones.ICE,strValorActual,strValorNuevo);
			}	
			
			if(ordencompra.getIsNew()||!ordencompra.getvalor_descuento().equals(ordencompra.getOrdenCompraOriginal().getvalor_descuento()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(ordencompra.getOrdenCompraOriginal().getvalor_descuento()!=null)
				{
					strValorActual=ordencompra.getOrdenCompraOriginal().getvalor_descuento().toString();
				}
				if(ordencompra.getvalor_descuento()!=null)
				{
					strValorNuevo=ordencompra.getvalor_descuento().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),OrdenCompraConstantesFunciones.VALORDESCUENTO,strValorActual,strValorNuevo);
			}	
			
			if(ordencompra.getIsNew()||!ordencompra.gettotal_descuento().equals(ordencompra.getOrdenCompraOriginal().gettotal_descuento()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(ordencompra.getOrdenCompraOriginal().gettotal_descuento()!=null)
				{
					strValorActual=ordencompra.getOrdenCompraOriginal().gettotal_descuento().toString();
				}
				if(ordencompra.gettotal_descuento()!=null)
				{
					strValorNuevo=ordencompra.gettotal_descuento().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),OrdenCompraConstantesFunciones.TOTALDESCUENTO,strValorActual,strValorNuevo);
			}	
			
			if(ordencompra.getIsNew()||!ordencompra.getiva().equals(ordencompra.getOrdenCompraOriginal().getiva()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(ordencompra.getOrdenCompraOriginal().getiva()!=null)
				{
					strValorActual=ordencompra.getOrdenCompraOriginal().getiva().toString();
				}
				if(ordencompra.getiva()!=null)
				{
					strValorNuevo=ordencompra.getiva().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),OrdenCompraConstantesFunciones.IVA,strValorActual,strValorNuevo);
			}	
			
			if(ordencompra.getIsNew()||!ordencompra.getstock().equals(ordencompra.getOrdenCompraOriginal().getstock()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(ordencompra.getOrdenCompraOriginal().getstock()!=null)
				{
					strValorActual=ordencompra.getOrdenCompraOriginal().getstock().toString();
				}
				if(ordencompra.getstock()!=null)
				{
					strValorNuevo=ordencompra.getstock().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),OrdenCompraConstantesFunciones.STOCK,strValorActual,strValorNuevo);
			}	
			
			if(ordencompra.getIsNew()||!ordencompra.getsub_total().equals(ordencompra.getOrdenCompraOriginal().getsub_total()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(ordencompra.getOrdenCompraOriginal().getsub_total()!=null)
				{
					strValorActual=ordencompra.getOrdenCompraOriginal().getsub_total().toString();
				}
				if(ordencompra.getsub_total()!=null)
				{
					strValorNuevo=ordencompra.getsub_total().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),OrdenCompraConstantesFunciones.SUBTOTAL,strValorActual,strValorNuevo);
			}	
			
			if(ordencompra.getIsNew()||!ordencompra.gettotal_otro().equals(ordencompra.getOrdenCompraOriginal().gettotal_otro()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(ordencompra.getOrdenCompraOriginal().gettotal_otro()!=null)
				{
					strValorActual=ordencompra.getOrdenCompraOriginal().gettotal_otro().toString();
				}
				if(ordencompra.gettotal_otro()!=null)
				{
					strValorNuevo=ordencompra.gettotal_otro().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),OrdenCompraConstantesFunciones.TOTALOTRO,strValorActual,strValorNuevo);
			}	
			
			if(ordencompra.getIsNew()||!ordencompra.getultimo_costo().equals(ordencompra.getOrdenCompraOriginal().getultimo_costo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(ordencompra.getOrdenCompraOriginal().getultimo_costo()!=null)
				{
					strValorActual=ordencompra.getOrdenCompraOriginal().getultimo_costo().toString();
				}
				if(ordencompra.getultimo_costo()!=null)
				{
					strValorNuevo=ordencompra.getultimo_costo().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),OrdenCompraConstantesFunciones.ULTIMOCOSTO,strValorActual,strValorNuevo);
			}	
			
			if(ordencompra.getIsNew()||!ordencompra.getnumero_items().equals(ordencompra.getOrdenCompraOriginal().getnumero_items()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(ordencompra.getOrdenCompraOriginal().getnumero_items()!=null)
				{
					strValorActual=ordencompra.getOrdenCompraOriginal().getnumero_items().toString();
				}
				if(ordencompra.getnumero_items()!=null)
				{
					strValorNuevo=ordencompra.getnumero_items().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),OrdenCompraConstantesFunciones.NUMEROITEMS,strValorActual,strValorNuevo);
			}	
			
			if(ordencompra.getIsNew()||!ordencompra.getretencion().equals(ordencompra.getOrdenCompraOriginal().getretencion()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(ordencompra.getOrdenCompraOriginal().getretencion()!=null)
				{
					strValorActual=ordencompra.getOrdenCompraOriginal().getretencion().toString();
				}
				if(ordencompra.getretencion()!=null)
				{
					strValorNuevo=ordencompra.getretencion().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),OrdenCompraConstantesFunciones.RETENCION,strValorActual,strValorNuevo);
			}	
			
			if(ordencompra.getIsNew()||!ordencompra.gettotal().equals(ordencompra.getOrdenCompraOriginal().gettotal()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(ordencompra.getOrdenCompraOriginal().gettotal()!=null)
				{
					strValorActual=ordencompra.getOrdenCompraOriginal().gettotal().toString();
				}
				if(ordencompra.gettotal()!=null)
				{
					strValorNuevo=ordencompra.gettotal().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),OrdenCompraConstantesFunciones.TOTAL,strValorActual,strValorNuevo);
			}	
			
			if(ordencompra.getIsNew()||!ordencompra.getflete().equals(ordencompra.getOrdenCompraOriginal().getflete()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(ordencompra.getOrdenCompraOriginal().getflete()!=null)
				{
					strValorActual=ordencompra.getOrdenCompraOriginal().getflete().toString();
				}
				if(ordencompra.getflete()!=null)
				{
					strValorNuevo=ordencompra.getflete().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),OrdenCompraConstantesFunciones.FLETE,strValorActual,strValorNuevo);
			}	
			
			if(ordencompra.getIsNew()||!ordencompra.getimpuesto().equals(ordencompra.getOrdenCompraOriginal().getimpuesto()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(ordencompra.getOrdenCompraOriginal().getimpuesto()!=null)
				{
					strValorActual=ordencompra.getOrdenCompraOriginal().getimpuesto().toString();
				}
				if(ordencompra.getimpuesto()!=null)
				{
					strValorNuevo=ordencompra.getimpuesto().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),OrdenCompraConstantesFunciones.IMPUESTO,strValorActual,strValorNuevo);
			}	
			
			if(ordencompra.getIsNew()||!ordencompra.getid_tipo_transaccion_modulo().equals(ordencompra.getOrdenCompraOriginal().getid_tipo_transaccion_modulo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(ordencompra.getOrdenCompraOriginal().getid_tipo_transaccion_modulo()!=null)
				{
					strValorActual=ordencompra.getOrdenCompraOriginal().getid_tipo_transaccion_modulo().toString();
				}
				if(ordencompra.getid_tipo_transaccion_modulo()!=null)
				{
					strValorNuevo=ordencompra.getid_tipo_transaccion_modulo().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),OrdenCompraConstantesFunciones.IDTIPOTRANSACCIONMODULO,strValorActual,strValorNuevo);
			}	
			
			if(ordencompra.getIsNew()||!ordencompra.getid_orden_compra().equals(ordencompra.getOrdenCompraOriginal().getid_orden_compra()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(ordencompra.getOrdenCompraOriginal().getid_orden_compra()!=null)
				{
					strValorActual=ordencompra.getOrdenCompraOriginal().getid_orden_compra().toString();
				}
				if(ordencompra.getid_orden_compra()!=null)
				{
					strValorNuevo=ordencompra.getid_orden_compra().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),OrdenCompraConstantesFunciones.IDORDENCOMPRA,strValorActual,strValorNuevo);
			}	
			
			if(ordencompra.getIsNew()||!ordencompra.getid_asiento_contable().equals(ordencompra.getOrdenCompraOriginal().getid_asiento_contable()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(ordencompra.getOrdenCompraOriginal().getid_asiento_contable()!=null)
				{
					strValorActual=ordencompra.getOrdenCompraOriginal().getid_asiento_contable().toString();
				}
				if(ordencompra.getid_asiento_contable()!=null)
				{
					strValorNuevo=ordencompra.getid_asiento_contable().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),OrdenCompraConstantesFunciones.IDASIENTOCONTABLE,strValorActual,strValorNuevo);
			}	
			
			if(ordencompra.getIsNew()||!ordencompra.getnumero_comprobante().equals(ordencompra.getOrdenCompraOriginal().getnumero_comprobante()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(ordencompra.getOrdenCompraOriginal().getnumero_comprobante()!=null)
				{
					strValorActual=ordencompra.getOrdenCompraOriginal().getnumero_comprobante();
				}
				if(ordencompra.getnumero_comprobante()!=null)
				{
					strValorNuevo=ordencompra.getnumero_comprobante() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),OrdenCompraConstantesFunciones.NUMEROCOMPROBANTE,strValorActual,strValorNuevo);
			}	
			
			if(ordencompra.getIsNew()||!ordencompra.getfecha().equals(ordencompra.getOrdenCompraOriginal().getfecha()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(ordencompra.getOrdenCompraOriginal().getfecha()!=null)
				{
					strValorActual=ordencompra.getOrdenCompraOriginal().getfecha().toString();
				}
				if(ordencompra.getfecha()!=null)
				{
					strValorNuevo=ordencompra.getfecha().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),OrdenCompraConstantesFunciones.FECHA,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void saveOrdenCompraRelacionesWithConnection(OrdenCompra ordencompra,List<DetalleOrdenCompra> detalleordencompras) throws Exception {

		if(!ordencompra.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveOrdenCompraRelacionesBase(ordencompra,detalleordencompras,true);
		}
	}

	public void saveOrdenCompraRelaciones(OrdenCompra ordencompra,List<DetalleOrdenCompra> detalleordencompras)throws Exception {

		if(!ordencompra.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveOrdenCompraRelacionesBase(ordencompra,detalleordencompras,false);
		}
	}

	public void saveOrdenCompraRelacionesBase(OrdenCompra ordencompra,List<DetalleOrdenCompra> detalleordencompras,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("OrdenCompra-saveRelacionesWithConnection");}
	
			ordencompra.setDetalleOrdenCompras(detalleordencompras);

			this.setOrdenCompra(ordencompra);

			if(OrdenCompraLogicAdditional.validarSaveRelaciones(ordencompra,this)) {

				OrdenCompraLogicAdditional.updateRelacionesToSave(ordencompra,this);

				if((ordencompra.getIsNew()||ordencompra.getIsChanged())&&!ordencompra.getIsDeleted()) {
					this.saveOrdenCompra();
					this.saveOrdenCompraRelacionesDetalles(detalleordencompras);

				} else if(ordencompra.getIsDeleted()) {
					this.saveOrdenCompraRelacionesDetalles(detalleordencompras);
					this.saveOrdenCompra();
				}

				OrdenCompraLogicAdditional.updateRelacionesToSaveAfter(ordencompra,this);

			} else {
				throw new Exception("LOS DATOS SON INVALIDOS");
			}

			if(conConexion) {connexion.commit();}

		} catch(Exception e) {
			
			DetalleOrdenCompraConstantesFunciones.InicializarGeneralEntityAuxiliaresDetalleOrdenCompras(detalleordencompras,true,true);

			if(conConexion){connexion.rollback();}
			Funciones.manageException(logger,e);
			throw e;

		} finally {
			if(conConexion){this.closeNewConnexionToDeep();}
		}
	}
	
	
	private void saveOrdenCompraRelacionesDetalles(List<DetalleOrdenCompra> detalleordencompras)throws Exception {
		try {
	

			Long idOrdenCompraActual=this.getOrdenCompra().getId();

			DetalleOrdenCompraLogic detalleordencompraLogic_Desde_OrdenCompra=new DetalleOrdenCompraLogic();
			detalleordencompraLogic_Desde_OrdenCompra.setDetalleOrdenCompras(detalleordencompras);

			detalleordencompraLogic_Desde_OrdenCompra.setConnexion(this.getConnexion());
			detalleordencompraLogic_Desde_OrdenCompra.setDatosCliente(this.datosCliente);

			for(DetalleOrdenCompra detalleordencompra_Desde_OrdenCompra:detalleordencompraLogic_Desde_OrdenCompra.getDetalleOrdenCompras()) {
				detalleordencompra_Desde_OrdenCompra.setid_orden_compra(idOrdenCompraActual);
			}

			detalleordencompraLogic_Desde_OrdenCompra.saveDetalleOrdenCompras();

		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfOrdenCompra(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=OrdenCompraConstantesFunciones.getClassesForeignKeysOfOrdenCompra(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfOrdenCompra(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=OrdenCompraConstantesFunciones.getClassesRelationshipsOfOrdenCompra(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}
