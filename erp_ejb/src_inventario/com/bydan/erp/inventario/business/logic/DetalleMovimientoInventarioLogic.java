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
import com.bydan.erp.inventario.util.DetalleMovimientoInventarioConstantesFunciones;
import com.bydan.erp.inventario.util.DetalleMovimientoInventarioParameterReturnGeneral;
//import com.bydan.erp.inventario.util.DetalleMovimientoInventarioParameterGeneral;
import com.bydan.erp.inventario.business.entity.DetalleMovimientoInventario;
import com.bydan.erp.inventario.business.logic.DetalleMovimientoInventarioLogicAdditional;
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
public class DetalleMovimientoInventarioLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(DetalleMovimientoInventarioLogic.class);
	
	protected DetalleMovimientoInventarioDataAccess detallemovimientoinventarioDataAccess; 	
	protected DetalleMovimientoInventario detallemovimientoinventario;
	protected List<DetalleMovimientoInventario> detallemovimientoinventarios;
	protected Object detallemovimientoinventarioObject;	
	protected List<Object> detallemovimientoinventariosObject;
	
	public static ClassValidator<DetalleMovimientoInventario> detallemovimientoinventarioValidator = new ClassValidator<DetalleMovimientoInventario>(DetalleMovimientoInventario.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected DetalleMovimientoInventarioLogicAdditional detallemovimientoinventarioLogicAdditional=null;
	
	public DetalleMovimientoInventarioLogicAdditional getDetalleMovimientoInventarioLogicAdditional() {
		return this.detallemovimientoinventarioLogicAdditional;
	}
	
	public void setDetalleMovimientoInventarioLogicAdditional(DetalleMovimientoInventarioLogicAdditional detallemovimientoinventarioLogicAdditional) {
		try {
			this.detallemovimientoinventarioLogicAdditional=detallemovimientoinventarioLogicAdditional;
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
	
	
	
	
	public  DetalleMovimientoInventarioLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.detallemovimientoinventarioDataAccess = new DetalleMovimientoInventarioDataAccess();
			
			this.detallemovimientoinventarios= new ArrayList<DetalleMovimientoInventario>();
			this.detallemovimientoinventario= new DetalleMovimientoInventario();
			
			this.detallemovimientoinventarioObject=new Object();
			this.detallemovimientoinventariosObject=new ArrayList<Object>();
				
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
			
			this.detallemovimientoinventarioDataAccess.setConnexionType(this.connexionType);
			this.detallemovimientoinventarioDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  DetalleMovimientoInventarioLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.detallemovimientoinventarioDataAccess = new DetalleMovimientoInventarioDataAccess();
			this.detallemovimientoinventarios= new ArrayList<DetalleMovimientoInventario>();
			this.detallemovimientoinventario= new DetalleMovimientoInventario();
			this.detallemovimientoinventarioObject=new Object();
			this.detallemovimientoinventariosObject=new ArrayList<Object>();
			
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
			
			this.detallemovimientoinventarioDataAccess.setConnexionType(this.connexionType);
			this.detallemovimientoinventarioDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public DetalleMovimientoInventario getDetalleMovimientoInventario() throws Exception {	
		DetalleMovimientoInventarioLogicAdditional.checkDetalleMovimientoInventarioToGet(detallemovimientoinventario,this.datosCliente,this.arrDatoGeneral);
		DetalleMovimientoInventarioLogicAdditional.updateDetalleMovimientoInventarioToGet(detallemovimientoinventario,this.arrDatoGeneral);
		
		return detallemovimientoinventario;
	}
		
	public void setDetalleMovimientoInventario(DetalleMovimientoInventario newDetalleMovimientoInventario) {
		this.detallemovimientoinventario = newDetalleMovimientoInventario;
	}
	
	public DetalleMovimientoInventarioDataAccess getDetalleMovimientoInventarioDataAccess() {
		return detallemovimientoinventarioDataAccess;
	}
	
	public void setDetalleMovimientoInventarioDataAccess(DetalleMovimientoInventarioDataAccess newdetallemovimientoinventarioDataAccess) {
		this.detallemovimientoinventarioDataAccess = newdetallemovimientoinventarioDataAccess;
	}
	
	public List<DetalleMovimientoInventario> getDetalleMovimientoInventarios() throws Exception {		
		this.quitarDetalleMovimientoInventariosNulos();
		
		DetalleMovimientoInventarioLogicAdditional.checkDetalleMovimientoInventarioToGets(detallemovimientoinventarios,this.datosCliente,this.arrDatoGeneral);
		
		for (DetalleMovimientoInventario detallemovimientoinventarioLocal: detallemovimientoinventarios ) {
			DetalleMovimientoInventarioLogicAdditional.updateDetalleMovimientoInventarioToGet(detallemovimientoinventarioLocal,this.arrDatoGeneral);
		}
		
		return detallemovimientoinventarios;
	}
	
	public void setDetalleMovimientoInventarios(List<DetalleMovimientoInventario> newDetalleMovimientoInventarios) {
		this.detallemovimientoinventarios = newDetalleMovimientoInventarios;
	}
	
	public Object getDetalleMovimientoInventarioObject() {	
		this.detallemovimientoinventarioObject=this.detallemovimientoinventarioDataAccess.getEntityObject();
		return this.detallemovimientoinventarioObject;
	}
		
	public void setDetalleMovimientoInventarioObject(Object newDetalleMovimientoInventarioObject) {
		this.detallemovimientoinventarioObject = newDetalleMovimientoInventarioObject;
	}
	
	public List<Object> getDetalleMovimientoInventariosObject() {		
		this.detallemovimientoinventariosObject=this.detallemovimientoinventarioDataAccess.getEntitiesObject();
		return this.detallemovimientoinventariosObject;
	}
		
	public void setDetalleMovimientoInventariosObject(List<Object> newDetalleMovimientoInventariosObject) {
		this.detallemovimientoinventariosObject = newDetalleMovimientoInventariosObject;
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
		
		if(this.detallemovimientoinventarioDataAccess!=null) {
			this.detallemovimientoinventarioDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleMovimientoInventario.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			detallemovimientoinventarioDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			detallemovimientoinventarioDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		detallemovimientoinventario = new  DetalleMovimientoInventario();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleMovimientoInventario.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			detallemovimientoinventario=detallemovimientoinventarioDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.detallemovimientoinventario,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				DetalleMovimientoInventarioConstantesFunciones.refrescarForeignKeysDescripcionesDetalleMovimientoInventario(this.detallemovimientoinventario);
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
		detallemovimientoinventario = new  DetalleMovimientoInventario();
		  		  
        try {
			
			detallemovimientoinventario=detallemovimientoinventarioDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.detallemovimientoinventario,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				DetalleMovimientoInventarioConstantesFunciones.refrescarForeignKeysDescripcionesDetalleMovimientoInventario(this.detallemovimientoinventario);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		detallemovimientoinventario = new  DetalleMovimientoInventario();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleMovimientoInventario.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			detallemovimientoinventario=detallemovimientoinventarioDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.detallemovimientoinventario,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				DetalleMovimientoInventarioConstantesFunciones.refrescarForeignKeysDescripcionesDetalleMovimientoInventario(this.detallemovimientoinventario);
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
		detallemovimientoinventario = new  DetalleMovimientoInventario();
		  		  
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
		detallemovimientoinventario = new  DetalleMovimientoInventario();
		  		  
        try {
			
			detallemovimientoinventario=detallemovimientoinventarioDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.detallemovimientoinventario,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				DetalleMovimientoInventarioConstantesFunciones.refrescarForeignKeysDescripcionesDetalleMovimientoInventario(this.detallemovimientoinventario);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		detallemovimientoinventario = new  DetalleMovimientoInventario();
		  		  
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
		detallemovimientoinventario = new  DetalleMovimientoInventario();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleMovimientoInventario.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =detallemovimientoinventarioDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		detallemovimientoinventario = new  DetalleMovimientoInventario();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=detallemovimientoinventarioDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		detallemovimientoinventario = new  DetalleMovimientoInventario();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleMovimientoInventario.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =detallemovimientoinventarioDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		detallemovimientoinventario = new  DetalleMovimientoInventario();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=detallemovimientoinventarioDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		detallemovimientoinventario = new  DetalleMovimientoInventario();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleMovimientoInventario.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =detallemovimientoinventarioDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		detallemovimientoinventario = new  DetalleMovimientoInventario();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=detallemovimientoinventarioDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		detallemovimientoinventarios = new  ArrayList<DetalleMovimientoInventario>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleMovimientoInventario.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			DetalleMovimientoInventarioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detallemovimientoinventarios=detallemovimientoinventarioDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarDetalleMovimientoInventario(detallemovimientoinventarios);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetalleMovimientoInventarioConstantesFunciones.refrescarForeignKeysDescripcionesDetalleMovimientoInventario(this.detallemovimientoinventarios);
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
		detallemovimientoinventarios = new  ArrayList<DetalleMovimientoInventario>();
		  		  
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
		detallemovimientoinventarios = new  ArrayList<DetalleMovimientoInventario>();
		  		  
        try {			
			DetalleMovimientoInventarioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detallemovimientoinventarios=detallemovimientoinventarioDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarDetalleMovimientoInventario(detallemovimientoinventarios);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetalleMovimientoInventarioConstantesFunciones.refrescarForeignKeysDescripcionesDetalleMovimientoInventario(this.detallemovimientoinventarios);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		detallemovimientoinventarios = new  ArrayList<DetalleMovimientoInventario>();
		  		  
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
		detallemovimientoinventarios = new  ArrayList<DetalleMovimientoInventario>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleMovimientoInventario.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			DetalleMovimientoInventarioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detallemovimientoinventarios=detallemovimientoinventarioDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarDetalleMovimientoInventario(detallemovimientoinventarios);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetalleMovimientoInventarioConstantesFunciones.refrescarForeignKeysDescripcionesDetalleMovimientoInventario(this.detallemovimientoinventarios);
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
		detallemovimientoinventarios = new  ArrayList<DetalleMovimientoInventario>();
		  		  
        try {
			DetalleMovimientoInventarioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detallemovimientoinventarios=detallemovimientoinventarioDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarDetalleMovimientoInventario(detallemovimientoinventarios);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetalleMovimientoInventarioConstantesFunciones.refrescarForeignKeysDescripcionesDetalleMovimientoInventario(this.detallemovimientoinventarios);
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
		detallemovimientoinventarios = new  ArrayList<DetalleMovimientoInventario>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleMovimientoInventario.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			DetalleMovimientoInventarioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detallemovimientoinventarios=detallemovimientoinventarioDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarDetalleMovimientoInventario(detallemovimientoinventarios);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetalleMovimientoInventarioConstantesFunciones.refrescarForeignKeysDescripcionesDetalleMovimientoInventario(this.detallemovimientoinventarios);
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
		detallemovimientoinventarios = new  ArrayList<DetalleMovimientoInventario>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			DetalleMovimientoInventarioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detallemovimientoinventarios=detallemovimientoinventarioDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarDetalleMovimientoInventario(detallemovimientoinventarios);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetalleMovimientoInventarioConstantesFunciones.refrescarForeignKeysDescripcionesDetalleMovimientoInventario(this.detallemovimientoinventarios);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		detallemovimientoinventario = new  DetalleMovimientoInventario();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleMovimientoInventario.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			DetalleMovimientoInventarioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detallemovimientoinventario=detallemovimientoinventarioDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarDetalleMovimientoInventario(detallemovimientoinventario);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetalleMovimientoInventarioConstantesFunciones.refrescarForeignKeysDescripcionesDetalleMovimientoInventario(this.detallemovimientoinventario);
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
		detallemovimientoinventario = new  DetalleMovimientoInventario();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			DetalleMovimientoInventarioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detallemovimientoinventario=detallemovimientoinventarioDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarDetalleMovimientoInventario(detallemovimientoinventario);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetalleMovimientoInventarioConstantesFunciones.refrescarForeignKeysDescripcionesDetalleMovimientoInventario(this.detallemovimientoinventario);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		detallemovimientoinventarios = new  ArrayList<DetalleMovimientoInventario>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleMovimientoInventario.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			DetalleMovimientoInventarioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detallemovimientoinventarios=detallemovimientoinventarioDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarDetalleMovimientoInventario(detallemovimientoinventarios);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetalleMovimientoInventarioConstantesFunciones.refrescarForeignKeysDescripcionesDetalleMovimientoInventario(this.detallemovimientoinventarios);
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
		detallemovimientoinventarios = new  ArrayList<DetalleMovimientoInventario>();
		  		  
        try {
			DetalleMovimientoInventarioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detallemovimientoinventarios=detallemovimientoinventarioDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarDetalleMovimientoInventario(detallemovimientoinventarios);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetalleMovimientoInventarioConstantesFunciones.refrescarForeignKeysDescripcionesDetalleMovimientoInventario(this.detallemovimientoinventarios);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosDetalleMovimientoInventariosWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		detallemovimientoinventarios = new  ArrayList<DetalleMovimientoInventario>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleMovimientoInventario.class.getSimpleName()+"-getTodosDetalleMovimientoInventariosWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			DetalleMovimientoInventarioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detallemovimientoinventarios=detallemovimientoinventarioDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarDetalleMovimientoInventario(detallemovimientoinventarios);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetalleMovimientoInventarioConstantesFunciones.refrescarForeignKeysDescripcionesDetalleMovimientoInventario(this.detallemovimientoinventarios);
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
	
	public  void  getTodosDetalleMovimientoInventarios(String sFinalQuery,Pagination pagination)throws Exception {
		detallemovimientoinventarios = new  ArrayList<DetalleMovimientoInventario>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			DetalleMovimientoInventarioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detallemovimientoinventarios=detallemovimientoinventarioDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarDetalleMovimientoInventario(detallemovimientoinventarios);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetalleMovimientoInventarioConstantesFunciones.refrescarForeignKeysDescripcionesDetalleMovimientoInventario(this.detallemovimientoinventarios);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarDetalleMovimientoInventario(DetalleMovimientoInventario detallemovimientoinventario) throws Exception {
		Boolean estaValidado=false;
		
		if(detallemovimientoinventario.getIsNew() || detallemovimientoinventario.getIsChanged()) { 
			this.invalidValues = detallemovimientoinventarioValidator.getInvalidValues(detallemovimientoinventario);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(detallemovimientoinventario);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarDetalleMovimientoInventario(List<DetalleMovimientoInventario> DetalleMovimientoInventarios) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(DetalleMovimientoInventario detallemovimientoinventarioLocal:detallemovimientoinventarios) {				
			estaValidadoObjeto=this.validarGuardarDetalleMovimientoInventario(detallemovimientoinventarioLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarDetalleMovimientoInventario(List<DetalleMovimientoInventario> DetalleMovimientoInventarios) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarDetalleMovimientoInventario(detallemovimientoinventarios)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarDetalleMovimientoInventario(DetalleMovimientoInventario DetalleMovimientoInventario) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarDetalleMovimientoInventario(detallemovimientoinventario)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(DetalleMovimientoInventario detallemovimientoinventario) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+detallemovimientoinventario.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=DetalleMovimientoInventarioConstantesFunciones.getDetalleMovimientoInventarioLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"detallemovimientoinventario","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(DetalleMovimientoInventarioConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(DetalleMovimientoInventarioConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveDetalleMovimientoInventarioWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleMovimientoInventario.class.getSimpleName()+"-saveDetalleMovimientoInventarioWithConnection");connexion.begin();			
			
			DetalleMovimientoInventarioLogicAdditional.checkDetalleMovimientoInventarioToSave(this.detallemovimientoinventario,this.datosCliente,connexion,this.arrDatoGeneral);
			
			DetalleMovimientoInventarioLogicAdditional.updateDetalleMovimientoInventarioToSave(this.detallemovimientoinventario,this.arrDatoGeneral);
			
			DetalleMovimientoInventarioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.detallemovimientoinventario,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowDetalleMovimientoInventario();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarDetalleMovimientoInventario(this.detallemovimientoinventario)) {
				DetalleMovimientoInventarioDataAccess.save(this.detallemovimientoinventario, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.detallemovimientoinventario,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			DetalleMovimientoInventarioLogicAdditional.checkDetalleMovimientoInventarioToSaveAfter(this.detallemovimientoinventario,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowDetalleMovimientoInventario();
			
			connexion.commit();			
			
			if(this.detallemovimientoinventario.getIsDeleted()) {
				this.detallemovimientoinventario=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveDetalleMovimientoInventario()throws Exception {	
		try {	
			
			DetalleMovimientoInventarioLogicAdditional.checkDetalleMovimientoInventarioToSave(this.detallemovimientoinventario,this.datosCliente,connexion,this.arrDatoGeneral);
			
			DetalleMovimientoInventarioLogicAdditional.updateDetalleMovimientoInventarioToSave(this.detallemovimientoinventario,this.arrDatoGeneral);
			
			DetalleMovimientoInventarioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.detallemovimientoinventario,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarDetalleMovimientoInventario(this.detallemovimientoinventario)) {			
				DetalleMovimientoInventarioDataAccess.save(this.detallemovimientoinventario, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.detallemovimientoinventario,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			DetalleMovimientoInventarioLogicAdditional.checkDetalleMovimientoInventarioToSaveAfter(this.detallemovimientoinventario,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.detallemovimientoinventario.getIsDeleted()) {
				this.detallemovimientoinventario=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveDetalleMovimientoInventariosWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleMovimientoInventario.class.getSimpleName()+"-saveDetalleMovimientoInventariosWithConnection");connexion.begin();			
			
			DetalleMovimientoInventarioLogicAdditional.checkDetalleMovimientoInventarioToSaves(detallemovimientoinventarios,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowDetalleMovimientoInventarios();
			
			Boolean validadoTodosDetalleMovimientoInventario=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(DetalleMovimientoInventario detallemovimientoinventarioLocal:detallemovimientoinventarios) {		
				if(detallemovimientoinventarioLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				DetalleMovimientoInventarioLogicAdditional.updateDetalleMovimientoInventarioToSave(detallemovimientoinventarioLocal,this.arrDatoGeneral);
	        	
				DetalleMovimientoInventarioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),detallemovimientoinventarioLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarDetalleMovimientoInventario(detallemovimientoinventarioLocal)) {
					DetalleMovimientoInventarioDataAccess.save(detallemovimientoinventarioLocal, connexion);				
				} else {
					validadoTodosDetalleMovimientoInventario=false;
				}
			}
			
			if(!validadoTodosDetalleMovimientoInventario) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			DetalleMovimientoInventarioLogicAdditional.checkDetalleMovimientoInventarioToSavesAfter(detallemovimientoinventarios,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowDetalleMovimientoInventarios();
			
			connexion.commit();		
			
			this.quitarDetalleMovimientoInventariosEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveDetalleMovimientoInventarios()throws Exception {				
		 try {	
			DetalleMovimientoInventarioLogicAdditional.checkDetalleMovimientoInventarioToSaves(detallemovimientoinventarios,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosDetalleMovimientoInventario=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(DetalleMovimientoInventario detallemovimientoinventarioLocal:detallemovimientoinventarios) {				
				if(detallemovimientoinventarioLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				DetalleMovimientoInventarioLogicAdditional.updateDetalleMovimientoInventarioToSave(detallemovimientoinventarioLocal,this.arrDatoGeneral);
	        	
				DetalleMovimientoInventarioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),detallemovimientoinventarioLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarDetalleMovimientoInventario(detallemovimientoinventarioLocal)) {				
					DetalleMovimientoInventarioDataAccess.save(detallemovimientoinventarioLocal, connexion);				
				} else {
					validadoTodosDetalleMovimientoInventario=false;
				}
			}
			
			if(!validadoTodosDetalleMovimientoInventario) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			DetalleMovimientoInventarioLogicAdditional.checkDetalleMovimientoInventarioToSavesAfter(detallemovimientoinventarios,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarDetalleMovimientoInventariosEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public DetalleMovimientoInventarioParameterReturnGeneral procesarAccionDetalleMovimientoInventarios(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<DetalleMovimientoInventario> detallemovimientoinventarios,DetalleMovimientoInventarioParameterReturnGeneral detallemovimientoinventarioParameterGeneral)throws Exception {
		 try {	
			DetalleMovimientoInventarioParameterReturnGeneral detallemovimientoinventarioReturnGeneral=new DetalleMovimientoInventarioParameterReturnGeneral();
	
			DetalleMovimientoInventarioLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,detallemovimientoinventarios,detallemovimientoinventarioParameterGeneral,detallemovimientoinventarioReturnGeneral);
			
			return detallemovimientoinventarioReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public DetalleMovimientoInventarioParameterReturnGeneral procesarAccionDetalleMovimientoInventariosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<DetalleMovimientoInventario> detallemovimientoinventarios,DetalleMovimientoInventarioParameterReturnGeneral detallemovimientoinventarioParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleMovimientoInventario.class.getSimpleName()+"-procesarAccionDetalleMovimientoInventariosWithConnection");connexion.begin();			
			
			DetalleMovimientoInventarioParameterReturnGeneral detallemovimientoinventarioReturnGeneral=new DetalleMovimientoInventarioParameterReturnGeneral();
	
			DetalleMovimientoInventarioLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,detallemovimientoinventarios,detallemovimientoinventarioParameterGeneral,detallemovimientoinventarioReturnGeneral);
			
			this.connexion.commit();
			
			return detallemovimientoinventarioReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public DetalleMovimientoInventarioParameterReturnGeneral procesarEventosDetalleMovimientoInventarios(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<DetalleMovimientoInventario> detallemovimientoinventarios,DetalleMovimientoInventario detallemovimientoinventario,DetalleMovimientoInventarioParameterReturnGeneral detallemovimientoinventarioParameterGeneral,Boolean isEsNuevoDetalleMovimientoInventario,ArrayList<Classe> clases)throws Exception {
		 try {	
			DetalleMovimientoInventarioParameterReturnGeneral detallemovimientoinventarioReturnGeneral=new DetalleMovimientoInventarioParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				detallemovimientoinventarioReturnGeneral.setConRecargarPropiedades(true);
			}
			
			DetalleMovimientoInventarioLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,detallemovimientoinventarios,detallemovimientoinventario,detallemovimientoinventarioParameterGeneral,detallemovimientoinventarioReturnGeneral,isEsNuevoDetalleMovimientoInventario,clases);
			
			return detallemovimientoinventarioReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public DetalleMovimientoInventarioParameterReturnGeneral procesarEventosDetalleMovimientoInventariosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<DetalleMovimientoInventario> detallemovimientoinventarios,DetalleMovimientoInventario detallemovimientoinventario,DetalleMovimientoInventarioParameterReturnGeneral detallemovimientoinventarioParameterGeneral,Boolean isEsNuevoDetalleMovimientoInventario,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleMovimientoInventario.class.getSimpleName()+"-procesarEventosDetalleMovimientoInventariosWithConnection");connexion.begin();			
			
			DetalleMovimientoInventarioParameterReturnGeneral detallemovimientoinventarioReturnGeneral=new DetalleMovimientoInventarioParameterReturnGeneral();
	
			detallemovimientoinventarioReturnGeneral.setDetalleMovimientoInventario(detallemovimientoinventario);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				detallemovimientoinventarioReturnGeneral.setConRecargarPropiedades(true);
			}
			
			DetalleMovimientoInventarioLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,detallemovimientoinventarios,detallemovimientoinventario,detallemovimientoinventarioParameterGeneral,detallemovimientoinventarioReturnGeneral,isEsNuevoDetalleMovimientoInventario,clases);
			
			this.connexion.commit();
			
			return detallemovimientoinventarioReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public DetalleMovimientoInventarioParameterReturnGeneral procesarImportacionDetalleMovimientoInventariosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,DetalleMovimientoInventarioParameterReturnGeneral detallemovimientoinventarioParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleMovimientoInventario.class.getSimpleName()+"-procesarImportacionDetalleMovimientoInventariosWithConnection");connexion.begin();			
			
			DetalleMovimientoInventarioParameterReturnGeneral detallemovimientoinventarioReturnGeneral=new DetalleMovimientoInventarioParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.detallemovimientoinventarios=new ArrayList<DetalleMovimientoInventario>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.detallemovimientoinventario=new DetalleMovimientoInventario();
				
				
				if(conColumnasBase) {this.detallemovimientoinventario.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.detallemovimientoinventario.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.detallemovimientoinventario.setdescripcion(arrColumnas[iColumn++]);
				this.detallemovimientoinventario.setcantidad(Integer.parseInt(arrColumnas[iColumn++]));
				this.detallemovimientoinventario.setcosto_unitario(Double.parseDouble(arrColumnas[iColumn++]));
				this.detallemovimientoinventario.setcosto_total(Double.parseDouble(arrColumnas[iColumn++]));
				this.detallemovimientoinventario.setdisponible(Integer.parseInt(arrColumnas[iColumn++]));
				
				this.detallemovimientoinventarios.add(this.detallemovimientoinventario);
			}
			
			this.saveDetalleMovimientoInventarios();
			
			this.connexion.commit();
			
			detallemovimientoinventarioReturnGeneral.setConRetornoEstaProcesado(true);
			detallemovimientoinventarioReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return detallemovimientoinventarioReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarDetalleMovimientoInventariosEliminados() throws Exception {				
		
		List<DetalleMovimientoInventario> detallemovimientoinventariosAux= new ArrayList<DetalleMovimientoInventario>();
		
		for(DetalleMovimientoInventario detallemovimientoinventario:detallemovimientoinventarios) {
			if(!detallemovimientoinventario.getIsDeleted()) {
				detallemovimientoinventariosAux.add(detallemovimientoinventario);
			}
		}
		
		detallemovimientoinventarios=detallemovimientoinventariosAux;
	}
	
	public void quitarDetalleMovimientoInventariosNulos() throws Exception {				
		
		List<DetalleMovimientoInventario> detallemovimientoinventariosAux= new ArrayList<DetalleMovimientoInventario>();
		
		for(DetalleMovimientoInventario detallemovimientoinventario : this.detallemovimientoinventarios) {
			if(detallemovimientoinventario==null) {
				detallemovimientoinventariosAux.add(detallemovimientoinventario);
			}
		}
		
		//this.detallemovimientoinventarios=detallemovimientoinventariosAux;
		
		this.detallemovimientoinventarios.removeAll(detallemovimientoinventariosAux);
	}
	
	public void getSetVersionRowDetalleMovimientoInventarioWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(detallemovimientoinventario.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((detallemovimientoinventario.getIsDeleted() || (detallemovimientoinventario.getIsChanged()&&!detallemovimientoinventario.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=detallemovimientoinventarioDataAccess.getSetVersionRowDetalleMovimientoInventario(connexion,detallemovimientoinventario.getId());
				
				if(!detallemovimientoinventario.getVersionRow().equals(timestamp)) {	
					detallemovimientoinventario.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				detallemovimientoinventario.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowDetalleMovimientoInventario()throws Exception {	
		
		if(detallemovimientoinventario.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((detallemovimientoinventario.getIsDeleted() || (detallemovimientoinventario.getIsChanged()&&!detallemovimientoinventario.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=detallemovimientoinventarioDataAccess.getSetVersionRowDetalleMovimientoInventario(connexion,detallemovimientoinventario.getId());
			
			try {							
				if(!detallemovimientoinventario.getVersionRow().equals(timestamp)) {	
					detallemovimientoinventario.setVersionRow(timestamp);
				}
				
				detallemovimientoinventario.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowDetalleMovimientoInventariosWithConnection()throws Exception {	
		if(detallemovimientoinventarios!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(DetalleMovimientoInventario detallemovimientoinventarioAux:detallemovimientoinventarios) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(detallemovimientoinventarioAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(detallemovimientoinventarioAux.getIsDeleted() || (detallemovimientoinventarioAux.getIsChanged()&&!detallemovimientoinventarioAux.getIsNew())) {
						
						timestamp=detallemovimientoinventarioDataAccess.getSetVersionRowDetalleMovimientoInventario(connexion,detallemovimientoinventarioAux.getId());
						
						if(!detallemovimientoinventario.getVersionRow().equals(timestamp)) {	
							detallemovimientoinventarioAux.setVersionRow(timestamp);
						}
								
						detallemovimientoinventarioAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowDetalleMovimientoInventarios()throws Exception {	
		if(detallemovimientoinventarios!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(DetalleMovimientoInventario detallemovimientoinventarioAux:detallemovimientoinventarios) {
					if(detallemovimientoinventarioAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(detallemovimientoinventarioAux.getIsDeleted() || (detallemovimientoinventarioAux.getIsChanged()&&!detallemovimientoinventarioAux.getIsNew())) {
						
						timestamp=detallemovimientoinventarioDataAccess.getSetVersionRowDetalleMovimientoInventario(connexion,detallemovimientoinventarioAux.getId());
						
						if(!detallemovimientoinventarioAux.getVersionRow().equals(timestamp)) {	
							detallemovimientoinventarioAux.setVersionRow(timestamp);
						}
						
													
						detallemovimientoinventarioAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public DetalleMovimientoInventarioParameterReturnGeneral cargarCombosLoteForeignKeyDetalleMovimientoInventarioWithConnection(String finalQueryGlobalMovimientoInventario,String finalQueryGlobalEmpresa,String finalQueryGlobalSucursal,String finalQueryGlobalEjercicio,String finalQueryGlobalPeriodo,String finalQueryGlobalAnio,String finalQueryGlobalMes,String finalQueryGlobalEstadoDetalleMovimientoInventario,String finalQueryGlobalBodega,String finalQueryGlobalProducto,String finalQueryGlobalUnidad,String finalQueryGlobalNovedadProducto,String finalQueryGlobalCentroCosto,String finalQueryGlobalCuentaContableCosto,String finalQueryGlobalTipoDetalleMovimientoInventario) throws Exception {
		DetalleMovimientoInventarioParameterReturnGeneral  detallemovimientoinventarioReturnGeneral =new DetalleMovimientoInventarioParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleMovimientoInventario.class.getSimpleName()+"-cargarCombosLoteForeignKeyDetalleMovimientoInventarioWithConnection");connexion.begin();
			
			detallemovimientoinventarioReturnGeneral =new DetalleMovimientoInventarioParameterReturnGeneral();
			
			

			List<MovimientoInventario> movimientoinventariosForeignKey=new ArrayList<MovimientoInventario>();
			MovimientoInventarioLogic movimientoinventarioLogic=new MovimientoInventarioLogic();
			movimientoinventarioLogic.setConnexion(this.connexion);
			movimientoinventarioLogic.getMovimientoInventarioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalMovimientoInventario.equals("NONE")) {
				movimientoinventarioLogic.getTodosMovimientoInventarios(finalQueryGlobalMovimientoInventario,new Pagination());
				movimientoinventariosForeignKey=movimientoinventarioLogic.getMovimientoInventarios();
			}

			detallemovimientoinventarioReturnGeneral.setmovimientoinventariosForeignKey(movimientoinventariosForeignKey);


			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			detallemovimientoinventarioReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Sucursal> sucursalsForeignKey=new ArrayList<Sucursal>();
			SucursalLogic sucursalLogic=new SucursalLogic();
			sucursalLogic.setConnexion(this.connexion);
			//sucursalLogic.getSucursalDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalSucursal.equals("NONE")) {
				sucursalLogic.getTodosSucursals(finalQueryGlobalSucursal,new Pagination());
				sucursalsForeignKey=sucursalLogic.getSucursals();
			}

			detallemovimientoinventarioReturnGeneral.setsucursalsForeignKey(sucursalsForeignKey);


			List<Ejercicio> ejerciciosForeignKey=new ArrayList<Ejercicio>();
			EjercicioLogic ejercicioLogic=new EjercicioLogic();
			ejercicioLogic.setConnexion(this.connexion);
			//ejercicioLogic.getEjercicioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEjercicio.equals("NONE")) {
				ejercicioLogic.getTodosEjercicios(finalQueryGlobalEjercicio,new Pagination());
				ejerciciosForeignKey=ejercicioLogic.getEjercicios();
			}

			detallemovimientoinventarioReturnGeneral.setejerciciosForeignKey(ejerciciosForeignKey);


			List<Periodo> periodosForeignKey=new ArrayList<Periodo>();
			PeriodoLogic periodoLogic=new PeriodoLogic();
			periodoLogic.setConnexion(this.connexion);
			//periodoLogic.getPeriodoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalPeriodo.equals("NONE")) {
				periodoLogic.getTodosPeriodos(finalQueryGlobalPeriodo,new Pagination());
				periodosForeignKey=periodoLogic.getPeriodos();
			}

			detallemovimientoinventarioReturnGeneral.setperiodosForeignKey(periodosForeignKey);


			List<Anio> aniosForeignKey=new ArrayList<Anio>();
			AnioLogic anioLogic=new AnioLogic();
			anioLogic.setConnexion(this.connexion);
			anioLogic.getAnioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalAnio.equals("NONE")) {
				anioLogic.getTodosAnios(finalQueryGlobalAnio,new Pagination());
				aniosForeignKey=anioLogic.getAnios();
			}

			detallemovimientoinventarioReturnGeneral.setaniosForeignKey(aniosForeignKey);


			List<Mes> messForeignKey=new ArrayList<Mes>();
			MesLogic mesLogic=new MesLogic();
			mesLogic.setConnexion(this.connexion);
			mesLogic.getMesDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalMes.equals("NONE")) {
				mesLogic.getTodosMess(finalQueryGlobalMes,new Pagination());
				messForeignKey=mesLogic.getMess();
			}

			detallemovimientoinventarioReturnGeneral.setmessForeignKey(messForeignKey);


			List<EstadoDetalleMovimientoInventario> estadodetallemovimientoinventariosForeignKey=new ArrayList<EstadoDetalleMovimientoInventario>();
			EstadoDetalleMovimientoInventarioLogic estadodetallemovimientoinventarioLogic=new EstadoDetalleMovimientoInventarioLogic();
			estadodetallemovimientoinventarioLogic.setConnexion(this.connexion);
			estadodetallemovimientoinventarioLogic.getEstadoDetalleMovimientoInventarioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEstadoDetalleMovimientoInventario.equals("NONE")) {
				estadodetallemovimientoinventarioLogic.getTodosEstadoDetalleMovimientoInventarios(finalQueryGlobalEstadoDetalleMovimientoInventario,new Pagination());
				estadodetallemovimientoinventariosForeignKey=estadodetallemovimientoinventarioLogic.getEstadoDetalleMovimientoInventarios();
			}

			detallemovimientoinventarioReturnGeneral.setestadodetallemovimientoinventariosForeignKey(estadodetallemovimientoinventariosForeignKey);


			List<Bodega> bodegasForeignKey=new ArrayList<Bodega>();
			BodegaLogic bodegaLogic=new BodegaLogic();
			bodegaLogic.setConnexion(this.connexion);
			bodegaLogic.getBodegaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalBodega.equals("NONE")) {
				bodegaLogic.getTodosBodegas(finalQueryGlobalBodega,new Pagination());
				bodegasForeignKey=bodegaLogic.getBodegas();
			}

			detallemovimientoinventarioReturnGeneral.setbodegasForeignKey(bodegasForeignKey);


			List<Producto> productosForeignKey=new ArrayList<Producto>();
			ProductoLogic productoLogic=new ProductoLogic();
			productoLogic.setConnexion(this.connexion);
			//productoLogic.getProductoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalProducto.equals("NONE")) {
				productoLogic.getTodosProductos(finalQueryGlobalProducto,new Pagination());
				productosForeignKey=productoLogic.getProductos();
			}

			detallemovimientoinventarioReturnGeneral.setproductosForeignKey(productosForeignKey);


			List<Unidad> unidadsForeignKey=new ArrayList<Unidad>();
			UnidadLogic unidadLogic=new UnidadLogic();
			unidadLogic.setConnexion(this.connexion);
			unidadLogic.getUnidadDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalUnidad.equals("NONE")) {
				unidadLogic.getTodosUnidads(finalQueryGlobalUnidad,new Pagination());
				unidadsForeignKey=unidadLogic.getUnidads();
			}

			detallemovimientoinventarioReturnGeneral.setunidadsForeignKey(unidadsForeignKey);


			List<NovedadProducto> novedadproductosForeignKey=new ArrayList<NovedadProducto>();
			NovedadProductoLogic novedadproductoLogic=new NovedadProductoLogic();
			novedadproductoLogic.setConnexion(this.connexion);
			novedadproductoLogic.getNovedadProductoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalNovedadProducto.equals("NONE")) {
				novedadproductoLogic.getTodosNovedadProductos(finalQueryGlobalNovedadProducto,new Pagination());
				novedadproductosForeignKey=novedadproductoLogic.getNovedadProductos();
			}

			detallemovimientoinventarioReturnGeneral.setnovedadproductosForeignKey(novedadproductosForeignKey);


			List<CentroCosto> centrocostosForeignKey=new ArrayList<CentroCosto>();
			CentroCostoLogic centrocostoLogic=new CentroCostoLogic();
			centrocostoLogic.setConnexion(this.connexion);
			centrocostoLogic.getCentroCostoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCentroCosto.equals("NONE")) {
				centrocostoLogic.getTodosCentroCostos(finalQueryGlobalCentroCosto,new Pagination());
				centrocostosForeignKey=centrocostoLogic.getCentroCostos();
			}

			detallemovimientoinventarioReturnGeneral.setcentrocostosForeignKey(centrocostosForeignKey);


			List<CuentaContable> cuentacontablecostosForeignKey=new ArrayList<CuentaContable>();
			CuentaContableLogic cuentacontablecostoLogic=new CuentaContableLogic();
			cuentacontablecostoLogic.setConnexion(this.connexion);
			cuentacontablecostoLogic.getCuentaContableDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCuentaContableCosto.equals("NONE")) {
				cuentacontablecostoLogic.getTodosCuentaContables(finalQueryGlobalCuentaContableCosto,new Pagination());
				cuentacontablecostosForeignKey=cuentacontablecostoLogic.getCuentaContables();
			}

			detallemovimientoinventarioReturnGeneral.setcuentacontablecostosForeignKey(cuentacontablecostosForeignKey);


			List<TipoDetalleMovimientoInventario> tipodetallemovimientoinventariosForeignKey=new ArrayList<TipoDetalleMovimientoInventario>();
			TipoDetalleMovimientoInventarioLogic tipodetallemovimientoinventarioLogic=new TipoDetalleMovimientoInventarioLogic();
			tipodetallemovimientoinventarioLogic.setConnexion(this.connexion);
			tipodetallemovimientoinventarioLogic.getTipoDetalleMovimientoInventarioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoDetalleMovimientoInventario.equals("NONE")) {
				tipodetallemovimientoinventarioLogic.getTodosTipoDetalleMovimientoInventarios(finalQueryGlobalTipoDetalleMovimientoInventario,new Pagination());
				tipodetallemovimientoinventariosForeignKey=tipodetallemovimientoinventarioLogic.getTipoDetalleMovimientoInventarios();
			}

			detallemovimientoinventarioReturnGeneral.settipodetallemovimientoinventariosForeignKey(tipodetallemovimientoinventariosForeignKey);

			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
		
		return detallemovimientoinventarioReturnGeneral;
	}
	
	public DetalleMovimientoInventarioParameterReturnGeneral cargarCombosLoteForeignKeyDetalleMovimientoInventario(String finalQueryGlobalMovimientoInventario,String finalQueryGlobalEmpresa,String finalQueryGlobalSucursal,String finalQueryGlobalEjercicio,String finalQueryGlobalPeriodo,String finalQueryGlobalAnio,String finalQueryGlobalMes,String finalQueryGlobalEstadoDetalleMovimientoInventario,String finalQueryGlobalBodega,String finalQueryGlobalProducto,String finalQueryGlobalUnidad,String finalQueryGlobalNovedadProducto,String finalQueryGlobalCentroCosto,String finalQueryGlobalCuentaContableCosto,String finalQueryGlobalTipoDetalleMovimientoInventario) throws Exception {
		DetalleMovimientoInventarioParameterReturnGeneral  detallemovimientoinventarioReturnGeneral =new DetalleMovimientoInventarioParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {						
			detallemovimientoinventarioReturnGeneral =new DetalleMovimientoInventarioParameterReturnGeneral();
			
			

			List<MovimientoInventario> movimientoinventariosForeignKey=new ArrayList<MovimientoInventario>();
			MovimientoInventarioLogic movimientoinventarioLogic=new MovimientoInventarioLogic();
			movimientoinventarioLogic.setConnexion(this.connexion);
			movimientoinventarioLogic.getMovimientoInventarioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalMovimientoInventario.equals("NONE")) {
				movimientoinventarioLogic.getTodosMovimientoInventarios(finalQueryGlobalMovimientoInventario,new Pagination());
				movimientoinventariosForeignKey=movimientoinventarioLogic.getMovimientoInventarios();
			}

			detallemovimientoinventarioReturnGeneral.setmovimientoinventariosForeignKey(movimientoinventariosForeignKey);


			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			detallemovimientoinventarioReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Sucursal> sucursalsForeignKey=new ArrayList<Sucursal>();
			SucursalLogic sucursalLogic=new SucursalLogic();
			sucursalLogic.setConnexion(this.connexion);
			//sucursalLogic.getSucursalDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalSucursal.equals("NONE")) {
				sucursalLogic.getTodosSucursals(finalQueryGlobalSucursal,new Pagination());
				sucursalsForeignKey=sucursalLogic.getSucursals();
			}

			detallemovimientoinventarioReturnGeneral.setsucursalsForeignKey(sucursalsForeignKey);


			List<Ejercicio> ejerciciosForeignKey=new ArrayList<Ejercicio>();
			EjercicioLogic ejercicioLogic=new EjercicioLogic();
			ejercicioLogic.setConnexion(this.connexion);
			//ejercicioLogic.getEjercicioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEjercicio.equals("NONE")) {
				ejercicioLogic.getTodosEjercicios(finalQueryGlobalEjercicio,new Pagination());
				ejerciciosForeignKey=ejercicioLogic.getEjercicios();
			}

			detallemovimientoinventarioReturnGeneral.setejerciciosForeignKey(ejerciciosForeignKey);


			List<Periodo> periodosForeignKey=new ArrayList<Periodo>();
			PeriodoLogic periodoLogic=new PeriodoLogic();
			periodoLogic.setConnexion(this.connexion);
			//periodoLogic.getPeriodoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalPeriodo.equals("NONE")) {
				periodoLogic.getTodosPeriodos(finalQueryGlobalPeriodo,new Pagination());
				periodosForeignKey=periodoLogic.getPeriodos();
			}

			detallemovimientoinventarioReturnGeneral.setperiodosForeignKey(periodosForeignKey);


			List<Anio> aniosForeignKey=new ArrayList<Anio>();
			AnioLogic anioLogic=new AnioLogic();
			anioLogic.setConnexion(this.connexion);
			anioLogic.getAnioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalAnio.equals("NONE")) {
				anioLogic.getTodosAnios(finalQueryGlobalAnio,new Pagination());
				aniosForeignKey=anioLogic.getAnios();
			}

			detallemovimientoinventarioReturnGeneral.setaniosForeignKey(aniosForeignKey);


			List<Mes> messForeignKey=new ArrayList<Mes>();
			MesLogic mesLogic=new MesLogic();
			mesLogic.setConnexion(this.connexion);
			mesLogic.getMesDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalMes.equals("NONE")) {
				mesLogic.getTodosMess(finalQueryGlobalMes,new Pagination());
				messForeignKey=mesLogic.getMess();
			}

			detallemovimientoinventarioReturnGeneral.setmessForeignKey(messForeignKey);


			List<EstadoDetalleMovimientoInventario> estadodetallemovimientoinventariosForeignKey=new ArrayList<EstadoDetalleMovimientoInventario>();
			EstadoDetalleMovimientoInventarioLogic estadodetallemovimientoinventarioLogic=new EstadoDetalleMovimientoInventarioLogic();
			estadodetallemovimientoinventarioLogic.setConnexion(this.connexion);
			estadodetallemovimientoinventarioLogic.getEstadoDetalleMovimientoInventarioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEstadoDetalleMovimientoInventario.equals("NONE")) {
				estadodetallemovimientoinventarioLogic.getTodosEstadoDetalleMovimientoInventarios(finalQueryGlobalEstadoDetalleMovimientoInventario,new Pagination());
				estadodetallemovimientoinventariosForeignKey=estadodetallemovimientoinventarioLogic.getEstadoDetalleMovimientoInventarios();
			}

			detallemovimientoinventarioReturnGeneral.setestadodetallemovimientoinventariosForeignKey(estadodetallemovimientoinventariosForeignKey);


			List<Bodega> bodegasForeignKey=new ArrayList<Bodega>();
			BodegaLogic bodegaLogic=new BodegaLogic();
			bodegaLogic.setConnexion(this.connexion);
			bodegaLogic.getBodegaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalBodega.equals("NONE")) {
				bodegaLogic.getTodosBodegas(finalQueryGlobalBodega,new Pagination());
				bodegasForeignKey=bodegaLogic.getBodegas();
			}

			detallemovimientoinventarioReturnGeneral.setbodegasForeignKey(bodegasForeignKey);


			List<Producto> productosForeignKey=new ArrayList<Producto>();
			ProductoLogic productoLogic=new ProductoLogic();
			productoLogic.setConnexion(this.connexion);
			//productoLogic.getProductoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalProducto.equals("NONE")) {
				productoLogic.getTodosProductos(finalQueryGlobalProducto,new Pagination());
				productosForeignKey=productoLogic.getProductos();
			}

			detallemovimientoinventarioReturnGeneral.setproductosForeignKey(productosForeignKey);


			List<Unidad> unidadsForeignKey=new ArrayList<Unidad>();
			UnidadLogic unidadLogic=new UnidadLogic();
			unidadLogic.setConnexion(this.connexion);
			unidadLogic.getUnidadDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalUnidad.equals("NONE")) {
				unidadLogic.getTodosUnidads(finalQueryGlobalUnidad,new Pagination());
				unidadsForeignKey=unidadLogic.getUnidads();
			}

			detallemovimientoinventarioReturnGeneral.setunidadsForeignKey(unidadsForeignKey);


			List<NovedadProducto> novedadproductosForeignKey=new ArrayList<NovedadProducto>();
			NovedadProductoLogic novedadproductoLogic=new NovedadProductoLogic();
			novedadproductoLogic.setConnexion(this.connexion);
			novedadproductoLogic.getNovedadProductoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalNovedadProducto.equals("NONE")) {
				novedadproductoLogic.getTodosNovedadProductos(finalQueryGlobalNovedadProducto,new Pagination());
				novedadproductosForeignKey=novedadproductoLogic.getNovedadProductos();
			}

			detallemovimientoinventarioReturnGeneral.setnovedadproductosForeignKey(novedadproductosForeignKey);


			List<CentroCosto> centrocostosForeignKey=new ArrayList<CentroCosto>();
			CentroCostoLogic centrocostoLogic=new CentroCostoLogic();
			centrocostoLogic.setConnexion(this.connexion);
			centrocostoLogic.getCentroCostoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCentroCosto.equals("NONE")) {
				centrocostoLogic.getTodosCentroCostos(finalQueryGlobalCentroCosto,new Pagination());
				centrocostosForeignKey=centrocostoLogic.getCentroCostos();
			}

			detallemovimientoinventarioReturnGeneral.setcentrocostosForeignKey(centrocostosForeignKey);


			List<CuentaContable> cuentacontablecostosForeignKey=new ArrayList<CuentaContable>();
			CuentaContableLogic cuentacontablecostoLogic=new CuentaContableLogic();
			cuentacontablecostoLogic.setConnexion(this.connexion);
			cuentacontablecostoLogic.getCuentaContableDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCuentaContableCosto.equals("NONE")) {
				cuentacontablecostoLogic.getTodosCuentaContables(finalQueryGlobalCuentaContableCosto,new Pagination());
				cuentacontablecostosForeignKey=cuentacontablecostoLogic.getCuentaContables();
			}

			detallemovimientoinventarioReturnGeneral.setcuentacontablecostosForeignKey(cuentacontablecostosForeignKey);


			List<TipoDetalleMovimientoInventario> tipodetallemovimientoinventariosForeignKey=new ArrayList<TipoDetalleMovimientoInventario>();
			TipoDetalleMovimientoInventarioLogic tipodetallemovimientoinventarioLogic=new TipoDetalleMovimientoInventarioLogic();
			tipodetallemovimientoinventarioLogic.setConnexion(this.connexion);
			tipodetallemovimientoinventarioLogic.getTipoDetalleMovimientoInventarioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoDetalleMovimientoInventario.equals("NONE")) {
				tipodetallemovimientoinventarioLogic.getTodosTipoDetalleMovimientoInventarios(finalQueryGlobalTipoDetalleMovimientoInventario,new Pagination());
				tipodetallemovimientoinventariosForeignKey=tipodetallemovimientoinventarioLogic.getTipoDetalleMovimientoInventarios();
			}

			detallemovimientoinventarioReturnGeneral.settipodetallemovimientoinventariosForeignKey(tipodetallemovimientoinventariosForeignKey);
						
			
		} catch(Exception e) {			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			
		}
		
		return detallemovimientoinventarioReturnGeneral;
	}
	
	public void cargarRelacionesLoteForeignKeyDetalleMovimientoInventarioWithConnection() throws Exception {
		ArrayList<Classe> classes=new ArrayList<Classe>();		
		
		
			NovedadSeguimientoLogic novedadseguimientoLogic=new NovedadSeguimientoLogic();
		
		try {
			
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleMovimientoInventario.class.getSimpleName()+"-cargarRelacionesLoteForeignKeyDetalleMovimientoInventarioWithConnection");connexion.begin();
			
			
			classes.add(new Classe(NovedadSeguimiento.class));
											
			

			novedadseguimientoLogic.setConnexion(this.getConnexion());
			novedadseguimientoLogic.setDatosCliente(this.datosCliente);
			novedadseguimientoLogic.setIsConRefrescarForeignKeys(true);
			
			this.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
			
			for(DetalleMovimientoInventario detallemovimientoinventario:this.detallemovimientoinventarios) {
				

				classes=new ArrayList<Classe>();
				classes=NovedadSeguimientoConstantesFunciones.getClassesForeignKeysOfNovedadSeguimiento(new ArrayList<Classe>(),DeepLoadType.NONE);

				novedadseguimientoLogic.setNovedadSeguimientos(detallemovimientoinventario.novedadseguimientos);
				novedadseguimientoLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
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
	
	public void deepLoad(DetalleMovimientoInventario detallemovimientoinventario,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			DetalleMovimientoInventarioLogicAdditional.updateDetalleMovimientoInventarioToGet(detallemovimientoinventario,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		detallemovimientoinventario.setMovimientoInventario(detallemovimientoinventarioDataAccess.getMovimientoInventario(connexion,detallemovimientoinventario));
		detallemovimientoinventario.setEmpresa(detallemovimientoinventarioDataAccess.getEmpresa(connexion,detallemovimientoinventario));
		detallemovimientoinventario.setSucursal(detallemovimientoinventarioDataAccess.getSucursal(connexion,detallemovimientoinventario));
		detallemovimientoinventario.setEjercicio(detallemovimientoinventarioDataAccess.getEjercicio(connexion,detallemovimientoinventario));
		detallemovimientoinventario.setPeriodo(detallemovimientoinventarioDataAccess.getPeriodo(connexion,detallemovimientoinventario));
		detallemovimientoinventario.setAnio(detallemovimientoinventarioDataAccess.getAnio(connexion,detallemovimientoinventario));
		detallemovimientoinventario.setMes(detallemovimientoinventarioDataAccess.getMes(connexion,detallemovimientoinventario));
		detallemovimientoinventario.setEstadoDetalleMovimientoInventario(detallemovimientoinventarioDataAccess.getEstadoDetalleMovimientoInventario(connexion,detallemovimientoinventario));
		detallemovimientoinventario.setBodega(detallemovimientoinventarioDataAccess.getBodega(connexion,detallemovimientoinventario));
		detallemovimientoinventario.setProducto(detallemovimientoinventarioDataAccess.getProducto(connexion,detallemovimientoinventario));
		detallemovimientoinventario.setUnidad(detallemovimientoinventarioDataAccess.getUnidad(connexion,detallemovimientoinventario));
		detallemovimientoinventario.setNovedadProducto(detallemovimientoinventarioDataAccess.getNovedadProducto(connexion,detallemovimientoinventario));
		detallemovimientoinventario.setCentroCosto(detallemovimientoinventarioDataAccess.getCentroCosto(connexion,detallemovimientoinventario));
		detallemovimientoinventario.setCuentaContableCosto(detallemovimientoinventarioDataAccess.getCuentaContableCosto(connexion,detallemovimientoinventario));
		detallemovimientoinventario.setTipoDetalleMovimientoInventario(detallemovimientoinventarioDataAccess.getTipoDetalleMovimientoInventario(connexion,detallemovimientoinventario));
		detallemovimientoinventario.setNovedadSeguimientos(detallemovimientoinventarioDataAccess.getNovedadSeguimientos(connexion,detallemovimientoinventario));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(MovimientoInventario.class)) {
				detallemovimientoinventario.setMovimientoInventario(detallemovimientoinventarioDataAccess.getMovimientoInventario(connexion,detallemovimientoinventario));
				continue;
			}

			if(clas.clas.equals(Empresa.class)) {
				detallemovimientoinventario.setEmpresa(detallemovimientoinventarioDataAccess.getEmpresa(connexion,detallemovimientoinventario));
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				detallemovimientoinventario.setSucursal(detallemovimientoinventarioDataAccess.getSucursal(connexion,detallemovimientoinventario));
				continue;
			}

			if(clas.clas.equals(Ejercicio.class)) {
				detallemovimientoinventario.setEjercicio(detallemovimientoinventarioDataAccess.getEjercicio(connexion,detallemovimientoinventario));
				continue;
			}

			if(clas.clas.equals(Periodo.class)) {
				detallemovimientoinventario.setPeriodo(detallemovimientoinventarioDataAccess.getPeriodo(connexion,detallemovimientoinventario));
				continue;
			}

			if(clas.clas.equals(Anio.class)) {
				detallemovimientoinventario.setAnio(detallemovimientoinventarioDataAccess.getAnio(connexion,detallemovimientoinventario));
				continue;
			}

			if(clas.clas.equals(Mes.class)) {
				detallemovimientoinventario.setMes(detallemovimientoinventarioDataAccess.getMes(connexion,detallemovimientoinventario));
				continue;
			}

			if(clas.clas.equals(EstadoDetalleMovimientoInventario.class)) {
				detallemovimientoinventario.setEstadoDetalleMovimientoInventario(detallemovimientoinventarioDataAccess.getEstadoDetalleMovimientoInventario(connexion,detallemovimientoinventario));
				continue;
			}

			if(clas.clas.equals(Bodega.class)) {
				detallemovimientoinventario.setBodega(detallemovimientoinventarioDataAccess.getBodega(connexion,detallemovimientoinventario));
				continue;
			}

			if(clas.clas.equals(Producto.class)) {
				detallemovimientoinventario.setProducto(detallemovimientoinventarioDataAccess.getProducto(connexion,detallemovimientoinventario));
				continue;
			}

			if(clas.clas.equals(Unidad.class)) {
				detallemovimientoinventario.setUnidad(detallemovimientoinventarioDataAccess.getUnidad(connexion,detallemovimientoinventario));
				continue;
			}

			if(clas.clas.equals(NovedadProducto.class)) {
				detallemovimientoinventario.setNovedadProducto(detallemovimientoinventarioDataAccess.getNovedadProducto(connexion,detallemovimientoinventario));
				continue;
			}

			if(clas.clas.equals(CentroCosto.class)) {
				detallemovimientoinventario.setCentroCosto(detallemovimientoinventarioDataAccess.getCentroCosto(connexion,detallemovimientoinventario));
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				detallemovimientoinventario.setCuentaContableCosto(detallemovimientoinventarioDataAccess.getCuentaContableCosto(connexion,detallemovimientoinventario));
				continue;
			}

			if(clas.clas.equals(TipoDetalleMovimientoInventario.class)) {
				detallemovimientoinventario.setTipoDetalleMovimientoInventario(detallemovimientoinventarioDataAccess.getTipoDetalleMovimientoInventario(connexion,detallemovimientoinventario));
				continue;
			}

			if(clas.clas.equals(NovedadSeguimiento.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				detallemovimientoinventario.setNovedadSeguimientos(detallemovimientoinventarioDataAccess.getNovedadSeguimientos(connexion,detallemovimientoinventario));

				if(this.isConDeep) {
					NovedadSeguimientoLogic novedadseguimientoLogic= new NovedadSeguimientoLogic(this.connexion);
					novedadseguimientoLogic.setNovedadSeguimientos(detallemovimientoinventario.getNovedadSeguimientos());
					ArrayList<Classe> classesLocal=NovedadSeguimientoConstantesFunciones.getClassesForeignKeysOfNovedadSeguimiento(new ArrayList<Classe>(),DeepLoadType.NONE);
					novedadseguimientoLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					NovedadSeguimientoConstantesFunciones.refrescarForeignKeysDescripcionesNovedadSeguimiento(novedadseguimientoLogic.getNovedadSeguimientos());
					detallemovimientoinventario.setNovedadSeguimientos(novedadseguimientoLogic.getNovedadSeguimientos());
				}

				continue;
			}
		}
	}
	else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(MovimientoInventario.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detallemovimientoinventario.setMovimientoInventario(detallemovimientoinventarioDataAccess.getMovimientoInventario(connexion,detallemovimientoinventario));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detallemovimientoinventario.setEmpresa(detallemovimientoinventarioDataAccess.getEmpresa(connexion,detallemovimientoinventario));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detallemovimientoinventario.setSucursal(detallemovimientoinventarioDataAccess.getSucursal(connexion,detallemovimientoinventario));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Ejercicio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detallemovimientoinventario.setEjercicio(detallemovimientoinventarioDataAccess.getEjercicio(connexion,detallemovimientoinventario));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Periodo.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detallemovimientoinventario.setPeriodo(detallemovimientoinventarioDataAccess.getPeriodo(connexion,detallemovimientoinventario));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Anio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detallemovimientoinventario.setAnio(detallemovimientoinventarioDataAccess.getAnio(connexion,detallemovimientoinventario));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Mes.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detallemovimientoinventario.setMes(detallemovimientoinventarioDataAccess.getMes(connexion,detallemovimientoinventario));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(EstadoDetalleMovimientoInventario.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detallemovimientoinventario.setEstadoDetalleMovimientoInventario(detallemovimientoinventarioDataAccess.getEstadoDetalleMovimientoInventario(connexion,detallemovimientoinventario));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Bodega.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detallemovimientoinventario.setBodega(detallemovimientoinventarioDataAccess.getBodega(connexion,detallemovimientoinventario));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Producto.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detallemovimientoinventario.setProducto(detallemovimientoinventarioDataAccess.getProducto(connexion,detallemovimientoinventario));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Unidad.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detallemovimientoinventario.setUnidad(detallemovimientoinventarioDataAccess.getUnidad(connexion,detallemovimientoinventario));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(NovedadProducto.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detallemovimientoinventario.setNovedadProducto(detallemovimientoinventarioDataAccess.getNovedadProducto(connexion,detallemovimientoinventario));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(CentroCosto.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detallemovimientoinventario.setCentroCosto(detallemovimientoinventarioDataAccess.getCentroCosto(connexion,detallemovimientoinventario));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(CuentaContable.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detallemovimientoinventario.setCuentaContableCosto(detallemovimientoinventarioDataAccess.getCuentaContableCosto(connexion,detallemovimientoinventario));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(TipoDetalleMovimientoInventario.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detallemovimientoinventario.setTipoDetalleMovimientoInventario(detallemovimientoinventarioDataAccess.getTipoDetalleMovimientoInventario(connexion,detallemovimientoinventario));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(NovedadSeguimiento.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(NovedadSeguimiento.class));
			detallemovimientoinventario.setNovedadSeguimientos(detallemovimientoinventarioDataAccess.getNovedadSeguimientos(connexion,detallemovimientoinventario));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		detallemovimientoinventario.setMovimientoInventario(detallemovimientoinventarioDataAccess.getMovimientoInventario(connexion,detallemovimientoinventario));
		MovimientoInventarioLogic movimientoinventarioLogic= new MovimientoInventarioLogic(connexion);
		movimientoinventarioLogic.deepLoad(detallemovimientoinventario.getMovimientoInventario(),isDeep,deepLoadType,clases);
				
		detallemovimientoinventario.setEmpresa(detallemovimientoinventarioDataAccess.getEmpresa(connexion,detallemovimientoinventario));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(detallemovimientoinventario.getEmpresa(),isDeep,deepLoadType,clases);
				
		detallemovimientoinventario.setSucursal(detallemovimientoinventarioDataAccess.getSucursal(connexion,detallemovimientoinventario));
		SucursalLogic sucursalLogic= new SucursalLogic(connexion);
		sucursalLogic.deepLoad(detallemovimientoinventario.getSucursal(),isDeep,deepLoadType,clases);
				
		detallemovimientoinventario.setEjercicio(detallemovimientoinventarioDataAccess.getEjercicio(connexion,detallemovimientoinventario));
		EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
		ejercicioLogic.deepLoad(detallemovimientoinventario.getEjercicio(),isDeep,deepLoadType,clases);
				
		detallemovimientoinventario.setPeriodo(detallemovimientoinventarioDataAccess.getPeriodo(connexion,detallemovimientoinventario));
		PeriodoLogic periodoLogic= new PeriodoLogic(connexion);
		periodoLogic.deepLoad(detallemovimientoinventario.getPeriodo(),isDeep,deepLoadType,clases);
				
		detallemovimientoinventario.setAnio(detallemovimientoinventarioDataAccess.getAnio(connexion,detallemovimientoinventario));
		AnioLogic anioLogic= new AnioLogic(connexion);
		anioLogic.deepLoad(detallemovimientoinventario.getAnio(),isDeep,deepLoadType,clases);
				
		detallemovimientoinventario.setMes(detallemovimientoinventarioDataAccess.getMes(connexion,detallemovimientoinventario));
		MesLogic mesLogic= new MesLogic(connexion);
		mesLogic.deepLoad(detallemovimientoinventario.getMes(),isDeep,deepLoadType,clases);
				
		detallemovimientoinventario.setEstadoDetalleMovimientoInventario(detallemovimientoinventarioDataAccess.getEstadoDetalleMovimientoInventario(connexion,detallemovimientoinventario));
		EstadoDetalleMovimientoInventarioLogic estadodetallemovimientoinventarioLogic= new EstadoDetalleMovimientoInventarioLogic(connexion);
		estadodetallemovimientoinventarioLogic.deepLoad(detallemovimientoinventario.getEstadoDetalleMovimientoInventario(),isDeep,deepLoadType,clases);
				
		detallemovimientoinventario.setBodega(detallemovimientoinventarioDataAccess.getBodega(connexion,detallemovimientoinventario));
		BodegaLogic bodegaLogic= new BodegaLogic(connexion);
		bodegaLogic.deepLoad(detallemovimientoinventario.getBodega(),isDeep,deepLoadType,clases);
				
		detallemovimientoinventario.setProducto(detallemovimientoinventarioDataAccess.getProducto(connexion,detallemovimientoinventario));
		ProductoLogic productoLogic= new ProductoLogic(connexion);
		productoLogic.deepLoad(detallemovimientoinventario.getProducto(),isDeep,deepLoadType,clases);
				
		detallemovimientoinventario.setUnidad(detallemovimientoinventarioDataAccess.getUnidad(connexion,detallemovimientoinventario));
		UnidadLogic unidadLogic= new UnidadLogic(connexion);
		unidadLogic.deepLoad(detallemovimientoinventario.getUnidad(),isDeep,deepLoadType,clases);
				
		detallemovimientoinventario.setNovedadProducto(detallemovimientoinventarioDataAccess.getNovedadProducto(connexion,detallemovimientoinventario));
		NovedadProductoLogic novedadproductoLogic= new NovedadProductoLogic(connexion);
		novedadproductoLogic.deepLoad(detallemovimientoinventario.getNovedadProducto(),isDeep,deepLoadType,clases);
				
		detallemovimientoinventario.setCentroCosto(detallemovimientoinventarioDataAccess.getCentroCosto(connexion,detallemovimientoinventario));
		CentroCostoLogic centrocostoLogic= new CentroCostoLogic(connexion);
		centrocostoLogic.deepLoad(detallemovimientoinventario.getCentroCosto(),isDeep,deepLoadType,clases);
				
		detallemovimientoinventario.setCuentaContableCosto(detallemovimientoinventarioDataAccess.getCuentaContableCosto(connexion,detallemovimientoinventario));
		CuentaContableLogic cuentacontablecostoLogic= new CuentaContableLogic(connexion);
		cuentacontablecostoLogic.deepLoad(detallemovimientoinventario.getCuentaContableCosto(),isDeep,deepLoadType,clases);
				
		detallemovimientoinventario.setTipoDetalleMovimientoInventario(detallemovimientoinventarioDataAccess.getTipoDetalleMovimientoInventario(connexion,detallemovimientoinventario));
		TipoDetalleMovimientoInventarioLogic tipodetallemovimientoinventarioLogic= new TipoDetalleMovimientoInventarioLogic(connexion);
		tipodetallemovimientoinventarioLogic.deepLoad(detallemovimientoinventario.getTipoDetalleMovimientoInventario(),isDeep,deepLoadType,clases);
				

		detallemovimientoinventario.setNovedadSeguimientos(detallemovimientoinventarioDataAccess.getNovedadSeguimientos(connexion,detallemovimientoinventario));

		for(NovedadSeguimiento novedadseguimiento:detallemovimientoinventario.getNovedadSeguimientos()) {
			NovedadSeguimientoLogic novedadseguimientoLogic= new NovedadSeguimientoLogic(connexion);
			novedadseguimientoLogic.deepLoad(novedadseguimiento,isDeep,deepLoadType,clases);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(MovimientoInventario.class)) {
				detallemovimientoinventario.setMovimientoInventario(detallemovimientoinventarioDataAccess.getMovimientoInventario(connexion,detallemovimientoinventario));
				MovimientoInventarioLogic movimientoinventarioLogic= new MovimientoInventarioLogic(connexion);
				movimientoinventarioLogic.deepLoad(detallemovimientoinventario.getMovimientoInventario(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Empresa.class)) {
				detallemovimientoinventario.setEmpresa(detallemovimientoinventarioDataAccess.getEmpresa(connexion,detallemovimientoinventario));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(detallemovimientoinventario.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				detallemovimientoinventario.setSucursal(detallemovimientoinventarioDataAccess.getSucursal(connexion,detallemovimientoinventario));
				SucursalLogic sucursalLogic= new SucursalLogic(connexion);
				sucursalLogic.deepLoad(detallemovimientoinventario.getSucursal(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Ejercicio.class)) {
				detallemovimientoinventario.setEjercicio(detallemovimientoinventarioDataAccess.getEjercicio(connexion,detallemovimientoinventario));
				EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
				ejercicioLogic.deepLoad(detallemovimientoinventario.getEjercicio(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Periodo.class)) {
				detallemovimientoinventario.setPeriodo(detallemovimientoinventarioDataAccess.getPeriodo(connexion,detallemovimientoinventario));
				PeriodoLogic periodoLogic= new PeriodoLogic(connexion);
				periodoLogic.deepLoad(detallemovimientoinventario.getPeriodo(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Anio.class)) {
				detallemovimientoinventario.setAnio(detallemovimientoinventarioDataAccess.getAnio(connexion,detallemovimientoinventario));
				AnioLogic anioLogic= new AnioLogic(connexion);
				anioLogic.deepLoad(detallemovimientoinventario.getAnio(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Mes.class)) {
				detallemovimientoinventario.setMes(detallemovimientoinventarioDataAccess.getMes(connexion,detallemovimientoinventario));
				MesLogic mesLogic= new MesLogic(connexion);
				mesLogic.deepLoad(detallemovimientoinventario.getMes(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(EstadoDetalleMovimientoInventario.class)) {
				detallemovimientoinventario.setEstadoDetalleMovimientoInventario(detallemovimientoinventarioDataAccess.getEstadoDetalleMovimientoInventario(connexion,detallemovimientoinventario));
				EstadoDetalleMovimientoInventarioLogic estadodetallemovimientoinventarioLogic= new EstadoDetalleMovimientoInventarioLogic(connexion);
				estadodetallemovimientoinventarioLogic.deepLoad(detallemovimientoinventario.getEstadoDetalleMovimientoInventario(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Bodega.class)) {
				detallemovimientoinventario.setBodega(detallemovimientoinventarioDataAccess.getBodega(connexion,detallemovimientoinventario));
				BodegaLogic bodegaLogic= new BodegaLogic(connexion);
				bodegaLogic.deepLoad(detallemovimientoinventario.getBodega(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Producto.class)) {
				detallemovimientoinventario.setProducto(detallemovimientoinventarioDataAccess.getProducto(connexion,detallemovimientoinventario));
				ProductoLogic productoLogic= new ProductoLogic(connexion);
				productoLogic.deepLoad(detallemovimientoinventario.getProducto(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Unidad.class)) {
				detallemovimientoinventario.setUnidad(detallemovimientoinventarioDataAccess.getUnidad(connexion,detallemovimientoinventario));
				UnidadLogic unidadLogic= new UnidadLogic(connexion);
				unidadLogic.deepLoad(detallemovimientoinventario.getUnidad(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(NovedadProducto.class)) {
				detallemovimientoinventario.setNovedadProducto(detallemovimientoinventarioDataAccess.getNovedadProducto(connexion,detallemovimientoinventario));
				NovedadProductoLogic novedadproductoLogic= new NovedadProductoLogic(connexion);
				novedadproductoLogic.deepLoad(detallemovimientoinventario.getNovedadProducto(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(CentroCosto.class)) {
				detallemovimientoinventario.setCentroCosto(detallemovimientoinventarioDataAccess.getCentroCosto(connexion,detallemovimientoinventario));
				CentroCostoLogic centrocostoLogic= new CentroCostoLogic(connexion);
				centrocostoLogic.deepLoad(detallemovimientoinventario.getCentroCosto(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				detallemovimientoinventario.setCuentaContableCosto(detallemovimientoinventarioDataAccess.getCuentaContableCosto(connexion,detallemovimientoinventario));
				CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
				cuentacontableLogic.deepLoad(detallemovimientoinventario.getCuentaContableCosto(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoDetalleMovimientoInventario.class)) {
				detallemovimientoinventario.setTipoDetalleMovimientoInventario(detallemovimientoinventarioDataAccess.getTipoDetalleMovimientoInventario(connexion,detallemovimientoinventario));
				TipoDetalleMovimientoInventarioLogic tipodetallemovimientoinventarioLogic= new TipoDetalleMovimientoInventarioLogic(connexion);
				tipodetallemovimientoinventarioLogic.deepLoad(detallemovimientoinventario.getTipoDetalleMovimientoInventario(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(NovedadSeguimiento.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				detallemovimientoinventario.setNovedadSeguimientos(detallemovimientoinventarioDataAccess.getNovedadSeguimientos(connexion,detallemovimientoinventario));

				for(NovedadSeguimiento novedadseguimiento:detallemovimientoinventario.getNovedadSeguimientos()) {
					NovedadSeguimientoLogic novedadseguimientoLogic= new NovedadSeguimientoLogic(connexion);
					novedadseguimientoLogic.deepLoad(novedadseguimiento,isDeep,deepLoadType,clases);
				}
				continue;
			}

		}
	}
	else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {


		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(MovimientoInventario.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detallemovimientoinventario.setMovimientoInventario(detallemovimientoinventarioDataAccess.getMovimientoInventario(connexion,detallemovimientoinventario));
			MovimientoInventarioLogic movimientoinventarioLogic= new MovimientoInventarioLogic(connexion);
			movimientoinventarioLogic.deepLoad(detallemovimientoinventario.getMovimientoInventario(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detallemovimientoinventario.setEmpresa(detallemovimientoinventarioDataAccess.getEmpresa(connexion,detallemovimientoinventario));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(detallemovimientoinventario.getEmpresa(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detallemovimientoinventario.setSucursal(detallemovimientoinventarioDataAccess.getSucursal(connexion,detallemovimientoinventario));
			SucursalLogic sucursalLogic= new SucursalLogic(connexion);
			sucursalLogic.deepLoad(detallemovimientoinventario.getSucursal(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Ejercicio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detallemovimientoinventario.setEjercicio(detallemovimientoinventarioDataAccess.getEjercicio(connexion,detallemovimientoinventario));
			EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
			ejercicioLogic.deepLoad(detallemovimientoinventario.getEjercicio(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Periodo.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detallemovimientoinventario.setPeriodo(detallemovimientoinventarioDataAccess.getPeriodo(connexion,detallemovimientoinventario));
			PeriodoLogic periodoLogic= new PeriodoLogic(connexion);
			periodoLogic.deepLoad(detallemovimientoinventario.getPeriodo(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Anio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detallemovimientoinventario.setAnio(detallemovimientoinventarioDataAccess.getAnio(connexion,detallemovimientoinventario));
			AnioLogic anioLogic= new AnioLogic(connexion);
			anioLogic.deepLoad(detallemovimientoinventario.getAnio(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Mes.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detallemovimientoinventario.setMes(detallemovimientoinventarioDataAccess.getMes(connexion,detallemovimientoinventario));
			MesLogic mesLogic= new MesLogic(connexion);
			mesLogic.deepLoad(detallemovimientoinventario.getMes(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(EstadoDetalleMovimientoInventario.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detallemovimientoinventario.setEstadoDetalleMovimientoInventario(detallemovimientoinventarioDataAccess.getEstadoDetalleMovimientoInventario(connexion,detallemovimientoinventario));
			EstadoDetalleMovimientoInventarioLogic estadodetallemovimientoinventarioLogic= new EstadoDetalleMovimientoInventarioLogic(connexion);
			estadodetallemovimientoinventarioLogic.deepLoad(detallemovimientoinventario.getEstadoDetalleMovimientoInventario(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Bodega.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detallemovimientoinventario.setBodega(detallemovimientoinventarioDataAccess.getBodega(connexion,detallemovimientoinventario));
			BodegaLogic bodegaLogic= new BodegaLogic(connexion);
			bodegaLogic.deepLoad(detallemovimientoinventario.getBodega(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Producto.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detallemovimientoinventario.setProducto(detallemovimientoinventarioDataAccess.getProducto(connexion,detallemovimientoinventario));
			ProductoLogic productoLogic= new ProductoLogic(connexion);
			productoLogic.deepLoad(detallemovimientoinventario.getProducto(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Unidad.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detallemovimientoinventario.setUnidad(detallemovimientoinventarioDataAccess.getUnidad(connexion,detallemovimientoinventario));
			UnidadLogic unidadLogic= new UnidadLogic(connexion);
			unidadLogic.deepLoad(detallemovimientoinventario.getUnidad(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(NovedadProducto.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detallemovimientoinventario.setNovedadProducto(detallemovimientoinventarioDataAccess.getNovedadProducto(connexion,detallemovimientoinventario));
			NovedadProductoLogic novedadproductoLogic= new NovedadProductoLogic(connexion);
			novedadproductoLogic.deepLoad(detallemovimientoinventario.getNovedadProducto(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(CentroCosto.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detallemovimientoinventario.setCentroCosto(detallemovimientoinventarioDataAccess.getCentroCosto(connexion,detallemovimientoinventario));
			CentroCostoLogic centrocostoLogic= new CentroCostoLogic(connexion);
			centrocostoLogic.deepLoad(detallemovimientoinventario.getCentroCosto(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(CuentaContable.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detallemovimientoinventario.setCuentaContableCosto(detallemovimientoinventarioDataAccess.getCuentaContableCosto(connexion,detallemovimientoinventario));
			CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
			cuentacontableLogic.deepLoad(detallemovimientoinventario.getCuentaContableCosto(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(TipoDetalleMovimientoInventario.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detallemovimientoinventario.setTipoDetalleMovimientoInventario(detallemovimientoinventarioDataAccess.getTipoDetalleMovimientoInventario(connexion,detallemovimientoinventario));
			TipoDetalleMovimientoInventarioLogic tipodetallemovimientoinventarioLogic= new TipoDetalleMovimientoInventarioLogic(connexion);
			tipodetallemovimientoinventarioLogic.deepLoad(detallemovimientoinventario.getTipoDetalleMovimientoInventario(),isDeep,deepLoadType,clases);
				
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(NovedadSeguimiento.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(NovedadSeguimiento.class));
			detallemovimientoinventario.setNovedadSeguimientos(detallemovimientoinventarioDataAccess.getNovedadSeguimientos(connexion,detallemovimientoinventario));

			for(NovedadSeguimiento novedadseguimiento:detallemovimientoinventario.getNovedadSeguimientos()) {
				NovedadSeguimientoLogic novedadseguimientoLogic= new NovedadSeguimientoLogic(connexion);
				novedadseguimientoLogic.deepLoad(novedadseguimiento,isDeep,deepLoadType,clases);
			}
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(DetalleMovimientoInventario detallemovimientoinventario,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			DetalleMovimientoInventarioLogicAdditional.updateDetalleMovimientoInventarioToSave(detallemovimientoinventario,this.arrDatoGeneral);
			
DetalleMovimientoInventarioDataAccess.save(detallemovimientoinventario, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		MovimientoInventarioDataAccess.save(detallemovimientoinventario.getMovimientoInventario(),connexion);

		EmpresaDataAccess.save(detallemovimientoinventario.getEmpresa(),connexion);

		SucursalDataAccess.save(detallemovimientoinventario.getSucursal(),connexion);

		EjercicioDataAccess.save(detallemovimientoinventario.getEjercicio(),connexion);

		PeriodoDataAccess.save(detallemovimientoinventario.getPeriodo(),connexion);

		AnioDataAccess.save(detallemovimientoinventario.getAnio(),connexion);

		MesDataAccess.save(detallemovimientoinventario.getMes(),connexion);

		EstadoDetalleMovimientoInventarioDataAccess.save(detallemovimientoinventario.getEstadoDetalleMovimientoInventario(),connexion);

		BodegaDataAccess.save(detallemovimientoinventario.getBodega(),connexion);

		ProductoDataAccess.save(detallemovimientoinventario.getProducto(),connexion);

		UnidadDataAccess.save(detallemovimientoinventario.getUnidad(),connexion);

		NovedadProductoDataAccess.save(detallemovimientoinventario.getNovedadProducto(),connexion);

		CentroCostoDataAccess.save(detallemovimientoinventario.getCentroCosto(),connexion);

		CuentaContableDataAccess.save(detallemovimientoinventario.getCuentaContableCosto(),connexion);

		TipoDetalleMovimientoInventarioDataAccess.save(detallemovimientoinventario.getTipoDetalleMovimientoInventario(),connexion);

		for(NovedadSeguimiento novedadseguimiento:detallemovimientoinventario.getNovedadSeguimientos()) {
			novedadseguimiento.setid_detalle_movimiento_inventario(detallemovimientoinventario.getId());
			NovedadSeguimientoDataAccess.save(novedadseguimiento,connexion);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(MovimientoInventario.class)) {
				MovimientoInventarioDataAccess.save(detallemovimientoinventario.getMovimientoInventario(),connexion);
				continue;
			}

			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(detallemovimientoinventario.getEmpresa(),connexion);
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				SucursalDataAccess.save(detallemovimientoinventario.getSucursal(),connexion);
				continue;
			}

			if(clas.clas.equals(Ejercicio.class)) {
				EjercicioDataAccess.save(detallemovimientoinventario.getEjercicio(),connexion);
				continue;
			}

			if(clas.clas.equals(Periodo.class)) {
				PeriodoDataAccess.save(detallemovimientoinventario.getPeriodo(),connexion);
				continue;
			}

			if(clas.clas.equals(Anio.class)) {
				AnioDataAccess.save(detallemovimientoinventario.getAnio(),connexion);
				continue;
			}

			if(clas.clas.equals(Mes.class)) {
				MesDataAccess.save(detallemovimientoinventario.getMes(),connexion);
				continue;
			}

			if(clas.clas.equals(EstadoDetalleMovimientoInventario.class)) {
				EstadoDetalleMovimientoInventarioDataAccess.save(detallemovimientoinventario.getEstadoDetalleMovimientoInventario(),connexion);
				continue;
			}

			if(clas.clas.equals(Bodega.class)) {
				BodegaDataAccess.save(detallemovimientoinventario.getBodega(),connexion);
				continue;
			}

			if(clas.clas.equals(Producto.class)) {
				ProductoDataAccess.save(detallemovimientoinventario.getProducto(),connexion);
				continue;
			}

			if(clas.clas.equals(Unidad.class)) {
				UnidadDataAccess.save(detallemovimientoinventario.getUnidad(),connexion);
				continue;
			}

			if(clas.clas.equals(NovedadProducto.class)) {
				NovedadProductoDataAccess.save(detallemovimientoinventario.getNovedadProducto(),connexion);
				continue;
			}

			if(clas.clas.equals(CentroCosto.class)) {
				CentroCostoDataAccess.save(detallemovimientoinventario.getCentroCosto(),connexion);
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				CuentaContableDataAccess.save(detallemovimientoinventario.getCuentaContableCosto(),connexion);
				continue;
			}

			if(clas.clas.equals(TipoDetalleMovimientoInventario.class)) {
				TipoDetalleMovimientoInventarioDataAccess.save(detallemovimientoinventario.getTipoDetalleMovimientoInventario(),connexion);
				continue;
			}


			if(clas.clas.equals(NovedadSeguimiento.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(NovedadSeguimiento novedadseguimiento:detallemovimientoinventario.getNovedadSeguimientos()) {
					novedadseguimiento.setid_detalle_movimiento_inventario(detallemovimientoinventario.getId());
					NovedadSeguimientoDataAccess.save(novedadseguimiento,connexion);
				}
				continue;
			}
		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		MovimientoInventarioDataAccess.save(detallemovimientoinventario.getMovimientoInventario(),connexion);
		MovimientoInventarioLogic movimientoinventarioLogic= new MovimientoInventarioLogic(connexion);
		movimientoinventarioLogic.deepLoad(detallemovimientoinventario.getMovimientoInventario(),isDeep,deepLoadType,clases);
				

		EmpresaDataAccess.save(detallemovimientoinventario.getEmpresa(),connexion);
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(detallemovimientoinventario.getEmpresa(),isDeep,deepLoadType,clases);
				

		SucursalDataAccess.save(detallemovimientoinventario.getSucursal(),connexion);
		SucursalLogic sucursalLogic= new SucursalLogic(connexion);
		sucursalLogic.deepLoad(detallemovimientoinventario.getSucursal(),isDeep,deepLoadType,clases);
				

		EjercicioDataAccess.save(detallemovimientoinventario.getEjercicio(),connexion);
		EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
		ejercicioLogic.deepLoad(detallemovimientoinventario.getEjercicio(),isDeep,deepLoadType,clases);
				

		PeriodoDataAccess.save(detallemovimientoinventario.getPeriodo(),connexion);
		PeriodoLogic periodoLogic= new PeriodoLogic(connexion);
		periodoLogic.deepLoad(detallemovimientoinventario.getPeriodo(),isDeep,deepLoadType,clases);
				

		AnioDataAccess.save(detallemovimientoinventario.getAnio(),connexion);
		AnioLogic anioLogic= new AnioLogic(connexion);
		anioLogic.deepLoad(detallemovimientoinventario.getAnio(),isDeep,deepLoadType,clases);
				

		MesDataAccess.save(detallemovimientoinventario.getMes(),connexion);
		MesLogic mesLogic= new MesLogic(connexion);
		mesLogic.deepLoad(detallemovimientoinventario.getMes(),isDeep,deepLoadType,clases);
				

		EstadoDetalleMovimientoInventarioDataAccess.save(detallemovimientoinventario.getEstadoDetalleMovimientoInventario(),connexion);
		EstadoDetalleMovimientoInventarioLogic estadodetallemovimientoinventarioLogic= new EstadoDetalleMovimientoInventarioLogic(connexion);
		estadodetallemovimientoinventarioLogic.deepLoad(detallemovimientoinventario.getEstadoDetalleMovimientoInventario(),isDeep,deepLoadType,clases);
				

		BodegaDataAccess.save(detallemovimientoinventario.getBodega(),connexion);
		BodegaLogic bodegaLogic= new BodegaLogic(connexion);
		bodegaLogic.deepLoad(detallemovimientoinventario.getBodega(),isDeep,deepLoadType,clases);
				

		ProductoDataAccess.save(detallemovimientoinventario.getProducto(),connexion);
		ProductoLogic productoLogic= new ProductoLogic(connexion);
		productoLogic.deepLoad(detallemovimientoinventario.getProducto(),isDeep,deepLoadType,clases);
				

		UnidadDataAccess.save(detallemovimientoinventario.getUnidad(),connexion);
		UnidadLogic unidadLogic= new UnidadLogic(connexion);
		unidadLogic.deepLoad(detallemovimientoinventario.getUnidad(),isDeep,deepLoadType,clases);
				

		NovedadProductoDataAccess.save(detallemovimientoinventario.getNovedadProducto(),connexion);
		NovedadProductoLogic novedadproductoLogic= new NovedadProductoLogic(connexion);
		novedadproductoLogic.deepLoad(detallemovimientoinventario.getNovedadProducto(),isDeep,deepLoadType,clases);
				

		CentroCostoDataAccess.save(detallemovimientoinventario.getCentroCosto(),connexion);
		CentroCostoLogic centrocostoLogic= new CentroCostoLogic(connexion);
		centrocostoLogic.deepLoad(detallemovimientoinventario.getCentroCosto(),isDeep,deepLoadType,clases);
				

		CuentaContableDataAccess.save(detallemovimientoinventario.getCuentaContableCosto(),connexion);
		CuentaContableLogic cuentacontablecostoLogic= new CuentaContableLogic(connexion);
		cuentacontablecostoLogic.deepLoad(detallemovimientoinventario.getCuentaContableCosto(),isDeep,deepLoadType,clases);
				

		TipoDetalleMovimientoInventarioDataAccess.save(detallemovimientoinventario.getTipoDetalleMovimientoInventario(),connexion);
		TipoDetalleMovimientoInventarioLogic tipodetallemovimientoinventarioLogic= new TipoDetalleMovimientoInventarioLogic(connexion);
		tipodetallemovimientoinventarioLogic.deepLoad(detallemovimientoinventario.getTipoDetalleMovimientoInventario(),isDeep,deepLoadType,clases);
				

		for(NovedadSeguimiento novedadseguimiento:detallemovimientoinventario.getNovedadSeguimientos()) {
			NovedadSeguimientoLogic novedadseguimientoLogic= new NovedadSeguimientoLogic(connexion);
			novedadseguimiento.setid_detalle_movimiento_inventario(detallemovimientoinventario.getId());
			NovedadSeguimientoDataAccess.save(novedadseguimiento,connexion);
			novedadseguimientoLogic.deepSave(novedadseguimiento,isDeep,deepLoadType,clases);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(MovimientoInventario.class)) {
				MovimientoInventarioDataAccess.save(detallemovimientoinventario.getMovimientoInventario(),connexion);
				MovimientoInventarioLogic movimientoinventarioLogic= new MovimientoInventarioLogic(connexion);
				movimientoinventarioLogic.deepSave(detallemovimientoinventario.getMovimientoInventario(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(detallemovimientoinventario.getEmpresa(),connexion);
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepSave(detallemovimientoinventario.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				SucursalDataAccess.save(detallemovimientoinventario.getSucursal(),connexion);
				SucursalLogic sucursalLogic= new SucursalLogic(connexion);
				sucursalLogic.deepSave(detallemovimientoinventario.getSucursal(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Ejercicio.class)) {
				EjercicioDataAccess.save(detallemovimientoinventario.getEjercicio(),connexion);
				EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
				ejercicioLogic.deepSave(detallemovimientoinventario.getEjercicio(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Periodo.class)) {
				PeriodoDataAccess.save(detallemovimientoinventario.getPeriodo(),connexion);
				PeriodoLogic periodoLogic= new PeriodoLogic(connexion);
				periodoLogic.deepSave(detallemovimientoinventario.getPeriodo(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Anio.class)) {
				AnioDataAccess.save(detallemovimientoinventario.getAnio(),connexion);
				AnioLogic anioLogic= new AnioLogic(connexion);
				anioLogic.deepSave(detallemovimientoinventario.getAnio(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Mes.class)) {
				MesDataAccess.save(detallemovimientoinventario.getMes(),connexion);
				MesLogic mesLogic= new MesLogic(connexion);
				mesLogic.deepSave(detallemovimientoinventario.getMes(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(EstadoDetalleMovimientoInventario.class)) {
				EstadoDetalleMovimientoInventarioDataAccess.save(detallemovimientoinventario.getEstadoDetalleMovimientoInventario(),connexion);
				EstadoDetalleMovimientoInventarioLogic estadodetallemovimientoinventarioLogic= new EstadoDetalleMovimientoInventarioLogic(connexion);
				estadodetallemovimientoinventarioLogic.deepSave(detallemovimientoinventario.getEstadoDetalleMovimientoInventario(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Bodega.class)) {
				BodegaDataAccess.save(detallemovimientoinventario.getBodega(),connexion);
				BodegaLogic bodegaLogic= new BodegaLogic(connexion);
				bodegaLogic.deepSave(detallemovimientoinventario.getBodega(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Producto.class)) {
				ProductoDataAccess.save(detallemovimientoinventario.getProducto(),connexion);
				ProductoLogic productoLogic= new ProductoLogic(connexion);
				productoLogic.deepSave(detallemovimientoinventario.getProducto(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Unidad.class)) {
				UnidadDataAccess.save(detallemovimientoinventario.getUnidad(),connexion);
				UnidadLogic unidadLogic= new UnidadLogic(connexion);
				unidadLogic.deepSave(detallemovimientoinventario.getUnidad(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(NovedadProducto.class)) {
				NovedadProductoDataAccess.save(detallemovimientoinventario.getNovedadProducto(),connexion);
				NovedadProductoLogic novedadproductoLogic= new NovedadProductoLogic(connexion);
				novedadproductoLogic.deepSave(detallemovimientoinventario.getNovedadProducto(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(CentroCosto.class)) {
				CentroCostoDataAccess.save(detallemovimientoinventario.getCentroCosto(),connexion);
				CentroCostoLogic centrocostoLogic= new CentroCostoLogic(connexion);
				centrocostoLogic.deepSave(detallemovimientoinventario.getCentroCosto(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				CuentaContableDataAccess.save(detallemovimientoinventario.getCuentaContableCosto(),connexion);
				CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
				cuentacontableLogic.deepSave(detallemovimientoinventario.getCuentaContableCosto(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoDetalleMovimientoInventario.class)) {
				TipoDetalleMovimientoInventarioDataAccess.save(detallemovimientoinventario.getTipoDetalleMovimientoInventario(),connexion);
				TipoDetalleMovimientoInventarioLogic tipodetallemovimientoinventarioLogic= new TipoDetalleMovimientoInventarioLogic(connexion);
				tipodetallemovimientoinventarioLogic.deepSave(detallemovimientoinventario.getTipoDetalleMovimientoInventario(),isDeep,deepLoadType,clases);				
				continue;
			}


			if(clas.clas.equals(NovedadSeguimiento.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(NovedadSeguimiento novedadseguimiento:detallemovimientoinventario.getNovedadSeguimientos()) {
					NovedadSeguimientoLogic novedadseguimientoLogic= new NovedadSeguimientoLogic(connexion);
					novedadseguimiento.setid_detalle_movimiento_inventario(detallemovimientoinventario.getId());
					NovedadSeguimientoDataAccess.save(novedadseguimiento,connexion);
					novedadseguimientoLogic.deepSave(novedadseguimiento,isDeep,deepLoadType,clases);
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
			this.getNewConnexionToDeep(DetalleMovimientoInventario.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(detallemovimientoinventario,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				DetalleMovimientoInventarioConstantesFunciones.refrescarForeignKeysDescripcionesDetalleMovimientoInventario(detallemovimientoinventario);
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
			this.deepLoad(this.detallemovimientoinventario,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				DetalleMovimientoInventarioConstantesFunciones.refrescarForeignKeysDescripcionesDetalleMovimientoInventario(this.detallemovimientoinventario);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(DetalleMovimientoInventario.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(detallemovimientoinventarios!=null) {
				for(DetalleMovimientoInventario detallemovimientoinventario:detallemovimientoinventarios) {
					this.deepLoad(detallemovimientoinventario,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					DetalleMovimientoInventarioConstantesFunciones.refrescarForeignKeysDescripcionesDetalleMovimientoInventario(detallemovimientoinventarios);
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
			if(detallemovimientoinventarios!=null) {
				for(DetalleMovimientoInventario detallemovimientoinventario:detallemovimientoinventarios) {
					this.deepLoad(detallemovimientoinventario,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					DetalleMovimientoInventarioConstantesFunciones.refrescarForeignKeysDescripcionesDetalleMovimientoInventario(detallemovimientoinventarios);
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
			this.getNewConnexionToDeep(DetalleMovimientoInventario.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(detallemovimientoinventario,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(DetalleMovimientoInventario.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(detallemovimientoinventarios!=null) {
				for(DetalleMovimientoInventario detallemovimientoinventario:detallemovimientoinventarios) {
					this.deepSave(detallemovimientoinventario,isDeep,deepLoadType,clases);
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
			if(detallemovimientoinventarios!=null) {
				for(DetalleMovimientoInventario detallemovimientoinventario:detallemovimientoinventarios) {
					this.deepSave(detallemovimientoinventario,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getDetalleMovimientoInventariosFK_IdAnioWithConnection(String sFinalQuery,Pagination pagination,Long id_anio)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleMovimientoInventario.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidAnio= new ParameterSelectionGeneral();
			parameterSelectionGeneralidAnio.setParameterSelectionGeneralEqual(ParameterType.LONG,id_anio,DetalleMovimientoInventarioConstantesFunciones.IDANIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidAnio);

			DetalleMovimientoInventarioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdAnio","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detallemovimientoinventarios=detallemovimientoinventarioDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleMovimientoInventarioConstantesFunciones.refrescarForeignKeysDescripcionesDetalleMovimientoInventario(this.detallemovimientoinventarios);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getDetalleMovimientoInventariosFK_IdAnio(String sFinalQuery,Pagination pagination,Long id_anio)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidAnio= new ParameterSelectionGeneral();
			parameterSelectionGeneralidAnio.setParameterSelectionGeneralEqual(ParameterType.LONG,id_anio,DetalleMovimientoInventarioConstantesFunciones.IDANIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidAnio);

			DetalleMovimientoInventarioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdAnio","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detallemovimientoinventarios=detallemovimientoinventarioDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleMovimientoInventarioConstantesFunciones.refrescarForeignKeysDescripcionesDetalleMovimientoInventario(this.detallemovimientoinventarios);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getDetalleMovimientoInventariosFK_IdBodegaWithConnection(String sFinalQuery,Pagination pagination,Long id_bodega)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleMovimientoInventario.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidBodega= new ParameterSelectionGeneral();
			parameterSelectionGeneralidBodega.setParameterSelectionGeneralEqual(ParameterType.LONG,id_bodega,DetalleMovimientoInventarioConstantesFunciones.IDBODEGA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidBodega);

			DetalleMovimientoInventarioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdBodega","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detallemovimientoinventarios=detallemovimientoinventarioDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleMovimientoInventarioConstantesFunciones.refrescarForeignKeysDescripcionesDetalleMovimientoInventario(this.detallemovimientoinventarios);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getDetalleMovimientoInventariosFK_IdBodega(String sFinalQuery,Pagination pagination,Long id_bodega)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidBodega= new ParameterSelectionGeneral();
			parameterSelectionGeneralidBodega.setParameterSelectionGeneralEqual(ParameterType.LONG,id_bodega,DetalleMovimientoInventarioConstantesFunciones.IDBODEGA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidBodega);

			DetalleMovimientoInventarioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdBodega","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detallemovimientoinventarios=detallemovimientoinventarioDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleMovimientoInventarioConstantesFunciones.refrescarForeignKeysDescripcionesDetalleMovimientoInventario(this.detallemovimientoinventarios);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getDetalleMovimientoInventariosFK_IdCentroCostoWithConnection(String sFinalQuery,Pagination pagination,Long id_centro_costo)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleMovimientoInventario.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCentroCosto= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCentroCosto.setParameterSelectionGeneralEqual(ParameterType.LONG,id_centro_costo,DetalleMovimientoInventarioConstantesFunciones.IDCENTROCOSTO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCentroCosto);

			DetalleMovimientoInventarioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCentroCosto","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detallemovimientoinventarios=detallemovimientoinventarioDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleMovimientoInventarioConstantesFunciones.refrescarForeignKeysDescripcionesDetalleMovimientoInventario(this.detallemovimientoinventarios);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getDetalleMovimientoInventariosFK_IdCentroCosto(String sFinalQuery,Pagination pagination,Long id_centro_costo)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCentroCosto= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCentroCosto.setParameterSelectionGeneralEqual(ParameterType.LONG,id_centro_costo,DetalleMovimientoInventarioConstantesFunciones.IDCENTROCOSTO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCentroCosto);

			DetalleMovimientoInventarioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCentroCosto","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detallemovimientoinventarios=detallemovimientoinventarioDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleMovimientoInventarioConstantesFunciones.refrescarForeignKeysDescripcionesDetalleMovimientoInventario(this.detallemovimientoinventarios);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getDetalleMovimientoInventariosFK_IdCuentaContableCostoWithConnection(String sFinalQuery,Pagination pagination,Long id_cuenta_contable_costo)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleMovimientoInventario.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCuentaContableCosto= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCuentaContableCosto.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cuenta_contable_costo,DetalleMovimientoInventarioConstantesFunciones.IDCUENTACONTABLECOSTO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCuentaContableCosto);

			DetalleMovimientoInventarioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCuentaContableCosto","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detallemovimientoinventarios=detallemovimientoinventarioDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleMovimientoInventarioConstantesFunciones.refrescarForeignKeysDescripcionesDetalleMovimientoInventario(this.detallemovimientoinventarios);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getDetalleMovimientoInventariosFK_IdCuentaContableCosto(String sFinalQuery,Pagination pagination,Long id_cuenta_contable_costo)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCuentaContableCosto= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCuentaContableCosto.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cuenta_contable_costo,DetalleMovimientoInventarioConstantesFunciones.IDCUENTACONTABLECOSTO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCuentaContableCosto);

			DetalleMovimientoInventarioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCuentaContableCosto","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detallemovimientoinventarios=detallemovimientoinventarioDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleMovimientoInventarioConstantesFunciones.refrescarForeignKeysDescripcionesDetalleMovimientoInventario(this.detallemovimientoinventarios);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getDetalleMovimientoInventariosFK_IdEjercicioWithConnection(String sFinalQuery,Pagination pagination,Long id_ejercicio)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleMovimientoInventario.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEjercicio= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEjercicio.setParameterSelectionGeneralEqual(ParameterType.LONG,id_ejercicio,DetalleMovimientoInventarioConstantesFunciones.IDEJERCICIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEjercicio);

			DetalleMovimientoInventarioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEjercicio","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detallemovimientoinventarios=detallemovimientoinventarioDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleMovimientoInventarioConstantesFunciones.refrescarForeignKeysDescripcionesDetalleMovimientoInventario(this.detallemovimientoinventarios);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getDetalleMovimientoInventariosFK_IdEjercicio(String sFinalQuery,Pagination pagination,Long id_ejercicio)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEjercicio= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEjercicio.setParameterSelectionGeneralEqual(ParameterType.LONG,id_ejercicio,DetalleMovimientoInventarioConstantesFunciones.IDEJERCICIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEjercicio);

			DetalleMovimientoInventarioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEjercicio","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detallemovimientoinventarios=detallemovimientoinventarioDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleMovimientoInventarioConstantesFunciones.refrescarForeignKeysDescripcionesDetalleMovimientoInventario(this.detallemovimientoinventarios);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getDetalleMovimientoInventariosFK_IdEmpresaWithConnection(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleMovimientoInventario.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,DetalleMovimientoInventarioConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			DetalleMovimientoInventarioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detallemovimientoinventarios=detallemovimientoinventarioDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleMovimientoInventarioConstantesFunciones.refrescarForeignKeysDescripcionesDetalleMovimientoInventario(this.detallemovimientoinventarios);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getDetalleMovimientoInventariosFK_IdEmpresa(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,DetalleMovimientoInventarioConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			DetalleMovimientoInventarioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detallemovimientoinventarios=detallemovimientoinventarioDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleMovimientoInventarioConstantesFunciones.refrescarForeignKeysDescripcionesDetalleMovimientoInventario(this.detallemovimientoinventarios);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getDetalleMovimientoInventariosFK_IdEstadoDetalleMovimientoInventarioWithConnection(String sFinalQuery,Pagination pagination,Long id_estado_detalle_movimiento_inventario)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleMovimientoInventario.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEstadoDetalleMovimientoInventario= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEstadoDetalleMovimientoInventario.setParameterSelectionGeneralEqual(ParameterType.LONG,id_estado_detalle_movimiento_inventario,DetalleMovimientoInventarioConstantesFunciones.IDESTADODETALLEMOVIMIENTOINVENTARIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEstadoDetalleMovimientoInventario);

			DetalleMovimientoInventarioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEstadoDetalleMovimientoInventario","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detallemovimientoinventarios=detallemovimientoinventarioDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleMovimientoInventarioConstantesFunciones.refrescarForeignKeysDescripcionesDetalleMovimientoInventario(this.detallemovimientoinventarios);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getDetalleMovimientoInventariosFK_IdEstadoDetalleMovimientoInventario(String sFinalQuery,Pagination pagination,Long id_estado_detalle_movimiento_inventario)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEstadoDetalleMovimientoInventario= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEstadoDetalleMovimientoInventario.setParameterSelectionGeneralEqual(ParameterType.LONG,id_estado_detalle_movimiento_inventario,DetalleMovimientoInventarioConstantesFunciones.IDESTADODETALLEMOVIMIENTOINVENTARIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEstadoDetalleMovimientoInventario);

			DetalleMovimientoInventarioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEstadoDetalleMovimientoInventario","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detallemovimientoinventarios=detallemovimientoinventarioDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleMovimientoInventarioConstantesFunciones.refrescarForeignKeysDescripcionesDetalleMovimientoInventario(this.detallemovimientoinventarios);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getDetalleMovimientoInventariosFK_IdMesWithConnection(String sFinalQuery,Pagination pagination,Long id_mes)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleMovimientoInventario.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidMes= new ParameterSelectionGeneral();
			parameterSelectionGeneralidMes.setParameterSelectionGeneralEqual(ParameterType.LONG,id_mes,DetalleMovimientoInventarioConstantesFunciones.IDMES,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidMes);

			DetalleMovimientoInventarioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdMes","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detallemovimientoinventarios=detallemovimientoinventarioDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleMovimientoInventarioConstantesFunciones.refrescarForeignKeysDescripcionesDetalleMovimientoInventario(this.detallemovimientoinventarios);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getDetalleMovimientoInventariosFK_IdMes(String sFinalQuery,Pagination pagination,Long id_mes)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidMes= new ParameterSelectionGeneral();
			parameterSelectionGeneralidMes.setParameterSelectionGeneralEqual(ParameterType.LONG,id_mes,DetalleMovimientoInventarioConstantesFunciones.IDMES,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidMes);

			DetalleMovimientoInventarioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdMes","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detallemovimientoinventarios=detallemovimientoinventarioDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleMovimientoInventarioConstantesFunciones.refrescarForeignKeysDescripcionesDetalleMovimientoInventario(this.detallemovimientoinventarios);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getDetalleMovimientoInventariosFK_IdMovimientoInventarioWithConnection(String sFinalQuery,Pagination pagination,Long id_movimiento_inventario)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleMovimientoInventario.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidMovimientoInventario= new ParameterSelectionGeneral();
			parameterSelectionGeneralidMovimientoInventario.setParameterSelectionGeneralEqual(ParameterType.LONG,id_movimiento_inventario,DetalleMovimientoInventarioConstantesFunciones.IDMOVIMIENTOINVENTARIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidMovimientoInventario);

			DetalleMovimientoInventarioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdMovimientoInventario","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detallemovimientoinventarios=detallemovimientoinventarioDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleMovimientoInventarioConstantesFunciones.refrescarForeignKeysDescripcionesDetalleMovimientoInventario(this.detallemovimientoinventarios);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getDetalleMovimientoInventariosFK_IdMovimientoInventario(String sFinalQuery,Pagination pagination,Long id_movimiento_inventario)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidMovimientoInventario= new ParameterSelectionGeneral();
			parameterSelectionGeneralidMovimientoInventario.setParameterSelectionGeneralEqual(ParameterType.LONG,id_movimiento_inventario,DetalleMovimientoInventarioConstantesFunciones.IDMOVIMIENTOINVENTARIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidMovimientoInventario);

			DetalleMovimientoInventarioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdMovimientoInventario","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detallemovimientoinventarios=detallemovimientoinventarioDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleMovimientoInventarioConstantesFunciones.refrescarForeignKeysDescripcionesDetalleMovimientoInventario(this.detallemovimientoinventarios);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getDetalleMovimientoInventariosFK_IdNovedadProductoWithConnection(String sFinalQuery,Pagination pagination,Long id_novedad_producto)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleMovimientoInventario.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidNovedadProducto= new ParameterSelectionGeneral();
			parameterSelectionGeneralidNovedadProducto.setParameterSelectionGeneralEqual(ParameterType.LONG,id_novedad_producto,DetalleMovimientoInventarioConstantesFunciones.IDNOVEDADPRODUCTO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidNovedadProducto);

			DetalleMovimientoInventarioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdNovedadProducto","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detallemovimientoinventarios=detallemovimientoinventarioDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleMovimientoInventarioConstantesFunciones.refrescarForeignKeysDescripcionesDetalleMovimientoInventario(this.detallemovimientoinventarios);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getDetalleMovimientoInventariosFK_IdNovedadProducto(String sFinalQuery,Pagination pagination,Long id_novedad_producto)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidNovedadProducto= new ParameterSelectionGeneral();
			parameterSelectionGeneralidNovedadProducto.setParameterSelectionGeneralEqual(ParameterType.LONG,id_novedad_producto,DetalleMovimientoInventarioConstantesFunciones.IDNOVEDADPRODUCTO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidNovedadProducto);

			DetalleMovimientoInventarioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdNovedadProducto","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detallemovimientoinventarios=detallemovimientoinventarioDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleMovimientoInventarioConstantesFunciones.refrescarForeignKeysDescripcionesDetalleMovimientoInventario(this.detallemovimientoinventarios);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getDetalleMovimientoInventariosFK_IdPeriodoWithConnection(String sFinalQuery,Pagination pagination,Long id_periodo)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleMovimientoInventario.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidPeriodo= new ParameterSelectionGeneral();
			parameterSelectionGeneralidPeriodo.setParameterSelectionGeneralEqual(ParameterType.LONG,id_periodo,DetalleMovimientoInventarioConstantesFunciones.IDPERIODO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidPeriodo);

			DetalleMovimientoInventarioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdPeriodo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detallemovimientoinventarios=detallemovimientoinventarioDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleMovimientoInventarioConstantesFunciones.refrescarForeignKeysDescripcionesDetalleMovimientoInventario(this.detallemovimientoinventarios);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getDetalleMovimientoInventariosFK_IdPeriodo(String sFinalQuery,Pagination pagination,Long id_periodo)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidPeriodo= new ParameterSelectionGeneral();
			parameterSelectionGeneralidPeriodo.setParameterSelectionGeneralEqual(ParameterType.LONG,id_periodo,DetalleMovimientoInventarioConstantesFunciones.IDPERIODO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidPeriodo);

			DetalleMovimientoInventarioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdPeriodo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detallemovimientoinventarios=detallemovimientoinventarioDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleMovimientoInventarioConstantesFunciones.refrescarForeignKeysDescripcionesDetalleMovimientoInventario(this.detallemovimientoinventarios);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getDetalleMovimientoInventariosFK_IdProductoWithConnection(String sFinalQuery,Pagination pagination,Long id_producto)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleMovimientoInventario.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidProducto= new ParameterSelectionGeneral();
			parameterSelectionGeneralidProducto.setParameterSelectionGeneralEqual(ParameterType.LONG,id_producto,DetalleMovimientoInventarioConstantesFunciones.IDPRODUCTO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidProducto);

			DetalleMovimientoInventarioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdProducto","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detallemovimientoinventarios=detallemovimientoinventarioDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleMovimientoInventarioConstantesFunciones.refrescarForeignKeysDescripcionesDetalleMovimientoInventario(this.detallemovimientoinventarios);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getDetalleMovimientoInventariosFK_IdProducto(String sFinalQuery,Pagination pagination,Long id_producto)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidProducto= new ParameterSelectionGeneral();
			parameterSelectionGeneralidProducto.setParameterSelectionGeneralEqual(ParameterType.LONG,id_producto,DetalleMovimientoInventarioConstantesFunciones.IDPRODUCTO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidProducto);

			DetalleMovimientoInventarioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdProducto","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detallemovimientoinventarios=detallemovimientoinventarioDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleMovimientoInventarioConstantesFunciones.refrescarForeignKeysDescripcionesDetalleMovimientoInventario(this.detallemovimientoinventarios);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getDetalleMovimientoInventariosFK_IdSucursalWithConnection(String sFinalQuery,Pagination pagination,Long id_sucursal)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleMovimientoInventario.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidSucursal= new ParameterSelectionGeneral();
			parameterSelectionGeneralidSucursal.setParameterSelectionGeneralEqual(ParameterType.LONG,id_sucursal,DetalleMovimientoInventarioConstantesFunciones.IDSUCURSAL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidSucursal);

			DetalleMovimientoInventarioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdSucursal","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detallemovimientoinventarios=detallemovimientoinventarioDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleMovimientoInventarioConstantesFunciones.refrescarForeignKeysDescripcionesDetalleMovimientoInventario(this.detallemovimientoinventarios);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getDetalleMovimientoInventariosFK_IdSucursal(String sFinalQuery,Pagination pagination,Long id_sucursal)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidSucursal= new ParameterSelectionGeneral();
			parameterSelectionGeneralidSucursal.setParameterSelectionGeneralEqual(ParameterType.LONG,id_sucursal,DetalleMovimientoInventarioConstantesFunciones.IDSUCURSAL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidSucursal);

			DetalleMovimientoInventarioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdSucursal","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detallemovimientoinventarios=detallemovimientoinventarioDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleMovimientoInventarioConstantesFunciones.refrescarForeignKeysDescripcionesDetalleMovimientoInventario(this.detallemovimientoinventarios);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getDetalleMovimientoInventariosFK_IdTipoDetalleMovimientoInventarioWithConnection(String sFinalQuery,Pagination pagination,Long id_tipo_detalle_movimiento_inventario)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleMovimientoInventario.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoDetalleMovimientoInventario= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoDetalleMovimientoInventario.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_detalle_movimiento_inventario,DetalleMovimientoInventarioConstantesFunciones.IDTIPODETALLEMOVIMIENTOINVENTARIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoDetalleMovimientoInventario);

			DetalleMovimientoInventarioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoDetalleMovimientoInventario","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detallemovimientoinventarios=detallemovimientoinventarioDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleMovimientoInventarioConstantesFunciones.refrescarForeignKeysDescripcionesDetalleMovimientoInventario(this.detallemovimientoinventarios);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getDetalleMovimientoInventariosFK_IdTipoDetalleMovimientoInventario(String sFinalQuery,Pagination pagination,Long id_tipo_detalle_movimiento_inventario)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoDetalleMovimientoInventario= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoDetalleMovimientoInventario.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_detalle_movimiento_inventario,DetalleMovimientoInventarioConstantesFunciones.IDTIPODETALLEMOVIMIENTOINVENTARIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoDetalleMovimientoInventario);

			DetalleMovimientoInventarioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoDetalleMovimientoInventario","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detallemovimientoinventarios=detallemovimientoinventarioDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleMovimientoInventarioConstantesFunciones.refrescarForeignKeysDescripcionesDetalleMovimientoInventario(this.detallemovimientoinventarios);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getDetalleMovimientoInventariosFK_IdUnidadWithConnection(String sFinalQuery,Pagination pagination,Long id_unidad)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleMovimientoInventario.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidUnidad= new ParameterSelectionGeneral();
			parameterSelectionGeneralidUnidad.setParameterSelectionGeneralEqual(ParameterType.LONG,id_unidad,DetalleMovimientoInventarioConstantesFunciones.IDUNIDAD,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidUnidad);

			DetalleMovimientoInventarioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdUnidad","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detallemovimientoinventarios=detallemovimientoinventarioDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleMovimientoInventarioConstantesFunciones.refrescarForeignKeysDescripcionesDetalleMovimientoInventario(this.detallemovimientoinventarios);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getDetalleMovimientoInventariosFK_IdUnidad(String sFinalQuery,Pagination pagination,Long id_unidad)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidUnidad= new ParameterSelectionGeneral();
			parameterSelectionGeneralidUnidad.setParameterSelectionGeneralEqual(ParameterType.LONG,id_unidad,DetalleMovimientoInventarioConstantesFunciones.IDUNIDAD,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidUnidad);

			DetalleMovimientoInventarioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdUnidad","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detallemovimientoinventarios=detallemovimientoinventarioDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleMovimientoInventarioConstantesFunciones.refrescarForeignKeysDescripcionesDetalleMovimientoInventario(this.detallemovimientoinventarios);
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
			if(DetalleMovimientoInventarioConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,DetalleMovimientoInventarioDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,DetalleMovimientoInventario detallemovimientoinventario,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(DetalleMovimientoInventarioConstantesFunciones.ISCONAUDITORIA) {
				if(detallemovimientoinventario.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,DetalleMovimientoInventarioDataAccess.TABLENAME, detallemovimientoinventario.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(DetalleMovimientoInventarioConstantesFunciones.ISCONAUDITORIADETALLE) {
						////DetalleMovimientoInventarioLogic.registrarAuditoriaDetallesDetalleMovimientoInventario(connexion,detallemovimientoinventario,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(detallemovimientoinventario.getIsDeleted()) {
					/*if(!detallemovimientoinventario.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,DetalleMovimientoInventarioDataAccess.TABLENAME, detallemovimientoinventario.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////DetalleMovimientoInventarioLogic.registrarAuditoriaDetallesDetalleMovimientoInventario(connexion,detallemovimientoinventario,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,DetalleMovimientoInventarioDataAccess.TABLENAME, detallemovimientoinventario.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(detallemovimientoinventario.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,DetalleMovimientoInventarioDataAccess.TABLENAME, detallemovimientoinventario.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(DetalleMovimientoInventarioConstantesFunciones.ISCONAUDITORIADETALLE) {
						////DetalleMovimientoInventarioLogic.registrarAuditoriaDetallesDetalleMovimientoInventario(connexion,detallemovimientoinventario,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesDetalleMovimientoInventario(Connexion connexion,DetalleMovimientoInventario detallemovimientoinventario)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(detallemovimientoinventario.getIsNew()||!detallemovimientoinventario.getid_movimiento_inventario().equals(detallemovimientoinventario.getDetalleMovimientoInventarioOriginal().getid_movimiento_inventario()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detallemovimientoinventario.getDetalleMovimientoInventarioOriginal().getid_movimiento_inventario()!=null)
				{
					strValorActual=detallemovimientoinventario.getDetalleMovimientoInventarioOriginal().getid_movimiento_inventario().toString();
				}
				if(detallemovimientoinventario.getid_movimiento_inventario()!=null)
				{
					strValorNuevo=detallemovimientoinventario.getid_movimiento_inventario().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleMovimientoInventarioConstantesFunciones.IDMOVIMIENTOINVENTARIO,strValorActual,strValorNuevo);
			}	
			
			if(detallemovimientoinventario.getIsNew()||!detallemovimientoinventario.getid_empresa().equals(detallemovimientoinventario.getDetalleMovimientoInventarioOriginal().getid_empresa()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detallemovimientoinventario.getDetalleMovimientoInventarioOriginal().getid_empresa()!=null)
				{
					strValorActual=detallemovimientoinventario.getDetalleMovimientoInventarioOriginal().getid_empresa().toString();
				}
				if(detallemovimientoinventario.getid_empresa()!=null)
				{
					strValorNuevo=detallemovimientoinventario.getid_empresa().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleMovimientoInventarioConstantesFunciones.IDEMPRESA,strValorActual,strValorNuevo);
			}	
			
			if(detallemovimientoinventario.getIsNew()||!detallemovimientoinventario.getid_sucursal().equals(detallemovimientoinventario.getDetalleMovimientoInventarioOriginal().getid_sucursal()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detallemovimientoinventario.getDetalleMovimientoInventarioOriginal().getid_sucursal()!=null)
				{
					strValorActual=detallemovimientoinventario.getDetalleMovimientoInventarioOriginal().getid_sucursal().toString();
				}
				if(detallemovimientoinventario.getid_sucursal()!=null)
				{
					strValorNuevo=detallemovimientoinventario.getid_sucursal().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleMovimientoInventarioConstantesFunciones.IDSUCURSAL,strValorActual,strValorNuevo);
			}	
			
			if(detallemovimientoinventario.getIsNew()||!detallemovimientoinventario.getid_ejercicio().equals(detallemovimientoinventario.getDetalleMovimientoInventarioOriginal().getid_ejercicio()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detallemovimientoinventario.getDetalleMovimientoInventarioOriginal().getid_ejercicio()!=null)
				{
					strValorActual=detallemovimientoinventario.getDetalleMovimientoInventarioOriginal().getid_ejercicio().toString();
				}
				if(detallemovimientoinventario.getid_ejercicio()!=null)
				{
					strValorNuevo=detallemovimientoinventario.getid_ejercicio().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleMovimientoInventarioConstantesFunciones.IDEJERCICIO,strValorActual,strValorNuevo);
			}	
			
			if(detallemovimientoinventario.getIsNew()||!detallemovimientoinventario.getid_periodo().equals(detallemovimientoinventario.getDetalleMovimientoInventarioOriginal().getid_periodo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detallemovimientoinventario.getDetalleMovimientoInventarioOriginal().getid_periodo()!=null)
				{
					strValorActual=detallemovimientoinventario.getDetalleMovimientoInventarioOriginal().getid_periodo().toString();
				}
				if(detallemovimientoinventario.getid_periodo()!=null)
				{
					strValorNuevo=detallemovimientoinventario.getid_periodo().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleMovimientoInventarioConstantesFunciones.IDPERIODO,strValorActual,strValorNuevo);
			}	
			
			if(detallemovimientoinventario.getIsNew()||!detallemovimientoinventario.getid_anio().equals(detallemovimientoinventario.getDetalleMovimientoInventarioOriginal().getid_anio()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detallemovimientoinventario.getDetalleMovimientoInventarioOriginal().getid_anio()!=null)
				{
					strValorActual=detallemovimientoinventario.getDetalleMovimientoInventarioOriginal().getid_anio().toString();
				}
				if(detallemovimientoinventario.getid_anio()!=null)
				{
					strValorNuevo=detallemovimientoinventario.getid_anio().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleMovimientoInventarioConstantesFunciones.IDANIO,strValorActual,strValorNuevo);
			}	
			
			if(detallemovimientoinventario.getIsNew()||!detallemovimientoinventario.getid_mes().equals(detallemovimientoinventario.getDetalleMovimientoInventarioOriginal().getid_mes()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detallemovimientoinventario.getDetalleMovimientoInventarioOriginal().getid_mes()!=null)
				{
					strValorActual=detallemovimientoinventario.getDetalleMovimientoInventarioOriginal().getid_mes().toString();
				}
				if(detallemovimientoinventario.getid_mes()!=null)
				{
					strValorNuevo=detallemovimientoinventario.getid_mes().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleMovimientoInventarioConstantesFunciones.IDMES,strValorActual,strValorNuevo);
			}	
			
			if(detallemovimientoinventario.getIsNew()||!detallemovimientoinventario.getid_estado_detalle_movimiento_inventario().equals(detallemovimientoinventario.getDetalleMovimientoInventarioOriginal().getid_estado_detalle_movimiento_inventario()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detallemovimientoinventario.getDetalleMovimientoInventarioOriginal().getid_estado_detalle_movimiento_inventario()!=null)
				{
					strValorActual=detallemovimientoinventario.getDetalleMovimientoInventarioOriginal().getid_estado_detalle_movimiento_inventario().toString();
				}
				if(detallemovimientoinventario.getid_estado_detalle_movimiento_inventario()!=null)
				{
					strValorNuevo=detallemovimientoinventario.getid_estado_detalle_movimiento_inventario().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleMovimientoInventarioConstantesFunciones.IDESTADODETALLEMOVIMIENTOINVENTARIO,strValorActual,strValorNuevo);
			}	
			
			if(detallemovimientoinventario.getIsNew()||!detallemovimientoinventario.getid_bodega().equals(detallemovimientoinventario.getDetalleMovimientoInventarioOriginal().getid_bodega()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detallemovimientoinventario.getDetalleMovimientoInventarioOriginal().getid_bodega()!=null)
				{
					strValorActual=detallemovimientoinventario.getDetalleMovimientoInventarioOriginal().getid_bodega().toString();
				}
				if(detallemovimientoinventario.getid_bodega()!=null)
				{
					strValorNuevo=detallemovimientoinventario.getid_bodega().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleMovimientoInventarioConstantesFunciones.IDBODEGA,strValorActual,strValorNuevo);
			}	
			
			if(detallemovimientoinventario.getIsNew()||!detallemovimientoinventario.getid_producto().equals(detallemovimientoinventario.getDetalleMovimientoInventarioOriginal().getid_producto()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detallemovimientoinventario.getDetalleMovimientoInventarioOriginal().getid_producto()!=null)
				{
					strValorActual=detallemovimientoinventario.getDetalleMovimientoInventarioOriginal().getid_producto().toString();
				}
				if(detallemovimientoinventario.getid_producto()!=null)
				{
					strValorNuevo=detallemovimientoinventario.getid_producto().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleMovimientoInventarioConstantesFunciones.IDPRODUCTO,strValorActual,strValorNuevo);
			}	
			
			if(detallemovimientoinventario.getIsNew()||!detallemovimientoinventario.getid_unidad().equals(detallemovimientoinventario.getDetalleMovimientoInventarioOriginal().getid_unidad()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detallemovimientoinventario.getDetalleMovimientoInventarioOriginal().getid_unidad()!=null)
				{
					strValorActual=detallemovimientoinventario.getDetalleMovimientoInventarioOriginal().getid_unidad().toString();
				}
				if(detallemovimientoinventario.getid_unidad()!=null)
				{
					strValorNuevo=detallemovimientoinventario.getid_unidad().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleMovimientoInventarioConstantesFunciones.IDUNIDAD,strValorActual,strValorNuevo);
			}	
			
			if(detallemovimientoinventario.getIsNew()||!detallemovimientoinventario.getdescripcion().equals(detallemovimientoinventario.getDetalleMovimientoInventarioOriginal().getdescripcion()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detallemovimientoinventario.getDetalleMovimientoInventarioOriginal().getdescripcion()!=null)
				{
					strValorActual=detallemovimientoinventario.getDetalleMovimientoInventarioOriginal().getdescripcion();
				}
				if(detallemovimientoinventario.getdescripcion()!=null)
				{
					strValorNuevo=detallemovimientoinventario.getdescripcion() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleMovimientoInventarioConstantesFunciones.DESCRIPCION,strValorActual,strValorNuevo);
			}	
			
			if(detallemovimientoinventario.getIsNew()||!detallemovimientoinventario.getcantidad().equals(detallemovimientoinventario.getDetalleMovimientoInventarioOriginal().getcantidad()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detallemovimientoinventario.getDetalleMovimientoInventarioOriginal().getcantidad()!=null)
				{
					strValorActual=detallemovimientoinventario.getDetalleMovimientoInventarioOriginal().getcantidad().toString();
				}
				if(detallemovimientoinventario.getcantidad()!=null)
				{
					strValorNuevo=detallemovimientoinventario.getcantidad().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleMovimientoInventarioConstantesFunciones.CANTIDAD,strValorActual,strValorNuevo);
			}	
			
			if(detallemovimientoinventario.getIsNew()||!detallemovimientoinventario.getdescuento().equals(detallemovimientoinventario.getDetalleMovimientoInventarioOriginal().getdescuento()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detallemovimientoinventario.getDetalleMovimientoInventarioOriginal().getdescuento()!=null)
				{
					strValorActual=detallemovimientoinventario.getDetalleMovimientoInventarioOriginal().getdescuento().toString();
				}
				if(detallemovimientoinventario.getdescuento()!=null)
				{
					strValorNuevo=detallemovimientoinventario.getdescuento().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleMovimientoInventarioConstantesFunciones.DESCUENTO,strValorActual,strValorNuevo);
			}	
			
			if(detallemovimientoinventario.getIsNew()||!detallemovimientoinventario.getcosto_unitario().equals(detallemovimientoinventario.getDetalleMovimientoInventarioOriginal().getcosto_unitario()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detallemovimientoinventario.getDetalleMovimientoInventarioOriginal().getcosto_unitario()!=null)
				{
					strValorActual=detallemovimientoinventario.getDetalleMovimientoInventarioOriginal().getcosto_unitario().toString();
				}
				if(detallemovimientoinventario.getcosto_unitario()!=null)
				{
					strValorNuevo=detallemovimientoinventario.getcosto_unitario().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleMovimientoInventarioConstantesFunciones.COSTOUNITARIO,strValorActual,strValorNuevo);
			}	
			
			if(detallemovimientoinventario.getIsNew()||!detallemovimientoinventario.getcosto_total().equals(detallemovimientoinventario.getDetalleMovimientoInventarioOriginal().getcosto_total()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detallemovimientoinventario.getDetalleMovimientoInventarioOriginal().getcosto_total()!=null)
				{
					strValorActual=detallemovimientoinventario.getDetalleMovimientoInventarioOriginal().getcosto_total().toString();
				}
				if(detallemovimientoinventario.getcosto_total()!=null)
				{
					strValorNuevo=detallemovimientoinventario.getcosto_total().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleMovimientoInventarioConstantesFunciones.COSTOTOTAL,strValorActual,strValorNuevo);
			}	
			
			if(detallemovimientoinventario.getIsNew()||!detallemovimientoinventario.getdisponible().equals(detallemovimientoinventario.getDetalleMovimientoInventarioOriginal().getdisponible()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detallemovimientoinventario.getDetalleMovimientoInventarioOriginal().getdisponible()!=null)
				{
					strValorActual=detallemovimientoinventario.getDetalleMovimientoInventarioOriginal().getdisponible().toString();
				}
				if(detallemovimientoinventario.getdisponible()!=null)
				{
					strValorNuevo=detallemovimientoinventario.getdisponible().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleMovimientoInventarioConstantesFunciones.DISPONIBLE,strValorActual,strValorNuevo);
			}	
			
			if(detallemovimientoinventario.getIsNew()||!detallemovimientoinventario.getiva().equals(detallemovimientoinventario.getDetalleMovimientoInventarioOriginal().getiva()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detallemovimientoinventario.getDetalleMovimientoInventarioOriginal().getiva()!=null)
				{
					strValorActual=detallemovimientoinventario.getDetalleMovimientoInventarioOriginal().getiva().toString();
				}
				if(detallemovimientoinventario.getiva()!=null)
				{
					strValorNuevo=detallemovimientoinventario.getiva().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleMovimientoInventarioConstantesFunciones.IVA,strValorActual,strValorNuevo);
			}	
			
			if(detallemovimientoinventario.getIsNew()||!detallemovimientoinventario.getiva_valor().equals(detallemovimientoinventario.getDetalleMovimientoInventarioOriginal().getiva_valor()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detallemovimientoinventario.getDetalleMovimientoInventarioOriginal().getiva_valor()!=null)
				{
					strValorActual=detallemovimientoinventario.getDetalleMovimientoInventarioOriginal().getiva_valor().toString();
				}
				if(detallemovimientoinventario.getiva_valor()!=null)
				{
					strValorNuevo=detallemovimientoinventario.getiva_valor().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleMovimientoInventarioConstantesFunciones.IVAVALOR,strValorActual,strValorNuevo);
			}	
			
			if(detallemovimientoinventario.getIsNew()||!detallemovimientoinventario.getcosto_iva().equals(detallemovimientoinventario.getDetalleMovimientoInventarioOriginal().getcosto_iva()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detallemovimientoinventario.getDetalleMovimientoInventarioOriginal().getcosto_iva()!=null)
				{
					strValorActual=detallemovimientoinventario.getDetalleMovimientoInventarioOriginal().getcosto_iva().toString();
				}
				if(detallemovimientoinventario.getcosto_iva()!=null)
				{
					strValorNuevo=detallemovimientoinventario.getcosto_iva().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleMovimientoInventarioConstantesFunciones.COSTOIVA,strValorActual,strValorNuevo);
			}	
			
			if(detallemovimientoinventario.getIsNew()||!detallemovimientoinventario.getice().equals(detallemovimientoinventario.getDetalleMovimientoInventarioOriginal().getice()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detallemovimientoinventario.getDetalleMovimientoInventarioOriginal().getice()!=null)
				{
					strValorActual=detallemovimientoinventario.getDetalleMovimientoInventarioOriginal().getice().toString();
				}
				if(detallemovimientoinventario.getice()!=null)
				{
					strValorNuevo=detallemovimientoinventario.getice().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleMovimientoInventarioConstantesFunciones.ICE,strValorActual,strValorNuevo);
			}	
			
			if(detallemovimientoinventario.getIsNew()||!detallemovimientoinventario.getice_valor().equals(detallemovimientoinventario.getDetalleMovimientoInventarioOriginal().getice_valor()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detallemovimientoinventario.getDetalleMovimientoInventarioOriginal().getice_valor()!=null)
				{
					strValorActual=detallemovimientoinventario.getDetalleMovimientoInventarioOriginal().getice_valor().toString();
				}
				if(detallemovimientoinventario.getice_valor()!=null)
				{
					strValorNuevo=detallemovimientoinventario.getice_valor().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleMovimientoInventarioConstantesFunciones.ICEVALOR,strValorActual,strValorNuevo);
			}	
			
			if(detallemovimientoinventario.getIsNew()||!detallemovimientoinventario.getdescuento1().equals(detallemovimientoinventario.getDetalleMovimientoInventarioOriginal().getdescuento1()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detallemovimientoinventario.getDetalleMovimientoInventarioOriginal().getdescuento1()!=null)
				{
					strValorActual=detallemovimientoinventario.getDetalleMovimientoInventarioOriginal().getdescuento1().toString();
				}
				if(detallemovimientoinventario.getdescuento1()!=null)
				{
					strValorNuevo=detallemovimientoinventario.getdescuento1().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleMovimientoInventarioConstantesFunciones.DESCUENTO1,strValorActual,strValorNuevo);
			}	
			
			if(detallemovimientoinventario.getIsNew()||!detallemovimientoinventario.getdescuento2().equals(detallemovimientoinventario.getDetalleMovimientoInventarioOriginal().getdescuento2()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detallemovimientoinventario.getDetalleMovimientoInventarioOriginal().getdescuento2()!=null)
				{
					strValorActual=detallemovimientoinventario.getDetalleMovimientoInventarioOriginal().getdescuento2().toString();
				}
				if(detallemovimientoinventario.getdescuento2()!=null)
				{
					strValorNuevo=detallemovimientoinventario.getdescuento2().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleMovimientoInventarioConstantesFunciones.DESCUENTO2,strValorActual,strValorNuevo);
			}	
			
			if(detallemovimientoinventario.getIsNew()||!detallemovimientoinventario.getserie().equals(detallemovimientoinventario.getDetalleMovimientoInventarioOriginal().getserie()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detallemovimientoinventario.getDetalleMovimientoInventarioOriginal().getserie()!=null)
				{
					strValorActual=detallemovimientoinventario.getDetalleMovimientoInventarioOriginal().getserie();
				}
				if(detallemovimientoinventario.getserie()!=null)
				{
					strValorNuevo=detallemovimientoinventario.getserie() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleMovimientoInventarioConstantesFunciones.SERIE,strValorActual,strValorNuevo);
			}	
			
			if(detallemovimientoinventario.getIsNew()||!detallemovimientoinventario.getlote().equals(detallemovimientoinventario.getDetalleMovimientoInventarioOriginal().getlote()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detallemovimientoinventario.getDetalleMovimientoInventarioOriginal().getlote()!=null)
				{
					strValorActual=detallemovimientoinventario.getDetalleMovimientoInventarioOriginal().getlote();
				}
				if(detallemovimientoinventario.getlote()!=null)
				{
					strValorNuevo=detallemovimientoinventario.getlote() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleMovimientoInventarioConstantesFunciones.LOTE,strValorActual,strValorNuevo);
			}	
			
			if(detallemovimientoinventario.getIsNew()||!detallemovimientoinventario.getfecha_elaboracion_lote().equals(detallemovimientoinventario.getDetalleMovimientoInventarioOriginal().getfecha_elaboracion_lote()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detallemovimientoinventario.getDetalleMovimientoInventarioOriginal().getfecha_elaboracion_lote()!=null)
				{
					strValorActual=detallemovimientoinventario.getDetalleMovimientoInventarioOriginal().getfecha_elaboracion_lote().toString();
				}
				if(detallemovimientoinventario.getfecha_elaboracion_lote()!=null)
				{
					strValorNuevo=detallemovimientoinventario.getfecha_elaboracion_lote().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleMovimientoInventarioConstantesFunciones.FECHAELABORACIONLOTE,strValorActual,strValorNuevo);
			}	
			
			if(detallemovimientoinventario.getIsNew()||!detallemovimientoinventario.getfecha_caducidad_lote().equals(detallemovimientoinventario.getDetalleMovimientoInventarioOriginal().getfecha_caducidad_lote()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detallemovimientoinventario.getDetalleMovimientoInventarioOriginal().getfecha_caducidad_lote()!=null)
				{
					strValorActual=detallemovimientoinventario.getDetalleMovimientoInventarioOriginal().getfecha_caducidad_lote().toString();
				}
				if(detallemovimientoinventario.getfecha_caducidad_lote()!=null)
				{
					strValorNuevo=detallemovimientoinventario.getfecha_caducidad_lote().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleMovimientoInventarioConstantesFunciones.FECHACADUCIDADLOTE,strValorActual,strValorNuevo);
			}	
			
			if(detallemovimientoinventario.getIsNew()||!detallemovimientoinventario.getid_novedad_producto().equals(detallemovimientoinventario.getDetalleMovimientoInventarioOriginal().getid_novedad_producto()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detallemovimientoinventario.getDetalleMovimientoInventarioOriginal().getid_novedad_producto()!=null)
				{
					strValorActual=detallemovimientoinventario.getDetalleMovimientoInventarioOriginal().getid_novedad_producto().toString();
				}
				if(detallemovimientoinventario.getid_novedad_producto()!=null)
				{
					strValorNuevo=detallemovimientoinventario.getid_novedad_producto().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleMovimientoInventarioConstantesFunciones.IDNOVEDADPRODUCTO,strValorActual,strValorNuevo);
			}	
			
			if(detallemovimientoinventario.getIsNew()||!detallemovimientoinventario.getid_centro_costo().equals(detallemovimientoinventario.getDetalleMovimientoInventarioOriginal().getid_centro_costo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detallemovimientoinventario.getDetalleMovimientoInventarioOriginal().getid_centro_costo()!=null)
				{
					strValorActual=detallemovimientoinventario.getDetalleMovimientoInventarioOriginal().getid_centro_costo().toString();
				}
				if(detallemovimientoinventario.getid_centro_costo()!=null)
				{
					strValorNuevo=detallemovimientoinventario.getid_centro_costo().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleMovimientoInventarioConstantesFunciones.IDCENTROCOSTO,strValorActual,strValorNuevo);
			}	
			
			if(detallemovimientoinventario.getIsNew()||!detallemovimientoinventario.getid_cuenta_contable_costo().equals(detallemovimientoinventario.getDetalleMovimientoInventarioOriginal().getid_cuenta_contable_costo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detallemovimientoinventario.getDetalleMovimientoInventarioOriginal().getid_cuenta_contable_costo()!=null)
				{
					strValorActual=detallemovimientoinventario.getDetalleMovimientoInventarioOriginal().getid_cuenta_contable_costo().toString();
				}
				if(detallemovimientoinventario.getid_cuenta_contable_costo()!=null)
				{
					strValorNuevo=detallemovimientoinventario.getid_cuenta_contable_costo().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleMovimientoInventarioConstantesFunciones.IDCUENTACONTABLECOSTO,strValorActual,strValorNuevo);
			}	
			
			if(detallemovimientoinventario.getIsNew()||!detallemovimientoinventario.getid_tipo_detalle_movimiento_inventario().equals(detallemovimientoinventario.getDetalleMovimientoInventarioOriginal().getid_tipo_detalle_movimiento_inventario()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detallemovimientoinventario.getDetalleMovimientoInventarioOriginal().getid_tipo_detalle_movimiento_inventario()!=null)
				{
					strValorActual=detallemovimientoinventario.getDetalleMovimientoInventarioOriginal().getid_tipo_detalle_movimiento_inventario().toString();
				}
				if(detallemovimientoinventario.getid_tipo_detalle_movimiento_inventario()!=null)
				{
					strValorNuevo=detallemovimientoinventario.getid_tipo_detalle_movimiento_inventario().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleMovimientoInventarioConstantesFunciones.IDTIPODETALLEMOVIMIENTOINVENTARIO,strValorActual,strValorNuevo);
			}	
			
			if(detallemovimientoinventario.getIsNew()||!detallemovimientoinventario.getnumero_comprobante().equals(detallemovimientoinventario.getDetalleMovimientoInventarioOriginal().getnumero_comprobante()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detallemovimientoinventario.getDetalleMovimientoInventarioOriginal().getnumero_comprobante()!=null)
				{
					strValorActual=detallemovimientoinventario.getDetalleMovimientoInventarioOriginal().getnumero_comprobante();
				}
				if(detallemovimientoinventario.getnumero_comprobante()!=null)
				{
					strValorNuevo=detallemovimientoinventario.getnumero_comprobante() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleMovimientoInventarioConstantesFunciones.NUMEROCOMPROBANTE,strValorActual,strValorNuevo);
			}	
			
			if(detallemovimientoinventario.getIsNew()||!detallemovimientoinventario.getlote_cliente().equals(detallemovimientoinventario.getDetalleMovimientoInventarioOriginal().getlote_cliente()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detallemovimientoinventario.getDetalleMovimientoInventarioOriginal().getlote_cliente()!=null)
				{
					strValorActual=detallemovimientoinventario.getDetalleMovimientoInventarioOriginal().getlote_cliente();
				}
				if(detallemovimientoinventario.getlote_cliente()!=null)
				{
					strValorNuevo=detallemovimientoinventario.getlote_cliente() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleMovimientoInventarioConstantesFunciones.LOTECLIENTE,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void saveDetalleMovimientoInventarioRelacionesWithConnection(DetalleMovimientoInventario detallemovimientoinventario,List<NovedadSeguimiento> novedadseguimientos) throws Exception {

		if(!detallemovimientoinventario.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveDetalleMovimientoInventarioRelacionesBase(detallemovimientoinventario,novedadseguimientos,true);
		}
	}

	public void saveDetalleMovimientoInventarioRelaciones(DetalleMovimientoInventario detallemovimientoinventario,List<NovedadSeguimiento> novedadseguimientos)throws Exception {

		if(!detallemovimientoinventario.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveDetalleMovimientoInventarioRelacionesBase(detallemovimientoinventario,novedadseguimientos,false);
		}
	}

	public void saveDetalleMovimientoInventarioRelacionesBase(DetalleMovimientoInventario detallemovimientoinventario,List<NovedadSeguimiento> novedadseguimientos,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("DetalleMovimientoInventario-saveRelacionesWithConnection");}
	
			detallemovimientoinventario.setNovedadSeguimientos(novedadseguimientos);

			this.setDetalleMovimientoInventario(detallemovimientoinventario);

			if(DetalleMovimientoInventarioLogicAdditional.validarSaveRelaciones(detallemovimientoinventario,this)) {

				DetalleMovimientoInventarioLogicAdditional.updateRelacionesToSave(detallemovimientoinventario,this);

				if((detallemovimientoinventario.getIsNew()||detallemovimientoinventario.getIsChanged())&&!detallemovimientoinventario.getIsDeleted()) {
					this.saveDetalleMovimientoInventario();
					this.saveDetalleMovimientoInventarioRelacionesDetalles(novedadseguimientos);

				} else if(detallemovimientoinventario.getIsDeleted()) {
					this.saveDetalleMovimientoInventarioRelacionesDetalles(novedadseguimientos);
					this.saveDetalleMovimientoInventario();
				}

				DetalleMovimientoInventarioLogicAdditional.updateRelacionesToSaveAfter(detallemovimientoinventario,this);

			} else {
				throw new Exception("LOS DATOS SON INVALIDOS");
			}

			if(conConexion) {connexion.commit();}

		} catch(Exception e) {
			
			NovedadSeguimientoConstantesFunciones.InicializarGeneralEntityAuxiliaresNovedadSeguimientos(novedadseguimientos,true,true);

			if(conConexion){connexion.rollback();}
			Funciones.manageException(logger,e);
			throw e;

		} finally {
			if(conConexion){this.closeNewConnexionToDeep();}
		}
	}
	
	
	private void saveDetalleMovimientoInventarioRelacionesDetalles(List<NovedadSeguimiento> novedadseguimientos)throws Exception {
		try {
	

			Long idDetalleMovimientoInventarioActual=this.getDetalleMovimientoInventario().getId();

			NovedadSeguimientoLogic novedadseguimientoLogic_Desde_DetalleMovimientoInventario=new NovedadSeguimientoLogic();
			novedadseguimientoLogic_Desde_DetalleMovimientoInventario.setNovedadSeguimientos(novedadseguimientos);

			novedadseguimientoLogic_Desde_DetalleMovimientoInventario.setConnexion(this.getConnexion());
			novedadseguimientoLogic_Desde_DetalleMovimientoInventario.setDatosCliente(this.datosCliente);

			for(NovedadSeguimiento novedadseguimiento_Desde_DetalleMovimientoInventario:novedadseguimientoLogic_Desde_DetalleMovimientoInventario.getNovedadSeguimientos()) {
				novedadseguimiento_Desde_DetalleMovimientoInventario.setid_detalle_movimiento_inventario(idDetalleMovimientoInventarioActual);
			}

			novedadseguimientoLogic_Desde_DetalleMovimientoInventario.saveNovedadSeguimientos();

		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfDetalleMovimientoInventario(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=DetalleMovimientoInventarioConstantesFunciones.getClassesForeignKeysOfDetalleMovimientoInventario(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfDetalleMovimientoInventario(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=DetalleMovimientoInventarioConstantesFunciones.getClassesRelationshipsOfDetalleMovimientoInventario(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}
