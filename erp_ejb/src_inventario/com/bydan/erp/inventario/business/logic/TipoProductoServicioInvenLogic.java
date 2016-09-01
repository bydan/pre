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
import com.bydan.erp.inventario.util.TipoProductoServicioInvenConstantesFunciones;
import com.bydan.erp.inventario.util.TipoProductoServicioInvenParameterReturnGeneral;
//import com.bydan.erp.inventario.util.TipoProductoServicioInvenParameterGeneral;
import com.bydan.erp.inventario.business.entity.TipoProductoServicioInven;
//import com.bydan.erp.inventario.business.logic.TipoProductoServicioInvenLogicAdditional;
import com.bydan.erp.inventario.business.dataaccess.*;
import com.bydan.erp.inventario.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.facturacion.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;


import com.bydan.erp.seguridad.business.logic.*;
import com.bydan.erp.facturacion.business.logic.*;
import com.bydan.erp.cartera.business.logic.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.facturacion.util.*;
import com.bydan.erp.cartera.util.*;


import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.facturacion.business.dataaccess.*;
import com.bydan.erp.cartera.business.dataaccess.*;








@SuppressWarnings("unused")
public class TipoProductoServicioInvenLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(TipoProductoServicioInvenLogic.class);
	
	protected TipoProductoServicioInvenDataAccess tipoproductoservicioinvenDataAccess; 	
	protected TipoProductoServicioInven tipoproductoservicioinven;
	protected List<TipoProductoServicioInven> tipoproductoservicioinvens;
	protected Object tipoproductoservicioinvenObject;	
	protected List<Object> tipoproductoservicioinvensObject;
	
	public static ClassValidator<TipoProductoServicioInven> tipoproductoservicioinvenValidator = new ClassValidator<TipoProductoServicioInven>(TipoProductoServicioInven.class);	
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
	
	
	
	
	public  TipoProductoServicioInvenLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.tipoproductoservicioinvenDataAccess = new TipoProductoServicioInvenDataAccess();
			
			this.tipoproductoservicioinvens= new ArrayList<TipoProductoServicioInven>();
			this.tipoproductoservicioinven= new TipoProductoServicioInven();
			
			this.tipoproductoservicioinvenObject=new Object();
			this.tipoproductoservicioinvensObject=new ArrayList<Object>();
				
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
			
			this.tipoproductoservicioinvenDataAccess.setConnexionType(this.connexionType);
			this.tipoproductoservicioinvenDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  TipoProductoServicioInvenLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.tipoproductoservicioinvenDataAccess = new TipoProductoServicioInvenDataAccess();
			this.tipoproductoservicioinvens= new ArrayList<TipoProductoServicioInven>();
			this.tipoproductoservicioinven= new TipoProductoServicioInven();
			this.tipoproductoservicioinvenObject=new Object();
			this.tipoproductoservicioinvensObject=new ArrayList<Object>();
			
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
			
			this.tipoproductoservicioinvenDataAccess.setConnexionType(this.connexionType);
			this.tipoproductoservicioinvenDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public TipoProductoServicioInven getTipoProductoServicioInven() throws Exception {	
		//TipoProductoServicioInvenLogicAdditional.checkTipoProductoServicioInvenToGet(tipoproductoservicioinven,this.datosCliente,this.arrDatoGeneral);
		//TipoProductoServicioInvenLogicAdditional.updateTipoProductoServicioInvenToGet(tipoproductoservicioinven,this.arrDatoGeneral);
		
		return tipoproductoservicioinven;
	}
		
	public void setTipoProductoServicioInven(TipoProductoServicioInven newTipoProductoServicioInven) {
		this.tipoproductoservicioinven = newTipoProductoServicioInven;
	}
	
	public TipoProductoServicioInvenDataAccess getTipoProductoServicioInvenDataAccess() {
		return tipoproductoservicioinvenDataAccess;
	}
	
	public void setTipoProductoServicioInvenDataAccess(TipoProductoServicioInvenDataAccess newtipoproductoservicioinvenDataAccess) {
		this.tipoproductoservicioinvenDataAccess = newtipoproductoservicioinvenDataAccess;
	}
	
	public List<TipoProductoServicioInven> getTipoProductoServicioInvens() throws Exception {		
		this.quitarTipoProductoServicioInvensNulos();
		
		//TipoProductoServicioInvenLogicAdditional.checkTipoProductoServicioInvenToGets(tipoproductoservicioinvens,this.datosCliente,this.arrDatoGeneral);
		
		for (TipoProductoServicioInven tipoproductoservicioinvenLocal: tipoproductoservicioinvens ) {
			//TipoProductoServicioInvenLogicAdditional.updateTipoProductoServicioInvenToGet(tipoproductoservicioinvenLocal,this.arrDatoGeneral);
		}
		
		return tipoproductoservicioinvens;
	}
	
	public void setTipoProductoServicioInvens(List<TipoProductoServicioInven> newTipoProductoServicioInvens) {
		this.tipoproductoservicioinvens = newTipoProductoServicioInvens;
	}
	
	public Object getTipoProductoServicioInvenObject() {	
		this.tipoproductoservicioinvenObject=this.tipoproductoservicioinvenDataAccess.getEntityObject();
		return this.tipoproductoservicioinvenObject;
	}
		
	public void setTipoProductoServicioInvenObject(Object newTipoProductoServicioInvenObject) {
		this.tipoproductoservicioinvenObject = newTipoProductoServicioInvenObject;
	}
	
	public List<Object> getTipoProductoServicioInvensObject() {		
		this.tipoproductoservicioinvensObject=this.tipoproductoservicioinvenDataAccess.getEntitiesObject();
		return this.tipoproductoservicioinvensObject;
	}
		
	public void setTipoProductoServicioInvensObject(List<Object> newTipoProductoServicioInvensObject) {
		this.tipoproductoservicioinvensObject = newTipoProductoServicioInvensObject;
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
		
		if(this.tipoproductoservicioinvenDataAccess!=null) {
			this.tipoproductoservicioinvenDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoProductoServicioInven.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			tipoproductoservicioinvenDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			tipoproductoservicioinvenDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		tipoproductoservicioinven = new  TipoProductoServicioInven();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoProductoServicioInven.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			tipoproductoservicioinven=tipoproductoservicioinvenDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tipoproductoservicioinven,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoProductoServicioInvenConstantesFunciones.refrescarForeignKeysDescripcionesTipoProductoServicioInven(this.tipoproductoservicioinven);
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
		tipoproductoservicioinven = new  TipoProductoServicioInven();
		  		  
        try {
			
			tipoproductoservicioinven=tipoproductoservicioinvenDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tipoproductoservicioinven,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoProductoServicioInvenConstantesFunciones.refrescarForeignKeysDescripcionesTipoProductoServicioInven(this.tipoproductoservicioinven);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		tipoproductoservicioinven = new  TipoProductoServicioInven();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoProductoServicioInven.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			tipoproductoservicioinven=tipoproductoservicioinvenDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tipoproductoservicioinven,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoProductoServicioInvenConstantesFunciones.refrescarForeignKeysDescripcionesTipoProductoServicioInven(this.tipoproductoservicioinven);
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
		tipoproductoservicioinven = new  TipoProductoServicioInven();
		  		  
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
		tipoproductoservicioinven = new  TipoProductoServicioInven();
		  		  
        try {
			
			tipoproductoservicioinven=tipoproductoservicioinvenDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tipoproductoservicioinven,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoProductoServicioInvenConstantesFunciones.refrescarForeignKeysDescripcionesTipoProductoServicioInven(this.tipoproductoservicioinven);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		tipoproductoservicioinven = new  TipoProductoServicioInven();
		  		  
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
		tipoproductoservicioinven = new  TipoProductoServicioInven();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoProductoServicioInven.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =tipoproductoservicioinvenDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		tipoproductoservicioinven = new  TipoProductoServicioInven();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=tipoproductoservicioinvenDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		tipoproductoservicioinven = new  TipoProductoServicioInven();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoProductoServicioInven.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =tipoproductoservicioinvenDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		tipoproductoservicioinven = new  TipoProductoServicioInven();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=tipoproductoservicioinvenDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		tipoproductoservicioinven = new  TipoProductoServicioInven();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoProductoServicioInven.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =tipoproductoservicioinvenDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		tipoproductoservicioinven = new  TipoProductoServicioInven();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=tipoproductoservicioinvenDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		tipoproductoservicioinvens = new  ArrayList<TipoProductoServicioInven>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoProductoServicioInven.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			TipoProductoServicioInvenLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoproductoservicioinvens=tipoproductoservicioinvenDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoProductoServicioInven(tipoproductoservicioinvens);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoProductoServicioInvenConstantesFunciones.refrescarForeignKeysDescripcionesTipoProductoServicioInven(this.tipoproductoservicioinvens);
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
		tipoproductoservicioinvens = new  ArrayList<TipoProductoServicioInven>();
		  		  
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
		tipoproductoservicioinvens = new  ArrayList<TipoProductoServicioInven>();
		  		  
        try {			
			TipoProductoServicioInvenLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoproductoservicioinvens=tipoproductoservicioinvenDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarTipoProductoServicioInven(tipoproductoservicioinvens);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoProductoServicioInvenConstantesFunciones.refrescarForeignKeysDescripcionesTipoProductoServicioInven(this.tipoproductoservicioinvens);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		tipoproductoservicioinvens = new  ArrayList<TipoProductoServicioInven>();
		  		  
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
		tipoproductoservicioinvens = new  ArrayList<TipoProductoServicioInven>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoProductoServicioInven.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			TipoProductoServicioInvenLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoproductoservicioinvens=tipoproductoservicioinvenDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoProductoServicioInven(tipoproductoservicioinvens);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoProductoServicioInvenConstantesFunciones.refrescarForeignKeysDescripcionesTipoProductoServicioInven(this.tipoproductoservicioinvens);
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
		tipoproductoservicioinvens = new  ArrayList<TipoProductoServicioInven>();
		  		  
        try {
			TipoProductoServicioInvenLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoproductoservicioinvens=tipoproductoservicioinvenDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoProductoServicioInven(tipoproductoservicioinvens);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoProductoServicioInvenConstantesFunciones.refrescarForeignKeysDescripcionesTipoProductoServicioInven(this.tipoproductoservicioinvens);
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
		tipoproductoservicioinvens = new  ArrayList<TipoProductoServicioInven>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoProductoServicioInven.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoProductoServicioInvenLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoproductoservicioinvens=tipoproductoservicioinvenDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoProductoServicioInven(tipoproductoservicioinvens);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoProductoServicioInvenConstantesFunciones.refrescarForeignKeysDescripcionesTipoProductoServicioInven(this.tipoproductoservicioinvens);
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
		tipoproductoservicioinvens = new  ArrayList<TipoProductoServicioInven>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoProductoServicioInvenLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoproductoservicioinvens=tipoproductoservicioinvenDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoProductoServicioInven(tipoproductoservicioinvens);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoProductoServicioInvenConstantesFunciones.refrescarForeignKeysDescripcionesTipoProductoServicioInven(this.tipoproductoservicioinvens);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		tipoproductoservicioinven = new  TipoProductoServicioInven();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoProductoServicioInven.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoProductoServicioInvenLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoproductoservicioinven=tipoproductoservicioinvenDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoProductoServicioInven(tipoproductoservicioinven);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoProductoServicioInvenConstantesFunciones.refrescarForeignKeysDescripcionesTipoProductoServicioInven(this.tipoproductoservicioinven);
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
		tipoproductoservicioinven = new  TipoProductoServicioInven();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoProductoServicioInvenLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoproductoservicioinven=tipoproductoservicioinvenDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoProductoServicioInven(tipoproductoservicioinven);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoProductoServicioInvenConstantesFunciones.refrescarForeignKeysDescripcionesTipoProductoServicioInven(this.tipoproductoservicioinven);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	
	
	public void getTodosTipoProductoServicioInvensWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		tipoproductoservicioinvens = new  ArrayList<TipoProductoServicioInven>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoProductoServicioInven.class.getSimpleName()+"-getTodosTipoProductoServicioInvensWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoProductoServicioInvenLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoproductoservicioinvens=tipoproductoservicioinvenDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarTipoProductoServicioInven(tipoproductoservicioinvens);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoProductoServicioInvenConstantesFunciones.refrescarForeignKeysDescripcionesTipoProductoServicioInven(this.tipoproductoservicioinvens);
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
	
	public  void  getTodosTipoProductoServicioInvens(String sFinalQuery,Pagination pagination)throws Exception {
		tipoproductoservicioinvens = new  ArrayList<TipoProductoServicioInven>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoProductoServicioInvenLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoproductoservicioinvens=tipoproductoservicioinvenDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarTipoProductoServicioInven(tipoproductoservicioinvens);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoProductoServicioInvenConstantesFunciones.refrescarForeignKeysDescripcionesTipoProductoServicioInven(this.tipoproductoservicioinvens);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarTipoProductoServicioInven(TipoProductoServicioInven tipoproductoservicioinven) throws Exception {
		Boolean estaValidado=false;
		
		if(tipoproductoservicioinven.getIsNew() || tipoproductoservicioinven.getIsChanged()) { 
			this.invalidValues = tipoproductoservicioinvenValidator.getInvalidValues(tipoproductoservicioinven);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(tipoproductoservicioinven);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarTipoProductoServicioInven(List<TipoProductoServicioInven> TipoProductoServicioInvens) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(TipoProductoServicioInven tipoproductoservicioinvenLocal:tipoproductoservicioinvens) {				
			estaValidadoObjeto=this.validarGuardarTipoProductoServicioInven(tipoproductoservicioinvenLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarTipoProductoServicioInven(List<TipoProductoServicioInven> TipoProductoServicioInvens) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarTipoProductoServicioInven(tipoproductoservicioinvens)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarTipoProductoServicioInven(TipoProductoServicioInven TipoProductoServicioInven) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarTipoProductoServicioInven(tipoproductoservicioinven)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(TipoProductoServicioInven tipoproductoservicioinven) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+tipoproductoservicioinven.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=TipoProductoServicioInvenConstantesFunciones.getTipoProductoServicioInvenLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"tipoproductoservicioinven","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(TipoProductoServicioInvenConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(TipoProductoServicioInvenConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveTipoProductoServicioInvenWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoProductoServicioInven.class.getSimpleName()+"-saveTipoProductoServicioInvenWithConnection");connexion.begin();			
			
			//TipoProductoServicioInvenLogicAdditional.checkTipoProductoServicioInvenToSave(this.tipoproductoservicioinven,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TipoProductoServicioInvenLogicAdditional.updateTipoProductoServicioInvenToSave(this.tipoproductoservicioinven,this.arrDatoGeneral);
			
			TipoProductoServicioInvenLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.tipoproductoservicioinven,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowTipoProductoServicioInven();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarTipoProductoServicioInven(this.tipoproductoservicioinven)) {
				TipoProductoServicioInvenDataAccess.save(this.tipoproductoservicioinven, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.tipoproductoservicioinven,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			//TipoProductoServicioInvenLogicAdditional.checkTipoProductoServicioInvenToSaveAfter(this.tipoproductoservicioinven,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowTipoProductoServicioInven();
			
			connexion.commit();			
			
			if(this.tipoproductoservicioinven.getIsDeleted()) {
				this.tipoproductoservicioinven=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveTipoProductoServicioInven()throws Exception {	
		try {	
			
			//TipoProductoServicioInvenLogicAdditional.checkTipoProductoServicioInvenToSave(this.tipoproductoservicioinven,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TipoProductoServicioInvenLogicAdditional.updateTipoProductoServicioInvenToSave(this.tipoproductoservicioinven,this.arrDatoGeneral);
			
			TipoProductoServicioInvenLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.tipoproductoservicioinven,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarTipoProductoServicioInven(this.tipoproductoservicioinven)) {			
				TipoProductoServicioInvenDataAccess.save(this.tipoproductoservicioinven, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.tipoproductoservicioinven,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			//TipoProductoServicioInvenLogicAdditional.checkTipoProductoServicioInvenToSaveAfter(this.tipoproductoservicioinven,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.tipoproductoservicioinven.getIsDeleted()) {
				this.tipoproductoservicioinven=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveTipoProductoServicioInvensWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoProductoServicioInven.class.getSimpleName()+"-saveTipoProductoServicioInvensWithConnection");connexion.begin();			
			
			//TipoProductoServicioInvenLogicAdditional.checkTipoProductoServicioInvenToSaves(tipoproductoservicioinvens,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowTipoProductoServicioInvens();
			
			Boolean validadoTodosTipoProductoServicioInven=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(TipoProductoServicioInven tipoproductoservicioinvenLocal:tipoproductoservicioinvens) {		
				if(tipoproductoservicioinvenLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				//TipoProductoServicioInvenLogicAdditional.updateTipoProductoServicioInvenToSave(tipoproductoservicioinvenLocal,this.arrDatoGeneral);
	        	
				TipoProductoServicioInvenLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),tipoproductoservicioinvenLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarTipoProductoServicioInven(tipoproductoservicioinvenLocal)) {
					TipoProductoServicioInvenDataAccess.save(tipoproductoservicioinvenLocal, connexion);				
				} else {
					validadoTodosTipoProductoServicioInven=false;
				}
			}
			
			if(!validadoTodosTipoProductoServicioInven) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			//TipoProductoServicioInvenLogicAdditional.checkTipoProductoServicioInvenToSavesAfter(tipoproductoservicioinvens,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowTipoProductoServicioInvens();
			
			connexion.commit();		
			
			this.quitarTipoProductoServicioInvensEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveTipoProductoServicioInvens()throws Exception {				
		 try {	
			//TipoProductoServicioInvenLogicAdditional.checkTipoProductoServicioInvenToSaves(tipoproductoservicioinvens,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosTipoProductoServicioInven=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(TipoProductoServicioInven tipoproductoservicioinvenLocal:tipoproductoservicioinvens) {				
				if(tipoproductoservicioinvenLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				//TipoProductoServicioInvenLogicAdditional.updateTipoProductoServicioInvenToSave(tipoproductoservicioinvenLocal,this.arrDatoGeneral);
	        	
				TipoProductoServicioInvenLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),tipoproductoservicioinvenLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarTipoProductoServicioInven(tipoproductoservicioinvenLocal)) {				
					TipoProductoServicioInvenDataAccess.save(tipoproductoservicioinvenLocal, connexion);				
				} else {
					validadoTodosTipoProductoServicioInven=false;
				}
			}
			
			if(!validadoTodosTipoProductoServicioInven) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			//TipoProductoServicioInvenLogicAdditional.checkTipoProductoServicioInvenToSavesAfter(tipoproductoservicioinvens,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarTipoProductoServicioInvensEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public TipoProductoServicioInvenParameterReturnGeneral procesarAccionTipoProductoServicioInvens(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<TipoProductoServicioInven> tipoproductoservicioinvens,TipoProductoServicioInvenParameterReturnGeneral tipoproductoservicioinvenParameterGeneral)throws Exception {
		 try {	
			TipoProductoServicioInvenParameterReturnGeneral tipoproductoservicioinvenReturnGeneral=new TipoProductoServicioInvenParameterReturnGeneral();
	
			
			return tipoproductoservicioinvenReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public TipoProductoServicioInvenParameterReturnGeneral procesarAccionTipoProductoServicioInvensWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<TipoProductoServicioInven> tipoproductoservicioinvens,TipoProductoServicioInvenParameterReturnGeneral tipoproductoservicioinvenParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoProductoServicioInven.class.getSimpleName()+"-procesarAccionTipoProductoServicioInvensWithConnection");connexion.begin();			
			
			TipoProductoServicioInvenParameterReturnGeneral tipoproductoservicioinvenReturnGeneral=new TipoProductoServicioInvenParameterReturnGeneral();
	
			
			this.connexion.commit();
			
			return tipoproductoservicioinvenReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public TipoProductoServicioInvenParameterReturnGeneral procesarEventosTipoProductoServicioInvens(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<TipoProductoServicioInven> tipoproductoservicioinvens,TipoProductoServicioInven tipoproductoservicioinven,TipoProductoServicioInvenParameterReturnGeneral tipoproductoservicioinvenParameterGeneral,Boolean isEsNuevoTipoProductoServicioInven,ArrayList<Classe> clases)throws Exception {
		 try {	
			TipoProductoServicioInvenParameterReturnGeneral tipoproductoservicioinvenReturnGeneral=new TipoProductoServicioInvenParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				tipoproductoservicioinvenReturnGeneral.setConRecargarPropiedades(true);
			}
			
			
			return tipoproductoservicioinvenReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public TipoProductoServicioInvenParameterReturnGeneral procesarEventosTipoProductoServicioInvensWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<TipoProductoServicioInven> tipoproductoservicioinvens,TipoProductoServicioInven tipoproductoservicioinven,TipoProductoServicioInvenParameterReturnGeneral tipoproductoservicioinvenParameterGeneral,Boolean isEsNuevoTipoProductoServicioInven,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoProductoServicioInven.class.getSimpleName()+"-procesarEventosTipoProductoServicioInvensWithConnection");connexion.begin();			
			
			TipoProductoServicioInvenParameterReturnGeneral tipoproductoservicioinvenReturnGeneral=new TipoProductoServicioInvenParameterReturnGeneral();
	
			tipoproductoservicioinvenReturnGeneral.setTipoProductoServicioInven(tipoproductoservicioinven);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				tipoproductoservicioinvenReturnGeneral.setConRecargarPropiedades(true);
			}
			
			
			this.connexion.commit();
			
			return tipoproductoservicioinvenReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public TipoProductoServicioInvenParameterReturnGeneral procesarImportacionTipoProductoServicioInvensWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,TipoProductoServicioInvenParameterReturnGeneral tipoproductoservicioinvenParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoProductoServicioInven.class.getSimpleName()+"-procesarImportacionTipoProductoServicioInvensWithConnection");connexion.begin();			
			
			TipoProductoServicioInvenParameterReturnGeneral tipoproductoservicioinvenReturnGeneral=new TipoProductoServicioInvenParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.tipoproductoservicioinvens=new ArrayList<TipoProductoServicioInven>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.tipoproductoservicioinven=new TipoProductoServicioInven();
				
				
				if(conColumnasBase) {this.tipoproductoservicioinven.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.tipoproductoservicioinven.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.tipoproductoservicioinven.setnombre(arrColumnas[iColumn++]);
				
				this.tipoproductoservicioinvens.add(this.tipoproductoservicioinven);
			}
			
			this.saveTipoProductoServicioInvens();
			
			this.connexion.commit();
			
			tipoproductoservicioinvenReturnGeneral.setConRetornoEstaProcesado(true);
			tipoproductoservicioinvenReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return tipoproductoservicioinvenReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarTipoProductoServicioInvensEliminados() throws Exception {				
		
		List<TipoProductoServicioInven> tipoproductoservicioinvensAux= new ArrayList<TipoProductoServicioInven>();
		
		for(TipoProductoServicioInven tipoproductoservicioinven:tipoproductoservicioinvens) {
			if(!tipoproductoservicioinven.getIsDeleted()) {
				tipoproductoservicioinvensAux.add(tipoproductoservicioinven);
			}
		}
		
		tipoproductoservicioinvens=tipoproductoservicioinvensAux;
	}
	
	public void quitarTipoProductoServicioInvensNulos() throws Exception {				
		
		List<TipoProductoServicioInven> tipoproductoservicioinvensAux= new ArrayList<TipoProductoServicioInven>();
		
		for(TipoProductoServicioInven tipoproductoservicioinven : this.tipoproductoservicioinvens) {
			if(tipoproductoservicioinven==null) {
				tipoproductoservicioinvensAux.add(tipoproductoservicioinven);
			}
		}
		
		//this.tipoproductoservicioinvens=tipoproductoservicioinvensAux;
		
		this.tipoproductoservicioinvens.removeAll(tipoproductoservicioinvensAux);
	}
	
	public void getSetVersionRowTipoProductoServicioInvenWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(tipoproductoservicioinven.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((tipoproductoservicioinven.getIsDeleted() || (tipoproductoservicioinven.getIsChanged()&&!tipoproductoservicioinven.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=tipoproductoservicioinvenDataAccess.getSetVersionRowTipoProductoServicioInven(connexion,tipoproductoservicioinven.getId());
				
				if(!tipoproductoservicioinven.getVersionRow().equals(timestamp)) {	
					tipoproductoservicioinven.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				tipoproductoservicioinven.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowTipoProductoServicioInven()throws Exception {	
		
		if(tipoproductoservicioinven.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((tipoproductoservicioinven.getIsDeleted() || (tipoproductoservicioinven.getIsChanged()&&!tipoproductoservicioinven.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=tipoproductoservicioinvenDataAccess.getSetVersionRowTipoProductoServicioInven(connexion,tipoproductoservicioinven.getId());
			
			try {							
				if(!tipoproductoservicioinven.getVersionRow().equals(timestamp)) {	
					tipoproductoservicioinven.setVersionRow(timestamp);
				}
				
				tipoproductoservicioinven.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowTipoProductoServicioInvensWithConnection()throws Exception {	
		if(tipoproductoservicioinvens!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(TipoProductoServicioInven tipoproductoservicioinvenAux:tipoproductoservicioinvens) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(tipoproductoservicioinvenAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(tipoproductoservicioinvenAux.getIsDeleted() || (tipoproductoservicioinvenAux.getIsChanged()&&!tipoproductoservicioinvenAux.getIsNew())) {
						
						timestamp=tipoproductoservicioinvenDataAccess.getSetVersionRowTipoProductoServicioInven(connexion,tipoproductoservicioinvenAux.getId());
						
						if(!tipoproductoservicioinven.getVersionRow().equals(timestamp)) {	
							tipoproductoservicioinvenAux.setVersionRow(timestamp);
						}
								
						tipoproductoservicioinvenAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowTipoProductoServicioInvens()throws Exception {	
		if(tipoproductoservicioinvens!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(TipoProductoServicioInven tipoproductoservicioinvenAux:tipoproductoservicioinvens) {
					if(tipoproductoservicioinvenAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(tipoproductoservicioinvenAux.getIsDeleted() || (tipoproductoservicioinvenAux.getIsChanged()&&!tipoproductoservicioinvenAux.getIsNew())) {
						
						timestamp=tipoproductoservicioinvenDataAccess.getSetVersionRowTipoProductoServicioInven(connexion,tipoproductoservicioinvenAux.getId());
						
						if(!tipoproductoservicioinvenAux.getVersionRow().equals(timestamp)) {	
							tipoproductoservicioinvenAux.setVersionRow(timestamp);
						}
						
													
						tipoproductoservicioinvenAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	
	public void cargarRelacionesLoteForeignKeyTipoProductoServicioInvenWithConnection() throws Exception {
		ArrayList<Classe> classes=new ArrayList<Classe>();		
		
		
			ParametroInventarioDefectoLogic parametroinventariodefectoLogic=new ParametroInventarioDefectoLogic();
		
		try {
			
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoProductoServicioInven.class.getSimpleName()+"-cargarRelacionesLoteForeignKeyTipoProductoServicioInvenWithConnection");connexion.begin();
			
			
			classes.add(new Classe(ParametroInventarioDefecto.class));
											
			

			parametroinventariodefectoLogic.setConnexion(this.getConnexion());
			parametroinventariodefectoLogic.setDatosCliente(this.datosCliente);
			parametroinventariodefectoLogic.setIsConRefrescarForeignKeys(true);
			
			this.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
			
			for(TipoProductoServicioInven tipoproductoservicioinven:this.tipoproductoservicioinvens) {
				

				classes=new ArrayList<Classe>();
				classes=ParametroInventarioDefectoConstantesFunciones.getClassesForeignKeysOfParametroInventarioDefecto(new ArrayList<Classe>(),DeepLoadType.NONE);

				parametroinventariodefectoLogic.setParametroInventarioDefectos(tipoproductoservicioinven.parametroinventariodefectos);
				parametroinventariodefectoLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
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
	
	public void deepLoad(TipoProductoServicioInven tipoproductoservicioinven,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			//TipoProductoServicioInvenLogicAdditional.updateTipoProductoServicioInvenToGet(tipoproductoservicioinven,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		tipoproductoservicioinven.setParametroInventarioDefectos(tipoproductoservicioinvenDataAccess.getParametroInventarioDefectos(connexion,tipoproductoservicioinven));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(ParametroInventarioDefecto.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				tipoproductoservicioinven.setParametroInventarioDefectos(tipoproductoservicioinvenDataAccess.getParametroInventarioDefectos(connexion,tipoproductoservicioinven));

				if(this.isConDeep) {
					ParametroInventarioDefectoLogic parametroinventariodefectoLogic= new ParametroInventarioDefectoLogic(this.connexion);
					parametroinventariodefectoLogic.setParametroInventarioDefectos(tipoproductoservicioinven.getParametroInventarioDefectos());
					ArrayList<Classe> classesLocal=ParametroInventarioDefectoConstantesFunciones.getClassesForeignKeysOfParametroInventarioDefecto(new ArrayList<Classe>(),DeepLoadType.NONE);
					parametroinventariodefectoLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					ParametroInventarioDefectoConstantesFunciones.refrescarForeignKeysDescripcionesParametroInventarioDefecto(parametroinventariodefectoLogic.getParametroInventarioDefectos());
					tipoproductoservicioinven.setParametroInventarioDefectos(parametroinventariodefectoLogic.getParametroInventarioDefectos());
				}

				continue;
			}
		}
	}
	else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {


		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(ParametroInventarioDefecto.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(ParametroInventarioDefecto.class));
			tipoproductoservicioinven.setParametroInventarioDefectos(tipoproductoservicioinvenDataAccess.getParametroInventarioDefectos(connexion,tipoproductoservicioinven));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {


		tipoproductoservicioinven.setParametroInventarioDefectos(tipoproductoservicioinvenDataAccess.getParametroInventarioDefectos(connexion,tipoproductoservicioinven));

		for(ParametroInventarioDefecto parametroinventariodefecto:tipoproductoservicioinven.getParametroInventarioDefectos()) {
			ParametroInventarioDefectoLogic parametroinventariodefectoLogic= new ParametroInventarioDefectoLogic(connexion);
			parametroinventariodefectoLogic.deepLoad(parametroinventariodefecto,isDeep,deepLoadType,clases);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(ParametroInventarioDefecto.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				tipoproductoservicioinven.setParametroInventarioDefectos(tipoproductoservicioinvenDataAccess.getParametroInventarioDefectos(connexion,tipoproductoservicioinven));

				for(ParametroInventarioDefecto parametroinventariodefecto:tipoproductoservicioinven.getParametroInventarioDefectos()) {
					ParametroInventarioDefectoLogic parametroinventariodefectoLogic= new ParametroInventarioDefectoLogic(connexion);
					parametroinventariodefectoLogic.deepLoad(parametroinventariodefecto,isDeep,deepLoadType,clases);
				}
				continue;
			}

		}
	}
	else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {


		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(ParametroInventarioDefecto.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(ParametroInventarioDefecto.class));
			tipoproductoservicioinven.setParametroInventarioDefectos(tipoproductoservicioinvenDataAccess.getParametroInventarioDefectos(connexion,tipoproductoservicioinven));

			for(ParametroInventarioDefecto parametroinventariodefecto:tipoproductoservicioinven.getParametroInventarioDefectos()) {
				ParametroInventarioDefectoLogic parametroinventariodefectoLogic= new ParametroInventarioDefectoLogic(connexion);
				parametroinventariodefectoLogic.deepLoad(parametroinventariodefecto,isDeep,deepLoadType,clases);
			}
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(TipoProductoServicioInven tipoproductoservicioinven,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}	
	}
	
	public void deepLoadWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(TipoProductoServicioInven.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(tipoproductoservicioinven,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				TipoProductoServicioInvenConstantesFunciones.refrescarForeignKeysDescripcionesTipoProductoServicioInven(tipoproductoservicioinven);
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
			this.deepLoad(this.tipoproductoservicioinven,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				TipoProductoServicioInvenConstantesFunciones.refrescarForeignKeysDescripcionesTipoProductoServicioInven(this.tipoproductoservicioinven);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(TipoProductoServicioInven.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(tipoproductoservicioinvens!=null) {
				for(TipoProductoServicioInven tipoproductoservicioinven:tipoproductoservicioinvens) {
					this.deepLoad(tipoproductoservicioinven,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					TipoProductoServicioInvenConstantesFunciones.refrescarForeignKeysDescripcionesTipoProductoServicioInven(tipoproductoservicioinvens);
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
			if(tipoproductoservicioinvens!=null) {
				for(TipoProductoServicioInven tipoproductoservicioinven:tipoproductoservicioinvens) {
					this.deepLoad(tipoproductoservicioinven,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					TipoProductoServicioInvenConstantesFunciones.refrescarForeignKeysDescripcionesTipoProductoServicioInven(tipoproductoservicioinvens);
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
	
	
	public void getTipoProductoServicioInvensBusquedaPorNombreWithConnection(String sFinalQuery,Pagination pagination,String nombre)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoProductoServicioInven.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralNombre= new ParameterSelectionGeneral();
			parameterSelectionGeneralNombre.setParameterSelectionGeneralLike(ParameterType.STRING,"%"+nombre+"%",TipoProductoServicioInvenConstantesFunciones.NOMBRE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralNombre);

			TipoProductoServicioInvenLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorNombre","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			tipoproductoservicioinvens=tipoproductoservicioinvenDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TipoProductoServicioInvenConstantesFunciones.refrescarForeignKeysDescripcionesTipoProductoServicioInven(this.tipoproductoservicioinvens);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getTipoProductoServicioInvensBusquedaPorNombre(String sFinalQuery,Pagination pagination,String nombre)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralNombre= new ParameterSelectionGeneral();
			parameterSelectionGeneralNombre.setParameterSelectionGeneralLike(ParameterType.STRING,"%"+nombre+"%",TipoProductoServicioInvenConstantesFunciones.NOMBRE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralNombre);

			TipoProductoServicioInvenLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorNombre","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			tipoproductoservicioinvens=tipoproductoservicioinvenDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TipoProductoServicioInvenConstantesFunciones.refrescarForeignKeysDescripcionesTipoProductoServicioInven(this.tipoproductoservicioinvens);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getTipoProductoServicioInvenPorNombreWithConnection(String nombre)throws Exception {
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoProductoServicioInven.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			ParameterSelectionGeneral parameterSelectionGeneralNombre= new ParameterSelectionGeneral();
			parameterSelectionGeneralNombre.setParameterSelectionGeneralEqual(ParameterType.STRING,nombre,TipoProductoServicioInvenConstantesFunciones.NOMBRE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralNombre);

			tipoproductoservicioinven=tipoproductoservicioinvenDataAccess.getEntity(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoad(this.tipoproductoservicioinven,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());

				TipoProductoServicioInvenConstantesFunciones.refrescarForeignKeysDescripcionesTipoProductoServicioInven(this.tipoproductoservicioinven);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getTipoProductoServicioInvenPorNombre(String nombre)throws Exception {
		try {

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			ParameterSelectionGeneral parameterSelectionGeneralNombre= new ParameterSelectionGeneral();
			parameterSelectionGeneralNombre.setParameterSelectionGeneralEqual(ParameterType.STRING,nombre,TipoProductoServicioInvenConstantesFunciones.NOMBRE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralNombre);

			tipoproductoservicioinven=tipoproductoservicioinvenDataAccess.getEntity(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoad(this.tipoproductoservicioinven,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());

				TipoProductoServicioInvenConstantesFunciones.refrescarForeignKeysDescripcionesTipoProductoServicioInven(this.tipoproductoservicioinven);
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
			if(TipoProductoServicioInvenConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoProductoServicioInvenDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,TipoProductoServicioInven tipoproductoservicioinven,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(TipoProductoServicioInvenConstantesFunciones.ISCONAUDITORIA) {
				if(tipoproductoservicioinven.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoProductoServicioInvenDataAccess.TABLENAME, tipoproductoservicioinven.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(TipoProductoServicioInvenConstantesFunciones.ISCONAUDITORIADETALLE) {
						////TipoProductoServicioInvenLogic.registrarAuditoriaDetallesTipoProductoServicioInven(connexion,tipoproductoservicioinven,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(tipoproductoservicioinven.getIsDeleted()) {
					/*if(!tipoproductoservicioinven.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,TipoProductoServicioInvenDataAccess.TABLENAME, tipoproductoservicioinven.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////TipoProductoServicioInvenLogic.registrarAuditoriaDetallesTipoProductoServicioInven(connexion,tipoproductoservicioinven,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoProductoServicioInvenDataAccess.TABLENAME, tipoproductoservicioinven.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(tipoproductoservicioinven.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoProductoServicioInvenDataAccess.TABLENAME, tipoproductoservicioinven.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(TipoProductoServicioInvenConstantesFunciones.ISCONAUDITORIADETALLE) {
						////TipoProductoServicioInvenLogic.registrarAuditoriaDetallesTipoProductoServicioInven(connexion,tipoproductoservicioinven,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesTipoProductoServicioInven(Connexion connexion,TipoProductoServicioInven tipoproductoservicioinven)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(tipoproductoservicioinven.getIsNew()||!tipoproductoservicioinven.getnombre().equals(tipoproductoservicioinven.getTipoProductoServicioInvenOriginal().getnombre()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(tipoproductoservicioinven.getTipoProductoServicioInvenOriginal().getnombre()!=null)
				{
					strValorActual=tipoproductoservicioinven.getTipoProductoServicioInvenOriginal().getnombre();
				}
				if(tipoproductoservicioinven.getnombre()!=null)
				{
					strValorNuevo=tipoproductoservicioinven.getnombre() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TipoProductoServicioInvenConstantesFunciones.NOMBRE,strValorActual,strValorNuevo);
			}	
	}
	
	
//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfTipoProductoServicioInven(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=TipoProductoServicioInvenConstantesFunciones.getClassesForeignKeysOfTipoProductoServicioInven(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfTipoProductoServicioInven(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=TipoProductoServicioInvenConstantesFunciones.getClassesRelationshipsOfTipoProductoServicioInven(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
}
