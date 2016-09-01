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
import com.bydan.erp.inventario.util.TipoDetalleMovimientoInventarioConstantesFunciones;
import com.bydan.erp.inventario.util.TipoDetalleMovimientoInventarioParameterReturnGeneral;
//import com.bydan.erp.inventario.util.TipoDetalleMovimientoInventarioParameterGeneral;
import com.bydan.erp.inventario.business.entity.TipoDetalleMovimientoInventario;
//import com.bydan.erp.inventario.business.logic.TipoDetalleMovimientoInventarioLogicAdditional;
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
public class TipoDetalleMovimientoInventarioLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(TipoDetalleMovimientoInventarioLogic.class);
	
	protected TipoDetalleMovimientoInventarioDataAccess tipodetallemovimientoinventarioDataAccess; 	
	protected TipoDetalleMovimientoInventario tipodetallemovimientoinventario;
	protected List<TipoDetalleMovimientoInventario> tipodetallemovimientoinventarios;
	protected Object tipodetallemovimientoinventarioObject;	
	protected List<Object> tipodetallemovimientoinventariosObject;
	
	public static ClassValidator<TipoDetalleMovimientoInventario> tipodetallemovimientoinventarioValidator = new ClassValidator<TipoDetalleMovimientoInventario>(TipoDetalleMovimientoInventario.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
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
	
	
	
	
	public  TipoDetalleMovimientoInventarioLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.tipodetallemovimientoinventarioDataAccess = new TipoDetalleMovimientoInventarioDataAccess();
			
			this.tipodetallemovimientoinventarios= new ArrayList<TipoDetalleMovimientoInventario>();
			this.tipodetallemovimientoinventario= new TipoDetalleMovimientoInventario();
			
			this.tipodetallemovimientoinventarioObject=new Object();
			this.tipodetallemovimientoinventariosObject=new ArrayList<Object>();
				
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
			
			this.tipodetallemovimientoinventarioDataAccess.setConnexionType(this.connexionType);
			this.tipodetallemovimientoinventarioDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  TipoDetalleMovimientoInventarioLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.tipodetallemovimientoinventarioDataAccess = new TipoDetalleMovimientoInventarioDataAccess();
			this.tipodetallemovimientoinventarios= new ArrayList<TipoDetalleMovimientoInventario>();
			this.tipodetallemovimientoinventario= new TipoDetalleMovimientoInventario();
			this.tipodetallemovimientoinventarioObject=new Object();
			this.tipodetallemovimientoinventariosObject=new ArrayList<Object>();
			
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
			
			this.tipodetallemovimientoinventarioDataAccess.setConnexionType(this.connexionType);
			this.tipodetallemovimientoinventarioDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public TipoDetalleMovimientoInventario getTipoDetalleMovimientoInventario() throws Exception {	
		//TipoDetalleMovimientoInventarioLogicAdditional.checkTipoDetalleMovimientoInventarioToGet(tipodetallemovimientoinventario,this.datosCliente,this.arrDatoGeneral);
		//TipoDetalleMovimientoInventarioLogicAdditional.updateTipoDetalleMovimientoInventarioToGet(tipodetallemovimientoinventario,this.arrDatoGeneral);
		
		return tipodetallemovimientoinventario;
	}
		
	public void setTipoDetalleMovimientoInventario(TipoDetalleMovimientoInventario newTipoDetalleMovimientoInventario) {
		this.tipodetallemovimientoinventario = newTipoDetalleMovimientoInventario;
	}
	
	public TipoDetalleMovimientoInventarioDataAccess getTipoDetalleMovimientoInventarioDataAccess() {
		return tipodetallemovimientoinventarioDataAccess;
	}
	
	public void setTipoDetalleMovimientoInventarioDataAccess(TipoDetalleMovimientoInventarioDataAccess newtipodetallemovimientoinventarioDataAccess) {
		this.tipodetallemovimientoinventarioDataAccess = newtipodetallemovimientoinventarioDataAccess;
	}
	
	public List<TipoDetalleMovimientoInventario> getTipoDetalleMovimientoInventarios() throws Exception {		
		this.quitarTipoDetalleMovimientoInventariosNulos();
		
		//TipoDetalleMovimientoInventarioLogicAdditional.checkTipoDetalleMovimientoInventarioToGets(tipodetallemovimientoinventarios,this.datosCliente,this.arrDatoGeneral);
		
		for (TipoDetalleMovimientoInventario tipodetallemovimientoinventarioLocal: tipodetallemovimientoinventarios ) {
			//TipoDetalleMovimientoInventarioLogicAdditional.updateTipoDetalleMovimientoInventarioToGet(tipodetallemovimientoinventarioLocal,this.arrDatoGeneral);
		}
		
		return tipodetallemovimientoinventarios;
	}
	
	public void setTipoDetalleMovimientoInventarios(List<TipoDetalleMovimientoInventario> newTipoDetalleMovimientoInventarios) {
		this.tipodetallemovimientoinventarios = newTipoDetalleMovimientoInventarios;
	}
	
	public Object getTipoDetalleMovimientoInventarioObject() {	
		this.tipodetallemovimientoinventarioObject=this.tipodetallemovimientoinventarioDataAccess.getEntityObject();
		return this.tipodetallemovimientoinventarioObject;
	}
		
	public void setTipoDetalleMovimientoInventarioObject(Object newTipoDetalleMovimientoInventarioObject) {
		this.tipodetallemovimientoinventarioObject = newTipoDetalleMovimientoInventarioObject;
	}
	
	public List<Object> getTipoDetalleMovimientoInventariosObject() {		
		this.tipodetallemovimientoinventariosObject=this.tipodetallemovimientoinventarioDataAccess.getEntitiesObject();
		return this.tipodetallemovimientoinventariosObject;
	}
		
	public void setTipoDetalleMovimientoInventariosObject(List<Object> newTipoDetalleMovimientoInventariosObject) {
		this.tipodetallemovimientoinventariosObject = newTipoDetalleMovimientoInventariosObject;
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
		
		if(this.tipodetallemovimientoinventarioDataAccess!=null) {
			this.tipodetallemovimientoinventarioDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoDetalleMovimientoInventario.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			tipodetallemovimientoinventarioDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			tipodetallemovimientoinventarioDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		tipodetallemovimientoinventario = new  TipoDetalleMovimientoInventario();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoDetalleMovimientoInventario.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			tipodetallemovimientoinventario=tipodetallemovimientoinventarioDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tipodetallemovimientoinventario,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoDetalleMovimientoInventarioConstantesFunciones.refrescarForeignKeysDescripcionesTipoDetalleMovimientoInventario(this.tipodetallemovimientoinventario);
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
		tipodetallemovimientoinventario = new  TipoDetalleMovimientoInventario();
		  		  
        try {
			
			tipodetallemovimientoinventario=tipodetallemovimientoinventarioDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tipodetallemovimientoinventario,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoDetalleMovimientoInventarioConstantesFunciones.refrescarForeignKeysDescripcionesTipoDetalleMovimientoInventario(this.tipodetallemovimientoinventario);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		tipodetallemovimientoinventario = new  TipoDetalleMovimientoInventario();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoDetalleMovimientoInventario.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			tipodetallemovimientoinventario=tipodetallemovimientoinventarioDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tipodetallemovimientoinventario,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoDetalleMovimientoInventarioConstantesFunciones.refrescarForeignKeysDescripcionesTipoDetalleMovimientoInventario(this.tipodetallemovimientoinventario);
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
		tipodetallemovimientoinventario = new  TipoDetalleMovimientoInventario();
		  		  
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
		tipodetallemovimientoinventario = new  TipoDetalleMovimientoInventario();
		  		  
        try {
			
			tipodetallemovimientoinventario=tipodetallemovimientoinventarioDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tipodetallemovimientoinventario,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoDetalleMovimientoInventarioConstantesFunciones.refrescarForeignKeysDescripcionesTipoDetalleMovimientoInventario(this.tipodetallemovimientoinventario);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		tipodetallemovimientoinventario = new  TipoDetalleMovimientoInventario();
		  		  
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
		tipodetallemovimientoinventario = new  TipoDetalleMovimientoInventario();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoDetalleMovimientoInventario.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =tipodetallemovimientoinventarioDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		tipodetallemovimientoinventario = new  TipoDetalleMovimientoInventario();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=tipodetallemovimientoinventarioDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		tipodetallemovimientoinventario = new  TipoDetalleMovimientoInventario();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoDetalleMovimientoInventario.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =tipodetallemovimientoinventarioDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		tipodetallemovimientoinventario = new  TipoDetalleMovimientoInventario();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=tipodetallemovimientoinventarioDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		tipodetallemovimientoinventario = new  TipoDetalleMovimientoInventario();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoDetalleMovimientoInventario.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =tipodetallemovimientoinventarioDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		tipodetallemovimientoinventario = new  TipoDetalleMovimientoInventario();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=tipodetallemovimientoinventarioDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		tipodetallemovimientoinventarios = new  ArrayList<TipoDetalleMovimientoInventario>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoDetalleMovimientoInventario.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			TipoDetalleMovimientoInventarioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipodetallemovimientoinventarios=tipodetallemovimientoinventarioDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoDetalleMovimientoInventario(tipodetallemovimientoinventarios);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoDetalleMovimientoInventarioConstantesFunciones.refrescarForeignKeysDescripcionesTipoDetalleMovimientoInventario(this.tipodetallemovimientoinventarios);
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
		tipodetallemovimientoinventarios = new  ArrayList<TipoDetalleMovimientoInventario>();
		  		  
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
		tipodetallemovimientoinventarios = new  ArrayList<TipoDetalleMovimientoInventario>();
		  		  
        try {			
			TipoDetalleMovimientoInventarioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipodetallemovimientoinventarios=tipodetallemovimientoinventarioDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarTipoDetalleMovimientoInventario(tipodetallemovimientoinventarios);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoDetalleMovimientoInventarioConstantesFunciones.refrescarForeignKeysDescripcionesTipoDetalleMovimientoInventario(this.tipodetallemovimientoinventarios);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		tipodetallemovimientoinventarios = new  ArrayList<TipoDetalleMovimientoInventario>();
		  		  
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
		tipodetallemovimientoinventarios = new  ArrayList<TipoDetalleMovimientoInventario>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoDetalleMovimientoInventario.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			TipoDetalleMovimientoInventarioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipodetallemovimientoinventarios=tipodetallemovimientoinventarioDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoDetalleMovimientoInventario(tipodetallemovimientoinventarios);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoDetalleMovimientoInventarioConstantesFunciones.refrescarForeignKeysDescripcionesTipoDetalleMovimientoInventario(this.tipodetallemovimientoinventarios);
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
		tipodetallemovimientoinventarios = new  ArrayList<TipoDetalleMovimientoInventario>();
		  		  
        try {
			TipoDetalleMovimientoInventarioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipodetallemovimientoinventarios=tipodetallemovimientoinventarioDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoDetalleMovimientoInventario(tipodetallemovimientoinventarios);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoDetalleMovimientoInventarioConstantesFunciones.refrescarForeignKeysDescripcionesTipoDetalleMovimientoInventario(this.tipodetallemovimientoinventarios);
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
		tipodetallemovimientoinventarios = new  ArrayList<TipoDetalleMovimientoInventario>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoDetalleMovimientoInventario.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoDetalleMovimientoInventarioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipodetallemovimientoinventarios=tipodetallemovimientoinventarioDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoDetalleMovimientoInventario(tipodetallemovimientoinventarios);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoDetalleMovimientoInventarioConstantesFunciones.refrescarForeignKeysDescripcionesTipoDetalleMovimientoInventario(this.tipodetallemovimientoinventarios);
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
		tipodetallemovimientoinventarios = new  ArrayList<TipoDetalleMovimientoInventario>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoDetalleMovimientoInventarioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipodetallemovimientoinventarios=tipodetallemovimientoinventarioDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoDetalleMovimientoInventario(tipodetallemovimientoinventarios);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoDetalleMovimientoInventarioConstantesFunciones.refrescarForeignKeysDescripcionesTipoDetalleMovimientoInventario(this.tipodetallemovimientoinventarios);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		tipodetallemovimientoinventario = new  TipoDetalleMovimientoInventario();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoDetalleMovimientoInventario.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoDetalleMovimientoInventarioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipodetallemovimientoinventario=tipodetallemovimientoinventarioDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoDetalleMovimientoInventario(tipodetallemovimientoinventario);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoDetalleMovimientoInventarioConstantesFunciones.refrescarForeignKeysDescripcionesTipoDetalleMovimientoInventario(this.tipodetallemovimientoinventario);
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
		tipodetallemovimientoinventario = new  TipoDetalleMovimientoInventario();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoDetalleMovimientoInventarioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipodetallemovimientoinventario=tipodetallemovimientoinventarioDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoDetalleMovimientoInventario(tipodetallemovimientoinventario);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoDetalleMovimientoInventarioConstantesFunciones.refrescarForeignKeysDescripcionesTipoDetalleMovimientoInventario(this.tipodetallemovimientoinventario);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	
	
	public void getTodosTipoDetalleMovimientoInventariosWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		tipodetallemovimientoinventarios = new  ArrayList<TipoDetalleMovimientoInventario>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoDetalleMovimientoInventario.class.getSimpleName()+"-getTodosTipoDetalleMovimientoInventariosWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoDetalleMovimientoInventarioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipodetallemovimientoinventarios=tipodetallemovimientoinventarioDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarTipoDetalleMovimientoInventario(tipodetallemovimientoinventarios);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoDetalleMovimientoInventarioConstantesFunciones.refrescarForeignKeysDescripcionesTipoDetalleMovimientoInventario(this.tipodetallemovimientoinventarios);
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
	
	public  void  getTodosTipoDetalleMovimientoInventarios(String sFinalQuery,Pagination pagination)throws Exception {
		tipodetallemovimientoinventarios = new  ArrayList<TipoDetalleMovimientoInventario>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoDetalleMovimientoInventarioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipodetallemovimientoinventarios=tipodetallemovimientoinventarioDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarTipoDetalleMovimientoInventario(tipodetallemovimientoinventarios);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoDetalleMovimientoInventarioConstantesFunciones.refrescarForeignKeysDescripcionesTipoDetalleMovimientoInventario(this.tipodetallemovimientoinventarios);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarTipoDetalleMovimientoInventario(TipoDetalleMovimientoInventario tipodetallemovimientoinventario) throws Exception {
		Boolean estaValidado=false;
		
		if(tipodetallemovimientoinventario.getIsNew() || tipodetallemovimientoinventario.getIsChanged()) { 
			this.invalidValues = tipodetallemovimientoinventarioValidator.getInvalidValues(tipodetallemovimientoinventario);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(tipodetallemovimientoinventario);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarTipoDetalleMovimientoInventario(List<TipoDetalleMovimientoInventario> TipoDetalleMovimientoInventarios) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(TipoDetalleMovimientoInventario tipodetallemovimientoinventarioLocal:tipodetallemovimientoinventarios) {				
			estaValidadoObjeto=this.validarGuardarTipoDetalleMovimientoInventario(tipodetallemovimientoinventarioLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarTipoDetalleMovimientoInventario(List<TipoDetalleMovimientoInventario> TipoDetalleMovimientoInventarios) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarTipoDetalleMovimientoInventario(tipodetallemovimientoinventarios)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarTipoDetalleMovimientoInventario(TipoDetalleMovimientoInventario TipoDetalleMovimientoInventario) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarTipoDetalleMovimientoInventario(tipodetallemovimientoinventario)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(TipoDetalleMovimientoInventario tipodetallemovimientoinventario) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+tipodetallemovimientoinventario.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=TipoDetalleMovimientoInventarioConstantesFunciones.getTipoDetalleMovimientoInventarioLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"tipodetallemovimientoinventario","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(TipoDetalleMovimientoInventarioConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(TipoDetalleMovimientoInventarioConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveTipoDetalleMovimientoInventarioWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoDetalleMovimientoInventario.class.getSimpleName()+"-saveTipoDetalleMovimientoInventarioWithConnection");connexion.begin();			
			
			//TipoDetalleMovimientoInventarioLogicAdditional.checkTipoDetalleMovimientoInventarioToSave(this.tipodetallemovimientoinventario,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TipoDetalleMovimientoInventarioLogicAdditional.updateTipoDetalleMovimientoInventarioToSave(this.tipodetallemovimientoinventario,this.arrDatoGeneral);
			
			TipoDetalleMovimientoInventarioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.tipodetallemovimientoinventario,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowTipoDetalleMovimientoInventario();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarTipoDetalleMovimientoInventario(this.tipodetallemovimientoinventario)) {
				TipoDetalleMovimientoInventarioDataAccess.save(this.tipodetallemovimientoinventario, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.tipodetallemovimientoinventario,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			//TipoDetalleMovimientoInventarioLogicAdditional.checkTipoDetalleMovimientoInventarioToSaveAfter(this.tipodetallemovimientoinventario,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowTipoDetalleMovimientoInventario();
			
			connexion.commit();			
			
			if(this.tipodetallemovimientoinventario.getIsDeleted()) {
				this.tipodetallemovimientoinventario=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveTipoDetalleMovimientoInventario()throws Exception {	
		try {	
			
			//TipoDetalleMovimientoInventarioLogicAdditional.checkTipoDetalleMovimientoInventarioToSave(this.tipodetallemovimientoinventario,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TipoDetalleMovimientoInventarioLogicAdditional.updateTipoDetalleMovimientoInventarioToSave(this.tipodetallemovimientoinventario,this.arrDatoGeneral);
			
			TipoDetalleMovimientoInventarioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.tipodetallemovimientoinventario,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarTipoDetalleMovimientoInventario(this.tipodetallemovimientoinventario)) {			
				TipoDetalleMovimientoInventarioDataAccess.save(this.tipodetallemovimientoinventario, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.tipodetallemovimientoinventario,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			//TipoDetalleMovimientoInventarioLogicAdditional.checkTipoDetalleMovimientoInventarioToSaveAfter(this.tipodetallemovimientoinventario,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.tipodetallemovimientoinventario.getIsDeleted()) {
				this.tipodetallemovimientoinventario=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveTipoDetalleMovimientoInventariosWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoDetalleMovimientoInventario.class.getSimpleName()+"-saveTipoDetalleMovimientoInventariosWithConnection");connexion.begin();			
			
			//TipoDetalleMovimientoInventarioLogicAdditional.checkTipoDetalleMovimientoInventarioToSaves(tipodetallemovimientoinventarios,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowTipoDetalleMovimientoInventarios();
			
			Boolean validadoTodosTipoDetalleMovimientoInventario=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(TipoDetalleMovimientoInventario tipodetallemovimientoinventarioLocal:tipodetallemovimientoinventarios) {		
				if(tipodetallemovimientoinventarioLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				//TipoDetalleMovimientoInventarioLogicAdditional.updateTipoDetalleMovimientoInventarioToSave(tipodetallemovimientoinventarioLocal,this.arrDatoGeneral);
	        	
				TipoDetalleMovimientoInventarioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),tipodetallemovimientoinventarioLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarTipoDetalleMovimientoInventario(tipodetallemovimientoinventarioLocal)) {
					TipoDetalleMovimientoInventarioDataAccess.save(tipodetallemovimientoinventarioLocal, connexion);				
				} else {
					validadoTodosTipoDetalleMovimientoInventario=false;
				}
			}
			
			if(!validadoTodosTipoDetalleMovimientoInventario) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			//TipoDetalleMovimientoInventarioLogicAdditional.checkTipoDetalleMovimientoInventarioToSavesAfter(tipodetallemovimientoinventarios,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowTipoDetalleMovimientoInventarios();
			
			connexion.commit();		
			
			this.quitarTipoDetalleMovimientoInventariosEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveTipoDetalleMovimientoInventarios()throws Exception {				
		 try {	
			//TipoDetalleMovimientoInventarioLogicAdditional.checkTipoDetalleMovimientoInventarioToSaves(tipodetallemovimientoinventarios,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosTipoDetalleMovimientoInventario=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(TipoDetalleMovimientoInventario tipodetallemovimientoinventarioLocal:tipodetallemovimientoinventarios) {				
				if(tipodetallemovimientoinventarioLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				//TipoDetalleMovimientoInventarioLogicAdditional.updateTipoDetalleMovimientoInventarioToSave(tipodetallemovimientoinventarioLocal,this.arrDatoGeneral);
	        	
				TipoDetalleMovimientoInventarioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),tipodetallemovimientoinventarioLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarTipoDetalleMovimientoInventario(tipodetallemovimientoinventarioLocal)) {				
					TipoDetalleMovimientoInventarioDataAccess.save(tipodetallemovimientoinventarioLocal, connexion);				
				} else {
					validadoTodosTipoDetalleMovimientoInventario=false;
				}
			}
			
			if(!validadoTodosTipoDetalleMovimientoInventario) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			//TipoDetalleMovimientoInventarioLogicAdditional.checkTipoDetalleMovimientoInventarioToSavesAfter(tipodetallemovimientoinventarios,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarTipoDetalleMovimientoInventariosEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public TipoDetalleMovimientoInventarioParameterReturnGeneral procesarAccionTipoDetalleMovimientoInventarios(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<TipoDetalleMovimientoInventario> tipodetallemovimientoinventarios,TipoDetalleMovimientoInventarioParameterReturnGeneral tipodetallemovimientoinventarioParameterGeneral)throws Exception {
		 try {	
			TipoDetalleMovimientoInventarioParameterReturnGeneral tipodetallemovimientoinventarioReturnGeneral=new TipoDetalleMovimientoInventarioParameterReturnGeneral();
	
			
			return tipodetallemovimientoinventarioReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public TipoDetalleMovimientoInventarioParameterReturnGeneral procesarAccionTipoDetalleMovimientoInventariosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<TipoDetalleMovimientoInventario> tipodetallemovimientoinventarios,TipoDetalleMovimientoInventarioParameterReturnGeneral tipodetallemovimientoinventarioParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoDetalleMovimientoInventario.class.getSimpleName()+"-procesarAccionTipoDetalleMovimientoInventariosWithConnection");connexion.begin();			
			
			TipoDetalleMovimientoInventarioParameterReturnGeneral tipodetallemovimientoinventarioReturnGeneral=new TipoDetalleMovimientoInventarioParameterReturnGeneral();
	
			
			this.connexion.commit();
			
			return tipodetallemovimientoinventarioReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public TipoDetalleMovimientoInventarioParameterReturnGeneral procesarEventosTipoDetalleMovimientoInventarios(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<TipoDetalleMovimientoInventario> tipodetallemovimientoinventarios,TipoDetalleMovimientoInventario tipodetallemovimientoinventario,TipoDetalleMovimientoInventarioParameterReturnGeneral tipodetallemovimientoinventarioParameterGeneral,Boolean isEsNuevoTipoDetalleMovimientoInventario,ArrayList<Classe> clases)throws Exception {
		 try {	
			TipoDetalleMovimientoInventarioParameterReturnGeneral tipodetallemovimientoinventarioReturnGeneral=new TipoDetalleMovimientoInventarioParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				tipodetallemovimientoinventarioReturnGeneral.setConRecargarPropiedades(true);
			}
			
			
			return tipodetallemovimientoinventarioReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public TipoDetalleMovimientoInventarioParameterReturnGeneral procesarEventosTipoDetalleMovimientoInventariosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<TipoDetalleMovimientoInventario> tipodetallemovimientoinventarios,TipoDetalleMovimientoInventario tipodetallemovimientoinventario,TipoDetalleMovimientoInventarioParameterReturnGeneral tipodetallemovimientoinventarioParameterGeneral,Boolean isEsNuevoTipoDetalleMovimientoInventario,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoDetalleMovimientoInventario.class.getSimpleName()+"-procesarEventosTipoDetalleMovimientoInventariosWithConnection");connexion.begin();			
			
			TipoDetalleMovimientoInventarioParameterReturnGeneral tipodetallemovimientoinventarioReturnGeneral=new TipoDetalleMovimientoInventarioParameterReturnGeneral();
	
			tipodetallemovimientoinventarioReturnGeneral.setTipoDetalleMovimientoInventario(tipodetallemovimientoinventario);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				tipodetallemovimientoinventarioReturnGeneral.setConRecargarPropiedades(true);
			}
			
			
			this.connexion.commit();
			
			return tipodetallemovimientoinventarioReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public TipoDetalleMovimientoInventarioParameterReturnGeneral procesarImportacionTipoDetalleMovimientoInventariosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,TipoDetalleMovimientoInventarioParameterReturnGeneral tipodetallemovimientoinventarioParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoDetalleMovimientoInventario.class.getSimpleName()+"-procesarImportacionTipoDetalleMovimientoInventariosWithConnection");connexion.begin();			
			
			TipoDetalleMovimientoInventarioParameterReturnGeneral tipodetallemovimientoinventarioReturnGeneral=new TipoDetalleMovimientoInventarioParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.tipodetallemovimientoinventarios=new ArrayList<TipoDetalleMovimientoInventario>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.tipodetallemovimientoinventario=new TipoDetalleMovimientoInventario();
				
				
				if(conColumnasBase) {this.tipodetallemovimientoinventario.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.tipodetallemovimientoinventario.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.tipodetallemovimientoinventario.setcodigo(arrColumnas[iColumn++]);
				this.tipodetallemovimientoinventario.setnombre(arrColumnas[iColumn++]);
				
				this.tipodetallemovimientoinventarios.add(this.tipodetallemovimientoinventario);
			}
			
			this.saveTipoDetalleMovimientoInventarios();
			
			this.connexion.commit();
			
			tipodetallemovimientoinventarioReturnGeneral.setConRetornoEstaProcesado(true);
			tipodetallemovimientoinventarioReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return tipodetallemovimientoinventarioReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarTipoDetalleMovimientoInventariosEliminados() throws Exception {				
		
		List<TipoDetalleMovimientoInventario> tipodetallemovimientoinventariosAux= new ArrayList<TipoDetalleMovimientoInventario>();
		
		for(TipoDetalleMovimientoInventario tipodetallemovimientoinventario:tipodetallemovimientoinventarios) {
			if(!tipodetallemovimientoinventario.getIsDeleted()) {
				tipodetallemovimientoinventariosAux.add(tipodetallemovimientoinventario);
			}
		}
		
		tipodetallemovimientoinventarios=tipodetallemovimientoinventariosAux;
	}
	
	public void quitarTipoDetalleMovimientoInventariosNulos() throws Exception {				
		
		List<TipoDetalleMovimientoInventario> tipodetallemovimientoinventariosAux= new ArrayList<TipoDetalleMovimientoInventario>();
		
		for(TipoDetalleMovimientoInventario tipodetallemovimientoinventario : this.tipodetallemovimientoinventarios) {
			if(tipodetallemovimientoinventario==null) {
				tipodetallemovimientoinventariosAux.add(tipodetallemovimientoinventario);
			}
		}
		
		//this.tipodetallemovimientoinventarios=tipodetallemovimientoinventariosAux;
		
		this.tipodetallemovimientoinventarios.removeAll(tipodetallemovimientoinventariosAux);
	}
	
	public void getSetVersionRowTipoDetalleMovimientoInventarioWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(tipodetallemovimientoinventario.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((tipodetallemovimientoinventario.getIsDeleted() || (tipodetallemovimientoinventario.getIsChanged()&&!tipodetallemovimientoinventario.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=tipodetallemovimientoinventarioDataAccess.getSetVersionRowTipoDetalleMovimientoInventario(connexion,tipodetallemovimientoinventario.getId());
				
				if(!tipodetallemovimientoinventario.getVersionRow().equals(timestamp)) {	
					tipodetallemovimientoinventario.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				tipodetallemovimientoinventario.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowTipoDetalleMovimientoInventario()throws Exception {	
		
		if(tipodetallemovimientoinventario.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((tipodetallemovimientoinventario.getIsDeleted() || (tipodetallemovimientoinventario.getIsChanged()&&!tipodetallemovimientoinventario.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=tipodetallemovimientoinventarioDataAccess.getSetVersionRowTipoDetalleMovimientoInventario(connexion,tipodetallemovimientoinventario.getId());
			
			try {							
				if(!tipodetallemovimientoinventario.getVersionRow().equals(timestamp)) {	
					tipodetallemovimientoinventario.setVersionRow(timestamp);
				}
				
				tipodetallemovimientoinventario.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowTipoDetalleMovimientoInventariosWithConnection()throws Exception {	
		if(tipodetallemovimientoinventarios!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(TipoDetalleMovimientoInventario tipodetallemovimientoinventarioAux:tipodetallemovimientoinventarios) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(tipodetallemovimientoinventarioAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(tipodetallemovimientoinventarioAux.getIsDeleted() || (tipodetallemovimientoinventarioAux.getIsChanged()&&!tipodetallemovimientoinventarioAux.getIsNew())) {
						
						timestamp=tipodetallemovimientoinventarioDataAccess.getSetVersionRowTipoDetalleMovimientoInventario(connexion,tipodetallemovimientoinventarioAux.getId());
						
						if(!tipodetallemovimientoinventario.getVersionRow().equals(timestamp)) {	
							tipodetallemovimientoinventarioAux.setVersionRow(timestamp);
						}
								
						tipodetallemovimientoinventarioAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowTipoDetalleMovimientoInventarios()throws Exception {	
		if(tipodetallemovimientoinventarios!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(TipoDetalleMovimientoInventario tipodetallemovimientoinventarioAux:tipodetallemovimientoinventarios) {
					if(tipodetallemovimientoinventarioAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(tipodetallemovimientoinventarioAux.getIsDeleted() || (tipodetallemovimientoinventarioAux.getIsChanged()&&!tipodetallemovimientoinventarioAux.getIsNew())) {
						
						timestamp=tipodetallemovimientoinventarioDataAccess.getSetVersionRowTipoDetalleMovimientoInventario(connexion,tipodetallemovimientoinventarioAux.getId());
						
						if(!tipodetallemovimientoinventarioAux.getVersionRow().equals(timestamp)) {	
							tipodetallemovimientoinventarioAux.setVersionRow(timestamp);
						}
						
													
						tipodetallemovimientoinventarioAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	
	public void cargarRelacionesLoteForeignKeyTipoDetalleMovimientoInventarioWithConnection() throws Exception {
		ArrayList<Classe> classes=new ArrayList<Classe>();		
		
		
			DetalleMovimientoInventarioLogic detallemovimientoinventarioLogic=new DetalleMovimientoInventarioLogic();
		
		try {
			
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoDetalleMovimientoInventario.class.getSimpleName()+"-cargarRelacionesLoteForeignKeyTipoDetalleMovimientoInventarioWithConnection");connexion.begin();
			
			
			classes.add(new Classe(DetalleMovimientoInventario.class));
											
			

			detallemovimientoinventarioLogic.setConnexion(this.getConnexion());
			detallemovimientoinventarioLogic.setDatosCliente(this.datosCliente);
			detallemovimientoinventarioLogic.setIsConRefrescarForeignKeys(true);
			
			this.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
			
			for(TipoDetalleMovimientoInventario tipodetallemovimientoinventario:this.tipodetallemovimientoinventarios) {
				

				classes=new ArrayList<Classe>();
				classes=DetalleMovimientoInventarioConstantesFunciones.getClassesForeignKeysOfDetalleMovimientoInventario(new ArrayList<Classe>(),DeepLoadType.NONE);

				detallemovimientoinventarioLogic.setDetalleMovimientoInventarios(tipodetallemovimientoinventario.detallemovimientoinventarios);
				detallemovimientoinventarioLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
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
	
	public void deepLoad(TipoDetalleMovimientoInventario tipodetallemovimientoinventario,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			//TipoDetalleMovimientoInventarioLogicAdditional.updateTipoDetalleMovimientoInventarioToGet(tipodetallemovimientoinventario,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		tipodetallemovimientoinventario.setDetalleMovimientoInventarios(tipodetallemovimientoinventarioDataAccess.getDetalleMovimientoInventarios(connexion,tipodetallemovimientoinventario));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(DetalleMovimientoInventario.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				tipodetallemovimientoinventario.setDetalleMovimientoInventarios(tipodetallemovimientoinventarioDataAccess.getDetalleMovimientoInventarios(connexion,tipodetallemovimientoinventario));

				if(this.isConDeep) {
					DetalleMovimientoInventarioLogic detallemovimientoinventarioLogic= new DetalleMovimientoInventarioLogic(this.connexion);
					detallemovimientoinventarioLogic.setDetalleMovimientoInventarios(tipodetallemovimientoinventario.getDetalleMovimientoInventarios());
					ArrayList<Classe> classesLocal=DetalleMovimientoInventarioConstantesFunciones.getClassesForeignKeysOfDetalleMovimientoInventario(new ArrayList<Classe>(),DeepLoadType.NONE);
					detallemovimientoinventarioLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					DetalleMovimientoInventarioConstantesFunciones.refrescarForeignKeysDescripcionesDetalleMovimientoInventario(detallemovimientoinventarioLogic.getDetalleMovimientoInventarios());
					tipodetallemovimientoinventario.setDetalleMovimientoInventarios(detallemovimientoinventarioLogic.getDetalleMovimientoInventarios());
				}

				continue;
			}
		}
	}
	else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {


		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(DetalleMovimientoInventario.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(DetalleMovimientoInventario.class));
			tipodetallemovimientoinventario.setDetalleMovimientoInventarios(tipodetallemovimientoinventarioDataAccess.getDetalleMovimientoInventarios(connexion,tipodetallemovimientoinventario));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {


		tipodetallemovimientoinventario.setDetalleMovimientoInventarios(tipodetallemovimientoinventarioDataAccess.getDetalleMovimientoInventarios(connexion,tipodetallemovimientoinventario));

		for(DetalleMovimientoInventario detallemovimientoinventario:tipodetallemovimientoinventario.getDetalleMovimientoInventarios()) {
			DetalleMovimientoInventarioLogic detallemovimientoinventarioLogic= new DetalleMovimientoInventarioLogic(connexion);
			detallemovimientoinventarioLogic.deepLoad(detallemovimientoinventario,isDeep,deepLoadType,clases);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(DetalleMovimientoInventario.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				tipodetallemovimientoinventario.setDetalleMovimientoInventarios(tipodetallemovimientoinventarioDataAccess.getDetalleMovimientoInventarios(connexion,tipodetallemovimientoinventario));

				for(DetalleMovimientoInventario detallemovimientoinventario:tipodetallemovimientoinventario.getDetalleMovimientoInventarios()) {
					DetalleMovimientoInventarioLogic detallemovimientoinventarioLogic= new DetalleMovimientoInventarioLogic(connexion);
					detallemovimientoinventarioLogic.deepLoad(detallemovimientoinventario,isDeep,deepLoadType,clases);
				}
				continue;
			}

		}
	}
	else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {


		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(DetalleMovimientoInventario.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(DetalleMovimientoInventario.class));
			tipodetallemovimientoinventario.setDetalleMovimientoInventarios(tipodetallemovimientoinventarioDataAccess.getDetalleMovimientoInventarios(connexion,tipodetallemovimientoinventario));

			for(DetalleMovimientoInventario detallemovimientoinventario:tipodetallemovimientoinventario.getDetalleMovimientoInventarios()) {
				DetalleMovimientoInventarioLogic detallemovimientoinventarioLogic= new DetalleMovimientoInventarioLogic(connexion);
				detallemovimientoinventarioLogic.deepLoad(detallemovimientoinventario,isDeep,deepLoadType,clases);
			}
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(TipoDetalleMovimientoInventario tipodetallemovimientoinventario,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}	
	}
	
	public void deepLoadWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(TipoDetalleMovimientoInventario.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(tipodetallemovimientoinventario,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				TipoDetalleMovimientoInventarioConstantesFunciones.refrescarForeignKeysDescripcionesTipoDetalleMovimientoInventario(tipodetallemovimientoinventario);
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
			this.deepLoad(this.tipodetallemovimientoinventario,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				TipoDetalleMovimientoInventarioConstantesFunciones.refrescarForeignKeysDescripcionesTipoDetalleMovimientoInventario(this.tipodetallemovimientoinventario);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(TipoDetalleMovimientoInventario.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(tipodetallemovimientoinventarios!=null) {
				for(TipoDetalleMovimientoInventario tipodetallemovimientoinventario:tipodetallemovimientoinventarios) {
					this.deepLoad(tipodetallemovimientoinventario,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					TipoDetalleMovimientoInventarioConstantesFunciones.refrescarForeignKeysDescripcionesTipoDetalleMovimientoInventario(tipodetallemovimientoinventarios);
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
			if(tipodetallemovimientoinventarios!=null) {
				for(TipoDetalleMovimientoInventario tipodetallemovimientoinventario:tipodetallemovimientoinventarios) {
					this.deepLoad(tipodetallemovimientoinventario,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					TipoDetalleMovimientoInventarioConstantesFunciones.refrescarForeignKeysDescripcionesTipoDetalleMovimientoInventario(tipodetallemovimientoinventarios);
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
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,String sProcesoBusqueda,String sDetalleProcesoBusqueda,QueryWhereSelectParameters queryWhereSelectParameters,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(TipoDetalleMovimientoInventarioConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoDetalleMovimientoInventarioDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,TipoDetalleMovimientoInventario tipodetallemovimientoinventario,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(TipoDetalleMovimientoInventarioConstantesFunciones.ISCONAUDITORIA) {
				if(tipodetallemovimientoinventario.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoDetalleMovimientoInventarioDataAccess.TABLENAME, tipodetallemovimientoinventario.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(TipoDetalleMovimientoInventarioConstantesFunciones.ISCONAUDITORIADETALLE) {
						////TipoDetalleMovimientoInventarioLogic.registrarAuditoriaDetallesTipoDetalleMovimientoInventario(connexion,tipodetallemovimientoinventario,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(tipodetallemovimientoinventario.getIsDeleted()) {
					/*if(!tipodetallemovimientoinventario.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,TipoDetalleMovimientoInventarioDataAccess.TABLENAME, tipodetallemovimientoinventario.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////TipoDetalleMovimientoInventarioLogic.registrarAuditoriaDetallesTipoDetalleMovimientoInventario(connexion,tipodetallemovimientoinventario,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoDetalleMovimientoInventarioDataAccess.TABLENAME, tipodetallemovimientoinventario.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(tipodetallemovimientoinventario.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoDetalleMovimientoInventarioDataAccess.TABLENAME, tipodetallemovimientoinventario.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(TipoDetalleMovimientoInventarioConstantesFunciones.ISCONAUDITORIADETALLE) {
						////TipoDetalleMovimientoInventarioLogic.registrarAuditoriaDetallesTipoDetalleMovimientoInventario(connexion,tipodetallemovimientoinventario,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesTipoDetalleMovimientoInventario(Connexion connexion,TipoDetalleMovimientoInventario tipodetallemovimientoinventario)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(tipodetallemovimientoinventario.getIsNew()||!tipodetallemovimientoinventario.getcodigo().equals(tipodetallemovimientoinventario.getTipoDetalleMovimientoInventarioOriginal().getcodigo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(tipodetallemovimientoinventario.getTipoDetalleMovimientoInventarioOriginal().getcodigo()!=null)
				{
					strValorActual=tipodetallemovimientoinventario.getTipoDetalleMovimientoInventarioOriginal().getcodigo();
				}
				if(tipodetallemovimientoinventario.getcodigo()!=null)
				{
					strValorNuevo=tipodetallemovimientoinventario.getcodigo() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TipoDetalleMovimientoInventarioConstantesFunciones.CODIGO,strValorActual,strValorNuevo);
			}	
			
			if(tipodetallemovimientoinventario.getIsNew()||!tipodetallemovimientoinventario.getnombre().equals(tipodetallemovimientoinventario.getTipoDetalleMovimientoInventarioOriginal().getnombre()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(tipodetallemovimientoinventario.getTipoDetalleMovimientoInventarioOriginal().getnombre()!=null)
				{
					strValorActual=tipodetallemovimientoinventario.getTipoDetalleMovimientoInventarioOriginal().getnombre();
				}
				if(tipodetallemovimientoinventario.getnombre()!=null)
				{
					strValorNuevo=tipodetallemovimientoinventario.getnombre() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TipoDetalleMovimientoInventarioConstantesFunciones.NOMBRE,strValorActual,strValorNuevo);
			}	
	}
	
	
//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfTipoDetalleMovimientoInventario(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=TipoDetalleMovimientoInventarioConstantesFunciones.getClassesForeignKeysOfTipoDetalleMovimientoInventario(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfTipoDetalleMovimientoInventario(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=TipoDetalleMovimientoInventarioConstantesFunciones.getClassesRelationshipsOfTipoDetalleMovimientoInventario(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
}
