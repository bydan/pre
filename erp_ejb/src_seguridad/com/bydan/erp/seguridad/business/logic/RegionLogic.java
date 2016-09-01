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
package com.bydan.erp.seguridad.business.logic;

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
import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.seguridad.util.RegionConstantesFunciones;
import com.bydan.erp.seguridad.util.RegionParameterReturnGeneral;
//import com.bydan.erp.seguridad.util.RegionParameterGeneral;
import com.bydan.erp.seguridad.business.entity.Region;
import com.bydan.erp.seguridad.business.logic.RegionLogicAdditional;
import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.seguridad.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.seguridad.business.entity.*;
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


import com.bydan.erp.cartera.business.logic.*;
import com.bydan.erp.seguridad.business.logic.*;
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


import com.bydan.erp.cartera.util.*;
import com.bydan.erp.seguridad.util.*;
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


import com.bydan.erp.cartera.business.dataaccess.*;
import com.bydan.erp.seguridad.business.dataaccess.*;
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
public class RegionLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(RegionLogic.class);
	
	protected RegionDataAccess regionDataAccess; 	
	protected Region region;
	protected List<Region> regions;
	protected Object regionObject;	
	protected List<Object> regionsObject;
	
	public static ClassValidator<Region> regionValidator = new ClassValidator<Region>(Region.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected RegionLogicAdditional regionLogicAdditional=null;
	
	public RegionLogicAdditional getRegionLogicAdditional() {
		return this.regionLogicAdditional;
	}
	
	public void setRegionLogicAdditional(RegionLogicAdditional regionLogicAdditional) {
		try {
			this.regionLogicAdditional=regionLogicAdditional;
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
	
	
	
	
	public  RegionLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.regionDataAccess = new RegionDataAccess();
			
			this.regions= new ArrayList<Region>();
			this.region= new Region();
			
			this.regionObject=new Object();
			this.regionsObject=new ArrayList<Object>();
				
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
			
			this.regionDataAccess.setConnexionType(this.connexionType);
			this.regionDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  RegionLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.regionDataAccess = new RegionDataAccess();
			this.regions= new ArrayList<Region>();
			this.region= new Region();
			this.regionObject=new Object();
			this.regionsObject=new ArrayList<Object>();
			
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
			
			this.regionDataAccess.setConnexionType(this.connexionType);
			this.regionDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public Region getRegion() throws Exception {	
		RegionLogicAdditional.checkRegionToGet(region,this.datosCliente,this.arrDatoGeneral);
		RegionLogicAdditional.updateRegionToGet(region,this.arrDatoGeneral);
		
		return region;
	}
		
	public void setRegion(Region newRegion) {
		this.region = newRegion;
	}
	
	public RegionDataAccess getRegionDataAccess() {
		return regionDataAccess;
	}
	
	public void setRegionDataAccess(RegionDataAccess newregionDataAccess) {
		this.regionDataAccess = newregionDataAccess;
	}
	
	public List<Region> getRegions() throws Exception {		
		this.quitarRegionsNulos();
		
		RegionLogicAdditional.checkRegionToGets(regions,this.datosCliente,this.arrDatoGeneral);
		
		for (Region regionLocal: regions ) {
			RegionLogicAdditional.updateRegionToGet(regionLocal,this.arrDatoGeneral);
		}
		
		return regions;
	}
	
	public void setRegions(List<Region> newRegions) {
		this.regions = newRegions;
	}
	
	public Object getRegionObject() {	
		this.regionObject=this.regionDataAccess.getEntityObject();
		return this.regionObject;
	}
		
	public void setRegionObject(Object newRegionObject) {
		this.regionObject = newRegionObject;
	}
	
	public List<Object> getRegionsObject() {		
		this.regionsObject=this.regionDataAccess.getEntitiesObject();
		return this.regionsObject;
	}
		
	public void setRegionsObject(List<Object> newRegionsObject) {
		this.regionsObject = newRegionsObject;
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
		
		if(this.regionDataAccess!=null) {
			this.regionDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Region.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			regionDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			regionDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		region = new  Region();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Region.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			region=regionDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.region,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				RegionConstantesFunciones.refrescarForeignKeysDescripcionesRegion(this.region);
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
		region = new  Region();
		  		  
        try {
			
			region=regionDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.region,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				RegionConstantesFunciones.refrescarForeignKeysDescripcionesRegion(this.region);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		region = new  Region();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Region.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			region=regionDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.region,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				RegionConstantesFunciones.refrescarForeignKeysDescripcionesRegion(this.region);
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
		region = new  Region();
		  		  
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
		region = new  Region();
		  		  
        try {
			
			region=regionDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.region,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				RegionConstantesFunciones.refrescarForeignKeysDescripcionesRegion(this.region);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		region = new  Region();
		  		  
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
		region = new  Region();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Region.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =regionDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		region = new  Region();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=regionDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		region = new  Region();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Region.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =regionDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		region = new  Region();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=regionDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		region = new  Region();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Region.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =regionDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		region = new  Region();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=regionDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		regions = new  ArrayList<Region>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Region.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			RegionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			regions=regionDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarRegion(regions);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				RegionConstantesFunciones.refrescarForeignKeysDescripcionesRegion(this.regions);
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
		regions = new  ArrayList<Region>();
		  		  
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
		regions = new  ArrayList<Region>();
		  		  
        try {			
			RegionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			regions=regionDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarRegion(regions);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				RegionConstantesFunciones.refrescarForeignKeysDescripcionesRegion(this.regions);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		regions = new  ArrayList<Region>();
		  		  
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
		regions = new  ArrayList<Region>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Region.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			RegionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			regions=regionDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarRegion(regions);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				RegionConstantesFunciones.refrescarForeignKeysDescripcionesRegion(this.regions);
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
		regions = new  ArrayList<Region>();
		  		  
        try {
			RegionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			regions=regionDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarRegion(regions);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				RegionConstantesFunciones.refrescarForeignKeysDescripcionesRegion(this.regions);
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
		regions = new  ArrayList<Region>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Region.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			RegionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			regions=regionDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarRegion(regions);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				RegionConstantesFunciones.refrescarForeignKeysDescripcionesRegion(this.regions);
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
		regions = new  ArrayList<Region>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			RegionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			regions=regionDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarRegion(regions);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				RegionConstantesFunciones.refrescarForeignKeysDescripcionesRegion(this.regions);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		region = new  Region();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Region.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			RegionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			region=regionDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarRegion(region);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				RegionConstantesFunciones.refrescarForeignKeysDescripcionesRegion(this.region);
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
		region = new  Region();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			RegionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			region=regionDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarRegion(region);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				RegionConstantesFunciones.refrescarForeignKeysDescripcionesRegion(this.region);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		regions = new  ArrayList<Region>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Region.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			RegionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			regions=regionDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarRegion(regions);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				RegionConstantesFunciones.refrescarForeignKeysDescripcionesRegion(this.regions);
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
		regions = new  ArrayList<Region>();
		  		  
        try {
			RegionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			regions=regionDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarRegion(regions);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				RegionConstantesFunciones.refrescarForeignKeysDescripcionesRegion(this.regions);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosRegionsWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		regions = new  ArrayList<Region>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Region.class.getSimpleName()+"-getTodosRegionsWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			RegionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			regions=regionDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarRegion(regions);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				RegionConstantesFunciones.refrescarForeignKeysDescripcionesRegion(this.regions);
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
	
	public  void  getTodosRegions(String sFinalQuery,Pagination pagination)throws Exception {
		regions = new  ArrayList<Region>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			RegionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			regions=regionDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarRegion(regions);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				RegionConstantesFunciones.refrescarForeignKeysDescripcionesRegion(this.regions);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarRegion(Region region) throws Exception {
		Boolean estaValidado=false;
		
		if(region.getIsNew() || region.getIsChanged()) { 
			this.invalidValues = regionValidator.getInvalidValues(region);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(region);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarRegion(List<Region> Regions) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(Region regionLocal:regions) {				
			estaValidadoObjeto=this.validarGuardarRegion(regionLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarRegion(List<Region> Regions) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarRegion(regions)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarRegion(Region Region) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarRegion(region)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(Region region) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+region.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=RegionConstantesFunciones.getRegionLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"region","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(RegionConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(RegionConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveRegionWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Region.class.getSimpleName()+"-saveRegionWithConnection");connexion.begin();			
			
			RegionLogicAdditional.checkRegionToSave(this.region,this.datosCliente,connexion,this.arrDatoGeneral);
			
			RegionLogicAdditional.updateRegionToSave(this.region,this.arrDatoGeneral);
			
			RegionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.region,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowRegion();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarRegion(this.region)) {
				RegionDataAccess.save(this.region, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.region,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			RegionLogicAdditional.checkRegionToSaveAfter(this.region,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowRegion();
			
			connexion.commit();			
			
			if(this.region.getIsDeleted()) {
				this.region=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveRegion()throws Exception {	
		try {	
			
			RegionLogicAdditional.checkRegionToSave(this.region,this.datosCliente,connexion,this.arrDatoGeneral);
			
			RegionLogicAdditional.updateRegionToSave(this.region,this.arrDatoGeneral);
			
			RegionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.region,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarRegion(this.region)) {			
				RegionDataAccess.save(this.region, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.region,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			RegionLogicAdditional.checkRegionToSaveAfter(this.region,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.region.getIsDeleted()) {
				this.region=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveRegionsWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Region.class.getSimpleName()+"-saveRegionsWithConnection");connexion.begin();			
			
			RegionLogicAdditional.checkRegionToSaves(regions,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowRegions();
			
			Boolean validadoTodosRegion=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(Region regionLocal:regions) {		
				if(regionLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				RegionLogicAdditional.updateRegionToSave(regionLocal,this.arrDatoGeneral);
	        	
				RegionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),regionLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarRegion(regionLocal)) {
					RegionDataAccess.save(regionLocal, connexion);				
				} else {
					validadoTodosRegion=false;
				}
			}
			
			if(!validadoTodosRegion) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			RegionLogicAdditional.checkRegionToSavesAfter(regions,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowRegions();
			
			connexion.commit();		
			
			this.quitarRegionsEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveRegions()throws Exception {				
		 try {	
			RegionLogicAdditional.checkRegionToSaves(regions,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosRegion=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(Region regionLocal:regions) {				
				if(regionLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				RegionLogicAdditional.updateRegionToSave(regionLocal,this.arrDatoGeneral);
	        	
				RegionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),regionLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarRegion(regionLocal)) {				
					RegionDataAccess.save(regionLocal, connexion);				
				} else {
					validadoTodosRegion=false;
				}
			}
			
			if(!validadoTodosRegion) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			RegionLogicAdditional.checkRegionToSavesAfter(regions,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarRegionsEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public RegionParameterReturnGeneral procesarAccionRegions(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<Region> regions,RegionParameterReturnGeneral regionParameterGeneral)throws Exception {
		 try {	
			RegionParameterReturnGeneral regionReturnGeneral=new RegionParameterReturnGeneral();
	
			RegionLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,regions,regionParameterGeneral,regionReturnGeneral);
			
			return regionReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public RegionParameterReturnGeneral procesarAccionRegionsWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<Region> regions,RegionParameterReturnGeneral regionParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Region.class.getSimpleName()+"-procesarAccionRegionsWithConnection");connexion.begin();			
			
			RegionParameterReturnGeneral regionReturnGeneral=new RegionParameterReturnGeneral();
	
			RegionLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,regions,regionParameterGeneral,regionReturnGeneral);
			
			this.connexion.commit();
			
			return regionReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public RegionParameterReturnGeneral procesarEventosRegions(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<Region> regions,Region region,RegionParameterReturnGeneral regionParameterGeneral,Boolean isEsNuevoRegion,ArrayList<Classe> clases)throws Exception {
		 try {	
			RegionParameterReturnGeneral regionReturnGeneral=new RegionParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				regionReturnGeneral.setConRecargarPropiedades(true);
			}
			
			RegionLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,regions,region,regionParameterGeneral,regionReturnGeneral,isEsNuevoRegion,clases);
			
			return regionReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public RegionParameterReturnGeneral procesarEventosRegionsWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<Region> regions,Region region,RegionParameterReturnGeneral regionParameterGeneral,Boolean isEsNuevoRegion,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Region.class.getSimpleName()+"-procesarEventosRegionsWithConnection");connexion.begin();			
			
			RegionParameterReturnGeneral regionReturnGeneral=new RegionParameterReturnGeneral();
	
			regionReturnGeneral.setRegion(region);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				regionReturnGeneral.setConRecargarPropiedades(true);
			}
			
			RegionLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,regions,region,regionParameterGeneral,regionReturnGeneral,isEsNuevoRegion,clases);
			
			this.connexion.commit();
			
			return regionReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public RegionParameterReturnGeneral procesarImportacionRegionsWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,RegionParameterReturnGeneral regionParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Region.class.getSimpleName()+"-procesarImportacionRegionsWithConnection");connexion.begin();			
			
			RegionParameterReturnGeneral regionReturnGeneral=new RegionParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.regions=new ArrayList<Region>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.region=new Region();
				
				
				if(conColumnasBase) {this.region.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.region.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.region.setcodigo(arrColumnas[iColumn++]);
			this.region.setnombre(arrColumnas[iColumn++]);
				
				this.regions.add(this.region);
			}
			
			this.saveRegions();
			
			this.connexion.commit();
			
			regionReturnGeneral.setConRetornoEstaProcesado(true);
			regionReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return regionReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarRegionsEliminados() throws Exception {				
		
		List<Region> regionsAux= new ArrayList<Region>();
		
		for(Region region:regions) {
			if(!region.getIsDeleted()) {
				regionsAux.add(region);
			}
		}
		
		regions=regionsAux;
	}
	
	public void quitarRegionsNulos() throws Exception {				
		
		List<Region> regionsAux= new ArrayList<Region>();
		
		for(Region region : this.regions) {
			if(region==null) {
				regionsAux.add(region);
			}
		}
		
		//this.regions=regionsAux;
		
		this.regions.removeAll(regionsAux);
	}
	
	public void getSetVersionRowRegionWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(region.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((region.getIsDeleted() || (region.getIsChanged()&&!region.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=regionDataAccess.getSetVersionRowRegion(connexion,region.getId());
				
				if(!region.getVersionRow().equals(timestamp)) {	
					region.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				region.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowRegion()throws Exception {	
		
		if(region.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((region.getIsDeleted() || (region.getIsChanged()&&!region.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=regionDataAccess.getSetVersionRowRegion(connexion,region.getId());
			
			try {							
				if(!region.getVersionRow().equals(timestamp)) {	
					region.setVersionRow(timestamp);
				}
				
				region.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowRegionsWithConnection()throws Exception {	
		if(regions!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(Region regionAux:regions) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(regionAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(regionAux.getIsDeleted() || (regionAux.getIsChanged()&&!regionAux.getIsNew())) {
						
						timestamp=regionDataAccess.getSetVersionRowRegion(connexion,regionAux.getId());
						
						if(!region.getVersionRow().equals(timestamp)) {	
							regionAux.setVersionRow(timestamp);
						}
								
						regionAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowRegions()throws Exception {	
		if(regions!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(Region regionAux:regions) {
					if(regionAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(regionAux.getIsDeleted() || (regionAux.getIsChanged()&&!regionAux.getIsNew())) {
						
						timestamp=regionDataAccess.getSetVersionRowRegion(connexion,regionAux.getId());
						
						if(!regionAux.getVersionRow().equals(timestamp)) {	
							regionAux.setVersionRow(timestamp);
						}
						
													
						regionAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public RegionParameterReturnGeneral cargarCombosLoteForeignKeyRegionWithConnection(String finalQueryGlobalPais) throws Exception {
		RegionParameterReturnGeneral  regionReturnGeneral =new RegionParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Region.class.getSimpleName()+"-cargarCombosLoteForeignKeyRegionWithConnection");connexion.begin();
			
			regionReturnGeneral =new RegionParameterReturnGeneral();
			
			

			List<Pais> paissForeignKey=new ArrayList<Pais>();
			PaisLogic paisLogic=new PaisLogic();
			paisLogic.setConnexion(this.connexion);
			paisLogic.getPaisDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalPais.equals("NONE")) {
				paisLogic.getTodosPaiss(finalQueryGlobalPais,new Pagination());
				paissForeignKey=paisLogic.getPaiss();
			}

			regionReturnGeneral.setpaissForeignKey(paissForeignKey);

			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
		
		return regionReturnGeneral;
	}
	
	public RegionParameterReturnGeneral cargarCombosLoteForeignKeyRegion(String finalQueryGlobalPais) throws Exception {
		RegionParameterReturnGeneral  regionReturnGeneral =new RegionParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {						
			regionReturnGeneral =new RegionParameterReturnGeneral();
			
			

			List<Pais> paissForeignKey=new ArrayList<Pais>();
			PaisLogic paisLogic=new PaisLogic();
			paisLogic.setConnexion(this.connexion);
			paisLogic.getPaisDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalPais.equals("NONE")) {
				paisLogic.getTodosPaiss(finalQueryGlobalPais,new Pagination());
				paissForeignKey=paisLogic.getPaiss();
			}

			regionReturnGeneral.setpaissForeignKey(paissForeignKey);
						
			
		} catch(Exception e) {			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			
		}
		
		return regionReturnGeneral;
	}
	
	public void cargarRelacionesLoteForeignKeyRegionWithConnection() throws Exception {
		ArrayList<Classe> classes=new ArrayList<Classe>();		
		
		
			ClienteLogic clienteLogic=new ClienteLogic();
			ProvinciaLogic provinciaLogic=new ProvinciaLogic();
			ParametroCarteraDefectoLogic parametrocarteradefectoLogic=new ParametroCarteraDefectoLogic();
		
		try {
			
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Region.class.getSimpleName()+"-cargarRelacionesLoteForeignKeyRegionWithConnection");connexion.begin();
			
			
			classes.add(new Classe(Cliente.class));
			classes.add(new Classe(Provincia.class));
			classes.add(new Classe(ParametroCarteraDefecto.class));
											
			

			clienteLogic.setConnexion(this.getConnexion());
			clienteLogic.setDatosCliente(this.datosCliente);
			clienteLogic.setIsConRefrescarForeignKeys(true);

			provinciaLogic.setConnexion(this.getConnexion());
			provinciaLogic.setDatosCliente(this.datosCliente);
			provinciaLogic.setIsConRefrescarForeignKeys(true);

			parametrocarteradefectoLogic.setConnexion(this.getConnexion());
			parametrocarteradefectoLogic.setDatosCliente(this.datosCliente);
			parametrocarteradefectoLogic.setIsConRefrescarForeignKeys(true);
			
			this.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
			
			for(Region region:this.regions) {
				

				classes=new ArrayList<Classe>();
				classes=ClienteConstantesFunciones.getClassesForeignKeysOfCliente(new ArrayList<Classe>(),DeepLoadType.NONE);

				clienteLogic.setClientes(region.clientes);
				clienteLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");

				classes=new ArrayList<Classe>();
				classes=ProvinciaConstantesFunciones.getClassesForeignKeysOfProvincia(new ArrayList<Classe>(),DeepLoadType.NONE);

				provinciaLogic.setProvincias(region.provincias);
				provinciaLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");

				classes=new ArrayList<Classe>();
				classes=ParametroCarteraDefectoConstantesFunciones.getClassesForeignKeysOfParametroCarteraDefecto(new ArrayList<Classe>(),DeepLoadType.NONE);

				parametrocarteradefectoLogic.setParametroCarteraDefectos(region.parametrocarteradefectos);
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
	
	public void deepLoad(Region region,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			RegionLogicAdditional.updateRegionToGet(region,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		region.setPais(regionDataAccess.getPais(connexion,region));
		region.setClientes(regionDataAccess.getClientes(connexion,region));
		region.setProvincias(regionDataAccess.getProvincias(connexion,region));
		region.setParametroCarteraDefectos(regionDataAccess.getParametroCarteraDefectos(connexion,region));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Pais.class)) {
				region.setPais(regionDataAccess.getPais(connexion,region));
				continue;
			}

			if(clas.clas.equals(Cliente.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				region.setClientes(regionDataAccess.getClientes(connexion,region));

				if(this.isConDeep) {
					ClienteLogic clienteLogic= new ClienteLogic(this.connexion);
					clienteLogic.setClientes(region.getClientes());
					ArrayList<Classe> classesLocal=ClienteConstantesFunciones.getClassesForeignKeysOfCliente(new ArrayList<Classe>(),DeepLoadType.NONE);
					clienteLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					ClienteConstantesFunciones.refrescarForeignKeysDescripcionesCliente(clienteLogic.getClientes());
					region.setClientes(clienteLogic.getClientes());
				}

				continue;
			}

			if(clas.clas.equals(Provincia.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				region.setProvincias(regionDataAccess.getProvincias(connexion,region));

				if(this.isConDeep) {
					ProvinciaLogic provinciaLogic= new ProvinciaLogic(this.connexion);
					provinciaLogic.setProvincias(region.getProvincias());
					ArrayList<Classe> classesLocal=ProvinciaConstantesFunciones.getClassesForeignKeysOfProvincia(new ArrayList<Classe>(),DeepLoadType.NONE);
					provinciaLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					ProvinciaConstantesFunciones.refrescarForeignKeysDescripcionesProvincia(provinciaLogic.getProvincias());
					region.setProvincias(provinciaLogic.getProvincias());
				}

				continue;
			}

			if(clas.clas.equals(ParametroCarteraDefecto.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				region.setParametroCarteraDefectos(regionDataAccess.getParametroCarteraDefectos(connexion,region));

				if(this.isConDeep) {
					ParametroCarteraDefectoLogic parametrocarteradefectoLogic= new ParametroCarteraDefectoLogic(this.connexion);
					parametrocarteradefectoLogic.setParametroCarteraDefectos(region.getParametroCarteraDefectos());
					ArrayList<Classe> classesLocal=ParametroCarteraDefectoConstantesFunciones.getClassesForeignKeysOfParametroCarteraDefecto(new ArrayList<Classe>(),DeepLoadType.NONE);
					parametrocarteradefectoLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					ParametroCarteraDefectoConstantesFunciones.refrescarForeignKeysDescripcionesParametroCarteraDefecto(parametrocarteradefectoLogic.getParametroCarteraDefectos());
					region.setParametroCarteraDefectos(parametrocarteradefectoLogic.getParametroCarteraDefectos());
				}

				continue;
			}
		}
	}
	else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Pais.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			region.setPais(regionDataAccess.getPais(connexion,region));
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
			region.setClientes(regionDataAccess.getClientes(connexion,region));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Provincia.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(Provincia.class));
			region.setProvincias(regionDataAccess.getProvincias(connexion,region));
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
			region.setParametroCarteraDefectos(regionDataAccess.getParametroCarteraDefectos(connexion,region));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		region.setPais(regionDataAccess.getPais(connexion,region));
		PaisLogic paisLogic= new PaisLogic(connexion);
		paisLogic.deepLoad(region.getPais(),isDeep,deepLoadType,clases);
				

		region.setClientes(regionDataAccess.getClientes(connexion,region));

		for(Cliente cliente:region.getClientes()) {
			ClienteLogic clienteLogic= new ClienteLogic(connexion);
			clienteLogic.deepLoad(cliente,isDeep,deepLoadType,clases);
		}

		region.setProvincias(regionDataAccess.getProvincias(connexion,region));

		for(Provincia provincia:region.getProvincias()) {
			ProvinciaLogic provinciaLogic= new ProvinciaLogic(connexion);
			provinciaLogic.deepLoad(provincia,isDeep,deepLoadType,clases);
		}

		region.setParametroCarteraDefectos(regionDataAccess.getParametroCarteraDefectos(connexion,region));

		for(ParametroCarteraDefecto parametrocarteradefecto:region.getParametroCarteraDefectos()) {
			ParametroCarteraDefectoLogic parametrocarteradefectoLogic= new ParametroCarteraDefectoLogic(connexion);
			parametrocarteradefectoLogic.deepLoad(parametrocarteradefecto,isDeep,deepLoadType,clases);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Pais.class)) {
				region.setPais(regionDataAccess.getPais(connexion,region));
				PaisLogic paisLogic= new PaisLogic(connexion);
				paisLogic.deepLoad(region.getPais(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Cliente.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				region.setClientes(regionDataAccess.getClientes(connexion,region));

				for(Cliente cliente:region.getClientes()) {
					ClienteLogic clienteLogic= new ClienteLogic(connexion);
					clienteLogic.deepLoad(cliente,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(Provincia.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				region.setProvincias(regionDataAccess.getProvincias(connexion,region));

				for(Provincia provincia:region.getProvincias()) {
					ProvinciaLogic provinciaLogic= new ProvinciaLogic(connexion);
					provinciaLogic.deepLoad(provincia,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(ParametroCarteraDefecto.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				region.setParametroCarteraDefectos(regionDataAccess.getParametroCarteraDefectos(connexion,region));

				for(ParametroCarteraDefecto parametrocarteradefecto:region.getParametroCarteraDefectos()) {
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
			if(clas.clas.equals(Pais.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			region.setPais(regionDataAccess.getPais(connexion,region));
			PaisLogic paisLogic= new PaisLogic(connexion);
			paisLogic.deepLoad(region.getPais(),isDeep,deepLoadType,clases);
				
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
			region.setClientes(regionDataAccess.getClientes(connexion,region));

			for(Cliente cliente:region.getClientes()) {
				ClienteLogic clienteLogic= new ClienteLogic(connexion);
				clienteLogic.deepLoad(cliente,isDeep,deepLoadType,clases);
			}
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Provincia.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(Provincia.class));
			region.setProvincias(regionDataAccess.getProvincias(connexion,region));

			for(Provincia provincia:region.getProvincias()) {
				ProvinciaLogic provinciaLogic= new ProvinciaLogic(connexion);
				provinciaLogic.deepLoad(provincia,isDeep,deepLoadType,clases);
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
			region.setParametroCarteraDefectos(regionDataAccess.getParametroCarteraDefectos(connexion,region));

			for(ParametroCarteraDefecto parametrocarteradefecto:region.getParametroCarteraDefectos()) {
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
	
	public void deepSave(Region region,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			RegionLogicAdditional.updateRegionToSave(region,this.arrDatoGeneral);
			
RegionDataAccess.save(region, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		PaisDataAccess.save(region.getPais(),connexion);

		for(Cliente cliente:region.getClientes()) {
			cliente.setid_region(region.getId());
			ClienteDataAccess.save(cliente,connexion);
		}

		for(Provincia provincia:region.getProvincias()) {
			provincia.setid_region(region.getId());
			ProvinciaDataAccess.save(provincia,connexion);
		}

		for(ParametroCarteraDefecto parametrocarteradefecto:region.getParametroCarteraDefectos()) {
			parametrocarteradefecto.setid_region(region.getId());
			ParametroCarteraDefectoDataAccess.save(parametrocarteradefecto,connexion);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Pais.class)) {
				PaisDataAccess.save(region.getPais(),connexion);
				continue;
			}


			if(clas.clas.equals(Cliente.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(Cliente cliente:region.getClientes()) {
					cliente.setid_region(region.getId());
					ClienteDataAccess.save(cliente,connexion);
				}
				continue;
			}

			if(clas.clas.equals(Provincia.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(Provincia provincia:region.getProvincias()) {
					provincia.setid_region(region.getId());
					ProvinciaDataAccess.save(provincia,connexion);
				}
				continue;
			}

			if(clas.clas.equals(ParametroCarteraDefecto.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(ParametroCarteraDefecto parametrocarteradefecto:region.getParametroCarteraDefectos()) {
					parametrocarteradefecto.setid_region(region.getId());
					ParametroCarteraDefectoDataAccess.save(parametrocarteradefecto,connexion);
				}
				continue;
			}
		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		PaisDataAccess.save(region.getPais(),connexion);
		PaisLogic paisLogic= new PaisLogic(connexion);
		paisLogic.deepLoad(region.getPais(),isDeep,deepLoadType,clases);
				

		for(Cliente cliente:region.getClientes()) {
			ClienteLogic clienteLogic= new ClienteLogic(connexion);
			cliente.setid_region(region.getId());
			ClienteDataAccess.save(cliente,connexion);
			clienteLogic.deepSave(cliente,isDeep,deepLoadType,clases);
		}

		for(Provincia provincia:region.getProvincias()) {
			ProvinciaLogic provinciaLogic= new ProvinciaLogic(connexion);
			provincia.setid_region(region.getId());
			ProvinciaDataAccess.save(provincia,connexion);
			provinciaLogic.deepSave(provincia,isDeep,deepLoadType,clases);
		}

		for(ParametroCarteraDefecto parametrocarteradefecto:region.getParametroCarteraDefectos()) {
			ParametroCarteraDefectoLogic parametrocarteradefectoLogic= new ParametroCarteraDefectoLogic(connexion);
			parametrocarteradefecto.setid_region(region.getId());
			ParametroCarteraDefectoDataAccess.save(parametrocarteradefecto,connexion);
			parametrocarteradefectoLogic.deepSave(parametrocarteradefecto,isDeep,deepLoadType,clases);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Pais.class)) {
				PaisDataAccess.save(region.getPais(),connexion);
				PaisLogic paisLogic= new PaisLogic(connexion);
				paisLogic.deepSave(region.getPais(),isDeep,deepLoadType,clases);				
				continue;
			}


			if(clas.clas.equals(Cliente.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(Cliente cliente:region.getClientes()) {
					ClienteLogic clienteLogic= new ClienteLogic(connexion);
					cliente.setid_region(region.getId());
					ClienteDataAccess.save(cliente,connexion);
					clienteLogic.deepSave(cliente,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(Provincia.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(Provincia provincia:region.getProvincias()) {
					ProvinciaLogic provinciaLogic= new ProvinciaLogic(connexion);
					provincia.setid_region(region.getId());
					ProvinciaDataAccess.save(provincia,connexion);
					provinciaLogic.deepSave(provincia,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(ParametroCarteraDefecto.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(ParametroCarteraDefecto parametrocarteradefecto:region.getParametroCarteraDefectos()) {
					ParametroCarteraDefectoLogic parametrocarteradefectoLogic= new ParametroCarteraDefectoLogic(connexion);
					parametrocarteradefecto.setid_region(region.getId());
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
			this.getNewConnexionToDeep(Region.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(region,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				RegionConstantesFunciones.refrescarForeignKeysDescripcionesRegion(region);
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
			this.deepLoad(this.region,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				RegionConstantesFunciones.refrescarForeignKeysDescripcionesRegion(this.region);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(Region.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(regions!=null) {
				for(Region region:regions) {
					this.deepLoad(region,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					RegionConstantesFunciones.refrescarForeignKeysDescripcionesRegion(regions);
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
			if(regions!=null) {
				for(Region region:regions) {
					this.deepLoad(region,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					RegionConstantesFunciones.refrescarForeignKeysDescripcionesRegion(regions);
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
			this.getNewConnexionToDeep(Region.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(region,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(Region.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(regions!=null) {
				for(Region region:regions) {
					this.deepSave(region,isDeep,deepLoadType,clases);
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
			if(regions!=null) {
				for(Region region:regions) {
					this.deepSave(region,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getRegionsFK_IdPaisWithConnection(String sFinalQuery,Pagination pagination,Long id_pais)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Region.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidPais= new ParameterSelectionGeneral();
			parameterSelectionGeneralidPais.setParameterSelectionGeneralEqual(ParameterType.LONG,id_pais,RegionConstantesFunciones.IDPAIS,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidPais);

			RegionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdPais","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			regions=regionDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				RegionConstantesFunciones.refrescarForeignKeysDescripcionesRegion(this.regions);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getRegionsFK_IdPais(String sFinalQuery,Pagination pagination,Long id_pais)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidPais= new ParameterSelectionGeneral();
			parameterSelectionGeneralidPais.setParameterSelectionGeneralEqual(ParameterType.LONG,id_pais,RegionConstantesFunciones.IDPAIS,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidPais);

			RegionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdPais","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			regions=regionDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				RegionConstantesFunciones.refrescarForeignKeysDescripcionesRegion(this.regions);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getRegionPorIdPaisPorNombreWithConnection(Long id_pais,String nombre)throws Exception {
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Region.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			ParameterSelectionGeneral parameterSelectionGeneralidPais= new ParameterSelectionGeneral();
			parameterSelectionGeneralidPais.setParameterSelectionGeneralEqual(ParameterType.LONG,id_pais,RegionConstantesFunciones.IDPAIS,ParameterTypeOperator.AND);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidPais);

			ParameterSelectionGeneral parameterSelectionGeneralNombre= new ParameterSelectionGeneral();
			parameterSelectionGeneralNombre.setParameterSelectionGeneralEqual(ParameterType.STRING,nombre,RegionConstantesFunciones.NOMBRE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralNombre);

			region=regionDataAccess.getEntity(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoad(this.region,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());

				RegionConstantesFunciones.refrescarForeignKeysDescripcionesRegion(this.region);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getRegionPorIdPaisPorNombre(Long id_pais,String nombre)throws Exception {
		try {

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			ParameterSelectionGeneral parameterSelectionGeneralidPais= new ParameterSelectionGeneral();
			parameterSelectionGeneralidPais.setParameterSelectionGeneralEqual(ParameterType.LONG,id_pais,RegionConstantesFunciones.IDPAIS,ParameterTypeOperator.AND);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidPais);

			ParameterSelectionGeneral parameterSelectionGeneralNombre= new ParameterSelectionGeneral();
			parameterSelectionGeneralNombre.setParameterSelectionGeneralEqual(ParameterType.STRING,nombre,RegionConstantesFunciones.NOMBRE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralNombre);

			region=regionDataAccess.getEntity(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoad(this.region,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());

				RegionConstantesFunciones.refrescarForeignKeysDescripcionesRegion(this.region);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getRegionPorIdPorIdPaisWithConnection(Long id,Long id_pais)throws Exception {
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Region.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			ParameterSelectionGeneral parameterSelectionGeneralid= new ParameterSelectionGeneral();
			parameterSelectionGeneralid.setParameterSelectionGeneralEqual(ParameterType.LONG,id,RegionConstantesFunciones.ID,ParameterTypeOperator.AND);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralid);

			ParameterSelectionGeneral parameterSelectionGeneralidPais= new ParameterSelectionGeneral();
			parameterSelectionGeneralidPais.setParameterSelectionGeneralEqual(ParameterType.LONG,id_pais,RegionConstantesFunciones.IDPAIS,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidPais);

			region=regionDataAccess.getEntity(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoad(this.region,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());

				RegionConstantesFunciones.refrescarForeignKeysDescripcionesRegion(this.region);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getRegionPorIdPorIdPais(Long id,Long id_pais)throws Exception {
		try {

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			ParameterSelectionGeneral parameterSelectionGeneralid= new ParameterSelectionGeneral();
			parameterSelectionGeneralid.setParameterSelectionGeneralEqual(ParameterType.LONG,id,RegionConstantesFunciones.ID,ParameterTypeOperator.AND);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralid);

			ParameterSelectionGeneral parameterSelectionGeneralidPais= new ParameterSelectionGeneral();
			parameterSelectionGeneralidPais.setParameterSelectionGeneralEqual(ParameterType.LONG,id_pais,RegionConstantesFunciones.IDPAIS,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidPais);

			region=regionDataAccess.getEntity(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoad(this.region,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());

				RegionConstantesFunciones.refrescarForeignKeysDescripcionesRegion(this.region);
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
			if(RegionConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,RegionDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,Region region,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(RegionConstantesFunciones.ISCONAUDITORIA) {
				if(region.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,RegionDataAccess.TABLENAME, region.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(RegionConstantesFunciones.ISCONAUDITORIADETALLE) {
						////RegionLogic.registrarAuditoriaDetallesRegion(connexion,region,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(region.getIsDeleted()) {
					/*if(!region.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,RegionDataAccess.TABLENAME, region.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////RegionLogic.registrarAuditoriaDetallesRegion(connexion,region,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,RegionDataAccess.TABLENAME, region.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(region.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,RegionDataAccess.TABLENAME, region.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(RegionConstantesFunciones.ISCONAUDITORIADETALLE) {
						////RegionLogic.registrarAuditoriaDetallesRegion(connexion,region,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesRegion(Connexion connexion,Region region)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(region.getIsNew()||!region.getid_pais().equals(region.getRegionOriginal().getid_pais()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(region.getRegionOriginal().getid_pais()!=null)
				{
					strValorActual=region.getRegionOriginal().getid_pais().toString();
				}
				if(region.getid_pais()!=null)
				{
					strValorNuevo=region.getid_pais().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),RegionConstantesFunciones.IDPAIS,strValorActual,strValorNuevo);
			}	
			
			if(region.getIsNew()||!region.getcodigo().equals(region.getRegionOriginal().getcodigo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(region.getRegionOriginal().getcodigo()!=null)
				{
					strValorActual=region.getRegionOriginal().getcodigo();
				}
				if(region.getcodigo()!=null)
				{
					strValorNuevo=region.getcodigo() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),RegionConstantesFunciones.CODIGO,strValorActual,strValorNuevo);
			}	
			
			if(region.getIsNew()||!region.getnombre().equals(region.getRegionOriginal().getnombre()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(region.getRegionOriginal().getnombre()!=null)
				{
					strValorActual=region.getRegionOriginal().getnombre();
				}
				if(region.getnombre()!=null)
				{
					strValorNuevo=region.getnombre() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),RegionConstantesFunciones.NOMBRE,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void saveRegionRelacionesWithConnection(Region region,List<Cliente> clientes,List<Provincia> provincias,List<ParametroCarteraDefecto> parametrocarteradefectos) throws Exception {

		if(!region.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveRegionRelacionesBase(region,clientes,provincias,parametrocarteradefectos,true);
		}
	}

	public void saveRegionRelaciones(Region region,List<Cliente> clientes,List<Provincia> provincias,List<ParametroCarteraDefecto> parametrocarteradefectos)throws Exception {

		if(!region.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveRegionRelacionesBase(region,clientes,provincias,parametrocarteradefectos,false);
		}
	}

	public void saveRegionRelacionesBase(Region region,List<Cliente> clientes,List<Provincia> provincias,List<ParametroCarteraDefecto> parametrocarteradefectos,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("Region-saveRelacionesWithConnection");}
	
			region.setClientes(clientes);
			region.setProvincias(provincias);
			region.setParametroCarteraDefectos(parametrocarteradefectos);

			this.setRegion(region);

			if(RegionLogicAdditional.validarSaveRelaciones(region,this)) {

				RegionLogicAdditional.updateRelacionesToSave(region,this);

				if((region.getIsNew()||region.getIsChanged())&&!region.getIsDeleted()) {
					this.saveRegion();
					this.saveRegionRelacionesDetalles(clientes,provincias,parametrocarteradefectos);

				} else if(region.getIsDeleted()) {
					this.saveRegionRelacionesDetalles(clientes,provincias,parametrocarteradefectos);
					this.saveRegion();
				}

				RegionLogicAdditional.updateRelacionesToSaveAfter(region,this);

			} else {
				throw new Exception("LOS DATOS SON INVALIDOS");
			}

			if(conConexion) {connexion.commit();}

		} catch(Exception e) {
			
			ClienteConstantesFunciones.InicializarGeneralEntityAuxiliaresClientes(clientes,true,true);
			ProvinciaConstantesFunciones.InicializarGeneralEntityAuxiliaresProvincias(provincias,true,true);
			ParametroCarteraDefectoConstantesFunciones.InicializarGeneralEntityAuxiliaresParametroCarteraDefectos(parametrocarteradefectos,true,true);

			if(conConexion){connexion.rollback();}
			Funciones.manageException(logger,e);
			throw e;

		} finally {
			if(conConexion){this.closeNewConnexionToDeep();}
		}
	}
	
	
	private void saveRegionRelacionesDetalles(List<Cliente> clientes,List<Provincia> provincias,List<ParametroCarteraDefecto> parametrocarteradefectos)throws Exception {
		try {
	

			Long idRegionActual=this.getRegion().getId();

			ClienteLogic clienteLogic_Desde_Region=new ClienteLogic();
			clienteLogic_Desde_Region.setClientes(clientes);

			clienteLogic_Desde_Region.setConnexion(this.getConnexion());
			clienteLogic_Desde_Region.setDatosCliente(this.datosCliente);

			for(Cliente cliente_Desde_Region:clienteLogic_Desde_Region.getClientes()) {
				cliente_Desde_Region.setid_region(idRegionActual);

				clienteLogic_Desde_Region.setCliente(cliente_Desde_Region);
				clienteLogic_Desde_Region.saveCliente();
			}


			ProvinciaLogic provinciaLogic_Desde_Region=new ProvinciaLogic();
			provinciaLogic_Desde_Region.setProvincias(provincias);

			provinciaLogic_Desde_Region.setConnexion(this.getConnexion());
			provinciaLogic_Desde_Region.setDatosCliente(this.datosCliente);

			for(Provincia provincia_Desde_Region:provinciaLogic_Desde_Region.getProvincias()) {
				provincia_Desde_Region.setid_region(idRegionActual);

				provinciaLogic_Desde_Region.setProvincia(provincia_Desde_Region);
				provinciaLogic_Desde_Region.saveProvincia();
			}


			ParametroCarteraDefectoLogic parametrocarteradefectoLogic_Desde_Region=new ParametroCarteraDefectoLogic();
			parametrocarteradefectoLogic_Desde_Region.setParametroCarteraDefectos(parametrocarteradefectos);

			parametrocarteradefectoLogic_Desde_Region.setConnexion(this.getConnexion());
			parametrocarteradefectoLogic_Desde_Region.setDatosCliente(this.datosCliente);

			for(ParametroCarteraDefecto parametrocarteradefecto_Desde_Region:parametrocarteradefectoLogic_Desde_Region.getParametroCarteraDefectos()) {
				parametrocarteradefecto_Desde_Region.setid_region(idRegionActual);
			}

			parametrocarteradefectoLogic_Desde_Region.saveParametroCarteraDefectos();

		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfRegion(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=RegionConstantesFunciones.getClassesForeignKeysOfRegion(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfRegion(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=RegionConstantesFunciones.getClassesRelationshipsOfRegion(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}
