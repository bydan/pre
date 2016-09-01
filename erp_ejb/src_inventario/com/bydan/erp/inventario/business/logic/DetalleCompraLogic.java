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
import com.bydan.erp.inventario.util.DetalleCompraConstantesFunciones;
import com.bydan.erp.inventario.util.DetalleCompraParameterReturnGeneral;
//import com.bydan.erp.inventario.util.DetalleCompraParameterGeneral;
import com.bydan.erp.inventario.business.entity.DetalleCompra;
import com.bydan.erp.inventario.business.logic.DetalleCompraLogicAdditional;
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
public class DetalleCompraLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(DetalleCompraLogic.class);
	
	protected DetalleCompraDataAccess detallecompraDataAccess; 	
	protected DetalleCompra detallecompra;
	protected List<DetalleCompra> detallecompras;
	protected Object detallecompraObject;	
	protected List<Object> detallecomprasObject;
	
	public static ClassValidator<DetalleCompra> detallecompraValidator = new ClassValidator<DetalleCompra>(DetalleCompra.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected DetalleCompraLogicAdditional detallecompraLogicAdditional=null;
	
	public DetalleCompraLogicAdditional getDetalleCompraLogicAdditional() {
		return this.detallecompraLogicAdditional;
	}
	
	public void setDetalleCompraLogicAdditional(DetalleCompraLogicAdditional detallecompraLogicAdditional) {
		try {
			this.detallecompraLogicAdditional=detallecompraLogicAdditional;
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
	
	
	
	
	public  DetalleCompraLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.detallecompraDataAccess = new DetalleCompraDataAccess();
			
			this.detallecompras= new ArrayList<DetalleCompra>();
			this.detallecompra= new DetalleCompra();
			
			this.detallecompraObject=new Object();
			this.detallecomprasObject=new ArrayList<Object>();
				
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
			
			this.detallecompraDataAccess.setConnexionType(this.connexionType);
			this.detallecompraDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  DetalleCompraLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.detallecompraDataAccess = new DetalleCompraDataAccess();
			this.detallecompras= new ArrayList<DetalleCompra>();
			this.detallecompra= new DetalleCompra();
			this.detallecompraObject=new Object();
			this.detallecomprasObject=new ArrayList<Object>();
			
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
			
			this.detallecompraDataAccess.setConnexionType(this.connexionType);
			this.detallecompraDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public DetalleCompra getDetalleCompra() throws Exception {	
		DetalleCompraLogicAdditional.checkDetalleCompraToGet(detallecompra,this.datosCliente,this.arrDatoGeneral);
		DetalleCompraLogicAdditional.updateDetalleCompraToGet(detallecompra,this.arrDatoGeneral);
		
		return detallecompra;
	}
		
	public void setDetalleCompra(DetalleCompra newDetalleCompra) {
		this.detallecompra = newDetalleCompra;
	}
	
	public DetalleCompraDataAccess getDetalleCompraDataAccess() {
		return detallecompraDataAccess;
	}
	
	public void setDetalleCompraDataAccess(DetalleCompraDataAccess newdetallecompraDataAccess) {
		this.detallecompraDataAccess = newdetallecompraDataAccess;
	}
	
	public List<DetalleCompra> getDetalleCompras() throws Exception {		
		this.quitarDetalleComprasNulos();
		
		DetalleCompraLogicAdditional.checkDetalleCompraToGets(detallecompras,this.datosCliente,this.arrDatoGeneral);
		
		for (DetalleCompra detallecompraLocal: detallecompras ) {
			DetalleCompraLogicAdditional.updateDetalleCompraToGet(detallecompraLocal,this.arrDatoGeneral);
		}
		
		return detallecompras;
	}
	
	public void setDetalleCompras(List<DetalleCompra> newDetalleCompras) {
		this.detallecompras = newDetalleCompras;
	}
	
	public Object getDetalleCompraObject() {	
		this.detallecompraObject=this.detallecompraDataAccess.getEntityObject();
		return this.detallecompraObject;
	}
		
	public void setDetalleCompraObject(Object newDetalleCompraObject) {
		this.detallecompraObject = newDetalleCompraObject;
	}
	
	public List<Object> getDetalleComprasObject() {		
		this.detallecomprasObject=this.detallecompraDataAccess.getEntitiesObject();
		return this.detallecomprasObject;
	}
		
	public void setDetalleComprasObject(List<Object> newDetalleComprasObject) {
		this.detallecomprasObject = newDetalleComprasObject;
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
		
		if(this.detallecompraDataAccess!=null) {
			this.detallecompraDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleCompra.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			detallecompraDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			detallecompraDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		detallecompra = new  DetalleCompra();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleCompra.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			detallecompra=detallecompraDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.detallecompra,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				DetalleCompraConstantesFunciones.refrescarForeignKeysDescripcionesDetalleCompra(this.detallecompra);
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
		detallecompra = new  DetalleCompra();
		  		  
        try {
			
			detallecompra=detallecompraDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.detallecompra,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				DetalleCompraConstantesFunciones.refrescarForeignKeysDescripcionesDetalleCompra(this.detallecompra);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		detallecompra = new  DetalleCompra();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleCompra.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			detallecompra=detallecompraDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.detallecompra,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				DetalleCompraConstantesFunciones.refrescarForeignKeysDescripcionesDetalleCompra(this.detallecompra);
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
		detallecompra = new  DetalleCompra();
		  		  
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
		detallecompra = new  DetalleCompra();
		  		  
        try {
			
			detallecompra=detallecompraDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.detallecompra,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				DetalleCompraConstantesFunciones.refrescarForeignKeysDescripcionesDetalleCompra(this.detallecompra);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		detallecompra = new  DetalleCompra();
		  		  
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
		detallecompra = new  DetalleCompra();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleCompra.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =detallecompraDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		detallecompra = new  DetalleCompra();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=detallecompraDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		detallecompra = new  DetalleCompra();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleCompra.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =detallecompraDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		detallecompra = new  DetalleCompra();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=detallecompraDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		detallecompra = new  DetalleCompra();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleCompra.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =detallecompraDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		detallecompra = new  DetalleCompra();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=detallecompraDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		detallecompras = new  ArrayList<DetalleCompra>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleCompra.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			DetalleCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detallecompras=detallecompraDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarDetalleCompra(detallecompras);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetalleCompraConstantesFunciones.refrescarForeignKeysDescripcionesDetalleCompra(this.detallecompras);
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
		detallecompras = new  ArrayList<DetalleCompra>();
		  		  
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
		detallecompras = new  ArrayList<DetalleCompra>();
		  		  
        try {			
			DetalleCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detallecompras=detallecompraDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarDetalleCompra(detallecompras);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetalleCompraConstantesFunciones.refrescarForeignKeysDescripcionesDetalleCompra(this.detallecompras);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		detallecompras = new  ArrayList<DetalleCompra>();
		  		  
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
		detallecompras = new  ArrayList<DetalleCompra>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleCompra.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			DetalleCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detallecompras=detallecompraDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarDetalleCompra(detallecompras);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetalleCompraConstantesFunciones.refrescarForeignKeysDescripcionesDetalleCompra(this.detallecompras);
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
		detallecompras = new  ArrayList<DetalleCompra>();
		  		  
        try {
			DetalleCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detallecompras=detallecompraDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarDetalleCompra(detallecompras);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetalleCompraConstantesFunciones.refrescarForeignKeysDescripcionesDetalleCompra(this.detallecompras);
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
		detallecompras = new  ArrayList<DetalleCompra>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleCompra.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			DetalleCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detallecompras=detallecompraDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarDetalleCompra(detallecompras);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetalleCompraConstantesFunciones.refrescarForeignKeysDescripcionesDetalleCompra(this.detallecompras);
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
		detallecompras = new  ArrayList<DetalleCompra>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			DetalleCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detallecompras=detallecompraDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarDetalleCompra(detallecompras);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetalleCompraConstantesFunciones.refrescarForeignKeysDescripcionesDetalleCompra(this.detallecompras);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		detallecompra = new  DetalleCompra();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleCompra.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			DetalleCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detallecompra=detallecompraDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarDetalleCompra(detallecompra);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetalleCompraConstantesFunciones.refrescarForeignKeysDescripcionesDetalleCompra(this.detallecompra);
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
		detallecompra = new  DetalleCompra();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			DetalleCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detallecompra=detallecompraDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarDetalleCompra(detallecompra);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetalleCompraConstantesFunciones.refrescarForeignKeysDescripcionesDetalleCompra(this.detallecompra);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		detallecompras = new  ArrayList<DetalleCompra>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleCompra.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			DetalleCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detallecompras=detallecompraDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarDetalleCompra(detallecompras);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetalleCompraConstantesFunciones.refrescarForeignKeysDescripcionesDetalleCompra(this.detallecompras);
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
		detallecompras = new  ArrayList<DetalleCompra>();
		  		  
        try {
			DetalleCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detallecompras=detallecompraDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarDetalleCompra(detallecompras);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetalleCompraConstantesFunciones.refrescarForeignKeysDescripcionesDetalleCompra(this.detallecompras);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosDetalleComprasWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		detallecompras = new  ArrayList<DetalleCompra>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleCompra.class.getSimpleName()+"-getTodosDetalleComprasWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			DetalleCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detallecompras=detallecompraDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarDetalleCompra(detallecompras);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetalleCompraConstantesFunciones.refrescarForeignKeysDescripcionesDetalleCompra(this.detallecompras);
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
	
	public  void  getTodosDetalleCompras(String sFinalQuery,Pagination pagination)throws Exception {
		detallecompras = new  ArrayList<DetalleCompra>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			DetalleCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detallecompras=detallecompraDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarDetalleCompra(detallecompras);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetalleCompraConstantesFunciones.refrescarForeignKeysDescripcionesDetalleCompra(this.detallecompras);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarDetalleCompra(DetalleCompra detallecompra) throws Exception {
		Boolean estaValidado=false;
		
		if(detallecompra.getIsNew() || detallecompra.getIsChanged()) { 
			this.invalidValues = detallecompraValidator.getInvalidValues(detallecompra);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(detallecompra);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarDetalleCompra(List<DetalleCompra> DetalleCompras) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(DetalleCompra detallecompraLocal:detallecompras) {				
			estaValidadoObjeto=this.validarGuardarDetalleCompra(detallecompraLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarDetalleCompra(List<DetalleCompra> DetalleCompras) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarDetalleCompra(detallecompras)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarDetalleCompra(DetalleCompra DetalleCompra) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarDetalleCompra(detallecompra)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(DetalleCompra detallecompra) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+detallecompra.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=DetalleCompraConstantesFunciones.getDetalleCompraLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"detallecompra","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(DetalleCompraConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(DetalleCompraConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveDetalleCompraWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleCompra.class.getSimpleName()+"-saveDetalleCompraWithConnection");connexion.begin();			
			
			DetalleCompraLogicAdditional.checkDetalleCompraToSave(this.detallecompra,this.datosCliente,connexion,this.arrDatoGeneral);
			
			DetalleCompraLogicAdditional.updateDetalleCompraToSave(this.detallecompra,this.arrDatoGeneral);
			
			DetalleCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.detallecompra,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowDetalleCompra();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarDetalleCompra(this.detallecompra)) {
				DetalleCompraDataAccess.save(this.detallecompra, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.detallecompra,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			DetalleCompraLogicAdditional.checkDetalleCompraToSaveAfter(this.detallecompra,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowDetalleCompra();
			
			connexion.commit();			
			
			if(this.detallecompra.getIsDeleted()) {
				this.detallecompra=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveDetalleCompra()throws Exception {	
		try {	
			
			DetalleCompraLogicAdditional.checkDetalleCompraToSave(this.detallecompra,this.datosCliente,connexion,this.arrDatoGeneral);
			
			DetalleCompraLogicAdditional.updateDetalleCompraToSave(this.detallecompra,this.arrDatoGeneral);
			
			DetalleCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.detallecompra,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarDetalleCompra(this.detallecompra)) {			
				DetalleCompraDataAccess.save(this.detallecompra, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.detallecompra,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			DetalleCompraLogicAdditional.checkDetalleCompraToSaveAfter(this.detallecompra,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.detallecompra.getIsDeleted()) {
				this.detallecompra=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveDetalleComprasWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleCompra.class.getSimpleName()+"-saveDetalleComprasWithConnection");connexion.begin();			
			
			DetalleCompraLogicAdditional.checkDetalleCompraToSaves(detallecompras,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowDetalleCompras();
			
			Boolean validadoTodosDetalleCompra=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(DetalleCompra detallecompraLocal:detallecompras) {		
				if(detallecompraLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				DetalleCompraLogicAdditional.updateDetalleCompraToSave(detallecompraLocal,this.arrDatoGeneral);
	        	
				DetalleCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),detallecompraLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarDetalleCompra(detallecompraLocal)) {
					DetalleCompraDataAccess.save(detallecompraLocal, connexion);				
				} else {
					validadoTodosDetalleCompra=false;
				}
			}
			
			if(!validadoTodosDetalleCompra) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			DetalleCompraLogicAdditional.checkDetalleCompraToSavesAfter(detallecompras,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowDetalleCompras();
			
			connexion.commit();		
			
			this.quitarDetalleComprasEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveDetalleCompras()throws Exception {				
		 try {	
			DetalleCompraLogicAdditional.checkDetalleCompraToSaves(detallecompras,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosDetalleCompra=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(DetalleCompra detallecompraLocal:detallecompras) {				
				if(detallecompraLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				DetalleCompraLogicAdditional.updateDetalleCompraToSave(detallecompraLocal,this.arrDatoGeneral);
	        	
				DetalleCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),detallecompraLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarDetalleCompra(detallecompraLocal)) {				
					DetalleCompraDataAccess.save(detallecompraLocal, connexion);				
				} else {
					validadoTodosDetalleCompra=false;
				}
			}
			
			if(!validadoTodosDetalleCompra) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			DetalleCompraLogicAdditional.checkDetalleCompraToSavesAfter(detallecompras,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarDetalleComprasEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public DetalleCompraParameterReturnGeneral procesarAccionDetalleCompras(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<DetalleCompra> detallecompras,DetalleCompraParameterReturnGeneral detallecompraParameterGeneral)throws Exception {
		 try {	
			DetalleCompraParameterReturnGeneral detallecompraReturnGeneral=new DetalleCompraParameterReturnGeneral();
	
			DetalleCompraLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,detallecompras,detallecompraParameterGeneral,detallecompraReturnGeneral);
			
			return detallecompraReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public DetalleCompraParameterReturnGeneral procesarAccionDetalleComprasWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<DetalleCompra> detallecompras,DetalleCompraParameterReturnGeneral detallecompraParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleCompra.class.getSimpleName()+"-procesarAccionDetalleComprasWithConnection");connexion.begin();			
			
			DetalleCompraParameterReturnGeneral detallecompraReturnGeneral=new DetalleCompraParameterReturnGeneral();
	
			DetalleCompraLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,detallecompras,detallecompraParameterGeneral,detallecompraReturnGeneral);
			
			this.connexion.commit();
			
			return detallecompraReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public DetalleCompraParameterReturnGeneral procesarEventosDetalleCompras(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<DetalleCompra> detallecompras,DetalleCompra detallecompra,DetalleCompraParameterReturnGeneral detallecompraParameterGeneral,Boolean isEsNuevoDetalleCompra,ArrayList<Classe> clases)throws Exception {
		 try {	
			DetalleCompraParameterReturnGeneral detallecompraReturnGeneral=new DetalleCompraParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				detallecompraReturnGeneral.setConRecargarPropiedades(true);
			}
			
			DetalleCompraLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,detallecompras,detallecompra,detallecompraParameterGeneral,detallecompraReturnGeneral,isEsNuevoDetalleCompra,clases);
			
			return detallecompraReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public DetalleCompraParameterReturnGeneral procesarEventosDetalleComprasWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<DetalleCompra> detallecompras,DetalleCompra detallecompra,DetalleCompraParameterReturnGeneral detallecompraParameterGeneral,Boolean isEsNuevoDetalleCompra,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleCompra.class.getSimpleName()+"-procesarEventosDetalleComprasWithConnection");connexion.begin();			
			
			DetalleCompraParameterReturnGeneral detallecompraReturnGeneral=new DetalleCompraParameterReturnGeneral();
	
			detallecompraReturnGeneral.setDetalleCompra(detallecompra);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				detallecompraReturnGeneral.setConRecargarPropiedades(true);
			}
			
			DetalleCompraLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,detallecompras,detallecompra,detallecompraParameterGeneral,detallecompraReturnGeneral,isEsNuevoDetalleCompra,clases);
			
			this.connexion.commit();
			
			return detallecompraReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public DetalleCompraParameterReturnGeneral procesarImportacionDetalleComprasWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,DetalleCompraParameterReturnGeneral detallecompraParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleCompra.class.getSimpleName()+"-procesarImportacionDetalleComprasWithConnection");connexion.begin();			
			
			DetalleCompraParameterReturnGeneral detallecompraReturnGeneral=new DetalleCompraParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.detallecompras=new ArrayList<DetalleCompra>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.detallecompra=new DetalleCompra();
				
				
				if(conColumnasBase) {this.detallecompra.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.detallecompra.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.detallecompra.setdescripcion(arrColumnas[iColumn++]);
				this.detallecompra.setcantidad(Integer.parseInt(arrColumnas[iColumn++]));
				this.detallecompra.setcosto_unitario(Double.parseDouble(arrColumnas[iColumn++]));
				this.detallecompra.setiva(Double.parseDouble(arrColumnas[iColumn++]));
				this.detallecompra.setiva_valor(Double.parseDouble(arrColumnas[iColumn++]));
				this.detallecompra.setcosto_total(Double.parseDouble(arrColumnas[iColumn++]));
				this.detallecompra.setdisponible(Integer.parseInt(arrColumnas[iColumn++]));
				this.detallecompra.setserie(arrColumnas[iColumn++]);
				this.detallecompra.setlote(arrColumnas[iColumn++]);
				this.detallecompra.setfecha_elaboracion_lote(Funciones.ConvertToDate(arrColumnas[iColumn++]));
				this.detallecompra.setfecha_caducidad_lote(Funciones.ConvertToDate(arrColumnas[iColumn++]));
				
				this.detallecompras.add(this.detallecompra);
			}
			
			this.saveDetalleCompras();
			
			this.connexion.commit();
			
			detallecompraReturnGeneral.setConRetornoEstaProcesado(true);
			detallecompraReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return detallecompraReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarDetalleComprasEliminados() throws Exception {				
		
		List<DetalleCompra> detallecomprasAux= new ArrayList<DetalleCompra>();
		
		for(DetalleCompra detallecompra:detallecompras) {
			if(!detallecompra.getIsDeleted()) {
				detallecomprasAux.add(detallecompra);
			}
		}
		
		detallecompras=detallecomprasAux;
	}
	
	public void quitarDetalleComprasNulos() throws Exception {				
		
		List<DetalleCompra> detallecomprasAux= new ArrayList<DetalleCompra>();
		
		for(DetalleCompra detallecompra : this.detallecompras) {
			if(detallecompra==null) {
				detallecomprasAux.add(detallecompra);
			}
		}
		
		//this.detallecompras=detallecomprasAux;
		
		this.detallecompras.removeAll(detallecomprasAux);
	}
	
	public void getSetVersionRowDetalleCompraWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(detallecompra.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((detallecompra.getIsDeleted() || (detallecompra.getIsChanged()&&!detallecompra.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=detallecompraDataAccess.getSetVersionRowDetalleCompra(connexion,detallecompra.getId());
				
				if(!detallecompra.getVersionRow().equals(timestamp)) {	
					detallecompra.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				detallecompra.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowDetalleCompra()throws Exception {	
		
		if(detallecompra.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((detallecompra.getIsDeleted() || (detallecompra.getIsChanged()&&!detallecompra.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=detallecompraDataAccess.getSetVersionRowDetalleCompra(connexion,detallecompra.getId());
			
			try {							
				if(!detallecompra.getVersionRow().equals(timestamp)) {	
					detallecompra.setVersionRow(timestamp);
				}
				
				detallecompra.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowDetalleComprasWithConnection()throws Exception {	
		if(detallecompras!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(DetalleCompra detallecompraAux:detallecompras) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(detallecompraAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(detallecompraAux.getIsDeleted() || (detallecompraAux.getIsChanged()&&!detallecompraAux.getIsNew())) {
						
						timestamp=detallecompraDataAccess.getSetVersionRowDetalleCompra(connexion,detallecompraAux.getId());
						
						if(!detallecompra.getVersionRow().equals(timestamp)) {	
							detallecompraAux.setVersionRow(timestamp);
						}
								
						detallecompraAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowDetalleCompras()throws Exception {	
		if(detallecompras!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(DetalleCompra detallecompraAux:detallecompras) {
					if(detallecompraAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(detallecompraAux.getIsDeleted() || (detallecompraAux.getIsChanged()&&!detallecompraAux.getIsNew())) {
						
						timestamp=detallecompraDataAccess.getSetVersionRowDetalleCompra(connexion,detallecompraAux.getId());
						
						if(!detallecompraAux.getVersionRow().equals(timestamp)) {	
							detallecompraAux.setVersionRow(timestamp);
						}
						
													
						detallecompraAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public DetalleCompraParameterReturnGeneral cargarCombosLoteForeignKeyDetalleCompraWithConnection(String finalQueryGlobalCompra,String finalQueryGlobalEmpresa,String finalQueryGlobalSucursal,String finalQueryGlobalEjercicio,String finalQueryGlobalPeriodo,String finalQueryGlobalAnio,String finalQueryGlobalMes,String finalQueryGlobalEstadoDetalleInventario,String finalQueryGlobalBodega,String finalQueryGlobalProducto,String finalQueryGlobalUnidad,String finalQueryGlobalNovedadProducto,String finalQueryGlobalCentroCosto,String finalQueryGlobalCuentaContableCosto) throws Exception {
		DetalleCompraParameterReturnGeneral  detallecompraReturnGeneral =new DetalleCompraParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleCompra.class.getSimpleName()+"-cargarCombosLoteForeignKeyDetalleCompraWithConnection");connexion.begin();
			
			detallecompraReturnGeneral =new DetalleCompraParameterReturnGeneral();
			
			

			List<Compra> comprasForeignKey=new ArrayList<Compra>();
			CompraLogic compraLogic=new CompraLogic();
			compraLogic.setConnexion(this.connexion);
			compraLogic.getCompraDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCompra.equals("NONE")) {
				compraLogic.getTodosCompras(finalQueryGlobalCompra,new Pagination());
				comprasForeignKey=compraLogic.getCompras();
			}

			detallecompraReturnGeneral.setcomprasForeignKey(comprasForeignKey);


			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			detallecompraReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Sucursal> sucursalsForeignKey=new ArrayList<Sucursal>();
			SucursalLogic sucursalLogic=new SucursalLogic();
			sucursalLogic.setConnexion(this.connexion);
			//sucursalLogic.getSucursalDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalSucursal.equals("NONE")) {
				sucursalLogic.getTodosSucursals(finalQueryGlobalSucursal,new Pagination());
				sucursalsForeignKey=sucursalLogic.getSucursals();
			}

			detallecompraReturnGeneral.setsucursalsForeignKey(sucursalsForeignKey);


			List<Ejercicio> ejerciciosForeignKey=new ArrayList<Ejercicio>();
			EjercicioLogic ejercicioLogic=new EjercicioLogic();
			ejercicioLogic.setConnexion(this.connexion);
			//ejercicioLogic.getEjercicioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEjercicio.equals("NONE")) {
				ejercicioLogic.getTodosEjercicios(finalQueryGlobalEjercicio,new Pagination());
				ejerciciosForeignKey=ejercicioLogic.getEjercicios();
			}

			detallecompraReturnGeneral.setejerciciosForeignKey(ejerciciosForeignKey);


			List<Periodo> periodosForeignKey=new ArrayList<Periodo>();
			PeriodoLogic periodoLogic=new PeriodoLogic();
			periodoLogic.setConnexion(this.connexion);
			//periodoLogic.getPeriodoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalPeriodo.equals("NONE")) {
				periodoLogic.getTodosPeriodos(finalQueryGlobalPeriodo,new Pagination());
				periodosForeignKey=periodoLogic.getPeriodos();
			}

			detallecompraReturnGeneral.setperiodosForeignKey(periodosForeignKey);


			List<Anio> aniosForeignKey=new ArrayList<Anio>();
			AnioLogic anioLogic=new AnioLogic();
			anioLogic.setConnexion(this.connexion);
			anioLogic.getAnioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalAnio.equals("NONE")) {
				anioLogic.getTodosAnios(finalQueryGlobalAnio,new Pagination());
				aniosForeignKey=anioLogic.getAnios();
			}

			detallecompraReturnGeneral.setaniosForeignKey(aniosForeignKey);


			List<Mes> messForeignKey=new ArrayList<Mes>();
			MesLogic mesLogic=new MesLogic();
			mesLogic.setConnexion(this.connexion);
			mesLogic.getMesDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalMes.equals("NONE")) {
				mesLogic.getTodosMess(finalQueryGlobalMes,new Pagination());
				messForeignKey=mesLogic.getMess();
			}

			detallecompraReturnGeneral.setmessForeignKey(messForeignKey);


			List<EstadoDetalleInventario> estadodetalleinventariosForeignKey=new ArrayList<EstadoDetalleInventario>();
			EstadoDetalleInventarioLogic estadodetalleinventarioLogic=new EstadoDetalleInventarioLogic();
			estadodetalleinventarioLogic.setConnexion(this.connexion);
			estadodetalleinventarioLogic.getEstadoDetalleInventarioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEstadoDetalleInventario.equals("NONE")) {
				estadodetalleinventarioLogic.getTodosEstadoDetalleInventarios(finalQueryGlobalEstadoDetalleInventario,new Pagination());
				estadodetalleinventariosForeignKey=estadodetalleinventarioLogic.getEstadoDetalleInventarios();
			}

			detallecompraReturnGeneral.setestadodetalleinventariosForeignKey(estadodetalleinventariosForeignKey);


			List<Bodega> bodegasForeignKey=new ArrayList<Bodega>();
			BodegaLogic bodegaLogic=new BodegaLogic();
			bodegaLogic.setConnexion(this.connexion);
			bodegaLogic.getBodegaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalBodega.equals("NONE")) {
				bodegaLogic.getTodosBodegas(finalQueryGlobalBodega,new Pagination());
				bodegasForeignKey=bodegaLogic.getBodegas();
			}

			detallecompraReturnGeneral.setbodegasForeignKey(bodegasForeignKey);


			List<Producto> productosForeignKey=new ArrayList<Producto>();
			ProductoLogic productoLogic=new ProductoLogic();
			productoLogic.setConnexion(this.connexion);
			//productoLogic.getProductoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalProducto.equals("NONE")) {
				productoLogic.getTodosProductos(finalQueryGlobalProducto,new Pagination());
				productosForeignKey=productoLogic.getProductos();
			}

			detallecompraReturnGeneral.setproductosForeignKey(productosForeignKey);


			List<Unidad> unidadsForeignKey=new ArrayList<Unidad>();
			UnidadLogic unidadLogic=new UnidadLogic();
			unidadLogic.setConnexion(this.connexion);
			unidadLogic.getUnidadDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalUnidad.equals("NONE")) {
				unidadLogic.getTodosUnidads(finalQueryGlobalUnidad,new Pagination());
				unidadsForeignKey=unidadLogic.getUnidads();
			}

			detallecompraReturnGeneral.setunidadsForeignKey(unidadsForeignKey);


			List<NovedadProducto> novedadproductosForeignKey=new ArrayList<NovedadProducto>();
			NovedadProductoLogic novedadproductoLogic=new NovedadProductoLogic();
			novedadproductoLogic.setConnexion(this.connexion);
			novedadproductoLogic.getNovedadProductoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalNovedadProducto.equals("NONE")) {
				novedadproductoLogic.getTodosNovedadProductos(finalQueryGlobalNovedadProducto,new Pagination());
				novedadproductosForeignKey=novedadproductoLogic.getNovedadProductos();
			}

			detallecompraReturnGeneral.setnovedadproductosForeignKey(novedadproductosForeignKey);


			List<CentroCosto> centrocostosForeignKey=new ArrayList<CentroCosto>();
			CentroCostoLogic centrocostoLogic=new CentroCostoLogic();
			centrocostoLogic.setConnexion(this.connexion);
			centrocostoLogic.getCentroCostoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCentroCosto.equals("NONE")) {
				centrocostoLogic.getTodosCentroCostos(finalQueryGlobalCentroCosto,new Pagination());
				centrocostosForeignKey=centrocostoLogic.getCentroCostos();
			}

			detallecompraReturnGeneral.setcentrocostosForeignKey(centrocostosForeignKey);


			List<CuentaContable> cuentacontablecostosForeignKey=new ArrayList<CuentaContable>();
			CuentaContableLogic cuentacontablecostoLogic=new CuentaContableLogic();
			cuentacontablecostoLogic.setConnexion(this.connexion);
			cuentacontablecostoLogic.getCuentaContableDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCuentaContableCosto.equals("NONE")) {
				cuentacontablecostoLogic.getTodosCuentaContables(finalQueryGlobalCuentaContableCosto,new Pagination());
				cuentacontablecostosForeignKey=cuentacontablecostoLogic.getCuentaContables();
			}

			detallecompraReturnGeneral.setcuentacontablecostosForeignKey(cuentacontablecostosForeignKey);

			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
		
		return detallecompraReturnGeneral;
	}
	
	public DetalleCompraParameterReturnGeneral cargarCombosLoteForeignKeyDetalleCompra(String finalQueryGlobalCompra,String finalQueryGlobalEmpresa,String finalQueryGlobalSucursal,String finalQueryGlobalEjercicio,String finalQueryGlobalPeriodo,String finalQueryGlobalAnio,String finalQueryGlobalMes,String finalQueryGlobalEstadoDetalleInventario,String finalQueryGlobalBodega,String finalQueryGlobalProducto,String finalQueryGlobalUnidad,String finalQueryGlobalNovedadProducto,String finalQueryGlobalCentroCosto,String finalQueryGlobalCuentaContableCosto) throws Exception {
		DetalleCompraParameterReturnGeneral  detallecompraReturnGeneral =new DetalleCompraParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {						
			detallecompraReturnGeneral =new DetalleCompraParameterReturnGeneral();
			
			

			List<Compra> comprasForeignKey=new ArrayList<Compra>();
			CompraLogic compraLogic=new CompraLogic();
			compraLogic.setConnexion(this.connexion);
			compraLogic.getCompraDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCompra.equals("NONE")) {
				compraLogic.getTodosCompras(finalQueryGlobalCompra,new Pagination());
				comprasForeignKey=compraLogic.getCompras();
			}

			detallecompraReturnGeneral.setcomprasForeignKey(comprasForeignKey);


			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			detallecompraReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Sucursal> sucursalsForeignKey=new ArrayList<Sucursal>();
			SucursalLogic sucursalLogic=new SucursalLogic();
			sucursalLogic.setConnexion(this.connexion);
			//sucursalLogic.getSucursalDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalSucursal.equals("NONE")) {
				sucursalLogic.getTodosSucursals(finalQueryGlobalSucursal,new Pagination());
				sucursalsForeignKey=sucursalLogic.getSucursals();
			}

			detallecompraReturnGeneral.setsucursalsForeignKey(sucursalsForeignKey);


			List<Ejercicio> ejerciciosForeignKey=new ArrayList<Ejercicio>();
			EjercicioLogic ejercicioLogic=new EjercicioLogic();
			ejercicioLogic.setConnexion(this.connexion);
			//ejercicioLogic.getEjercicioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEjercicio.equals("NONE")) {
				ejercicioLogic.getTodosEjercicios(finalQueryGlobalEjercicio,new Pagination());
				ejerciciosForeignKey=ejercicioLogic.getEjercicios();
			}

			detallecompraReturnGeneral.setejerciciosForeignKey(ejerciciosForeignKey);


			List<Periodo> periodosForeignKey=new ArrayList<Periodo>();
			PeriodoLogic periodoLogic=new PeriodoLogic();
			periodoLogic.setConnexion(this.connexion);
			//periodoLogic.getPeriodoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalPeriodo.equals("NONE")) {
				periodoLogic.getTodosPeriodos(finalQueryGlobalPeriodo,new Pagination());
				periodosForeignKey=periodoLogic.getPeriodos();
			}

			detallecompraReturnGeneral.setperiodosForeignKey(periodosForeignKey);


			List<Anio> aniosForeignKey=new ArrayList<Anio>();
			AnioLogic anioLogic=new AnioLogic();
			anioLogic.setConnexion(this.connexion);
			anioLogic.getAnioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalAnio.equals("NONE")) {
				anioLogic.getTodosAnios(finalQueryGlobalAnio,new Pagination());
				aniosForeignKey=anioLogic.getAnios();
			}

			detallecompraReturnGeneral.setaniosForeignKey(aniosForeignKey);


			List<Mes> messForeignKey=new ArrayList<Mes>();
			MesLogic mesLogic=new MesLogic();
			mesLogic.setConnexion(this.connexion);
			mesLogic.getMesDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalMes.equals("NONE")) {
				mesLogic.getTodosMess(finalQueryGlobalMes,new Pagination());
				messForeignKey=mesLogic.getMess();
			}

			detallecompraReturnGeneral.setmessForeignKey(messForeignKey);


			List<EstadoDetalleInventario> estadodetalleinventariosForeignKey=new ArrayList<EstadoDetalleInventario>();
			EstadoDetalleInventarioLogic estadodetalleinventarioLogic=new EstadoDetalleInventarioLogic();
			estadodetalleinventarioLogic.setConnexion(this.connexion);
			estadodetalleinventarioLogic.getEstadoDetalleInventarioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEstadoDetalleInventario.equals("NONE")) {
				estadodetalleinventarioLogic.getTodosEstadoDetalleInventarios(finalQueryGlobalEstadoDetalleInventario,new Pagination());
				estadodetalleinventariosForeignKey=estadodetalleinventarioLogic.getEstadoDetalleInventarios();
			}

			detallecompraReturnGeneral.setestadodetalleinventariosForeignKey(estadodetalleinventariosForeignKey);


			List<Bodega> bodegasForeignKey=new ArrayList<Bodega>();
			BodegaLogic bodegaLogic=new BodegaLogic();
			bodegaLogic.setConnexion(this.connexion);
			bodegaLogic.getBodegaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalBodega.equals("NONE")) {
				bodegaLogic.getTodosBodegas(finalQueryGlobalBodega,new Pagination());
				bodegasForeignKey=bodegaLogic.getBodegas();
			}

			detallecompraReturnGeneral.setbodegasForeignKey(bodegasForeignKey);


			List<Producto> productosForeignKey=new ArrayList<Producto>();
			ProductoLogic productoLogic=new ProductoLogic();
			productoLogic.setConnexion(this.connexion);
			//productoLogic.getProductoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalProducto.equals("NONE")) {
				productoLogic.getTodosProductos(finalQueryGlobalProducto,new Pagination());
				productosForeignKey=productoLogic.getProductos();
			}

			detallecompraReturnGeneral.setproductosForeignKey(productosForeignKey);


			List<Unidad> unidadsForeignKey=new ArrayList<Unidad>();
			UnidadLogic unidadLogic=new UnidadLogic();
			unidadLogic.setConnexion(this.connexion);
			unidadLogic.getUnidadDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalUnidad.equals("NONE")) {
				unidadLogic.getTodosUnidads(finalQueryGlobalUnidad,new Pagination());
				unidadsForeignKey=unidadLogic.getUnidads();
			}

			detallecompraReturnGeneral.setunidadsForeignKey(unidadsForeignKey);


			List<NovedadProducto> novedadproductosForeignKey=new ArrayList<NovedadProducto>();
			NovedadProductoLogic novedadproductoLogic=new NovedadProductoLogic();
			novedadproductoLogic.setConnexion(this.connexion);
			novedadproductoLogic.getNovedadProductoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalNovedadProducto.equals("NONE")) {
				novedadproductoLogic.getTodosNovedadProductos(finalQueryGlobalNovedadProducto,new Pagination());
				novedadproductosForeignKey=novedadproductoLogic.getNovedadProductos();
			}

			detallecompraReturnGeneral.setnovedadproductosForeignKey(novedadproductosForeignKey);


			List<CentroCosto> centrocostosForeignKey=new ArrayList<CentroCosto>();
			CentroCostoLogic centrocostoLogic=new CentroCostoLogic();
			centrocostoLogic.setConnexion(this.connexion);
			centrocostoLogic.getCentroCostoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCentroCosto.equals("NONE")) {
				centrocostoLogic.getTodosCentroCostos(finalQueryGlobalCentroCosto,new Pagination());
				centrocostosForeignKey=centrocostoLogic.getCentroCostos();
			}

			detallecompraReturnGeneral.setcentrocostosForeignKey(centrocostosForeignKey);


			List<CuentaContable> cuentacontablecostosForeignKey=new ArrayList<CuentaContable>();
			CuentaContableLogic cuentacontablecostoLogic=new CuentaContableLogic();
			cuentacontablecostoLogic.setConnexion(this.connexion);
			cuentacontablecostoLogic.getCuentaContableDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCuentaContableCosto.equals("NONE")) {
				cuentacontablecostoLogic.getTodosCuentaContables(finalQueryGlobalCuentaContableCosto,new Pagination());
				cuentacontablecostosForeignKey=cuentacontablecostoLogic.getCuentaContables();
			}

			detallecompraReturnGeneral.setcuentacontablecostosForeignKey(cuentacontablecostosForeignKey);
						
			
		} catch(Exception e) {			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			
		}
		
		return detallecompraReturnGeneral;
	}
	
	
	public void deepLoad(DetalleCompra detallecompra,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			DetalleCompraLogicAdditional.updateDetalleCompraToGet(detallecompra,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		detallecompra.setCompra(detallecompraDataAccess.getCompra(connexion,detallecompra));
		detallecompra.setEmpresa(detallecompraDataAccess.getEmpresa(connexion,detallecompra));
		detallecompra.setSucursal(detallecompraDataAccess.getSucursal(connexion,detallecompra));
		detallecompra.setEjercicio(detallecompraDataAccess.getEjercicio(connexion,detallecompra));
		detallecompra.setPeriodo(detallecompraDataAccess.getPeriodo(connexion,detallecompra));
		detallecompra.setAnio(detallecompraDataAccess.getAnio(connexion,detallecompra));
		detallecompra.setMes(detallecompraDataAccess.getMes(connexion,detallecompra));
		detallecompra.setEstadoDetalleInventario(detallecompraDataAccess.getEstadoDetalleInventario(connexion,detallecompra));
		detallecompra.setBodega(detallecompraDataAccess.getBodega(connexion,detallecompra));
		detallecompra.setProducto(detallecompraDataAccess.getProducto(connexion,detallecompra));
		detallecompra.setUnidad(detallecompraDataAccess.getUnidad(connexion,detallecompra));
		detallecompra.setNovedadProducto(detallecompraDataAccess.getNovedadProducto(connexion,detallecompra));
		detallecompra.setCentroCosto(detallecompraDataAccess.getCentroCosto(connexion,detallecompra));
		detallecompra.setCuentaContableCosto(detallecompraDataAccess.getCuentaContableCosto(connexion,detallecompra));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Compra.class)) {
				detallecompra.setCompra(detallecompraDataAccess.getCompra(connexion,detallecompra));
				continue;
			}

			if(clas.clas.equals(Empresa.class)) {
				detallecompra.setEmpresa(detallecompraDataAccess.getEmpresa(connexion,detallecompra));
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				detallecompra.setSucursal(detallecompraDataAccess.getSucursal(connexion,detallecompra));
				continue;
			}

			if(clas.clas.equals(Ejercicio.class)) {
				detallecompra.setEjercicio(detallecompraDataAccess.getEjercicio(connexion,detallecompra));
				continue;
			}

			if(clas.clas.equals(Periodo.class)) {
				detallecompra.setPeriodo(detallecompraDataAccess.getPeriodo(connexion,detallecompra));
				continue;
			}

			if(clas.clas.equals(Anio.class)) {
				detallecompra.setAnio(detallecompraDataAccess.getAnio(connexion,detallecompra));
				continue;
			}

			if(clas.clas.equals(Mes.class)) {
				detallecompra.setMes(detallecompraDataAccess.getMes(connexion,detallecompra));
				continue;
			}

			if(clas.clas.equals(EstadoDetalleInventario.class)) {
				detallecompra.setEstadoDetalleInventario(detallecompraDataAccess.getEstadoDetalleInventario(connexion,detallecompra));
				continue;
			}

			if(clas.clas.equals(Bodega.class)) {
				detallecompra.setBodega(detallecompraDataAccess.getBodega(connexion,detallecompra));
				continue;
			}

			if(clas.clas.equals(Producto.class)) {
				detallecompra.setProducto(detallecompraDataAccess.getProducto(connexion,detallecompra));
				continue;
			}

			if(clas.clas.equals(Unidad.class)) {
				detallecompra.setUnidad(detallecompraDataAccess.getUnidad(connexion,detallecompra));
				continue;
			}

			if(clas.clas.equals(NovedadProducto.class)) {
				detallecompra.setNovedadProducto(detallecompraDataAccess.getNovedadProducto(connexion,detallecompra));
				continue;
			}

			if(clas.clas.equals(CentroCosto.class)) {
				detallecompra.setCentroCosto(detallecompraDataAccess.getCentroCosto(connexion,detallecompra));
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				detallecompra.setCuentaContableCosto(detallecompraDataAccess.getCuentaContableCosto(connexion,detallecompra));
				continue;
			}
		}
	}
	else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Compra.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detallecompra.setCompra(detallecompraDataAccess.getCompra(connexion,detallecompra));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detallecompra.setEmpresa(detallecompraDataAccess.getEmpresa(connexion,detallecompra));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detallecompra.setSucursal(detallecompraDataAccess.getSucursal(connexion,detallecompra));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Ejercicio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detallecompra.setEjercicio(detallecompraDataAccess.getEjercicio(connexion,detallecompra));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Periodo.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detallecompra.setPeriodo(detallecompraDataAccess.getPeriodo(connexion,detallecompra));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Anio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detallecompra.setAnio(detallecompraDataAccess.getAnio(connexion,detallecompra));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Mes.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detallecompra.setMes(detallecompraDataAccess.getMes(connexion,detallecompra));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(EstadoDetalleInventario.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detallecompra.setEstadoDetalleInventario(detallecompraDataAccess.getEstadoDetalleInventario(connexion,detallecompra));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Bodega.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detallecompra.setBodega(detallecompraDataAccess.getBodega(connexion,detallecompra));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Producto.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detallecompra.setProducto(detallecompraDataAccess.getProducto(connexion,detallecompra));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Unidad.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detallecompra.setUnidad(detallecompraDataAccess.getUnidad(connexion,detallecompra));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(NovedadProducto.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detallecompra.setNovedadProducto(detallecompraDataAccess.getNovedadProducto(connexion,detallecompra));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(CentroCosto.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detallecompra.setCentroCosto(detallecompraDataAccess.getCentroCosto(connexion,detallecompra));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(CuentaContable.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detallecompra.setCuentaContableCosto(detallecompraDataAccess.getCuentaContableCosto(connexion,detallecompra));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		detallecompra.setCompra(detallecompraDataAccess.getCompra(connexion,detallecompra));
		CompraLogic compraLogic= new CompraLogic(connexion);
		compraLogic.deepLoad(detallecompra.getCompra(),isDeep,deepLoadType,clases);
				
		detallecompra.setEmpresa(detallecompraDataAccess.getEmpresa(connexion,detallecompra));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(detallecompra.getEmpresa(),isDeep,deepLoadType,clases);
				
		detallecompra.setSucursal(detallecompraDataAccess.getSucursal(connexion,detallecompra));
		SucursalLogic sucursalLogic= new SucursalLogic(connexion);
		sucursalLogic.deepLoad(detallecompra.getSucursal(),isDeep,deepLoadType,clases);
				
		detallecompra.setEjercicio(detallecompraDataAccess.getEjercicio(connexion,detallecompra));
		EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
		ejercicioLogic.deepLoad(detallecompra.getEjercicio(),isDeep,deepLoadType,clases);
				
		detallecompra.setPeriodo(detallecompraDataAccess.getPeriodo(connexion,detallecompra));
		PeriodoLogic periodoLogic= new PeriodoLogic(connexion);
		periodoLogic.deepLoad(detallecompra.getPeriodo(),isDeep,deepLoadType,clases);
				
		detallecompra.setAnio(detallecompraDataAccess.getAnio(connexion,detallecompra));
		AnioLogic anioLogic= new AnioLogic(connexion);
		anioLogic.deepLoad(detallecompra.getAnio(),isDeep,deepLoadType,clases);
				
		detallecompra.setMes(detallecompraDataAccess.getMes(connexion,detallecompra));
		MesLogic mesLogic= new MesLogic(connexion);
		mesLogic.deepLoad(detallecompra.getMes(),isDeep,deepLoadType,clases);
				
		detallecompra.setEstadoDetalleInventario(detallecompraDataAccess.getEstadoDetalleInventario(connexion,detallecompra));
		EstadoDetalleInventarioLogic estadodetalleinventarioLogic= new EstadoDetalleInventarioLogic(connexion);
		estadodetalleinventarioLogic.deepLoad(detallecompra.getEstadoDetalleInventario(),isDeep,deepLoadType,clases);
				
		detallecompra.setBodega(detallecompraDataAccess.getBodega(connexion,detallecompra));
		BodegaLogic bodegaLogic= new BodegaLogic(connexion);
		bodegaLogic.deepLoad(detallecompra.getBodega(),isDeep,deepLoadType,clases);
				
		detallecompra.setProducto(detallecompraDataAccess.getProducto(connexion,detallecompra));
		ProductoLogic productoLogic= new ProductoLogic(connexion);
		productoLogic.deepLoad(detallecompra.getProducto(),isDeep,deepLoadType,clases);
				
		detallecompra.setUnidad(detallecompraDataAccess.getUnidad(connexion,detallecompra));
		UnidadLogic unidadLogic= new UnidadLogic(connexion);
		unidadLogic.deepLoad(detallecompra.getUnidad(),isDeep,deepLoadType,clases);
				
		detallecompra.setNovedadProducto(detallecompraDataAccess.getNovedadProducto(connexion,detallecompra));
		NovedadProductoLogic novedadproductoLogic= new NovedadProductoLogic(connexion);
		novedadproductoLogic.deepLoad(detallecompra.getNovedadProducto(),isDeep,deepLoadType,clases);
				
		detallecompra.setCentroCosto(detallecompraDataAccess.getCentroCosto(connexion,detallecompra));
		CentroCostoLogic centrocostoLogic= new CentroCostoLogic(connexion);
		centrocostoLogic.deepLoad(detallecompra.getCentroCosto(),isDeep,deepLoadType,clases);
				
		detallecompra.setCuentaContableCosto(detallecompraDataAccess.getCuentaContableCosto(connexion,detallecompra));
		CuentaContableLogic cuentacontablecostoLogic= new CuentaContableLogic(connexion);
		cuentacontablecostoLogic.deepLoad(detallecompra.getCuentaContableCosto(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Compra.class)) {
				detallecompra.setCompra(detallecompraDataAccess.getCompra(connexion,detallecompra));
				CompraLogic compraLogic= new CompraLogic(connexion);
				compraLogic.deepLoad(detallecompra.getCompra(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Empresa.class)) {
				detallecompra.setEmpresa(detallecompraDataAccess.getEmpresa(connexion,detallecompra));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(detallecompra.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				detallecompra.setSucursal(detallecompraDataAccess.getSucursal(connexion,detallecompra));
				SucursalLogic sucursalLogic= new SucursalLogic(connexion);
				sucursalLogic.deepLoad(detallecompra.getSucursal(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Ejercicio.class)) {
				detallecompra.setEjercicio(detallecompraDataAccess.getEjercicio(connexion,detallecompra));
				EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
				ejercicioLogic.deepLoad(detallecompra.getEjercicio(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Periodo.class)) {
				detallecompra.setPeriodo(detallecompraDataAccess.getPeriodo(connexion,detallecompra));
				PeriodoLogic periodoLogic= new PeriodoLogic(connexion);
				periodoLogic.deepLoad(detallecompra.getPeriodo(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Anio.class)) {
				detallecompra.setAnio(detallecompraDataAccess.getAnio(connexion,detallecompra));
				AnioLogic anioLogic= new AnioLogic(connexion);
				anioLogic.deepLoad(detallecompra.getAnio(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Mes.class)) {
				detallecompra.setMes(detallecompraDataAccess.getMes(connexion,detallecompra));
				MesLogic mesLogic= new MesLogic(connexion);
				mesLogic.deepLoad(detallecompra.getMes(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(EstadoDetalleInventario.class)) {
				detallecompra.setEstadoDetalleInventario(detallecompraDataAccess.getEstadoDetalleInventario(connexion,detallecompra));
				EstadoDetalleInventarioLogic estadodetalleinventarioLogic= new EstadoDetalleInventarioLogic(connexion);
				estadodetalleinventarioLogic.deepLoad(detallecompra.getEstadoDetalleInventario(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Bodega.class)) {
				detallecompra.setBodega(detallecompraDataAccess.getBodega(connexion,detallecompra));
				BodegaLogic bodegaLogic= new BodegaLogic(connexion);
				bodegaLogic.deepLoad(detallecompra.getBodega(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Producto.class)) {
				detallecompra.setProducto(detallecompraDataAccess.getProducto(connexion,detallecompra));
				ProductoLogic productoLogic= new ProductoLogic(connexion);
				productoLogic.deepLoad(detallecompra.getProducto(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Unidad.class)) {
				detallecompra.setUnidad(detallecompraDataAccess.getUnidad(connexion,detallecompra));
				UnidadLogic unidadLogic= new UnidadLogic(connexion);
				unidadLogic.deepLoad(detallecompra.getUnidad(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(NovedadProducto.class)) {
				detallecompra.setNovedadProducto(detallecompraDataAccess.getNovedadProducto(connexion,detallecompra));
				NovedadProductoLogic novedadproductoLogic= new NovedadProductoLogic(connexion);
				novedadproductoLogic.deepLoad(detallecompra.getNovedadProducto(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(CentroCosto.class)) {
				detallecompra.setCentroCosto(detallecompraDataAccess.getCentroCosto(connexion,detallecompra));
				CentroCostoLogic centrocostoLogic= new CentroCostoLogic(connexion);
				centrocostoLogic.deepLoad(detallecompra.getCentroCosto(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				detallecompra.setCuentaContableCosto(detallecompraDataAccess.getCuentaContableCosto(connexion,detallecompra));
				CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
				cuentacontableLogic.deepLoad(detallecompra.getCuentaContableCosto(),isDeep,deepLoadType,clases);				
				continue;
			}

		}
	}
	else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {


		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Compra.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detallecompra.setCompra(detallecompraDataAccess.getCompra(connexion,detallecompra));
			CompraLogic compraLogic= new CompraLogic(connexion);
			compraLogic.deepLoad(detallecompra.getCompra(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detallecompra.setEmpresa(detallecompraDataAccess.getEmpresa(connexion,detallecompra));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(detallecompra.getEmpresa(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detallecompra.setSucursal(detallecompraDataAccess.getSucursal(connexion,detallecompra));
			SucursalLogic sucursalLogic= new SucursalLogic(connexion);
			sucursalLogic.deepLoad(detallecompra.getSucursal(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Ejercicio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detallecompra.setEjercicio(detallecompraDataAccess.getEjercicio(connexion,detallecompra));
			EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
			ejercicioLogic.deepLoad(detallecompra.getEjercicio(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Periodo.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detallecompra.setPeriodo(detallecompraDataAccess.getPeriodo(connexion,detallecompra));
			PeriodoLogic periodoLogic= new PeriodoLogic(connexion);
			periodoLogic.deepLoad(detallecompra.getPeriodo(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Anio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detallecompra.setAnio(detallecompraDataAccess.getAnio(connexion,detallecompra));
			AnioLogic anioLogic= new AnioLogic(connexion);
			anioLogic.deepLoad(detallecompra.getAnio(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Mes.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detallecompra.setMes(detallecompraDataAccess.getMes(connexion,detallecompra));
			MesLogic mesLogic= new MesLogic(connexion);
			mesLogic.deepLoad(detallecompra.getMes(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(EstadoDetalleInventario.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detallecompra.setEstadoDetalleInventario(detallecompraDataAccess.getEstadoDetalleInventario(connexion,detallecompra));
			EstadoDetalleInventarioLogic estadodetalleinventarioLogic= new EstadoDetalleInventarioLogic(connexion);
			estadodetalleinventarioLogic.deepLoad(detallecompra.getEstadoDetalleInventario(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Bodega.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detallecompra.setBodega(detallecompraDataAccess.getBodega(connexion,detallecompra));
			BodegaLogic bodegaLogic= new BodegaLogic(connexion);
			bodegaLogic.deepLoad(detallecompra.getBodega(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Producto.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detallecompra.setProducto(detallecompraDataAccess.getProducto(connexion,detallecompra));
			ProductoLogic productoLogic= new ProductoLogic(connexion);
			productoLogic.deepLoad(detallecompra.getProducto(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Unidad.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detallecompra.setUnidad(detallecompraDataAccess.getUnidad(connexion,detallecompra));
			UnidadLogic unidadLogic= new UnidadLogic(connexion);
			unidadLogic.deepLoad(detallecompra.getUnidad(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(NovedadProducto.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detallecompra.setNovedadProducto(detallecompraDataAccess.getNovedadProducto(connexion,detallecompra));
			NovedadProductoLogic novedadproductoLogic= new NovedadProductoLogic(connexion);
			novedadproductoLogic.deepLoad(detallecompra.getNovedadProducto(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(CentroCosto.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detallecompra.setCentroCosto(detallecompraDataAccess.getCentroCosto(connexion,detallecompra));
			CentroCostoLogic centrocostoLogic= new CentroCostoLogic(connexion);
			centrocostoLogic.deepLoad(detallecompra.getCentroCosto(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(CuentaContable.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detallecompra.setCuentaContableCosto(detallecompraDataAccess.getCuentaContableCosto(connexion,detallecompra));
			CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
			cuentacontableLogic.deepLoad(detallecompra.getCuentaContableCosto(),isDeep,deepLoadType,clases);
				
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(DetalleCompra detallecompra,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			DetalleCompraLogicAdditional.updateDetalleCompraToSave(detallecompra,this.arrDatoGeneral);
			
DetalleCompraDataAccess.save(detallecompra, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		CompraDataAccess.save(detallecompra.getCompra(),connexion);

		EmpresaDataAccess.save(detallecompra.getEmpresa(),connexion);

		SucursalDataAccess.save(detallecompra.getSucursal(),connexion);

		EjercicioDataAccess.save(detallecompra.getEjercicio(),connexion);

		PeriodoDataAccess.save(detallecompra.getPeriodo(),connexion);

		AnioDataAccess.save(detallecompra.getAnio(),connexion);

		MesDataAccess.save(detallecompra.getMes(),connexion);

		EstadoDetalleInventarioDataAccess.save(detallecompra.getEstadoDetalleInventario(),connexion);

		BodegaDataAccess.save(detallecompra.getBodega(),connexion);

		ProductoDataAccess.save(detallecompra.getProducto(),connexion);

		UnidadDataAccess.save(detallecompra.getUnidad(),connexion);

		NovedadProductoDataAccess.save(detallecompra.getNovedadProducto(),connexion);

		CentroCostoDataAccess.save(detallecompra.getCentroCosto(),connexion);

		CuentaContableDataAccess.save(detallecompra.getCuentaContableCosto(),connexion);
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Compra.class)) {
				CompraDataAccess.save(detallecompra.getCompra(),connexion);
				continue;
			}

			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(detallecompra.getEmpresa(),connexion);
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				SucursalDataAccess.save(detallecompra.getSucursal(),connexion);
				continue;
			}

			if(clas.clas.equals(Ejercicio.class)) {
				EjercicioDataAccess.save(detallecompra.getEjercicio(),connexion);
				continue;
			}

			if(clas.clas.equals(Periodo.class)) {
				PeriodoDataAccess.save(detallecompra.getPeriodo(),connexion);
				continue;
			}

			if(clas.clas.equals(Anio.class)) {
				AnioDataAccess.save(detallecompra.getAnio(),connexion);
				continue;
			}

			if(clas.clas.equals(Mes.class)) {
				MesDataAccess.save(detallecompra.getMes(),connexion);
				continue;
			}

			if(clas.clas.equals(EstadoDetalleInventario.class)) {
				EstadoDetalleInventarioDataAccess.save(detallecompra.getEstadoDetalleInventario(),connexion);
				continue;
			}

			if(clas.clas.equals(Bodega.class)) {
				BodegaDataAccess.save(detallecompra.getBodega(),connexion);
				continue;
			}

			if(clas.clas.equals(Producto.class)) {
				ProductoDataAccess.save(detallecompra.getProducto(),connexion);
				continue;
			}

			if(clas.clas.equals(Unidad.class)) {
				UnidadDataAccess.save(detallecompra.getUnidad(),connexion);
				continue;
			}

			if(clas.clas.equals(NovedadProducto.class)) {
				NovedadProductoDataAccess.save(detallecompra.getNovedadProducto(),connexion);
				continue;
			}

			if(clas.clas.equals(CentroCosto.class)) {
				CentroCostoDataAccess.save(detallecompra.getCentroCosto(),connexion);
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				CuentaContableDataAccess.save(detallecompra.getCuentaContableCosto(),connexion);
				continue;
			}

		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		CompraDataAccess.save(detallecompra.getCompra(),connexion);
		CompraLogic compraLogic= new CompraLogic(connexion);
		compraLogic.deepLoad(detallecompra.getCompra(),isDeep,deepLoadType,clases);
				

		EmpresaDataAccess.save(detallecompra.getEmpresa(),connexion);
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(detallecompra.getEmpresa(),isDeep,deepLoadType,clases);
				

		SucursalDataAccess.save(detallecompra.getSucursal(),connexion);
		SucursalLogic sucursalLogic= new SucursalLogic(connexion);
		sucursalLogic.deepLoad(detallecompra.getSucursal(),isDeep,deepLoadType,clases);
				

		EjercicioDataAccess.save(detallecompra.getEjercicio(),connexion);
		EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
		ejercicioLogic.deepLoad(detallecompra.getEjercicio(),isDeep,deepLoadType,clases);
				

		PeriodoDataAccess.save(detallecompra.getPeriodo(),connexion);
		PeriodoLogic periodoLogic= new PeriodoLogic(connexion);
		periodoLogic.deepLoad(detallecompra.getPeriodo(),isDeep,deepLoadType,clases);
				

		AnioDataAccess.save(detallecompra.getAnio(),connexion);
		AnioLogic anioLogic= new AnioLogic(connexion);
		anioLogic.deepLoad(detallecompra.getAnio(),isDeep,deepLoadType,clases);
				

		MesDataAccess.save(detallecompra.getMes(),connexion);
		MesLogic mesLogic= new MesLogic(connexion);
		mesLogic.deepLoad(detallecompra.getMes(),isDeep,deepLoadType,clases);
				

		EstadoDetalleInventarioDataAccess.save(detallecompra.getEstadoDetalleInventario(),connexion);
		EstadoDetalleInventarioLogic estadodetalleinventarioLogic= new EstadoDetalleInventarioLogic(connexion);
		estadodetalleinventarioLogic.deepLoad(detallecompra.getEstadoDetalleInventario(),isDeep,deepLoadType,clases);
				

		BodegaDataAccess.save(detallecompra.getBodega(),connexion);
		BodegaLogic bodegaLogic= new BodegaLogic(connexion);
		bodegaLogic.deepLoad(detallecompra.getBodega(),isDeep,deepLoadType,clases);
				

		ProductoDataAccess.save(detallecompra.getProducto(),connexion);
		ProductoLogic productoLogic= new ProductoLogic(connexion);
		productoLogic.deepLoad(detallecompra.getProducto(),isDeep,deepLoadType,clases);
				

		UnidadDataAccess.save(detallecompra.getUnidad(),connexion);
		UnidadLogic unidadLogic= new UnidadLogic(connexion);
		unidadLogic.deepLoad(detallecompra.getUnidad(),isDeep,deepLoadType,clases);
				

		NovedadProductoDataAccess.save(detallecompra.getNovedadProducto(),connexion);
		NovedadProductoLogic novedadproductoLogic= new NovedadProductoLogic(connexion);
		novedadproductoLogic.deepLoad(detallecompra.getNovedadProducto(),isDeep,deepLoadType,clases);
				

		CentroCostoDataAccess.save(detallecompra.getCentroCosto(),connexion);
		CentroCostoLogic centrocostoLogic= new CentroCostoLogic(connexion);
		centrocostoLogic.deepLoad(detallecompra.getCentroCosto(),isDeep,deepLoadType,clases);
				

		CuentaContableDataAccess.save(detallecompra.getCuentaContableCosto(),connexion);
		CuentaContableLogic cuentacontablecostoLogic= new CuentaContableLogic(connexion);
		cuentacontablecostoLogic.deepLoad(detallecompra.getCuentaContableCosto(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Compra.class)) {
				CompraDataAccess.save(detallecompra.getCompra(),connexion);
				CompraLogic compraLogic= new CompraLogic(connexion);
				compraLogic.deepSave(detallecompra.getCompra(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(detallecompra.getEmpresa(),connexion);
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepSave(detallecompra.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				SucursalDataAccess.save(detallecompra.getSucursal(),connexion);
				SucursalLogic sucursalLogic= new SucursalLogic(connexion);
				sucursalLogic.deepSave(detallecompra.getSucursal(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Ejercicio.class)) {
				EjercicioDataAccess.save(detallecompra.getEjercicio(),connexion);
				EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
				ejercicioLogic.deepSave(detallecompra.getEjercicio(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Periodo.class)) {
				PeriodoDataAccess.save(detallecompra.getPeriodo(),connexion);
				PeriodoLogic periodoLogic= new PeriodoLogic(connexion);
				periodoLogic.deepSave(detallecompra.getPeriodo(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Anio.class)) {
				AnioDataAccess.save(detallecompra.getAnio(),connexion);
				AnioLogic anioLogic= new AnioLogic(connexion);
				anioLogic.deepSave(detallecompra.getAnio(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Mes.class)) {
				MesDataAccess.save(detallecompra.getMes(),connexion);
				MesLogic mesLogic= new MesLogic(connexion);
				mesLogic.deepSave(detallecompra.getMes(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(EstadoDetalleInventario.class)) {
				EstadoDetalleInventarioDataAccess.save(detallecompra.getEstadoDetalleInventario(),connexion);
				EstadoDetalleInventarioLogic estadodetalleinventarioLogic= new EstadoDetalleInventarioLogic(connexion);
				estadodetalleinventarioLogic.deepSave(detallecompra.getEstadoDetalleInventario(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Bodega.class)) {
				BodegaDataAccess.save(detallecompra.getBodega(),connexion);
				BodegaLogic bodegaLogic= new BodegaLogic(connexion);
				bodegaLogic.deepSave(detallecompra.getBodega(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Producto.class)) {
				ProductoDataAccess.save(detallecompra.getProducto(),connexion);
				ProductoLogic productoLogic= new ProductoLogic(connexion);
				productoLogic.deepSave(detallecompra.getProducto(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Unidad.class)) {
				UnidadDataAccess.save(detallecompra.getUnidad(),connexion);
				UnidadLogic unidadLogic= new UnidadLogic(connexion);
				unidadLogic.deepSave(detallecompra.getUnidad(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(NovedadProducto.class)) {
				NovedadProductoDataAccess.save(detallecompra.getNovedadProducto(),connexion);
				NovedadProductoLogic novedadproductoLogic= new NovedadProductoLogic(connexion);
				novedadproductoLogic.deepSave(detallecompra.getNovedadProducto(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(CentroCosto.class)) {
				CentroCostoDataAccess.save(detallecompra.getCentroCosto(),connexion);
				CentroCostoLogic centrocostoLogic= new CentroCostoLogic(connexion);
				centrocostoLogic.deepSave(detallecompra.getCentroCosto(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				CuentaContableDataAccess.save(detallecompra.getCuentaContableCosto(),connexion);
				CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
				cuentacontableLogic.deepSave(detallecompra.getCuentaContableCosto(),isDeep,deepLoadType,clases);				
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
			this.getNewConnexionToDeep(DetalleCompra.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(detallecompra,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				DetalleCompraConstantesFunciones.refrescarForeignKeysDescripcionesDetalleCompra(detallecompra);
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
			this.deepLoad(this.detallecompra,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				DetalleCompraConstantesFunciones.refrescarForeignKeysDescripcionesDetalleCompra(this.detallecompra);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(DetalleCompra.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(detallecompras!=null) {
				for(DetalleCompra detallecompra:detallecompras) {
					this.deepLoad(detallecompra,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					DetalleCompraConstantesFunciones.refrescarForeignKeysDescripcionesDetalleCompra(detallecompras);
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
			if(detallecompras!=null) {
				for(DetalleCompra detallecompra:detallecompras) {
					this.deepLoad(detallecompra,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					DetalleCompraConstantesFunciones.refrescarForeignKeysDescripcionesDetalleCompra(detallecompras);
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
			this.getNewConnexionToDeep(DetalleCompra.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(detallecompra,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(DetalleCompra.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(detallecompras!=null) {
				for(DetalleCompra detallecompra:detallecompras) {
					this.deepSave(detallecompra,isDeep,deepLoadType,clases);
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
			if(detallecompras!=null) {
				for(DetalleCompra detallecompra:detallecompras) {
					this.deepSave(detallecompra,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getDetalleComprasFK_IdAnioWithConnection(String sFinalQuery,Pagination pagination,Long id_anio)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleCompra.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidAnio= new ParameterSelectionGeneral();
			parameterSelectionGeneralidAnio.setParameterSelectionGeneralEqual(ParameterType.LONG,id_anio,DetalleCompraConstantesFunciones.IDANIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidAnio);

			DetalleCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdAnio","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detallecompras=detallecompraDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleCompraConstantesFunciones.refrescarForeignKeysDescripcionesDetalleCompra(this.detallecompras);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getDetalleComprasFK_IdAnio(String sFinalQuery,Pagination pagination,Long id_anio)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidAnio= new ParameterSelectionGeneral();
			parameterSelectionGeneralidAnio.setParameterSelectionGeneralEqual(ParameterType.LONG,id_anio,DetalleCompraConstantesFunciones.IDANIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidAnio);

			DetalleCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdAnio","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detallecompras=detallecompraDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleCompraConstantesFunciones.refrescarForeignKeysDescripcionesDetalleCompra(this.detallecompras);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getDetalleComprasFK_IdBodegaWithConnection(String sFinalQuery,Pagination pagination,Long id_bodega)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleCompra.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidBodega= new ParameterSelectionGeneral();
			parameterSelectionGeneralidBodega.setParameterSelectionGeneralEqual(ParameterType.LONG,id_bodega,DetalleCompraConstantesFunciones.IDBODEGA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidBodega);

			DetalleCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdBodega","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detallecompras=detallecompraDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleCompraConstantesFunciones.refrescarForeignKeysDescripcionesDetalleCompra(this.detallecompras);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getDetalleComprasFK_IdBodega(String sFinalQuery,Pagination pagination,Long id_bodega)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidBodega= new ParameterSelectionGeneral();
			parameterSelectionGeneralidBodega.setParameterSelectionGeneralEqual(ParameterType.LONG,id_bodega,DetalleCompraConstantesFunciones.IDBODEGA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidBodega);

			DetalleCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdBodega","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detallecompras=detallecompraDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleCompraConstantesFunciones.refrescarForeignKeysDescripcionesDetalleCompra(this.detallecompras);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getDetalleComprasFK_IdCentroCostoWithConnection(String sFinalQuery,Pagination pagination,Long id_centro_costo)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleCompra.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCentroCosto= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCentroCosto.setParameterSelectionGeneralEqual(ParameterType.LONG,id_centro_costo,DetalleCompraConstantesFunciones.IDCENTROCOSTO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCentroCosto);

			DetalleCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCentroCosto","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detallecompras=detallecompraDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleCompraConstantesFunciones.refrescarForeignKeysDescripcionesDetalleCompra(this.detallecompras);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getDetalleComprasFK_IdCentroCosto(String sFinalQuery,Pagination pagination,Long id_centro_costo)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCentroCosto= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCentroCosto.setParameterSelectionGeneralEqual(ParameterType.LONG,id_centro_costo,DetalleCompraConstantesFunciones.IDCENTROCOSTO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCentroCosto);

			DetalleCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCentroCosto","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detallecompras=detallecompraDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleCompraConstantesFunciones.refrescarForeignKeysDescripcionesDetalleCompra(this.detallecompras);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getDetalleComprasFK_IdCompraWithConnection(String sFinalQuery,Pagination pagination,Long id_compra)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleCompra.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCompra= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCompra.setParameterSelectionGeneralEqual(ParameterType.LONG,id_compra,DetalleCompraConstantesFunciones.IDCOMPRA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCompra);

			DetalleCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCompra","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detallecompras=detallecompraDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleCompraConstantesFunciones.refrescarForeignKeysDescripcionesDetalleCompra(this.detallecompras);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getDetalleComprasFK_IdCompra(String sFinalQuery,Pagination pagination,Long id_compra)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCompra= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCompra.setParameterSelectionGeneralEqual(ParameterType.LONG,id_compra,DetalleCompraConstantesFunciones.IDCOMPRA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCompra);

			DetalleCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCompra","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detallecompras=detallecompraDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleCompraConstantesFunciones.refrescarForeignKeysDescripcionesDetalleCompra(this.detallecompras);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getDetalleComprasFK_IdCuentaContableCostoWithConnection(String sFinalQuery,Pagination pagination,Long id_cuenta_contable_costo)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleCompra.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCuentaContableCosto= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCuentaContableCosto.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cuenta_contable_costo,DetalleCompraConstantesFunciones.IDCUENTACONTABLECOSTO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCuentaContableCosto);

			DetalleCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCuentaContableCosto","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detallecompras=detallecompraDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleCompraConstantesFunciones.refrescarForeignKeysDescripcionesDetalleCompra(this.detallecompras);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getDetalleComprasFK_IdCuentaContableCosto(String sFinalQuery,Pagination pagination,Long id_cuenta_contable_costo)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCuentaContableCosto= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCuentaContableCosto.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cuenta_contable_costo,DetalleCompraConstantesFunciones.IDCUENTACONTABLECOSTO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCuentaContableCosto);

			DetalleCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCuentaContableCosto","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detallecompras=detallecompraDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleCompraConstantesFunciones.refrescarForeignKeysDescripcionesDetalleCompra(this.detallecompras);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getDetalleComprasFK_IdEjercicioWithConnection(String sFinalQuery,Pagination pagination,Long id_ejercicio)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleCompra.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEjercicio= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEjercicio.setParameterSelectionGeneralEqual(ParameterType.LONG,id_ejercicio,DetalleCompraConstantesFunciones.IDEJERCICIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEjercicio);

			DetalleCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEjercicio","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detallecompras=detallecompraDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleCompraConstantesFunciones.refrescarForeignKeysDescripcionesDetalleCompra(this.detallecompras);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getDetalleComprasFK_IdEjercicio(String sFinalQuery,Pagination pagination,Long id_ejercicio)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEjercicio= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEjercicio.setParameterSelectionGeneralEqual(ParameterType.LONG,id_ejercicio,DetalleCompraConstantesFunciones.IDEJERCICIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEjercicio);

			DetalleCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEjercicio","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detallecompras=detallecompraDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleCompraConstantesFunciones.refrescarForeignKeysDescripcionesDetalleCompra(this.detallecompras);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getDetalleComprasFK_IdEmpresaWithConnection(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleCompra.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,DetalleCompraConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			DetalleCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detallecompras=detallecompraDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleCompraConstantesFunciones.refrescarForeignKeysDescripcionesDetalleCompra(this.detallecompras);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getDetalleComprasFK_IdEmpresa(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,DetalleCompraConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			DetalleCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detallecompras=detallecompraDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleCompraConstantesFunciones.refrescarForeignKeysDescripcionesDetalleCompra(this.detallecompras);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getDetalleComprasFK_IdEstadoDetalleInventarioWithConnection(String sFinalQuery,Pagination pagination,Long id_estado_detalle_inventario)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleCompra.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEstadoDetalleInventario= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEstadoDetalleInventario.setParameterSelectionGeneralEqual(ParameterType.LONG,id_estado_detalle_inventario,DetalleCompraConstantesFunciones.IDESTADODETALLEINVENTARIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEstadoDetalleInventario);

			DetalleCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEstadoDetalleInventario","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detallecompras=detallecompraDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleCompraConstantesFunciones.refrescarForeignKeysDescripcionesDetalleCompra(this.detallecompras);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getDetalleComprasFK_IdEstadoDetalleInventario(String sFinalQuery,Pagination pagination,Long id_estado_detalle_inventario)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEstadoDetalleInventario= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEstadoDetalleInventario.setParameterSelectionGeneralEqual(ParameterType.LONG,id_estado_detalle_inventario,DetalleCompraConstantesFunciones.IDESTADODETALLEINVENTARIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEstadoDetalleInventario);

			DetalleCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEstadoDetalleInventario","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detallecompras=detallecompraDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleCompraConstantesFunciones.refrescarForeignKeysDescripcionesDetalleCompra(this.detallecompras);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getDetalleComprasFK_IdMesWithConnection(String sFinalQuery,Pagination pagination,Long id_mes)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleCompra.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidMes= new ParameterSelectionGeneral();
			parameterSelectionGeneralidMes.setParameterSelectionGeneralEqual(ParameterType.LONG,id_mes,DetalleCompraConstantesFunciones.IDMES,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidMes);

			DetalleCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdMes","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detallecompras=detallecompraDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleCompraConstantesFunciones.refrescarForeignKeysDescripcionesDetalleCompra(this.detallecompras);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getDetalleComprasFK_IdMes(String sFinalQuery,Pagination pagination,Long id_mes)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidMes= new ParameterSelectionGeneral();
			parameterSelectionGeneralidMes.setParameterSelectionGeneralEqual(ParameterType.LONG,id_mes,DetalleCompraConstantesFunciones.IDMES,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidMes);

			DetalleCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdMes","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detallecompras=detallecompraDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleCompraConstantesFunciones.refrescarForeignKeysDescripcionesDetalleCompra(this.detallecompras);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getDetalleComprasFK_IdNovedadProductoWithConnection(String sFinalQuery,Pagination pagination,Long id_novedad_producto)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleCompra.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidNovedadProducto= new ParameterSelectionGeneral();
			parameterSelectionGeneralidNovedadProducto.setParameterSelectionGeneralEqual(ParameterType.LONG,id_novedad_producto,DetalleCompraConstantesFunciones.IDNOVEDADPRODUCTO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidNovedadProducto);

			DetalleCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdNovedadProducto","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detallecompras=detallecompraDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleCompraConstantesFunciones.refrescarForeignKeysDescripcionesDetalleCompra(this.detallecompras);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getDetalleComprasFK_IdNovedadProducto(String sFinalQuery,Pagination pagination,Long id_novedad_producto)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidNovedadProducto= new ParameterSelectionGeneral();
			parameterSelectionGeneralidNovedadProducto.setParameterSelectionGeneralEqual(ParameterType.LONG,id_novedad_producto,DetalleCompraConstantesFunciones.IDNOVEDADPRODUCTO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidNovedadProducto);

			DetalleCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdNovedadProducto","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detallecompras=detallecompraDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleCompraConstantesFunciones.refrescarForeignKeysDescripcionesDetalleCompra(this.detallecompras);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getDetalleComprasFK_IdPeriodoWithConnection(String sFinalQuery,Pagination pagination,Long id_periodo)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleCompra.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidPeriodo= new ParameterSelectionGeneral();
			parameterSelectionGeneralidPeriodo.setParameterSelectionGeneralEqual(ParameterType.LONG,id_periodo,DetalleCompraConstantesFunciones.IDPERIODO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidPeriodo);

			DetalleCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdPeriodo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detallecompras=detallecompraDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleCompraConstantesFunciones.refrescarForeignKeysDescripcionesDetalleCompra(this.detallecompras);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getDetalleComprasFK_IdPeriodo(String sFinalQuery,Pagination pagination,Long id_periodo)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidPeriodo= new ParameterSelectionGeneral();
			parameterSelectionGeneralidPeriodo.setParameterSelectionGeneralEqual(ParameterType.LONG,id_periodo,DetalleCompraConstantesFunciones.IDPERIODO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidPeriodo);

			DetalleCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdPeriodo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detallecompras=detallecompraDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleCompraConstantesFunciones.refrescarForeignKeysDescripcionesDetalleCompra(this.detallecompras);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getDetalleComprasFK_IdProductoWithConnection(String sFinalQuery,Pagination pagination,Long id_producto)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleCompra.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidProducto= new ParameterSelectionGeneral();
			parameterSelectionGeneralidProducto.setParameterSelectionGeneralEqual(ParameterType.LONG,id_producto,DetalleCompraConstantesFunciones.IDPRODUCTO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidProducto);

			DetalleCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdProducto","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detallecompras=detallecompraDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleCompraConstantesFunciones.refrescarForeignKeysDescripcionesDetalleCompra(this.detallecompras);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getDetalleComprasFK_IdProducto(String sFinalQuery,Pagination pagination,Long id_producto)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidProducto= new ParameterSelectionGeneral();
			parameterSelectionGeneralidProducto.setParameterSelectionGeneralEqual(ParameterType.LONG,id_producto,DetalleCompraConstantesFunciones.IDPRODUCTO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidProducto);

			DetalleCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdProducto","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detallecompras=detallecompraDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleCompraConstantesFunciones.refrescarForeignKeysDescripcionesDetalleCompra(this.detallecompras);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getDetalleComprasFK_IdSucursalWithConnection(String sFinalQuery,Pagination pagination,Long id_sucursal)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleCompra.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidSucursal= new ParameterSelectionGeneral();
			parameterSelectionGeneralidSucursal.setParameterSelectionGeneralEqual(ParameterType.LONG,id_sucursal,DetalleCompraConstantesFunciones.IDSUCURSAL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidSucursal);

			DetalleCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdSucursal","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detallecompras=detallecompraDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleCompraConstantesFunciones.refrescarForeignKeysDescripcionesDetalleCompra(this.detallecompras);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getDetalleComprasFK_IdSucursal(String sFinalQuery,Pagination pagination,Long id_sucursal)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidSucursal= new ParameterSelectionGeneral();
			parameterSelectionGeneralidSucursal.setParameterSelectionGeneralEqual(ParameterType.LONG,id_sucursal,DetalleCompraConstantesFunciones.IDSUCURSAL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidSucursal);

			DetalleCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdSucursal","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detallecompras=detallecompraDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleCompraConstantesFunciones.refrescarForeignKeysDescripcionesDetalleCompra(this.detallecompras);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getDetalleComprasFK_IdUnidadWithConnection(String sFinalQuery,Pagination pagination,Long id_unidad)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleCompra.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidUnidad= new ParameterSelectionGeneral();
			parameterSelectionGeneralidUnidad.setParameterSelectionGeneralEqual(ParameterType.LONG,id_unidad,DetalleCompraConstantesFunciones.IDUNIDAD,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidUnidad);

			DetalleCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdUnidad","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detallecompras=detallecompraDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleCompraConstantesFunciones.refrescarForeignKeysDescripcionesDetalleCompra(this.detallecompras);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getDetalleComprasFK_IdUnidad(String sFinalQuery,Pagination pagination,Long id_unidad)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidUnidad= new ParameterSelectionGeneral();
			parameterSelectionGeneralidUnidad.setParameterSelectionGeneralEqual(ParameterType.LONG,id_unidad,DetalleCompraConstantesFunciones.IDUNIDAD,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidUnidad);

			DetalleCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdUnidad","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detallecompras=detallecompraDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleCompraConstantesFunciones.refrescarForeignKeysDescripcionesDetalleCompra(this.detallecompras);
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
			if(DetalleCompraConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,DetalleCompraDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,DetalleCompra detallecompra,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(DetalleCompraConstantesFunciones.ISCONAUDITORIA) {
				if(detallecompra.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,DetalleCompraDataAccess.TABLENAME, detallecompra.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(DetalleCompraConstantesFunciones.ISCONAUDITORIADETALLE) {
						////DetalleCompraLogic.registrarAuditoriaDetallesDetalleCompra(connexion,detallecompra,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(detallecompra.getIsDeleted()) {
					/*if(!detallecompra.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,DetalleCompraDataAccess.TABLENAME, detallecompra.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////DetalleCompraLogic.registrarAuditoriaDetallesDetalleCompra(connexion,detallecompra,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,DetalleCompraDataAccess.TABLENAME, detallecompra.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(detallecompra.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,DetalleCompraDataAccess.TABLENAME, detallecompra.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(DetalleCompraConstantesFunciones.ISCONAUDITORIADETALLE) {
						////DetalleCompraLogic.registrarAuditoriaDetallesDetalleCompra(connexion,detallecompra,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesDetalleCompra(Connexion connexion,DetalleCompra detallecompra)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(detallecompra.getIsNew()||!detallecompra.getid_compra().equals(detallecompra.getDetalleCompraOriginal().getid_compra()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detallecompra.getDetalleCompraOriginal().getid_compra()!=null)
				{
					strValorActual=detallecompra.getDetalleCompraOriginal().getid_compra().toString();
				}
				if(detallecompra.getid_compra()!=null)
				{
					strValorNuevo=detallecompra.getid_compra().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleCompraConstantesFunciones.IDCOMPRA,strValorActual,strValorNuevo);
			}	
			
			if(detallecompra.getIsNew()||!detallecompra.getid_empresa().equals(detallecompra.getDetalleCompraOriginal().getid_empresa()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detallecompra.getDetalleCompraOriginal().getid_empresa()!=null)
				{
					strValorActual=detallecompra.getDetalleCompraOriginal().getid_empresa().toString();
				}
				if(detallecompra.getid_empresa()!=null)
				{
					strValorNuevo=detallecompra.getid_empresa().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleCompraConstantesFunciones.IDEMPRESA,strValorActual,strValorNuevo);
			}	
			
			if(detallecompra.getIsNew()||!detallecompra.getid_sucursal().equals(detallecompra.getDetalleCompraOriginal().getid_sucursal()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detallecompra.getDetalleCompraOriginal().getid_sucursal()!=null)
				{
					strValorActual=detallecompra.getDetalleCompraOriginal().getid_sucursal().toString();
				}
				if(detallecompra.getid_sucursal()!=null)
				{
					strValorNuevo=detallecompra.getid_sucursal().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleCompraConstantesFunciones.IDSUCURSAL,strValorActual,strValorNuevo);
			}	
			
			if(detallecompra.getIsNew()||!detallecompra.getid_ejercicio().equals(detallecompra.getDetalleCompraOriginal().getid_ejercicio()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detallecompra.getDetalleCompraOriginal().getid_ejercicio()!=null)
				{
					strValorActual=detallecompra.getDetalleCompraOriginal().getid_ejercicio().toString();
				}
				if(detallecompra.getid_ejercicio()!=null)
				{
					strValorNuevo=detallecompra.getid_ejercicio().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleCompraConstantesFunciones.IDEJERCICIO,strValorActual,strValorNuevo);
			}	
			
			if(detallecompra.getIsNew()||!detallecompra.getid_periodo().equals(detallecompra.getDetalleCompraOriginal().getid_periodo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detallecompra.getDetalleCompraOriginal().getid_periodo()!=null)
				{
					strValorActual=detallecompra.getDetalleCompraOriginal().getid_periodo().toString();
				}
				if(detallecompra.getid_periodo()!=null)
				{
					strValorNuevo=detallecompra.getid_periodo().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleCompraConstantesFunciones.IDPERIODO,strValorActual,strValorNuevo);
			}	
			
			if(detallecompra.getIsNew()||!detallecompra.getid_anio().equals(detallecompra.getDetalleCompraOriginal().getid_anio()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detallecompra.getDetalleCompraOriginal().getid_anio()!=null)
				{
					strValorActual=detallecompra.getDetalleCompraOriginal().getid_anio().toString();
				}
				if(detallecompra.getid_anio()!=null)
				{
					strValorNuevo=detallecompra.getid_anio().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleCompraConstantesFunciones.IDANIO,strValorActual,strValorNuevo);
			}	
			
			if(detallecompra.getIsNew()||!detallecompra.getid_mes().equals(detallecompra.getDetalleCompraOriginal().getid_mes()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detallecompra.getDetalleCompraOriginal().getid_mes()!=null)
				{
					strValorActual=detallecompra.getDetalleCompraOriginal().getid_mes().toString();
				}
				if(detallecompra.getid_mes()!=null)
				{
					strValorNuevo=detallecompra.getid_mes().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleCompraConstantesFunciones.IDMES,strValorActual,strValorNuevo);
			}	
			
			if(detallecompra.getIsNew()||!detallecompra.getid_estado_detalle_inventario().equals(detallecompra.getDetalleCompraOriginal().getid_estado_detalle_inventario()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detallecompra.getDetalleCompraOriginal().getid_estado_detalle_inventario()!=null)
				{
					strValorActual=detallecompra.getDetalleCompraOriginal().getid_estado_detalle_inventario().toString();
				}
				if(detallecompra.getid_estado_detalle_inventario()!=null)
				{
					strValorNuevo=detallecompra.getid_estado_detalle_inventario().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleCompraConstantesFunciones.IDESTADODETALLEINVENTARIO,strValorActual,strValorNuevo);
			}	
			
			if(detallecompra.getIsNew()||!detallecompra.getid_bodega().equals(detallecompra.getDetalleCompraOriginal().getid_bodega()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detallecompra.getDetalleCompraOriginal().getid_bodega()!=null)
				{
					strValorActual=detallecompra.getDetalleCompraOriginal().getid_bodega().toString();
				}
				if(detallecompra.getid_bodega()!=null)
				{
					strValorNuevo=detallecompra.getid_bodega().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleCompraConstantesFunciones.IDBODEGA,strValorActual,strValorNuevo);
			}	
			
			if(detallecompra.getIsNew()||!detallecompra.getid_producto().equals(detallecompra.getDetalleCompraOriginal().getid_producto()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detallecompra.getDetalleCompraOriginal().getid_producto()!=null)
				{
					strValorActual=detallecompra.getDetalleCompraOriginal().getid_producto().toString();
				}
				if(detallecompra.getid_producto()!=null)
				{
					strValorNuevo=detallecompra.getid_producto().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleCompraConstantesFunciones.IDPRODUCTO,strValorActual,strValorNuevo);
			}	
			
			if(detallecompra.getIsNew()||!detallecompra.getid_unidad().equals(detallecompra.getDetalleCompraOriginal().getid_unidad()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detallecompra.getDetalleCompraOriginal().getid_unidad()!=null)
				{
					strValorActual=detallecompra.getDetalleCompraOriginal().getid_unidad().toString();
				}
				if(detallecompra.getid_unidad()!=null)
				{
					strValorNuevo=detallecompra.getid_unidad().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleCompraConstantesFunciones.IDUNIDAD,strValorActual,strValorNuevo);
			}	
			
			if(detallecompra.getIsNew()||!detallecompra.getdescripcion().equals(detallecompra.getDetalleCompraOriginal().getdescripcion()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detallecompra.getDetalleCompraOriginal().getdescripcion()!=null)
				{
					strValorActual=detallecompra.getDetalleCompraOriginal().getdescripcion();
				}
				if(detallecompra.getdescripcion()!=null)
				{
					strValorNuevo=detallecompra.getdescripcion() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleCompraConstantesFunciones.DESCRIPCION,strValorActual,strValorNuevo);
			}	
			
			if(detallecompra.getIsNew()||!detallecompra.getid_novedad_producto().equals(detallecompra.getDetalleCompraOriginal().getid_novedad_producto()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detallecompra.getDetalleCompraOriginal().getid_novedad_producto()!=null)
				{
					strValorActual=detallecompra.getDetalleCompraOriginal().getid_novedad_producto().toString();
				}
				if(detallecompra.getid_novedad_producto()!=null)
				{
					strValorNuevo=detallecompra.getid_novedad_producto().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleCompraConstantesFunciones.IDNOVEDADPRODUCTO,strValorActual,strValorNuevo);
			}	
			
			if(detallecompra.getIsNew()||!detallecompra.getcantidad().equals(detallecompra.getDetalleCompraOriginal().getcantidad()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detallecompra.getDetalleCompraOriginal().getcantidad()!=null)
				{
					strValorActual=detallecompra.getDetalleCompraOriginal().getcantidad().toString();
				}
				if(detallecompra.getcantidad()!=null)
				{
					strValorNuevo=detallecompra.getcantidad().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleCompraConstantesFunciones.CANTIDAD,strValorActual,strValorNuevo);
			}	
			
			if(detallecompra.getIsNew()||!detallecompra.getdescuento().equals(detallecompra.getDetalleCompraOriginal().getdescuento()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detallecompra.getDetalleCompraOriginal().getdescuento()!=null)
				{
					strValorActual=detallecompra.getDetalleCompraOriginal().getdescuento().toString();
				}
				if(detallecompra.getdescuento()!=null)
				{
					strValorNuevo=detallecompra.getdescuento().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleCompraConstantesFunciones.DESCUENTO,strValorActual,strValorNuevo);
			}	
			
			if(detallecompra.getIsNew()||!detallecompra.getcosto_unitario().equals(detallecompra.getDetalleCompraOriginal().getcosto_unitario()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detallecompra.getDetalleCompraOriginal().getcosto_unitario()!=null)
				{
					strValorActual=detallecompra.getDetalleCompraOriginal().getcosto_unitario().toString();
				}
				if(detallecompra.getcosto_unitario()!=null)
				{
					strValorNuevo=detallecompra.getcosto_unitario().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleCompraConstantesFunciones.COSTOUNITARIO,strValorActual,strValorNuevo);
			}	
			
			if(detallecompra.getIsNew()||!detallecompra.getiva().equals(detallecompra.getDetalleCompraOriginal().getiva()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detallecompra.getDetalleCompraOriginal().getiva()!=null)
				{
					strValorActual=detallecompra.getDetalleCompraOriginal().getiva().toString();
				}
				if(detallecompra.getiva()!=null)
				{
					strValorNuevo=detallecompra.getiva().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleCompraConstantesFunciones.IVA,strValorActual,strValorNuevo);
			}	
			
			if(detallecompra.getIsNew()||!detallecompra.getiva_valor().equals(detallecompra.getDetalleCompraOriginal().getiva_valor()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detallecompra.getDetalleCompraOriginal().getiva_valor()!=null)
				{
					strValorActual=detallecompra.getDetalleCompraOriginal().getiva_valor().toString();
				}
				if(detallecompra.getiva_valor()!=null)
				{
					strValorNuevo=detallecompra.getiva_valor().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleCompraConstantesFunciones.IVAVALOR,strValorActual,strValorNuevo);
			}	
			
			if(detallecompra.getIsNew()||!detallecompra.getcosto_total().equals(detallecompra.getDetalleCompraOriginal().getcosto_total()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detallecompra.getDetalleCompraOriginal().getcosto_total()!=null)
				{
					strValorActual=detallecompra.getDetalleCompraOriginal().getcosto_total().toString();
				}
				if(detallecompra.getcosto_total()!=null)
				{
					strValorNuevo=detallecompra.getcosto_total().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleCompraConstantesFunciones.COSTOTOTAL,strValorActual,strValorNuevo);
			}	
			
			if(detallecompra.getIsNew()||!detallecompra.getdisponible().equals(detallecompra.getDetalleCompraOriginal().getdisponible()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detallecompra.getDetalleCompraOriginal().getdisponible()!=null)
				{
					strValorActual=detallecompra.getDetalleCompraOriginal().getdisponible().toString();
				}
				if(detallecompra.getdisponible()!=null)
				{
					strValorNuevo=detallecompra.getdisponible().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleCompraConstantesFunciones.DISPONIBLE,strValorActual,strValorNuevo);
			}	
			
			if(detallecompra.getIsNew()||!detallecompra.getcosto_iva().equals(detallecompra.getDetalleCompraOriginal().getcosto_iva()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detallecompra.getDetalleCompraOriginal().getcosto_iva()!=null)
				{
					strValorActual=detallecompra.getDetalleCompraOriginal().getcosto_iva().toString();
				}
				if(detallecompra.getcosto_iva()!=null)
				{
					strValorNuevo=detallecompra.getcosto_iva().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleCompraConstantesFunciones.COSTOIVA,strValorActual,strValorNuevo);
			}	
			
			if(detallecompra.getIsNew()||!detallecompra.getice().equals(detallecompra.getDetalleCompraOriginal().getice()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detallecompra.getDetalleCompraOriginal().getice()!=null)
				{
					strValorActual=detallecompra.getDetalleCompraOriginal().getice().toString();
				}
				if(detallecompra.getice()!=null)
				{
					strValorNuevo=detallecompra.getice().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleCompraConstantesFunciones.ICE,strValorActual,strValorNuevo);
			}	
			
			if(detallecompra.getIsNew()||!detallecompra.getice_valor().equals(detallecompra.getDetalleCompraOriginal().getice_valor()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detallecompra.getDetalleCompraOriginal().getice_valor()!=null)
				{
					strValorActual=detallecompra.getDetalleCompraOriginal().getice_valor().toString();
				}
				if(detallecompra.getice_valor()!=null)
				{
					strValorNuevo=detallecompra.getice_valor().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleCompraConstantesFunciones.ICEVALOR,strValorActual,strValorNuevo);
			}	
			
			if(detallecompra.getIsNew()||!detallecompra.getdescuento1().equals(detallecompra.getDetalleCompraOriginal().getdescuento1()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detallecompra.getDetalleCompraOriginal().getdescuento1()!=null)
				{
					strValorActual=detallecompra.getDetalleCompraOriginal().getdescuento1().toString();
				}
				if(detallecompra.getdescuento1()!=null)
				{
					strValorNuevo=detallecompra.getdescuento1().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleCompraConstantesFunciones.DESCUENTO1,strValorActual,strValorNuevo);
			}	
			
			if(detallecompra.getIsNew()||!detallecompra.getdescuento2().equals(detallecompra.getDetalleCompraOriginal().getdescuento2()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detallecompra.getDetalleCompraOriginal().getdescuento2()!=null)
				{
					strValorActual=detallecompra.getDetalleCompraOriginal().getdescuento2().toString();
				}
				if(detallecompra.getdescuento2()!=null)
				{
					strValorNuevo=detallecompra.getdescuento2().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleCompraConstantesFunciones.DESCUENTO2,strValorActual,strValorNuevo);
			}	
			
			if(detallecompra.getIsNew()||!detallecompra.getserie().equals(detallecompra.getDetalleCompraOriginal().getserie()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detallecompra.getDetalleCompraOriginal().getserie()!=null)
				{
					strValorActual=detallecompra.getDetalleCompraOriginal().getserie();
				}
				if(detallecompra.getserie()!=null)
				{
					strValorNuevo=detallecompra.getserie() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleCompraConstantesFunciones.SERIE,strValorActual,strValorNuevo);
			}	
			
			if(detallecompra.getIsNew()||!detallecompra.getlote().equals(detallecompra.getDetalleCompraOriginal().getlote()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detallecompra.getDetalleCompraOriginal().getlote()!=null)
				{
					strValorActual=detallecompra.getDetalleCompraOriginal().getlote();
				}
				if(detallecompra.getlote()!=null)
				{
					strValorNuevo=detallecompra.getlote() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleCompraConstantesFunciones.LOTE,strValorActual,strValorNuevo);
			}	
			
			if(detallecompra.getIsNew()||!detallecompra.getfecha_elaboracion_lote().equals(detallecompra.getDetalleCompraOriginal().getfecha_elaboracion_lote()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detallecompra.getDetalleCompraOriginal().getfecha_elaboracion_lote()!=null)
				{
					strValorActual=detallecompra.getDetalleCompraOriginal().getfecha_elaboracion_lote().toString();
				}
				if(detallecompra.getfecha_elaboracion_lote()!=null)
				{
					strValorNuevo=detallecompra.getfecha_elaboracion_lote().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleCompraConstantesFunciones.FECHAELABORACIONLOTE,strValorActual,strValorNuevo);
			}	
			
			if(detallecompra.getIsNew()||!detallecompra.getfecha_caducidad_lote().equals(detallecompra.getDetalleCompraOriginal().getfecha_caducidad_lote()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detallecompra.getDetalleCompraOriginal().getfecha_caducidad_lote()!=null)
				{
					strValorActual=detallecompra.getDetalleCompraOriginal().getfecha_caducidad_lote().toString();
				}
				if(detallecompra.getfecha_caducidad_lote()!=null)
				{
					strValorNuevo=detallecompra.getfecha_caducidad_lote().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleCompraConstantesFunciones.FECHACADUCIDADLOTE,strValorActual,strValorNuevo);
			}	
			
			if(detallecompra.getIsNew()||!detallecompra.getid_centro_costo().equals(detallecompra.getDetalleCompraOriginal().getid_centro_costo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detallecompra.getDetalleCompraOriginal().getid_centro_costo()!=null)
				{
					strValorActual=detallecompra.getDetalleCompraOriginal().getid_centro_costo().toString();
				}
				if(detallecompra.getid_centro_costo()!=null)
				{
					strValorNuevo=detallecompra.getid_centro_costo().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleCompraConstantesFunciones.IDCENTROCOSTO,strValorActual,strValorNuevo);
			}	
			
			if(detallecompra.getIsNew()||!detallecompra.getid_cuenta_contable_costo().equals(detallecompra.getDetalleCompraOriginal().getid_cuenta_contable_costo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detallecompra.getDetalleCompraOriginal().getid_cuenta_contable_costo()!=null)
				{
					strValorActual=detallecompra.getDetalleCompraOriginal().getid_cuenta_contable_costo().toString();
				}
				if(detallecompra.getid_cuenta_contable_costo()!=null)
				{
					strValorNuevo=detallecompra.getid_cuenta_contable_costo().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleCompraConstantesFunciones.IDCUENTACONTABLECOSTO,strValorActual,strValorNuevo);
			}	
			
			if(detallecompra.getIsNew()||!detallecompra.getnumero_comprobante().equals(detallecompra.getDetalleCompraOriginal().getnumero_comprobante()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detallecompra.getDetalleCompraOriginal().getnumero_comprobante()!=null)
				{
					strValorActual=detallecompra.getDetalleCompraOriginal().getnumero_comprobante();
				}
				if(detallecompra.getnumero_comprobante()!=null)
				{
					strValorNuevo=detallecompra.getnumero_comprobante() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleCompraConstantesFunciones.NUMEROCOMPROBANTE,strValorActual,strValorNuevo);
			}	
			
			if(detallecompra.getIsNew()||!detallecompra.getlote_cliente().equals(detallecompra.getDetalleCompraOriginal().getlote_cliente()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detallecompra.getDetalleCompraOriginal().getlote_cliente()!=null)
				{
					strValorActual=detallecompra.getDetalleCompraOriginal().getlote_cliente();
				}
				if(detallecompra.getlote_cliente()!=null)
				{
					strValorNuevo=detallecompra.getlote_cliente() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleCompraConstantesFunciones.LOTECLIENTE,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void saveDetalleCompraRelacionesWithConnection(DetalleCompra detallecompra) throws Exception {

		if(!detallecompra.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveDetalleCompraRelacionesBase(detallecompra,true);
		}
	}

	public void saveDetalleCompraRelaciones(DetalleCompra detallecompra)throws Exception {

		if(!detallecompra.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveDetalleCompraRelacionesBase(detallecompra,false);
		}
	}

	public void saveDetalleCompraRelacionesBase(DetalleCompra detallecompra,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("DetalleCompra-saveRelacionesWithConnection");}
	

			this.setDetalleCompra(detallecompra);

			if(DetalleCompraLogicAdditional.validarSaveRelaciones(detallecompra,this)) {

				DetalleCompraLogicAdditional.updateRelacionesToSave(detallecompra,this);

				if((detallecompra.getIsNew()||detallecompra.getIsChanged())&&!detallecompra.getIsDeleted()) {
					this.saveDetalleCompra();
					this.saveDetalleCompraRelacionesDetalles();

				} else if(detallecompra.getIsDeleted()) {
					this.saveDetalleCompraRelacionesDetalles();
					this.saveDetalleCompra();
				}

				DetalleCompraLogicAdditional.updateRelacionesToSaveAfter(detallecompra,this);

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
	
	
	private void saveDetalleCompraRelacionesDetalles()throws Exception {
		try {
	

		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfDetalleCompra(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=DetalleCompraConstantesFunciones.getClassesForeignKeysOfDetalleCompra(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfDetalleCompra(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=DetalleCompraConstantesFunciones.getClassesRelationshipsOfDetalleCompra(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}
