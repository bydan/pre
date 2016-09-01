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
import com.bydan.erp.facturacion.util.TipoParamFactuDescuentoConstantesFunciones;
import com.bydan.erp.facturacion.util.TipoParamFactuDescuentoParameterReturnGeneral;
//import com.bydan.erp.facturacion.util.TipoParamFactuDescuentoParameterGeneral;
import com.bydan.erp.facturacion.business.entity.TipoParamFactuDescuento;
import com.bydan.erp.facturacion.business.logic.TipoParamFactuDescuentoLogicAdditional;
import com.bydan.erp.facturacion.business.dataaccess.*;
import com.bydan.erp.facturacion.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;
















@SuppressWarnings("unused")
public class TipoParamFactuDescuentoLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(TipoParamFactuDescuentoLogic.class);
	
	protected TipoParamFactuDescuentoDataAccess tipoparamfactudescuentoDataAccess; 	
	protected TipoParamFactuDescuento tipoparamfactudescuento;
	protected List<TipoParamFactuDescuento> tipoparamfactudescuentos;
	protected Object tipoparamfactudescuentoObject;	
	protected List<Object> tipoparamfactudescuentosObject;
	
	public static ClassValidator<TipoParamFactuDescuento> tipoparamfactudescuentoValidator = new ClassValidator<TipoParamFactuDescuento>(TipoParamFactuDescuento.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected TipoParamFactuDescuentoLogicAdditional tipoparamfactudescuentoLogicAdditional=null;
	
	public TipoParamFactuDescuentoLogicAdditional getTipoParamFactuDescuentoLogicAdditional() {
		return this.tipoparamfactudescuentoLogicAdditional;
	}
	
	public void setTipoParamFactuDescuentoLogicAdditional(TipoParamFactuDescuentoLogicAdditional tipoparamfactudescuentoLogicAdditional) {
		try {
			this.tipoparamfactudescuentoLogicAdditional=tipoparamfactudescuentoLogicAdditional;
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
	
	
	
	
	public  TipoParamFactuDescuentoLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.tipoparamfactudescuentoDataAccess = new TipoParamFactuDescuentoDataAccess();
			
			this.tipoparamfactudescuentos= new ArrayList<TipoParamFactuDescuento>();
			this.tipoparamfactudescuento= new TipoParamFactuDescuento();
			
			this.tipoparamfactudescuentoObject=new Object();
			this.tipoparamfactudescuentosObject=new ArrayList<Object>();
				
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
			
			this.tipoparamfactudescuentoDataAccess.setConnexionType(this.connexionType);
			this.tipoparamfactudescuentoDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  TipoParamFactuDescuentoLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.tipoparamfactudescuentoDataAccess = new TipoParamFactuDescuentoDataAccess();
			this.tipoparamfactudescuentos= new ArrayList<TipoParamFactuDescuento>();
			this.tipoparamfactudescuento= new TipoParamFactuDescuento();
			this.tipoparamfactudescuentoObject=new Object();
			this.tipoparamfactudescuentosObject=new ArrayList<Object>();
			
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
			
			this.tipoparamfactudescuentoDataAccess.setConnexionType(this.connexionType);
			this.tipoparamfactudescuentoDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public TipoParamFactuDescuento getTipoParamFactuDescuento() throws Exception {	
		TipoParamFactuDescuentoLogicAdditional.checkTipoParamFactuDescuentoToGet(tipoparamfactudescuento,this.datosCliente,this.arrDatoGeneral);
		TipoParamFactuDescuentoLogicAdditional.updateTipoParamFactuDescuentoToGet(tipoparamfactudescuento,this.arrDatoGeneral);
		
		return tipoparamfactudescuento;
	}
		
	public void setTipoParamFactuDescuento(TipoParamFactuDescuento newTipoParamFactuDescuento) {
		this.tipoparamfactudescuento = newTipoParamFactuDescuento;
	}
	
	public TipoParamFactuDescuentoDataAccess getTipoParamFactuDescuentoDataAccess() {
		return tipoparamfactudescuentoDataAccess;
	}
	
	public void setTipoParamFactuDescuentoDataAccess(TipoParamFactuDescuentoDataAccess newtipoparamfactudescuentoDataAccess) {
		this.tipoparamfactudescuentoDataAccess = newtipoparamfactudescuentoDataAccess;
	}
	
	public List<TipoParamFactuDescuento> getTipoParamFactuDescuentos() throws Exception {		
		this.quitarTipoParamFactuDescuentosNulos();
		
		TipoParamFactuDescuentoLogicAdditional.checkTipoParamFactuDescuentoToGets(tipoparamfactudescuentos,this.datosCliente,this.arrDatoGeneral);
		
		for (TipoParamFactuDescuento tipoparamfactudescuentoLocal: tipoparamfactudescuentos ) {
			TipoParamFactuDescuentoLogicAdditional.updateTipoParamFactuDescuentoToGet(tipoparamfactudescuentoLocal,this.arrDatoGeneral);
		}
		
		return tipoparamfactudescuentos;
	}
	
	public void setTipoParamFactuDescuentos(List<TipoParamFactuDescuento> newTipoParamFactuDescuentos) {
		this.tipoparamfactudescuentos = newTipoParamFactuDescuentos;
	}
	
	public Object getTipoParamFactuDescuentoObject() {	
		this.tipoparamfactudescuentoObject=this.tipoparamfactudescuentoDataAccess.getEntityObject();
		return this.tipoparamfactudescuentoObject;
	}
		
	public void setTipoParamFactuDescuentoObject(Object newTipoParamFactuDescuentoObject) {
		this.tipoparamfactudescuentoObject = newTipoParamFactuDescuentoObject;
	}
	
	public List<Object> getTipoParamFactuDescuentosObject() {		
		this.tipoparamfactudescuentosObject=this.tipoparamfactudescuentoDataAccess.getEntitiesObject();
		return this.tipoparamfactudescuentosObject;
	}
		
	public void setTipoParamFactuDescuentosObject(List<Object> newTipoParamFactuDescuentosObject) {
		this.tipoparamfactudescuentosObject = newTipoParamFactuDescuentosObject;
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
		
		if(this.tipoparamfactudescuentoDataAccess!=null) {
			this.tipoparamfactudescuentoDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoParamFactuDescuento.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			tipoparamfactudescuentoDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			tipoparamfactudescuentoDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		tipoparamfactudescuento = new  TipoParamFactuDescuento();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoParamFactuDescuento.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			tipoparamfactudescuento=tipoparamfactudescuentoDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tipoparamfactudescuento,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoParamFactuDescuentoConstantesFunciones.refrescarForeignKeysDescripcionesTipoParamFactuDescuento(this.tipoparamfactudescuento);
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
		tipoparamfactudescuento = new  TipoParamFactuDescuento();
		  		  
        try {
			
			tipoparamfactudescuento=tipoparamfactudescuentoDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tipoparamfactudescuento,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoParamFactuDescuentoConstantesFunciones.refrescarForeignKeysDescripcionesTipoParamFactuDescuento(this.tipoparamfactudescuento);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		tipoparamfactudescuento = new  TipoParamFactuDescuento();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoParamFactuDescuento.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			tipoparamfactudescuento=tipoparamfactudescuentoDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tipoparamfactudescuento,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoParamFactuDescuentoConstantesFunciones.refrescarForeignKeysDescripcionesTipoParamFactuDescuento(this.tipoparamfactudescuento);
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
		tipoparamfactudescuento = new  TipoParamFactuDescuento();
		  		  
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
		tipoparamfactudescuento = new  TipoParamFactuDescuento();
		  		  
        try {
			
			tipoparamfactudescuento=tipoparamfactudescuentoDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tipoparamfactudescuento,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoParamFactuDescuentoConstantesFunciones.refrescarForeignKeysDescripcionesTipoParamFactuDescuento(this.tipoparamfactudescuento);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		tipoparamfactudescuento = new  TipoParamFactuDescuento();
		  		  
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
		tipoparamfactudescuento = new  TipoParamFactuDescuento();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoParamFactuDescuento.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =tipoparamfactudescuentoDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		tipoparamfactudescuento = new  TipoParamFactuDescuento();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=tipoparamfactudescuentoDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		tipoparamfactudescuento = new  TipoParamFactuDescuento();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoParamFactuDescuento.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =tipoparamfactudescuentoDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		tipoparamfactudescuento = new  TipoParamFactuDescuento();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=tipoparamfactudescuentoDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		tipoparamfactudescuento = new  TipoParamFactuDescuento();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoParamFactuDescuento.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =tipoparamfactudescuentoDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		tipoparamfactudescuento = new  TipoParamFactuDescuento();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=tipoparamfactudescuentoDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		tipoparamfactudescuentos = new  ArrayList<TipoParamFactuDescuento>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoParamFactuDescuento.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			TipoParamFactuDescuentoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoparamfactudescuentos=tipoparamfactudescuentoDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoParamFactuDescuento(tipoparamfactudescuentos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoParamFactuDescuentoConstantesFunciones.refrescarForeignKeysDescripcionesTipoParamFactuDescuento(this.tipoparamfactudescuentos);
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
		tipoparamfactudescuentos = new  ArrayList<TipoParamFactuDescuento>();
		  		  
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
		tipoparamfactudescuentos = new  ArrayList<TipoParamFactuDescuento>();
		  		  
        try {			
			TipoParamFactuDescuentoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoparamfactudescuentos=tipoparamfactudescuentoDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarTipoParamFactuDescuento(tipoparamfactudescuentos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoParamFactuDescuentoConstantesFunciones.refrescarForeignKeysDescripcionesTipoParamFactuDescuento(this.tipoparamfactudescuentos);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		tipoparamfactudescuentos = new  ArrayList<TipoParamFactuDescuento>();
		  		  
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
		tipoparamfactudescuentos = new  ArrayList<TipoParamFactuDescuento>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoParamFactuDescuento.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			TipoParamFactuDescuentoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoparamfactudescuentos=tipoparamfactudescuentoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoParamFactuDescuento(tipoparamfactudescuentos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoParamFactuDescuentoConstantesFunciones.refrescarForeignKeysDescripcionesTipoParamFactuDescuento(this.tipoparamfactudescuentos);
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
		tipoparamfactudescuentos = new  ArrayList<TipoParamFactuDescuento>();
		  		  
        try {
			TipoParamFactuDescuentoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoparamfactudescuentos=tipoparamfactudescuentoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoParamFactuDescuento(tipoparamfactudescuentos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoParamFactuDescuentoConstantesFunciones.refrescarForeignKeysDescripcionesTipoParamFactuDescuento(this.tipoparamfactudescuentos);
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
		tipoparamfactudescuentos = new  ArrayList<TipoParamFactuDescuento>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoParamFactuDescuento.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoParamFactuDescuentoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoparamfactudescuentos=tipoparamfactudescuentoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoParamFactuDescuento(tipoparamfactudescuentos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoParamFactuDescuentoConstantesFunciones.refrescarForeignKeysDescripcionesTipoParamFactuDescuento(this.tipoparamfactudescuentos);
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
		tipoparamfactudescuentos = new  ArrayList<TipoParamFactuDescuento>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoParamFactuDescuentoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoparamfactudescuentos=tipoparamfactudescuentoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoParamFactuDescuento(tipoparamfactudescuentos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoParamFactuDescuentoConstantesFunciones.refrescarForeignKeysDescripcionesTipoParamFactuDescuento(this.tipoparamfactudescuentos);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		tipoparamfactudescuento = new  TipoParamFactuDescuento();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoParamFactuDescuento.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoParamFactuDescuentoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoparamfactudescuento=tipoparamfactudescuentoDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoParamFactuDescuento(tipoparamfactudescuento);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoParamFactuDescuentoConstantesFunciones.refrescarForeignKeysDescripcionesTipoParamFactuDescuento(this.tipoparamfactudescuento);
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
		tipoparamfactudescuento = new  TipoParamFactuDescuento();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoParamFactuDescuentoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoparamfactudescuento=tipoparamfactudescuentoDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoParamFactuDescuento(tipoparamfactudescuento);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoParamFactuDescuentoConstantesFunciones.refrescarForeignKeysDescripcionesTipoParamFactuDescuento(this.tipoparamfactudescuento);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		tipoparamfactudescuentos = new  ArrayList<TipoParamFactuDescuento>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoParamFactuDescuento.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			TipoParamFactuDescuentoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoparamfactudescuentos=tipoparamfactudescuentoDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoParamFactuDescuento(tipoparamfactudescuentos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoParamFactuDescuentoConstantesFunciones.refrescarForeignKeysDescripcionesTipoParamFactuDescuento(this.tipoparamfactudescuentos);
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
		tipoparamfactudescuentos = new  ArrayList<TipoParamFactuDescuento>();
		  		  
        try {
			TipoParamFactuDescuentoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoparamfactudescuentos=tipoparamfactudescuentoDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoParamFactuDescuento(tipoparamfactudescuentos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoParamFactuDescuentoConstantesFunciones.refrescarForeignKeysDescripcionesTipoParamFactuDescuento(this.tipoparamfactudescuentos);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosTipoParamFactuDescuentosWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		tipoparamfactudescuentos = new  ArrayList<TipoParamFactuDescuento>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoParamFactuDescuento.class.getSimpleName()+"-getTodosTipoParamFactuDescuentosWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoParamFactuDescuentoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoparamfactudescuentos=tipoparamfactudescuentoDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarTipoParamFactuDescuento(tipoparamfactudescuentos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoParamFactuDescuentoConstantesFunciones.refrescarForeignKeysDescripcionesTipoParamFactuDescuento(this.tipoparamfactudescuentos);
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
	
	public  void  getTodosTipoParamFactuDescuentos(String sFinalQuery,Pagination pagination)throws Exception {
		tipoparamfactudescuentos = new  ArrayList<TipoParamFactuDescuento>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoParamFactuDescuentoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoparamfactudescuentos=tipoparamfactudescuentoDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarTipoParamFactuDescuento(tipoparamfactudescuentos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoParamFactuDescuentoConstantesFunciones.refrescarForeignKeysDescripcionesTipoParamFactuDescuento(this.tipoparamfactudescuentos);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarTipoParamFactuDescuento(TipoParamFactuDescuento tipoparamfactudescuento) throws Exception {
		Boolean estaValidado=false;
		
		if(tipoparamfactudescuento.getIsNew() || tipoparamfactudescuento.getIsChanged()) { 
			this.invalidValues = tipoparamfactudescuentoValidator.getInvalidValues(tipoparamfactudescuento);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(tipoparamfactudescuento);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarTipoParamFactuDescuento(List<TipoParamFactuDescuento> TipoParamFactuDescuentos) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(TipoParamFactuDescuento tipoparamfactudescuentoLocal:tipoparamfactudescuentos) {				
			estaValidadoObjeto=this.validarGuardarTipoParamFactuDescuento(tipoparamfactudescuentoLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarTipoParamFactuDescuento(List<TipoParamFactuDescuento> TipoParamFactuDescuentos) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarTipoParamFactuDescuento(tipoparamfactudescuentos)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarTipoParamFactuDescuento(TipoParamFactuDescuento TipoParamFactuDescuento) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarTipoParamFactuDescuento(tipoparamfactudescuento)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(TipoParamFactuDescuento tipoparamfactudescuento) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+tipoparamfactudescuento.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=TipoParamFactuDescuentoConstantesFunciones.getTipoParamFactuDescuentoLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"tipoparamfactudescuento","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(TipoParamFactuDescuentoConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(TipoParamFactuDescuentoConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveTipoParamFactuDescuentoWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoParamFactuDescuento.class.getSimpleName()+"-saveTipoParamFactuDescuentoWithConnection");connexion.begin();			
			
			TipoParamFactuDescuentoLogicAdditional.checkTipoParamFactuDescuentoToSave(this.tipoparamfactudescuento,this.datosCliente,connexion,this.arrDatoGeneral);
			
			TipoParamFactuDescuentoLogicAdditional.updateTipoParamFactuDescuentoToSave(this.tipoparamfactudescuento,this.arrDatoGeneral);
			
			TipoParamFactuDescuentoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.tipoparamfactudescuento,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowTipoParamFactuDescuento();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarTipoParamFactuDescuento(this.tipoparamfactudescuento)) {
				TipoParamFactuDescuentoDataAccess.save(this.tipoparamfactudescuento, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.tipoparamfactudescuento,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			TipoParamFactuDescuentoLogicAdditional.checkTipoParamFactuDescuentoToSaveAfter(this.tipoparamfactudescuento,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowTipoParamFactuDescuento();
			
			connexion.commit();			
			
			if(this.tipoparamfactudescuento.getIsDeleted()) {
				this.tipoparamfactudescuento=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveTipoParamFactuDescuento()throws Exception {	
		try {	
			
			TipoParamFactuDescuentoLogicAdditional.checkTipoParamFactuDescuentoToSave(this.tipoparamfactudescuento,this.datosCliente,connexion,this.arrDatoGeneral);
			
			TipoParamFactuDescuentoLogicAdditional.updateTipoParamFactuDescuentoToSave(this.tipoparamfactudescuento,this.arrDatoGeneral);
			
			TipoParamFactuDescuentoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.tipoparamfactudescuento,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarTipoParamFactuDescuento(this.tipoparamfactudescuento)) {			
				TipoParamFactuDescuentoDataAccess.save(this.tipoparamfactudescuento, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.tipoparamfactudescuento,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			TipoParamFactuDescuentoLogicAdditional.checkTipoParamFactuDescuentoToSaveAfter(this.tipoparamfactudescuento,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.tipoparamfactudescuento.getIsDeleted()) {
				this.tipoparamfactudescuento=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveTipoParamFactuDescuentosWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoParamFactuDescuento.class.getSimpleName()+"-saveTipoParamFactuDescuentosWithConnection");connexion.begin();			
			
			TipoParamFactuDescuentoLogicAdditional.checkTipoParamFactuDescuentoToSaves(tipoparamfactudescuentos,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowTipoParamFactuDescuentos();
			
			Boolean validadoTodosTipoParamFactuDescuento=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(TipoParamFactuDescuento tipoparamfactudescuentoLocal:tipoparamfactudescuentos) {		
				if(tipoparamfactudescuentoLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				TipoParamFactuDescuentoLogicAdditional.updateTipoParamFactuDescuentoToSave(tipoparamfactudescuentoLocal,this.arrDatoGeneral);
	        	
				TipoParamFactuDescuentoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),tipoparamfactudescuentoLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarTipoParamFactuDescuento(tipoparamfactudescuentoLocal)) {
					TipoParamFactuDescuentoDataAccess.save(tipoparamfactudescuentoLocal, connexion);				
				} else {
					validadoTodosTipoParamFactuDescuento=false;
				}
			}
			
			if(!validadoTodosTipoParamFactuDescuento) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			TipoParamFactuDescuentoLogicAdditional.checkTipoParamFactuDescuentoToSavesAfter(tipoparamfactudescuentos,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowTipoParamFactuDescuentos();
			
			connexion.commit();		
			
			this.quitarTipoParamFactuDescuentosEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveTipoParamFactuDescuentos()throws Exception {				
		 try {	
			TipoParamFactuDescuentoLogicAdditional.checkTipoParamFactuDescuentoToSaves(tipoparamfactudescuentos,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosTipoParamFactuDescuento=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(TipoParamFactuDescuento tipoparamfactudescuentoLocal:tipoparamfactudescuentos) {				
				if(tipoparamfactudescuentoLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				TipoParamFactuDescuentoLogicAdditional.updateTipoParamFactuDescuentoToSave(tipoparamfactudescuentoLocal,this.arrDatoGeneral);
	        	
				TipoParamFactuDescuentoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),tipoparamfactudescuentoLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarTipoParamFactuDescuento(tipoparamfactudescuentoLocal)) {				
					TipoParamFactuDescuentoDataAccess.save(tipoparamfactudescuentoLocal, connexion);				
				} else {
					validadoTodosTipoParamFactuDescuento=false;
				}
			}
			
			if(!validadoTodosTipoParamFactuDescuento) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			TipoParamFactuDescuentoLogicAdditional.checkTipoParamFactuDescuentoToSavesAfter(tipoparamfactudescuentos,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarTipoParamFactuDescuentosEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public TipoParamFactuDescuentoParameterReturnGeneral procesarAccionTipoParamFactuDescuentos(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<TipoParamFactuDescuento> tipoparamfactudescuentos,TipoParamFactuDescuentoParameterReturnGeneral tipoparamfactudescuentoParameterGeneral)throws Exception {
		 try {	
			TipoParamFactuDescuentoParameterReturnGeneral tipoparamfactudescuentoReturnGeneral=new TipoParamFactuDescuentoParameterReturnGeneral();
	
			TipoParamFactuDescuentoLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,tipoparamfactudescuentos,tipoparamfactudescuentoParameterGeneral,tipoparamfactudescuentoReturnGeneral);
			
			return tipoparamfactudescuentoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public TipoParamFactuDescuentoParameterReturnGeneral procesarAccionTipoParamFactuDescuentosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<TipoParamFactuDescuento> tipoparamfactudescuentos,TipoParamFactuDescuentoParameterReturnGeneral tipoparamfactudescuentoParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoParamFactuDescuento.class.getSimpleName()+"-procesarAccionTipoParamFactuDescuentosWithConnection");connexion.begin();			
			
			TipoParamFactuDescuentoParameterReturnGeneral tipoparamfactudescuentoReturnGeneral=new TipoParamFactuDescuentoParameterReturnGeneral();
	
			TipoParamFactuDescuentoLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,tipoparamfactudescuentos,tipoparamfactudescuentoParameterGeneral,tipoparamfactudescuentoReturnGeneral);
			
			this.connexion.commit();
			
			return tipoparamfactudescuentoReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public TipoParamFactuDescuentoParameterReturnGeneral procesarEventosTipoParamFactuDescuentos(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<TipoParamFactuDescuento> tipoparamfactudescuentos,TipoParamFactuDescuento tipoparamfactudescuento,TipoParamFactuDescuentoParameterReturnGeneral tipoparamfactudescuentoParameterGeneral,Boolean isEsNuevoTipoParamFactuDescuento,ArrayList<Classe> clases)throws Exception {
		 try {	
			TipoParamFactuDescuentoParameterReturnGeneral tipoparamfactudescuentoReturnGeneral=new TipoParamFactuDescuentoParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				tipoparamfactudescuentoReturnGeneral.setConRecargarPropiedades(true);
			}
			
			TipoParamFactuDescuentoLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,tipoparamfactudescuentos,tipoparamfactudescuento,tipoparamfactudescuentoParameterGeneral,tipoparamfactudescuentoReturnGeneral,isEsNuevoTipoParamFactuDescuento,clases);
			
			return tipoparamfactudescuentoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public TipoParamFactuDescuentoParameterReturnGeneral procesarEventosTipoParamFactuDescuentosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<TipoParamFactuDescuento> tipoparamfactudescuentos,TipoParamFactuDescuento tipoparamfactudescuento,TipoParamFactuDescuentoParameterReturnGeneral tipoparamfactudescuentoParameterGeneral,Boolean isEsNuevoTipoParamFactuDescuento,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoParamFactuDescuento.class.getSimpleName()+"-procesarEventosTipoParamFactuDescuentosWithConnection");connexion.begin();			
			
			TipoParamFactuDescuentoParameterReturnGeneral tipoparamfactudescuentoReturnGeneral=new TipoParamFactuDescuentoParameterReturnGeneral();
	
			tipoparamfactudescuentoReturnGeneral.setTipoParamFactuDescuento(tipoparamfactudescuento);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				tipoparamfactudescuentoReturnGeneral.setConRecargarPropiedades(true);
			}
			
			TipoParamFactuDescuentoLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,tipoparamfactudescuentos,tipoparamfactudescuento,tipoparamfactudescuentoParameterGeneral,tipoparamfactudescuentoReturnGeneral,isEsNuevoTipoParamFactuDescuento,clases);
			
			this.connexion.commit();
			
			return tipoparamfactudescuentoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public TipoParamFactuDescuentoParameterReturnGeneral procesarImportacionTipoParamFactuDescuentosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,TipoParamFactuDescuentoParameterReturnGeneral tipoparamfactudescuentoParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoParamFactuDescuento.class.getSimpleName()+"-procesarImportacionTipoParamFactuDescuentosWithConnection");connexion.begin();			
			
			TipoParamFactuDescuentoParameterReturnGeneral tipoparamfactudescuentoReturnGeneral=new TipoParamFactuDescuentoParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.tipoparamfactudescuentos=new ArrayList<TipoParamFactuDescuento>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.tipoparamfactudescuento=new TipoParamFactuDescuento();
				
				
				if(conColumnasBase) {this.tipoparamfactudescuento.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.tipoparamfactudescuento.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.tipoparamfactudescuento.setnombre(arrColumnas[iColumn++]);
				
				this.tipoparamfactudescuentos.add(this.tipoparamfactudescuento);
			}
			
			this.saveTipoParamFactuDescuentos();
			
			this.connexion.commit();
			
			tipoparamfactudescuentoReturnGeneral.setConRetornoEstaProcesado(true);
			tipoparamfactudescuentoReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return tipoparamfactudescuentoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarTipoParamFactuDescuentosEliminados() throws Exception {				
		
		List<TipoParamFactuDescuento> tipoparamfactudescuentosAux= new ArrayList<TipoParamFactuDescuento>();
		
		for(TipoParamFactuDescuento tipoparamfactudescuento:tipoparamfactudescuentos) {
			if(!tipoparamfactudescuento.getIsDeleted()) {
				tipoparamfactudescuentosAux.add(tipoparamfactudescuento);
			}
		}
		
		tipoparamfactudescuentos=tipoparamfactudescuentosAux;
	}
	
	public void quitarTipoParamFactuDescuentosNulos() throws Exception {				
		
		List<TipoParamFactuDescuento> tipoparamfactudescuentosAux= new ArrayList<TipoParamFactuDescuento>();
		
		for(TipoParamFactuDescuento tipoparamfactudescuento : this.tipoparamfactudescuentos) {
			if(tipoparamfactudescuento==null) {
				tipoparamfactudescuentosAux.add(tipoparamfactudescuento);
			}
		}
		
		//this.tipoparamfactudescuentos=tipoparamfactudescuentosAux;
		
		this.tipoparamfactudescuentos.removeAll(tipoparamfactudescuentosAux);
	}
	
	public void getSetVersionRowTipoParamFactuDescuentoWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(tipoparamfactudescuento.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((tipoparamfactudescuento.getIsDeleted() || (tipoparamfactudescuento.getIsChanged()&&!tipoparamfactudescuento.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=tipoparamfactudescuentoDataAccess.getSetVersionRowTipoParamFactuDescuento(connexion,tipoparamfactudescuento.getId());
				
				if(!tipoparamfactudescuento.getVersionRow().equals(timestamp)) {	
					tipoparamfactudescuento.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				tipoparamfactudescuento.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowTipoParamFactuDescuento()throws Exception {	
		
		if(tipoparamfactudescuento.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((tipoparamfactudescuento.getIsDeleted() || (tipoparamfactudescuento.getIsChanged()&&!tipoparamfactudescuento.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=tipoparamfactudescuentoDataAccess.getSetVersionRowTipoParamFactuDescuento(connexion,tipoparamfactudescuento.getId());
			
			try {							
				if(!tipoparamfactudescuento.getVersionRow().equals(timestamp)) {	
					tipoparamfactudescuento.setVersionRow(timestamp);
				}
				
				tipoparamfactudescuento.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowTipoParamFactuDescuentosWithConnection()throws Exception {	
		if(tipoparamfactudescuentos!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(TipoParamFactuDescuento tipoparamfactudescuentoAux:tipoparamfactudescuentos) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(tipoparamfactudescuentoAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(tipoparamfactudescuentoAux.getIsDeleted() || (tipoparamfactudescuentoAux.getIsChanged()&&!tipoparamfactudescuentoAux.getIsNew())) {
						
						timestamp=tipoparamfactudescuentoDataAccess.getSetVersionRowTipoParamFactuDescuento(connexion,tipoparamfactudescuentoAux.getId());
						
						if(!tipoparamfactudescuento.getVersionRow().equals(timestamp)) {	
							tipoparamfactudescuentoAux.setVersionRow(timestamp);
						}
								
						tipoparamfactudescuentoAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowTipoParamFactuDescuentos()throws Exception {	
		if(tipoparamfactudescuentos!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(TipoParamFactuDescuento tipoparamfactudescuentoAux:tipoparamfactudescuentos) {
					if(tipoparamfactudescuentoAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(tipoparamfactudescuentoAux.getIsDeleted() || (tipoparamfactudescuentoAux.getIsChanged()&&!tipoparamfactudescuentoAux.getIsNew())) {
						
						timestamp=tipoparamfactudescuentoDataAccess.getSetVersionRowTipoParamFactuDescuento(connexion,tipoparamfactudescuentoAux.getId());
						
						if(!tipoparamfactudescuentoAux.getVersionRow().equals(timestamp)) {	
							tipoparamfactudescuentoAux.setVersionRow(timestamp);
						}
						
													
						tipoparamfactudescuentoAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	
	
	public void deepLoad(TipoParamFactuDescuento tipoparamfactudescuento,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			TipoParamFactuDescuentoLogicAdditional.updateTipoParamFactuDescuentoToGet(tipoparamfactudescuento,this.arrDatoGeneral);
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(TipoParamFactuDescuento tipoparamfactudescuento,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			TipoParamFactuDescuentoLogicAdditional.updateTipoParamFactuDescuentoToSave(tipoparamfactudescuento,this.arrDatoGeneral);
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}	
	}
	
	public void deepLoadWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(TipoParamFactuDescuento.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(tipoparamfactudescuento,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				TipoParamFactuDescuentoConstantesFunciones.refrescarForeignKeysDescripcionesTipoParamFactuDescuento(tipoparamfactudescuento);
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
			this.deepLoad(this.tipoparamfactudescuento,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				TipoParamFactuDescuentoConstantesFunciones.refrescarForeignKeysDescripcionesTipoParamFactuDescuento(this.tipoparamfactudescuento);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(TipoParamFactuDescuento.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(tipoparamfactudescuentos!=null) {
				for(TipoParamFactuDescuento tipoparamfactudescuento:tipoparamfactudescuentos) {
					this.deepLoad(tipoparamfactudescuento,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					TipoParamFactuDescuentoConstantesFunciones.refrescarForeignKeysDescripcionesTipoParamFactuDescuento(tipoparamfactudescuentos);
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
			if(tipoparamfactudescuentos!=null) {
				for(TipoParamFactuDescuento tipoparamfactudescuento:tipoparamfactudescuentos) {
					this.deepLoad(tipoparamfactudescuento,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					TipoParamFactuDescuentoConstantesFunciones.refrescarForeignKeysDescripcionesTipoParamFactuDescuento(tipoparamfactudescuentos);
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
			this.getNewConnexionToDeep(TipoParamFactuDescuento.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(tipoparamfactudescuento,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(TipoParamFactuDescuento.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(tipoparamfactudescuentos!=null) {
				for(TipoParamFactuDescuento tipoparamfactudescuento:tipoparamfactudescuentos) {
					this.deepSave(tipoparamfactudescuento,isDeep,deepLoadType,clases);
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
			if(tipoparamfactudescuentos!=null) {
				for(TipoParamFactuDescuento tipoparamfactudescuento:tipoparamfactudescuentos) {
					this.deepSave(tipoparamfactudescuento,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getTipoParamFactuDescuentosBusquedaPorNombreWithConnection(String sFinalQuery,Pagination pagination,String nombre)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoParamFactuDescuento.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralNombre= new ParameterSelectionGeneral();
			parameterSelectionGeneralNombre.setParameterSelectionGeneralLike(ParameterType.STRING,"%"+nombre+"%",TipoParamFactuDescuentoConstantesFunciones.NOMBRE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralNombre);

			TipoParamFactuDescuentoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorNombre","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			tipoparamfactudescuentos=tipoparamfactudescuentoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TipoParamFactuDescuentoConstantesFunciones.refrescarForeignKeysDescripcionesTipoParamFactuDescuento(this.tipoparamfactudescuentos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getTipoParamFactuDescuentosBusquedaPorNombre(String sFinalQuery,Pagination pagination,String nombre)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralNombre= new ParameterSelectionGeneral();
			parameterSelectionGeneralNombre.setParameterSelectionGeneralLike(ParameterType.STRING,"%"+nombre+"%",TipoParamFactuDescuentoConstantesFunciones.NOMBRE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralNombre);

			TipoParamFactuDescuentoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorNombre","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			tipoparamfactudescuentos=tipoparamfactudescuentoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TipoParamFactuDescuentoConstantesFunciones.refrescarForeignKeysDescripcionesTipoParamFactuDescuento(this.tipoparamfactudescuentos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getTipoParamFactuDescuentoPorNombreWithConnection(String nombre)throws Exception {
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoParamFactuDescuento.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			ParameterSelectionGeneral parameterSelectionGeneralNombre= new ParameterSelectionGeneral();
			parameterSelectionGeneralNombre.setParameterSelectionGeneralEqual(ParameterType.STRING,nombre,TipoParamFactuDescuentoConstantesFunciones.NOMBRE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralNombre);

			tipoparamfactudescuento=tipoparamfactudescuentoDataAccess.getEntity(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoad(this.tipoparamfactudescuento,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());

				TipoParamFactuDescuentoConstantesFunciones.refrescarForeignKeysDescripcionesTipoParamFactuDescuento(this.tipoparamfactudescuento);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getTipoParamFactuDescuentoPorNombre(String nombre)throws Exception {
		try {

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			ParameterSelectionGeneral parameterSelectionGeneralNombre= new ParameterSelectionGeneral();
			parameterSelectionGeneralNombre.setParameterSelectionGeneralEqual(ParameterType.STRING,nombre,TipoParamFactuDescuentoConstantesFunciones.NOMBRE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralNombre);

			tipoparamfactudescuento=tipoparamfactudescuentoDataAccess.getEntity(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoad(this.tipoparamfactudescuento,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());

				TipoParamFactuDescuentoConstantesFunciones.refrescarForeignKeysDescripcionesTipoParamFactuDescuento(this.tipoparamfactudescuento);
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
			if(TipoParamFactuDescuentoConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoParamFactuDescuentoDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,TipoParamFactuDescuento tipoparamfactudescuento,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(TipoParamFactuDescuentoConstantesFunciones.ISCONAUDITORIA) {
				if(tipoparamfactudescuento.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoParamFactuDescuentoDataAccess.TABLENAME, tipoparamfactudescuento.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(TipoParamFactuDescuentoConstantesFunciones.ISCONAUDITORIADETALLE) {
						////TipoParamFactuDescuentoLogic.registrarAuditoriaDetallesTipoParamFactuDescuento(connexion,tipoparamfactudescuento,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(tipoparamfactudescuento.getIsDeleted()) {
					/*if(!tipoparamfactudescuento.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,TipoParamFactuDescuentoDataAccess.TABLENAME, tipoparamfactudescuento.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////TipoParamFactuDescuentoLogic.registrarAuditoriaDetallesTipoParamFactuDescuento(connexion,tipoparamfactudescuento,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoParamFactuDescuentoDataAccess.TABLENAME, tipoparamfactudescuento.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(tipoparamfactudescuento.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoParamFactuDescuentoDataAccess.TABLENAME, tipoparamfactudescuento.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(TipoParamFactuDescuentoConstantesFunciones.ISCONAUDITORIADETALLE) {
						////TipoParamFactuDescuentoLogic.registrarAuditoriaDetallesTipoParamFactuDescuento(connexion,tipoparamfactudescuento,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesTipoParamFactuDescuento(Connexion connexion,TipoParamFactuDescuento tipoparamfactudescuento)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(tipoparamfactudescuento.getIsNew()||!tipoparamfactudescuento.getnombre().equals(tipoparamfactudescuento.getTipoParamFactuDescuentoOriginal().getnombre()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(tipoparamfactudescuento.getTipoParamFactuDescuentoOriginal().getnombre()!=null)
				{
					strValorActual=tipoparamfactudescuento.getTipoParamFactuDescuentoOriginal().getnombre();
				}
				if(tipoparamfactudescuento.getnombre()!=null)
				{
					strValorNuevo=tipoparamfactudescuento.getnombre() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TipoParamFactuDescuentoConstantesFunciones.NOMBRE,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void saveTipoParamFactuDescuentoRelacionesWithConnection(TipoParamFactuDescuento tipoparamfactudescuento) throws Exception {

		if(!tipoparamfactudescuento.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveTipoParamFactuDescuentoRelacionesBase(tipoparamfactudescuento,true);
		}
	}

	public void saveTipoParamFactuDescuentoRelaciones(TipoParamFactuDescuento tipoparamfactudescuento)throws Exception {

		if(!tipoparamfactudescuento.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveTipoParamFactuDescuentoRelacionesBase(tipoparamfactudescuento,false);
		}
	}

	public void saveTipoParamFactuDescuentoRelacionesBase(TipoParamFactuDescuento tipoparamfactudescuento,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("TipoParamFactuDescuento-saveRelacionesWithConnection");}
	

			this.setTipoParamFactuDescuento(tipoparamfactudescuento);

				if((tipoparamfactudescuento.getIsNew()||tipoparamfactudescuento.getIsChanged())&&!tipoparamfactudescuento.getIsDeleted()) {
					this.saveTipoParamFactuDescuento();
					this.saveTipoParamFactuDescuentoRelacionesDetalles();

				} else if(tipoparamfactudescuento.getIsDeleted()) {
					this.saveTipoParamFactuDescuentoRelacionesDetalles();
					this.saveTipoParamFactuDescuento();
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
	
	
	private void saveTipoParamFactuDescuentoRelacionesDetalles()throws Exception {
		try {
	

		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfTipoParamFactuDescuento(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=TipoParamFactuDescuentoConstantesFunciones.getClassesForeignKeysOfTipoParamFactuDescuento(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfTipoParamFactuDescuento(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=TipoParamFactuDescuentoConstantesFunciones.getClassesRelationshipsOfTipoParamFactuDescuento(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}
