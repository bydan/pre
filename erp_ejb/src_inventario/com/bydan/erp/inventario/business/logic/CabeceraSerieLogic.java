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
import com.bydan.erp.inventario.util.CabeceraSerieConstantesFunciones;
import com.bydan.erp.inventario.util.CabeceraSerieParameterReturnGeneral;
//import com.bydan.erp.inventario.util.CabeceraSerieParameterGeneral;
import com.bydan.erp.inventario.business.entity.CabeceraSerie;
import com.bydan.erp.inventario.business.logic.CabeceraSerieLogicAdditional;
import com.bydan.erp.inventario.business.dataaccess.*;
import com.bydan.erp.inventario.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.logic.*;


import com.bydan.erp.seguridad.util.*;


import com.bydan.erp.seguridad.business.dataaccess.*;








@SuppressWarnings("unused")
public class CabeceraSerieLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(CabeceraSerieLogic.class);
	
	protected CabeceraSerieDataAccess cabeceraserieDataAccess; 	
	protected CabeceraSerie cabeceraserie;
	protected List<CabeceraSerie> cabeceraseries;
	protected Object cabeceraserieObject;	
	protected List<Object> cabeceraseriesObject;
	
	public static ClassValidator<CabeceraSerie> cabeceraserieValidator = new ClassValidator<CabeceraSerie>(CabeceraSerie.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected CabeceraSerieLogicAdditional cabeceraserieLogicAdditional=null;
	
	public CabeceraSerieLogicAdditional getCabeceraSerieLogicAdditional() {
		return this.cabeceraserieLogicAdditional;
	}
	
	public void setCabeceraSerieLogicAdditional(CabeceraSerieLogicAdditional cabeceraserieLogicAdditional) {
		try {
			this.cabeceraserieLogicAdditional=cabeceraserieLogicAdditional;
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
	
	
	
	
	public  CabeceraSerieLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.cabeceraserieDataAccess = new CabeceraSerieDataAccess();
			
			this.cabeceraseries= new ArrayList<CabeceraSerie>();
			this.cabeceraserie= new CabeceraSerie();
			
			this.cabeceraserieObject=new Object();
			this.cabeceraseriesObject=new ArrayList<Object>();
				
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
			
			this.cabeceraserieDataAccess.setConnexionType(this.connexionType);
			this.cabeceraserieDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  CabeceraSerieLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.cabeceraserieDataAccess = new CabeceraSerieDataAccess();
			this.cabeceraseries= new ArrayList<CabeceraSerie>();
			this.cabeceraserie= new CabeceraSerie();
			this.cabeceraserieObject=new Object();
			this.cabeceraseriesObject=new ArrayList<Object>();
			
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
			
			this.cabeceraserieDataAccess.setConnexionType(this.connexionType);
			this.cabeceraserieDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public CabeceraSerie getCabeceraSerie() throws Exception {	
		CabeceraSerieLogicAdditional.checkCabeceraSerieToGet(cabeceraserie,this.datosCliente,this.arrDatoGeneral);
		CabeceraSerieLogicAdditional.updateCabeceraSerieToGet(cabeceraserie,this.arrDatoGeneral);
		
		return cabeceraserie;
	}
		
	public void setCabeceraSerie(CabeceraSerie newCabeceraSerie) {
		this.cabeceraserie = newCabeceraSerie;
	}
	
	public CabeceraSerieDataAccess getCabeceraSerieDataAccess() {
		return cabeceraserieDataAccess;
	}
	
	public void setCabeceraSerieDataAccess(CabeceraSerieDataAccess newcabeceraserieDataAccess) {
		this.cabeceraserieDataAccess = newcabeceraserieDataAccess;
	}
	
	public List<CabeceraSerie> getCabeceraSeries() throws Exception {		
		this.quitarCabeceraSeriesNulos();
		
		CabeceraSerieLogicAdditional.checkCabeceraSerieToGets(cabeceraseries,this.datosCliente,this.arrDatoGeneral);
		
		for (CabeceraSerie cabeceraserieLocal: cabeceraseries ) {
			CabeceraSerieLogicAdditional.updateCabeceraSerieToGet(cabeceraserieLocal,this.arrDatoGeneral);
		}
		
		return cabeceraseries;
	}
	
	public void setCabeceraSeries(List<CabeceraSerie> newCabeceraSeries) {
		this.cabeceraseries = newCabeceraSeries;
	}
	
	public Object getCabeceraSerieObject() {	
		this.cabeceraserieObject=this.cabeceraserieDataAccess.getEntityObject();
		return this.cabeceraserieObject;
	}
		
	public void setCabeceraSerieObject(Object newCabeceraSerieObject) {
		this.cabeceraserieObject = newCabeceraSerieObject;
	}
	
	public List<Object> getCabeceraSeriesObject() {		
		this.cabeceraseriesObject=this.cabeceraserieDataAccess.getEntitiesObject();
		return this.cabeceraseriesObject;
	}
		
	public void setCabeceraSeriesObject(List<Object> newCabeceraSeriesObject) {
		this.cabeceraseriesObject = newCabeceraSeriesObject;
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
		
		if(this.cabeceraserieDataAccess!=null) {
			this.cabeceraserieDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CabeceraSerie.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			cabeceraserieDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			cabeceraserieDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		cabeceraserie = new  CabeceraSerie();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CabeceraSerie.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			cabeceraserie=cabeceraserieDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.cabeceraserie,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				CabeceraSerieConstantesFunciones.refrescarForeignKeysDescripcionesCabeceraSerie(this.cabeceraserie);
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
		cabeceraserie = new  CabeceraSerie();
		  		  
        try {
			
			cabeceraserie=cabeceraserieDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.cabeceraserie,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				CabeceraSerieConstantesFunciones.refrescarForeignKeysDescripcionesCabeceraSerie(this.cabeceraserie);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		cabeceraserie = new  CabeceraSerie();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CabeceraSerie.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			cabeceraserie=cabeceraserieDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.cabeceraserie,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				CabeceraSerieConstantesFunciones.refrescarForeignKeysDescripcionesCabeceraSerie(this.cabeceraserie);
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
		cabeceraserie = new  CabeceraSerie();
		  		  
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
		cabeceraserie = new  CabeceraSerie();
		  		  
        try {
			
			cabeceraserie=cabeceraserieDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.cabeceraserie,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				CabeceraSerieConstantesFunciones.refrescarForeignKeysDescripcionesCabeceraSerie(this.cabeceraserie);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		cabeceraserie = new  CabeceraSerie();
		  		  
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
		cabeceraserie = new  CabeceraSerie();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CabeceraSerie.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =cabeceraserieDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		cabeceraserie = new  CabeceraSerie();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=cabeceraserieDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		cabeceraserie = new  CabeceraSerie();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CabeceraSerie.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =cabeceraserieDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		cabeceraserie = new  CabeceraSerie();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=cabeceraserieDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		cabeceraserie = new  CabeceraSerie();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CabeceraSerie.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =cabeceraserieDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		cabeceraserie = new  CabeceraSerie();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=cabeceraserieDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		cabeceraseries = new  ArrayList<CabeceraSerie>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CabeceraSerie.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			CabeceraSerieLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			cabeceraseries=cabeceraserieDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarCabeceraSerie(cabeceraseries);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				CabeceraSerieConstantesFunciones.refrescarForeignKeysDescripcionesCabeceraSerie(this.cabeceraseries);
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
		cabeceraseries = new  ArrayList<CabeceraSerie>();
		  		  
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
		cabeceraseries = new  ArrayList<CabeceraSerie>();
		  		  
        try {			
			CabeceraSerieLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			cabeceraseries=cabeceraserieDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarCabeceraSerie(cabeceraseries);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				CabeceraSerieConstantesFunciones.refrescarForeignKeysDescripcionesCabeceraSerie(this.cabeceraseries);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		cabeceraseries = new  ArrayList<CabeceraSerie>();
		  		  
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
		cabeceraseries = new  ArrayList<CabeceraSerie>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CabeceraSerie.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			CabeceraSerieLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			cabeceraseries=cabeceraserieDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarCabeceraSerie(cabeceraseries);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				CabeceraSerieConstantesFunciones.refrescarForeignKeysDescripcionesCabeceraSerie(this.cabeceraseries);
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
		cabeceraseries = new  ArrayList<CabeceraSerie>();
		  		  
        try {
			CabeceraSerieLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			cabeceraseries=cabeceraserieDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarCabeceraSerie(cabeceraseries);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				CabeceraSerieConstantesFunciones.refrescarForeignKeysDescripcionesCabeceraSerie(this.cabeceraseries);
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
		cabeceraseries = new  ArrayList<CabeceraSerie>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CabeceraSerie.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			CabeceraSerieLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			cabeceraseries=cabeceraserieDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarCabeceraSerie(cabeceraseries);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				CabeceraSerieConstantesFunciones.refrescarForeignKeysDescripcionesCabeceraSerie(this.cabeceraseries);
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
		cabeceraseries = new  ArrayList<CabeceraSerie>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			CabeceraSerieLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			cabeceraseries=cabeceraserieDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarCabeceraSerie(cabeceraseries);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				CabeceraSerieConstantesFunciones.refrescarForeignKeysDescripcionesCabeceraSerie(this.cabeceraseries);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		cabeceraserie = new  CabeceraSerie();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CabeceraSerie.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			CabeceraSerieLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			cabeceraserie=cabeceraserieDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarCabeceraSerie(cabeceraserie);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				CabeceraSerieConstantesFunciones.refrescarForeignKeysDescripcionesCabeceraSerie(this.cabeceraserie);
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
		cabeceraserie = new  CabeceraSerie();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			CabeceraSerieLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			cabeceraserie=cabeceraserieDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarCabeceraSerie(cabeceraserie);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				CabeceraSerieConstantesFunciones.refrescarForeignKeysDescripcionesCabeceraSerie(this.cabeceraserie);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		cabeceraseries = new  ArrayList<CabeceraSerie>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CabeceraSerie.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			CabeceraSerieLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			cabeceraseries=cabeceraserieDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarCabeceraSerie(cabeceraseries);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				CabeceraSerieConstantesFunciones.refrescarForeignKeysDescripcionesCabeceraSerie(this.cabeceraseries);
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
		cabeceraseries = new  ArrayList<CabeceraSerie>();
		  		  
        try {
			CabeceraSerieLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			cabeceraseries=cabeceraserieDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarCabeceraSerie(cabeceraseries);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				CabeceraSerieConstantesFunciones.refrescarForeignKeysDescripcionesCabeceraSerie(this.cabeceraseries);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosCabeceraSeriesWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		cabeceraseries = new  ArrayList<CabeceraSerie>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CabeceraSerie.class.getSimpleName()+"-getTodosCabeceraSeriesWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			CabeceraSerieLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			cabeceraseries=cabeceraserieDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarCabeceraSerie(cabeceraseries);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				CabeceraSerieConstantesFunciones.refrescarForeignKeysDescripcionesCabeceraSerie(this.cabeceraseries);
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
	
	public  void  getTodosCabeceraSeries(String sFinalQuery,Pagination pagination)throws Exception {
		cabeceraseries = new  ArrayList<CabeceraSerie>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			CabeceraSerieLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			cabeceraseries=cabeceraserieDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarCabeceraSerie(cabeceraseries);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				CabeceraSerieConstantesFunciones.refrescarForeignKeysDescripcionesCabeceraSerie(this.cabeceraseries);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarCabeceraSerie(CabeceraSerie cabeceraserie) throws Exception {
		Boolean estaValidado=false;
		
		if(cabeceraserie.getIsNew() || cabeceraserie.getIsChanged()) { 
			this.invalidValues = cabeceraserieValidator.getInvalidValues(cabeceraserie);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(cabeceraserie);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarCabeceraSerie(List<CabeceraSerie> CabeceraSeries) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(CabeceraSerie cabeceraserieLocal:cabeceraseries) {				
			estaValidadoObjeto=this.validarGuardarCabeceraSerie(cabeceraserieLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarCabeceraSerie(List<CabeceraSerie> CabeceraSeries) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarCabeceraSerie(cabeceraseries)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarCabeceraSerie(CabeceraSerie CabeceraSerie) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarCabeceraSerie(cabeceraserie)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(CabeceraSerie cabeceraserie) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+cabeceraserie.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=CabeceraSerieConstantesFunciones.getCabeceraSerieLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"cabeceraserie","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(CabeceraSerieConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(CabeceraSerieConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveCabeceraSerieWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CabeceraSerie.class.getSimpleName()+"-saveCabeceraSerieWithConnection");connexion.begin();			
			
			CabeceraSerieLogicAdditional.checkCabeceraSerieToSave(this.cabeceraserie,this.datosCliente,connexion,this.arrDatoGeneral);
			
			CabeceraSerieLogicAdditional.updateCabeceraSerieToSave(this.cabeceraserie,this.arrDatoGeneral);
			
			CabeceraSerieLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.cabeceraserie,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowCabeceraSerie();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarCabeceraSerie(this.cabeceraserie)) {
				CabeceraSerieDataAccess.save(this.cabeceraserie, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.cabeceraserie,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			CabeceraSerieLogicAdditional.checkCabeceraSerieToSaveAfter(this.cabeceraserie,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowCabeceraSerie();
			
			connexion.commit();			
			
			if(this.cabeceraserie.getIsDeleted()) {
				this.cabeceraserie=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveCabeceraSerie()throws Exception {	
		try {	
			
			CabeceraSerieLogicAdditional.checkCabeceraSerieToSave(this.cabeceraserie,this.datosCliente,connexion,this.arrDatoGeneral);
			
			CabeceraSerieLogicAdditional.updateCabeceraSerieToSave(this.cabeceraserie,this.arrDatoGeneral);
			
			CabeceraSerieLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.cabeceraserie,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarCabeceraSerie(this.cabeceraserie)) {			
				CabeceraSerieDataAccess.save(this.cabeceraserie, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.cabeceraserie,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			CabeceraSerieLogicAdditional.checkCabeceraSerieToSaveAfter(this.cabeceraserie,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.cabeceraserie.getIsDeleted()) {
				this.cabeceraserie=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveCabeceraSeriesWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CabeceraSerie.class.getSimpleName()+"-saveCabeceraSeriesWithConnection");connexion.begin();			
			
			CabeceraSerieLogicAdditional.checkCabeceraSerieToSaves(cabeceraseries,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowCabeceraSeries();
			
			Boolean validadoTodosCabeceraSerie=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(CabeceraSerie cabeceraserieLocal:cabeceraseries) {		
				if(cabeceraserieLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				CabeceraSerieLogicAdditional.updateCabeceraSerieToSave(cabeceraserieLocal,this.arrDatoGeneral);
	        	
				CabeceraSerieLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),cabeceraserieLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarCabeceraSerie(cabeceraserieLocal)) {
					CabeceraSerieDataAccess.save(cabeceraserieLocal, connexion);				
				} else {
					validadoTodosCabeceraSerie=false;
				}
			}
			
			if(!validadoTodosCabeceraSerie) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			CabeceraSerieLogicAdditional.checkCabeceraSerieToSavesAfter(cabeceraseries,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowCabeceraSeries();
			
			connexion.commit();		
			
			this.quitarCabeceraSeriesEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveCabeceraSeries()throws Exception {				
		 try {	
			CabeceraSerieLogicAdditional.checkCabeceraSerieToSaves(cabeceraseries,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosCabeceraSerie=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(CabeceraSerie cabeceraserieLocal:cabeceraseries) {				
				if(cabeceraserieLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				CabeceraSerieLogicAdditional.updateCabeceraSerieToSave(cabeceraserieLocal,this.arrDatoGeneral);
	        	
				CabeceraSerieLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),cabeceraserieLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarCabeceraSerie(cabeceraserieLocal)) {				
					CabeceraSerieDataAccess.save(cabeceraserieLocal, connexion);				
				} else {
					validadoTodosCabeceraSerie=false;
				}
			}
			
			if(!validadoTodosCabeceraSerie) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			CabeceraSerieLogicAdditional.checkCabeceraSerieToSavesAfter(cabeceraseries,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarCabeceraSeriesEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public CabeceraSerieParameterReturnGeneral procesarAccionCabeceraSeries(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<CabeceraSerie> cabeceraseries,CabeceraSerieParameterReturnGeneral cabeceraserieParameterGeneral)throws Exception {
		 try {	
			CabeceraSerieParameterReturnGeneral cabeceraserieReturnGeneral=new CabeceraSerieParameterReturnGeneral();
	
			CabeceraSerieLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,cabeceraseries,cabeceraserieParameterGeneral,cabeceraserieReturnGeneral);
			
			return cabeceraserieReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public CabeceraSerieParameterReturnGeneral procesarAccionCabeceraSeriesWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<CabeceraSerie> cabeceraseries,CabeceraSerieParameterReturnGeneral cabeceraserieParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CabeceraSerie.class.getSimpleName()+"-procesarAccionCabeceraSeriesWithConnection");connexion.begin();			
			
			CabeceraSerieParameterReturnGeneral cabeceraserieReturnGeneral=new CabeceraSerieParameterReturnGeneral();
	
			CabeceraSerieLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,cabeceraseries,cabeceraserieParameterGeneral,cabeceraserieReturnGeneral);
			
			this.connexion.commit();
			
			return cabeceraserieReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public CabeceraSerieParameterReturnGeneral procesarEventosCabeceraSeries(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<CabeceraSerie> cabeceraseries,CabeceraSerie cabeceraserie,CabeceraSerieParameterReturnGeneral cabeceraserieParameterGeneral,Boolean isEsNuevoCabeceraSerie,ArrayList<Classe> clases)throws Exception {
		 try {	
			CabeceraSerieParameterReturnGeneral cabeceraserieReturnGeneral=new CabeceraSerieParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				cabeceraserieReturnGeneral.setConRecargarPropiedades(true);
			}
			
			CabeceraSerieLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,cabeceraseries,cabeceraserie,cabeceraserieParameterGeneral,cabeceraserieReturnGeneral,isEsNuevoCabeceraSerie,clases);
			
			return cabeceraserieReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public CabeceraSerieParameterReturnGeneral procesarEventosCabeceraSeriesWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<CabeceraSerie> cabeceraseries,CabeceraSerie cabeceraserie,CabeceraSerieParameterReturnGeneral cabeceraserieParameterGeneral,Boolean isEsNuevoCabeceraSerie,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CabeceraSerie.class.getSimpleName()+"-procesarEventosCabeceraSeriesWithConnection");connexion.begin();			
			
			CabeceraSerieParameterReturnGeneral cabeceraserieReturnGeneral=new CabeceraSerieParameterReturnGeneral();
	
			cabeceraserieReturnGeneral.setCabeceraSerie(cabeceraserie);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				cabeceraserieReturnGeneral.setConRecargarPropiedades(true);
			}
			
			CabeceraSerieLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,cabeceraseries,cabeceraserie,cabeceraserieParameterGeneral,cabeceraserieReturnGeneral,isEsNuevoCabeceraSerie,clases);
			
			this.connexion.commit();
			
			return cabeceraserieReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public CabeceraSerieParameterReturnGeneral procesarImportacionCabeceraSeriesWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,CabeceraSerieParameterReturnGeneral cabeceraserieParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CabeceraSerie.class.getSimpleName()+"-procesarImportacionCabeceraSeriesWithConnection");connexion.begin();			
			
			CabeceraSerieParameterReturnGeneral cabeceraserieReturnGeneral=new CabeceraSerieParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.cabeceraseries=new ArrayList<CabeceraSerie>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.cabeceraserie=new CabeceraSerie();
				
				
				if(conColumnasBase) {this.cabeceraserie.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.cabeceraserie.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.cabeceraserie.setnombre(arrColumnas[iColumn++]);
				this.cabeceraserie.setformula(arrColumnas[iColumn++]);
				this.cabeceraserie.setcon_formula(Boolean.parseBoolean(arrColumnas[iColumn++]));
				this.cabeceraserie.setcon_totalizar(Boolean.parseBoolean(arrColumnas[iColumn++]));
				
				this.cabeceraseries.add(this.cabeceraserie);
			}
			
			this.saveCabeceraSeries();
			
			this.connexion.commit();
			
			cabeceraserieReturnGeneral.setConRetornoEstaProcesado(true);
			cabeceraserieReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return cabeceraserieReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarCabeceraSeriesEliminados() throws Exception {				
		
		List<CabeceraSerie> cabeceraseriesAux= new ArrayList<CabeceraSerie>();
		
		for(CabeceraSerie cabeceraserie:cabeceraseries) {
			if(!cabeceraserie.getIsDeleted()) {
				cabeceraseriesAux.add(cabeceraserie);
			}
		}
		
		cabeceraseries=cabeceraseriesAux;
	}
	
	public void quitarCabeceraSeriesNulos() throws Exception {				
		
		List<CabeceraSerie> cabeceraseriesAux= new ArrayList<CabeceraSerie>();
		
		for(CabeceraSerie cabeceraserie : this.cabeceraseries) {
			if(cabeceraserie==null) {
				cabeceraseriesAux.add(cabeceraserie);
			}
		}
		
		//this.cabeceraseries=cabeceraseriesAux;
		
		this.cabeceraseries.removeAll(cabeceraseriesAux);
	}
	
	public void getSetVersionRowCabeceraSerieWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(cabeceraserie.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((cabeceraserie.getIsDeleted() || (cabeceraserie.getIsChanged()&&!cabeceraserie.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=cabeceraserieDataAccess.getSetVersionRowCabeceraSerie(connexion,cabeceraserie.getId());
				
				if(!cabeceraserie.getVersionRow().equals(timestamp)) {	
					cabeceraserie.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				cabeceraserie.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowCabeceraSerie()throws Exception {	
		
		if(cabeceraserie.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((cabeceraserie.getIsDeleted() || (cabeceraserie.getIsChanged()&&!cabeceraserie.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=cabeceraserieDataAccess.getSetVersionRowCabeceraSerie(connexion,cabeceraserie.getId());
			
			try {							
				if(!cabeceraserie.getVersionRow().equals(timestamp)) {	
					cabeceraserie.setVersionRow(timestamp);
				}
				
				cabeceraserie.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowCabeceraSeriesWithConnection()throws Exception {	
		if(cabeceraseries!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(CabeceraSerie cabeceraserieAux:cabeceraseries) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(cabeceraserieAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(cabeceraserieAux.getIsDeleted() || (cabeceraserieAux.getIsChanged()&&!cabeceraserieAux.getIsNew())) {
						
						timestamp=cabeceraserieDataAccess.getSetVersionRowCabeceraSerie(connexion,cabeceraserieAux.getId());
						
						if(!cabeceraserie.getVersionRow().equals(timestamp)) {	
							cabeceraserieAux.setVersionRow(timestamp);
						}
								
						cabeceraserieAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowCabeceraSeries()throws Exception {	
		if(cabeceraseries!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(CabeceraSerie cabeceraserieAux:cabeceraseries) {
					if(cabeceraserieAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(cabeceraserieAux.getIsDeleted() || (cabeceraserieAux.getIsChanged()&&!cabeceraserieAux.getIsNew())) {
						
						timestamp=cabeceraserieDataAccess.getSetVersionRowCabeceraSerie(connexion,cabeceraserieAux.getId());
						
						if(!cabeceraserieAux.getVersionRow().equals(timestamp)) {	
							cabeceraserieAux.setVersionRow(timestamp);
						}
						
													
						cabeceraserieAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public CabeceraSerieParameterReturnGeneral cargarCombosLoteForeignKeyCabeceraSerieWithConnection(String finalQueryGlobalEmpresa) throws Exception {
		CabeceraSerieParameterReturnGeneral  cabeceraserieReturnGeneral =new CabeceraSerieParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CabeceraSerie.class.getSimpleName()+"-cargarCombosLoteForeignKeyCabeceraSerieWithConnection");connexion.begin();
			
			cabeceraserieReturnGeneral =new CabeceraSerieParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			cabeceraserieReturnGeneral.setempresasForeignKey(empresasForeignKey);

			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
		
		return cabeceraserieReturnGeneral;
	}
	
	public CabeceraSerieParameterReturnGeneral cargarCombosLoteForeignKeyCabeceraSerie(String finalQueryGlobalEmpresa) throws Exception {
		CabeceraSerieParameterReturnGeneral  cabeceraserieReturnGeneral =new CabeceraSerieParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {						
			cabeceraserieReturnGeneral =new CabeceraSerieParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			cabeceraserieReturnGeneral.setempresasForeignKey(empresasForeignKey);
						
			
		} catch(Exception e) {			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			
		}
		
		return cabeceraserieReturnGeneral;
	}
	
	
	public void deepLoad(CabeceraSerie cabeceraserie,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			CabeceraSerieLogicAdditional.updateCabeceraSerieToGet(cabeceraserie,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		cabeceraserie.setEmpresa(cabeceraserieDataAccess.getEmpresa(connexion,cabeceraserie));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				cabeceraserie.setEmpresa(cabeceraserieDataAccess.getEmpresa(connexion,cabeceraserie));
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
			cabeceraserie.setEmpresa(cabeceraserieDataAccess.getEmpresa(connexion,cabeceraserie));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		cabeceraserie.setEmpresa(cabeceraserieDataAccess.getEmpresa(connexion,cabeceraserie));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(cabeceraserie.getEmpresa(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				cabeceraserie.setEmpresa(cabeceraserieDataAccess.getEmpresa(connexion,cabeceraserie));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(cabeceraserie.getEmpresa(),isDeep,deepLoadType,clases);				
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
			cabeceraserie.setEmpresa(cabeceraserieDataAccess.getEmpresa(connexion,cabeceraserie));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(cabeceraserie.getEmpresa(),isDeep,deepLoadType,clases);
				
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(CabeceraSerie cabeceraserie,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			CabeceraSerieLogicAdditional.updateCabeceraSerieToSave(cabeceraserie,this.arrDatoGeneral);
			
CabeceraSerieDataAccess.save(cabeceraserie, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(cabeceraserie.getEmpresa(),connexion);
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(cabeceraserie.getEmpresa(),connexion);
				continue;
			}

		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(cabeceraserie.getEmpresa(),connexion);
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(cabeceraserie.getEmpresa(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(cabeceraserie.getEmpresa(),connexion);
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepSave(cabeceraserie.getEmpresa(),isDeep,deepLoadType,clases);				
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
			this.getNewConnexionToDeep(CabeceraSerie.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(cabeceraserie,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				CabeceraSerieConstantesFunciones.refrescarForeignKeysDescripcionesCabeceraSerie(cabeceraserie);
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
			this.deepLoad(this.cabeceraserie,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				CabeceraSerieConstantesFunciones.refrescarForeignKeysDescripcionesCabeceraSerie(this.cabeceraserie);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(CabeceraSerie.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(cabeceraseries!=null) {
				for(CabeceraSerie cabeceraserie:cabeceraseries) {
					this.deepLoad(cabeceraserie,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					CabeceraSerieConstantesFunciones.refrescarForeignKeysDescripcionesCabeceraSerie(cabeceraseries);
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
			if(cabeceraseries!=null) {
				for(CabeceraSerie cabeceraserie:cabeceraseries) {
					this.deepLoad(cabeceraserie,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					CabeceraSerieConstantesFunciones.refrescarForeignKeysDescripcionesCabeceraSerie(cabeceraseries);
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
			this.getNewConnexionToDeep(CabeceraSerie.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(cabeceraserie,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(CabeceraSerie.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(cabeceraseries!=null) {
				for(CabeceraSerie cabeceraserie:cabeceraseries) {
					this.deepSave(cabeceraserie,isDeep,deepLoadType,clases);
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
			if(cabeceraseries!=null) {
				for(CabeceraSerie cabeceraserie:cabeceraseries) {
					this.deepSave(cabeceraserie,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getCabeceraSeriesBusquedaPorNombreWithConnection(String sFinalQuery,Pagination pagination,String nombre)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CabeceraSerie.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralNombre= new ParameterSelectionGeneral();
			parameterSelectionGeneralNombre.setParameterSelectionGeneralLike(ParameterType.STRING,"%"+nombre+"%",CabeceraSerieConstantesFunciones.NOMBRE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralNombre);

			CabeceraSerieLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorNombre","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			cabeceraseries=cabeceraserieDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				CabeceraSerieConstantesFunciones.refrescarForeignKeysDescripcionesCabeceraSerie(this.cabeceraseries);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getCabeceraSeriesBusquedaPorNombre(String sFinalQuery,Pagination pagination,String nombre)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralNombre= new ParameterSelectionGeneral();
			parameterSelectionGeneralNombre.setParameterSelectionGeneralLike(ParameterType.STRING,"%"+nombre+"%",CabeceraSerieConstantesFunciones.NOMBRE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralNombre);

			CabeceraSerieLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorNombre","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			cabeceraseries=cabeceraserieDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				CabeceraSerieConstantesFunciones.refrescarForeignKeysDescripcionesCabeceraSerie(this.cabeceraseries);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getCabeceraSeriesFK_IdEmpresaWithConnection(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CabeceraSerie.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,CabeceraSerieConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			CabeceraSerieLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			cabeceraseries=cabeceraserieDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				CabeceraSerieConstantesFunciones.refrescarForeignKeysDescripcionesCabeceraSerie(this.cabeceraseries);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getCabeceraSeriesFK_IdEmpresa(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,CabeceraSerieConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			CabeceraSerieLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			cabeceraseries=cabeceraserieDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				CabeceraSerieConstantesFunciones.refrescarForeignKeysDescripcionesCabeceraSerie(this.cabeceraseries);
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
			if(CabeceraSerieConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,CabeceraSerieDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,CabeceraSerie cabeceraserie,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(CabeceraSerieConstantesFunciones.ISCONAUDITORIA) {
				if(cabeceraserie.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,CabeceraSerieDataAccess.TABLENAME, cabeceraserie.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(CabeceraSerieConstantesFunciones.ISCONAUDITORIADETALLE) {
						////CabeceraSerieLogic.registrarAuditoriaDetallesCabeceraSerie(connexion,cabeceraserie,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(cabeceraserie.getIsDeleted()) {
					/*if(!cabeceraserie.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,CabeceraSerieDataAccess.TABLENAME, cabeceraserie.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////CabeceraSerieLogic.registrarAuditoriaDetallesCabeceraSerie(connexion,cabeceraserie,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,CabeceraSerieDataAccess.TABLENAME, cabeceraserie.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(cabeceraserie.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,CabeceraSerieDataAccess.TABLENAME, cabeceraserie.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(CabeceraSerieConstantesFunciones.ISCONAUDITORIADETALLE) {
						////CabeceraSerieLogic.registrarAuditoriaDetallesCabeceraSerie(connexion,cabeceraserie,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesCabeceraSerie(Connexion connexion,CabeceraSerie cabeceraserie)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(cabeceraserie.getIsNew()||!cabeceraserie.getid_empresa().equals(cabeceraserie.getCabeceraSerieOriginal().getid_empresa()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(cabeceraserie.getCabeceraSerieOriginal().getid_empresa()!=null)
				{
					strValorActual=cabeceraserie.getCabeceraSerieOriginal().getid_empresa().toString();
				}
				if(cabeceraserie.getid_empresa()!=null)
				{
					strValorNuevo=cabeceraserie.getid_empresa().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),CabeceraSerieConstantesFunciones.IDEMPRESA,strValorActual,strValorNuevo);
			}	
			
			if(cabeceraserie.getIsNew()||!cabeceraserie.getnombre().equals(cabeceraserie.getCabeceraSerieOriginal().getnombre()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(cabeceraserie.getCabeceraSerieOriginal().getnombre()!=null)
				{
					strValorActual=cabeceraserie.getCabeceraSerieOriginal().getnombre();
				}
				if(cabeceraserie.getnombre()!=null)
				{
					strValorNuevo=cabeceraserie.getnombre() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),CabeceraSerieConstantesFunciones.NOMBRE,strValorActual,strValorNuevo);
			}	
			
			if(cabeceraserie.getIsNew()||!cabeceraserie.getformula().equals(cabeceraserie.getCabeceraSerieOriginal().getformula()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(cabeceraserie.getCabeceraSerieOriginal().getformula()!=null)
				{
					strValorActual=cabeceraserie.getCabeceraSerieOriginal().getformula();
				}
				if(cabeceraserie.getformula()!=null)
				{
					strValorNuevo=cabeceraserie.getformula() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),CabeceraSerieConstantesFunciones.FORMULA,strValorActual,strValorNuevo);
			}	
			
			if(cabeceraserie.getIsNew()||!cabeceraserie.getcon_formula().equals(cabeceraserie.getCabeceraSerieOriginal().getcon_formula()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(cabeceraserie.getCabeceraSerieOriginal().getcon_formula()!=null)
				{
					strValorActual=cabeceraserie.getCabeceraSerieOriginal().getcon_formula().toString();
				}
				if(cabeceraserie.getcon_formula()!=null)
				{
					strValorNuevo=cabeceraserie.getcon_formula().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),CabeceraSerieConstantesFunciones.CONFORMULA,strValorActual,strValorNuevo);
			}	
			
			if(cabeceraserie.getIsNew()||!cabeceraserie.getcon_totalizar().equals(cabeceraserie.getCabeceraSerieOriginal().getcon_totalizar()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(cabeceraserie.getCabeceraSerieOriginal().getcon_totalizar()!=null)
				{
					strValorActual=cabeceraserie.getCabeceraSerieOriginal().getcon_totalizar().toString();
				}
				if(cabeceraserie.getcon_totalizar()!=null)
				{
					strValorNuevo=cabeceraserie.getcon_totalizar().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),CabeceraSerieConstantesFunciones.CONTOTALIZAR,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void saveCabeceraSerieRelacionesWithConnection(CabeceraSerie cabeceraserie) throws Exception {

		if(!cabeceraserie.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveCabeceraSerieRelacionesBase(cabeceraserie,true);
		}
	}

	public void saveCabeceraSerieRelaciones(CabeceraSerie cabeceraserie)throws Exception {

		if(!cabeceraserie.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveCabeceraSerieRelacionesBase(cabeceraserie,false);
		}
	}

	public void saveCabeceraSerieRelacionesBase(CabeceraSerie cabeceraserie,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("CabeceraSerie-saveRelacionesWithConnection");}
	

			this.setCabeceraSerie(cabeceraserie);

			if(CabeceraSerieLogicAdditional.validarSaveRelaciones(cabeceraserie,this)) {

				CabeceraSerieLogicAdditional.updateRelacionesToSave(cabeceraserie,this);

				if((cabeceraserie.getIsNew()||cabeceraserie.getIsChanged())&&!cabeceraserie.getIsDeleted()) {
					this.saveCabeceraSerie();
					this.saveCabeceraSerieRelacionesDetalles();

				} else if(cabeceraserie.getIsDeleted()) {
					this.saveCabeceraSerieRelacionesDetalles();
					this.saveCabeceraSerie();
				}

				CabeceraSerieLogicAdditional.updateRelacionesToSaveAfter(cabeceraserie,this);

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
	
	
	private void saveCabeceraSerieRelacionesDetalles()throws Exception {
		try {
	

		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfCabeceraSerie(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=CabeceraSerieConstantesFunciones.getClassesForeignKeysOfCabeceraSerie(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfCabeceraSerie(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=CabeceraSerieConstantesFunciones.getClassesRelationshipsOfCabeceraSerie(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}
