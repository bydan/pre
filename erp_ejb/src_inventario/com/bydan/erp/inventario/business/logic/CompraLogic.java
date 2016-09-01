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
import com.bydan.erp.inventario.util.CompraConstantesFunciones;
import com.bydan.erp.inventario.util.CompraParameterReturnGeneral;
//import com.bydan.erp.inventario.util.CompraParameterGeneral;
import com.bydan.erp.inventario.business.entity.Compra;
import com.bydan.erp.inventario.business.logic.CompraLogicAdditional;
import com.bydan.erp.inventario.business.dataaccess.*;
import com.bydan.erp.inventario.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.nomina.business.entity.*;
import com.bydan.erp.facturacion.business.entity.*;
import com.bydan.erp.sris.business.entity.*;
import com.bydan.erp.tesoreria.business.entity.*;


import com.bydan.erp.seguridad.business.logic.*;
import com.bydan.erp.contabilidad.business.logic.*;
import com.bydan.erp.cartera.business.logic.*;
import com.bydan.erp.nomina.business.logic.*;
import com.bydan.erp.facturacion.business.logic.*;
import com.bydan.erp.sris.business.logic.*;
import com.bydan.erp.tesoreria.business.logic.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.contabilidad.util.*;
import com.bydan.erp.cartera.util.*;
import com.bydan.erp.nomina.util.*;
import com.bydan.erp.facturacion.util.*;
import com.bydan.erp.sris.util.*;
import com.bydan.erp.tesoreria.util.*;


import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.contabilidad.business.dataaccess.*;
import com.bydan.erp.cartera.business.dataaccess.*;
import com.bydan.erp.nomina.business.dataaccess.*;
import com.bydan.erp.facturacion.business.dataaccess.*;
import com.bydan.erp.sris.business.dataaccess.*;
import com.bydan.erp.tesoreria.business.dataaccess.*;








@SuppressWarnings("unused")
public class CompraLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(CompraLogic.class);
	
	protected CompraDataAccess compraDataAccess; 	
	protected Compra compra;
	protected List<Compra> compras;
	protected Object compraObject;	
	protected List<Object> comprasObject;
	
	public static ClassValidator<Compra> compraValidator = new ClassValidator<Compra>(Compra.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected CompraLogicAdditional compraLogicAdditional=null;
	
	public CompraLogicAdditional getCompraLogicAdditional() {
		return this.compraLogicAdditional;
	}
	
	public void setCompraLogicAdditional(CompraLogicAdditional compraLogicAdditional) {
		try {
			this.compraLogicAdditional=compraLogicAdditional;
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
	
	
	
	
	public  CompraLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.compraDataAccess = new CompraDataAccess();
			
			this.compras= new ArrayList<Compra>();
			this.compra= new Compra();
			
			this.compraObject=new Object();
			this.comprasObject=new ArrayList<Object>();
				
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
			
			this.compraDataAccess.setConnexionType(this.connexionType);
			this.compraDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  CompraLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.compraDataAccess = new CompraDataAccess();
			this.compras= new ArrayList<Compra>();
			this.compra= new Compra();
			this.compraObject=new Object();
			this.comprasObject=new ArrayList<Object>();
			
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
			
			this.compraDataAccess.setConnexionType(this.connexionType);
			this.compraDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public Compra getCompra() throws Exception {	
		CompraLogicAdditional.checkCompraToGet(compra,this.datosCliente,this.arrDatoGeneral);
		CompraLogicAdditional.updateCompraToGet(compra,this.arrDatoGeneral);
		
		return compra;
	}
		
	public void setCompra(Compra newCompra) {
		this.compra = newCompra;
	}
	
	public CompraDataAccess getCompraDataAccess() {
		return compraDataAccess;
	}
	
	public void setCompraDataAccess(CompraDataAccess newcompraDataAccess) {
		this.compraDataAccess = newcompraDataAccess;
	}
	
	public List<Compra> getCompras() throws Exception {		
		this.quitarComprasNulos();
		
		CompraLogicAdditional.checkCompraToGets(compras,this.datosCliente,this.arrDatoGeneral);
		
		for (Compra compraLocal: compras ) {
			CompraLogicAdditional.updateCompraToGet(compraLocal,this.arrDatoGeneral);
		}
		
		return compras;
	}
	
	public void setCompras(List<Compra> newCompras) {
		this.compras = newCompras;
	}
	
	public Object getCompraObject() {	
		this.compraObject=this.compraDataAccess.getEntityObject();
		return this.compraObject;
	}
		
	public void setCompraObject(Object newCompraObject) {
		this.compraObject = newCompraObject;
	}
	
	public List<Object> getComprasObject() {		
		this.comprasObject=this.compraDataAccess.getEntitiesObject();
		return this.comprasObject;
	}
		
	public void setComprasObject(List<Object> newComprasObject) {
		this.comprasObject = newComprasObject;
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
		
		if(this.compraDataAccess!=null) {
			this.compraDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Compra.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			compraDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			compraDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		compra = new  Compra();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Compra.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			compra=compraDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.compra,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				CompraConstantesFunciones.refrescarForeignKeysDescripcionesCompra(this.compra);
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
		compra = new  Compra();
		  		  
        try {
			
			compra=compraDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.compra,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				CompraConstantesFunciones.refrescarForeignKeysDescripcionesCompra(this.compra);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		compra = new  Compra();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Compra.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			compra=compraDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.compra,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				CompraConstantesFunciones.refrescarForeignKeysDescripcionesCompra(this.compra);
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
		compra = new  Compra();
		  		  
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
		compra = new  Compra();
		  		  
        try {
			
			compra=compraDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.compra,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				CompraConstantesFunciones.refrescarForeignKeysDescripcionesCompra(this.compra);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		compra = new  Compra();
		  		  
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
		compra = new  Compra();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Compra.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =compraDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		compra = new  Compra();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=compraDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		compra = new  Compra();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Compra.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =compraDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		compra = new  Compra();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=compraDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		compra = new  Compra();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Compra.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =compraDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		compra = new  Compra();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=compraDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		compras = new  ArrayList<Compra>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Compra.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			CompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			compras=compraDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarCompra(compras);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				CompraConstantesFunciones.refrescarForeignKeysDescripcionesCompra(this.compras);
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
		compras = new  ArrayList<Compra>();
		  		  
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
		compras = new  ArrayList<Compra>();
		  		  
        try {			
			CompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			compras=compraDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarCompra(compras);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				CompraConstantesFunciones.refrescarForeignKeysDescripcionesCompra(this.compras);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		compras = new  ArrayList<Compra>();
		  		  
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
		compras = new  ArrayList<Compra>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Compra.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			CompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			compras=compraDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarCompra(compras);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				CompraConstantesFunciones.refrescarForeignKeysDescripcionesCompra(this.compras);
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
		compras = new  ArrayList<Compra>();
		  		  
        try {
			CompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			compras=compraDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarCompra(compras);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				CompraConstantesFunciones.refrescarForeignKeysDescripcionesCompra(this.compras);
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
		compras = new  ArrayList<Compra>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Compra.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			CompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			compras=compraDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarCompra(compras);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				CompraConstantesFunciones.refrescarForeignKeysDescripcionesCompra(this.compras);
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
		compras = new  ArrayList<Compra>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			CompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			compras=compraDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarCompra(compras);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				CompraConstantesFunciones.refrescarForeignKeysDescripcionesCompra(this.compras);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		compra = new  Compra();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Compra.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			CompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			compra=compraDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarCompra(compra);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				CompraConstantesFunciones.refrescarForeignKeysDescripcionesCompra(this.compra);
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
		compra = new  Compra();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			CompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			compra=compraDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarCompra(compra);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				CompraConstantesFunciones.refrescarForeignKeysDescripcionesCompra(this.compra);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		compras = new  ArrayList<Compra>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Compra.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			CompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			compras=compraDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarCompra(compras);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				CompraConstantesFunciones.refrescarForeignKeysDescripcionesCompra(this.compras);
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
		compras = new  ArrayList<Compra>();
		  		  
        try {
			CompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			compras=compraDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarCompra(compras);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				CompraConstantesFunciones.refrescarForeignKeysDescripcionesCompra(this.compras);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosComprasWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		compras = new  ArrayList<Compra>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Compra.class.getSimpleName()+"-getTodosComprasWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			CompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			compras=compraDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarCompra(compras);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				CompraConstantesFunciones.refrescarForeignKeysDescripcionesCompra(this.compras);
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
	
	public  void  getTodosCompras(String sFinalQuery,Pagination pagination)throws Exception {
		compras = new  ArrayList<Compra>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			CompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			compras=compraDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarCompra(compras);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				CompraConstantesFunciones.refrescarForeignKeysDescripcionesCompra(this.compras);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarCompra(Compra compra) throws Exception {
		Boolean estaValidado=false;
		
		if(compra.getIsNew() || compra.getIsChanged()) { 
			this.invalidValues = compraValidator.getInvalidValues(compra);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(compra);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarCompra(List<Compra> Compras) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(Compra compraLocal:compras) {				
			estaValidadoObjeto=this.validarGuardarCompra(compraLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarCompra(List<Compra> Compras) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarCompra(compras)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarCompra(Compra Compra) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarCompra(compra)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(Compra compra) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+compra.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=CompraConstantesFunciones.getCompraLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"compra","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(CompraConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(CompraConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveCompraWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Compra.class.getSimpleName()+"-saveCompraWithConnection");connexion.begin();			
			
			CompraLogicAdditional.checkCompraToSave(this.compra,this.datosCliente,connexion,this.arrDatoGeneral);
			
			CompraLogicAdditional.updateCompraToSave(this.compra,this.arrDatoGeneral);
			
			CompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.compra,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowCompra();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarCompra(this.compra)) {
				CompraDataAccess.save(this.compra, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.compra,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			CompraLogicAdditional.checkCompraToSaveAfter(this.compra,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowCompra();
			
			connexion.commit();			
			
			if(this.compra.getIsDeleted()) {
				this.compra=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveCompra()throws Exception {	
		try {	
			
			CompraLogicAdditional.checkCompraToSave(this.compra,this.datosCliente,connexion,this.arrDatoGeneral);
			
			CompraLogicAdditional.updateCompraToSave(this.compra,this.arrDatoGeneral);
			
			CompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.compra,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarCompra(this.compra)) {			
				CompraDataAccess.save(this.compra, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.compra,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			CompraLogicAdditional.checkCompraToSaveAfter(this.compra,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.compra.getIsDeleted()) {
				this.compra=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveComprasWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Compra.class.getSimpleName()+"-saveComprasWithConnection");connexion.begin();			
			
			CompraLogicAdditional.checkCompraToSaves(compras,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowCompras();
			
			Boolean validadoTodosCompra=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(Compra compraLocal:compras) {		
				if(compraLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				CompraLogicAdditional.updateCompraToSave(compraLocal,this.arrDatoGeneral);
	        	
				CompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),compraLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarCompra(compraLocal)) {
					CompraDataAccess.save(compraLocal, connexion);				
				} else {
					validadoTodosCompra=false;
				}
			}
			
			if(!validadoTodosCompra) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			CompraLogicAdditional.checkCompraToSavesAfter(compras,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowCompras();
			
			connexion.commit();		
			
			this.quitarComprasEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveCompras()throws Exception {				
		 try {	
			CompraLogicAdditional.checkCompraToSaves(compras,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosCompra=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(Compra compraLocal:compras) {				
				if(compraLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				CompraLogicAdditional.updateCompraToSave(compraLocal,this.arrDatoGeneral);
	        	
				CompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),compraLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarCompra(compraLocal)) {				
					CompraDataAccess.save(compraLocal, connexion);				
				} else {
					validadoTodosCompra=false;
				}
			}
			
			if(!validadoTodosCompra) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			CompraLogicAdditional.checkCompraToSavesAfter(compras,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarComprasEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public CompraParameterReturnGeneral procesarAccionCompras(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<Compra> compras,CompraParameterReturnGeneral compraParameterGeneral)throws Exception {
		 try {	
			CompraParameterReturnGeneral compraReturnGeneral=new CompraParameterReturnGeneral();
	
			CompraLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,compras,compraParameterGeneral,compraReturnGeneral);
			
			return compraReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public CompraParameterReturnGeneral procesarAccionComprasWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<Compra> compras,CompraParameterReturnGeneral compraParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Compra.class.getSimpleName()+"-procesarAccionComprasWithConnection");connexion.begin();			
			
			CompraParameterReturnGeneral compraReturnGeneral=new CompraParameterReturnGeneral();
	
			CompraLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,compras,compraParameterGeneral,compraReturnGeneral);
			
			this.connexion.commit();
			
			return compraReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public CompraParameterReturnGeneral procesarEventosCompras(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<Compra> compras,Compra compra,CompraParameterReturnGeneral compraParameterGeneral,Boolean isEsNuevoCompra,ArrayList<Classe> clases)throws Exception {
		 try {	
			CompraParameterReturnGeneral compraReturnGeneral=new CompraParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				compraReturnGeneral.setConRecargarPropiedades(true);
			}
			
			CompraLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,compras,compra,compraParameterGeneral,compraReturnGeneral,isEsNuevoCompra,clases);
			
			return compraReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public CompraParameterReturnGeneral procesarEventosComprasWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<Compra> compras,Compra compra,CompraParameterReturnGeneral compraParameterGeneral,Boolean isEsNuevoCompra,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Compra.class.getSimpleName()+"-procesarEventosComprasWithConnection");connexion.begin();			
			
			CompraParameterReturnGeneral compraReturnGeneral=new CompraParameterReturnGeneral();
	
			compraReturnGeneral.setCompra(compra);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				compraReturnGeneral.setConRecargarPropiedades(true);
			}
			
			CompraLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,compras,compra,compraParameterGeneral,compraReturnGeneral,isEsNuevoCompra,clases);
			
			this.connexion.commit();
			
			return compraReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public CompraParameterReturnGeneral procesarImportacionComprasWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,CompraParameterReturnGeneral compraParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Compra.class.getSimpleName()+"-procesarImportacionComprasWithConnection");connexion.begin();			
			
			CompraParameterReturnGeneral compraReturnGeneral=new CompraParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.compras=new ArrayList<Compra>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.compra=new Compra();
				
				
				if(conColumnasBase) {this.compra.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.compra.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.compra.setfecha_emision(Funciones.ConvertToDate(arrColumnas[iColumn++]));
				this.compra.setfecha_entrega(Funciones.ConvertToDate(arrColumnas[iColumn++]));
				this.compra.setnumero_secuencial(arrColumnas[iColumn++]);
				this.compra.setnumero_factura(arrColumnas[iColumn++]);
				this.compra.setdescripcion(arrColumnas[iColumn++]);
				this.compra.setautori_usuario(arrColumnas[iColumn++]);
				this.compra.setfactura_inicial(arrColumnas[iColumn++]);
				this.compra.setfactura_final(arrColumnas[iColumn++]);
				this.compra.setservicio_documento(arrColumnas[iColumn++]);
				this.compra.setfecha_valor(Funciones.ConvertToDate(arrColumnas[iColumn++]));
				this.compra.setporcentaje_descuento(Double.parseDouble(arrColumnas[iColumn++]));
				this.compra.setsuman(Double.parseDouble(arrColumnas[iColumn++]));
				this.compra.setice(Double.parseDouble(arrColumnas[iColumn++]));
				this.compra.setvalor_descuento(Double.parseDouble(arrColumnas[iColumn++]));
				this.compra.settotal_descuento(Double.parseDouble(arrColumnas[iColumn++]));
				this.compra.setiva(Double.parseDouble(arrColumnas[iColumn++]));
				this.compra.setstock(Double.parseDouble(arrColumnas[iColumn++]));
				this.compra.setsub_total(Double.parseDouble(arrColumnas[iColumn++]));
				this.compra.settotal_otro(Double.parseDouble(arrColumnas[iColumn++]));
				this.compra.setultimo_costo(Double.parseDouble(arrColumnas[iColumn++]));
				this.compra.setnumero_items(Integer.parseInt(arrColumnas[iColumn++]));
				this.compra.setretencion(Double.parseDouble(arrColumnas[iColumn++]));
				this.compra.settotal(Double.parseDouble(arrColumnas[iColumn++]));
				
				this.compras.add(this.compra);
			}
			
			this.saveCompras();
			
			this.connexion.commit();
			
			compraReturnGeneral.setConRetornoEstaProcesado(true);
			compraReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return compraReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarComprasEliminados() throws Exception {				
		
		List<Compra> comprasAux= new ArrayList<Compra>();
		
		for(Compra compra:compras) {
			if(!compra.getIsDeleted()) {
				comprasAux.add(compra);
			}
		}
		
		compras=comprasAux;
	}
	
	public void quitarComprasNulos() throws Exception {				
		
		List<Compra> comprasAux= new ArrayList<Compra>();
		
		for(Compra compra : this.compras) {
			if(compra==null) {
				comprasAux.add(compra);
			}
		}
		
		//this.compras=comprasAux;
		
		this.compras.removeAll(comprasAux);
	}
	
	public void getSetVersionRowCompraWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(compra.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((compra.getIsDeleted() || (compra.getIsChanged()&&!compra.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=compraDataAccess.getSetVersionRowCompra(connexion,compra.getId());
				
				if(!compra.getVersionRow().equals(timestamp)) {	
					compra.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				compra.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowCompra()throws Exception {	
		
		if(compra.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((compra.getIsDeleted() || (compra.getIsChanged()&&!compra.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=compraDataAccess.getSetVersionRowCompra(connexion,compra.getId());
			
			try {							
				if(!compra.getVersionRow().equals(timestamp)) {	
					compra.setVersionRow(timestamp);
				}
				
				compra.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowComprasWithConnection()throws Exception {	
		if(compras!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(Compra compraAux:compras) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(compraAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(compraAux.getIsDeleted() || (compraAux.getIsChanged()&&!compraAux.getIsNew())) {
						
						timestamp=compraDataAccess.getSetVersionRowCompra(connexion,compraAux.getId());
						
						if(!compra.getVersionRow().equals(timestamp)) {	
							compraAux.setVersionRow(timestamp);
						}
								
						compraAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowCompras()throws Exception {	
		if(compras!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(Compra compraAux:compras) {
					if(compraAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(compraAux.getIsDeleted() || (compraAux.getIsChanged()&&!compraAux.getIsNew())) {
						
						timestamp=compraDataAccess.getSetVersionRowCompra(connexion,compraAux.getId());
						
						if(!compraAux.getVersionRow().equals(timestamp)) {	
							compraAux.setVersionRow(timestamp);
						}
						
													
						compraAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public CompraParameterReturnGeneral cargarCombosLoteForeignKeyCompraWithConnection(String finalQueryGlobalEmpresa,String finalQueryGlobalSucursal,String finalQueryGlobalModulo,String finalQueryGlobalEjercicio,String finalQueryGlobalPeriodo,String finalQueryGlobalAnio,String finalQueryGlobalMes,String finalQueryGlobalUsuario,String finalQueryGlobalMoneda,String finalQueryGlobalTipoCambio,String finalQueryGlobalEstadoInventario,String finalQueryGlobalCliente,String finalQueryGlobalFormato,String finalQueryGlobalEmpleado,String finalQueryGlobalTransportista,String finalQueryGlobalOrdenCompra,String finalQueryGlobalPedidoCompra,String finalQueryGlobalTipoTransaccionModulo,String finalQueryGlobalAsientoContable) throws Exception {
		CompraParameterReturnGeneral  compraReturnGeneral =new CompraParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Compra.class.getSimpleName()+"-cargarCombosLoteForeignKeyCompraWithConnection");connexion.begin();
			
			compraReturnGeneral =new CompraParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			compraReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Sucursal> sucursalsForeignKey=new ArrayList<Sucursal>();
			SucursalLogic sucursalLogic=new SucursalLogic();
			sucursalLogic.setConnexion(this.connexion);
			//sucursalLogic.getSucursalDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalSucursal.equals("NONE")) {
				sucursalLogic.getTodosSucursals(finalQueryGlobalSucursal,new Pagination());
				sucursalsForeignKey=sucursalLogic.getSucursals();
			}

			compraReturnGeneral.setsucursalsForeignKey(sucursalsForeignKey);


			List<Modulo> modulosForeignKey=new ArrayList<Modulo>();
			ModuloLogic moduloLogic=new ModuloLogic();
			moduloLogic.setConnexion(this.connexion);
			moduloLogic.getModuloDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalModulo.equals("NONE")) {
				moduloLogic.getTodosModulos(finalQueryGlobalModulo,new Pagination());
				modulosForeignKey=moduloLogic.getModulos();
			}

			compraReturnGeneral.setmodulosForeignKey(modulosForeignKey);


			List<Ejercicio> ejerciciosForeignKey=new ArrayList<Ejercicio>();
			EjercicioLogic ejercicioLogic=new EjercicioLogic();
			ejercicioLogic.setConnexion(this.connexion);
			//ejercicioLogic.getEjercicioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEjercicio.equals("NONE")) {
				ejercicioLogic.getTodosEjercicios(finalQueryGlobalEjercicio,new Pagination());
				ejerciciosForeignKey=ejercicioLogic.getEjercicios();
			}

			compraReturnGeneral.setejerciciosForeignKey(ejerciciosForeignKey);


			List<Periodo> periodosForeignKey=new ArrayList<Periodo>();
			PeriodoLogic periodoLogic=new PeriodoLogic();
			periodoLogic.setConnexion(this.connexion);
			//periodoLogic.getPeriodoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalPeriodo.equals("NONE")) {
				periodoLogic.getTodosPeriodos(finalQueryGlobalPeriodo,new Pagination());
				periodosForeignKey=periodoLogic.getPeriodos();
			}

			compraReturnGeneral.setperiodosForeignKey(periodosForeignKey);


			List<Anio> aniosForeignKey=new ArrayList<Anio>();
			AnioLogic anioLogic=new AnioLogic();
			anioLogic.setConnexion(this.connexion);
			anioLogic.getAnioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalAnio.equals("NONE")) {
				anioLogic.getTodosAnios(finalQueryGlobalAnio,new Pagination());
				aniosForeignKey=anioLogic.getAnios();
			}

			compraReturnGeneral.setaniosForeignKey(aniosForeignKey);


			List<Mes> messForeignKey=new ArrayList<Mes>();
			MesLogic mesLogic=new MesLogic();
			mesLogic.setConnexion(this.connexion);
			mesLogic.getMesDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalMes.equals("NONE")) {
				mesLogic.getTodosMess(finalQueryGlobalMes,new Pagination());
				messForeignKey=mesLogic.getMess();
			}

			compraReturnGeneral.setmessForeignKey(messForeignKey);


			List<Usuario> usuariosForeignKey=new ArrayList<Usuario>();
			UsuarioLogic usuarioLogic=new UsuarioLogic();
			usuarioLogic.setConnexion(this.connexion);
			//usuarioLogic.getUsuarioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalUsuario.equals("NONE")) {
				usuarioLogic.getTodosUsuarios(finalQueryGlobalUsuario,new Pagination());
				usuariosForeignKey=usuarioLogic.getUsuarios();
			}

			compraReturnGeneral.setusuariosForeignKey(usuariosForeignKey);


			List<Moneda> monedasForeignKey=new ArrayList<Moneda>();
			MonedaLogic monedaLogic=new MonedaLogic();
			monedaLogic.setConnexion(this.connexion);
			//monedaLogic.getMonedaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalMoneda.equals("NONE")) {
				monedaLogic.getTodosMonedas(finalQueryGlobalMoneda,new Pagination());
				monedasForeignKey=monedaLogic.getMonedas();
			}

			compraReturnGeneral.setmonedasForeignKey(monedasForeignKey);


			List<TipoCambio> tipocambiosForeignKey=new ArrayList<TipoCambio>();
			TipoCambioLogic tipocambioLogic=new TipoCambioLogic();
			tipocambioLogic.setConnexion(this.connexion);
			tipocambioLogic.getTipoCambioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoCambio.equals("NONE")) {
				tipocambioLogic.getTodosTipoCambios(finalQueryGlobalTipoCambio,new Pagination());
				tipocambiosForeignKey=tipocambioLogic.getTipoCambios();
			}

			compraReturnGeneral.settipocambiosForeignKey(tipocambiosForeignKey);


			List<EstadoInventario> estadoinventariosForeignKey=new ArrayList<EstadoInventario>();
			EstadoInventarioLogic estadoinventarioLogic=new EstadoInventarioLogic();
			estadoinventarioLogic.setConnexion(this.connexion);
			estadoinventarioLogic.getEstadoInventarioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEstadoInventario.equals("NONE")) {
				estadoinventarioLogic.getTodosEstadoInventarios(finalQueryGlobalEstadoInventario,new Pagination());
				estadoinventariosForeignKey=estadoinventarioLogic.getEstadoInventarios();
			}

			compraReturnGeneral.setestadoinventariosForeignKey(estadoinventariosForeignKey);


			List<Cliente> clientesForeignKey=new ArrayList<Cliente>();
			ClienteLogic clienteLogic=new ClienteLogic();
			clienteLogic.setConnexion(this.connexion);
			clienteLogic.getClienteDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCliente.equals("NONE")) {
				clienteLogic.getTodosClientes(finalQueryGlobalCliente,new Pagination());
				clientesForeignKey=clienteLogic.getClientes();
			}

			compraReturnGeneral.setclientesForeignKey(clientesForeignKey);


			List<Formato> formatosForeignKey=new ArrayList<Formato>();
			FormatoLogic formatoLogic=new FormatoLogic();
			formatoLogic.setConnexion(this.connexion);
			formatoLogic.getFormatoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalFormato.equals("NONE")) {
				formatoLogic.getTodosFormatos(finalQueryGlobalFormato,new Pagination());
				formatosForeignKey=formatoLogic.getFormatos();
			}

			compraReturnGeneral.setformatosForeignKey(formatosForeignKey);


			List<Empleado> empleadosForeignKey=new ArrayList<Empleado>();
			EmpleadoLogic empleadoLogic=new EmpleadoLogic();
			empleadoLogic.setConnexion(this.connexion);
			empleadoLogic.getEmpleadoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpleado.equals("NONE")) {
				empleadoLogic.getTodosEmpleados(finalQueryGlobalEmpleado,new Pagination());
				empleadosForeignKey=empleadoLogic.getEmpleados();
			}

			compraReturnGeneral.setempleadosForeignKey(empleadosForeignKey);


			List<Transportista> transportistasForeignKey=new ArrayList<Transportista>();
			TransportistaLogic transportistaLogic=new TransportistaLogic();
			transportistaLogic.setConnexion(this.connexion);
			transportistaLogic.getTransportistaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTransportista.equals("NONE")) {
				transportistaLogic.getTodosTransportistas(finalQueryGlobalTransportista,new Pagination());
				transportistasForeignKey=transportistaLogic.getTransportistas();
			}

			compraReturnGeneral.settransportistasForeignKey(transportistasForeignKey);


			List<OrdenCompra> ordencomprasForeignKey=new ArrayList<OrdenCompra>();
			OrdenCompraLogic ordencompraLogic=new OrdenCompraLogic();
			ordencompraLogic.setConnexion(this.connexion);
			ordencompraLogic.getOrdenCompraDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalOrdenCompra.equals("NONE")) {
				ordencompraLogic.getTodosOrdenCompras(finalQueryGlobalOrdenCompra,new Pagination());
				ordencomprasForeignKey=ordencompraLogic.getOrdenCompras();
			}

			compraReturnGeneral.setordencomprasForeignKey(ordencomprasForeignKey);


			List<PedidoCompra> pedidocomprasForeignKey=new ArrayList<PedidoCompra>();
			PedidoCompraLogic pedidocompraLogic=new PedidoCompraLogic();
			pedidocompraLogic.setConnexion(this.connexion);
			pedidocompraLogic.getPedidoCompraDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalPedidoCompra.equals("NONE")) {
				pedidocompraLogic.getTodosPedidoCompras(finalQueryGlobalPedidoCompra,new Pagination());
				pedidocomprasForeignKey=pedidocompraLogic.getPedidoCompras();
			}

			compraReturnGeneral.setpedidocomprasForeignKey(pedidocomprasForeignKey);


			List<TipoTransaccionModulo> tipotransaccionmodulosForeignKey=new ArrayList<TipoTransaccionModulo>();
			TipoTransaccionModuloLogic tipotransaccionmoduloLogic=new TipoTransaccionModuloLogic();
			tipotransaccionmoduloLogic.setConnexion(this.connexion);
			tipotransaccionmoduloLogic.getTipoTransaccionModuloDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoTransaccionModulo.equals("NONE")) {
				tipotransaccionmoduloLogic.getTodosTipoTransaccionModulos(finalQueryGlobalTipoTransaccionModulo,new Pagination());
				tipotransaccionmodulosForeignKey=tipotransaccionmoduloLogic.getTipoTransaccionModulos();
			}

			compraReturnGeneral.settipotransaccionmodulosForeignKey(tipotransaccionmodulosForeignKey);


			List<AsientoContable> asientocontablesForeignKey=new ArrayList<AsientoContable>();
			AsientoContableLogic asientocontableLogic=new AsientoContableLogic();
			asientocontableLogic.setConnexion(this.connexion);
			asientocontableLogic.getAsientoContableDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalAsientoContable.equals("NONE")) {
				asientocontableLogic.getTodosAsientoContables(finalQueryGlobalAsientoContable,new Pagination());
				asientocontablesForeignKey=asientocontableLogic.getAsientoContables();
			}

			compraReturnGeneral.setasientocontablesForeignKey(asientocontablesForeignKey);

			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
		
		return compraReturnGeneral;
	}
	
	public CompraParameterReturnGeneral cargarCombosLoteForeignKeyCompra(String finalQueryGlobalEmpresa,String finalQueryGlobalSucursal,String finalQueryGlobalModulo,String finalQueryGlobalEjercicio,String finalQueryGlobalPeriodo,String finalQueryGlobalAnio,String finalQueryGlobalMes,String finalQueryGlobalUsuario,String finalQueryGlobalMoneda,String finalQueryGlobalTipoCambio,String finalQueryGlobalEstadoInventario,String finalQueryGlobalCliente,String finalQueryGlobalFormato,String finalQueryGlobalEmpleado,String finalQueryGlobalTransportista,String finalQueryGlobalOrdenCompra,String finalQueryGlobalPedidoCompra,String finalQueryGlobalTipoTransaccionModulo,String finalQueryGlobalAsientoContable) throws Exception {
		CompraParameterReturnGeneral  compraReturnGeneral =new CompraParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {						
			compraReturnGeneral =new CompraParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			compraReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Sucursal> sucursalsForeignKey=new ArrayList<Sucursal>();
			SucursalLogic sucursalLogic=new SucursalLogic();
			sucursalLogic.setConnexion(this.connexion);
			//sucursalLogic.getSucursalDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalSucursal.equals("NONE")) {
				sucursalLogic.getTodosSucursals(finalQueryGlobalSucursal,new Pagination());
				sucursalsForeignKey=sucursalLogic.getSucursals();
			}

			compraReturnGeneral.setsucursalsForeignKey(sucursalsForeignKey);


			List<Modulo> modulosForeignKey=new ArrayList<Modulo>();
			ModuloLogic moduloLogic=new ModuloLogic();
			moduloLogic.setConnexion(this.connexion);
			moduloLogic.getModuloDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalModulo.equals("NONE")) {
				moduloLogic.getTodosModulos(finalQueryGlobalModulo,new Pagination());
				modulosForeignKey=moduloLogic.getModulos();
			}

			compraReturnGeneral.setmodulosForeignKey(modulosForeignKey);


			List<Ejercicio> ejerciciosForeignKey=new ArrayList<Ejercicio>();
			EjercicioLogic ejercicioLogic=new EjercicioLogic();
			ejercicioLogic.setConnexion(this.connexion);
			//ejercicioLogic.getEjercicioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEjercicio.equals("NONE")) {
				ejercicioLogic.getTodosEjercicios(finalQueryGlobalEjercicio,new Pagination());
				ejerciciosForeignKey=ejercicioLogic.getEjercicios();
			}

			compraReturnGeneral.setejerciciosForeignKey(ejerciciosForeignKey);


			List<Periodo> periodosForeignKey=new ArrayList<Periodo>();
			PeriodoLogic periodoLogic=new PeriodoLogic();
			periodoLogic.setConnexion(this.connexion);
			//periodoLogic.getPeriodoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalPeriodo.equals("NONE")) {
				periodoLogic.getTodosPeriodos(finalQueryGlobalPeriodo,new Pagination());
				periodosForeignKey=periodoLogic.getPeriodos();
			}

			compraReturnGeneral.setperiodosForeignKey(periodosForeignKey);


			List<Anio> aniosForeignKey=new ArrayList<Anio>();
			AnioLogic anioLogic=new AnioLogic();
			anioLogic.setConnexion(this.connexion);
			anioLogic.getAnioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalAnio.equals("NONE")) {
				anioLogic.getTodosAnios(finalQueryGlobalAnio,new Pagination());
				aniosForeignKey=anioLogic.getAnios();
			}

			compraReturnGeneral.setaniosForeignKey(aniosForeignKey);


			List<Mes> messForeignKey=new ArrayList<Mes>();
			MesLogic mesLogic=new MesLogic();
			mesLogic.setConnexion(this.connexion);
			mesLogic.getMesDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalMes.equals("NONE")) {
				mesLogic.getTodosMess(finalQueryGlobalMes,new Pagination());
				messForeignKey=mesLogic.getMess();
			}

			compraReturnGeneral.setmessForeignKey(messForeignKey);


			List<Usuario> usuariosForeignKey=new ArrayList<Usuario>();
			UsuarioLogic usuarioLogic=new UsuarioLogic();
			usuarioLogic.setConnexion(this.connexion);
			//usuarioLogic.getUsuarioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalUsuario.equals("NONE")) {
				usuarioLogic.getTodosUsuarios(finalQueryGlobalUsuario,new Pagination());
				usuariosForeignKey=usuarioLogic.getUsuarios();
			}

			compraReturnGeneral.setusuariosForeignKey(usuariosForeignKey);


			List<Moneda> monedasForeignKey=new ArrayList<Moneda>();
			MonedaLogic monedaLogic=new MonedaLogic();
			monedaLogic.setConnexion(this.connexion);
			//monedaLogic.getMonedaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalMoneda.equals("NONE")) {
				monedaLogic.getTodosMonedas(finalQueryGlobalMoneda,new Pagination());
				monedasForeignKey=monedaLogic.getMonedas();
			}

			compraReturnGeneral.setmonedasForeignKey(monedasForeignKey);


			List<TipoCambio> tipocambiosForeignKey=new ArrayList<TipoCambio>();
			TipoCambioLogic tipocambioLogic=new TipoCambioLogic();
			tipocambioLogic.setConnexion(this.connexion);
			tipocambioLogic.getTipoCambioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoCambio.equals("NONE")) {
				tipocambioLogic.getTodosTipoCambios(finalQueryGlobalTipoCambio,new Pagination());
				tipocambiosForeignKey=tipocambioLogic.getTipoCambios();
			}

			compraReturnGeneral.settipocambiosForeignKey(tipocambiosForeignKey);


			List<EstadoInventario> estadoinventariosForeignKey=new ArrayList<EstadoInventario>();
			EstadoInventarioLogic estadoinventarioLogic=new EstadoInventarioLogic();
			estadoinventarioLogic.setConnexion(this.connexion);
			estadoinventarioLogic.getEstadoInventarioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEstadoInventario.equals("NONE")) {
				estadoinventarioLogic.getTodosEstadoInventarios(finalQueryGlobalEstadoInventario,new Pagination());
				estadoinventariosForeignKey=estadoinventarioLogic.getEstadoInventarios();
			}

			compraReturnGeneral.setestadoinventariosForeignKey(estadoinventariosForeignKey);


			List<Cliente> clientesForeignKey=new ArrayList<Cliente>();
			ClienteLogic clienteLogic=new ClienteLogic();
			clienteLogic.setConnexion(this.connexion);
			clienteLogic.getClienteDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCliente.equals("NONE")) {
				clienteLogic.getTodosClientes(finalQueryGlobalCliente,new Pagination());
				clientesForeignKey=clienteLogic.getClientes();
			}

			compraReturnGeneral.setclientesForeignKey(clientesForeignKey);


			List<Formato> formatosForeignKey=new ArrayList<Formato>();
			FormatoLogic formatoLogic=new FormatoLogic();
			formatoLogic.setConnexion(this.connexion);
			formatoLogic.getFormatoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalFormato.equals("NONE")) {
				formatoLogic.getTodosFormatos(finalQueryGlobalFormato,new Pagination());
				formatosForeignKey=formatoLogic.getFormatos();
			}

			compraReturnGeneral.setformatosForeignKey(formatosForeignKey);


			List<Empleado> empleadosForeignKey=new ArrayList<Empleado>();
			EmpleadoLogic empleadoLogic=new EmpleadoLogic();
			empleadoLogic.setConnexion(this.connexion);
			empleadoLogic.getEmpleadoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpleado.equals("NONE")) {
				empleadoLogic.getTodosEmpleados(finalQueryGlobalEmpleado,new Pagination());
				empleadosForeignKey=empleadoLogic.getEmpleados();
			}

			compraReturnGeneral.setempleadosForeignKey(empleadosForeignKey);


			List<Transportista> transportistasForeignKey=new ArrayList<Transportista>();
			TransportistaLogic transportistaLogic=new TransportistaLogic();
			transportistaLogic.setConnexion(this.connexion);
			transportistaLogic.getTransportistaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTransportista.equals("NONE")) {
				transportistaLogic.getTodosTransportistas(finalQueryGlobalTransportista,new Pagination());
				transportistasForeignKey=transportistaLogic.getTransportistas();
			}

			compraReturnGeneral.settransportistasForeignKey(transportistasForeignKey);


			List<OrdenCompra> ordencomprasForeignKey=new ArrayList<OrdenCompra>();
			OrdenCompraLogic ordencompraLogic=new OrdenCompraLogic();
			ordencompraLogic.setConnexion(this.connexion);
			ordencompraLogic.getOrdenCompraDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalOrdenCompra.equals("NONE")) {
				ordencompraLogic.getTodosOrdenCompras(finalQueryGlobalOrdenCompra,new Pagination());
				ordencomprasForeignKey=ordencompraLogic.getOrdenCompras();
			}

			compraReturnGeneral.setordencomprasForeignKey(ordencomprasForeignKey);


			List<PedidoCompra> pedidocomprasForeignKey=new ArrayList<PedidoCompra>();
			PedidoCompraLogic pedidocompraLogic=new PedidoCompraLogic();
			pedidocompraLogic.setConnexion(this.connexion);
			pedidocompraLogic.getPedidoCompraDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalPedidoCompra.equals("NONE")) {
				pedidocompraLogic.getTodosPedidoCompras(finalQueryGlobalPedidoCompra,new Pagination());
				pedidocomprasForeignKey=pedidocompraLogic.getPedidoCompras();
			}

			compraReturnGeneral.setpedidocomprasForeignKey(pedidocomprasForeignKey);


			List<TipoTransaccionModulo> tipotransaccionmodulosForeignKey=new ArrayList<TipoTransaccionModulo>();
			TipoTransaccionModuloLogic tipotransaccionmoduloLogic=new TipoTransaccionModuloLogic();
			tipotransaccionmoduloLogic.setConnexion(this.connexion);
			tipotransaccionmoduloLogic.getTipoTransaccionModuloDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoTransaccionModulo.equals("NONE")) {
				tipotransaccionmoduloLogic.getTodosTipoTransaccionModulos(finalQueryGlobalTipoTransaccionModulo,new Pagination());
				tipotransaccionmodulosForeignKey=tipotransaccionmoduloLogic.getTipoTransaccionModulos();
			}

			compraReturnGeneral.settipotransaccionmodulosForeignKey(tipotransaccionmodulosForeignKey);


			List<AsientoContable> asientocontablesForeignKey=new ArrayList<AsientoContable>();
			AsientoContableLogic asientocontableLogic=new AsientoContableLogic();
			asientocontableLogic.setConnexion(this.connexion);
			asientocontableLogic.getAsientoContableDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalAsientoContable.equals("NONE")) {
				asientocontableLogic.getTodosAsientoContables(finalQueryGlobalAsientoContable,new Pagination());
				asientocontablesForeignKey=asientocontableLogic.getAsientoContables();
			}

			compraReturnGeneral.setasientocontablesForeignKey(asientocontablesForeignKey);
						
			
		} catch(Exception e) {			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			
		}
		
		return compraReturnGeneral;
	}
	
	public void cargarRelacionesLoteForeignKeyCompraWithConnection() throws Exception {
		ArrayList<Classe> classes=new ArrayList<Classe>();		
		
		
			RetencionInvenLogic retencioninvenLogic=new RetencionInvenLogic();
			TransaccionLocalLogic transaccionlocalLogic=new TransaccionLocalLogic();
			FormaPagoInvenLogic formapagoinvenLogic=new FormaPagoInvenLogic();
			DetalleCompraLogic detallecompraLogic=new DetalleCompraLogic();
		
		try {
			
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Compra.class.getSimpleName()+"-cargarRelacionesLoteForeignKeyCompraWithConnection");connexion.begin();
			
			
			classes.add(new Classe(RetencionInven.class));
			classes.add(new Classe(TransaccionLocal.class));
			classes.add(new Classe(FormaPagoInven.class));
			classes.add(new Classe(DetalleCompra.class));
											
			

			retencioninvenLogic.setConnexion(this.getConnexion());
			retencioninvenLogic.setDatosCliente(this.datosCliente);
			retencioninvenLogic.setIsConRefrescarForeignKeys(true);

			transaccionlocalLogic.setConnexion(this.getConnexion());
			transaccionlocalLogic.setDatosCliente(this.datosCliente);
			transaccionlocalLogic.setIsConRefrescarForeignKeys(true);

			formapagoinvenLogic.setConnexion(this.getConnexion());
			formapagoinvenLogic.setDatosCliente(this.datosCliente);
			formapagoinvenLogic.setIsConRefrescarForeignKeys(true);

			detallecompraLogic.setConnexion(this.getConnexion());
			detallecompraLogic.setDatosCliente(this.datosCliente);
			detallecompraLogic.setIsConRefrescarForeignKeys(true);
			
			this.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
			
			for(Compra compra:this.compras) {
				

				classes=new ArrayList<Classe>();
				classes=RetencionInvenConstantesFunciones.getClassesForeignKeysOfRetencionInven(new ArrayList<Classe>(),DeepLoadType.NONE);

				retencioninvenLogic.setRetencionInvens(compra.retencioninvens);
				retencioninvenLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");

				classes=new ArrayList<Classe>();
				classes=TransaccionLocalConstantesFunciones.getClassesForeignKeysOfTransaccionLocal(new ArrayList<Classe>(),DeepLoadType.NONE);

				transaccionlocalLogic.setTransaccionLocals(compra.transaccionlocals);
				transaccionlocalLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");

				classes=new ArrayList<Classe>();
				classes=FormaPagoInvenConstantesFunciones.getClassesForeignKeysOfFormaPagoInven(new ArrayList<Classe>(),DeepLoadType.NONE);

				formapagoinvenLogic.setFormaPagoInvens(compra.formapagoinvens);
				formapagoinvenLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");

				classes=new ArrayList<Classe>();
				classes=DetalleCompraConstantesFunciones.getClassesForeignKeysOfDetalleCompra(new ArrayList<Classe>(),DeepLoadType.NONE);

				detallecompraLogic.setDetalleCompras(compra.detallecompras);
				detallecompraLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
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
	
	public void deepLoad(Compra compra,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			CompraLogicAdditional.updateCompraToGet(compra,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		compra.setEmpresa(compraDataAccess.getEmpresa(connexion,compra));
		compra.setSucursal(compraDataAccess.getSucursal(connexion,compra));
		compra.setModulo(compraDataAccess.getModulo(connexion,compra));
		compra.setEjercicio(compraDataAccess.getEjercicio(connexion,compra));
		compra.setPeriodo(compraDataAccess.getPeriodo(connexion,compra));
		compra.setAnio(compraDataAccess.getAnio(connexion,compra));
		compra.setMes(compraDataAccess.getMes(connexion,compra));
		compra.setUsuario(compraDataAccess.getUsuario(connexion,compra));
		compra.setMoneda(compraDataAccess.getMoneda(connexion,compra));
		compra.setTipoCambio(compraDataAccess.getTipoCambio(connexion,compra));
		compra.setEstadoInventario(compraDataAccess.getEstadoInventario(connexion,compra));
		compra.setCliente(compraDataAccess.getCliente(connexion,compra));
		compra.setFormato(compraDataAccess.getFormato(connexion,compra));
		compra.setEmpleado(compraDataAccess.getEmpleado(connexion,compra));
		compra.setTransportista(compraDataAccess.getTransportista(connexion,compra));
		compra.setOrdenCompra(compraDataAccess.getOrdenCompra(connexion,compra));
		compra.setPedidoCompra(compraDataAccess.getPedidoCompra(connexion,compra));
		compra.setTipoTransaccionModulo(compraDataAccess.getTipoTransaccionModulo(connexion,compra));
		compra.setAsientoContable(compraDataAccess.getAsientoContable(connexion,compra));
		compra.setRetencionInvens(compraDataAccess.getRetencionInvens(connexion,compra));
		compra.setTransaccionLocals(compraDataAccess.getTransaccionLocals(connexion,compra));
		compra.setFormaPagoInvens(compraDataAccess.getFormaPagoInvens(connexion,compra));
		compra.setDetalleCompras(compraDataAccess.getDetalleCompras(connexion,compra));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				compra.setEmpresa(compraDataAccess.getEmpresa(connexion,compra));
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				compra.setSucursal(compraDataAccess.getSucursal(connexion,compra));
				continue;
			}

			if(clas.clas.equals(Modulo.class)) {
				compra.setModulo(compraDataAccess.getModulo(connexion,compra));
				continue;
			}

			if(clas.clas.equals(Ejercicio.class)) {
				compra.setEjercicio(compraDataAccess.getEjercicio(connexion,compra));
				continue;
			}

			if(clas.clas.equals(Periodo.class)) {
				compra.setPeriodo(compraDataAccess.getPeriodo(connexion,compra));
				continue;
			}

			if(clas.clas.equals(Anio.class)) {
				compra.setAnio(compraDataAccess.getAnio(connexion,compra));
				continue;
			}

			if(clas.clas.equals(Mes.class)) {
				compra.setMes(compraDataAccess.getMes(connexion,compra));
				continue;
			}

			if(clas.clas.equals(Usuario.class)) {
				compra.setUsuario(compraDataAccess.getUsuario(connexion,compra));
				continue;
			}

			if(clas.clas.equals(Moneda.class)) {
				compra.setMoneda(compraDataAccess.getMoneda(connexion,compra));
				continue;
			}

			if(clas.clas.equals(TipoCambio.class)) {
				compra.setTipoCambio(compraDataAccess.getTipoCambio(connexion,compra));
				continue;
			}

			if(clas.clas.equals(EstadoInventario.class)) {
				compra.setEstadoInventario(compraDataAccess.getEstadoInventario(connexion,compra));
				continue;
			}

			if(clas.clas.equals(Cliente.class)) {
				compra.setCliente(compraDataAccess.getCliente(connexion,compra));
				continue;
			}

			if(clas.clas.equals(Formato.class)) {
				compra.setFormato(compraDataAccess.getFormato(connexion,compra));
				continue;
			}

			if(clas.clas.equals(Empleado.class)) {
				compra.setEmpleado(compraDataAccess.getEmpleado(connexion,compra));
				continue;
			}

			if(clas.clas.equals(Transportista.class)) {
				compra.setTransportista(compraDataAccess.getTransportista(connexion,compra));
				continue;
			}

			if(clas.clas.equals(OrdenCompra.class)) {
				compra.setOrdenCompra(compraDataAccess.getOrdenCompra(connexion,compra));
				continue;
			}

			if(clas.clas.equals(PedidoCompra.class)) {
				compra.setPedidoCompra(compraDataAccess.getPedidoCompra(connexion,compra));
				continue;
			}

			if(clas.clas.equals(TipoTransaccionModulo.class)) {
				compra.setTipoTransaccionModulo(compraDataAccess.getTipoTransaccionModulo(connexion,compra));
				continue;
			}

			if(clas.clas.equals(AsientoContable.class)) {
				compra.setAsientoContable(compraDataAccess.getAsientoContable(connexion,compra));
				continue;
			}

			if(clas.clas.equals(RetencionInven.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				compra.setRetencionInvens(compraDataAccess.getRetencionInvens(connexion,compra));

				if(this.isConDeep) {
					RetencionInvenLogic retencioninvenLogic= new RetencionInvenLogic(this.connexion);
					retencioninvenLogic.setRetencionInvens(compra.getRetencionInvens());
					ArrayList<Classe> classesLocal=RetencionInvenConstantesFunciones.getClassesForeignKeysOfRetencionInven(new ArrayList<Classe>(),DeepLoadType.NONE);
					retencioninvenLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					RetencionInvenConstantesFunciones.refrescarForeignKeysDescripcionesRetencionInven(retencioninvenLogic.getRetencionInvens());
					compra.setRetencionInvens(retencioninvenLogic.getRetencionInvens());
				}

				continue;
			}

			if(clas.clas.equals(TransaccionLocal.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				compra.setTransaccionLocals(compraDataAccess.getTransaccionLocals(connexion,compra));

				if(this.isConDeep) {
					TransaccionLocalLogic transaccionlocalLogic= new TransaccionLocalLogic(this.connexion);
					transaccionlocalLogic.setTransaccionLocals(compra.getTransaccionLocals());
					ArrayList<Classe> classesLocal=TransaccionLocalConstantesFunciones.getClassesForeignKeysOfTransaccionLocal(new ArrayList<Classe>(),DeepLoadType.NONE);
					transaccionlocalLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					TransaccionLocalConstantesFunciones.refrescarForeignKeysDescripcionesTransaccionLocal(transaccionlocalLogic.getTransaccionLocals());
					compra.setTransaccionLocals(transaccionlocalLogic.getTransaccionLocals());
				}

				continue;
			}

			if(clas.clas.equals(FormaPagoInven.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				compra.setFormaPagoInvens(compraDataAccess.getFormaPagoInvens(connexion,compra));

				if(this.isConDeep) {
					FormaPagoInvenLogic formapagoinvenLogic= new FormaPagoInvenLogic(this.connexion);
					formapagoinvenLogic.setFormaPagoInvens(compra.getFormaPagoInvens());
					ArrayList<Classe> classesLocal=FormaPagoInvenConstantesFunciones.getClassesForeignKeysOfFormaPagoInven(new ArrayList<Classe>(),DeepLoadType.NONE);
					formapagoinvenLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					FormaPagoInvenConstantesFunciones.refrescarForeignKeysDescripcionesFormaPagoInven(formapagoinvenLogic.getFormaPagoInvens());
					compra.setFormaPagoInvens(formapagoinvenLogic.getFormaPagoInvens());
				}

				continue;
			}

			if(clas.clas.equals(DetalleCompra.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				compra.setDetalleCompras(compraDataAccess.getDetalleCompras(connexion,compra));

				if(this.isConDeep) {
					DetalleCompraLogic detallecompraLogic= new DetalleCompraLogic(this.connexion);
					detallecompraLogic.setDetalleCompras(compra.getDetalleCompras());
					ArrayList<Classe> classesLocal=DetalleCompraConstantesFunciones.getClassesForeignKeysOfDetalleCompra(new ArrayList<Classe>(),DeepLoadType.NONE);
					detallecompraLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					DetalleCompraConstantesFunciones.refrescarForeignKeysDescripcionesDetalleCompra(detallecompraLogic.getDetalleCompras());
					compra.setDetalleCompras(detallecompraLogic.getDetalleCompras());
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
			compra.setEmpresa(compraDataAccess.getEmpresa(connexion,compra));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			compra.setSucursal(compraDataAccess.getSucursal(connexion,compra));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Modulo.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			compra.setModulo(compraDataAccess.getModulo(connexion,compra));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Ejercicio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			compra.setEjercicio(compraDataAccess.getEjercicio(connexion,compra));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Periodo.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			compra.setPeriodo(compraDataAccess.getPeriodo(connexion,compra));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Anio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			compra.setAnio(compraDataAccess.getAnio(connexion,compra));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Mes.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			compra.setMes(compraDataAccess.getMes(connexion,compra));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Usuario.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			compra.setUsuario(compraDataAccess.getUsuario(connexion,compra));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Moneda.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			compra.setMoneda(compraDataAccess.getMoneda(connexion,compra));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(TipoCambio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			compra.setTipoCambio(compraDataAccess.getTipoCambio(connexion,compra));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(EstadoInventario.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			compra.setEstadoInventario(compraDataAccess.getEstadoInventario(connexion,compra));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Cliente.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			compra.setCliente(compraDataAccess.getCliente(connexion,compra));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Formato.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			compra.setFormato(compraDataAccess.getFormato(connexion,compra));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Empleado.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			compra.setEmpleado(compraDataAccess.getEmpleado(connexion,compra));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Transportista.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			compra.setTransportista(compraDataAccess.getTransportista(connexion,compra));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(OrdenCompra.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			compra.setOrdenCompra(compraDataAccess.getOrdenCompra(connexion,compra));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(PedidoCompra.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			compra.setPedidoCompra(compraDataAccess.getPedidoCompra(connexion,compra));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(TipoTransaccionModulo.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			compra.setTipoTransaccionModulo(compraDataAccess.getTipoTransaccionModulo(connexion,compra));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(AsientoContable.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			compra.setAsientoContable(compraDataAccess.getAsientoContable(connexion,compra));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(RetencionInven.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(RetencionInven.class));
			compra.setRetencionInvens(compraDataAccess.getRetencionInvens(connexion,compra));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(TransaccionLocal.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(TransaccionLocal.class));
			compra.setTransaccionLocals(compraDataAccess.getTransaccionLocals(connexion,compra));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(FormaPagoInven.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(FormaPagoInven.class));
			compra.setFormaPagoInvens(compraDataAccess.getFormaPagoInvens(connexion,compra));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(DetalleCompra.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(DetalleCompra.class));
			compra.setDetalleCompras(compraDataAccess.getDetalleCompras(connexion,compra));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		compra.setEmpresa(compraDataAccess.getEmpresa(connexion,compra));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(compra.getEmpresa(),isDeep,deepLoadType,clases);
				
		compra.setSucursal(compraDataAccess.getSucursal(connexion,compra));
		SucursalLogic sucursalLogic= new SucursalLogic(connexion);
		sucursalLogic.deepLoad(compra.getSucursal(),isDeep,deepLoadType,clases);
				
		compra.setModulo(compraDataAccess.getModulo(connexion,compra));
		ModuloLogic moduloLogic= new ModuloLogic(connexion);
		moduloLogic.deepLoad(compra.getModulo(),isDeep,deepLoadType,clases);
				
		compra.setEjercicio(compraDataAccess.getEjercicio(connexion,compra));
		EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
		ejercicioLogic.deepLoad(compra.getEjercicio(),isDeep,deepLoadType,clases);
				
		compra.setPeriodo(compraDataAccess.getPeriodo(connexion,compra));
		PeriodoLogic periodoLogic= new PeriodoLogic(connexion);
		periodoLogic.deepLoad(compra.getPeriodo(),isDeep,deepLoadType,clases);
				
		compra.setAnio(compraDataAccess.getAnio(connexion,compra));
		AnioLogic anioLogic= new AnioLogic(connexion);
		anioLogic.deepLoad(compra.getAnio(),isDeep,deepLoadType,clases);
				
		compra.setMes(compraDataAccess.getMes(connexion,compra));
		MesLogic mesLogic= new MesLogic(connexion);
		mesLogic.deepLoad(compra.getMes(),isDeep,deepLoadType,clases);
				
		compra.setUsuario(compraDataAccess.getUsuario(connexion,compra));
		UsuarioLogic usuarioLogic= new UsuarioLogic(connexion);
		usuarioLogic.deepLoad(compra.getUsuario(),isDeep,deepLoadType,clases);
				
		compra.setMoneda(compraDataAccess.getMoneda(connexion,compra));
		MonedaLogic monedaLogic= new MonedaLogic(connexion);
		monedaLogic.deepLoad(compra.getMoneda(),isDeep,deepLoadType,clases);
				
		compra.setTipoCambio(compraDataAccess.getTipoCambio(connexion,compra));
		TipoCambioLogic tipocambioLogic= new TipoCambioLogic(connexion);
		tipocambioLogic.deepLoad(compra.getTipoCambio(),isDeep,deepLoadType,clases);
				
		compra.setEstadoInventario(compraDataAccess.getEstadoInventario(connexion,compra));
		EstadoInventarioLogic estadoinventarioLogic= new EstadoInventarioLogic(connexion);
		estadoinventarioLogic.deepLoad(compra.getEstadoInventario(),isDeep,deepLoadType,clases);
				
		compra.setCliente(compraDataAccess.getCliente(connexion,compra));
		ClienteLogic clienteLogic= new ClienteLogic(connexion);
		clienteLogic.deepLoad(compra.getCliente(),isDeep,deepLoadType,clases);
				
		compra.setFormato(compraDataAccess.getFormato(connexion,compra));
		FormatoLogic formatoLogic= new FormatoLogic(connexion);
		formatoLogic.deepLoad(compra.getFormato(),isDeep,deepLoadType,clases);
				
		compra.setEmpleado(compraDataAccess.getEmpleado(connexion,compra));
		EmpleadoLogic empleadoLogic= new EmpleadoLogic(connexion);
		empleadoLogic.deepLoad(compra.getEmpleado(),isDeep,deepLoadType,clases);
				
		compra.setTransportista(compraDataAccess.getTransportista(connexion,compra));
		TransportistaLogic transportistaLogic= new TransportistaLogic(connexion);
		transportistaLogic.deepLoad(compra.getTransportista(),isDeep,deepLoadType,clases);
				
		compra.setOrdenCompra(compraDataAccess.getOrdenCompra(connexion,compra));
		OrdenCompraLogic ordencompraLogic= new OrdenCompraLogic(connexion);
		ordencompraLogic.deepLoad(compra.getOrdenCompra(),isDeep,deepLoadType,clases);
				
		compra.setPedidoCompra(compraDataAccess.getPedidoCompra(connexion,compra));
		PedidoCompraLogic pedidocompraLogic= new PedidoCompraLogic(connexion);
		pedidocompraLogic.deepLoad(compra.getPedidoCompra(),isDeep,deepLoadType,clases);
				
		compra.setTipoTransaccionModulo(compraDataAccess.getTipoTransaccionModulo(connexion,compra));
		TipoTransaccionModuloLogic tipotransaccionmoduloLogic= new TipoTransaccionModuloLogic(connexion);
		tipotransaccionmoduloLogic.deepLoad(compra.getTipoTransaccionModulo(),isDeep,deepLoadType,clases);
				
		compra.setAsientoContable(compraDataAccess.getAsientoContable(connexion,compra));
		AsientoContableLogic asientocontableLogic= new AsientoContableLogic(connexion);
		asientocontableLogic.deepLoad(compra.getAsientoContable(),isDeep,deepLoadType,clases);
				

		compra.setRetencionInvens(compraDataAccess.getRetencionInvens(connexion,compra));

		for(RetencionInven retencioninven:compra.getRetencionInvens()) {
			RetencionInvenLogic retencioninvenLogic= new RetencionInvenLogic(connexion);
			retencioninvenLogic.deepLoad(retencioninven,isDeep,deepLoadType,clases);
		}

		compra.setTransaccionLocals(compraDataAccess.getTransaccionLocals(connexion,compra));

		for(TransaccionLocal transaccionlocal:compra.getTransaccionLocals()) {
			TransaccionLocalLogic transaccionlocalLogic= new TransaccionLocalLogic(connexion);
			transaccionlocalLogic.deepLoad(transaccionlocal,isDeep,deepLoadType,clases);
		}

		compra.setFormaPagoInvens(compraDataAccess.getFormaPagoInvens(connexion,compra));

		for(FormaPagoInven formapagoinven:compra.getFormaPagoInvens()) {
			FormaPagoInvenLogic formapagoinvenLogic= new FormaPagoInvenLogic(connexion);
			formapagoinvenLogic.deepLoad(formapagoinven,isDeep,deepLoadType,clases);
		}

		compra.setDetalleCompras(compraDataAccess.getDetalleCompras(connexion,compra));

		for(DetalleCompra detallecompra:compra.getDetalleCompras()) {
			DetalleCompraLogic detallecompraLogic= new DetalleCompraLogic(connexion);
			detallecompraLogic.deepLoad(detallecompra,isDeep,deepLoadType,clases);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				compra.setEmpresa(compraDataAccess.getEmpresa(connexion,compra));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(compra.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				compra.setSucursal(compraDataAccess.getSucursal(connexion,compra));
				SucursalLogic sucursalLogic= new SucursalLogic(connexion);
				sucursalLogic.deepLoad(compra.getSucursal(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Modulo.class)) {
				compra.setModulo(compraDataAccess.getModulo(connexion,compra));
				ModuloLogic moduloLogic= new ModuloLogic(connexion);
				moduloLogic.deepLoad(compra.getModulo(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Ejercicio.class)) {
				compra.setEjercicio(compraDataAccess.getEjercicio(connexion,compra));
				EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
				ejercicioLogic.deepLoad(compra.getEjercicio(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Periodo.class)) {
				compra.setPeriodo(compraDataAccess.getPeriodo(connexion,compra));
				PeriodoLogic periodoLogic= new PeriodoLogic(connexion);
				periodoLogic.deepLoad(compra.getPeriodo(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Anio.class)) {
				compra.setAnio(compraDataAccess.getAnio(connexion,compra));
				AnioLogic anioLogic= new AnioLogic(connexion);
				anioLogic.deepLoad(compra.getAnio(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Mes.class)) {
				compra.setMes(compraDataAccess.getMes(connexion,compra));
				MesLogic mesLogic= new MesLogic(connexion);
				mesLogic.deepLoad(compra.getMes(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Usuario.class)) {
				compra.setUsuario(compraDataAccess.getUsuario(connexion,compra));
				UsuarioLogic usuarioLogic= new UsuarioLogic(connexion);
				usuarioLogic.deepLoad(compra.getUsuario(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Moneda.class)) {
				compra.setMoneda(compraDataAccess.getMoneda(connexion,compra));
				MonedaLogic monedaLogic= new MonedaLogic(connexion);
				monedaLogic.deepLoad(compra.getMoneda(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoCambio.class)) {
				compra.setTipoCambio(compraDataAccess.getTipoCambio(connexion,compra));
				TipoCambioLogic tipocambioLogic= new TipoCambioLogic(connexion);
				tipocambioLogic.deepLoad(compra.getTipoCambio(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(EstadoInventario.class)) {
				compra.setEstadoInventario(compraDataAccess.getEstadoInventario(connexion,compra));
				EstadoInventarioLogic estadoinventarioLogic= new EstadoInventarioLogic(connexion);
				estadoinventarioLogic.deepLoad(compra.getEstadoInventario(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Cliente.class)) {
				compra.setCliente(compraDataAccess.getCliente(connexion,compra));
				ClienteLogic clienteLogic= new ClienteLogic(connexion);
				clienteLogic.deepLoad(compra.getCliente(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Formato.class)) {
				compra.setFormato(compraDataAccess.getFormato(connexion,compra));
				FormatoLogic formatoLogic= new FormatoLogic(connexion);
				formatoLogic.deepLoad(compra.getFormato(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Empleado.class)) {
				compra.setEmpleado(compraDataAccess.getEmpleado(connexion,compra));
				EmpleadoLogic empleadoLogic= new EmpleadoLogic(connexion);
				empleadoLogic.deepLoad(compra.getEmpleado(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Transportista.class)) {
				compra.setTransportista(compraDataAccess.getTransportista(connexion,compra));
				TransportistaLogic transportistaLogic= new TransportistaLogic(connexion);
				transportistaLogic.deepLoad(compra.getTransportista(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(OrdenCompra.class)) {
				compra.setOrdenCompra(compraDataAccess.getOrdenCompra(connexion,compra));
				OrdenCompraLogic ordencompraLogic= new OrdenCompraLogic(connexion);
				ordencompraLogic.deepLoad(compra.getOrdenCompra(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(PedidoCompra.class)) {
				compra.setPedidoCompra(compraDataAccess.getPedidoCompra(connexion,compra));
				PedidoCompraLogic pedidocompraLogic= new PedidoCompraLogic(connexion);
				pedidocompraLogic.deepLoad(compra.getPedidoCompra(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoTransaccionModulo.class)) {
				compra.setTipoTransaccionModulo(compraDataAccess.getTipoTransaccionModulo(connexion,compra));
				TipoTransaccionModuloLogic tipotransaccionmoduloLogic= new TipoTransaccionModuloLogic(connexion);
				tipotransaccionmoduloLogic.deepLoad(compra.getTipoTransaccionModulo(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(AsientoContable.class)) {
				compra.setAsientoContable(compraDataAccess.getAsientoContable(connexion,compra));
				AsientoContableLogic asientocontableLogic= new AsientoContableLogic(connexion);
				asientocontableLogic.deepLoad(compra.getAsientoContable(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(RetencionInven.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				compra.setRetencionInvens(compraDataAccess.getRetencionInvens(connexion,compra));

				for(RetencionInven retencioninven:compra.getRetencionInvens()) {
					RetencionInvenLogic retencioninvenLogic= new RetencionInvenLogic(connexion);
					retencioninvenLogic.deepLoad(retencioninven,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(TransaccionLocal.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				compra.setTransaccionLocals(compraDataAccess.getTransaccionLocals(connexion,compra));

				for(TransaccionLocal transaccionlocal:compra.getTransaccionLocals()) {
					TransaccionLocalLogic transaccionlocalLogic= new TransaccionLocalLogic(connexion);
					transaccionlocalLogic.deepLoad(transaccionlocal,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(FormaPagoInven.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				compra.setFormaPagoInvens(compraDataAccess.getFormaPagoInvens(connexion,compra));

				for(FormaPagoInven formapagoinven:compra.getFormaPagoInvens()) {
					FormaPagoInvenLogic formapagoinvenLogic= new FormaPagoInvenLogic(connexion);
					formapagoinvenLogic.deepLoad(formapagoinven,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(DetalleCompra.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				compra.setDetalleCompras(compraDataAccess.getDetalleCompras(connexion,compra));

				for(DetalleCompra detallecompra:compra.getDetalleCompras()) {
					DetalleCompraLogic detallecompraLogic= new DetalleCompraLogic(connexion);
					detallecompraLogic.deepLoad(detallecompra,isDeep,deepLoadType,clases);
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
			compra.setEmpresa(compraDataAccess.getEmpresa(connexion,compra));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(compra.getEmpresa(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			compra.setSucursal(compraDataAccess.getSucursal(connexion,compra));
			SucursalLogic sucursalLogic= new SucursalLogic(connexion);
			sucursalLogic.deepLoad(compra.getSucursal(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Modulo.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			compra.setModulo(compraDataAccess.getModulo(connexion,compra));
			ModuloLogic moduloLogic= new ModuloLogic(connexion);
			moduloLogic.deepLoad(compra.getModulo(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Ejercicio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			compra.setEjercicio(compraDataAccess.getEjercicio(connexion,compra));
			EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
			ejercicioLogic.deepLoad(compra.getEjercicio(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Periodo.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			compra.setPeriodo(compraDataAccess.getPeriodo(connexion,compra));
			PeriodoLogic periodoLogic= new PeriodoLogic(connexion);
			periodoLogic.deepLoad(compra.getPeriodo(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Anio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			compra.setAnio(compraDataAccess.getAnio(connexion,compra));
			AnioLogic anioLogic= new AnioLogic(connexion);
			anioLogic.deepLoad(compra.getAnio(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Mes.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			compra.setMes(compraDataAccess.getMes(connexion,compra));
			MesLogic mesLogic= new MesLogic(connexion);
			mesLogic.deepLoad(compra.getMes(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Usuario.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			compra.setUsuario(compraDataAccess.getUsuario(connexion,compra));
			UsuarioLogic usuarioLogic= new UsuarioLogic(connexion);
			usuarioLogic.deepLoad(compra.getUsuario(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Moneda.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			compra.setMoneda(compraDataAccess.getMoneda(connexion,compra));
			MonedaLogic monedaLogic= new MonedaLogic(connexion);
			monedaLogic.deepLoad(compra.getMoneda(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(TipoCambio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			compra.setTipoCambio(compraDataAccess.getTipoCambio(connexion,compra));
			TipoCambioLogic tipocambioLogic= new TipoCambioLogic(connexion);
			tipocambioLogic.deepLoad(compra.getTipoCambio(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(EstadoInventario.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			compra.setEstadoInventario(compraDataAccess.getEstadoInventario(connexion,compra));
			EstadoInventarioLogic estadoinventarioLogic= new EstadoInventarioLogic(connexion);
			estadoinventarioLogic.deepLoad(compra.getEstadoInventario(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Cliente.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			compra.setCliente(compraDataAccess.getCliente(connexion,compra));
			ClienteLogic clienteLogic= new ClienteLogic(connexion);
			clienteLogic.deepLoad(compra.getCliente(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Formato.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			compra.setFormato(compraDataAccess.getFormato(connexion,compra));
			FormatoLogic formatoLogic= new FormatoLogic(connexion);
			formatoLogic.deepLoad(compra.getFormato(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Empleado.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			compra.setEmpleado(compraDataAccess.getEmpleado(connexion,compra));
			EmpleadoLogic empleadoLogic= new EmpleadoLogic(connexion);
			empleadoLogic.deepLoad(compra.getEmpleado(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Transportista.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			compra.setTransportista(compraDataAccess.getTransportista(connexion,compra));
			TransportistaLogic transportistaLogic= new TransportistaLogic(connexion);
			transportistaLogic.deepLoad(compra.getTransportista(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(OrdenCompra.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			compra.setOrdenCompra(compraDataAccess.getOrdenCompra(connexion,compra));
			OrdenCompraLogic ordencompraLogic= new OrdenCompraLogic(connexion);
			ordencompraLogic.deepLoad(compra.getOrdenCompra(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(PedidoCompra.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			compra.setPedidoCompra(compraDataAccess.getPedidoCompra(connexion,compra));
			PedidoCompraLogic pedidocompraLogic= new PedidoCompraLogic(connexion);
			pedidocompraLogic.deepLoad(compra.getPedidoCompra(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(TipoTransaccionModulo.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			compra.setTipoTransaccionModulo(compraDataAccess.getTipoTransaccionModulo(connexion,compra));
			TipoTransaccionModuloLogic tipotransaccionmoduloLogic= new TipoTransaccionModuloLogic(connexion);
			tipotransaccionmoduloLogic.deepLoad(compra.getTipoTransaccionModulo(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(AsientoContable.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			compra.setAsientoContable(compraDataAccess.getAsientoContable(connexion,compra));
			AsientoContableLogic asientocontableLogic= new AsientoContableLogic(connexion);
			asientocontableLogic.deepLoad(compra.getAsientoContable(),isDeep,deepLoadType,clases);
				
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(RetencionInven.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(RetencionInven.class));
			compra.setRetencionInvens(compraDataAccess.getRetencionInvens(connexion,compra));

			for(RetencionInven retencioninven:compra.getRetencionInvens()) {
				RetencionInvenLogic retencioninvenLogic= new RetencionInvenLogic(connexion);
				retencioninvenLogic.deepLoad(retencioninven,isDeep,deepLoadType,clases);
			}
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(TransaccionLocal.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(TransaccionLocal.class));
			compra.setTransaccionLocals(compraDataAccess.getTransaccionLocals(connexion,compra));

			for(TransaccionLocal transaccionlocal:compra.getTransaccionLocals()) {
				TransaccionLocalLogic transaccionlocalLogic= new TransaccionLocalLogic(connexion);
				transaccionlocalLogic.deepLoad(transaccionlocal,isDeep,deepLoadType,clases);
			}
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(FormaPagoInven.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(FormaPagoInven.class));
			compra.setFormaPagoInvens(compraDataAccess.getFormaPagoInvens(connexion,compra));

			for(FormaPagoInven formapagoinven:compra.getFormaPagoInvens()) {
				FormaPagoInvenLogic formapagoinvenLogic= new FormaPagoInvenLogic(connexion);
				formapagoinvenLogic.deepLoad(formapagoinven,isDeep,deepLoadType,clases);
			}
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(DetalleCompra.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(DetalleCompra.class));
			compra.setDetalleCompras(compraDataAccess.getDetalleCompras(connexion,compra));

			for(DetalleCompra detallecompra:compra.getDetalleCompras()) {
				DetalleCompraLogic detallecompraLogic= new DetalleCompraLogic(connexion);
				detallecompraLogic.deepLoad(detallecompra,isDeep,deepLoadType,clases);
			}
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(Compra compra,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			CompraLogicAdditional.updateCompraToSave(compra,this.arrDatoGeneral);
			
CompraDataAccess.save(compra, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(compra.getEmpresa(),connexion);

		SucursalDataAccess.save(compra.getSucursal(),connexion);

		ModuloDataAccess.save(compra.getModulo(),connexion);

		EjercicioDataAccess.save(compra.getEjercicio(),connexion);

		PeriodoDataAccess.save(compra.getPeriodo(),connexion);

		AnioDataAccess.save(compra.getAnio(),connexion);

		MesDataAccess.save(compra.getMes(),connexion);

		UsuarioDataAccess.save(compra.getUsuario(),connexion);

		MonedaDataAccess.save(compra.getMoneda(),connexion);

		TipoCambioDataAccess.save(compra.getTipoCambio(),connexion);

		EstadoInventarioDataAccess.save(compra.getEstadoInventario(),connexion);

		ClienteDataAccess.save(compra.getCliente(),connexion);

		FormatoDataAccess.save(compra.getFormato(),connexion);

		EmpleadoDataAccess.save(compra.getEmpleado(),connexion);

		TransportistaDataAccess.save(compra.getTransportista(),connexion);

		OrdenCompraDataAccess.save(compra.getOrdenCompra(),connexion);

		PedidoCompraDataAccess.save(compra.getPedidoCompra(),connexion);

		TipoTransaccionModuloDataAccess.save(compra.getTipoTransaccionModulo(),connexion);

		AsientoContableDataAccess.save(compra.getAsientoContable(),connexion);

		for(RetencionInven retencioninven:compra.getRetencionInvens()) {
			retencioninven.setid_compra(compra.getId());
			RetencionInvenDataAccess.save(retencioninven,connexion);
		}

		for(TransaccionLocal transaccionlocal:compra.getTransaccionLocals()) {
			transaccionlocal.setid_compra(compra.getId());
			TransaccionLocalDataAccess.save(transaccionlocal,connexion);
		}

		for(FormaPagoInven formapagoinven:compra.getFormaPagoInvens()) {
			formapagoinven.setid_compra(compra.getId());
			FormaPagoInvenDataAccess.save(formapagoinven,connexion);
		}

		for(DetalleCompra detallecompra:compra.getDetalleCompras()) {
			detallecompra.setid_compra(compra.getId());
			DetalleCompraDataAccess.save(detallecompra,connexion);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(compra.getEmpresa(),connexion);
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				SucursalDataAccess.save(compra.getSucursal(),connexion);
				continue;
			}

			if(clas.clas.equals(Modulo.class)) {
				ModuloDataAccess.save(compra.getModulo(),connexion);
				continue;
			}

			if(clas.clas.equals(Ejercicio.class)) {
				EjercicioDataAccess.save(compra.getEjercicio(),connexion);
				continue;
			}

			if(clas.clas.equals(Periodo.class)) {
				PeriodoDataAccess.save(compra.getPeriodo(),connexion);
				continue;
			}

			if(clas.clas.equals(Anio.class)) {
				AnioDataAccess.save(compra.getAnio(),connexion);
				continue;
			}

			if(clas.clas.equals(Mes.class)) {
				MesDataAccess.save(compra.getMes(),connexion);
				continue;
			}

			if(clas.clas.equals(Usuario.class)) {
				UsuarioDataAccess.save(compra.getUsuario(),connexion);
				continue;
			}

			if(clas.clas.equals(Moneda.class)) {
				MonedaDataAccess.save(compra.getMoneda(),connexion);
				continue;
			}

			if(clas.clas.equals(TipoCambio.class)) {
				TipoCambioDataAccess.save(compra.getTipoCambio(),connexion);
				continue;
			}

			if(clas.clas.equals(EstadoInventario.class)) {
				EstadoInventarioDataAccess.save(compra.getEstadoInventario(),connexion);
				continue;
			}

			if(clas.clas.equals(Cliente.class)) {
				ClienteDataAccess.save(compra.getCliente(),connexion);
				continue;
			}

			if(clas.clas.equals(Formato.class)) {
				FormatoDataAccess.save(compra.getFormato(),connexion);
				continue;
			}

			if(clas.clas.equals(Empleado.class)) {
				EmpleadoDataAccess.save(compra.getEmpleado(),connexion);
				continue;
			}

			if(clas.clas.equals(Transportista.class)) {
				TransportistaDataAccess.save(compra.getTransportista(),connexion);
				continue;
			}

			if(clas.clas.equals(OrdenCompra.class)) {
				OrdenCompraDataAccess.save(compra.getOrdenCompra(),connexion);
				continue;
			}

			if(clas.clas.equals(PedidoCompra.class)) {
				PedidoCompraDataAccess.save(compra.getPedidoCompra(),connexion);
				continue;
			}

			if(clas.clas.equals(TipoTransaccionModulo.class)) {
				TipoTransaccionModuloDataAccess.save(compra.getTipoTransaccionModulo(),connexion);
				continue;
			}

			if(clas.clas.equals(AsientoContable.class)) {
				AsientoContableDataAccess.save(compra.getAsientoContable(),connexion);
				continue;
			}


			if(clas.clas.equals(RetencionInven.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(RetencionInven retencioninven:compra.getRetencionInvens()) {
					retencioninven.setid_compra(compra.getId());
					RetencionInvenDataAccess.save(retencioninven,connexion);
				}
				continue;
			}

			if(clas.clas.equals(TransaccionLocal.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(TransaccionLocal transaccionlocal:compra.getTransaccionLocals()) {
					transaccionlocal.setid_compra(compra.getId());
					TransaccionLocalDataAccess.save(transaccionlocal,connexion);
				}
				continue;
			}

			if(clas.clas.equals(FormaPagoInven.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(FormaPagoInven formapagoinven:compra.getFormaPagoInvens()) {
					formapagoinven.setid_compra(compra.getId());
					FormaPagoInvenDataAccess.save(formapagoinven,connexion);
				}
				continue;
			}

			if(clas.clas.equals(DetalleCompra.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(DetalleCompra detallecompra:compra.getDetalleCompras()) {
					detallecompra.setid_compra(compra.getId());
					DetalleCompraDataAccess.save(detallecompra,connexion);
				}
				continue;
			}
		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(compra.getEmpresa(),connexion);
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(compra.getEmpresa(),isDeep,deepLoadType,clases);
				

		SucursalDataAccess.save(compra.getSucursal(),connexion);
		SucursalLogic sucursalLogic= new SucursalLogic(connexion);
		sucursalLogic.deepLoad(compra.getSucursal(),isDeep,deepLoadType,clases);
				

		ModuloDataAccess.save(compra.getModulo(),connexion);
		ModuloLogic moduloLogic= new ModuloLogic(connexion);
		moduloLogic.deepLoad(compra.getModulo(),isDeep,deepLoadType,clases);
				

		EjercicioDataAccess.save(compra.getEjercicio(),connexion);
		EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
		ejercicioLogic.deepLoad(compra.getEjercicio(),isDeep,deepLoadType,clases);
				

		PeriodoDataAccess.save(compra.getPeriodo(),connexion);
		PeriodoLogic periodoLogic= new PeriodoLogic(connexion);
		periodoLogic.deepLoad(compra.getPeriodo(),isDeep,deepLoadType,clases);
				

		AnioDataAccess.save(compra.getAnio(),connexion);
		AnioLogic anioLogic= new AnioLogic(connexion);
		anioLogic.deepLoad(compra.getAnio(),isDeep,deepLoadType,clases);
				

		MesDataAccess.save(compra.getMes(),connexion);
		MesLogic mesLogic= new MesLogic(connexion);
		mesLogic.deepLoad(compra.getMes(),isDeep,deepLoadType,clases);
				

		UsuarioDataAccess.save(compra.getUsuario(),connexion);
		UsuarioLogic usuarioLogic= new UsuarioLogic(connexion);
		usuarioLogic.deepLoad(compra.getUsuario(),isDeep,deepLoadType,clases);
				

		MonedaDataAccess.save(compra.getMoneda(),connexion);
		MonedaLogic monedaLogic= new MonedaLogic(connexion);
		monedaLogic.deepLoad(compra.getMoneda(),isDeep,deepLoadType,clases);
				

		TipoCambioDataAccess.save(compra.getTipoCambio(),connexion);
		TipoCambioLogic tipocambioLogic= new TipoCambioLogic(connexion);
		tipocambioLogic.deepLoad(compra.getTipoCambio(),isDeep,deepLoadType,clases);
				

		EstadoInventarioDataAccess.save(compra.getEstadoInventario(),connexion);
		EstadoInventarioLogic estadoinventarioLogic= new EstadoInventarioLogic(connexion);
		estadoinventarioLogic.deepLoad(compra.getEstadoInventario(),isDeep,deepLoadType,clases);
				

		ClienteDataAccess.save(compra.getCliente(),connexion);
		ClienteLogic clienteLogic= new ClienteLogic(connexion);
		clienteLogic.deepLoad(compra.getCliente(),isDeep,deepLoadType,clases);
				

		FormatoDataAccess.save(compra.getFormato(),connexion);
		FormatoLogic formatoLogic= new FormatoLogic(connexion);
		formatoLogic.deepLoad(compra.getFormato(),isDeep,deepLoadType,clases);
				

		EmpleadoDataAccess.save(compra.getEmpleado(),connexion);
		EmpleadoLogic empleadoLogic= new EmpleadoLogic(connexion);
		empleadoLogic.deepLoad(compra.getEmpleado(),isDeep,deepLoadType,clases);
				

		TransportistaDataAccess.save(compra.getTransportista(),connexion);
		TransportistaLogic transportistaLogic= new TransportistaLogic(connexion);
		transportistaLogic.deepLoad(compra.getTransportista(),isDeep,deepLoadType,clases);
				

		OrdenCompraDataAccess.save(compra.getOrdenCompra(),connexion);
		OrdenCompraLogic ordencompraLogic= new OrdenCompraLogic(connexion);
		ordencompraLogic.deepLoad(compra.getOrdenCompra(),isDeep,deepLoadType,clases);
				

		PedidoCompraDataAccess.save(compra.getPedidoCompra(),connexion);
		PedidoCompraLogic pedidocompraLogic= new PedidoCompraLogic(connexion);
		pedidocompraLogic.deepLoad(compra.getPedidoCompra(),isDeep,deepLoadType,clases);
				

		TipoTransaccionModuloDataAccess.save(compra.getTipoTransaccionModulo(),connexion);
		TipoTransaccionModuloLogic tipotransaccionmoduloLogic= new TipoTransaccionModuloLogic(connexion);
		tipotransaccionmoduloLogic.deepLoad(compra.getTipoTransaccionModulo(),isDeep,deepLoadType,clases);
				

		AsientoContableDataAccess.save(compra.getAsientoContable(),connexion);
		AsientoContableLogic asientocontableLogic= new AsientoContableLogic(connexion);
		asientocontableLogic.deepLoad(compra.getAsientoContable(),isDeep,deepLoadType,clases);
				

		for(RetencionInven retencioninven:compra.getRetencionInvens()) {
			RetencionInvenLogic retencioninvenLogic= new RetencionInvenLogic(connexion);
			retencioninven.setid_compra(compra.getId());
			RetencionInvenDataAccess.save(retencioninven,connexion);
			retencioninvenLogic.deepSave(retencioninven,isDeep,deepLoadType,clases);
		}

		for(TransaccionLocal transaccionlocal:compra.getTransaccionLocals()) {
			TransaccionLocalLogic transaccionlocalLogic= new TransaccionLocalLogic(connexion);
			transaccionlocal.setid_compra(compra.getId());
			TransaccionLocalDataAccess.save(transaccionlocal,connexion);
			transaccionlocalLogic.deepSave(transaccionlocal,isDeep,deepLoadType,clases);
		}

		for(FormaPagoInven formapagoinven:compra.getFormaPagoInvens()) {
			FormaPagoInvenLogic formapagoinvenLogic= new FormaPagoInvenLogic(connexion);
			formapagoinven.setid_compra(compra.getId());
			FormaPagoInvenDataAccess.save(formapagoinven,connexion);
			formapagoinvenLogic.deepSave(formapagoinven,isDeep,deepLoadType,clases);
		}

		for(DetalleCompra detallecompra:compra.getDetalleCompras()) {
			DetalleCompraLogic detallecompraLogic= new DetalleCompraLogic(connexion);
			detallecompra.setid_compra(compra.getId());
			DetalleCompraDataAccess.save(detallecompra,connexion);
			detallecompraLogic.deepSave(detallecompra,isDeep,deepLoadType,clases);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(compra.getEmpresa(),connexion);
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepSave(compra.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				SucursalDataAccess.save(compra.getSucursal(),connexion);
				SucursalLogic sucursalLogic= new SucursalLogic(connexion);
				sucursalLogic.deepSave(compra.getSucursal(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Modulo.class)) {
				ModuloDataAccess.save(compra.getModulo(),connexion);
				ModuloLogic moduloLogic= new ModuloLogic(connexion);
				moduloLogic.deepSave(compra.getModulo(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Ejercicio.class)) {
				EjercicioDataAccess.save(compra.getEjercicio(),connexion);
				EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
				ejercicioLogic.deepSave(compra.getEjercicio(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Periodo.class)) {
				PeriodoDataAccess.save(compra.getPeriodo(),connexion);
				PeriodoLogic periodoLogic= new PeriodoLogic(connexion);
				periodoLogic.deepSave(compra.getPeriodo(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Anio.class)) {
				AnioDataAccess.save(compra.getAnio(),connexion);
				AnioLogic anioLogic= new AnioLogic(connexion);
				anioLogic.deepSave(compra.getAnio(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Mes.class)) {
				MesDataAccess.save(compra.getMes(),connexion);
				MesLogic mesLogic= new MesLogic(connexion);
				mesLogic.deepSave(compra.getMes(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Usuario.class)) {
				UsuarioDataAccess.save(compra.getUsuario(),connexion);
				UsuarioLogic usuarioLogic= new UsuarioLogic(connexion);
				usuarioLogic.deepSave(compra.getUsuario(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Moneda.class)) {
				MonedaDataAccess.save(compra.getMoneda(),connexion);
				MonedaLogic monedaLogic= new MonedaLogic(connexion);
				monedaLogic.deepSave(compra.getMoneda(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoCambio.class)) {
				TipoCambioDataAccess.save(compra.getTipoCambio(),connexion);
				TipoCambioLogic tipocambioLogic= new TipoCambioLogic(connexion);
				tipocambioLogic.deepSave(compra.getTipoCambio(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(EstadoInventario.class)) {
				EstadoInventarioDataAccess.save(compra.getEstadoInventario(),connexion);
				EstadoInventarioLogic estadoinventarioLogic= new EstadoInventarioLogic(connexion);
				estadoinventarioLogic.deepSave(compra.getEstadoInventario(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Cliente.class)) {
				ClienteDataAccess.save(compra.getCliente(),connexion);
				ClienteLogic clienteLogic= new ClienteLogic(connexion);
				clienteLogic.deepSave(compra.getCliente(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Formato.class)) {
				FormatoDataAccess.save(compra.getFormato(),connexion);
				FormatoLogic formatoLogic= new FormatoLogic(connexion);
				formatoLogic.deepSave(compra.getFormato(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Empleado.class)) {
				EmpleadoDataAccess.save(compra.getEmpleado(),connexion);
				EmpleadoLogic empleadoLogic= new EmpleadoLogic(connexion);
				empleadoLogic.deepSave(compra.getEmpleado(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Transportista.class)) {
				TransportistaDataAccess.save(compra.getTransportista(),connexion);
				TransportistaLogic transportistaLogic= new TransportistaLogic(connexion);
				transportistaLogic.deepSave(compra.getTransportista(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(OrdenCompra.class)) {
				OrdenCompraDataAccess.save(compra.getOrdenCompra(),connexion);
				OrdenCompraLogic ordencompraLogic= new OrdenCompraLogic(connexion);
				ordencompraLogic.deepSave(compra.getOrdenCompra(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(PedidoCompra.class)) {
				PedidoCompraDataAccess.save(compra.getPedidoCompra(),connexion);
				PedidoCompraLogic pedidocompraLogic= new PedidoCompraLogic(connexion);
				pedidocompraLogic.deepSave(compra.getPedidoCompra(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoTransaccionModulo.class)) {
				TipoTransaccionModuloDataAccess.save(compra.getTipoTransaccionModulo(),connexion);
				TipoTransaccionModuloLogic tipotransaccionmoduloLogic= new TipoTransaccionModuloLogic(connexion);
				tipotransaccionmoduloLogic.deepSave(compra.getTipoTransaccionModulo(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(AsientoContable.class)) {
				AsientoContableDataAccess.save(compra.getAsientoContable(),connexion);
				AsientoContableLogic asientocontableLogic= new AsientoContableLogic(connexion);
				asientocontableLogic.deepSave(compra.getAsientoContable(),isDeep,deepLoadType,clases);				
				continue;
			}


			if(clas.clas.equals(RetencionInven.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(RetencionInven retencioninven:compra.getRetencionInvens()) {
					RetencionInvenLogic retencioninvenLogic= new RetencionInvenLogic(connexion);
					retencioninven.setid_compra(compra.getId());
					RetencionInvenDataAccess.save(retencioninven,connexion);
					retencioninvenLogic.deepSave(retencioninven,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(TransaccionLocal.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(TransaccionLocal transaccionlocal:compra.getTransaccionLocals()) {
					TransaccionLocalLogic transaccionlocalLogic= new TransaccionLocalLogic(connexion);
					transaccionlocal.setid_compra(compra.getId());
					TransaccionLocalDataAccess.save(transaccionlocal,connexion);
					transaccionlocalLogic.deepSave(transaccionlocal,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(FormaPagoInven.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(FormaPagoInven formapagoinven:compra.getFormaPagoInvens()) {
					FormaPagoInvenLogic formapagoinvenLogic= new FormaPagoInvenLogic(connexion);
					formapagoinven.setid_compra(compra.getId());
					FormaPagoInvenDataAccess.save(formapagoinven,connexion);
					formapagoinvenLogic.deepSave(formapagoinven,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(DetalleCompra.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(DetalleCompra detallecompra:compra.getDetalleCompras()) {
					DetalleCompraLogic detallecompraLogic= new DetalleCompraLogic(connexion);
					detallecompra.setid_compra(compra.getId());
					DetalleCompraDataAccess.save(detallecompra,connexion);
					detallecompraLogic.deepSave(detallecompra,isDeep,deepLoadType,clases);
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
			this.getNewConnexionToDeep(Compra.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(compra,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				CompraConstantesFunciones.refrescarForeignKeysDescripcionesCompra(compra);
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
			this.deepLoad(this.compra,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				CompraConstantesFunciones.refrescarForeignKeysDescripcionesCompra(this.compra);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(Compra.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(compras!=null) {
				for(Compra compra:compras) {
					this.deepLoad(compra,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					CompraConstantesFunciones.refrescarForeignKeysDescripcionesCompra(compras);
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
			if(compras!=null) {
				for(Compra compra:compras) {
					this.deepLoad(compra,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					CompraConstantesFunciones.refrescarForeignKeysDescripcionesCompra(compras);
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
			this.getNewConnexionToDeep(Compra.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(compra,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(Compra.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(compras!=null) {
				for(Compra compra:compras) {
					this.deepSave(compra,isDeep,deepLoadType,clases);
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
			if(compras!=null) {
				for(Compra compra:compras) {
					this.deepSave(compra,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getComprasFK_IdAnioWithConnection(String sFinalQuery,Pagination pagination,Long id_anio)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Compra.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidAnio= new ParameterSelectionGeneral();
			parameterSelectionGeneralidAnio.setParameterSelectionGeneralEqual(ParameterType.LONG,id_anio,CompraConstantesFunciones.IDANIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidAnio);

			CompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdAnio","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			compras=compraDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				CompraConstantesFunciones.refrescarForeignKeysDescripcionesCompra(this.compras);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getComprasFK_IdAnio(String sFinalQuery,Pagination pagination,Long id_anio)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidAnio= new ParameterSelectionGeneral();
			parameterSelectionGeneralidAnio.setParameterSelectionGeneralEqual(ParameterType.LONG,id_anio,CompraConstantesFunciones.IDANIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidAnio);

			CompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdAnio","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			compras=compraDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				CompraConstantesFunciones.refrescarForeignKeysDescripcionesCompra(this.compras);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getComprasFK_IdAsientoContableWithConnection(String sFinalQuery,Pagination pagination,Long id_asiento_contable)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Compra.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidAsientoContable= new ParameterSelectionGeneral();
			parameterSelectionGeneralidAsientoContable.setParameterSelectionGeneralEqual(ParameterType.LONG,id_asiento_contable,CompraConstantesFunciones.IDASIENTOCONTABLE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidAsientoContable);

			CompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdAsientoContable","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			compras=compraDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				CompraConstantesFunciones.refrescarForeignKeysDescripcionesCompra(this.compras);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getComprasFK_IdAsientoContable(String sFinalQuery,Pagination pagination,Long id_asiento_contable)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidAsientoContable= new ParameterSelectionGeneral();
			parameterSelectionGeneralidAsientoContable.setParameterSelectionGeneralEqual(ParameterType.LONG,id_asiento_contable,CompraConstantesFunciones.IDASIENTOCONTABLE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidAsientoContable);

			CompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdAsientoContable","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			compras=compraDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				CompraConstantesFunciones.refrescarForeignKeysDescripcionesCompra(this.compras);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getComprasFK_IdClienteWithConnection(String sFinalQuery,Pagination pagination,Long id_cliente)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Compra.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCliente= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCliente.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cliente,CompraConstantesFunciones.IDCLIENTE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCliente);

			CompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCliente","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			compras=compraDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				CompraConstantesFunciones.refrescarForeignKeysDescripcionesCompra(this.compras);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getComprasFK_IdCliente(String sFinalQuery,Pagination pagination,Long id_cliente)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCliente= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCliente.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cliente,CompraConstantesFunciones.IDCLIENTE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCliente);

			CompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCliente","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			compras=compraDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				CompraConstantesFunciones.refrescarForeignKeysDescripcionesCompra(this.compras);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getComprasFK_IdEjercicioWithConnection(String sFinalQuery,Pagination pagination,Long id_ejercicio)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Compra.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEjercicio= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEjercicio.setParameterSelectionGeneralEqual(ParameterType.LONG,id_ejercicio,CompraConstantesFunciones.IDEJERCICIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEjercicio);

			CompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEjercicio","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			compras=compraDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				CompraConstantesFunciones.refrescarForeignKeysDescripcionesCompra(this.compras);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getComprasFK_IdEjercicio(String sFinalQuery,Pagination pagination,Long id_ejercicio)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEjercicio= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEjercicio.setParameterSelectionGeneralEqual(ParameterType.LONG,id_ejercicio,CompraConstantesFunciones.IDEJERCICIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEjercicio);

			CompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEjercicio","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			compras=compraDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				CompraConstantesFunciones.refrescarForeignKeysDescripcionesCompra(this.compras);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getComprasFK_IdEmpleadoWithConnection(String sFinalQuery,Pagination pagination,Long id_empleado)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Compra.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpleado= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpleado.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empleado,CompraConstantesFunciones.IDEMPLEADO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpleado);

			CompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpleado","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			compras=compraDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				CompraConstantesFunciones.refrescarForeignKeysDescripcionesCompra(this.compras);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getComprasFK_IdEmpleado(String sFinalQuery,Pagination pagination,Long id_empleado)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpleado= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpleado.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empleado,CompraConstantesFunciones.IDEMPLEADO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpleado);

			CompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpleado","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			compras=compraDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				CompraConstantesFunciones.refrescarForeignKeysDescripcionesCompra(this.compras);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getComprasFK_IdEmpresaWithConnection(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Compra.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,CompraConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			CompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			compras=compraDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				CompraConstantesFunciones.refrescarForeignKeysDescripcionesCompra(this.compras);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getComprasFK_IdEmpresa(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,CompraConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			CompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			compras=compraDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				CompraConstantesFunciones.refrescarForeignKeysDescripcionesCompra(this.compras);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getComprasFK_IdEstadoInventarioWithConnection(String sFinalQuery,Pagination pagination,Long id_estado_inventario)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Compra.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEstadoInventario= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEstadoInventario.setParameterSelectionGeneralEqual(ParameterType.LONG,id_estado_inventario,CompraConstantesFunciones.IDESTADOINVENTARIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEstadoInventario);

			CompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEstadoInventario","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			compras=compraDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				CompraConstantesFunciones.refrescarForeignKeysDescripcionesCompra(this.compras);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getComprasFK_IdEstadoInventario(String sFinalQuery,Pagination pagination,Long id_estado_inventario)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEstadoInventario= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEstadoInventario.setParameterSelectionGeneralEqual(ParameterType.LONG,id_estado_inventario,CompraConstantesFunciones.IDESTADOINVENTARIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEstadoInventario);

			CompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEstadoInventario","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			compras=compraDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				CompraConstantesFunciones.refrescarForeignKeysDescripcionesCompra(this.compras);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getComprasFK_IdFormatoWithConnection(String sFinalQuery,Pagination pagination,Long id_formato)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Compra.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidFormato= new ParameterSelectionGeneral();
			parameterSelectionGeneralidFormato.setParameterSelectionGeneralEqual(ParameterType.LONG,id_formato,CompraConstantesFunciones.IDFORMATO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidFormato);

			CompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdFormato","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			compras=compraDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				CompraConstantesFunciones.refrescarForeignKeysDescripcionesCompra(this.compras);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getComprasFK_IdFormato(String sFinalQuery,Pagination pagination,Long id_formato)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidFormato= new ParameterSelectionGeneral();
			parameterSelectionGeneralidFormato.setParameterSelectionGeneralEqual(ParameterType.LONG,id_formato,CompraConstantesFunciones.IDFORMATO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidFormato);

			CompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdFormato","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			compras=compraDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				CompraConstantesFunciones.refrescarForeignKeysDescripcionesCompra(this.compras);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getComprasFK_IdMesWithConnection(String sFinalQuery,Pagination pagination,Long id_mes)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Compra.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidMes= new ParameterSelectionGeneral();
			parameterSelectionGeneralidMes.setParameterSelectionGeneralEqual(ParameterType.LONG,id_mes,CompraConstantesFunciones.IDMES,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidMes);

			CompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdMes","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			compras=compraDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				CompraConstantesFunciones.refrescarForeignKeysDescripcionesCompra(this.compras);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getComprasFK_IdMes(String sFinalQuery,Pagination pagination,Long id_mes)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidMes= new ParameterSelectionGeneral();
			parameterSelectionGeneralidMes.setParameterSelectionGeneralEqual(ParameterType.LONG,id_mes,CompraConstantesFunciones.IDMES,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidMes);

			CompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdMes","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			compras=compraDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				CompraConstantesFunciones.refrescarForeignKeysDescripcionesCompra(this.compras);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getComprasFK_IdModuloWithConnection(String sFinalQuery,Pagination pagination,Long id_modulo)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Compra.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidModulo= new ParameterSelectionGeneral();
			parameterSelectionGeneralidModulo.setParameterSelectionGeneralEqual(ParameterType.LONG,id_modulo,CompraConstantesFunciones.IDMODULO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidModulo);

			CompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdModulo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			compras=compraDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				CompraConstantesFunciones.refrescarForeignKeysDescripcionesCompra(this.compras);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getComprasFK_IdModulo(String sFinalQuery,Pagination pagination,Long id_modulo)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidModulo= new ParameterSelectionGeneral();
			parameterSelectionGeneralidModulo.setParameterSelectionGeneralEqual(ParameterType.LONG,id_modulo,CompraConstantesFunciones.IDMODULO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidModulo);

			CompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdModulo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			compras=compraDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				CompraConstantesFunciones.refrescarForeignKeysDescripcionesCompra(this.compras);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getComprasFK_IdMonedaWithConnection(String sFinalQuery,Pagination pagination,Long id_moneda)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Compra.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidMoneda= new ParameterSelectionGeneral();
			parameterSelectionGeneralidMoneda.setParameterSelectionGeneralEqual(ParameterType.LONG,id_moneda,CompraConstantesFunciones.IDMONEDA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidMoneda);

			CompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdMoneda","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			compras=compraDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				CompraConstantesFunciones.refrescarForeignKeysDescripcionesCompra(this.compras);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getComprasFK_IdMoneda(String sFinalQuery,Pagination pagination,Long id_moneda)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidMoneda= new ParameterSelectionGeneral();
			parameterSelectionGeneralidMoneda.setParameterSelectionGeneralEqual(ParameterType.LONG,id_moneda,CompraConstantesFunciones.IDMONEDA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidMoneda);

			CompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdMoneda","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			compras=compraDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				CompraConstantesFunciones.refrescarForeignKeysDescripcionesCompra(this.compras);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getComprasFK_IdOrdenCompraWithConnection(String sFinalQuery,Pagination pagination,Long id_orden_compra)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Compra.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidOrdenCompra= new ParameterSelectionGeneral();
			parameterSelectionGeneralidOrdenCompra.setParameterSelectionGeneralEqual(ParameterType.LONG,id_orden_compra,CompraConstantesFunciones.IDORDENCOMPRA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidOrdenCompra);

			CompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdOrdenCompra","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			compras=compraDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				CompraConstantesFunciones.refrescarForeignKeysDescripcionesCompra(this.compras);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getComprasFK_IdOrdenCompra(String sFinalQuery,Pagination pagination,Long id_orden_compra)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidOrdenCompra= new ParameterSelectionGeneral();
			parameterSelectionGeneralidOrdenCompra.setParameterSelectionGeneralEqual(ParameterType.LONG,id_orden_compra,CompraConstantesFunciones.IDORDENCOMPRA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidOrdenCompra);

			CompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdOrdenCompra","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			compras=compraDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				CompraConstantesFunciones.refrescarForeignKeysDescripcionesCompra(this.compras);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getComprasFK_IdPedidoCompraWithConnection(String sFinalQuery,Pagination pagination,Long id_pedido_compra)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Compra.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidPedidoCompra= new ParameterSelectionGeneral();
			parameterSelectionGeneralidPedidoCompra.setParameterSelectionGeneralEqual(ParameterType.LONG,id_pedido_compra,CompraConstantesFunciones.IDPEDIDOCOMPRA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidPedidoCompra);

			CompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdPedidoCompra","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			compras=compraDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				CompraConstantesFunciones.refrescarForeignKeysDescripcionesCompra(this.compras);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getComprasFK_IdPedidoCompra(String sFinalQuery,Pagination pagination,Long id_pedido_compra)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidPedidoCompra= new ParameterSelectionGeneral();
			parameterSelectionGeneralidPedidoCompra.setParameterSelectionGeneralEqual(ParameterType.LONG,id_pedido_compra,CompraConstantesFunciones.IDPEDIDOCOMPRA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidPedidoCompra);

			CompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdPedidoCompra","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			compras=compraDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				CompraConstantesFunciones.refrescarForeignKeysDescripcionesCompra(this.compras);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getComprasFK_IdPeriodoWithConnection(String sFinalQuery,Pagination pagination,Long id_periodo)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Compra.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidPeriodo= new ParameterSelectionGeneral();
			parameterSelectionGeneralidPeriodo.setParameterSelectionGeneralEqual(ParameterType.LONG,id_periodo,CompraConstantesFunciones.IDPERIODO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidPeriodo);

			CompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdPeriodo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			compras=compraDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				CompraConstantesFunciones.refrescarForeignKeysDescripcionesCompra(this.compras);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getComprasFK_IdPeriodo(String sFinalQuery,Pagination pagination,Long id_periodo)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidPeriodo= new ParameterSelectionGeneral();
			parameterSelectionGeneralidPeriodo.setParameterSelectionGeneralEqual(ParameterType.LONG,id_periodo,CompraConstantesFunciones.IDPERIODO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidPeriodo);

			CompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdPeriodo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			compras=compraDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				CompraConstantesFunciones.refrescarForeignKeysDescripcionesCompra(this.compras);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getComprasFK_IdSucursalWithConnection(String sFinalQuery,Pagination pagination,Long id_sucursal)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Compra.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidSucursal= new ParameterSelectionGeneral();
			parameterSelectionGeneralidSucursal.setParameterSelectionGeneralEqual(ParameterType.LONG,id_sucursal,CompraConstantesFunciones.IDSUCURSAL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidSucursal);

			CompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdSucursal","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			compras=compraDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				CompraConstantesFunciones.refrescarForeignKeysDescripcionesCompra(this.compras);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getComprasFK_IdSucursal(String sFinalQuery,Pagination pagination,Long id_sucursal)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidSucursal= new ParameterSelectionGeneral();
			parameterSelectionGeneralidSucursal.setParameterSelectionGeneralEqual(ParameterType.LONG,id_sucursal,CompraConstantesFunciones.IDSUCURSAL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidSucursal);

			CompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdSucursal","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			compras=compraDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				CompraConstantesFunciones.refrescarForeignKeysDescripcionesCompra(this.compras);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getComprasFK_IdTipoCambioWithConnection(String sFinalQuery,Pagination pagination,Long id_tipo_cambio)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Compra.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoCambio= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoCambio.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_cambio,CompraConstantesFunciones.IDTIPOCAMBIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoCambio);

			CompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoCambio","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			compras=compraDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				CompraConstantesFunciones.refrescarForeignKeysDescripcionesCompra(this.compras);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getComprasFK_IdTipoCambio(String sFinalQuery,Pagination pagination,Long id_tipo_cambio)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoCambio= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoCambio.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_cambio,CompraConstantesFunciones.IDTIPOCAMBIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoCambio);

			CompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoCambio","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			compras=compraDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				CompraConstantesFunciones.refrescarForeignKeysDescripcionesCompra(this.compras);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getComprasFK_IdTipoTransaccionModuloWithConnection(String sFinalQuery,Pagination pagination,Long id_tipo_transaccion_modulo)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Compra.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoTransaccionModulo= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoTransaccionModulo.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_transaccion_modulo,CompraConstantesFunciones.IDTIPOTRANSACCIONMODULO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoTransaccionModulo);

			CompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoTransaccionModulo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			compras=compraDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				CompraConstantesFunciones.refrescarForeignKeysDescripcionesCompra(this.compras);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getComprasFK_IdTipoTransaccionModulo(String sFinalQuery,Pagination pagination,Long id_tipo_transaccion_modulo)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoTransaccionModulo= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoTransaccionModulo.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_transaccion_modulo,CompraConstantesFunciones.IDTIPOTRANSACCIONMODULO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoTransaccionModulo);

			CompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoTransaccionModulo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			compras=compraDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				CompraConstantesFunciones.refrescarForeignKeysDescripcionesCompra(this.compras);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getComprasFK_IdTransportistaWithConnection(String sFinalQuery,Pagination pagination,Long id_transportista)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Compra.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTransportista= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTransportista.setParameterSelectionGeneralEqual(ParameterType.LONG,id_transportista,CompraConstantesFunciones.IDTRANSPORTISTA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTransportista);

			CompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTransportista","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			compras=compraDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				CompraConstantesFunciones.refrescarForeignKeysDescripcionesCompra(this.compras);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getComprasFK_IdTransportista(String sFinalQuery,Pagination pagination,Long id_transportista)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTransportista= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTransportista.setParameterSelectionGeneralEqual(ParameterType.LONG,id_transportista,CompraConstantesFunciones.IDTRANSPORTISTA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTransportista);

			CompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTransportista","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			compras=compraDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				CompraConstantesFunciones.refrescarForeignKeysDescripcionesCompra(this.compras);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getComprasFK_IdUsuarioWithConnection(String sFinalQuery,Pagination pagination,Long id_usuario)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Compra.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidUsuario= new ParameterSelectionGeneral();
			parameterSelectionGeneralidUsuario.setParameterSelectionGeneralEqual(ParameterType.LONG,id_usuario,CompraConstantesFunciones.IDUSUARIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidUsuario);

			CompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdUsuario","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			compras=compraDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				CompraConstantesFunciones.refrescarForeignKeysDescripcionesCompra(this.compras);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getComprasFK_IdUsuario(String sFinalQuery,Pagination pagination,Long id_usuario)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidUsuario= new ParameterSelectionGeneral();
			parameterSelectionGeneralidUsuario.setParameterSelectionGeneralEqual(ParameterType.LONG,id_usuario,CompraConstantesFunciones.IDUSUARIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidUsuario);

			CompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdUsuario","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			compras=compraDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				CompraConstantesFunciones.refrescarForeignKeysDescripcionesCompra(this.compras);
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
			if(CompraConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,CompraDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,Compra compra,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(CompraConstantesFunciones.ISCONAUDITORIA) {
				if(compra.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,CompraDataAccess.TABLENAME, compra.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(CompraConstantesFunciones.ISCONAUDITORIADETALLE) {
						////CompraLogic.registrarAuditoriaDetallesCompra(connexion,compra,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(compra.getIsDeleted()) {
					/*if(!compra.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,CompraDataAccess.TABLENAME, compra.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////CompraLogic.registrarAuditoriaDetallesCompra(connexion,compra,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,CompraDataAccess.TABLENAME, compra.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(compra.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,CompraDataAccess.TABLENAME, compra.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(CompraConstantesFunciones.ISCONAUDITORIADETALLE) {
						////CompraLogic.registrarAuditoriaDetallesCompra(connexion,compra,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesCompra(Connexion connexion,Compra compra)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(compra.getIsNew()||!compra.getid_empresa().equals(compra.getCompraOriginal().getid_empresa()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(compra.getCompraOriginal().getid_empresa()!=null)
				{
					strValorActual=compra.getCompraOriginal().getid_empresa().toString();
				}
				if(compra.getid_empresa()!=null)
				{
					strValorNuevo=compra.getid_empresa().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),CompraConstantesFunciones.IDEMPRESA,strValorActual,strValorNuevo);
			}	
			
			if(compra.getIsNew()||!compra.getid_sucursal().equals(compra.getCompraOriginal().getid_sucursal()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(compra.getCompraOriginal().getid_sucursal()!=null)
				{
					strValorActual=compra.getCompraOriginal().getid_sucursal().toString();
				}
				if(compra.getid_sucursal()!=null)
				{
					strValorNuevo=compra.getid_sucursal().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),CompraConstantesFunciones.IDSUCURSAL,strValorActual,strValorNuevo);
			}	
			
			if(compra.getIsNew()||!compra.getid_modulo().equals(compra.getCompraOriginal().getid_modulo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(compra.getCompraOriginal().getid_modulo()!=null)
				{
					strValorActual=compra.getCompraOriginal().getid_modulo().toString();
				}
				if(compra.getid_modulo()!=null)
				{
					strValorNuevo=compra.getid_modulo().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),CompraConstantesFunciones.IDMODULO,strValorActual,strValorNuevo);
			}	
			
			if(compra.getIsNew()||!compra.getid_ejercicio().equals(compra.getCompraOriginal().getid_ejercicio()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(compra.getCompraOriginal().getid_ejercicio()!=null)
				{
					strValorActual=compra.getCompraOriginal().getid_ejercicio().toString();
				}
				if(compra.getid_ejercicio()!=null)
				{
					strValorNuevo=compra.getid_ejercicio().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),CompraConstantesFunciones.IDEJERCICIO,strValorActual,strValorNuevo);
			}	
			
			if(compra.getIsNew()||!compra.getid_periodo().equals(compra.getCompraOriginal().getid_periodo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(compra.getCompraOriginal().getid_periodo()!=null)
				{
					strValorActual=compra.getCompraOriginal().getid_periodo().toString();
				}
				if(compra.getid_periodo()!=null)
				{
					strValorNuevo=compra.getid_periodo().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),CompraConstantesFunciones.IDPERIODO,strValorActual,strValorNuevo);
			}	
			
			if(compra.getIsNew()||!compra.getid_anio().equals(compra.getCompraOriginal().getid_anio()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(compra.getCompraOriginal().getid_anio()!=null)
				{
					strValorActual=compra.getCompraOriginal().getid_anio().toString();
				}
				if(compra.getid_anio()!=null)
				{
					strValorNuevo=compra.getid_anio().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),CompraConstantesFunciones.IDANIO,strValorActual,strValorNuevo);
			}	
			
			if(compra.getIsNew()||!compra.getid_mes().equals(compra.getCompraOriginal().getid_mes()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(compra.getCompraOriginal().getid_mes()!=null)
				{
					strValorActual=compra.getCompraOriginal().getid_mes().toString();
				}
				if(compra.getid_mes()!=null)
				{
					strValorNuevo=compra.getid_mes().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),CompraConstantesFunciones.IDMES,strValorActual,strValorNuevo);
			}	
			
			if(compra.getIsNew()||!compra.getid_usuario().equals(compra.getCompraOriginal().getid_usuario()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(compra.getCompraOriginal().getid_usuario()!=null)
				{
					strValorActual=compra.getCompraOriginal().getid_usuario().toString();
				}
				if(compra.getid_usuario()!=null)
				{
					strValorNuevo=compra.getid_usuario().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),CompraConstantesFunciones.IDUSUARIO,strValorActual,strValorNuevo);
			}	
			
			if(compra.getIsNew()||!compra.getfecha_emision().equals(compra.getCompraOriginal().getfecha_emision()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(compra.getCompraOriginal().getfecha_emision()!=null)
				{
					strValorActual=compra.getCompraOriginal().getfecha_emision().toString();
				}
				if(compra.getfecha_emision()!=null)
				{
					strValorNuevo=compra.getfecha_emision().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),CompraConstantesFunciones.FECHAEMISION,strValorActual,strValorNuevo);
			}	
			
			if(compra.getIsNew()||!compra.getfecha_entrega().equals(compra.getCompraOriginal().getfecha_entrega()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(compra.getCompraOriginal().getfecha_entrega()!=null)
				{
					strValorActual=compra.getCompraOriginal().getfecha_entrega().toString();
				}
				if(compra.getfecha_entrega()!=null)
				{
					strValorNuevo=compra.getfecha_entrega().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),CompraConstantesFunciones.FECHAENTREGA,strValorActual,strValorNuevo);
			}	
			
			if(compra.getIsNew()||!compra.getnumero_secuencial().equals(compra.getCompraOriginal().getnumero_secuencial()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(compra.getCompraOriginal().getnumero_secuencial()!=null)
				{
					strValorActual=compra.getCompraOriginal().getnumero_secuencial();
				}
				if(compra.getnumero_secuencial()!=null)
				{
					strValorNuevo=compra.getnumero_secuencial() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),CompraConstantesFunciones.NUMEROSECUENCIAL,strValorActual,strValorNuevo);
			}	
			
			if(compra.getIsNew()||!compra.getid_moneda().equals(compra.getCompraOriginal().getid_moneda()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(compra.getCompraOriginal().getid_moneda()!=null)
				{
					strValorActual=compra.getCompraOriginal().getid_moneda().toString();
				}
				if(compra.getid_moneda()!=null)
				{
					strValorNuevo=compra.getid_moneda().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),CompraConstantesFunciones.IDMONEDA,strValorActual,strValorNuevo);
			}	
			
			if(compra.getIsNew()||!compra.getid_tipo_cambio().equals(compra.getCompraOriginal().getid_tipo_cambio()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(compra.getCompraOriginal().getid_tipo_cambio()!=null)
				{
					strValorActual=compra.getCompraOriginal().getid_tipo_cambio().toString();
				}
				if(compra.getid_tipo_cambio()!=null)
				{
					strValorNuevo=compra.getid_tipo_cambio().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),CompraConstantesFunciones.IDTIPOCAMBIO,strValorActual,strValorNuevo);
			}	
			
			if(compra.getIsNew()||!compra.getid_estado_inventario().equals(compra.getCompraOriginal().getid_estado_inventario()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(compra.getCompraOriginal().getid_estado_inventario()!=null)
				{
					strValorActual=compra.getCompraOriginal().getid_estado_inventario().toString();
				}
				if(compra.getid_estado_inventario()!=null)
				{
					strValorNuevo=compra.getid_estado_inventario().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),CompraConstantesFunciones.IDESTADOINVENTARIO,strValorActual,strValorNuevo);
			}	
			
			if(compra.getIsNew()||!compra.getid_cliente().equals(compra.getCompraOriginal().getid_cliente()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(compra.getCompraOriginal().getid_cliente()!=null)
				{
					strValorActual=compra.getCompraOriginal().getid_cliente().toString();
				}
				if(compra.getid_cliente()!=null)
				{
					strValorNuevo=compra.getid_cliente().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),CompraConstantesFunciones.IDCLIENTE,strValorActual,strValorNuevo);
			}	
			
			if(compra.getIsNew()||!compra.getid_formato().equals(compra.getCompraOriginal().getid_formato()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(compra.getCompraOriginal().getid_formato()!=null)
				{
					strValorActual=compra.getCompraOriginal().getid_formato().toString();
				}
				if(compra.getid_formato()!=null)
				{
					strValorNuevo=compra.getid_formato().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),CompraConstantesFunciones.IDFORMATO,strValorActual,strValorNuevo);
			}	
			
			if(compra.getIsNew()||!compra.getid_empleado().equals(compra.getCompraOriginal().getid_empleado()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(compra.getCompraOriginal().getid_empleado()!=null)
				{
					strValorActual=compra.getCompraOriginal().getid_empleado().toString();
				}
				if(compra.getid_empleado()!=null)
				{
					strValorNuevo=compra.getid_empleado().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),CompraConstantesFunciones.IDEMPLEADO,strValorActual,strValorNuevo);
			}	
			
			if(compra.getIsNew()||!compra.getnumero_factura().equals(compra.getCompraOriginal().getnumero_factura()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(compra.getCompraOriginal().getnumero_factura()!=null)
				{
					strValorActual=compra.getCompraOriginal().getnumero_factura();
				}
				if(compra.getnumero_factura()!=null)
				{
					strValorNuevo=compra.getnumero_factura() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),CompraConstantesFunciones.NUMEROFACTURA,strValorActual,strValorNuevo);
			}	
			
			if(compra.getIsNew()||!compra.getid_transportista().equals(compra.getCompraOriginal().getid_transportista()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(compra.getCompraOriginal().getid_transportista()!=null)
				{
					strValorActual=compra.getCompraOriginal().getid_transportista().toString();
				}
				if(compra.getid_transportista()!=null)
				{
					strValorNuevo=compra.getid_transportista().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),CompraConstantesFunciones.IDTRANSPORTISTA,strValorActual,strValorNuevo);
			}	
			
			if(compra.getIsNew()||!compra.getdescripcion().equals(compra.getCompraOriginal().getdescripcion()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(compra.getCompraOriginal().getdescripcion()!=null)
				{
					strValorActual=compra.getCompraOriginal().getdescripcion();
				}
				if(compra.getdescripcion()!=null)
				{
					strValorNuevo=compra.getdescripcion() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),CompraConstantesFunciones.DESCRIPCION,strValorActual,strValorNuevo);
			}	
			
			if(compra.getIsNew()||!compra.getid_orden_compra().equals(compra.getCompraOriginal().getid_orden_compra()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(compra.getCompraOriginal().getid_orden_compra()!=null)
				{
					strValorActual=compra.getCompraOriginal().getid_orden_compra().toString();
				}
				if(compra.getid_orden_compra()!=null)
				{
					strValorNuevo=compra.getid_orden_compra().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),CompraConstantesFunciones.IDORDENCOMPRA,strValorActual,strValorNuevo);
			}	
			
			if(compra.getIsNew()||!compra.getid_pedido_compra().equals(compra.getCompraOriginal().getid_pedido_compra()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(compra.getCompraOriginal().getid_pedido_compra()!=null)
				{
					strValorActual=compra.getCompraOriginal().getid_pedido_compra().toString();
				}
				if(compra.getid_pedido_compra()!=null)
				{
					strValorNuevo=compra.getid_pedido_compra().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),CompraConstantesFunciones.IDPEDIDOCOMPRA,strValorActual,strValorNuevo);
			}	
			
			if(compra.getIsNew()||!compra.getautori_usuario().equals(compra.getCompraOriginal().getautori_usuario()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(compra.getCompraOriginal().getautori_usuario()!=null)
				{
					strValorActual=compra.getCompraOriginal().getautori_usuario();
				}
				if(compra.getautori_usuario()!=null)
				{
					strValorNuevo=compra.getautori_usuario() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),CompraConstantesFunciones.AUTORIUSUARIO,strValorActual,strValorNuevo);
			}	
			
			if(compra.getIsNew()||!compra.getfactura_inicial().equals(compra.getCompraOriginal().getfactura_inicial()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(compra.getCompraOriginal().getfactura_inicial()!=null)
				{
					strValorActual=compra.getCompraOriginal().getfactura_inicial();
				}
				if(compra.getfactura_inicial()!=null)
				{
					strValorNuevo=compra.getfactura_inicial() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),CompraConstantesFunciones.FACTURAINICIAL,strValorActual,strValorNuevo);
			}	
			
			if(compra.getIsNew()||!compra.getfactura_final().equals(compra.getCompraOriginal().getfactura_final()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(compra.getCompraOriginal().getfactura_final()!=null)
				{
					strValorActual=compra.getCompraOriginal().getfactura_final();
				}
				if(compra.getfactura_final()!=null)
				{
					strValorNuevo=compra.getfactura_final() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),CompraConstantesFunciones.FACTURAFINAL,strValorActual,strValorNuevo);
			}	
			
			if(compra.getIsNew()||!compra.getservicio_documento().equals(compra.getCompraOriginal().getservicio_documento()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(compra.getCompraOriginal().getservicio_documento()!=null)
				{
					strValorActual=compra.getCompraOriginal().getservicio_documento();
				}
				if(compra.getservicio_documento()!=null)
				{
					strValorNuevo=compra.getservicio_documento() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),CompraConstantesFunciones.SERVICIODOCUMENTO,strValorActual,strValorNuevo);
			}	
			
			if(compra.getIsNew()||!compra.getfecha_valor().equals(compra.getCompraOriginal().getfecha_valor()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(compra.getCompraOriginal().getfecha_valor()!=null)
				{
					strValorActual=compra.getCompraOriginal().getfecha_valor().toString();
				}
				if(compra.getfecha_valor()!=null)
				{
					strValorNuevo=compra.getfecha_valor().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),CompraConstantesFunciones.FECHAVALOR,strValorActual,strValorNuevo);
			}	
			
			if(compra.getIsNew()||!compra.getporcentaje_descuento().equals(compra.getCompraOriginal().getporcentaje_descuento()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(compra.getCompraOriginal().getporcentaje_descuento()!=null)
				{
					strValorActual=compra.getCompraOriginal().getporcentaje_descuento().toString();
				}
				if(compra.getporcentaje_descuento()!=null)
				{
					strValorNuevo=compra.getporcentaje_descuento().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),CompraConstantesFunciones.PORCENTAJEDESCUENTO,strValorActual,strValorNuevo);
			}	
			
			if(compra.getIsNew()||!compra.getsuman().equals(compra.getCompraOriginal().getsuman()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(compra.getCompraOriginal().getsuman()!=null)
				{
					strValorActual=compra.getCompraOriginal().getsuman().toString();
				}
				if(compra.getsuman()!=null)
				{
					strValorNuevo=compra.getsuman().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),CompraConstantesFunciones.SUMAN,strValorActual,strValorNuevo);
			}	
			
			if(compra.getIsNew()||!compra.getice().equals(compra.getCompraOriginal().getice()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(compra.getCompraOriginal().getice()!=null)
				{
					strValorActual=compra.getCompraOriginal().getice().toString();
				}
				if(compra.getice()!=null)
				{
					strValorNuevo=compra.getice().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),CompraConstantesFunciones.ICE,strValorActual,strValorNuevo);
			}	
			
			if(compra.getIsNew()||!compra.getvalor_descuento().equals(compra.getCompraOriginal().getvalor_descuento()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(compra.getCompraOriginal().getvalor_descuento()!=null)
				{
					strValorActual=compra.getCompraOriginal().getvalor_descuento().toString();
				}
				if(compra.getvalor_descuento()!=null)
				{
					strValorNuevo=compra.getvalor_descuento().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),CompraConstantesFunciones.VALORDESCUENTO,strValorActual,strValorNuevo);
			}	
			
			if(compra.getIsNew()||!compra.gettotal_descuento().equals(compra.getCompraOriginal().gettotal_descuento()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(compra.getCompraOriginal().gettotal_descuento()!=null)
				{
					strValorActual=compra.getCompraOriginal().gettotal_descuento().toString();
				}
				if(compra.gettotal_descuento()!=null)
				{
					strValorNuevo=compra.gettotal_descuento().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),CompraConstantesFunciones.TOTALDESCUENTO,strValorActual,strValorNuevo);
			}	
			
			if(compra.getIsNew()||!compra.getiva().equals(compra.getCompraOriginal().getiva()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(compra.getCompraOriginal().getiva()!=null)
				{
					strValorActual=compra.getCompraOriginal().getiva().toString();
				}
				if(compra.getiva()!=null)
				{
					strValorNuevo=compra.getiva().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),CompraConstantesFunciones.IVA,strValorActual,strValorNuevo);
			}	
			
			if(compra.getIsNew()||!compra.getstock().equals(compra.getCompraOriginal().getstock()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(compra.getCompraOriginal().getstock()!=null)
				{
					strValorActual=compra.getCompraOriginal().getstock().toString();
				}
				if(compra.getstock()!=null)
				{
					strValorNuevo=compra.getstock().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),CompraConstantesFunciones.STOCK,strValorActual,strValorNuevo);
			}	
			
			if(compra.getIsNew()||!compra.getsub_total().equals(compra.getCompraOriginal().getsub_total()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(compra.getCompraOriginal().getsub_total()!=null)
				{
					strValorActual=compra.getCompraOriginal().getsub_total().toString();
				}
				if(compra.getsub_total()!=null)
				{
					strValorNuevo=compra.getsub_total().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),CompraConstantesFunciones.SUBTOTAL,strValorActual,strValorNuevo);
			}	
			
			if(compra.getIsNew()||!compra.gettotal_otro().equals(compra.getCompraOriginal().gettotal_otro()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(compra.getCompraOriginal().gettotal_otro()!=null)
				{
					strValorActual=compra.getCompraOriginal().gettotal_otro().toString();
				}
				if(compra.gettotal_otro()!=null)
				{
					strValorNuevo=compra.gettotal_otro().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),CompraConstantesFunciones.TOTALOTRO,strValorActual,strValorNuevo);
			}	
			
			if(compra.getIsNew()||!compra.getultimo_costo().equals(compra.getCompraOriginal().getultimo_costo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(compra.getCompraOriginal().getultimo_costo()!=null)
				{
					strValorActual=compra.getCompraOriginal().getultimo_costo().toString();
				}
				if(compra.getultimo_costo()!=null)
				{
					strValorNuevo=compra.getultimo_costo().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),CompraConstantesFunciones.ULTIMOCOSTO,strValorActual,strValorNuevo);
			}	
			
			if(compra.getIsNew()||!compra.getnumero_items().equals(compra.getCompraOriginal().getnumero_items()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(compra.getCompraOriginal().getnumero_items()!=null)
				{
					strValorActual=compra.getCompraOriginal().getnumero_items().toString();
				}
				if(compra.getnumero_items()!=null)
				{
					strValorNuevo=compra.getnumero_items().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),CompraConstantesFunciones.NUMEROITEMS,strValorActual,strValorNuevo);
			}	
			
			if(compra.getIsNew()||!compra.getretencion().equals(compra.getCompraOriginal().getretencion()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(compra.getCompraOriginal().getretencion()!=null)
				{
					strValorActual=compra.getCompraOriginal().getretencion().toString();
				}
				if(compra.getretencion()!=null)
				{
					strValorNuevo=compra.getretencion().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),CompraConstantesFunciones.RETENCION,strValorActual,strValorNuevo);
			}	
			
			if(compra.getIsNew()||!compra.gettotal().equals(compra.getCompraOriginal().gettotal()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(compra.getCompraOriginal().gettotal()!=null)
				{
					strValorActual=compra.getCompraOriginal().gettotal().toString();
				}
				if(compra.gettotal()!=null)
				{
					strValorNuevo=compra.gettotal().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),CompraConstantesFunciones.TOTAL,strValorActual,strValorNuevo);
			}	
			
			if(compra.getIsNew()||!compra.getflete().equals(compra.getCompraOriginal().getflete()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(compra.getCompraOriginal().getflete()!=null)
				{
					strValorActual=compra.getCompraOriginal().getflete().toString();
				}
				if(compra.getflete()!=null)
				{
					strValorNuevo=compra.getflete().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),CompraConstantesFunciones.FLETE,strValorActual,strValorNuevo);
			}	
			
			if(compra.getIsNew()||!compra.getimpuesto().equals(compra.getCompraOriginal().getimpuesto()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(compra.getCompraOriginal().getimpuesto()!=null)
				{
					strValorActual=compra.getCompraOriginal().getimpuesto().toString();
				}
				if(compra.getimpuesto()!=null)
				{
					strValorNuevo=compra.getimpuesto().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),CompraConstantesFunciones.IMPUESTO,strValorActual,strValorNuevo);
			}	
			
			if(compra.getIsNew()||!compra.getid_tipo_transaccion_modulo().equals(compra.getCompraOriginal().getid_tipo_transaccion_modulo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(compra.getCompraOriginal().getid_tipo_transaccion_modulo()!=null)
				{
					strValorActual=compra.getCompraOriginal().getid_tipo_transaccion_modulo().toString();
				}
				if(compra.getid_tipo_transaccion_modulo()!=null)
				{
					strValorNuevo=compra.getid_tipo_transaccion_modulo().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),CompraConstantesFunciones.IDTIPOTRANSACCIONMODULO,strValorActual,strValorNuevo);
			}	
			
			if(compra.getIsNew()||!compra.getid_asiento_contable().equals(compra.getCompraOriginal().getid_asiento_contable()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(compra.getCompraOriginal().getid_asiento_contable()!=null)
				{
					strValorActual=compra.getCompraOriginal().getid_asiento_contable().toString();
				}
				if(compra.getid_asiento_contable()!=null)
				{
					strValorNuevo=compra.getid_asiento_contable().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),CompraConstantesFunciones.IDASIENTOCONTABLE,strValorActual,strValorNuevo);
			}	
			
			if(compra.getIsNew()||!compra.getnumero_comprobante().equals(compra.getCompraOriginal().getnumero_comprobante()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(compra.getCompraOriginal().getnumero_comprobante()!=null)
				{
					strValorActual=compra.getCompraOriginal().getnumero_comprobante();
				}
				if(compra.getnumero_comprobante()!=null)
				{
					strValorNuevo=compra.getnumero_comprobante() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),CompraConstantesFunciones.NUMEROCOMPROBANTE,strValorActual,strValorNuevo);
			}	
			
			if(compra.getIsNew()||!compra.getfecha().equals(compra.getCompraOriginal().getfecha()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(compra.getCompraOriginal().getfecha()!=null)
				{
					strValorActual=compra.getCompraOriginal().getfecha().toString();
				}
				if(compra.getfecha()!=null)
				{
					strValorNuevo=compra.getfecha().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),CompraConstantesFunciones.FECHA,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void saveCompraRelacionesWithConnection(Compra compra,List<RetencionInven> retencioninvens,List<TransaccionLocal> transaccionlocals,List<FormaPagoInven> formapagoinvens,List<DetalleCompra> detallecompras) throws Exception {

		if(!compra.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveCompraRelacionesBase(compra,retencioninvens,transaccionlocals,formapagoinvens,detallecompras,true);
		}
	}

	public void saveCompraRelaciones(Compra compra,List<RetencionInven> retencioninvens,List<TransaccionLocal> transaccionlocals,List<FormaPagoInven> formapagoinvens,List<DetalleCompra> detallecompras)throws Exception {

		if(!compra.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveCompraRelacionesBase(compra,retencioninvens,transaccionlocals,formapagoinvens,detallecompras,false);
		}
	}

	public void saveCompraRelacionesBase(Compra compra,List<RetencionInven> retencioninvens,List<TransaccionLocal> transaccionlocals,List<FormaPagoInven> formapagoinvens,List<DetalleCompra> detallecompras,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("Compra-saveRelacionesWithConnection");}
	
			compra.setRetencionInvens(retencioninvens);
			compra.setTransaccionLocals(transaccionlocals);
			compra.setFormaPagoInvens(formapagoinvens);
			compra.setDetalleCompras(detallecompras);

			this.setCompra(compra);

			if(CompraLogicAdditional.validarSaveRelaciones(compra,this)) {

				CompraLogicAdditional.updateRelacionesToSave(compra,this);

				if((compra.getIsNew()||compra.getIsChanged())&&!compra.getIsDeleted()) {
					this.saveCompra();
					this.saveCompraRelacionesDetalles(retencioninvens,transaccionlocals,formapagoinvens,detallecompras);

				} else if(compra.getIsDeleted()) {
					this.saveCompraRelacionesDetalles(retencioninvens,transaccionlocals,formapagoinvens,detallecompras);
					this.saveCompra();
				}

				CompraLogicAdditional.updateRelacionesToSaveAfter(compra,this);

			} else {
				throw new Exception("LOS DATOS SON INVALIDOS");
			}

			if(conConexion) {connexion.commit();}

		} catch(Exception e) {
			
			RetencionInvenConstantesFunciones.InicializarGeneralEntityAuxiliaresRetencionInvens(retencioninvens,true,true);
			TransaccionLocalConstantesFunciones.InicializarGeneralEntityAuxiliaresTransaccionLocals(transaccionlocals,true,true);
			FormaPagoInvenConstantesFunciones.InicializarGeneralEntityAuxiliaresFormaPagoInvens(formapagoinvens,true,true);
			DetalleCompraConstantesFunciones.InicializarGeneralEntityAuxiliaresDetalleCompras(detallecompras,true,true);

			if(conConexion){connexion.rollback();}
			Funciones.manageException(logger,e);
			throw e;

		} finally {
			if(conConexion){this.closeNewConnexionToDeep();}
		}
	}
	
	
	private void saveCompraRelacionesDetalles(List<RetencionInven> retencioninvens,List<TransaccionLocal> transaccionlocals,List<FormaPagoInven> formapagoinvens,List<DetalleCompra> detallecompras)throws Exception {
		try {
	

			Long idCompraActual=this.getCompra().getId();

			RetencionInvenLogic retencioninvenLogic_Desde_Compra=new RetencionInvenLogic();
			retencioninvenLogic_Desde_Compra.setRetencionInvens(retencioninvens);

			retencioninvenLogic_Desde_Compra.setConnexion(this.getConnexion());
			retencioninvenLogic_Desde_Compra.setDatosCliente(this.datosCliente);

			for(RetencionInven retencioninven_Desde_Compra:retencioninvenLogic_Desde_Compra.getRetencionInvens()) {
				retencioninven_Desde_Compra.setid_compra(idCompraActual);
			}

			retencioninvenLogic_Desde_Compra.saveRetencionInvens();

			TransaccionLocalLogic transaccionlocalLogic_Desde_Compra=new TransaccionLocalLogic();
			transaccionlocalLogic_Desde_Compra.setTransaccionLocals(transaccionlocals);

			transaccionlocalLogic_Desde_Compra.setConnexion(this.getConnexion());
			transaccionlocalLogic_Desde_Compra.setDatosCliente(this.datosCliente);

			for(TransaccionLocal transaccionlocal_Desde_Compra:transaccionlocalLogic_Desde_Compra.getTransaccionLocals()) {
				transaccionlocal_Desde_Compra.setid_compra(idCompraActual);
			}

			transaccionlocalLogic_Desde_Compra.saveTransaccionLocals();

			FormaPagoInvenLogic formapagoinvenLogic_Desde_Compra=new FormaPagoInvenLogic();
			formapagoinvenLogic_Desde_Compra.setFormaPagoInvens(formapagoinvens);

			formapagoinvenLogic_Desde_Compra.setConnexion(this.getConnexion());
			formapagoinvenLogic_Desde_Compra.setDatosCliente(this.datosCliente);

			for(FormaPagoInven formapagoinven_Desde_Compra:formapagoinvenLogic_Desde_Compra.getFormaPagoInvens()) {
				formapagoinven_Desde_Compra.setid_compra(idCompraActual);
			}

			formapagoinvenLogic_Desde_Compra.saveFormaPagoInvens();

			DetalleCompraLogic detallecompraLogic_Desde_Compra=new DetalleCompraLogic();
			detallecompraLogic_Desde_Compra.setDetalleCompras(detallecompras);

			detallecompraLogic_Desde_Compra.setConnexion(this.getConnexion());
			detallecompraLogic_Desde_Compra.setDatosCliente(this.datosCliente);

			for(DetalleCompra detallecompra_Desde_Compra:detallecompraLogic_Desde_Compra.getDetalleCompras()) {
				detallecompra_Desde_Compra.setid_compra(idCompraActual);
			}

			detallecompraLogic_Desde_Compra.saveDetalleCompras();

		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfCompra(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=CompraConstantesFunciones.getClassesForeignKeysOfCompra(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfCompra(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=CompraConstantesFunciones.getClassesRelationshipsOfCompra(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}
