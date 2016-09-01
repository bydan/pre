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
import com.bydan.erp.facturacion.util.FacturaConstantesFunciones;
import com.bydan.erp.facturacion.util.FacturaParameterReturnGeneral;
//import com.bydan.erp.facturacion.util.FacturaParameterGeneral;
import com.bydan.erp.facturacion.business.entity.Factura;
import com.bydan.erp.facturacion.business.logic.FacturaLogicAdditional;
import com.bydan.erp.facturacion.business.dataaccess.*;
import com.bydan.erp.facturacion.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.nomina.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.inventario.business.entity.*;
import com.bydan.erp.comisiones.business.entity.*;
import com.bydan.erp.tesoreria.business.entity.*;


import com.bydan.erp.seguridad.business.logic.*;
import com.bydan.erp.contabilidad.business.logic.*;
import com.bydan.erp.nomina.business.logic.*;
import com.bydan.erp.cartera.business.logic.*;
import com.bydan.erp.inventario.business.logic.*;
import com.bydan.erp.comisiones.business.logic.*;
import com.bydan.erp.tesoreria.business.logic.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.contabilidad.util.*;
import com.bydan.erp.nomina.util.*;
import com.bydan.erp.cartera.util.*;
import com.bydan.erp.inventario.util.*;
import com.bydan.erp.comisiones.util.*;
import com.bydan.erp.tesoreria.util.*;


import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.contabilidad.business.dataaccess.*;
import com.bydan.erp.nomina.business.dataaccess.*;
import com.bydan.erp.cartera.business.dataaccess.*;
import com.bydan.erp.inventario.business.dataaccess.*;
import com.bydan.erp.comisiones.business.dataaccess.*;
import com.bydan.erp.tesoreria.business.dataaccess.*;








@SuppressWarnings("unused")
public class FacturaLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(FacturaLogic.class);
	
	protected FacturaDataAccess facturaDataAccess; 	
	protected Factura factura;
	protected List<Factura> facturas;
	protected Object facturaObject;	
	protected List<Object> facturasObject;
	
	public static ClassValidator<Factura> facturaValidator = new ClassValidator<Factura>(Factura.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected FacturaLogicAdditional facturaLogicAdditional=null;
	
	public FacturaLogicAdditional getFacturaLogicAdditional() {
		return this.facturaLogicAdditional;
	}
	
	public void setFacturaLogicAdditional(FacturaLogicAdditional facturaLogicAdditional) {
		try {
			this.facturaLogicAdditional=facturaLogicAdditional;
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
	
	
	
	
	public  FacturaLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.facturaDataAccess = new FacturaDataAccess();
			
			this.facturas= new ArrayList<Factura>();
			this.factura= new Factura();
			
			this.facturaObject=new Object();
			this.facturasObject=new ArrayList<Object>();
				
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
			
			this.facturaDataAccess.setConnexionType(this.connexionType);
			this.facturaDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  FacturaLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.facturaDataAccess = new FacturaDataAccess();
			this.facturas= new ArrayList<Factura>();
			this.factura= new Factura();
			this.facturaObject=new Object();
			this.facturasObject=new ArrayList<Object>();
			
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
			
			this.facturaDataAccess.setConnexionType(this.connexionType);
			this.facturaDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public Factura getFactura() throws Exception {	
		FacturaLogicAdditional.checkFacturaToGet(factura,this.datosCliente,this.arrDatoGeneral);
		FacturaLogicAdditional.updateFacturaToGet(factura,this.arrDatoGeneral);
		
		return factura;
	}
		
	public void setFactura(Factura newFactura) {
		this.factura = newFactura;
	}
	
	public FacturaDataAccess getFacturaDataAccess() {
		return facturaDataAccess;
	}
	
	public void setFacturaDataAccess(FacturaDataAccess newfacturaDataAccess) {
		this.facturaDataAccess = newfacturaDataAccess;
	}
	
	public List<Factura> getFacturas() throws Exception {		
		this.quitarFacturasNulos();
		
		FacturaLogicAdditional.checkFacturaToGets(facturas,this.datosCliente,this.arrDatoGeneral);
		
		for (Factura facturaLocal: facturas ) {
			FacturaLogicAdditional.updateFacturaToGet(facturaLocal,this.arrDatoGeneral);
		}
		
		return facturas;
	}
	
	public void setFacturas(List<Factura> newFacturas) {
		this.facturas = newFacturas;
	}
	
	public Object getFacturaObject() {	
		this.facturaObject=this.facturaDataAccess.getEntityObject();
		return this.facturaObject;
	}
		
	public void setFacturaObject(Object newFacturaObject) {
		this.facturaObject = newFacturaObject;
	}
	
	public List<Object> getFacturasObject() {		
		this.facturasObject=this.facturaDataAccess.getEntitiesObject();
		return this.facturasObject;
	}
		
	public void setFacturasObject(List<Object> newFacturasObject) {
		this.facturasObject = newFacturasObject;
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
		
		if(this.facturaDataAccess!=null) {
			this.facturaDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Factura.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			facturaDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			facturaDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		factura = new  Factura();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Factura.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			factura=facturaDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.factura,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				FacturaConstantesFunciones.refrescarForeignKeysDescripcionesFactura(this.factura);
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
		factura = new  Factura();
		  		  
        try {
			
			factura=facturaDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.factura,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				FacturaConstantesFunciones.refrescarForeignKeysDescripcionesFactura(this.factura);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		factura = new  Factura();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Factura.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			factura=facturaDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.factura,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				FacturaConstantesFunciones.refrescarForeignKeysDescripcionesFactura(this.factura);
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
		factura = new  Factura();
		  		  
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
		factura = new  Factura();
		  		  
        try {
			
			factura=facturaDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.factura,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				FacturaConstantesFunciones.refrescarForeignKeysDescripcionesFactura(this.factura);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		factura = new  Factura();
		  		  
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
		factura = new  Factura();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Factura.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =facturaDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		factura = new  Factura();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=facturaDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		factura = new  Factura();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Factura.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =facturaDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		factura = new  Factura();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=facturaDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		factura = new  Factura();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Factura.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =facturaDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		factura = new  Factura();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=facturaDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		facturas = new  ArrayList<Factura>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Factura.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			FacturaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			facturas=facturaDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarFactura(facturas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				FacturaConstantesFunciones.refrescarForeignKeysDescripcionesFactura(this.facturas);
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
		facturas = new  ArrayList<Factura>();
		  		  
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
		facturas = new  ArrayList<Factura>();
		  		  
        try {			
			FacturaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			facturas=facturaDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarFactura(facturas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				FacturaConstantesFunciones.refrescarForeignKeysDescripcionesFactura(this.facturas);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		facturas = new  ArrayList<Factura>();
		  		  
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
		facturas = new  ArrayList<Factura>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Factura.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			FacturaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			facturas=facturaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarFactura(facturas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				FacturaConstantesFunciones.refrescarForeignKeysDescripcionesFactura(this.facturas);
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
		facturas = new  ArrayList<Factura>();
		  		  
        try {
			FacturaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			facturas=facturaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarFactura(facturas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				FacturaConstantesFunciones.refrescarForeignKeysDescripcionesFactura(this.facturas);
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
		facturas = new  ArrayList<Factura>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Factura.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			FacturaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			facturas=facturaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarFactura(facturas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				FacturaConstantesFunciones.refrescarForeignKeysDescripcionesFactura(this.facturas);
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
		facturas = new  ArrayList<Factura>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			FacturaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			facturas=facturaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarFactura(facturas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				FacturaConstantesFunciones.refrescarForeignKeysDescripcionesFactura(this.facturas);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		factura = new  Factura();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Factura.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			FacturaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			factura=facturaDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarFactura(factura);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				FacturaConstantesFunciones.refrescarForeignKeysDescripcionesFactura(this.factura);
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
		factura = new  Factura();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			FacturaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			factura=facturaDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarFactura(factura);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				FacturaConstantesFunciones.refrescarForeignKeysDescripcionesFactura(this.factura);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		facturas = new  ArrayList<Factura>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Factura.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			FacturaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			facturas=facturaDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarFactura(facturas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				FacturaConstantesFunciones.refrescarForeignKeysDescripcionesFactura(this.facturas);
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
		facturas = new  ArrayList<Factura>();
		  		  
        try {
			FacturaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			facturas=facturaDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarFactura(facturas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				FacturaConstantesFunciones.refrescarForeignKeysDescripcionesFactura(this.facturas);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosFacturasWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		facturas = new  ArrayList<Factura>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Factura.class.getSimpleName()+"-getTodosFacturasWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			FacturaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			facturas=facturaDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarFactura(facturas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				FacturaConstantesFunciones.refrescarForeignKeysDescripcionesFactura(this.facturas);
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
	
	public  void  getTodosFacturas(String sFinalQuery,Pagination pagination)throws Exception {
		facturas = new  ArrayList<Factura>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			FacturaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			facturas=facturaDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarFactura(facturas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				FacturaConstantesFunciones.refrescarForeignKeysDescripcionesFactura(this.facturas);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarFactura(Factura factura) throws Exception {
		Boolean estaValidado=false;
		
		if(factura.getIsNew() || factura.getIsChanged()) { 
			this.invalidValues = facturaValidator.getInvalidValues(factura);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(factura);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarFactura(List<Factura> Facturas) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(Factura facturaLocal:facturas) {				
			estaValidadoObjeto=this.validarGuardarFactura(facturaLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarFactura(List<Factura> Facturas) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarFactura(facturas)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarFactura(Factura Factura) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarFactura(factura)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(Factura factura) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+factura.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=FacturaConstantesFunciones.getFacturaLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"factura","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(FacturaConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(FacturaConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveFacturaWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Factura.class.getSimpleName()+"-saveFacturaWithConnection");connexion.begin();			
			
			FacturaLogicAdditional.checkFacturaToSave(this.factura,this.datosCliente,connexion,this.arrDatoGeneral);
			
			FacturaLogicAdditional.updateFacturaToSave(this.factura,this.arrDatoGeneral);
			
			FacturaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.factura,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowFactura();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarFactura(this.factura)) {
				FacturaDataAccess.save(this.factura, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.factura,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			FacturaLogicAdditional.checkFacturaToSaveAfter(this.factura,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowFactura();
			
			connexion.commit();			
			
			if(this.factura.getIsDeleted()) {
				this.factura=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveFactura()throws Exception {	
		try {	
			
			FacturaLogicAdditional.checkFacturaToSave(this.factura,this.datosCliente,connexion,this.arrDatoGeneral);
			
			FacturaLogicAdditional.updateFacturaToSave(this.factura,this.arrDatoGeneral);
			
			FacturaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.factura,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarFactura(this.factura)) {			
				FacturaDataAccess.save(this.factura, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.factura,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			FacturaLogicAdditional.checkFacturaToSaveAfter(this.factura,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.factura.getIsDeleted()) {
				this.factura=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveFacturasWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Factura.class.getSimpleName()+"-saveFacturasWithConnection");connexion.begin();			
			
			FacturaLogicAdditional.checkFacturaToSaves(facturas,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowFacturas();
			
			Boolean validadoTodosFactura=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(Factura facturaLocal:facturas) {		
				if(facturaLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				FacturaLogicAdditional.updateFacturaToSave(facturaLocal,this.arrDatoGeneral);
	        	
				FacturaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),facturaLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarFactura(facturaLocal)) {
					FacturaDataAccess.save(facturaLocal, connexion);				
				} else {
					validadoTodosFactura=false;
				}
			}
			
			if(!validadoTodosFactura) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			FacturaLogicAdditional.checkFacturaToSavesAfter(facturas,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowFacturas();
			
			connexion.commit();		
			
			this.quitarFacturasEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveFacturas()throws Exception {				
		 try {	
			FacturaLogicAdditional.checkFacturaToSaves(facturas,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosFactura=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(Factura facturaLocal:facturas) {				
				if(facturaLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				FacturaLogicAdditional.updateFacturaToSave(facturaLocal,this.arrDatoGeneral);
	        	
				FacturaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),facturaLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarFactura(facturaLocal)) {				
					FacturaDataAccess.save(facturaLocal, connexion);				
				} else {
					validadoTodosFactura=false;
				}
			}
			
			if(!validadoTodosFactura) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			FacturaLogicAdditional.checkFacturaToSavesAfter(facturas,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarFacturasEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public FacturaParameterReturnGeneral procesarAccionFacturas(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<Factura> facturas,FacturaParameterReturnGeneral facturaParameterGeneral)throws Exception {
		 try {	
			FacturaParameterReturnGeneral facturaReturnGeneral=new FacturaParameterReturnGeneral();
	
			FacturaLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,facturas,facturaParameterGeneral,facturaReturnGeneral);
			
			return facturaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public FacturaParameterReturnGeneral procesarAccionFacturasWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<Factura> facturas,FacturaParameterReturnGeneral facturaParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Factura.class.getSimpleName()+"-procesarAccionFacturasWithConnection");connexion.begin();			
			
			FacturaParameterReturnGeneral facturaReturnGeneral=new FacturaParameterReturnGeneral();
	
			FacturaLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,facturas,facturaParameterGeneral,facturaReturnGeneral);
			
			this.connexion.commit();
			
			return facturaReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public FacturaParameterReturnGeneral procesarEventosFacturas(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<Factura> facturas,Factura factura,FacturaParameterReturnGeneral facturaParameterGeneral,Boolean isEsNuevoFactura,ArrayList<Classe> clases)throws Exception {
		 try {	
			FacturaParameterReturnGeneral facturaReturnGeneral=new FacturaParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				facturaReturnGeneral.setConRecargarPropiedades(true);
			}
			
			FacturaLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,facturas,factura,facturaParameterGeneral,facturaReturnGeneral,isEsNuevoFactura,clases);
			
			return facturaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public FacturaParameterReturnGeneral procesarEventosFacturasWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<Factura> facturas,Factura factura,FacturaParameterReturnGeneral facturaParameterGeneral,Boolean isEsNuevoFactura,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Factura.class.getSimpleName()+"-procesarEventosFacturasWithConnection");connexion.begin();			
			
			FacturaParameterReturnGeneral facturaReturnGeneral=new FacturaParameterReturnGeneral();
	
			facturaReturnGeneral.setFactura(factura);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				facturaReturnGeneral.setConRecargarPropiedades(true);
			}
			
			FacturaLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,facturas,factura,facturaParameterGeneral,facturaReturnGeneral,isEsNuevoFactura,clases);
			
			this.connexion.commit();
			
			return facturaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public FacturaParameterReturnGeneral procesarImportacionFacturasWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,FacturaParameterReturnGeneral facturaParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Factura.class.getSimpleName()+"-procesarImportacionFacturasWithConnection");connexion.begin();			
			
			FacturaParameterReturnGeneral facturaReturnGeneral=new FacturaParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.facturas=new ArrayList<Factura>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.factura=new Factura();
				
				
				if(conColumnasBase) {this.factura.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.factura.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.factura.setnumero_pre_impreso(arrColumnas[iColumn++]);
				this.factura.setfecha_emision(Funciones.ConvertToDate(arrColumnas[iColumn++]));
				this.factura.setnumero_dias(Integer.parseInt(arrColumnas[iColumn++]));
				this.factura.setfecha_vencimiento(Funciones.ConvertToDate(arrColumnas[iColumn++]));
				this.factura.setcotizacion(Double.parseDouble(arrColumnas[iColumn++]));
				this.factura.setdireccion(arrColumnas[iColumn++]);
				this.factura.setruc(arrColumnas[iColumn++]);
				this.factura.settelefono(arrColumnas[iColumn++]);
				this.factura.setorden(arrColumnas[iColumn++]);
				//this.factura.sethora_inicio(arrColumnas[iColumn++]);
				//this.factura.sethora_fin(arrColumnas[iColumn++]);
				this.factura.setdescripcion(arrColumnas[iColumn++]);
				this.factura.setcupo(Double.parseDouble(arrColumnas[iColumn++]));
				this.factura.setsaldo(Double.parseDouble(arrColumnas[iColumn++]));
				this.factura.setdocumentos(Double.parseDouble(arrColumnas[iColumn++]));
				this.factura.setdisponible(Double.parseDouble(arrColumnas[iColumn++]));
				this.factura.setporcentaje_descuento(Double.parseDouble(arrColumnas[iColumn++]));
				this.factura.settotal_iva(Double.parseDouble(arrColumnas[iColumn++]));
				this.factura.setsuman(Double.parseDouble(arrColumnas[iColumn++]));
				this.factura.setdescuento_valor(Double.parseDouble(arrColumnas[iColumn++]));
				this.factura.settotal_sin_iva(Double.parseDouble(arrColumnas[iColumn++]));
				this.factura.settotal_descuento(Double.parseDouble(arrColumnas[iColumn++]));
				this.factura.settotal_flete(Double.parseDouble(arrColumnas[iColumn++]));
				this.factura.settotal(Double.parseDouble(arrColumnas[iColumn++]));
				this.factura.setsub_total(Double.parseDouble(arrColumnas[iColumn++]));
				this.factura.settotal_otro(Double.parseDouble(arrColumnas[iColumn++]));
				this.factura.setultimo_costo(Double.parseDouble(arrColumnas[iColumn++]));
				this.factura.setiva(Double.parseDouble(arrColumnas[iColumn++]));
				this.factura.setdescuento(Double.parseDouble(arrColumnas[iColumn++]));
				this.factura.setfinanciamiento(Double.parseDouble(arrColumnas[iColumn++]));
				this.factura.setmargen_utilidad(Double.parseDouble(arrColumnas[iColumn++]));
				this.factura.setice(Double.parseDouble(arrColumnas[iColumn++]));
				this.factura.setanticipo(Double.parseDouble(arrColumnas[iColumn++]));
				this.factura.setotros_valores(Double.parseDouble(arrColumnas[iColumn++]));
				
				this.facturas.add(this.factura);
			}
			
			this.saveFacturas();
			
			this.connexion.commit();
			
			facturaReturnGeneral.setConRetornoEstaProcesado(true);
			facturaReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return facturaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarFacturasEliminados() throws Exception {				
		
		List<Factura> facturasAux= new ArrayList<Factura>();
		
		for(Factura factura:facturas) {
			if(!factura.getIsDeleted()) {
				facturasAux.add(factura);
			}
		}
		
		facturas=facturasAux;
	}
	
	public void quitarFacturasNulos() throws Exception {				
		
		List<Factura> facturasAux= new ArrayList<Factura>();
		
		for(Factura factura : this.facturas) {
			if(factura==null) {
				facturasAux.add(factura);
			}
		}
		
		//this.facturas=facturasAux;
		
		this.facturas.removeAll(facturasAux);
	}
	
	public void getSetVersionRowFacturaWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(factura.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((factura.getIsDeleted() || (factura.getIsChanged()&&!factura.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=facturaDataAccess.getSetVersionRowFactura(connexion,factura.getId());
				
				if(!factura.getVersionRow().equals(timestamp)) {	
					factura.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				factura.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowFactura()throws Exception {	
		
		if(factura.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((factura.getIsDeleted() || (factura.getIsChanged()&&!factura.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=facturaDataAccess.getSetVersionRowFactura(connexion,factura.getId());
			
			try {							
				if(!factura.getVersionRow().equals(timestamp)) {	
					factura.setVersionRow(timestamp);
				}
				
				factura.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowFacturasWithConnection()throws Exception {	
		if(facturas!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(Factura facturaAux:facturas) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(facturaAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(facturaAux.getIsDeleted() || (facturaAux.getIsChanged()&&!facturaAux.getIsNew())) {
						
						timestamp=facturaDataAccess.getSetVersionRowFactura(connexion,facturaAux.getId());
						
						if(!factura.getVersionRow().equals(timestamp)) {	
							facturaAux.setVersionRow(timestamp);
						}
								
						facturaAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowFacturas()throws Exception {	
		if(facturas!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(Factura facturaAux:facturas) {
					if(facturaAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(facturaAux.getIsDeleted() || (facturaAux.getIsChanged()&&!facturaAux.getIsNew())) {
						
						timestamp=facturaDataAccess.getSetVersionRowFactura(connexion,facturaAux.getId());
						
						if(!facturaAux.getVersionRow().equals(timestamp)) {	
							facturaAux.setVersionRow(timestamp);
						}
						
													
						facturaAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public FacturaParameterReturnGeneral cargarCombosLoteForeignKeyFacturaWithConnection(String finalQueryGlobalEmpresa,String finalQueryGlobalSucursal,String finalQueryGlobalEjercicio,String finalQueryGlobalPeriodo,String finalQueryGlobalAnio,String finalQueryGlobalMes,String finalQueryGlobalUsuario,String finalQueryGlobalMoneda,String finalQueryGlobalEmpleado,String finalQueryGlobalFormato,String finalQueryGlobalCliente,String finalQueryGlobalTipoPrecio,String finalQueryGlobalSubCliente,String finalQueryGlobalVendedor,String finalQueryGlobalTransporte,String finalQueryGlobalTransportista,String finalQueryGlobalTipoLlamada,String finalQueryGlobalTipoFactura,String finalQueryGlobalTipoCambio,String finalQueryGlobalAsientoContable,String finalQueryGlobalPedido,String finalQueryGlobalResponsable,String finalQueryGlobalEstadoFisicoFacturaEmpresa) throws Exception {
		FacturaParameterReturnGeneral  facturaReturnGeneral =new FacturaParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Factura.class.getSimpleName()+"-cargarCombosLoteForeignKeyFacturaWithConnection");connexion.begin();
			
			facturaReturnGeneral =new FacturaParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			facturaReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Sucursal> sucursalsForeignKey=new ArrayList<Sucursal>();
			SucursalLogic sucursalLogic=new SucursalLogic();
			sucursalLogic.setConnexion(this.connexion);
			//sucursalLogic.getSucursalDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalSucursal.equals("NONE")) {
				sucursalLogic.getTodosSucursals(finalQueryGlobalSucursal,new Pagination());
				sucursalsForeignKey=sucursalLogic.getSucursals();
			}

			facturaReturnGeneral.setsucursalsForeignKey(sucursalsForeignKey);


			List<Ejercicio> ejerciciosForeignKey=new ArrayList<Ejercicio>();
			EjercicioLogic ejercicioLogic=new EjercicioLogic();
			ejercicioLogic.setConnexion(this.connexion);
			//ejercicioLogic.getEjercicioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEjercicio.equals("NONE")) {
				ejercicioLogic.getTodosEjercicios(finalQueryGlobalEjercicio,new Pagination());
				ejerciciosForeignKey=ejercicioLogic.getEjercicios();
			}

			facturaReturnGeneral.setejerciciosForeignKey(ejerciciosForeignKey);


			List<Periodo> periodosForeignKey=new ArrayList<Periodo>();
			PeriodoLogic periodoLogic=new PeriodoLogic();
			periodoLogic.setConnexion(this.connexion);
			//periodoLogic.getPeriodoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalPeriodo.equals("NONE")) {
				periodoLogic.getTodosPeriodos(finalQueryGlobalPeriodo,new Pagination());
				periodosForeignKey=periodoLogic.getPeriodos();
			}

			facturaReturnGeneral.setperiodosForeignKey(periodosForeignKey);


			List<Anio> aniosForeignKey=new ArrayList<Anio>();
			AnioLogic anioLogic=new AnioLogic();
			anioLogic.setConnexion(this.connexion);
			anioLogic.getAnioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalAnio.equals("NONE")) {
				anioLogic.getTodosAnios(finalQueryGlobalAnio,new Pagination());
				aniosForeignKey=anioLogic.getAnios();
			}

			facturaReturnGeneral.setaniosForeignKey(aniosForeignKey);


			List<Mes> messForeignKey=new ArrayList<Mes>();
			MesLogic mesLogic=new MesLogic();
			mesLogic.setConnexion(this.connexion);
			mesLogic.getMesDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalMes.equals("NONE")) {
				mesLogic.getTodosMess(finalQueryGlobalMes,new Pagination());
				messForeignKey=mesLogic.getMess();
			}

			facturaReturnGeneral.setmessForeignKey(messForeignKey);


			List<Usuario> usuariosForeignKey=new ArrayList<Usuario>();
			UsuarioLogic usuarioLogic=new UsuarioLogic();
			usuarioLogic.setConnexion(this.connexion);
			//usuarioLogic.getUsuarioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalUsuario.equals("NONE")) {
				usuarioLogic.getTodosUsuarios(finalQueryGlobalUsuario,new Pagination());
				usuariosForeignKey=usuarioLogic.getUsuarios();
			}

			facturaReturnGeneral.setusuariosForeignKey(usuariosForeignKey);


			List<Moneda> monedasForeignKey=new ArrayList<Moneda>();
			MonedaLogic monedaLogic=new MonedaLogic();
			monedaLogic.setConnexion(this.connexion);
			//monedaLogic.getMonedaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalMoneda.equals("NONE")) {
				monedaLogic.getTodosMonedas(finalQueryGlobalMoneda,new Pagination());
				monedasForeignKey=monedaLogic.getMonedas();
			}

			facturaReturnGeneral.setmonedasForeignKey(monedasForeignKey);


			List<Empleado> empleadosForeignKey=new ArrayList<Empleado>();
			EmpleadoLogic empleadoLogic=new EmpleadoLogic();
			empleadoLogic.setConnexion(this.connexion);
			empleadoLogic.getEmpleadoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpleado.equals("NONE")) {
				empleadoLogic.getTodosEmpleados(finalQueryGlobalEmpleado,new Pagination());
				empleadosForeignKey=empleadoLogic.getEmpleados();
			}

			facturaReturnGeneral.setempleadosForeignKey(empleadosForeignKey);


			List<Formato> formatosForeignKey=new ArrayList<Formato>();
			FormatoLogic formatoLogic=new FormatoLogic();
			formatoLogic.setConnexion(this.connexion);
			formatoLogic.getFormatoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalFormato.equals("NONE")) {
				formatoLogic.getTodosFormatos(finalQueryGlobalFormato,new Pagination());
				formatosForeignKey=formatoLogic.getFormatos();
			}

			facturaReturnGeneral.setformatosForeignKey(formatosForeignKey);


			List<Cliente> clientesForeignKey=new ArrayList<Cliente>();
			ClienteLogic clienteLogic=new ClienteLogic();
			clienteLogic.setConnexion(this.connexion);
			clienteLogic.getClienteDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCliente.equals("NONE")) {
				clienteLogic.getTodosClientes(finalQueryGlobalCliente,new Pagination());
				clientesForeignKey=clienteLogic.getClientes();
			}

			facturaReturnGeneral.setclientesForeignKey(clientesForeignKey);


			List<TipoPrecio> tipopreciosForeignKey=new ArrayList<TipoPrecio>();
			TipoPrecioLogic tipoprecioLogic=new TipoPrecioLogic();
			tipoprecioLogic.setConnexion(this.connexion);
			tipoprecioLogic.getTipoPrecioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoPrecio.equals("NONE")) {
				tipoprecioLogic.getTodosTipoPrecios(finalQueryGlobalTipoPrecio,new Pagination());
				tipopreciosForeignKey=tipoprecioLogic.getTipoPrecios();
			}

			facturaReturnGeneral.settipopreciosForeignKey(tipopreciosForeignKey);


			List<SubCliente> subclientesForeignKey=new ArrayList<SubCliente>();
			SubClienteLogic subclienteLogic=new SubClienteLogic();
			subclienteLogic.setConnexion(this.connexion);
			subclienteLogic.getSubClienteDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalSubCliente.equals("NONE")) {
				subclienteLogic.getTodosSubClientes(finalQueryGlobalSubCliente,new Pagination());
				subclientesForeignKey=subclienteLogic.getSubClientes();
			}

			facturaReturnGeneral.setsubclientesForeignKey(subclientesForeignKey);


			List<Vendedor> vendedorsForeignKey=new ArrayList<Vendedor>();
			VendedorLogic vendedorLogic=new VendedorLogic();
			vendedorLogic.setConnexion(this.connexion);
			vendedorLogic.getVendedorDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalVendedor.equals("NONE")) {
				vendedorLogic.getTodosVendedors(finalQueryGlobalVendedor,new Pagination());
				vendedorsForeignKey=vendedorLogic.getVendedors();
			}

			facturaReturnGeneral.setvendedorsForeignKey(vendedorsForeignKey);


			List<Transporte> transportesForeignKey=new ArrayList<Transporte>();
			TransporteLogic transporteLogic=new TransporteLogic();
			transporteLogic.setConnexion(this.connexion);
			transporteLogic.getTransporteDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTransporte.equals("NONE")) {
				transporteLogic.getTodosTransportes(finalQueryGlobalTransporte,new Pagination());
				transportesForeignKey=transporteLogic.getTransportes();
			}

			facturaReturnGeneral.settransportesForeignKey(transportesForeignKey);


			List<Transportista> transportistasForeignKey=new ArrayList<Transportista>();
			TransportistaLogic transportistaLogic=new TransportistaLogic();
			transportistaLogic.setConnexion(this.connexion);
			transportistaLogic.getTransportistaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTransportista.equals("NONE")) {
				transportistaLogic.getTodosTransportistas(finalQueryGlobalTransportista,new Pagination());
				transportistasForeignKey=transportistaLogic.getTransportistas();
			}

			facturaReturnGeneral.settransportistasForeignKey(transportistasForeignKey);


			List<TipoLlamada> tipollamadasForeignKey=new ArrayList<TipoLlamada>();
			TipoLlamadaLogic tipollamadaLogic=new TipoLlamadaLogic();
			tipollamadaLogic.setConnexion(this.connexion);
			tipollamadaLogic.getTipoLlamadaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoLlamada.equals("NONE")) {
				tipollamadaLogic.getTodosTipoLlamadas(finalQueryGlobalTipoLlamada,new Pagination());
				tipollamadasForeignKey=tipollamadaLogic.getTipoLlamadas();
			}

			facturaReturnGeneral.settipollamadasForeignKey(tipollamadasForeignKey);


			List<TipoFactura> tipofacturasForeignKey=new ArrayList<TipoFactura>();
			TipoFacturaLogic tipofacturaLogic=new TipoFacturaLogic();
			tipofacturaLogic.setConnexion(this.connexion);
			tipofacturaLogic.getTipoFacturaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoFactura.equals("NONE")) {
				tipofacturaLogic.getTodosTipoFacturas(finalQueryGlobalTipoFactura,new Pagination());
				tipofacturasForeignKey=tipofacturaLogic.getTipoFacturas();
			}

			facturaReturnGeneral.settipofacturasForeignKey(tipofacturasForeignKey);


			List<TipoCambio> tipocambiosForeignKey=new ArrayList<TipoCambio>();
			TipoCambioLogic tipocambioLogic=new TipoCambioLogic();
			tipocambioLogic.setConnexion(this.connexion);
			tipocambioLogic.getTipoCambioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoCambio.equals("NONE")) {
				tipocambioLogic.getTodosTipoCambios(finalQueryGlobalTipoCambio,new Pagination());
				tipocambiosForeignKey=tipocambioLogic.getTipoCambios();
			}

			facturaReturnGeneral.settipocambiosForeignKey(tipocambiosForeignKey);


			List<AsientoContable> asientocontablesForeignKey=new ArrayList<AsientoContable>();
			AsientoContableLogic asientocontableLogic=new AsientoContableLogic();
			asientocontableLogic.setConnexion(this.connexion);
			asientocontableLogic.getAsientoContableDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalAsientoContable.equals("NONE")) {
				asientocontableLogic.getTodosAsientoContables(finalQueryGlobalAsientoContable,new Pagination());
				asientocontablesForeignKey=asientocontableLogic.getAsientoContables();
			}

			facturaReturnGeneral.setasientocontablesForeignKey(asientocontablesForeignKey);


			List<Pedido> pedidosForeignKey=new ArrayList<Pedido>();
			PedidoLogic pedidoLogic=new PedidoLogic();
			pedidoLogic.setConnexion(this.connexion);
			pedidoLogic.getPedidoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalPedido.equals("NONE")) {
				pedidoLogic.getTodosPedidos(finalQueryGlobalPedido,new Pagination());
				pedidosForeignKey=pedidoLogic.getPedidos();
			}

			facturaReturnGeneral.setpedidosForeignKey(pedidosForeignKey);


			List<Responsable> responsablesForeignKey=new ArrayList<Responsable>();
			ResponsableLogic responsableLogic=new ResponsableLogic();
			responsableLogic.setConnexion(this.connexion);
			responsableLogic.getResponsableDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalResponsable.equals("NONE")) {
				responsableLogic.getTodosResponsables(finalQueryGlobalResponsable,new Pagination());
				responsablesForeignKey=responsableLogic.getResponsables();
			}

			facturaReturnGeneral.setresponsablesForeignKey(responsablesForeignKey);


			List<EstadoFisicoFacturaEmpresa> estadofisicofacturaempresasForeignKey=new ArrayList<EstadoFisicoFacturaEmpresa>();
			EstadoFisicoFacturaEmpresaLogic estadofisicofacturaempresaLogic=new EstadoFisicoFacturaEmpresaLogic();
			estadofisicofacturaempresaLogic.setConnexion(this.connexion);
			estadofisicofacturaempresaLogic.getEstadoFisicoFacturaEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEstadoFisicoFacturaEmpresa.equals("NONE")) {
				estadofisicofacturaempresaLogic.getTodosEstadoFisicoFacturaEmpresas(finalQueryGlobalEstadoFisicoFacturaEmpresa,new Pagination());
				estadofisicofacturaempresasForeignKey=estadofisicofacturaempresaLogic.getEstadoFisicoFacturaEmpresas();
			}

			facturaReturnGeneral.setestadofisicofacturaempresasForeignKey(estadofisicofacturaempresasForeignKey);

			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
		
		return facturaReturnGeneral;
	}
	
	public FacturaParameterReturnGeneral cargarCombosLoteForeignKeyFactura(String finalQueryGlobalEmpresa,String finalQueryGlobalSucursal,String finalQueryGlobalEjercicio,String finalQueryGlobalPeriodo,String finalQueryGlobalAnio,String finalQueryGlobalMes,String finalQueryGlobalUsuario,String finalQueryGlobalMoneda,String finalQueryGlobalEmpleado,String finalQueryGlobalFormato,String finalQueryGlobalCliente,String finalQueryGlobalTipoPrecio,String finalQueryGlobalSubCliente,String finalQueryGlobalVendedor,String finalQueryGlobalTransporte,String finalQueryGlobalTransportista,String finalQueryGlobalTipoLlamada,String finalQueryGlobalTipoFactura,String finalQueryGlobalTipoCambio,String finalQueryGlobalAsientoContable,String finalQueryGlobalPedido,String finalQueryGlobalResponsable,String finalQueryGlobalEstadoFisicoFacturaEmpresa) throws Exception {
		FacturaParameterReturnGeneral  facturaReturnGeneral =new FacturaParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {						
			facturaReturnGeneral =new FacturaParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			facturaReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Sucursal> sucursalsForeignKey=new ArrayList<Sucursal>();
			SucursalLogic sucursalLogic=new SucursalLogic();
			sucursalLogic.setConnexion(this.connexion);
			//sucursalLogic.getSucursalDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalSucursal.equals("NONE")) {
				sucursalLogic.getTodosSucursals(finalQueryGlobalSucursal,new Pagination());
				sucursalsForeignKey=sucursalLogic.getSucursals();
			}

			facturaReturnGeneral.setsucursalsForeignKey(sucursalsForeignKey);


			List<Ejercicio> ejerciciosForeignKey=new ArrayList<Ejercicio>();
			EjercicioLogic ejercicioLogic=new EjercicioLogic();
			ejercicioLogic.setConnexion(this.connexion);
			//ejercicioLogic.getEjercicioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEjercicio.equals("NONE")) {
				ejercicioLogic.getTodosEjercicios(finalQueryGlobalEjercicio,new Pagination());
				ejerciciosForeignKey=ejercicioLogic.getEjercicios();
			}

			facturaReturnGeneral.setejerciciosForeignKey(ejerciciosForeignKey);


			List<Periodo> periodosForeignKey=new ArrayList<Periodo>();
			PeriodoLogic periodoLogic=new PeriodoLogic();
			periodoLogic.setConnexion(this.connexion);
			//periodoLogic.getPeriodoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalPeriodo.equals("NONE")) {
				periodoLogic.getTodosPeriodos(finalQueryGlobalPeriodo,new Pagination());
				periodosForeignKey=periodoLogic.getPeriodos();
			}

			facturaReturnGeneral.setperiodosForeignKey(periodosForeignKey);


			List<Anio> aniosForeignKey=new ArrayList<Anio>();
			AnioLogic anioLogic=new AnioLogic();
			anioLogic.setConnexion(this.connexion);
			anioLogic.getAnioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalAnio.equals("NONE")) {
				anioLogic.getTodosAnios(finalQueryGlobalAnio,new Pagination());
				aniosForeignKey=anioLogic.getAnios();
			}

			facturaReturnGeneral.setaniosForeignKey(aniosForeignKey);


			List<Mes> messForeignKey=new ArrayList<Mes>();
			MesLogic mesLogic=new MesLogic();
			mesLogic.setConnexion(this.connexion);
			mesLogic.getMesDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalMes.equals("NONE")) {
				mesLogic.getTodosMess(finalQueryGlobalMes,new Pagination());
				messForeignKey=mesLogic.getMess();
			}

			facturaReturnGeneral.setmessForeignKey(messForeignKey);


			List<Usuario> usuariosForeignKey=new ArrayList<Usuario>();
			UsuarioLogic usuarioLogic=new UsuarioLogic();
			usuarioLogic.setConnexion(this.connexion);
			//usuarioLogic.getUsuarioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalUsuario.equals("NONE")) {
				usuarioLogic.getTodosUsuarios(finalQueryGlobalUsuario,new Pagination());
				usuariosForeignKey=usuarioLogic.getUsuarios();
			}

			facturaReturnGeneral.setusuariosForeignKey(usuariosForeignKey);


			List<Moneda> monedasForeignKey=new ArrayList<Moneda>();
			MonedaLogic monedaLogic=new MonedaLogic();
			monedaLogic.setConnexion(this.connexion);
			//monedaLogic.getMonedaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalMoneda.equals("NONE")) {
				monedaLogic.getTodosMonedas(finalQueryGlobalMoneda,new Pagination());
				monedasForeignKey=monedaLogic.getMonedas();
			}

			facturaReturnGeneral.setmonedasForeignKey(monedasForeignKey);


			List<Empleado> empleadosForeignKey=new ArrayList<Empleado>();
			EmpleadoLogic empleadoLogic=new EmpleadoLogic();
			empleadoLogic.setConnexion(this.connexion);
			empleadoLogic.getEmpleadoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpleado.equals("NONE")) {
				empleadoLogic.getTodosEmpleados(finalQueryGlobalEmpleado,new Pagination());
				empleadosForeignKey=empleadoLogic.getEmpleados();
			}

			facturaReturnGeneral.setempleadosForeignKey(empleadosForeignKey);


			List<Formato> formatosForeignKey=new ArrayList<Formato>();
			FormatoLogic formatoLogic=new FormatoLogic();
			formatoLogic.setConnexion(this.connexion);
			formatoLogic.getFormatoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalFormato.equals("NONE")) {
				formatoLogic.getTodosFormatos(finalQueryGlobalFormato,new Pagination());
				formatosForeignKey=formatoLogic.getFormatos();
			}

			facturaReturnGeneral.setformatosForeignKey(formatosForeignKey);


			List<Cliente> clientesForeignKey=new ArrayList<Cliente>();
			ClienteLogic clienteLogic=new ClienteLogic();
			clienteLogic.setConnexion(this.connexion);
			clienteLogic.getClienteDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCliente.equals("NONE")) {
				clienteLogic.getTodosClientes(finalQueryGlobalCliente,new Pagination());
				clientesForeignKey=clienteLogic.getClientes();
			}

			facturaReturnGeneral.setclientesForeignKey(clientesForeignKey);


			List<TipoPrecio> tipopreciosForeignKey=new ArrayList<TipoPrecio>();
			TipoPrecioLogic tipoprecioLogic=new TipoPrecioLogic();
			tipoprecioLogic.setConnexion(this.connexion);
			tipoprecioLogic.getTipoPrecioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoPrecio.equals("NONE")) {
				tipoprecioLogic.getTodosTipoPrecios(finalQueryGlobalTipoPrecio,new Pagination());
				tipopreciosForeignKey=tipoprecioLogic.getTipoPrecios();
			}

			facturaReturnGeneral.settipopreciosForeignKey(tipopreciosForeignKey);


			List<SubCliente> subclientesForeignKey=new ArrayList<SubCliente>();
			SubClienteLogic subclienteLogic=new SubClienteLogic();
			subclienteLogic.setConnexion(this.connexion);
			subclienteLogic.getSubClienteDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalSubCliente.equals("NONE")) {
				subclienteLogic.getTodosSubClientes(finalQueryGlobalSubCliente,new Pagination());
				subclientesForeignKey=subclienteLogic.getSubClientes();
			}

			facturaReturnGeneral.setsubclientesForeignKey(subclientesForeignKey);


			List<Vendedor> vendedorsForeignKey=new ArrayList<Vendedor>();
			VendedorLogic vendedorLogic=new VendedorLogic();
			vendedorLogic.setConnexion(this.connexion);
			vendedorLogic.getVendedorDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalVendedor.equals("NONE")) {
				vendedorLogic.getTodosVendedors(finalQueryGlobalVendedor,new Pagination());
				vendedorsForeignKey=vendedorLogic.getVendedors();
			}

			facturaReturnGeneral.setvendedorsForeignKey(vendedorsForeignKey);


			List<Transporte> transportesForeignKey=new ArrayList<Transporte>();
			TransporteLogic transporteLogic=new TransporteLogic();
			transporteLogic.setConnexion(this.connexion);
			transporteLogic.getTransporteDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTransporte.equals("NONE")) {
				transporteLogic.getTodosTransportes(finalQueryGlobalTransporte,new Pagination());
				transportesForeignKey=transporteLogic.getTransportes();
			}

			facturaReturnGeneral.settransportesForeignKey(transportesForeignKey);


			List<Transportista> transportistasForeignKey=new ArrayList<Transportista>();
			TransportistaLogic transportistaLogic=new TransportistaLogic();
			transportistaLogic.setConnexion(this.connexion);
			transportistaLogic.getTransportistaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTransportista.equals("NONE")) {
				transportistaLogic.getTodosTransportistas(finalQueryGlobalTransportista,new Pagination());
				transportistasForeignKey=transportistaLogic.getTransportistas();
			}

			facturaReturnGeneral.settransportistasForeignKey(transportistasForeignKey);


			List<TipoLlamada> tipollamadasForeignKey=new ArrayList<TipoLlamada>();
			TipoLlamadaLogic tipollamadaLogic=new TipoLlamadaLogic();
			tipollamadaLogic.setConnexion(this.connexion);
			tipollamadaLogic.getTipoLlamadaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoLlamada.equals("NONE")) {
				tipollamadaLogic.getTodosTipoLlamadas(finalQueryGlobalTipoLlamada,new Pagination());
				tipollamadasForeignKey=tipollamadaLogic.getTipoLlamadas();
			}

			facturaReturnGeneral.settipollamadasForeignKey(tipollamadasForeignKey);


			List<TipoFactura> tipofacturasForeignKey=new ArrayList<TipoFactura>();
			TipoFacturaLogic tipofacturaLogic=new TipoFacturaLogic();
			tipofacturaLogic.setConnexion(this.connexion);
			tipofacturaLogic.getTipoFacturaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoFactura.equals("NONE")) {
				tipofacturaLogic.getTodosTipoFacturas(finalQueryGlobalTipoFactura,new Pagination());
				tipofacturasForeignKey=tipofacturaLogic.getTipoFacturas();
			}

			facturaReturnGeneral.settipofacturasForeignKey(tipofacturasForeignKey);


			List<TipoCambio> tipocambiosForeignKey=new ArrayList<TipoCambio>();
			TipoCambioLogic tipocambioLogic=new TipoCambioLogic();
			tipocambioLogic.setConnexion(this.connexion);
			tipocambioLogic.getTipoCambioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoCambio.equals("NONE")) {
				tipocambioLogic.getTodosTipoCambios(finalQueryGlobalTipoCambio,new Pagination());
				tipocambiosForeignKey=tipocambioLogic.getTipoCambios();
			}

			facturaReturnGeneral.settipocambiosForeignKey(tipocambiosForeignKey);


			List<AsientoContable> asientocontablesForeignKey=new ArrayList<AsientoContable>();
			AsientoContableLogic asientocontableLogic=new AsientoContableLogic();
			asientocontableLogic.setConnexion(this.connexion);
			asientocontableLogic.getAsientoContableDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalAsientoContable.equals("NONE")) {
				asientocontableLogic.getTodosAsientoContables(finalQueryGlobalAsientoContable,new Pagination());
				asientocontablesForeignKey=asientocontableLogic.getAsientoContables();
			}

			facturaReturnGeneral.setasientocontablesForeignKey(asientocontablesForeignKey);


			List<Pedido> pedidosForeignKey=new ArrayList<Pedido>();
			PedidoLogic pedidoLogic=new PedidoLogic();
			pedidoLogic.setConnexion(this.connexion);
			pedidoLogic.getPedidoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalPedido.equals("NONE")) {
				pedidoLogic.getTodosPedidos(finalQueryGlobalPedido,new Pagination());
				pedidosForeignKey=pedidoLogic.getPedidos();
			}

			facturaReturnGeneral.setpedidosForeignKey(pedidosForeignKey);


			List<Responsable> responsablesForeignKey=new ArrayList<Responsable>();
			ResponsableLogic responsableLogic=new ResponsableLogic();
			responsableLogic.setConnexion(this.connexion);
			responsableLogic.getResponsableDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalResponsable.equals("NONE")) {
				responsableLogic.getTodosResponsables(finalQueryGlobalResponsable,new Pagination());
				responsablesForeignKey=responsableLogic.getResponsables();
			}

			facturaReturnGeneral.setresponsablesForeignKey(responsablesForeignKey);


			List<EstadoFisicoFacturaEmpresa> estadofisicofacturaempresasForeignKey=new ArrayList<EstadoFisicoFacturaEmpresa>();
			EstadoFisicoFacturaEmpresaLogic estadofisicofacturaempresaLogic=new EstadoFisicoFacturaEmpresaLogic();
			estadofisicofacturaempresaLogic.setConnexion(this.connexion);
			estadofisicofacturaempresaLogic.getEstadoFisicoFacturaEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEstadoFisicoFacturaEmpresa.equals("NONE")) {
				estadofisicofacturaempresaLogic.getTodosEstadoFisicoFacturaEmpresas(finalQueryGlobalEstadoFisicoFacturaEmpresa,new Pagination());
				estadofisicofacturaempresasForeignKey=estadofisicofacturaempresaLogic.getEstadoFisicoFacturaEmpresas();
			}

			facturaReturnGeneral.setestadofisicofacturaempresasForeignKey(estadofisicofacturaempresasForeignKey);
						
			
		} catch(Exception e) {			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			
		}
		
		return facturaReturnGeneral;
	}
	
	public void cargarRelacionesLoteForeignKeyFacturaWithConnection() throws Exception {
		ArrayList<Classe> classes=new ArrayList<Classe>();		
		
		
			DetaFormaPagoLogic detaformapagoLogic=new DetaFormaPagoLogic();
			DetalleFacturaLogic detallefacturaLogic=new DetalleFacturaLogic();
		
		try {
			
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Factura.class.getSimpleName()+"-cargarRelacionesLoteForeignKeyFacturaWithConnection");connexion.begin();
			
			
			classes.add(new Classe(DetaFormaPago.class));
			classes.add(new Classe(DetalleFactura.class));
											
			

			detaformapagoLogic.setConnexion(this.getConnexion());
			detaformapagoLogic.setDatosCliente(this.datosCliente);
			detaformapagoLogic.setIsConRefrescarForeignKeys(true);

			detallefacturaLogic.setConnexion(this.getConnexion());
			detallefacturaLogic.setDatosCliente(this.datosCliente);
			detallefacturaLogic.setIsConRefrescarForeignKeys(true);
			
			this.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
			
			for(Factura factura:this.facturas) {
				

				classes=new ArrayList<Classe>();
				classes=DetaFormaPagoConstantesFunciones.getClassesForeignKeysOfDetaFormaPago(new ArrayList<Classe>(),DeepLoadType.NONE);

				detaformapagoLogic.setDetaFormaPagos(factura.detaformapagos);
				detaformapagoLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");

				classes=new ArrayList<Classe>();
				classes=DetalleFacturaConstantesFunciones.getClassesForeignKeysOfDetalleFactura(new ArrayList<Classe>(),DeepLoadType.NONE);

				detallefacturaLogic.setDetalleFacturas(factura.detallefacturas);
				detallefacturaLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
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
	
	public void deepLoad(Factura factura,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			FacturaLogicAdditional.updateFacturaToGet(factura,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		factura.setEmpresa(facturaDataAccess.getEmpresa(connexion,factura));
		factura.setSucursal(facturaDataAccess.getSucursal(connexion,factura));
		factura.setEjercicio(facturaDataAccess.getEjercicio(connexion,factura));
		factura.setPeriodo(facturaDataAccess.getPeriodo(connexion,factura));
		factura.setAnio(facturaDataAccess.getAnio(connexion,factura));
		factura.setMes(facturaDataAccess.getMes(connexion,factura));
		factura.setUsuario(facturaDataAccess.getUsuario(connexion,factura));
		factura.setMoneda(facturaDataAccess.getMoneda(connexion,factura));
		factura.setEmpleado(facturaDataAccess.getEmpleado(connexion,factura));
		factura.setFormato(facturaDataAccess.getFormato(connexion,factura));
		factura.setCliente(facturaDataAccess.getCliente(connexion,factura));
		factura.setTipoPrecio(facturaDataAccess.getTipoPrecio(connexion,factura));
		factura.setSubCliente(facturaDataAccess.getSubCliente(connexion,factura));
		factura.setVendedor(facturaDataAccess.getVendedor(connexion,factura));
		factura.setTransporte(facturaDataAccess.getTransporte(connexion,factura));
		factura.setTransportista(facturaDataAccess.getTransportista(connexion,factura));
		factura.setTipoLlamada(facturaDataAccess.getTipoLlamada(connexion,factura));
		factura.setTipoFactura(facturaDataAccess.getTipoFactura(connexion,factura));
		factura.setTipoCambio(facturaDataAccess.getTipoCambio(connexion,factura));
		factura.setAsientoContable(facturaDataAccess.getAsientoContable(connexion,factura));
		factura.setPedido(facturaDataAccess.getPedido(connexion,factura));
		factura.setResponsable(facturaDataAccess.getResponsable(connexion,factura));
		factura.setEstadoFisicoFacturaEmpresa(facturaDataAccess.getEstadoFisicoFacturaEmpresa(connexion,factura));
		factura.setDetaFormaPagos(facturaDataAccess.getDetaFormaPagos(connexion,factura));
		factura.setDetalleFacturas(facturaDataAccess.getDetalleFacturas(connexion,factura));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				factura.setEmpresa(facturaDataAccess.getEmpresa(connexion,factura));
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				factura.setSucursal(facturaDataAccess.getSucursal(connexion,factura));
				continue;
			}

			if(clas.clas.equals(Ejercicio.class)) {
				factura.setEjercicio(facturaDataAccess.getEjercicio(connexion,factura));
				continue;
			}

			if(clas.clas.equals(Periodo.class)) {
				factura.setPeriodo(facturaDataAccess.getPeriodo(connexion,factura));
				continue;
			}

			if(clas.clas.equals(Anio.class)) {
				factura.setAnio(facturaDataAccess.getAnio(connexion,factura));
				continue;
			}

			if(clas.clas.equals(Mes.class)) {
				factura.setMes(facturaDataAccess.getMes(connexion,factura));
				continue;
			}

			if(clas.clas.equals(Usuario.class)) {
				factura.setUsuario(facturaDataAccess.getUsuario(connexion,factura));
				continue;
			}

			if(clas.clas.equals(Moneda.class)) {
				factura.setMoneda(facturaDataAccess.getMoneda(connexion,factura));
				continue;
			}

			if(clas.clas.equals(Empleado.class)) {
				factura.setEmpleado(facturaDataAccess.getEmpleado(connexion,factura));
				continue;
			}

			if(clas.clas.equals(Formato.class)) {
				factura.setFormato(facturaDataAccess.getFormato(connexion,factura));
				continue;
			}

			if(clas.clas.equals(Cliente.class)) {
				factura.setCliente(facturaDataAccess.getCliente(connexion,factura));
				continue;
			}

			if(clas.clas.equals(TipoPrecio.class)) {
				factura.setTipoPrecio(facturaDataAccess.getTipoPrecio(connexion,factura));
				continue;
			}

			if(clas.clas.equals(SubCliente.class)) {
				factura.setSubCliente(facturaDataAccess.getSubCliente(connexion,factura));
				continue;
			}

			if(clas.clas.equals(Vendedor.class)) {
				factura.setVendedor(facturaDataAccess.getVendedor(connexion,factura));
				continue;
			}

			if(clas.clas.equals(Transporte.class)) {
				factura.setTransporte(facturaDataAccess.getTransporte(connexion,factura));
				continue;
			}

			if(clas.clas.equals(Transportista.class)) {
				factura.setTransportista(facturaDataAccess.getTransportista(connexion,factura));
				continue;
			}

			if(clas.clas.equals(TipoLlamada.class)) {
				factura.setTipoLlamada(facturaDataAccess.getTipoLlamada(connexion,factura));
				continue;
			}

			if(clas.clas.equals(TipoFactura.class)) {
				factura.setTipoFactura(facturaDataAccess.getTipoFactura(connexion,factura));
				continue;
			}

			if(clas.clas.equals(TipoCambio.class)) {
				factura.setTipoCambio(facturaDataAccess.getTipoCambio(connexion,factura));
				continue;
			}

			if(clas.clas.equals(AsientoContable.class)) {
				factura.setAsientoContable(facturaDataAccess.getAsientoContable(connexion,factura));
				continue;
			}

			if(clas.clas.equals(Pedido.class)) {
				factura.setPedido(facturaDataAccess.getPedido(connexion,factura));
				continue;
			}

			if(clas.clas.equals(Responsable.class)) {
				factura.setResponsable(facturaDataAccess.getResponsable(connexion,factura));
				continue;
			}

			if(clas.clas.equals(EstadoFisicoFacturaEmpresa.class)) {
				factura.setEstadoFisicoFacturaEmpresa(facturaDataAccess.getEstadoFisicoFacturaEmpresa(connexion,factura));
				continue;
			}

			if(clas.clas.equals(DetaFormaPago.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				factura.setDetaFormaPagos(facturaDataAccess.getDetaFormaPagos(connexion,factura));

				if(this.isConDeep) {
					DetaFormaPagoLogic detaformapagoLogic= new DetaFormaPagoLogic(this.connexion);
					detaformapagoLogic.setDetaFormaPagos(factura.getDetaFormaPagos());
					ArrayList<Classe> classesLocal=DetaFormaPagoConstantesFunciones.getClassesForeignKeysOfDetaFormaPago(new ArrayList<Classe>(),DeepLoadType.NONE);
					detaformapagoLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					DetaFormaPagoConstantesFunciones.refrescarForeignKeysDescripcionesDetaFormaPago(detaformapagoLogic.getDetaFormaPagos());
					factura.setDetaFormaPagos(detaformapagoLogic.getDetaFormaPagos());
				}

				continue;
			}

			if(clas.clas.equals(DetalleFactura.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				factura.setDetalleFacturas(facturaDataAccess.getDetalleFacturas(connexion,factura));

				if(this.isConDeep) {
					DetalleFacturaLogic detallefacturaLogic= new DetalleFacturaLogic(this.connexion);
					detallefacturaLogic.setDetalleFacturas(factura.getDetalleFacturas());
					ArrayList<Classe> classesLocal=DetalleFacturaConstantesFunciones.getClassesForeignKeysOfDetalleFactura(new ArrayList<Classe>(),DeepLoadType.NONE);
					detallefacturaLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					DetalleFacturaConstantesFunciones.refrescarForeignKeysDescripcionesDetalleFactura(detallefacturaLogic.getDetalleFacturas());
					factura.setDetalleFacturas(detallefacturaLogic.getDetalleFacturas());
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
			factura.setEmpresa(facturaDataAccess.getEmpresa(connexion,factura));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			factura.setSucursal(facturaDataAccess.getSucursal(connexion,factura));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Ejercicio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			factura.setEjercicio(facturaDataAccess.getEjercicio(connexion,factura));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Periodo.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			factura.setPeriodo(facturaDataAccess.getPeriodo(connexion,factura));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Anio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			factura.setAnio(facturaDataAccess.getAnio(connexion,factura));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Mes.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			factura.setMes(facturaDataAccess.getMes(connexion,factura));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Usuario.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			factura.setUsuario(facturaDataAccess.getUsuario(connexion,factura));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Moneda.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			factura.setMoneda(facturaDataAccess.getMoneda(connexion,factura));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Empleado.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			factura.setEmpleado(facturaDataAccess.getEmpleado(connexion,factura));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Formato.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			factura.setFormato(facturaDataAccess.getFormato(connexion,factura));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Cliente.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			factura.setCliente(facturaDataAccess.getCliente(connexion,factura));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(TipoPrecio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			factura.setTipoPrecio(facturaDataAccess.getTipoPrecio(connexion,factura));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(SubCliente.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			factura.setSubCliente(facturaDataAccess.getSubCliente(connexion,factura));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Vendedor.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			factura.setVendedor(facturaDataAccess.getVendedor(connexion,factura));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Transporte.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			factura.setTransporte(facturaDataAccess.getTransporte(connexion,factura));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Transportista.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			factura.setTransportista(facturaDataAccess.getTransportista(connexion,factura));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(TipoLlamada.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			factura.setTipoLlamada(facturaDataAccess.getTipoLlamada(connexion,factura));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(TipoFactura.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			factura.setTipoFactura(facturaDataAccess.getTipoFactura(connexion,factura));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(TipoCambio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			factura.setTipoCambio(facturaDataAccess.getTipoCambio(connexion,factura));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(AsientoContable.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			factura.setAsientoContable(facturaDataAccess.getAsientoContable(connexion,factura));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Pedido.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			factura.setPedido(facturaDataAccess.getPedido(connexion,factura));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Responsable.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			factura.setResponsable(facturaDataAccess.getResponsable(connexion,factura));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(EstadoFisicoFacturaEmpresa.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			factura.setEstadoFisicoFacturaEmpresa(facturaDataAccess.getEstadoFisicoFacturaEmpresa(connexion,factura));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(DetaFormaPago.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(DetaFormaPago.class));
			factura.setDetaFormaPagos(facturaDataAccess.getDetaFormaPagos(connexion,factura));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(DetalleFactura.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(DetalleFactura.class));
			factura.setDetalleFacturas(facturaDataAccess.getDetalleFacturas(connexion,factura));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		factura.setEmpresa(facturaDataAccess.getEmpresa(connexion,factura));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(factura.getEmpresa(),isDeep,deepLoadType,clases);
				
		factura.setSucursal(facturaDataAccess.getSucursal(connexion,factura));
		SucursalLogic sucursalLogic= new SucursalLogic(connexion);
		sucursalLogic.deepLoad(factura.getSucursal(),isDeep,deepLoadType,clases);
				
		factura.setEjercicio(facturaDataAccess.getEjercicio(connexion,factura));
		EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
		ejercicioLogic.deepLoad(factura.getEjercicio(),isDeep,deepLoadType,clases);
				
		factura.setPeriodo(facturaDataAccess.getPeriodo(connexion,factura));
		PeriodoLogic periodoLogic= new PeriodoLogic(connexion);
		periodoLogic.deepLoad(factura.getPeriodo(),isDeep,deepLoadType,clases);
				
		factura.setAnio(facturaDataAccess.getAnio(connexion,factura));
		AnioLogic anioLogic= new AnioLogic(connexion);
		anioLogic.deepLoad(factura.getAnio(),isDeep,deepLoadType,clases);
				
		factura.setMes(facturaDataAccess.getMes(connexion,factura));
		MesLogic mesLogic= new MesLogic(connexion);
		mesLogic.deepLoad(factura.getMes(),isDeep,deepLoadType,clases);
				
		factura.setUsuario(facturaDataAccess.getUsuario(connexion,factura));
		UsuarioLogic usuarioLogic= new UsuarioLogic(connexion);
		usuarioLogic.deepLoad(factura.getUsuario(),isDeep,deepLoadType,clases);
				
		factura.setMoneda(facturaDataAccess.getMoneda(connexion,factura));
		MonedaLogic monedaLogic= new MonedaLogic(connexion);
		monedaLogic.deepLoad(factura.getMoneda(),isDeep,deepLoadType,clases);
				
		factura.setEmpleado(facturaDataAccess.getEmpleado(connexion,factura));
		EmpleadoLogic empleadoLogic= new EmpleadoLogic(connexion);
		empleadoLogic.deepLoad(factura.getEmpleado(),isDeep,deepLoadType,clases);
				
		factura.setFormato(facturaDataAccess.getFormato(connexion,factura));
		FormatoLogic formatoLogic= new FormatoLogic(connexion);
		formatoLogic.deepLoad(factura.getFormato(),isDeep,deepLoadType,clases);
				
		factura.setCliente(facturaDataAccess.getCliente(connexion,factura));
		ClienteLogic clienteLogic= new ClienteLogic(connexion);
		clienteLogic.deepLoad(factura.getCliente(),isDeep,deepLoadType,clases);
				
		factura.setTipoPrecio(facturaDataAccess.getTipoPrecio(connexion,factura));
		TipoPrecioLogic tipoprecioLogic= new TipoPrecioLogic(connexion);
		tipoprecioLogic.deepLoad(factura.getTipoPrecio(),isDeep,deepLoadType,clases);
				
		factura.setSubCliente(facturaDataAccess.getSubCliente(connexion,factura));
		SubClienteLogic subclienteLogic= new SubClienteLogic(connexion);
		subclienteLogic.deepLoad(factura.getSubCliente(),isDeep,deepLoadType,clases);
				
		factura.setVendedor(facturaDataAccess.getVendedor(connexion,factura));
		VendedorLogic vendedorLogic= new VendedorLogic(connexion);
		vendedorLogic.deepLoad(factura.getVendedor(),isDeep,deepLoadType,clases);
				
		factura.setTransporte(facturaDataAccess.getTransporte(connexion,factura));
		TransporteLogic transporteLogic= new TransporteLogic(connexion);
		transporteLogic.deepLoad(factura.getTransporte(),isDeep,deepLoadType,clases);
				
		factura.setTransportista(facturaDataAccess.getTransportista(connexion,factura));
		TransportistaLogic transportistaLogic= new TransportistaLogic(connexion);
		transportistaLogic.deepLoad(factura.getTransportista(),isDeep,deepLoadType,clases);
				
		factura.setTipoLlamada(facturaDataAccess.getTipoLlamada(connexion,factura));
		TipoLlamadaLogic tipollamadaLogic= new TipoLlamadaLogic(connexion);
		tipollamadaLogic.deepLoad(factura.getTipoLlamada(),isDeep,deepLoadType,clases);
				
		factura.setTipoFactura(facturaDataAccess.getTipoFactura(connexion,factura));
		TipoFacturaLogic tipofacturaLogic= new TipoFacturaLogic(connexion);
		tipofacturaLogic.deepLoad(factura.getTipoFactura(),isDeep,deepLoadType,clases);
				
		factura.setTipoCambio(facturaDataAccess.getTipoCambio(connexion,factura));
		TipoCambioLogic tipocambioLogic= new TipoCambioLogic(connexion);
		tipocambioLogic.deepLoad(factura.getTipoCambio(),isDeep,deepLoadType,clases);
				
		factura.setAsientoContable(facturaDataAccess.getAsientoContable(connexion,factura));
		AsientoContableLogic asientocontableLogic= new AsientoContableLogic(connexion);
		asientocontableLogic.deepLoad(factura.getAsientoContable(),isDeep,deepLoadType,clases);
				
		factura.setPedido(facturaDataAccess.getPedido(connexion,factura));
		PedidoLogic pedidoLogic= new PedidoLogic(connexion);
		pedidoLogic.deepLoad(factura.getPedido(),isDeep,deepLoadType,clases);
				
		factura.setResponsable(facturaDataAccess.getResponsable(connexion,factura));
		ResponsableLogic responsableLogic= new ResponsableLogic(connexion);
		responsableLogic.deepLoad(factura.getResponsable(),isDeep,deepLoadType,clases);
				
		factura.setEstadoFisicoFacturaEmpresa(facturaDataAccess.getEstadoFisicoFacturaEmpresa(connexion,factura));
		EstadoFisicoFacturaEmpresaLogic estadofisicofacturaempresaLogic= new EstadoFisicoFacturaEmpresaLogic(connexion);
		estadofisicofacturaempresaLogic.deepLoad(factura.getEstadoFisicoFacturaEmpresa(),isDeep,deepLoadType,clases);
				

		factura.setDetaFormaPagos(facturaDataAccess.getDetaFormaPagos(connexion,factura));

		for(DetaFormaPago detaformapago:factura.getDetaFormaPagos()) {
			DetaFormaPagoLogic detaformapagoLogic= new DetaFormaPagoLogic(connexion);
			detaformapagoLogic.deepLoad(detaformapago,isDeep,deepLoadType,clases);
		}

		factura.setDetalleFacturas(facturaDataAccess.getDetalleFacturas(connexion,factura));

		for(DetalleFactura detallefactura:factura.getDetalleFacturas()) {
			DetalleFacturaLogic detallefacturaLogic= new DetalleFacturaLogic(connexion);
			detallefacturaLogic.deepLoad(detallefactura,isDeep,deepLoadType,clases);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				factura.setEmpresa(facturaDataAccess.getEmpresa(connexion,factura));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(factura.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				factura.setSucursal(facturaDataAccess.getSucursal(connexion,factura));
				SucursalLogic sucursalLogic= new SucursalLogic(connexion);
				sucursalLogic.deepLoad(factura.getSucursal(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Ejercicio.class)) {
				factura.setEjercicio(facturaDataAccess.getEjercicio(connexion,factura));
				EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
				ejercicioLogic.deepLoad(factura.getEjercicio(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Periodo.class)) {
				factura.setPeriodo(facturaDataAccess.getPeriodo(connexion,factura));
				PeriodoLogic periodoLogic= new PeriodoLogic(connexion);
				periodoLogic.deepLoad(factura.getPeriodo(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Anio.class)) {
				factura.setAnio(facturaDataAccess.getAnio(connexion,factura));
				AnioLogic anioLogic= new AnioLogic(connexion);
				anioLogic.deepLoad(factura.getAnio(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Mes.class)) {
				factura.setMes(facturaDataAccess.getMes(connexion,factura));
				MesLogic mesLogic= new MesLogic(connexion);
				mesLogic.deepLoad(factura.getMes(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Usuario.class)) {
				factura.setUsuario(facturaDataAccess.getUsuario(connexion,factura));
				UsuarioLogic usuarioLogic= new UsuarioLogic(connexion);
				usuarioLogic.deepLoad(factura.getUsuario(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Moneda.class)) {
				factura.setMoneda(facturaDataAccess.getMoneda(connexion,factura));
				MonedaLogic monedaLogic= new MonedaLogic(connexion);
				monedaLogic.deepLoad(factura.getMoneda(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Empleado.class)) {
				factura.setEmpleado(facturaDataAccess.getEmpleado(connexion,factura));
				EmpleadoLogic empleadoLogic= new EmpleadoLogic(connexion);
				empleadoLogic.deepLoad(factura.getEmpleado(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Formato.class)) {
				factura.setFormato(facturaDataAccess.getFormato(connexion,factura));
				FormatoLogic formatoLogic= new FormatoLogic(connexion);
				formatoLogic.deepLoad(factura.getFormato(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Cliente.class)) {
				factura.setCliente(facturaDataAccess.getCliente(connexion,factura));
				ClienteLogic clienteLogic= new ClienteLogic(connexion);
				clienteLogic.deepLoad(factura.getCliente(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoPrecio.class)) {
				factura.setTipoPrecio(facturaDataAccess.getTipoPrecio(connexion,factura));
				TipoPrecioLogic tipoprecioLogic= new TipoPrecioLogic(connexion);
				tipoprecioLogic.deepLoad(factura.getTipoPrecio(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(SubCliente.class)) {
				factura.setSubCliente(facturaDataAccess.getSubCliente(connexion,factura));
				SubClienteLogic subclienteLogic= new SubClienteLogic(connexion);
				subclienteLogic.deepLoad(factura.getSubCliente(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Vendedor.class)) {
				factura.setVendedor(facturaDataAccess.getVendedor(connexion,factura));
				VendedorLogic vendedorLogic= new VendedorLogic(connexion);
				vendedorLogic.deepLoad(factura.getVendedor(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Transporte.class)) {
				factura.setTransporte(facturaDataAccess.getTransporte(connexion,factura));
				TransporteLogic transporteLogic= new TransporteLogic(connexion);
				transporteLogic.deepLoad(factura.getTransporte(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Transportista.class)) {
				factura.setTransportista(facturaDataAccess.getTransportista(connexion,factura));
				TransportistaLogic transportistaLogic= new TransportistaLogic(connexion);
				transportistaLogic.deepLoad(factura.getTransportista(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoLlamada.class)) {
				factura.setTipoLlamada(facturaDataAccess.getTipoLlamada(connexion,factura));
				TipoLlamadaLogic tipollamadaLogic= new TipoLlamadaLogic(connexion);
				tipollamadaLogic.deepLoad(factura.getTipoLlamada(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoFactura.class)) {
				factura.setTipoFactura(facturaDataAccess.getTipoFactura(connexion,factura));
				TipoFacturaLogic tipofacturaLogic= new TipoFacturaLogic(connexion);
				tipofacturaLogic.deepLoad(factura.getTipoFactura(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoCambio.class)) {
				factura.setTipoCambio(facturaDataAccess.getTipoCambio(connexion,factura));
				TipoCambioLogic tipocambioLogic= new TipoCambioLogic(connexion);
				tipocambioLogic.deepLoad(factura.getTipoCambio(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(AsientoContable.class)) {
				factura.setAsientoContable(facturaDataAccess.getAsientoContable(connexion,factura));
				AsientoContableLogic asientocontableLogic= new AsientoContableLogic(connexion);
				asientocontableLogic.deepLoad(factura.getAsientoContable(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Pedido.class)) {
				factura.setPedido(facturaDataAccess.getPedido(connexion,factura));
				PedidoLogic pedidoLogic= new PedidoLogic(connexion);
				pedidoLogic.deepLoad(factura.getPedido(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Responsable.class)) {
				factura.setResponsable(facturaDataAccess.getResponsable(connexion,factura));
				ResponsableLogic responsableLogic= new ResponsableLogic(connexion);
				responsableLogic.deepLoad(factura.getResponsable(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(EstadoFisicoFacturaEmpresa.class)) {
				factura.setEstadoFisicoFacturaEmpresa(facturaDataAccess.getEstadoFisicoFacturaEmpresa(connexion,factura));
				EstadoFisicoFacturaEmpresaLogic estadofisicofacturaempresaLogic= new EstadoFisicoFacturaEmpresaLogic(connexion);
				estadofisicofacturaempresaLogic.deepLoad(factura.getEstadoFisicoFacturaEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(DetaFormaPago.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				factura.setDetaFormaPagos(facturaDataAccess.getDetaFormaPagos(connexion,factura));

				for(DetaFormaPago detaformapago:factura.getDetaFormaPagos()) {
					DetaFormaPagoLogic detaformapagoLogic= new DetaFormaPagoLogic(connexion);
					detaformapagoLogic.deepLoad(detaformapago,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(DetalleFactura.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				factura.setDetalleFacturas(facturaDataAccess.getDetalleFacturas(connexion,factura));

				for(DetalleFactura detallefactura:factura.getDetalleFacturas()) {
					DetalleFacturaLogic detallefacturaLogic= new DetalleFacturaLogic(connexion);
					detallefacturaLogic.deepLoad(detallefactura,isDeep,deepLoadType,clases);
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
			factura.setEmpresa(facturaDataAccess.getEmpresa(connexion,factura));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(factura.getEmpresa(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			factura.setSucursal(facturaDataAccess.getSucursal(connexion,factura));
			SucursalLogic sucursalLogic= new SucursalLogic(connexion);
			sucursalLogic.deepLoad(factura.getSucursal(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Ejercicio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			factura.setEjercicio(facturaDataAccess.getEjercicio(connexion,factura));
			EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
			ejercicioLogic.deepLoad(factura.getEjercicio(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Periodo.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			factura.setPeriodo(facturaDataAccess.getPeriodo(connexion,factura));
			PeriodoLogic periodoLogic= new PeriodoLogic(connexion);
			periodoLogic.deepLoad(factura.getPeriodo(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Anio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			factura.setAnio(facturaDataAccess.getAnio(connexion,factura));
			AnioLogic anioLogic= new AnioLogic(connexion);
			anioLogic.deepLoad(factura.getAnio(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Mes.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			factura.setMes(facturaDataAccess.getMes(connexion,factura));
			MesLogic mesLogic= new MesLogic(connexion);
			mesLogic.deepLoad(factura.getMes(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Usuario.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			factura.setUsuario(facturaDataAccess.getUsuario(connexion,factura));
			UsuarioLogic usuarioLogic= new UsuarioLogic(connexion);
			usuarioLogic.deepLoad(factura.getUsuario(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Moneda.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			factura.setMoneda(facturaDataAccess.getMoneda(connexion,factura));
			MonedaLogic monedaLogic= new MonedaLogic(connexion);
			monedaLogic.deepLoad(factura.getMoneda(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Empleado.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			factura.setEmpleado(facturaDataAccess.getEmpleado(connexion,factura));
			EmpleadoLogic empleadoLogic= new EmpleadoLogic(connexion);
			empleadoLogic.deepLoad(factura.getEmpleado(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Formato.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			factura.setFormato(facturaDataAccess.getFormato(connexion,factura));
			FormatoLogic formatoLogic= new FormatoLogic(connexion);
			formatoLogic.deepLoad(factura.getFormato(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Cliente.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			factura.setCliente(facturaDataAccess.getCliente(connexion,factura));
			ClienteLogic clienteLogic= new ClienteLogic(connexion);
			clienteLogic.deepLoad(factura.getCliente(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(TipoPrecio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			factura.setTipoPrecio(facturaDataAccess.getTipoPrecio(connexion,factura));
			TipoPrecioLogic tipoprecioLogic= new TipoPrecioLogic(connexion);
			tipoprecioLogic.deepLoad(factura.getTipoPrecio(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(SubCliente.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			factura.setSubCliente(facturaDataAccess.getSubCliente(connexion,factura));
			SubClienteLogic subclienteLogic= new SubClienteLogic(connexion);
			subclienteLogic.deepLoad(factura.getSubCliente(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Vendedor.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			factura.setVendedor(facturaDataAccess.getVendedor(connexion,factura));
			VendedorLogic vendedorLogic= new VendedorLogic(connexion);
			vendedorLogic.deepLoad(factura.getVendedor(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Transporte.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			factura.setTransporte(facturaDataAccess.getTransporte(connexion,factura));
			TransporteLogic transporteLogic= new TransporteLogic(connexion);
			transporteLogic.deepLoad(factura.getTransporte(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Transportista.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			factura.setTransportista(facturaDataAccess.getTransportista(connexion,factura));
			TransportistaLogic transportistaLogic= new TransportistaLogic(connexion);
			transportistaLogic.deepLoad(factura.getTransportista(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(TipoLlamada.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			factura.setTipoLlamada(facturaDataAccess.getTipoLlamada(connexion,factura));
			TipoLlamadaLogic tipollamadaLogic= new TipoLlamadaLogic(connexion);
			tipollamadaLogic.deepLoad(factura.getTipoLlamada(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(TipoFactura.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			factura.setTipoFactura(facturaDataAccess.getTipoFactura(connexion,factura));
			TipoFacturaLogic tipofacturaLogic= new TipoFacturaLogic(connexion);
			tipofacturaLogic.deepLoad(factura.getTipoFactura(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(TipoCambio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			factura.setTipoCambio(facturaDataAccess.getTipoCambio(connexion,factura));
			TipoCambioLogic tipocambioLogic= new TipoCambioLogic(connexion);
			tipocambioLogic.deepLoad(factura.getTipoCambio(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(AsientoContable.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			factura.setAsientoContable(facturaDataAccess.getAsientoContable(connexion,factura));
			AsientoContableLogic asientocontableLogic= new AsientoContableLogic(connexion);
			asientocontableLogic.deepLoad(factura.getAsientoContable(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Pedido.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			factura.setPedido(facturaDataAccess.getPedido(connexion,factura));
			PedidoLogic pedidoLogic= new PedidoLogic(connexion);
			pedidoLogic.deepLoad(factura.getPedido(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Responsable.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			factura.setResponsable(facturaDataAccess.getResponsable(connexion,factura));
			ResponsableLogic responsableLogic= new ResponsableLogic(connexion);
			responsableLogic.deepLoad(factura.getResponsable(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(EstadoFisicoFacturaEmpresa.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			factura.setEstadoFisicoFacturaEmpresa(facturaDataAccess.getEstadoFisicoFacturaEmpresa(connexion,factura));
			EstadoFisicoFacturaEmpresaLogic estadofisicofacturaempresaLogic= new EstadoFisicoFacturaEmpresaLogic(connexion);
			estadofisicofacturaempresaLogic.deepLoad(factura.getEstadoFisicoFacturaEmpresa(),isDeep,deepLoadType,clases);
				
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(DetaFormaPago.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(DetaFormaPago.class));
			factura.setDetaFormaPagos(facturaDataAccess.getDetaFormaPagos(connexion,factura));

			for(DetaFormaPago detaformapago:factura.getDetaFormaPagos()) {
				DetaFormaPagoLogic detaformapagoLogic= new DetaFormaPagoLogic(connexion);
				detaformapagoLogic.deepLoad(detaformapago,isDeep,deepLoadType,clases);
			}
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(DetalleFactura.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(DetalleFactura.class));
			factura.setDetalleFacturas(facturaDataAccess.getDetalleFacturas(connexion,factura));

			for(DetalleFactura detallefactura:factura.getDetalleFacturas()) {
				DetalleFacturaLogic detallefacturaLogic= new DetalleFacturaLogic(connexion);
				detallefacturaLogic.deepLoad(detallefactura,isDeep,deepLoadType,clases);
			}
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(Factura factura,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			FacturaLogicAdditional.updateFacturaToSave(factura,this.arrDatoGeneral);
			
FacturaDataAccess.save(factura, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(factura.getEmpresa(),connexion);

		SucursalDataAccess.save(factura.getSucursal(),connexion);

		EjercicioDataAccess.save(factura.getEjercicio(),connexion);

		PeriodoDataAccess.save(factura.getPeriodo(),connexion);

		AnioDataAccess.save(factura.getAnio(),connexion);

		MesDataAccess.save(factura.getMes(),connexion);

		UsuarioDataAccess.save(factura.getUsuario(),connexion);

		MonedaDataAccess.save(factura.getMoneda(),connexion);

		EmpleadoDataAccess.save(factura.getEmpleado(),connexion);

		FormatoDataAccess.save(factura.getFormato(),connexion);

		ClienteDataAccess.save(factura.getCliente(),connexion);

		TipoPrecioDataAccess.save(factura.getTipoPrecio(),connexion);

		SubClienteDataAccess.save(factura.getSubCliente(),connexion);

		VendedorDataAccess.save(factura.getVendedor(),connexion);

		TransporteDataAccess.save(factura.getTransporte(),connexion);

		TransportistaDataAccess.save(factura.getTransportista(),connexion);

		TipoLlamadaDataAccess.save(factura.getTipoLlamada(),connexion);

		TipoFacturaDataAccess.save(factura.getTipoFactura(),connexion);

		TipoCambioDataAccess.save(factura.getTipoCambio(),connexion);

		AsientoContableDataAccess.save(factura.getAsientoContable(),connexion);

		PedidoDataAccess.save(factura.getPedido(),connexion);

		ResponsableDataAccess.save(factura.getResponsable(),connexion);

		EstadoFisicoFacturaEmpresaDataAccess.save(factura.getEstadoFisicoFacturaEmpresa(),connexion);

		for(DetaFormaPago detaformapago:factura.getDetaFormaPagos()) {
			detaformapago.setid_factura(factura.getId());
			DetaFormaPagoDataAccess.save(detaformapago,connexion);
		}

		for(DetalleFactura detallefactura:factura.getDetalleFacturas()) {
			detallefactura.setid_factura(factura.getId());
			DetalleFacturaDataAccess.save(detallefactura,connexion);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(factura.getEmpresa(),connexion);
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				SucursalDataAccess.save(factura.getSucursal(),connexion);
				continue;
			}

			if(clas.clas.equals(Ejercicio.class)) {
				EjercicioDataAccess.save(factura.getEjercicio(),connexion);
				continue;
			}

			if(clas.clas.equals(Periodo.class)) {
				PeriodoDataAccess.save(factura.getPeriodo(),connexion);
				continue;
			}

			if(clas.clas.equals(Anio.class)) {
				AnioDataAccess.save(factura.getAnio(),connexion);
				continue;
			}

			if(clas.clas.equals(Mes.class)) {
				MesDataAccess.save(factura.getMes(),connexion);
				continue;
			}

			if(clas.clas.equals(Usuario.class)) {
				UsuarioDataAccess.save(factura.getUsuario(),connexion);
				continue;
			}

			if(clas.clas.equals(Moneda.class)) {
				MonedaDataAccess.save(factura.getMoneda(),connexion);
				continue;
			}

			if(clas.clas.equals(Empleado.class)) {
				EmpleadoDataAccess.save(factura.getEmpleado(),connexion);
				continue;
			}

			if(clas.clas.equals(Formato.class)) {
				FormatoDataAccess.save(factura.getFormato(),connexion);
				continue;
			}

			if(clas.clas.equals(Cliente.class)) {
				ClienteDataAccess.save(factura.getCliente(),connexion);
				continue;
			}

			if(clas.clas.equals(TipoPrecio.class)) {
				TipoPrecioDataAccess.save(factura.getTipoPrecio(),connexion);
				continue;
			}

			if(clas.clas.equals(SubCliente.class)) {
				SubClienteDataAccess.save(factura.getSubCliente(),connexion);
				continue;
			}

			if(clas.clas.equals(Vendedor.class)) {
				VendedorDataAccess.save(factura.getVendedor(),connexion);
				continue;
			}

			if(clas.clas.equals(Transporte.class)) {
				TransporteDataAccess.save(factura.getTransporte(),connexion);
				continue;
			}

			if(clas.clas.equals(Transportista.class)) {
				TransportistaDataAccess.save(factura.getTransportista(),connexion);
				continue;
			}

			if(clas.clas.equals(TipoLlamada.class)) {
				TipoLlamadaDataAccess.save(factura.getTipoLlamada(),connexion);
				continue;
			}

			if(clas.clas.equals(TipoFactura.class)) {
				TipoFacturaDataAccess.save(factura.getTipoFactura(),connexion);
				continue;
			}

			if(clas.clas.equals(TipoCambio.class)) {
				TipoCambioDataAccess.save(factura.getTipoCambio(),connexion);
				continue;
			}

			if(clas.clas.equals(AsientoContable.class)) {
				AsientoContableDataAccess.save(factura.getAsientoContable(),connexion);
				continue;
			}

			if(clas.clas.equals(Pedido.class)) {
				PedidoDataAccess.save(factura.getPedido(),connexion);
				continue;
			}

			if(clas.clas.equals(Responsable.class)) {
				ResponsableDataAccess.save(factura.getResponsable(),connexion);
				continue;
			}

			if(clas.clas.equals(EstadoFisicoFacturaEmpresa.class)) {
				EstadoFisicoFacturaEmpresaDataAccess.save(factura.getEstadoFisicoFacturaEmpresa(),connexion);
				continue;
			}


			if(clas.clas.equals(DetaFormaPago.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(DetaFormaPago detaformapago:factura.getDetaFormaPagos()) {
					detaformapago.setid_factura(factura.getId());
					DetaFormaPagoDataAccess.save(detaformapago,connexion);
				}
				continue;
			}

			if(clas.clas.equals(DetalleFactura.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(DetalleFactura detallefactura:factura.getDetalleFacturas()) {
					detallefactura.setid_factura(factura.getId());
					DetalleFacturaDataAccess.save(detallefactura,connexion);
				}
				continue;
			}
		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(factura.getEmpresa(),connexion);
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(factura.getEmpresa(),isDeep,deepLoadType,clases);
				

		SucursalDataAccess.save(factura.getSucursal(),connexion);
		SucursalLogic sucursalLogic= new SucursalLogic(connexion);
		sucursalLogic.deepLoad(factura.getSucursal(),isDeep,deepLoadType,clases);
				

		EjercicioDataAccess.save(factura.getEjercicio(),connexion);
		EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
		ejercicioLogic.deepLoad(factura.getEjercicio(),isDeep,deepLoadType,clases);
				

		PeriodoDataAccess.save(factura.getPeriodo(),connexion);
		PeriodoLogic periodoLogic= new PeriodoLogic(connexion);
		periodoLogic.deepLoad(factura.getPeriodo(),isDeep,deepLoadType,clases);
				

		AnioDataAccess.save(factura.getAnio(),connexion);
		AnioLogic anioLogic= new AnioLogic(connexion);
		anioLogic.deepLoad(factura.getAnio(),isDeep,deepLoadType,clases);
				

		MesDataAccess.save(factura.getMes(),connexion);
		MesLogic mesLogic= new MesLogic(connexion);
		mesLogic.deepLoad(factura.getMes(),isDeep,deepLoadType,clases);
				

		UsuarioDataAccess.save(factura.getUsuario(),connexion);
		UsuarioLogic usuarioLogic= new UsuarioLogic(connexion);
		usuarioLogic.deepLoad(factura.getUsuario(),isDeep,deepLoadType,clases);
				

		MonedaDataAccess.save(factura.getMoneda(),connexion);
		MonedaLogic monedaLogic= new MonedaLogic(connexion);
		monedaLogic.deepLoad(factura.getMoneda(),isDeep,deepLoadType,clases);
				

		EmpleadoDataAccess.save(factura.getEmpleado(),connexion);
		EmpleadoLogic empleadoLogic= new EmpleadoLogic(connexion);
		empleadoLogic.deepLoad(factura.getEmpleado(),isDeep,deepLoadType,clases);
				

		FormatoDataAccess.save(factura.getFormato(),connexion);
		FormatoLogic formatoLogic= new FormatoLogic(connexion);
		formatoLogic.deepLoad(factura.getFormato(),isDeep,deepLoadType,clases);
				

		ClienteDataAccess.save(factura.getCliente(),connexion);
		ClienteLogic clienteLogic= new ClienteLogic(connexion);
		clienteLogic.deepLoad(factura.getCliente(),isDeep,deepLoadType,clases);
				

		TipoPrecioDataAccess.save(factura.getTipoPrecio(),connexion);
		TipoPrecioLogic tipoprecioLogic= new TipoPrecioLogic(connexion);
		tipoprecioLogic.deepLoad(factura.getTipoPrecio(),isDeep,deepLoadType,clases);
				

		SubClienteDataAccess.save(factura.getSubCliente(),connexion);
		SubClienteLogic subclienteLogic= new SubClienteLogic(connexion);
		subclienteLogic.deepLoad(factura.getSubCliente(),isDeep,deepLoadType,clases);
				

		VendedorDataAccess.save(factura.getVendedor(),connexion);
		VendedorLogic vendedorLogic= new VendedorLogic(connexion);
		vendedorLogic.deepLoad(factura.getVendedor(),isDeep,deepLoadType,clases);
				

		TransporteDataAccess.save(factura.getTransporte(),connexion);
		TransporteLogic transporteLogic= new TransporteLogic(connexion);
		transporteLogic.deepLoad(factura.getTransporte(),isDeep,deepLoadType,clases);
				

		TransportistaDataAccess.save(factura.getTransportista(),connexion);
		TransportistaLogic transportistaLogic= new TransportistaLogic(connexion);
		transportistaLogic.deepLoad(factura.getTransportista(),isDeep,deepLoadType,clases);
				

		TipoLlamadaDataAccess.save(factura.getTipoLlamada(),connexion);
		TipoLlamadaLogic tipollamadaLogic= new TipoLlamadaLogic(connexion);
		tipollamadaLogic.deepLoad(factura.getTipoLlamada(),isDeep,deepLoadType,clases);
				

		TipoFacturaDataAccess.save(factura.getTipoFactura(),connexion);
		TipoFacturaLogic tipofacturaLogic= new TipoFacturaLogic(connexion);
		tipofacturaLogic.deepLoad(factura.getTipoFactura(),isDeep,deepLoadType,clases);
				

		TipoCambioDataAccess.save(factura.getTipoCambio(),connexion);
		TipoCambioLogic tipocambioLogic= new TipoCambioLogic(connexion);
		tipocambioLogic.deepLoad(factura.getTipoCambio(),isDeep,deepLoadType,clases);
				

		AsientoContableDataAccess.save(factura.getAsientoContable(),connexion);
		AsientoContableLogic asientocontableLogic= new AsientoContableLogic(connexion);
		asientocontableLogic.deepLoad(factura.getAsientoContable(),isDeep,deepLoadType,clases);
				

		PedidoDataAccess.save(factura.getPedido(),connexion);
		PedidoLogic pedidoLogic= new PedidoLogic(connexion);
		pedidoLogic.deepLoad(factura.getPedido(),isDeep,deepLoadType,clases);
				

		ResponsableDataAccess.save(factura.getResponsable(),connexion);
		ResponsableLogic responsableLogic= new ResponsableLogic(connexion);
		responsableLogic.deepLoad(factura.getResponsable(),isDeep,deepLoadType,clases);
				

		EstadoFisicoFacturaEmpresaDataAccess.save(factura.getEstadoFisicoFacturaEmpresa(),connexion);
		EstadoFisicoFacturaEmpresaLogic estadofisicofacturaempresaLogic= new EstadoFisicoFacturaEmpresaLogic(connexion);
		estadofisicofacturaempresaLogic.deepLoad(factura.getEstadoFisicoFacturaEmpresa(),isDeep,deepLoadType,clases);
				

		for(DetaFormaPago detaformapago:factura.getDetaFormaPagos()) {
			DetaFormaPagoLogic detaformapagoLogic= new DetaFormaPagoLogic(connexion);
			detaformapago.setid_factura(factura.getId());
			DetaFormaPagoDataAccess.save(detaformapago,connexion);
			detaformapagoLogic.deepSave(detaformapago,isDeep,deepLoadType,clases);
		}

		for(DetalleFactura detallefactura:factura.getDetalleFacturas()) {
			DetalleFacturaLogic detallefacturaLogic= new DetalleFacturaLogic(connexion);
			detallefactura.setid_factura(factura.getId());
			DetalleFacturaDataAccess.save(detallefactura,connexion);
			detallefacturaLogic.deepSave(detallefactura,isDeep,deepLoadType,clases);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(factura.getEmpresa(),connexion);
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepSave(factura.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				SucursalDataAccess.save(factura.getSucursal(),connexion);
				SucursalLogic sucursalLogic= new SucursalLogic(connexion);
				sucursalLogic.deepSave(factura.getSucursal(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Ejercicio.class)) {
				EjercicioDataAccess.save(factura.getEjercicio(),connexion);
				EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
				ejercicioLogic.deepSave(factura.getEjercicio(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Periodo.class)) {
				PeriodoDataAccess.save(factura.getPeriodo(),connexion);
				PeriodoLogic periodoLogic= new PeriodoLogic(connexion);
				periodoLogic.deepSave(factura.getPeriodo(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Anio.class)) {
				AnioDataAccess.save(factura.getAnio(),connexion);
				AnioLogic anioLogic= new AnioLogic(connexion);
				anioLogic.deepSave(factura.getAnio(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Mes.class)) {
				MesDataAccess.save(factura.getMes(),connexion);
				MesLogic mesLogic= new MesLogic(connexion);
				mesLogic.deepSave(factura.getMes(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Usuario.class)) {
				UsuarioDataAccess.save(factura.getUsuario(),connexion);
				UsuarioLogic usuarioLogic= new UsuarioLogic(connexion);
				usuarioLogic.deepSave(factura.getUsuario(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Moneda.class)) {
				MonedaDataAccess.save(factura.getMoneda(),connexion);
				MonedaLogic monedaLogic= new MonedaLogic(connexion);
				monedaLogic.deepSave(factura.getMoneda(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Empleado.class)) {
				EmpleadoDataAccess.save(factura.getEmpleado(),connexion);
				EmpleadoLogic empleadoLogic= new EmpleadoLogic(connexion);
				empleadoLogic.deepSave(factura.getEmpleado(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Formato.class)) {
				FormatoDataAccess.save(factura.getFormato(),connexion);
				FormatoLogic formatoLogic= new FormatoLogic(connexion);
				formatoLogic.deepSave(factura.getFormato(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Cliente.class)) {
				ClienteDataAccess.save(factura.getCliente(),connexion);
				ClienteLogic clienteLogic= new ClienteLogic(connexion);
				clienteLogic.deepSave(factura.getCliente(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoPrecio.class)) {
				TipoPrecioDataAccess.save(factura.getTipoPrecio(),connexion);
				TipoPrecioLogic tipoprecioLogic= new TipoPrecioLogic(connexion);
				tipoprecioLogic.deepSave(factura.getTipoPrecio(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(SubCliente.class)) {
				SubClienteDataAccess.save(factura.getSubCliente(),connexion);
				SubClienteLogic subclienteLogic= new SubClienteLogic(connexion);
				subclienteLogic.deepSave(factura.getSubCliente(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Vendedor.class)) {
				VendedorDataAccess.save(factura.getVendedor(),connexion);
				VendedorLogic vendedorLogic= new VendedorLogic(connexion);
				vendedorLogic.deepSave(factura.getVendedor(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Transporte.class)) {
				TransporteDataAccess.save(factura.getTransporte(),connexion);
				TransporteLogic transporteLogic= new TransporteLogic(connexion);
				transporteLogic.deepSave(factura.getTransporte(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Transportista.class)) {
				TransportistaDataAccess.save(factura.getTransportista(),connexion);
				TransportistaLogic transportistaLogic= new TransportistaLogic(connexion);
				transportistaLogic.deepSave(factura.getTransportista(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoLlamada.class)) {
				TipoLlamadaDataAccess.save(factura.getTipoLlamada(),connexion);
				TipoLlamadaLogic tipollamadaLogic= new TipoLlamadaLogic(connexion);
				tipollamadaLogic.deepSave(factura.getTipoLlamada(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoFactura.class)) {
				TipoFacturaDataAccess.save(factura.getTipoFactura(),connexion);
				TipoFacturaLogic tipofacturaLogic= new TipoFacturaLogic(connexion);
				tipofacturaLogic.deepSave(factura.getTipoFactura(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoCambio.class)) {
				TipoCambioDataAccess.save(factura.getTipoCambio(),connexion);
				TipoCambioLogic tipocambioLogic= new TipoCambioLogic(connexion);
				tipocambioLogic.deepSave(factura.getTipoCambio(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(AsientoContable.class)) {
				AsientoContableDataAccess.save(factura.getAsientoContable(),connexion);
				AsientoContableLogic asientocontableLogic= new AsientoContableLogic(connexion);
				asientocontableLogic.deepSave(factura.getAsientoContable(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Pedido.class)) {
				PedidoDataAccess.save(factura.getPedido(),connexion);
				PedidoLogic pedidoLogic= new PedidoLogic(connexion);
				pedidoLogic.deepSave(factura.getPedido(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Responsable.class)) {
				ResponsableDataAccess.save(factura.getResponsable(),connexion);
				ResponsableLogic responsableLogic= new ResponsableLogic(connexion);
				responsableLogic.deepSave(factura.getResponsable(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(EstadoFisicoFacturaEmpresa.class)) {
				EstadoFisicoFacturaEmpresaDataAccess.save(factura.getEstadoFisicoFacturaEmpresa(),connexion);
				EstadoFisicoFacturaEmpresaLogic estadofisicofacturaempresaLogic= new EstadoFisicoFacturaEmpresaLogic(connexion);
				estadofisicofacturaempresaLogic.deepSave(factura.getEstadoFisicoFacturaEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}


			if(clas.clas.equals(DetaFormaPago.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(DetaFormaPago detaformapago:factura.getDetaFormaPagos()) {
					DetaFormaPagoLogic detaformapagoLogic= new DetaFormaPagoLogic(connexion);
					detaformapago.setid_factura(factura.getId());
					DetaFormaPagoDataAccess.save(detaformapago,connexion);
					detaformapagoLogic.deepSave(detaformapago,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(DetalleFactura.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(DetalleFactura detallefactura:factura.getDetalleFacturas()) {
					DetalleFacturaLogic detallefacturaLogic= new DetalleFacturaLogic(connexion);
					detallefactura.setid_factura(factura.getId());
					DetalleFacturaDataAccess.save(detallefactura,connexion);
					detallefacturaLogic.deepSave(detallefactura,isDeep,deepLoadType,clases);
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
			this.getNewConnexionToDeep(Factura.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(factura,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				FacturaConstantesFunciones.refrescarForeignKeysDescripcionesFactura(factura);
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
			this.deepLoad(this.factura,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				FacturaConstantesFunciones.refrescarForeignKeysDescripcionesFactura(this.factura);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(Factura.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(facturas!=null) {
				for(Factura factura:facturas) {
					this.deepLoad(factura,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					FacturaConstantesFunciones.refrescarForeignKeysDescripcionesFactura(facturas);
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
			if(facturas!=null) {
				for(Factura factura:facturas) {
					this.deepLoad(factura,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					FacturaConstantesFunciones.refrescarForeignKeysDescripcionesFactura(facturas);
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
			this.getNewConnexionToDeep(Factura.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(factura,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(Factura.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(facturas!=null) {
				for(Factura factura:facturas) {
					this.deepSave(factura,isDeep,deepLoadType,clases);
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
			if(facturas!=null) {
				for(Factura factura:facturas) {
					this.deepSave(factura,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getFacturasBusquedaPorNumeroPreImpresoWithConnection(String sFinalQuery,Pagination pagination,String numero_pre_impreso)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Factura.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralNumeroPreImpreso= new ParameterSelectionGeneral();
			parameterSelectionGeneralNumeroPreImpreso.setParameterSelectionGeneralLike(ParameterType.STRING,"%"+numero_pre_impreso+"%",FacturaConstantesFunciones.NUMEROPREIMPRESO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralNumeroPreImpreso);

			FacturaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorNumeroPreImpreso","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			facturas=facturaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				FacturaConstantesFunciones.refrescarForeignKeysDescripcionesFactura(this.facturas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getFacturasBusquedaPorNumeroPreImpreso(String sFinalQuery,Pagination pagination,String numero_pre_impreso)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralNumeroPreImpreso= new ParameterSelectionGeneral();
			parameterSelectionGeneralNumeroPreImpreso.setParameterSelectionGeneralLike(ParameterType.STRING,"%"+numero_pre_impreso+"%",FacturaConstantesFunciones.NUMEROPREIMPRESO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralNumeroPreImpreso);

			FacturaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorNumeroPreImpreso","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			facturas=facturaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				FacturaConstantesFunciones.refrescarForeignKeysDescripcionesFactura(this.facturas);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getFacturasFK_IdAnioWithConnection(String sFinalQuery,Pagination pagination,Long id_anio)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Factura.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidAnio= new ParameterSelectionGeneral();
			parameterSelectionGeneralidAnio.setParameterSelectionGeneralEqual(ParameterType.LONG,id_anio,FacturaConstantesFunciones.IDANIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidAnio);

			FacturaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdAnio","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			facturas=facturaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				FacturaConstantesFunciones.refrescarForeignKeysDescripcionesFactura(this.facturas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getFacturasFK_IdAnio(String sFinalQuery,Pagination pagination,Long id_anio)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidAnio= new ParameterSelectionGeneral();
			parameterSelectionGeneralidAnio.setParameterSelectionGeneralEqual(ParameterType.LONG,id_anio,FacturaConstantesFunciones.IDANIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidAnio);

			FacturaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdAnio","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			facturas=facturaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				FacturaConstantesFunciones.refrescarForeignKeysDescripcionesFactura(this.facturas);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getFacturasFK_IdAsientoContableWithConnection(String sFinalQuery,Pagination pagination,Long id_asiento_contable)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Factura.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidAsientoContable= new ParameterSelectionGeneral();
			parameterSelectionGeneralidAsientoContable.setParameterSelectionGeneralEqual(ParameterType.LONG,id_asiento_contable,FacturaConstantesFunciones.IDASIENTOCONTABLE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidAsientoContable);

			FacturaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdAsientoContable","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			facturas=facturaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				FacturaConstantesFunciones.refrescarForeignKeysDescripcionesFactura(this.facturas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getFacturasFK_IdAsientoContable(String sFinalQuery,Pagination pagination,Long id_asiento_contable)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidAsientoContable= new ParameterSelectionGeneral();
			parameterSelectionGeneralidAsientoContable.setParameterSelectionGeneralEqual(ParameterType.LONG,id_asiento_contable,FacturaConstantesFunciones.IDASIENTOCONTABLE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidAsientoContable);

			FacturaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdAsientoContable","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			facturas=facturaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				FacturaConstantesFunciones.refrescarForeignKeysDescripcionesFactura(this.facturas);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getFacturasFK_IdClienteWithConnection(String sFinalQuery,Pagination pagination,Long id_cliente)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Factura.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCliente= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCliente.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cliente,FacturaConstantesFunciones.IDCLIENTE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCliente);

			FacturaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCliente","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			facturas=facturaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				FacturaConstantesFunciones.refrescarForeignKeysDescripcionesFactura(this.facturas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getFacturasFK_IdCliente(String sFinalQuery,Pagination pagination,Long id_cliente)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCliente= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCliente.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cliente,FacturaConstantesFunciones.IDCLIENTE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCliente);

			FacturaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCliente","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			facturas=facturaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				FacturaConstantesFunciones.refrescarForeignKeysDescripcionesFactura(this.facturas);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getFacturasFK_IdEjercicioWithConnection(String sFinalQuery,Pagination pagination,Long id_ejercicio)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Factura.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEjercicio= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEjercicio.setParameterSelectionGeneralEqual(ParameterType.LONG,id_ejercicio,FacturaConstantesFunciones.IDEJERCICIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEjercicio);

			FacturaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEjercicio","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			facturas=facturaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				FacturaConstantesFunciones.refrescarForeignKeysDescripcionesFactura(this.facturas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getFacturasFK_IdEjercicio(String sFinalQuery,Pagination pagination,Long id_ejercicio)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEjercicio= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEjercicio.setParameterSelectionGeneralEqual(ParameterType.LONG,id_ejercicio,FacturaConstantesFunciones.IDEJERCICIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEjercicio);

			FacturaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEjercicio","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			facturas=facturaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				FacturaConstantesFunciones.refrescarForeignKeysDescripcionesFactura(this.facturas);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getFacturasFK_IdEmpleadoWithConnection(String sFinalQuery,Pagination pagination,Long id_empleado)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Factura.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpleado= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpleado.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empleado,FacturaConstantesFunciones.IDEMPLEADO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpleado);

			FacturaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpleado","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			facturas=facturaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				FacturaConstantesFunciones.refrescarForeignKeysDescripcionesFactura(this.facturas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getFacturasFK_IdEmpleado(String sFinalQuery,Pagination pagination,Long id_empleado)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpleado= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpleado.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empleado,FacturaConstantesFunciones.IDEMPLEADO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpleado);

			FacturaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpleado","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			facturas=facturaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				FacturaConstantesFunciones.refrescarForeignKeysDescripcionesFactura(this.facturas);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getFacturasFK_IdEmpresaWithConnection(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Factura.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,FacturaConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			FacturaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			facturas=facturaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				FacturaConstantesFunciones.refrescarForeignKeysDescripcionesFactura(this.facturas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getFacturasFK_IdEmpresa(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,FacturaConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			FacturaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			facturas=facturaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				FacturaConstantesFunciones.refrescarForeignKeysDescripcionesFactura(this.facturas);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getFacturasFK_IdEstadoFisicoFacturaEmpresaWithConnection(String sFinalQuery,Pagination pagination,Long id_estado_fisico_factura_empresa)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Factura.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEstadoFisicoFacturaEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEstadoFisicoFacturaEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_estado_fisico_factura_empresa,FacturaConstantesFunciones.IDESTADOFISICOFACTURAEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEstadoFisicoFacturaEmpresa);

			FacturaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEstadoFisicoFacturaEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			facturas=facturaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				FacturaConstantesFunciones.refrescarForeignKeysDescripcionesFactura(this.facturas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getFacturasFK_IdEstadoFisicoFacturaEmpresa(String sFinalQuery,Pagination pagination,Long id_estado_fisico_factura_empresa)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEstadoFisicoFacturaEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEstadoFisicoFacturaEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_estado_fisico_factura_empresa,FacturaConstantesFunciones.IDESTADOFISICOFACTURAEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEstadoFisicoFacturaEmpresa);

			FacturaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEstadoFisicoFacturaEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			facturas=facturaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				FacturaConstantesFunciones.refrescarForeignKeysDescripcionesFactura(this.facturas);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getFacturasFK_IdFormatoWithConnection(String sFinalQuery,Pagination pagination,Long id_formato)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Factura.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidFormato= new ParameterSelectionGeneral();
			parameterSelectionGeneralidFormato.setParameterSelectionGeneralEqual(ParameterType.LONG,id_formato,FacturaConstantesFunciones.IDFORMATO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidFormato);

			FacturaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdFormato","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			facturas=facturaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				FacturaConstantesFunciones.refrescarForeignKeysDescripcionesFactura(this.facturas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getFacturasFK_IdFormato(String sFinalQuery,Pagination pagination,Long id_formato)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidFormato= new ParameterSelectionGeneral();
			parameterSelectionGeneralidFormato.setParameterSelectionGeneralEqual(ParameterType.LONG,id_formato,FacturaConstantesFunciones.IDFORMATO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidFormato);

			FacturaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdFormato","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			facturas=facturaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				FacturaConstantesFunciones.refrescarForeignKeysDescripcionesFactura(this.facturas);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getFacturasFK_IdMesWithConnection(String sFinalQuery,Pagination pagination,Long id_mes)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Factura.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidMes= new ParameterSelectionGeneral();
			parameterSelectionGeneralidMes.setParameterSelectionGeneralEqual(ParameterType.LONG,id_mes,FacturaConstantesFunciones.IDMES,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidMes);

			FacturaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdMes","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			facturas=facturaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				FacturaConstantesFunciones.refrescarForeignKeysDescripcionesFactura(this.facturas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getFacturasFK_IdMes(String sFinalQuery,Pagination pagination,Long id_mes)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidMes= new ParameterSelectionGeneral();
			parameterSelectionGeneralidMes.setParameterSelectionGeneralEqual(ParameterType.LONG,id_mes,FacturaConstantesFunciones.IDMES,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidMes);

			FacturaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdMes","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			facturas=facturaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				FacturaConstantesFunciones.refrescarForeignKeysDescripcionesFactura(this.facturas);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getFacturasFK_IdMonedaWithConnection(String sFinalQuery,Pagination pagination,Long id_moneda)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Factura.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidMoneda= new ParameterSelectionGeneral();
			parameterSelectionGeneralidMoneda.setParameterSelectionGeneralEqual(ParameterType.LONG,id_moneda,FacturaConstantesFunciones.IDMONEDA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidMoneda);

			FacturaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdMoneda","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			facturas=facturaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				FacturaConstantesFunciones.refrescarForeignKeysDescripcionesFactura(this.facturas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getFacturasFK_IdMoneda(String sFinalQuery,Pagination pagination,Long id_moneda)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidMoneda= new ParameterSelectionGeneral();
			parameterSelectionGeneralidMoneda.setParameterSelectionGeneralEqual(ParameterType.LONG,id_moneda,FacturaConstantesFunciones.IDMONEDA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidMoneda);

			FacturaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdMoneda","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			facturas=facturaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				FacturaConstantesFunciones.refrescarForeignKeysDescripcionesFactura(this.facturas);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getFacturasFK_IdPedidoWithConnection(String sFinalQuery,Pagination pagination,Long id_pedido)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Factura.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidPedido= new ParameterSelectionGeneral();
			parameterSelectionGeneralidPedido.setParameterSelectionGeneralEqual(ParameterType.LONG,id_pedido,FacturaConstantesFunciones.IDPEDIDO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidPedido);

			FacturaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdPedido","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			facturas=facturaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				FacturaConstantesFunciones.refrescarForeignKeysDescripcionesFactura(this.facturas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getFacturasFK_IdPedido(String sFinalQuery,Pagination pagination,Long id_pedido)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidPedido= new ParameterSelectionGeneral();
			parameterSelectionGeneralidPedido.setParameterSelectionGeneralEqual(ParameterType.LONG,id_pedido,FacturaConstantesFunciones.IDPEDIDO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidPedido);

			FacturaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdPedido","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			facturas=facturaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				FacturaConstantesFunciones.refrescarForeignKeysDescripcionesFactura(this.facturas);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getFacturasFK_IdPeriodoWithConnection(String sFinalQuery,Pagination pagination,Long id_periodo)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Factura.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidPeriodo= new ParameterSelectionGeneral();
			parameterSelectionGeneralidPeriodo.setParameterSelectionGeneralEqual(ParameterType.LONG,id_periodo,FacturaConstantesFunciones.IDPERIODO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidPeriodo);

			FacturaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdPeriodo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			facturas=facturaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				FacturaConstantesFunciones.refrescarForeignKeysDescripcionesFactura(this.facturas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getFacturasFK_IdPeriodo(String sFinalQuery,Pagination pagination,Long id_periodo)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidPeriodo= new ParameterSelectionGeneral();
			parameterSelectionGeneralidPeriodo.setParameterSelectionGeneralEqual(ParameterType.LONG,id_periodo,FacturaConstantesFunciones.IDPERIODO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidPeriodo);

			FacturaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdPeriodo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			facturas=facturaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				FacturaConstantesFunciones.refrescarForeignKeysDescripcionesFactura(this.facturas);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getFacturasFK_IdResponsableWithConnection(String sFinalQuery,Pagination pagination,Long id_responsable)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Factura.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidResponsable= new ParameterSelectionGeneral();
			parameterSelectionGeneralidResponsable.setParameterSelectionGeneralEqual(ParameterType.LONG,id_responsable,FacturaConstantesFunciones.IDRESPONSABLE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidResponsable);

			FacturaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdResponsable","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			facturas=facturaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				FacturaConstantesFunciones.refrescarForeignKeysDescripcionesFactura(this.facturas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getFacturasFK_IdResponsable(String sFinalQuery,Pagination pagination,Long id_responsable)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidResponsable= new ParameterSelectionGeneral();
			parameterSelectionGeneralidResponsable.setParameterSelectionGeneralEqual(ParameterType.LONG,id_responsable,FacturaConstantesFunciones.IDRESPONSABLE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidResponsable);

			FacturaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdResponsable","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			facturas=facturaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				FacturaConstantesFunciones.refrescarForeignKeysDescripcionesFactura(this.facturas);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getFacturasFK_IdSubClienteWithConnection(String sFinalQuery,Pagination pagination,Long id_sub_cliente)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Factura.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidSubCliente= new ParameterSelectionGeneral();
			parameterSelectionGeneralidSubCliente.setParameterSelectionGeneralEqual(ParameterType.LONG,id_sub_cliente,FacturaConstantesFunciones.IDSUBCLIENTE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidSubCliente);

			FacturaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdSubCliente","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			facturas=facturaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				FacturaConstantesFunciones.refrescarForeignKeysDescripcionesFactura(this.facturas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getFacturasFK_IdSubCliente(String sFinalQuery,Pagination pagination,Long id_sub_cliente)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidSubCliente= new ParameterSelectionGeneral();
			parameterSelectionGeneralidSubCliente.setParameterSelectionGeneralEqual(ParameterType.LONG,id_sub_cliente,FacturaConstantesFunciones.IDSUBCLIENTE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidSubCliente);

			FacturaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdSubCliente","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			facturas=facturaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				FacturaConstantesFunciones.refrescarForeignKeysDescripcionesFactura(this.facturas);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getFacturasFK_IdSucursalWithConnection(String sFinalQuery,Pagination pagination,Long id_sucursal)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Factura.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidSucursal= new ParameterSelectionGeneral();
			parameterSelectionGeneralidSucursal.setParameterSelectionGeneralEqual(ParameterType.LONG,id_sucursal,FacturaConstantesFunciones.IDSUCURSAL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidSucursal);

			FacturaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdSucursal","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			facturas=facturaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				FacturaConstantesFunciones.refrescarForeignKeysDescripcionesFactura(this.facturas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getFacturasFK_IdSucursal(String sFinalQuery,Pagination pagination,Long id_sucursal)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidSucursal= new ParameterSelectionGeneral();
			parameterSelectionGeneralidSucursal.setParameterSelectionGeneralEqual(ParameterType.LONG,id_sucursal,FacturaConstantesFunciones.IDSUCURSAL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidSucursal);

			FacturaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdSucursal","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			facturas=facturaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				FacturaConstantesFunciones.refrescarForeignKeysDescripcionesFactura(this.facturas);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getFacturasFK_IdTipoCambioWithConnection(String sFinalQuery,Pagination pagination,Long id_tipo_cambio)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Factura.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoCambio= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoCambio.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_cambio,FacturaConstantesFunciones.IDTIPOCAMBIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoCambio);

			FacturaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoCambio","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			facturas=facturaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				FacturaConstantesFunciones.refrescarForeignKeysDescripcionesFactura(this.facturas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getFacturasFK_IdTipoCambio(String sFinalQuery,Pagination pagination,Long id_tipo_cambio)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoCambio= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoCambio.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_cambio,FacturaConstantesFunciones.IDTIPOCAMBIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoCambio);

			FacturaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoCambio","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			facturas=facturaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				FacturaConstantesFunciones.refrescarForeignKeysDescripcionesFactura(this.facturas);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getFacturasFK_IdTipoFacturaWithConnection(String sFinalQuery,Pagination pagination,Long id_tipo_factura)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Factura.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoFactura= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoFactura.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_factura,FacturaConstantesFunciones.IDTIPOFACTURA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoFactura);

			FacturaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoFactura","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			facturas=facturaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				FacturaConstantesFunciones.refrescarForeignKeysDescripcionesFactura(this.facturas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getFacturasFK_IdTipoFactura(String sFinalQuery,Pagination pagination,Long id_tipo_factura)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoFactura= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoFactura.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_factura,FacturaConstantesFunciones.IDTIPOFACTURA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoFactura);

			FacturaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoFactura","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			facturas=facturaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				FacturaConstantesFunciones.refrescarForeignKeysDescripcionesFactura(this.facturas);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getFacturasFK_IdTipoLlamadaWithConnection(String sFinalQuery,Pagination pagination,Long id_tipo_llamada)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Factura.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoLlamada= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoLlamada.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_llamada,FacturaConstantesFunciones.IDTIPOLLAMADA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoLlamada);

			FacturaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoLlamada","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			facturas=facturaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				FacturaConstantesFunciones.refrescarForeignKeysDescripcionesFactura(this.facturas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getFacturasFK_IdTipoLlamada(String sFinalQuery,Pagination pagination,Long id_tipo_llamada)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoLlamada= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoLlamada.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_llamada,FacturaConstantesFunciones.IDTIPOLLAMADA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoLlamada);

			FacturaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoLlamada","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			facturas=facturaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				FacturaConstantesFunciones.refrescarForeignKeysDescripcionesFactura(this.facturas);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getFacturasFK_IdTipoPrecioWithConnection(String sFinalQuery,Pagination pagination,Long id_tipo_precio)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Factura.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoPrecio= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoPrecio.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_precio,FacturaConstantesFunciones.IDTIPOPRECIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoPrecio);

			FacturaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoPrecio","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			facturas=facturaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				FacturaConstantesFunciones.refrescarForeignKeysDescripcionesFactura(this.facturas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getFacturasFK_IdTipoPrecio(String sFinalQuery,Pagination pagination,Long id_tipo_precio)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoPrecio= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoPrecio.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_precio,FacturaConstantesFunciones.IDTIPOPRECIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoPrecio);

			FacturaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoPrecio","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			facturas=facturaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				FacturaConstantesFunciones.refrescarForeignKeysDescripcionesFactura(this.facturas);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getFacturasFK_IdTransporteWithConnection(String sFinalQuery,Pagination pagination,Long id_transporte)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Factura.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTransporte= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTransporte.setParameterSelectionGeneralEqual(ParameterType.LONG,id_transporte,FacturaConstantesFunciones.IDTRANSPORTE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTransporte);

			FacturaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTransporte","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			facturas=facturaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				FacturaConstantesFunciones.refrescarForeignKeysDescripcionesFactura(this.facturas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getFacturasFK_IdTransporte(String sFinalQuery,Pagination pagination,Long id_transporte)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTransporte= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTransporte.setParameterSelectionGeneralEqual(ParameterType.LONG,id_transporte,FacturaConstantesFunciones.IDTRANSPORTE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTransporte);

			FacturaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTransporte","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			facturas=facturaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				FacturaConstantesFunciones.refrescarForeignKeysDescripcionesFactura(this.facturas);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getFacturasFK_IdTransportistaWithConnection(String sFinalQuery,Pagination pagination,Long id_transportista)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Factura.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTransportista= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTransportista.setParameterSelectionGeneralEqual(ParameterType.LONG,id_transportista,FacturaConstantesFunciones.IDTRANSPORTISTA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTransportista);

			FacturaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTransportista","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			facturas=facturaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				FacturaConstantesFunciones.refrescarForeignKeysDescripcionesFactura(this.facturas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getFacturasFK_IdTransportista(String sFinalQuery,Pagination pagination,Long id_transportista)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTransportista= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTransportista.setParameterSelectionGeneralEqual(ParameterType.LONG,id_transportista,FacturaConstantesFunciones.IDTRANSPORTISTA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTransportista);

			FacturaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTransportista","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			facturas=facturaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				FacturaConstantesFunciones.refrescarForeignKeysDescripcionesFactura(this.facturas);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getFacturasFK_IdUsuarioWithConnection(String sFinalQuery,Pagination pagination,Long id_usuario)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Factura.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidUsuario= new ParameterSelectionGeneral();
			parameterSelectionGeneralidUsuario.setParameterSelectionGeneralEqual(ParameterType.LONG,id_usuario,FacturaConstantesFunciones.IDUSUARIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidUsuario);

			FacturaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdUsuario","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			facturas=facturaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				FacturaConstantesFunciones.refrescarForeignKeysDescripcionesFactura(this.facturas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getFacturasFK_IdUsuario(String sFinalQuery,Pagination pagination,Long id_usuario)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidUsuario= new ParameterSelectionGeneral();
			parameterSelectionGeneralidUsuario.setParameterSelectionGeneralEqual(ParameterType.LONG,id_usuario,FacturaConstantesFunciones.IDUSUARIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidUsuario);

			FacturaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdUsuario","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			facturas=facturaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				FacturaConstantesFunciones.refrescarForeignKeysDescripcionesFactura(this.facturas);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getFacturasFK_IdVendedorWithConnection(String sFinalQuery,Pagination pagination,Long id_vendedor)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Factura.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidVendedor= new ParameterSelectionGeneral();
			parameterSelectionGeneralidVendedor.setParameterSelectionGeneralEqual(ParameterType.LONG,id_vendedor,FacturaConstantesFunciones.IDVENDEDOR,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidVendedor);

			FacturaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdVendedor","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			facturas=facturaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				FacturaConstantesFunciones.refrescarForeignKeysDescripcionesFactura(this.facturas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getFacturasFK_IdVendedor(String sFinalQuery,Pagination pagination,Long id_vendedor)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidVendedor= new ParameterSelectionGeneral();
			parameterSelectionGeneralidVendedor.setParameterSelectionGeneralEqual(ParameterType.LONG,id_vendedor,FacturaConstantesFunciones.IDVENDEDOR,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidVendedor);

			FacturaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdVendedor","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			facturas=facturaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				FacturaConstantesFunciones.refrescarForeignKeysDescripcionesFactura(this.facturas);
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
			if(FacturaConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,FacturaDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,Factura factura,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(FacturaConstantesFunciones.ISCONAUDITORIA) {
				if(factura.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,FacturaDataAccess.TABLENAME, factura.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(FacturaConstantesFunciones.ISCONAUDITORIADETALLE) {
						////FacturaLogic.registrarAuditoriaDetallesFactura(connexion,factura,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(factura.getIsDeleted()) {
					/*if(!factura.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,FacturaDataAccess.TABLENAME, factura.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////FacturaLogic.registrarAuditoriaDetallesFactura(connexion,factura,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,FacturaDataAccess.TABLENAME, factura.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(factura.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,FacturaDataAccess.TABLENAME, factura.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(FacturaConstantesFunciones.ISCONAUDITORIADETALLE) {
						////FacturaLogic.registrarAuditoriaDetallesFactura(connexion,factura,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesFactura(Connexion connexion,Factura factura)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(factura.getIsNew()||!factura.getid_empresa().equals(factura.getFacturaOriginal().getid_empresa()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(factura.getFacturaOriginal().getid_empresa()!=null)
				{
					strValorActual=factura.getFacturaOriginal().getid_empresa().toString();
				}
				if(factura.getid_empresa()!=null)
				{
					strValorNuevo=factura.getid_empresa().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),FacturaConstantesFunciones.IDEMPRESA,strValorActual,strValorNuevo);
			}	
			
			if(factura.getIsNew()||!factura.getid_sucursal().equals(factura.getFacturaOriginal().getid_sucursal()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(factura.getFacturaOriginal().getid_sucursal()!=null)
				{
					strValorActual=factura.getFacturaOriginal().getid_sucursal().toString();
				}
				if(factura.getid_sucursal()!=null)
				{
					strValorNuevo=factura.getid_sucursal().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),FacturaConstantesFunciones.IDSUCURSAL,strValorActual,strValorNuevo);
			}	
			
			if(factura.getIsNew()||!factura.getid_ejercicio().equals(factura.getFacturaOriginal().getid_ejercicio()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(factura.getFacturaOriginal().getid_ejercicio()!=null)
				{
					strValorActual=factura.getFacturaOriginal().getid_ejercicio().toString();
				}
				if(factura.getid_ejercicio()!=null)
				{
					strValorNuevo=factura.getid_ejercicio().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),FacturaConstantesFunciones.IDEJERCICIO,strValorActual,strValorNuevo);
			}	
			
			if(factura.getIsNew()||!factura.getid_periodo().equals(factura.getFacturaOriginal().getid_periodo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(factura.getFacturaOriginal().getid_periodo()!=null)
				{
					strValorActual=factura.getFacturaOriginal().getid_periodo().toString();
				}
				if(factura.getid_periodo()!=null)
				{
					strValorNuevo=factura.getid_periodo().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),FacturaConstantesFunciones.IDPERIODO,strValorActual,strValorNuevo);
			}	
			
			if(factura.getIsNew()||!factura.getid_anio().equals(factura.getFacturaOriginal().getid_anio()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(factura.getFacturaOriginal().getid_anio()!=null)
				{
					strValorActual=factura.getFacturaOriginal().getid_anio().toString();
				}
				if(factura.getid_anio()!=null)
				{
					strValorNuevo=factura.getid_anio().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),FacturaConstantesFunciones.IDANIO,strValorActual,strValorNuevo);
			}	
			
			if(factura.getIsNew()||!factura.getid_mes().equals(factura.getFacturaOriginal().getid_mes()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(factura.getFacturaOriginal().getid_mes()!=null)
				{
					strValorActual=factura.getFacturaOriginal().getid_mes().toString();
				}
				if(factura.getid_mes()!=null)
				{
					strValorNuevo=factura.getid_mes().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),FacturaConstantesFunciones.IDMES,strValorActual,strValorNuevo);
			}	
			
			if(factura.getIsNew()||!factura.getid_usuario().equals(factura.getFacturaOriginal().getid_usuario()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(factura.getFacturaOriginal().getid_usuario()!=null)
				{
					strValorActual=factura.getFacturaOriginal().getid_usuario().toString();
				}
				if(factura.getid_usuario()!=null)
				{
					strValorNuevo=factura.getid_usuario().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),FacturaConstantesFunciones.IDUSUARIO,strValorActual,strValorNuevo);
			}	
			
			if(factura.getIsNew()||!factura.getnumero_pre_impreso().equals(factura.getFacturaOriginal().getnumero_pre_impreso()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(factura.getFacturaOriginal().getnumero_pre_impreso()!=null)
				{
					strValorActual=factura.getFacturaOriginal().getnumero_pre_impreso();
				}
				if(factura.getnumero_pre_impreso()!=null)
				{
					strValorNuevo=factura.getnumero_pre_impreso() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),FacturaConstantesFunciones.NUMEROPREIMPRESO,strValorActual,strValorNuevo);
			}	
			
			if(factura.getIsNew()||!factura.getfecha_emision().equals(factura.getFacturaOriginal().getfecha_emision()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(factura.getFacturaOriginal().getfecha_emision()!=null)
				{
					strValorActual=factura.getFacturaOriginal().getfecha_emision().toString();
				}
				if(factura.getfecha_emision()!=null)
				{
					strValorNuevo=factura.getfecha_emision().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),FacturaConstantesFunciones.FECHAEMISION,strValorActual,strValorNuevo);
			}	
			
			if(factura.getIsNew()||!factura.getnumero_dias().equals(factura.getFacturaOriginal().getnumero_dias()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(factura.getFacturaOriginal().getnumero_dias()!=null)
				{
					strValorActual=factura.getFacturaOriginal().getnumero_dias().toString();
				}
				if(factura.getnumero_dias()!=null)
				{
					strValorNuevo=factura.getnumero_dias().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),FacturaConstantesFunciones.NUMERODIAS,strValorActual,strValorNuevo);
			}	
			
			if(factura.getIsNew()||!factura.getfecha_vencimiento().equals(factura.getFacturaOriginal().getfecha_vencimiento()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(factura.getFacturaOriginal().getfecha_vencimiento()!=null)
				{
					strValorActual=factura.getFacturaOriginal().getfecha_vencimiento().toString();
				}
				if(factura.getfecha_vencimiento()!=null)
				{
					strValorNuevo=factura.getfecha_vencimiento().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),FacturaConstantesFunciones.FECHAVENCIMIENTO,strValorActual,strValorNuevo);
			}	
			
			if(factura.getIsNew()||!factura.getid_moneda().equals(factura.getFacturaOriginal().getid_moneda()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(factura.getFacturaOriginal().getid_moneda()!=null)
				{
					strValorActual=factura.getFacturaOriginal().getid_moneda().toString();
				}
				if(factura.getid_moneda()!=null)
				{
					strValorNuevo=factura.getid_moneda().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),FacturaConstantesFunciones.IDMONEDA,strValorActual,strValorNuevo);
			}	
			
			if(factura.getIsNew()||!factura.getcotizacion().equals(factura.getFacturaOriginal().getcotizacion()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(factura.getFacturaOriginal().getcotizacion()!=null)
				{
					strValorActual=factura.getFacturaOriginal().getcotizacion().toString();
				}
				if(factura.getcotizacion()!=null)
				{
					strValorNuevo=factura.getcotizacion().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),FacturaConstantesFunciones.COTIZACION,strValorActual,strValorNuevo);
			}	
			
			if(factura.getIsNew()||!factura.getid_empleado().equals(factura.getFacturaOriginal().getid_empleado()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(factura.getFacturaOriginal().getid_empleado()!=null)
				{
					strValorActual=factura.getFacturaOriginal().getid_empleado().toString();
				}
				if(factura.getid_empleado()!=null)
				{
					strValorNuevo=factura.getid_empleado().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),FacturaConstantesFunciones.IDEMPLEADO,strValorActual,strValorNuevo);
			}	
			
			if(factura.getIsNew()||!factura.getid_formato().equals(factura.getFacturaOriginal().getid_formato()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(factura.getFacturaOriginal().getid_formato()!=null)
				{
					strValorActual=factura.getFacturaOriginal().getid_formato().toString();
				}
				if(factura.getid_formato()!=null)
				{
					strValorNuevo=factura.getid_formato().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),FacturaConstantesFunciones.IDFORMATO,strValorActual,strValorNuevo);
			}	
			
			if(factura.getIsNew()||!factura.getdireccion().equals(factura.getFacturaOriginal().getdireccion()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(factura.getFacturaOriginal().getdireccion()!=null)
				{
					strValorActual=factura.getFacturaOriginal().getdireccion();
				}
				if(factura.getdireccion()!=null)
				{
					strValorNuevo=factura.getdireccion() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),FacturaConstantesFunciones.DIRECCION,strValorActual,strValorNuevo);
			}	
			
			if(factura.getIsNew()||!factura.getruc().equals(factura.getFacturaOriginal().getruc()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(factura.getFacturaOriginal().getruc()!=null)
				{
					strValorActual=factura.getFacturaOriginal().getruc();
				}
				if(factura.getruc()!=null)
				{
					strValorNuevo=factura.getruc() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),FacturaConstantesFunciones.RUC,strValorActual,strValorNuevo);
			}	
			
			if(factura.getIsNew()||!factura.getid_cliente().equals(factura.getFacturaOriginal().getid_cliente()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(factura.getFacturaOriginal().getid_cliente()!=null)
				{
					strValorActual=factura.getFacturaOriginal().getid_cliente().toString();
				}
				if(factura.getid_cliente()!=null)
				{
					strValorNuevo=factura.getid_cliente().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),FacturaConstantesFunciones.IDCLIENTE,strValorActual,strValorNuevo);
			}	
			
			if(factura.getIsNew()||!factura.getid_tipo_precio().equals(factura.getFacturaOriginal().getid_tipo_precio()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(factura.getFacturaOriginal().getid_tipo_precio()!=null)
				{
					strValorActual=factura.getFacturaOriginal().getid_tipo_precio().toString();
				}
				if(factura.getid_tipo_precio()!=null)
				{
					strValorNuevo=factura.getid_tipo_precio().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),FacturaConstantesFunciones.IDTIPOPRECIO,strValorActual,strValorNuevo);
			}	
			
			if(factura.getIsNew()||!factura.gettelefono().equals(factura.getFacturaOriginal().gettelefono()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(factura.getFacturaOriginal().gettelefono()!=null)
				{
					strValorActual=factura.getFacturaOriginal().gettelefono();
				}
				if(factura.gettelefono()!=null)
				{
					strValorNuevo=factura.gettelefono() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),FacturaConstantesFunciones.TELEFONO,strValorActual,strValorNuevo);
			}	
			
			if(factura.getIsNew()||!factura.getid_sub_cliente().equals(factura.getFacturaOriginal().getid_sub_cliente()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(factura.getFacturaOriginal().getid_sub_cliente()!=null)
				{
					strValorActual=factura.getFacturaOriginal().getid_sub_cliente().toString();
				}
				if(factura.getid_sub_cliente()!=null)
				{
					strValorNuevo=factura.getid_sub_cliente().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),FacturaConstantesFunciones.IDSUBCLIENTE,strValorActual,strValorNuevo);
			}	
			
			if(factura.getIsNew()||!factura.getid_vendedor().equals(factura.getFacturaOriginal().getid_vendedor()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(factura.getFacturaOriginal().getid_vendedor()!=null)
				{
					strValorActual=factura.getFacturaOriginal().getid_vendedor().toString();
				}
				if(factura.getid_vendedor()!=null)
				{
					strValorNuevo=factura.getid_vendedor().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),FacturaConstantesFunciones.IDVENDEDOR,strValorActual,strValorNuevo);
			}	
			
			if(factura.getIsNew()||!factura.getid_transporte().equals(factura.getFacturaOriginal().getid_transporte()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(factura.getFacturaOriginal().getid_transporte()!=null)
				{
					strValorActual=factura.getFacturaOriginal().getid_transporte().toString();
				}
				if(factura.getid_transporte()!=null)
				{
					strValorNuevo=factura.getid_transporte().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),FacturaConstantesFunciones.IDTRANSPORTE,strValorActual,strValorNuevo);
			}	
			
			if(factura.getIsNew()||!factura.getid_transportista().equals(factura.getFacturaOriginal().getid_transportista()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(factura.getFacturaOriginal().getid_transportista()!=null)
				{
					strValorActual=factura.getFacturaOriginal().getid_transportista().toString();
				}
				if(factura.getid_transportista()!=null)
				{
					strValorNuevo=factura.getid_transportista().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),FacturaConstantesFunciones.IDTRANSPORTISTA,strValorActual,strValorNuevo);
			}	
			
			if(factura.getIsNew()||!factura.getorden().equals(factura.getFacturaOriginal().getorden()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(factura.getFacturaOriginal().getorden()!=null)
				{
					strValorActual=factura.getFacturaOriginal().getorden();
				}
				if(factura.getorden()!=null)
				{
					strValorNuevo=factura.getorden() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),FacturaConstantesFunciones.ORDEN,strValorActual,strValorNuevo);
			}	
			
			if(factura.getIsNew()||!factura.getid_tipo_llamada().equals(factura.getFacturaOriginal().getid_tipo_llamada()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(factura.getFacturaOriginal().getid_tipo_llamada()!=null)
				{
					strValorActual=factura.getFacturaOriginal().getid_tipo_llamada().toString();
				}
				if(factura.getid_tipo_llamada()!=null)
				{
					strValorNuevo=factura.getid_tipo_llamada().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),FacturaConstantesFunciones.IDTIPOLLAMADA,strValorActual,strValorNuevo);
			}	
			
			if(factura.getIsNew()||!factura.gethora_inicio().equals(factura.getFacturaOriginal().gethora_inicio()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(factura.getFacturaOriginal().gethora_inicio()!=null)
				{
					strValorActual=factura.getFacturaOriginal().gethora_inicio().toString();
				}
				if(factura.gethora_inicio()!=null)
				{
					strValorNuevo=factura.gethora_inicio().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),FacturaConstantesFunciones.HORAINICIO,strValorActual,strValorNuevo);
			}	
			
			if(factura.getIsNew()||!factura.gethora_fin().equals(factura.getFacturaOriginal().gethora_fin()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(factura.getFacturaOriginal().gethora_fin()!=null)
				{
					strValorActual=factura.getFacturaOriginal().gethora_fin().toString();
				}
				if(factura.gethora_fin()!=null)
				{
					strValorNuevo=factura.gethora_fin().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),FacturaConstantesFunciones.HORAFIN,strValorActual,strValorNuevo);
			}	
			
			if(factura.getIsNew()||!factura.getid_tipo_factura().equals(factura.getFacturaOriginal().getid_tipo_factura()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(factura.getFacturaOriginal().getid_tipo_factura()!=null)
				{
					strValorActual=factura.getFacturaOriginal().getid_tipo_factura().toString();
				}
				if(factura.getid_tipo_factura()!=null)
				{
					strValorNuevo=factura.getid_tipo_factura().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),FacturaConstantesFunciones.IDTIPOFACTURA,strValorActual,strValorNuevo);
			}	
			
			if(factura.getIsNew()||!factura.getdescripcion().equals(factura.getFacturaOriginal().getdescripcion()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(factura.getFacturaOriginal().getdescripcion()!=null)
				{
					strValorActual=factura.getFacturaOriginal().getdescripcion();
				}
				if(factura.getdescripcion()!=null)
				{
					strValorNuevo=factura.getdescripcion() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),FacturaConstantesFunciones.DESCRIPCION,strValorActual,strValorNuevo);
			}	
			
			if(factura.getIsNew()||!factura.getcupo().equals(factura.getFacturaOriginal().getcupo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(factura.getFacturaOriginal().getcupo()!=null)
				{
					strValorActual=factura.getFacturaOriginal().getcupo().toString();
				}
				if(factura.getcupo()!=null)
				{
					strValorNuevo=factura.getcupo().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),FacturaConstantesFunciones.CUPO,strValorActual,strValorNuevo);
			}	
			
			if(factura.getIsNew()||!factura.getsaldo().equals(factura.getFacturaOriginal().getsaldo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(factura.getFacturaOriginal().getsaldo()!=null)
				{
					strValorActual=factura.getFacturaOriginal().getsaldo().toString();
				}
				if(factura.getsaldo()!=null)
				{
					strValorNuevo=factura.getsaldo().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),FacturaConstantesFunciones.SALDO,strValorActual,strValorNuevo);
			}	
			
			if(factura.getIsNew()||!factura.getdocumentos().equals(factura.getFacturaOriginal().getdocumentos()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(factura.getFacturaOriginal().getdocumentos()!=null)
				{
					strValorActual=factura.getFacturaOriginal().getdocumentos().toString();
				}
				if(factura.getdocumentos()!=null)
				{
					strValorNuevo=factura.getdocumentos().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),FacturaConstantesFunciones.DOCUMENTOS,strValorActual,strValorNuevo);
			}	
			
			if(factura.getIsNew()||!factura.getdisponible().equals(factura.getFacturaOriginal().getdisponible()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(factura.getFacturaOriginal().getdisponible()!=null)
				{
					strValorActual=factura.getFacturaOriginal().getdisponible().toString();
				}
				if(factura.getdisponible()!=null)
				{
					strValorNuevo=factura.getdisponible().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),FacturaConstantesFunciones.DISPONIBLE,strValorActual,strValorNuevo);
			}	
			
			if(factura.getIsNew()||!factura.getporcentaje_descuento().equals(factura.getFacturaOriginal().getporcentaje_descuento()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(factura.getFacturaOriginal().getporcentaje_descuento()!=null)
				{
					strValorActual=factura.getFacturaOriginal().getporcentaje_descuento().toString();
				}
				if(factura.getporcentaje_descuento()!=null)
				{
					strValorNuevo=factura.getporcentaje_descuento().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),FacturaConstantesFunciones.PORCENTAJEDESCUENTO,strValorActual,strValorNuevo);
			}	
			
			if(factura.getIsNew()||!factura.gettotal_iva().equals(factura.getFacturaOriginal().gettotal_iva()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(factura.getFacturaOriginal().gettotal_iva()!=null)
				{
					strValorActual=factura.getFacturaOriginal().gettotal_iva().toString();
				}
				if(factura.gettotal_iva()!=null)
				{
					strValorNuevo=factura.gettotal_iva().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),FacturaConstantesFunciones.TOTALIVA,strValorActual,strValorNuevo);
			}	
			
			if(factura.getIsNew()||!factura.getsuman().equals(factura.getFacturaOriginal().getsuman()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(factura.getFacturaOriginal().getsuman()!=null)
				{
					strValorActual=factura.getFacturaOriginal().getsuman().toString();
				}
				if(factura.getsuman()!=null)
				{
					strValorNuevo=factura.getsuman().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),FacturaConstantesFunciones.SUMAN,strValorActual,strValorNuevo);
			}	
			
			if(factura.getIsNew()||!factura.getdescuento_valor().equals(factura.getFacturaOriginal().getdescuento_valor()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(factura.getFacturaOriginal().getdescuento_valor()!=null)
				{
					strValorActual=factura.getFacturaOriginal().getdescuento_valor().toString();
				}
				if(factura.getdescuento_valor()!=null)
				{
					strValorNuevo=factura.getdescuento_valor().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),FacturaConstantesFunciones.DESCUENTOVALOR,strValorActual,strValorNuevo);
			}	
			
			if(factura.getIsNew()||!factura.gettotal_sin_iva().equals(factura.getFacturaOriginal().gettotal_sin_iva()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(factura.getFacturaOriginal().gettotal_sin_iva()!=null)
				{
					strValorActual=factura.getFacturaOriginal().gettotal_sin_iva().toString();
				}
				if(factura.gettotal_sin_iva()!=null)
				{
					strValorNuevo=factura.gettotal_sin_iva().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),FacturaConstantesFunciones.TOTALSINIVA,strValorActual,strValorNuevo);
			}	
			
			if(factura.getIsNew()||!factura.gettotal_descuento().equals(factura.getFacturaOriginal().gettotal_descuento()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(factura.getFacturaOriginal().gettotal_descuento()!=null)
				{
					strValorActual=factura.getFacturaOriginal().gettotal_descuento().toString();
				}
				if(factura.gettotal_descuento()!=null)
				{
					strValorNuevo=factura.gettotal_descuento().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),FacturaConstantesFunciones.TOTALDESCUENTO,strValorActual,strValorNuevo);
			}	
			
			if(factura.getIsNew()||!factura.gettotal_flete().equals(factura.getFacturaOriginal().gettotal_flete()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(factura.getFacturaOriginal().gettotal_flete()!=null)
				{
					strValorActual=factura.getFacturaOriginal().gettotal_flete().toString();
				}
				if(factura.gettotal_flete()!=null)
				{
					strValorNuevo=factura.gettotal_flete().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),FacturaConstantesFunciones.TOTALFLETE,strValorActual,strValorNuevo);
			}	
			
			if(factura.getIsNew()||!factura.gettotal().equals(factura.getFacturaOriginal().gettotal()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(factura.getFacturaOriginal().gettotal()!=null)
				{
					strValorActual=factura.getFacturaOriginal().gettotal().toString();
				}
				if(factura.gettotal()!=null)
				{
					strValorNuevo=factura.gettotal().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),FacturaConstantesFunciones.TOTAL,strValorActual,strValorNuevo);
			}	
			
			if(factura.getIsNew()||!factura.getsub_total().equals(factura.getFacturaOriginal().getsub_total()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(factura.getFacturaOriginal().getsub_total()!=null)
				{
					strValorActual=factura.getFacturaOriginal().getsub_total().toString();
				}
				if(factura.getsub_total()!=null)
				{
					strValorNuevo=factura.getsub_total().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),FacturaConstantesFunciones.SUBTOTAL,strValorActual,strValorNuevo);
			}	
			
			if(factura.getIsNew()||!factura.gettotal_otro().equals(factura.getFacturaOriginal().gettotal_otro()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(factura.getFacturaOriginal().gettotal_otro()!=null)
				{
					strValorActual=factura.getFacturaOriginal().gettotal_otro().toString();
				}
				if(factura.gettotal_otro()!=null)
				{
					strValorNuevo=factura.gettotal_otro().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),FacturaConstantesFunciones.TOTALOTRO,strValorActual,strValorNuevo);
			}	
			
			if(factura.getIsNew()||!factura.getultimo_costo().equals(factura.getFacturaOriginal().getultimo_costo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(factura.getFacturaOriginal().getultimo_costo()!=null)
				{
					strValorActual=factura.getFacturaOriginal().getultimo_costo().toString();
				}
				if(factura.getultimo_costo()!=null)
				{
					strValorNuevo=factura.getultimo_costo().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),FacturaConstantesFunciones.ULTIMOCOSTO,strValorActual,strValorNuevo);
			}	
			
			if(factura.getIsNew()||!factura.getiva().equals(factura.getFacturaOriginal().getiva()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(factura.getFacturaOriginal().getiva()!=null)
				{
					strValorActual=factura.getFacturaOriginal().getiva().toString();
				}
				if(factura.getiva()!=null)
				{
					strValorNuevo=factura.getiva().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),FacturaConstantesFunciones.IVA,strValorActual,strValorNuevo);
			}	
			
			if(factura.getIsNew()||!factura.getdescuento().equals(factura.getFacturaOriginal().getdescuento()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(factura.getFacturaOriginal().getdescuento()!=null)
				{
					strValorActual=factura.getFacturaOriginal().getdescuento().toString();
				}
				if(factura.getdescuento()!=null)
				{
					strValorNuevo=factura.getdescuento().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),FacturaConstantesFunciones.DESCUENTO,strValorActual,strValorNuevo);
			}	
			
			if(factura.getIsNew()||!factura.getfinanciamiento().equals(factura.getFacturaOriginal().getfinanciamiento()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(factura.getFacturaOriginal().getfinanciamiento()!=null)
				{
					strValorActual=factura.getFacturaOriginal().getfinanciamiento().toString();
				}
				if(factura.getfinanciamiento()!=null)
				{
					strValorNuevo=factura.getfinanciamiento().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),FacturaConstantesFunciones.FINANCIAMIENTO,strValorActual,strValorNuevo);
			}	
			
			if(factura.getIsNew()||!factura.getmargen_utilidad().equals(factura.getFacturaOriginal().getmargen_utilidad()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(factura.getFacturaOriginal().getmargen_utilidad()!=null)
				{
					strValorActual=factura.getFacturaOriginal().getmargen_utilidad().toString();
				}
				if(factura.getmargen_utilidad()!=null)
				{
					strValorNuevo=factura.getmargen_utilidad().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),FacturaConstantesFunciones.MARGENUTILIDAD,strValorActual,strValorNuevo);
			}	
			
			if(factura.getIsNew()||!factura.getice().equals(factura.getFacturaOriginal().getice()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(factura.getFacturaOriginal().getice()!=null)
				{
					strValorActual=factura.getFacturaOriginal().getice().toString();
				}
				if(factura.getice()!=null)
				{
					strValorNuevo=factura.getice().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),FacturaConstantesFunciones.ICE,strValorActual,strValorNuevo);
			}	
			
			if(factura.getIsNew()||!factura.getanticipo().equals(factura.getFacturaOriginal().getanticipo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(factura.getFacturaOriginal().getanticipo()!=null)
				{
					strValorActual=factura.getFacturaOriginal().getanticipo().toString();
				}
				if(factura.getanticipo()!=null)
				{
					strValorNuevo=factura.getanticipo().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),FacturaConstantesFunciones.ANTICIPO,strValorActual,strValorNuevo);
			}	
			
			if(factura.getIsNew()||!factura.getotros_valores().equals(factura.getFacturaOriginal().getotros_valores()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(factura.getFacturaOriginal().getotros_valores()!=null)
				{
					strValorActual=factura.getFacturaOriginal().getotros_valores().toString();
				}
				if(factura.getotros_valores()!=null)
				{
					strValorNuevo=factura.getotros_valores().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),FacturaConstantesFunciones.OTROSVALORES,strValorActual,strValorNuevo);
			}	
			
			if(factura.getIsNew()||!factura.gettotal_retencion().equals(factura.getFacturaOriginal().gettotal_retencion()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(factura.getFacturaOriginal().gettotal_retencion()!=null)
				{
					strValorActual=factura.getFacturaOriginal().gettotal_retencion().toString();
				}
				if(factura.gettotal_retencion()!=null)
				{
					strValorNuevo=factura.gettotal_retencion().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),FacturaConstantesFunciones.TOTALRETENCION,strValorActual,strValorNuevo);
			}	
			
			if(factura.getIsNew()||!factura.gettotal_consumo_especial().equals(factura.getFacturaOriginal().gettotal_consumo_especial()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(factura.getFacturaOriginal().gettotal_consumo_especial()!=null)
				{
					strValorActual=factura.getFacturaOriginal().gettotal_consumo_especial().toString();
				}
				if(factura.gettotal_consumo_especial()!=null)
				{
					strValorNuevo=factura.gettotal_consumo_especial().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),FacturaConstantesFunciones.TOTALCONSUMOESPECIAL,strValorActual,strValorNuevo);
			}	
			
			if(factura.getIsNew()||!factura.getretencion().equals(factura.getFacturaOriginal().getretencion()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(factura.getFacturaOriginal().getretencion()!=null)
				{
					strValorActual=factura.getFacturaOriginal().getretencion().toString();
				}
				if(factura.getretencion()!=null)
				{
					strValorNuevo=factura.getretencion().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),FacturaConstantesFunciones.RETENCION,strValorActual,strValorNuevo);
			}	
			
			if(factura.getIsNew()||!factura.getid_tipo_cambio().equals(factura.getFacturaOriginal().getid_tipo_cambio()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(factura.getFacturaOriginal().getid_tipo_cambio()!=null)
				{
					strValorActual=factura.getFacturaOriginal().getid_tipo_cambio().toString();
				}
				if(factura.getid_tipo_cambio()!=null)
				{
					strValorNuevo=factura.getid_tipo_cambio().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),FacturaConstantesFunciones.IDTIPOCAMBIO,strValorActual,strValorNuevo);
			}	
			
			if(factura.getIsNew()||!factura.getes_cliente().equals(factura.getFacturaOriginal().getes_cliente()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(factura.getFacturaOriginal().getes_cliente()!=null)
				{
					strValorActual=factura.getFacturaOriginal().getes_cliente().toString();
				}
				if(factura.getes_cliente()!=null)
				{
					strValorNuevo=factura.getes_cliente().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),FacturaConstantesFunciones.ESCLIENTE,strValorActual,strValorNuevo);
			}	
			
			if(factura.getIsNew()||!factura.getid_asiento_contable().equals(factura.getFacturaOriginal().getid_asiento_contable()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(factura.getFacturaOriginal().getid_asiento_contable()!=null)
				{
					strValorActual=factura.getFacturaOriginal().getid_asiento_contable().toString();
				}
				if(factura.getid_asiento_contable()!=null)
				{
					strValorNuevo=factura.getid_asiento_contable().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),FacturaConstantesFunciones.IDASIENTOCONTABLE,strValorActual,strValorNuevo);
			}	
			
			if(factura.getIsNew()||!factura.getid_pedido().equals(factura.getFacturaOriginal().getid_pedido()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(factura.getFacturaOriginal().getid_pedido()!=null)
				{
					strValorActual=factura.getFacturaOriginal().getid_pedido().toString();
				}
				if(factura.getid_pedido()!=null)
				{
					strValorNuevo=factura.getid_pedido().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),FacturaConstantesFunciones.IDPEDIDO,strValorActual,strValorNuevo);
			}	
			
			if(factura.getIsNew()||!factura.getid_responsable().equals(factura.getFacturaOriginal().getid_responsable()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(factura.getFacturaOriginal().getid_responsable()!=null)
				{
					strValorActual=factura.getFacturaOriginal().getid_responsable().toString();
				}
				if(factura.getid_responsable()!=null)
				{
					strValorNuevo=factura.getid_responsable().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),FacturaConstantesFunciones.IDRESPONSABLE,strValorActual,strValorNuevo);
			}	
			
			if(factura.getIsNew()||!factura.getid_estado_fisico_factura_empresa().equals(factura.getFacturaOriginal().getid_estado_fisico_factura_empresa()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(factura.getFacturaOriginal().getid_estado_fisico_factura_empresa()!=null)
				{
					strValorActual=factura.getFacturaOriginal().getid_estado_fisico_factura_empresa().toString();
				}
				if(factura.getid_estado_fisico_factura_empresa()!=null)
				{
					strValorNuevo=factura.getid_estado_fisico_factura_empresa().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),FacturaConstantesFunciones.IDESTADOFISICOFACTURAEMPRESA,strValorActual,strValorNuevo);
			}	
			
			if(factura.getIsNew()||!factura.getfecha().equals(factura.getFacturaOriginal().getfecha()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(factura.getFacturaOriginal().getfecha()!=null)
				{
					strValorActual=factura.getFacturaOriginal().getfecha().toString();
				}
				if(factura.getfecha()!=null)
				{
					strValorNuevo=factura.getfecha().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),FacturaConstantesFunciones.FECHA,strValorActual,strValorNuevo);
			}	
			
			if(factura.getIsNew()||!factura.getfecha_autorizacion().equals(factura.getFacturaOriginal().getfecha_autorizacion()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(factura.getFacturaOriginal().getfecha_autorizacion()!=null)
				{
					strValorActual=factura.getFacturaOriginal().getfecha_autorizacion().toString();
				}
				if(factura.getfecha_autorizacion()!=null)
				{
					strValorNuevo=factura.getfecha_autorizacion().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),FacturaConstantesFunciones.FECHAAUTORIZACION,strValorActual,strValorNuevo);
			}	
			
			if(factura.getIsNew()||!factura.getfecha_cliente().equals(factura.getFacturaOriginal().getfecha_cliente()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(factura.getFacturaOriginal().getfecha_cliente()!=null)
				{
					strValorActual=factura.getFacturaOriginal().getfecha_cliente().toString();
				}
				if(factura.getfecha_cliente()!=null)
				{
					strValorNuevo=factura.getfecha_cliente().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),FacturaConstantesFunciones.FECHACLIENTE,strValorActual,strValorNuevo);
			}	
			
			if(factura.getIsNew()||!factura.getnumero_documento().equals(factura.getFacturaOriginal().getnumero_documento()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(factura.getFacturaOriginal().getnumero_documento()!=null)
				{
					strValorActual=factura.getFacturaOriginal().getnumero_documento();
				}
				if(factura.getnumero_documento()!=null)
				{
					strValorNuevo=factura.getnumero_documento() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),FacturaConstantesFunciones.NUMERODOCUMENTO,strValorActual,strValorNuevo);
			}	
			
			if(factura.getIsNew()||!factura.getnumero_dau().equals(factura.getFacturaOriginal().getnumero_dau()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(factura.getFacturaOriginal().getnumero_dau()!=null)
				{
					strValorActual=factura.getFacturaOriginal().getnumero_dau();
				}
				if(factura.getnumero_dau()!=null)
				{
					strValorNuevo=factura.getnumero_dau() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),FacturaConstantesFunciones.NUMERODAU,strValorActual,strValorNuevo);
			}	
			
			if(factura.getIsNew()||!factura.getnumero_referendo().equals(factura.getFacturaOriginal().getnumero_referendo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(factura.getFacturaOriginal().getnumero_referendo()!=null)
				{
					strValorActual=factura.getFacturaOriginal().getnumero_referendo();
				}
				if(factura.getnumero_referendo()!=null)
				{
					strValorNuevo=factura.getnumero_referendo() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),FacturaConstantesFunciones.NUMEROREFERENDO,strValorActual,strValorNuevo);
			}	
			
			if(factura.getIsNew()||!factura.getfecha_referendo().equals(factura.getFacturaOriginal().getfecha_referendo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(factura.getFacturaOriginal().getfecha_referendo()!=null)
				{
					strValorActual=factura.getFacturaOriginal().getfecha_referendo().toString();
				}
				if(factura.getfecha_referendo()!=null)
				{
					strValorNuevo=factura.getfecha_referendo().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),FacturaConstantesFunciones.FECHAREFERENDO,strValorActual,strValorNuevo);
			}	
			
			if(factura.getIsNew()||!factura.getaforo_referendo().equals(factura.getFacturaOriginal().getaforo_referendo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(factura.getFacturaOriginal().getaforo_referendo()!=null)
				{
					strValorActual=factura.getFacturaOriginal().getaforo_referendo();
				}
				if(factura.getaforo_referendo()!=null)
				{
					strValorNuevo=factura.getaforo_referendo() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),FacturaConstantesFunciones.AFOROREFERENDO,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void saveFacturaRelacionesWithConnection(Factura factura,List<DetaFormaPago> detaformapagos,List<DetalleFactura> detallefacturas) throws Exception {

		if(!factura.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveFacturaRelacionesBase(factura,detaformapagos,detallefacturas,true);
		}
	}

	public void saveFacturaRelaciones(Factura factura,List<DetaFormaPago> detaformapagos,List<DetalleFactura> detallefacturas)throws Exception {

		if(!factura.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveFacturaRelacionesBase(factura,detaformapagos,detallefacturas,false);
		}
	}

	public void saveFacturaRelacionesBase(Factura factura,List<DetaFormaPago> detaformapagos,List<DetalleFactura> detallefacturas,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("Factura-saveRelacionesWithConnection");}
	
			factura.setDetaFormaPagos(detaformapagos);
			factura.setDetalleFacturas(detallefacturas);

			this.setFactura(factura);

			if(FacturaLogicAdditional.validarSaveRelaciones(factura,this)) {

				FacturaLogicAdditional.updateRelacionesToSave(factura,this);

				if((factura.getIsNew()||factura.getIsChanged())&&!factura.getIsDeleted()) {
					this.saveFactura();
					this.saveFacturaRelacionesDetalles(detaformapagos,detallefacturas);

				} else if(factura.getIsDeleted()) {
					this.saveFacturaRelacionesDetalles(detaformapagos,detallefacturas);
					this.saveFactura();
				}

				FacturaLogicAdditional.updateRelacionesToSaveAfter(factura,this);

			} else {
				throw new Exception("LOS DATOS SON INVALIDOS");
			}

			if(conConexion) {connexion.commit();}

		} catch(Exception e) {
			
			DetaFormaPagoConstantesFunciones.InicializarGeneralEntityAuxiliaresDetaFormaPagos(detaformapagos,true,true);
			DetalleFacturaConstantesFunciones.InicializarGeneralEntityAuxiliaresDetalleFacturas(detallefacturas,true,true);

			if(conConexion){connexion.rollback();}
			Funciones.manageException(logger,e);
			throw e;

		} finally {
			if(conConexion){this.closeNewConnexionToDeep();}
		}
	}
	
	
	private void saveFacturaRelacionesDetalles(List<DetaFormaPago> detaformapagos,List<DetalleFactura> detallefacturas)throws Exception {
		try {
	

			Long idFacturaActual=this.getFactura().getId();

			DetaFormaPagoLogic detaformapagoLogic_Desde_Factura=new DetaFormaPagoLogic();
			detaformapagoLogic_Desde_Factura.setDetaFormaPagos(detaformapagos);

			detaformapagoLogic_Desde_Factura.setConnexion(this.getConnexion());
			detaformapagoLogic_Desde_Factura.setDatosCliente(this.datosCliente);

			for(DetaFormaPago detaformapago_Desde_Factura:detaformapagoLogic_Desde_Factura.getDetaFormaPagos()) {
				detaformapago_Desde_Factura.setid_factura(idFacturaActual);

				detaformapagoLogic_Desde_Factura.setDetaFormaPago(detaformapago_Desde_Factura);
				detaformapagoLogic_Desde_Factura.saveDetaFormaPago();

				Long idDetaFormaPagoActual=detaformapago_Desde_Factura.getId();

				BancoFormaPagoLogic bancoformapagoLogic_Desde_DetaFormaPago=new BancoFormaPagoLogic();

				if(detaformapago_Desde_Factura.getBancoFormaPagos()==null){
					detaformapago_Desde_Factura.setBancoFormaPagos(new ArrayList<BancoFormaPago>());
				}

				bancoformapagoLogic_Desde_DetaFormaPago.setBancoFormaPagos(detaformapago_Desde_Factura.getBancoFormaPagos());

				bancoformapagoLogic_Desde_DetaFormaPago.setConnexion(this.getConnexion());
				bancoformapagoLogic_Desde_DetaFormaPago.setDatosCliente(this.datosCliente);

				for(BancoFormaPago bancoformapago_Desde_DetaFormaPago:bancoformapagoLogic_Desde_DetaFormaPago.getBancoFormaPagos()) {
					bancoformapago_Desde_DetaFormaPago.setid_deta_forma_pago(idDetaFormaPagoActual);
				}

				bancoformapagoLogic_Desde_DetaFormaPago.saveBancoFormaPagos();
			}


			DetalleFacturaLogic detallefacturaLogic_Desde_Factura=new DetalleFacturaLogic();
			detallefacturaLogic_Desde_Factura.setDetalleFacturas(detallefacturas);

			detallefacturaLogic_Desde_Factura.setConnexion(this.getConnexion());
			detallefacturaLogic_Desde_Factura.setDatosCliente(this.datosCliente);

			for(DetalleFactura detallefactura_Desde_Factura:detallefacturaLogic_Desde_Factura.getDetalleFacturas()) {
				detallefactura_Desde_Factura.setid_factura(idFacturaActual);
			}

			detallefacturaLogic_Desde_Factura.saveDetalleFacturas();

		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfFactura(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=FacturaConstantesFunciones.getClassesForeignKeysOfFactura(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfFactura(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=FacturaConstantesFunciones.getClassesRelationshipsOfFactura(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}
