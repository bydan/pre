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
import com.bydan.erp.seguridad.util.SectorConstantesFunciones;
import com.bydan.erp.seguridad.util.SectorParameterReturnGeneral;
//import com.bydan.erp.seguridad.util.SectorParameterGeneral;
import com.bydan.erp.seguridad.business.entity.Sector;
import com.bydan.erp.seguridad.business.logic.SectorLogicAdditional;
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
public class SectorLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(SectorLogic.class);
	
	protected SectorDataAccess sectorDataAccess; 	
	protected Sector sector;
	protected List<Sector> sectors;
	protected Object sectorObject;	
	protected List<Object> sectorsObject;
	
	public static ClassValidator<Sector> sectorValidator = new ClassValidator<Sector>(Sector.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected SectorLogicAdditional sectorLogicAdditional=null;
	
	public SectorLogicAdditional getSectorLogicAdditional() {
		return this.sectorLogicAdditional;
	}
	
	public void setSectorLogicAdditional(SectorLogicAdditional sectorLogicAdditional) {
		try {
			this.sectorLogicAdditional=sectorLogicAdditional;
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
	
	
	
	
	public  SectorLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.sectorDataAccess = new SectorDataAccess();
			
			this.sectors= new ArrayList<Sector>();
			this.sector= new Sector();
			
			this.sectorObject=new Object();
			this.sectorsObject=new ArrayList<Object>();
				
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
			
			this.sectorDataAccess.setConnexionType(this.connexionType);
			this.sectorDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  SectorLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.sectorDataAccess = new SectorDataAccess();
			this.sectors= new ArrayList<Sector>();
			this.sector= new Sector();
			this.sectorObject=new Object();
			this.sectorsObject=new ArrayList<Object>();
			
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
			
			this.sectorDataAccess.setConnexionType(this.connexionType);
			this.sectorDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public Sector getSector() throws Exception {	
		SectorLogicAdditional.checkSectorToGet(sector,this.datosCliente,this.arrDatoGeneral);
		SectorLogicAdditional.updateSectorToGet(sector,this.arrDatoGeneral);
		
		return sector;
	}
		
	public void setSector(Sector newSector) {
		this.sector = newSector;
	}
	
	public SectorDataAccess getSectorDataAccess() {
		return sectorDataAccess;
	}
	
	public void setSectorDataAccess(SectorDataAccess newsectorDataAccess) {
		this.sectorDataAccess = newsectorDataAccess;
	}
	
	public List<Sector> getSectors() throws Exception {		
		this.quitarSectorsNulos();
		
		SectorLogicAdditional.checkSectorToGets(sectors,this.datosCliente,this.arrDatoGeneral);
		
		for (Sector sectorLocal: sectors ) {
			SectorLogicAdditional.updateSectorToGet(sectorLocal,this.arrDatoGeneral);
		}
		
		return sectors;
	}
	
	public void setSectors(List<Sector> newSectors) {
		this.sectors = newSectors;
	}
	
	public Object getSectorObject() {	
		this.sectorObject=this.sectorDataAccess.getEntityObject();
		return this.sectorObject;
	}
		
	public void setSectorObject(Object newSectorObject) {
		this.sectorObject = newSectorObject;
	}
	
	public List<Object> getSectorsObject() {		
		this.sectorsObject=this.sectorDataAccess.getEntitiesObject();
		return this.sectorsObject;
	}
		
	public void setSectorsObject(List<Object> newSectorsObject) {
		this.sectorsObject = newSectorsObject;
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
		
		if(this.sectorDataAccess!=null) {
			this.sectorDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Sector.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			sectorDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			sectorDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		sector = new  Sector();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Sector.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			sector=sectorDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.sector,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				SectorConstantesFunciones.refrescarForeignKeysDescripcionesSector(this.sector);
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
		sector = new  Sector();
		  		  
        try {
			
			sector=sectorDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.sector,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				SectorConstantesFunciones.refrescarForeignKeysDescripcionesSector(this.sector);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		sector = new  Sector();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Sector.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			sector=sectorDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.sector,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				SectorConstantesFunciones.refrescarForeignKeysDescripcionesSector(this.sector);
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
		sector = new  Sector();
		  		  
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
		sector = new  Sector();
		  		  
        try {
			
			sector=sectorDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.sector,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				SectorConstantesFunciones.refrescarForeignKeysDescripcionesSector(this.sector);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		sector = new  Sector();
		  		  
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
		sector = new  Sector();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Sector.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =sectorDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		sector = new  Sector();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=sectorDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		sector = new  Sector();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Sector.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =sectorDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		sector = new  Sector();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=sectorDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		sector = new  Sector();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Sector.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =sectorDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		sector = new  Sector();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=sectorDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		sectors = new  ArrayList<Sector>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Sector.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			SectorLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			sectors=sectorDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarSector(sectors);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				SectorConstantesFunciones.refrescarForeignKeysDescripcionesSector(this.sectors);
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
		sectors = new  ArrayList<Sector>();
		  		  
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
		sectors = new  ArrayList<Sector>();
		  		  
        try {			
			SectorLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			sectors=sectorDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarSector(sectors);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				SectorConstantesFunciones.refrescarForeignKeysDescripcionesSector(this.sectors);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		sectors = new  ArrayList<Sector>();
		  		  
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
		sectors = new  ArrayList<Sector>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Sector.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			SectorLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			sectors=sectorDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarSector(sectors);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				SectorConstantesFunciones.refrescarForeignKeysDescripcionesSector(this.sectors);
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
		sectors = new  ArrayList<Sector>();
		  		  
        try {
			SectorLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			sectors=sectorDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarSector(sectors);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				SectorConstantesFunciones.refrescarForeignKeysDescripcionesSector(this.sectors);
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
		sectors = new  ArrayList<Sector>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Sector.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			SectorLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			sectors=sectorDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarSector(sectors);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				SectorConstantesFunciones.refrescarForeignKeysDescripcionesSector(this.sectors);
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
		sectors = new  ArrayList<Sector>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			SectorLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			sectors=sectorDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarSector(sectors);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				SectorConstantesFunciones.refrescarForeignKeysDescripcionesSector(this.sectors);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		sector = new  Sector();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Sector.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			SectorLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			sector=sectorDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarSector(sector);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				SectorConstantesFunciones.refrescarForeignKeysDescripcionesSector(this.sector);
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
		sector = new  Sector();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			SectorLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			sector=sectorDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarSector(sector);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				SectorConstantesFunciones.refrescarForeignKeysDescripcionesSector(this.sector);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		sectors = new  ArrayList<Sector>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Sector.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			SectorLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			sectors=sectorDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarSector(sectors);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				SectorConstantesFunciones.refrescarForeignKeysDescripcionesSector(this.sectors);
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
		sectors = new  ArrayList<Sector>();
		  		  
        try {
			SectorLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			sectors=sectorDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarSector(sectors);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				SectorConstantesFunciones.refrescarForeignKeysDescripcionesSector(this.sectors);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosSectorsWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		sectors = new  ArrayList<Sector>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Sector.class.getSimpleName()+"-getTodosSectorsWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			SectorLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			sectors=sectorDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarSector(sectors);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				SectorConstantesFunciones.refrescarForeignKeysDescripcionesSector(this.sectors);
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
	
	public  void  getTodosSectors(String sFinalQuery,Pagination pagination)throws Exception {
		sectors = new  ArrayList<Sector>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			SectorLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			sectors=sectorDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarSector(sectors);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				SectorConstantesFunciones.refrescarForeignKeysDescripcionesSector(this.sectors);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarSector(Sector sector) throws Exception {
		Boolean estaValidado=false;
		
		if(sector.getIsNew() || sector.getIsChanged()) { 
			this.invalidValues = sectorValidator.getInvalidValues(sector);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(sector);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarSector(List<Sector> Sectors) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(Sector sectorLocal:sectors) {				
			estaValidadoObjeto=this.validarGuardarSector(sectorLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarSector(List<Sector> Sectors) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarSector(sectors)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarSector(Sector Sector) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarSector(sector)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(Sector sector) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+sector.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=SectorConstantesFunciones.getSectorLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"sector","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(SectorConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(SectorConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveSectorWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Sector.class.getSimpleName()+"-saveSectorWithConnection");connexion.begin();			
			
			SectorLogicAdditional.checkSectorToSave(this.sector,this.datosCliente,connexion,this.arrDatoGeneral);
			
			SectorLogicAdditional.updateSectorToSave(this.sector,this.arrDatoGeneral);
			
			SectorLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.sector,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowSector();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarSector(this.sector)) {
				SectorDataAccess.save(this.sector, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.sector,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			SectorLogicAdditional.checkSectorToSaveAfter(this.sector,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowSector();
			
			connexion.commit();			
			
			if(this.sector.getIsDeleted()) {
				this.sector=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveSector()throws Exception {	
		try {	
			
			SectorLogicAdditional.checkSectorToSave(this.sector,this.datosCliente,connexion,this.arrDatoGeneral);
			
			SectorLogicAdditional.updateSectorToSave(this.sector,this.arrDatoGeneral);
			
			SectorLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.sector,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarSector(this.sector)) {			
				SectorDataAccess.save(this.sector, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.sector,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			SectorLogicAdditional.checkSectorToSaveAfter(this.sector,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.sector.getIsDeleted()) {
				this.sector=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveSectorsWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Sector.class.getSimpleName()+"-saveSectorsWithConnection");connexion.begin();			
			
			SectorLogicAdditional.checkSectorToSaves(sectors,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowSectors();
			
			Boolean validadoTodosSector=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(Sector sectorLocal:sectors) {		
				if(sectorLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				SectorLogicAdditional.updateSectorToSave(sectorLocal,this.arrDatoGeneral);
	        	
				SectorLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),sectorLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarSector(sectorLocal)) {
					SectorDataAccess.save(sectorLocal, connexion);				
				} else {
					validadoTodosSector=false;
				}
			}
			
			if(!validadoTodosSector) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			SectorLogicAdditional.checkSectorToSavesAfter(sectors,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowSectors();
			
			connexion.commit();		
			
			this.quitarSectorsEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveSectors()throws Exception {				
		 try {	
			SectorLogicAdditional.checkSectorToSaves(sectors,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosSector=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(Sector sectorLocal:sectors) {				
				if(sectorLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				SectorLogicAdditional.updateSectorToSave(sectorLocal,this.arrDatoGeneral);
	        	
				SectorLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),sectorLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarSector(sectorLocal)) {				
					SectorDataAccess.save(sectorLocal, connexion);				
				} else {
					validadoTodosSector=false;
				}
			}
			
			if(!validadoTodosSector) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			SectorLogicAdditional.checkSectorToSavesAfter(sectors,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarSectorsEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public SectorParameterReturnGeneral procesarAccionSectors(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<Sector> sectors,SectorParameterReturnGeneral sectorParameterGeneral)throws Exception {
		 try {	
			SectorParameterReturnGeneral sectorReturnGeneral=new SectorParameterReturnGeneral();
	
			SectorLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,sectors,sectorParameterGeneral,sectorReturnGeneral);
			
			return sectorReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public SectorParameterReturnGeneral procesarAccionSectorsWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<Sector> sectors,SectorParameterReturnGeneral sectorParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Sector.class.getSimpleName()+"-procesarAccionSectorsWithConnection");connexion.begin();			
			
			SectorParameterReturnGeneral sectorReturnGeneral=new SectorParameterReturnGeneral();
	
			SectorLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,sectors,sectorParameterGeneral,sectorReturnGeneral);
			
			this.connexion.commit();
			
			return sectorReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public SectorParameterReturnGeneral procesarEventosSectors(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<Sector> sectors,Sector sector,SectorParameterReturnGeneral sectorParameterGeneral,Boolean isEsNuevoSector,ArrayList<Classe> clases)throws Exception {
		 try {	
			SectorParameterReturnGeneral sectorReturnGeneral=new SectorParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				sectorReturnGeneral.setConRecargarPropiedades(true);
			}
			
			SectorLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,sectors,sector,sectorParameterGeneral,sectorReturnGeneral,isEsNuevoSector,clases);
			
			return sectorReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public SectorParameterReturnGeneral procesarEventosSectorsWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<Sector> sectors,Sector sector,SectorParameterReturnGeneral sectorParameterGeneral,Boolean isEsNuevoSector,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Sector.class.getSimpleName()+"-procesarEventosSectorsWithConnection");connexion.begin();			
			
			SectorParameterReturnGeneral sectorReturnGeneral=new SectorParameterReturnGeneral();
	
			sectorReturnGeneral.setSector(sector);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				sectorReturnGeneral.setConRecargarPropiedades(true);
			}
			
			SectorLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,sectors,sector,sectorParameterGeneral,sectorReturnGeneral,isEsNuevoSector,clases);
			
			this.connexion.commit();
			
			return sectorReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public SectorParameterReturnGeneral procesarImportacionSectorsWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,SectorParameterReturnGeneral sectorParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Sector.class.getSimpleName()+"-procesarImportacionSectorsWithConnection");connexion.begin();			
			
			SectorParameterReturnGeneral sectorReturnGeneral=new SectorParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.sectors=new ArrayList<Sector>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.sector=new Sector();
				
				
				if(conColumnasBase) {this.sector.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.sector.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.sector.setnombre(arrColumnas[iColumn++]);
			this.sector.setdescripcion(arrColumnas[iColumn++]);
				
				this.sectors.add(this.sector);
			}
			
			this.saveSectors();
			
			this.connexion.commit();
			
			sectorReturnGeneral.setConRetornoEstaProcesado(true);
			sectorReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return sectorReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarSectorsEliminados() throws Exception {				
		
		List<Sector> sectorsAux= new ArrayList<Sector>();
		
		for(Sector sector:sectors) {
			if(!sector.getIsDeleted()) {
				sectorsAux.add(sector);
			}
		}
		
		sectors=sectorsAux;
	}
	
	public void quitarSectorsNulos() throws Exception {				
		
		List<Sector> sectorsAux= new ArrayList<Sector>();
		
		for(Sector sector : this.sectors) {
			if(sector==null) {
				sectorsAux.add(sector);
			}
		}
		
		//this.sectors=sectorsAux;
		
		this.sectors.removeAll(sectorsAux);
	}
	
	public void getSetVersionRowSectorWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(sector.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((sector.getIsDeleted() || (sector.getIsChanged()&&!sector.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=sectorDataAccess.getSetVersionRowSector(connexion,sector.getId());
				
				if(!sector.getVersionRow().equals(timestamp)) {	
					sector.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				sector.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowSector()throws Exception {	
		
		if(sector.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((sector.getIsDeleted() || (sector.getIsChanged()&&!sector.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=sectorDataAccess.getSetVersionRowSector(connexion,sector.getId());
			
			try {							
				if(!sector.getVersionRow().equals(timestamp)) {	
					sector.setVersionRow(timestamp);
				}
				
				sector.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowSectorsWithConnection()throws Exception {	
		if(sectors!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(Sector sectorAux:sectors) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(sectorAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(sectorAux.getIsDeleted() || (sectorAux.getIsChanged()&&!sectorAux.getIsNew())) {
						
						timestamp=sectorDataAccess.getSetVersionRowSector(connexion,sectorAux.getId());
						
						if(!sector.getVersionRow().equals(timestamp)) {	
							sectorAux.setVersionRow(timestamp);
						}
								
						sectorAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowSectors()throws Exception {	
		if(sectors!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(Sector sectorAux:sectors) {
					if(sectorAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(sectorAux.getIsDeleted() || (sectorAux.getIsChanged()&&!sectorAux.getIsNew())) {
						
						timestamp=sectorDataAccess.getSetVersionRowSector(connexion,sectorAux.getId());
						
						if(!sectorAux.getVersionRow().equals(timestamp)) {	
							sectorAux.setVersionRow(timestamp);
						}
						
													
						sectorAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public SectorParameterReturnGeneral cargarCombosLoteForeignKeySectorWithConnection(String finalQueryGlobalEmpresa,String finalQueryGlobalCiudad) throws Exception {
		SectorParameterReturnGeneral  sectorReturnGeneral =new SectorParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Sector.class.getSimpleName()+"-cargarCombosLoteForeignKeySectorWithConnection");connexion.begin();
			
			sectorReturnGeneral =new SectorParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			sectorReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Ciudad> ciudadsForeignKey=new ArrayList<Ciudad>();
			CiudadLogic ciudadLogic=new CiudadLogic();
			ciudadLogic.setConnexion(this.connexion);
			ciudadLogic.getCiudadDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCiudad.equals("NONE")) {
				ciudadLogic.getTodosCiudads(finalQueryGlobalCiudad,new Pagination());
				ciudadsForeignKey=ciudadLogic.getCiudads();
			}

			sectorReturnGeneral.setciudadsForeignKey(ciudadsForeignKey);

			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
		
		return sectorReturnGeneral;
	}
	
	public SectorParameterReturnGeneral cargarCombosLoteForeignKeySector(String finalQueryGlobalEmpresa,String finalQueryGlobalCiudad) throws Exception {
		SectorParameterReturnGeneral  sectorReturnGeneral =new SectorParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {						
			sectorReturnGeneral =new SectorParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			sectorReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Ciudad> ciudadsForeignKey=new ArrayList<Ciudad>();
			CiudadLogic ciudadLogic=new CiudadLogic();
			ciudadLogic.setConnexion(this.connexion);
			ciudadLogic.getCiudadDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCiudad.equals("NONE")) {
				ciudadLogic.getTodosCiudads(finalQueryGlobalCiudad,new Pagination());
				ciudadsForeignKey=ciudadLogic.getCiudads();
			}

			sectorReturnGeneral.setciudadsForeignKey(ciudadsForeignKey);
						
			
		} catch(Exception e) {			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			
		}
		
		return sectorReturnGeneral;
	}
	
	public void cargarRelacionesLoteForeignKeySectorWithConnection() throws Exception {
		ArrayList<Classe> classes=new ArrayList<Classe>();		
		
		
			RutaLogic rutaLogic=new RutaLogic();
			SubSectorLogic subsectorLogic=new SubSectorLogic();
		
		try {
			
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Sector.class.getSimpleName()+"-cargarRelacionesLoteForeignKeySectorWithConnection");connexion.begin();
			
			
			classes.add(new Classe(Ruta.class));
			classes.add(new Classe(SubSector.class));
											
			

			rutaLogic.setConnexion(this.getConnexion());
			rutaLogic.setDatosCliente(this.datosCliente);
			rutaLogic.setIsConRefrescarForeignKeys(true);

			subsectorLogic.setConnexion(this.getConnexion());
			subsectorLogic.setDatosCliente(this.datosCliente);
			subsectorLogic.setIsConRefrescarForeignKeys(true);
			
			this.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
			
			for(Sector sector:this.sectors) {
				

				classes=new ArrayList<Classe>();
				classes=RutaConstantesFunciones.getClassesForeignKeysOfRuta(new ArrayList<Classe>(),DeepLoadType.NONE);

				rutaLogic.setRutas(sector.rutaOrigens);
				rutaLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");

				classes=new ArrayList<Classe>();
				classes=SubSectorConstantesFunciones.getClassesForeignKeysOfSubSector(new ArrayList<Classe>(),DeepLoadType.NONE);

				subsectorLogic.setSubSectors(sector.subsectors);
				subsectorLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
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
	
	public void deepLoad(Sector sector,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			SectorLogicAdditional.updateSectorToGet(sector,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		sector.setEmpresa(sectorDataAccess.getEmpresa(connexion,sector));
		sector.setCiudad(sectorDataAccess.getCiudad(connexion,sector));
		sector.setRutaOrigens(sectorDataAccess.getRutaOrigens(connexion,sector));
		sector.setSubSectors(sectorDataAccess.getSubSectors(connexion,sector));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				sector.setEmpresa(sectorDataAccess.getEmpresa(connexion,sector));
				continue;
			}

			if(clas.clas.equals(Ciudad.class)) {
				sector.setCiudad(sectorDataAccess.getCiudad(connexion,sector));
				continue;
			}

			if(clas.clas.equals(Ruta.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				sector.setRutaOrigens(sectorDataAccess.getRutaOrigens(connexion,sector));

				if(this.isConDeep) {
					RutaLogic rutaLogic= new RutaLogic(this.connexion);
					rutaLogic.setRutas(sector.getRutaOrigens());
					ArrayList<Classe> classesLocal=RutaConstantesFunciones.getClassesForeignKeysOfRuta(new ArrayList<Classe>(),DeepLoadType.NONE);
					rutaLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					RutaConstantesFunciones.refrescarForeignKeysDescripcionesRuta(rutaLogic.getRutas());
					sector.setRutaOrigens(rutaLogic.getRutas());
				}

				continue;
			}

			if(clas.clas.equals(SubSector.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				sector.setSubSectors(sectorDataAccess.getSubSectors(connexion,sector));

				if(this.isConDeep) {
					SubSectorLogic subsectorLogic= new SubSectorLogic(this.connexion);
					subsectorLogic.setSubSectors(sector.getSubSectors());
					ArrayList<Classe> classesLocal=SubSectorConstantesFunciones.getClassesForeignKeysOfSubSector(new ArrayList<Classe>(),DeepLoadType.NONE);
					subsectorLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					SubSectorConstantesFunciones.refrescarForeignKeysDescripcionesSubSector(subsectorLogic.getSubSectors());
					sector.setSubSectors(subsectorLogic.getSubSectors());
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
			sector.setEmpresa(sectorDataAccess.getEmpresa(connexion,sector));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Ciudad.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			sector.setCiudad(sectorDataAccess.getCiudad(connexion,sector));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Ruta.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(Ruta.class));
			sector.setRutaOrigens(sectorDataAccess.getRutaOrigens(connexion,sector));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(SubSector.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(SubSector.class));
			sector.setSubSectors(sectorDataAccess.getSubSectors(connexion,sector));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		sector.setEmpresa(sectorDataAccess.getEmpresa(connexion,sector));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(sector.getEmpresa(),isDeep,deepLoadType,clases);
				
		sector.setCiudad(sectorDataAccess.getCiudad(connexion,sector));
		CiudadLogic ciudadLogic= new CiudadLogic(connexion);
		ciudadLogic.deepLoad(sector.getCiudad(),isDeep,deepLoadType,clases);
				

		sector.setRutaOrigens(sectorDataAccess.getRutaOrigens(connexion,sector));

		for(Ruta ruta:sector.getRutaOrigens()) {
			RutaLogic rutaLogic= new RutaLogic(connexion);
			rutaLogic.deepLoad(ruta,isDeep,deepLoadType,clases);
		}

		sector.setSubSectors(sectorDataAccess.getSubSectors(connexion,sector));

		for(SubSector subsector:sector.getSubSectors()) {
			SubSectorLogic subsectorLogic= new SubSectorLogic(connexion);
			subsectorLogic.deepLoad(subsector,isDeep,deepLoadType,clases);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				sector.setEmpresa(sectorDataAccess.getEmpresa(connexion,sector));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(sector.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Ciudad.class)) {
				sector.setCiudad(sectorDataAccess.getCiudad(connexion,sector));
				CiudadLogic ciudadLogic= new CiudadLogic(connexion);
				ciudadLogic.deepLoad(sector.getCiudad(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Ruta.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				sector.setRutaOrigens(sectorDataAccess.getRutaOrigens(connexion,sector));

				for(Ruta ruta:sector.getRutaOrigens()) {
					RutaLogic rutaLogic= new RutaLogic(connexion);
					rutaLogic.deepLoad(ruta,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(SubSector.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				sector.setSubSectors(sectorDataAccess.getSubSectors(connexion,sector));

				for(SubSector subsector:sector.getSubSectors()) {
					SubSectorLogic subsectorLogic= new SubSectorLogic(connexion);
					subsectorLogic.deepLoad(subsector,isDeep,deepLoadType,clases);
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
			sector.setEmpresa(sectorDataAccess.getEmpresa(connexion,sector));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(sector.getEmpresa(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Ciudad.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			sector.setCiudad(sectorDataAccess.getCiudad(connexion,sector));
			CiudadLogic ciudadLogic= new CiudadLogic(connexion);
			ciudadLogic.deepLoad(sector.getCiudad(),isDeep,deepLoadType,clases);
				
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Ruta.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(Ruta.class));
			sector.setRutaOrigens(sectorDataAccess.getRutaOrigens(connexion,sector));

			for(Ruta ruta:sector.getRutaOrigens()) {
				RutaLogic rutaLogic= new RutaLogic(connexion);
				rutaLogic.deepLoad(ruta,isDeep,deepLoadType,clases);
			}
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(SubSector.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(SubSector.class));
			sector.setSubSectors(sectorDataAccess.getSubSectors(connexion,sector));

			for(SubSector subsector:sector.getSubSectors()) {
				SubSectorLogic subsectorLogic= new SubSectorLogic(connexion);
				subsectorLogic.deepLoad(subsector,isDeep,deepLoadType,clases);
			}
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(Sector sector,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			SectorLogicAdditional.updateSectorToSave(sector,this.arrDatoGeneral);
			
SectorDataAccess.save(sector, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(sector.getEmpresa(),connexion);

		CiudadDataAccess.save(sector.getCiudad(),connexion);

		for(Ruta ruta:sector.getRutaOrigens()) {
			ruta.setid_sector_origen(sector.getId());
			RutaDataAccess.save(ruta,connexion);
		}

		for(SubSector subsector:sector.getSubSectors()) {
			subsector.setid_sector(sector.getId());
			SubSectorDataAccess.save(subsector,connexion);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(sector.getEmpresa(),connexion);
				continue;
			}

			if(clas.clas.equals(Ciudad.class)) {
				CiudadDataAccess.save(sector.getCiudad(),connexion);
				continue;
			}


			if(clas.clas.equals(Ruta.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(Ruta ruta:sector.getRutaOrigens()) {
					ruta.setid_sector_origen(sector.getId());
					RutaDataAccess.save(ruta,connexion);
				}
				continue;
			}

			if(clas.clas.equals(SubSector.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(SubSector subsector:sector.getSubSectors()) {
					subsector.setid_sector(sector.getId());
					SubSectorDataAccess.save(subsector,connexion);
				}
				continue;
			}
		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(sector.getEmpresa(),connexion);
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(sector.getEmpresa(),isDeep,deepLoadType,clases);
				

		CiudadDataAccess.save(sector.getCiudad(),connexion);
		CiudadLogic ciudadLogic= new CiudadLogic(connexion);
		ciudadLogic.deepLoad(sector.getCiudad(),isDeep,deepLoadType,clases);
				

		for(Ruta ruta:sector.getRutaOrigens()) {
			RutaLogic rutaLogic= new RutaLogic(connexion);
			ruta.setid_sector_origen(sector.getId());
			RutaDataAccess.save(ruta,connexion);
			rutaLogic.deepSave(ruta,isDeep,deepLoadType,clases);
		}

		for(SubSector subsector:sector.getSubSectors()) {
			SubSectorLogic subsectorLogic= new SubSectorLogic(connexion);
			subsector.setid_sector(sector.getId());
			SubSectorDataAccess.save(subsector,connexion);
			subsectorLogic.deepSave(subsector,isDeep,deepLoadType,clases);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(sector.getEmpresa(),connexion);
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepSave(sector.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Ciudad.class)) {
				CiudadDataAccess.save(sector.getCiudad(),connexion);
				CiudadLogic ciudadLogic= new CiudadLogic(connexion);
				ciudadLogic.deepSave(sector.getCiudad(),isDeep,deepLoadType,clases);				
				continue;
			}


			if(clas.clas.equals(Ruta.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(Ruta ruta:sector.getRutaOrigens()) {
					RutaLogic rutaLogic= new RutaLogic(connexion);
					ruta.setid_sector_origen(sector.getId());
					RutaDataAccess.save(ruta,connexion);
					rutaLogic.deepSave(ruta,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(SubSector.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(SubSector subsector:sector.getSubSectors()) {
					SubSectorLogic subsectorLogic= new SubSectorLogic(connexion);
					subsector.setid_sector(sector.getId());
					SubSectorDataAccess.save(subsector,connexion);
					subsectorLogic.deepSave(subsector,isDeep,deepLoadType,clases);
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
			this.getNewConnexionToDeep(Sector.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(sector,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				SectorConstantesFunciones.refrescarForeignKeysDescripcionesSector(sector);
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
			this.deepLoad(this.sector,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				SectorConstantesFunciones.refrescarForeignKeysDescripcionesSector(this.sector);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(Sector.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(sectors!=null) {
				for(Sector sector:sectors) {
					this.deepLoad(sector,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					SectorConstantesFunciones.refrescarForeignKeysDescripcionesSector(sectors);
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
			if(sectors!=null) {
				for(Sector sector:sectors) {
					this.deepLoad(sector,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					SectorConstantesFunciones.refrescarForeignKeysDescripcionesSector(sectors);
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
			this.getNewConnexionToDeep(Sector.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(sector,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(Sector.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(sectors!=null) {
				for(Sector sector:sectors) {
					this.deepSave(sector,isDeep,deepLoadType,clases);
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
			if(sectors!=null) {
				for(Sector sector:sectors) {
					this.deepSave(sector,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getSectorsFK_IdCiudadWithConnection(String sFinalQuery,Pagination pagination,Long id_ciudad)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Sector.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCiudad= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCiudad.setParameterSelectionGeneralEqual(ParameterType.LONG,id_ciudad,SectorConstantesFunciones.IDCIUDAD,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCiudad);

			SectorLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCiudad","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			sectors=sectorDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				SectorConstantesFunciones.refrescarForeignKeysDescripcionesSector(this.sectors);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getSectorsFK_IdCiudad(String sFinalQuery,Pagination pagination,Long id_ciudad)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCiudad= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCiudad.setParameterSelectionGeneralEqual(ParameterType.LONG,id_ciudad,SectorConstantesFunciones.IDCIUDAD,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCiudad);

			SectorLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCiudad","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			sectors=sectorDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				SectorConstantesFunciones.refrescarForeignKeysDescripcionesSector(this.sectors);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getSectorsFK_IdEmpresaWithConnection(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Sector.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,SectorConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			SectorLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			sectors=sectorDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				SectorConstantesFunciones.refrescarForeignKeysDescripcionesSector(this.sectors);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getSectorsFK_IdEmpresa(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,SectorConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			SectorLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			sectors=sectorDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				SectorConstantesFunciones.refrescarForeignKeysDescripcionesSector(this.sectors);
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
			if(SectorConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,SectorDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,Sector sector,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(SectorConstantesFunciones.ISCONAUDITORIA) {
				if(sector.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,SectorDataAccess.TABLENAME, sector.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(SectorConstantesFunciones.ISCONAUDITORIADETALLE) {
						////SectorLogic.registrarAuditoriaDetallesSector(connexion,sector,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(sector.getIsDeleted()) {
					/*if(!sector.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,SectorDataAccess.TABLENAME, sector.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////SectorLogic.registrarAuditoriaDetallesSector(connexion,sector,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,SectorDataAccess.TABLENAME, sector.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(sector.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,SectorDataAccess.TABLENAME, sector.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(SectorConstantesFunciones.ISCONAUDITORIADETALLE) {
						////SectorLogic.registrarAuditoriaDetallesSector(connexion,sector,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesSector(Connexion connexion,Sector sector)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(sector.getIsNew()||!sector.getid_empresa().equals(sector.getSectorOriginal().getid_empresa()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(sector.getSectorOriginal().getid_empresa()!=null)
				{
					strValorActual=sector.getSectorOriginal().getid_empresa().toString();
				}
				if(sector.getid_empresa()!=null)
				{
					strValorNuevo=sector.getid_empresa().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),SectorConstantesFunciones.IDEMPRESA,strValorActual,strValorNuevo);
			}	
			
			if(sector.getIsNew()||!sector.getid_ciudad().equals(sector.getSectorOriginal().getid_ciudad()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(sector.getSectorOriginal().getid_ciudad()!=null)
				{
					strValorActual=sector.getSectorOriginal().getid_ciudad().toString();
				}
				if(sector.getid_ciudad()!=null)
				{
					strValorNuevo=sector.getid_ciudad().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),SectorConstantesFunciones.IDCIUDAD,strValorActual,strValorNuevo);
			}	
			
			if(sector.getIsNew()||!sector.getnombre().equals(sector.getSectorOriginal().getnombre()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(sector.getSectorOriginal().getnombre()!=null)
				{
					strValorActual=sector.getSectorOriginal().getnombre();
				}
				if(sector.getnombre()!=null)
				{
					strValorNuevo=sector.getnombre() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),SectorConstantesFunciones.NOMBRE,strValorActual,strValorNuevo);
			}	
			
			if(sector.getIsNew()||!sector.getdescripcion().equals(sector.getSectorOriginal().getdescripcion()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(sector.getSectorOriginal().getdescripcion()!=null)
				{
					strValorActual=sector.getSectorOriginal().getdescripcion();
				}
				if(sector.getdescripcion()!=null)
				{
					strValorNuevo=sector.getdescripcion() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),SectorConstantesFunciones.DESCRIPCION,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void saveSectorRelacionesWithConnection(Sector sector,List<Ruta> rutaOrigens,List<SubSector> subsectors) throws Exception {

		if(!sector.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveSectorRelacionesBase(sector,rutaOrigens,subsectors,true);
		}
	}

	public void saveSectorRelaciones(Sector sector,List<Ruta> rutaOrigens,List<SubSector> subsectors)throws Exception {

		if(!sector.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveSectorRelacionesBase(sector,rutaOrigens,subsectors,false);
		}
	}

	public void saveSectorRelacionesBase(Sector sector,List<Ruta> rutaOrigens,List<SubSector> subsectors,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("Sector-saveRelacionesWithConnection");}
	
			sector.setRutaOrigens(rutaOrigens);
			sector.setSubSectors(subsectors);

			this.setSector(sector);

			if(SectorLogicAdditional.validarSaveRelaciones(sector,this)) {

				SectorLogicAdditional.updateRelacionesToSave(sector,this);

				if((sector.getIsNew()||sector.getIsChanged())&&!sector.getIsDeleted()) {
					this.saveSector();
					this.saveSectorRelacionesDetalles(rutaOrigens,subsectors);

				} else if(sector.getIsDeleted()) {
					this.saveSectorRelacionesDetalles(rutaOrigens,subsectors);
					this.saveSector();
				}

				SectorLogicAdditional.updateRelacionesToSaveAfter(sector,this);

			} else {
				throw new Exception("LOS DATOS SON INVALIDOS");
			}

			if(conConexion) {connexion.commit();}

		} catch(Exception e) {
			
			RutaConstantesFunciones.InicializarGeneralEntityAuxiliaresRutas(rutaOrigens,true,true);
			SubSectorConstantesFunciones.InicializarGeneralEntityAuxiliaresSubSectors(subsectors,true,true);

			if(conConexion){connexion.rollback();}
			Funciones.manageException(logger,e);
			throw e;

		} finally {
			if(conConexion){this.closeNewConnexionToDeep();}
		}
	}
	
	
	private void saveSectorRelacionesDetalles(List<Ruta> rutaOrigens,List<SubSector> subsectors)throws Exception {
		try {
	

			Long idSectorActual=this.getSector().getId();

			RutaLogic rutaOrigenLogic_Desde_Sector=new RutaLogic();
			rutaOrigenLogic_Desde_Sector.setRutas(rutaOrigens);

			rutaOrigenLogic_Desde_Sector.setConnexion(this.getConnexion());
			rutaOrigenLogic_Desde_Sector.setDatosCliente(this.datosCliente);

			for(Ruta ruta_Desde_Sector:rutaOrigenLogic_Desde_Sector.getRutas()) {
				ruta_Desde_Sector.setid_sector_origen(idSectorActual);

				rutaOrigenLogic_Desde_Sector.setRuta(ruta_Desde_Sector);
				rutaOrigenLogic_Desde_Sector.saveRuta();

				Long idRutaActual=ruta_Desde_Sector.getId();

				ClienteLogic clienteLogic_Desde_Ruta=new ClienteLogic();

				if(ruta_Desde_Sector.getClientes()==null){
					ruta_Desde_Sector.setClientes(new ArrayList<Cliente>());
				}

				clienteLogic_Desde_Ruta.setClientes(ruta_Desde_Sector.getClientes());

				clienteLogic_Desde_Ruta.setConnexion(this.getConnexion());
				clienteLogic_Desde_Ruta.setDatosCliente(this.datosCliente);

				for(Cliente cliente_Desde_Ruta:clienteLogic_Desde_Ruta.getClientes()) {
					cliente_Desde_Ruta.setid_ruta(idRutaActual);

					clienteLogic_Desde_Ruta.setCliente(cliente_Desde_Ruta);
					clienteLogic_Desde_Ruta.saveCliente();
				}


				ParametroCarteraDefectoLogic parametrocarteradefectoLogic_Desde_Ruta=new ParametroCarteraDefectoLogic();

				if(ruta_Desde_Sector.getParametroCarteraDefectos()==null){
					ruta_Desde_Sector.setParametroCarteraDefectos(new ArrayList<ParametroCarteraDefecto>());
				}

				parametrocarteradefectoLogic_Desde_Ruta.setParametroCarteraDefectos(ruta_Desde_Sector.getParametroCarteraDefectos());

				parametrocarteradefectoLogic_Desde_Ruta.setConnexion(this.getConnexion());
				parametrocarteradefectoLogic_Desde_Ruta.setDatosCliente(this.datosCliente);

				for(ParametroCarteraDefecto parametrocarteradefecto_Desde_Ruta:parametrocarteradefectoLogic_Desde_Ruta.getParametroCarteraDefectos()) {
					parametrocarteradefecto_Desde_Ruta.setid_ruta(idRutaActual);
				}

				parametrocarteradefectoLogic_Desde_Ruta.saveParametroCarteraDefectos();
			}


			SubSectorLogic subsectorLogic_Desde_Sector=new SubSectorLogic();
			subsectorLogic_Desde_Sector.setSubSectors(subsectors);

			subsectorLogic_Desde_Sector.setConnexion(this.getConnexion());
			subsectorLogic_Desde_Sector.setDatosCliente(this.datosCliente);

			for(SubSector subsector_Desde_Sector:subsectorLogic_Desde_Sector.getSubSectors()) {
				subsector_Desde_Sector.setid_sector(idSectorActual);
			}

			subsectorLogic_Desde_Sector.saveSubSectors();

		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfSector(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=SectorConstantesFunciones.getClassesForeignKeysOfSector(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfSector(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=SectorConstantesFunciones.getClassesRelationshipsOfSector(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}
