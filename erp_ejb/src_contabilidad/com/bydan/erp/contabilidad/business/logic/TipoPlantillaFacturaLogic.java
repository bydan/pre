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
package com.bydan.erp.contabilidad.business.logic;

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
import com.bydan.erp.contabilidad.util.*;
import com.bydan.erp.contabilidad.util.TipoPlantillaFacturaConstantesFunciones;
import com.bydan.erp.contabilidad.util.TipoPlantillaFacturaParameterReturnGeneral;
//import com.bydan.erp.contabilidad.util.TipoPlantillaFacturaParameterGeneral;
import com.bydan.erp.contabilidad.business.entity.TipoPlantillaFactura;
//import com.bydan.erp.contabilidad.business.logic.TipoPlantillaFacturaLogicAdditional;
import com.bydan.erp.contabilidad.business.dataaccess.*;
import com.bydan.erp.contabilidad.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.logic.*;


import com.bydan.erp.seguridad.util.*;


import com.bydan.erp.seguridad.business.dataaccess.*;








@SuppressWarnings("unused")
public class TipoPlantillaFacturaLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(TipoPlantillaFacturaLogic.class);
	
	protected TipoPlantillaFacturaDataAccess tipoplantillafacturaDataAccess; 	
	protected TipoPlantillaFactura tipoplantillafactura;
	protected List<TipoPlantillaFactura> tipoplantillafacturas;
	protected Object tipoplantillafacturaObject;	
	protected List<Object> tipoplantillafacturasObject;
	
	public static ClassValidator<TipoPlantillaFactura> tipoplantillafacturaValidator = new ClassValidator<TipoPlantillaFactura>(TipoPlantillaFactura.class);	
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
	
	
	
	
	public  TipoPlantillaFacturaLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.tipoplantillafacturaDataAccess = new TipoPlantillaFacturaDataAccess();
			
			this.tipoplantillafacturas= new ArrayList<TipoPlantillaFactura>();
			this.tipoplantillafactura= new TipoPlantillaFactura();
			
			this.tipoplantillafacturaObject=new Object();
			this.tipoplantillafacturasObject=new ArrayList<Object>();
				
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
			
			this.tipoplantillafacturaDataAccess.setConnexionType(this.connexionType);
			this.tipoplantillafacturaDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  TipoPlantillaFacturaLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.tipoplantillafacturaDataAccess = new TipoPlantillaFacturaDataAccess();
			this.tipoplantillafacturas= new ArrayList<TipoPlantillaFactura>();
			this.tipoplantillafactura= new TipoPlantillaFactura();
			this.tipoplantillafacturaObject=new Object();
			this.tipoplantillafacturasObject=new ArrayList<Object>();
			
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
			
			this.tipoplantillafacturaDataAccess.setConnexionType(this.connexionType);
			this.tipoplantillafacturaDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public TipoPlantillaFactura getTipoPlantillaFactura() throws Exception {	
		//TipoPlantillaFacturaLogicAdditional.checkTipoPlantillaFacturaToGet(tipoplantillafactura,this.datosCliente,this.arrDatoGeneral);
		//TipoPlantillaFacturaLogicAdditional.updateTipoPlantillaFacturaToGet(tipoplantillafactura,this.arrDatoGeneral);
		
		return tipoplantillafactura;
	}
		
	public void setTipoPlantillaFactura(TipoPlantillaFactura newTipoPlantillaFactura) {
		this.tipoplantillafactura = newTipoPlantillaFactura;
	}
	
	public TipoPlantillaFacturaDataAccess getTipoPlantillaFacturaDataAccess() {
		return tipoplantillafacturaDataAccess;
	}
	
	public void setTipoPlantillaFacturaDataAccess(TipoPlantillaFacturaDataAccess newtipoplantillafacturaDataAccess) {
		this.tipoplantillafacturaDataAccess = newtipoplantillafacturaDataAccess;
	}
	
	public List<TipoPlantillaFactura> getTipoPlantillaFacturas() throws Exception {		
		this.quitarTipoPlantillaFacturasNulos();
		
		//TipoPlantillaFacturaLogicAdditional.checkTipoPlantillaFacturaToGets(tipoplantillafacturas,this.datosCliente,this.arrDatoGeneral);
		
		for (TipoPlantillaFactura tipoplantillafacturaLocal: tipoplantillafacturas ) {
			//TipoPlantillaFacturaLogicAdditional.updateTipoPlantillaFacturaToGet(tipoplantillafacturaLocal,this.arrDatoGeneral);
		}
		
		return tipoplantillafacturas;
	}
	
	public void setTipoPlantillaFacturas(List<TipoPlantillaFactura> newTipoPlantillaFacturas) {
		this.tipoplantillafacturas = newTipoPlantillaFacturas;
	}
	
	public Object getTipoPlantillaFacturaObject() {	
		this.tipoplantillafacturaObject=this.tipoplantillafacturaDataAccess.getEntityObject();
		return this.tipoplantillafacturaObject;
	}
		
	public void setTipoPlantillaFacturaObject(Object newTipoPlantillaFacturaObject) {
		this.tipoplantillafacturaObject = newTipoPlantillaFacturaObject;
	}
	
	public List<Object> getTipoPlantillaFacturasObject() {		
		this.tipoplantillafacturasObject=this.tipoplantillafacturaDataAccess.getEntitiesObject();
		return this.tipoplantillafacturasObject;
	}
		
	public void setTipoPlantillaFacturasObject(List<Object> newTipoPlantillaFacturasObject) {
		this.tipoplantillafacturasObject = newTipoPlantillaFacturasObject;
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
		
		if(this.tipoplantillafacturaDataAccess!=null) {
			this.tipoplantillafacturaDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoPlantillaFactura.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			tipoplantillafacturaDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			tipoplantillafacturaDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		tipoplantillafactura = new  TipoPlantillaFactura();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoPlantillaFactura.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			tipoplantillafactura=tipoplantillafacturaDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tipoplantillafactura,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoPlantillaFacturaConstantesFunciones.refrescarForeignKeysDescripcionesTipoPlantillaFactura(this.tipoplantillafactura);
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
		tipoplantillafactura = new  TipoPlantillaFactura();
		  		  
        try {
			
			tipoplantillafactura=tipoplantillafacturaDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tipoplantillafactura,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoPlantillaFacturaConstantesFunciones.refrescarForeignKeysDescripcionesTipoPlantillaFactura(this.tipoplantillafactura);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		tipoplantillafactura = new  TipoPlantillaFactura();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoPlantillaFactura.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			tipoplantillafactura=tipoplantillafacturaDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tipoplantillafactura,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoPlantillaFacturaConstantesFunciones.refrescarForeignKeysDescripcionesTipoPlantillaFactura(this.tipoplantillafactura);
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
		tipoplantillafactura = new  TipoPlantillaFactura();
		  		  
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
		tipoplantillafactura = new  TipoPlantillaFactura();
		  		  
        try {
			
			tipoplantillafactura=tipoplantillafacturaDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tipoplantillafactura,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoPlantillaFacturaConstantesFunciones.refrescarForeignKeysDescripcionesTipoPlantillaFactura(this.tipoplantillafactura);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		tipoplantillafactura = new  TipoPlantillaFactura();
		  		  
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
		tipoplantillafactura = new  TipoPlantillaFactura();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoPlantillaFactura.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =tipoplantillafacturaDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		tipoplantillafactura = new  TipoPlantillaFactura();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=tipoplantillafacturaDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		tipoplantillafactura = new  TipoPlantillaFactura();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoPlantillaFactura.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =tipoplantillafacturaDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		tipoplantillafactura = new  TipoPlantillaFactura();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=tipoplantillafacturaDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		tipoplantillafactura = new  TipoPlantillaFactura();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoPlantillaFactura.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =tipoplantillafacturaDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		tipoplantillafactura = new  TipoPlantillaFactura();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=tipoplantillafacturaDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		tipoplantillafacturas = new  ArrayList<TipoPlantillaFactura>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoPlantillaFactura.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			TipoPlantillaFacturaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoplantillafacturas=tipoplantillafacturaDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoPlantillaFactura(tipoplantillafacturas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoPlantillaFacturaConstantesFunciones.refrescarForeignKeysDescripcionesTipoPlantillaFactura(this.tipoplantillafacturas);
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
		tipoplantillafacturas = new  ArrayList<TipoPlantillaFactura>();
		  		  
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
		tipoplantillafacturas = new  ArrayList<TipoPlantillaFactura>();
		  		  
        try {			
			TipoPlantillaFacturaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoplantillafacturas=tipoplantillafacturaDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarTipoPlantillaFactura(tipoplantillafacturas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoPlantillaFacturaConstantesFunciones.refrescarForeignKeysDescripcionesTipoPlantillaFactura(this.tipoplantillafacturas);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		tipoplantillafacturas = new  ArrayList<TipoPlantillaFactura>();
		  		  
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
		tipoplantillafacturas = new  ArrayList<TipoPlantillaFactura>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoPlantillaFactura.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			TipoPlantillaFacturaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoplantillafacturas=tipoplantillafacturaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoPlantillaFactura(tipoplantillafacturas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoPlantillaFacturaConstantesFunciones.refrescarForeignKeysDescripcionesTipoPlantillaFactura(this.tipoplantillafacturas);
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
		tipoplantillafacturas = new  ArrayList<TipoPlantillaFactura>();
		  		  
        try {
			TipoPlantillaFacturaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoplantillafacturas=tipoplantillafacturaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoPlantillaFactura(tipoplantillafacturas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoPlantillaFacturaConstantesFunciones.refrescarForeignKeysDescripcionesTipoPlantillaFactura(this.tipoplantillafacturas);
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
		tipoplantillafacturas = new  ArrayList<TipoPlantillaFactura>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoPlantillaFactura.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoPlantillaFacturaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoplantillafacturas=tipoplantillafacturaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoPlantillaFactura(tipoplantillafacturas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoPlantillaFacturaConstantesFunciones.refrescarForeignKeysDescripcionesTipoPlantillaFactura(this.tipoplantillafacturas);
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
		tipoplantillafacturas = new  ArrayList<TipoPlantillaFactura>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoPlantillaFacturaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoplantillafacturas=tipoplantillafacturaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoPlantillaFactura(tipoplantillafacturas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoPlantillaFacturaConstantesFunciones.refrescarForeignKeysDescripcionesTipoPlantillaFactura(this.tipoplantillafacturas);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		tipoplantillafactura = new  TipoPlantillaFactura();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoPlantillaFactura.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoPlantillaFacturaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoplantillafactura=tipoplantillafacturaDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoPlantillaFactura(tipoplantillafactura);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoPlantillaFacturaConstantesFunciones.refrescarForeignKeysDescripcionesTipoPlantillaFactura(this.tipoplantillafactura);
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
		tipoplantillafactura = new  TipoPlantillaFactura();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoPlantillaFacturaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoplantillafactura=tipoplantillafacturaDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoPlantillaFactura(tipoplantillafactura);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoPlantillaFacturaConstantesFunciones.refrescarForeignKeysDescripcionesTipoPlantillaFactura(this.tipoplantillafactura);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	
	
	public void getTodosTipoPlantillaFacturasWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		tipoplantillafacturas = new  ArrayList<TipoPlantillaFactura>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoPlantillaFactura.class.getSimpleName()+"-getTodosTipoPlantillaFacturasWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoPlantillaFacturaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoplantillafacturas=tipoplantillafacturaDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarTipoPlantillaFactura(tipoplantillafacturas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoPlantillaFacturaConstantesFunciones.refrescarForeignKeysDescripcionesTipoPlantillaFactura(this.tipoplantillafacturas);
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
	
	public  void  getTodosTipoPlantillaFacturas(String sFinalQuery,Pagination pagination)throws Exception {
		tipoplantillafacturas = new  ArrayList<TipoPlantillaFactura>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoPlantillaFacturaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoplantillafacturas=tipoplantillafacturaDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarTipoPlantillaFactura(tipoplantillafacturas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoPlantillaFacturaConstantesFunciones.refrescarForeignKeysDescripcionesTipoPlantillaFactura(this.tipoplantillafacturas);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarTipoPlantillaFactura(TipoPlantillaFactura tipoplantillafactura) throws Exception {
		Boolean estaValidado=false;
		
		if(tipoplantillafactura.getIsNew() || tipoplantillafactura.getIsChanged()) { 
			this.invalidValues = tipoplantillafacturaValidator.getInvalidValues(tipoplantillafactura);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(tipoplantillafactura);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarTipoPlantillaFactura(List<TipoPlantillaFactura> TipoPlantillaFacturas) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(TipoPlantillaFactura tipoplantillafacturaLocal:tipoplantillafacturas) {				
			estaValidadoObjeto=this.validarGuardarTipoPlantillaFactura(tipoplantillafacturaLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarTipoPlantillaFactura(List<TipoPlantillaFactura> TipoPlantillaFacturas) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarTipoPlantillaFactura(tipoplantillafacturas)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarTipoPlantillaFactura(TipoPlantillaFactura TipoPlantillaFactura) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarTipoPlantillaFactura(tipoplantillafactura)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(TipoPlantillaFactura tipoplantillafactura) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+tipoplantillafactura.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=TipoPlantillaFacturaConstantesFunciones.getTipoPlantillaFacturaLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"tipoplantillafactura","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(TipoPlantillaFacturaConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(TipoPlantillaFacturaConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveTipoPlantillaFacturaWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoPlantillaFactura.class.getSimpleName()+"-saveTipoPlantillaFacturaWithConnection");connexion.begin();			
			
			//TipoPlantillaFacturaLogicAdditional.checkTipoPlantillaFacturaToSave(this.tipoplantillafactura,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TipoPlantillaFacturaLogicAdditional.updateTipoPlantillaFacturaToSave(this.tipoplantillafactura,this.arrDatoGeneral);
			
			TipoPlantillaFacturaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.tipoplantillafactura,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowTipoPlantillaFactura();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarTipoPlantillaFactura(this.tipoplantillafactura)) {
				TipoPlantillaFacturaDataAccess.save(this.tipoplantillafactura, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.tipoplantillafactura,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			//TipoPlantillaFacturaLogicAdditional.checkTipoPlantillaFacturaToSaveAfter(this.tipoplantillafactura,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowTipoPlantillaFactura();
			
			connexion.commit();			
			
			if(this.tipoplantillafactura.getIsDeleted()) {
				this.tipoplantillafactura=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveTipoPlantillaFactura()throws Exception {	
		try {	
			
			//TipoPlantillaFacturaLogicAdditional.checkTipoPlantillaFacturaToSave(this.tipoplantillafactura,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TipoPlantillaFacturaLogicAdditional.updateTipoPlantillaFacturaToSave(this.tipoplantillafactura,this.arrDatoGeneral);
			
			TipoPlantillaFacturaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.tipoplantillafactura,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarTipoPlantillaFactura(this.tipoplantillafactura)) {			
				TipoPlantillaFacturaDataAccess.save(this.tipoplantillafactura, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.tipoplantillafactura,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			//TipoPlantillaFacturaLogicAdditional.checkTipoPlantillaFacturaToSaveAfter(this.tipoplantillafactura,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.tipoplantillafactura.getIsDeleted()) {
				this.tipoplantillafactura=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveTipoPlantillaFacturasWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoPlantillaFactura.class.getSimpleName()+"-saveTipoPlantillaFacturasWithConnection");connexion.begin();			
			
			//TipoPlantillaFacturaLogicAdditional.checkTipoPlantillaFacturaToSaves(tipoplantillafacturas,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowTipoPlantillaFacturas();
			
			Boolean validadoTodosTipoPlantillaFactura=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(TipoPlantillaFactura tipoplantillafacturaLocal:tipoplantillafacturas) {		
				if(tipoplantillafacturaLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				//TipoPlantillaFacturaLogicAdditional.updateTipoPlantillaFacturaToSave(tipoplantillafacturaLocal,this.arrDatoGeneral);
	        	
				TipoPlantillaFacturaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),tipoplantillafacturaLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarTipoPlantillaFactura(tipoplantillafacturaLocal)) {
					TipoPlantillaFacturaDataAccess.save(tipoplantillafacturaLocal, connexion);				
				} else {
					validadoTodosTipoPlantillaFactura=false;
				}
			}
			
			if(!validadoTodosTipoPlantillaFactura) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			//TipoPlantillaFacturaLogicAdditional.checkTipoPlantillaFacturaToSavesAfter(tipoplantillafacturas,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowTipoPlantillaFacturas();
			
			connexion.commit();		
			
			this.quitarTipoPlantillaFacturasEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveTipoPlantillaFacturas()throws Exception {				
		 try {	
			//TipoPlantillaFacturaLogicAdditional.checkTipoPlantillaFacturaToSaves(tipoplantillafacturas,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosTipoPlantillaFactura=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(TipoPlantillaFactura tipoplantillafacturaLocal:tipoplantillafacturas) {				
				if(tipoplantillafacturaLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				//TipoPlantillaFacturaLogicAdditional.updateTipoPlantillaFacturaToSave(tipoplantillafacturaLocal,this.arrDatoGeneral);
	        	
				TipoPlantillaFacturaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),tipoplantillafacturaLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarTipoPlantillaFactura(tipoplantillafacturaLocal)) {				
					TipoPlantillaFacturaDataAccess.save(tipoplantillafacturaLocal, connexion);				
				} else {
					validadoTodosTipoPlantillaFactura=false;
				}
			}
			
			if(!validadoTodosTipoPlantillaFactura) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			//TipoPlantillaFacturaLogicAdditional.checkTipoPlantillaFacturaToSavesAfter(tipoplantillafacturas,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarTipoPlantillaFacturasEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public TipoPlantillaFacturaParameterReturnGeneral procesarAccionTipoPlantillaFacturas(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<TipoPlantillaFactura> tipoplantillafacturas,TipoPlantillaFacturaParameterReturnGeneral tipoplantillafacturaParameterGeneral)throws Exception {
		 try {	
			TipoPlantillaFacturaParameterReturnGeneral tipoplantillafacturaReturnGeneral=new TipoPlantillaFacturaParameterReturnGeneral();
	
			
			return tipoplantillafacturaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public TipoPlantillaFacturaParameterReturnGeneral procesarAccionTipoPlantillaFacturasWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<TipoPlantillaFactura> tipoplantillafacturas,TipoPlantillaFacturaParameterReturnGeneral tipoplantillafacturaParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoPlantillaFactura.class.getSimpleName()+"-procesarAccionTipoPlantillaFacturasWithConnection");connexion.begin();			
			
			TipoPlantillaFacturaParameterReturnGeneral tipoplantillafacturaReturnGeneral=new TipoPlantillaFacturaParameterReturnGeneral();
	
			
			this.connexion.commit();
			
			return tipoplantillafacturaReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public TipoPlantillaFacturaParameterReturnGeneral procesarEventosTipoPlantillaFacturas(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<TipoPlantillaFactura> tipoplantillafacturas,TipoPlantillaFactura tipoplantillafactura,TipoPlantillaFacturaParameterReturnGeneral tipoplantillafacturaParameterGeneral,Boolean isEsNuevoTipoPlantillaFactura,ArrayList<Classe> clases)throws Exception {
		 try {	
			TipoPlantillaFacturaParameterReturnGeneral tipoplantillafacturaReturnGeneral=new TipoPlantillaFacturaParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				tipoplantillafacturaReturnGeneral.setConRecargarPropiedades(true);
			}
			
			
			return tipoplantillafacturaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public TipoPlantillaFacturaParameterReturnGeneral procesarEventosTipoPlantillaFacturasWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<TipoPlantillaFactura> tipoplantillafacturas,TipoPlantillaFactura tipoplantillafactura,TipoPlantillaFacturaParameterReturnGeneral tipoplantillafacturaParameterGeneral,Boolean isEsNuevoTipoPlantillaFactura,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoPlantillaFactura.class.getSimpleName()+"-procesarEventosTipoPlantillaFacturasWithConnection");connexion.begin();			
			
			TipoPlantillaFacturaParameterReturnGeneral tipoplantillafacturaReturnGeneral=new TipoPlantillaFacturaParameterReturnGeneral();
	
			tipoplantillafacturaReturnGeneral.setTipoPlantillaFactura(tipoplantillafactura);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				tipoplantillafacturaReturnGeneral.setConRecargarPropiedades(true);
			}
			
			
			this.connexion.commit();
			
			return tipoplantillafacturaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public TipoPlantillaFacturaParameterReturnGeneral procesarImportacionTipoPlantillaFacturasWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,TipoPlantillaFacturaParameterReturnGeneral tipoplantillafacturaParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoPlantillaFactura.class.getSimpleName()+"-procesarImportacionTipoPlantillaFacturasWithConnection");connexion.begin();			
			
			TipoPlantillaFacturaParameterReturnGeneral tipoplantillafacturaReturnGeneral=new TipoPlantillaFacturaParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.tipoplantillafacturas=new ArrayList<TipoPlantillaFactura>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.tipoplantillafactura=new TipoPlantillaFactura();
				
				
				if(conColumnasBase) {this.tipoplantillafactura.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.tipoplantillafactura.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.tipoplantillafactura.setcodigo(arrColumnas[iColumn++]);
				this.tipoplantillafactura.setnombre(arrColumnas[iColumn++]);
				
				this.tipoplantillafacturas.add(this.tipoplantillafactura);
			}
			
			this.saveTipoPlantillaFacturas();
			
			this.connexion.commit();
			
			tipoplantillafacturaReturnGeneral.setConRetornoEstaProcesado(true);
			tipoplantillafacturaReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return tipoplantillafacturaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarTipoPlantillaFacturasEliminados() throws Exception {				
		
		List<TipoPlantillaFactura> tipoplantillafacturasAux= new ArrayList<TipoPlantillaFactura>();
		
		for(TipoPlantillaFactura tipoplantillafactura:tipoplantillafacturas) {
			if(!tipoplantillafactura.getIsDeleted()) {
				tipoplantillafacturasAux.add(tipoplantillafactura);
			}
		}
		
		tipoplantillafacturas=tipoplantillafacturasAux;
	}
	
	public void quitarTipoPlantillaFacturasNulos() throws Exception {				
		
		List<TipoPlantillaFactura> tipoplantillafacturasAux= new ArrayList<TipoPlantillaFactura>();
		
		for(TipoPlantillaFactura tipoplantillafactura : this.tipoplantillafacturas) {
			if(tipoplantillafactura==null) {
				tipoplantillafacturasAux.add(tipoplantillafactura);
			}
		}
		
		//this.tipoplantillafacturas=tipoplantillafacturasAux;
		
		this.tipoplantillafacturas.removeAll(tipoplantillafacturasAux);
	}
	
	public void getSetVersionRowTipoPlantillaFacturaWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(tipoplantillafactura.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((tipoplantillafactura.getIsDeleted() || (tipoplantillafactura.getIsChanged()&&!tipoplantillafactura.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=tipoplantillafacturaDataAccess.getSetVersionRowTipoPlantillaFactura(connexion,tipoplantillafactura.getId());
				
				if(!tipoplantillafactura.getVersionRow().equals(timestamp)) {	
					tipoplantillafactura.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				tipoplantillafactura.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowTipoPlantillaFactura()throws Exception {	
		
		if(tipoplantillafactura.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((tipoplantillafactura.getIsDeleted() || (tipoplantillafactura.getIsChanged()&&!tipoplantillafactura.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=tipoplantillafacturaDataAccess.getSetVersionRowTipoPlantillaFactura(connexion,tipoplantillafactura.getId());
			
			try {							
				if(!tipoplantillafactura.getVersionRow().equals(timestamp)) {	
					tipoplantillafactura.setVersionRow(timestamp);
				}
				
				tipoplantillafactura.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowTipoPlantillaFacturasWithConnection()throws Exception {	
		if(tipoplantillafacturas!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(TipoPlantillaFactura tipoplantillafacturaAux:tipoplantillafacturas) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(tipoplantillafacturaAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(tipoplantillafacturaAux.getIsDeleted() || (tipoplantillafacturaAux.getIsChanged()&&!tipoplantillafacturaAux.getIsNew())) {
						
						timestamp=tipoplantillafacturaDataAccess.getSetVersionRowTipoPlantillaFactura(connexion,tipoplantillafacturaAux.getId());
						
						if(!tipoplantillafactura.getVersionRow().equals(timestamp)) {	
							tipoplantillafacturaAux.setVersionRow(timestamp);
						}
								
						tipoplantillafacturaAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowTipoPlantillaFacturas()throws Exception {	
		if(tipoplantillafacturas!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(TipoPlantillaFactura tipoplantillafacturaAux:tipoplantillafacturas) {
					if(tipoplantillafacturaAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(tipoplantillafacturaAux.getIsDeleted() || (tipoplantillafacturaAux.getIsChanged()&&!tipoplantillafacturaAux.getIsNew())) {
						
						timestamp=tipoplantillafacturaDataAccess.getSetVersionRowTipoPlantillaFactura(connexion,tipoplantillafacturaAux.getId());
						
						if(!tipoplantillafacturaAux.getVersionRow().equals(timestamp)) {	
							tipoplantillafacturaAux.setVersionRow(timestamp);
						}
						
													
						tipoplantillafacturaAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public TipoPlantillaFacturaParameterReturnGeneral cargarCombosLoteForeignKeyTipoPlantillaFacturaWithConnection(String finalQueryGlobalEmpresa) throws Exception {
		TipoPlantillaFacturaParameterReturnGeneral  tipoplantillafacturaReturnGeneral =new TipoPlantillaFacturaParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoPlantillaFactura.class.getSimpleName()+"-cargarCombosLoteForeignKeyTipoPlantillaFacturaWithConnection");connexion.begin();
			
			tipoplantillafacturaReturnGeneral =new TipoPlantillaFacturaParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			tipoplantillafacturaReturnGeneral.setempresasForeignKey(empresasForeignKey);

			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
		
		return tipoplantillafacturaReturnGeneral;
	}
	
	public TipoPlantillaFacturaParameterReturnGeneral cargarCombosLoteForeignKeyTipoPlantillaFactura(String finalQueryGlobalEmpresa) throws Exception {
		TipoPlantillaFacturaParameterReturnGeneral  tipoplantillafacturaReturnGeneral =new TipoPlantillaFacturaParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {						
			tipoplantillafacturaReturnGeneral =new TipoPlantillaFacturaParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			tipoplantillafacturaReturnGeneral.setempresasForeignKey(empresasForeignKey);
						
			
		} catch(Exception e) {			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			
		}
		
		return tipoplantillafacturaReturnGeneral;
	}
	
	
	public void deepLoad(TipoPlantillaFactura tipoplantillafactura,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			//TipoPlantillaFacturaLogicAdditional.updateTipoPlantillaFacturaToGet(tipoplantillafactura,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		tipoplantillafactura.setEmpresa(tipoplantillafacturaDataAccess.getEmpresa(connexion,tipoplantillafactura));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				tipoplantillafactura.setEmpresa(tipoplantillafacturaDataAccess.getEmpresa(connexion,tipoplantillafactura));
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
			tipoplantillafactura.setEmpresa(tipoplantillafacturaDataAccess.getEmpresa(connexion,tipoplantillafactura));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		tipoplantillafactura.setEmpresa(tipoplantillafacturaDataAccess.getEmpresa(connexion,tipoplantillafactura));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(tipoplantillafactura.getEmpresa(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				tipoplantillafactura.setEmpresa(tipoplantillafacturaDataAccess.getEmpresa(connexion,tipoplantillafactura));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(tipoplantillafactura.getEmpresa(),isDeep,deepLoadType,clases);				
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
			tipoplantillafactura.setEmpresa(tipoplantillafacturaDataAccess.getEmpresa(connexion,tipoplantillafactura));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(tipoplantillafactura.getEmpresa(),isDeep,deepLoadType,clases);
				
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(TipoPlantillaFactura tipoplantillafactura,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}	
	}
	
	public void deepLoadWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(TipoPlantillaFactura.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(tipoplantillafactura,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				TipoPlantillaFacturaConstantesFunciones.refrescarForeignKeysDescripcionesTipoPlantillaFactura(tipoplantillafactura);
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
			this.deepLoad(this.tipoplantillafactura,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				TipoPlantillaFacturaConstantesFunciones.refrescarForeignKeysDescripcionesTipoPlantillaFactura(this.tipoplantillafactura);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(TipoPlantillaFactura.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(tipoplantillafacturas!=null) {
				for(TipoPlantillaFactura tipoplantillafactura:tipoplantillafacturas) {
					this.deepLoad(tipoplantillafactura,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					TipoPlantillaFacturaConstantesFunciones.refrescarForeignKeysDescripcionesTipoPlantillaFactura(tipoplantillafacturas);
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
			if(tipoplantillafacturas!=null) {
				for(TipoPlantillaFactura tipoplantillafactura:tipoplantillafacturas) {
					this.deepLoad(tipoplantillafactura,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					TipoPlantillaFacturaConstantesFunciones.refrescarForeignKeysDescripcionesTipoPlantillaFactura(tipoplantillafacturas);
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
	
	
	public void getTipoPlantillaFacturasFK_IdEmpresaWithConnection(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoPlantillaFactura.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,TipoPlantillaFacturaConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			TipoPlantillaFacturaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			tipoplantillafacturas=tipoplantillafacturaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TipoPlantillaFacturaConstantesFunciones.refrescarForeignKeysDescripcionesTipoPlantillaFactura(this.tipoplantillafacturas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getTipoPlantillaFacturasFK_IdEmpresa(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,TipoPlantillaFacturaConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			TipoPlantillaFacturaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			tipoplantillafacturas=tipoplantillafacturaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TipoPlantillaFacturaConstantesFunciones.refrescarForeignKeysDescripcionesTipoPlantillaFactura(this.tipoplantillafacturas);
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
			if(TipoPlantillaFacturaConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoPlantillaFacturaDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,TipoPlantillaFactura tipoplantillafactura,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(TipoPlantillaFacturaConstantesFunciones.ISCONAUDITORIA) {
				if(tipoplantillafactura.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoPlantillaFacturaDataAccess.TABLENAME, tipoplantillafactura.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(TipoPlantillaFacturaConstantesFunciones.ISCONAUDITORIADETALLE) {
						////TipoPlantillaFacturaLogic.registrarAuditoriaDetallesTipoPlantillaFactura(connexion,tipoplantillafactura,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(tipoplantillafactura.getIsDeleted()) {
					/*if(!tipoplantillafactura.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,TipoPlantillaFacturaDataAccess.TABLENAME, tipoplantillafactura.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////TipoPlantillaFacturaLogic.registrarAuditoriaDetallesTipoPlantillaFactura(connexion,tipoplantillafactura,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoPlantillaFacturaDataAccess.TABLENAME, tipoplantillafactura.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(tipoplantillafactura.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoPlantillaFacturaDataAccess.TABLENAME, tipoplantillafactura.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(TipoPlantillaFacturaConstantesFunciones.ISCONAUDITORIADETALLE) {
						////TipoPlantillaFacturaLogic.registrarAuditoriaDetallesTipoPlantillaFactura(connexion,tipoplantillafactura,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesTipoPlantillaFactura(Connexion connexion,TipoPlantillaFactura tipoplantillafactura)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(tipoplantillafactura.getIsNew()||!tipoplantillafactura.getid_empresa().equals(tipoplantillafactura.getTipoPlantillaFacturaOriginal().getid_empresa()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(tipoplantillafactura.getTipoPlantillaFacturaOriginal().getid_empresa()!=null)
				{
					strValorActual=tipoplantillafactura.getTipoPlantillaFacturaOriginal().getid_empresa().toString();
				}
				if(tipoplantillafactura.getid_empresa()!=null)
				{
					strValorNuevo=tipoplantillafactura.getid_empresa().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TipoPlantillaFacturaConstantesFunciones.IDEMPRESA,strValorActual,strValorNuevo);
			}	
			
			if(tipoplantillafactura.getIsNew()||!tipoplantillafactura.getcodigo().equals(tipoplantillafactura.getTipoPlantillaFacturaOriginal().getcodigo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(tipoplantillafactura.getTipoPlantillaFacturaOriginal().getcodigo()!=null)
				{
					strValorActual=tipoplantillafactura.getTipoPlantillaFacturaOriginal().getcodigo();
				}
				if(tipoplantillafactura.getcodigo()!=null)
				{
					strValorNuevo=tipoplantillafactura.getcodigo() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TipoPlantillaFacturaConstantesFunciones.CODIGO,strValorActual,strValorNuevo);
			}	
			
			if(tipoplantillafactura.getIsNew()||!tipoplantillafactura.getnombre().equals(tipoplantillafactura.getTipoPlantillaFacturaOriginal().getnombre()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(tipoplantillafactura.getTipoPlantillaFacturaOriginal().getnombre()!=null)
				{
					strValorActual=tipoplantillafactura.getTipoPlantillaFacturaOriginal().getnombre();
				}
				if(tipoplantillafactura.getnombre()!=null)
				{
					strValorNuevo=tipoplantillafactura.getnombre() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TipoPlantillaFacturaConstantesFunciones.NOMBRE,strValorActual,strValorNuevo);
			}	
	}
	
	
//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfTipoPlantillaFactura(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=TipoPlantillaFacturaConstantesFunciones.getClassesForeignKeysOfTipoPlantillaFactura(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfTipoPlantillaFactura(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=TipoPlantillaFacturaConstantesFunciones.getClassesRelationshipsOfTipoPlantillaFactura(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
}
