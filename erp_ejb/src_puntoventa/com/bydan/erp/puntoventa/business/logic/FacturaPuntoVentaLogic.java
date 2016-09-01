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
package com.bydan.erp.puntoventa.business.logic;

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
import com.bydan.erp.puntoventa.util.*;
import com.bydan.erp.puntoventa.util.FacturaPuntoVentaConstantesFunciones;
import com.bydan.erp.puntoventa.util.FacturaPuntoVentaParameterReturnGeneral;
//import com.bydan.erp.puntoventa.util.FacturaPuntoVentaParameterGeneral;
import com.bydan.erp.puntoventa.business.entity.FacturaPuntoVenta;
import com.bydan.erp.puntoventa.business.logic.FacturaPuntoVentaLogicAdditional;
import com.bydan.erp.puntoventa.business.dataaccess.*;
import com.bydan.erp.puntoventa.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.comisiones.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.inventario.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;


import com.bydan.erp.seguridad.business.logic.*;
import com.bydan.erp.comisiones.business.logic.*;
import com.bydan.erp.cartera.business.logic.*;
import com.bydan.erp.inventario.business.logic.*;
import com.bydan.erp.contabilidad.business.logic.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.comisiones.util.*;
import com.bydan.erp.cartera.util.*;
import com.bydan.erp.inventario.util.*;
import com.bydan.erp.contabilidad.util.*;


import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.comisiones.business.dataaccess.*;
import com.bydan.erp.cartera.business.dataaccess.*;
import com.bydan.erp.inventario.business.dataaccess.*;
import com.bydan.erp.contabilidad.business.dataaccess.*;








@SuppressWarnings("unused")
public class FacturaPuntoVentaLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(FacturaPuntoVentaLogic.class);
	
	protected FacturaPuntoVentaDataAccess facturapuntoventaDataAccess; 	
	protected FacturaPuntoVenta facturapuntoventa;
	protected List<FacturaPuntoVenta> facturapuntoventas;
	protected Object facturapuntoventaObject;	
	protected List<Object> facturapuntoventasObject;
	
	public static ClassValidator<FacturaPuntoVenta> facturapuntoventaValidator = new ClassValidator<FacturaPuntoVenta>(FacturaPuntoVenta.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected FacturaPuntoVentaLogicAdditional facturapuntoventaLogicAdditional=null;
	
	public FacturaPuntoVentaLogicAdditional getFacturaPuntoVentaLogicAdditional() {
		return this.facturapuntoventaLogicAdditional;
	}
	
	public void setFacturaPuntoVentaLogicAdditional(FacturaPuntoVentaLogicAdditional facturapuntoventaLogicAdditional) {
		try {
			this.facturapuntoventaLogicAdditional=facturapuntoventaLogicAdditional;
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
	
	
	
	
	public  FacturaPuntoVentaLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.facturapuntoventaDataAccess = new FacturaPuntoVentaDataAccess();
			
			this.facturapuntoventas= new ArrayList<FacturaPuntoVenta>();
			this.facturapuntoventa= new FacturaPuntoVenta();
			
			this.facturapuntoventaObject=new Object();
			this.facturapuntoventasObject=new ArrayList<Object>();
				
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
			
			this.facturapuntoventaDataAccess.setConnexionType(this.connexionType);
			this.facturapuntoventaDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  FacturaPuntoVentaLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.facturapuntoventaDataAccess = new FacturaPuntoVentaDataAccess();
			this.facturapuntoventas= new ArrayList<FacturaPuntoVenta>();
			this.facturapuntoventa= new FacturaPuntoVenta();
			this.facturapuntoventaObject=new Object();
			this.facturapuntoventasObject=new ArrayList<Object>();
			
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
			
			this.facturapuntoventaDataAccess.setConnexionType(this.connexionType);
			this.facturapuntoventaDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public FacturaPuntoVenta getFacturaPuntoVenta() throws Exception {	
		FacturaPuntoVentaLogicAdditional.checkFacturaPuntoVentaToGet(facturapuntoventa,this.datosCliente,this.arrDatoGeneral);
		FacturaPuntoVentaLogicAdditional.updateFacturaPuntoVentaToGet(facturapuntoventa,this.arrDatoGeneral);
		
		return facturapuntoventa;
	}
		
	public void setFacturaPuntoVenta(FacturaPuntoVenta newFacturaPuntoVenta) {
		this.facturapuntoventa = newFacturaPuntoVenta;
	}
	
	public FacturaPuntoVentaDataAccess getFacturaPuntoVentaDataAccess() {
		return facturapuntoventaDataAccess;
	}
	
	public void setFacturaPuntoVentaDataAccess(FacturaPuntoVentaDataAccess newfacturapuntoventaDataAccess) {
		this.facturapuntoventaDataAccess = newfacturapuntoventaDataAccess;
	}
	
	public List<FacturaPuntoVenta> getFacturaPuntoVentas() throws Exception {		
		this.quitarFacturaPuntoVentasNulos();
		
		FacturaPuntoVentaLogicAdditional.checkFacturaPuntoVentaToGets(facturapuntoventas,this.datosCliente,this.arrDatoGeneral);
		
		for (FacturaPuntoVenta facturapuntoventaLocal: facturapuntoventas ) {
			FacturaPuntoVentaLogicAdditional.updateFacturaPuntoVentaToGet(facturapuntoventaLocal,this.arrDatoGeneral);
		}
		
		return facturapuntoventas;
	}
	
	public void setFacturaPuntoVentas(List<FacturaPuntoVenta> newFacturaPuntoVentas) {
		this.facturapuntoventas = newFacturaPuntoVentas;
	}
	
	public Object getFacturaPuntoVentaObject() {	
		this.facturapuntoventaObject=this.facturapuntoventaDataAccess.getEntityObject();
		return this.facturapuntoventaObject;
	}
		
	public void setFacturaPuntoVentaObject(Object newFacturaPuntoVentaObject) {
		this.facturapuntoventaObject = newFacturaPuntoVentaObject;
	}
	
	public List<Object> getFacturaPuntoVentasObject() {		
		this.facturapuntoventasObject=this.facturapuntoventaDataAccess.getEntitiesObject();
		return this.facturapuntoventasObject;
	}
		
	public void setFacturaPuntoVentasObject(List<Object> newFacturaPuntoVentasObject) {
		this.facturapuntoventasObject = newFacturaPuntoVentasObject;
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
		
		if(this.facturapuntoventaDataAccess!=null) {
			this.facturapuntoventaDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FacturaPuntoVenta.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			facturapuntoventaDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			facturapuntoventaDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		facturapuntoventa = new  FacturaPuntoVenta();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FacturaPuntoVenta.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			facturapuntoventa=facturapuntoventaDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.facturapuntoventa,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				FacturaPuntoVentaConstantesFunciones.refrescarForeignKeysDescripcionesFacturaPuntoVenta(this.facturapuntoventa);
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
		facturapuntoventa = new  FacturaPuntoVenta();
		  		  
        try {
			
			facturapuntoventa=facturapuntoventaDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.facturapuntoventa,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				FacturaPuntoVentaConstantesFunciones.refrescarForeignKeysDescripcionesFacturaPuntoVenta(this.facturapuntoventa);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		facturapuntoventa = new  FacturaPuntoVenta();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FacturaPuntoVenta.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			facturapuntoventa=facturapuntoventaDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.facturapuntoventa,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				FacturaPuntoVentaConstantesFunciones.refrescarForeignKeysDescripcionesFacturaPuntoVenta(this.facturapuntoventa);
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
		facturapuntoventa = new  FacturaPuntoVenta();
		  		  
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
		facturapuntoventa = new  FacturaPuntoVenta();
		  		  
        try {
			
			facturapuntoventa=facturapuntoventaDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.facturapuntoventa,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				FacturaPuntoVentaConstantesFunciones.refrescarForeignKeysDescripcionesFacturaPuntoVenta(this.facturapuntoventa);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		facturapuntoventa = new  FacturaPuntoVenta();
		  		  
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
		facturapuntoventa = new  FacturaPuntoVenta();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FacturaPuntoVenta.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =facturapuntoventaDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		facturapuntoventa = new  FacturaPuntoVenta();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=facturapuntoventaDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		facturapuntoventa = new  FacturaPuntoVenta();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FacturaPuntoVenta.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =facturapuntoventaDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		facturapuntoventa = new  FacturaPuntoVenta();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=facturapuntoventaDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		facturapuntoventa = new  FacturaPuntoVenta();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FacturaPuntoVenta.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =facturapuntoventaDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		facturapuntoventa = new  FacturaPuntoVenta();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=facturapuntoventaDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		facturapuntoventas = new  ArrayList<FacturaPuntoVenta>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FacturaPuntoVenta.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			FacturaPuntoVentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			facturapuntoventas=facturapuntoventaDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarFacturaPuntoVenta(facturapuntoventas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				FacturaPuntoVentaConstantesFunciones.refrescarForeignKeysDescripcionesFacturaPuntoVenta(this.facturapuntoventas);
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
		facturapuntoventas = new  ArrayList<FacturaPuntoVenta>();
		  		  
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
		facturapuntoventas = new  ArrayList<FacturaPuntoVenta>();
		  		  
        try {			
			FacturaPuntoVentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			facturapuntoventas=facturapuntoventaDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarFacturaPuntoVenta(facturapuntoventas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				FacturaPuntoVentaConstantesFunciones.refrescarForeignKeysDescripcionesFacturaPuntoVenta(this.facturapuntoventas);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		facturapuntoventas = new  ArrayList<FacturaPuntoVenta>();
		  		  
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
		facturapuntoventas = new  ArrayList<FacturaPuntoVenta>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FacturaPuntoVenta.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			FacturaPuntoVentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			facturapuntoventas=facturapuntoventaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarFacturaPuntoVenta(facturapuntoventas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				FacturaPuntoVentaConstantesFunciones.refrescarForeignKeysDescripcionesFacturaPuntoVenta(this.facturapuntoventas);
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
		facturapuntoventas = new  ArrayList<FacturaPuntoVenta>();
		  		  
        try {
			FacturaPuntoVentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			facturapuntoventas=facturapuntoventaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarFacturaPuntoVenta(facturapuntoventas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				FacturaPuntoVentaConstantesFunciones.refrescarForeignKeysDescripcionesFacturaPuntoVenta(this.facturapuntoventas);
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
		facturapuntoventas = new  ArrayList<FacturaPuntoVenta>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FacturaPuntoVenta.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			FacturaPuntoVentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			facturapuntoventas=facturapuntoventaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarFacturaPuntoVenta(facturapuntoventas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				FacturaPuntoVentaConstantesFunciones.refrescarForeignKeysDescripcionesFacturaPuntoVenta(this.facturapuntoventas);
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
		facturapuntoventas = new  ArrayList<FacturaPuntoVenta>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			FacturaPuntoVentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			facturapuntoventas=facturapuntoventaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarFacturaPuntoVenta(facturapuntoventas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				FacturaPuntoVentaConstantesFunciones.refrescarForeignKeysDescripcionesFacturaPuntoVenta(this.facturapuntoventas);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		facturapuntoventa = new  FacturaPuntoVenta();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FacturaPuntoVenta.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			FacturaPuntoVentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			facturapuntoventa=facturapuntoventaDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarFacturaPuntoVenta(facturapuntoventa);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				FacturaPuntoVentaConstantesFunciones.refrescarForeignKeysDescripcionesFacturaPuntoVenta(this.facturapuntoventa);
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
		facturapuntoventa = new  FacturaPuntoVenta();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			FacturaPuntoVentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			facturapuntoventa=facturapuntoventaDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarFacturaPuntoVenta(facturapuntoventa);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				FacturaPuntoVentaConstantesFunciones.refrescarForeignKeysDescripcionesFacturaPuntoVenta(this.facturapuntoventa);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		facturapuntoventas = new  ArrayList<FacturaPuntoVenta>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FacturaPuntoVenta.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			FacturaPuntoVentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			facturapuntoventas=facturapuntoventaDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarFacturaPuntoVenta(facturapuntoventas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				FacturaPuntoVentaConstantesFunciones.refrescarForeignKeysDescripcionesFacturaPuntoVenta(this.facturapuntoventas);
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
		facturapuntoventas = new  ArrayList<FacturaPuntoVenta>();
		  		  
        try {
			FacturaPuntoVentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			facturapuntoventas=facturapuntoventaDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarFacturaPuntoVenta(facturapuntoventas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				FacturaPuntoVentaConstantesFunciones.refrescarForeignKeysDescripcionesFacturaPuntoVenta(this.facturapuntoventas);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosFacturaPuntoVentasWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		facturapuntoventas = new  ArrayList<FacturaPuntoVenta>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FacturaPuntoVenta.class.getSimpleName()+"-getTodosFacturaPuntoVentasWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			FacturaPuntoVentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			facturapuntoventas=facturapuntoventaDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarFacturaPuntoVenta(facturapuntoventas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				FacturaPuntoVentaConstantesFunciones.refrescarForeignKeysDescripcionesFacturaPuntoVenta(this.facturapuntoventas);
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
	
	public  void  getTodosFacturaPuntoVentas(String sFinalQuery,Pagination pagination)throws Exception {
		facturapuntoventas = new  ArrayList<FacturaPuntoVenta>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			FacturaPuntoVentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			facturapuntoventas=facturapuntoventaDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarFacturaPuntoVenta(facturapuntoventas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				FacturaPuntoVentaConstantesFunciones.refrescarForeignKeysDescripcionesFacturaPuntoVenta(this.facturapuntoventas);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarFacturaPuntoVenta(FacturaPuntoVenta facturapuntoventa) throws Exception {
		Boolean estaValidado=false;
		
		if(facturapuntoventa.getIsNew() || facturapuntoventa.getIsChanged()) { 
			this.invalidValues = facturapuntoventaValidator.getInvalidValues(facturapuntoventa);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(facturapuntoventa);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarFacturaPuntoVenta(List<FacturaPuntoVenta> FacturaPuntoVentas) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(FacturaPuntoVenta facturapuntoventaLocal:facturapuntoventas) {				
			estaValidadoObjeto=this.validarGuardarFacturaPuntoVenta(facturapuntoventaLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarFacturaPuntoVenta(List<FacturaPuntoVenta> FacturaPuntoVentas) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarFacturaPuntoVenta(facturapuntoventas)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarFacturaPuntoVenta(FacturaPuntoVenta FacturaPuntoVenta) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarFacturaPuntoVenta(facturapuntoventa)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(FacturaPuntoVenta facturapuntoventa) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+facturapuntoventa.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=FacturaPuntoVentaConstantesFunciones.getFacturaPuntoVentaLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"facturapuntoventa","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(FacturaPuntoVentaConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(FacturaPuntoVentaConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveFacturaPuntoVentaWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FacturaPuntoVenta.class.getSimpleName()+"-saveFacturaPuntoVentaWithConnection");connexion.begin();			
			
			FacturaPuntoVentaLogicAdditional.checkFacturaPuntoVentaToSave(this.facturapuntoventa,this.datosCliente,connexion,this.arrDatoGeneral);
			
			FacturaPuntoVentaLogicAdditional.updateFacturaPuntoVentaToSave(this.facturapuntoventa,this.arrDatoGeneral);
			
			FacturaPuntoVentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.facturapuntoventa,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowFacturaPuntoVenta();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarFacturaPuntoVenta(this.facturapuntoventa)) {
				FacturaPuntoVentaDataAccess.save(this.facturapuntoventa, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.facturapuntoventa,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			FacturaPuntoVentaLogicAdditional.checkFacturaPuntoVentaToSaveAfter(this.facturapuntoventa,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowFacturaPuntoVenta();
			
			connexion.commit();			
			
			if(this.facturapuntoventa.getIsDeleted()) {
				this.facturapuntoventa=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveFacturaPuntoVenta()throws Exception {	
		try {	
			
			FacturaPuntoVentaLogicAdditional.checkFacturaPuntoVentaToSave(this.facturapuntoventa,this.datosCliente,connexion,this.arrDatoGeneral);
			
			FacturaPuntoVentaLogicAdditional.updateFacturaPuntoVentaToSave(this.facturapuntoventa,this.arrDatoGeneral);
			
			FacturaPuntoVentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.facturapuntoventa,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarFacturaPuntoVenta(this.facturapuntoventa)) {			
				FacturaPuntoVentaDataAccess.save(this.facturapuntoventa, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.facturapuntoventa,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			FacturaPuntoVentaLogicAdditional.checkFacturaPuntoVentaToSaveAfter(this.facturapuntoventa,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.facturapuntoventa.getIsDeleted()) {
				this.facturapuntoventa=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveFacturaPuntoVentasWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FacturaPuntoVenta.class.getSimpleName()+"-saveFacturaPuntoVentasWithConnection");connexion.begin();			
			
			FacturaPuntoVentaLogicAdditional.checkFacturaPuntoVentaToSaves(facturapuntoventas,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowFacturaPuntoVentas();
			
			Boolean validadoTodosFacturaPuntoVenta=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(FacturaPuntoVenta facturapuntoventaLocal:facturapuntoventas) {		
				if(facturapuntoventaLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				FacturaPuntoVentaLogicAdditional.updateFacturaPuntoVentaToSave(facturapuntoventaLocal,this.arrDatoGeneral);
	        	
				FacturaPuntoVentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),facturapuntoventaLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarFacturaPuntoVenta(facturapuntoventaLocal)) {
					FacturaPuntoVentaDataAccess.save(facturapuntoventaLocal, connexion);				
				} else {
					validadoTodosFacturaPuntoVenta=false;
				}
			}
			
			if(!validadoTodosFacturaPuntoVenta) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			FacturaPuntoVentaLogicAdditional.checkFacturaPuntoVentaToSavesAfter(facturapuntoventas,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowFacturaPuntoVentas();
			
			connexion.commit();		
			
			this.quitarFacturaPuntoVentasEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveFacturaPuntoVentas()throws Exception {				
		 try {	
			FacturaPuntoVentaLogicAdditional.checkFacturaPuntoVentaToSaves(facturapuntoventas,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosFacturaPuntoVenta=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(FacturaPuntoVenta facturapuntoventaLocal:facturapuntoventas) {				
				if(facturapuntoventaLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				FacturaPuntoVentaLogicAdditional.updateFacturaPuntoVentaToSave(facturapuntoventaLocal,this.arrDatoGeneral);
	        	
				FacturaPuntoVentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),facturapuntoventaLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarFacturaPuntoVenta(facturapuntoventaLocal)) {				
					FacturaPuntoVentaDataAccess.save(facturapuntoventaLocal, connexion);				
				} else {
					validadoTodosFacturaPuntoVenta=false;
				}
			}
			
			if(!validadoTodosFacturaPuntoVenta) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			FacturaPuntoVentaLogicAdditional.checkFacturaPuntoVentaToSavesAfter(facturapuntoventas,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarFacturaPuntoVentasEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public FacturaPuntoVentaParameterReturnGeneral procesarAccionFacturaPuntoVentas(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<FacturaPuntoVenta> facturapuntoventas,FacturaPuntoVentaParameterReturnGeneral facturapuntoventaParameterGeneral)throws Exception {
		 try {	
			FacturaPuntoVentaParameterReturnGeneral facturapuntoventaReturnGeneral=new FacturaPuntoVentaParameterReturnGeneral();
	
			FacturaPuntoVentaLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,facturapuntoventas,facturapuntoventaParameterGeneral,facturapuntoventaReturnGeneral);
			
			return facturapuntoventaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public FacturaPuntoVentaParameterReturnGeneral procesarAccionFacturaPuntoVentasWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<FacturaPuntoVenta> facturapuntoventas,FacturaPuntoVentaParameterReturnGeneral facturapuntoventaParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FacturaPuntoVenta.class.getSimpleName()+"-procesarAccionFacturaPuntoVentasWithConnection");connexion.begin();			
			
			FacturaPuntoVentaParameterReturnGeneral facturapuntoventaReturnGeneral=new FacturaPuntoVentaParameterReturnGeneral();
	
			FacturaPuntoVentaLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,facturapuntoventas,facturapuntoventaParameterGeneral,facturapuntoventaReturnGeneral);
			
			this.connexion.commit();
			
			return facturapuntoventaReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public FacturaPuntoVentaParameterReturnGeneral procesarEventosFacturaPuntoVentas(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<FacturaPuntoVenta> facturapuntoventas,FacturaPuntoVenta facturapuntoventa,FacturaPuntoVentaParameterReturnGeneral facturapuntoventaParameterGeneral,Boolean isEsNuevoFacturaPuntoVenta,ArrayList<Classe> clases)throws Exception {
		 try {	
			FacturaPuntoVentaParameterReturnGeneral facturapuntoventaReturnGeneral=new FacturaPuntoVentaParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				facturapuntoventaReturnGeneral.setConRecargarPropiedades(true);
			}
			
			FacturaPuntoVentaLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,facturapuntoventas,facturapuntoventa,facturapuntoventaParameterGeneral,facturapuntoventaReturnGeneral,isEsNuevoFacturaPuntoVenta,clases);
			
			return facturapuntoventaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public FacturaPuntoVentaParameterReturnGeneral procesarEventosFacturaPuntoVentasWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<FacturaPuntoVenta> facturapuntoventas,FacturaPuntoVenta facturapuntoventa,FacturaPuntoVentaParameterReturnGeneral facturapuntoventaParameterGeneral,Boolean isEsNuevoFacturaPuntoVenta,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FacturaPuntoVenta.class.getSimpleName()+"-procesarEventosFacturaPuntoVentasWithConnection");connexion.begin();			
			
			FacturaPuntoVentaParameterReturnGeneral facturapuntoventaReturnGeneral=new FacturaPuntoVentaParameterReturnGeneral();
	
			facturapuntoventaReturnGeneral.setFacturaPuntoVenta(facturapuntoventa);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				facturapuntoventaReturnGeneral.setConRecargarPropiedades(true);
			}
			
			FacturaPuntoVentaLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,facturapuntoventas,facturapuntoventa,facturapuntoventaParameterGeneral,facturapuntoventaReturnGeneral,isEsNuevoFacturaPuntoVenta,clases);
			
			this.connexion.commit();
			
			return facturapuntoventaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public FacturaPuntoVentaParameterReturnGeneral procesarImportacionFacturaPuntoVentasWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,FacturaPuntoVentaParameterReturnGeneral facturapuntoventaParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FacturaPuntoVenta.class.getSimpleName()+"-procesarImportacionFacturaPuntoVentasWithConnection");connexion.begin();			
			
			FacturaPuntoVentaParameterReturnGeneral facturapuntoventaReturnGeneral=new FacturaPuntoVentaParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.facturapuntoventas=new ArrayList<FacturaPuntoVenta>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.facturapuntoventa=new FacturaPuntoVenta();
				
				
				if(conColumnasBase) {this.facturapuntoventa.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.facturapuntoventa.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.facturapuntoventa.setnumero_secuencial(arrColumnas[iColumn++]);
				this.facturapuntoventa.setcodigo_cliente(arrColumnas[iColumn++]);
				this.facturapuntoventa.setnombre_cliente(arrColumnas[iColumn++]);
				this.facturapuntoventa.settarjeta_cliente(arrColumnas[iColumn++]);
				this.facturapuntoventa.setdireccion_cliente(arrColumnas[iColumn++]);
				this.facturapuntoventa.settelefono_cliente(arrColumnas[iColumn++]);
				this.facturapuntoventa.setfecha(Funciones.ConvertToDate(arrColumnas[iColumn++]));
				//this.facturapuntoventa.sethora(arrColumnas[iColumn++]);
				this.facturapuntoventa.settotal_iva(Double.parseDouble(arrColumnas[iColumn++]));
				this.facturapuntoventa.settotal_sin_iva(Double.parseDouble(arrColumnas[iColumn++]));
				this.facturapuntoventa.setiva(Double.parseDouble(arrColumnas[iColumn++]));
				this.facturapuntoventa.setdescuento(Double.parseDouble(arrColumnas[iColumn++]));
				this.facturapuntoventa.setfinanciamiento(Double.parseDouble(arrColumnas[iColumn++]));
				this.facturapuntoventa.setflete(Double.parseDouble(arrColumnas[iColumn++]));
				this.facturapuntoventa.setice(Double.parseDouble(arrColumnas[iColumn++]));
				this.facturapuntoventa.setotros(Double.parseDouble(arrColumnas[iColumn++]));
				this.facturapuntoventa.setsub_total(Double.parseDouble(arrColumnas[iColumn++]));
				this.facturapuntoventa.settotal(Double.parseDouble(arrColumnas[iColumn++]));
				
				this.facturapuntoventas.add(this.facturapuntoventa);
			}
			
			this.saveFacturaPuntoVentas();
			
			this.connexion.commit();
			
			facturapuntoventaReturnGeneral.setConRetornoEstaProcesado(true);
			facturapuntoventaReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return facturapuntoventaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarFacturaPuntoVentasEliminados() throws Exception {				
		
		List<FacturaPuntoVenta> facturapuntoventasAux= new ArrayList<FacturaPuntoVenta>();
		
		for(FacturaPuntoVenta facturapuntoventa:facturapuntoventas) {
			if(!facturapuntoventa.getIsDeleted()) {
				facturapuntoventasAux.add(facturapuntoventa);
			}
		}
		
		facturapuntoventas=facturapuntoventasAux;
	}
	
	public void quitarFacturaPuntoVentasNulos() throws Exception {				
		
		List<FacturaPuntoVenta> facturapuntoventasAux= new ArrayList<FacturaPuntoVenta>();
		
		for(FacturaPuntoVenta facturapuntoventa : this.facturapuntoventas) {
			if(facturapuntoventa==null) {
				facturapuntoventasAux.add(facturapuntoventa);
			}
		}
		
		//this.facturapuntoventas=facturapuntoventasAux;
		
		this.facturapuntoventas.removeAll(facturapuntoventasAux);
	}
	
	public void getSetVersionRowFacturaPuntoVentaWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(facturapuntoventa.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((facturapuntoventa.getIsDeleted() || (facturapuntoventa.getIsChanged()&&!facturapuntoventa.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=facturapuntoventaDataAccess.getSetVersionRowFacturaPuntoVenta(connexion,facturapuntoventa.getId());
				
				if(!facturapuntoventa.getVersionRow().equals(timestamp)) {	
					facturapuntoventa.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				facturapuntoventa.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowFacturaPuntoVenta()throws Exception {	
		
		if(facturapuntoventa.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((facturapuntoventa.getIsDeleted() || (facturapuntoventa.getIsChanged()&&!facturapuntoventa.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=facturapuntoventaDataAccess.getSetVersionRowFacturaPuntoVenta(connexion,facturapuntoventa.getId());
			
			try {							
				if(!facturapuntoventa.getVersionRow().equals(timestamp)) {	
					facturapuntoventa.setVersionRow(timestamp);
				}
				
				facturapuntoventa.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowFacturaPuntoVentasWithConnection()throws Exception {	
		if(facturapuntoventas!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(FacturaPuntoVenta facturapuntoventaAux:facturapuntoventas) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(facturapuntoventaAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(facturapuntoventaAux.getIsDeleted() || (facturapuntoventaAux.getIsChanged()&&!facturapuntoventaAux.getIsNew())) {
						
						timestamp=facturapuntoventaDataAccess.getSetVersionRowFacturaPuntoVenta(connexion,facturapuntoventaAux.getId());
						
						if(!facturapuntoventa.getVersionRow().equals(timestamp)) {	
							facturapuntoventaAux.setVersionRow(timestamp);
						}
								
						facturapuntoventaAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowFacturaPuntoVentas()throws Exception {	
		if(facturapuntoventas!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(FacturaPuntoVenta facturapuntoventaAux:facturapuntoventas) {
					if(facturapuntoventaAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(facturapuntoventaAux.getIsDeleted() || (facturapuntoventaAux.getIsChanged()&&!facturapuntoventaAux.getIsNew())) {
						
						timestamp=facturapuntoventaDataAccess.getSetVersionRowFacturaPuntoVenta(connexion,facturapuntoventaAux.getId());
						
						if(!facturapuntoventaAux.getVersionRow().equals(timestamp)) {	
							facturapuntoventaAux.setVersionRow(timestamp);
						}
						
													
						facturapuntoventaAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public FacturaPuntoVentaParameterReturnGeneral cargarCombosLoteForeignKeyFacturaPuntoVentaWithConnection(String finalQueryGlobalEmpresa,String finalQueryGlobalSucursal,String finalQueryGlobalUsuario,String finalQueryGlobalVendedor,String finalQueryGlobalCliente,String finalQueryGlobalCaja,String finalQueryGlobalTipoPrecio,String finalQueryGlobalMesa,String finalQueryGlobalFormato,String finalQueryGlobalTipoFacturaPuntoVenta,String finalQueryGlobalEstadoFacturaPuntoVenta,String finalQueryGlobalAsientoContable) throws Exception {
		FacturaPuntoVentaParameterReturnGeneral  facturapuntoventaReturnGeneral =new FacturaPuntoVentaParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FacturaPuntoVenta.class.getSimpleName()+"-cargarCombosLoteForeignKeyFacturaPuntoVentaWithConnection");connexion.begin();
			
			facturapuntoventaReturnGeneral =new FacturaPuntoVentaParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			facturapuntoventaReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Sucursal> sucursalsForeignKey=new ArrayList<Sucursal>();
			SucursalLogic sucursalLogic=new SucursalLogic();
			sucursalLogic.setConnexion(this.connexion);
			//sucursalLogic.getSucursalDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalSucursal.equals("NONE")) {
				sucursalLogic.getTodosSucursals(finalQueryGlobalSucursal,new Pagination());
				sucursalsForeignKey=sucursalLogic.getSucursals();
			}

			facturapuntoventaReturnGeneral.setsucursalsForeignKey(sucursalsForeignKey);


			List<Usuario> usuariosForeignKey=new ArrayList<Usuario>();
			UsuarioLogic usuarioLogic=new UsuarioLogic();
			usuarioLogic.setConnexion(this.connexion);
			//usuarioLogic.getUsuarioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalUsuario.equals("NONE")) {
				usuarioLogic.getTodosUsuarios(finalQueryGlobalUsuario,new Pagination());
				usuariosForeignKey=usuarioLogic.getUsuarios();
			}

			facturapuntoventaReturnGeneral.setusuariosForeignKey(usuariosForeignKey);


			List<Vendedor> vendedorsForeignKey=new ArrayList<Vendedor>();
			VendedorLogic vendedorLogic=new VendedorLogic();
			vendedorLogic.setConnexion(this.connexion);
			vendedorLogic.getVendedorDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalVendedor.equals("NONE")) {
				vendedorLogic.getTodosVendedors(finalQueryGlobalVendedor,new Pagination());
				vendedorsForeignKey=vendedorLogic.getVendedors();
			}

			facturapuntoventaReturnGeneral.setvendedorsForeignKey(vendedorsForeignKey);


			List<Cliente> clientesForeignKey=new ArrayList<Cliente>();
			ClienteLogic clienteLogic=new ClienteLogic();
			clienteLogic.setConnexion(this.connexion);
			//clienteLogic.getClienteDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCliente.equals("NONE")) {
				clienteLogic.getTodosClientes(finalQueryGlobalCliente,new Pagination());
				clientesForeignKey=clienteLogic.getClientes();
			}

			facturapuntoventaReturnGeneral.setclientesForeignKey(clientesForeignKey);


			List<Caja> cajasForeignKey=new ArrayList<Caja>();
			CajaLogic cajaLogic=new CajaLogic();
			cajaLogic.setConnexion(this.connexion);
			cajaLogic.getCajaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCaja.equals("NONE")) {
				cajaLogic.getTodosCajas(finalQueryGlobalCaja,new Pagination());
				cajasForeignKey=cajaLogic.getCajas();
			}

			facturapuntoventaReturnGeneral.setcajasForeignKey(cajasForeignKey);


			List<TipoPrecio> tipopreciosForeignKey=new ArrayList<TipoPrecio>();
			TipoPrecioLogic tipoprecioLogic=new TipoPrecioLogic();
			tipoprecioLogic.setConnexion(this.connexion);
			tipoprecioLogic.getTipoPrecioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoPrecio.equals("NONE")) {
				tipoprecioLogic.getTodosTipoPrecios(finalQueryGlobalTipoPrecio,new Pagination());
				tipopreciosForeignKey=tipoprecioLogic.getTipoPrecios();
			}

			facturapuntoventaReturnGeneral.settipopreciosForeignKey(tipopreciosForeignKey);


			List<Mesa> mesasForeignKey=new ArrayList<Mesa>();
			MesaLogic mesaLogic=new MesaLogic();
			mesaLogic.setConnexion(this.connexion);
			mesaLogic.getMesaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalMesa.equals("NONE")) {
				mesaLogic.getTodosMesas(finalQueryGlobalMesa,new Pagination());
				mesasForeignKey=mesaLogic.getMesas();
			}

			facturapuntoventaReturnGeneral.setmesasForeignKey(mesasForeignKey);


			List<Formato> formatosForeignKey=new ArrayList<Formato>();
			FormatoLogic formatoLogic=new FormatoLogic();
			formatoLogic.setConnexion(this.connexion);
			formatoLogic.getFormatoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalFormato.equals("NONE")) {
				formatoLogic.getTodosFormatos(finalQueryGlobalFormato,new Pagination());
				formatosForeignKey=formatoLogic.getFormatos();
			}

			facturapuntoventaReturnGeneral.setformatosForeignKey(formatosForeignKey);


			List<TipoFacturaPuntoVenta> tipofacturapuntoventasForeignKey=new ArrayList<TipoFacturaPuntoVenta>();
			TipoFacturaPuntoVentaLogic tipofacturapuntoventaLogic=new TipoFacturaPuntoVentaLogic();
			tipofacturapuntoventaLogic.setConnexion(this.connexion);
			tipofacturapuntoventaLogic.getTipoFacturaPuntoVentaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoFacturaPuntoVenta.equals("NONE")) {
				tipofacturapuntoventaLogic.getTodosTipoFacturaPuntoVentas(finalQueryGlobalTipoFacturaPuntoVenta,new Pagination());
				tipofacturapuntoventasForeignKey=tipofacturapuntoventaLogic.getTipoFacturaPuntoVentas();
			}

			facturapuntoventaReturnGeneral.settipofacturapuntoventasForeignKey(tipofacturapuntoventasForeignKey);


			List<EstadoFacturaPuntoVenta> estadofacturapuntoventasForeignKey=new ArrayList<EstadoFacturaPuntoVenta>();
			EstadoFacturaPuntoVentaLogic estadofacturapuntoventaLogic=new EstadoFacturaPuntoVentaLogic();
			estadofacturapuntoventaLogic.setConnexion(this.connexion);
			estadofacturapuntoventaLogic.getEstadoFacturaPuntoVentaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEstadoFacturaPuntoVenta.equals("NONE")) {
				estadofacturapuntoventaLogic.getTodosEstadoFacturaPuntoVentas(finalQueryGlobalEstadoFacturaPuntoVenta,new Pagination());
				estadofacturapuntoventasForeignKey=estadofacturapuntoventaLogic.getEstadoFacturaPuntoVentas();
			}

			facturapuntoventaReturnGeneral.setestadofacturapuntoventasForeignKey(estadofacturapuntoventasForeignKey);


			List<AsientoContable> asientocontablesForeignKey=new ArrayList<AsientoContable>();
			AsientoContableLogic asientocontableLogic=new AsientoContableLogic();
			asientocontableLogic.setConnexion(this.connexion);
			asientocontableLogic.getAsientoContableDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalAsientoContable.equals("NONE")) {
				asientocontableLogic.getTodosAsientoContables(finalQueryGlobalAsientoContable,new Pagination());
				asientocontablesForeignKey=asientocontableLogic.getAsientoContables();
			}

			facturapuntoventaReturnGeneral.setasientocontablesForeignKey(asientocontablesForeignKey);

			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
		
		return facturapuntoventaReturnGeneral;
	}
	
	public FacturaPuntoVentaParameterReturnGeneral cargarCombosLoteForeignKeyFacturaPuntoVenta(String finalQueryGlobalEmpresa,String finalQueryGlobalSucursal,String finalQueryGlobalUsuario,String finalQueryGlobalVendedor,String finalQueryGlobalCliente,String finalQueryGlobalCaja,String finalQueryGlobalTipoPrecio,String finalQueryGlobalMesa,String finalQueryGlobalFormato,String finalQueryGlobalTipoFacturaPuntoVenta,String finalQueryGlobalEstadoFacturaPuntoVenta,String finalQueryGlobalAsientoContable) throws Exception {
		FacturaPuntoVentaParameterReturnGeneral  facturapuntoventaReturnGeneral =new FacturaPuntoVentaParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {						
			facturapuntoventaReturnGeneral =new FacturaPuntoVentaParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			facturapuntoventaReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Sucursal> sucursalsForeignKey=new ArrayList<Sucursal>();
			SucursalLogic sucursalLogic=new SucursalLogic();
			sucursalLogic.setConnexion(this.connexion);
			//sucursalLogic.getSucursalDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalSucursal.equals("NONE")) {
				sucursalLogic.getTodosSucursals(finalQueryGlobalSucursal,new Pagination());
				sucursalsForeignKey=sucursalLogic.getSucursals();
			}

			facturapuntoventaReturnGeneral.setsucursalsForeignKey(sucursalsForeignKey);


			List<Usuario> usuariosForeignKey=new ArrayList<Usuario>();
			UsuarioLogic usuarioLogic=new UsuarioLogic();
			usuarioLogic.setConnexion(this.connexion);
			//usuarioLogic.getUsuarioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalUsuario.equals("NONE")) {
				usuarioLogic.getTodosUsuarios(finalQueryGlobalUsuario,new Pagination());
				usuariosForeignKey=usuarioLogic.getUsuarios();
			}

			facturapuntoventaReturnGeneral.setusuariosForeignKey(usuariosForeignKey);


			List<Vendedor> vendedorsForeignKey=new ArrayList<Vendedor>();
			VendedorLogic vendedorLogic=new VendedorLogic();
			vendedorLogic.setConnexion(this.connexion);
			vendedorLogic.getVendedorDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalVendedor.equals("NONE")) {
				vendedorLogic.getTodosVendedors(finalQueryGlobalVendedor,new Pagination());
				vendedorsForeignKey=vendedorLogic.getVendedors();
			}

			facturapuntoventaReturnGeneral.setvendedorsForeignKey(vendedorsForeignKey);


			List<Cliente> clientesForeignKey=new ArrayList<Cliente>();
			ClienteLogic clienteLogic=new ClienteLogic();
			clienteLogic.setConnexion(this.connexion);
			//clienteLogic.getClienteDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCliente.equals("NONE")) {
				clienteLogic.getTodosClientes(finalQueryGlobalCliente,new Pagination());
				clientesForeignKey=clienteLogic.getClientes();
			}

			facturapuntoventaReturnGeneral.setclientesForeignKey(clientesForeignKey);


			List<Caja> cajasForeignKey=new ArrayList<Caja>();
			CajaLogic cajaLogic=new CajaLogic();
			cajaLogic.setConnexion(this.connexion);
			cajaLogic.getCajaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCaja.equals("NONE")) {
				cajaLogic.getTodosCajas(finalQueryGlobalCaja,new Pagination());
				cajasForeignKey=cajaLogic.getCajas();
			}

			facturapuntoventaReturnGeneral.setcajasForeignKey(cajasForeignKey);


			List<TipoPrecio> tipopreciosForeignKey=new ArrayList<TipoPrecio>();
			TipoPrecioLogic tipoprecioLogic=new TipoPrecioLogic();
			tipoprecioLogic.setConnexion(this.connexion);
			tipoprecioLogic.getTipoPrecioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoPrecio.equals("NONE")) {
				tipoprecioLogic.getTodosTipoPrecios(finalQueryGlobalTipoPrecio,new Pagination());
				tipopreciosForeignKey=tipoprecioLogic.getTipoPrecios();
			}

			facturapuntoventaReturnGeneral.settipopreciosForeignKey(tipopreciosForeignKey);


			List<Mesa> mesasForeignKey=new ArrayList<Mesa>();
			MesaLogic mesaLogic=new MesaLogic();
			mesaLogic.setConnexion(this.connexion);
			mesaLogic.getMesaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalMesa.equals("NONE")) {
				mesaLogic.getTodosMesas(finalQueryGlobalMesa,new Pagination());
				mesasForeignKey=mesaLogic.getMesas();
			}

			facturapuntoventaReturnGeneral.setmesasForeignKey(mesasForeignKey);


			List<Formato> formatosForeignKey=new ArrayList<Formato>();
			FormatoLogic formatoLogic=new FormatoLogic();
			formatoLogic.setConnexion(this.connexion);
			formatoLogic.getFormatoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalFormato.equals("NONE")) {
				formatoLogic.getTodosFormatos(finalQueryGlobalFormato,new Pagination());
				formatosForeignKey=formatoLogic.getFormatos();
			}

			facturapuntoventaReturnGeneral.setformatosForeignKey(formatosForeignKey);


			List<TipoFacturaPuntoVenta> tipofacturapuntoventasForeignKey=new ArrayList<TipoFacturaPuntoVenta>();
			TipoFacturaPuntoVentaLogic tipofacturapuntoventaLogic=new TipoFacturaPuntoVentaLogic();
			tipofacturapuntoventaLogic.setConnexion(this.connexion);
			tipofacturapuntoventaLogic.getTipoFacturaPuntoVentaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoFacturaPuntoVenta.equals("NONE")) {
				tipofacturapuntoventaLogic.getTodosTipoFacturaPuntoVentas(finalQueryGlobalTipoFacturaPuntoVenta,new Pagination());
				tipofacturapuntoventasForeignKey=tipofacturapuntoventaLogic.getTipoFacturaPuntoVentas();
			}

			facturapuntoventaReturnGeneral.settipofacturapuntoventasForeignKey(tipofacturapuntoventasForeignKey);


			List<EstadoFacturaPuntoVenta> estadofacturapuntoventasForeignKey=new ArrayList<EstadoFacturaPuntoVenta>();
			EstadoFacturaPuntoVentaLogic estadofacturapuntoventaLogic=new EstadoFacturaPuntoVentaLogic();
			estadofacturapuntoventaLogic.setConnexion(this.connexion);
			estadofacturapuntoventaLogic.getEstadoFacturaPuntoVentaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEstadoFacturaPuntoVenta.equals("NONE")) {
				estadofacturapuntoventaLogic.getTodosEstadoFacturaPuntoVentas(finalQueryGlobalEstadoFacturaPuntoVenta,new Pagination());
				estadofacturapuntoventasForeignKey=estadofacturapuntoventaLogic.getEstadoFacturaPuntoVentas();
			}

			facturapuntoventaReturnGeneral.setestadofacturapuntoventasForeignKey(estadofacturapuntoventasForeignKey);


			List<AsientoContable> asientocontablesForeignKey=new ArrayList<AsientoContable>();
			AsientoContableLogic asientocontableLogic=new AsientoContableLogic();
			asientocontableLogic.setConnexion(this.connexion);
			asientocontableLogic.getAsientoContableDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalAsientoContable.equals("NONE")) {
				asientocontableLogic.getTodosAsientoContables(finalQueryGlobalAsientoContable,new Pagination());
				asientocontablesForeignKey=asientocontableLogic.getAsientoContables();
			}

			facturapuntoventaReturnGeneral.setasientocontablesForeignKey(asientocontablesForeignKey);
						
			
		} catch(Exception e) {			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			
		}
		
		return facturapuntoventaReturnGeneral;
	}
	
	public void cargarRelacionesLoteForeignKeyFacturaPuntoVentaWithConnection() throws Exception {
		ArrayList<Classe> classes=new ArrayList<Classe>();		
		
		
			FormaPagoPuntoVentaLogic formapagopuntoventaLogic=new FormaPagoPuntoVentaLogic();
			DetalleFacturaPuntoVentaLogic detallefacturapuntoventaLogic=new DetalleFacturaPuntoVentaLogic();
		
		try {
			
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FacturaPuntoVenta.class.getSimpleName()+"-cargarRelacionesLoteForeignKeyFacturaPuntoVentaWithConnection");connexion.begin();
			
			
			classes.add(new Classe(FormaPagoPuntoVenta.class));
			classes.add(new Classe(DetalleFacturaPuntoVenta.class));
											
			

			formapagopuntoventaLogic.setConnexion(this.getConnexion());
			formapagopuntoventaLogic.setDatosCliente(this.datosCliente);
			formapagopuntoventaLogic.setIsConRefrescarForeignKeys(true);

			detallefacturapuntoventaLogic.setConnexion(this.getConnexion());
			detallefacturapuntoventaLogic.setDatosCliente(this.datosCliente);
			detallefacturapuntoventaLogic.setIsConRefrescarForeignKeys(true);
			
			this.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
			
			for(FacturaPuntoVenta facturapuntoventa:this.facturapuntoventas) {
				

				classes=new ArrayList<Classe>();
				classes=FormaPagoPuntoVentaConstantesFunciones.getClassesForeignKeysOfFormaPagoPuntoVenta(new ArrayList<Classe>(),DeepLoadType.NONE);

				formapagopuntoventaLogic.setFormaPagoPuntoVentas(facturapuntoventa.formapagopuntoventas);
				formapagopuntoventaLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");

				classes=new ArrayList<Classe>();
				classes=DetalleFacturaPuntoVentaConstantesFunciones.getClassesForeignKeysOfDetalleFacturaPuntoVenta(new ArrayList<Classe>(),DeepLoadType.NONE);

				detallefacturapuntoventaLogic.setDetalleFacturaPuntoVentas(facturapuntoventa.detallefacturapuntoventas);
				detallefacturapuntoventaLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
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
	
	public void deepLoad(FacturaPuntoVenta facturapuntoventa,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			FacturaPuntoVentaLogicAdditional.updateFacturaPuntoVentaToGet(facturapuntoventa,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		facturapuntoventa.setEmpresa(facturapuntoventaDataAccess.getEmpresa(connexion,facturapuntoventa));
		facturapuntoventa.setSucursal(facturapuntoventaDataAccess.getSucursal(connexion,facturapuntoventa));
		facturapuntoventa.setUsuario(facturapuntoventaDataAccess.getUsuario(connexion,facturapuntoventa));
		facturapuntoventa.setVendedor(facturapuntoventaDataAccess.getVendedor(connexion,facturapuntoventa));
		facturapuntoventa.setCliente(facturapuntoventaDataAccess.getCliente(connexion,facturapuntoventa));
		facturapuntoventa.setCaja(facturapuntoventaDataAccess.getCaja(connexion,facturapuntoventa));
		facturapuntoventa.setTipoPrecio(facturapuntoventaDataAccess.getTipoPrecio(connexion,facturapuntoventa));
		facturapuntoventa.setMesa(facturapuntoventaDataAccess.getMesa(connexion,facturapuntoventa));
		facturapuntoventa.setFormato(facturapuntoventaDataAccess.getFormato(connexion,facturapuntoventa));
		facturapuntoventa.setTipoFacturaPuntoVenta(facturapuntoventaDataAccess.getTipoFacturaPuntoVenta(connexion,facturapuntoventa));
		facturapuntoventa.setEstadoFacturaPuntoVenta(facturapuntoventaDataAccess.getEstadoFacturaPuntoVenta(connexion,facturapuntoventa));
		facturapuntoventa.setAsientoContable(facturapuntoventaDataAccess.getAsientoContable(connexion,facturapuntoventa));
		facturapuntoventa.setFormaPagoPuntoVentas(facturapuntoventaDataAccess.getFormaPagoPuntoVentas(connexion,facturapuntoventa));
		facturapuntoventa.setDetalleFacturaPuntoVentas(facturapuntoventaDataAccess.getDetalleFacturaPuntoVentas(connexion,facturapuntoventa));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				facturapuntoventa.setEmpresa(facturapuntoventaDataAccess.getEmpresa(connexion,facturapuntoventa));
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				facturapuntoventa.setSucursal(facturapuntoventaDataAccess.getSucursal(connexion,facturapuntoventa));
				continue;
			}

			if(clas.clas.equals(Usuario.class)) {
				facturapuntoventa.setUsuario(facturapuntoventaDataAccess.getUsuario(connexion,facturapuntoventa));
				continue;
			}

			if(clas.clas.equals(Vendedor.class)) {
				facturapuntoventa.setVendedor(facturapuntoventaDataAccess.getVendedor(connexion,facturapuntoventa));
				continue;
			}

			if(clas.clas.equals(Cliente.class)) {
				facturapuntoventa.setCliente(facturapuntoventaDataAccess.getCliente(connexion,facturapuntoventa));
				continue;
			}

			if(clas.clas.equals(Caja.class)) {
				facturapuntoventa.setCaja(facturapuntoventaDataAccess.getCaja(connexion,facturapuntoventa));
				continue;
			}

			if(clas.clas.equals(TipoPrecio.class)) {
				facturapuntoventa.setTipoPrecio(facturapuntoventaDataAccess.getTipoPrecio(connexion,facturapuntoventa));
				continue;
			}

			if(clas.clas.equals(Mesa.class)) {
				facturapuntoventa.setMesa(facturapuntoventaDataAccess.getMesa(connexion,facturapuntoventa));
				continue;
			}

			if(clas.clas.equals(Formato.class)) {
				facturapuntoventa.setFormato(facturapuntoventaDataAccess.getFormato(connexion,facturapuntoventa));
				continue;
			}

			if(clas.clas.equals(TipoFacturaPuntoVenta.class)) {
				facturapuntoventa.setTipoFacturaPuntoVenta(facturapuntoventaDataAccess.getTipoFacturaPuntoVenta(connexion,facturapuntoventa));
				continue;
			}

			if(clas.clas.equals(EstadoFacturaPuntoVenta.class)) {
				facturapuntoventa.setEstadoFacturaPuntoVenta(facturapuntoventaDataAccess.getEstadoFacturaPuntoVenta(connexion,facturapuntoventa));
				continue;
			}

			if(clas.clas.equals(AsientoContable.class)) {
				facturapuntoventa.setAsientoContable(facturapuntoventaDataAccess.getAsientoContable(connexion,facturapuntoventa));
				continue;
			}

			if(clas.clas.equals(FormaPagoPuntoVenta.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				facturapuntoventa.setFormaPagoPuntoVentas(facturapuntoventaDataAccess.getFormaPagoPuntoVentas(connexion,facturapuntoventa));

				if(this.isConDeep) {
					FormaPagoPuntoVentaLogic formapagopuntoventaLogic= new FormaPagoPuntoVentaLogic(this.connexion);
					formapagopuntoventaLogic.setFormaPagoPuntoVentas(facturapuntoventa.getFormaPagoPuntoVentas());
					ArrayList<Classe> classesLocal=FormaPagoPuntoVentaConstantesFunciones.getClassesForeignKeysOfFormaPagoPuntoVenta(new ArrayList<Classe>(),DeepLoadType.NONE);
					formapagopuntoventaLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					FormaPagoPuntoVentaConstantesFunciones.refrescarForeignKeysDescripcionesFormaPagoPuntoVenta(formapagopuntoventaLogic.getFormaPagoPuntoVentas());
					facturapuntoventa.setFormaPagoPuntoVentas(formapagopuntoventaLogic.getFormaPagoPuntoVentas());
				}

				continue;
			}

			if(clas.clas.equals(DetalleFacturaPuntoVenta.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				facturapuntoventa.setDetalleFacturaPuntoVentas(facturapuntoventaDataAccess.getDetalleFacturaPuntoVentas(connexion,facturapuntoventa));

				if(this.isConDeep) {
					DetalleFacturaPuntoVentaLogic detallefacturapuntoventaLogic= new DetalleFacturaPuntoVentaLogic(this.connexion);
					detallefacturapuntoventaLogic.setDetalleFacturaPuntoVentas(facturapuntoventa.getDetalleFacturaPuntoVentas());
					ArrayList<Classe> classesLocal=DetalleFacturaPuntoVentaConstantesFunciones.getClassesForeignKeysOfDetalleFacturaPuntoVenta(new ArrayList<Classe>(),DeepLoadType.NONE);
					detallefacturapuntoventaLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					DetalleFacturaPuntoVentaConstantesFunciones.refrescarForeignKeysDescripcionesDetalleFacturaPuntoVenta(detallefacturapuntoventaLogic.getDetalleFacturaPuntoVentas());
					facturapuntoventa.setDetalleFacturaPuntoVentas(detallefacturapuntoventaLogic.getDetalleFacturaPuntoVentas());
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
			facturapuntoventa.setEmpresa(facturapuntoventaDataAccess.getEmpresa(connexion,facturapuntoventa));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			facturapuntoventa.setSucursal(facturapuntoventaDataAccess.getSucursal(connexion,facturapuntoventa));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Usuario.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			facturapuntoventa.setUsuario(facturapuntoventaDataAccess.getUsuario(connexion,facturapuntoventa));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Vendedor.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			facturapuntoventa.setVendedor(facturapuntoventaDataAccess.getVendedor(connexion,facturapuntoventa));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Cliente.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			facturapuntoventa.setCliente(facturapuntoventaDataAccess.getCliente(connexion,facturapuntoventa));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Caja.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			facturapuntoventa.setCaja(facturapuntoventaDataAccess.getCaja(connexion,facturapuntoventa));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(TipoPrecio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			facturapuntoventa.setTipoPrecio(facturapuntoventaDataAccess.getTipoPrecio(connexion,facturapuntoventa));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Mesa.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			facturapuntoventa.setMesa(facturapuntoventaDataAccess.getMesa(connexion,facturapuntoventa));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Formato.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			facturapuntoventa.setFormato(facturapuntoventaDataAccess.getFormato(connexion,facturapuntoventa));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(TipoFacturaPuntoVenta.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			facturapuntoventa.setTipoFacturaPuntoVenta(facturapuntoventaDataAccess.getTipoFacturaPuntoVenta(connexion,facturapuntoventa));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(EstadoFacturaPuntoVenta.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			facturapuntoventa.setEstadoFacturaPuntoVenta(facturapuntoventaDataAccess.getEstadoFacturaPuntoVenta(connexion,facturapuntoventa));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(AsientoContable.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			facturapuntoventa.setAsientoContable(facturapuntoventaDataAccess.getAsientoContable(connexion,facturapuntoventa));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(FormaPagoPuntoVenta.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(FormaPagoPuntoVenta.class));
			facturapuntoventa.setFormaPagoPuntoVentas(facturapuntoventaDataAccess.getFormaPagoPuntoVentas(connexion,facturapuntoventa));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(DetalleFacturaPuntoVenta.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(DetalleFacturaPuntoVenta.class));
			facturapuntoventa.setDetalleFacturaPuntoVentas(facturapuntoventaDataAccess.getDetalleFacturaPuntoVentas(connexion,facturapuntoventa));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		facturapuntoventa.setEmpresa(facturapuntoventaDataAccess.getEmpresa(connexion,facturapuntoventa));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(facturapuntoventa.getEmpresa(),isDeep,deepLoadType,clases);
				
		facturapuntoventa.setSucursal(facturapuntoventaDataAccess.getSucursal(connexion,facturapuntoventa));
		SucursalLogic sucursalLogic= new SucursalLogic(connexion);
		sucursalLogic.deepLoad(facturapuntoventa.getSucursal(),isDeep,deepLoadType,clases);
				
		facturapuntoventa.setUsuario(facturapuntoventaDataAccess.getUsuario(connexion,facturapuntoventa));
		UsuarioLogic usuarioLogic= new UsuarioLogic(connexion);
		usuarioLogic.deepLoad(facturapuntoventa.getUsuario(),isDeep,deepLoadType,clases);
				
		facturapuntoventa.setVendedor(facturapuntoventaDataAccess.getVendedor(connexion,facturapuntoventa));
		VendedorLogic vendedorLogic= new VendedorLogic(connexion);
		vendedorLogic.deepLoad(facturapuntoventa.getVendedor(),isDeep,deepLoadType,clases);
				
		facturapuntoventa.setCliente(facturapuntoventaDataAccess.getCliente(connexion,facturapuntoventa));
		ClienteLogic clienteLogic= new ClienteLogic(connexion);
		clienteLogic.deepLoad(facturapuntoventa.getCliente(),isDeep,deepLoadType,clases);
				
		facturapuntoventa.setCaja(facturapuntoventaDataAccess.getCaja(connexion,facturapuntoventa));
		CajaLogic cajaLogic= new CajaLogic(connexion);
		cajaLogic.deepLoad(facturapuntoventa.getCaja(),isDeep,deepLoadType,clases);
				
		facturapuntoventa.setTipoPrecio(facturapuntoventaDataAccess.getTipoPrecio(connexion,facturapuntoventa));
		TipoPrecioLogic tipoprecioLogic= new TipoPrecioLogic(connexion);
		tipoprecioLogic.deepLoad(facturapuntoventa.getTipoPrecio(),isDeep,deepLoadType,clases);
				
		facturapuntoventa.setMesa(facturapuntoventaDataAccess.getMesa(connexion,facturapuntoventa));
		MesaLogic mesaLogic= new MesaLogic(connexion);
		mesaLogic.deepLoad(facturapuntoventa.getMesa(),isDeep,deepLoadType,clases);
				
		facturapuntoventa.setFormato(facturapuntoventaDataAccess.getFormato(connexion,facturapuntoventa));
		FormatoLogic formatoLogic= new FormatoLogic(connexion);
		formatoLogic.deepLoad(facturapuntoventa.getFormato(),isDeep,deepLoadType,clases);
				
		facturapuntoventa.setTipoFacturaPuntoVenta(facturapuntoventaDataAccess.getTipoFacturaPuntoVenta(connexion,facturapuntoventa));
		TipoFacturaPuntoVentaLogic tipofacturapuntoventaLogic= new TipoFacturaPuntoVentaLogic(connexion);
		tipofacturapuntoventaLogic.deepLoad(facturapuntoventa.getTipoFacturaPuntoVenta(),isDeep,deepLoadType,clases);
				
		facturapuntoventa.setEstadoFacturaPuntoVenta(facturapuntoventaDataAccess.getEstadoFacturaPuntoVenta(connexion,facturapuntoventa));
		EstadoFacturaPuntoVentaLogic estadofacturapuntoventaLogic= new EstadoFacturaPuntoVentaLogic(connexion);
		estadofacturapuntoventaLogic.deepLoad(facturapuntoventa.getEstadoFacturaPuntoVenta(),isDeep,deepLoadType,clases);
				
		facturapuntoventa.setAsientoContable(facturapuntoventaDataAccess.getAsientoContable(connexion,facturapuntoventa));
		AsientoContableLogic asientocontableLogic= new AsientoContableLogic(connexion);
		asientocontableLogic.deepLoad(facturapuntoventa.getAsientoContable(),isDeep,deepLoadType,clases);
				

		facturapuntoventa.setFormaPagoPuntoVentas(facturapuntoventaDataAccess.getFormaPagoPuntoVentas(connexion,facturapuntoventa));

		for(FormaPagoPuntoVenta formapagopuntoventa:facturapuntoventa.getFormaPagoPuntoVentas()) {
			FormaPagoPuntoVentaLogic formapagopuntoventaLogic= new FormaPagoPuntoVentaLogic(connexion);
			formapagopuntoventaLogic.deepLoad(formapagopuntoventa,isDeep,deepLoadType,clases);
		}

		facturapuntoventa.setDetalleFacturaPuntoVentas(facturapuntoventaDataAccess.getDetalleFacturaPuntoVentas(connexion,facturapuntoventa));

		for(DetalleFacturaPuntoVenta detallefacturapuntoventa:facturapuntoventa.getDetalleFacturaPuntoVentas()) {
			DetalleFacturaPuntoVentaLogic detallefacturapuntoventaLogic= new DetalleFacturaPuntoVentaLogic(connexion);
			detallefacturapuntoventaLogic.deepLoad(detallefacturapuntoventa,isDeep,deepLoadType,clases);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				facturapuntoventa.setEmpresa(facturapuntoventaDataAccess.getEmpresa(connexion,facturapuntoventa));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(facturapuntoventa.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				facturapuntoventa.setSucursal(facturapuntoventaDataAccess.getSucursal(connexion,facturapuntoventa));
				SucursalLogic sucursalLogic= new SucursalLogic(connexion);
				sucursalLogic.deepLoad(facturapuntoventa.getSucursal(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Usuario.class)) {
				facturapuntoventa.setUsuario(facturapuntoventaDataAccess.getUsuario(connexion,facturapuntoventa));
				UsuarioLogic usuarioLogic= new UsuarioLogic(connexion);
				usuarioLogic.deepLoad(facturapuntoventa.getUsuario(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Vendedor.class)) {
				facturapuntoventa.setVendedor(facturapuntoventaDataAccess.getVendedor(connexion,facturapuntoventa));
				VendedorLogic vendedorLogic= new VendedorLogic(connexion);
				vendedorLogic.deepLoad(facturapuntoventa.getVendedor(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Cliente.class)) {
				facturapuntoventa.setCliente(facturapuntoventaDataAccess.getCliente(connexion,facturapuntoventa));
				ClienteLogic clienteLogic= new ClienteLogic(connexion);
				clienteLogic.deepLoad(facturapuntoventa.getCliente(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Caja.class)) {
				facturapuntoventa.setCaja(facturapuntoventaDataAccess.getCaja(connexion,facturapuntoventa));
				CajaLogic cajaLogic= new CajaLogic(connexion);
				cajaLogic.deepLoad(facturapuntoventa.getCaja(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoPrecio.class)) {
				facturapuntoventa.setTipoPrecio(facturapuntoventaDataAccess.getTipoPrecio(connexion,facturapuntoventa));
				TipoPrecioLogic tipoprecioLogic= new TipoPrecioLogic(connexion);
				tipoprecioLogic.deepLoad(facturapuntoventa.getTipoPrecio(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Mesa.class)) {
				facturapuntoventa.setMesa(facturapuntoventaDataAccess.getMesa(connexion,facturapuntoventa));
				MesaLogic mesaLogic= new MesaLogic(connexion);
				mesaLogic.deepLoad(facturapuntoventa.getMesa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Formato.class)) {
				facturapuntoventa.setFormato(facturapuntoventaDataAccess.getFormato(connexion,facturapuntoventa));
				FormatoLogic formatoLogic= new FormatoLogic(connexion);
				formatoLogic.deepLoad(facturapuntoventa.getFormato(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoFacturaPuntoVenta.class)) {
				facturapuntoventa.setTipoFacturaPuntoVenta(facturapuntoventaDataAccess.getTipoFacturaPuntoVenta(connexion,facturapuntoventa));
				TipoFacturaPuntoVentaLogic tipofacturapuntoventaLogic= new TipoFacturaPuntoVentaLogic(connexion);
				tipofacturapuntoventaLogic.deepLoad(facturapuntoventa.getTipoFacturaPuntoVenta(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(EstadoFacturaPuntoVenta.class)) {
				facturapuntoventa.setEstadoFacturaPuntoVenta(facturapuntoventaDataAccess.getEstadoFacturaPuntoVenta(connexion,facturapuntoventa));
				EstadoFacturaPuntoVentaLogic estadofacturapuntoventaLogic= new EstadoFacturaPuntoVentaLogic(connexion);
				estadofacturapuntoventaLogic.deepLoad(facturapuntoventa.getEstadoFacturaPuntoVenta(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(AsientoContable.class)) {
				facturapuntoventa.setAsientoContable(facturapuntoventaDataAccess.getAsientoContable(connexion,facturapuntoventa));
				AsientoContableLogic asientocontableLogic= new AsientoContableLogic(connexion);
				asientocontableLogic.deepLoad(facturapuntoventa.getAsientoContable(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(FormaPagoPuntoVenta.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				facturapuntoventa.setFormaPagoPuntoVentas(facturapuntoventaDataAccess.getFormaPagoPuntoVentas(connexion,facturapuntoventa));

				for(FormaPagoPuntoVenta formapagopuntoventa:facturapuntoventa.getFormaPagoPuntoVentas()) {
					FormaPagoPuntoVentaLogic formapagopuntoventaLogic= new FormaPagoPuntoVentaLogic(connexion);
					formapagopuntoventaLogic.deepLoad(formapagopuntoventa,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(DetalleFacturaPuntoVenta.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				facturapuntoventa.setDetalleFacturaPuntoVentas(facturapuntoventaDataAccess.getDetalleFacturaPuntoVentas(connexion,facturapuntoventa));

				for(DetalleFacturaPuntoVenta detallefacturapuntoventa:facturapuntoventa.getDetalleFacturaPuntoVentas()) {
					DetalleFacturaPuntoVentaLogic detallefacturapuntoventaLogic= new DetalleFacturaPuntoVentaLogic(connexion);
					detallefacturapuntoventaLogic.deepLoad(detallefacturapuntoventa,isDeep,deepLoadType,clases);
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
			facturapuntoventa.setEmpresa(facturapuntoventaDataAccess.getEmpresa(connexion,facturapuntoventa));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(facturapuntoventa.getEmpresa(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			facturapuntoventa.setSucursal(facturapuntoventaDataAccess.getSucursal(connexion,facturapuntoventa));
			SucursalLogic sucursalLogic= new SucursalLogic(connexion);
			sucursalLogic.deepLoad(facturapuntoventa.getSucursal(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Usuario.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			facturapuntoventa.setUsuario(facturapuntoventaDataAccess.getUsuario(connexion,facturapuntoventa));
			UsuarioLogic usuarioLogic= new UsuarioLogic(connexion);
			usuarioLogic.deepLoad(facturapuntoventa.getUsuario(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Vendedor.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			facturapuntoventa.setVendedor(facturapuntoventaDataAccess.getVendedor(connexion,facturapuntoventa));
			VendedorLogic vendedorLogic= new VendedorLogic(connexion);
			vendedorLogic.deepLoad(facturapuntoventa.getVendedor(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Cliente.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			facturapuntoventa.setCliente(facturapuntoventaDataAccess.getCliente(connexion,facturapuntoventa));
			ClienteLogic clienteLogic= new ClienteLogic(connexion);
			clienteLogic.deepLoad(facturapuntoventa.getCliente(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Caja.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			facturapuntoventa.setCaja(facturapuntoventaDataAccess.getCaja(connexion,facturapuntoventa));
			CajaLogic cajaLogic= new CajaLogic(connexion);
			cajaLogic.deepLoad(facturapuntoventa.getCaja(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(TipoPrecio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			facturapuntoventa.setTipoPrecio(facturapuntoventaDataAccess.getTipoPrecio(connexion,facturapuntoventa));
			TipoPrecioLogic tipoprecioLogic= new TipoPrecioLogic(connexion);
			tipoprecioLogic.deepLoad(facturapuntoventa.getTipoPrecio(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Mesa.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			facturapuntoventa.setMesa(facturapuntoventaDataAccess.getMesa(connexion,facturapuntoventa));
			MesaLogic mesaLogic= new MesaLogic(connexion);
			mesaLogic.deepLoad(facturapuntoventa.getMesa(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Formato.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			facturapuntoventa.setFormato(facturapuntoventaDataAccess.getFormato(connexion,facturapuntoventa));
			FormatoLogic formatoLogic= new FormatoLogic(connexion);
			formatoLogic.deepLoad(facturapuntoventa.getFormato(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(TipoFacturaPuntoVenta.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			facturapuntoventa.setTipoFacturaPuntoVenta(facturapuntoventaDataAccess.getTipoFacturaPuntoVenta(connexion,facturapuntoventa));
			TipoFacturaPuntoVentaLogic tipofacturapuntoventaLogic= new TipoFacturaPuntoVentaLogic(connexion);
			tipofacturapuntoventaLogic.deepLoad(facturapuntoventa.getTipoFacturaPuntoVenta(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(EstadoFacturaPuntoVenta.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			facturapuntoventa.setEstadoFacturaPuntoVenta(facturapuntoventaDataAccess.getEstadoFacturaPuntoVenta(connexion,facturapuntoventa));
			EstadoFacturaPuntoVentaLogic estadofacturapuntoventaLogic= new EstadoFacturaPuntoVentaLogic(connexion);
			estadofacturapuntoventaLogic.deepLoad(facturapuntoventa.getEstadoFacturaPuntoVenta(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(AsientoContable.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			facturapuntoventa.setAsientoContable(facturapuntoventaDataAccess.getAsientoContable(connexion,facturapuntoventa));
			AsientoContableLogic asientocontableLogic= new AsientoContableLogic(connexion);
			asientocontableLogic.deepLoad(facturapuntoventa.getAsientoContable(),isDeep,deepLoadType,clases);
				
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(FormaPagoPuntoVenta.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(FormaPagoPuntoVenta.class));
			facturapuntoventa.setFormaPagoPuntoVentas(facturapuntoventaDataAccess.getFormaPagoPuntoVentas(connexion,facturapuntoventa));

			for(FormaPagoPuntoVenta formapagopuntoventa:facturapuntoventa.getFormaPagoPuntoVentas()) {
				FormaPagoPuntoVentaLogic formapagopuntoventaLogic= new FormaPagoPuntoVentaLogic(connexion);
				formapagopuntoventaLogic.deepLoad(formapagopuntoventa,isDeep,deepLoadType,clases);
			}
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(DetalleFacturaPuntoVenta.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(DetalleFacturaPuntoVenta.class));
			facturapuntoventa.setDetalleFacturaPuntoVentas(facturapuntoventaDataAccess.getDetalleFacturaPuntoVentas(connexion,facturapuntoventa));

			for(DetalleFacturaPuntoVenta detallefacturapuntoventa:facturapuntoventa.getDetalleFacturaPuntoVentas()) {
				DetalleFacturaPuntoVentaLogic detallefacturapuntoventaLogic= new DetalleFacturaPuntoVentaLogic(connexion);
				detallefacturapuntoventaLogic.deepLoad(detallefacturapuntoventa,isDeep,deepLoadType,clases);
			}
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(FacturaPuntoVenta facturapuntoventa,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			FacturaPuntoVentaLogicAdditional.updateFacturaPuntoVentaToSave(facturapuntoventa,this.arrDatoGeneral);
			
FacturaPuntoVentaDataAccess.save(facturapuntoventa, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(facturapuntoventa.getEmpresa(),connexion);

		SucursalDataAccess.save(facturapuntoventa.getSucursal(),connexion);

		UsuarioDataAccess.save(facturapuntoventa.getUsuario(),connexion);

		VendedorDataAccess.save(facturapuntoventa.getVendedor(),connexion);

		ClienteDataAccess.save(facturapuntoventa.getCliente(),connexion);

		CajaDataAccess.save(facturapuntoventa.getCaja(),connexion);

		TipoPrecioDataAccess.save(facturapuntoventa.getTipoPrecio(),connexion);

		MesaDataAccess.save(facturapuntoventa.getMesa(),connexion);

		FormatoDataAccess.save(facturapuntoventa.getFormato(),connexion);

		TipoFacturaPuntoVentaDataAccess.save(facturapuntoventa.getTipoFacturaPuntoVenta(),connexion);

		EstadoFacturaPuntoVentaDataAccess.save(facturapuntoventa.getEstadoFacturaPuntoVenta(),connexion);

		AsientoContableDataAccess.save(facturapuntoventa.getAsientoContable(),connexion);

		for(FormaPagoPuntoVenta formapagopuntoventa:facturapuntoventa.getFormaPagoPuntoVentas()) {
			formapagopuntoventa.setid_factura_punto_venta(facturapuntoventa.getId());
			FormaPagoPuntoVentaDataAccess.save(formapagopuntoventa,connexion);
		}

		for(DetalleFacturaPuntoVenta detallefacturapuntoventa:facturapuntoventa.getDetalleFacturaPuntoVentas()) {
			detallefacturapuntoventa.setid_factura_punto_venta(facturapuntoventa.getId());
			DetalleFacturaPuntoVentaDataAccess.save(detallefacturapuntoventa,connexion);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(facturapuntoventa.getEmpresa(),connexion);
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				SucursalDataAccess.save(facturapuntoventa.getSucursal(),connexion);
				continue;
			}

			if(clas.clas.equals(Usuario.class)) {
				UsuarioDataAccess.save(facturapuntoventa.getUsuario(),connexion);
				continue;
			}

			if(clas.clas.equals(Vendedor.class)) {
				VendedorDataAccess.save(facturapuntoventa.getVendedor(),connexion);
				continue;
			}

			if(clas.clas.equals(Cliente.class)) {
				ClienteDataAccess.save(facturapuntoventa.getCliente(),connexion);
				continue;
			}

			if(clas.clas.equals(Caja.class)) {
				CajaDataAccess.save(facturapuntoventa.getCaja(),connexion);
				continue;
			}

			if(clas.clas.equals(TipoPrecio.class)) {
				TipoPrecioDataAccess.save(facturapuntoventa.getTipoPrecio(),connexion);
				continue;
			}

			if(clas.clas.equals(Mesa.class)) {
				MesaDataAccess.save(facturapuntoventa.getMesa(),connexion);
				continue;
			}

			if(clas.clas.equals(Formato.class)) {
				FormatoDataAccess.save(facturapuntoventa.getFormato(),connexion);
				continue;
			}

			if(clas.clas.equals(TipoFacturaPuntoVenta.class)) {
				TipoFacturaPuntoVentaDataAccess.save(facturapuntoventa.getTipoFacturaPuntoVenta(),connexion);
				continue;
			}

			if(clas.clas.equals(EstadoFacturaPuntoVenta.class)) {
				EstadoFacturaPuntoVentaDataAccess.save(facturapuntoventa.getEstadoFacturaPuntoVenta(),connexion);
				continue;
			}

			if(clas.clas.equals(AsientoContable.class)) {
				AsientoContableDataAccess.save(facturapuntoventa.getAsientoContable(),connexion);
				continue;
			}


			if(clas.clas.equals(FormaPagoPuntoVenta.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(FormaPagoPuntoVenta formapagopuntoventa:facturapuntoventa.getFormaPagoPuntoVentas()) {
					formapagopuntoventa.setid_factura_punto_venta(facturapuntoventa.getId());
					FormaPagoPuntoVentaDataAccess.save(formapagopuntoventa,connexion);
				}
				continue;
			}

			if(clas.clas.equals(DetalleFacturaPuntoVenta.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(DetalleFacturaPuntoVenta detallefacturapuntoventa:facturapuntoventa.getDetalleFacturaPuntoVentas()) {
					detallefacturapuntoventa.setid_factura_punto_venta(facturapuntoventa.getId());
					DetalleFacturaPuntoVentaDataAccess.save(detallefacturapuntoventa,connexion);
				}
				continue;
			}
		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(facturapuntoventa.getEmpresa(),connexion);
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(facturapuntoventa.getEmpresa(),isDeep,deepLoadType,clases);
				

		SucursalDataAccess.save(facturapuntoventa.getSucursal(),connexion);
		SucursalLogic sucursalLogic= new SucursalLogic(connexion);
		sucursalLogic.deepLoad(facturapuntoventa.getSucursal(),isDeep,deepLoadType,clases);
				

		UsuarioDataAccess.save(facturapuntoventa.getUsuario(),connexion);
		UsuarioLogic usuarioLogic= new UsuarioLogic(connexion);
		usuarioLogic.deepLoad(facturapuntoventa.getUsuario(),isDeep,deepLoadType,clases);
				

		VendedorDataAccess.save(facturapuntoventa.getVendedor(),connexion);
		VendedorLogic vendedorLogic= new VendedorLogic(connexion);
		vendedorLogic.deepLoad(facturapuntoventa.getVendedor(),isDeep,deepLoadType,clases);
				

		ClienteDataAccess.save(facturapuntoventa.getCliente(),connexion);
		ClienteLogic clienteLogic= new ClienteLogic(connexion);
		clienteLogic.deepLoad(facturapuntoventa.getCliente(),isDeep,deepLoadType,clases);
				

		CajaDataAccess.save(facturapuntoventa.getCaja(),connexion);
		CajaLogic cajaLogic= new CajaLogic(connexion);
		cajaLogic.deepLoad(facturapuntoventa.getCaja(),isDeep,deepLoadType,clases);
				

		TipoPrecioDataAccess.save(facturapuntoventa.getTipoPrecio(),connexion);
		TipoPrecioLogic tipoprecioLogic= new TipoPrecioLogic(connexion);
		tipoprecioLogic.deepLoad(facturapuntoventa.getTipoPrecio(),isDeep,deepLoadType,clases);
				

		MesaDataAccess.save(facturapuntoventa.getMesa(),connexion);
		MesaLogic mesaLogic= new MesaLogic(connexion);
		mesaLogic.deepLoad(facturapuntoventa.getMesa(),isDeep,deepLoadType,clases);
				

		FormatoDataAccess.save(facturapuntoventa.getFormato(),connexion);
		FormatoLogic formatoLogic= new FormatoLogic(connexion);
		formatoLogic.deepLoad(facturapuntoventa.getFormato(),isDeep,deepLoadType,clases);
				

		TipoFacturaPuntoVentaDataAccess.save(facturapuntoventa.getTipoFacturaPuntoVenta(),connexion);
		TipoFacturaPuntoVentaLogic tipofacturapuntoventaLogic= new TipoFacturaPuntoVentaLogic(connexion);
		tipofacturapuntoventaLogic.deepLoad(facturapuntoventa.getTipoFacturaPuntoVenta(),isDeep,deepLoadType,clases);
				

		EstadoFacturaPuntoVentaDataAccess.save(facturapuntoventa.getEstadoFacturaPuntoVenta(),connexion);
		EstadoFacturaPuntoVentaLogic estadofacturapuntoventaLogic= new EstadoFacturaPuntoVentaLogic(connexion);
		estadofacturapuntoventaLogic.deepLoad(facturapuntoventa.getEstadoFacturaPuntoVenta(),isDeep,deepLoadType,clases);
				

		AsientoContableDataAccess.save(facturapuntoventa.getAsientoContable(),connexion);
		AsientoContableLogic asientocontableLogic= new AsientoContableLogic(connexion);
		asientocontableLogic.deepLoad(facturapuntoventa.getAsientoContable(),isDeep,deepLoadType,clases);
				

		for(FormaPagoPuntoVenta formapagopuntoventa:facturapuntoventa.getFormaPagoPuntoVentas()) {
			FormaPagoPuntoVentaLogic formapagopuntoventaLogic= new FormaPagoPuntoVentaLogic(connexion);
			formapagopuntoventa.setid_factura_punto_venta(facturapuntoventa.getId());
			FormaPagoPuntoVentaDataAccess.save(formapagopuntoventa,connexion);
			formapagopuntoventaLogic.deepSave(formapagopuntoventa,isDeep,deepLoadType,clases);
		}

		for(DetalleFacturaPuntoVenta detallefacturapuntoventa:facturapuntoventa.getDetalleFacturaPuntoVentas()) {
			DetalleFacturaPuntoVentaLogic detallefacturapuntoventaLogic= new DetalleFacturaPuntoVentaLogic(connexion);
			detallefacturapuntoventa.setid_factura_punto_venta(facturapuntoventa.getId());
			DetalleFacturaPuntoVentaDataAccess.save(detallefacturapuntoventa,connexion);
			detallefacturapuntoventaLogic.deepSave(detallefacturapuntoventa,isDeep,deepLoadType,clases);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(facturapuntoventa.getEmpresa(),connexion);
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepSave(facturapuntoventa.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				SucursalDataAccess.save(facturapuntoventa.getSucursal(),connexion);
				SucursalLogic sucursalLogic= new SucursalLogic(connexion);
				sucursalLogic.deepSave(facturapuntoventa.getSucursal(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Usuario.class)) {
				UsuarioDataAccess.save(facturapuntoventa.getUsuario(),connexion);
				UsuarioLogic usuarioLogic= new UsuarioLogic(connexion);
				usuarioLogic.deepSave(facturapuntoventa.getUsuario(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Vendedor.class)) {
				VendedorDataAccess.save(facturapuntoventa.getVendedor(),connexion);
				VendedorLogic vendedorLogic= new VendedorLogic(connexion);
				vendedorLogic.deepSave(facturapuntoventa.getVendedor(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Cliente.class)) {
				ClienteDataAccess.save(facturapuntoventa.getCliente(),connexion);
				ClienteLogic clienteLogic= new ClienteLogic(connexion);
				clienteLogic.deepSave(facturapuntoventa.getCliente(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Caja.class)) {
				CajaDataAccess.save(facturapuntoventa.getCaja(),connexion);
				CajaLogic cajaLogic= new CajaLogic(connexion);
				cajaLogic.deepSave(facturapuntoventa.getCaja(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoPrecio.class)) {
				TipoPrecioDataAccess.save(facturapuntoventa.getTipoPrecio(),connexion);
				TipoPrecioLogic tipoprecioLogic= new TipoPrecioLogic(connexion);
				tipoprecioLogic.deepSave(facturapuntoventa.getTipoPrecio(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Mesa.class)) {
				MesaDataAccess.save(facturapuntoventa.getMesa(),connexion);
				MesaLogic mesaLogic= new MesaLogic(connexion);
				mesaLogic.deepSave(facturapuntoventa.getMesa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Formato.class)) {
				FormatoDataAccess.save(facturapuntoventa.getFormato(),connexion);
				FormatoLogic formatoLogic= new FormatoLogic(connexion);
				formatoLogic.deepSave(facturapuntoventa.getFormato(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoFacturaPuntoVenta.class)) {
				TipoFacturaPuntoVentaDataAccess.save(facturapuntoventa.getTipoFacturaPuntoVenta(),connexion);
				TipoFacturaPuntoVentaLogic tipofacturapuntoventaLogic= new TipoFacturaPuntoVentaLogic(connexion);
				tipofacturapuntoventaLogic.deepSave(facturapuntoventa.getTipoFacturaPuntoVenta(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(EstadoFacturaPuntoVenta.class)) {
				EstadoFacturaPuntoVentaDataAccess.save(facturapuntoventa.getEstadoFacturaPuntoVenta(),connexion);
				EstadoFacturaPuntoVentaLogic estadofacturapuntoventaLogic= new EstadoFacturaPuntoVentaLogic(connexion);
				estadofacturapuntoventaLogic.deepSave(facturapuntoventa.getEstadoFacturaPuntoVenta(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(AsientoContable.class)) {
				AsientoContableDataAccess.save(facturapuntoventa.getAsientoContable(),connexion);
				AsientoContableLogic asientocontableLogic= new AsientoContableLogic(connexion);
				asientocontableLogic.deepSave(facturapuntoventa.getAsientoContable(),isDeep,deepLoadType,clases);				
				continue;
			}


			if(clas.clas.equals(FormaPagoPuntoVenta.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(FormaPagoPuntoVenta formapagopuntoventa:facturapuntoventa.getFormaPagoPuntoVentas()) {
					FormaPagoPuntoVentaLogic formapagopuntoventaLogic= new FormaPagoPuntoVentaLogic(connexion);
					formapagopuntoventa.setid_factura_punto_venta(facturapuntoventa.getId());
					FormaPagoPuntoVentaDataAccess.save(formapagopuntoventa,connexion);
					formapagopuntoventaLogic.deepSave(formapagopuntoventa,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(DetalleFacturaPuntoVenta.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(DetalleFacturaPuntoVenta detallefacturapuntoventa:facturapuntoventa.getDetalleFacturaPuntoVentas()) {
					DetalleFacturaPuntoVentaLogic detallefacturapuntoventaLogic= new DetalleFacturaPuntoVentaLogic(connexion);
					detallefacturapuntoventa.setid_factura_punto_venta(facturapuntoventa.getId());
					DetalleFacturaPuntoVentaDataAccess.save(detallefacturapuntoventa,connexion);
					detallefacturapuntoventaLogic.deepSave(detallefacturapuntoventa,isDeep,deepLoadType,clases);
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
			this.getNewConnexionToDeep(FacturaPuntoVenta.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(facturapuntoventa,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				FacturaPuntoVentaConstantesFunciones.refrescarForeignKeysDescripcionesFacturaPuntoVenta(facturapuntoventa);
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
			this.deepLoad(this.facturapuntoventa,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				FacturaPuntoVentaConstantesFunciones.refrescarForeignKeysDescripcionesFacturaPuntoVenta(this.facturapuntoventa);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(FacturaPuntoVenta.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(facturapuntoventas!=null) {
				for(FacturaPuntoVenta facturapuntoventa:facturapuntoventas) {
					this.deepLoad(facturapuntoventa,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					FacturaPuntoVentaConstantesFunciones.refrescarForeignKeysDescripcionesFacturaPuntoVenta(facturapuntoventas);
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
			if(facturapuntoventas!=null) {
				for(FacturaPuntoVenta facturapuntoventa:facturapuntoventas) {
					this.deepLoad(facturapuntoventa,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					FacturaPuntoVentaConstantesFunciones.refrescarForeignKeysDescripcionesFacturaPuntoVenta(facturapuntoventas);
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
			this.getNewConnexionToDeep(FacturaPuntoVenta.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(facturapuntoventa,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(FacturaPuntoVenta.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(facturapuntoventas!=null) {
				for(FacturaPuntoVenta facturapuntoventa:facturapuntoventas) {
					this.deepSave(facturapuntoventa,isDeep,deepLoadType,clases);
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
			if(facturapuntoventas!=null) {
				for(FacturaPuntoVenta facturapuntoventa:facturapuntoventas) {
					this.deepSave(facturapuntoventa,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getFacturaPuntoVentasFK_IdAsientoContableWithConnection(String sFinalQuery,Pagination pagination,Long id_asiento_contable)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FacturaPuntoVenta.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidAsientoContable= new ParameterSelectionGeneral();
			parameterSelectionGeneralidAsientoContable.setParameterSelectionGeneralEqual(ParameterType.LONG,id_asiento_contable,FacturaPuntoVentaConstantesFunciones.IDASIENTOCONTABLE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidAsientoContable);

			FacturaPuntoVentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdAsientoContable","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			facturapuntoventas=facturapuntoventaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				FacturaPuntoVentaConstantesFunciones.refrescarForeignKeysDescripcionesFacturaPuntoVenta(this.facturapuntoventas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getFacturaPuntoVentasFK_IdAsientoContable(String sFinalQuery,Pagination pagination,Long id_asiento_contable)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidAsientoContable= new ParameterSelectionGeneral();
			parameterSelectionGeneralidAsientoContable.setParameterSelectionGeneralEqual(ParameterType.LONG,id_asiento_contable,FacturaPuntoVentaConstantesFunciones.IDASIENTOCONTABLE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidAsientoContable);

			FacturaPuntoVentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdAsientoContable","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			facturapuntoventas=facturapuntoventaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				FacturaPuntoVentaConstantesFunciones.refrescarForeignKeysDescripcionesFacturaPuntoVenta(this.facturapuntoventas);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getFacturaPuntoVentasFK_IdCajaWithConnection(String sFinalQuery,Pagination pagination,Long id_caja)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FacturaPuntoVenta.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCaja= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCaja.setParameterSelectionGeneralEqual(ParameterType.LONG,id_caja,FacturaPuntoVentaConstantesFunciones.IDCAJA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCaja);

			FacturaPuntoVentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCaja","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			facturapuntoventas=facturapuntoventaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				FacturaPuntoVentaConstantesFunciones.refrescarForeignKeysDescripcionesFacturaPuntoVenta(this.facturapuntoventas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getFacturaPuntoVentasFK_IdCaja(String sFinalQuery,Pagination pagination,Long id_caja)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCaja= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCaja.setParameterSelectionGeneralEqual(ParameterType.LONG,id_caja,FacturaPuntoVentaConstantesFunciones.IDCAJA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCaja);

			FacturaPuntoVentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCaja","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			facturapuntoventas=facturapuntoventaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				FacturaPuntoVentaConstantesFunciones.refrescarForeignKeysDescripcionesFacturaPuntoVenta(this.facturapuntoventas);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getFacturaPuntoVentasFK_IdClienteWithConnection(String sFinalQuery,Pagination pagination,Long id_cliente)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FacturaPuntoVenta.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCliente= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCliente.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cliente,FacturaPuntoVentaConstantesFunciones.IDCLIENTE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCliente);

			FacturaPuntoVentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCliente","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			facturapuntoventas=facturapuntoventaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				FacturaPuntoVentaConstantesFunciones.refrescarForeignKeysDescripcionesFacturaPuntoVenta(this.facturapuntoventas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getFacturaPuntoVentasFK_IdCliente(String sFinalQuery,Pagination pagination,Long id_cliente)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCliente= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCliente.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cliente,FacturaPuntoVentaConstantesFunciones.IDCLIENTE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCliente);

			FacturaPuntoVentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCliente","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			facturapuntoventas=facturapuntoventaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				FacturaPuntoVentaConstantesFunciones.refrescarForeignKeysDescripcionesFacturaPuntoVenta(this.facturapuntoventas);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getFacturaPuntoVentasFK_IdEmpresaWithConnection(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FacturaPuntoVenta.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,FacturaPuntoVentaConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			FacturaPuntoVentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			facturapuntoventas=facturapuntoventaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				FacturaPuntoVentaConstantesFunciones.refrescarForeignKeysDescripcionesFacturaPuntoVenta(this.facturapuntoventas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getFacturaPuntoVentasFK_IdEmpresa(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,FacturaPuntoVentaConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			FacturaPuntoVentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			facturapuntoventas=facturapuntoventaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				FacturaPuntoVentaConstantesFunciones.refrescarForeignKeysDescripcionesFacturaPuntoVenta(this.facturapuntoventas);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getFacturaPuntoVentasFK_IdEstadoFacturaPuntoVentaWithConnection(String sFinalQuery,Pagination pagination,Long id_estado_factura_punto_venta)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FacturaPuntoVenta.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEstadoFacturaPuntoVenta= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEstadoFacturaPuntoVenta.setParameterSelectionGeneralEqual(ParameterType.LONG,id_estado_factura_punto_venta,FacturaPuntoVentaConstantesFunciones.IDESTADOFACTURAPUNTOVENTA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEstadoFacturaPuntoVenta);

			FacturaPuntoVentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEstadoFacturaPuntoVenta","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			facturapuntoventas=facturapuntoventaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				FacturaPuntoVentaConstantesFunciones.refrescarForeignKeysDescripcionesFacturaPuntoVenta(this.facturapuntoventas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getFacturaPuntoVentasFK_IdEstadoFacturaPuntoVenta(String sFinalQuery,Pagination pagination,Long id_estado_factura_punto_venta)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEstadoFacturaPuntoVenta= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEstadoFacturaPuntoVenta.setParameterSelectionGeneralEqual(ParameterType.LONG,id_estado_factura_punto_venta,FacturaPuntoVentaConstantesFunciones.IDESTADOFACTURAPUNTOVENTA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEstadoFacturaPuntoVenta);

			FacturaPuntoVentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEstadoFacturaPuntoVenta","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			facturapuntoventas=facturapuntoventaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				FacturaPuntoVentaConstantesFunciones.refrescarForeignKeysDescripcionesFacturaPuntoVenta(this.facturapuntoventas);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getFacturaPuntoVentasFK_IdFormatoWithConnection(String sFinalQuery,Pagination pagination,Long id_formato)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FacturaPuntoVenta.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidFormato= new ParameterSelectionGeneral();
			parameterSelectionGeneralidFormato.setParameterSelectionGeneralEqual(ParameterType.LONG,id_formato,FacturaPuntoVentaConstantesFunciones.IDFORMATO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidFormato);

			FacturaPuntoVentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdFormato","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			facturapuntoventas=facturapuntoventaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				FacturaPuntoVentaConstantesFunciones.refrescarForeignKeysDescripcionesFacturaPuntoVenta(this.facturapuntoventas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getFacturaPuntoVentasFK_IdFormato(String sFinalQuery,Pagination pagination,Long id_formato)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidFormato= new ParameterSelectionGeneral();
			parameterSelectionGeneralidFormato.setParameterSelectionGeneralEqual(ParameterType.LONG,id_formato,FacturaPuntoVentaConstantesFunciones.IDFORMATO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidFormato);

			FacturaPuntoVentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdFormato","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			facturapuntoventas=facturapuntoventaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				FacturaPuntoVentaConstantesFunciones.refrescarForeignKeysDescripcionesFacturaPuntoVenta(this.facturapuntoventas);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getFacturaPuntoVentasFK_IdMesaWithConnection(String sFinalQuery,Pagination pagination,Long id_mesa)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FacturaPuntoVenta.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidMesa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidMesa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_mesa,FacturaPuntoVentaConstantesFunciones.IDMESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidMesa);

			FacturaPuntoVentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdMesa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			facturapuntoventas=facturapuntoventaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				FacturaPuntoVentaConstantesFunciones.refrescarForeignKeysDescripcionesFacturaPuntoVenta(this.facturapuntoventas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getFacturaPuntoVentasFK_IdMesa(String sFinalQuery,Pagination pagination,Long id_mesa)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidMesa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidMesa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_mesa,FacturaPuntoVentaConstantesFunciones.IDMESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidMesa);

			FacturaPuntoVentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdMesa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			facturapuntoventas=facturapuntoventaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				FacturaPuntoVentaConstantesFunciones.refrescarForeignKeysDescripcionesFacturaPuntoVenta(this.facturapuntoventas);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getFacturaPuntoVentasFK_IdSucursalWithConnection(String sFinalQuery,Pagination pagination,Long id_sucursal)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FacturaPuntoVenta.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidSucursal= new ParameterSelectionGeneral();
			parameterSelectionGeneralidSucursal.setParameterSelectionGeneralEqual(ParameterType.LONG,id_sucursal,FacturaPuntoVentaConstantesFunciones.IDSUCURSAL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidSucursal);

			FacturaPuntoVentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdSucursal","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			facturapuntoventas=facturapuntoventaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				FacturaPuntoVentaConstantesFunciones.refrescarForeignKeysDescripcionesFacturaPuntoVenta(this.facturapuntoventas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getFacturaPuntoVentasFK_IdSucursal(String sFinalQuery,Pagination pagination,Long id_sucursal)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidSucursal= new ParameterSelectionGeneral();
			parameterSelectionGeneralidSucursal.setParameterSelectionGeneralEqual(ParameterType.LONG,id_sucursal,FacturaPuntoVentaConstantesFunciones.IDSUCURSAL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidSucursal);

			FacturaPuntoVentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdSucursal","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			facturapuntoventas=facturapuntoventaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				FacturaPuntoVentaConstantesFunciones.refrescarForeignKeysDescripcionesFacturaPuntoVenta(this.facturapuntoventas);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getFacturaPuntoVentasFK_IdTipoFacturaPuntoVentaWithConnection(String sFinalQuery,Pagination pagination,Long id_tipo_factura_punto_venta)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FacturaPuntoVenta.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoFacturaPuntoVenta= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoFacturaPuntoVenta.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_factura_punto_venta,FacturaPuntoVentaConstantesFunciones.IDTIPOFACTURAPUNTOVENTA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoFacturaPuntoVenta);

			FacturaPuntoVentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoFacturaPuntoVenta","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			facturapuntoventas=facturapuntoventaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				FacturaPuntoVentaConstantesFunciones.refrescarForeignKeysDescripcionesFacturaPuntoVenta(this.facturapuntoventas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getFacturaPuntoVentasFK_IdTipoFacturaPuntoVenta(String sFinalQuery,Pagination pagination,Long id_tipo_factura_punto_venta)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoFacturaPuntoVenta= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoFacturaPuntoVenta.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_factura_punto_venta,FacturaPuntoVentaConstantesFunciones.IDTIPOFACTURAPUNTOVENTA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoFacturaPuntoVenta);

			FacturaPuntoVentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoFacturaPuntoVenta","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			facturapuntoventas=facturapuntoventaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				FacturaPuntoVentaConstantesFunciones.refrescarForeignKeysDescripcionesFacturaPuntoVenta(this.facturapuntoventas);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getFacturaPuntoVentasFK_IdTipoPrecioWithConnection(String sFinalQuery,Pagination pagination,Long id_tipo_precio)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FacturaPuntoVenta.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoPrecio= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoPrecio.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_precio,FacturaPuntoVentaConstantesFunciones.IDTIPOPRECIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoPrecio);

			FacturaPuntoVentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoPrecio","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			facturapuntoventas=facturapuntoventaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				FacturaPuntoVentaConstantesFunciones.refrescarForeignKeysDescripcionesFacturaPuntoVenta(this.facturapuntoventas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getFacturaPuntoVentasFK_IdTipoPrecio(String sFinalQuery,Pagination pagination,Long id_tipo_precio)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoPrecio= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoPrecio.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_precio,FacturaPuntoVentaConstantesFunciones.IDTIPOPRECIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoPrecio);

			FacturaPuntoVentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoPrecio","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			facturapuntoventas=facturapuntoventaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				FacturaPuntoVentaConstantesFunciones.refrescarForeignKeysDescripcionesFacturaPuntoVenta(this.facturapuntoventas);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getFacturaPuntoVentasFK_IdUsuarioWithConnection(String sFinalQuery,Pagination pagination,Long id_usuario)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FacturaPuntoVenta.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidUsuario= new ParameterSelectionGeneral();
			parameterSelectionGeneralidUsuario.setParameterSelectionGeneralEqual(ParameterType.LONG,id_usuario,FacturaPuntoVentaConstantesFunciones.IDUSUARIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidUsuario);

			FacturaPuntoVentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdUsuario","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			facturapuntoventas=facturapuntoventaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				FacturaPuntoVentaConstantesFunciones.refrescarForeignKeysDescripcionesFacturaPuntoVenta(this.facturapuntoventas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getFacturaPuntoVentasFK_IdUsuario(String sFinalQuery,Pagination pagination,Long id_usuario)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidUsuario= new ParameterSelectionGeneral();
			parameterSelectionGeneralidUsuario.setParameterSelectionGeneralEqual(ParameterType.LONG,id_usuario,FacturaPuntoVentaConstantesFunciones.IDUSUARIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidUsuario);

			FacturaPuntoVentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdUsuario","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			facturapuntoventas=facturapuntoventaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				FacturaPuntoVentaConstantesFunciones.refrescarForeignKeysDescripcionesFacturaPuntoVenta(this.facturapuntoventas);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getFacturaPuntoVentasFK_IdVendedorWithConnection(String sFinalQuery,Pagination pagination,Long id_vendedor)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FacturaPuntoVenta.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidVendedor= new ParameterSelectionGeneral();
			parameterSelectionGeneralidVendedor.setParameterSelectionGeneralEqual(ParameterType.LONG,id_vendedor,FacturaPuntoVentaConstantesFunciones.IDVENDEDOR,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidVendedor);

			FacturaPuntoVentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdVendedor","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			facturapuntoventas=facturapuntoventaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				FacturaPuntoVentaConstantesFunciones.refrescarForeignKeysDescripcionesFacturaPuntoVenta(this.facturapuntoventas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getFacturaPuntoVentasFK_IdVendedor(String sFinalQuery,Pagination pagination,Long id_vendedor)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidVendedor= new ParameterSelectionGeneral();
			parameterSelectionGeneralidVendedor.setParameterSelectionGeneralEqual(ParameterType.LONG,id_vendedor,FacturaPuntoVentaConstantesFunciones.IDVENDEDOR,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidVendedor);

			FacturaPuntoVentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdVendedor","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			facturapuntoventas=facturapuntoventaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				FacturaPuntoVentaConstantesFunciones.refrescarForeignKeysDescripcionesFacturaPuntoVenta(this.facturapuntoventas);
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
			if(FacturaPuntoVentaConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,FacturaPuntoVentaDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,FacturaPuntoVenta facturapuntoventa,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(FacturaPuntoVentaConstantesFunciones.ISCONAUDITORIA) {
				if(facturapuntoventa.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,FacturaPuntoVentaDataAccess.TABLENAME, facturapuntoventa.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(FacturaPuntoVentaConstantesFunciones.ISCONAUDITORIADETALLE) {
						////FacturaPuntoVentaLogic.registrarAuditoriaDetallesFacturaPuntoVenta(connexion,facturapuntoventa,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(facturapuntoventa.getIsDeleted()) {
					/*if(!facturapuntoventa.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,FacturaPuntoVentaDataAccess.TABLENAME, facturapuntoventa.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////FacturaPuntoVentaLogic.registrarAuditoriaDetallesFacturaPuntoVenta(connexion,facturapuntoventa,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,FacturaPuntoVentaDataAccess.TABLENAME, facturapuntoventa.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(facturapuntoventa.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,FacturaPuntoVentaDataAccess.TABLENAME, facturapuntoventa.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(FacturaPuntoVentaConstantesFunciones.ISCONAUDITORIADETALLE) {
						////FacturaPuntoVentaLogic.registrarAuditoriaDetallesFacturaPuntoVenta(connexion,facturapuntoventa,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesFacturaPuntoVenta(Connexion connexion,FacturaPuntoVenta facturapuntoventa)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(facturapuntoventa.getIsNew()||!facturapuntoventa.getid_empresa().equals(facturapuntoventa.getFacturaPuntoVentaOriginal().getid_empresa()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(facturapuntoventa.getFacturaPuntoVentaOriginal().getid_empresa()!=null)
				{
					strValorActual=facturapuntoventa.getFacturaPuntoVentaOriginal().getid_empresa().toString();
				}
				if(facturapuntoventa.getid_empresa()!=null)
				{
					strValorNuevo=facturapuntoventa.getid_empresa().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),FacturaPuntoVentaConstantesFunciones.IDEMPRESA,strValorActual,strValorNuevo);
			}	
			
			if(facturapuntoventa.getIsNew()||!facturapuntoventa.getid_sucursal().equals(facturapuntoventa.getFacturaPuntoVentaOriginal().getid_sucursal()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(facturapuntoventa.getFacturaPuntoVentaOriginal().getid_sucursal()!=null)
				{
					strValorActual=facturapuntoventa.getFacturaPuntoVentaOriginal().getid_sucursal().toString();
				}
				if(facturapuntoventa.getid_sucursal()!=null)
				{
					strValorNuevo=facturapuntoventa.getid_sucursal().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),FacturaPuntoVentaConstantesFunciones.IDSUCURSAL,strValorActual,strValorNuevo);
			}	
			
			if(facturapuntoventa.getIsNew()||!facturapuntoventa.getid_usuario().equals(facturapuntoventa.getFacturaPuntoVentaOriginal().getid_usuario()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(facturapuntoventa.getFacturaPuntoVentaOriginal().getid_usuario()!=null)
				{
					strValorActual=facturapuntoventa.getFacturaPuntoVentaOriginal().getid_usuario().toString();
				}
				if(facturapuntoventa.getid_usuario()!=null)
				{
					strValorNuevo=facturapuntoventa.getid_usuario().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),FacturaPuntoVentaConstantesFunciones.IDUSUARIO,strValorActual,strValorNuevo);
			}	
			
			if(facturapuntoventa.getIsNew()||!facturapuntoventa.getid_vendedor().equals(facturapuntoventa.getFacturaPuntoVentaOriginal().getid_vendedor()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(facturapuntoventa.getFacturaPuntoVentaOriginal().getid_vendedor()!=null)
				{
					strValorActual=facturapuntoventa.getFacturaPuntoVentaOriginal().getid_vendedor().toString();
				}
				if(facturapuntoventa.getid_vendedor()!=null)
				{
					strValorNuevo=facturapuntoventa.getid_vendedor().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),FacturaPuntoVentaConstantesFunciones.IDVENDEDOR,strValorActual,strValorNuevo);
			}	
			
			if(facturapuntoventa.getIsNew()||!facturapuntoventa.getid_cliente().equals(facturapuntoventa.getFacturaPuntoVentaOriginal().getid_cliente()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(facturapuntoventa.getFacturaPuntoVentaOriginal().getid_cliente()!=null)
				{
					strValorActual=facturapuntoventa.getFacturaPuntoVentaOriginal().getid_cliente().toString();
				}
				if(facturapuntoventa.getid_cliente()!=null)
				{
					strValorNuevo=facturapuntoventa.getid_cliente().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),FacturaPuntoVentaConstantesFunciones.IDCLIENTE,strValorActual,strValorNuevo);
			}	
			
			if(facturapuntoventa.getIsNew()||!facturapuntoventa.getid_caja().equals(facturapuntoventa.getFacturaPuntoVentaOriginal().getid_caja()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(facturapuntoventa.getFacturaPuntoVentaOriginal().getid_caja()!=null)
				{
					strValorActual=facturapuntoventa.getFacturaPuntoVentaOriginal().getid_caja().toString();
				}
				if(facturapuntoventa.getid_caja()!=null)
				{
					strValorNuevo=facturapuntoventa.getid_caja().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),FacturaPuntoVentaConstantesFunciones.IDCAJA,strValorActual,strValorNuevo);
			}	
			
			if(facturapuntoventa.getIsNew()||!facturapuntoventa.getid_tipo_precio().equals(facturapuntoventa.getFacturaPuntoVentaOriginal().getid_tipo_precio()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(facturapuntoventa.getFacturaPuntoVentaOriginal().getid_tipo_precio()!=null)
				{
					strValorActual=facturapuntoventa.getFacturaPuntoVentaOriginal().getid_tipo_precio().toString();
				}
				if(facturapuntoventa.getid_tipo_precio()!=null)
				{
					strValorNuevo=facturapuntoventa.getid_tipo_precio().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),FacturaPuntoVentaConstantesFunciones.IDTIPOPRECIO,strValorActual,strValorNuevo);
			}	
			
			if(facturapuntoventa.getIsNew()||!facturapuntoventa.getid_mesa().equals(facturapuntoventa.getFacturaPuntoVentaOriginal().getid_mesa()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(facturapuntoventa.getFacturaPuntoVentaOriginal().getid_mesa()!=null)
				{
					strValorActual=facturapuntoventa.getFacturaPuntoVentaOriginal().getid_mesa().toString();
				}
				if(facturapuntoventa.getid_mesa()!=null)
				{
					strValorNuevo=facturapuntoventa.getid_mesa().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),FacturaPuntoVentaConstantesFunciones.IDMESA,strValorActual,strValorNuevo);
			}	
			
			if(facturapuntoventa.getIsNew()||!facturapuntoventa.getid_formato().equals(facturapuntoventa.getFacturaPuntoVentaOriginal().getid_formato()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(facturapuntoventa.getFacturaPuntoVentaOriginal().getid_formato()!=null)
				{
					strValorActual=facturapuntoventa.getFacturaPuntoVentaOriginal().getid_formato().toString();
				}
				if(facturapuntoventa.getid_formato()!=null)
				{
					strValorNuevo=facturapuntoventa.getid_formato().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),FacturaPuntoVentaConstantesFunciones.IDFORMATO,strValorActual,strValorNuevo);
			}	
			
			if(facturapuntoventa.getIsNew()||!facturapuntoventa.getid_tipo_factura_punto_venta().equals(facturapuntoventa.getFacturaPuntoVentaOriginal().getid_tipo_factura_punto_venta()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(facturapuntoventa.getFacturaPuntoVentaOriginal().getid_tipo_factura_punto_venta()!=null)
				{
					strValorActual=facturapuntoventa.getFacturaPuntoVentaOriginal().getid_tipo_factura_punto_venta().toString();
				}
				if(facturapuntoventa.getid_tipo_factura_punto_venta()!=null)
				{
					strValorNuevo=facturapuntoventa.getid_tipo_factura_punto_venta().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),FacturaPuntoVentaConstantesFunciones.IDTIPOFACTURAPUNTOVENTA,strValorActual,strValorNuevo);
			}	
			
			if(facturapuntoventa.getIsNew()||!facturapuntoventa.getid_estado_factura_punto_venta().equals(facturapuntoventa.getFacturaPuntoVentaOriginal().getid_estado_factura_punto_venta()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(facturapuntoventa.getFacturaPuntoVentaOriginal().getid_estado_factura_punto_venta()!=null)
				{
					strValorActual=facturapuntoventa.getFacturaPuntoVentaOriginal().getid_estado_factura_punto_venta().toString();
				}
				if(facturapuntoventa.getid_estado_factura_punto_venta()!=null)
				{
					strValorNuevo=facturapuntoventa.getid_estado_factura_punto_venta().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),FacturaPuntoVentaConstantesFunciones.IDESTADOFACTURAPUNTOVENTA,strValorActual,strValorNuevo);
			}	
			
			if(facturapuntoventa.getIsNew()||!facturapuntoventa.getid_asiento_contable().equals(facturapuntoventa.getFacturaPuntoVentaOriginal().getid_asiento_contable()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(facturapuntoventa.getFacturaPuntoVentaOriginal().getid_asiento_contable()!=null)
				{
					strValorActual=facturapuntoventa.getFacturaPuntoVentaOriginal().getid_asiento_contable().toString();
				}
				if(facturapuntoventa.getid_asiento_contable()!=null)
				{
					strValorNuevo=facturapuntoventa.getid_asiento_contable().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),FacturaPuntoVentaConstantesFunciones.IDASIENTOCONTABLE,strValorActual,strValorNuevo);
			}	
			
			if(facturapuntoventa.getIsNew()||!facturapuntoventa.getnumero_secuencial().equals(facturapuntoventa.getFacturaPuntoVentaOriginal().getnumero_secuencial()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(facturapuntoventa.getFacturaPuntoVentaOriginal().getnumero_secuencial()!=null)
				{
					strValorActual=facturapuntoventa.getFacturaPuntoVentaOriginal().getnumero_secuencial();
				}
				if(facturapuntoventa.getnumero_secuencial()!=null)
				{
					strValorNuevo=facturapuntoventa.getnumero_secuencial() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),FacturaPuntoVentaConstantesFunciones.NUMEROSECUENCIAL,strValorActual,strValorNuevo);
			}	
			
			if(facturapuntoventa.getIsNew()||!facturapuntoventa.getcodigo_cliente().equals(facturapuntoventa.getFacturaPuntoVentaOriginal().getcodigo_cliente()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(facturapuntoventa.getFacturaPuntoVentaOriginal().getcodigo_cliente()!=null)
				{
					strValorActual=facturapuntoventa.getFacturaPuntoVentaOriginal().getcodigo_cliente();
				}
				if(facturapuntoventa.getcodigo_cliente()!=null)
				{
					strValorNuevo=facturapuntoventa.getcodigo_cliente() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),FacturaPuntoVentaConstantesFunciones.CODIGOCLIENTE,strValorActual,strValorNuevo);
			}	
			
			if(facturapuntoventa.getIsNew()||!facturapuntoventa.getnombre_cliente().equals(facturapuntoventa.getFacturaPuntoVentaOriginal().getnombre_cliente()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(facturapuntoventa.getFacturaPuntoVentaOriginal().getnombre_cliente()!=null)
				{
					strValorActual=facturapuntoventa.getFacturaPuntoVentaOriginal().getnombre_cliente();
				}
				if(facturapuntoventa.getnombre_cliente()!=null)
				{
					strValorNuevo=facturapuntoventa.getnombre_cliente() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),FacturaPuntoVentaConstantesFunciones.NOMBRECLIENTE,strValorActual,strValorNuevo);
			}	
			
			if(facturapuntoventa.getIsNew()||!facturapuntoventa.gettarjeta_cliente().equals(facturapuntoventa.getFacturaPuntoVentaOriginal().gettarjeta_cliente()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(facturapuntoventa.getFacturaPuntoVentaOriginal().gettarjeta_cliente()!=null)
				{
					strValorActual=facturapuntoventa.getFacturaPuntoVentaOriginal().gettarjeta_cliente();
				}
				if(facturapuntoventa.gettarjeta_cliente()!=null)
				{
					strValorNuevo=facturapuntoventa.gettarjeta_cliente() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),FacturaPuntoVentaConstantesFunciones.TARJETACLIENTE,strValorActual,strValorNuevo);
			}	
			
			if(facturapuntoventa.getIsNew()||!facturapuntoventa.getdireccion_cliente().equals(facturapuntoventa.getFacturaPuntoVentaOriginal().getdireccion_cliente()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(facturapuntoventa.getFacturaPuntoVentaOriginal().getdireccion_cliente()!=null)
				{
					strValorActual=facturapuntoventa.getFacturaPuntoVentaOriginal().getdireccion_cliente();
				}
				if(facturapuntoventa.getdireccion_cliente()!=null)
				{
					strValorNuevo=facturapuntoventa.getdireccion_cliente() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),FacturaPuntoVentaConstantesFunciones.DIRECCIONCLIENTE,strValorActual,strValorNuevo);
			}	
			
			if(facturapuntoventa.getIsNew()||!facturapuntoventa.gettelefono_cliente().equals(facturapuntoventa.getFacturaPuntoVentaOriginal().gettelefono_cliente()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(facturapuntoventa.getFacturaPuntoVentaOriginal().gettelefono_cliente()!=null)
				{
					strValorActual=facturapuntoventa.getFacturaPuntoVentaOriginal().gettelefono_cliente();
				}
				if(facturapuntoventa.gettelefono_cliente()!=null)
				{
					strValorNuevo=facturapuntoventa.gettelefono_cliente() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),FacturaPuntoVentaConstantesFunciones.TELEFONOCLIENTE,strValorActual,strValorNuevo);
			}	
			
			if(facturapuntoventa.getIsNew()||!facturapuntoventa.getfecha().equals(facturapuntoventa.getFacturaPuntoVentaOriginal().getfecha()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(facturapuntoventa.getFacturaPuntoVentaOriginal().getfecha()!=null)
				{
					strValorActual=facturapuntoventa.getFacturaPuntoVentaOriginal().getfecha().toString();
				}
				if(facturapuntoventa.getfecha()!=null)
				{
					strValorNuevo=facturapuntoventa.getfecha().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),FacturaPuntoVentaConstantesFunciones.FECHA,strValorActual,strValorNuevo);
			}	
			
			if(facturapuntoventa.getIsNew()||!facturapuntoventa.gethora().equals(facturapuntoventa.getFacturaPuntoVentaOriginal().gethora()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(facturapuntoventa.getFacturaPuntoVentaOriginal().gethora()!=null)
				{
					strValorActual=facturapuntoventa.getFacturaPuntoVentaOriginal().gethora().toString();
				}
				if(facturapuntoventa.gethora()!=null)
				{
					strValorNuevo=facturapuntoventa.gethora().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),FacturaPuntoVentaConstantesFunciones.HORA,strValorActual,strValorNuevo);
			}	
			
			if(facturapuntoventa.getIsNew()||!facturapuntoventa.gettotal_iva().equals(facturapuntoventa.getFacturaPuntoVentaOriginal().gettotal_iva()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(facturapuntoventa.getFacturaPuntoVentaOriginal().gettotal_iva()!=null)
				{
					strValorActual=facturapuntoventa.getFacturaPuntoVentaOriginal().gettotal_iva().toString();
				}
				if(facturapuntoventa.gettotal_iva()!=null)
				{
					strValorNuevo=facturapuntoventa.gettotal_iva().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),FacturaPuntoVentaConstantesFunciones.TOTALIVA,strValorActual,strValorNuevo);
			}	
			
			if(facturapuntoventa.getIsNew()||!facturapuntoventa.gettotal_sin_iva().equals(facturapuntoventa.getFacturaPuntoVentaOriginal().gettotal_sin_iva()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(facturapuntoventa.getFacturaPuntoVentaOriginal().gettotal_sin_iva()!=null)
				{
					strValorActual=facturapuntoventa.getFacturaPuntoVentaOriginal().gettotal_sin_iva().toString();
				}
				if(facturapuntoventa.gettotal_sin_iva()!=null)
				{
					strValorNuevo=facturapuntoventa.gettotal_sin_iva().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),FacturaPuntoVentaConstantesFunciones.TOTALSINIVA,strValorActual,strValorNuevo);
			}	
			
			if(facturapuntoventa.getIsNew()||!facturapuntoventa.getiva().equals(facturapuntoventa.getFacturaPuntoVentaOriginal().getiva()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(facturapuntoventa.getFacturaPuntoVentaOriginal().getiva()!=null)
				{
					strValorActual=facturapuntoventa.getFacturaPuntoVentaOriginal().getiva().toString();
				}
				if(facturapuntoventa.getiva()!=null)
				{
					strValorNuevo=facturapuntoventa.getiva().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),FacturaPuntoVentaConstantesFunciones.IVA,strValorActual,strValorNuevo);
			}	
			
			if(facturapuntoventa.getIsNew()||!facturapuntoventa.getdescuento().equals(facturapuntoventa.getFacturaPuntoVentaOriginal().getdescuento()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(facturapuntoventa.getFacturaPuntoVentaOriginal().getdescuento()!=null)
				{
					strValorActual=facturapuntoventa.getFacturaPuntoVentaOriginal().getdescuento().toString();
				}
				if(facturapuntoventa.getdescuento()!=null)
				{
					strValorNuevo=facturapuntoventa.getdescuento().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),FacturaPuntoVentaConstantesFunciones.DESCUENTO,strValorActual,strValorNuevo);
			}	
			
			if(facturapuntoventa.getIsNew()||!facturapuntoventa.getfinanciamiento().equals(facturapuntoventa.getFacturaPuntoVentaOriginal().getfinanciamiento()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(facturapuntoventa.getFacturaPuntoVentaOriginal().getfinanciamiento()!=null)
				{
					strValorActual=facturapuntoventa.getFacturaPuntoVentaOriginal().getfinanciamiento().toString();
				}
				if(facturapuntoventa.getfinanciamiento()!=null)
				{
					strValorNuevo=facturapuntoventa.getfinanciamiento().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),FacturaPuntoVentaConstantesFunciones.FINANCIAMIENTO,strValorActual,strValorNuevo);
			}	
			
			if(facturapuntoventa.getIsNew()||!facturapuntoventa.getflete().equals(facturapuntoventa.getFacturaPuntoVentaOriginal().getflete()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(facturapuntoventa.getFacturaPuntoVentaOriginal().getflete()!=null)
				{
					strValorActual=facturapuntoventa.getFacturaPuntoVentaOriginal().getflete().toString();
				}
				if(facturapuntoventa.getflete()!=null)
				{
					strValorNuevo=facturapuntoventa.getflete().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),FacturaPuntoVentaConstantesFunciones.FLETE,strValorActual,strValorNuevo);
			}	
			
			if(facturapuntoventa.getIsNew()||!facturapuntoventa.getice().equals(facturapuntoventa.getFacturaPuntoVentaOriginal().getice()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(facturapuntoventa.getFacturaPuntoVentaOriginal().getice()!=null)
				{
					strValorActual=facturapuntoventa.getFacturaPuntoVentaOriginal().getice().toString();
				}
				if(facturapuntoventa.getice()!=null)
				{
					strValorNuevo=facturapuntoventa.getice().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),FacturaPuntoVentaConstantesFunciones.ICE,strValorActual,strValorNuevo);
			}	
			
			if(facturapuntoventa.getIsNew()||!facturapuntoventa.getotros().equals(facturapuntoventa.getFacturaPuntoVentaOriginal().getotros()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(facturapuntoventa.getFacturaPuntoVentaOriginal().getotros()!=null)
				{
					strValorActual=facturapuntoventa.getFacturaPuntoVentaOriginal().getotros().toString();
				}
				if(facturapuntoventa.getotros()!=null)
				{
					strValorNuevo=facturapuntoventa.getotros().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),FacturaPuntoVentaConstantesFunciones.OTROS,strValorActual,strValorNuevo);
			}	
			
			if(facturapuntoventa.getIsNew()||!facturapuntoventa.getsub_total().equals(facturapuntoventa.getFacturaPuntoVentaOriginal().getsub_total()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(facturapuntoventa.getFacturaPuntoVentaOriginal().getsub_total()!=null)
				{
					strValorActual=facturapuntoventa.getFacturaPuntoVentaOriginal().getsub_total().toString();
				}
				if(facturapuntoventa.getsub_total()!=null)
				{
					strValorNuevo=facturapuntoventa.getsub_total().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),FacturaPuntoVentaConstantesFunciones.SUBTOTAL,strValorActual,strValorNuevo);
			}	
			
			if(facturapuntoventa.getIsNew()||!facturapuntoventa.gettotal().equals(facturapuntoventa.getFacturaPuntoVentaOriginal().gettotal()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(facturapuntoventa.getFacturaPuntoVentaOriginal().gettotal()!=null)
				{
					strValorActual=facturapuntoventa.getFacturaPuntoVentaOriginal().gettotal().toString();
				}
				if(facturapuntoventa.gettotal()!=null)
				{
					strValorNuevo=facturapuntoventa.gettotal().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),FacturaPuntoVentaConstantesFunciones.TOTAL,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void saveFacturaPuntoVentaRelacionesWithConnection(FacturaPuntoVenta facturapuntoventa,List<FormaPagoPuntoVenta> formapagopuntoventas,List<DetalleFacturaPuntoVenta> detallefacturapuntoventas) throws Exception {

		if(!facturapuntoventa.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveFacturaPuntoVentaRelacionesBase(facturapuntoventa,formapagopuntoventas,detallefacturapuntoventas,true);
		}
	}

	public void saveFacturaPuntoVentaRelaciones(FacturaPuntoVenta facturapuntoventa,List<FormaPagoPuntoVenta> formapagopuntoventas,List<DetalleFacturaPuntoVenta> detallefacturapuntoventas)throws Exception {

		if(!facturapuntoventa.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveFacturaPuntoVentaRelacionesBase(facturapuntoventa,formapagopuntoventas,detallefacturapuntoventas,false);
		}
	}

	public void saveFacturaPuntoVentaRelacionesBase(FacturaPuntoVenta facturapuntoventa,List<FormaPagoPuntoVenta> formapagopuntoventas,List<DetalleFacturaPuntoVenta> detallefacturapuntoventas,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("FacturaPuntoVenta-saveRelacionesWithConnection");}
	
			facturapuntoventa.setFormaPagoPuntoVentas(formapagopuntoventas);
			facturapuntoventa.setDetalleFacturaPuntoVentas(detallefacturapuntoventas);

			this.setFacturaPuntoVenta(facturapuntoventa);

			if(FacturaPuntoVentaLogicAdditional.validarSaveRelaciones(facturapuntoventa,this)) {

				FacturaPuntoVentaLogicAdditional.updateRelacionesToSave(facturapuntoventa,this);

				if((facturapuntoventa.getIsNew()||facturapuntoventa.getIsChanged())&&!facturapuntoventa.getIsDeleted()) {
					this.saveFacturaPuntoVenta();
					this.saveFacturaPuntoVentaRelacionesDetalles(formapagopuntoventas,detallefacturapuntoventas);

				} else if(facturapuntoventa.getIsDeleted()) {
					this.saveFacturaPuntoVentaRelacionesDetalles(formapagopuntoventas,detallefacturapuntoventas);
					this.saveFacturaPuntoVenta();
				}

				FacturaPuntoVentaLogicAdditional.updateRelacionesToSaveAfter(facturapuntoventa,this);

			} else {
				throw new Exception("LOS DATOS SON INVALIDOS");
			}

			if(conConexion) {connexion.commit();}

		} catch(Exception e) {
			
			FormaPagoPuntoVentaConstantesFunciones.InicializarGeneralEntityAuxiliaresFormaPagoPuntoVentas(formapagopuntoventas,true,true);
			DetalleFacturaPuntoVentaConstantesFunciones.InicializarGeneralEntityAuxiliaresDetalleFacturaPuntoVentas(detallefacturapuntoventas,true,true);

			if(conConexion){connexion.rollback();}
			Funciones.manageException(logger,e);
			throw e;

		} finally {
			if(conConexion){this.closeNewConnexionToDeep();}
		}
	}
	
	
	private void saveFacturaPuntoVentaRelacionesDetalles(List<FormaPagoPuntoVenta> formapagopuntoventas,List<DetalleFacturaPuntoVenta> detallefacturapuntoventas)throws Exception {
		try {
	

			Long idFacturaPuntoVentaActual=this.getFacturaPuntoVenta().getId();

			FormaPagoPuntoVentaLogic formapagopuntoventaLogic_Desde_FacturaPuntoVenta=new FormaPagoPuntoVentaLogic();
			formapagopuntoventaLogic_Desde_FacturaPuntoVenta.setFormaPagoPuntoVentas(formapagopuntoventas);

			formapagopuntoventaLogic_Desde_FacturaPuntoVenta.setConnexion(this.getConnexion());
			formapagopuntoventaLogic_Desde_FacturaPuntoVenta.setDatosCliente(this.datosCliente);

			for(FormaPagoPuntoVenta formapagopuntoventa_Desde_FacturaPuntoVenta:formapagopuntoventaLogic_Desde_FacturaPuntoVenta.getFormaPagoPuntoVentas()) {
				formapagopuntoventa_Desde_FacturaPuntoVenta.setid_factura_punto_venta(idFacturaPuntoVentaActual);
			}

			formapagopuntoventaLogic_Desde_FacturaPuntoVenta.saveFormaPagoPuntoVentas();

			DetalleFacturaPuntoVentaLogic detallefacturapuntoventaLogic_Desde_FacturaPuntoVenta=new DetalleFacturaPuntoVentaLogic();
			detallefacturapuntoventaLogic_Desde_FacturaPuntoVenta.setDetalleFacturaPuntoVentas(detallefacturapuntoventas);

			detallefacturapuntoventaLogic_Desde_FacturaPuntoVenta.setConnexion(this.getConnexion());
			detallefacturapuntoventaLogic_Desde_FacturaPuntoVenta.setDatosCliente(this.datosCliente);

			for(DetalleFacturaPuntoVenta detallefacturapuntoventa_Desde_FacturaPuntoVenta:detallefacturapuntoventaLogic_Desde_FacturaPuntoVenta.getDetalleFacturaPuntoVentas()) {
				detallefacturapuntoventa_Desde_FacturaPuntoVenta.setid_factura_punto_venta(idFacturaPuntoVentaActual);
			}

			detallefacturapuntoventaLogic_Desde_FacturaPuntoVenta.saveDetalleFacturaPuntoVentas();

		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfFacturaPuntoVenta(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=FacturaPuntoVentaConstantesFunciones.getClassesForeignKeysOfFacturaPuntoVenta(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfFacturaPuntoVenta(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=FacturaPuntoVentaConstantesFunciones.getClassesRelationshipsOfFacturaPuntoVenta(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}
