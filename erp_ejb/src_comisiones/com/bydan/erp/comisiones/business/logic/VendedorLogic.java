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
package com.bydan.erp.comisiones.business.logic;

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
import com.bydan.erp.comisiones.util.*;
import com.bydan.erp.comisiones.util.VendedorConstantesFunciones;
import com.bydan.erp.comisiones.util.VendedorParameterReturnGeneral;
//import com.bydan.erp.comisiones.util.VendedorParameterGeneral;
import com.bydan.erp.comisiones.business.entity.Vendedor;
import com.bydan.erp.comisiones.business.logic.VendedorLogicAdditional;
import com.bydan.erp.comisiones.business.dataaccess.*;
import com.bydan.erp.comisiones.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.nomina.business.entity.*;
import com.bydan.erp.facturacion.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.inventario.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.comisiones.business.entity.*;
import com.bydan.erp.sris.business.entity.*;
import com.bydan.erp.tesoreria.business.entity.*;
import com.bydan.erp.puntoventa.business.entity.*;
import com.bydan.erp.activosfijos.business.entity.*;
import com.bydan.erp.importaciones.business.entity.*;
import com.bydan.erp.produccion.business.entity.*;


import com.bydan.erp.seguridad.business.logic.*;
import com.bydan.erp.nomina.business.logic.*;
import com.bydan.erp.facturacion.business.logic.*;
import com.bydan.erp.contabilidad.business.logic.*;
import com.bydan.erp.inventario.business.logic.*;
import com.bydan.erp.cartera.business.logic.*;
import com.bydan.erp.comisiones.business.logic.*;
import com.bydan.erp.sris.business.logic.*;
import com.bydan.erp.tesoreria.business.logic.*;
import com.bydan.erp.puntoventa.business.logic.*;
import com.bydan.erp.activosfijos.business.logic.*;
import com.bydan.erp.importaciones.business.logic.*;
import com.bydan.erp.produccion.business.logic.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.nomina.util.*;
import com.bydan.erp.facturacion.util.*;
import com.bydan.erp.contabilidad.util.*;
import com.bydan.erp.inventario.util.*;
import com.bydan.erp.cartera.util.*;
import com.bydan.erp.comisiones.util.*;
import com.bydan.erp.sris.util.*;
import com.bydan.erp.tesoreria.util.*;
import com.bydan.erp.puntoventa.util.*;
import com.bydan.erp.activosfijos.util.*;
import com.bydan.erp.importaciones.util.*;
import com.bydan.erp.produccion.util.*;


import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.nomina.business.dataaccess.*;
import com.bydan.erp.facturacion.business.dataaccess.*;
import com.bydan.erp.contabilidad.business.dataaccess.*;
import com.bydan.erp.inventario.business.dataaccess.*;
import com.bydan.erp.cartera.business.dataaccess.*;
import com.bydan.erp.comisiones.business.dataaccess.*;
import com.bydan.erp.sris.business.dataaccess.*;
import com.bydan.erp.tesoreria.business.dataaccess.*;
import com.bydan.erp.puntoventa.business.dataaccess.*;
import com.bydan.erp.activosfijos.business.dataaccess.*;
import com.bydan.erp.importaciones.business.dataaccess.*;
import com.bydan.erp.produccion.business.dataaccess.*;








@SuppressWarnings("unused")
public class VendedorLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(VendedorLogic.class);
	
	protected VendedorDataAccess vendedorDataAccess; 	
	protected Vendedor vendedor;
	protected List<Vendedor> vendedors;
	protected Object vendedorObject;	
	protected List<Object> vendedorsObject;
	
	public static ClassValidator<Vendedor> vendedorValidator = new ClassValidator<Vendedor>(Vendedor.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected VendedorLogicAdditional vendedorLogicAdditional=null;
	
	public VendedorLogicAdditional getVendedorLogicAdditional() {
		return this.vendedorLogicAdditional;
	}
	
	public void setVendedorLogicAdditional(VendedorLogicAdditional vendedorLogicAdditional) {
		try {
			this.vendedorLogicAdditional=vendedorLogicAdditional;
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
	
	
	
	
	public  VendedorLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.vendedorDataAccess = new VendedorDataAccess();
			
			this.vendedors= new ArrayList<Vendedor>();
			this.vendedor= new Vendedor();
			
			this.vendedorObject=new Object();
			this.vendedorsObject=new ArrayList<Object>();
				
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
			
			this.vendedorDataAccess.setConnexionType(this.connexionType);
			this.vendedorDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  VendedorLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.vendedorDataAccess = new VendedorDataAccess();
			this.vendedors= new ArrayList<Vendedor>();
			this.vendedor= new Vendedor();
			this.vendedorObject=new Object();
			this.vendedorsObject=new ArrayList<Object>();
			
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
			
			this.vendedorDataAccess.setConnexionType(this.connexionType);
			this.vendedorDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public Vendedor getVendedor() throws Exception {	
		VendedorLogicAdditional.checkVendedorToGet(vendedor,this.datosCliente,this.arrDatoGeneral);
		VendedorLogicAdditional.updateVendedorToGet(vendedor,this.arrDatoGeneral);
		
		return vendedor;
	}
		
	public void setVendedor(Vendedor newVendedor) {
		this.vendedor = newVendedor;
	}
	
	public VendedorDataAccess getVendedorDataAccess() {
		return vendedorDataAccess;
	}
	
	public void setVendedorDataAccess(VendedorDataAccess newvendedorDataAccess) {
		this.vendedorDataAccess = newvendedorDataAccess;
	}
	
	public List<Vendedor> getVendedors() throws Exception {		
		this.quitarVendedorsNulos();
		
		VendedorLogicAdditional.checkVendedorToGets(vendedors,this.datosCliente,this.arrDatoGeneral);
		
		for (Vendedor vendedorLocal: vendedors ) {
			VendedorLogicAdditional.updateVendedorToGet(vendedorLocal,this.arrDatoGeneral);
		}
		
		return vendedors;
	}
	
	public void setVendedors(List<Vendedor> newVendedors) {
		this.vendedors = newVendedors;
	}
	
	public Object getVendedorObject() {	
		this.vendedorObject=this.vendedorDataAccess.getEntityObject();
		return this.vendedorObject;
	}
		
	public void setVendedorObject(Object newVendedorObject) {
		this.vendedorObject = newVendedorObject;
	}
	
	public List<Object> getVendedorsObject() {		
		this.vendedorsObject=this.vendedorDataAccess.getEntitiesObject();
		return this.vendedorsObject;
	}
		
	public void setVendedorsObject(List<Object> newVendedorsObject) {
		this.vendedorsObject = newVendedorsObject;
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
		
		if(this.vendedorDataAccess!=null) {
			this.vendedorDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Vendedor.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			vendedorDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			vendedorDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		vendedor = new  Vendedor();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Vendedor.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			vendedor=vendedorDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.vendedor,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				VendedorConstantesFunciones.refrescarForeignKeysDescripcionesVendedor(this.vendedor);
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
		vendedor = new  Vendedor();
		  		  
        try {
			
			vendedor=vendedorDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.vendedor,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				VendedorConstantesFunciones.refrescarForeignKeysDescripcionesVendedor(this.vendedor);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		vendedor = new  Vendedor();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Vendedor.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			vendedor=vendedorDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.vendedor,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				VendedorConstantesFunciones.refrescarForeignKeysDescripcionesVendedor(this.vendedor);
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
		vendedor = new  Vendedor();
		  		  
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
		vendedor = new  Vendedor();
		  		  
        try {
			
			vendedor=vendedorDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.vendedor,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				VendedorConstantesFunciones.refrescarForeignKeysDescripcionesVendedor(this.vendedor);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		vendedor = new  Vendedor();
		  		  
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
		vendedor = new  Vendedor();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Vendedor.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =vendedorDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		vendedor = new  Vendedor();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=vendedorDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		vendedor = new  Vendedor();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Vendedor.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =vendedorDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		vendedor = new  Vendedor();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=vendedorDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		vendedor = new  Vendedor();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Vendedor.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =vendedorDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		vendedor = new  Vendedor();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=vendedorDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		vendedors = new  ArrayList<Vendedor>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Vendedor.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			VendedorLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			vendedors=vendedorDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarVendedor(vendedors);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				VendedorConstantesFunciones.refrescarForeignKeysDescripcionesVendedor(this.vendedors);
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
		vendedors = new  ArrayList<Vendedor>();
		  		  
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
		vendedors = new  ArrayList<Vendedor>();
		  		  
        try {			
			VendedorLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			vendedors=vendedorDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarVendedor(vendedors);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				VendedorConstantesFunciones.refrescarForeignKeysDescripcionesVendedor(this.vendedors);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		vendedors = new  ArrayList<Vendedor>();
		  		  
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
		vendedors = new  ArrayList<Vendedor>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Vendedor.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			VendedorLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			vendedors=vendedorDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarVendedor(vendedors);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				VendedorConstantesFunciones.refrescarForeignKeysDescripcionesVendedor(this.vendedors);
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
		vendedors = new  ArrayList<Vendedor>();
		  		  
        try {
			VendedorLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			vendedors=vendedorDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarVendedor(vendedors);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				VendedorConstantesFunciones.refrescarForeignKeysDescripcionesVendedor(this.vendedors);
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
		vendedors = new  ArrayList<Vendedor>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Vendedor.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			VendedorLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			vendedors=vendedorDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarVendedor(vendedors);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				VendedorConstantesFunciones.refrescarForeignKeysDescripcionesVendedor(this.vendedors);
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
		vendedors = new  ArrayList<Vendedor>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			VendedorLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			vendedors=vendedorDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarVendedor(vendedors);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				VendedorConstantesFunciones.refrescarForeignKeysDescripcionesVendedor(this.vendedors);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		vendedor = new  Vendedor();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Vendedor.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			VendedorLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			vendedor=vendedorDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarVendedor(vendedor);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				VendedorConstantesFunciones.refrescarForeignKeysDescripcionesVendedor(this.vendedor);
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
		vendedor = new  Vendedor();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			VendedorLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			vendedor=vendedorDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarVendedor(vendedor);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				VendedorConstantesFunciones.refrescarForeignKeysDescripcionesVendedor(this.vendedor);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		vendedors = new  ArrayList<Vendedor>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Vendedor.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			VendedorLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			vendedors=vendedorDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarVendedor(vendedors);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				VendedorConstantesFunciones.refrescarForeignKeysDescripcionesVendedor(this.vendedors);
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
		vendedors = new  ArrayList<Vendedor>();
		  		  
        try {
			VendedorLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			vendedors=vendedorDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarVendedor(vendedors);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				VendedorConstantesFunciones.refrescarForeignKeysDescripcionesVendedor(this.vendedors);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosVendedorsWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		vendedors = new  ArrayList<Vendedor>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Vendedor.class.getSimpleName()+"-getTodosVendedorsWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			VendedorLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			vendedors=vendedorDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarVendedor(vendedors);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				VendedorConstantesFunciones.refrescarForeignKeysDescripcionesVendedor(this.vendedors);
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
	
	public  void  getTodosVendedors(String sFinalQuery,Pagination pagination)throws Exception {
		vendedors = new  ArrayList<Vendedor>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			VendedorLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			vendedors=vendedorDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarVendedor(vendedors);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				VendedorConstantesFunciones.refrescarForeignKeysDescripcionesVendedor(this.vendedors);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarVendedor(Vendedor vendedor) throws Exception {
		Boolean estaValidado=false;
		
		if(vendedor.getIsNew() || vendedor.getIsChanged()) { 
			this.invalidValues = vendedorValidator.getInvalidValues(vendedor);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(vendedor);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarVendedor(List<Vendedor> Vendedors) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(Vendedor vendedorLocal:vendedors) {				
			estaValidadoObjeto=this.validarGuardarVendedor(vendedorLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarVendedor(List<Vendedor> Vendedors) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarVendedor(vendedors)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarVendedor(Vendedor Vendedor) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarVendedor(vendedor)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(Vendedor vendedor) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+vendedor.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=VendedorConstantesFunciones.getVendedorLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"vendedor","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(VendedorConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(VendedorConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveVendedorWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Vendedor.class.getSimpleName()+"-saveVendedorWithConnection");connexion.begin();			
			
			VendedorLogicAdditional.checkVendedorToSave(this.vendedor,this.datosCliente,connexion,this.arrDatoGeneral);
			
			VendedorLogicAdditional.updateVendedorToSave(this.vendedor,this.arrDatoGeneral);
			
			VendedorLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.vendedor,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowVendedor();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarVendedor(this.vendedor)) {
				VendedorDataAccess.save(this.vendedor, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.vendedor,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			VendedorLogicAdditional.checkVendedorToSaveAfter(this.vendedor,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowVendedor();
			
			connexion.commit();			
			
			if(this.vendedor.getIsDeleted()) {
				this.vendedor=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveVendedor()throws Exception {	
		try {	
			
			VendedorLogicAdditional.checkVendedorToSave(this.vendedor,this.datosCliente,connexion,this.arrDatoGeneral);
			
			VendedorLogicAdditional.updateVendedorToSave(this.vendedor,this.arrDatoGeneral);
			
			VendedorLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.vendedor,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarVendedor(this.vendedor)) {			
				VendedorDataAccess.save(this.vendedor, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.vendedor,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			VendedorLogicAdditional.checkVendedorToSaveAfter(this.vendedor,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.vendedor.getIsDeleted()) {
				this.vendedor=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveVendedorsWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Vendedor.class.getSimpleName()+"-saveVendedorsWithConnection");connexion.begin();			
			
			VendedorLogicAdditional.checkVendedorToSaves(vendedors,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowVendedors();
			
			Boolean validadoTodosVendedor=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(Vendedor vendedorLocal:vendedors) {		
				if(vendedorLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				VendedorLogicAdditional.updateVendedorToSave(vendedorLocal,this.arrDatoGeneral);
	        	
				VendedorLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),vendedorLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarVendedor(vendedorLocal)) {
					VendedorDataAccess.save(vendedorLocal, connexion);				
				} else {
					validadoTodosVendedor=false;
				}
			}
			
			if(!validadoTodosVendedor) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			VendedorLogicAdditional.checkVendedorToSavesAfter(vendedors,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowVendedors();
			
			connexion.commit();		
			
			this.quitarVendedorsEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveVendedors()throws Exception {				
		 try {	
			VendedorLogicAdditional.checkVendedorToSaves(vendedors,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosVendedor=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(Vendedor vendedorLocal:vendedors) {				
				if(vendedorLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				VendedorLogicAdditional.updateVendedorToSave(vendedorLocal,this.arrDatoGeneral);
	        	
				VendedorLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),vendedorLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarVendedor(vendedorLocal)) {				
					VendedorDataAccess.save(vendedorLocal, connexion);				
				} else {
					validadoTodosVendedor=false;
				}
			}
			
			if(!validadoTodosVendedor) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			VendedorLogicAdditional.checkVendedorToSavesAfter(vendedors,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarVendedorsEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public VendedorParameterReturnGeneral procesarAccionVendedors(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<Vendedor> vendedors,VendedorParameterReturnGeneral vendedorParameterGeneral)throws Exception {
		 try {	
			VendedorParameterReturnGeneral vendedorReturnGeneral=new VendedorParameterReturnGeneral();
	
			VendedorLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,vendedors,vendedorParameterGeneral,vendedorReturnGeneral);
			
			return vendedorReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public VendedorParameterReturnGeneral procesarAccionVendedorsWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<Vendedor> vendedors,VendedorParameterReturnGeneral vendedorParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Vendedor.class.getSimpleName()+"-procesarAccionVendedorsWithConnection");connexion.begin();			
			
			VendedorParameterReturnGeneral vendedorReturnGeneral=new VendedorParameterReturnGeneral();
	
			VendedorLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,vendedors,vendedorParameterGeneral,vendedorReturnGeneral);
			
			this.connexion.commit();
			
			return vendedorReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public VendedorParameterReturnGeneral procesarEventosVendedors(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<Vendedor> vendedors,Vendedor vendedor,VendedorParameterReturnGeneral vendedorParameterGeneral,Boolean isEsNuevoVendedor,ArrayList<Classe> clases)throws Exception {
		 try {	
			VendedorParameterReturnGeneral vendedorReturnGeneral=new VendedorParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				vendedorReturnGeneral.setConRecargarPropiedades(true);
			}
			
			VendedorLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,vendedors,vendedor,vendedorParameterGeneral,vendedorReturnGeneral,isEsNuevoVendedor,clases);
			
			return vendedorReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public VendedorParameterReturnGeneral procesarEventosVendedorsWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<Vendedor> vendedors,Vendedor vendedor,VendedorParameterReturnGeneral vendedorParameterGeneral,Boolean isEsNuevoVendedor,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Vendedor.class.getSimpleName()+"-procesarEventosVendedorsWithConnection");connexion.begin();			
			
			VendedorParameterReturnGeneral vendedorReturnGeneral=new VendedorParameterReturnGeneral();
	
			vendedorReturnGeneral.setVendedor(vendedor);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				vendedorReturnGeneral.setConRecargarPropiedades(true);
			}
			
			VendedorLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,vendedors,vendedor,vendedorParameterGeneral,vendedorReturnGeneral,isEsNuevoVendedor,clases);
			
			this.connexion.commit();
			
			return vendedorReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public VendedorParameterReturnGeneral procesarImportacionVendedorsWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,VendedorParameterReturnGeneral vendedorParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Vendedor.class.getSimpleName()+"-procesarImportacionVendedorsWithConnection");connexion.begin();			
			
			VendedorParameterReturnGeneral vendedorReturnGeneral=new VendedorParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.vendedors=new ArrayList<Vendedor>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.vendedor=new Vendedor();
				
				
				if(conColumnasBase) {this.vendedor.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.vendedor.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.vendedor.setcodigo(arrColumnas[iColumn++]);
				this.vendedor.setnombre(arrColumnas[iColumn++]);
				this.vendedor.setruc(arrColumnas[iColumn++]);
				this.vendedor.setemail(arrColumnas[iColumn++]);
				this.vendedor.settelefono(arrColumnas[iColumn++]);
				this.vendedor.setrepresentante(arrColumnas[iColumn++]);
				this.vendedor.setes_supervisor(Boolean.parseBoolean(arrColumnas[iColumn++]));
				this.vendedor.setfecha_creacion(Funciones.ConvertToDate(arrColumnas[iColumn++]));
				this.vendedor.setdireccion_domicilio(arrColumnas[iColumn++]);
				this.vendedor.setdireccion_referencia(arrColumnas[iColumn++]);
				this.vendedor.setdescripcion(arrColumnas[iColumn++]);
				this.vendedor.setporcentaje_comision(Double.parseDouble(arrColumnas[iColumn++]));
				this.vendedor.setcomision(Double.parseDouble(arrColumnas[iColumn++]));
				this.vendedor.setmonto_vendido(Double.parseDouble(arrColumnas[iColumn++]));
				this.vendedor.setnumero_facturas(Integer.parseInt(arrColumnas[iColumn++]));
				this.vendedor.setfecha_ultima_venta(Funciones.ConvertToDate(arrColumnas[iColumn++]));
				this.vendedor.setmonto_ultima_venta(Double.parseDouble(arrColumnas[iColumn++]));
				this.vendedor.setcon_presupuesto(Boolean.parseBoolean(arrColumnas[iColumn++]));
				this.vendedor.setcon_cobertura(Boolean.parseBoolean(arrColumnas[iColumn++]));
				
				this.vendedors.add(this.vendedor);
			}
			
			this.saveVendedors();
			
			this.connexion.commit();
			
			vendedorReturnGeneral.setConRetornoEstaProcesado(true);
			vendedorReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return vendedorReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarVendedorsEliminados() throws Exception {				
		
		List<Vendedor> vendedorsAux= new ArrayList<Vendedor>();
		
		for(Vendedor vendedor:vendedors) {
			if(!vendedor.getIsDeleted()) {
				vendedorsAux.add(vendedor);
			}
		}
		
		vendedors=vendedorsAux;
	}
	
	public void quitarVendedorsNulos() throws Exception {				
		
		List<Vendedor> vendedorsAux= new ArrayList<Vendedor>();
		
		for(Vendedor vendedor : this.vendedors) {
			if(vendedor==null) {
				vendedorsAux.add(vendedor);
			}
		}
		
		//this.vendedors=vendedorsAux;
		
		this.vendedors.removeAll(vendedorsAux);
	}
	
	public void getSetVersionRowVendedorWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(vendedor.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((vendedor.getIsDeleted() || (vendedor.getIsChanged()&&!vendedor.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=vendedorDataAccess.getSetVersionRowVendedor(connexion,vendedor.getId());
				
				if(!vendedor.getVersionRow().equals(timestamp)) {	
					vendedor.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				vendedor.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowVendedor()throws Exception {	
		
		if(vendedor.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((vendedor.getIsDeleted() || (vendedor.getIsChanged()&&!vendedor.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=vendedorDataAccess.getSetVersionRowVendedor(connexion,vendedor.getId());
			
			try {							
				if(!vendedor.getVersionRow().equals(timestamp)) {	
					vendedor.setVersionRow(timestamp);
				}
				
				vendedor.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowVendedorsWithConnection()throws Exception {	
		if(vendedors!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(Vendedor vendedorAux:vendedors) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(vendedorAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(vendedorAux.getIsDeleted() || (vendedorAux.getIsChanged()&&!vendedorAux.getIsNew())) {
						
						timestamp=vendedorDataAccess.getSetVersionRowVendedor(connexion,vendedorAux.getId());
						
						if(!vendedor.getVersionRow().equals(timestamp)) {	
							vendedorAux.setVersionRow(timestamp);
						}
								
						vendedorAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowVendedors()throws Exception {	
		if(vendedors!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(Vendedor vendedorAux:vendedors) {
					if(vendedorAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(vendedorAux.getIsDeleted() || (vendedorAux.getIsChanged()&&!vendedorAux.getIsNew())) {
						
						timestamp=vendedorDataAccess.getSetVersionRowVendedor(connexion,vendedorAux.getId());
						
						if(!vendedorAux.getVersionRow().equals(timestamp)) {	
							vendedorAux.setVersionRow(timestamp);
						}
						
													
						vendedorAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public VendedorParameterReturnGeneral cargarCombosLoteForeignKeyVendedorWithConnection(String finalQueryGlobalEmpresa,String finalQueryGlobalSucursal,String finalQueryGlobalEmpleado,String finalQueryGlobalEmpleadoSoporte,String finalQueryGlobalVendedor,String finalQueryGlobalPais,String finalQueryGlobalCiudad,String finalQueryGlobalZona) throws Exception {
		VendedorParameterReturnGeneral  vendedorReturnGeneral =new VendedorParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Vendedor.class.getSimpleName()+"-cargarCombosLoteForeignKeyVendedorWithConnection");connexion.begin();
			
			vendedorReturnGeneral =new VendedorParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			vendedorReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Sucursal> sucursalsForeignKey=new ArrayList<Sucursal>();
			SucursalLogic sucursalLogic=new SucursalLogic();
			sucursalLogic.setConnexion(this.connexion);
			//sucursalLogic.getSucursalDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalSucursal.equals("NONE")) {
				sucursalLogic.getTodosSucursals(finalQueryGlobalSucursal,new Pagination());
				sucursalsForeignKey=sucursalLogic.getSucursals();
			}

			vendedorReturnGeneral.setsucursalsForeignKey(sucursalsForeignKey);


			List<Empleado> empleadosForeignKey=new ArrayList<Empleado>();
			EmpleadoLogic empleadoLogic=new EmpleadoLogic();
			empleadoLogic.setConnexion(this.connexion);
			empleadoLogic.getEmpleadoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpleado.equals("NONE")) {
				empleadoLogic.getTodosEmpleados(finalQueryGlobalEmpleado,new Pagination());
				empleadosForeignKey=empleadoLogic.getEmpleados();
			}

			vendedorReturnGeneral.setempleadosForeignKey(empleadosForeignKey);


			List<Empleado> empleadosoportesForeignKey=new ArrayList<Empleado>();
			EmpleadoLogic empleadosoporteLogic=new EmpleadoLogic();
			empleadosoporteLogic.setConnexion(this.connexion);
			empleadosoporteLogic.getEmpleadoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpleadoSoporte.equals("NONE")) {
				empleadosoporteLogic.getTodosEmpleados(finalQueryGlobalEmpleadoSoporte,new Pagination());
				empleadosoportesForeignKey=empleadosoporteLogic.getEmpleados();
			}

			vendedorReturnGeneral.setempleadosoportesForeignKey(empleadosoportesForeignKey);


			List<Vendedor> vendedorsForeignKey=new ArrayList<Vendedor>();
			VendedorLogic vendedorLogic=new VendedorLogic();
			vendedorLogic.setConnexion(this.connexion);
			vendedorLogic.getVendedorDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalVendedor.equals("NONE")) {
				vendedorLogic.getTodosVendedors(finalQueryGlobalVendedor,new Pagination());
				vendedorsForeignKey=vendedorLogic.getVendedors();
			}

			vendedorReturnGeneral.setvendedorsForeignKey(vendedorsForeignKey);


			List<Pais> paissForeignKey=new ArrayList<Pais>();
			PaisLogic paisLogic=new PaisLogic();
			paisLogic.setConnexion(this.connexion);
			paisLogic.getPaisDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalPais.equals("NONE")) {
				paisLogic.getTodosPaiss(finalQueryGlobalPais,new Pagination());
				paissForeignKey=paisLogic.getPaiss();
			}

			vendedorReturnGeneral.setpaissForeignKey(paissForeignKey);


			List<Ciudad> ciudadsForeignKey=new ArrayList<Ciudad>();
			CiudadLogic ciudadLogic=new CiudadLogic();
			ciudadLogic.setConnexion(this.connexion);
			ciudadLogic.getCiudadDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCiudad.equals("NONE")) {
				ciudadLogic.getTodosCiudads(finalQueryGlobalCiudad,new Pagination());
				ciudadsForeignKey=ciudadLogic.getCiudads();
			}

			vendedorReturnGeneral.setciudadsForeignKey(ciudadsForeignKey);


			List<Zona> zonasForeignKey=new ArrayList<Zona>();
			ZonaLogic zonaLogic=new ZonaLogic();
			zonaLogic.setConnexion(this.connexion);
			zonaLogic.getZonaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalZona.equals("NONE")) {
				zonaLogic.getTodosZonas(finalQueryGlobalZona,new Pagination());
				zonasForeignKey=zonaLogic.getZonas();
			}

			vendedorReturnGeneral.setzonasForeignKey(zonasForeignKey);

			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
		
		return vendedorReturnGeneral;
	}
	
	public VendedorParameterReturnGeneral cargarCombosLoteForeignKeyVendedor(String finalQueryGlobalEmpresa,String finalQueryGlobalSucursal,String finalQueryGlobalEmpleado,String finalQueryGlobalEmpleadoSoporte,String finalQueryGlobalVendedor,String finalQueryGlobalPais,String finalQueryGlobalCiudad,String finalQueryGlobalZona) throws Exception {
		VendedorParameterReturnGeneral  vendedorReturnGeneral =new VendedorParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {						
			vendedorReturnGeneral =new VendedorParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			vendedorReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Sucursal> sucursalsForeignKey=new ArrayList<Sucursal>();
			SucursalLogic sucursalLogic=new SucursalLogic();
			sucursalLogic.setConnexion(this.connexion);
			//sucursalLogic.getSucursalDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalSucursal.equals("NONE")) {
				sucursalLogic.getTodosSucursals(finalQueryGlobalSucursal,new Pagination());
				sucursalsForeignKey=sucursalLogic.getSucursals();
			}

			vendedorReturnGeneral.setsucursalsForeignKey(sucursalsForeignKey);


			List<Empleado> empleadosForeignKey=new ArrayList<Empleado>();
			EmpleadoLogic empleadoLogic=new EmpleadoLogic();
			empleadoLogic.setConnexion(this.connexion);
			empleadoLogic.getEmpleadoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpleado.equals("NONE")) {
				empleadoLogic.getTodosEmpleados(finalQueryGlobalEmpleado,new Pagination());
				empleadosForeignKey=empleadoLogic.getEmpleados();
			}

			vendedorReturnGeneral.setempleadosForeignKey(empleadosForeignKey);


			List<Empleado> empleadosoportesForeignKey=new ArrayList<Empleado>();
			EmpleadoLogic empleadosoporteLogic=new EmpleadoLogic();
			empleadosoporteLogic.setConnexion(this.connexion);
			empleadosoporteLogic.getEmpleadoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpleadoSoporte.equals("NONE")) {
				empleadosoporteLogic.getTodosEmpleados(finalQueryGlobalEmpleadoSoporte,new Pagination());
				empleadosoportesForeignKey=empleadosoporteLogic.getEmpleados();
			}

			vendedorReturnGeneral.setempleadosoportesForeignKey(empleadosoportesForeignKey);


			List<Vendedor> vendedorsForeignKey=new ArrayList<Vendedor>();
			VendedorLogic vendedorLogic=new VendedorLogic();
			vendedorLogic.setConnexion(this.connexion);
			vendedorLogic.getVendedorDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalVendedor.equals("NONE")) {
				vendedorLogic.getTodosVendedors(finalQueryGlobalVendedor,new Pagination());
				vendedorsForeignKey=vendedorLogic.getVendedors();
			}

			vendedorReturnGeneral.setvendedorsForeignKey(vendedorsForeignKey);


			List<Pais> paissForeignKey=new ArrayList<Pais>();
			PaisLogic paisLogic=new PaisLogic();
			paisLogic.setConnexion(this.connexion);
			paisLogic.getPaisDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalPais.equals("NONE")) {
				paisLogic.getTodosPaiss(finalQueryGlobalPais,new Pagination());
				paissForeignKey=paisLogic.getPaiss();
			}

			vendedorReturnGeneral.setpaissForeignKey(paissForeignKey);


			List<Ciudad> ciudadsForeignKey=new ArrayList<Ciudad>();
			CiudadLogic ciudadLogic=new CiudadLogic();
			ciudadLogic.setConnexion(this.connexion);
			ciudadLogic.getCiudadDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCiudad.equals("NONE")) {
				ciudadLogic.getTodosCiudads(finalQueryGlobalCiudad,new Pagination());
				ciudadsForeignKey=ciudadLogic.getCiudads();
			}

			vendedorReturnGeneral.setciudadsForeignKey(ciudadsForeignKey);


			List<Zona> zonasForeignKey=new ArrayList<Zona>();
			ZonaLogic zonaLogic=new ZonaLogic();
			zonaLogic.setConnexion(this.connexion);
			zonaLogic.getZonaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalZona.equals("NONE")) {
				zonaLogic.getTodosZonas(finalQueryGlobalZona,new Pagination());
				zonasForeignKey=zonaLogic.getZonas();
			}

			vendedorReturnGeneral.setzonasForeignKey(zonasForeignKey);
						
			
		} catch(Exception e) {			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			
		}
		
		return vendedorReturnGeneral;
	}
	
	public void cargarRelacionesLoteForeignKeyVendedorWithConnection() throws Exception {
		ArrayList<Classe> classes=new ArrayList<Classe>();		
		
		
			NotaCreditoSoliLogic notacreditosoliLogic=new NotaCreditoSoliLogic();
			ComisionVentaCobroLogic comisionventacobroLogic=new ComisionVentaCobroLogic();
			VendedorLogic vendedorLogic=new VendedorLogic();
			ClienteLogic clienteLogic=new ClienteLogic();
			ComisionGrupoLogic comisiongrupoLogic=new ComisionGrupoLogic();
			ComisionLineaLogic comisionlineaLogic=new ComisionLineaLogic();
			VendedorZonaLogic vendedorzonaLogic=new VendedorZonaLogic();
			ComisionCateLogic comisioncateLogic=new ComisionCateLogic();
			CajeroTurnoLogic cajeroturnoLogic=new CajeroTurnoLogic();
			ComisionMarcaLogic comisionmarcaLogic=new ComisionMarcaLogic();
			PresupuestoVentasLogic presupuestoventasLogic=new PresupuestoVentasLogic();
			PresupuestoVentasLineasLogic presupuestoventaslineasLogic=new PresupuestoVentasLineasLogic();
		
		try {
			
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Vendedor.class.getSimpleName()+"-cargarRelacionesLoteForeignKeyVendedorWithConnection");connexion.begin();
			
			
			classes.add(new Classe(NotaCreditoSoli.class));
			classes.add(new Classe(ComisionVentaCobro.class));
			classes.add(new Classe(Vendedor.class));
			classes.add(new Classe(Cliente.class));
			classes.add(new Classe(ComisionGrupo.class));
			classes.add(new Classe(ComisionLinea.class));
			classes.add(new Classe(VendedorZona.class));
			classes.add(new Classe(ComisionCate.class));
			classes.add(new Classe(CajeroTurno.class));
			classes.add(new Classe(ComisionMarca.class));
			classes.add(new Classe(PresupuestoVentas.class));
			classes.add(new Classe(PresupuestoVentasLineas.class));
											
			

			notacreditosoliLogic.setConnexion(this.getConnexion());
			notacreditosoliLogic.setDatosCliente(this.datosCliente);
			notacreditosoliLogic.setIsConRefrescarForeignKeys(true);

			comisionventacobroLogic.setConnexion(this.getConnexion());
			comisionventacobroLogic.setDatosCliente(this.datosCliente);
			comisionventacobroLogic.setIsConRefrescarForeignKeys(true);

			vendedorLogic.setConnexion(this.getConnexion());
			vendedorLogic.setDatosCliente(this.datosCliente);
			vendedorLogic.setIsConRefrescarForeignKeys(true);

			clienteLogic.setConnexion(this.getConnexion());
			clienteLogic.setDatosCliente(this.datosCliente);
			clienteLogic.setIsConRefrescarForeignKeys(true);

			comisiongrupoLogic.setConnexion(this.getConnexion());
			comisiongrupoLogic.setDatosCliente(this.datosCliente);
			comisiongrupoLogic.setIsConRefrescarForeignKeys(true);

			comisionlineaLogic.setConnexion(this.getConnexion());
			comisionlineaLogic.setDatosCliente(this.datosCliente);
			comisionlineaLogic.setIsConRefrescarForeignKeys(true);

			vendedorzonaLogic.setConnexion(this.getConnexion());
			vendedorzonaLogic.setDatosCliente(this.datosCliente);
			vendedorzonaLogic.setIsConRefrescarForeignKeys(true);

			comisioncateLogic.setConnexion(this.getConnexion());
			comisioncateLogic.setDatosCliente(this.datosCliente);
			comisioncateLogic.setIsConRefrescarForeignKeys(true);

			cajeroturnoLogic.setConnexion(this.getConnexion());
			cajeroturnoLogic.setDatosCliente(this.datosCliente);
			cajeroturnoLogic.setIsConRefrescarForeignKeys(true);

			comisionmarcaLogic.setConnexion(this.getConnexion());
			comisionmarcaLogic.setDatosCliente(this.datosCliente);
			comisionmarcaLogic.setIsConRefrescarForeignKeys(true);

			presupuestoventasLogic.setConnexion(this.getConnexion());
			presupuestoventasLogic.setDatosCliente(this.datosCliente);
			presupuestoventasLogic.setIsConRefrescarForeignKeys(true);

			presupuestoventaslineasLogic.setConnexion(this.getConnexion());
			presupuestoventaslineasLogic.setDatosCliente(this.datosCliente);
			presupuestoventaslineasLogic.setIsConRefrescarForeignKeys(true);
			
			this.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
			
			for(Vendedor vendedor:this.vendedors) {
				

				classes=new ArrayList<Classe>();
				classes=NotaCreditoSoliConstantesFunciones.getClassesForeignKeysOfNotaCreditoSoli(new ArrayList<Classe>(),DeepLoadType.NONE);

				notacreditosoliLogic.setNotaCreditoSolis(vendedor.notacreditosolis);
				notacreditosoliLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");

				classes=new ArrayList<Classe>();
				classes=ComisionVentaCobroConstantesFunciones.getClassesForeignKeysOfComisionVentaCobro(new ArrayList<Classe>(),DeepLoadType.NONE);

				comisionventacobroLogic.setComisionVentaCobros(vendedor.comisionventacobros);
				comisionventacobroLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");

				classes=new ArrayList<Classe>();
				classes=VendedorConstantesFunciones.getClassesForeignKeysOfVendedor(new ArrayList<Classe>(),DeepLoadType.NONE);

				vendedorLogic.setVendedors(vendedor.vendedors);
				vendedorLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");

				classes=new ArrayList<Classe>();
				classes=ClienteConstantesFunciones.getClassesForeignKeysOfCliente(new ArrayList<Classe>(),DeepLoadType.NONE);

				clienteLogic.setClientes(vendedor.clientes);
				clienteLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");

				classes=new ArrayList<Classe>();
				classes=ComisionGrupoConstantesFunciones.getClassesForeignKeysOfComisionGrupo(new ArrayList<Classe>(),DeepLoadType.NONE);

				comisiongrupoLogic.setComisionGrupos(vendedor.comisiongrupos);
				comisiongrupoLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");

				classes=new ArrayList<Classe>();
				classes=ComisionLineaConstantesFunciones.getClassesForeignKeysOfComisionLinea(new ArrayList<Classe>(),DeepLoadType.NONE);

				comisionlineaLogic.setComisionLineas(vendedor.comisionlineas);
				comisionlineaLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");

				classes=new ArrayList<Classe>();
				classes=VendedorZonaConstantesFunciones.getClassesForeignKeysOfVendedorZona(new ArrayList<Classe>(),DeepLoadType.NONE);

				vendedorzonaLogic.setVendedorZonas(vendedor.vendedorzonas);
				vendedorzonaLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");

				classes=new ArrayList<Classe>();
				classes=ComisionCateConstantesFunciones.getClassesForeignKeysOfComisionCate(new ArrayList<Classe>(),DeepLoadType.NONE);

				comisioncateLogic.setComisionCates(vendedor.comisioncates);
				comisioncateLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");

				classes=new ArrayList<Classe>();
				classes=CajeroTurnoConstantesFunciones.getClassesForeignKeysOfCajeroTurno(new ArrayList<Classe>(),DeepLoadType.NONE);

				cajeroturnoLogic.setCajeroTurnos(vendedor.cajeroturnos);
				cajeroturnoLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");

				classes=new ArrayList<Classe>();
				classes=ComisionMarcaConstantesFunciones.getClassesForeignKeysOfComisionMarca(new ArrayList<Classe>(),DeepLoadType.NONE);

				comisionmarcaLogic.setComisionMarcas(vendedor.comisionmarcas);
				comisionmarcaLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");

				classes=new ArrayList<Classe>();
				classes=PresupuestoVentasConstantesFunciones.getClassesForeignKeysOfPresupuestoVentas(new ArrayList<Classe>(),DeepLoadType.NONE);

				presupuestoventasLogic.setPresupuestoVentass(vendedor.presupuestoventass);
				presupuestoventasLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");

				classes=new ArrayList<Classe>();
				classes=PresupuestoVentasLineasConstantesFunciones.getClassesForeignKeysOfPresupuestoVentasLineas(new ArrayList<Classe>(),DeepLoadType.NONE);

				presupuestoventaslineasLogic.setPresupuestoVentasLineass(vendedor.presupuestoventaslineass);
				presupuestoventaslineasLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
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
	
	public void deepLoad(Vendedor vendedor,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			VendedorLogicAdditional.updateVendedorToGet(vendedor,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		vendedor.setEmpresa(vendedorDataAccess.getEmpresa(connexion,vendedor));
		vendedor.setSucursal(vendedorDataAccess.getSucursal(connexion,vendedor));
		vendedor.setEmpleado(vendedorDataAccess.getEmpleado(connexion,vendedor));
		vendedor.setEmpleadoSoporte(vendedorDataAccess.getEmpleadoSoporte(connexion,vendedor));
		vendedor.setVendedor(vendedorDataAccess.getVendedor(connexion,vendedor));
		vendedor.setPais(vendedorDataAccess.getPais(connexion,vendedor));
		vendedor.setCiudad(vendedorDataAccess.getCiudad(connexion,vendedor));
		vendedor.setZona(vendedorDataAccess.getZona(connexion,vendedor));
		vendedor.setNotaCreditoSolis(vendedorDataAccess.getNotaCreditoSolis(connexion,vendedor));
		vendedor.setComisionVentaCobros(vendedorDataAccess.getComisionVentaCobros(connexion,vendedor));
		vendedor.setVendedors(vendedorDataAccess.getVendedors(connexion,vendedor));
		vendedor.setClientes(vendedorDataAccess.getClientes(connexion,vendedor));
		vendedor.setComisionGrupos(vendedorDataAccess.getComisionGrupos(connexion,vendedor));
		vendedor.setComisionLineas(vendedorDataAccess.getComisionLineas(connexion,vendedor));
		vendedor.setVendedorZonas(vendedorDataAccess.getVendedorZonas(connexion,vendedor));
		vendedor.setComisionCates(vendedorDataAccess.getComisionCates(connexion,vendedor));
		vendedor.setCajeroTurnos(vendedorDataAccess.getCajeroTurnos(connexion,vendedor));
		vendedor.setComisionMarcas(vendedorDataAccess.getComisionMarcas(connexion,vendedor));
		vendedor.setPresupuestoVentass(vendedorDataAccess.getPresupuestoVentass(connexion,vendedor));
		vendedor.setPresupuestoVentasLineass(vendedorDataAccess.getPresupuestoVentasLineass(connexion,vendedor));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				vendedor.setEmpresa(vendedorDataAccess.getEmpresa(connexion,vendedor));
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				vendedor.setSucursal(vendedorDataAccess.getSucursal(connexion,vendedor));
				continue;
			}

			if(clas.clas.equals(Empleado.class)) {
				vendedor.setEmpleado(vendedorDataAccess.getEmpleado(connexion,vendedor));
				continue;
			}

			if(clas.clas.equals(Empleado.class)) {
				vendedor.setEmpleadoSoporte(vendedorDataAccess.getEmpleadoSoporte(connexion,vendedor));
				continue;
			}

			if(clas.clas.equals(Vendedor.class)) {
				vendedor.setVendedor(vendedorDataAccess.getVendedor(connexion,vendedor));
				continue;
			}

			if(clas.clas.equals(Pais.class)) {
				vendedor.setPais(vendedorDataAccess.getPais(connexion,vendedor));
				continue;
			}

			if(clas.clas.equals(Ciudad.class)) {
				vendedor.setCiudad(vendedorDataAccess.getCiudad(connexion,vendedor));
				continue;
			}

			if(clas.clas.equals(Zona.class)) {
				vendedor.setZona(vendedorDataAccess.getZona(connexion,vendedor));
				continue;
			}

			if(clas.clas.equals(NotaCreditoSoli.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				vendedor.setNotaCreditoSolis(vendedorDataAccess.getNotaCreditoSolis(connexion,vendedor));

				if(this.isConDeep) {
					NotaCreditoSoliLogic notacreditosoliLogic= new NotaCreditoSoliLogic(this.connexion);
					notacreditosoliLogic.setNotaCreditoSolis(vendedor.getNotaCreditoSolis());
					ArrayList<Classe> classesLocal=NotaCreditoSoliConstantesFunciones.getClassesForeignKeysOfNotaCreditoSoli(new ArrayList<Classe>(),DeepLoadType.NONE);
					notacreditosoliLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					NotaCreditoSoliConstantesFunciones.refrescarForeignKeysDescripcionesNotaCreditoSoli(notacreditosoliLogic.getNotaCreditoSolis());
					vendedor.setNotaCreditoSolis(notacreditosoliLogic.getNotaCreditoSolis());
				}

				continue;
			}

			if(clas.clas.equals(ComisionVentaCobro.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				vendedor.setComisionVentaCobros(vendedorDataAccess.getComisionVentaCobros(connexion,vendedor));

				if(this.isConDeep) {
					ComisionVentaCobroLogic comisionventacobroLogic= new ComisionVentaCobroLogic(this.connexion);
					comisionventacobroLogic.setComisionVentaCobros(vendedor.getComisionVentaCobros());
					ArrayList<Classe> classesLocal=ComisionVentaCobroConstantesFunciones.getClassesForeignKeysOfComisionVentaCobro(new ArrayList<Classe>(),DeepLoadType.NONE);
					comisionventacobroLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					ComisionVentaCobroConstantesFunciones.refrescarForeignKeysDescripcionesComisionVentaCobro(comisionventacobroLogic.getComisionVentaCobros());
					vendedor.setComisionVentaCobros(comisionventacobroLogic.getComisionVentaCobros());
				}

				continue;
			}

			if(clas.clas.equals(Vendedor.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				vendedor.setVendedors(vendedorDataAccess.getVendedors(connexion,vendedor));

				if(this.isConDeep) {
					VendedorLogic vendedorLogic= new VendedorLogic(this.connexion);
					vendedorLogic.setVendedors(vendedor.getVendedors());
					ArrayList<Classe> classesLocal=VendedorConstantesFunciones.getClassesForeignKeysOfVendedor(new ArrayList<Classe>(),DeepLoadType.NONE);
					vendedorLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					VendedorConstantesFunciones.refrescarForeignKeysDescripcionesVendedor(vendedorLogic.getVendedors());
					vendedor.setVendedors(vendedorLogic.getVendedors());
				}

				continue;
			}

			if(clas.clas.equals(Cliente.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				vendedor.setClientes(vendedorDataAccess.getClientes(connexion,vendedor));

				if(this.isConDeep) {
					ClienteLogic clienteLogic= new ClienteLogic(this.connexion);
					clienteLogic.setClientes(vendedor.getClientes());
					ArrayList<Classe> classesLocal=ClienteConstantesFunciones.getClassesForeignKeysOfCliente(new ArrayList<Classe>(),DeepLoadType.NONE);
					clienteLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					ClienteConstantesFunciones.refrescarForeignKeysDescripcionesCliente(clienteLogic.getClientes());
					vendedor.setClientes(clienteLogic.getClientes());
				}

				continue;
			}

			if(clas.clas.equals(ComisionGrupo.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				vendedor.setComisionGrupos(vendedorDataAccess.getComisionGrupos(connexion,vendedor));

				if(this.isConDeep) {
					ComisionGrupoLogic comisiongrupoLogic= new ComisionGrupoLogic(this.connexion);
					comisiongrupoLogic.setComisionGrupos(vendedor.getComisionGrupos());
					ArrayList<Classe> classesLocal=ComisionGrupoConstantesFunciones.getClassesForeignKeysOfComisionGrupo(new ArrayList<Classe>(),DeepLoadType.NONE);
					comisiongrupoLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					ComisionGrupoConstantesFunciones.refrescarForeignKeysDescripcionesComisionGrupo(comisiongrupoLogic.getComisionGrupos());
					vendedor.setComisionGrupos(comisiongrupoLogic.getComisionGrupos());
				}

				continue;
			}

			if(clas.clas.equals(ComisionLinea.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				vendedor.setComisionLineas(vendedorDataAccess.getComisionLineas(connexion,vendedor));

				if(this.isConDeep) {
					ComisionLineaLogic comisionlineaLogic= new ComisionLineaLogic(this.connexion);
					comisionlineaLogic.setComisionLineas(vendedor.getComisionLineas());
					ArrayList<Classe> classesLocal=ComisionLineaConstantesFunciones.getClassesForeignKeysOfComisionLinea(new ArrayList<Classe>(),DeepLoadType.NONE);
					comisionlineaLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					ComisionLineaConstantesFunciones.refrescarForeignKeysDescripcionesComisionLinea(comisionlineaLogic.getComisionLineas());
					vendedor.setComisionLineas(comisionlineaLogic.getComisionLineas());
				}

				continue;
			}

			if(clas.clas.equals(VendedorZona.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				vendedor.setVendedorZonas(vendedorDataAccess.getVendedorZonas(connexion,vendedor));

				if(this.isConDeep) {
					VendedorZonaLogic vendedorzonaLogic= new VendedorZonaLogic(this.connexion);
					vendedorzonaLogic.setVendedorZonas(vendedor.getVendedorZonas());
					ArrayList<Classe> classesLocal=VendedorZonaConstantesFunciones.getClassesForeignKeysOfVendedorZona(new ArrayList<Classe>(),DeepLoadType.NONE);
					vendedorzonaLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					VendedorZonaConstantesFunciones.refrescarForeignKeysDescripcionesVendedorZona(vendedorzonaLogic.getVendedorZonas());
					vendedor.setVendedorZonas(vendedorzonaLogic.getVendedorZonas());
				}

				continue;
			}

			if(clas.clas.equals(ComisionCate.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				vendedor.setComisionCates(vendedorDataAccess.getComisionCates(connexion,vendedor));

				if(this.isConDeep) {
					ComisionCateLogic comisioncateLogic= new ComisionCateLogic(this.connexion);
					comisioncateLogic.setComisionCates(vendedor.getComisionCates());
					ArrayList<Classe> classesLocal=ComisionCateConstantesFunciones.getClassesForeignKeysOfComisionCate(new ArrayList<Classe>(),DeepLoadType.NONE);
					comisioncateLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					ComisionCateConstantesFunciones.refrescarForeignKeysDescripcionesComisionCate(comisioncateLogic.getComisionCates());
					vendedor.setComisionCates(comisioncateLogic.getComisionCates());
				}

				continue;
			}

			if(clas.clas.equals(CajeroTurno.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				vendedor.setCajeroTurnos(vendedorDataAccess.getCajeroTurnos(connexion,vendedor));

				if(this.isConDeep) {
					CajeroTurnoLogic cajeroturnoLogic= new CajeroTurnoLogic(this.connexion);
					cajeroturnoLogic.setCajeroTurnos(vendedor.getCajeroTurnos());
					ArrayList<Classe> classesLocal=CajeroTurnoConstantesFunciones.getClassesForeignKeysOfCajeroTurno(new ArrayList<Classe>(),DeepLoadType.NONE);
					cajeroturnoLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					CajeroTurnoConstantesFunciones.refrescarForeignKeysDescripcionesCajeroTurno(cajeroturnoLogic.getCajeroTurnos());
					vendedor.setCajeroTurnos(cajeroturnoLogic.getCajeroTurnos());
				}

				continue;
			}

			if(clas.clas.equals(ComisionMarca.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				vendedor.setComisionMarcas(vendedorDataAccess.getComisionMarcas(connexion,vendedor));

				if(this.isConDeep) {
					ComisionMarcaLogic comisionmarcaLogic= new ComisionMarcaLogic(this.connexion);
					comisionmarcaLogic.setComisionMarcas(vendedor.getComisionMarcas());
					ArrayList<Classe> classesLocal=ComisionMarcaConstantesFunciones.getClassesForeignKeysOfComisionMarca(new ArrayList<Classe>(),DeepLoadType.NONE);
					comisionmarcaLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					ComisionMarcaConstantesFunciones.refrescarForeignKeysDescripcionesComisionMarca(comisionmarcaLogic.getComisionMarcas());
					vendedor.setComisionMarcas(comisionmarcaLogic.getComisionMarcas());
				}

				continue;
			}

			if(clas.clas.equals(PresupuestoVentas.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				vendedor.setPresupuestoVentass(vendedorDataAccess.getPresupuestoVentass(connexion,vendedor));

				if(this.isConDeep) {
					PresupuestoVentasLogic presupuestoventasLogic= new PresupuestoVentasLogic(this.connexion);
					presupuestoventasLogic.setPresupuestoVentass(vendedor.getPresupuestoVentass());
					ArrayList<Classe> classesLocal=PresupuestoVentasConstantesFunciones.getClassesForeignKeysOfPresupuestoVentas(new ArrayList<Classe>(),DeepLoadType.NONE);
					presupuestoventasLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					PresupuestoVentasConstantesFunciones.refrescarForeignKeysDescripcionesPresupuestoVentas(presupuestoventasLogic.getPresupuestoVentass());
					vendedor.setPresupuestoVentass(presupuestoventasLogic.getPresupuestoVentass());
				}

				continue;
			}

			if(clas.clas.equals(PresupuestoVentasLineas.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				vendedor.setPresupuestoVentasLineass(vendedorDataAccess.getPresupuestoVentasLineass(connexion,vendedor));

				if(this.isConDeep) {
					PresupuestoVentasLineasLogic presupuestoventaslineasLogic= new PresupuestoVentasLineasLogic(this.connexion);
					presupuestoventaslineasLogic.setPresupuestoVentasLineass(vendedor.getPresupuestoVentasLineass());
					ArrayList<Classe> classesLocal=PresupuestoVentasLineasConstantesFunciones.getClassesForeignKeysOfPresupuestoVentasLineas(new ArrayList<Classe>(),DeepLoadType.NONE);
					presupuestoventaslineasLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					PresupuestoVentasLineasConstantesFunciones.refrescarForeignKeysDescripcionesPresupuestoVentasLineas(presupuestoventaslineasLogic.getPresupuestoVentasLineass());
					vendedor.setPresupuestoVentasLineass(presupuestoventaslineasLogic.getPresupuestoVentasLineass());
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
			vendedor.setEmpresa(vendedorDataAccess.getEmpresa(connexion,vendedor));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			vendedor.setSucursal(vendedorDataAccess.getSucursal(connexion,vendedor));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Empleado.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			vendedor.setEmpleado(vendedorDataAccess.getEmpleado(connexion,vendedor));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Empleado.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			vendedor.setEmpleadoSoporte(vendedorDataAccess.getEmpleadoSoporte(connexion,vendedor));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Vendedor.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			vendedor.setVendedor(vendedorDataAccess.getVendedor(connexion,vendedor));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Pais.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			vendedor.setPais(vendedorDataAccess.getPais(connexion,vendedor));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Ciudad.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			vendedor.setCiudad(vendedorDataAccess.getCiudad(connexion,vendedor));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Zona.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			vendedor.setZona(vendedorDataAccess.getZona(connexion,vendedor));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(NotaCreditoSoli.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(NotaCreditoSoli.class));
			vendedor.setNotaCreditoSolis(vendedorDataAccess.getNotaCreditoSolis(connexion,vendedor));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(ComisionVentaCobro.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(ComisionVentaCobro.class));
			vendedor.setComisionVentaCobros(vendedorDataAccess.getComisionVentaCobros(connexion,vendedor));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Vendedor.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(Vendedor.class));
			vendedor.setVendedors(vendedorDataAccess.getVendedors(connexion,vendedor));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Cliente.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(Cliente.class));
			vendedor.setClientes(vendedorDataAccess.getClientes(connexion,vendedor));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(ComisionGrupo.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(ComisionGrupo.class));
			vendedor.setComisionGrupos(vendedorDataAccess.getComisionGrupos(connexion,vendedor));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(ComisionLinea.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(ComisionLinea.class));
			vendedor.setComisionLineas(vendedorDataAccess.getComisionLineas(connexion,vendedor));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(VendedorZona.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(VendedorZona.class));
			vendedor.setVendedorZonas(vendedorDataAccess.getVendedorZonas(connexion,vendedor));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(ComisionCate.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(ComisionCate.class));
			vendedor.setComisionCates(vendedorDataAccess.getComisionCates(connexion,vendedor));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(CajeroTurno.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(CajeroTurno.class));
			vendedor.setCajeroTurnos(vendedorDataAccess.getCajeroTurnos(connexion,vendedor));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(ComisionMarca.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(ComisionMarca.class));
			vendedor.setComisionMarcas(vendedorDataAccess.getComisionMarcas(connexion,vendedor));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(PresupuestoVentas.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(PresupuestoVentas.class));
			vendedor.setPresupuestoVentass(vendedorDataAccess.getPresupuestoVentass(connexion,vendedor));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(PresupuestoVentasLineas.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(PresupuestoVentasLineas.class));
			vendedor.setPresupuestoVentasLineass(vendedorDataAccess.getPresupuestoVentasLineass(connexion,vendedor));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		vendedor.setEmpresa(vendedorDataAccess.getEmpresa(connexion,vendedor));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(vendedor.getEmpresa(),isDeep,deepLoadType,clases);
				
		vendedor.setSucursal(vendedorDataAccess.getSucursal(connexion,vendedor));
		SucursalLogic sucursalLogic= new SucursalLogic(connexion);
		sucursalLogic.deepLoad(vendedor.getSucursal(),isDeep,deepLoadType,clases);
				
		vendedor.setEmpleado(vendedorDataAccess.getEmpleado(connexion,vendedor));
		EmpleadoLogic empleadoLogic= new EmpleadoLogic(connexion);
		empleadoLogic.deepLoad(vendedor.getEmpleado(),isDeep,deepLoadType,clases);
				
		vendedor.setEmpleadoSoporte(vendedorDataAccess.getEmpleadoSoporte(connexion,vendedor));
		EmpleadoLogic empleadosoporteLogic= new EmpleadoLogic(connexion);
		empleadosoporteLogic.deepLoad(vendedor.getEmpleadoSoporte(),isDeep,deepLoadType,clases);
				
		vendedor.setVendedor(vendedorDataAccess.getVendedor(connexion,vendedor));
		VendedorLogic vendedorLogic= new VendedorLogic(connexion);
		vendedorLogic.deepLoad(vendedor.getVendedor(),isDeep,deepLoadType,clases);
				
		vendedor.setPais(vendedorDataAccess.getPais(connexion,vendedor));
		PaisLogic paisLogic= new PaisLogic(connexion);
		paisLogic.deepLoad(vendedor.getPais(),isDeep,deepLoadType,clases);
				
		vendedor.setCiudad(vendedorDataAccess.getCiudad(connexion,vendedor));
		CiudadLogic ciudadLogic= new CiudadLogic(connexion);
		ciudadLogic.deepLoad(vendedor.getCiudad(),isDeep,deepLoadType,clases);
				
		vendedor.setZona(vendedorDataAccess.getZona(connexion,vendedor));
		ZonaLogic zonaLogic= new ZonaLogic(connexion);
		zonaLogic.deepLoad(vendedor.getZona(),isDeep,deepLoadType,clases);
				

		vendedor.setNotaCreditoSolis(vendedorDataAccess.getNotaCreditoSolis(connexion,vendedor));

		for(NotaCreditoSoli notacreditosoli:vendedor.getNotaCreditoSolis()) {
			NotaCreditoSoliLogic notacreditosoliLogic= new NotaCreditoSoliLogic(connexion);
			notacreditosoliLogic.deepLoad(notacreditosoli,isDeep,deepLoadType,clases);
		}

		vendedor.setComisionVentaCobros(vendedorDataAccess.getComisionVentaCobros(connexion,vendedor));

		for(ComisionVentaCobro comisionventacobro:vendedor.getComisionVentaCobros()) {
			ComisionVentaCobroLogic comisionventacobroLogic= new ComisionVentaCobroLogic(connexion);
			comisionventacobroLogic.deepLoad(comisionventacobro,isDeep,deepLoadType,clases);
		}

		vendedor.setVendedors(vendedorDataAccess.getVendedors(connexion,vendedor));

		for(Vendedor vendedorRecursivo:vendedor.getVendedors()) {
			VendedorLogic vendedorRecursivoLogic= new VendedorLogic(connexion);
			vendedorRecursivoLogic.deepLoad(vendedorRecursivo,isDeep,deepLoadType,clases);
		}

		vendedor.setClientes(vendedorDataAccess.getClientes(connexion,vendedor));

		for(Cliente cliente:vendedor.getClientes()) {
			ClienteLogic clienteLogic= new ClienteLogic(connexion);
			clienteLogic.deepLoad(cliente,isDeep,deepLoadType,clases);
		}

		vendedor.setComisionGrupos(vendedorDataAccess.getComisionGrupos(connexion,vendedor));

		for(ComisionGrupo comisiongrupo:vendedor.getComisionGrupos()) {
			ComisionGrupoLogic comisiongrupoLogic= new ComisionGrupoLogic(connexion);
			comisiongrupoLogic.deepLoad(comisiongrupo,isDeep,deepLoadType,clases);
		}

		vendedor.setComisionLineas(vendedorDataAccess.getComisionLineas(connexion,vendedor));

		for(ComisionLinea comisionlinea:vendedor.getComisionLineas()) {
			ComisionLineaLogic comisionlineaLogic= new ComisionLineaLogic(connexion);
			comisionlineaLogic.deepLoad(comisionlinea,isDeep,deepLoadType,clases);
		}

		vendedor.setVendedorZonas(vendedorDataAccess.getVendedorZonas(connexion,vendedor));

		for(VendedorZona vendedorzona:vendedor.getVendedorZonas()) {
			VendedorZonaLogic vendedorzonaLogic= new VendedorZonaLogic(connexion);
			vendedorzonaLogic.deepLoad(vendedorzona,isDeep,deepLoadType,clases);
		}

		vendedor.setComisionCates(vendedorDataAccess.getComisionCates(connexion,vendedor));

		for(ComisionCate comisioncate:vendedor.getComisionCates()) {
			ComisionCateLogic comisioncateLogic= new ComisionCateLogic(connexion);
			comisioncateLogic.deepLoad(comisioncate,isDeep,deepLoadType,clases);
		}

		vendedor.setCajeroTurnos(vendedorDataAccess.getCajeroTurnos(connexion,vendedor));

		for(CajeroTurno cajeroturno:vendedor.getCajeroTurnos()) {
			CajeroTurnoLogic cajeroturnoLogic= new CajeroTurnoLogic(connexion);
			cajeroturnoLogic.deepLoad(cajeroturno,isDeep,deepLoadType,clases);
		}

		vendedor.setComisionMarcas(vendedorDataAccess.getComisionMarcas(connexion,vendedor));

		for(ComisionMarca comisionmarca:vendedor.getComisionMarcas()) {
			ComisionMarcaLogic comisionmarcaLogic= new ComisionMarcaLogic(connexion);
			comisionmarcaLogic.deepLoad(comisionmarca,isDeep,deepLoadType,clases);
		}

		vendedor.setPresupuestoVentass(vendedorDataAccess.getPresupuestoVentass(connexion,vendedor));

		for(PresupuestoVentas presupuestoventas:vendedor.getPresupuestoVentass()) {
			PresupuestoVentasLogic presupuestoventasLogic= new PresupuestoVentasLogic(connexion);
			presupuestoventasLogic.deepLoad(presupuestoventas,isDeep,deepLoadType,clases);
		}

		vendedor.setPresupuestoVentasLineass(vendedorDataAccess.getPresupuestoVentasLineass(connexion,vendedor));

		for(PresupuestoVentasLineas presupuestoventaslineas:vendedor.getPresupuestoVentasLineass()) {
			PresupuestoVentasLineasLogic presupuestoventaslineasLogic= new PresupuestoVentasLineasLogic(connexion);
			presupuestoventaslineasLogic.deepLoad(presupuestoventaslineas,isDeep,deepLoadType,clases);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				vendedor.setEmpresa(vendedorDataAccess.getEmpresa(connexion,vendedor));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(vendedor.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				vendedor.setSucursal(vendedorDataAccess.getSucursal(connexion,vendedor));
				SucursalLogic sucursalLogic= new SucursalLogic(connexion);
				sucursalLogic.deepLoad(vendedor.getSucursal(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Empleado.class)) {
				vendedor.setEmpleado(vendedorDataAccess.getEmpleado(connexion,vendedor));
				EmpleadoLogic empleadoLogic= new EmpleadoLogic(connexion);
				empleadoLogic.deepLoad(vendedor.getEmpleado(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Empleado.class)) {
				vendedor.setEmpleadoSoporte(vendedorDataAccess.getEmpleadoSoporte(connexion,vendedor));
				EmpleadoLogic empleadoLogic= new EmpleadoLogic(connexion);
				empleadoLogic.deepLoad(vendedor.getEmpleadoSoporte(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Vendedor.class)) {
				vendedor.setVendedor(vendedorDataAccess.getVendedor(connexion,vendedor));
				VendedorLogic vendedorLogic= new VendedorLogic(connexion);
				vendedorLogic.deepLoad(vendedor.getVendedor(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Pais.class)) {
				vendedor.setPais(vendedorDataAccess.getPais(connexion,vendedor));
				PaisLogic paisLogic= new PaisLogic(connexion);
				paisLogic.deepLoad(vendedor.getPais(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Ciudad.class)) {
				vendedor.setCiudad(vendedorDataAccess.getCiudad(connexion,vendedor));
				CiudadLogic ciudadLogic= new CiudadLogic(connexion);
				ciudadLogic.deepLoad(vendedor.getCiudad(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Zona.class)) {
				vendedor.setZona(vendedorDataAccess.getZona(connexion,vendedor));
				ZonaLogic zonaLogic= new ZonaLogic(connexion);
				zonaLogic.deepLoad(vendedor.getZona(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(NotaCreditoSoli.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				vendedor.setNotaCreditoSolis(vendedorDataAccess.getNotaCreditoSolis(connexion,vendedor));

				for(NotaCreditoSoli notacreditosoli:vendedor.getNotaCreditoSolis()) {
					NotaCreditoSoliLogic notacreditosoliLogic= new NotaCreditoSoliLogic(connexion);
					notacreditosoliLogic.deepLoad(notacreditosoli,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(ComisionVentaCobro.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				vendedor.setComisionVentaCobros(vendedorDataAccess.getComisionVentaCobros(connexion,vendedor));

				for(ComisionVentaCobro comisionventacobro:vendedor.getComisionVentaCobros()) {
					ComisionVentaCobroLogic comisionventacobroLogic= new ComisionVentaCobroLogic(connexion);
					comisionventacobroLogic.deepLoad(comisionventacobro,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(Vendedor.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				vendedor.setVendedors(vendedorDataAccess.getVendedors(connexion,vendedor));

				for(Vendedor vendedorRecursivo:vendedor.getVendedors()) {
					VendedorLogic vendedorRecursivoLogic= new VendedorLogic(connexion);
					vendedorRecursivoLogic.deepLoad(vendedorRecursivo,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(Cliente.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				vendedor.setClientes(vendedorDataAccess.getClientes(connexion,vendedor));

				for(Cliente cliente:vendedor.getClientes()) {
					ClienteLogic clienteLogic= new ClienteLogic(connexion);
					clienteLogic.deepLoad(cliente,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(ComisionGrupo.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				vendedor.setComisionGrupos(vendedorDataAccess.getComisionGrupos(connexion,vendedor));

				for(ComisionGrupo comisiongrupo:vendedor.getComisionGrupos()) {
					ComisionGrupoLogic comisiongrupoLogic= new ComisionGrupoLogic(connexion);
					comisiongrupoLogic.deepLoad(comisiongrupo,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(ComisionLinea.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				vendedor.setComisionLineas(vendedorDataAccess.getComisionLineas(connexion,vendedor));

				for(ComisionLinea comisionlinea:vendedor.getComisionLineas()) {
					ComisionLineaLogic comisionlineaLogic= new ComisionLineaLogic(connexion);
					comisionlineaLogic.deepLoad(comisionlinea,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(VendedorZona.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				vendedor.setVendedorZonas(vendedorDataAccess.getVendedorZonas(connexion,vendedor));

				for(VendedorZona vendedorzona:vendedor.getVendedorZonas()) {
					VendedorZonaLogic vendedorzonaLogic= new VendedorZonaLogic(connexion);
					vendedorzonaLogic.deepLoad(vendedorzona,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(ComisionCate.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				vendedor.setComisionCates(vendedorDataAccess.getComisionCates(connexion,vendedor));

				for(ComisionCate comisioncate:vendedor.getComisionCates()) {
					ComisionCateLogic comisioncateLogic= new ComisionCateLogic(connexion);
					comisioncateLogic.deepLoad(comisioncate,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(CajeroTurno.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				vendedor.setCajeroTurnos(vendedorDataAccess.getCajeroTurnos(connexion,vendedor));

				for(CajeroTurno cajeroturno:vendedor.getCajeroTurnos()) {
					CajeroTurnoLogic cajeroturnoLogic= new CajeroTurnoLogic(connexion);
					cajeroturnoLogic.deepLoad(cajeroturno,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(ComisionMarca.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				vendedor.setComisionMarcas(vendedorDataAccess.getComisionMarcas(connexion,vendedor));

				for(ComisionMarca comisionmarca:vendedor.getComisionMarcas()) {
					ComisionMarcaLogic comisionmarcaLogic= new ComisionMarcaLogic(connexion);
					comisionmarcaLogic.deepLoad(comisionmarca,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(PresupuestoVentas.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				vendedor.setPresupuestoVentass(vendedorDataAccess.getPresupuestoVentass(connexion,vendedor));

				for(PresupuestoVentas presupuestoventas:vendedor.getPresupuestoVentass()) {
					PresupuestoVentasLogic presupuestoventasLogic= new PresupuestoVentasLogic(connexion);
					presupuestoventasLogic.deepLoad(presupuestoventas,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(PresupuestoVentasLineas.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				vendedor.setPresupuestoVentasLineass(vendedorDataAccess.getPresupuestoVentasLineass(connexion,vendedor));

				for(PresupuestoVentasLineas presupuestoventaslineas:vendedor.getPresupuestoVentasLineass()) {
					PresupuestoVentasLineasLogic presupuestoventaslineasLogic= new PresupuestoVentasLineasLogic(connexion);
					presupuestoventaslineasLogic.deepLoad(presupuestoventaslineas,isDeep,deepLoadType,clases);
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
			vendedor.setEmpresa(vendedorDataAccess.getEmpresa(connexion,vendedor));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(vendedor.getEmpresa(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			vendedor.setSucursal(vendedorDataAccess.getSucursal(connexion,vendedor));
			SucursalLogic sucursalLogic= new SucursalLogic(connexion);
			sucursalLogic.deepLoad(vendedor.getSucursal(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Empleado.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			vendedor.setEmpleado(vendedorDataAccess.getEmpleado(connexion,vendedor));
			EmpleadoLogic empleadoLogic= new EmpleadoLogic(connexion);
			empleadoLogic.deepLoad(vendedor.getEmpleado(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Empleado.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			vendedor.setEmpleadoSoporte(vendedorDataAccess.getEmpleadoSoporte(connexion,vendedor));
			EmpleadoLogic empleadoLogic= new EmpleadoLogic(connexion);
			empleadoLogic.deepLoad(vendedor.getEmpleadoSoporte(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Vendedor.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			vendedor.setVendedor(vendedorDataAccess.getVendedor(connexion,vendedor));
			VendedorLogic vendedorLogic= new VendedorLogic(connexion);
			vendedorLogic.deepLoad(vendedor.getVendedor(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Pais.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			vendedor.setPais(vendedorDataAccess.getPais(connexion,vendedor));
			PaisLogic paisLogic= new PaisLogic(connexion);
			paisLogic.deepLoad(vendedor.getPais(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Ciudad.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			vendedor.setCiudad(vendedorDataAccess.getCiudad(connexion,vendedor));
			CiudadLogic ciudadLogic= new CiudadLogic(connexion);
			ciudadLogic.deepLoad(vendedor.getCiudad(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Zona.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			vendedor.setZona(vendedorDataAccess.getZona(connexion,vendedor));
			ZonaLogic zonaLogic= new ZonaLogic(connexion);
			zonaLogic.deepLoad(vendedor.getZona(),isDeep,deepLoadType,clases);
				
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(NotaCreditoSoli.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(NotaCreditoSoli.class));
			vendedor.setNotaCreditoSolis(vendedorDataAccess.getNotaCreditoSolis(connexion,vendedor));

			for(NotaCreditoSoli notacreditosoli:vendedor.getNotaCreditoSolis()) {
				NotaCreditoSoliLogic notacreditosoliLogic= new NotaCreditoSoliLogic(connexion);
				notacreditosoliLogic.deepLoad(notacreditosoli,isDeep,deepLoadType,clases);
			}
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(ComisionVentaCobro.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(ComisionVentaCobro.class));
			vendedor.setComisionVentaCobros(vendedorDataAccess.getComisionVentaCobros(connexion,vendedor));

			for(ComisionVentaCobro comisionventacobro:vendedor.getComisionVentaCobros()) {
				ComisionVentaCobroLogic comisionventacobroLogic= new ComisionVentaCobroLogic(connexion);
				comisionventacobroLogic.deepLoad(comisionventacobro,isDeep,deepLoadType,clases);
			}
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Vendedor.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(Vendedor.class));
			vendedor.setVendedors(vendedorDataAccess.getVendedors(connexion,vendedor));

			for(Vendedor vendedorRecursivo:vendedor.getVendedors()) {
				VendedorLogic vendedorRecursivoLogic= new VendedorLogic(connexion);
				vendedorRecursivoLogic.deepLoad(vendedorRecursivo,isDeep,deepLoadType,clases);
			}
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Cliente.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(Cliente.class));
			vendedor.setClientes(vendedorDataAccess.getClientes(connexion,vendedor));

			for(Cliente cliente:vendedor.getClientes()) {
				ClienteLogic clienteLogic= new ClienteLogic(connexion);
				clienteLogic.deepLoad(cliente,isDeep,deepLoadType,clases);
			}
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(ComisionGrupo.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(ComisionGrupo.class));
			vendedor.setComisionGrupos(vendedorDataAccess.getComisionGrupos(connexion,vendedor));

			for(ComisionGrupo comisiongrupo:vendedor.getComisionGrupos()) {
				ComisionGrupoLogic comisiongrupoLogic= new ComisionGrupoLogic(connexion);
				comisiongrupoLogic.deepLoad(comisiongrupo,isDeep,deepLoadType,clases);
			}
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(ComisionLinea.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(ComisionLinea.class));
			vendedor.setComisionLineas(vendedorDataAccess.getComisionLineas(connexion,vendedor));

			for(ComisionLinea comisionlinea:vendedor.getComisionLineas()) {
				ComisionLineaLogic comisionlineaLogic= new ComisionLineaLogic(connexion);
				comisionlineaLogic.deepLoad(comisionlinea,isDeep,deepLoadType,clases);
			}
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(VendedorZona.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(VendedorZona.class));
			vendedor.setVendedorZonas(vendedorDataAccess.getVendedorZonas(connexion,vendedor));

			for(VendedorZona vendedorzona:vendedor.getVendedorZonas()) {
				VendedorZonaLogic vendedorzonaLogic= new VendedorZonaLogic(connexion);
				vendedorzonaLogic.deepLoad(vendedorzona,isDeep,deepLoadType,clases);
			}
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(ComisionCate.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(ComisionCate.class));
			vendedor.setComisionCates(vendedorDataAccess.getComisionCates(connexion,vendedor));

			for(ComisionCate comisioncate:vendedor.getComisionCates()) {
				ComisionCateLogic comisioncateLogic= new ComisionCateLogic(connexion);
				comisioncateLogic.deepLoad(comisioncate,isDeep,deepLoadType,clases);
			}
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(CajeroTurno.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(CajeroTurno.class));
			vendedor.setCajeroTurnos(vendedorDataAccess.getCajeroTurnos(connexion,vendedor));

			for(CajeroTurno cajeroturno:vendedor.getCajeroTurnos()) {
				CajeroTurnoLogic cajeroturnoLogic= new CajeroTurnoLogic(connexion);
				cajeroturnoLogic.deepLoad(cajeroturno,isDeep,deepLoadType,clases);
			}
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(ComisionMarca.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(ComisionMarca.class));
			vendedor.setComisionMarcas(vendedorDataAccess.getComisionMarcas(connexion,vendedor));

			for(ComisionMarca comisionmarca:vendedor.getComisionMarcas()) {
				ComisionMarcaLogic comisionmarcaLogic= new ComisionMarcaLogic(connexion);
				comisionmarcaLogic.deepLoad(comisionmarca,isDeep,deepLoadType,clases);
			}
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(PresupuestoVentas.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(PresupuestoVentas.class));
			vendedor.setPresupuestoVentass(vendedorDataAccess.getPresupuestoVentass(connexion,vendedor));

			for(PresupuestoVentas presupuestoventas:vendedor.getPresupuestoVentass()) {
				PresupuestoVentasLogic presupuestoventasLogic= new PresupuestoVentasLogic(connexion);
				presupuestoventasLogic.deepLoad(presupuestoventas,isDeep,deepLoadType,clases);
			}
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(PresupuestoVentasLineas.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(PresupuestoVentasLineas.class));
			vendedor.setPresupuestoVentasLineass(vendedorDataAccess.getPresupuestoVentasLineass(connexion,vendedor));

			for(PresupuestoVentasLineas presupuestoventaslineas:vendedor.getPresupuestoVentasLineass()) {
				PresupuestoVentasLineasLogic presupuestoventaslineasLogic= new PresupuestoVentasLineasLogic(connexion);
				presupuestoventaslineasLogic.deepLoad(presupuestoventaslineas,isDeep,deepLoadType,clases);
			}
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(Vendedor vendedor,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			VendedorLogicAdditional.updateVendedorToSave(vendedor,this.arrDatoGeneral);
			
VendedorDataAccess.save(vendedor, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(vendedor.getEmpresa(),connexion);

		SucursalDataAccess.save(vendedor.getSucursal(),connexion);

		EmpleadoDataAccess.save(vendedor.getEmpleado(),connexion);

		EmpleadoDataAccess.save(vendedor.getEmpleadoSoporte(),connexion);

		VendedorDataAccess.save(vendedor.getVendedor(),connexion);

		PaisDataAccess.save(vendedor.getPais(),connexion);

		CiudadDataAccess.save(vendedor.getCiudad(),connexion);

		ZonaDataAccess.save(vendedor.getZona(),connexion);

		for(NotaCreditoSoli notacreditosoli:vendedor.getNotaCreditoSolis()) {
			notacreditosoli.setid_vendedor(vendedor.getId());
			NotaCreditoSoliDataAccess.save(notacreditosoli,connexion);
		}

		for(ComisionVentaCobro comisionventacobro:vendedor.getComisionVentaCobros()) {
			comisionventacobro.setid_vendedor(vendedor.getId());
			ComisionVentaCobroDataAccess.save(comisionventacobro,connexion);
		}

		for(Vendedor vendedorRecursivo:vendedor.getVendedors()) {
			vendedorRecursivo.setid_vendedor(vendedor.getId());
			VendedorDataAccess.save(vendedorRecursivo,connexion);
		}

		for(Cliente cliente:vendedor.getClientes()) {
			cliente.setid_vendedor(vendedor.getId());
			ClienteDataAccess.save(cliente,connexion);
		}

		for(ComisionGrupo comisiongrupo:vendedor.getComisionGrupos()) {
			comisiongrupo.setid_vendedor(vendedor.getId());
			ComisionGrupoDataAccess.save(comisiongrupo,connexion);
		}

		for(ComisionLinea comisionlinea:vendedor.getComisionLineas()) {
			comisionlinea.setid_vendedor(vendedor.getId());
			ComisionLineaDataAccess.save(comisionlinea,connexion);
		}

		for(VendedorZona vendedorzona:vendedor.getVendedorZonas()) {
			vendedorzona.setid_vendedor(vendedor.getId());
			VendedorZonaDataAccess.save(vendedorzona,connexion);
		}

		for(ComisionCate comisioncate:vendedor.getComisionCates()) {
			comisioncate.setid_vendedor(vendedor.getId());
			ComisionCateDataAccess.save(comisioncate,connexion);
		}

		for(CajeroTurno cajeroturno:vendedor.getCajeroTurnos()) {
			cajeroturno.setid_vendedor(vendedor.getId());
			CajeroTurnoDataAccess.save(cajeroturno,connexion);
		}

		for(ComisionMarca comisionmarca:vendedor.getComisionMarcas()) {
			comisionmarca.setid_vendedor(vendedor.getId());
			ComisionMarcaDataAccess.save(comisionmarca,connexion);
		}

		for(PresupuestoVentas presupuestoventas:vendedor.getPresupuestoVentass()) {
			presupuestoventas.setid_vendedor(vendedor.getId());
			PresupuestoVentasDataAccess.save(presupuestoventas,connexion);
		}

		for(PresupuestoVentasLineas presupuestoventaslineas:vendedor.getPresupuestoVentasLineass()) {
			presupuestoventaslineas.setid_vendedor(vendedor.getId());
			PresupuestoVentasLineasDataAccess.save(presupuestoventaslineas,connexion);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(vendedor.getEmpresa(),connexion);
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				SucursalDataAccess.save(vendedor.getSucursal(),connexion);
				continue;
			}

			if(clas.clas.equals(Empleado.class)) {
				EmpleadoDataAccess.save(vendedor.getEmpleado(),connexion);
				continue;
			}

			if(clas.clas.equals(Empleado.class)) {
				EmpleadoDataAccess.save(vendedor.getEmpleadoSoporte(),connexion);
				continue;
			}

			if(clas.clas.equals(Vendedor.class)) {
				VendedorDataAccess.save(vendedor.getVendedor(),connexion);
				continue;
			}

			if(clas.clas.equals(Pais.class)) {
				PaisDataAccess.save(vendedor.getPais(),connexion);
				continue;
			}

			if(clas.clas.equals(Ciudad.class)) {
				CiudadDataAccess.save(vendedor.getCiudad(),connexion);
				continue;
			}

			if(clas.clas.equals(Zona.class)) {
				ZonaDataAccess.save(vendedor.getZona(),connexion);
				continue;
			}


			if(clas.clas.equals(NotaCreditoSoli.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(NotaCreditoSoli notacreditosoli:vendedor.getNotaCreditoSolis()) {
					notacreditosoli.setid_vendedor(vendedor.getId());
					NotaCreditoSoliDataAccess.save(notacreditosoli,connexion);
				}
				continue;
			}

			if(clas.clas.equals(ComisionVentaCobro.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(ComisionVentaCobro comisionventacobro:vendedor.getComisionVentaCobros()) {
					comisionventacobro.setid_vendedor(vendedor.getId());
					ComisionVentaCobroDataAccess.save(comisionventacobro,connexion);
				}
				continue;
			}

			if(clas.clas.equals(Vendedor.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(Vendedor vendedorRecursivo:vendedor.getVendedors()) {
					vendedorRecursivo.setid_vendedor(vendedor.getId());
					VendedorDataAccess.save(vendedorRecursivo,connexion);
				}
				continue;
			}

			if(clas.clas.equals(Cliente.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(Cliente cliente:vendedor.getClientes()) {
					cliente.setid_vendedor(vendedor.getId());
					ClienteDataAccess.save(cliente,connexion);
				}
				continue;
			}

			if(clas.clas.equals(ComisionGrupo.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(ComisionGrupo comisiongrupo:vendedor.getComisionGrupos()) {
					comisiongrupo.setid_vendedor(vendedor.getId());
					ComisionGrupoDataAccess.save(comisiongrupo,connexion);
				}
				continue;
			}

			if(clas.clas.equals(ComisionLinea.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(ComisionLinea comisionlinea:vendedor.getComisionLineas()) {
					comisionlinea.setid_vendedor(vendedor.getId());
					ComisionLineaDataAccess.save(comisionlinea,connexion);
				}
				continue;
			}

			if(clas.clas.equals(VendedorZona.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(VendedorZona vendedorzona:vendedor.getVendedorZonas()) {
					vendedorzona.setid_vendedor(vendedor.getId());
					VendedorZonaDataAccess.save(vendedorzona,connexion);
				}
				continue;
			}

			if(clas.clas.equals(ComisionCate.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(ComisionCate comisioncate:vendedor.getComisionCates()) {
					comisioncate.setid_vendedor(vendedor.getId());
					ComisionCateDataAccess.save(comisioncate,connexion);
				}
				continue;
			}

			if(clas.clas.equals(CajeroTurno.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(CajeroTurno cajeroturno:vendedor.getCajeroTurnos()) {
					cajeroturno.setid_vendedor(vendedor.getId());
					CajeroTurnoDataAccess.save(cajeroturno,connexion);
				}
				continue;
			}

			if(clas.clas.equals(ComisionMarca.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(ComisionMarca comisionmarca:vendedor.getComisionMarcas()) {
					comisionmarca.setid_vendedor(vendedor.getId());
					ComisionMarcaDataAccess.save(comisionmarca,connexion);
				}
				continue;
			}

			if(clas.clas.equals(PresupuestoVentas.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(PresupuestoVentas presupuestoventas:vendedor.getPresupuestoVentass()) {
					presupuestoventas.setid_vendedor(vendedor.getId());
					PresupuestoVentasDataAccess.save(presupuestoventas,connexion);
				}
				continue;
			}

			if(clas.clas.equals(PresupuestoVentasLineas.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(PresupuestoVentasLineas presupuestoventaslineas:vendedor.getPresupuestoVentasLineass()) {
					presupuestoventaslineas.setid_vendedor(vendedor.getId());
					PresupuestoVentasLineasDataAccess.save(presupuestoventaslineas,connexion);
				}
				continue;
			}
		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(vendedor.getEmpresa(),connexion);
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(vendedor.getEmpresa(),isDeep,deepLoadType,clases);
				

		SucursalDataAccess.save(vendedor.getSucursal(),connexion);
		SucursalLogic sucursalLogic= new SucursalLogic(connexion);
		sucursalLogic.deepLoad(vendedor.getSucursal(),isDeep,deepLoadType,clases);
				

		EmpleadoDataAccess.save(vendedor.getEmpleado(),connexion);
		EmpleadoLogic empleadoLogic= new EmpleadoLogic(connexion);
		empleadoLogic.deepLoad(vendedor.getEmpleado(),isDeep,deepLoadType,clases);
				

		EmpleadoDataAccess.save(vendedor.getEmpleadoSoporte(),connexion);
		EmpleadoLogic empleadosoporteLogic= new EmpleadoLogic(connexion);
		empleadosoporteLogic.deepLoad(vendedor.getEmpleadoSoporte(),isDeep,deepLoadType,clases);
				

		VendedorDataAccess.save(vendedor.getVendedor(),connexion);
		VendedorLogic vendedorLogic= new VendedorLogic(connexion);
		vendedorLogic.deepLoad(vendedor.getVendedor(),isDeep,deepLoadType,clases);
				

		PaisDataAccess.save(vendedor.getPais(),connexion);
		PaisLogic paisLogic= new PaisLogic(connexion);
		paisLogic.deepLoad(vendedor.getPais(),isDeep,deepLoadType,clases);
				

		CiudadDataAccess.save(vendedor.getCiudad(),connexion);
		CiudadLogic ciudadLogic= new CiudadLogic(connexion);
		ciudadLogic.deepLoad(vendedor.getCiudad(),isDeep,deepLoadType,clases);
				

		ZonaDataAccess.save(vendedor.getZona(),connexion);
		ZonaLogic zonaLogic= new ZonaLogic(connexion);
		zonaLogic.deepLoad(vendedor.getZona(),isDeep,deepLoadType,clases);
				

		for(NotaCreditoSoli notacreditosoli:vendedor.getNotaCreditoSolis()) {
			NotaCreditoSoliLogic notacreditosoliLogic= new NotaCreditoSoliLogic(connexion);
			notacreditosoli.setid_vendedor(vendedor.getId());
			NotaCreditoSoliDataAccess.save(notacreditosoli,connexion);
			notacreditosoliLogic.deepSave(notacreditosoli,isDeep,deepLoadType,clases);
		}

		for(ComisionVentaCobro comisionventacobro:vendedor.getComisionVentaCobros()) {
			ComisionVentaCobroLogic comisionventacobroLogic= new ComisionVentaCobroLogic(connexion);
			comisionventacobro.setid_vendedor(vendedor.getId());
			ComisionVentaCobroDataAccess.save(comisionventacobro,connexion);
			comisionventacobroLogic.deepSave(comisionventacobro,isDeep,deepLoadType,clases);
		}

		for(Vendedor vendedorRecursivo:vendedor.getVendedors()) {
			VendedorLogic vendedorRecursivoLogic= new VendedorLogic(connexion);
			vendedorRecursivo.setid_vendedor(vendedor.getId());
			VendedorDataAccess.save(vendedorRecursivo,connexion);
			vendedorRecursivoLogic.deepSave(vendedorRecursivo,isDeep,deepLoadType,clases);
		}

		for(Cliente cliente:vendedor.getClientes()) {
			ClienteLogic clienteLogic= new ClienteLogic(connexion);
			cliente.setid_vendedor(vendedor.getId());
			ClienteDataAccess.save(cliente,connexion);
			clienteLogic.deepSave(cliente,isDeep,deepLoadType,clases);
		}

		for(ComisionGrupo comisiongrupo:vendedor.getComisionGrupos()) {
			ComisionGrupoLogic comisiongrupoLogic= new ComisionGrupoLogic(connexion);
			comisiongrupo.setid_vendedor(vendedor.getId());
			ComisionGrupoDataAccess.save(comisiongrupo,connexion);
			comisiongrupoLogic.deepSave(comisiongrupo,isDeep,deepLoadType,clases);
		}

		for(ComisionLinea comisionlinea:vendedor.getComisionLineas()) {
			ComisionLineaLogic comisionlineaLogic= new ComisionLineaLogic(connexion);
			comisionlinea.setid_vendedor(vendedor.getId());
			ComisionLineaDataAccess.save(comisionlinea,connexion);
			comisionlineaLogic.deepSave(comisionlinea,isDeep,deepLoadType,clases);
		}

		for(VendedorZona vendedorzona:vendedor.getVendedorZonas()) {
			VendedorZonaLogic vendedorzonaLogic= new VendedorZonaLogic(connexion);
			vendedorzona.setid_vendedor(vendedor.getId());
			VendedorZonaDataAccess.save(vendedorzona,connexion);
			vendedorzonaLogic.deepSave(vendedorzona,isDeep,deepLoadType,clases);
		}

		for(ComisionCate comisioncate:vendedor.getComisionCates()) {
			ComisionCateLogic comisioncateLogic= new ComisionCateLogic(connexion);
			comisioncate.setid_vendedor(vendedor.getId());
			ComisionCateDataAccess.save(comisioncate,connexion);
			comisioncateLogic.deepSave(comisioncate,isDeep,deepLoadType,clases);
		}

		for(CajeroTurno cajeroturno:vendedor.getCajeroTurnos()) {
			CajeroTurnoLogic cajeroturnoLogic= new CajeroTurnoLogic(connexion);
			cajeroturno.setid_vendedor(vendedor.getId());
			CajeroTurnoDataAccess.save(cajeroturno,connexion);
			cajeroturnoLogic.deepSave(cajeroturno,isDeep,deepLoadType,clases);
		}

		for(ComisionMarca comisionmarca:vendedor.getComisionMarcas()) {
			ComisionMarcaLogic comisionmarcaLogic= new ComisionMarcaLogic(connexion);
			comisionmarca.setid_vendedor(vendedor.getId());
			ComisionMarcaDataAccess.save(comisionmarca,connexion);
			comisionmarcaLogic.deepSave(comisionmarca,isDeep,deepLoadType,clases);
		}

		for(PresupuestoVentas presupuestoventas:vendedor.getPresupuestoVentass()) {
			PresupuestoVentasLogic presupuestoventasLogic= new PresupuestoVentasLogic(connexion);
			presupuestoventas.setid_vendedor(vendedor.getId());
			PresupuestoVentasDataAccess.save(presupuestoventas,connexion);
			presupuestoventasLogic.deepSave(presupuestoventas,isDeep,deepLoadType,clases);
		}

		for(PresupuestoVentasLineas presupuestoventaslineas:vendedor.getPresupuestoVentasLineass()) {
			PresupuestoVentasLineasLogic presupuestoventaslineasLogic= new PresupuestoVentasLineasLogic(connexion);
			presupuestoventaslineas.setid_vendedor(vendedor.getId());
			PresupuestoVentasLineasDataAccess.save(presupuestoventaslineas,connexion);
			presupuestoventaslineasLogic.deepSave(presupuestoventaslineas,isDeep,deepLoadType,clases);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(vendedor.getEmpresa(),connexion);
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepSave(vendedor.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				SucursalDataAccess.save(vendedor.getSucursal(),connexion);
				SucursalLogic sucursalLogic= new SucursalLogic(connexion);
				sucursalLogic.deepSave(vendedor.getSucursal(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Empleado.class)) {
				EmpleadoDataAccess.save(vendedor.getEmpleado(),connexion);
				EmpleadoLogic empleadoLogic= new EmpleadoLogic(connexion);
				empleadoLogic.deepSave(vendedor.getEmpleado(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Empleado.class)) {
				EmpleadoDataAccess.save(vendedor.getEmpleadoSoporte(),connexion);
				EmpleadoLogic empleadoLogic= new EmpleadoLogic(connexion);
				empleadoLogic.deepSave(vendedor.getEmpleadoSoporte(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Vendedor.class)) {
				VendedorDataAccess.save(vendedor.getVendedor(),connexion);
				VendedorLogic vendedorLogic= new VendedorLogic(connexion);
				vendedorLogic.deepSave(vendedor.getVendedor(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Pais.class)) {
				PaisDataAccess.save(vendedor.getPais(),connexion);
				PaisLogic paisLogic= new PaisLogic(connexion);
				paisLogic.deepSave(vendedor.getPais(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Ciudad.class)) {
				CiudadDataAccess.save(vendedor.getCiudad(),connexion);
				CiudadLogic ciudadLogic= new CiudadLogic(connexion);
				ciudadLogic.deepSave(vendedor.getCiudad(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Zona.class)) {
				ZonaDataAccess.save(vendedor.getZona(),connexion);
				ZonaLogic zonaLogic= new ZonaLogic(connexion);
				zonaLogic.deepSave(vendedor.getZona(),isDeep,deepLoadType,clases);				
				continue;
			}


			if(clas.clas.equals(NotaCreditoSoli.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(NotaCreditoSoli notacreditosoli:vendedor.getNotaCreditoSolis()) {
					NotaCreditoSoliLogic notacreditosoliLogic= new NotaCreditoSoliLogic(connexion);
					notacreditosoli.setid_vendedor(vendedor.getId());
					NotaCreditoSoliDataAccess.save(notacreditosoli,connexion);
					notacreditosoliLogic.deepSave(notacreditosoli,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(ComisionVentaCobro.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(ComisionVentaCobro comisionventacobro:vendedor.getComisionVentaCobros()) {
					ComisionVentaCobroLogic comisionventacobroLogic= new ComisionVentaCobroLogic(connexion);
					comisionventacobro.setid_vendedor(vendedor.getId());
					ComisionVentaCobroDataAccess.save(comisionventacobro,connexion);
					comisionventacobroLogic.deepSave(comisionventacobro,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(Vendedor.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(Vendedor vendedorRecursivo:vendedor.getVendedors()) {
					VendedorLogic vendedorRecursivoLogic= new VendedorLogic(connexion);
					vendedorRecursivo.setid_vendedor(vendedor.getId());
					VendedorDataAccess.save(vendedorRecursivo,connexion);
					vendedorRecursivoLogic.deepSave(vendedorRecursivo,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(Cliente.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(Cliente cliente:vendedor.getClientes()) {
					ClienteLogic clienteLogic= new ClienteLogic(connexion);
					cliente.setid_vendedor(vendedor.getId());
					ClienteDataAccess.save(cliente,connexion);
					clienteLogic.deepSave(cliente,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(ComisionGrupo.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(ComisionGrupo comisiongrupo:vendedor.getComisionGrupos()) {
					ComisionGrupoLogic comisiongrupoLogic= new ComisionGrupoLogic(connexion);
					comisiongrupo.setid_vendedor(vendedor.getId());
					ComisionGrupoDataAccess.save(comisiongrupo,connexion);
					comisiongrupoLogic.deepSave(comisiongrupo,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(ComisionLinea.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(ComisionLinea comisionlinea:vendedor.getComisionLineas()) {
					ComisionLineaLogic comisionlineaLogic= new ComisionLineaLogic(connexion);
					comisionlinea.setid_vendedor(vendedor.getId());
					ComisionLineaDataAccess.save(comisionlinea,connexion);
					comisionlineaLogic.deepSave(comisionlinea,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(VendedorZona.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(VendedorZona vendedorzona:vendedor.getVendedorZonas()) {
					VendedorZonaLogic vendedorzonaLogic= new VendedorZonaLogic(connexion);
					vendedorzona.setid_vendedor(vendedor.getId());
					VendedorZonaDataAccess.save(vendedorzona,connexion);
					vendedorzonaLogic.deepSave(vendedorzona,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(ComisionCate.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(ComisionCate comisioncate:vendedor.getComisionCates()) {
					ComisionCateLogic comisioncateLogic= new ComisionCateLogic(connexion);
					comisioncate.setid_vendedor(vendedor.getId());
					ComisionCateDataAccess.save(comisioncate,connexion);
					comisioncateLogic.deepSave(comisioncate,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(CajeroTurno.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(CajeroTurno cajeroturno:vendedor.getCajeroTurnos()) {
					CajeroTurnoLogic cajeroturnoLogic= new CajeroTurnoLogic(connexion);
					cajeroturno.setid_vendedor(vendedor.getId());
					CajeroTurnoDataAccess.save(cajeroturno,connexion);
					cajeroturnoLogic.deepSave(cajeroturno,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(ComisionMarca.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(ComisionMarca comisionmarca:vendedor.getComisionMarcas()) {
					ComisionMarcaLogic comisionmarcaLogic= new ComisionMarcaLogic(connexion);
					comisionmarca.setid_vendedor(vendedor.getId());
					ComisionMarcaDataAccess.save(comisionmarca,connexion);
					comisionmarcaLogic.deepSave(comisionmarca,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(PresupuestoVentas.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(PresupuestoVentas presupuestoventas:vendedor.getPresupuestoVentass()) {
					PresupuestoVentasLogic presupuestoventasLogic= new PresupuestoVentasLogic(connexion);
					presupuestoventas.setid_vendedor(vendedor.getId());
					PresupuestoVentasDataAccess.save(presupuestoventas,connexion);
					presupuestoventasLogic.deepSave(presupuestoventas,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(PresupuestoVentasLineas.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(PresupuestoVentasLineas presupuestoventaslineas:vendedor.getPresupuestoVentasLineass()) {
					PresupuestoVentasLineasLogic presupuestoventaslineasLogic= new PresupuestoVentasLineasLogic(connexion);
					presupuestoventaslineas.setid_vendedor(vendedor.getId());
					PresupuestoVentasLineasDataAccess.save(presupuestoventaslineas,connexion);
					presupuestoventaslineasLogic.deepSave(presupuestoventaslineas,isDeep,deepLoadType,clases);
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
			this.getNewConnexionToDeep(Vendedor.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(vendedor,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				VendedorConstantesFunciones.refrescarForeignKeysDescripcionesVendedor(vendedor);
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
			this.deepLoad(this.vendedor,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				VendedorConstantesFunciones.refrescarForeignKeysDescripcionesVendedor(this.vendedor);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(Vendedor.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(vendedors!=null) {
				for(Vendedor vendedor:vendedors) {
					this.deepLoad(vendedor,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					VendedorConstantesFunciones.refrescarForeignKeysDescripcionesVendedor(vendedors);
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
			if(vendedors!=null) {
				for(Vendedor vendedor:vendedors) {
					this.deepLoad(vendedor,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					VendedorConstantesFunciones.refrescarForeignKeysDescripcionesVendedor(vendedors);
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
			this.getNewConnexionToDeep(Vendedor.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(vendedor,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(Vendedor.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(vendedors!=null) {
				for(Vendedor vendedor:vendedors) {
					this.deepSave(vendedor,isDeep,deepLoadType,clases);
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
			if(vendedors!=null) {
				for(Vendedor vendedor:vendedors) {
					this.deepSave(vendedor,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getVendedorsBusquedaPorCodigoWithConnection(String sFinalQuery,Pagination pagination,String codigo)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Vendedor.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralCodigo= new ParameterSelectionGeneral();
			parameterSelectionGeneralCodigo.setParameterSelectionGeneralLike(ParameterType.STRING,"%"+codigo+"%",VendedorConstantesFunciones.CODIGO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralCodigo);

			VendedorLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorCodigo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			vendedors=vendedorDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				VendedorConstantesFunciones.refrescarForeignKeysDescripcionesVendedor(this.vendedors);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getVendedorsBusquedaPorCodigo(String sFinalQuery,Pagination pagination,String codigo)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralCodigo= new ParameterSelectionGeneral();
			parameterSelectionGeneralCodigo.setParameterSelectionGeneralLike(ParameterType.STRING,"%"+codigo+"%",VendedorConstantesFunciones.CODIGO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralCodigo);

			VendedorLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorCodigo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			vendedors=vendedorDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				VendedorConstantesFunciones.refrescarForeignKeysDescripcionesVendedor(this.vendedors);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getVendedorsBusquedaPorNombreWithConnection(String sFinalQuery,Pagination pagination,String nombre)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Vendedor.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralNombre= new ParameterSelectionGeneral();
			parameterSelectionGeneralNombre.setParameterSelectionGeneralLike(ParameterType.STRING,"%"+nombre+"%",VendedorConstantesFunciones.NOMBRE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralNombre);

			VendedorLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorNombre","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			vendedors=vendedorDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				VendedorConstantesFunciones.refrescarForeignKeysDescripcionesVendedor(this.vendedors);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getVendedorsBusquedaPorNombre(String sFinalQuery,Pagination pagination,String nombre)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralNombre= new ParameterSelectionGeneral();
			parameterSelectionGeneralNombre.setParameterSelectionGeneralLike(ParameterType.STRING,"%"+nombre+"%",VendedorConstantesFunciones.NOMBRE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralNombre);

			VendedorLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorNombre","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			vendedors=vendedorDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				VendedorConstantesFunciones.refrescarForeignKeysDescripcionesVendedor(this.vendedors);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getVendedorsBusquedaPorRucWithConnection(String sFinalQuery,Pagination pagination,String ruc)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Vendedor.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralRuc= new ParameterSelectionGeneral();
			parameterSelectionGeneralRuc.setParameterSelectionGeneralLike(ParameterType.STRING,"%"+ruc+"%",VendedorConstantesFunciones.RUC,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralRuc);

			VendedorLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorRuc","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			vendedors=vendedorDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				VendedorConstantesFunciones.refrescarForeignKeysDescripcionesVendedor(this.vendedors);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getVendedorsBusquedaPorRuc(String sFinalQuery,Pagination pagination,String ruc)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralRuc= new ParameterSelectionGeneral();
			parameterSelectionGeneralRuc.setParameterSelectionGeneralLike(ParameterType.STRING,"%"+ruc+"%",VendedorConstantesFunciones.RUC,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralRuc);

			VendedorLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorRuc","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			vendedors=vendedorDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				VendedorConstantesFunciones.refrescarForeignKeysDescripcionesVendedor(this.vendedors);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getVendedorsFK_IdCiudadWithConnection(String sFinalQuery,Pagination pagination,Long id_ciudad)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Vendedor.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCiudad= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCiudad.setParameterSelectionGeneralEqual(ParameterType.LONG,id_ciudad,VendedorConstantesFunciones.IDCIUDAD,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCiudad);

			VendedorLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCiudad","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			vendedors=vendedorDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				VendedorConstantesFunciones.refrescarForeignKeysDescripcionesVendedor(this.vendedors);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getVendedorsFK_IdCiudad(String sFinalQuery,Pagination pagination,Long id_ciudad)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCiudad= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCiudad.setParameterSelectionGeneralEqual(ParameterType.LONG,id_ciudad,VendedorConstantesFunciones.IDCIUDAD,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCiudad);

			VendedorLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCiudad","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			vendedors=vendedorDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				VendedorConstantesFunciones.refrescarForeignKeysDescripcionesVendedor(this.vendedors);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getVendedorsFK_IdEmpleadoWithConnection(String sFinalQuery,Pagination pagination,Long id_empleado)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Vendedor.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpleado= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpleado.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empleado,VendedorConstantesFunciones.IDEMPLEADO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpleado);

			VendedorLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpleado","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			vendedors=vendedorDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				VendedorConstantesFunciones.refrescarForeignKeysDescripcionesVendedor(this.vendedors);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getVendedorsFK_IdEmpleado(String sFinalQuery,Pagination pagination,Long id_empleado)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpleado= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpleado.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empleado,VendedorConstantesFunciones.IDEMPLEADO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpleado);

			VendedorLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpleado","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			vendedors=vendedorDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				VendedorConstantesFunciones.refrescarForeignKeysDescripcionesVendedor(this.vendedors);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getVendedorsFK_IdEmpleadoSoporteWithConnection(String sFinalQuery,Pagination pagination,Long id_empleado_soporte)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Vendedor.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpleadoSoporte= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpleadoSoporte.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empleado_soporte,VendedorConstantesFunciones.IDEMPLEADOSOPORTE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpleadoSoporte);

			VendedorLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpleadoSoporte","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			vendedors=vendedorDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				VendedorConstantesFunciones.refrescarForeignKeysDescripcionesVendedor(this.vendedors);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getVendedorsFK_IdEmpleadoSoporte(String sFinalQuery,Pagination pagination,Long id_empleado_soporte)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpleadoSoporte= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpleadoSoporte.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empleado_soporte,VendedorConstantesFunciones.IDEMPLEADOSOPORTE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpleadoSoporte);

			VendedorLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpleadoSoporte","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			vendedors=vendedorDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				VendedorConstantesFunciones.refrescarForeignKeysDescripcionesVendedor(this.vendedors);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getVendedorsFK_IdEmpresaWithConnection(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Vendedor.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,VendedorConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			VendedorLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			vendedors=vendedorDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				VendedorConstantesFunciones.refrescarForeignKeysDescripcionesVendedor(this.vendedors);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getVendedorsFK_IdEmpresa(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,VendedorConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			VendedorLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			vendedors=vendedorDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				VendedorConstantesFunciones.refrescarForeignKeysDescripcionesVendedor(this.vendedors);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getVendedorsFK_IdPaisWithConnection(String sFinalQuery,Pagination pagination,Long id_pais)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Vendedor.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidPais= new ParameterSelectionGeneral();
			parameterSelectionGeneralidPais.setParameterSelectionGeneralEqual(ParameterType.LONG,id_pais,VendedorConstantesFunciones.IDPAIS,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidPais);

			VendedorLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdPais","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			vendedors=vendedorDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				VendedorConstantesFunciones.refrescarForeignKeysDescripcionesVendedor(this.vendedors);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getVendedorsFK_IdPais(String sFinalQuery,Pagination pagination,Long id_pais)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidPais= new ParameterSelectionGeneral();
			parameterSelectionGeneralidPais.setParameterSelectionGeneralEqual(ParameterType.LONG,id_pais,VendedorConstantesFunciones.IDPAIS,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidPais);

			VendedorLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdPais","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			vendedors=vendedorDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				VendedorConstantesFunciones.refrescarForeignKeysDescripcionesVendedor(this.vendedors);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getVendedorsFK_IdSucursalWithConnection(String sFinalQuery,Pagination pagination,Long id_sucursal)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Vendedor.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidSucursal= new ParameterSelectionGeneral();
			parameterSelectionGeneralidSucursal.setParameterSelectionGeneralEqual(ParameterType.LONG,id_sucursal,VendedorConstantesFunciones.IDSUCURSAL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidSucursal);

			VendedorLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdSucursal","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			vendedors=vendedorDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				VendedorConstantesFunciones.refrescarForeignKeysDescripcionesVendedor(this.vendedors);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getVendedorsFK_IdSucursal(String sFinalQuery,Pagination pagination,Long id_sucursal)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidSucursal= new ParameterSelectionGeneral();
			parameterSelectionGeneralidSucursal.setParameterSelectionGeneralEqual(ParameterType.LONG,id_sucursal,VendedorConstantesFunciones.IDSUCURSAL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidSucursal);

			VendedorLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdSucursal","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			vendedors=vendedorDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				VendedorConstantesFunciones.refrescarForeignKeysDescripcionesVendedor(this.vendedors);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getVendedorsFK_IdVendedorWithConnection(String sFinalQuery,Pagination pagination,Long id_vendedor)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Vendedor.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidVendedor= new ParameterSelectionGeneral();
			parameterSelectionGeneralidVendedor.setParameterSelectionGeneralEqual(ParameterType.LONG,id_vendedor,VendedorConstantesFunciones.IDVENDEDOR,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidVendedor);

			VendedorLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdVendedor","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			vendedors=vendedorDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				VendedorConstantesFunciones.refrescarForeignKeysDescripcionesVendedor(this.vendedors);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getVendedorsFK_IdVendedor(String sFinalQuery,Pagination pagination,Long id_vendedor)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidVendedor= new ParameterSelectionGeneral();
			parameterSelectionGeneralidVendedor.setParameterSelectionGeneralEqual(ParameterType.LONG,id_vendedor,VendedorConstantesFunciones.IDVENDEDOR,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidVendedor);

			VendedorLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdVendedor","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			vendedors=vendedorDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				VendedorConstantesFunciones.refrescarForeignKeysDescripcionesVendedor(this.vendedors);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getVendedorsFK_IdZonaWithConnection(String sFinalQuery,Pagination pagination,Long id_zona)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Vendedor.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidZona= new ParameterSelectionGeneral();
			parameterSelectionGeneralidZona.setParameterSelectionGeneralEqual(ParameterType.LONG,id_zona,VendedorConstantesFunciones.IDZONA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidZona);

			VendedorLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdZona","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			vendedors=vendedorDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				VendedorConstantesFunciones.refrescarForeignKeysDescripcionesVendedor(this.vendedors);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getVendedorsFK_IdZona(String sFinalQuery,Pagination pagination,Long id_zona)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidZona= new ParameterSelectionGeneral();
			parameterSelectionGeneralidZona.setParameterSelectionGeneralEqual(ParameterType.LONG,id_zona,VendedorConstantesFunciones.IDZONA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidZona);

			VendedorLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdZona","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			vendedors=vendedorDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				VendedorConstantesFunciones.refrescarForeignKeysDescripcionesVendedor(this.vendedors);
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
			if(VendedorConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,VendedorDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,Vendedor vendedor,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(VendedorConstantesFunciones.ISCONAUDITORIA) {
				if(vendedor.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,VendedorDataAccess.TABLENAME, vendedor.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(VendedorConstantesFunciones.ISCONAUDITORIADETALLE) {
						////VendedorLogic.registrarAuditoriaDetallesVendedor(connexion,vendedor,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(vendedor.getIsDeleted()) {
					/*if(!vendedor.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,VendedorDataAccess.TABLENAME, vendedor.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////VendedorLogic.registrarAuditoriaDetallesVendedor(connexion,vendedor,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,VendedorDataAccess.TABLENAME, vendedor.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(vendedor.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,VendedorDataAccess.TABLENAME, vendedor.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(VendedorConstantesFunciones.ISCONAUDITORIADETALLE) {
						////VendedorLogic.registrarAuditoriaDetallesVendedor(connexion,vendedor,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesVendedor(Connexion connexion,Vendedor vendedor)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(vendedor.getIsNew()||!vendedor.getid_empresa().equals(vendedor.getVendedorOriginal().getid_empresa()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(vendedor.getVendedorOriginal().getid_empresa()!=null)
				{
					strValorActual=vendedor.getVendedorOriginal().getid_empresa().toString();
				}
				if(vendedor.getid_empresa()!=null)
				{
					strValorNuevo=vendedor.getid_empresa().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),VendedorConstantesFunciones.IDEMPRESA,strValorActual,strValorNuevo);
			}	
			
			if(vendedor.getIsNew()||!vendedor.getid_sucursal().equals(vendedor.getVendedorOriginal().getid_sucursal()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(vendedor.getVendedorOriginal().getid_sucursal()!=null)
				{
					strValorActual=vendedor.getVendedorOriginal().getid_sucursal().toString();
				}
				if(vendedor.getid_sucursal()!=null)
				{
					strValorNuevo=vendedor.getid_sucursal().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),VendedorConstantesFunciones.IDSUCURSAL,strValorActual,strValorNuevo);
			}	
			
			if(vendedor.getIsNew()||!vendedor.getcodigo().equals(vendedor.getVendedorOriginal().getcodigo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(vendedor.getVendedorOriginal().getcodigo()!=null)
				{
					strValorActual=vendedor.getVendedorOriginal().getcodigo();
				}
				if(vendedor.getcodigo()!=null)
				{
					strValorNuevo=vendedor.getcodigo() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),VendedorConstantesFunciones.CODIGO,strValorActual,strValorNuevo);
			}	
			
			if(vendedor.getIsNew()||!vendedor.getnombre().equals(vendedor.getVendedorOriginal().getnombre()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(vendedor.getVendedorOriginal().getnombre()!=null)
				{
					strValorActual=vendedor.getVendedorOriginal().getnombre();
				}
				if(vendedor.getnombre()!=null)
				{
					strValorNuevo=vendedor.getnombre() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),VendedorConstantesFunciones.NOMBRE,strValorActual,strValorNuevo);
			}	
			
			if(vendedor.getIsNew()||!vendedor.getruc().equals(vendedor.getVendedorOriginal().getruc()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(vendedor.getVendedorOriginal().getruc()!=null)
				{
					strValorActual=vendedor.getVendedorOriginal().getruc();
				}
				if(vendedor.getruc()!=null)
				{
					strValorNuevo=vendedor.getruc() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),VendedorConstantesFunciones.RUC,strValorActual,strValorNuevo);
			}	
			
			if(vendedor.getIsNew()||!vendedor.getemail().equals(vendedor.getVendedorOriginal().getemail()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(vendedor.getVendedorOriginal().getemail()!=null)
				{
					strValorActual=vendedor.getVendedorOriginal().getemail();
				}
				if(vendedor.getemail()!=null)
				{
					strValorNuevo=vendedor.getemail() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),VendedorConstantesFunciones.EMAIL,strValorActual,strValorNuevo);
			}	
			
			if(vendedor.getIsNew()||!vendedor.getid_empleado().equals(vendedor.getVendedorOriginal().getid_empleado()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(vendedor.getVendedorOriginal().getid_empleado()!=null)
				{
					strValorActual=vendedor.getVendedorOriginal().getid_empleado().toString();
				}
				if(vendedor.getid_empleado()!=null)
				{
					strValorNuevo=vendedor.getid_empleado().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),VendedorConstantesFunciones.IDEMPLEADO,strValorActual,strValorNuevo);
			}	
			
			if(vendedor.getIsNew()||!vendedor.gettelefono().equals(vendedor.getVendedorOriginal().gettelefono()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(vendedor.getVendedorOriginal().gettelefono()!=null)
				{
					strValorActual=vendedor.getVendedorOriginal().gettelefono();
				}
				if(vendedor.gettelefono()!=null)
				{
					strValorNuevo=vendedor.gettelefono() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),VendedorConstantesFunciones.TELEFONO,strValorActual,strValorNuevo);
			}	
			
			if(vendedor.getIsNew()||!vendedor.getid_empleado_soporte().equals(vendedor.getVendedorOriginal().getid_empleado_soporte()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(vendedor.getVendedorOriginal().getid_empleado_soporte()!=null)
				{
					strValorActual=vendedor.getVendedorOriginal().getid_empleado_soporte().toString();
				}
				if(vendedor.getid_empleado_soporte()!=null)
				{
					strValorNuevo=vendedor.getid_empleado_soporte().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),VendedorConstantesFunciones.IDEMPLEADOSOPORTE,strValorActual,strValorNuevo);
			}	
			
			if(vendedor.getIsNew()||!vendedor.getid_vendedor().equals(vendedor.getVendedorOriginal().getid_vendedor()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(vendedor.getVendedorOriginal().getid_vendedor()!=null)
				{
					strValorActual=vendedor.getVendedorOriginal().getid_vendedor().toString();
				}
				if(vendedor.getid_vendedor()!=null)
				{
					strValorNuevo=vendedor.getid_vendedor().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),VendedorConstantesFunciones.IDVENDEDOR,strValorActual,strValorNuevo);
			}	
			
			if(vendedor.getIsNew()||!vendedor.getid_pais().equals(vendedor.getVendedorOriginal().getid_pais()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(vendedor.getVendedorOriginal().getid_pais()!=null)
				{
					strValorActual=vendedor.getVendedorOriginal().getid_pais().toString();
				}
				if(vendedor.getid_pais()!=null)
				{
					strValorNuevo=vendedor.getid_pais().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),VendedorConstantesFunciones.IDPAIS,strValorActual,strValorNuevo);
			}	
			
			if(vendedor.getIsNew()||!vendedor.getid_ciudad().equals(vendedor.getVendedorOriginal().getid_ciudad()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(vendedor.getVendedorOriginal().getid_ciudad()!=null)
				{
					strValorActual=vendedor.getVendedorOriginal().getid_ciudad().toString();
				}
				if(vendedor.getid_ciudad()!=null)
				{
					strValorNuevo=vendedor.getid_ciudad().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),VendedorConstantesFunciones.IDCIUDAD,strValorActual,strValorNuevo);
			}	
			
			if(vendedor.getIsNew()||!vendedor.getid_zona().equals(vendedor.getVendedorOriginal().getid_zona()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(vendedor.getVendedorOriginal().getid_zona()!=null)
				{
					strValorActual=vendedor.getVendedorOriginal().getid_zona().toString();
				}
				if(vendedor.getid_zona()!=null)
				{
					strValorNuevo=vendedor.getid_zona().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),VendedorConstantesFunciones.IDZONA,strValorActual,strValorNuevo);
			}	
			
			if(vendedor.getIsNew()||!vendedor.getrepresentante().equals(vendedor.getVendedorOriginal().getrepresentante()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(vendedor.getVendedorOriginal().getrepresentante()!=null)
				{
					strValorActual=vendedor.getVendedorOriginal().getrepresentante();
				}
				if(vendedor.getrepresentante()!=null)
				{
					strValorNuevo=vendedor.getrepresentante() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),VendedorConstantesFunciones.REPRESENTANTE,strValorActual,strValorNuevo);
			}	
			
			if(vendedor.getIsNew()||!vendedor.getes_supervisor().equals(vendedor.getVendedorOriginal().getes_supervisor()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(vendedor.getVendedorOriginal().getes_supervisor()!=null)
				{
					strValorActual=vendedor.getVendedorOriginal().getes_supervisor().toString();
				}
				if(vendedor.getes_supervisor()!=null)
				{
					strValorNuevo=vendedor.getes_supervisor().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),VendedorConstantesFunciones.ESSUPERVISOR,strValorActual,strValorNuevo);
			}	
			
			if(vendedor.getIsNew()||!vendedor.getfecha_creacion().equals(vendedor.getVendedorOriginal().getfecha_creacion()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(vendedor.getVendedorOriginal().getfecha_creacion()!=null)
				{
					strValorActual=vendedor.getVendedorOriginal().getfecha_creacion().toString();
				}
				if(vendedor.getfecha_creacion()!=null)
				{
					strValorNuevo=vendedor.getfecha_creacion().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),VendedorConstantesFunciones.FECHACREACION,strValorActual,strValorNuevo);
			}	
			
			if(vendedor.getIsNew()||!vendedor.getdireccion_domicilio().equals(vendedor.getVendedorOriginal().getdireccion_domicilio()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(vendedor.getVendedorOriginal().getdireccion_domicilio()!=null)
				{
					strValorActual=vendedor.getVendedorOriginal().getdireccion_domicilio();
				}
				if(vendedor.getdireccion_domicilio()!=null)
				{
					strValorNuevo=vendedor.getdireccion_domicilio() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),VendedorConstantesFunciones.DIRECCIONDOMICILIO,strValorActual,strValorNuevo);
			}	
			
			if(vendedor.getIsNew()||!vendedor.getdireccion_referencia().equals(vendedor.getVendedorOriginal().getdireccion_referencia()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(vendedor.getVendedorOriginal().getdireccion_referencia()!=null)
				{
					strValorActual=vendedor.getVendedorOriginal().getdireccion_referencia();
				}
				if(vendedor.getdireccion_referencia()!=null)
				{
					strValorNuevo=vendedor.getdireccion_referencia() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),VendedorConstantesFunciones.DIRECCIONREFERENCIA,strValorActual,strValorNuevo);
			}	
			
			if(vendedor.getIsNew()||!vendedor.getdescripcion().equals(vendedor.getVendedorOriginal().getdescripcion()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(vendedor.getVendedorOriginal().getdescripcion()!=null)
				{
					strValorActual=vendedor.getVendedorOriginal().getdescripcion();
				}
				if(vendedor.getdescripcion()!=null)
				{
					strValorNuevo=vendedor.getdescripcion() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),VendedorConstantesFunciones.DESCRIPCION,strValorActual,strValorNuevo);
			}	
			
			if(vendedor.getIsNew()||!vendedor.getporcentaje_comision().equals(vendedor.getVendedorOriginal().getporcentaje_comision()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(vendedor.getVendedorOriginal().getporcentaje_comision()!=null)
				{
					strValorActual=vendedor.getVendedorOriginal().getporcentaje_comision().toString();
				}
				if(vendedor.getporcentaje_comision()!=null)
				{
					strValorNuevo=vendedor.getporcentaje_comision().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),VendedorConstantesFunciones.PORCENTAJECOMISION,strValorActual,strValorNuevo);
			}	
			
			if(vendedor.getIsNew()||!vendedor.getcomision().equals(vendedor.getVendedorOriginal().getcomision()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(vendedor.getVendedorOriginal().getcomision()!=null)
				{
					strValorActual=vendedor.getVendedorOriginal().getcomision().toString();
				}
				if(vendedor.getcomision()!=null)
				{
					strValorNuevo=vendedor.getcomision().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),VendedorConstantesFunciones.COMISION,strValorActual,strValorNuevo);
			}	
			
			if(vendedor.getIsNew()||!vendedor.getmonto_vendido().equals(vendedor.getVendedorOriginal().getmonto_vendido()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(vendedor.getVendedorOriginal().getmonto_vendido()!=null)
				{
					strValorActual=vendedor.getVendedorOriginal().getmonto_vendido().toString();
				}
				if(vendedor.getmonto_vendido()!=null)
				{
					strValorNuevo=vendedor.getmonto_vendido().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),VendedorConstantesFunciones.MONTOVENDIDO,strValorActual,strValorNuevo);
			}	
			
			if(vendedor.getIsNew()||!vendedor.getnumero_facturas().equals(vendedor.getVendedorOriginal().getnumero_facturas()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(vendedor.getVendedorOriginal().getnumero_facturas()!=null)
				{
					strValorActual=vendedor.getVendedorOriginal().getnumero_facturas().toString();
				}
				if(vendedor.getnumero_facturas()!=null)
				{
					strValorNuevo=vendedor.getnumero_facturas().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),VendedorConstantesFunciones.NUMEROFACTURAS,strValorActual,strValorNuevo);
			}	
			
			if(vendedor.getIsNew()||!vendedor.getfecha_ultima_venta().equals(vendedor.getVendedorOriginal().getfecha_ultima_venta()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(vendedor.getVendedorOriginal().getfecha_ultima_venta()!=null)
				{
					strValorActual=vendedor.getVendedorOriginal().getfecha_ultima_venta().toString();
				}
				if(vendedor.getfecha_ultima_venta()!=null)
				{
					strValorNuevo=vendedor.getfecha_ultima_venta().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),VendedorConstantesFunciones.FECHAULTIMAVENTA,strValorActual,strValorNuevo);
			}	
			
			if(vendedor.getIsNew()||!vendedor.getmonto_ultima_venta().equals(vendedor.getVendedorOriginal().getmonto_ultima_venta()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(vendedor.getVendedorOriginal().getmonto_ultima_venta()!=null)
				{
					strValorActual=vendedor.getVendedorOriginal().getmonto_ultima_venta().toString();
				}
				if(vendedor.getmonto_ultima_venta()!=null)
				{
					strValorNuevo=vendedor.getmonto_ultima_venta().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),VendedorConstantesFunciones.MONTOULTIMAVENTA,strValorActual,strValorNuevo);
			}	
			
			if(vendedor.getIsNew()||!vendedor.getcon_presupuesto().equals(vendedor.getVendedorOriginal().getcon_presupuesto()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(vendedor.getVendedorOriginal().getcon_presupuesto()!=null)
				{
					strValorActual=vendedor.getVendedorOriginal().getcon_presupuesto().toString();
				}
				if(vendedor.getcon_presupuesto()!=null)
				{
					strValorNuevo=vendedor.getcon_presupuesto().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),VendedorConstantesFunciones.CONPRESUPUESTO,strValorActual,strValorNuevo);
			}	
			
			if(vendedor.getIsNew()||!vendedor.getcon_cobertura().equals(vendedor.getVendedorOriginal().getcon_cobertura()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(vendedor.getVendedorOriginal().getcon_cobertura()!=null)
				{
					strValorActual=vendedor.getVendedorOriginal().getcon_cobertura().toString();
				}
				if(vendedor.getcon_cobertura()!=null)
				{
					strValorNuevo=vendedor.getcon_cobertura().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),VendedorConstantesFunciones.CONCOBERTURA,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void saveVendedorRelacionesWithConnection(Vendedor vendedor,List<NotaCreditoSoli> notacreditosolis,List<ComisionVentaCobro> comisionventacobros,List<Vendedor> vendedors,List<Cliente> clientes,List<ComisionGrupo> comisiongrupos,List<ComisionLinea> comisionlineas,List<VendedorZona> vendedorzonas,List<ComisionCate> comisioncates,List<CajeroTurno> cajeroturnos,List<ComisionMarca> comisionmarcas,List<PresupuestoVentas> presupuestoventass,List<PresupuestoVentasLineas> presupuestoventaslineass) throws Exception {

		if(!vendedor.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveVendedorRelacionesBase(vendedor,notacreditosolis,comisionventacobros,vendedors,clientes,comisiongrupos,comisionlineas,vendedorzonas,comisioncates,cajeroturnos,comisionmarcas,presupuestoventass,presupuestoventaslineass,true);
		}
	}

	public void saveVendedorRelaciones(Vendedor vendedor,List<NotaCreditoSoli> notacreditosolis,List<ComisionVentaCobro> comisionventacobros,List<Vendedor> vendedors,List<Cliente> clientes,List<ComisionGrupo> comisiongrupos,List<ComisionLinea> comisionlineas,List<VendedorZona> vendedorzonas,List<ComisionCate> comisioncates,List<CajeroTurno> cajeroturnos,List<ComisionMarca> comisionmarcas,List<PresupuestoVentas> presupuestoventass,List<PresupuestoVentasLineas> presupuestoventaslineass)throws Exception {

		if(!vendedor.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveVendedorRelacionesBase(vendedor,notacreditosolis,comisionventacobros,vendedors,clientes,comisiongrupos,comisionlineas,vendedorzonas,comisioncates,cajeroturnos,comisionmarcas,presupuestoventass,presupuestoventaslineass,false);
		}
	}

	public void saveVendedorRelacionesBase(Vendedor vendedor,List<NotaCreditoSoli> notacreditosolis,List<ComisionVentaCobro> comisionventacobros,List<Vendedor> vendedors,List<Cliente> clientes,List<ComisionGrupo> comisiongrupos,List<ComisionLinea> comisionlineas,List<VendedorZona> vendedorzonas,List<ComisionCate> comisioncates,List<CajeroTurno> cajeroturnos,List<ComisionMarca> comisionmarcas,List<PresupuestoVentas> presupuestoventass,List<PresupuestoVentasLineas> presupuestoventaslineass,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("Vendedor-saveRelacionesWithConnection");}
	
			vendedor.setNotaCreditoSolis(notacreditosolis);
			vendedor.setComisionVentaCobros(comisionventacobros);
			vendedor.setVendedors(vendedors);
			vendedor.setClientes(clientes);
			vendedor.setComisionGrupos(comisiongrupos);
			vendedor.setComisionLineas(comisionlineas);
			vendedor.setVendedorZonas(vendedorzonas);
			vendedor.setComisionCates(comisioncates);
			vendedor.setCajeroTurnos(cajeroturnos);
			vendedor.setComisionMarcas(comisionmarcas);
			vendedor.setPresupuestoVentass(presupuestoventass);
			vendedor.setPresupuestoVentasLineass(presupuestoventaslineass);

			this.setVendedor(vendedor);

			if(VendedorLogicAdditional.validarSaveRelaciones(vendedor,this)) {

				VendedorLogicAdditional.updateRelacionesToSave(vendedor,this);

				if((vendedor.getIsNew()||vendedor.getIsChanged())&&!vendedor.getIsDeleted()) {
					this.saveVendedor();
					this.saveVendedorRelacionesDetalles(notacreditosolis,comisionventacobros,vendedors,clientes,comisiongrupos,comisionlineas,vendedorzonas,comisioncates,cajeroturnos,comisionmarcas,presupuestoventass,presupuestoventaslineass);

				} else if(vendedor.getIsDeleted()) {
					this.saveVendedorRelacionesDetalles(notacreditosolis,comisionventacobros,vendedors,clientes,comisiongrupos,comisionlineas,vendedorzonas,comisioncates,cajeroturnos,comisionmarcas,presupuestoventass,presupuestoventaslineass);
					this.saveVendedor();
				}

				VendedorLogicAdditional.updateRelacionesToSaveAfter(vendedor,this);

			} else {
				throw new Exception("LOS DATOS SON INVALIDOS");
			}

			if(conConexion) {connexion.commit();}

		} catch(Exception e) {
			
			NotaCreditoSoliConstantesFunciones.InicializarGeneralEntityAuxiliaresNotaCreditoSolis(notacreditosolis,true,true);
			ComisionVentaCobroConstantesFunciones.InicializarGeneralEntityAuxiliaresComisionVentaCobros(comisionventacobros,true,true);
			VendedorConstantesFunciones.InicializarGeneralEntityAuxiliaresVendedors(vendedors,true,true);
			ClienteConstantesFunciones.InicializarGeneralEntityAuxiliaresClientes(clientes,true,true);
			ComisionGrupoConstantesFunciones.InicializarGeneralEntityAuxiliaresComisionGrupos(comisiongrupos,true,true);
			ComisionLineaConstantesFunciones.InicializarGeneralEntityAuxiliaresComisionLineas(comisionlineas,true,true);
			VendedorZonaConstantesFunciones.InicializarGeneralEntityAuxiliaresVendedorZonas(vendedorzonas,true,true);
			ComisionCateConstantesFunciones.InicializarGeneralEntityAuxiliaresComisionCates(comisioncates,true,true);
			CajeroTurnoConstantesFunciones.InicializarGeneralEntityAuxiliaresCajeroTurnos(cajeroturnos,true,true);
			ComisionMarcaConstantesFunciones.InicializarGeneralEntityAuxiliaresComisionMarcas(comisionmarcas,true,true);
			PresupuestoVentasConstantesFunciones.InicializarGeneralEntityAuxiliaresPresupuestoVentass(presupuestoventass,true,true);
			PresupuestoVentasLineasConstantesFunciones.InicializarGeneralEntityAuxiliaresPresupuestoVentasLineass(presupuestoventaslineass,true,true);

			if(conConexion){connexion.rollback();}
			Funciones.manageException(logger,e);
			throw e;

		} finally {
			if(conConexion){this.closeNewConnexionToDeep();}
		}
	}
	
	
	private void saveVendedorRelacionesDetalles(List<NotaCreditoSoli> notacreditosolis,List<ComisionVentaCobro> comisionventacobros,List<Vendedor> vendedors,List<Cliente> clientes,List<ComisionGrupo> comisiongrupos,List<ComisionLinea> comisionlineas,List<VendedorZona> vendedorzonas,List<ComisionCate> comisioncates,List<CajeroTurno> cajeroturnos,List<ComisionMarca> comisionmarcas,List<PresupuestoVentas> presupuestoventass,List<PresupuestoVentasLineas> presupuestoventaslineass)throws Exception {
		try {
	

			Long idVendedorActual=this.getVendedor().getId();

			NotaCreditoSoliLogic notacreditosoliLogic_Desde_Vendedor=new NotaCreditoSoliLogic();
			notacreditosoliLogic_Desde_Vendedor.setNotaCreditoSolis(notacreditosolis);

			notacreditosoliLogic_Desde_Vendedor.setConnexion(this.getConnexion());
			notacreditosoliLogic_Desde_Vendedor.setDatosCliente(this.datosCliente);

			for(NotaCreditoSoli notacreditosoli_Desde_Vendedor:notacreditosoliLogic_Desde_Vendedor.getNotaCreditoSolis()) {
				notacreditosoli_Desde_Vendedor.setid_vendedor(idVendedorActual);

				notacreditosoliLogic_Desde_Vendedor.setNotaCreditoSoli(notacreditosoli_Desde_Vendedor);
				notacreditosoliLogic_Desde_Vendedor.saveNotaCreditoSoli();

				Long idNotaCreditoSoliActual=notacreditosoli_Desde_Vendedor.getId();

				DetaNotaCreditoSoliLogic detanotacreditosoliLogic_Desde_NotaCreditoSoli=new DetaNotaCreditoSoliLogic();

				if(notacreditosoli_Desde_Vendedor.getDetaNotaCreditoSolis()==null){
					notacreditosoli_Desde_Vendedor.setDetaNotaCreditoSolis(new ArrayList<DetaNotaCreditoSoli>());
				}

				detanotacreditosoliLogic_Desde_NotaCreditoSoli.setDetaNotaCreditoSolis(notacreditosoli_Desde_Vendedor.getDetaNotaCreditoSolis());

				detanotacreditosoliLogic_Desde_NotaCreditoSoli.setConnexion(this.getConnexion());
				detanotacreditosoliLogic_Desde_NotaCreditoSoli.setDatosCliente(this.datosCliente);

				for(DetaNotaCreditoSoli detanotacreditosoli_Desde_NotaCreditoSoli:detanotacreditosoliLogic_Desde_NotaCreditoSoli.getDetaNotaCreditoSolis()) {
					detanotacreditosoli_Desde_NotaCreditoSoli.setid_nota_credito_soli(idNotaCreditoSoliActual);
				}

				detanotacreditosoliLogic_Desde_NotaCreditoSoli.saveDetaNotaCreditoSolis();
			}


			ComisionVentaCobroLogic comisionventacobroLogic_Desde_Vendedor=new ComisionVentaCobroLogic();
			comisionventacobroLogic_Desde_Vendedor.setComisionVentaCobros(comisionventacobros);

			comisionventacobroLogic_Desde_Vendedor.setConnexion(this.getConnexion());
			comisionventacobroLogic_Desde_Vendedor.setDatosCliente(this.datosCliente);

			for(ComisionVentaCobro comisionventacobro_Desde_Vendedor:comisionventacobroLogic_Desde_Vendedor.getComisionVentaCobros()) {
				comisionventacobro_Desde_Vendedor.setid_vendedor(idVendedorActual);
			}

			comisionventacobroLogic_Desde_Vendedor.saveComisionVentaCobros();

			VendedorLogic vendedorLogicHijos_Desde_Vendedor=new VendedorLogic();
			vendedorLogicHijos_Desde_Vendedor.setVendedors(vendedors);

			vendedorLogicHijos_Desde_Vendedor.setConnexion(this.getConnexion());
			vendedorLogicHijos_Desde_Vendedor.setDatosCliente(this.datosCliente);

			for(Vendedor vendedorHijos_Desde_Vendedor:vendedorLogicHijos_Desde_Vendedor.getVendedors()) {
				vendedorHijos_Desde_Vendedor.setid_vendedor(idVendedorActual);

				vendedorLogicHijos_Desde_Vendedor.setVendedor(vendedorHijos_Desde_Vendedor);
				vendedorLogicHijos_Desde_Vendedor.saveVendedor();
			}


			ClienteLogic clienteLogic_Desde_Vendedor=new ClienteLogic();
			clienteLogic_Desde_Vendedor.setClientes(clientes);

			clienteLogic_Desde_Vendedor.setConnexion(this.getConnexion());
			clienteLogic_Desde_Vendedor.setDatosCliente(this.datosCliente);

			for(Cliente cliente_Desde_Vendedor:clienteLogic_Desde_Vendedor.getClientes()) {
				cliente_Desde_Vendedor.setid_vendedor(idVendedorActual);

				clienteLogic_Desde_Vendedor.setCliente(cliente_Desde_Vendedor);
				clienteLogic_Desde_Vendedor.saveCliente();
			}


			ComisionGrupoLogic comisiongrupoLogic_Desde_Vendedor=new ComisionGrupoLogic();
			comisiongrupoLogic_Desde_Vendedor.setComisionGrupos(comisiongrupos);

			comisiongrupoLogic_Desde_Vendedor.setConnexion(this.getConnexion());
			comisiongrupoLogic_Desde_Vendedor.setDatosCliente(this.datosCliente);

			for(ComisionGrupo comisiongrupo_Desde_Vendedor:comisiongrupoLogic_Desde_Vendedor.getComisionGrupos()) {
				comisiongrupo_Desde_Vendedor.setid_vendedor(idVendedorActual);
			}

			comisiongrupoLogic_Desde_Vendedor.saveComisionGrupos();

			ComisionLineaLogic comisionlineaLogic_Desde_Vendedor=new ComisionLineaLogic();
			comisionlineaLogic_Desde_Vendedor.setComisionLineas(comisionlineas);

			comisionlineaLogic_Desde_Vendedor.setConnexion(this.getConnexion());
			comisionlineaLogic_Desde_Vendedor.setDatosCliente(this.datosCliente);

			for(ComisionLinea comisionlinea_Desde_Vendedor:comisionlineaLogic_Desde_Vendedor.getComisionLineas()) {
				comisionlinea_Desde_Vendedor.setid_vendedor(idVendedorActual);
			}

			comisionlineaLogic_Desde_Vendedor.saveComisionLineas();

			VendedorZonaLogic vendedorzonaLogic_Desde_Vendedor=new VendedorZonaLogic();
			vendedorzonaLogic_Desde_Vendedor.setVendedorZonas(vendedorzonas);

			vendedorzonaLogic_Desde_Vendedor.setConnexion(this.getConnexion());
			vendedorzonaLogic_Desde_Vendedor.setDatosCliente(this.datosCliente);

			for(VendedorZona vendedorzona_Desde_Vendedor:vendedorzonaLogic_Desde_Vendedor.getVendedorZonas()) {
				vendedorzona_Desde_Vendedor.setid_vendedor(idVendedorActual);
			}

			vendedorzonaLogic_Desde_Vendedor.saveVendedorZonas();

			ComisionCateLogic comisioncateLogic_Desde_Vendedor=new ComisionCateLogic();
			comisioncateLogic_Desde_Vendedor.setComisionCates(comisioncates);

			comisioncateLogic_Desde_Vendedor.setConnexion(this.getConnexion());
			comisioncateLogic_Desde_Vendedor.setDatosCliente(this.datosCliente);

			for(ComisionCate comisioncate_Desde_Vendedor:comisioncateLogic_Desde_Vendedor.getComisionCates()) {
				comisioncate_Desde_Vendedor.setid_vendedor(idVendedorActual);
			}

			comisioncateLogic_Desde_Vendedor.saveComisionCates();

			CajeroTurnoLogic cajeroturnoLogic_Desde_Vendedor=new CajeroTurnoLogic();
			cajeroturnoLogic_Desde_Vendedor.setCajeroTurnos(cajeroturnos);

			cajeroturnoLogic_Desde_Vendedor.setConnexion(this.getConnexion());
			cajeroturnoLogic_Desde_Vendedor.setDatosCliente(this.datosCliente);

			for(CajeroTurno cajeroturno_Desde_Vendedor:cajeroturnoLogic_Desde_Vendedor.getCajeroTurnos()) {
				cajeroturno_Desde_Vendedor.setid_vendedor(idVendedorActual);
			}

			cajeroturnoLogic_Desde_Vendedor.saveCajeroTurnos();

			ComisionMarcaLogic comisionmarcaLogic_Desde_Vendedor=new ComisionMarcaLogic();
			comisionmarcaLogic_Desde_Vendedor.setComisionMarcas(comisionmarcas);

			comisionmarcaLogic_Desde_Vendedor.setConnexion(this.getConnexion());
			comisionmarcaLogic_Desde_Vendedor.setDatosCliente(this.datosCliente);

			for(ComisionMarca comisionmarca_Desde_Vendedor:comisionmarcaLogic_Desde_Vendedor.getComisionMarcas()) {
				comisionmarca_Desde_Vendedor.setid_vendedor(idVendedorActual);
			}

			comisionmarcaLogic_Desde_Vendedor.saveComisionMarcas();

			PresupuestoVentasLogic presupuestoventasLogic_Desde_Vendedor=new PresupuestoVentasLogic();
			presupuestoventasLogic_Desde_Vendedor.setPresupuestoVentass(presupuestoventass);

			presupuestoventasLogic_Desde_Vendedor.setConnexion(this.getConnexion());
			presupuestoventasLogic_Desde_Vendedor.setDatosCliente(this.datosCliente);

			for(PresupuestoVentas presupuestoventas_Desde_Vendedor:presupuestoventasLogic_Desde_Vendedor.getPresupuestoVentass()) {
				presupuestoventas_Desde_Vendedor.setid_vendedor(idVendedorActual);
			}

			presupuestoventasLogic_Desde_Vendedor.savePresupuestoVentass();

			PresupuestoVentasLineasLogic presupuestoventaslineasLogic_Desde_Vendedor=new PresupuestoVentasLineasLogic();
			presupuestoventaslineasLogic_Desde_Vendedor.setPresupuestoVentasLineass(presupuestoventaslineass);

			presupuestoventaslineasLogic_Desde_Vendedor.setConnexion(this.getConnexion());
			presupuestoventaslineasLogic_Desde_Vendedor.setDatosCliente(this.datosCliente);

			for(PresupuestoVentasLineas presupuestoventaslineas_Desde_Vendedor:presupuestoventaslineasLogic_Desde_Vendedor.getPresupuestoVentasLineass()) {
				presupuestoventaslineas_Desde_Vendedor.setid_vendedor(idVendedorActual);
			}

			presupuestoventaslineasLogic_Desde_Vendedor.savePresupuestoVentasLineass();

		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfVendedor(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=VendedorConstantesFunciones.getClassesForeignKeysOfVendedor(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfVendedor(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=VendedorConstantesFunciones.getClassesRelationshipsOfVendedor(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}
