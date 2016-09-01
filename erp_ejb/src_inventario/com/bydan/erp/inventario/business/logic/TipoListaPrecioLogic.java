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
import com.bydan.erp.inventario.util.TipoListaPrecioConstantesFunciones;
import com.bydan.erp.inventario.util.TipoListaPrecioParameterReturnGeneral;
//import com.bydan.erp.inventario.util.TipoListaPrecioParameterGeneral;
import com.bydan.erp.inventario.business.entity.TipoListaPrecio;
import com.bydan.erp.inventario.business.logic.TipoListaPrecioLogicAdditional;
import com.bydan.erp.inventario.business.dataaccess.*;
import com.bydan.erp.inventario.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.nomina.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.comisiones.business.entity.*;
import com.bydan.erp.inventario.business.entity.*;
import com.bydan.erp.sris.business.entity.*;
import com.bydan.erp.facturacion.business.entity.*;
import com.bydan.erp.tesoreria.business.entity.*;
import com.bydan.erp.puntoventa.business.entity.*;
import com.bydan.erp.activosfijos.business.entity.*;
import com.bydan.erp.importaciones.business.entity.*;
import com.bydan.erp.produccion.business.entity.*;


import com.bydan.erp.seguridad.business.logic.*;
import com.bydan.erp.cartera.business.logic.*;
import com.bydan.erp.nomina.business.logic.*;
import com.bydan.erp.contabilidad.business.logic.*;
import com.bydan.erp.comisiones.business.logic.*;
import com.bydan.erp.inventario.business.logic.*;
import com.bydan.erp.sris.business.logic.*;
import com.bydan.erp.facturacion.business.logic.*;
import com.bydan.erp.tesoreria.business.logic.*;
import com.bydan.erp.puntoventa.business.logic.*;
import com.bydan.erp.activosfijos.business.logic.*;
import com.bydan.erp.importaciones.business.logic.*;
import com.bydan.erp.produccion.business.logic.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.cartera.util.*;
import com.bydan.erp.nomina.util.*;
import com.bydan.erp.contabilidad.util.*;
import com.bydan.erp.comisiones.util.*;
import com.bydan.erp.inventario.util.*;
import com.bydan.erp.sris.util.*;
import com.bydan.erp.facturacion.util.*;
import com.bydan.erp.tesoreria.util.*;
import com.bydan.erp.puntoventa.util.*;
import com.bydan.erp.activosfijos.util.*;
import com.bydan.erp.importaciones.util.*;
import com.bydan.erp.produccion.util.*;


import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.cartera.business.dataaccess.*;
import com.bydan.erp.nomina.business.dataaccess.*;
import com.bydan.erp.contabilidad.business.dataaccess.*;
import com.bydan.erp.comisiones.business.dataaccess.*;
import com.bydan.erp.inventario.business.dataaccess.*;
import com.bydan.erp.sris.business.dataaccess.*;
import com.bydan.erp.facturacion.business.dataaccess.*;
import com.bydan.erp.tesoreria.business.dataaccess.*;
import com.bydan.erp.puntoventa.business.dataaccess.*;
import com.bydan.erp.activosfijos.business.dataaccess.*;
import com.bydan.erp.importaciones.business.dataaccess.*;
import com.bydan.erp.produccion.business.dataaccess.*;








@SuppressWarnings("unused")
public class TipoListaPrecioLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(TipoListaPrecioLogic.class);
	
	protected TipoListaPrecioDataAccess tipolistaprecioDataAccess; 	
	protected TipoListaPrecio tipolistaprecio;
	protected List<TipoListaPrecio> tipolistaprecios;
	protected Object tipolistaprecioObject;	
	protected List<Object> tipolistapreciosObject;
	
	public static ClassValidator<TipoListaPrecio> tipolistaprecioValidator = new ClassValidator<TipoListaPrecio>(TipoListaPrecio.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected TipoListaPrecioLogicAdditional tipolistaprecioLogicAdditional=null;
	
	public TipoListaPrecioLogicAdditional getTipoListaPrecioLogicAdditional() {
		return this.tipolistaprecioLogicAdditional;
	}
	
	public void setTipoListaPrecioLogicAdditional(TipoListaPrecioLogicAdditional tipolistaprecioLogicAdditional) {
		try {
			this.tipolistaprecioLogicAdditional=tipolistaprecioLogicAdditional;
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
	
	
	
	
	public  TipoListaPrecioLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.tipolistaprecioDataAccess = new TipoListaPrecioDataAccess();
			
			this.tipolistaprecios= new ArrayList<TipoListaPrecio>();
			this.tipolistaprecio= new TipoListaPrecio();
			
			this.tipolistaprecioObject=new Object();
			this.tipolistapreciosObject=new ArrayList<Object>();
				
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
			
			this.tipolistaprecioDataAccess.setConnexionType(this.connexionType);
			this.tipolistaprecioDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  TipoListaPrecioLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.tipolistaprecioDataAccess = new TipoListaPrecioDataAccess();
			this.tipolistaprecios= new ArrayList<TipoListaPrecio>();
			this.tipolistaprecio= new TipoListaPrecio();
			this.tipolistaprecioObject=new Object();
			this.tipolistapreciosObject=new ArrayList<Object>();
			
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
			
			this.tipolistaprecioDataAccess.setConnexionType(this.connexionType);
			this.tipolistaprecioDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public TipoListaPrecio getTipoListaPrecio() throws Exception {	
		TipoListaPrecioLogicAdditional.checkTipoListaPrecioToGet(tipolistaprecio,this.datosCliente,this.arrDatoGeneral);
		TipoListaPrecioLogicAdditional.updateTipoListaPrecioToGet(tipolistaprecio,this.arrDatoGeneral);
		
		return tipolistaprecio;
	}
		
	public void setTipoListaPrecio(TipoListaPrecio newTipoListaPrecio) {
		this.tipolistaprecio = newTipoListaPrecio;
	}
	
	public TipoListaPrecioDataAccess getTipoListaPrecioDataAccess() {
		return tipolistaprecioDataAccess;
	}
	
	public void setTipoListaPrecioDataAccess(TipoListaPrecioDataAccess newtipolistaprecioDataAccess) {
		this.tipolistaprecioDataAccess = newtipolistaprecioDataAccess;
	}
	
	public List<TipoListaPrecio> getTipoListaPrecios() throws Exception {		
		this.quitarTipoListaPreciosNulos();
		
		TipoListaPrecioLogicAdditional.checkTipoListaPrecioToGets(tipolistaprecios,this.datosCliente,this.arrDatoGeneral);
		
		for (TipoListaPrecio tipolistaprecioLocal: tipolistaprecios ) {
			TipoListaPrecioLogicAdditional.updateTipoListaPrecioToGet(tipolistaprecioLocal,this.arrDatoGeneral);
		}
		
		return tipolistaprecios;
	}
	
	public void setTipoListaPrecios(List<TipoListaPrecio> newTipoListaPrecios) {
		this.tipolistaprecios = newTipoListaPrecios;
	}
	
	public Object getTipoListaPrecioObject() {	
		this.tipolistaprecioObject=this.tipolistaprecioDataAccess.getEntityObject();
		return this.tipolistaprecioObject;
	}
		
	public void setTipoListaPrecioObject(Object newTipoListaPrecioObject) {
		this.tipolistaprecioObject = newTipoListaPrecioObject;
	}
	
	public List<Object> getTipoListaPreciosObject() {		
		this.tipolistapreciosObject=this.tipolistaprecioDataAccess.getEntitiesObject();
		return this.tipolistapreciosObject;
	}
		
	public void setTipoListaPreciosObject(List<Object> newTipoListaPreciosObject) {
		this.tipolistapreciosObject = newTipoListaPreciosObject;
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
		
		if(this.tipolistaprecioDataAccess!=null) {
			this.tipolistaprecioDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoListaPrecio.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			tipolistaprecioDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			tipolistaprecioDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		tipolistaprecio = new  TipoListaPrecio();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoListaPrecio.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			tipolistaprecio=tipolistaprecioDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tipolistaprecio,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoListaPrecioConstantesFunciones.refrescarForeignKeysDescripcionesTipoListaPrecio(this.tipolistaprecio);
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
		tipolistaprecio = new  TipoListaPrecio();
		  		  
        try {
			
			tipolistaprecio=tipolistaprecioDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tipolistaprecio,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoListaPrecioConstantesFunciones.refrescarForeignKeysDescripcionesTipoListaPrecio(this.tipolistaprecio);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		tipolistaprecio = new  TipoListaPrecio();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoListaPrecio.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			tipolistaprecio=tipolistaprecioDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tipolistaprecio,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoListaPrecioConstantesFunciones.refrescarForeignKeysDescripcionesTipoListaPrecio(this.tipolistaprecio);
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
		tipolistaprecio = new  TipoListaPrecio();
		  		  
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
		tipolistaprecio = new  TipoListaPrecio();
		  		  
        try {
			
			tipolistaprecio=tipolistaprecioDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tipolistaprecio,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoListaPrecioConstantesFunciones.refrescarForeignKeysDescripcionesTipoListaPrecio(this.tipolistaprecio);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		tipolistaprecio = new  TipoListaPrecio();
		  		  
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
		tipolistaprecio = new  TipoListaPrecio();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoListaPrecio.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =tipolistaprecioDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		tipolistaprecio = new  TipoListaPrecio();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=tipolistaprecioDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		tipolistaprecio = new  TipoListaPrecio();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoListaPrecio.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =tipolistaprecioDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		tipolistaprecio = new  TipoListaPrecio();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=tipolistaprecioDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		tipolistaprecio = new  TipoListaPrecio();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoListaPrecio.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =tipolistaprecioDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		tipolistaprecio = new  TipoListaPrecio();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=tipolistaprecioDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		tipolistaprecios = new  ArrayList<TipoListaPrecio>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoListaPrecio.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			TipoListaPrecioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipolistaprecios=tipolistaprecioDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoListaPrecio(tipolistaprecios);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoListaPrecioConstantesFunciones.refrescarForeignKeysDescripcionesTipoListaPrecio(this.tipolistaprecios);
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
		tipolistaprecios = new  ArrayList<TipoListaPrecio>();
		  		  
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
		tipolistaprecios = new  ArrayList<TipoListaPrecio>();
		  		  
        try {			
			TipoListaPrecioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipolistaprecios=tipolistaprecioDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarTipoListaPrecio(tipolistaprecios);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoListaPrecioConstantesFunciones.refrescarForeignKeysDescripcionesTipoListaPrecio(this.tipolistaprecios);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		tipolistaprecios = new  ArrayList<TipoListaPrecio>();
		  		  
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
		tipolistaprecios = new  ArrayList<TipoListaPrecio>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoListaPrecio.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			TipoListaPrecioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipolistaprecios=tipolistaprecioDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoListaPrecio(tipolistaprecios);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoListaPrecioConstantesFunciones.refrescarForeignKeysDescripcionesTipoListaPrecio(this.tipolistaprecios);
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
		tipolistaprecios = new  ArrayList<TipoListaPrecio>();
		  		  
        try {
			TipoListaPrecioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipolistaprecios=tipolistaprecioDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoListaPrecio(tipolistaprecios);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoListaPrecioConstantesFunciones.refrescarForeignKeysDescripcionesTipoListaPrecio(this.tipolistaprecios);
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
		tipolistaprecios = new  ArrayList<TipoListaPrecio>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoListaPrecio.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoListaPrecioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipolistaprecios=tipolistaprecioDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoListaPrecio(tipolistaprecios);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoListaPrecioConstantesFunciones.refrescarForeignKeysDescripcionesTipoListaPrecio(this.tipolistaprecios);
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
		tipolistaprecios = new  ArrayList<TipoListaPrecio>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoListaPrecioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipolistaprecios=tipolistaprecioDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoListaPrecio(tipolistaprecios);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoListaPrecioConstantesFunciones.refrescarForeignKeysDescripcionesTipoListaPrecio(this.tipolistaprecios);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		tipolistaprecio = new  TipoListaPrecio();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoListaPrecio.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoListaPrecioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipolistaprecio=tipolistaprecioDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoListaPrecio(tipolistaprecio);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoListaPrecioConstantesFunciones.refrescarForeignKeysDescripcionesTipoListaPrecio(this.tipolistaprecio);
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
		tipolistaprecio = new  TipoListaPrecio();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoListaPrecioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipolistaprecio=tipolistaprecioDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoListaPrecio(tipolistaprecio);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoListaPrecioConstantesFunciones.refrescarForeignKeysDescripcionesTipoListaPrecio(this.tipolistaprecio);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		tipolistaprecios = new  ArrayList<TipoListaPrecio>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoListaPrecio.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			TipoListaPrecioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipolistaprecios=tipolistaprecioDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoListaPrecio(tipolistaprecios);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoListaPrecioConstantesFunciones.refrescarForeignKeysDescripcionesTipoListaPrecio(this.tipolistaprecios);
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
		tipolistaprecios = new  ArrayList<TipoListaPrecio>();
		  		  
        try {
			TipoListaPrecioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipolistaprecios=tipolistaprecioDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoListaPrecio(tipolistaprecios);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoListaPrecioConstantesFunciones.refrescarForeignKeysDescripcionesTipoListaPrecio(this.tipolistaprecios);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosTipoListaPreciosWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		tipolistaprecios = new  ArrayList<TipoListaPrecio>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoListaPrecio.class.getSimpleName()+"-getTodosTipoListaPreciosWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoListaPrecioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipolistaprecios=tipolistaprecioDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarTipoListaPrecio(tipolistaprecios);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoListaPrecioConstantesFunciones.refrescarForeignKeysDescripcionesTipoListaPrecio(this.tipolistaprecios);
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
	
	public  void  getTodosTipoListaPrecios(String sFinalQuery,Pagination pagination)throws Exception {
		tipolistaprecios = new  ArrayList<TipoListaPrecio>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoListaPrecioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipolistaprecios=tipolistaprecioDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarTipoListaPrecio(tipolistaprecios);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoListaPrecioConstantesFunciones.refrescarForeignKeysDescripcionesTipoListaPrecio(this.tipolistaprecios);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarTipoListaPrecio(TipoListaPrecio tipolistaprecio) throws Exception {
		Boolean estaValidado=false;
		
		if(tipolistaprecio.getIsNew() || tipolistaprecio.getIsChanged()) { 
			this.invalidValues = tipolistaprecioValidator.getInvalidValues(tipolistaprecio);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(tipolistaprecio);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarTipoListaPrecio(List<TipoListaPrecio> TipoListaPrecios) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(TipoListaPrecio tipolistaprecioLocal:tipolistaprecios) {				
			estaValidadoObjeto=this.validarGuardarTipoListaPrecio(tipolistaprecioLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarTipoListaPrecio(List<TipoListaPrecio> TipoListaPrecios) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarTipoListaPrecio(tipolistaprecios)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarTipoListaPrecio(TipoListaPrecio TipoListaPrecio) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarTipoListaPrecio(tipolistaprecio)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(TipoListaPrecio tipolistaprecio) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+tipolistaprecio.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=TipoListaPrecioConstantesFunciones.getTipoListaPrecioLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"tipolistaprecio","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(TipoListaPrecioConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(TipoListaPrecioConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveTipoListaPrecioWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoListaPrecio.class.getSimpleName()+"-saveTipoListaPrecioWithConnection");connexion.begin();			
			
			TipoListaPrecioLogicAdditional.checkTipoListaPrecioToSave(this.tipolistaprecio,this.datosCliente,connexion,this.arrDatoGeneral);
			
			TipoListaPrecioLogicAdditional.updateTipoListaPrecioToSave(this.tipolistaprecio,this.arrDatoGeneral);
			
			TipoListaPrecioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.tipolistaprecio,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowTipoListaPrecio();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarTipoListaPrecio(this.tipolistaprecio)) {
				TipoListaPrecioDataAccess.save(this.tipolistaprecio, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.tipolistaprecio,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			TipoListaPrecioLogicAdditional.checkTipoListaPrecioToSaveAfter(this.tipolistaprecio,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowTipoListaPrecio();
			
			connexion.commit();			
			
			if(this.tipolistaprecio.getIsDeleted()) {
				this.tipolistaprecio=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveTipoListaPrecio()throws Exception {	
		try {	
			
			TipoListaPrecioLogicAdditional.checkTipoListaPrecioToSave(this.tipolistaprecio,this.datosCliente,connexion,this.arrDatoGeneral);
			
			TipoListaPrecioLogicAdditional.updateTipoListaPrecioToSave(this.tipolistaprecio,this.arrDatoGeneral);
			
			TipoListaPrecioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.tipolistaprecio,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarTipoListaPrecio(this.tipolistaprecio)) {			
				TipoListaPrecioDataAccess.save(this.tipolistaprecio, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.tipolistaprecio,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			TipoListaPrecioLogicAdditional.checkTipoListaPrecioToSaveAfter(this.tipolistaprecio,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.tipolistaprecio.getIsDeleted()) {
				this.tipolistaprecio=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveTipoListaPreciosWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoListaPrecio.class.getSimpleName()+"-saveTipoListaPreciosWithConnection");connexion.begin();			
			
			TipoListaPrecioLogicAdditional.checkTipoListaPrecioToSaves(tipolistaprecios,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowTipoListaPrecios();
			
			Boolean validadoTodosTipoListaPrecio=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(TipoListaPrecio tipolistaprecioLocal:tipolistaprecios) {		
				if(tipolistaprecioLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				TipoListaPrecioLogicAdditional.updateTipoListaPrecioToSave(tipolistaprecioLocal,this.arrDatoGeneral);
	        	
				TipoListaPrecioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),tipolistaprecioLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarTipoListaPrecio(tipolistaprecioLocal)) {
					TipoListaPrecioDataAccess.save(tipolistaprecioLocal, connexion);				
				} else {
					validadoTodosTipoListaPrecio=false;
				}
			}
			
			if(!validadoTodosTipoListaPrecio) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			TipoListaPrecioLogicAdditional.checkTipoListaPrecioToSavesAfter(tipolistaprecios,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowTipoListaPrecios();
			
			connexion.commit();		
			
			this.quitarTipoListaPreciosEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveTipoListaPrecios()throws Exception {				
		 try {	
			TipoListaPrecioLogicAdditional.checkTipoListaPrecioToSaves(tipolistaprecios,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosTipoListaPrecio=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(TipoListaPrecio tipolistaprecioLocal:tipolistaprecios) {				
				if(tipolistaprecioLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				TipoListaPrecioLogicAdditional.updateTipoListaPrecioToSave(tipolistaprecioLocal,this.arrDatoGeneral);
	        	
				TipoListaPrecioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),tipolistaprecioLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarTipoListaPrecio(tipolistaprecioLocal)) {				
					TipoListaPrecioDataAccess.save(tipolistaprecioLocal, connexion);				
				} else {
					validadoTodosTipoListaPrecio=false;
				}
			}
			
			if(!validadoTodosTipoListaPrecio) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			TipoListaPrecioLogicAdditional.checkTipoListaPrecioToSavesAfter(tipolistaprecios,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarTipoListaPreciosEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public TipoListaPrecioParameterReturnGeneral procesarAccionTipoListaPrecios(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<TipoListaPrecio> tipolistaprecios,TipoListaPrecioParameterReturnGeneral tipolistaprecioParameterGeneral)throws Exception {
		 try {	
			TipoListaPrecioParameterReturnGeneral tipolistaprecioReturnGeneral=new TipoListaPrecioParameterReturnGeneral();
	
			TipoListaPrecioLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,tipolistaprecios,tipolistaprecioParameterGeneral,tipolistaprecioReturnGeneral);
			
			return tipolistaprecioReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public TipoListaPrecioParameterReturnGeneral procesarAccionTipoListaPreciosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<TipoListaPrecio> tipolistaprecios,TipoListaPrecioParameterReturnGeneral tipolistaprecioParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoListaPrecio.class.getSimpleName()+"-procesarAccionTipoListaPreciosWithConnection");connexion.begin();			
			
			TipoListaPrecioParameterReturnGeneral tipolistaprecioReturnGeneral=new TipoListaPrecioParameterReturnGeneral();
	
			TipoListaPrecioLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,tipolistaprecios,tipolistaprecioParameterGeneral,tipolistaprecioReturnGeneral);
			
			this.connexion.commit();
			
			return tipolistaprecioReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public TipoListaPrecioParameterReturnGeneral procesarEventosTipoListaPrecios(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<TipoListaPrecio> tipolistaprecios,TipoListaPrecio tipolistaprecio,TipoListaPrecioParameterReturnGeneral tipolistaprecioParameterGeneral,Boolean isEsNuevoTipoListaPrecio,ArrayList<Classe> clases)throws Exception {
		 try {	
			TipoListaPrecioParameterReturnGeneral tipolistaprecioReturnGeneral=new TipoListaPrecioParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				tipolistaprecioReturnGeneral.setConRecargarPropiedades(true);
			}
			
			TipoListaPrecioLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,tipolistaprecios,tipolistaprecio,tipolistaprecioParameterGeneral,tipolistaprecioReturnGeneral,isEsNuevoTipoListaPrecio,clases);
			
			return tipolistaprecioReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public TipoListaPrecioParameterReturnGeneral procesarEventosTipoListaPreciosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<TipoListaPrecio> tipolistaprecios,TipoListaPrecio tipolistaprecio,TipoListaPrecioParameterReturnGeneral tipolistaprecioParameterGeneral,Boolean isEsNuevoTipoListaPrecio,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoListaPrecio.class.getSimpleName()+"-procesarEventosTipoListaPreciosWithConnection");connexion.begin();			
			
			TipoListaPrecioParameterReturnGeneral tipolistaprecioReturnGeneral=new TipoListaPrecioParameterReturnGeneral();
	
			tipolistaprecioReturnGeneral.setTipoListaPrecio(tipolistaprecio);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				tipolistaprecioReturnGeneral.setConRecargarPropiedades(true);
			}
			
			TipoListaPrecioLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,tipolistaprecios,tipolistaprecio,tipolistaprecioParameterGeneral,tipolistaprecioReturnGeneral,isEsNuevoTipoListaPrecio,clases);
			
			this.connexion.commit();
			
			return tipolistaprecioReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public TipoListaPrecioParameterReturnGeneral procesarImportacionTipoListaPreciosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,TipoListaPrecioParameterReturnGeneral tipolistaprecioParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoListaPrecio.class.getSimpleName()+"-procesarImportacionTipoListaPreciosWithConnection");connexion.begin();			
			
			TipoListaPrecioParameterReturnGeneral tipolistaprecioReturnGeneral=new TipoListaPrecioParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.tipolistaprecios=new ArrayList<TipoListaPrecio>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.tipolistaprecio=new TipoListaPrecio();
				
				
				if(conColumnasBase) {this.tipolistaprecio.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.tipolistaprecio.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.tipolistaprecio.setcodigo(arrColumnas[iColumn++]);
				this.tipolistaprecio.setnombre(arrColumnas[iColumn++]);
				this.tipolistaprecio.setfecha_desde(Funciones.ConvertToDate(arrColumnas[iColumn++]));
				this.tipolistaprecio.setfecha_hasta(Funciones.ConvertToDate(arrColumnas[iColumn++]));
				this.tipolistaprecio.setesta_activo(Boolean.parseBoolean(arrColumnas[iColumn++]));
			this.tipolistaprecio.setdescripcion(arrColumnas[iColumn++]);
				
				this.tipolistaprecios.add(this.tipolistaprecio);
			}
			
			this.saveTipoListaPrecios();
			
			this.connexion.commit();
			
			tipolistaprecioReturnGeneral.setConRetornoEstaProcesado(true);
			tipolistaprecioReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return tipolistaprecioReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarTipoListaPreciosEliminados() throws Exception {				
		
		List<TipoListaPrecio> tipolistapreciosAux= new ArrayList<TipoListaPrecio>();
		
		for(TipoListaPrecio tipolistaprecio:tipolistaprecios) {
			if(!tipolistaprecio.getIsDeleted()) {
				tipolistapreciosAux.add(tipolistaprecio);
			}
		}
		
		tipolistaprecios=tipolistapreciosAux;
	}
	
	public void quitarTipoListaPreciosNulos() throws Exception {				
		
		List<TipoListaPrecio> tipolistapreciosAux= new ArrayList<TipoListaPrecio>();
		
		for(TipoListaPrecio tipolistaprecio : this.tipolistaprecios) {
			if(tipolistaprecio==null) {
				tipolistapreciosAux.add(tipolistaprecio);
			}
		}
		
		//this.tipolistaprecios=tipolistapreciosAux;
		
		this.tipolistaprecios.removeAll(tipolistapreciosAux);
	}
	
	public void getSetVersionRowTipoListaPrecioWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(tipolistaprecio.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((tipolistaprecio.getIsDeleted() || (tipolistaprecio.getIsChanged()&&!tipolistaprecio.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=tipolistaprecioDataAccess.getSetVersionRowTipoListaPrecio(connexion,tipolistaprecio.getId());
				
				if(!tipolistaprecio.getVersionRow().equals(timestamp)) {	
					tipolistaprecio.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				tipolistaprecio.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowTipoListaPrecio()throws Exception {	
		
		if(tipolistaprecio.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((tipolistaprecio.getIsDeleted() || (tipolistaprecio.getIsChanged()&&!tipolistaprecio.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=tipolistaprecioDataAccess.getSetVersionRowTipoListaPrecio(connexion,tipolistaprecio.getId());
			
			try {							
				if(!tipolistaprecio.getVersionRow().equals(timestamp)) {	
					tipolistaprecio.setVersionRow(timestamp);
				}
				
				tipolistaprecio.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowTipoListaPreciosWithConnection()throws Exception {	
		if(tipolistaprecios!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(TipoListaPrecio tipolistaprecioAux:tipolistaprecios) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(tipolistaprecioAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(tipolistaprecioAux.getIsDeleted() || (tipolistaprecioAux.getIsChanged()&&!tipolistaprecioAux.getIsNew())) {
						
						timestamp=tipolistaprecioDataAccess.getSetVersionRowTipoListaPrecio(connexion,tipolistaprecioAux.getId());
						
						if(!tipolistaprecio.getVersionRow().equals(timestamp)) {	
							tipolistaprecioAux.setVersionRow(timestamp);
						}
								
						tipolistaprecioAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowTipoListaPrecios()throws Exception {	
		if(tipolistaprecios!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(TipoListaPrecio tipolistaprecioAux:tipolistaprecios) {
					if(tipolistaprecioAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(tipolistaprecioAux.getIsDeleted() || (tipolistaprecioAux.getIsChanged()&&!tipolistaprecioAux.getIsNew())) {
						
						timestamp=tipolistaprecioDataAccess.getSetVersionRowTipoListaPrecio(connexion,tipolistaprecioAux.getId());
						
						if(!tipolistaprecioAux.getVersionRow().equals(timestamp)) {	
							tipolistaprecioAux.setVersionRow(timestamp);
						}
						
													
						tipolistaprecioAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public TipoListaPrecioParameterReturnGeneral cargarCombosLoteForeignKeyTipoListaPrecioWithConnection(String finalQueryGlobalEmpresa) throws Exception {
		TipoListaPrecioParameterReturnGeneral  tipolistaprecioReturnGeneral =new TipoListaPrecioParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoListaPrecio.class.getSimpleName()+"-cargarCombosLoteForeignKeyTipoListaPrecioWithConnection");connexion.begin();
			
			tipolistaprecioReturnGeneral =new TipoListaPrecioParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			tipolistaprecioReturnGeneral.setempresasForeignKey(empresasForeignKey);

			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
		
		return tipolistaprecioReturnGeneral;
	}
	
	public TipoListaPrecioParameterReturnGeneral cargarCombosLoteForeignKeyTipoListaPrecio(String finalQueryGlobalEmpresa) throws Exception {
		TipoListaPrecioParameterReturnGeneral  tipolistaprecioReturnGeneral =new TipoListaPrecioParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {						
			tipolistaprecioReturnGeneral =new TipoListaPrecioParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			tipolistaprecioReturnGeneral.setempresasForeignKey(empresasForeignKey);
						
			
		} catch(Exception e) {			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			
		}
		
		return tipolistaprecioReturnGeneral;
	}
	
	public void cargarRelacionesLoteForeignKeyTipoListaPrecioWithConnection() throws Exception {
		ArrayList<Classe> classes=new ArrayList<Classe>();		
		
		
			ClienteLogic clienteLogic=new ClienteLogic();
			ParametroCarteraDefectoLogic parametrocarteradefectoLogic=new ParametroCarteraDefectoLogic();
		
		try {
			
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoListaPrecio.class.getSimpleName()+"-cargarRelacionesLoteForeignKeyTipoListaPrecioWithConnection");connexion.begin();
			
			
			classes.add(new Classe(Cliente.class));
			classes.add(new Classe(ParametroCarteraDefecto.class));
											
			

			clienteLogic.setConnexion(this.getConnexion());
			clienteLogic.setDatosCliente(this.datosCliente);
			clienteLogic.setIsConRefrescarForeignKeys(true);

			parametrocarteradefectoLogic.setConnexion(this.getConnexion());
			parametrocarteradefectoLogic.setDatosCliente(this.datosCliente);
			parametrocarteradefectoLogic.setIsConRefrescarForeignKeys(true);
			
			this.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
			
			for(TipoListaPrecio tipolistaprecio:this.tipolistaprecios) {
				

				classes=new ArrayList<Classe>();
				classes=ClienteConstantesFunciones.getClassesForeignKeysOfCliente(new ArrayList<Classe>(),DeepLoadType.NONE);

				clienteLogic.setClientes(tipolistaprecio.clientes);
				clienteLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");

				classes=new ArrayList<Classe>();
				classes=ParametroCarteraDefectoConstantesFunciones.getClassesForeignKeysOfParametroCarteraDefecto(new ArrayList<Classe>(),DeepLoadType.NONE);

				parametrocarteradefectoLogic.setParametroCarteraDefectos(tipolistaprecio.parametrocarteradefectos);
				parametrocarteradefectoLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
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
	
	public void deepLoad(TipoListaPrecio tipolistaprecio,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			TipoListaPrecioLogicAdditional.updateTipoListaPrecioToGet(tipolistaprecio,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		tipolistaprecio.setEmpresa(tipolistaprecioDataAccess.getEmpresa(connexion,tipolistaprecio));
		tipolistaprecio.setClientes(tipolistaprecioDataAccess.getClientes(connexion,tipolistaprecio));
		tipolistaprecio.setParametroCarteraDefectos(tipolistaprecioDataAccess.getParametroCarteraDefectos(connexion,tipolistaprecio));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				tipolistaprecio.setEmpresa(tipolistaprecioDataAccess.getEmpresa(connexion,tipolistaprecio));
				continue;
			}

			if(clas.clas.equals(Cliente.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				tipolistaprecio.setClientes(tipolistaprecioDataAccess.getClientes(connexion,tipolistaprecio));

				if(this.isConDeep) {
					ClienteLogic clienteLogic= new ClienteLogic(this.connexion);
					clienteLogic.setClientes(tipolistaprecio.getClientes());
					ArrayList<Classe> classesLocal=ClienteConstantesFunciones.getClassesForeignKeysOfCliente(new ArrayList<Classe>(),DeepLoadType.NONE);
					clienteLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					ClienteConstantesFunciones.refrescarForeignKeysDescripcionesCliente(clienteLogic.getClientes());
					tipolistaprecio.setClientes(clienteLogic.getClientes());
				}

				continue;
			}

			if(clas.clas.equals(ParametroCarteraDefecto.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				tipolistaprecio.setParametroCarteraDefectos(tipolistaprecioDataAccess.getParametroCarteraDefectos(connexion,tipolistaprecio));

				if(this.isConDeep) {
					ParametroCarteraDefectoLogic parametrocarteradefectoLogic= new ParametroCarteraDefectoLogic(this.connexion);
					parametrocarteradefectoLogic.setParametroCarteraDefectos(tipolistaprecio.getParametroCarteraDefectos());
					ArrayList<Classe> classesLocal=ParametroCarteraDefectoConstantesFunciones.getClassesForeignKeysOfParametroCarteraDefecto(new ArrayList<Classe>(),DeepLoadType.NONE);
					parametrocarteradefectoLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					ParametroCarteraDefectoConstantesFunciones.refrescarForeignKeysDescripcionesParametroCarteraDefecto(parametrocarteradefectoLogic.getParametroCarteraDefectos());
					tipolistaprecio.setParametroCarteraDefectos(parametrocarteradefectoLogic.getParametroCarteraDefectos());
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
			tipolistaprecio.setEmpresa(tipolistaprecioDataAccess.getEmpresa(connexion,tipolistaprecio));
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
			tipolistaprecio.setClientes(tipolistaprecioDataAccess.getClientes(connexion,tipolistaprecio));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(ParametroCarteraDefecto.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(ParametroCarteraDefecto.class));
			tipolistaprecio.setParametroCarteraDefectos(tipolistaprecioDataAccess.getParametroCarteraDefectos(connexion,tipolistaprecio));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		tipolistaprecio.setEmpresa(tipolistaprecioDataAccess.getEmpresa(connexion,tipolistaprecio));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(tipolistaprecio.getEmpresa(),isDeep,deepLoadType,clases);
				

		tipolistaprecio.setClientes(tipolistaprecioDataAccess.getClientes(connexion,tipolistaprecio));

		for(Cliente cliente:tipolistaprecio.getClientes()) {
			ClienteLogic clienteLogic= new ClienteLogic(connexion);
			clienteLogic.deepLoad(cliente,isDeep,deepLoadType,clases);
		}

		tipolistaprecio.setParametroCarteraDefectos(tipolistaprecioDataAccess.getParametroCarteraDefectos(connexion,tipolistaprecio));

		for(ParametroCarteraDefecto parametrocarteradefecto:tipolistaprecio.getParametroCarteraDefectos()) {
			ParametroCarteraDefectoLogic parametrocarteradefectoLogic= new ParametroCarteraDefectoLogic(connexion);
			parametrocarteradefectoLogic.deepLoad(parametrocarteradefecto,isDeep,deepLoadType,clases);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				tipolistaprecio.setEmpresa(tipolistaprecioDataAccess.getEmpresa(connexion,tipolistaprecio));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(tipolistaprecio.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Cliente.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				tipolistaprecio.setClientes(tipolistaprecioDataAccess.getClientes(connexion,tipolistaprecio));

				for(Cliente cliente:tipolistaprecio.getClientes()) {
					ClienteLogic clienteLogic= new ClienteLogic(connexion);
					clienteLogic.deepLoad(cliente,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(ParametroCarteraDefecto.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				tipolistaprecio.setParametroCarteraDefectos(tipolistaprecioDataAccess.getParametroCarteraDefectos(connexion,tipolistaprecio));

				for(ParametroCarteraDefecto parametrocarteradefecto:tipolistaprecio.getParametroCarteraDefectos()) {
					ParametroCarteraDefectoLogic parametrocarteradefectoLogic= new ParametroCarteraDefectoLogic(connexion);
					parametrocarteradefectoLogic.deepLoad(parametrocarteradefecto,isDeep,deepLoadType,clases);
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
			tipolistaprecio.setEmpresa(tipolistaprecioDataAccess.getEmpresa(connexion,tipolistaprecio));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(tipolistaprecio.getEmpresa(),isDeep,deepLoadType,clases);
				
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
			tipolistaprecio.setClientes(tipolistaprecioDataAccess.getClientes(connexion,tipolistaprecio));

			for(Cliente cliente:tipolistaprecio.getClientes()) {
				ClienteLogic clienteLogic= new ClienteLogic(connexion);
				clienteLogic.deepLoad(cliente,isDeep,deepLoadType,clases);
			}
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(ParametroCarteraDefecto.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(ParametroCarteraDefecto.class));
			tipolistaprecio.setParametroCarteraDefectos(tipolistaprecioDataAccess.getParametroCarteraDefectos(connexion,tipolistaprecio));

			for(ParametroCarteraDefecto parametrocarteradefecto:tipolistaprecio.getParametroCarteraDefectos()) {
				ParametroCarteraDefectoLogic parametrocarteradefectoLogic= new ParametroCarteraDefectoLogic(connexion);
				parametrocarteradefectoLogic.deepLoad(parametrocarteradefecto,isDeep,deepLoadType,clases);
			}
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(TipoListaPrecio tipolistaprecio,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			TipoListaPrecioLogicAdditional.updateTipoListaPrecioToSave(tipolistaprecio,this.arrDatoGeneral);
			
TipoListaPrecioDataAccess.save(tipolistaprecio, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(tipolistaprecio.getEmpresa(),connexion);

		for(Cliente cliente:tipolistaprecio.getClientes()) {
			cliente.setid_tipo_lista_precio(tipolistaprecio.getId());
			ClienteDataAccess.save(cliente,connexion);
		}

		for(ParametroCarteraDefecto parametrocarteradefecto:tipolistaprecio.getParametroCarteraDefectos()) {
			parametrocarteradefecto.setid_tipo_lista_precio(tipolistaprecio.getId());
			ParametroCarteraDefectoDataAccess.save(parametrocarteradefecto,connexion);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(tipolistaprecio.getEmpresa(),connexion);
				continue;
			}


			if(clas.clas.equals(Cliente.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(Cliente cliente:tipolistaprecio.getClientes()) {
					cliente.setid_tipo_lista_precio(tipolistaprecio.getId());
					ClienteDataAccess.save(cliente,connexion);
				}
				continue;
			}

			if(clas.clas.equals(ParametroCarteraDefecto.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(ParametroCarteraDefecto parametrocarteradefecto:tipolistaprecio.getParametroCarteraDefectos()) {
					parametrocarteradefecto.setid_tipo_lista_precio(tipolistaprecio.getId());
					ParametroCarteraDefectoDataAccess.save(parametrocarteradefecto,connexion);
				}
				continue;
			}
		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(tipolistaprecio.getEmpresa(),connexion);
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(tipolistaprecio.getEmpresa(),isDeep,deepLoadType,clases);
				

		for(Cliente cliente:tipolistaprecio.getClientes()) {
			ClienteLogic clienteLogic= new ClienteLogic(connexion);
			cliente.setid_tipo_lista_precio(tipolistaprecio.getId());
			ClienteDataAccess.save(cliente,connexion);
			clienteLogic.deepSave(cliente,isDeep,deepLoadType,clases);
		}

		for(ParametroCarteraDefecto parametrocarteradefecto:tipolistaprecio.getParametroCarteraDefectos()) {
			ParametroCarteraDefectoLogic parametrocarteradefectoLogic= new ParametroCarteraDefectoLogic(connexion);
			parametrocarteradefecto.setid_tipo_lista_precio(tipolistaprecio.getId());
			ParametroCarteraDefectoDataAccess.save(parametrocarteradefecto,connexion);
			parametrocarteradefectoLogic.deepSave(parametrocarteradefecto,isDeep,deepLoadType,clases);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(tipolistaprecio.getEmpresa(),connexion);
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepSave(tipolistaprecio.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}


			if(clas.clas.equals(Cliente.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(Cliente cliente:tipolistaprecio.getClientes()) {
					ClienteLogic clienteLogic= new ClienteLogic(connexion);
					cliente.setid_tipo_lista_precio(tipolistaprecio.getId());
					ClienteDataAccess.save(cliente,connexion);
					clienteLogic.deepSave(cliente,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(ParametroCarteraDefecto.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(ParametroCarteraDefecto parametrocarteradefecto:tipolistaprecio.getParametroCarteraDefectos()) {
					ParametroCarteraDefectoLogic parametrocarteradefectoLogic= new ParametroCarteraDefectoLogic(connexion);
					parametrocarteradefecto.setid_tipo_lista_precio(tipolistaprecio.getId());
					ParametroCarteraDefectoDataAccess.save(parametrocarteradefecto,connexion);
					parametrocarteradefectoLogic.deepSave(parametrocarteradefecto,isDeep,deepLoadType,clases);
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
			this.getNewConnexionToDeep(TipoListaPrecio.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(tipolistaprecio,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				TipoListaPrecioConstantesFunciones.refrescarForeignKeysDescripcionesTipoListaPrecio(tipolistaprecio);
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
			this.deepLoad(this.tipolistaprecio,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				TipoListaPrecioConstantesFunciones.refrescarForeignKeysDescripcionesTipoListaPrecio(this.tipolistaprecio);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(TipoListaPrecio.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(tipolistaprecios!=null) {
				for(TipoListaPrecio tipolistaprecio:tipolistaprecios) {
					this.deepLoad(tipolistaprecio,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					TipoListaPrecioConstantesFunciones.refrescarForeignKeysDescripcionesTipoListaPrecio(tipolistaprecios);
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
			if(tipolistaprecios!=null) {
				for(TipoListaPrecio tipolistaprecio:tipolistaprecios) {
					this.deepLoad(tipolistaprecio,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					TipoListaPrecioConstantesFunciones.refrescarForeignKeysDescripcionesTipoListaPrecio(tipolistaprecios);
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
			this.getNewConnexionToDeep(TipoListaPrecio.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(tipolistaprecio,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(TipoListaPrecio.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(tipolistaprecios!=null) {
				for(TipoListaPrecio tipolistaprecio:tipolistaprecios) {
					this.deepSave(tipolistaprecio,isDeep,deepLoadType,clases);
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
			if(tipolistaprecios!=null) {
				for(TipoListaPrecio tipolistaprecio:tipolistaprecios) {
					this.deepSave(tipolistaprecio,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getTipoListaPreciosFK_IdEmpresaWithConnection(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoListaPrecio.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,TipoListaPrecioConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			TipoListaPrecioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			tipolistaprecios=tipolistaprecioDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TipoListaPrecioConstantesFunciones.refrescarForeignKeysDescripcionesTipoListaPrecio(this.tipolistaprecios);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getTipoListaPreciosFK_IdEmpresa(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,TipoListaPrecioConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			TipoListaPrecioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			tipolistaprecios=tipolistaprecioDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TipoListaPrecioConstantesFunciones.refrescarForeignKeysDescripcionesTipoListaPrecio(this.tipolistaprecios);
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
			if(TipoListaPrecioConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoListaPrecioDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,TipoListaPrecio tipolistaprecio,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(TipoListaPrecioConstantesFunciones.ISCONAUDITORIA) {
				if(tipolistaprecio.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoListaPrecioDataAccess.TABLENAME, tipolistaprecio.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(TipoListaPrecioConstantesFunciones.ISCONAUDITORIADETALLE) {
						////TipoListaPrecioLogic.registrarAuditoriaDetallesTipoListaPrecio(connexion,tipolistaprecio,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(tipolistaprecio.getIsDeleted()) {
					/*if(!tipolistaprecio.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,TipoListaPrecioDataAccess.TABLENAME, tipolistaprecio.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////TipoListaPrecioLogic.registrarAuditoriaDetallesTipoListaPrecio(connexion,tipolistaprecio,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoListaPrecioDataAccess.TABLENAME, tipolistaprecio.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(tipolistaprecio.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoListaPrecioDataAccess.TABLENAME, tipolistaprecio.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(TipoListaPrecioConstantesFunciones.ISCONAUDITORIADETALLE) {
						////TipoListaPrecioLogic.registrarAuditoriaDetallesTipoListaPrecio(connexion,tipolistaprecio,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesTipoListaPrecio(Connexion connexion,TipoListaPrecio tipolistaprecio)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(tipolistaprecio.getIsNew()||!tipolistaprecio.getid_empresa().equals(tipolistaprecio.getTipoListaPrecioOriginal().getid_empresa()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(tipolistaprecio.getTipoListaPrecioOriginal().getid_empresa()!=null)
				{
					strValorActual=tipolistaprecio.getTipoListaPrecioOriginal().getid_empresa().toString();
				}
				if(tipolistaprecio.getid_empresa()!=null)
				{
					strValorNuevo=tipolistaprecio.getid_empresa().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TipoListaPrecioConstantesFunciones.IDEMPRESA,strValorActual,strValorNuevo);
			}	
			
			if(tipolistaprecio.getIsNew()||!tipolistaprecio.getcodigo().equals(tipolistaprecio.getTipoListaPrecioOriginal().getcodigo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(tipolistaprecio.getTipoListaPrecioOriginal().getcodigo()!=null)
				{
					strValorActual=tipolistaprecio.getTipoListaPrecioOriginal().getcodigo();
				}
				if(tipolistaprecio.getcodigo()!=null)
				{
					strValorNuevo=tipolistaprecio.getcodigo() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TipoListaPrecioConstantesFunciones.CODIGO,strValorActual,strValorNuevo);
			}	
			
			if(tipolistaprecio.getIsNew()||!tipolistaprecio.getnombre().equals(tipolistaprecio.getTipoListaPrecioOriginal().getnombre()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(tipolistaprecio.getTipoListaPrecioOriginal().getnombre()!=null)
				{
					strValorActual=tipolistaprecio.getTipoListaPrecioOriginal().getnombre();
				}
				if(tipolistaprecio.getnombre()!=null)
				{
					strValorNuevo=tipolistaprecio.getnombre() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TipoListaPrecioConstantesFunciones.NOMBRE,strValorActual,strValorNuevo);
			}	
			
			if(tipolistaprecio.getIsNew()||!tipolistaprecio.getfecha_desde().equals(tipolistaprecio.getTipoListaPrecioOriginal().getfecha_desde()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(tipolistaprecio.getTipoListaPrecioOriginal().getfecha_desde()!=null)
				{
					strValorActual=tipolistaprecio.getTipoListaPrecioOriginal().getfecha_desde().toString();
				}
				if(tipolistaprecio.getfecha_desde()!=null)
				{
					strValorNuevo=tipolistaprecio.getfecha_desde().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TipoListaPrecioConstantesFunciones.FECHADESDE,strValorActual,strValorNuevo);
			}	
			
			if(tipolistaprecio.getIsNew()||!tipolistaprecio.getfecha_hasta().equals(tipolistaprecio.getTipoListaPrecioOriginal().getfecha_hasta()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(tipolistaprecio.getTipoListaPrecioOriginal().getfecha_hasta()!=null)
				{
					strValorActual=tipolistaprecio.getTipoListaPrecioOriginal().getfecha_hasta().toString();
				}
				if(tipolistaprecio.getfecha_hasta()!=null)
				{
					strValorNuevo=tipolistaprecio.getfecha_hasta().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TipoListaPrecioConstantesFunciones.FECHAHASTA,strValorActual,strValorNuevo);
			}	
			
			if(tipolistaprecio.getIsNew()||!tipolistaprecio.getesta_activo().equals(tipolistaprecio.getTipoListaPrecioOriginal().getesta_activo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(tipolistaprecio.getTipoListaPrecioOriginal().getesta_activo()!=null)
				{
					strValorActual=tipolistaprecio.getTipoListaPrecioOriginal().getesta_activo().toString();
				}
				if(tipolistaprecio.getesta_activo()!=null)
				{
					strValorNuevo=tipolistaprecio.getesta_activo().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TipoListaPrecioConstantesFunciones.ESTAACTIVO,strValorActual,strValorNuevo);
			}	
			
			if(tipolistaprecio.getIsNew()||!tipolistaprecio.getdescripcion().equals(tipolistaprecio.getTipoListaPrecioOriginal().getdescripcion()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(tipolistaprecio.getTipoListaPrecioOriginal().getdescripcion()!=null)
				{
					strValorActual=tipolistaprecio.getTipoListaPrecioOriginal().getdescripcion();
				}
				if(tipolistaprecio.getdescripcion()!=null)
				{
					strValorNuevo=tipolistaprecio.getdescripcion() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TipoListaPrecioConstantesFunciones.DESCRIPCION,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void saveTipoListaPrecioRelacionesWithConnection(TipoListaPrecio tipolistaprecio,List<Cliente> clientes,List<ParametroCarteraDefecto> parametrocarteradefectos) throws Exception {

		if(!tipolistaprecio.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveTipoListaPrecioRelacionesBase(tipolistaprecio,clientes,parametrocarteradefectos,true);
		}
	}

	public void saveTipoListaPrecioRelaciones(TipoListaPrecio tipolistaprecio,List<Cliente> clientes,List<ParametroCarteraDefecto> parametrocarteradefectos)throws Exception {

		if(!tipolistaprecio.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveTipoListaPrecioRelacionesBase(tipolistaprecio,clientes,parametrocarteradefectos,false);
		}
	}

	public void saveTipoListaPrecioRelacionesBase(TipoListaPrecio tipolistaprecio,List<Cliente> clientes,List<ParametroCarteraDefecto> parametrocarteradefectos,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("TipoListaPrecio-saveRelacionesWithConnection");}
	
			tipolistaprecio.setClientes(clientes);
			tipolistaprecio.setParametroCarteraDefectos(parametrocarteradefectos);

			this.setTipoListaPrecio(tipolistaprecio);

			if(TipoListaPrecioLogicAdditional.validarSaveRelaciones(tipolistaprecio,this)) {

				TipoListaPrecioLogicAdditional.updateRelacionesToSave(tipolistaprecio,this);

				if((tipolistaprecio.getIsNew()||tipolistaprecio.getIsChanged())&&!tipolistaprecio.getIsDeleted()) {
					this.saveTipoListaPrecio();
					this.saveTipoListaPrecioRelacionesDetalles(clientes,parametrocarteradefectos);

				} else if(tipolistaprecio.getIsDeleted()) {
					this.saveTipoListaPrecioRelacionesDetalles(clientes,parametrocarteradefectos);
					this.saveTipoListaPrecio();
				}

				TipoListaPrecioLogicAdditional.updateRelacionesToSaveAfter(tipolistaprecio,this);

			} else {
				throw new Exception("LOS DATOS SON INVALIDOS");
			}

			if(conConexion) {connexion.commit();}

		} catch(Exception e) {
			
			ClienteConstantesFunciones.InicializarGeneralEntityAuxiliaresClientes(clientes,true,true);
			ParametroCarteraDefectoConstantesFunciones.InicializarGeneralEntityAuxiliaresParametroCarteraDefectos(parametrocarteradefectos,true,true);

			if(conConexion){connexion.rollback();}
			Funciones.manageException(logger,e);
			throw e;

		} finally {
			if(conConexion){this.closeNewConnexionToDeep();}
		}
	}
	
	
	private void saveTipoListaPrecioRelacionesDetalles(List<Cliente> clientes,List<ParametroCarteraDefecto> parametrocarteradefectos)throws Exception {
		try {
	

			Long idTipoListaPrecioActual=this.getTipoListaPrecio().getId();

			ClienteLogic clienteLogic_Desde_TipoListaPrecio=new ClienteLogic();
			clienteLogic_Desde_TipoListaPrecio.setClientes(clientes);

			clienteLogic_Desde_TipoListaPrecio.setConnexion(this.getConnexion());
			clienteLogic_Desde_TipoListaPrecio.setDatosCliente(this.datosCliente);

			for(Cliente cliente_Desde_TipoListaPrecio:clienteLogic_Desde_TipoListaPrecio.getClientes()) {
				cliente_Desde_TipoListaPrecio.setid_tipo_lista_precio(idTipoListaPrecioActual);

				clienteLogic_Desde_TipoListaPrecio.setCliente(cliente_Desde_TipoListaPrecio);
				clienteLogic_Desde_TipoListaPrecio.saveCliente();
			}


			ParametroCarteraDefectoLogic parametrocarteradefectoLogic_Desde_TipoListaPrecio=new ParametroCarteraDefectoLogic();
			parametrocarteradefectoLogic_Desde_TipoListaPrecio.setParametroCarteraDefectos(parametrocarteradefectos);

			parametrocarteradefectoLogic_Desde_TipoListaPrecio.setConnexion(this.getConnexion());
			parametrocarteradefectoLogic_Desde_TipoListaPrecio.setDatosCliente(this.datosCliente);

			for(ParametroCarteraDefecto parametrocarteradefecto_Desde_TipoListaPrecio:parametrocarteradefectoLogic_Desde_TipoListaPrecio.getParametroCarteraDefectos()) {
				parametrocarteradefecto_Desde_TipoListaPrecio.setid_tipo_lista_precio(idTipoListaPrecioActual);
			}

			parametrocarteradefectoLogic_Desde_TipoListaPrecio.saveParametroCarteraDefectos();

		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfTipoListaPrecio(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=TipoListaPrecioConstantesFunciones.getClassesForeignKeysOfTipoListaPrecio(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfTipoListaPrecio(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=TipoListaPrecioConstantesFunciones.getClassesRelationshipsOfTipoListaPrecio(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}
